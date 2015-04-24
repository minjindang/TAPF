/**
 * 
 */
package tw.gov.nta.debt.account.common;

import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import tw.gov.nta.account.common.AccountManager;
import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.sql.DebitRef;
import tw.gov.nta.sql.account.VoucherDet;
import tw.gov.nta.sql.account.VoucherMain;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.DebtPlanDet;
import tw.gov.nta.sql.debt.DebtTypeRef;
import tw.gov.nta.sql.debt.IssueExchangeTicketMain;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.PaymentMain;
import tw.gov.nta.sql.debt.account.AccountPhaseDet;
import tw.gov.nta.sql.debt.account.AccountPhaseMain;
import tw.gov.nta.sql.debt.account.VoucherNoRef;
import tw.gov.nta.sql.debt.account.dao.AccountPhaseDetDAO;
import tw.gov.nta.sql.debt.account.dao.AccountPhaseMainDAO;
import tw.gov.nta.sql.debt.dao.IssueMainDAO;


/**
 * @author Administrator
 *
 */
public class DebtAccountManager extends AccountManager {
	private AccountPhaseMainDAO phaseDao = new AccountPhaseMainDAO();
	private AccountPhaseDetDAO phaseDetDao = new AccountPhaseDetDAO();
	DecimalFormat decimalFormat = new DecimalFormat();
	//voucherType
	static public Integer Sell = 1;
	static public Integer Pay = 2;
	static public Integer Charge = 3;
	static public Integer PayCharge = 4;
	//sourceType
	static public String Issue = "A";
	static public String Debt = "B";
	static public String Plan = "C";
	static public String Payment = "D";
	static public String InterestAdjust = "E";
	public AccountPhaseMain getPhase(Integer id) throws HibernateException
    {	
		//依照主鍵值找出代碼類別資料
		//依照主鍵值找出代碼類別資料
		Session session = phaseDao.getSession();
		AccountPhaseMain phase = phaseDao.get(id,session);
		Hibernate.initialize(phase);
		session.close();
		return phase;
    }

    public void createPhase(AccountPhaseMain accountPhaseMain) throws HibernateException
    {
    	//將代碼新增於資料檔中
    	//傳入代碼類別資料AccountPhaseMain並將資料儲存至資料檔
    	phaseDao.save(accountPhaseMain);
    }

    public void updatePhase(AccountPhaseMain accountPhaseMain) throws HibernateException
    {
    	//更新所對應，並以傳入AccountPhaseMain更新相關資料
    	phaseDao.saveOrUpdate(accountPhaseMain);
    }
    
    public void deletePhase(Integer id) throws HibernateException
    {
    	//以傳入之主鍵值找出對應的代碼類別資料並刪除
    	phaseDao.delete(id);
    }

    public AccountPhaseMain queryPhase(int id) throws HibernateException
    {
    	
        return phaseDao.get(id);

    	//以代碼類別(代碼類別、代碼類別名稱)找出相符的資料
    }	
    
