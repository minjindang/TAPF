package tw.gov.nta.debt.common;

import gov.dnt.tame.common.LabelValueBean;
import gov.dnt.tame.util.ListToolManager;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

import tw.gov.nta.sql.debt.BankRef;
import tw.gov.nta.sql.debt.ContractBankMain;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.dao.BankRefDAO;
import tw.gov.nta.sql.debt.dao.ContractBankMainDAO;
import tw.gov.nta.sql.debt.dao.IssueMainDAO;
import tw.gov.nta.sql.debt.dao.PaymentMainDAO;


public class ContractBankManager{

	/**
	 * 新增簽約銀行Dto
	 * @return
	 */
	public ContractBankMain createBean() {
		return new ContractBankMain();
	}

	/**
	 * 取得簽約銀行Dto
	 * @param pId
	 * @return
	 */
	public ContractBankMain getBean(int pId) {
		return new ContractBankMainDAO().get(new Integer(pId));
	}

	/**
	 * 新增簽約銀行
	 * @param pContractBankMainDto
	 * @throws Exception
	 */
	public void confirm(ContractBankMain pContractBankMainDto) throws Exception {
		if(!checkBean(pContractBankMainDto))
			throw new Exception();
		new ContractBankMainDAO().saveOrUpdate(pContractBankMainDto);
	}

	/**
	 * 確認簽約銀行
	 * @param pContractBankMainDtoList
	 * @throws Exception
	 */
	public void confirm(List pContractBankMainDtoList) throws Exception {
		if(pContractBankMainDtoList == null || pContractBankMainDtoList.size() == 0) return;
		Iterator tIterator = pContractBankMainDtoList.iterator();
		while(tIterator.hasNext())
			confirm((ContractBankMain)tIterator.next());
		
	}

	/**
	 * check簽約銀行Dto，目前只回應true
	 * @param pContractBankMainDto
	 * @return
	 */
	public boolean checkBean(ContractBankMain pContractBankMainDto) {
		return true;
	}
	
	public boolean checkBean(DebtMain pDebtMainDto) {
		List list = Search(new String[]{"contractYear","bank.id"},new Object[]{pDebtMainDto.getIssue().getAccountYear(),pDebtMainDto.getBank().getId()},new String[]{"=","="},new String[]{""});
		if(list.size()==0)
			return false;
		ContractBankMain dto = (ContractBankMain)list.get(0);
		if(pDebtMainDto.getId() == null){
			if(dto.getContractAmount().subtract((dto.getBorrowAmount()!= null)?dto.getBorrowAmount():new BigDecimal(0)).doubleValue() < pDebtMainDto.getIssueAmount().doubleValue())
				return false;	
		}
		else{
			DebtMain debtMain = new DebtManager().getBean(pDebtMainDto.getId());
			if(dto.getContractAmount().subtract((dto.getBorrowAmount()!= null)?dto.getBorrowAmount():new BigDecimal(0)).subtract(debtMain.getIssueAmount()).add(pDebtMainDto.getIssueAmount()).doubleValue() < pDebtMainDto.getIssueAmount().doubleValue())
				return false;	
		}
		return true;
	}
	
	
	/**
	 * 取消簽約銀行
	 * @param pId
	 */
	public void cancel(int pId){
		ContractBankMain tContractBankMainDto = getBean(pId);
		if(!isModify(tContractBankMainDto)) return;
		new ContractBankMainDAO().delete(tContractBankMainDto);
	}

	/**
	 * 確認是否可修改，目前只回應true
	 * @param pContractBankMainDto
	 * @return
	 */
	public boolean isModify(ContractBankMain pContractBankMainDto){
		return true;
	}	
	
	/**
	 * 查詢簽約銀行資料
	 * @param pcols:多筆欄位
	 * @param pValues:多筆數值
	 * @param pConds:多筆條件(=,>,<,>=,<=)
	 * @param pOrderby:多筆排序條件
	 * @return:查詢結果清單
	 */
	public List Search(String[] pCols, Object[] pValues, String[] pConds, String[] pOrderby){
		Session tSession = new PaymentMainDAO().getSession();
		Criteria tCriteria = tSession.createCriteria(ContractBankMain.class);
		if(pCols != null && pValues != null && pConds != null){
			for(int i = 0 ; i < pCols.length ; i++){
				if(pConds[i] == null || pCols[i] == null || pValues[i] == null || "".equals(pCols[i]) || "".equals(pValues[i]) || "".equals(pConds[i]))
					continue;
				if(pConds[i].equals("="))
					tCriteria.add(Expression.eq(pCols[i], pValues[i]));
				else if(pConds[i].equals(">"))
					tCriteria.add(Expression.gt(pCols[i], pValues[i]));
				else if(pConds[i].equals("<"))
					tCriteria.add(Expression.lt(pCols[i], pValues[i]));
				else if(pConds[i].equals(">="))
					tCriteria.add(Expression.ge(pCols[i], pValues[i]));
				else if(pConds[i].equals("<="))
					tCriteria.add(Expression.le(pCols[i], pValues[i]));
				else if(pConds[i].equals("like"))
					tCriteria.add(Expression.like(pCols[i], pValues[i]));
			}
		}
		if(pOrderby != null){
			for(int i = 0 ; i < pOrderby.length ; i++){
				if(pOrderby[i] == null || "".equals(pOrderby[i])) continue;
				tCriteria.addOrder(Order.asc(pOrderby[i]));
			}
		}
		List tResultList = tCriteria.list();
		tSession.close();
		return tResultList;
	}
	
