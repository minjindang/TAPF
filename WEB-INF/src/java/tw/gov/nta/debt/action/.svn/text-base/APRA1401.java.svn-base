/* APRA401.java 報表
 程式目的：APRA14
 程式代號：APRA14
 程式日期：0950308
 程式作者：Eric.Chen
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
 --------------------------------------------------------
 */
package tw.gov.nta.debt.action;

import gov.dnt.tame.common.ExcelReportBaseAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Apra1401Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class APRA1401 extends ExcelReportBaseAction {

	private final static String TEMP_TABLE_NAME = "APRA14_RPT";
	
	protected SQLJob SQL1(Apra1401Form myForm){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select (select X.debt_name from issue_main X where X.id=D.issue_id) as debt_name,");
		sqljob.appendSQL("P.PCS100T,");
		sqljob.appendSQL("P.PCS500T,"); 
		sqljob.appendSQL("P.PCS1M,"); 
		sqljob.appendSQL("P.PCS5M,"); 
		sqljob.appendSQL("P.TOTAL_PCS,"); 
		sqljob.appendSQL("P.TOTAL_AMT,");
		sqljob.appendSQL("convert(varchar,MIN(P.INT_TIMES))+'-'+(select convert(varchar,Y.interest_alternate) from issue_main Y where Y.id=D.issue_id)+'息' as INT_TIMES,");
		sqljob.appendSQL("D.remark,");
		sqljob.appendSQL("P.bond_code,");
		sqljob.appendSQL("P.bond_period,");
		sqljob.appendSQL("B.BANK_FNAME,"); 
		sqljob.appendSQL("B.BANK_CODE ");
		sqljob.appendSQL("from DEBT_MAIN D,v_PAIDF P, BANKF B "); 
		sqljob.appendSQL("WHERE ");
		sqljob.appendSQL("P.TX_DATE>=? ");
		sqljob.addParameter(myForm.getCloseSdate());
		sqljob.appendSQL("and P.TX_DATE<=? ");
		sqljob.addParameter(myForm.getCloseEdate());
		sqljob.appendSQL("and B.BANK_CODE = ? ");
		sqljob.addParameter(myForm.getBankName());
		sqljob.appendSQL("and (convert(varchar,P.bond_code) "); 
		sqljob.appendSQL("+( case when Len(convert(varchar,P.bond_period)) < 2 then '0'+convert(varchar,P.bond_period) else convert(varchar,P.bond_period) end ) ");
		sqljob.appendSQL("+(case P.bond_mark when '甲' then '01' when '乙' then '02' else '' end ))=D.remark ");

		sqljob.appendSQL("and B.BANK_CODE=P.BANK_CODE ");
		sqljob.appendSQL("group by D.issue_id,D.remark,P.PCS100T, P.PCS500T, P.PCS1M, P.PCS5M, P.TOTAL_PCS, P.TOTAL_AMT,B.BANK_FNAME , B.BANK_CODE,P.bond_code,P.bond_period ");
		sqljob.appendSQL("order by P.bond_code,P.bond_period ");
		System.out.println("APRA14-SQL1"+sqljob.toString());
		return sqljob;
	}
	
	
	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request, 
			Connection connection) throws Exception 
	{
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update( connection, delSQLJob(TEMP_TABLE_NAME,usrId) );
		
		Apra1401Form myForm = (Apra1401Form)form;
		//執行 insert
		List queryList = (List) run.query(SQL1(myForm), new MapListHandler());
		
		Map tMap = null;
		Map dMap = new HashMap();
		for (Iterator it1=queryList.iterator(); it1.hasNext();){
			tMap = (Map)it1.next();
			dMap.putAll(getCommonMap(usrId));
			dMap.put("DEBT_NAME",(String)tMap.get("debt_name"));
			dMap.put("HUNDRED_THOUSAND_COUNT",new BigDecimal((Integer)tMap.get("PCS100T")));
			dMap.put("FIVE_HUNDRED_THOUSAND_COUNT",new BigDecimal((Integer)tMap.get("PCS500T")));
			dMap.put("MILLION_COUNT",new BigDecimal((Integer)tMap.get("PCS1M")));
			dMap.put("FIVE_MILLION_COUNT",new BigDecimal((Integer)tMap.get("PCS5M")));
			dMap.put("TICKET_COUNT",new BigDecimal((Integer)tMap.get("TOTAL_PCS")));
			dMap.put("TOTAL_AMOUNT",new BigDecimal((Double)tMap.get("TOTAL_AMT")));
			dMap.put("ATTACH_SERIAL",(String)tMap.get("INT_TIMES"));
			run.update(connection,insTemp(TEMP_TABLE_NAME,dMap));
			request.setAttribute("bankCName",(String)tMap.get("BANK_FNAME"));
		}
	}
	
	
}
