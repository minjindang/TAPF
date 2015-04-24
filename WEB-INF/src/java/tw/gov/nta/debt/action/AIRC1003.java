/* AIRC1001.java ����
 �{���ت��GAIRC10
 �{���N���GAIRC10
 �{������G0950309
 �{���@�̡GEric.Chen
 --------------------------------------------------------
 �ק�@�̡@�@�ק����@�@�@�ק�ت�
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

import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Airc1001Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class AIRC1003 extends ExcelReportRemainAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM AIRC10_RPT ");
		//sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		return sqljob;
	}

	protected SQLJob insTemp(ActionForm form,String usrId){
		Airc1001Form airc1001Form = (Airc1001Form) form;
		String SYYYMM = airc1001Form.getLimitSDate();
		String EYYYMM = airc1001Form.getLimitEDate();
		String kind = airc1001Form.getKind();
		
		SQLJob sqljob = new SQLJob();
		
		sqljob.appendSQL("insert into AIRC10_RPT (year_month,sum_1,sum_2,sum_3,sum_4,sum_5,sum_6,sum_7,sum_8,sum_9,sum_10) ");
		sqljob.appendSQL("select YYYMM,sum(AMT1) as AMT1, ");
		sqljob.appendSQL("sum(AMT2) as AMT2,  ");
		sqljob.appendSQL("sum(AMT3) as AMT3,  ");
		sqljob.appendSQL("sum(AMT4) as AMT4,  ");
		sqljob.appendSQL("sum(AMT5) as AMT5,  ");
		sqljob.appendSQL("sum(AMT6) as AMT6,  ");
		sqljob.appendSQL("sum(AMT7) as AMT7,  ");
		sqljob.appendSQL("sum(AMT9) as AMT8,  ");
		sqljob.appendSQL("sum(AMT8 +AMT10) as AMT9, "); 
		sqljob.appendSQL("sum(AMT11) as AMT10  ");
		sqljob.appendSQL("From TRBST04 ");
		sqljob.appendSQL("where  YYYMM >= ? ");
		sqljob.addParameter(SYYYMM);
		sqljob.appendSQL("AND YYYMM <= ? ");
		sqljob.addParameter(EYYYMM);
		//����������A
		if(kind != null && "A".equals(kind))
			sqljob.appendSQL("AND substring(BONDID,1,1) not in ('T','Z')  ");
		//��������w��B
		if(kind != null && "B".equals(kind))
			sqljob.appendSQL("AND substring(BONDID,1,1) ='T'  ");
		sqljob.appendSQL("GROUP BY YYYMM; ");
		
		return sqljob;
	}
	protected SQLJob selTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select year_month,sum_1/1000 as sum_1,sum_2/1000 as sum_2,sum_3/1000 as sum_3,sum_4/1000 as sum_4,sum_5/1000 as sum_5," +
				"sum_6/1000 as sum_6,sum_7/1000 as sum_7,sum_8/1000 as sum_8,sum_9/1000 as sum_9,sum_10/1000 as sum_10  from AIRC10_RPT order by id desc");
		return sqljob;
	}
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {

		//���o�ϥΪ̱b��
		String usrId = this.getUserId(request);
		//���oSQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//���� delete 
		run.update(connection,delTemp(form,usrId));
		//���� insert
		run.update(connection,insTemp(form,usrId));
		
		//�d�X��ƶǨ�C�L�����{��
		List dataList = (List)run.query(connection,selTemp(form,usrId),new MapListHandler());
		request.setAttribute("dataList",dataList);
	}
}