	/**
	 * 尚未實做
	 *
	 */
	public void getAccountInfo() {
	}
	/**
	 * 重新計算已借額度
	 * @param 
	 * @return
	 * @throws SQLException 
	 */
	public BigDecimal recountBorrowAmount(Integer pBankId,String pYear,Connection connection){
		return recountBorrowAmount( pBankId, pYear);
	}
	public BigDecimal recountBorrowAmount(Integer pBankId,String pYear){
		return recountBorrowAmount( pBankId, pYear,new Date());
	}
	public BigDecimal recountBorrowAmount(Integer pBankId,String pYear,Date baseDate){
		Session session = new IssueMainDAO().getSession();
		BigDecimal borrowAmount = new BigDecimal(0);
//		String issueHql = "select issue from IssueMain issue where issue.debtType = 'D' and ";
		Query query =null;
		StringBuffer buffer = new StringBuffer();
		buffer.append("select isnull(sum(debt.issueAmount),0) as issueAmount from DebtMain as debt ");
		buffer.append("where debt.issue.debtType='D'");
		buffer.append("and debt.issue.accountYear <= ?");
		//buffer.append("and debt.issue.accountYear >= 94");
		buffer.append("and debt.accrue ='Y'");
		buffer.append("and debt.bank.id = ?");
		buffer.append("and debt.budgetYear = 'N'");
		buffer.append("and debt.get = 'Y'");
		buffer.append("and debt.issue.issueDate <= ?");
		query = session.createQuery(buffer.toString());
		query.setParameter(0,pYear);
		query.setParameter(1,pBankId);
		query.setParameter(2,baseDate);
		BigDecimal totalIssueAmount = (BigDecimal) query.list().get(0);
		buffer = new StringBuffer();
		buffer.append("select isnull(sum(pay.capitalAmount),0) as capitalAmount from PaymentMain as pay ");
		buffer.append("where pay.plan.debt.issue.debtType='D'");
		buffer.append("and pay.plan.debt.issue.accountYear <= ?");
		buffer.append("and pay.plan.debt.accrue ='Y'");
		buffer.append("and pay.plan.debt.bank.id = ?");
		buffer.append("and pay.plan.deleteMark = 'N'");
		buffer.append("and pay.plan.debt.budgetYear = 'N'");
		buffer.append("and pay.plan.debt.get = 'Y'");
		buffer.append("and pay.repayDate <= ?");
		query = session.createQuery(buffer.toString());
		query.setParameter(0,pYear);
		query.setParameter(1,pBankId);
		query.setParameter(2,baseDate);
		BigDecimal totalCapitalAmount = (BigDecimal) query.list().get(0);
		return totalIssueAmount.subtract(totalCapitalAmount);
	}

	/**public BigDecimal recountBorrowAmount(Integer pBankId,String pYear,Connection connection) throws SQLException{
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL(" select isNull(");
		sqljob.appendSQL("(");
		sqljob.appendSQL("select sum(isnull(b.issue_amount,0)) - ");
		sqljob.appendSQL("(select isNull(sum(p.capital_amount),0) from payment_main p ");
		sqljob.appendSQL("where  (select account_year from issue_main where id = p.issue_id) <= contract_bank_main.contract_year");
		sqljob.appendSQL("and (select bank_id from debt_main where id = p.debt_id) = contract_bank_main.bank_id) ");
//		sqljob.appendSQL("where (select bank_id from debt_main where id = p.debt_id) = contract_bank_main.bank_id) ");
		sqljob.appendSQL("from issue_main a,debt_main b");
		sqljob.appendSQL("where a.id = b.issue_id ");
		sqljob.appendSQL("and a.debt_type = 'D' ");
		sqljob.appendSQL("and b.accrue = 'Y' ");
		sqljob.appendSQL("and b.bank_id = contract_bank_main.bank_id");
		sqljob.appendSQL("and a.account_year = contract_bank_main.contract_year)");
		sqljob.appendSQL(",0)as borrow from contract_bank_main");
		sqljob.appendSQL(" where bank_id = "+pBankId);
		sqljob.appendSQL("and contract_year = '"+pYear+"'");
//		sqljob.addParameter(pBankId);
//		sqljob.addParameter(pYear);
		System.out.println(sqljob.toString());
//		SQLRunner run = new ConnectionSQLRunner(DriverManager.getConnection("jdbc:microsoft:sqlserver://172.20.110.2:1433;DatabaseName=DEBT;SelectMethod=cursor;autoReconnect=true","sa","1qaz2wsx"));
		SQLRunner run = new ConnectionSQLRunner(connection);
		List list = (List) run.query(sqljob, new MapListHandler());
		BigDecimal borrowAmount = new BigDecimal(0);
		if(list.size()>0)
			borrowAmount = new BigDecimal(((Map)list.get(0)).get("borrow").toString());
		return borrowAmount;
	}*/
	public static List<LabelValueBean> getBankByAccountYear(String accountYear) throws HibernateException
	{
		StringBuffer hqlStr = new StringBuffer("select contractBankMain.bank.bankCode, contractBankMain.bank.bankName from ContractBankMain contractBankMain");
        if(!"".equals(accountYear))
        	hqlStr.append( " where contractBankMain.contractYear ='" +accountYear+ "' ");
        Session session = new ContractBankMainDAO().getSession();
		Query query = session.createQuery(hqlStr.toString());
		if(query.list().size() == 0)
			hqlStr = new StringBuffer("select bankCode,bankName from BankRef");
        System.out.println(hqlStr.toString());
        return ListToolManager.getList(hqlStr.toString());
	}
}
 
