package tw.gov.nta.shortterm.action;

import gov.dnt.tame.common.ExcelReportBaseAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.hibernate.Query;
import org.hibernate.Session;

import tw.gov.nta.debt.common.ContractBankManager;
import tw.gov.nta.shortterm.common.ShorttermNoPayCount;
import tw.gov.nta.shortterm.form.Dira1201Form;
import tw.gov.nta.sql.debt.BankRef;
import tw.gov.nta.sql.debt.ContractBankMain;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.dao.BankfDAO;
import tw.gov.nta.sql.debt.dao.ContractBankMainDAO;
import tw.gov.nta.sql.debt.dao.PaymentMainDAO;
import tw.gov.nta.system.common.BankCodeManage;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLRunner;


public class DIRA1201 extends ExcelReportBaseAction {
	
	//取得簽約銀行
	private List getContractBankList(String accountYear){
		ContractBankMainDAO dao = new ContractBankMainDAO();
		Session session = dao.getSession();
		StringBuffer hqlStr = new StringBuffer();
		hqlStr.append(" select contractBank from ContractBankMain contractBank  where 1=1 \n");
//		hqlStr.append(" and contractBank.contractYear = (select max(c.contractYear) from ContractBankMain c where c.bank.id = contractBank.bank.id) \n");
		hqlStr.append(" and contractBank.contractYear = ?");//以使用所輸入的"年度"查尋所有銀行
		hqlStr.append(" order by contractBank.contractYear desc,contractBank.bank.bankCode \n");
		Query query = session.createQuery(hqlStr.toString());
		query.setParameter(0,accountYear);
	    List list = query.list();
		return list;
	}
	
