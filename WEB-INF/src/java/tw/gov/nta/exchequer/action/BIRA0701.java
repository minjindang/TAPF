package tw.gov.nta.exchequer.action;

import gov.dnt.tame.common.ExcelReportRemainAction;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.exchequer.form.Bira0701Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;


public class BIRA0701 extends ExcelReportRemainAction{

	
	protected SQLJob SQL1(Bira0701Form myForm){
		SQLJob sqljob = new SQLJob();
		/*
		sqljob.appendSQL("select Right('000'+convert(varchar(3),  ");
		sqljob.appendSQL("case when year(B.date1) < 2000 and month(B.date1) > 6 ");
		sqljob.appendSQL("then  year(B.date1)+1 ");
		sqljob.appendSQL("else  year(B.date1) ");
		sqljob.appendSQL("end-1911),3) as year1,A.issue_serial,A.issue_date,A.due_date,A.issue_amount,");
		sqljob.appendSQL("sum(case when (kind = '1') and A.debt_type='B' then isnull(A_total,0) else 0 end) as issue_total_B,");//國庫券發行數
		sqljob.appendSQL("sum(case when (kind = '2') and A.debt_type='B' then isnull(A_total,0) else 0 end) as capital_total_B ");//國庫券還本數
		sqljob.appendSQL("from issue_main A,v_debtT B ");
		sqljob.appendSQL("where A.issue_serial = B.issue_serial ");
		sqljob.appendSQL("and B.date1 <= '"+new Timestamp(new Date().getTime())+"' ");
		if (!"".equals(myForm.getBudgetCode())){
			sqljob.appendSQL("and budget_code = ? ");
			sqljob.addParameter(myForm.getBudgetCode());
		}
		sqljob.appendSQL("group by Right('000'+convert(varchar(3),");
		sqljob.appendSQL("case when year(B.date1) < 2000 and month(B.date1) > 6 ");
		sqljob.appendSQL("then  year(B.date1)+1 ");
		sqljob.appendSQL("else  year(B.date1) ");
		sqljob.appendSQL("end-1911),3) ");
		sqljob.appendSQL("order by Right('000'+convert(varchar(3),");
		sqljob.appendSQL("case when year(B.date1) < 2000 and month(B.date1) > 6 ");
		sqljob.appendSQL("then  year(B.date1)+1 ");
		sqljob.appendSQL(" else  year(B.date1) ");
		sqljob.appendSQL("end-1911),3)");
		*/
		sqljob.appendSQL("select ");
		sqljob.appendSQL("Right('000'+convert(varchar(3),case when year(A.issue_date) < 2000 ");
		sqljob.appendSQL("and month(A.issue_date) > 6 ");
		sqljob.appendSQL("then year(A.issue_date)+1 else year(A.issue_date) end-1911),3) as year1,");
		sqljob.appendSQL("A.issue_serial,A.issue_date,A.due_date,A.issue_amount from issue_main A ");
		sqljob.appendSQL("where A.debt_type='B' ");
		sqljob.appendSQL("and A.issue_date <= '"+new Timestamp(new Date().getTime())+"' ");
		if (!"".equals(myForm.getBudgetCode()))
			sqljob.appendSQL("and budget_code = "+myForm.getBudgetCode()+" "); //預算別
		sqljob.appendSQL("order by A.issue_date,A.issue_serial ");
		System.out.println("BIRA0701-SQL1:" + sqljob);
		return sqljob;
	}
	protected SQLJob SQL2(Bira0701Form myForm,Date lastDueDate,Date thisDueDate){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select isNull(sum(issue_amount),0) as capital_amount from issue_main ");
		sqljob.appendSQL("where  debt_type='B' ");
		sqljob.appendSQL("and due_date <= '"+new Timestamp(new Date().getTime())+"' ");
		sqljob.appendSQL("and due_date > '"+new Timestamp(lastDueDate.getTime())+"' ");
		sqljob.appendSQL("and due_date <= '"+new Timestamp(thisDueDate.getTime())+"' ");
		if (!"".equals(myForm.getBudgetCode()))
			sqljob.appendSQL("and budget_code = "+myForm.getBudgetCode()+" "); //預算別
		
		System.out.println("BIRA0701-SQL2:" + sqljob);
		return sqljob;
	}
	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		Bira0701Form myForm = (Bira0701Form) form;
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delSQLJob("BIRA07_RPT",usrId));

		//依條件找出期別
		List queryList1 = (List) run.query(SQL1(myForm), new MapListHandler());
		Map tMap = null;
		Map dMap = new HashMap();
		//截至每期發行日之未償餘額
		BigDecimal thisNoPayAmount = new BigDecimal(0);
		//截至上期發行日之未償餘額
		BigDecimal lastNoPayAmount = new BigDecimal(0);
		Date lastDate = DateUtil.str2Date(DateUtil.getLastDateOfMonth("000","01"));
		for(Iterator tIterator = queryList1.iterator(); tIterator.hasNext(); )
		{
			tMap = (Map) tIterator.next();
			dMap.putAll(getCommonMap(usrId));
			//期別
			dMap.put("ISSUE_SERIAL",(String)tMap.get("issue_serial"));
			//發行日
			dMap.put("ISSUE_DATE",(Date)tMap.get("issue_date"));
			//截至上期發行日之未償餘額
			//user要求F081_01的截至上期發行日之未償餘額為0
			if (((String)dMap.get("ISSUE_SERIAL")).equals("F081_01")){
				dMap.put("SREMAIN_AMOUNT",new BigDecimal(0));
				lastNoPayAmount = new BigDecimal(0);
			}else{
				dMap.put("SREMAIN_AMOUNT",lastNoPayAmount);
			}
			//發行額
			dMap.put("ISSUE_AMOUNT",(BigDecimal)tMap.get("issue_amount"));
			
			//還本額(上期發行日期至當期發行日期間的還本數)
			//user要求F081_01的還本數為0
			if (((String)dMap.get("ISSUE_SERIAL")).equals("F081_01")){
				dMap.put("HAS_PAY",new BigDecimal(0));
			}
			else{
				Map queryMap = (Map) run.query(SQL2(myForm,lastDate,(Date) dMap.get("ISSUE_DATE")), new MapHandler());
				dMap.put("HAS_PAY",(BigDecimal)queryMap.get("capital_amount"));
			}
			
			//截至本期發行日未償餘額
			thisNoPayAmount=lastNoPayAmount.add((BigDecimal)dMap.get("ISSUE_AMOUNT")).subtract((BigDecimal)dMap.get("HAS_PAY"));
			dMap.put("EREMAIN_AMOUNT",thisNoPayAmount);
			//歲支出
			dMap.put("YEAR_TOTAL",this.getYearAmountB(connection,(String)tMap.get("year1"),new BigDecimal(1)));
			//未償/歲支出
			dMap.put("YEAR_RATE",this.divideCheck(thisNoPayAmount,(BigDecimal)dMap.get("YEAR_TOTAL")));
			if (myForm.getIssueSdate() != null && myForm.getIssueEdate() != null){
				if (!myForm.getIssueEdate().before((Date)tMap.get("issue_date"))
						&& !((Date)tMap.get("issue_date")).before(myForm.getIssueSdate())) {
					run.update(connection,insTemp("BIRA07_RPT",dMap));
				}
			}
			else
				run.update(connection,insTemp("BIRA07_RPT",dMap));
			lastNoPayAmount = thisNoPayAmount;
			lastDate = (Date)dMap.get("ISSUE_DATE");
		}
	}
}
