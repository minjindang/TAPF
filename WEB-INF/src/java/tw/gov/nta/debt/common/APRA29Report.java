package tw.gov.nta.debt.common;

import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.hibernate.Query;
import org.hibernate.Session;

import tw.gov.nta.sql.debt.DebtPlanDet;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.PaymentMain;
import tw.gov.nta.sql.debt.dao.DebtPlanDetDAO;
import tw.gov.nta.sql.debt.dao.PaymentMainDAO;

import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class APRA29Report {
	
	public List planSubReportAmount(String[] debtType,String[] debtCode,String[] conds,Date startDate , Date endDate,String path){
		//1030724_startDate�u�̾ڨt�Τ�+1���D
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH,c.get(Calendar.DAY_OF_MONTH)+1);
		startDate = c.getTime();
		
		List<DebtPlanDet> allPlan = new LinkedList<DebtPlanDet>();
		List<DebtPlanDet> endList = new LinkedList<DebtPlanDet>();		
		for(int i = 0 ; i<debtType.length;i++){
			List list = getPalnList(debtType[i].toString(),debtCode[i].toString(),conds[i].toString(),startDate,endDate,"1",path);
			if(list!=null){
				for(Iterator it = list.iterator();it.hasNext();){
					DebtPlanDet debtPlanDet = (DebtPlanDet)((Object[])it.next())[0];
					if (!debtPlanDet.getId().equals(63768))
					{
//						BigDecimal allCapitalAmount = new PayManager().getCapitalByDebt(debtPlanDet.getDebt().getId());
						BigDecimal allCapitalAmount = new PayManager().getCapitalByDebt(debtPlanDet.getDebt().getId(),startDate);
						if(allCapitalAmount.compareTo(debtPlanDet.getDebt().getIssueAmount()) == 0){
							debtPlanDet.setInterestAmount(new BigDecimal("0"));
						}
						allPlan.add(debtPlanDet);
					}
				}
			}	
		}
		
		if (!allPlan.isEmpty()){
			List list2 = getPaymentList(allPlan, startDate, endDate);
			if (list2 != null){
				DebtPlanDetDAO dao = new DebtPlanDetDAO();
				Session session = dao.getSession();
				String debtPlantDetSQL = "from DebtPlanDet debtPlanDet where 1 =1 and debtPlanDet.issueId not in (from IssueMain issueMain where issueMain.id = debtPlanDet.issueId and issueMain.debtType = 'A') and debtPlanDet.id = ";
				for(Iterator it = list2.iterator(); it.hasNext();){
					PaymentMain paymentMain = (PaymentMain)(it.next());
					String sql = debtPlantDetSQL + paymentMain.getPlan().getId() + " order by debtPlanDet.repayDate";
					Query query = session.createQuery(sql.toString());
					List list3 = query.list();
					if(null != list3 && !list3.isEmpty())
					{
						DebtPlanDet debtPlanDet = (DebtPlanDet)(list3.get(0));
//						System.out.println("debtPlanDet=="+debtPlanDet.getId());
//						if("A".equals(debtPlanDet.getDebt().getIssue().getDebtType())){
//							debtPlanDet.setRepayDate(DateUtil.str2Date(DateUtil.getDateAdd("d",-1,DateUtil.date2ROCStr(debtPlanDet.getRepayDate()))));
//						}
						allPlan.add(debtPlanDet);
					}
				}
			}
		}
		//���o��plan��ƻݦ������e�v�٪��B
		for(Iterator it = allPlan.iterator();it.hasNext();){
			DebtPlanDet debtPlanDet = (DebtPlanDet)it.next();
			
			List paymentMainList = null;
			if("B".equals(debtPlanDet.getDebt().getIssue().getDebtType())){
				//20120104 chris wu �]��w��L�����A�G�ϥ�debtplandet.repayDate���e����ơA���@���e�R�^��ơC
				paymentMainList =  new PayManager().getListByPlan(debtPlanDet.getId(),debtPlanDet.getRepayDate());
			}else{
				paymentMainList =  new PayManager().getListByPlan(debtPlanDet.getId());
			}
			
			if(paymentMainList.size() == 0){
				endList.add(checkDebtType(debtPlanDet));
			}else{
				for(Iterator itPayment = paymentMainList.iterator();itPayment.hasNext();){
					PaymentMain paymentMain = (PaymentMain)itPayment.next();
					if((paymentMain.getRepayDate().getTime() == debtPlanDet.getRepayDate().getTime()) && (!"A".equals(debtPlanDet.getDebt().getIssue().getDebtType()))){
						endList.add(createTempDebtPlanDet(paymentMain, checkDebtType(debtPlanDet)));
					}else{
						debtPlanDet.setCapitalAmount(debtPlanDet.getCapitalAmount().subtract(paymentMain.getCapitalAmount()));
						if("C".equals(debtPlanDet.getDebt().getIssue().getDebtType()) && !debtPlanDet.getCapitalAmount().equals(paymentMain.getCapitalAmount())){
							RateManager myRate = new RateManager();
							InterestCounter myCounter = new InterestCounter();
							//���o�̤j���٥��I�����
							Date maxRepayDate = new PayManager().getMaxDateByDebt(debtPlanDet.getDebt().getId());
							//���s�p�⤤���ɧQ��
							debtPlanDet.setInterestAmount(myCounter.countInterest(maxRepayDate,
													debtPlanDet.getRepayDate(),
													myRate.getEffectiveRate(debtPlanDet.getDebt().getId()),
													debtPlanDet.getCapitalAmount().doubleValue(),0));
							endList.add(debtPlanDet);
						}else if(debtPlanDet.getDebt().getIssue().getDebtType().equals("E")){
							BigDecimal chargeAmount = debtPlanDet.getChargeAmount();
							BigDecimal transferCapitalAmount = null!=debtPlanDet.getTransferCapitalAmount()?debtPlanDet.getTransferCapitalAmount():new BigDecimal(0);
							BigDecimal transferInterestAmount = null!=debtPlanDet.getTransferInterestAmount()?debtPlanDet.getTransferInterestAmount():new BigDecimal(0);
							BigDecimal interestAmount = null!=paymentMain.getInterestAmount()?paymentMain.getInterestAmount():new BigDecimal(0);
							debtPlanDet.setInterestAmount((chargeAmount.multiply(transferCapitalAmount).multiply(transferInterestAmount)
									.divide(new BigDecimal(365)).divide(new BigDecimal(100))).setScale(4,4).subtract(interestAmount));
						}else if((paymentMain.getRepayDate().getTime()>=startDate.getTime() && paymentMain.getRepayDate().getTime()<=endDate.getTime())){
							//���ůS�O�B�z
							if("3774".equals(debtPlanDet.getIssueId().toString()))
								System.out.println(debtPlanDet.getIssueId());
							if("A".equals(debtPlanDet.getDebt().getIssue().getDebtType())){
								//�̫�@����payment_main
								if((paymentMain.getRepayDate()).toString().equals(paymentMain.getPlan().getDebt().getIssue().getFinishDate().toString())){
									//&& !"1".equals(paymentMain.getCapitalSerial().trim())
									if("A".equals(paymentMain.getPlan().getDebt().getIssue().getDebtType()) ){
										paymentMain.setRepayDate(DateUtil.str2Date(DateUtil.getDateAdd("d",-1,DateUtil.date2ROCStr(paymentMain.getRepayDate()))));
									}
									endList.add(createTempDebtPlanDet(paymentMain, checkDebtType(debtPlanDet)));
								//���O�̫�@���A�B���O���e�R�^��debt_plan_det
								}else if(paymentMain.getRepayDate().toString().equals(paymentMain.getPlanRepayDate().toString())){
									endList.add(debtPlanDet);
								//�䥦���p
								}else{
									if("A".equals(paymentMain.getPlan().getDebt().getIssue().getDebtType())){
										paymentMain.setRepayDate(DateUtil.str2Date(DateUtil.getDateAdd("d",-1,DateUtil.date2ROCStr(paymentMain.getRepayDate()))));
									}
									endList.add(createTempDebtPlanDet(paymentMain, checkDebtType(debtPlanDet)));
								}
							}else
								endList.add(createTempDebtPlanDet(paymentMain, checkDebtType(debtPlanDet)));
						}else if("B".equals(debtPlanDet.getDebt().getIssue().getDebtType())){
							/**
							 * ��w��
							 * �ꦬ��=���B/10000*�C�U������
							 * �Q����=���B-�ꦬ��
							 * �Q���`�ټ�=���e�R�^���B-���e�R�^�ꦬ��-���e�R�^�Q��
							 */
//							System.out.println(debtPlanDet.getIssueId());
							BigDecimal saveInterestAmount = new BigDecimal("0");
							
							BigDecimal manageCapitalAmount = paymentMain.getManageCapitalAmount();
							if(manageCapitalAmount == null)
								manageCapitalAmount = new BigDecimal("0");
							BigDecimal manageInterestAmount = paymentMain.getManageInterestAmount();
							if(manageInterestAmount == null)
								manageInterestAmount = new BigDecimal("0");
							saveInterestAmount = paymentMain.getBalanceCapitalAmount().subtract(manageCapitalAmount).subtract(manageInterestAmount);
							
							debtPlanDet.setInterestAmount(debtPlanDet.getInterestAmount().subtract(paymentMain.getInterestAmount()).subtract(saveInterestAmount));
							
							endList.add(debtPlanDet);
						}else{
							endList.add(debtPlanDet);
						}
					}
				}
			}			
		}
		
		//���o�����ɧQ�����
		List list = getPalnList("C","","",startDate,endDate,"2",path);
		for(Iterator it = list.iterator();it.hasNext();){
			DebtPlanDet debtPlanDet = (DebtPlanDet)((Object)it.next());	
			debtPlanDet.setInterestAmount(new PlanManager().getMiddlePlanInterestAmount(debtPlanDet.getId()));
			//�u���Q�����S�O�B�z�ҥH���ΦҼ{�٥�
			debtPlanDet.setCapitalAmount(new BigDecimal(0));
			List paymentMainList =  new PayManager().getListByPlan(debtPlanDet.getId());
			if(paymentMainList.size() == 0 && debtPlanDet.getRepayDate().after(new Date())){
//				endList.add(debtPlanDet);
			}
			else{
				for(Iterator itPayment = paymentMainList.iterator();itPayment.hasNext();){
					PaymentMain paymentMain = (PaymentMain)itPayment.next();
					System.out.println(paymentMain.getIssueId());
					System.out.println(paymentMain.getInterestAmount());
					if(paymentMain.getRepayDate().compareTo(debtPlanDet.getRepayDate())==0){
						endList.add(createTempDebtPlanDetInterest(paymentMain, debtPlanDet));
					}
					else{
						BigDecimal allCapitalAmount = new PayManager().getCapitalByDebt(debtPlanDet.getDebt().getId());
						//�s�[�{��0980203
//						if (!debtPlanDet.getDebt().getIssue().getCapitalAmount().equals(debtPlanDet.getDebt().getIssue().getIssueAmount()))
						if (!allCapitalAmount.equals(debtPlanDet.getDebt().getCompareAmount()))
							debtPlanDet.setInterestAmount(debtPlanDet.getInterestAmount().subtract(paymentMain.getInterestAmount()));
						else
							debtPlanDet.setInterestAmount(new BigDecimal(0));
						long payDate = (paymentMain.getRepayDate()).getTime();
						long sDate = (startDate).getTime();	
						long eDate = (endDate).getTime();	
//						if(paymentMain.getRepayDate().compareTo(startDate)== -1 && paymentMain.getRepayDate().compareTo(endDate)== 1)
						if(payDate >= sDate && payDate <= eDate)
							endList.add(createTempDebtPlanDetInterest(paymentMain, debtPlanDet));
						endList.add(debtPlanDet);
					}
				}
			}
		}
		return endList;
	}
	private DebtPlanDet checkDebtType(DebtPlanDet debtPlanDet){
		if(debtPlanDet.getDebt().getIssue().getDebtType().equals("A")){
			Calendar tCalendar = GregorianCalendar.getInstance();
			tCalendar.setTime(debtPlanDet.getRepayDate());
			//tCalendar.add(tCalendar.DATE, -1);
			debtPlanDet.setRepayDate(tCalendar.getTime());
			return debtPlanDet;
		}
		else
			return debtPlanDet;
	}
	private DebtPlanDet createTempDebtPlanDet(PaymentMain paymentMain,DebtPlanDet debtPlanDet){
		DebtPlanDet tempDebtPlanDet = new DebtPlanDet();
		tempDebtPlanDet.setRepayDate(paymentMain.getRepayDate());
		tempDebtPlanDet.setInterestAmount(paymentMain.getInterestAmount());
		tempDebtPlanDet.setCapitalAmount(paymentMain.getCapitalAmount());
		tempDebtPlanDet.setIssueId(debtPlanDet.getIssueId());
		return tempDebtPlanDet;
	}
	private DebtPlanDet createTempDebtPlanDetInterest(PaymentMain paymentMain,DebtPlanDet debtPlanDet){
		DebtPlanDet tempDebtPlanDet = new DebtPlanDet();
		tempDebtPlanDet.setRepayDate(paymentMain.getRepayDate());
		tempDebtPlanDet.setInterestAmount(paymentMain.getInterestAmount());
		tempDebtPlanDet.setCapitalAmount(new BigDecimal(0));
		tempDebtPlanDet.setIssueId(debtPlanDet.getIssueId());
		return tempDebtPlanDet;
	}
	private BigDecimal[] paymentAmount(Integer debtPlanId){
		BigDecimal[] paymentAmount = {new BigDecimal(0),new BigDecimal(0)};
		List paymentList = new PayManager().getListByPlan(debtPlanId);
		for(Iterator itPayment = paymentList.iterator();itPayment.hasNext();){
			PaymentMain paymentMain = (PaymentMain)itPayment.next();
			paymentAmount[0] = paymentAmount[0].add(paymentMain.getCapitalAmount());
			paymentAmount[1] = paymentAmount[1].add(paymentMain.getInterestAmount());
		}
		return paymentAmount;
	}
	//patch����apra28 or apra29�ϥ�
	public Map completeTempMap(String path,DebtPlanDet debtPlanDet) {
		Map map = new HashMap();
		IssueMain issueMain = new IssueManager().getBean(debtPlanDet.getIssueId());
		map.put("REPAY_DATE", debtPlanDet.getRepayDate());
		map.put("CAPITAL_AMOUNT", debtPlanDet.getCapitalAmount());
		map.put("INTEREST_AMOUNT", debtPlanDet.getInterestAmount());
		map.put("DEBT_TYPE", issueMain.getDebtType());
		map.put("DEBT_CODE", issueMain.getDebtCode());
		map.put("PATH", path);
		return map;
	}
	private Object completeMap(DebtPlanDet debtPlanDet) {
		Map map = new HashMap();
		map.put("REPAY_DATE", "");
		map.put("FLIGHT_CAPITAL_AMOUNT", "");
		map.put("FLIGHT_INTEREST_AMOUNT", "");
		map.put("LONG_CAPITAL_AMOUNT", "");
		map.put("LONG_INTEREST_AMOUNT", "");
		map.put("SHORT_CAPITAL_AMOUNT", "");
		map.put("SHORT_INTEREST_AMOUNT", "");
		map.put("SHORTFUND_CAPITAL_AMOUNT", "");
		map.put("SHORTFUND_INTEREST_AMOUNT", "");
		map.put("BOND_CAPITAL_AMOUNT", "");
		map.put("BOND_INTEREST_AMOUNT", "");
		map.put("NATION_CAPITAL_AMOUNT", "");
		map.put("NATION_INTEREST_AMOUNT", "");
		return null;
	}
	//20090716�[�J���e�ٴڪ�����
	private List getPaymentList(List<DebtPlanDet> DebtPlanDetList, Date startDate , Date endDate)
	{
		PaymentMainDAO dao = new PaymentMainDAO();
		Session session = dao.getSession();
		String debtPlanDetId = "";
		StringBuffer strbuff = new StringBuffer();
		String issueId = "";
		for(Iterator it = DebtPlanDetList.iterator();it.hasNext();){
			DebtPlanDet debtPlanDet = (DebtPlanDet)it.next();
			issueId = String.valueOf(debtPlanDet.getIssueId());
			if (!"".equals(debtPlanDetId))
				debtPlanDetId = debtPlanDetId + "," + debtPlanDet.getId().toString();
			else
				debtPlanDetId = debtPlanDet.getId().toString();
		}
		strbuff.append("from PaymentMain paymentMain ");
		strbuff.append("where 1 = 1 ");
		strbuff.append("and paymentMain.repayDate between '" + DateUtil.date2Str(startDate, "yyyy/MM/dd") +"' and '" +
				DateUtil.date2Str(endDate, "yyyy/MM/dd") + "' ");
		strbuff.append("and paymentMain.plan.id not in (" + debtPlanDetId + ") ");
//		if("3915".equals(issueId) || "3927".equals(issueId))
//			System.out.println("���e�ٴڡG"+strbuff.toString());
		Query query = session.createQuery(strbuff.toString());

		if(query.list() == null)
			return new LinkedList();
		else
			return query.list();	
	}

	private List getPalnList(String debtType, String debtCode,String conds ,Date startDate , Date endDate,String multiplyKey,String path) {
		DebtPlanDetDAO dao = new DebtPlanDetDAO();
		Session session = dao.getSession();
		DateUtil dateUtil = new DateUtil();
		StringBuffer strbuff = new StringBuffer();
		if(multiplyKey.equals("2"))
			strbuff.append("from DebtPlanDet debtPlanDet ");
		else
			strbuff.append("from DebtPlanDet debtPlanDet, IssueMain issueMain ");
		strbuff.append("where 1 = 1");
		if(!debtType.equals("") && debtType != null && multiplyKey.equals("2"))
			strbuff.append(" and debtPlanDet.issueId in (select id from IssueMain i where i.debtType='"+debtType+"')");
		else{
			strbuff.append(" and debtPlanDet.issueId = issueMain.id");
			strbuff.append(" and issueMain.debtType = '"+debtType+"'");
		}
		strbuff.append(" and debtPlanDet.deleteMark ='N'");	
		if(!debtCode.equals("") && debtCode != null && !conds.equals("") && conds != null && !multiplyKey.equals("2")){
			if ("A".equals(debtType))
				strbuff.append(" and issueMain.bondType "+conds+debtCode.toString());
			else
				strbuff.append(" and issueMain.debtCode.id "+conds+debtCode.toString());
		}
		strbuff.append(" and debtPlanDet.repayDate >= '"+dateUtil.date2Str(startDate, "yyyy/MM/dd")+"'");
		strbuff.append(" and debtPlanDet.repayDate <= '"+dateUtil.date2Str(endDate, "yyyy/MM/dd")+"'");
		if(!debtType.equals("") && debtType != null &&debtType.equals("C")){
			//�j�h�Ʀs��null�A�G���h��
//			strbuff.append(" and debtPlanDet.reportFlag = '0'");
			strbuff.append(" and (debtPlanDet.interestAmount > '0' or debtPlanDet.capitalAmount > '0')");
		}
//		if(!debtType.equals("") && debtType != null &&debtType.equals("A")&& path.equals("apra29"))
//			strbuff.append(" and issueMain.bondType <> '2'");
		Query query = session.createQuery(strbuff.toString());
//		System.out.println(strbuff.toString());
		query.equals(null);
		if(query.list() == null)
//		if(query.equals(null))
			return new LinkedList();
		else
			return query.list();
	}
	public SQLJob insTemp(String usrId,String path){
		return insTemp( usrId, path,null,null);
	}
	public SQLJob insTemp(String usrId,String path,Date startDate , Date endDate){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO " + path+"_rpt");
		sqljob.appendSQL(" ( ");
		if(path.equals("apra29"))
			sqljob.appendSQL(" REPAY_DATE , ROC_REPAY_DATE,");
		else
			sqljob.appendSQL(" REPAY_DATE, ");
		sqljob.appendSQL("  FLIGHT_CAPITAL_AMOUNT, FLIGHT_INTEREST_AMOUNT, LONG_CAPITAL_AMOUNT, LONG_INTEREST_AMOUNT, ");
		sqljob.appendSQL(" SHORT_CAPITAL_AMOUNT, SHORT_INTEREST_AMOUNT, SHORTFUND_CAPITAL_AMOUNT, SHORTFUND_INTEREST_AMOUNT, BOND_CAPITAL_AMOUNT, ");
		sqljob.appendSQL(" BOND_INTEREST_AMOUNT, NATION_CAPITAL_AMOUNT, NATION_INTEREST_AMOUNT, TOTAL_AMOUNT, ");
		sqljob.appendSQL(" USRID, MOD_DATE, REMARK ");
		sqljob.appendSQL(" ) ");
		if(path.equals("apra29"))
			sqljob.appendSQL(" SELECT REPAY_DATE,CAST(DATEPART( yy ,REPAY_DATE )-1911 AS CHAR(3))+'/'+CAST(DATEPART( MM ,REPAY_DATE ) AS CHAR(2))+'/'+CAST(DATEPART( DD ,REPAY_DATE ) AS CHAR(2)) ");
		else
//			sqljob.appendSQL(" SELECT (CASE WHEN DEBT_TYPE='A' THEN REPAY_DATE-1 ELSE REPAY_DATE END)");
		sqljob.appendSQL(" select REPAY_DATE");
//		sqljob.appendSQL(",ISNULL(SUM((CASE WHEN DEBT_TYPE='E' AND DEBT_CODE = 58 THEN CAPITAL_AMOUNT ELSE 0 END)),0)/100000000  AS FLIGHT_CAPITAL_AMOUNT");
//		sqljob.appendSQL(",ISNULL(SUM((CASE WHEN DEBT_TYPE='E' AND DEBT_CODE = 58 THEN INTEREST_AMOUNT ELSE 0 END)),0)/100000000 AS FLIGHT_INTEREST_AMOUNT");
		sqljob.appendSQL(",SUM((CASE WHEN DEBT_TYPE='D' AND DEBT_CODE=31 THEN CAPITAL_AMOUNT ELSE 0 END)) AS FLIGHT_CAPITAL_AMOUNT");
		sqljob.appendSQL(",SUM((CASE WHEN DEBT_TYPE='D' AND DEBT_CODE=31 THEN INTEREST_AMOUNT ELSE 0 END)) AS FLIGHT_INTEREST_AMOUNT");
		sqljob.appendSQL(",SUM((CASE WHEN DEBT_TYPE='C'  THEN CAPITAL_AMOUNT ELSE 0 END)) AS LONG_CAPITAL_AMOUNT");
		sqljob.appendSQL(",SUM((CASE WHEN DEBT_TYPE='C'  THEN INTEREST_AMOUNT ELSE 0 END)) AS LONG_CAPITAL_AMOUNT");
		sqljob.appendSQL(",SUM((CASE WHEN DEBT_TYPE='D' AND DEBT_CODE not in (31,25) THEN CAPITAL_AMOUNT ELSE 0 END)) AS SHORT_CAPITAL_AMOUNT");
		sqljob.appendSQL(",SUM((CASE WHEN DEBT_TYPE='D' AND DEBT_CODE not in (31,25) THEN INTEREST_AMOUNT ELSE 0 END)) AS SHORT_INTEREST_AMOUNT");
		sqljob.appendSQL(",SUM((CASE WHEN DEBT_TYPE='D' AND DEBT_CODE=25 THEN CAPITAL_AMOUNT ELSE 0 END)) AS SHORTFUND_CAPITAL_AMOUNT");
		sqljob.appendSQL(",SUM((CASE WHEN DEBT_TYPE='D' AND DEBT_CODE=25 THEN INTEREST_AMOUNT ELSE 0 END)) AS SHORTFUND_INTEREST_AMOUNT");
		sqljob.appendSQL(",SUM((CASE WHEN DEBT_TYPE='A' THEN CAPITAL_AMOUNT ELSE 0 END)) AS BOND_CAPITAL_AMOUNT");
		sqljob.appendSQL(",SUM((CASE WHEN DEBT_TYPE='A' THEN INTEREST_AMOUNT ELSE 0 END)) AS BOND_INTEREST_AMOUNT");
		sqljob.appendSQL(",SUM((CASE WHEN DEBT_TYPE='B' THEN CAPITAL_AMOUNT ELSE 0 END)) AS NATION_CAPITAL_AMOUNT");
		sqljob.appendSQL(",SUM((CASE WHEN DEBT_TYPE='B' THEN INTEREST_AMOUNT ELSE 0 END)) AS NATION_INTEREST_AMOUNT");
		sqljob.appendSQL(",SUM( ISNULL(CAPITAL_AMOUNT,0) )+SUM( ISNULL(INTEREST_AMOUNT,0) ) AS TOTAL_AMOUNT");
		sqljob.appendSQL(",'"+usrId+"'");
		sqljob.appendSQL(",'"+new Timestamp( new Date().getTime() )+"'");
		sqljob.appendSQL(",''");
		sqljob.appendSQL("FROM apra29_temp");
		sqljob.appendSQL("WHERE path = '"+path+"'");
		sqljob.appendSQL("and (CAPITAL_AMOUNT >0 or INTEREST_AMOUNT >0)");
		if(startDate != null){
			sqljob.appendSQL(" AND REPAY_DATE >= ?");
			sqljob.addParameter(startDate);
		}
		if(endDate != null){
			sqljob.appendSQL(" AND REPAY_DATE <= ?");
			sqljob.addParameter(endDate);
		}
		sqljob.appendSQL("  GROUP BY REPAY_DATE");
		sqljob.appendSQL("  ORDER BY REPAY_DATE");
//		System.out.println(sqljob);
		return sqljob;
	}
	public SQLJob insSubtotal(Date startDate,Date endDate) {
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO apra29_rpt");
		sqljob.appendSQL(" ( ");
		sqljob.appendSQL(" ROC_REPAY_DATE,");
		sqljob.appendSQL(" FLIGHT_CAPITAL_AMOUNT, FLIGHT_INTEREST_AMOUNT, LONG_CAPITAL_AMOUNT, LONG_INTEREST_AMOUNT, ");
		sqljob.appendSQL(" SHORT_CAPITAL_AMOUNT, SHORT_INTEREST_AMOUNT, SHORTFUND_CAPITAL_AMOUNT, SHORTFUND_INTEREST_AMOUNT, BOND_CAPITAL_AMOUNT, ");
		sqljob.appendSQL(" BOND_INTEREST_AMOUNT, NATION_CAPITAL_AMOUNT, NATION_INTEREST_AMOUNT, TOTAL_AMOUNT, ");
		sqljob.appendSQL(" USRID, MOD_DATE, REMARK ");
		sqljob.appendSQL(" ) ");
		sqljob.appendSQL(" SELECT '�p   �p',");
		sqljob.appendSQL(" SUM(FLIGHT_CAPITAL_AMOUNT), SUM(FLIGHT_INTEREST_AMOUNT), SUM(LONG_CAPITAL_AMOUNT), SUM(LONG_INTEREST_AMOUNT), ");
		sqljob.appendSQL(" SUM(SHORT_CAPITAL_AMOUNT), SUM(SHORT_INTEREST_AMOUNT), SUM(SHORTFUND_CAPITAL_AMOUNT), SUM(SHORTFUND_INTEREST_AMOUNT), SUM(BOND_CAPITAL_AMOUNT), ");
		sqljob.appendSQL(" SUM(BOND_INTEREST_AMOUNT), SUM(NATION_CAPITAL_AMOUNT), SUM(NATION_INTEREST_AMOUNT), SUM(TOTAL_AMOUNT) ");
		sqljob.appendSQL(",'TAPF'");
		sqljob.appendSQL(",'"+new Timestamp( new Date().getTime() )+"'");
		sqljob.appendSQL(",''");
		sqljob.appendSQL(" FROM APRA29_RPT WHERE 1=1");
		sqljob.appendSQL(" AND REPAY_DATE >= ?");
		sqljob.appendSQL(" AND REPAY_DATE <= ?");
		sqljob.addParameter(startDate);
		sqljob.addParameter(endDate);
//		System.out.println(sqljob);
		return sqljob;
	}
	//���e�R�^
	public SQLJob sqlPayment(Date repayDateS, Date repayDateE){
		SQLJob sqljob = new SQLJob();
		PaymentMainDAO dao = new PaymentMainDAO();
		Session session = dao.getSession();
		
		sqljob.appendSQL("select p.repay_date,p.CAPITAL_AMOUNT,p.interest_amount,i.debt_type, ");
		sqljob.appendSQL("(select debt_code from debt_main where id = d.debt_id) as debt_code ");
		sqljob.appendSQL("from issue_main i, payment_main p, debt_plan_det d ");
		sqljob.appendSQL("where 1=1");
		sqljob.appendSQL("and i.debt_type = 'A' ");
		sqljob.appendSQL("and i.id = p.issue_id ");
		sqljob.appendSQL("and i.id = d.issue_id ");
		sqljob.appendSQL("and p.plan_id = d.id ");
		sqljob.appendSQL("and p.REPAY_DATE <> p.PLAN_REPAY_DATE ");
		sqljob.appendSQL("and p.CAPITAL_AMOUNT > 0 ");
		sqljob.appendSQL("and p.REPAY_DATE >= ?");
		sqljob.appendSQL("and p.repay_DATE <= ?");

		sqljob.addParameter(repayDateS);
		sqljob.addParameter(repayDateE);
//		System.out.println(sqljob.toString());

		return sqljob;
	}
	/**
	 * 102 07 24 �s�W
	 * �p�G��������j��t�Τ�A�h�d�߱��󪺵���������t�Τ���F�p�G��������p��t�Τ�A�h��������
	 * @return
	 */
	public SQLJob paymentSubReportAmount(String[] debtType,String[] debtCode,String[] conds,Date startDate , Date endDate,String path){
		Calendar current_Date = Calendar.getInstance();
		Calendar end_Date = Calendar.getInstance();
		end_Date.setTime(endDate);
		if(current_Date.compareTo(end_Date) < 0)//�t�Τ�p�󵲧�����A���t�Τ�
			endDate = current_Date.getTime();
		
		SQLJob sqljob = new SQLJob();
		
		sqljob.appendSQL("select A.repay_date,C.debt_type,(case when C.debt_type = 'D' then (case when B.debt_code in('24','25','31') then B.debt_code else '0' end) else '0' end) as debt_code, ");
		sqljob.appendSQL("sum(A.CAPITAL_AMOUNT) as CAPITAL_AMOUNT,sum(A.interest_amount) as Interest_amount ");
		sqljob.appendSQL("from payment_main A,debt_main B,issue_main C where A.debt_id = B.id and A.issue_id = C.id");
		sqljob.appendSQL("and A.REPAY_DATE >= ?");
		sqljob.appendSQL("and A.REPAY_DATE <= ?");
		sqljob.appendSQL("and C.due_date >= ?");
		//sqljob.appendSQL("and debt_type + isnull(bond_type,'1') in('A1','B1','B2','C1','C2','D1','D2') ");
		sqljob.appendSQL("and CASE WHEN LEN(debt_type)=0 THEN debt_type +'1' ELSE debt_type + isnull(bond_type,'1') END in('A1','B1','B2','C1','C2','D1','D2')");
		sqljob.appendSQL("group by A.REPAY_DATE,C.debt_type,(case when C.debt_type = 'D' then (case when B.debt_code in('24','25','31') then B.debt_code else '0' end) else '0' end) ");
		sqljob.appendSQL(" order by A.REPAY_DATE,C.debt_type,(case when C.debt_type = 'D' then (case when B.debt_code in('24','25','31') then B.debt_code else '0' end) else '0' end)");
		
		sqljob.addParameter(startDate);
		sqljob.addParameter(endDate);
		sqljob.addParameter(startDate);
		
		return sqljob;
	}
	public List getReport(SQLRunner run,String bondType,Date strDate , Date endDate)throws Exception{
		if(run != null){
			String[] debt_type = {"A","B","C","D"};
			List resultList = new java.util.ArrayList();
			Map paraMap = new HashMap();
			//typeA = �w�v , typeB = ���v
			Date today = new Date();
			boolean isTypeA = false , isTypeB = false;
			paraMap.put("SDATE",strDate);
			paraMap.put("NDATE",today);
			paraMap.put("EDATE",endDate);
			if(strDate.before(today) && endDate.after(today)){
				//�p�G���ѬO�b�d�ߤ������� �hNDATE��J���Ѥ��
				isTypeA = true;
				isTypeB = true;
			}else if(strDate.before(today)){
				//�p�G���Ѥ��b�d�߷�����A�B�b�d�ߤ���_����A�hNDATE��JendDate�A�B���dtypeB
				paraMap.put("NDATE",endDate);
				isTypeA = true;
			}else if(endDate.after(today)){
				//�p�G���Ѥ��b�d�߷�����A�B�b�d�ߤ���ᤧ��A�hNDATE��JstrDate�A�B���dtypeA
				paraMap.put("NDATE",strDate);
				isTypeB = true;
			}
			
			//sqljob_1 = �w�v,sqljob_2 = ���v
			//���Fdebt_type=A ���Ū��źءA�~�n���ҤA�����A��l�Ҥ��z�|bond_type�����e
			//debt_type : A = ���� ,B = ��w�� ,C = ������ ,D = �u��
			SQLJob sqljob_1 = null , sqljob_2 = null;
			for(int i = 0 ; i< debt_type.length ; i ++){
				paraMap.put("debt_type",debt_type[i]);
				if ("A".equals(debt_type[i])) {
					paraMap.put("bondType", bondType);
					if(isTypeA)
					sqljob_1 = getSqljobByDebtTypeA_1(paraMap);
					if(isTypeB)
					sqljob_2 = getSqljobByDebtTypeA_2(paraMap);
				} else if ("B".equals(debt_type[i])) {
					paraMap.put("bondType", "");
					if(isTypeA)
					sqljob_1 = getSqljobByDebtTypeB_1(paraMap);
					if(isTypeB)
					sqljob_2 = getSqljobByDebtTypeB_2(paraMap);
				} else if ("C".equals(debt_type[i])) {
					paraMap.put("bondType", "");
					if(isTypeA)
					sqljob_1 = getSqljobByDebtTypeC_1(paraMap);
					if(isTypeB)
					sqljob_2 = getSqljobByDebtTypeC_2(paraMap);
				} else if ("D".equals(debt_type[i])) {
					paraMap.put("bondType", "");
					if(isTypeA)
					sqljob_1 = getSqljobByDebtTypeD_1(paraMap);
					if(isTypeB)
					sqljob_2 = getSqljobByDebtTypeD_2(paraMap);
				}
				
				if(sqljob_1 != null)
					resultList.addAll((List)run.query(sqljob_1,new MapListHandler()));
				if(sqljob_2 != null)
					resultList.addAll((List)run.query(sqljob_2,new MapListHandler()));
			}
			//�N����নdebt_plan_det
			List endList = new java.util.ArrayList();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			for(Iterator it = resultList.iterator();it.hasNext();){
				Map tempMap = (Map)it.next();
				if(tempMap.get("CapitalAmount") == null)tempMap.put("CapitalAmount","0");
				if(tempMap.get("InterestAmount") == null)tempMap.put("InterestAmount","0");
				DebtPlanDet debtPlanDet = new DebtPlanDet();
				debtPlanDet.setIssueId(Integer.parseInt(String.valueOf(tempMap.get("ISSUE_ID"))));
				debtPlanDet.setCapitalAmount(BigDecimal.valueOf(Double.parseDouble(String.valueOf(tempMap.get("CapitalAmount")))));
				debtPlanDet.setInterestAmount(BigDecimal.valueOf(Double.parseDouble(String.valueOf(tempMap.get("InterestAmount")))));
				String sqlDateStr = String.valueOf(tempMap.get("REPAY_DATE"));
				Date repayDate = sdf.parse(sqlDateStr);
				debtPlanDet.setRepayDate(repayDate);
				endList.add(debtPlanDet);
			}
			return endList;
		}
		return new java.util.ArrayList();
	}
	private SQLJob getSqljobByDebtTypeA_1(Map paraMap){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL(" SELECT D.REPAY_DATE AS REPAY_DATE,SUM(ISNULL(P.capital_amount,0)) as CapitalAmount,SUM(ISNULL(P.Interest_amount,0)) as InterestAmount,P.ISSUE_ID ");
		sqljob.appendSQL(" FROM PAYMENT_MAIN P LEFT JOIN ISSUE_MAIN I ON P.ISSUE_ID=I.ID ");
		sqljob.appendSQL(" LEFT JOIN DEBT_PLAN_DET D ON P.PLAN_ID=D.ID ");
		sqljob.appendSQL(" WHERE 1=1  ");
		sqljob.appendSQL(" AND I.DEBT_TYPE=? ");
		sqljob.addParameter(paraMap.get("debt_type"));
		if(paraMap.get("bondType") != null && !"".equals(paraMap.get("bondType"))){
			sqljob.appendSQL(" AND (I.BOND_TYPE=? OR ?='0') ");
			sqljob.addParameter(paraMap.get("bondType"));
			sqljob.addParameter(paraMap.get("bondType"));
		}
		sqljob.appendSQL(" AND D.REPAY_DATE BETWEEN ? AND ? ");
		sqljob.appendSQL(" AND (P.ISDELETE IS NULL OR P.ISDELETE<>'Y') ");
		sqljob.appendSQL(" GROUP BY D.REPAY_DATE,P.ISSUE_ID ");
		sqljob.appendSQL(" ORDER BY D.REPAY_DATE ");
		sqljob.addParameter(paraMap.get("SDATE"));
		sqljob.addParameter(paraMap.get("NDATE"));
		return sqljob;
	}
	private SQLJob getSqljobByDebtTypeA_2(Map paraMap){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL(" SELECT D.REPAY_DATE AS REPAY_DATE,SUM(ISNULL(D.capital_amount,0)) as CapitalAmount,SUM(ISNULL(D.Interest_amount,0)) as InterestAmount,D.ISSUE_ID ");
		sqljob.appendSQL(" FROM DEBT_PLAN_DET D LEFT JOIN PAYMENT_MAIN P ON D.ID=P.PLAN_ID  ");
		sqljob.appendSQL(" LEFT JOIN ISSUE_MAIN I ON D.ISSUE_ID=I.ID ");
		sqljob.appendSQL(" WHERE 1=1  ");
		sqljob.appendSQL(" AND I.DEBT_TYPE=? ");
		sqljob.addParameter(paraMap.get("debt_type"));
		if(paraMap.get("bondType") != null && !"".equals(paraMap.get("bondType"))){
			sqljob.appendSQL(" AND (I.BOND_TYPE=? OR ?='0') ");
			sqljob.addParameter(paraMap.get("bondType"));
			sqljob.addParameter(paraMap.get("bondType"));
		}
		sqljob.appendSQL(" AND D.DELETE_MARK='N' ");
		sqljob.appendSQL(" AND D.REPAY_DATE BETWEEN ? AND ? ");
		sqljob.appendSQL(" AND (P.ISDELETE IS NULL OR P.ISDELETE<>'Y') ");
		sqljob.appendSQL(" GROUP BY D.REPAY_DATE,D.ISSUE_ID ");
		sqljob.appendSQL(" ORDER BY D.REPAY_DATE ");
		sqljob.addParameter(paraMap.get("NDATE"));
		sqljob.addParameter(paraMap.get("EDATE"));
		return sqljob;
	}
	private SQLJob getSqljobByDebtTypeB_1(Map paraMap){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL(" SELECT P.REPAY_DATE AS REPAY_DATE,SUM(ISNULL(P.capital_amount,0)) as CapitalAmount,SUM(ISNULL(P.Interest_amount,0)) as InterestAmount,P.ISSUE_ID ");
		sqljob.appendSQL(" FROM PAYMENT_MAIN P LEFT JOIN ISSUE_MAIN I ON P.ISSUE_ID=I.ID ");
		sqljob.appendSQL(" WHERE 1=1  ");
		sqljob.appendSQL(" AND I.DEBT_TYPE=? ");
		sqljob.addParameter(paraMap.get("debt_type"));
		if(paraMap.get("bondType") != null && !"".equals(paraMap.get("bondType"))){
			sqljob.appendSQL(" AND (I.BOND_TYPE=? OR ?='0') ");
			sqljob.addParameter(paraMap.get("bondType"));
			sqljob.addParameter(paraMap.get("bondType"));
		}
		sqljob.appendSQL(" AND P.REPAY_DATE BETWEEN ? AND ? ");
		sqljob.appendSQL(" AND (P.ISDELETE IS NULL OR P.ISDELETE<>'Y') ");
		sqljob.appendSQL(" GROUP BY P.ISSUE_ID,P.REPAY_DATE ");
		sqljob.appendSQL(" ORDER BY P.REPAY_DATE ");
		sqljob.addParameter(paraMap.get("SDATE"));
		sqljob.addParameter(paraMap.get("NDATE"));
		return sqljob;
	}
	private SQLJob getSqljobByDebtTypeB_2(Map paraMap){
		SQLJob sqljob = new SQLJob();
		
		sqljob.appendSQL(" SELECT D.REPAY_DATE AS REPAY_DATE, ");
		sqljob.appendSQL(" (ISNULL(sum(distinct D.capital_amount),0) - ISNULL(sum(distinct P.capital_amount),2)) as CapitalAmount, ");
		sqljob.appendSQL(" (ISNULL(sum(distinct I.issue_amount),0) - ISNULL(sum(distinct P.balance_capital_amount),0) - (ISNULL(sum(distinct D.capital_amount),0) - ISNULL(sum(distinct P.capital_amount),0))) as InterestAmount, ");
		sqljob.appendSQL(" D.ISSUE_ID ");
		sqljob.appendSQL(" FROM DEBT_PLAN_DET D "); 
		sqljob.appendSQL(" LEFT JOIN PAYMENT_MAIN P ON D.ID=P.PLAN_ID "); 
		sqljob.appendSQL(" LEFT JOIN ISSUE_MAIN I ON D.ISSUE_ID=I.ID  ");
		sqljob.appendSQL(" WHERE 1=1  ");
		sqljob.appendSQL(" AND D.ISSUE_ID IN (SELECT ID FROM ISSUE_MAIN WHERE DEBT_TYPE=?  "); 
		sqljob.addParameter(paraMap.get("debt_type"));
		if(paraMap.get("bondType") != null && !"".equals(paraMap.get("bondType"))){
			sqljob.appendSQL(" AND (BOND_TYPE=? OR ?='0') ");
			sqljob.addParameter(paraMap.get("bondType"));
			sqljob.addParameter(paraMap.get("bondType"));
		}
		sqljob.appendSQL(" )");
		sqljob.appendSQL(" AND D.DELETE_MARK='N' ");
		sqljob.appendSQL(" AND D.REPAY_DATE BETWEEN ? AND ? ");
		sqljob.appendSQL(" GROUP BY D.REPAY_DATE,D.ISSUE_ID ");
		sqljob.appendSQL(" ORDER BY D.REPAY_DATE ");
		sqljob.addParameter(paraMap.get("NDATE"));
		sqljob.addParameter(paraMap.get("EDATE"));

		return sqljob;
	}
	private SQLJob getSqljobByDebtTypeC_1(Map paraMap){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL(" SELECT P.REPAY_DATE,SUM(ISNULL(P.capital_amount,0)) as CapitalAmount,SUM(ISNULL(P.Interest_amount,0)) as InterestAmount,P.ISSUE_ID");
		sqljob.appendSQL(" FROM PAYMENT_MAIN P LEFT JOIN ISSUE_MAIN I ON P.ISSUE_ID=I.ID ");
		sqljob.appendSQL(" WHERE 1=1  ");
		sqljob.appendSQL(" AND I.DEBT_TYPE=? ");
		sqljob.addParameter(paraMap.get("debt_type"));
		if(paraMap.get("bondType") != null && !"".equals(paraMap.get("bondType"))){
			sqljob.appendSQL(" AND (I.BOND_TYPE=? OR ?='0') ");
			sqljob.addParameter(paraMap.get("bondType"));
			sqljob.addParameter(paraMap.get("bondType"));
		}
		sqljob.appendSQL(" AND P.REPAY_DATE BETWEEN ? AND ? ");
		sqljob.appendSQL(" AND (P.ISDELETE IS NULL OR P.ISDELETE<>'Y') ");
		sqljob.appendSQL(" GROUP BY P.ISSUE_ID,P.REPAY_DATE ");
		sqljob.appendSQL(" ORDER BY P.REPAY_DATE ");
		sqljob.addParameter(paraMap.get("SDATE"));
		sqljob.addParameter(paraMap.get("NDATE"));
		return sqljob;
	}
	private SQLJob getSqljobByDebtTypeC_2(Map paraMap){
		SQLJob sqljob = new SQLJob();		
		
		sqljob.appendSQL(" SELECT D.REPAY_DATE AS REPAY_DATE, ");
		sqljob.appendSQL(" CASE WHEN P.REPAY_DATE<=? THEN 0 ");
		sqljob.addParameter(paraMap.get("NDATE"));
		sqljob.appendSQL(" ELSE ");
		sqljob.appendSQL(" SUM(ISNULL(D.capital_amount,0)) END AS CapitalAmount, ");
		sqljob.appendSQL(" CASE WHEN P.REPAY_DATE<=? THEN 0 ");
		sqljob.addParameter(paraMap.get("NDATE"));
		sqljob.appendSQL(" ELSE ");
		sqljob.appendSQL(" SUM(ISNULL(D.Interest_amount,0)) END AS InterestAmount, ");
		sqljob.appendSQL(" D.ISSUE_ID ");
		sqljob.appendSQL(" FROM DEBT_PLAN_DET D LEFT JOIN PAYMENT_MAIN P ON D.ID=P.PLAN_ID ");
		sqljob.appendSQL(" WHERE 1=1 ");
		sqljob.appendSQL(" AND D.ISSUE_ID IN (SELECT ID FROM ISSUE_MAIN WHERE DEBT_TYPE=? ");
		sqljob.addParameter(paraMap.get("debt_type"));
		if(paraMap.get("bondType") != null && !"".equals(paraMap.get("bondType"))){
			sqljob.appendSQL(" AND (BOND_TYPE=? OR ?='0') ");
			sqljob.addParameter(paraMap.get("bondType"));
			sqljob.addParameter(paraMap.get("bondType"));
		}
		sqljob.appendSQL(" ) ");
		sqljob.appendSQL(" AND D.DELETE_MARK='N' ");
		sqljob.appendSQL(" AND D.REPAY_DATE BETWEEN ? AND ? ");
		sqljob.appendSQL(" GROUP BY D.REPAY_DATE,P.REPAY_DATE,D.ISSUE_ID ");
		sqljob.appendSQL(" ORDER BY D.REPAY_DATE ");
		sqljob.addParameter(paraMap.get("NDATE"));
		sqljob.addParameter(paraMap.get("EDATE"));
		return sqljob;
	}
	private SQLJob getSqljobByDebtTypeD_1(Map paraMap){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL(" SELECT P.ISSUE_ID,I.DEBT_CODE,P.REPAY_DATE AS REPAY_DATE,SUM(ISNULL(P.capital_amount,0)) as CapitalAmount,SUM(ISNULL(P.Interest_amount,0)) as InterestAmount ");
		sqljob.appendSQL(" FROM PAYMENT_MAIN P LEFT JOIN ISSUE_MAIN I ON P.ISSUE_ID=I.ID ");
		sqljob.appendSQL(" WHERE 1=1  ");
		sqljob.appendSQL(" AND I.DEBT_TYPE=? ");
		sqljob.addParameter(paraMap.get("debt_type"));
		if(paraMap.get("bondType") != null && !"".equals(paraMap.get("bondType"))){
			sqljob.appendSQL(" AND (I.BOND_TYPE=? OR ?='0') ");
			sqljob.addParameter(paraMap.get("bondType"));
			sqljob.addParameter(paraMap.get("bondType"));
		}
		sqljob.appendSQL(" AND P.REPAY_DATE BETWEEN ? AND ? ");
		sqljob.appendSQL(" AND (P.ISDELETE IS NULL OR P.ISDELETE<>'Y') ");
		sqljob.appendSQL(" GROUP BY P.ISSUE_ID,I.DEBT_CODE,P.REPAY_DATE ");
		sqljob.appendSQL(" ORDER BY P.REPAY_DATE ");
		sqljob.addParameter(paraMap.get("SDATE"));
		sqljob.addParameter(paraMap.get("NDATE"));
		return sqljob;
	}
	private SQLJob getSqljobByDebtTypeD_2(Map paraMap){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL(" SELECT I.DEBT_CODE,D.REPAY_DATE AS REPAY_DATE,SUM(ISNULL(D.capital_amount,0)) as CapitalAmount,SUM(ISNULL(D.Interest_amount,0)) as InterestAmount,D.ISSUE_ID ");
		sqljob.appendSQL(" FROM DEBT_PLAN_DET D LEFT JOIN ISSUE_MAIN I ON D.ISSUE_ID=I.ID ");
		sqljob.appendSQL(" WHERE 1=1  ");
		sqljob.appendSQL(" AND I.DEBT_TYPE=? ");
		sqljob.addParameter(paraMap.get("debt_type"));
		if(paraMap.get("bondType") != null && !"".equals(paraMap.get("bondType"))){
			sqljob.appendSQL(" AND (I.BOND_TYPE=? OR ?='0') ");
			sqljob.addParameter(paraMap.get("bondType"));
			sqljob.addParameter(paraMap.get("bondType"));
		}
		sqljob.appendSQL(" AND D.DELETE_MARK='N' ");
		sqljob.appendSQL(" AND D.REPAY_DATE BETWEEN ? AND ? ");
		sqljob.appendSQL(" GROUP BY D.ISSUE_ID,I.DEBT_CODE,D.REPAY_DATE ");
		sqljob.appendSQL(" ORDER BY D.REPAY_DATE ");
		sqljob.addParameter(paraMap.get("NDATE"));
		sqljob.addParameter(paraMap.get("EDATE"));
		return sqljob;
	}
}