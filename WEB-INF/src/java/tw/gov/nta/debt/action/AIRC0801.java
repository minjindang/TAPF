/* AIRC0801.java ����
 �{���ت��GAIRC08
 �{���N���GAIRC08
 �{������G0950308
 �{���@�̡GEric.Chen
 --------------------------------------------------------
 �ק�@�̡@�@�ק����@�@�@�ק�ت�
 --------------------------------------------------------
 */
package tw.gov.nta.debt.action;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Airc0801Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

import gov.dnt.tame.common.DefaultAction;

public class AIRC0801 extends DefaultAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM AIRC08_RPT ");
		//sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}

	protected SQLJob insTemp(ActionForm form,String usrId){
		Airc0801Form airc0801Form = (Airc0801Form) form;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO AIRC08_RPT ");
		sqljob.appendSQL(" ( ");
		sqljob.appendSQL(" USRID, MOD_DATE, REMARK, ISSUE_SERIAL, ");
		sqljob.appendSQL(" DEBT_NAME, ");
		sqljob.appendSQL(" BANK_NAME, ");
		sqljob.appendSQL(" PAY_FUND, PAY_MONTH_AMOUNT, LESS_FUND_AMOUNT ");
		sqljob.appendSQL(" ) ");
		
		sqljob.appendSQL("select '"+ usrId + "' , CURRENT_TIMESTAMP , NULL , A.issue_serial, A.debt_name, ");
		sqljob.appendSQL("C.bank_name, B.pay_fund, B.pay_month_amount, B.less_fund_amount ");
	    sqljob.appendSQL("from issue_main A, central_exchange_less_det B, Bank_ref C ");
	    sqljob.appendSQL("where A.id=B.issue_id ");
	    sqljob.appendSQL("and C.id=B.bank_id ");
	    sqljob.appendSQL("and A.debt_type='A' ");
	    sqljob.appendSQL("and A.bond_kind='4' ");
	   
		if( null != airc0801Form.getIssueSerial() && !"".equals(airc0801Form.getIssueSerial()) )
		{
			sqljob.appendSQL("and A.issue_serial=? ");
			sqljob.addParameter(airc0801Form.getIssueSerial());
		}
		if( null != airc0801Form.getLimitDate() && !"".equals(airc0801Form.getLimitDate()) )
		{
			sqljob.appendSQL("and B.term_ym=? ");
			sqljob.addParameter(airc0801Form.getLimitDate());
		}

		System.out.println(sqljob.toString());
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
	}

}
