/* AIRC1001.java 報表
 程式目的：AIRC10
 程式代號：AIRC10
 程式日期：0950309
 程式作者：Eric.Chen
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
 --------------------------------------------------------
 */
package tw.gov.nta.debt.action;

import gov.dnt.tame.common.ExcelReportRemainAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Airc1001Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class AIRC1001 extends ExcelReportRemainAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM AIRC10_RPT ");
		//sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}

//	protected SQLJob insTemp(ActionForm form,String usrId){
//		Airc1001Form airc1001Form = (Airc1001Form) form;
//		SQLJob sqljob = new SQLJob();
//		sqljob.appendSQL("INSERT INTO AIRC10_RPT ");
//		sqljob.appendSQL(" ( ");
//		sqljob.appendSQL(" USRID, MOD_DATE, REMARK, YEAR_MONTH, ");
//		sqljob.appendSQL(" DEBT_NAME, ");
//		sqljob.appendSQL(" ISSUE_AMOUNT, ");
//		sqljob.appendSQL(" BANK_ID, ");
// 		sqljob.appendSQL(" SEP_AMOUNT, CON_AMOUNT, NOSEP_AMOUNT ,SEP_LESS_AMOUNT , TOTAL_AMOUNT");
//		sqljob.appendSQL(" ) ");
//		sqljob.appendSQL("SELECT '"+usrId+"', CURRENT_TIMESTAMP , null , I.ISSUE_SERIAL,");
//		sqljob.appendSQL(" I.DEBT_NAME,");
//		sqljob.appendSQL(" I.ISSUE_AMOUNT, ");
//		sqljob.appendSQL(" (SELECT BANK_NAME FROM BANK_REF WHERE BANK_CODE=Q.ACTNO ) AS BANK_ID, " );
//		sqljob.appendSQL(" Q.AAMT AS SEP_AMOUNT, Q.BAMT AS CON_AMOUNT, Q.CAMT AS NOSEP_AMOUNT , Q.DAMT AS SEP_LESS_AMOUNT , (Q.CAMT + Q.DAMT ) AS  TOTAL_AMOUNT ");
//		sqljob.appendSQL(" FROM ISSUE_MAIN I,TRBSTR3 Q");
//		sqljob.appendSQL("WHERE I.BOND_KIND='4' AND I.ID = Q.ISSUE_ID ");
//		if( null != airc1001Form.getIssueSerial() && !"".equals(airc1001Form.getIssueSerial()) )
//		{
//			sqljob.appendSQL("AND I.ISSUE_SERIAL=?");
//			sqljob.addParameter(airc1001Form.getIssueSerial());
//		}
//		System.out.println(airc1001Form.getLimitDate());
//		if( null != airc1001Form.getLimitDate() && !"".equals(airc1001Form.getLimitDate()) )
//		{
//			sqljob.appendSQL("AND YEAR(Q.DATE) - 1911 = ? ");
//			sqljob.addParameter(airc1001Form.getLimitDate().toString().substring(0,3));
//			sqljob.appendSQL("AND MONTH(Q.DATE)= ? ");
//			sqljob.addParameter(airc1001Form.getLimitDate().toString().substring(3,5));
//		}
//		sqljob.appendSQL("ORDER BY M.BANK_ID");
//		System.out.println(sqljob.toString());
//		return sqljob;
//	}
	protected SQLJob selTemp(ActionForm form,String usrId){
		Airc1001Form airc1001Form = (Airc1001Form) form;
		SQLJob sqljob = new SQLJob();
		BigDecimal unit = new BigDecimal(airc1001Form.getAmountUnit());
		if(unit.compareTo(new BigDecimal(0))==0)
			unit = new BigDecimal(1);
		
		sqljob.appendSQL("select year_month,");
		for(int i = 1 ; i <= 20 ; i++){
			sqljob.appendSQL("sum_"+String.valueOf(i)+" / "+unit+" as sum_"+String.valueOf(i)+" ,");
			sqljob.appendSQL("percent_"+String.valueOf(i)+" as percent_"+String.valueOf(i));
			if(i != 20 )
				sqljob.appendSQL(",");
		}
		sqljob.appendSQL(" from airc10data where 1 = 1");
		if(!"".equals(airc1001Form.getLimitSDate())){
			sqljob.appendSQL(" and year_month >= ?");
			sqljob.addParameter(airc1001Form.getLimitSDate());
		}
		if(!"".equals(airc1001Form.getLimitEDate())){
			sqljob.appendSQL(" and year_month <= ?");
			sqljob.addParameter(airc1001Form.getLimitEDate());
		}
		System.out.println(sqljob.toString());
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
		@SuppressWarnings("unused")
		BigDecimal sumTotalA = new BigDecimal(0);
		BigDecimal percentTotalA = new BigDecimal(0);
		BigDecimal sumTotalB = new BigDecimal(0);
		BigDecimal percentTotalB = new BigDecimal(0);
		
		List queryList1 = (List) run.query(selTemp(form,usrId), new MapListHandler());
		for(Iterator it = queryList1.iterator();it.hasNext();){
			Map map = (Map)it.next();
			for(int i = 1 ; i <= 13 ; i++){
				sumTotalA = sumTotalA.add(new BigDecimal(map.get("sum_"+String.valueOf(i)).toString()));
				percentTotalA = percentTotalA.add(new BigDecimal(map.get("percent_"+String.valueOf(i)).toString()));
			}
			for(int i = 1 ; i <= 20 ; i++){
				sumTotalB = sumTotalB.add(new BigDecimal(map.get("sum_"+String.valueOf(i)).toString()));
				percentTotalB = percentTotalB.add(new BigDecimal(map.get("percent_"+String.valueOf(i)).toString()));
			}
			map.put("sum_TotalA", sumTotalA);
			map.put("percent_TotalA", percentTotalA);
			map.put("sum_TotalB", sumTotalB);
			map.put("percent_TotalB", percentTotalB);
			run.update(connection,insTemp("AIRC10_RPT",map));
		}
	}
}