    public List queryPhase(AccountPhaseMain accountPhaseMain) throws HibernateException
    {
        Criteria criteria = phaseDao.getSession().createCriteria(AccountPhaseMain.class);     
        criteria.add(Expression.eq("debtType",accountPhaseMain.getDebtType()));
        
        if ((null != accountPhaseMain.getPhaseCode()) && (!"".equals(accountPhaseMain.getPhaseCode().trim())))
            criteria.add(Expression.like("phaseCode", accountPhaseMain.getPhaseCode().trim()+"%"));
        if ((null != accountPhaseMain.getPhaseName()) && (!"".equals(accountPhaseMain.getPhaseName().trim())))
            criteria.add(Expression.like("phaseName", accountPhaseMain.getPhaseName().trim()+'%'));
        if ((null != accountPhaseMain.getPhaseShortName()) && (!"".equals(accountPhaseMain.getPhaseShortName().trim())))
            criteria.add(Expression.like("phaseShortName", accountPhaseMain.getPhaseShortName().trim()+'%'));
        if ((null != accountPhaseMain.getIssueKind()) && (!"".equals(accountPhaseMain.getIssueKind().trim())) && (!"2".equals(accountPhaseMain.getIssueKind().trim())))
            criteria.add(Expression.eq("issueKind", accountPhaseMain.getIssueKind().trim()));
        if ((null != accountPhaseMain.getPhaseType()) && (!"".equals(accountPhaseMain.getPhaseType())))
            criteria.add(Expression.eq("phaseType", accountPhaseMain.getPhaseType()));
        
        criteria.addOrder(Order.asc("phaseCode"));
        return criteria.list();

    	//以代碼類別(代碼類別、代碼類別名稱)找出相符的資料
    }	
    
    
	public AccountPhaseDet getPhaseDet(Integer id) throws HibernateException
    {	
		//依照主鍵值找出代碼類別資料
		Session session = phaseDetDao.getSession();
		AccountPhaseDet phaseDet = phaseDetDao.get(id,session);
		Hibernate.initialize(phaseDet);
		session.close();
		return phaseDet;
    }

    public void createPhaseDet(AccountPhaseDet accountPhaseDet) throws HibernateException
    {
    	//將代碼新增於資料檔中
    	//傳入代碼類別資料AccountPhaseMain並將資料儲存至資料檔
    	phaseDetDao.save(accountPhaseDet);
    }

    public boolean updatePhaseDet(AccountPhaseDet accountPhaseDet) throws HibernateException
    {
    	//更新所對應，並以傳入AccountPhaseMain更新相關資料
    	phaseDetDao.saveOrUpdate(accountPhaseDet);
        return true;
    }
    
    public void deletePhaseDet(Integer id) throws HibernateException
    {
    	//以傳入之主鍵值找出對應的代碼類別資料並刪除
    	phaseDetDao.delete(id);
    }

    public List queryPhaseDet(AccountPhaseDet accountPhaseDet) throws HibernateException
    {
        Criteria criteria = phaseDetDao.getSession().createCriteria(AccountPhaseMain.class);
        if ((null != accountPhaseDet.getAccountPhase()) && (!"".equals(accountPhaseDet.getAccountPhase())))
            criteria.add(Expression.like("phaseCode", accountPhaseDet.getAccountPhase()+"%"));
        if ((null != accountPhaseDet.getAccountCode()) && (!"".equals(accountPhaseDet.getAccountCode())))
 //           criteria.add(Expression.like("phaseName", accountPhaseDet.getAccountCodeId()+'%'));
        criteria.addOrder(Order.asc("phaseCode"));
        return criteria.list();

    	//以代碼類別(代碼類別、代碼類別名稱)找出相符的資料
    }	
    
    public List<VoucherMain> generateVoucherByIssue(int issueId,int voucherType,String makeUserId,boolean isSpecial,DebtTypeRef debt)
    			throws Exception{
    	//特殊傳票則回傳空傳票
    	List<VoucherMain> vouchers = null;

		IssueMainDAO issueMainDao = IssueMainDAO.getInstance();
		Session session = issueMainDao.getSession();
    	vouchers = generateVoucherByIssue(issueId,voucherType,makeUserId,isSpecial,session,debt);
    	session.close();
    	return vouchers;
    }

    public List<VoucherMain> generateVoucherByIssue(int issueId,int voucherType,String makeUserId,boolean isSpecial,Session session,DebtTypeRef debt)
	throws Exception{
		//特殊傳票則回傳空傳票
		List<VoucherMain> vouchers = null;
		
		IssueMain issue = (IssueMain)session.load(IssueMain.class,issueId);
		vouchers = generateVoucherByIssue(issue,voucherType,makeUserId,isSpecial,session,debt);

		return vouchers;
}   
    
