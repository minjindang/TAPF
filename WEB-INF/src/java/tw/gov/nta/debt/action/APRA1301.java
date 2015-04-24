/* APRA1301.java 報表
 程式目的：APRA13
 程式代號：APRA13
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

import tw.gov.nta.conversion.ConvertTRBTLNOForPAIDF;
import tw.gov.nta.debt.form.Apra1301Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class APRA1301 extends ExcelReportBaseAction {


	protected SQLJob SQL1(Apra1301Form myForm){	
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select distinct ");
		sqljob.appendSQL("B.BANK_FNAME, "); 
		sqljob.appendSQL("SUM(P.TOTAL_PCS) as TICKET_COUNT,"); 
		sqljob.appendSQL("SUM(P.TOTAL_AMT) as TOTAL_AMOUNT,"); 
		sqljob.appendSQL("B.BANK_CODE ");
		sqljob.appendSQL("from BANKF B, V_PAIDF P ");
		sqljob.appendSQL("where B.BANK_CODE = P.BANK_CODE ");
		sqljob.appendSQL("and TX_DATE>= ? ");
		sqljob.addParameter(myForm.getCloseSdate());
		sqljob.appendSQL("and TX_DATE<= ? ");
		sqljob.addParameter(myForm.getCloseEdate());
		sqljob.appendSQL("GROUP BY B.BANK_FNAME, B.BANK_CODE ");
		sqljob.appendSQL("order by B.BANK_CODE ");
		System.out.println("APRA0901-SQL1"+sqljob.toString());
		return sqljob;
	}

	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {

		Apra1301Form myForm = (Apra1301Form) form;
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delSQLJob("APRA13_RPT",usrId)); 
		//執行 insert
		ConvertTRBTLNOForPAIDF convert = new ConvertTRBTLNOForPAIDF();
		convert.setConnection(connection);
		convert.initialize();
		convert.convert();
		List queryList1 = (List) run.query(SQL1(myForm), new MapListHandler());
		Map tMap = null;
		Map dMap = new HashMap();
		for (Iterator it1 = queryList1.iterator(); it1.hasNext();){
			tMap = (Map) it1.next();
			dMap.putAll(getCommonMap(usrId));
			dMap.put("bank_id",(Integer)tMap.get("BANK_CODE"));//--銀行代號
			dMap.put("BANK_NAME",(String)tMap.get("BANK_FNAME"));//--清算銀行
			dMap.put("TICKET_COUNT",(Integer)tMap.get("TICKET_COUNT"));//--張數
			dMap.put("TOTAL_AMOUNT",new BigDecimal((Double)tMap.get("TOTAL_AMOUNT")));//--票面金額
			run.update(connection,insTemp("APRA13_RPT",dMap));
		}
	}
}
