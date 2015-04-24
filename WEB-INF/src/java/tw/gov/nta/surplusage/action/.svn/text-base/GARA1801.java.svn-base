package tw.gov.nta.surplusage.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;
import org.hibernate.Session;

import tw.gov.nta.account.action.ECRE0801;
import tw.gov.nta.debt.action.CIMA0110;
import tw.gov.nta.sql.debt.GaraNote;
import tw.gov.nta.sql.debt.dao.IssueMainDAO;
import tw.gov.nta.surplusage.common.GaraNoteManager;
import tw.gov.nta.surplusage.form.Gara1801Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class GARA1801 extends DefaultAction 
{
	//GARA18_RPT 的欄位名稱
	public String field_name[] = 
	{
			"REMAIN_AMOUNT",
			"SUM_AVERAGE"
	};
	
	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request, 
			Connection connection) throws Exception 
	{
		// TODO Auto-generated method stub
		Gara1801Form myForm = (Gara1801Form)form;
		
		GaraNote garaNote = new GaraNoteManager().getGaraNote(myForm.getPath());
		garaNote.setMemo(myForm.getMemo());
		garaNote.setPath(myForm.getPath());
		new GaraNoteManager().confirm(garaNote);
		request.setAttribute("memo",garaNote.getMemo());
		
		int changIntString = 0;
		String reportDate = "";
		if (myForm.getIssueYearMonth().equals(null) || myForm.getIssueYearMonth().equals("")){
			reportDate = new Timestamp(new Date().getTime()).toString();//DateUtil.date2ROCStr(new Date(),"yyy/MM.dd" );
			request.setAttribute("reportDate","");
		}else{
			reportDate = myForm.getIssueYearMonth().substring(1,3);
			changIntString = Integer.parseInt(reportDate, 10);
			changIntString = changIntString+1911;
			reportDate = reportDate.valueOf(changIntString)+"/"+myForm.getIssueYearMonth().substring(3,5)+"/"+myForm.getIssueYearMonth().substring(5,7);
			request.setAttribute("reportDate",myForm.getIssueYearMonth());
		}
		
		
		String usrId = this.getUserId(request);
		SQLRunner run = new ConnectionSQLRunner(connection);
		
		//1.刪除舊資料
		SQLJob job = delTmp(usrId);
		run.update(job);
		
		//2.計算
		//2.1 2年以下
		job = selTmp(myForm,1,reportDate);
		List list1 = (List)run.query(job, new MapListHandler());
		
		//2.2 2~5年
		job = selTmp(myForm,2,reportDate);
		List list2 = (List)run.query(job, new MapListHandler());
		
		//2.3 5~10年
		job = selTmp(myForm,3,reportDate);
		List list3 = (List)run.query(job, new MapListHandler());
		
		//2.4 10~20年
		job = selTmp(myForm,4,reportDate);
		List list4 = (List)run.query(job, new MapListHandler());
		
		//2.5 20年以上
		job = selTmp(myForm,5,reportDate);
		List list5 = (List)run.query(job, new MapListHandler());
	
		//新增至temp table GARA18_RPT
		for(int i=0;i<2;i++)
		{
			job = insTmp(usrId,i,list1,list2,list3,list4,list5);
			run.update(job);
		}
	}

	
