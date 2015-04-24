/* APRA0901.java 報表
 程式目的：APRA09
 程式代號：APRA09
 程式日期：0950308
 程式作者：Eric.Chen
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
 --------------------------------------------------------
 */
package tw.gov.nta.debt.action;

import gov.dnt.tame.common.ExcelReportBaseAction;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Apra0901Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class APRA0901 extends ExcelReportBaseAction {

	protected SQLJob SQL1(Apra0901Form myForm){	
		String cYear = "";
		String pPeriod = "";
		//算出上半年度,下半年度
		if( null != myForm.getCloseDate() && !"".equals(myForm.getCloseDate())){
			cYear = DateUtil.date2ROCStr(myForm.getCloseDate()).substring(0,3);
			int cMonth = Integer.parseInt(DateUtil.date2ROCStr(myForm.getCloseDate()).substring(3,5));
			if (cMonth<7){
				pPeriod = "1";//上半年度
			}else
				pPeriod = "2";//下半年度
		}
		
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("SELECT DISTINCT ");
		sqljob.appendSQL("p_flag,");
		sqljob.appendSQL("p_times,");
		sqljob.appendSQL("(case when p_flag='P' then p_times else 0 end) as t1,");//--本次別
		sqljob.appendSQL("(case when p_flag='I'  then p_times else 0 end) as t2,");//--息次別
		sqljob.appendSQL("SUM(I_AMT) as t3,");//--撥入基金
		sqljob.appendSQL("SUM(T_AMT) as t4,");//--累計經付數
		sqljob.appendSQL("SUM(BAL) as t5,");//--基金餘額
		sqljob.appendSQL("BOND_ID ");
		sqljob.appendSQL("FROM PAIDA WHERE 1=1 ");
		if( null != myForm.getDebtName())
		{
			sqljob.appendSQL("AND BOND_ID = ? ");
			sqljob.addParameter(myForm.getDebtName());
		}
		if( null != myForm.getCloseDate() && !"".equals(myForm.getCloseDate()))
		{
			sqljob.appendSQL("AND (P_YEAR < "+cYear+" ");
			sqljob.appendSQL("OR (P_PERIOD <="+pPeriod+" AND P_YEAR = "+cYear+" )) ");
		}
		sqljob.appendSQL("GROUP BY BOND_ID,P_FLAG, P_TIMES ");
		sqljob.appendSQL("ORDER BY BOND_ID,P_FLAG, P_TIMES ");
		System.out.println("APRA0901-SQL1"+sqljob.toString());
		return sqljob;
	}

	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		Apra0901Form myForm = (Apra0901Form) form;
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delSQLJob("APRA09_RPT",usrId)); 
		//執行 insert
		List queryList1 = (List) run.query(SQL1(myForm), new MapListHandler());
		Map tMap = null;
		Map dMap = new HashMap();
		for (Iterator it1 = queryList1.iterator(); it1.hasNext();){
			tMap = (Map) it1.next();
			dMap.putAll(getCommonMap(usrId));
			dMap.put("capital_serial",String.valueOf(tMap.get("t1")));//--本次別
			dMap.put("interest_serial",String.valueOf(tMap.get("t2")));//--息次別
			dMap.put("money1",new BigDecimal((Double)tMap.get("t3")));//--撥入基金
			dMap.put("money2",new BigDecimal((Double)tMap.get("t4")));//--累計經付數
			dMap.put("issue_amount",new BigDecimal((Double)tMap.get("t5")));//--基金餘額
			run.update(connection,insTemp("APRA09_RPT",dMap));
		}
	}
}
