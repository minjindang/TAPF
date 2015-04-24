/* CIRA0301.java 報表
 程式目的：CIRA03
 程式代號：CIRA03
 程式日期：0950308
 程式作者：Eric.Chen
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
 --------------------------------------------------------
 */
package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Cira0301Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class CIRA0301 extends DefaultAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM CIRA03_RPT ");
		//sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}

	protected SQLJob insTemp(ActionForm form,String usrId){
		Cira0301Form cira0301Form = (Cira0301Form) form;
		SQLJob sqljob = new SQLJob();
		String unit = cira0301Form.getBaseUnit();
		sqljob.appendSQL("INSERT INTO CIRA03_RPT ");
		sqljob.appendSQL(" ( ");
		sqljob.appendSQL(" USRID, MOD_DATE, REMARK, Issue_serial,Issue_amount" +
				", Days , Issue_date , Due_date , Compare_amount ,Compare_rate, " + 
				"Max_rate , Min_rate , Average_rate , Capital_amount, Lost_amount , now_average_rate )" );
		
		
		sqljob.appendSQL("SELECT '"+usrId+"', CURRENT_TIMESTAMP , max(A.remark) , case when max(a.bond_type) = '1' then max(a.issue_serial) + '(自)' else max(a.issue_serial) end , isnull(max(A.issue_amount),cast(0 as int)) /"+ unit +" , " + 
				" dbo.countDay(max(issue_date),max(due_date),case when null = A.show_type then 'E' else A.show_type end ) , max(issue_date) , max(due_date) , " +
				" isnull(sum(compare_amount),cast(0 as int)) /"+ unit +" , (case when A.issue_kind = '1' then 0 when max(A.issue_amount) = 0 then 0 else sum(compare_amount)/max(A.issue_amount) end ) " + 
				" ,(select isnull(max(compare_rate),cast(0 as int))/100 from debt_main where issue_id=A.id and issue_amount>0), " +
				"(select isnull(min(compare_rate),cast(0 as int))/100 from debt_main where issue_id=A.id and issue_amount>0) ," +
				" isnull(max(average_rate),cast(0 as int))/100 , isnull(max(capital_amount),cast(0 as int)) /"+ unit +" ," +
				" (isnull(max(A.issue_amount),cast(0 as int)) - isnull(max(capital_amount),cast(0 as int))) / "+ unit );
		sqljob.appendSQL(",(select dbo.sp_get_rate(A.id)) /100 ");			
		sqljob.appendSQL(" FROM issue_main A, debt_main B ");
		sqljob.appendSQL(" Where B.issue_id = A.id and A.debt_type = 'C'");
	
		
		if( null != cira0301Form.getStartYear() && ! "".equals(cira0301Form.getStartYear()))
		{
			sqljob.appendSQL("AND A.account_year >=? ");
			sqljob.addParameter(cira0301Form.getStartYear());
		}
		if( null != cira0301Form.getEndYear() && ! "".equals(cira0301Form.getEndYear()))
		{
			sqljob.appendSQL("AND A.account_year <=? ");
			sqljob.addParameter(cira0301Form.getEndYear());
		}
		
		if( null != cira0301Form.getStartSerial() && ! "".equals(cira0301Form.getStartSerial()))
		{
			sqljob.appendSQL("AND A.issue_serial >=?");
			sqljob.addParameter(cira0301Form.getStartSerial());
		}
		if( null != cira0301Form.getStartSerial() && ! "".equals(cira0301Form.getEndSerial()))
		{
			sqljob.appendSQL("AND A.issue_serial <=?");
			sqljob.addParameter(cira0301Form.getEndSerial());
		}
		if( null != cira0301Form.getStartDate())
		{
			sqljob.appendSQL("AND A.issue_date >=? ");
			sqljob.addParameter(cira0301Form.getStartDate());
		}
		if( null != cira0301Form.getEndDate())
		{
			sqljob.appendSQL("AND A.issue_date <=? ");
			sqljob.addParameter(cira0301Form.getEndDate());
		}
		if("未償".equals(cira0301Form.getStatus()))
		{ sqljob.appendSQL("AND A.issue_amount  > A.capital_amount "); }	
		if("己償".equals(cira0301Form.getStatus()))
		{ sqljob.appendSQL("AND A.issue_amount  = A.capital_amount "); }	
		
		sqljob.appendSQL("GROUP BY A.id, issue_id , A.ISSUE_KIND , A.show_type ");
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
