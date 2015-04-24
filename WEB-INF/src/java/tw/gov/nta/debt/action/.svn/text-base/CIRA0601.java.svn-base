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
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Cira0601Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class CIRA0601 extends DefaultAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM CIRA06_RPT ");
		//sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}

	protected SQLJob insTemp(ActionForm form,String usrId){
		Cira0601Form cira0601Form = (Cira0601Form) form;
		SQLJob sqljob = new SQLJob();
		
		/**
		 * 調整後利率
		 */
		StringBuffer strb1 = new StringBuffer();
		strb1.append("select isnull(D.debt_rate,cast(0 as int))/100 from debt_rate_det D where D.debt_id = B.id and D.delete_mark = 'N' ");
		if( null != cira0601Form.getBaseDate() && ! "".equals(cira0601Form.getBaseDate()))
		{
			strb1.append("AND D.effective_date <= '");
			strb1.append(DateUtil.date2Str(cira0601Form.getBaseDate()));
			strb1.append("' ");
			strb1.append("AND D.suspend_date >= '");
			strb1.append(DateUtil.date2Str(cira0601Form.getBaseDate()));
			strb1.append("' ");
		}
		
		sqljob.appendSQL("INSERT INTO CIRA06_RPT ");
		sqljob.appendSQL(" ( ");
		sqljob.appendSQL(" USRID, MOD_DATE, Bank_name , Issue_serial , Issue_date  , Days , Issue_amount , Change_rate , remark ");
		sqljob.appendSQL(" ) ");
		sqljob.appendSQL(" select usrId, A, bank_name, issue_serail, issue_date, range, sum(amount), debt_rate, remark from (");
		sqljob.appendSQL(" select '"+usrId+"' as usrId, CURRENT_TIMESTAMP as A, ");
		
		//0970612修改
		if("未償".equals(cira0601Form.getStatus())){
			sqljob.appendSQL(" C.bank_name , (case when a.bond_type = '1' then a.issue_serial + '(自)' else a.issue_serial end) as issue_serail , A.issue_date " +
					", dbo.countDay(A.issue_date,A.due_date,A.show_type) as range, (isnull(B.issue_amount,0) - isnull((select sum(isnull(capital_amount,0)) from payment_main where debt_id = B.id and repay_date <= '"+DateUtil.date2Str(cira0601Form.getBaseDate())+"' ),0)) /" + cira0601Form.getBaseUnit() +  " as amount ,isnull(("+
					strb1 + "),0) as debt_rate, B.remark ");
		}else{
			sqljob.appendSQL(" C.bank_name , case when a.bond_type = '1' then a.issue_serial + '(自)' else a.issue_serial end  as issue_serail, A.issue_date " +
					", dbo.countDay(A.issue_date,A.due_date,A.show_type) , (isnull(B.issue_amount,0) - isnull((select sum(isnull(capital_amount,0)) from payment_main where debt_id = B.id ),0)) /" + cira0601Form.getBaseUnit() +  " as amount,isnull(("+
					strb1 + "),0) as debt_rate, B.remark ");
		}

		sqljob.appendSQL(" FROM issue_main A, debt_main B , bank_ref C ");
		sqljob.appendSQL(" WHERE A.debt_type = 'C' and B.issue_id = A.id AND  C.id = B.bank_id ");
		
		
		if( null != cira0601Form.getStartSerial() && ! "".equals(cira0601Form.getStartSerial()))
		{
			sqljob.appendSQL("AND A.issue_serial >=?");
			sqljob.addParameter(cira0601Form.getStartSerial());
		}
		if( null != cira0601Form.getStartSerial() && ! "".equals(cira0601Form.getStartSerial()))
		{
			sqljob.appendSQL("AND A.issue_serial <=?");
			sqljob.addParameter(cira0601Form.getStartSerial());
		}
		if( null != cira0601Form.getStartDate())
		{
			sqljob.appendSQL("AND A.issue_date >=? ");
			sqljob.addParameter(cira0601Form.getStartDate());
		}
		if( null != cira0601Form.getEndDate())
		{
			sqljob.appendSQL("AND A.issue_date <=? ");
			sqljob.addParameter(cira0601Form.getEndDate());
		}
		if( null != cira0601Form.getStartYear() && ! "".equals(cira0601Form.getStartYear()))
		{
			sqljob.appendSQL("AND A.account_year >=? ");
			sqljob.addParameter(cira0601Form.getStartYear());
		}
		if( null != cira0601Form.getEndYear() && ! "".equals(cira0601Form.getEndYear()))
		{
			sqljob.appendSQL("AND A.account_year <=? ");
			sqljob.addParameter(cira0601Form.getEndYear());
		}
		if( null != cira0601Form.getBankCode() && ! "".equals(cira0601Form.getBankCode()))
		{
			sqljob.appendSQL("AND B.bank_id =? ");
			sqljob.addParameter(cira0601Form.getBankCode());
		}
		if("未償".equals(cira0601Form.getStatus()))
		{ sqljob.appendSQL(" AND B.issue_amount > ( select isnull(sum(P.capital_amount),cast(0 as int)) from payment_main P where P.debt_id = B.id and P.repay_date <= '"+DateUtil.date2Str(cira0601Form.getBaseDate())+"' ) "); }		
		if("己償".equals(cira0601Form.getStatus()))
		{ sqljob.appendSQL(" AND B.issue_amount <= ( select isnull(sum(P.capital_amount),cast(0 as int)) from payment_main P where P.debt_id = B.id ) "); }	
		if( null != cira0601Form.getDebtCode() && ! "".equals(cira0601Form.getDebtCode()))
		{
			sqljob.appendSQL("AND B.debt_code =? ");
			sqljob.addParameter(cira0601Form.getDebtCode());
		}
		if( null != cira0601Form.getBudgetCode() && ! "".equals(cira0601Form.getBudgetCode()))
		{
			sqljob.appendSQL("AND B.budget_code =? ");
			sqljob.addParameter(cira0601Form.getBudgetCode());
		}
//		sqljob.appendSQL("ORDER BY C.id");
		sqljob.appendSQL(") as DerivedTable ");
		sqljob.appendSQL(" group by usrId, A, bank_name, issue_serail, issue_date, range, debt_rate, remark ");
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
