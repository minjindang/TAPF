/* CPRA0201.java 報表
 程式目的：CPRA02
 程式代號：CPRA02
 程式日期：0950308
 程式作者：Eric.Chen
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
 --------------------------------------------------------
 */
package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Cira0401Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class CIRA0401 extends DefaultAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM CIRA04_RPT ");
		//sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}

	protected SQLJob insTemp(ActionForm form,String usrId){
		Cira0401Form cira0401Form = (Cira0401Form) form;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO CIRA04_RPT ");
		sqljob.appendSQL(" ( ");
		sqljob.appendSQL(" USRID, MOD_DATE, REMARK, Issue_serial , Bank_name ," +
						 " Issue_amount, Days , Issue_date , Due_date , Budget,Debt ," +
					     " Compare_rate, Now_rate , Capital_amount , Lost_amount )" );
		
		/**
		 * 己償金額
		 */
		StringBuffer strb1 = new StringBuffer();
		strb1.append(" select isnull(sum(D.capital_amount),cast(0 as int)) / ");
		strb1.append(cira0401Form.getBaseUnit());
		strb1.append(" from payment_main D where D.debt_id = B.id ");
		
		/**
		 * 未償金額
		 */
		StringBuffer strb2 = new StringBuffer();
		strb2.append(" isnull(B.issue_amount,cast(0 as int)) / ");
		strb2.append(cira0401Form.getBaseUnit());
		strb2.append(" - (");
		strb2.append(strb1);
		strb2.append(")");
		
		/**
		 * 調整後利率
		 */
		StringBuffer strb3 = new StringBuffer();
		strb3.append("select isnull(F.debt_rate,cast(0 as int))/100 from debt_rate_det F where F.debt_id = B.id and F.delete_mark = 'N' ");
		if( null != cira0401Form.getBaseDate() && ! "".equals(cira0401Form.getBaseDate()))
		{
			strb3.append("AND F.effective_date <= '");
			strb3.append(DateUtil.date2Str(cira0401Form.getBaseDate()));
			strb3.append("' ");
			strb3.append("AND F.suspend_date >= '");
			strb3.append(DateUtil.date2Str(cira0401Form.getBaseDate()));
			strb3.append("' ");
		}
		
		sqljob.appendSQL("SELECT '"+usrId+"', CURRENT_TIMESTAMP , B.remark , ");
		sqljob.appendSQL("case when a.bond_type = '1' then a.issue_serial + '(自)' else a.issue_serial end,C.Bank_Name, B.issue_amount /" + cira0401Form.getBaseUnit() +
				" , dbo.countYMD(A.issue_date,A.due_date),A.issue_date," +
				"A.due_date,(select budget_name from budget_ref where id = B.budget_code)," +
				"(select debit_name from debit_ref where id = B.debt_code),B.compare_rate/100 , (" +  strb3 + ") , (" + strb1 +
				") , (" + strb2 + ")" );

		sqljob.appendSQL(" FROM issue_main A, debt_main B , Bank_ref C ");
		sqljob.appendSQL(" Where B.issue_id = A.id and A.debt_type = 'C' AND B.bank_id = C.id ");

		
		
		if( null != cira0401Form.getStartYear() && ! "".equals(cira0401Form.getStartYear()))
		{
			sqljob.appendSQL("AND A.account_year >=? ");
			sqljob.addParameter(cira0401Form.getStartYear());
		}
		if( null != cira0401Form.getEndYear() && ! "".equals(cira0401Form.getEndYear()))
		{
			sqljob.appendSQL("AND A.account_year <=? ");
			sqljob.addParameter(cira0401Form.getEndYear());
		}
		
		if( null != cira0401Form.getStartSerial() && ! "".equals(cira0401Form.getStartSerial()))
		{
			sqljob.appendSQL("AND A.issue_serial >=?");
			sqljob.addParameter(cira0401Form.getStartSerial());
		}
		if( null != cira0401Form.getStartSerial() && ! "".equals(cira0401Form.getEndSerial()))
		{
			sqljob.appendSQL("AND A.issue_serial <=?");
			sqljob.addParameter(cira0401Form.getEndSerial());
		}
		if( null != cira0401Form.getStartDate())
		{
			sqljob.appendSQL("AND A.issue_date >=? ");
			sqljob.addParameter(cira0401Form.getStartDate());
		}
		if( null != cira0401Form.getEndDate())
		{
			sqljob.appendSQL("AND A.issue_date <=? ");
			sqljob.addParameter(cira0401Form.getEndDate());
		}
		if( null != cira0401Form.getDebtCode() && ! "".equals(cira0401Form.getDebtCode()))
		{
			sqljob.appendSQL("AND B.debt_code = ? ");
			sqljob.addParameter(cira0401Form.getDebtCode());
		}
		if( null != cira0401Form.getBudgetCode() && ! "".equals(cira0401Form.getBudgetCode()))
		{
			sqljob.appendSQL("AND B.budget_code =? ");
			sqljob.addParameter(cira0401Form.getBudgetCode());
		}
		if( null != cira0401Form.getBankCode() && ! "".equals(cira0401Form.getBankCode()))
		{
			sqljob.appendSQL("AND B.bank_id =? ");
			sqljob.addParameter(cira0401Form.getBankCode());
		}
				
		if("未償".equals(cira0401Form.getStatus()))
		{ sqljob.appendSQL(" AND B.issue_amount > ( select isnull(sum(P.capital_amount),cast(0 as int)) from payment_main P where P.debt_id = B.id ) "); }	
		if("己償".equals(cira0401Form.getStatus()))
		{ sqljob.appendSQL(" AND B.issue_amount <= ( select isnull(sum(P.capital_amount),cast(0 as int)) from payment_main P where P.debt_id = B.id ) "); }	
		System.out.println(sqljob.toString());
		return sqljob;
	}

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {

		//取得使用者帳號
		String usrId = request.getSession().getAttribute("ACCOUNT").toString();
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delTemp(form,usrId));
		//執行 insert
		run.update(connection,insTemp(form,usrId));
		
	}


}
