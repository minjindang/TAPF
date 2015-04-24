/* APRA0901.java ����
 �{���ت��GAPRA09
 �{���N���GAPRA09
 �{������G0950308
 �{���@�̡GEric.Chen
 --------------------------------------------------------
 �ק�@�̡@�@�ק����@�@�@�ק�ت�
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
		//��X�W�b�~��,�U�b�~��
		if( null != myForm.getCloseDate() && !"".equals(myForm.getCloseDate())){
			cYear = DateUtil.date2ROCStr(myForm.getCloseDate()).substring(0,3);
			int cMonth = Integer.parseInt(DateUtil.date2ROCStr(myForm.getCloseDate()).substring(3,5));
			if (cMonth<7){
				pPeriod = "1";//�W�b�~��
			}else
				pPeriod = "2";//�U�b�~��
		}
		
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("SELECT DISTINCT ");
		sqljob.appendSQL("p_flag,");
		sqljob.appendSQL("p_times,");
		sqljob.appendSQL("(case when p_flag='P' then p_times else 0 end) as t1,");//--�����O
		sqljob.appendSQL("(case when p_flag='I'  then p_times else 0 end) as t2,");//--�����O
		sqljob.appendSQL("SUM(I_AMT) as t3,");//--���J���
		sqljob.appendSQL("SUM(T_AMT) as t4,");//--�֭p�g�I��
		sqljob.appendSQL("SUM(BAL) as t5,");//--����l�B
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
		//���o�ϥΪ̱b��
		String usrId = this.getUserId(request);
		//���oSQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//���� delete 
		run.update(connection,delSQLJob("APRA09_RPT",usrId)); 
		//���� insert
		List queryList1 = (List) run.query(SQL1(myForm), new MapListHandler());
		Map tMap = null;
		Map dMap = new HashMap();
		for (Iterator it1 = queryList1.iterator(); it1.hasNext();){
			tMap = (Map) it1.next();
			dMap.putAll(getCommonMap(usrId));
			dMap.put("capital_serial",String.valueOf(tMap.get("t1")));//--�����O
			dMap.put("interest_serial",String.valueOf(tMap.get("t2")));//--�����O
			dMap.put("money1",new BigDecimal((Double)tMap.get("t3")));//--���J���
			dMap.put("money2",new BigDecimal((Double)tMap.get("t4")));//--�֭p�g�I��
			dMap.put("issue_amount",new BigDecimal((Double)tMap.get("t5")));//--����l�B
			run.update(connection,insTemp("APRA09_RPT",dMap));
		}
	}
}
