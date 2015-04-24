/* APRA0401.java ����
 �{���ت��GAPRA04
 �{���N���GAPRA04
 �{������G0950308
 �{���@�̡GEric.Chen
 --------------------------------------------------------
 �ק�@�̡@�@�ק����@�@�@�ק�ت�
 --------------------------------------------------------
 */
package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Apra0401Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class APRA0401 extends DefaultAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM APRA04_RPT ");
		//sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}

	protected SQLJob insTemp(ActionForm form,String usrId){
		Apra0401Form apra0401form = (Apra0401Form) form;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO APRA04_RPT ");
		sqljob.appendSQL(" ( ");
		sqljob.appendSQL(" USRID, MOD_DATE, REMARK, DUE_DATE ,DEBT_NAME ,");
		sqljob.appendSQL(" CAPITAL_SERIAL , INTEREST_SERIAL ,");
		sqljob.appendSQL(" CAPITAL_AMOUNT, INTEREST_AMOUNT, FEE_AMOUNT");
		sqljob.appendSQL(" ) ");	
		sqljob.appendSQL("SELECT '"+usrId+"', CURRENT_TIMESTAMP , null , P.REPAY_DATE , ");
		sqljob.appendSQL(" I.DEBT_NAME , P.CAPITAL_SERIAL,P.INTEREST_SERIAL, ");
		sqljob.appendSQL(" SUM(P.CAPITAL_AMOUNT) AS CAPITAL_AMOUNT , SUM(P.INTEREST_AMOUNT) AS INTEREST_AMOUNT ," );
		sqljob.appendSQL(" SUM(P.CHARGE_AMOUNT)AS CHARGE_AMOUNT ");
		sqljob.appendSQL(" FROM ISSUE_MAIN I, DEBT_MAIN D,DEBT_PLAN_DET P");
		sqljob.appendSQL(" WHERE I.ID=D.ISSUE_ID AND D.ID=P.DEBT_ID " +
				"AND D.BUDGET_CODE='2' " +
				"AND D.DEBT_CODE='5' AND I.DEBT_TYPE='A'"); //BUDGET_CODE �S�O�w��N�X2  ��q�س]����N�X 5  �n�H��Ʈw���
		
		if( null != apra0401form.getRepaySdate())
		{
			sqljob.appendSQL("AND P.REPAY_DATE>=? ");
			sqljob.addParameter(apra0401form.getRepaySdate());
		}

		if( null != apra0401form.getRepayEdate())
		{
			sqljob.appendSQL("AND P.REPAY_DATE<=? ");
			sqljob.addParameter(apra0401form.getRepayEdate());
		}
		sqljob.appendSQL("GROUP BY P.REPAY_DATE,I.DEBT_NAME,P.CAPITAL_SERIAL,P.INTEREST_SERIAL");
		sqljob.appendSQL("ORDER BY P.REPAY_DATE");
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
