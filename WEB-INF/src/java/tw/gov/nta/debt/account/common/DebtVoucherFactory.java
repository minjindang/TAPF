package tw.gov.nta.debt.account.common;

import gov.dnt.tame.util.DateUtil;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;

import tw.gov.nta.account.common.AccountManager;
import tw.gov.nta.sql.account.VoucherDet;
import tw.gov.nta.sql.account.VoucherMain;
import tw.gov.nta.sql.account.VoucherSourceDet;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.DebtPlanDet;
import tw.gov.nta.sql.debt.DebtTypeRef;
import tw.gov.nta.sql.debt.ExtendDueDateMain;
import tw.gov.nta.sql.debt.InterestAdjustMain;
import tw.gov.nta.sql.debt.IssueExchangeTicketMain;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.PaymentMain;
import tw.gov.nta.sql.debt.account.AccountPhaseDet;
import tw.gov.nta.sql.debt.account.AccountPhaseMain;

public class DebtVoucherFactory {
	private String makeUserId;
	private Session session;
	private int voucherType;
	private DebtTypeRef debtType;
	AccountManager manager = new AccountManager();
	static private DebtVoucherFactory factory = null;
	//宣告傳票日期規則常數  
	static public final int VoucherDateToday = 1;
	static public final int VoucherDateMonthFirstDay = 2;
	static public final int VoucherDateMonthLastDay = 3;
	static public final int VoucherDateSourceMakeDay = 4;
	static public final int VoucherDateIssueDay = 5;
	static public final int VoucherDateDueDay = 6;
	static public final int VoucherDateCashDueDay = 7;
	
	//宣告傳票來源種類
	static public final String SourceTypeIssueMain = "IssueMain";
	static public final String SourceTypeDebtMain = "DebtMain";
	static public final String SourceTypeDebtPlanDet = "DebtPlanDet";
	static public final String SourceTypePaymentMain = "PaymentMain";
	static public final String SourceTypeInterestAdjustMain = "InterestAdjustMain";
	static public final String SourceTypeIssueExchangeTicketMain = "IssueExchangeTicketMain";
	static public final String SourceTypeExtendDueDateMain = "ExtendDueDateMain";
	static public final String SourceTypeManKeyIn = "S";
	
	/**
	 * 由發行編號和傳票類型編製傳票
	 * @param issue			發行
	 * @param voucherType	傳票型態
	 * @return
	 */
	
	private DebtVoucherFactory() {
	}

	private DebtVoucherFactory(Session session) {
		setSession(session);
	}
	
	static public DebtVoucherFactory getInstance(Session session) {
		if (factory == null) 
			factory = new DebtVoucherFactory(session);
		else
			factory.setSession(session);
		
		return factory;
	}

	public List<VoucherMain> makeVouchers(IssueMain issue,int voucherType,String makeUserId,boolean isSpecial,DebtTypeRef debt) throws HibernateException, Exception{	
		setDebtType(debt);
		return makeVouchers(issue,voucherType,makeUserId,isSpecial);
	}

	/**
	 * 依發行資料及傳票類別製作傳票清單
	 * @param issue			發行資料
	 * @param voucherType	傳票類別 <見DebtAccountManager宣告>
	 * @param makeUserId	製票人
	 * @param isSpecial		是否為特殊傳票
	 * @return
	 * @throws HibernateException
	 * @throws Exception
	 */	
	public List<VoucherMain> makeVouchers(IssueMain issue,int voucherType,String makeUserId,boolean isSpecial) throws HibernateException, Exception{
		this.makeUserId = makeUserId;
		this.voucherType = voucherType;
		
		//傳票清單
		List<VoucherMain> vouchers = new LinkedList<VoucherMain>();
		
		Map<String,List> sourceMap = new HashMap<String,List>();
		
		sourceMap.put("IssueMainList",new ArrayList<IssueMain>());
		sourceMap.put("DebtMainList",new ArrayList<DebtMain>());
		sourceMap.put("DebtPlanDetList",new ArrayList<DebtPlanDet>());
		sourceMap.put("PaymentMainList",new ArrayList<PaymentMain>());

		
		
		if (getDebtType() == null) {
			//取得債務種類
			Criteria debtTypeCriteria = session.createCriteria(DebtTypeRef.class);
			DebtTypeRef debtType = (DebtTypeRef)(debtTypeCriteria.add(Expression.eq("typeCode",issue.getDebtType())).list().get(0));		
			setDebtType(debtType);	
		}
		
		//如果是特殊傳票即回傳空傳票
		if (isSpecial) {
			VoucherMain newVoucher = makeNewVoucher(issue.getId(),debtType);
			newVoucher.setVoucherSer(1);
			VoucherSourceDet voucherSource = new VoucherSourceDet();
			voucherSource.setSourceId(issue.getId());
			voucherSource.setVoucher(newVoucher);
			newVoucher.addTovoucherSourceDets(voucherSource);
			newVoucher.setVoucherType(voucherType);
			//newVoucher.(issue.getId());
			//特殊傳票的來源為人工輸入
			newVoucher.setSourceType(SourceTypeManKeyIn);
			vouchers.add(newVoucher);
			return vouchers;
		}
	
		//取得應製作的會計階段清單
		List accountPhaseList = getAccountPhaseSet(issue);
		
		AccountPhaseMain phaseMain = null;
		
		int voucherSer = 0;
		for(Iterator iterator=accountPhaseList.iterator();iterator.hasNext();) {
			phaseMain = (AccountPhaseMain)iterator.next();
			if (phaseMain.getPhaseCode().trim().equals("L501") | phaseMain.getPhaseCode().trim().equals("L502")){
				System.out.println("test");
			}
			//System.out.println("AccountPhaseMain.id:"+phaseMain.getId());
			//System.out.println("AccountPhaseMain.code:"+phaseMain.getPhaseCode());
			//System.out.println("AccountPhaseMain.Name:"+phaseMain.getPhaseName());
			//判斷會計階段的執行時機
			String execWhen = phaseMain.getExecWhen();
			String sourceType = phaseMain.getGetTable();
	
			List<? extends Object> sourceList = new ArrayList<Object>();
			
			sourceList = getSourceObjectList(issue,sourceType,sourceMap);	
			
			for(Iterator iteratorSource=sourceList.iterator();iteratorSource.hasNext();) {			
				//判斷資料來源是否符合執行時機，符合即新增一筆傳票
				Object source =  iteratorSource.next();
				if (phaseMain.getId()==1){
					System.out.println("test");
				}
				if (compareExecWhen(issue,execWhen,source) && (!checkVoucherMade(source,phaseMain))) {		
					VoucherMain newVoucher = generalVoucherByPhase(issue,source,sourceType,phaseMain);
					if (newVoucher != null) {
						//如果傳票相關資料相同時要併成一張
						//ex.發行id相同、會計階段相同
						
						//先看有沒有相同的傳票
						VoucherMain existsVoucher = getExistVoucher(vouchers,newVoucher,source);
						//沒有就新增一張
						if (existsVoucher == null) {
							voucherSer++;
							newVoucher.setVoucherSer(voucherSer);
							newVoucher.setSourceType(sourceType);	
							vouchers.add(newVoucher);
						
						//有的話金額加到已經存在那一張
						}else {
							//先把傳票資料來源加進去原來的傳票
							for (Iterator sourceIterator = newVoucher.getVoucherSourceDets().iterator();sourceIterator.hasNext();) {
								VoucherSourceDet voucherSourceDet = (VoucherSourceDet)sourceIterator.next();
								voucherSourceDet.setVoucher(existsVoucher);
								existsVoucher.addTovoucherSourceDets(voucherSourceDet);
							}
							
							//再把同一科目的金額加進去
							for(Iterator newIteratorDet = newVoucher.getVoucherDets().iterator();newIteratorDet.hasNext();) {
								//判斷是否已經加進去
								boolean isAdd = false;
								VoucherDet newVoucherDet = (VoucherDet)newIteratorDet.next();
								for(Iterator existsIteratorDet = existsVoucher.getVoucherDets().iterator();existsIteratorDet.hasNext();) {
									VoucherDet existsVoucherDet = (VoucherDet)existsIteratorDet.next();
//									//同一會計科目且科目類別相等加在一起
									if (newVoucherDet.getAccount().equals(existsVoucherDet.getAccount())&&newVoucherDet.getAccountType().equals(existsVoucherDet.getAccountType())) {
										isAdd = true;
										existsVoucherDet.setAccountAmount(existsVoucherDet.getAccountAmount().add(newVoucherDet.getAccountAmount()));
										break;
									}
								}
								//如果都沒有加進去已經存在傳票的金額，就加一筆明細
								if (!isAdd) {
									existsVoucher.getVoucherDets().add(newVoucherDet);
								}
								
							}
						}
					}
				}
			}	
		}

		return vouchers;
	}
	
