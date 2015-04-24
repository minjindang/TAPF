
package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;
import tw.gov.nta.conversion.ConvertBase;
import tw.gov.nta.conversion.ConvertTPSBF7;
import tw.gov.nta.conversion.ConvertTRBTLNO;
import tw.gov.nta.debt.common.BatchPlanExecutive;
import tw.gov.nta.debt.common.PlanExecutive;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;


public class EARC0701 extends DefaultAction{
	
	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM EARC07_RPT ");
		return sqljob;
	}
	protected void runPlanExcutive(){
		try{
			Date today = new Date();
			System.out.println("---------------------------------------------");
			System.out.println(today);
			tw.gov.nta.sql.base._BaseRootDAO.initialize();
			PlanExecutive pe = new PlanExecutive();
			pe.executePlan( today );
			tw.gov.nta.sql.base._BaseRootDAO.closeCurrentThreadSessions();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	protected SQLJob insTemp1(AccountQueryForm myForm,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO EARC07_RPT (USRID,MOD_DATE,remark,");
		sqljob.appendSQL("issue_serial,capital_serial,interest_serial,ticket_name,ticket_count,");
		sqljob.appendSQL("accum_count,total_amount,accum_amount) ");
		sqljob.appendSQL("select ?,?,null,");
		sqljob.addParameter(usrId);
		sqljob.addParameter(new Timestamp(new Date().getTime()));
		sqljob.appendSQL("a.issue_serial,b.capital_serial,b.interest_serial,b.ticket_name,isNull(sum(b.ticket_count),0)ticket_count,");
		sqljob.appendSQL("isNull(sum(b.accum_count),0)accum_count,isNull(sum(b.total_amount),0)total_amount,isNull(sum(b.accum_amount),0)accum_amount ");
		sqljob.appendSQL("from issue_main a,issue_exchange_ticket_det b,debt_main c ");
		sqljob.appendSQL("where  a.id = c.issue_id and b.debt_id = c.id ");
		sqljob.appendSQL("and b.exchange_date between '"+myForm.getSQLAccountYear()+"/"+myForm.getMonth()+"/01' and '"+myForm.getSQLLastDate()+" 23:59:59' ");
		sqljob.appendSQL("group by  a.issue_serial,b.capital_serial,b.interest_serial,b.ticket_name");
		System.out.println(sqljob);
		return sqljob;
	}
	
	protected SQLJob insTemp2(AccountQueryForm myForm,String usrId){
		//runPlanExcutive();
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO EARC07_RPT (USRID,MOD_DATE,remark,");
		sqljob.appendSQL("issue_serial,capital_serial,interest_serial,ticket_name,ticket_count,");
		sqljob.appendSQL("accum_count,total_amount,accum_amount) ");
		sqljob.appendSQL("select ?,?,null,");
		sqljob.addParameter(usrId);
		sqljob.addParameter(new Timestamp(new Date().getTime()));
		sqljob.appendSQL("a.issue_serial,b.capital_serial,b.interest_serial,c.ticket_name,isNull(c.ticket_count,0)ticket_count,");
//		sqljob.appendSQL("isNull(c.accum_count,0)accum_count,case when b.capital_serial > 0 then c.capital_amount else c.interest_amount end ticket_amount,isNull(c.accum_amount,0)accum_amount ");
		sqljob.appendSQL("isNull(c.accum_count,0)accum_count,case when b.capital_serial > 0 then b.capital_amount else b.interest_amount end ticket_amount,isNull(c.accum_amount,0)accum_amount ");
		sqljob.appendSQL("from issue_main a,payment_main b,payment_ticket_det c ");
		sqljob.appendSQL("where a.id = b.issue_id ");
		sqljob.appendSQL("  and b.id = c.payment_id ");
		sqljob.appendSQL(" and b.repay_date between '"+myForm.getSQLAccountYear()+"/"+myForm.getMonth()+"/01' and '"+myForm.getSQLLastDate()+" 23:59:59' ");
		sqljob.appendSQL("  order by a.account_year,a.serial_no,capital_Serial desc,interest_serial,ticket_amount ");
		System.out.println(sqljob);
		return sqljob;
	}
	
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delTemp(form,usrId));
		//執行 insert
		
		AccountQueryForm myForm = (AccountQueryForm)form;
		if ("1".equals((String)request.getParameter("proSet"))){
			ConvertBase convert = null;
			if ("2".equals((String)request.getParameter("choose"))){
				convert = new ConvertTPSBF7();
			}else if ("1".equals((String)request.getParameter("choose"))){
				convert = new ConvertTRBTLNO();			
			}	
			
			convert.initialize(myForm.getAccountYear(),myForm.getMonth(),true);
			convert.convert();
		}

		
		if ("1".equals((String)request.getParameter("choose"))){
			run.update(connection,insTemp1(myForm,usrId));
		}else if ("2".equals((String)request.getParameter("choose"))){		
			run.update(connection,insTemp2(myForm,usrId));
		}	

	}
}