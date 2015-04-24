package tw.gov.nta.conversion;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

import tw.gov.nta.debt.common.PayManager;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.DebtPlanDet;
import tw.gov.nta.sql.debt.IssueExchangeTicketDet;
import tw.gov.nta.sql.debt.PaymentMain;
import tw.gov.nta.sql.debt.PaymentTicketDet;
import tw.gov.nta.sql.debt.dao.IssueExchangeTicketDetDAO;
import tw.gov.nta.sql.debt.dao.PaymentMainDAO;
import tw.gov.nta.sql.debt.dao.PaymentTicketDetDAO;

public class ConvertTPSBF7 extends ConvertBase {
	private Integer yearNo = null;
	private Integer monthNo = null;
	private IssueExchangeTicketDetDAO dao = new IssueExchangeTicketDetDAO();
	private Session session = dao.createNewSession();
	private Connection connection = session.connection();
	
	@Override
	public void initialize(String year,String month,boolean resetFlag){
		resetFlag=true;
		super.initialize(year,month,resetFlag);
		this.yearNo = Integer.valueOf(year) + 1911;
		this.monthNo = Integer.valueOf(month);
	}

	@Override
	protected boolean checkExists() {
		PaymentMainDAO dao = new PaymentMainDAO();
		Session sessionPaymentMain= dao.getSession();
		
		Query query = sessionPaymentMain.createSQLQuery("select 1 from payment_main p,payment_ticket_det t where p.id = t.payment_id " +
				"and Year(p.repay_date) = "+yearNo.toString()+" and Month(p.repay_date) = "+monthNo.toString());
		
		if(query.list().size() > 0){
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		//設定分割規則
		String splitInfo = "YYMM:9:5,BANK:9:7,BONDID:X:6,PFLAG:X:1,PTIMES:X:2,"
				+ "PVAL:X:1,SIGN:X:1,NO:9:5,AMT:S9:13,NOL:9:5,"
				+ "AML:S9:13,NOT:9:5,AMTT:S9:13";
		setSplitInfo(splitInfo);
		
		//抓取資料檔案名稱
		setFileName("TPSBF7");
	}

	@Override
	public String getFullFilePath() {
		// TODO Auto-generated method stub

		return filePath + fileName + "\\" + yearNo.toString() + "\\" + monthNo.toString() + "\\" +fileName + "." + fileType;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see tw.gov.nta.conversion.ConvertBase#transIntoTable(java.util.Map)
	 */
	@Override
	public void transIntoTable(Map<String, Object> sourceData) {
		// TODO Auto-generated method stub
		
		//發行序號
		String bondid = (String) sourceData.get("BONDID");
		
		//轉檔年月
		String yymm = ((BigDecimal) sourceData.get("YYMM")).toString();
		
        //轉檔年月的最後一天		
		Date repayDate = getRepayDate(yymm);

		//還本或付息
		String payType = (String) sourceData.get("PFLAG");
		
		//第幾次還本付息
		String payPeriod = (String) sourceData.get("PTIMES");
		
		//還本付息金額
		BigDecimal payAmount = (BigDecimal) sourceData.get("AMT");

		//判斷是還本還是付息
		Integer capitalSerial = new Integer(0);
		Integer interestSerial = new Integer(0);
		Double capitalAmount = 0D;
		Double integerAmount = 0D;
		
		if ("I".equals(payType)) {
			interestSerial = Integer.valueOf(payPeriod);
			integerAmount = payAmount.doubleValue();
		}else {
			capitalSerial = Integer.valueOf(payPeriod);
			capitalAmount = payAmount.doubleValue();
		}		
		
		PaymentMainDAO dao = new PaymentMainDAO();
		
		try {
			
			//發行id
			Integer issueId = ConvertFunction.transToIssueId(bondid,session);	
			//因為會有不同面額但同一次還本或付息期次，但PaymentMain只要入同一筆
			//所以先取得已經入的，再加進去
			String queryPaymentString = "from PaymentMain p where p.repayDate = :repayDate and p.issueId = :issueId " +
					"and p.capitalSerial = :capitalSerial and p.interestSerial = :interestSerial and p.repayType = '1'";
			Query query = null;
			Session sessionPaymentMain = new PaymentMainDAO().getSession();
			query = sessionPaymentMain.createQuery(queryPaymentString);
			query.setInteger("issueId", issueId);
			query.setInteger("interestSerial", interestSerial);
			query.setInteger("capitalSerial",capitalSerial);
			query.setDate("repayDate",repayDate);

			List<PaymentMain> paymentList = query.list();
			
			PaymentMain payment = null;
			
			//如果有相同還本付息期次且面額相同的就入在原來那一筆，不然就新增一筆 Payment
			if(paymentList.size()>0) {
				payment = paymentList.get(0);
				if (interestSerial!=0){
					payment.setInterestAmount(payment.getInterestAmount().add(new BigDecimal(integerAmount)));
				}				
				if (capitalSerial!=0){
					payment.setCapitalAmount(payment.getCapitalAmount().add(new BigDecimal(capitalAmount)));
				}
				payment.setUserid("EXCEL");
				sessionPaymentMain.save(payment);
			}else {
				//利用PaymentManager來產生PaymentMain 以免漏掉參數
				
				//因為PaymentManager要plan才能產生，所以先取得plan
				String queryPlanString = "from DebtPlanDet plan where plan.debt.issue.id = :issueId and " +
						"plan.interestSerial = :interestSerial and plan.capitalSerial = :capitalSerial";
				query = sessionPaymentMain.createQuery(queryPlanString);
				
				query.setInteger("issueId", issueId);
				query.setInteger("interestSerial", interestSerial);
				query.setInteger("capitalSerial",capitalSerial);
				DebtPlanDet plan = (DebtPlanDet)query.list().get(0);
				
				//利用PaymentManager來產生PaymentMain
				payment = new PayManager().repayDebt(plan.getId(), capitalSerial, interestSerial, capitalAmount,integerAmount
						, repayDate,sessionPaymentMain);
				payment.setUserid("EXCEL");
				sessionPaymentMain.save(payment);
			}
			Integer paymentId = payment.getId();
			BigDecimal ticketAmount = new BigDecimal(ConvertFunction.getIssVal((String)sourceData.get("PVAL")));
			String queryPaymentString2 = "from PaymentTicketDet p where p.payment.id = :paymentId and p.ticketAmount = :ticketAmount";
			/*
			Query query2 = null;
			Session sessionPaymentTicketDet = new PaymentTicketDetDAO().getSession();
			query2 = sessionPaymentTicketDet.createQuery(queryPaymentString2);
			query2.setInteger("paymentId", paymentId);
			query2.setBigDecimal("ticketAmount", ticketAmount);
			
			List<PaymentTicketDet> paymentTicketDetList = query2.list();
			//產生PaymentTicetDet
			PaymentTicketDet paymentDet = null;
			//如果有相同PaymentTicetDet就入在原來那一筆，不然就新增一筆 PaymentTicetDet
			if(paymentTicketDetList.size()>0) {
				paymentDet = paymentTicketDetList.get(0);
			}else{
				//產生PaymentTicetDet
				paymentDet = new PaymentTicketDet();
				paymentDet.setModDate(new Date());
			}
			BigDecimal amt=(BigDecimal)sourceData.get("AMT");
			Long ticketCount = ((BigDecimal)sourceData.get("NO")).longValue();
			BigDecimal ticketName = new BigDecimal(ConvertFunction.getIssVal((String)sourceData.get("PVAL"),"1"));
			String ticketName2 = ConvertFunction.getIssVal((String)sourceData.get("PVAL"),"2");
			paymentDet.setPayment(payment);
			
			paymentDet.setTicketAmount(ticketName);
			
			if(paymentTicketDetList.size()>0) {
				paymentDet.setTicketCount(new BigDecimal(paymentDet.getTicketCount()).add(new BigDecimal(ticketCount)).longValue());
				paymentDet.setAccumCount(new BigDecimal(paymentDet.getAccumCount()).add(new BigDecimal(ticketCount)).longValue());
			}else{
				paymentDet.setTicketCount(ticketCount);
				paymentDet.setAccumCount(getMaxAccumCount(paymentDet) + paymentDet.getTicketCount());
			}
			if (payment.getCapitalSerial().trim().equals("0")){
				paymentDet.setInterestAmount(payment.getInterestAmount());
				paymentDet.setCapitalAmount(new BigDecimal(0));
			}else{
				paymentDet.setInterestAmount(new BigDecimal(0));
				//paymentDet.setCapitalAmount(payment.getCapitalAmount());
			}
			paymentDet.setTicketName(ticketName2);
			paymentDet.setUserid("EXCEL");
			new PaymentTicketDetDAO().saveOrUpdate(paymentDet,sessionPaymentTicketDet);
			sessionPaymentTicketDet.flush();
			sessionPaymentTicketDet.close();
			
			updatePaymentTicketDet(paymentDet,yymm,interestSerial);
			*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void updatePaymentTicketDet(PaymentTicketDet paymentTicketDet,String upYymm,Integer interestSerialNo) {
		// TODO Auto-generated method stub
		try{
			Session sessionPaymentTicketDet = new PaymentTicketDetDAO().getSession();
			SQLRunner run = new ConnectionSQLRunner(connection);
			SQLJob sqlJob = new SQLJob();
			String paymentId = paymentTicketDet.getPayment().getId().toString().trim();
			String interestAmount = paymentTicketDet.getInterestAmount().toString().trim();
			//String capitalAmount = paymentTicketDet.getCapitalAmount().toString().trim();
			sqlJob.appendSQL("update payment_ticket_det set interest_amount ="+interestAmount+"  WHERE payment_id ="+paymentId);
			run.update(sqlJob);
			
			SQLJob sqlJob2 = new SQLJob();
			String planId = paymentTicketDet.getPayment().getPlan().getId().toString().trim();
			String capitalSerial = paymentTicketDet.getPayment().getCapitalSerial().toString().trim();
			String interestSerial = interestSerialNo.toString().trim();
			String ticketAmount = paymentTicketDet.getTicketAmount().toString().trim();
			if (interestSerialNo==0 | interestSerialNo.equals(null)){
				sqlJob2.appendSQL("update payment_ticket_det set capital_amount=(select sum(d.ticket_amount*d.ticket_count) from payment_ticket_det d where d.payment_id = payment_ticket_det.payment_id) WHERE payment_id ="+paymentId);
				run.update(sqlJob2);
				run.update(sqlJob2);
			}

			String ticketId=paymentTicketDet.getId().toString().trim();
			String yymm = "";
			if(upYymm.length()<5)
				yymm = '0'+upYymm ;
			else
				yymm = upYymm ;
			Date repayDate = getRepayDate(yymm);
			String upRepayDate = new String().valueOf(Integer.parseInt(yymm.substring(0,3))+1911)+yymm.substring(3)+new String().valueOf(repayDate.getDate());
			
			/*			 
			SQLJob sqlJob4 = new SQLJob();
			sqlJob4.appendSQL("update payment_main set capital_amount=(select max(capital_amount  ) from payment_ticket_det where payment_id ="+paymentId+") WHERE id ="+paymentId);
			run.update(sqlJob4);
			
			SQLJob sqlJob5 = new SQLJob();
			sqlJob5.appendSQL("update payment_main set interest_amount=(select max(interest_amount) from payment_ticket_det where payment_id ="+paymentId+") WHERE id ="+paymentId);
			run.update(sqlJob5);
			*/
			
			SQLJob sqlJob3 = new SQLJob();
			if (interestSerialNo==0 | interestSerialNo.equals(null)){
				sqlJob3.appendSQL("update payment_ticket_det set accum_amount=(select sum(capital_amount) from payment_main where plan_id = "+planId+" and convert(varchar,repay_Date,112)<='"+upRepayDate+"' and (select count(payment_id) from payment_ticket_det where payment_id = payment_main.id) >0)  WHERE payment_id ="+paymentId);
			}else{
				sqlJob3.appendSQL("update payment_ticket_det set accum_amount=(select sum(interest_amount) from payment_main where plan_id = "+planId+" and (select count(payment_id) from payment_ticket_det where payment_id = payment_main.id) >0 and convert(varchar,repay_Date,112)<='"+upRepayDate+"') WHERE payment_id ="+paymentId);
			}
			run.update(sqlJob3);
			
			sessionPaymentTicketDet.flush();
			sessionPaymentTicketDet.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	private Long getMaxAccumCount(PaymentTicketDet paymentDet) {
		// TODO Auto-generated method stub
		PaymentTicketDetDAO dao = new PaymentTicketDetDAO();
		Session session = dao.getSession();
		Query query = session.createQuery("select max(p.accumCount) from PaymentTicketDet p where " +
				" p.ticketAmount = "+paymentDet.getTicketAmount()+
				" and p.payment.repayDate <= ? and p.payment.issueId = "+paymentDet.getPayment().getIssueId()+
				" and p.payment.capitalSerial = "+paymentDet.getPayment().getCapitalSerial()+" and p.payment.interestSerial = "+paymentDet.getPayment().getInterestSerial());
		
		query.setDate(0,paymentDet.getPayment().getRepayDate());
		Long accumCount = new Long(0);
		Object result = query.uniqueResult();
		if(result != null){
			accumCount = (Long)result;
		}

		return accumCount;
	}

	@Override
	public void deleteTable(Map<String, Object> sourceData) {
		// TODO Auto-generated method stub
		try{
			SQLRunner run = new ConnectionSQLRunner(connection);
			SQLJob sqlJob = new SQLJob();

			String yymm = '0'+(sourceData.get("YYMM").toString());
			Date repayDate = getRepayDate(yymm);
			String delDate = new String().valueOf(Integer.parseInt(yymm.substring(0,3))+1911)+yymm.substring(3)+new String().valueOf(repayDate.getDate());
			String delym = delDate.substring(0,6);
			sqlJob.appendSQL("DELETE FROM payment_ticket_det WHERE payment_id in (select id from payment_main where convert(varchar,repay_date,112) >= '" + delym+ "01' and convert(varchar,repay_date,112) <= '" + delDate + "' and userid = 'Excel' and issue_id in (select id from issue_main where debt_type = 'A'))");
			run.update(sqlJob);

			SQLJob sqlJob2 = new SQLJob();
			sqlJob2.appendSQL("DELETE FROM payment_main WHERE convert(varchar,repay_date,112) >= '" + delym + "01' and convert(varchar,repay_date,112) <= '" + delDate + "' and issue_id in (select id from issue_main where debt_type = 'A') and userid = 'Excel'");
			run.update(sqlJob2);
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		
	}

}
