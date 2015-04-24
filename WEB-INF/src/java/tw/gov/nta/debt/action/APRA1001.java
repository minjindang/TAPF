/* APRA1001.java 報表
 程式目的：APRA10
 程式代號：APRA10
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

import tw.gov.nta.debt.form.Apra1001Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class APRA1001 extends ExcelReportBaseAction {

	protected SQLJob SQL1(Apra1001Form myForm){	
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
		sqljob.appendSQL("select ");
		sqljob.appendSQL("P.P_FLAG,");
		sqljob.appendSQL("P.P_TIMES,");
		sqljob.appendSQL("(case when P.P_FLAG='P' then P.P_TIMES else 0 end) as t1,");//--本次別
		sqljob.appendSQL("(case when P.P_FLAG='I'  then P.P_TIMES else 0 end) as t2,");//--息次別
		sqljob.appendSQL("SUM(P.I_AMT) as t3,");//--撥入基金
		sqljob.appendSQL("SUM(P.T_AMT) as t4,");//--累計經付數
		sqljob.appendSQL("SUM(P.BAL) as t5,");//--基金餘額
		sqljob.appendSQL("P.BOND_ID,");
		sqljob.appendSQL("P.BANK_CODE,");
		sqljob.appendSQL("B.BANK_FNAME ");
		sqljob.appendSQL("from PAIDA P, BANKF B WHERE B.BANK_CODE=P.BANK_CODE ");
		if( null != myForm.getDebtName())
		{
			sqljob.appendSQL("AND P.BOND_ID = ? ");
			sqljob.addParameter(myForm.getDebtName());
		}
		if( null != myForm.getBankId())
		{
			sqljob.appendSQL("AND B.BANK_CODE = ? ");
			sqljob.addParameter(myForm.getBankId());
		}
		if( null != myForm.getCloseDate() && !"".equals(myForm.getCloseDate()))
		{
			sqljob.appendSQL("AND (P.P_YEAR < "+cYear+" ");
			sqljob.appendSQL("OR (P.P_PERIOD <="+pPeriod+" AND P.P_YEAR = "+cYear+" )) ");
		}
		sqljob.appendSQL("GROUP BY P.BOND_ID,P.P_FLAG, P.P_TIMES, BOND_ID,P.BANK_CODE,B.BANK_FNAME ");
		sqljob.appendSQL("ORDER BY BOND_ID,P_FLAG, P_TIMES ");
		System.out.println("APRA01001-SQL1"+sqljob.toString());
		return sqljob;
	}
	
	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		Apra1001Form myForm = (Apra1001Form) form;
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delSQLJob("APRA10_RPT",usrId)); 
		//執行 insert
		List queryList1 = (List) run.query(SQL1(myForm), new MapListHandler());
		Map tMap = null;
		Map dMap = new HashMap();
		for (Iterator it1 = queryList1.iterator(); it1.hasNext();){
			tMap = (Map) it1.next();
			dMap.putAll(getCommonMap(usrId));
			dMap.put("CAPITAL_SERIAL",String.valueOf(tMap.get("t1")));//--本次別
			dMap.put("INTEREST_SERIAL",String.valueOf(tMap.get("t2")));//--息次別
			dMap.put("PAYFUND_AMOUNT",new BigDecimal((Double)tMap.get("t3")));//--撥入基金
			dMap.put("PAYBANK_AMOUNT",new BigDecimal((Double)tMap.get("t4")));//--累計經付數
			dMap.put("PAYLESS_AMOUNT",new BigDecimal((Double)tMap.get("t5")));//--基金餘額
			run.update(connection,insTemp("APRA10_RPT",dMap));
		}
	}
}
