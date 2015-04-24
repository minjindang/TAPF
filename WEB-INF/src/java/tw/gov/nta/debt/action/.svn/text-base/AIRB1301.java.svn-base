package tw.gov.nta.debt.action;

import gov.dnt.tame.common.ExcelReportBaseAction;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Airb1301Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class AIRB1301 extends ExcelReportBaseAction {
	
	private final static String TEMP_TABLE_NAME = "AIRB13_RPT";
	
	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM AIRB13_RPT ");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	
	protected SQLJob SQL(Airb1301Form myForm){
		SQLJob sqljob = new SQLJob();
		
		sqljob.appendSQL("select i.due_date, ");
		sqljob.appendSQL("i.issue_serial, ");
		sqljob.appendSQL("p.repay_date, ");
		sqljob.appendSQL("p.capital_amount, ");
		sqljob.appendSQL("p.average_rate/100 as average_rate, ");
		sqljob.appendSQL("p.interest_amount, ");
		sqljob.appendSQL("p.buy_amount, ");
		sqljob.appendSQL("p.interest_amount * 0.1 as advance_tax, ");
		sqljob.appendSQL("p.buy_amount - p.interest_amount * 0.1 as final_amount ");
		sqljob.appendSQL("from issue_main i, debt_plan_det d, payment_main p ");
		sqljob.appendSQL("where i.id = d.issue_id ");
		sqljob.appendSQLCondition("i.id = p.issue_id ");
		sqljob.appendSQLCondition("d.id = p.plan_id ");
		sqljob.appendSQLCondition("i.debt_type = 'A' ");
		//sqljob.appendSQLCondition("d.delete_mark <> 'Y' ");
		sqljob.appendSQLCondition("p.repay_date > '2009-01-01' ");
		sqljob.appendSQLCondition("p.repay_date <> p.plan_repay_date ");
		sqljob.appendSQLCondition("p.repay_date between ? and ? ");
		sqljob.appendSQLCondition("i.bond_kind = ?");
		sqljob.addParameter(myForm.getRepayDateS());
		sqljob.addParameter(myForm.getRepayDateE());
		sqljob.addParameter(myForm.getBondKind());

		System.out.println(sqljob.toString());
		return sqljob;
	}
	
	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception 
	{
		Airb1301Form myForm = (Airb1301Form) form;
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delSQLJob("AIRB13_RPT",usrId)); 
		SQLJob sqljob = SQL(myForm);
		List tList = (List) run.query(sqljob, new MapListHandler());
		Map tMap = null;
		for(Iterator tIterator = tList.iterator(); tIterator.hasNext(); ){	
			tMap = (Map) tIterator.next();
			System.out.println((BigDecimal)tMap.get("average_rate"));
			run.update(connection,insTemp(TEMP_TABLE_NAME,tMap));
		}
		String repayDateS = DateUtil.date2ChineseROC2(myForm.getRepayDateS());
		String repayDateE = DateUtil.date2ChineseROC2(myForm.getRepayDateE());
		request.setAttribute("repayDateS",repayDateS);
		request.setAttribute("repayDateE",repayDateE);
		if("1".equals(myForm.getBondKind()))
			request.setAttribute("bondKind","一般");
		else if("3".equals(myForm.getBondKind()))
			request.setAttribute("bondKind","增額");
	}

}