//	insert 至 temp table GARA18_RPT
	//field - 1:未償債務餘額 , 2:各類加權平均利率 , 3:總加權平均利率
	public SQLJob insTmp(String usrId , int field, List list1, List list2, List list3, List list4, List list5)
	{
		SQLJob job = new SQLJob();
		job.appendSQL("INSERT INTO GARA18_RPT (USRID, MOD_DATE , " +
				"A1, A2, A3, A4, A5, A6, A7, A8, A9, A10) VALUES (" +
				"?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) ");
		job.addParameter(usrId);
		job.addParameter(new Date());
		job.addParameter((BigDecimal)((Map)list1.get(0)).get(field_name[field]));//公債 2年以下
		job.addParameter((BigDecimal)((Map)list1.get(1)).get(field_name[field]));//中長借2年以下
		job.addParameter((BigDecimal)((Map)list2.get(0)).get(field_name[field]));//公債 2~5年
		job.addParameter((BigDecimal)((Map)list2.get(1)).get(field_name[field]));//中長借2~5年
		job.addParameter((BigDecimal)((Map)list3.get(0)).get(field_name[field]));//公債 5~10年
		job.addParameter((BigDecimal)((Map)list3.get(1)).get(field_name[field]));//中長借5~10年
		job.addParameter((BigDecimal)((Map)list4.get(0)).get(field_name[field]));//公債 10~20年
		job.addParameter((BigDecimal)((Map)list4.get(1)).get(field_name[field]));//中長借10~20年
		job.addParameter((BigDecimal)((Map)list5.get(0)).get(field_name[field]));//公債 20年以上
		job.addParameter((BigDecimal)((Map)list5.get(1)).get(field_name[field]));//中長借20年以上
		return job;
	}
	
	//SQL1
	//op 年期 - 1:二年以下, 2 :二年~五年 , 3:五年~十年 , 4:十年~20年, 5:20年以上
	public SQLJob selTmp(Gara1801Form form , int op, String reportDate)
	{
		String diffDate = "";
		String diffDate1 = "";
		BigDecimal unit = form.getAmountUnit();
//		年期 20061208修改Avery
//		switch(op)
//		{
//			case 1:
//				diffDate = "	AND DATEDIFF(dd,issue_date,due_date) <= 728 ";
//				break;
//			case 2:
//				diffDate = "	AND DATEDIFF(dd,issue_date,due_date) > 728 ";
//				diffDate += "	AND DATEDIFF(dd,issue_date,due_date) <= 1820 ";
//				break;
//			case 3:
//				diffDate = "	AND DATEDIFF(dd,issue_date,due_date) > 1820 ";
//				diffDate += "	AND DATEDIFF(dd,issue_date,due_date) > 3640 ";
//				break;
//			case 4:
//				diffDate = "	AND DATEDIFF(dd,issue_date,due_date) > 3640 ";
//				diffDate += "	AND DATEDIFF(dd,issue_date,due_date) <= 7280 ";
//				break;
//			case 5:
//				diffDate = "	AND DATEDIFF(dd,issue_date,due_date) > 7280 ";
//				break;
//		}
//		SQLJob job = new SQLJob();
//		job.appendSQL("SELECT 'A' AS DEBT_TYPE  , COUNT(*) AS CASE_COUNT , ");
//		job.appendSQL("		ISNULL(SUM(ISSUE_AMOUNT - CAPITAL_AMOUNT - INTEREST_AMOUNT),0) / ? AS REMAIN_AMOUNT , ");
//		job.appendSQL("		ISNULL(SUM(AVERAGE_RATE),0) / ? AS SUM_AVERAGE ,");
//		job.appendSQL("		ISNULL((SUM(ISSUE_AMOUNT * AVERAGE_RATE) / SUM(ISSUE_AMOUNT)),0) / ?  AS TOTAL_AVERAGE ");	
//		job.appendSQL("FROM ISSUE_MAIN");
//		job.appendSQL("WHERE  DEBT_TYPE = 'A' " + diffDate);
//		job.appendSQL("UNION ");
//		job.appendSQL("SELECT 'C' AS DEBT_TYPE  , COUNT(*) AS CASE_COUNT , ");
//		job.appendSQL("		ISNULL(SUM(ISSUE_AMOUNT - CAPITAL_AMOUNT - INTEREST_AMOUNT),0) / ? AS REMAIN_AMOUNT , ");
//		job.appendSQL("		ISNULL(SUM(AVERAGE_RATE),0) / ? AS SUM_AVERAGE  ,");
//		job.appendSQL("		ISNULL((SUM(ISSUE_AMOUNT * AVERAGE_RATE) / SUM(ISSUE_AMOUNT)),0) / ? AS TOTAL_AVERAGE ");	
//		job.appendSQL("FROM ISSUE_MAIN");
//		job.appendSQL("WHERE  DEBT_TYPE = 'C' " + diffDate);
//		job.appendSQL("	ORDER BY DEBT_TYPE ");
//		job.addParameter(form.getAmountUnit());
//		job.addParameter(form.getAmountUnit());
//		job.addParameter(form.getAmountUnit());
//		job.addParameter(form.getAmountUnit());
//		job.addParameter(form.getAmountUnit());
//		job.addParameter(form.getAmountUnit());
	
		switch(op)
		{
			case 1:
				diffDate = "	AND (DATEDIFF(dd,A.issue_date,A.due_date) between 0 and 365*2)";
				diffDate1 = "	AND (DATEDIFF(dd,X.issue_date,X.due_date) between 0 and 365*2)";
				break;
			case 2:
				diffDate = "	AND (DATEDIFF(dd,A.issue_date,A.due_date) between 365*2 and 365*6)";
				diffDate1 = "	AND (DATEDIFF(dd,X.issue_date,X.due_date) between 365*2 and 365*6)";
				break;
			case 3:
				diffDate = "	AND (DATEDIFF(dd,A.issue_date,A.due_date) between 365*6 and  365*11-1)";
				diffDate1 = "	AND (DATEDIFF(dd,X.issue_date,X.due_date) between 365*6 and  365*11-1)";
				break;
			case 4:
				diffDate = "	AND (DATEDIFF(dd,A.issue_date,A.due_date) between 365*11 and 365*21)";
				diffDate1 = "	AND (DATEDIFF(dd,X.issue_date,X.due_date) between 365*11 and 365*21)";
				break;
			case 5:
				diffDate = "	AND (DATEDIFF(dd,A.issue_date,A.due_date) > 365*21 )";
				diffDate1 = "	AND (DATEDIFF(dd,X.issue_date,X.due_date) > 365*21 )";
				break;
		}
		
		SQLJob job = new SQLJob();
		job.appendSQL("(select '1' as seq,ISNULL(sum( B.capital_amount),0)/"+unit+" as REMAIN_AMOUNT,");
		job.appendSQL("ISNULL(sum( B.capital_amount *AVERAGE_RATE ) / sum(B.capital_amount),0) AS SUM_AVERAGE");
		job.appendSQL("from issue_main A, debt_plan_det B");
		job.appendSQL("where A.debt_type='A'");
		job.appendSQL("and A.bond_type=1");
//		job.appendSQL("and issue_date < '"+reportDate+"' ");
		job.appendSQL("and issue_date < '"+reportDate+"' ");
		job.appendSQL("and A.id=B.issue_id");
		job.appendSQL("and B.repay_date>='"+reportDate+"'");
//		job.appendSQL("and B.repay_date>='"+new Timestamp(new Date().getTime())+"'");
		job.appendSQL(diffDate);
		job.appendSQL(")");
		job.appendSQL("UNION");
		job.appendSQL("(select '2' as seq,ISNULL((sum(issue_amount) - ");
		job.appendSQL("(select sum(capital_amount) from payment_main where issue_id in (select id from issue_main X where X.debt_type='C' and X.issue_amount <> X.capital_amount "+diffDate1+" and X.bond_type =2 ))");
		job.appendSQL("),0)/"+unit+" as REMAIN_AMOUNT,");
		job.appendSQL("ISNULL((select (sum(d.debt_rate * b.issue_amount) / sum(b.issue_amount))");
		job.appendSQL("from issue_main A , debt_main b, debt_rate_det d ");
		job.appendSQL("where A.debt_type='C' and A.issue_amount <> A.capital_amount ");
		job.appendSQL("and A.bond_type =2 and b.id=d.debt_id and A.id=b.issue_id and b.accrue='Y'");
		job.appendSQL("and d.effective_date < '"+reportDate+"' and d.suspend_date > '"+reportDate+"' and d.delete_mark='N'");
		job.appendSQL(""+diffDate+"),0) as SUM_AVERAGE");	
		job.appendSQL("from issue_main A");		
		job.appendSQL("where A.debt_type='C'");
		job.appendSQL("and issue_amount <> capital_amount");
		job.appendSQL("and A.bond_type =2");
		job.appendSQL(diffDate);
		job.appendSQL(")");
		job.appendSQL("order by seq");
		System.out.println(job);
		return job;		
	}
	
	//刪除 temp table GARA18_RPT 的舊資料
	public SQLJob delTmp(String usrId)
	{
		SQLJob job = new SQLJob();
		job.appendSQL("DELETE FROM GARA18_RPT ");
		
		return job;
	}

}