	//
	private List getBankList() {
		Session session = new BankfDAO().getSession();
		StringBuffer hqlStr = new StringBuffer();
		hqlStr.append("select bank from BankRef bank where 1=1");
		hqlStr.append("and bank in (");
		hqlStr.append("	select debt.bank from DebtMain debt where debt.issue.debtType='D'");
		hqlStr.append("	and debt.budgetYear ='Y')");
		hqlStr.append("	order by bank.bankCode");
		Query query = session.createQuery(hqlStr.toString());
	    List list = query.list();
		return list;
	}
	//取得所有借款
	private List getDebtList(String accountYear, String budgetYear ,BankRef bank,Date baseDate ) {
		ContractBankMainDAO dao = new ContractBankMainDAO();
		Session session = dao.getSession();
		if(baseDate == null)
			baseDate = new Date();
		StringBuffer hqlStr = new StringBuffer();
		hqlStr.append(" select debt from DebtMain debt where 1=1 \n");
		hqlStr.append(" and debt.issue.debtType='D' \n");
		hqlStr.append(" and debt.issue.accountYear <= ? \n");
		hqlStr.append(" and debt.budgetYear = ? \n");
		hqlStr.append(" and debt.accrue ='Y' \n");
//		hqlStr.append(" and debt.get = 'Y' \n");//由於有些的get沒有輸入值，所以先拿掉，避免錯誤
		hqlStr.append(" and debt.bank.id in (select bankRef.id from BankRef bankRef where bankRef.bankCode = ?) \n");
		hqlStr.append(" and debt.issue.issueDate <= ? \n");
		Query query = session.createQuery(hqlStr.toString());
		query.setParameter(0,accountYear);
		query.setParameter(1,budgetYear);
		query.setParameter(2,bank.getBankCode());
		if(baseDate == null)
			query.setParameter(3,new Date());
		else
			query.setParameter(3,baseDate);
		List debtList = query.list();
		    //如以清償不列入計算
		    //使用Array儲存代資料刪除
//	    System.out.println(hqlStr.toString()+"@"+accountYear+"@"+budgetYear+"@"+bank.getBankCode());

	    List list = new LinkedList();
	    for(Iterator it = debtList.iterator();it.hasNext();){
	    	DebtMain debt = (DebtMain)it.next();
	    	BigDecimal capitalAmount = getCapitalAmount(debt,baseDate);
//	    	System.out.println(debt.getIssue().getDebtName());
	    	if(debt.getIssueAmount().compareTo(capitalAmount) == 1 ){
	    		list.add(debt);
	    	}
	    }
		return list;

	}
	//計算該借款已償金額
	private BigDecimal getCapitalAmount(DebtMain debt,Date baseDate){
		ContractBankMainDAO dao = new ContractBankMainDAO();
		Session session = dao.getSession();
		if(baseDate == null)
			baseDate = new Date();
		StringBuffer hqlStr = new StringBuffer();
		hqlStr.append("select isnull(sum(pay.capitalAmount),0) as capitalAmount from PaymentMain as pay ");
		hqlStr.append("where pay.debtId = ?");
//		hqlStr.append("and pay.plan.deleteMark = 'N'");//由於有些的delete_Mark沒有輸入值，所以先拿掉，避免錯誤
		hqlStr.append("and pay.repayDate <= ?");
		Query query = session.createQuery(hqlStr.toString());
		query.setParameter(0,debt.getId());
		query.setParameter(1,baseDate);
		BigDecimal capitalAmount = (BigDecimal) query.list().get(0);
//		System.out.println(hqlStr.toString()+"@"+debt.getId()+"@"+baseDate);
		return capitalAmount;
	}
	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,Connection connection) throws Exception {
		Dira1201Form myForm = (Dira1201Form) form;
		String usrId = this.getUserId(request);
		SQLRunner run = new ConnectionSQLRunner(connection);
		run.update(connection,this.delSQLJob("dira12_rpt", usrId));
		//階段1取得簽約銀行內容及未還期別
		//取得年度簽約銀行(budget_year ="N")
		List listContractBank = getContractBankList(myForm.getAccountYear());
		
		//簽約額度總額
		BigDecimal contractAmount = new BigDecimal(0);
		//已借額度
		BigDecimal recountBorrowAmount = new BigDecimal(0);
		//民營化基金(總合)
		BigDecimal payAmount1 = new BigDecimal(0);
		//債務化基金(總合)
		BigDecimal payAmount2 = new BigDecimal(0);
		//國庫借款(總合)
		BigDecimal payAmount3 = new BigDecimal(0);
		
		int tmpNo = 1;
		for(Iterator it = listContractBank.iterator();it.hasNext();){
			ContractBankMain contractBankMain = (ContractBankMain)it.next();
			BigDecimal borrowAmount = new BigDecimal(0);
			Map map = new HashMap();
			String issueSerial = "";
			if(contractBankMain.getContractYear().compareTo(myForm.getAccountYear()) == -1)
			{
				map.put("bank_name", new BankCodeManage().getBankNewName(contractBankMain.getBank())+"(未續約)");
				map.put("contract_amount", new BigDecimal(0));
			}
			else{
				map.put("bank_name", new BankCodeManage().getBankNewName(contractBankMain.getBank()));
				map.put("contract_amount", contractBankMain.getContractAmount().divide(new BigDecimal(100000000)));
			}
			
			List debtList = getDebtList(myForm.getAccountYear(), "N" ,contractBankMain.getBank(),myForm.getBaseDate() );
			//若無借款資料且簽約年度不等於查詢年度則不作後續處裡直接跳過
			if (debtList.size()==0 && !contractBankMain.getContractYear().equals(myForm.getAccountYear()))
				continue;
			else{
				for(Iterator itDebt = debtList.iterator();itDebt.hasNext();){
					DebtMain debt = (DebtMain)itDebt.next();
					borrowAmount = borrowAmount.add(debt.getIssueAmount());
					recountBorrowAmount = recountBorrowAmount.add(debt.getIssueAmount());
					BigDecimal payment_main = debt.getIssueAmount().divide(new BigDecimal(100000000));
//					issueSerial = issueSerial+debt.getIssue().getIssueSerial()+"("+debt.getIssueAmount().divide(new BigDecimal(100000000))+")";
					issueSerial = issueSerial+debt.getIssue().getIssueSerial()+"("+payment_main.setScale(0,BigDecimal.ROUND_HALF_DOWN)+")";
					if (itDebt.hasNext())
						issueSerial = issueSerial+"、";
					if(debt.getIssue().getBudgetCode() == 4)
						payAmount1 = payAmount1.add(payment_main.setScale(0,BigDecimal.ROUND_HALF_DOWN));
					else if(debt.getIssue().getBudgetCode() == 3)
						payAmount2 = payAmount2.add(payment_main.setScale(0,BigDecimal.ROUND_HALF_DOWN));
					else
						payAmount3 = payAmount3.add(payment_main.setScale(0,BigDecimal.ROUND_HALF_DOWN));
				}
				map.put("lost_amount",  (contractBankMain.getContractAmount().subtract(borrowAmount)).divide(new BigDecimal(100000000)));
			}
			map.put("issue_Serial", issueSerial);
			map.put("tmp_no", tmpNo++);
			map.put("has_borrow", borrowAmount.divide(new BigDecimal(100000000)));
			run.update(connection,this.insTemp("dira12_rpt", map));
			contractAmount = contractAmount.add(contractBankMain.getContractAmount());
		}
		
		//階段2取得非簽約銀行內容及未還期別
		//取得年度簽約銀行(budget_year ="N")
		List listBank = getBankList();
		for(Iterator it = listBank.iterator();it.hasNext();){
			BankRef bank = (BankRef)it.next();
			BigDecimal borrowAmount = new BigDecimal(0);
			Map map = new HashMap();
			String issueSerial = "";
			map.put("bank_name", new BankCodeManage().getBankNewName(bank)+"(另訂契約)");
			//map.put("contract_amount", contractBankMain.getContractAmount().divide(new BigDecimal(100000000)));
			List debtList = getDebtList(myForm.getAccountYear(), "Y" ,bank,myForm.getBaseDate() );
			//若無借款資料且簽約年度不等於查詢年度則不作後續處裡直接跳過
			BigDecimal issueAmount = new BigDecimal(0);
			if (debtList.size()==0 )
				continue;
			for(Iterator itDebt = debtList.iterator();itDebt.hasNext();){
				DebtMain debt = (DebtMain)itDebt.next();
				borrowAmount = borrowAmount.add(debt.getIssueAmount());
				recountBorrowAmount = recountBorrowAmount.add(debt.getIssueAmount());
				issueAmount = issueAmount.add(debt.getIssueAmount());
				BigDecimal payment_main = debt.getIssueAmount().divide(new BigDecimal(100000000));
//				issueSerial = issueSerial+debt.getIssue().getIssueSerial()+"("+debt.getIssueAmount().divide(new BigDecimal(100000000))+")";
				issueSerial = issueSerial+debt.getIssue().getIssueSerial()+"("+payment_main.setScale(0,BigDecimal.ROUND_HALF_DOWN)+")";
				if (itDebt.hasNext())
					issueSerial = issueSerial+"、";
				if(debt.getIssue().getBudgetCode() == 4)
					payAmount1 = payAmount1.add(payment_main.setScale(0,BigDecimal.ROUND_HALF_DOWN));
				else if(debt.getIssue().getBudgetCode() == 3)
					payAmount2 = payAmount2.add(payment_main.setScale(0,BigDecimal.ROUND_HALF_DOWN));
				else
					payAmount3 = payAmount3.add(payment_main.setScale(0,BigDecimal.ROUND_HALF_DOWN));				
			}
			map.put("lost_amount", new BigDecimal(0));
			map.put("has_borrow", issueAmount.divide(new BigDecimal(100000000)));
			map.put("contract_amount", new BigDecimal(0));
			map.put("issue_Serial", issueSerial);
			map.put("tmp_no", tmpNo++);
			run.update(connection,this.insTemp("dira12_rpt", map));
		}
//		String memo = "註：已借款額度包含「行政院公營事業民營化基金」借款"+new ShorttermNoPayCount().noPayAmount(null,myForm.getAccountYear(),"3").divide(new BigDecimal(100000000),0,4)+"億元、債務基金借款"+new ShorttermNoPayCount().noPayAmount(null,myForm.getAccountYear(),"4").divide(new BigDecimal(100000000),0,4)+"億元";
		String memo = "註：已借款額度包含「行政院公營事業民營化基金」借款"+payAmount1+"億元、債務基金借款"+payAmount2+"億元、國庫借款"+payAmount3+"億元";
		request.setAttribute("memo",memo);
		request.setAttribute("contractAmount",contractAmount.divide(new BigDecimal(100000000)));
		request.setAttribute("borrow",recountBorrowAmount.divide(new BigDecimal(100000000)));
	}
}
