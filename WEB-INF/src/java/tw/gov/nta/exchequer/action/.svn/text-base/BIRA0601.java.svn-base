/* BIRA0601.java 報表
 程式目的：BIRA0601
 程式代號：BIRA0601
 程式日期：0950717
 程式作者：Avery
 ////////////////////////////////////////////////////////
 修改作者　　修改日期　　　修改目的
 ////////////////////////////////////////////////////////
 */
package tw.gov.nta.exchequer.action;

import gov.dnt.tame.common.ExcelReportRemainAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.exchequer.form.Bira0601Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class BIRA0601 extends ExcelReportRemainAction {
	
	protected SQLJob SQL1(Bira0601Form myForm)
	{
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select Right('000'+convert(varchar(3),  ");
		sqljob.appendSQL("case when year(B.date1) < 2000 and month(B.date1) > 6 ");
		sqljob.appendSQL("then  year(B.date1)+1 ");
		sqljob.appendSQL("else  year(B.date1) ");
		sqljob.appendSQL("end-1911),3) as year1,");
		sqljob.appendSQL("sum(case when (kind = '1') and A.debt_type='B' then isnull(A_total,0) else 0 end) as issue_total_B,");//國庫券發行數
		sqljob.appendSQL("sum(case when (kind = '2') and A.debt_type='B' then isnull(A_total,0) else 0 end) as capital_total_B ");//國庫券還本數
		sqljob.appendSQL("from issue_main A,v_debtT B ");
		sqljob.appendSQL("where A.issue_serial = B.issue_serial ");
		sqljob.appendSQL("and B.date1 <= '"+new Timestamp(new Date().getTime())+"' ");
		if (!"".equals(myForm.getBudgetCode())){
			sqljob.appendSQL("and budget_code = ? ");
			sqljob.addParameter(myForm.getBudgetCode());
		}
		if (!"".equals(myForm.getDebtCode())){
			sqljob.appendSQL("and debt_code = ? ");
			sqljob.addParameter(myForm.getDebtCode());
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
		System.out.println("BIRA0601-SQL1:"+sqljob);
		return sqljob;
	}
	
	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Bira0601Form myForm = (Bira0601Form) form;
		
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delSQLJob("BIRA06_RPT",usrId));
		//執行 insert
		List queryList1 = (List) run.query(SQL1(myForm), new MapListHandler());
		Map tMap = null;
		Map dMap = new HashMap();
		//年底未償餘額
		BigDecimal thisNoPayAmount = new BigDecimal(0);
		//年初未償餘額
		BigDecimal lastNoPayAmount = new BigDecimal(0);
		for(Iterator tIterator = queryList1.iterator(); tIterator.hasNext(); )
		{
			tMap = (Map) tIterator.next();
			dMap.putAll(getCommonMap(usrId));
			//年度
			dMap.put("account_year",tMap.get("year1"));
			//當年發行額
			dMap.put("issue_total",(BigDecimal)tMap.get("issue_total_B"));
			//當年還本金
			dMap.put("capital_total",(BigDecimal)tMap.get("capital_total_B"));
			//當年歲(支)出
			dMap.put("real_amount",this.getYearAmountB(connection,(String)dMap.get("account_year"),new BigDecimal(1)));
			//年初未償餘額(年初未償餘額=前一年年底未償餘額)
			dMap.put("syear_notpay",lastNoPayAmount);
			//年底未償餘額(前一年未償餘額+發行總數-總還本數)
			thisNoPayAmount= lastNoPayAmount.add((BigDecimal)dMap.get("issue_total")).subtract((BigDecimal)dMap.get("capital_total"));
			dMap.put("eyear_notpay",thisNoPayAmount);
			//未償餘額/歲(支)出
			dMap.put("real_rate1",this.divideCheck(thisNoPayAmount,(BigDecimal)dMap.get("real_amount")));
			if (!"".equals(myForm.getAccountSYear()) && !"".equals(myForm.getAccountEYear())){
				if (Integer.parseInt(myForm.getAccountSYear()) <= Integer.parseInt((String)dMap.get("account_year")) 
						&& Integer.parseInt(myForm.getAccountEYear()) >= Integer.parseInt((String)dMap.get("account_year"))){
					run.update(connection,insTemp("BIRA06_RPT",dMap));
				}
			}
			else
				run.update(connection,insTemp("BIRA06_RPT",dMap));
			lastNoPayAmount = thisNoPayAmount;
		}
	}
}
