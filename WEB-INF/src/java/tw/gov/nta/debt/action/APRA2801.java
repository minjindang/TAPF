package tw.gov.nta.debt.action;

import gov.dnt.tame.common.ExcelReportBaseAction;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Timestamp;
import java.text.Bidi;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.APRA29Report;
import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.form.Apra2801Form;
import tw.gov.nta.sql.debt.DebtPlanDet;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.PaymentMain;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class APRA2801 extends ExcelReportBaseAction {
	private final static String TEMP_TABLE_NAME = "APRA28_RPT";
	@SuppressWarnings("static-access")
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Apra2801Form myForm = (Apra2801Form) form;
//		取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//執行 delete 
		run.update(connection, this.delSQLJob(TEMP_TABLE_NAME, usrId) );
		run.update(connection, this.delSQLJob("apra29_temp", usrId, "and path = 'apra28'") );
		DateUtil dateUtil = new DateUtil();
		String bondType = myForm.getBondType();
		String[] debtType = {"E","D","D","D","C","A","B"};
		String[] debtCode = {"58","(25,31)","25","31","",bondType,""};
		String[] conds = {"="," not in ","=","=","","=",""};
		String year = myForm.getPayYearMonth().substring(0,3);
		String month = myForm.getPayYearMonth().substring(3,5);
		Date startDate = new Date(Integer.parseInt(year)+11,Integer.parseInt(month)-1,1);
		Date endDate = dateUtil.str2Date(dateUtil.getLastDateOfMonth(year, month));
		//Date endDate = dateUtil.str2Date(dateUtil.getLastDateOfMonth(year, "03"));
		@SuppressWarnings("unused")
		APRA29Report apra29Report = new APRA29Report();
		//1020927修改 查詢方式修正 使用新的方法
		//List list= apra29Report.planSubReportAmount(debtType, debtCode ,conds,startDate, endDate,"apra28");
		List list= apra29Report.getReport(run,bondType,startDate, endDate);
		for(Iterator it = list.iterator();it.hasNext();){
			DebtPlanDet debtPlanDet = (DebtPlanDet)it.next();

			BigDecimal capitalAmount = debtPlanDet.getCapitalAmount().divide(new BigDecimal(100000000));
			BigDecimal interestAmount = debtPlanDet.getInterestAmount().divide(new BigDecimal(100000000));			
			debtPlanDet.setCapitalAmount(capitalAmount.setScale(4,BigDecimal.ROUND_DOWN));
			debtPlanDet.setInterestAmount(interestAmount.setScale(4,BigDecimal.ROUND_HALF_UP));			
			run.update(connection,this.insTemp("apra29_temp", new APRA29Report().completeTempMap("apra28",debtPlanDet)));
		}
		//List paymentIssueMain = (List)run.query(new APRA29Report().sqlPayment(startDate,endDate),new MapListHandler());
		//for(Iterator it = paymentIssueMain.iterator();it.hasNext();){
			//Map map = (Map)it.next();
			//BigDecimal capitalAmount = ((BigDecimal)map.get("CAPITAL_AMOUNT")).divide(new BigDecimal(100000000));
			//BigDecimal interestAmount = ((BigDecimal)map.get("interest_amount")).divide(new BigDecimal(100000000));
			//map.put("capital_amount",capitalAmount);
			//map.put("interest_amount",interestAmount);
			//map.put("path","apra28");
			//run.update(connection,this.insTemp("apra29_temp", map));	
		//}
//		1020724新增
//		List temp = (List)run.query(apra29Report.paymentSubReportAmount(debtType, debtCode ,conds,startDate, endDate,"apra28"),new MapListHandler());
//		for(Iterator it = temp.iterator();it.hasNext();){
//			Map map = (Map)it.next();
//			BigDecimal capitalAmount = ((BigDecimal)map.get("CAPITAL_AMOUNT")).divide(new BigDecimal(100000000));
//			BigDecimal interestAmount = ((BigDecimal)map.get("interest_amount")).divide(new BigDecimal(100000000));
//			map.put("capital_amount",capitalAmount);
//			map.put("interest_amount",interestAmount);
//			map.put("path","apra28");
//			run.update(connection,this.insTemp("apra29_temp", map));	
//		}
		run.update(connection,new APRA29Report().insTemp(usrId,"apra28",startDate, endDate));
		run.update(connection,new APRA29Report().insSubtotal(startDate,endDate));
		
	}
	
}
