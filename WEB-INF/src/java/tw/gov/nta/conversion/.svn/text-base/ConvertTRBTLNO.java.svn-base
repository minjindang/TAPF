package tw.gov.nta.conversion;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.DebtPlanDet;
import tw.gov.nta.sql.debt.IssueExchangeTicketDet;
import tw.gov.nta.sql.debt.IssueExchangeTicketMain;
import tw.gov.nta.sql.debt.dao.IssueExchangeTicketDetDAO;
import tw.gov.nta.sql.debt.dao.IssueExchangeTicketMainDAO;
import tw.gov.nta.sql.debt.dao.IssueMainDAO;

public class ConvertTRBTLNO extends ConvertBase {
	private IssueExchangeTicketDetDAO dao = new IssueExchangeTicketDetDAO();
	private Session session = dao.createNewSession();
	private Connection connection = session.connection();
	private Integer yearNo = null;
	private Integer monthNo = null;
	private DateFormat df = new SimpleDateFormat("yyyy/mm/dd");
	
	@Override
	public void initialize(String year,String month,boolean resetFlag){
		resetFlag=true;
		this.yearNo = Integer.valueOf(year) + 1911;
		this.monthNo = Integer.valueOf(month);
		super.initialize(year,month,resetFlag);
	}
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		String splitInfo = "BONDID:X:6,IPDSTR:X:2,ACTNO:9:6,BDTNO100TM:9:5,BDTNO500TM:9:5," +
				"BDTNO1M:9:5,BDTNO5M:9:5,YBDTNO100TM:9:5,YBDTNO500TM:9:5,YBDTNO1M:9:5," +
				"YBDTNO5M:9:5,MBDTNO100TM:9:5,MBDTNO500TM:9:5,MBDTNO1M:9:5,MBDTNO5M:9:5," +
				"YYMM:X:5,IPDEND:9:2,FILLER:X:23";
		setSplitInfo(splitInfo);
		setFileName("TRBTLNO");
	}	
	
	@Override
	public String getFullFilePath() {
		// TODO Auto-generated method stub
		return filePath + fileName +  "\\" + this.yearNo.toString() + "\\" + this.monthNo.toString() + "\\" +fileName + "." + fileType;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void transIntoTable(Map<String, Object> sourceData) {
		// TODO Auto-generated method stub
		//發行序號
		String bondid = (String) sourceData.get("BONDID");
		
		//轉檔年月
		String yymm = (String) sourceData.get("YYMM");
		
        //轉檔年月的最後一天		
		Date repayDate = getRepayDate(yymm);
		
		//從那個付息期次開始
		int interestSerial = Integer.valueOf((String) sourceData.get("IPDSTR"));
		
		String[] tickets = {"100TM:100000:十萬","500TM:500000:五十萬","1M:1000000:一百萬","5M:5000000:五百萬"};

		try {
			
			IssueExchangeTicketMainDAO dao = new IssueExchangeTicketMainDAO();
			
			Session session = dao.createNewSession();
			Integer issueId = ConvertFunction.transToIssueId(bondid,session);
			
			//取得借款
			String queryString = "from DebtMain debt where debt.issue.id = ? ";
			Query query = session.createQuery(queryString);
			query.setInteger(0, issueId);
			
			DebtMain debt = (DebtMain)query.uniqueResult();
			//將處理好的exchangeDet放入Array裡，等會要塞入統計值
			List tempExchangeDetList = new ArrayList();
			
			BigDecimal totalExchangeAmount = new BigDecimal(0);
			String ticketCode = "";
			String ticketName = "";
			BigDecimal ticketPrice = new BigDecimal(0);
			BigDecimal afterTicketCount = new BigDecimal(0);
			BigDecimal beforeTicketCount = new BigDecimal(0);
			BigDecimal ticketCount = new BigDecimal(0);
			BigDecimal ticketAmount = new BigDecimal(0);
			BigDecimal exchangeRate = new BigDecimal(0);
			BigDecimal sumExchangeRate = new BigDecimal(0);
			//計算同面額的資料
			for(int i=0;i<tickets.length;i++){
				IssueExchangeTicketDet tempDet = new IssueExchangeTicketDet();
				//面額對應代碼
				ticketCode = tickets[i].split(":")[0];
				//面額中文名
				ticketName = tickets[i].split(":")[2];
				//面額代表金額
				ticketPrice = new BigDecimal(tickets[i].split(":")[1]);
				//轉換後張數
				afterTicketCount = (BigDecimal)sourceData.get("BDTNO"+ticketCode);
				//轉換前張數
				beforeTicketCount = (BigDecimal)sourceData.get("MBDTNO"+ticketCode);
				//轉換張數
				ticketCount = afterTicketCount.subtract(beforeTicketCount);
				//轉換金額
				ticketAmount = ticketCount.multiply(ticketPrice);
				
				tempDet.setTicketCount(ticketCount.longValue());
				tempDet.setExchangeDate(repayDate);
				tempDet.setTicketAmount(ticketPrice);
				tempDet.setTicketName(ticketName);
				//加總本次金額
				totalExchangeAmount = totalExchangeAmount.add(ticketAmount);
				tempExchangeDetList.add(tempDet);

			}
			exchangeRate = totalExchangeAmount.divide(debt.getIssueAmount(),10,BigDecimal.ROUND_HALF_UP);
		
			//因為銀行代號不同會重覆，所以要取得已經入的，再累加上去
			List<IssueExchangeTicketDet> existsDetList = getExistsDet(session,debt.getId());
			List<IssueExchangeTicketMain> existsMainList = getExistsMain(session,debt.getId());

			
			//取得付息期次之後對應的計畫列表
			String queryPlanString = "from DebtPlanDet plan where plan.debt.issue.id = :issueId and (plan.capitalSerial <> 0 or plan.interestSerial >= :interestSerial)";
			query = session.createQuery(queryPlanString);
			query.setInteger("issueId", issueId);
			query.setInteger("interestSerial",interestSerial);
			List planList = query.list();

			for(Iterator iterator = planList.iterator();iterator.hasNext();){
				DebtPlanDet plan = (DebtPlanDet)iterator.next();
				IssueExchangeTicketMain exchangeMain = null;
				//有重覆的要加進去
				for(Iterator<IssueExchangeTicketMain> existMainIterator = existsMainList.iterator();existMainIterator.hasNext();){
					IssueExchangeTicketMain buffer = existMainIterator.next();
					if(df.format(buffer.getExchangeDate()).equals(df.format(repayDate))&&
					   buffer.getInterestSerial().equals(plan.getInterestSerial())&&
					   buffer.getCapitalSerial().equals(plan.getCapitalSerial())){
						exchangeMain = buffer;
						break;
					}
				}
				
				if(exchangeMain == null){
					exchangeMain = new IssueExchangeTicketMain();
					exchangeMain.setInterestSerial(plan.getInterestSerial());
					exchangeMain.setCapitalSerial(plan.getCapitalSerial());
					exchangeMain.setDebt(plan.getDebt());
					exchangeMain.setExchangeDate(repayDate);
					exchangeMain.setCapitalAmount(new BigDecimal(0));
					exchangeMain.setInterestAmount(new BigDecimal(0));
				}
				BigDecimal exchangeCapitalAmount = exchangeMain.getCapitalAmount().add(totalExchangeAmount);
//				if (issueId == 3730){
//					System.out.println("還本次數 = "+exchangeMain.getCapitalSerial());
//					System.out.println("付息次數 = "+exchangeMain.getInterestSerial());
//					System.out.println("轉換面額 = "+ticketPrice);
//					System.out.println("本次金額 = "+ticketAmount);
//					System.out.println("加總金額：totalExchangeAmount = "+totalExchangeAmount);
//					System.out.println("==============");
//				}
				BigDecimal exchangeInterestAmount = plan.getInterestAmount().multiply(
													exchangeCapitalAmount.divide(debt.getIssueAmount(),10,BigDecimal.ROUND_HALF_UP)
																)
												.setScale(0,BigDecimal.ROUND_HALF_UP);
				//exchangeInterestAmount=getMainAmount(exchangeMain.getDebt().getId().toString(),exchangeMain.getCapitalSerial().toString(),exchangeMain.getInterestSerial().toString(),exchangeInterestAmount);
				
				BigDecimal accumExchangeCapitalAmount = getMaxAccumExchangeAmount(exchangeMain);
				BigDecimal accumExchangeInterestAmount = getMaxAccumExchangeAmount(exchangeMain);
				//BigDecimal accumExchangeCapitalAmount = plan.getTransferCapitalAmount().add(exchangeCapitalAmount);
				//BigDecimal accumExchangeInterestAmount = plan.getTransferInterestAmount().add(exchangeInterestAmount);
				
				if (plan.getInterestSerial()==0){
					//本金
					exchangeMain.setCapitalAmount(exchangeCapitalAmount);
					exchangeMain.setInterestAmount(new BigDecimal(0));
					plan.setTransferCapitalAmount(accumExchangeCapitalAmount);
//					if (issueId == 3730 && plan.getInterestSerial()==0 ){
//						System.out.println("accumExchangeCapitalAmount = "+accumExchangeCapitalAmount);
//						System.out.println("加總金額：ticketAmount = "+totalExchangeAmount);
//					}
					//exchangeMain.setAccumCapitalAmount(accumExchangeCapitalAmount.add(exchangeCapitalAmount));
					exchangeMain.setAccumCapitalAmount(accumExchangeCapitalAmount.add(totalExchangeAmount));
					
//					if (issueId == 3720 && plan.getInterestSerial()==0 ){
//						System.out.println("getAccumCapitalAmount = "+exchangeMain.getAccumCapitalAmount());
//						System.out.println("累加金額：exchangeCapitalAmount = "+exchangeCapitalAmount);
//					}

					exchangeMain.setAccumInterestAmount(new BigDecimal(0));
				}else{
					//利息
					exchangeMain.setCapitalAmount(new BigDecimal(0));
					exchangeMain.setInterestAmount(exchangeMain.getInterestAmount().add(exchangeInterestAmount));
					plan.setTransferInterestAmount(accumExchangeInterestAmount);
					exchangeMain.setAccumCapitalAmount(new BigDecimal(0));
					accumExchangeInterestAmount=accumExchangeInterestAmount.add(exchangeInterestAmount);
					exchangeMain.setAccumInterestAmount(accumExchangeInterestAmount);
				}
				int k=0;
				for(Iterator iteratorDet = tempExchangeDetList.iterator();iteratorDet.hasNext();){
					IssueExchangeTicketDet tempExchangeDet = (IssueExchangeTicketDet)iteratorDet.next();
					IssueExchangeTicketDet exchangeDet = null;

					k++;
					//有重覆的要加進去
					for(Iterator<IssueExchangeTicketDet> existDetIterator = existsDetList.iterator();existDetIterator.hasNext();){
						IssueExchangeTicketDet buffer = existDetIterator.next();
						
						if(df.format(buffer.getExchangeDate()).equals(df.format(repayDate))&&
						   buffer.getInterestSerial().equals(plan.getInterestSerial())&&
						   buffer.getCapitalSerial().equals(plan.getCapitalSerial())&&
						   buffer.getTicketAmount().longValue() ==  tempExchangeDet.getTicketAmount().longValue()){
							exchangeDet = buffer;
							break;
						}
					}
					
					if(exchangeDet == null){
						exchangeDet = new IssueExchangeTicketDet();
						exchangeDet.setTicketCount(0L);
						exchangeDet.setTotalAmount(new BigDecimal(0));
					}	
					
					copyProperties(exchangeDet,tempExchangeDet);
					exchangeDet.setCapitalSerial(plan.getCapitalSerial());
					exchangeDet.setInterestSerial(plan.getInterestSerial());
					exchangeDet.setDebtId(plan.getDebt().getId());
					if (!exchangeDet.getCapitalSerial().equals(0)){
						exchangeDet.setTotalAmount(exchangeMain.getCapitalAmount());
					}else{
						exchangeDet.setTotalAmount(exchangeMain.getInterestAmount());
//						exchangeDet.setTotalAmount(exchangeDet.getTicketCount()>0?getMaxTotalAmount(exchangeMain,plan.getInterestAmount().toString(),debt.getIssueAmount().toString(),exchangeDet.getTicketCount().toString(),exchangeDet.getTicketAmount().toString()):exchangeMain.getInterestAmount());
//						exchangeDet.setTotalAmount(getMaxTotalAmount(exchangeMain,plan.getInterestAmount().toString(),debt.getIssueAmount().toString(),exchangeDet.getTicketCount().toString(),exchangeDet.getTicketAmount().toString()));
					}
					exchangeDet.setAccumAmount(exchangeDet.getCapitalSerial().equals(0)?exchangeMain.getAccumInterestAmount():exchangeMain.getAccumCapitalAmount());
//					exchangeDet.setAccumCount(getMaxAccumCount(exchangeDet) + exchangeDet.getTicketCount());
					exchangeDet.setAccumCount(getMaxAccumCount(exchangeDet) + tempExchangeDet.getTicketCount());

					session.saveOrUpdate(exchangeDet);
					
				}
				
				session.saveOrUpdate(exchangeMain);
				
				accumExchangeInterestAmount = getMaxAccumExchangeAmount(exchangeMain);
				plan.setTransferInterestAmount(accumExchangeInterestAmount);
				session.update(plan);
				
			}
			
			session.flush();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	private void copyProperties(IssueExchangeTicketDet exchangeDet, IssueExchangeTicketDet tempExchangeDet) throws IllegalAccessException, InvocationTargetException {
		// TODO Auto-generated method stub
		exchangeDet.setTicketCount(exchangeDet.getTicketCount() + tempExchangeDet.getTicketCount());
		exchangeDet.setExchangeDate(tempExchangeDet.getExchangeDate());
		exchangeDet.setTicketAmount(tempExchangeDet.getTicketAmount());
		exchangeDet.setTicketName(tempExchangeDet.getTicketName());
	}
	
	private BigDecimal getMaxAccumExchangeAmount(IssueExchangeTicketMain exchangeMain) {
		// TODO Auto-generated method stub
		IssueExchangeTicketDetDAO dao = new IssueExchangeTicketDetDAO();
		Session session = dao.getSession();

		Query query = session.createQuery("select max(p.accumAmount) from IssueExchangeTicketDet p where " +
				"p.debtId = "+exchangeMain.getDebt().getId()+" and p.capitalSerial = "+exchangeMain.getCapitalSerial()+
				" and p.interestSerial = "+exchangeMain.getInterestSerial()+
				" and p.exchangeDate <= ?");
		
		query.setDate(0,exchangeMain.getExchangeDate());
		BigDecimal accumAmount = new BigDecimal(0);
		Object result = query.uniqueResult();
		if(result != null){
			accumAmount = (BigDecimal)result;
		}

		return accumAmount;
	}
	public BigDecimal getMaxTotalAmount(IssueExchangeTicketMain exchangeMain,String planInterestAmount,String debtIssueAmount,String debtTicketCount,String debtTicketAmount) {
		// TODO Auto-generated method stub
		IssueExchangeTicketDetDAO dao = new IssueExchangeTicketDetDAO();
		Session session = dao.getSession();

		Query query = session.createQuery("select sum("+planInterestAmount+"*(p.ticketAmount*p.ticketCount)/"+debtIssueAmount+") from IssueExchangeTicketDet p where " +
				"p.debtId = "+exchangeMain.getDebt().getId()+" and p.capitalSerial = "+exchangeMain.getCapitalSerial()+
				" and p.interestSerial = "+exchangeMain.getInterestSerial()+
				" and p.exchangeDate = ?");
		
		query.setDate(0,exchangeMain.getExchangeDate());
		BigDecimal totalAmount = new BigDecimal(0);
		BigDecimal ticketTotal = new BigDecimal(planInterestAmount).multiply(new BigDecimal(debtTicketCount)).multiply(new BigDecimal(debtTicketAmount)).divide(new BigDecimal(debtIssueAmount));
		Object result = query.uniqueResult();
		if(result != null){
			totalAmount = new BigDecimal(result.toString());
		}else if (Integer.parseInt(ticketTotal.toString())>0 ){
			totalAmount =ticketTotal;
		}

		return totalAmount;
	}
	public BigDecimal getMainAmount(String debtId,String capitalSerial,String interestSerial,BigDecimal nowMainAmount) {
		// TODO Auto-generated method stub
		IssueExchangeTicketMainDAO dao = new IssueExchangeTicketMainDAO();
		Session session = dao.getSession();

		Query query = session.createQuery("select p.interestAmount from IssueExchangeTicketMain p where " +
				"p.debt.id = "+debtId+" and p.capitalSerial = "+capitalSerial+
				" and p.interestSerial = "+interestSerial);
		
		BigDecimal mainAmount = new BigDecimal(0);
		Object result = query.uniqueResult();
		if(result != null){
			mainAmount = new BigDecimal(result.toString());
		}
		mainAmount = mainAmount.add(nowMainAmount);
		

		return mainAmount;
	}

	private Long getMaxAccumCount(IssueExchangeTicketDet exchangeDet) {
		// TODO Auto-generated method stub
		IssueExchangeTicketDetDAO dao = new IssueExchangeTicketDetDAO();
		Session session = dao.getSession();
		
		Query query = session.createQuery("select max(p.accumCount) from IssueExchangeTicketDet p where " +
				"p.debtId = "+exchangeDet.getDebtId()+" and p.capitalSerial = "+exchangeDet.getCapitalSerial()+
				" and p.interestSerial = "+exchangeDet.getInterestSerial()+" and p.ticketAmount = " + exchangeDet.getTicketAmount()+
				" and p.exchangeDate <= ? ");
		
		query.setDate(0,exchangeDet.getExchangeDate());
		Long accumCount = new Long(0);
		Object result = query.uniqueResult();
		if(result != null){
			accumCount = (Long)result;
		}

		return accumCount;
	}

	@Override
	protected boolean checkExists() {
		IssueExchangeTicketDetDAO dao = new IssueExchangeTicketDetDAO();
		Session session = dao.getSession();
		
		Query query = session.createSQLQuery("select top 1 1 from issue_exchange_ticket_det p where " +
				"Year(p.exchange_date) = "+yearNo.toString()+" and Month(p.exchange_date) = "+monthNo.toString());
		
		if(query.list().size() > 0){
			return true;
		}else{
			return false;
		}
	}
	
	protected List<IssueExchangeTicketDet> getExistsDet(Session session,Integer debtId) {
		
		Query query = session.createQuery("from IssueExchangeTicketDet p where " +
				"p.debtId = ?  and Year(p.exchangeDate) = "+yearNo.toString()+" and Month(p.exchangeDate) = "+monthNo.toString());
		
		query.setInteger(0,debtId);

		List detList = query.list();
		
		if (detList == null){
			detList = new ArrayList();
		}
		
		return detList;
	}

	protected List<IssueExchangeTicketMain> getExistsMain(Session session,Integer debtId) {
		
		Query query = session.createQuery("from IssueExchangeTicketMain p where " +
				"p.debt.id = ?  and Year(p.exchangeDate) = "+yearNo.toString()+" and Month(p.exchangeDate) = "+monthNo.toString());
		
		query.setInteger(0,debtId);
		
		List mainList = query.list();
		
		if (mainList == null){
			mainList = new ArrayList();
		}
		
		return mainList;
	}	
	
	@Override
	public void deleteTable(Map<String, Object> sourceData) {
		// TODO Auto-generated method stub
		//避免資料重複,先刪除相同資料才執行新增
		try{
			SQLRunner run = new ConnectionSQLRunner(connection);
			SQLJob sqlJob = new SQLJob();
			SQLRunner runMain = new ConnectionSQLRunner(connection);
			SQLJob sqlJobMain = new SQLJob();

			String yymm = sourceData.get("YYMM").toString();
			Date repayDate = getRepayDate(yymm);
			String delDate = new String().valueOf(Integer.parseInt(yymm.substring(0,3))+1911)+yymm.substring(3)+"01";
//			String delDate = new String().valueOf(Integer.parseInt(yymm.substring(0,3))+1911)+yymm.substring(3)+new String().valueOf(repayDate.getDate());
			String delDate2 = new String().valueOf(Integer.parseInt(yymm.substring(0,3))+1911)+yymm.substring(3)+"31";
			sqlJob.appendSQL("DELETE FROM issue_exchange_ticket_det WHERE convert(varchar,exchange_date,112) between '" + delDate + "' and '"+delDate2+"' and debt_id in (select id from debt_main where issue_id in (select id from issue_main where debt_type = 'A'))");
			sqlJobMain.appendSQL("DELETE FROM issue_exchange_ticket_main WHERE convert(varchar,exchange_date,112) between '" + delDate + "' and '"+delDate2+"' and debt_id in (select id from debt_main where issue_id in (select id from issue_main where debt_type = 'A'))");
			run.update(sqlJob);
			runMain.update(sqlJobMain);
		}
		catch(Exception e){
			//System.out.println(e);
		}
		
	}
}
