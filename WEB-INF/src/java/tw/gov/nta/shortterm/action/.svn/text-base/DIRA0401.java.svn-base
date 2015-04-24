package tw.gov.nta.shortterm.action;

import gov.dnt.tame.common.ExcelReportBaseAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.hibernate.Query;
import org.hibernate.Session;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLRunner;

import tw.gov.nta.debt.common.ContractBankManager;
import tw.gov.nta.shortterm.form.Dira0401Form;
import tw.gov.nta.sql.debt.ContractBankMain;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.dao.ContractBankMainDAO;
import tw.gov.nta.sql.debt.dao.IssueMainDAO;
import tw.gov.nta.system.common.BankCodeManage;

public class DIRA0401 extends ExcelReportBaseAction {
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		Integer tempNo = 0;
		// TODO Auto-generated method stub
		Dira0401Form myForm = (Dira0401Form)form;
		String usrId = this.getUserId(request);
		SQLRunner run = new ConnectionSQLRunner(connection);
		//刪除temp table舊資料
		run.update(connection,this.delSQLJob("dira04_rpt", usrId));
		//取得發行明細
		IssueMain issueMain =  new IssueMainDAO().get(myForm.getIssueId());
		//取得年度簽約銀行
		Session session = new IssueMainDAO().getSession();
		Query query = session.createQuery("select contractBank from ContractBankMain contractBank where  contractBank.contractYear = ? order by contractBank.bank.bankCode");
//		Query query = session.createQuery("select contractBank from ContractBankMain contractBank ,BankRef bank " +
//				"where contractBank.bank = bank and contractBank.contractYear = ? order by bank.bankCode");
		query.setParameter(0, myForm.getIssueYear().toString());
		List ContractBankList = query.list();
		//List ContractBankList = new ContractBankManager().Search(new String[]{"contractYear"} , new String[]{myForm.getIssueYear()}, new String[]{"="}, new String[]{"contractYear","bank"});
		//1.先取得有簽約並得標之年度簽約銀行
		
		
		query = session.createQuery("select debt from DebtMain debt where debt.issue =:issue  order by debt.compareRate");
		query.setParameter("issue", issueMain);
		List debtMains = query.list();
		for(Iterator itDebt = debtMains.iterator();itDebt.hasNext();){
			DebtMain debt = (DebtMain)itDebt.next();
			for(Iterator itContractBank = ContractBankList.iterator();itContractBank.hasNext();){
				ContractBankMain contractBankMain = (ContractBankMain)itContractBank.next();
				Map map = getDefMap(issueMain);
				if (!debt.getBudgetYear().equals("Y")){
					if(debt.getBank().equals(contractBankMain.getBank())){
						Calendar calendar = computeDate( issueMain.getIssueDate() );
						calendar.add(Calendar.DATE,-1);
						BigDecimal contractAmount = contractBankMain.getContractAmount().divide(new BigDecimal("100000000"));
						BigDecimal hasBoorow = new ContractBankManager().recountBorrowAmount(contractBankMain.getBank().getId(), issueMain.getAccountYear(), calendar.getTime()).divide(new BigDecimal("100000000"));
						BigDecimal lostAmount =  (contractAmount.subtract(hasBoorow).compareTo(new BigDecimal(0)) >= 0)?contractAmount.subtract(hasBoorow):new BigDecimal(0);
						map.put("no", ++tempNo);
						map.put("bank_name", new BankCodeManage().getBankNewName(contractBankMain.getBank()));
						map.put("contract_amount", contractAmount);
						map.put("has_borrow",hasBoorow );
						map.put("lost_amount",lostAmount);
						map.put("compare_amount",debt.getCompareAmount().divide(new BigDecimal("100000000")) );
						map.put("compare_rate",new BigDecimal(0) );
						map.put("issue_amount",new BigDecimal(0) );
						map.put("interest_amount",new BigDecimal(0) );
						if(debt.getAccrue().equals("Y")){
							map.put("compare_rate",debt.getCompareRate().setScale(3, BigDecimal.ROUND_HALF_UP).toString()+"%" );
							map.put("issue_amount",debt.getIssueAmount().divide(new BigDecimal("100000000")) );
							map.put("interest_amount",debt.getOriginInterestAmount() );
						}
						else if (!debt.getAccrue().equals("Y") && lostAmount.compareTo(new BigDecimal(0)) != 0)
							map.put("compare_rate","放棄" );
						else if (lostAmount.compareTo(new BigDecimal(0))==0)
							map.put("compare_rate","額度滿" );
						run.update(connection,this.insTemp("dira04_rpt", map));
					}
				}
				else
					continue;
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
//		for(Iterator itContractBank = ContractBankList.iterator();itContractBank.hasNext();){
//			ContractBankMain contractBankMain = (ContractBankMain)itContractBank.next();
//			Map map = getDefMap(issueMain);
//			Session session = new IssueMainDAO().getSession();
//			Query query = session.createQuery("select debt from DebtMain debt where debt.issue =:issue  order by debt.compareRate");
//			query.setParameter("issue", issueMain);
//			List debtMains = query.list();
//			for(Iterator itDebt = debtMains.iterator();itDebt.hasNext();){
//				DebtMain debt = (DebtMain)itDebt.next();
//				if (!debt.getBudgetYear().equals("Y")){
//					if(debt.getBank().equals(contractBankMain.getBank())){
//						Calendar calendar = computeDate( issueMain.getIssueDate() );
//						calendar.add(Calendar.DATE,-1);
//						BigDecimal contractAmount = contractBankMain.getContractAmount().divide(new BigDecimal("100000000"));
//						BigDecimal hasBoorow = new ContractBankManager().recountBorrowAmount(contractBankMain.getBank().getId(), issueMain.getAccountYear(), calendar.getTime()).divide(new BigDecimal("100000000"));
//						BigDecimal lostAmount =  (contractAmount.subtract(hasBoorow).compareTo(new BigDecimal(0)) >= 0)?contractAmount.subtract(hasBoorow):new BigDecimal(0);
//						map.put("no", ++tempNo);
//						map.put("bank_name", new BankCodeManage().getBankNewName(contractBankMain.getBank()));
//						map.put("contract_amount", contractAmount);
//						map.put("has_borrow",hasBoorow );
//						map.put("lost_amount",lostAmount);
//						map.put("compare_amount",debt.getCompareAmount().divide(new BigDecimal("100000000")) );
//						map.put("compare_rate",new BigDecimal(0) );
//						map.put("issue_amount",new BigDecimal(0) );
//						map.put("interest_amount",new BigDecimal(0) );
//						if(debt.getAccrue().equals("Y")){
//							map.put("compare_rate",debt.getCompareRate().setScale(3, BigDecimal.ROUND_HALF_UP).toString()+"%" );
//							map.put("issue_amount",debt.getIssueAmount().divide(new BigDecimal("100000000")) );
//							map.put("interest_amount",debt.getOriginInterestAmount() );
//						}
//						else if (!debt.getAccrue().equals("Y") && lostAmount.compareTo(new BigDecimal(0)) != 0)
//							map.put("compare_rate","放棄" );
//						else if (lostAmount.compareTo(new BigDecimal(0))==0)
//							map.put("compare_rate","額度滿" );
//						run.update(connection,this.insTemp("dira04_rpt", map));
//					}
//				}
//				else
//					continue;
//			}
//		}
		//2.取得參加投標之另訂新增銀行
		for(Iterator itDebt = issueMain.getDebtMains().iterator();itDebt.hasNext();){
			Map map = getDefMap(issueMain);
			DebtMain debt = (DebtMain)itDebt.next();
			if (debt.getBudgetYear().equals("Y") && debt.getAccrue().equals("Y")){
				map.put("no", ++tempNo);
				map.put("bank_name", new BankCodeManage().getBankNewName(debt.getBank())+"(逐筆簽約)");
				map.put("contract_amount", debt.getIssueAmount());
				map.put("has_borrow",new BigDecimal(0) );
				map.put("lost_amount",new BigDecimal(0));
				map.put("compare_amount",debt.getCompareAmount().divide(new BigDecimal("100000000")) );
				map.put("compare_rate",new BigDecimal(0) );
				map.put("issue_amount",new BigDecimal(0) );
				map.put("interest_amount",new BigDecimal(0) );
				if(debt.getAccrue().equals("Y")){
					map.put("compare_rate",debt.getCompareRate().setScale(3, BigDecimal.ROUND_HALF_UP).toString()+"%" );
					map.put("issue_amount",debt.getIssueAmount().divide(new BigDecimal("100000000")) );
					map.put("interest_amount",debt.getOriginInterestAmount() );
				}
				else if (!debt.getAccrue().equals("Y") )
					map.put("compare_rate","放棄" );
				run.update(connection,this.insTemp("dira04_rpt", map));
			}
		}
		//3.取得參加投標之年度簽約銀行
		for(Iterator itContractBank = ContractBankList.iterator();itContractBank.hasNext();){
			ContractBankMain contractBankMain = (ContractBankMain)itContractBank.next();
			Map map = getDefMap(issueMain);
			boolean bid = false;
			for(Iterator itDebt = issueMain.getDebtMains().iterator();itDebt.hasNext();){
				DebtMain debt = (DebtMain)itDebt.next();
				if (!debt.getBudgetYear().equals("Y")){
					if(debt.getBank().equals(contractBankMain.getBank()))
						bid = true;
				}
				else
					continue;
			}
			//未投標
			if(!bid){
				Calendar calendar = computeDate( issueMain.getIssueDate() );
				calendar.add(Calendar.DATE,-1);
				BigDecimal contractAmount = contractBankMain.getContractAmount().divide(new BigDecimal("100000000"));
				BigDecimal hasBoorow = new ContractBankManager().recountBorrowAmount(contractBankMain.getBank().getId(), issueMain.getAccountYear(), calendar.getTime()).divide(new BigDecimal("100000000"));
				BigDecimal lostAmount =  (contractAmount.subtract(hasBoorow).compareTo(new BigDecimal(0)) >= 0)?contractAmount.subtract(hasBoorow):new BigDecimal(0);
				map.put("no", ++tempNo);
				map.put("bank_name", new BankCodeManage().getBankNewName(contractBankMain.getBank()));
				map.put("contract_amount", contractAmount);
				map.put("has_borrow",hasBoorow );
				map.put("lost_amount",lostAmount);
				map.put("compare_amount",new BigDecimal(0));
				map.put("compare_rate",new BigDecimal(0) );
				map.put("issue_amount",new BigDecimal(0) );
				map.put("interest_amount",new BigDecimal(0) );
				map.put("compare_rate","放棄" );
				run.update(connection,this.insTemp("dira04_rpt", map));
			}
		}
		request.setAttribute("average_rate",issueMain.getAverageRate());
	}
	private Map getDefMap(IssueMain issue ){
		Map map = new HashMap();
		map.put("debt_name", issue.getDebtName());
		map.put("start_date", issue.getIssueDate());
		map.put("end_date", issue.getDueDate());
		map.put("sys_date", new Date());
		
		return map;
	}
	private Calendar computeDate(Date date)
	{
		Calendar tCalendar = GregorianCalendar.getInstance();
		tCalendar.setTime(date);
		return tCalendar;
	}
}