    public List<VoucherMain> generateVoucherByIssue(IssueMain issue,int voucherType,String makeUserId,boolean isSpecial,Session session,DebtTypeRef debt)
	throws Exception{
		//特殊傳票則回傳空傳票
		List<VoucherMain> vouchers = null;
		DebtVoucherFactory factory = DebtVoucherFactory.getInstance(session);
		vouchers = factory.makeVouchers(issue,voucherType,makeUserId,isSpecial,debt);
		
		//將傳票排序
		vouchers = sortVoucher(vouchers);
		return vouchers;
}        
    
	/* (non-Javadoc)
	 * @see tw.gov.nta.account.common.AccountManager#setVoucherNo(tw.gov.nta.sql.account.VoucherMain)
	 */
	protected void setVoucherNo(VoucherMain voucher,IssueMain issue) throws Exception {
		// TODO Auto-generated method stub
		Session session = phaseDao.getSession();
		setVoucherNo(voucher,issue,session);
	}
 
	protected void setVoucherNo(VoucherMain voucher,IssueMain issue,Session session) throws Exception {
		// TODO Auto-generated method stub
		super.setVoucherNo(voucher,session);
		String voucherNo = generateVoucherNo(voucher,issue,session);
		if (voucherNo == null)
			throw new Exception("無法取得傳票號碼!");
		voucher.setVoucherNo(voucherNo);
		
	}
	
	/*
	 * 產生傳票編號
	 * 編碼原則：發行年度 + 預算(中長借不加) + 預算期別 + 傳票別(S=>經售(舉借)類) + 流水號 
	 * 										P=>經付(償付)
	 * 										L=>手續費
	 * 										T=>轉換
	 * 
	 * 公債編碼原則：發行年度+期次(2碼)+預算別+傳票類別+付息期次(經付類,經售類帶'00')+流水號(3碼)
	 */
	
	private String generateVoucherNo(VoucherMain voucher,IssueMain issue,Session session) {
		// TODO Auto-generated method stub

		
		int voucherType = voucher.getVoucherType();

		boolean isBond = false;
		
		if ("A".equals(issue.getDebtType()))
			isBond = true;
		
		StringBuffer buffer = new StringBuffer();
		//發行年度
		String accountYear = issue.getAccountYear();
//		decimalFormat.applyPattern("000");
//		accountYear = decimalFormat.format(accountYear);
		buffer.append(accountYear);
		
		//期別
		String serialNo = issue.getSerialNo();
		decimalFormat.applyPattern("00");
		
		try {
			buffer.append(decimalFormat.format(Integer.parseInt(serialNo)));
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			buffer.append(serialNo);
		}
		
		int budgetId = voucher.getBudgetCode(),debtId = voucher.getDebtCode();
		if(debtId == 0 ) {
			if (voucher.getSourceType().equals(DebtVoucherFactory.SourceTypeDebtMain)) {
				DebtMain debt = (DebtMain)session.get(DebtMain.class,voucher.getVoucherSourceDets().iterator().next().getSourceId());
				budgetId = debt.getBudgetCode();
				debtId = debt.getDebtCode();
				
			}else {
				budgetId = issue.getBudgetCode();
				debtId = issue.getDebtCode();
			}
		}
		//預算別 *先拿掉..看來只要有債務別就好了
//		String bugetCode = ((BudgetRef)session.get(BudgetRef.class,budgetId)).getBudgetType();
//		buffer.append(bugetCode);
		
		String debtCode = "";
		//債務別(中長借不加)
		if(!"C".equals(issue.getDebtType().trim())) {
		
			if(debtId != 0) {
				debtCode = ((DebitRef)session.get(DebitRef.class,debtId)).getDebitType();
			}else {
				debtCode = "";
			}
			
			buffer.append(debtCode);
		}
		//傳票別
		if (voucherType == DebtAccountManager.Sell)
			buffer.append("S");
		else if(voucherType == DebtAccountManager.Pay)
			buffer.append("P");
		else if(voucherType == DebtAccountManager.Charge)
			buffer.append("L");
		else if(voucherType == DebtAccountManager.PayCharge)
			buffer.append("L");		
		else
			buffer.append("X");
		
		String paymentSerialNo = "";
		String sourceType = voucher.getSourceType();
		if(isBond) {
			if(DebtVoucherFactory.SourceTypeIssueMain.equals(voucher.getSourceType()) || DebtVoucherFactory.SourceTypeDebtMain.equals(voucher.getSourceType())) {
				paymentSerialNo = "00";
			}else if(DebtVoucherFactory.SourceTypeDebtPlanDet.equals(sourceType) 
				  || DebtVoucherFactory.SourceTypePaymentMain.equals(sourceType)
				  || DebtVoucherFactory.SourceTypeIssueExchangeTicketMain.equals(sourceType)) {
				Object payment = getVoucherSource(voucher.getSourceType(),voucher.getVoucherSourceDets().iterator().next().getSourceId(),session);
				try {
					String capitalSerial = BeanUtils.getProperty(payment,"capitalSerial").trim();
					String interestSerial = BeanUtils.getProperty(payment,"interestSerial").trim();
					if (capitalSerial != null && Integer.parseInt(capitalSerial) !=0) {
						int capitalNo = Integer.parseInt(capitalSerial);
						paymentSerialNo = decimalFormat.format(capitalNo);

					}else if (interestSerial != null && Integer.parseInt(interestSerial) !=0) {
							int interestNo = Integer.parseInt(interestSerial);
							paymentSerialNo = decimalFormat.format(interestNo);
					}else {
						paymentSerialNo ="00";
					}
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					paymentSerialNo = "00";
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					paymentSerialNo = "00";
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					paymentSerialNo = "00";
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					paymentSerialNo = "00";
				}
			}
			
			buffer.append(paymentSerialNo);
		}
		//流水號
		buffer.append(getVoucherSerialNo(issue.getDebtType(),accountYear,debtCode,serialNo,voucherType,paymentSerialNo,session));
		if (issue.getIssueKind()== null)
			issue.setIssueKind("0");
		if (voucher.getIssueKind()== null)
			voucher.setIssueKind("0");
		if (voucher.getIssueKind().trim().equals(issue.getIssueKind().trim())) {
			buffer.append("T");
		}
		return buffer.toString();
	}

