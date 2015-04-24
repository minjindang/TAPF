/**
 * @author Andrew Sung
 * @create 2006/4/19
 */

package tw.gov.nta.exchequer.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

import tw.gov.nta.exchequer.form.Bpra0301Form;

public class BPRA0301 extends DefaultAction
{
	protected SQLJob delTemp(String code,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM "+code+"_RPT ");
		////sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	
	protected SQLJob insTemp(ActionForm form,String usrId){
		Bpra0301Form myForm = (Bpra0301Form)form;
		String amountUtil =myForm.getAmountUnit();
		if(amountUtil==null || "".equals(amountUtil))
		{
			amountUtil = "1";
		}
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO "+myForm.getCode()+"_RPT");
		sqljob.appendSQL("(USRID, BOND_TYPE,ISSUE_SERIAL, DATE_PERIOD, ");
		sqljob.appendSQL("TEN_MILLION_COUNT, MILLION_COUNT, FIVE_HUNDRED_THOUSAND_COUNT, ");
		sqljob.appendSQL("HUNDRED_THOUSAND_COUNT, FIFTY_THOUSAND_COUNT,TOTAL_TICKET_COUNT, ");
		sqljob.appendSQL("TOTAL_AMOUNT ) ");
		sqljob.appendSQL("SELECT '"+usrId+"',");
		sqljob.appendSQL("(case when A.bond_type = '1' then '¥Ò' else '¤A' end ) as bond_type,");
		sqljob.appendSQL("(case when A.account_year = 081 and A.serial_no = 1 then '°]FA1' ");
		sqljob.appendSQL("when A.account_year = 082 and A.serial_no = 1 then '°]FA2' ");
		sqljob.appendSQL("when A.account_year = 082 and A.serial_no = 2 then '°]FB1' ");
		sqljob.appendSQL("else ('°]'+A.account_year+'_'+A.serial_no) end )  as issue_serial, ");
		//sqljob.appendSQL("('°]'+A.account_year+'_'+A.serial_no) as issue_serial,");
		sqljob.appendSQL("datediff(dd,issue_date,due_date) as date_period,");
		sqljob.appendSQL("sum(case B.ticket_amount when 10000000 then B.ticket_count else 0 end) as TEN_MILLION_COUNT,");
		sqljob.appendSQL("sum(case B.ticket_amount when 1000000 then B.ticket_count else 0 end) as MILLION_COUNT,");
		sqljob.appendSQL("sum(case B.ticket_amount when 500000 then B.ticket_count else 0 end) as FIVE_HUNDRED_THOUSAND_COUNT,");
		sqljob.appendSQL("sum(case B.ticket_amount when 100000 then B.ticket_count else 0 end) as HUNDRED_THOUSAND_COUNT,");
		sqljob.appendSQL("sum(case B.ticket_amount when 50000 then B.ticket_count else 0 end) as FIFTY_THOUSAND_COUNT,");
		sqljob.appendSQL("sum(case when B.ticket_amount in (10000000,1000000,500000,100000,50000) then B.ticket_count else 0 end ) as TOTAL_TICKET_COUNT,");
		sqljob.appendSQL("sum(case when B.ticket_amount in (10000000,1000000,500000,100000,50000) then B.ticket_amount * B.ticket_count else 0 end )-(A.issue_amount-A.capital_amount-A.interest_amount) as TOTAL_AMOUNT ");
		sqljob.appendSQL("FROM issue_main A , Issue_ticket_det B  where B.issue_id = A.id  ");
		sqljob.appendSQL(" and A.debt_type = 'B' ");
		System.out.print("myForm.getIssueSdate()"+myForm.getIssueSdate()+"myForm.getIssueEdate()"+myForm.getIssueEdate());
		if (null != myForm.getIssueSdate() && null != myForm.getIssueEdate()){
			sqljob.appendSQL("and issue_date between ? and ? ");
			sqljob.addParameter(myForm.getIssueSdate());
			sqljob.addParameter(myForm.getIssueEdate());
		}
		sqljob.appendSQL("group by bond_type,issue_serial,issue_date,due_date,A.serial_no,A.Account_year,A.issue_amount,A.capital_amount,A.interest_amount ");
		sqljob.appendSQL("order by A.account_year,case when len(A.serial_no) > 1 then A.serial_no else '0'+A.serial_no end ");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	
	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception
	{
		Bpra0301Form myForm = (Bpra0301Form)form;
		String usrId = this.getUserId(request);
		SQLRunner run = new ConnectionSQLRunner(connection);
		run.update(connection,delTemp(myForm.getCode(),usrId));
		run.update(connection,insTemp(form,usrId));
		request.setAttribute("code",myForm.getCode());
	}
}
