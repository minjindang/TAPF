package tw.gov.nta.debt.action;

import gov.dnt.tame.common.ExcelReportBaseAction;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
import tw.gov.nta.debt.form.Apra2901Form;
import tw.gov.nta.sql.debt.DebtPlanDet;
import tw.gov.nta.sql.debt.IssueMain;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class APRA2901 extends ExcelReportBaseAction {
	private final static String TEMP_TABLE_NAME = "APRA29_RPT";
	@SuppressWarnings("static-access")
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Apra2901Form myForm = (Apra2901Form) form;
//		取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//執行 delete 
		run.update(connection, this.delSQLJob(TEMP_TABLE_NAME, usrId) );
		run.update(connection, this.delSQLJob("apra29_temp", usrId, "and path = 'apra29'") );
		DateUtil dateUtil = new DateUtil();
		String bondType = myForm.getBondType();
		String[] debtType = {"E","D","D","D","C","A","B"};
		String[] debtCode = {"58","(25,31)","25","31","",bondType,""};
		String[] conds = {"="," not in ","=","=","","=",""};
		String startYear = myForm.getPaySmonth().substring(0,3);
		String startMonth = myForm.getPaySmonth().substring(3,5);
		Date startDate = new Date(Integer.parseInt(startYear)+11,Integer.parseInt(startMonth)-1,1);
		String endYear = myForm.getPayEmonth().substring(0,3);
		String endMonth = myForm.getPayEmonth().substring(3,5);
		Date endDate = dateUtil.str2Date(dateUtil.getLastDateOfMonth(endYear, endMonth));
		//Date endDate = dateUtil.str2Date(dateUtil.getLastDateOfMonth(year, "03"));
		int year = 0;
		int month = 0;
		if(Integer.parseInt(startYear)==Integer.parseInt(endYear)){
			year = 0;
			month = (Integer.parseInt(endMonth)-Integer.parseInt(startMonth))+1;
		}
		else{
			month = Integer.parseInt(endMonth)+(12-Integer.parseInt(startMonth))+1;
		}
		for(int i = 0;i<month;i++){
			@SuppressWarnings("unused")
			Calendar startDateCalendar = GregorianCalendar.getInstance();
			startDateCalendar.setTime(startDate);
			if(i >0)
				startDateCalendar.add(Calendar.MONTH, 1);
			startDate = startDateCalendar.getTime();
			endDate = DateUtil.getLastDateOfMonth(startDate);
			APRA29Report apra29Report = new APRA29Report();
			//1020927修改 查詢方式修正 使用新的方法
			//List list= apra29Report.planSubReportAmount(debtType, debtCode ,conds,startDate, endDate,"apra29");
			List list= apra29Report.getReport(run,bondType,startDate, endDate);
			for(Iterator it = list.iterator();it.hasNext();){
				DebtPlanDet debtPlanDet = (DebtPlanDet)it.next();
				BigDecimal capitalAmount = debtPlanDet.getCapitalAmount().divide(new BigDecimal(100000000));
				BigDecimal interestAmount = debtPlanDet.getInterestAmount().divide(new BigDecimal(100000000));
				debtPlanDet.setCapitalAmount(capitalAmount.setScale(4,BigDecimal.ROUND_DOWN));
				debtPlanDet.setInterestAmount(interestAmount.setScale(4,BigDecimal.ROUND_DOWN));
				run.update(connection,this.insTemp("apra29_temp", new APRA29Report().completeTempMap("apra29",debtPlanDet)));
			}
//			List paymentIssueMain = (List)run.query(new APRA29Report().sqlPayment(startDate,endDate),new MapListHandler());
//			for(Iterator it = paymentIssueMain.iterator();it.hasNext();){
//				Map map = (Map)it.next();
//				BigDecimal capitalAmount = ((BigDecimal)map.get("CAPITAL_AMOUNT")).divide(new BigDecimal(100000000));
//				BigDecimal interestAmount = ((BigDecimal)map.get("interest_amount")).divide(new BigDecimal(100000000));
//				map.put("capital_amount",capitalAmount);
//				map.put("interest_amount",interestAmount);
//				map.put("path","apra29");
//				run.update(connection,this.insTemp("apra29_temp", map));	
//			}
//			//1020724新增
//			List temp = (List)run.query(apra29Report.paymentSubReportAmount(debtType, debtCode ,conds,startDate, endDate,"apra29"),new MapListHandler());
//			for(Iterator it = temp.iterator();it.hasNext();){
//				Map map = (Map)it.next();
//				BigDecimal capitalAmount = ((BigDecimal)map.get("CAPITAL_AMOUNT")).divide(new BigDecimal(100000000));
//				BigDecimal interestAmount = ((BigDecimal)map.get("interest_amount")).divide(new BigDecimal(100000000));
//				map.put("capital_amount",capitalAmount);
//				map.put("interest_amount",interestAmount);
//				map.put("path","apra29");
//				run.update(connection,this.insTemp("apra29_temp", map));	
//			}
			run.update(connection,new APRA29Report().insTemp(usrId,"apra29",startDate, endDate));
			run.update(connection,new APRA29Report().insSubtotal(startDate,endDate));
		}
	}
	
}