	private String getVoucherSerialNo(String debtType,String accountYear, String debtCode, String serialNo,int voucherType,String paymentSerialNo,Session session) {
		// TODO Auto-generated method stub
		int voucherSerial = 0;
		VoucherNoRef voucherNo = null;
		Criteria criteria = session.createCriteria(VoucherNoRef.class);
		Map<String,Object> queryMap = new HashMap<String,Object>();
		queryMap.put("debtType",debtType);
		queryMap.put("accountYear",accountYear);
		queryMap.put("debtCode",debtCode);
		queryMap.put("issueSerial",serialNo);
		queryMap.put("voucherType",voucherType);
		queryMap.put("paymentSerialNo",paymentSerialNo);
		criteria.add(Expression.allEq(queryMap));
		List voucherNoList = criteria.list();
		if (voucherNoList == null || voucherNoList.size() == 0) {
			voucherSerial = 1;
			voucherNo = new VoucherNoRef();
			voucherNo.setAccountYear(accountYear);
			voucherNo.setDebtCode(debtCode);
			voucherNo.setIssueSerial(serialNo);
			voucherNo.setVoucherType(voucherType);
			voucherNo.setDebtType(debtType);
			voucherNo.setPaymentSerialNo(paymentSerialNo);
		}else {
			voucherNo = (VoucherNoRef)voucherNoList.get(0);
			voucherSerial = voucherNo.getSerialNo().intValue() + 1;
		}
		voucherNo.setSerialNo(voucherSerial);
		session.saveOrUpdate(voucherNo);
		decimalFormat.applyPattern("000");
		return decimalFormat.format(voucherSerial);
	}   	

	
	public void batchMakeVoucherByIssue(int[] issueIds,int voucherType,String makeUserId,DebtTypeRef debt) throws Exception {
		int issueId;
		Session session = phaseDao.createNewSession();
		IssueMain issue = null;
		for(int i=0;i<issueIds.length;i++) {
			Transaction tx = session.beginTransaction();
			try {				
				List<VoucherMain> voucherList = new ArrayList<VoucherMain>();
				issueId = issueIds[i];
				//issue = (IssueMain)session.load(IssueMain.class, issueId);
				issue = new IssueManager().getBean(issueId);
				System.out.println(issue.getId());
				voucherList = generateVoucherByIssue(issue,voucherType,makeUserId,false,session,debt);
				makeVouchers(voucherList,issue,session);
				tx.commit();
			}catch(Exception ex) {
				tx.rollback();
				throw ex;
			}
		}
		
		session.close();
		
	}

