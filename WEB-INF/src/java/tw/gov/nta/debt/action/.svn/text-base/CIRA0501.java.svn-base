/* CIRA0501.java 報表
 程式目的：CIRA05
 程式代號：CIRA05
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

import tw.gov.nta.debt.form.Cira0501Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class CIRA0501 extends DefaultAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM CIRA05_RPT ");
		//sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}

	protected SQLJob insTemp(ActionForm form,String usrId){
		Cira0501Form cira0501Form = (Cira0501Form) form;
		SQLJob sqljob = new SQLJob();
		
		/**
		 * 調整後利率
		 */
		StringBuffer strb1 = new StringBuffer();
		strb1.append("select isnull(D.debt_rate,cast(0 as int))/100 from debt_rate_det D where D.debt_id = max(B.id) and D.delete_mark = 'N' ");
		if( null != cira0501Form.getBaseDate() && ! "".equals(cira0501Form.getBaseDate()))
		{
			strb1.append("AND D.effective_date <= '");
			strb1.append(DateUtil.date2Str(cira0501Form.getBaseDate()));
			strb1.append("' ");
			strb1.append("AND D.suspend_date >= '");
			strb1.append(DateUtil.date2Str(cira0501Form.getBaseDate()));
			strb1.append("' ");
		}
		
		
		sqljob.appendSQL("INSERT INTO CIRA05_RPT ");
		sqljob.appendSQL(" ( ");
		sqljob.appendSQL(" USRID, MOD_DATE, Bank_name , Issue_serial , Issue_date  , Days , Issue_amount , Compare_rate , Change_rate , remark ");
		sqljob.appendSQL(" ) ");
		sqljob.appendSQL(" select '"+usrId+"', CURRENT_TIMESTAMP , ");
		sqljob.appendSQL(" C.bank_name , case when max(a.bond_type) = '1' then max(a.issue_serial) + '(自)' else max(a.issue_serial) end  , max(a.issue_date) " +
				", dbo.countDay(max(a.issue_date),max(a.due_date),max(a.show_type)) , (sum(isnull(b.issue_amount,0)) - isnull((select sum(isnull(capital_amount,0)) from payment_main where debt_id = B.id ),0)) /" + cira0501Form.getBaseUnit() +  ", isnull(max(b.compare_rate),cast(0 as int))/100 ,isnull(("+
				strb1 + "),0), max(B.remark) ");
		sqljob.appendSQL(" FROM issue_main A, debt_main B , bank_ref C ");
		sqljob.appendSQL(" WHERE A.debt_type = 'C' and B.issue_id = A.id AND  C.id = B.bank_id ");
		
		

		if( null != cira0501Form.getStartSerial() && ! "".equals(cira0501Form.getStartSerial()))
		{
			sqljob.appendSQL("AND A.issue_serial >=? ");
			sqljob.addParameter(cira0501Form.getStartSerial());
		}
		if( null != cira0501Form.getStartSerial() && ! "".equals(cira0501Form.getStartSerial()))
		{
			sqljob.appendSQL("AND A.issue_serial <=? ");
			sqljob.addParameter(cira0501Form.getStartSerial());
		}
		if( null != cira0501Form.getStartYear() && ! "".equals(cira0501Form.getStartYear()))
		{
			sqljob.appendSQL("AND A.account_year >=? ");
			sqljob.addParameter(cira0501Form.getStartYear());
		}
		if( null != cira0501Form.getEndYear() && ! "".equals(cira0501Form.getEndYear()))
		{
			sqljob.appendSQL("AND A.account_year <=? ");
			sqljob.addParameter(cira0501Form.getEndYear());
		}
		if( null != cira0501Form.getBankCode() && ! "".equals(cira0501Form.getBankCode()))
		{
			sqljob.appendSQL("AND B.bank_id =? ");
			sqljob.addParameter(cira0501Form.getBankCode());
		}
		if("未償".equals(cira0501Form.getStatus()))
		{ sqljob.appendSQL(" AND B.issue_amount > ( select isnull(sum(P.capital_amount),cast(0 as int)) from payment_main P where P.debt_id = B.id ) "); }	
		if("己償".equals(cira0501Form.getStatus()))
		{ sqljob.appendSQL(" AND B.issue_amount <= ( select isnull(sum(P.capital_amount),cast(0 as int)) from payment_main P where P.debt_id = B.id ) "); }	
		if( null != cira0501Form.getDebtCode() && ! "".equals(cira0501Form.getDebtCode()))
		{
			sqljob.appendSQL("AND B.debt_code =? ");
			sqljob.addParameter(cira0501Form.getDebtCode());
		}
		if( null != cira0501Form.getBudgetCode() && ! "".equals(cira0501Form.getBudgetCode()))
		{
			sqljob.appendSQL("AND B.budget_code =? ");
			sqljob.addParameter(cira0501Form.getBudgetCode());
		}
		sqljob.appendSQL("group BY a.id , C.id , c.bank_name ,B.id");
		sqljob.appendSQL("ORDER BY C.id");
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