	/**
	 * 如果有此原始公債發行的增額公債，就要把傳票一起產生，並且與原來的資料一同加入
	 * @param issue          //原始發行資料
	 * @param sourceType     //資料形態
	 * @return
	 */
	private List<? extends Object> getSourceObjectList(IssueMain issue, String sourceType,Map<String,List> sourceMap) {
		// TODO Auto-generated method stub
		//增額公債不會再有增額公債，所以如果id <> sourceIssueId(增額公債)時就傳回null
		
		if ("".equals(sourceType) || sourceType == null)
			return new ArrayList<Object>();
		
		List<? extends Object> IssueMainList = null,DebtMainList = null;
		List<? extends Object> DebtPlanDetList = null,PaymentMainList = null;
		String fromTable = "";
		String issueIdName = "";
		
		String queryString = "from #fromTable# As T where exists(select 1 from IssueMain As M where " +
				" M.sourceIssueId = ? and M.id = T.#issueId#)";		
		
		if (SourceTypeIssueMain.equals(sourceType)) {
			IssueMainList = (List<? extends Object>)sourceMap.get("IssueMainList");
			if (IssueMainList != null && IssueMainList.size() != 0) {
				return IssueMainList;
			}
			fromTable = "IssueMain";
			issueIdName ="id";
			
		}else if(SourceTypeDebtMain.equals(sourceType)) {
			DebtMainList = (List<? extends Object>)sourceMap.get("DebtMainList");
			if (DebtMainList != null && DebtMainList.size() != 0) {
				return DebtMainList;
			}
			fromTable = "DebtMain";
			issueIdName ="issue.id";
		}else if(SourceTypeDebtPlanDet.equals(sourceType)) {
			DebtPlanDetList = (List<? extends Object>)sourceMap.get("DebtPlanDetList");
			if (DebtPlanDetList != null && DebtPlanDetList.size() != 0) {
				return DebtPlanDetList;
			}
			fromTable = "DebtPlanDet";
			issueIdName ="issueId";
			if(voucherType!=DebtAccountManager.Charge&&voucherType!=DebtAccountManager.PayCharge){
				if(!issue.getDebtType().equals("C"))
					queryString = queryString +" and T.repayDate > '2006/04/30'";
			}else{
				queryString = queryString +" and T.repayDate > '2007/05/31'";
			}
			if(issue.getDebtType().equals("A"))
				queryString = queryString +" and T.deleteMark <> 'Y'";
		}else if(SourceTypePaymentMain.equals(sourceType)) {
			PaymentMainList = (List<? extends Object>)sourceMap.get("PaymentMainList");
			if (PaymentMainList != null && PaymentMainList.size() != 0) {
				return PaymentMainList;
			}
			fromTable = "PaymentMain";
			issueIdName ="issueId";
			if(voucherType!=DebtAccountManager.Charge&&voucherType!=DebtAccountManager.PayCharge){
				if(!issue.getDebtType().equals("C"))
					queryString = queryString +" and T.repayDate > '2006/04/30'";
			}else{
				queryString = queryString +" and T.repayDate > '2007/05/31'";
			}
			if(issue.getDebtType().equals("A"))
				queryString = queryString +" and T.plan in (Select id From DebtPlanDet as D Where D.id = T.plan and D.deleteMark <> 'Y')";
			else
				queryString = queryString +" and T.repayDate > '2009/10/01'";
		}else if(SourceTypeInterestAdjustMain.equals(sourceType)) {
			fromTable = "InterestAdjustMain";
			issueIdName ="plan.debt.issue.id";
			
		}else if(SourceTypeIssueExchangeTicketMain.equals(sourceType)) {
			fromTable = "IssueExchangeTicketMain";
			issueIdName ="debt.issue.id";
		}else if(SourceTypeExtendDueDateMain.equals(sourceType)) {
			fromTable = "ExtendDueDateMain";
			issueIdName ="debt.issue.id";
		}	
		
		queryString = queryString.replaceAll("#fromTable#",fromTable) ;
		queryString = queryString.replaceAll("#issueId#",issueIdName);
		
		Query query = session.createQuery(queryString);
		query.setParameter(0,issue.getId());
		
		
		List<? extends Object> sourceList = null;
		try {
			sourceList = query.list();
		} catch (HibernateException e) {
			sourceList = new ArrayList();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (SourceTypeIssueMain.equals(sourceType)) {
			sourceMap.put("IssueMainList",sourceList);
		}else if (SourceTypeDebtMain.equals(sourceType)){
			sourceMap.put("DebtMainList",sourceList);
		}else if (SourceTypeDebtPlanDet.equals(sourceType)) {
			sourceMap.put("DebtPlanDetList",sourceList);
		}else if (SourceTypePaymentMain.equals(sourceType)) {
			sourceMap.put("PaymentMainList",sourceList);
		}
		
		return sourceList;

	}

	/**
	 * 如果相關資料相同就將存在的傳票傳回開在同一張
	 * 相關資料：發行ID
	 *         會計階段
	 *         傳票日期
	 *         預算別
	 *         債務別
	 * @param vouchers
	 * @param newVoucher
	 * @return
	 */
	private VoucherMain getExistVoucher(List<VoucherMain> vouchers, VoucherMain newVoucher,Object source) {
		// TODO Auto-generated method stub
//		if ("A".equals(debtType.getTypeCode().trim())){
//			return null;
//		}
		
		Integer capitalSerial =new Integer(0);
		Integer interestSerial=new Integer(0);
		String payType = null;
		
		try {
			//如果是付款相關的，要比對付本金期次及付息期次
			if ("A".equals(debtType.getTypeCode().trim()) &&(source instanceof PaymentMain ||
										source instanceof DebtPlanDet || 
										source instanceof IssueExchangeTicketMain)) {
				capitalSerial = Integer.valueOf(BeanUtils.getProperty(source,"capitalSerial").trim());
				interestSerial = Integer.valueOf(BeanUtils.getProperty(source,"interestSerial").trim());
				//如果是付款主檔，還要比對付款類別
				if (source instanceof PaymentMain) {
					PaymentMain payment = (PaymentMain)source;
					payType = payment.getRepayType();
				}
			}
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		//比對目前已製作的傳票
		for(Iterator iterator = vouchers.iterator();iterator.hasNext();) {
			
			VoucherMain existsVoucher = (VoucherMain)iterator.next();
			
			//取得傳票來源
			String sourceType = existsVoucher.getSourceType();
			
			//如果傳票來源不同就對下一張
			if(sourceType == null || !sourceType.equals(newVoucher.getSourceType())) {
				continue;
			}
			
			//比對以下項目是否相同
			//1.會計階段
			//2.傳票日期
			//3.預算別
			//4.債務別
			if(existsVoucher.getPhase().getId().equals(newVoucher.getPhase().getId())&&
			   existsVoucher.getVoucherDate().equals(newVoucher.getVoucherDate())) {
			   //如果債種是中長借，就不比對預算別
			   if(!"C".equals(debtType.getTypeCode().trim())) {
				   if(!existsVoucher.getBudgetCode().equals(newVoucher.getBudgetCode())||
				       !existsVoucher.getDebtCode().equals(newVoucher.getDebtCode())) {
					   continue;
				   }
			   }
	
			   //如果不等於付款相關來源(因為還要付本/付息期次)，就回傳此傳票
				if(!SourceTypePaymentMain.equals(sourceType)&&!SourceTypeDebtPlanDet.equals(sourceType)
						&&!SourceTypeIssueExchangeTicketMain.equals(sourceType)) {
					return existsVoucher;
				}
			}else {
				continue;
			}
			
			//比對來源 
			if(SourceTypePaymentMain.equals(sourceType)||SourceTypeDebtPlanDet.equals(sourceType)
					||SourceTypeIssueExchangeTicketMain.equals(sourceType)) {
				for(Iterator sourceIterator = existsVoucher.getVoucherSourceDets().iterator();sourceIterator.hasNext();) {
					VoucherSourceDet sourceDet = (VoucherSourceDet)sourceIterator.next();
					PaymentMain payment = (PaymentMain)session.get(PaymentMain.class,sourceDet.getSourceId());
					
					//傳票製作是手續費的話，如果同一個付款方式(登錄/債票)就回傳
					if ((voucherType == DebtAccountManager.Charge||voucherType == DebtAccountManager.PayCharge)&&SourceTypePaymentMain.equals(sourceType)) {
						//取得付款資料
						
						//如果新傳票的付款方式等於已製作傳票的付款方式就回傳
						if ((payType==null || payment.getRepayType()==null) || payType.equals(payment.getRepayType())) {
							return existsVoucher;
						}else {
							continue;
						}
					}else if(voucherType == DebtAccountManager.Charge||voucherType == DebtAccountManager.PayCharge){
						return existsVoucher;
					}
					
					//比對付本息期次
					if (source instanceof PaymentMain ||
							source instanceof DebtPlanDet || 
							source instanceof IssueExchangeTicketMain) {
						if("A".equals(debtType.getTypeCode().trim())) {
							Integer existCapitalSerial = new Integer(0);
							Integer existInterestSerial = new Integer(0);
							//取得資料來源及付本息期次
							if(SourceTypePaymentMain.equals(sourceType)) {
								existCapitalSerial = Integer.valueOf(payment.getCapitalSerial().trim());
								existInterestSerial = Integer.valueOf(payment.getInterestSerial().trim());
							}else if(SourceTypeDebtPlanDet.equals(sourceType)){
								DebtPlanDet plan = (DebtPlanDet)session.get(DebtPlanDet.class,sourceDet.getSourceId());
								existCapitalSerial = plan.getCapitalSerial();
								existInterestSerial = plan.getInterestSerial();
							}else if(SourceTypeIssueExchangeTicketMain.equals(sourceType)){
								IssueExchangeTicketMain exchange = (IssueExchangeTicketMain)session.get(IssueExchangeTicketMain.class,sourceDet.getSourceId());
								existCapitalSerial = exchange.getCapitalSerial();
								existInterestSerial = exchange.getInterestSerial();
							}
							
							//如果相等或者傳票日期為截止兌付日或到期日(表示要彙總開一張)就回傳此傳票
							
							if (existCapitalSerial == null || existInterestSerial == null) {
								if(newVoucher.getVoucherDate().equals(existsVoucher.getVoucherDate())) {
									//如果新傳票的付款方式等於已製作傳票的付款方式就回傳
									if ((payType==null || payment.getRepayType()==null) || payType.equals(payment.getRepayType())) {
										return existsVoucher;
									}else {
										continue;
									}
								}
							}else {
						
								if ((existCapitalSerial.equals(capitalSerial) && existInterestSerial.equals(interestSerial))
									||(VoucherDateCashDueDay == newVoucher.getPhase().getVoucherDateRule())
									||(VoucherDateDueDay == newVoucher.getPhase().getVoucherDateRule())) {
									if ((payType==null || payment.getRepayType()==null) || payType.equals(payment.getRepayType())) {
										return existsVoucher;
									}else {
										continue;
									}
								}
							}
						}else {
							if(newVoucher.getVoucherDate().equals(existsVoucher.getVoucherDate())) {
								return existsVoucher;
							}
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * 依發行資料取得應製作的會計階段清單
	 * @param issue 發行資料
	 * @return
	 */
	private List getAccountPhaseSet(IssueMain issue) {
		// TODO Auto-generated method stub
		
		StringBuffer queryString = new StringBuffer();
		
		//依照下面條件取得應製作的會計階段傳票
		//1.債種
		//2.傳票種類
		//3.發行型態(登錄 or 債票)
		//4.使用時機
		
		//先用HQL取得符合前三條件的會計階段
		queryString.append(" from AccountPhaseMain a ");
		queryString.append(" where a.debtType = ? ");
		queryString.append(" and a.phaseType = ? ");
		queryString.append(" and (a.issueKind = ? or a.issueKind = '2')");
		queryString.append(" and a.getTable is not null");
		queryString.append(" order by a.phaseSerial ");
		Query query = session.createQuery(queryString.toString());
		query.setParameter(0,debtType);
		query.setParameter(1,voucherType);
		String issueKind = issue.getIssueKind();
		if (issueKind == null)
			issueKind = "0";
		
		query.setParameter(2,issueKind);
		
		return query.list();

	}
	
	/**
	 * 依來源判斷是否要製作此會計階段傳票
	 * @param issue            發行資料
	 * @param compareString	   比對字串
	 * @param source           資料來源
	 * @return
	 */
	private boolean compareExecWhen(IssueMain issue,String compareString,Object source) {
		String compareOperator = null;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		//如果是手續費 多判斷是否小於等於今天
		if (voucherType==DebtAccountManager.Charge||voucherType==DebtAccountManager.PayCharge) {
			Calendar calendar = Calendar.getInstance();
			try {
				calendar.setTime(df.parse(BeanUtils.getProperty(source,"repayDate")));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (calendar.get(Calendar.MONTH) >=6) {
				calendar.set(calendar.get(Calendar.YEAR),11,31);
			}else {
				calendar.set(calendar.get(Calendar.YEAR),5,30);
			}
			if(calendar.getTime().compareTo(new Date())==1){
				return false;
			}
		}		
		//如果沒有比對資料就執行
		if (compareString == null || compareString.length() == 0 )
			return true;
		
		if (source == null )
			return false;
		
		if (compareString.indexOf("(") > -1) {
			boolean reverseSign = false;
			
			if(compareString.indexOf("!") > -1){
				reverseSign = true;
			}
				
			int leftQutaPos = compareString.indexOf("(");
			while(leftQutaPos > -1) {
				int rightQutaPos = compareString.indexOf(")",leftQutaPos);
			    if (!compareExecWhen(issue,compareString.substring(leftQutaPos+1,rightQutaPos).trim(),source)) {
			    	if (reverseSign) {
			    		return true;
			    	}else {
			    		return false;
			    	}
			    }
			    leftQutaPos = compareString.indexOf("(",rightQutaPos);
			}
			
	    	if (reverseSign) {
	    		return false;
	    	}else {
	    		return true;
	    	}
		}
		
		int equalPos = compareString.indexOf("=");
		int greatThenPos = compareString.indexOf(">");
		int lessThenPos = compareString.indexOf("<");
		int notEqualPos = compareString.indexOf("<>");
		int greatAndEqualPos = compareString.indexOf(">=");
		int lessAndEqualPos = compareString.indexOf("<=");
		
		Object compareValue = null,equalValue = null;
		
		String co1 = "",co2 ="";
		
		String variableType = "";
	
		
		if (compareString.indexOf("'") > 0)
			variableType = "String";
		else if(compareString.toUpperCase().indexOf("DATE") > 0)
			variableType = "Date";
		else
			variableType = "Number";
		
		int comparePos = 0;
		if (equalPos>0) {
			compareOperator = "=";
			comparePos = equalPos;
		}
		
		if (greatThenPos>0) {
			compareOperator = ">";
			comparePos = greatThenPos;
		}
		
		if (lessThenPos>0) {
			compareOperator = "<";
			comparePos = lessThenPos;
		}
		if (notEqualPos>0) {
			compareOperator = "<>";
			comparePos = notEqualPos;
		}
		if (greatAndEqualPos>0) {
			compareOperator = ">=";
			comparePos = greatAndEqualPos;
		}
		if (lessAndEqualPos>0) {
			compareOperator = "<=";
			comparePos = lessAndEqualPos;
		}
	
		co1 = compareString.substring(0,comparePos).trim();
		co2 = compareString.substring(comparePos+compareOperator.length(),compareString.length()).	trim();
		try {
			if (co1.contains("$"))
				if("$TODAY$".equals(co1))
					compareValue = new Date();
				else if("$LASTMONTH$".equals(co1)) {
					try {
						compareValue = df.parse(BeanUtils.getProperty(source,"plan.repayDate"));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Calendar calendar = Calendar.getInstance();
					calendar.setTime((Date)compareValue);
					calendar.add(Calendar.DATE,-1);
					compareValue = calendar.getTime();
				}else {
					compareValue = BeanUtils.getProperty(source,co1.substring(co1.indexOf("$")+1,co1.length()));
				}
			else
				compareValue = co1;
			
			if (co2.contains("$"))
				if("$TODAY$".equals(co2))
					equalValue = new Date();
				else if("$LASTMONTH$".equals(co2)) {
					try {
						equalValue = df.parse(BeanUtils.getProperty(source,"plan.repayDate"));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Calendar calendar = Calendar.getInstance();
					calendar.setTime((Date)equalValue);
					calendar.add(Calendar.DATE,-1);
					equalValue = calendar.getTime();
				}else {
					equalValue = BeanUtils.getProperty(source,co2.substring(co2.indexOf("$")+1,co2.length()));
				}
			else
				equalValue = co2;
			
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		if(compareValue == null || equalValue == null) {
			return false;
		}
		if ("String".equals(variableType)) {
			String s1=(String)compareValue;
			String s2=(String)equalValue;
			
			//把單引號去掉
			int commaPos = s1.indexOf("'");
			if (commaPos > -1)
				s1 = s1.substring(commaPos+1,s1.length() -1);
			
			//把單引號去掉
			commaPos = s2.indexOf("'");
			if (commaPos > -1)
				s2 = s2.substring(commaPos+1,s2.length() -1);
						
			if ("=".equals(compareOperator)) {
				if ((s1.equals(s2)))
					return true ;
				else
					return false;
			}
			if ("<>".equals(compareOperator)) {
				if (!(s1.equals(s2)))
					return true ;
				else
					return false;
			}
		}else if("Number".equals(variableType)) {
			BigDecimal n1 = new BigDecimal(0);
			BigDecimal n2 = new BigDecimal(0);
			try {
			n1 = new BigDecimal((String)compareValue);
			n2 = new BigDecimal((String)equalValue);
			}catch(java.lang.NullPointerException e) {
				e.printStackTrace();
			}
			if ("=".equals(compareOperator)) {
				if (n1.equals(n2))
					return true ;
				else
					return false;
			}
			else if(">".equals(compareOperator)) {
				if (n1.compareTo(n2) > 0)
					return true ;
				else
					return false;				
				
			}
			else if("<".equals(compareOperator)) {
				if (n1.compareTo(n2) < 0)
					return true;
				else
					return false;				
				
			}
			else if("<>".equals(compareOperator)) {
				if (!(n1.equals(n2)))
					return true;
				else
					return false;				
				
			}
			else if(">=".equals(compareOperator)) {
				if (n1.compareTo(n2) >= 0)
					return true ;
				else
					return false;				
				
			}

			else if("<=".equals(compareOperator)) {
				if (n1.compareTo(n2) <= 0)
					return true ;
				else
					return false;				
				
			}
		}
		else if("Date".equals(variableType)) {
			Date d1 = null;
			Date d2 = null;
			
			try {
				if (compareValue instanceof Date) {
					d1 = (Date) compareValue;
				}else {
					d1 = df.parse((String)compareValue);
				}
			
				if (equalValue instanceof Date) {
					d2 = (Date) equalValue;
				}else {
					d2 = df.parse((String)equalValue);
				}
			}	
			catch (ParseException e) {
					// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if ("=".equals(compareOperator)) {
				if (d1.equals(d2))
					return true;
				else
					return false;
			}
			else if(">".equals(compareOperator)) {
				if (d1.compareTo(d2) > 0)
					return true;
				else
					return false;				
				
			}
			else if("<".equals(compareOperator)) {
				if (d1.compareTo(d2) < 0)
					return true;
				else
					return false;				
				
			}
			else if("<>".equals(compareOperator)) {
				if (!(d1.equals(d2)))
					return true;
				else
					return false;						
			
			}else if("<=".equals(compareOperator)) {
				if (d1.compareTo(d2) <= 0)
					return true;
				else
					return false;				
				
			}else if(">=".equals(compareOperator)) {
				if (d1.compareTo(d2) >= 0)
					return true;
				else
					return false;				
				
			}
		}

		return false;
	}

	private Date getVoucherDate(IssueMain issue,Object source,int voucherDateRule) {
		// TODO Auto-generated method stub
		

		Calendar calendar = Calendar.getInstance();
		int year=0,month=0;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		if (voucherType==DebtAccountManager.Charge||voucherType==DebtAccountManager.PayCharge) {
			try {
				calendar.setTime(df.parse(BeanUtils.getProperty(source,"repayDate")));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (calendar.get(Calendar.MONTH) >=6) {
				calendar.set(calendar.get(Calendar.YEAR),11,31);
			}else {
				calendar.set(calendar.get(Calendar.YEAR),5,30);
			}
		}else{
		
		
			try {
				if (voucherDateRule == VoucherDateMonthFirstDay){
					if ( source instanceof PaymentMain || source instanceof DebtPlanDet ) {
						calendar.setTime(df.parse(BeanUtils.getProperty(source,"repayDate")));
						year = calendar.get(Calendar.YEAR);
						month = calendar.get(Calendar.MONTH);
					}
					calendar.set(year,month,1);
				}else if(voucherDateRule == VoucherDateMonthLastDay) {
					if ( source instanceof PaymentMain || source instanceof DebtPlanDet ) {
						calendar.setTime(df.parse(BeanUtils.getProperty(source,"repayDate")));
						year = calendar.get(Calendar.YEAR);
						month = calendar.get(Calendar.MONTH);
					}
					calendar.set(year,month + 1,1);
					calendar.add(Calendar.DATE,-1);
				}else if(voucherDateRule == VoucherDateSourceMakeDay) {
					if ( source instanceof PaymentMain || source instanceof DebtPlanDet ) {
						calendar.setTime(df.parse(BeanUtils.getProperty(source,"repayDate")));
					}else if ( source instanceof DebtMain ) {
						calendar.setTime(((DebtMain)source).getIssue().getIssueDate());
					}else if (source instanceof IssueMain){
						calendar.setTime(issue.getIssueDate());
					}else if (source instanceof IssueExchangeTicketMain){
						calendar.setTime(((IssueExchangeTicketMain)source).getExchangeDate());
					}else if (source instanceof InterestAdjustMain){
						calendar.setTime(((InterestAdjustMain)source).getChangeDate());
					}else if (source instanceof ExtendDueDateMain){
						calendar.setTime(((ExtendDueDateMain)source).getOldDueDate());
					}
				//因為會有增額公債的問題，所以不能直接抓issue(原始公債)的issueDate
				}else if(voucherDateRule == VoucherDateIssueDay) {
					if ( source instanceof PaymentMain ) {
						calendar.setTime(df.parse(BeanUtils.getProperty(source,"plan.debt.issue.issueDate")));
					}else if(source instanceof DebtPlanDet ) {
						calendar.setTime(df.parse(BeanUtils.getProperty(source,"debt.issue.issueDate")));
					}else if ( source instanceof DebtMain ) {
						calendar.setTime(df.parse(BeanUtils.getProperty(source,"issue.issueDate")));
					}else if (source instanceof IssueMain){
						calendar.setTime(df.parse(BeanUtils.getProperty(source,"issueDate")));
					}
				}else if(voucherDateRule == VoucherDateDueDay) {
					if("C".equals(debtType.getTypeCode().trim())) {
						StringBuffer queryString = new StringBuffer();
						queryString.append("select max(payment.repayDate),sum(payment.capitalAmount) from PaymentMain payment where payment.plan.debt.issue = :issue");
						Query paymentQuery = session.createQuery(queryString.toString());
						paymentQuery.setParameter("issue",issue);
						List paymentList = paymentQuery.list();
						if (paymentList.size() != 0) {
							Object[] result = (Object[])paymentList.get(0);
							if(result[0]==null || result[1]==null){
								calendar.setTime(issue.getDueDate());
							}else {
								if(issue.getIssueAmount().equals((BigDecimal)result[1])) {
									calendar.setTime((Date)result[0]);
								}else {
									calendar.setTime(issue.getDueDate());
								}
							}
						}else {
							calendar.setTime(issue.getDueDate());
						}
					}else {
						if ( source instanceof PaymentMain ) {
							calendar.setTime(df.parse(BeanUtils.getProperty(source,"plan.debt.issue.dueDate")));
						}else if(source instanceof DebtPlanDet ) {
							calendar.setTime(df.parse(BeanUtils.getProperty(source,"debt.issue.dueDate")));
						}else if ( source instanceof DebtMain ) {
							calendar.setTime(df.parse(BeanUtils.getProperty(source,"issue.dueDate")));
						}else if (source instanceof IssueMain){
							calendar.setTime(df.parse(BeanUtils.getProperty(source,"dueDate")));
						}
					}
				}else if(voucherDateRule == VoucherDateCashDueDay) {
					if ( source instanceof PaymentMain ) {
						calendar.setTime(df.parse(BeanUtils.getProperty(source,"plan.debt.issue.cashDueDate")));
					}else if(source instanceof DebtPlanDet ) {
						calendar.setTime(df.parse(BeanUtils.getProperty(source,"debt.issue.cashDueDate")));
					}else if ( source instanceof DebtMain ) {
						calendar.setTime(df.parse(BeanUtils.getProperty(source,"issue.cashDueDate")));
					}else if (source instanceof IssueMain){
						calendar.setTime(df.parse(BeanUtils.getProperty(source,"cashDueDate")));
					}
				}else if (voucherDateRule == 0) {
					calendar.setTime(new Date());
					
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return calendar.getTime();
	}

	
//	呼叫依會計階段產生傳票清單
	private VoucherMain generalVoucherByPhase(IssueMain issue,Object source,String sourceType,AccountPhaseMain phaseMain) throws Exception {
		// TODO Auto-generated method stub
		
		VoucherMain newVoucher = makeNewVoucher(issue.getId(),debtType);
			
		
		newVoucher.setPhase(phaseMain);
		
		//設定傳票日期
		Integer voucherDateRule = phaseMain.getVoucherDateRule();
		if (voucherDateRule == null)
			voucherDateRule = 0;
		
		Date voucherDate = getVoucherDate(issue,source,voucherDateRule);
		
		//幾月以前的傳票不產生(因舊系統有轉了)
		//設定過期傳票不再製作，針對公債會計(20100111)
		Calendar checkDate = Calendar.getInstance();
		
//		if(!issue.getDebtType().equals("A") || "3".equals(issue.getBondType()))
//		{
			checkDate.set(2009,10,01);
			checkDate.set(checkDate.get(Calendar.YEAR),01,01);
//		}else{
//			String nowData = DateUtil.date2ROCStr(new Date());
//			Date accountDate = new Date();
//			accountDate = DateUtil.str2Date(DateUtil.dateFlipMonth(nowData,-2));
//			DateUtil.date2ROCStr(accountDate);
//			String accountDateStr = DateUtil.date2Str(DateUtil.getLastDateOfMonth(accountDate));
//			String year = accountDateStr.substring(0,4);
//			String month = accountDateStr.substring(4,6);
//			String day = accountDateStr.substring(6,8);		
//			checkDate.set(Integer.parseInt(year),Integer.parseInt(month),Integer.parseInt(day));
//		}
		
		if (debtType.getType().equals("A")&&voucherDate.before(checkDate.getTime())){
			return null;
		}	
		
		newVoucher.setVoucherDate(voucherDate);
		
		try {
			//取得來源資料
			VoucherSourceDet voucherSourceDet = new VoucherSourceDet();
			Integer sourceId = Integer.valueOf(BeanUtils.getProperty(source,"id"));

			voucherSourceDet.setSourceId(sourceId);
			voucherSourceDet.setVoucher(newVoucher);
			newVoucher.addTovoucherSourceDets(voucherSourceDet);
			
			//取得預算別、債務別
			int budgetCode = 0,debtCode = 0;
			
			String fromObject = "";
			if(SourceTypeIssueMain.equals(sourceType)) {
				fromObject = "";
			}else if(SourceTypeDebtMain.equals(sourceType)) {
				fromObject = "";
			}else if(SourceTypeDebtPlanDet.equals(sourceType)) {
				fromObject = "debt.";
			}else if(SourceTypePaymentMain.equals(sourceType)) {
				fromObject = "plan.debt.";
			}else if(SourceTypeInterestAdjustMain.equals(sourceType)) {
				fromObject = "plan.debt.";
			}else if(SourceTypeIssueExchangeTicketMain.equals(sourceType)) {
				fromObject = "debt.";
			}else if(SourceTypeExtendDueDateMain.equals(sourceType)) {
				fromObject = "debt.";
			}
			budgetCode = Integer.valueOf(BeanUtils.getProperty(source,fromObject + "budgetCode"));
			debtCode = Integer.valueOf(BeanUtils.getProperty(source,fromObject + "debtCode"));
			
			newVoucher.setBudgetCode(budgetCode);
			newVoucher.setDebtCode(debtCode);

			//設定摘要
			StringBuffer remark = new StringBuffer();
//			remark.append("財政部");
//			remark.append(debtType.getTypeName());
//			remark.append(issue.getAccountYear()+"年度");
//			
//			
//			if("A".equals(debtType.getTypeCode().trim())) {
//				String debtSerial = BeanUtils.getProperty(source,fromObject + "debtSerial");
//				remark.append("第"+debtSerial.trim());
//			}else {
//				remark.append("第"+issue.getIssueSerial().trim());
//			}
			remark.append(phaseMain.getPhaseName());
			newVoucher.setRemark(remark.toString());			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		newVoucher.setSourceType(sourceType);

		//取得傳票明細
		generalVoucherDetailByPhase(source,phaseMain,newVoucher);
		Set voucherDets = newVoucher.getVoucherDets(); 
		if (voucherDets != null &&voucherDets.size() != 0) {
			AccountManager.sortVoucherDet(newVoucher.getVoucherDets());
		}else {
			return null;
		}	
		
		//設計傳票發行(付款)類別<平衡表用>
		newVoucher.setIssueKind(issue.getIssueKind());
		
		//因為公債有實體轉登錄的狀況，所以要再判斷
		//1.是不是實體轉分錄的會計階段
		//2.計畫是否為轉換後的會計階段
		//3.付款方式是登錄還是債票
		if("A".equals(debtType.getTypeCode().trim())) {
			//1.判斷是不是實體轉分錄的會計階段
			String phaseCode = phaseMain.getPhaseCode().trim();
			if(SourceTypeIssueExchangeTicketMain.equals(sourceType)){
				if("P202".equals(phaseCode)) {
					newVoucher.setIssueKind("0");
				}
			}else if(SourceTypeDebtPlanDet.equals(sourceType)) {
				if("P302".equals(phaseCode)||"P503".equals(phaseCode)||"L502".equals(phaseCode)) {
					newVoucher.setIssueKind("0");
				}
			}else if(SourceTypePaymentMain.equals(sourceType)) {
				PaymentMain payment = (PaymentMain)source;
				newVoucher.setIssueKind(payment.getRepayType());
			}
		}
		return newVoucher;
			
		
	}
	
	private VoucherMain makeNewVoucher(int issueId,DebtTypeRef debtType) {
		// TODO Auto-generated method stub
		VoucherMain newVoucher = new VoucherMain();
		newVoucher.setDelete(false);
		newVoucher.setModDate(new Date());
		newVoucher.setVoucherDate(new Date());
		newVoucher.setIssueId(issueId);
		newVoucher.setUsrid(makeUserId);
		newVoucher.setVoucherType(voucherType);
		newVoucher.setDebtType(debtType);
		return newVoucher;
	}

	/**
	 * 依會計階段產生傳票金額明細資料
	 * @param source     資料來源
	 * @param phaseMain  會計階段
	 * @param voucher    傳票
	 * @throws Exception
	 */
	private void generalVoucherDetailByPhase(Object source,AccountPhaseMain phaseMain, VoucherMain voucher) throws Exception {
		// TODO Auto-generated method stub
		AccountPhaseDet phaseDet = null;
		VoucherDet voucherDet = null;
		BigDecimal accountAmount = null;
		for(Iterator iterator=phaseMain.getAccountPhaseDets().iterator();iterator.hasNext();) {
			voucherDet = new VoucherDet();
			phaseDet = (AccountPhaseDet)iterator.next();
			voucherDet.setAccount(phaseDet.getAccountCode());
			accountAmount = getAccountAmountByFormula(source,phaseDet);
			//1020730調整成不四捨五入，防止傳票產生後在畫面上又四捨五入一次，造成尾差
			//accountAmount = accountAmount.setScale(1,BigDecimal.ROUND_HALF_UP);
			voucherDet.setAccountAmount(accountAmount);
			voucherDet.setAccountType(phaseDet.getAccountType());
			if (voucherDet.getAccountAmount().intValue() != 0)
				manager.addVoucherDet(voucher,voucherDet,1);
		}
	}

	private BigDecimal getAccountAmountByFormula(Object source,AccountPhaseDet phaseDet) {
		// TODO Auto-generated method stub
		String formula = phaseDet.getFormula();
		if ("".equals(formula) || formula == null) {
			return new BigDecimal(0);
		}
		else {
			BigDecimal accountAmount = countAmountByFormula(source,formula).setScale(2,RoundingMode.HALF_UP);
			return accountAmount;
		}
	}

	private BigDecimal countAmountByFormula(Object source,String formula) {
		
		while (formula.indexOf("(") > -1) {
			int rightQutaPos = formula.indexOf(")");
			int leftQutaPos = formula.indexOf("(");
			for(int tempLeftQutaPos = leftQutaPos;(tempLeftQutaPos!=-1 && tempLeftQutaPos < rightQutaPos);tempLeftQutaPos = formula.indexOf("(",leftQutaPos + 1)) {
				leftQutaPos = tempLeftQutaPos;
			}

			String temp = countAmountByFormula(source,formula.substring(leftQutaPos+1,rightQutaPos).trim()).toString();
			formula = formula.substring(0,leftQutaPos) + temp + formula.substring(rightQutaPos+1);
		}
		int plusPos = formula.indexOf("+");
		int minusPos = formula.indexOf("-");
		int multiPos = formula.indexOf("*");
		int devidePos = formula.indexOf("/");
		BigDecimal result=null,obj1=null,obj2=null;
		

		if( plusPos > 0) {
			obj1 = countAmountByFormula(source,formula.substring(0,plusPos).trim());
			obj2 = countAmountByFormula(source,formula.substring(plusPos+1).trim());
			result = obj1.add(obj2);
		}else if( multiPos > 0) {
			obj1 = countAmountByFormula(source,formula.substring(0,multiPos).trim());
			obj2 = countAmountByFormula(source,formula.substring(multiPos+1).trim());
			result = obj1.multiply(obj2);
		}else if( devidePos > 0) {
			obj1 = countAmountByFormula(source,formula.substring(0,devidePos).trim());
			obj2 = countAmountByFormula(source,formula.substring(devidePos+1).trim());
			try {
				result = obj1.divide(obj2, new MathContext(100));
			}catch(java.lang.ArithmeticException e ) {
				e.printStackTrace();
				result = new BigDecimal(0);
			}
		}else if  (minusPos > 0) {
			obj1 = countAmountByFormula(source,formula.substring(0,minusPos).trim());
			obj2 = countAmountByFormula(source,formula.substring(minusPos+1).trim());			
			result = obj1.subtract(obj2);
		} else
			try {
				result = new BigDecimal(formula);
			}catch (NumberFormatException e){
				try {
//					if(formula.indexOf("chargeRate")>-1){
//						String formula2 = formula.replaceAll("chargeRate","issueDate");
//						String issueDate =  BeanUtils.getProperty(source,formula2);
//						if(issueDate.compareTo("1999/07/01") <0 ){
//							return new BigDecimal(0.001);
//						}
//					}
					String decimal = BeanUtils.getProperty(source,formula);
					if (decimal == null)
						result = new BigDecimal(0);
					else
						result = new BigDecimal(decimal);
					} catch (IllegalAccessException ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
					} catch (InvocationTargetException ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
					} catch (NoSuchMethodException ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
					}					
			}
			
		
		return result;
	}
	
	protected boolean checkVoucherMade(Object source,AccountPhaseMain phase) {
		
		String sourceType = "";
		int sourceId = 0;
		try {
			sourceId = Integer.valueOf(BeanUtils.getProperty(source,"id"));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (source instanceof IssueMain) {
			sourceType = SourceTypeIssueMain;
			
		}else if (source instanceof DebtMain) {
			sourceType = SourceTypeDebtMain;
			
		}else if (source instanceof DebtPlanDet) {
			sourceType = SourceTypeDebtPlanDet;
			
		}else if (source instanceof PaymentMain) {
			sourceType = SourceTypePaymentMain;
		
		}else if (source instanceof InterestAdjustMain) {
			sourceType = SourceTypeInterestAdjustMain;
			
		}else if (source instanceof IssueExchangeTicketMain) {
			sourceType = SourceTypeIssueExchangeTicketMain;
			
		}else if (source instanceof ExtendDueDateMain) {
			sourceType = SourceTypeExtendDueDateMain;
		}
		
		StringBuffer queryString = new StringBuffer();
		
		queryString.append(" from VoucherSourceDet as source");
		queryString.append(" where source.voucher.phase = ?");
		queryString.append(" and source.voucher.sourceType =?");
		queryString.append(" and source.sourceId =?");
		
		Query query = session.createQuery(queryString.toString());
		
		query.setParameter(0,phase);
		query.setParameter(1,sourceType);
		query.setParameter(2,sourceId);

		List<VoucherMain> voucherList = query.list();
		if ((voucherList == null)||(voucherList.size() == 0))
			return false;
			
		else
			return true;
	}

	/**
	 * @return Returns the session.
	 */
	public Session getSession() {
		return session;
	}

	/**
	 * @param session The session to set.
	 */
	public void setSession(Session session) {
		this.session = session;
	}

	/**
	 * @return Returns the debtType.
	 */
	public DebtTypeRef getDebtType() {
		return debtType;
	}

	/**
	 * @param debtType The debtType to set.
	 */
	public void setDebtType(DebtTypeRef debtType) {
		this.debtType = debtType;
	}

	/**
	 * @return Returns the makeUserId.
	 */
	public String getMakeUserId() {
		return makeUserId;
	}

	/**
	 * @param makeUserId The makeUserId to set.
	 */
	public void setMakeUserId(String makeUserId) {
		this.makeUserId = makeUserId;
	}

	/**
	 * @return Returns the manager.
	 */
	public AccountManager getManager() {
		return manager;
	}

	/**
	 * @param manager The manager to set.
	 */
	public void setManager(AccountManager manager) {
		this.manager = manager;
	}

	/**
	 * @return Returns the voucherType.
	 */
	public int getVoucherType() {
		return voucherType;
	}

	/**
	 * @param voucherType The voucherType to set.
	 */
	public void setVoucherType(int voucherType) {
		this.voucherType = voucherType;
	}
}
