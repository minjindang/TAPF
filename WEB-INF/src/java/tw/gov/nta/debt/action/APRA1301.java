/* APRA1301.java ����
 �{���ت��GAPRA13
 �{���N���GAPRA13
 �{������G0950308
 �{���@�̡GEric.Chen
 --------------------------------------------------------
 �ק�@�̡@�@�ק����@�@�@�ק�ت�
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
		//���o�ϥΪ̱b��
		String usrId = this.getUserId(request);
		//���oSQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//���� delete 
		run.update(connection,delSQLJob("APRA13_RPT",usrId)); 
		//���� insert
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
			dMap.put("bank_id",(Integer)tMap.get("BANK_CODE"));//--�Ȧ�N��
			dMap.put("BANK_NAME",(String)tMap.get("BANK_FNAME"));//--�M��Ȧ�
			dMap.put("TICKET_COUNT",(Integer)tMap.get("TICKET_COUNT"));//--�i��
			dMap.put("TOTAL_AMOUNT",new BigDecimal((Double)tMap.get("TOTAL_AMOUNT")));//--�������B
			run.update(connection,insTemp("APRA13_RPT",dMap));
		}
	}
}