	public void makeVouchers(List voucherList,IssueMain issue,Session session) throws Exception {
		for(Iterator iterator=voucherList.iterator();iterator.hasNext();)
			makeVoucher((VoucherMain)iterator.next(),issue,session);
	}	
		
	public void makeVoucher(VoucherMain voucher,IssueMain issue,Session session) throws Exception{
		checkVoucher(voucher,session);
		setVoucherNo(voucher,issue,session);
		System.out.println(voucher.getVoucherNo());
		for(Iterator iterator = voucher.getVoucherDets().iterator();iterator.hasNext();) {
			((VoucherDet)iterator.next()).setVoucher(voucher);
		}
		session.saveOrUpdate(voucher);

	}	
	
	public void makeVoucher(VoucherMain voucher,int issueId,Session session) throws Exception{
		IssueMain issue = (IssueMain)session.get(IssueMain.class,issueId);
		makeVoucher(voucher,issue,session);

	}	
	   static public List<VoucherMain> sortVoucher(List<VoucherMain> voucherList) {
			//將傳票排序
			Collections.sort(voucherList,
					new Comparator<VoucherMain>() 
					{
						public int compare(VoucherMain o1, VoucherMain o2)  {
							
							//比傳票日期小的在前
							if (!o1.getIssueId().equals(o2.getIssueId())) {
								Session session = IssueMainDAO.getInstance().getSession();
								IssueMain issue1 = (IssueMain)session.get(IssueMain.class,o1.getIssueId());
								IssueMain issue2 = (IssueMain)session.get(IssueMain.class,o2.getIssueId());
								if(issue1.getIssueSerial().compareTo(issue2.getIssueSerial()) > 0 ) {
									return 1;
								}else {
									return -1;
								}
							}
							
							if (o1.getVoucherDate().compareTo(o2.getVoucherDate()) > 0) {
								return 1;				
							}else if(o1.getVoucherDate().compareTo(o2.getVoucherDate()) == 0) {
								//比會計階段序號 小的在前
								if (o2.getPhase().getPhaseSerial() == null) {
									return 1;
								}else if(o1.getPhase().getPhaseSerial() == null) {
									return -1;
								}
								
								if (o1.getPhase().getPhaseSerial().compareTo(o2.getPhase().getPhaseSerial()) > 0) {
									return 1;
								}else {
									return -1;
								}
							}else
								return -1;
							}
						}
			);	
			
			return voucherList;
	    }	
	   
	   private Object getVoucherSource(String sourceType,int sourceId,Session session){
		   Object result = null;
		   if(DebtVoucherFactory.SourceTypeIssueMain.equals(sourceType)) {
			   result = session.get(IssueMain.class,sourceId);
		   }else if(DebtVoucherFactory.SourceTypeDebtMain.equals(sourceType)) {
			   result = session.get(DebtMain.class,sourceId);
		   }else if(DebtVoucherFactory.SourceTypeDebtPlanDet.equals(sourceType)){
			   result = session.get(DebtPlanDet.class,sourceId);
		   }else if(DebtVoucherFactory.SourceTypePaymentMain.equals(sourceType)) {
			   result = session.get(PaymentMain.class,sourceId);
		   }else if(DebtVoucherFactory.SourceTypeIssueExchangeTicketMain.equals(sourceType)) {
			   result = session.get(IssueExchangeTicketMain.class,sourceId);
		   }
		   
		   return result;
	   }
}
