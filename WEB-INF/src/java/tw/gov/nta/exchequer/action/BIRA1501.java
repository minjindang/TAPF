/*
 * �b 2006/2/27 �إ�
 *
 * TODO �p�G�n�ܧ�o�Ӳ��ͪ��ɮת��d���A�в���
 * ���� - �ߦn�]�w - Java - �{���X�˦� - �{���X�d��
 */
package tw.gov.nta.exchequer.action;

import gov.dnt.tame.common.DefaultAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.conversion.ConvertTBBCF03;
import tw.gov.nta.exchequer.form.Bira1501Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

/**
 * @author Jack Du
 *
 * TODO �p�G�n�ܧ�o�Ӳ��ͪ����O���Ѫ��d���A�в���
 * ���� - �ߦn�]�w - Java - �{���X�˦� - �{���X�d��
 */
public class BIRA1501 extends DefaultAction{
	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM BIRA15_RPT ");
		////sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}

	protected SQLJob insTemp(ActionForm form,String usrId){
		Bira1501Form myForm = (Bira1501Form) form;
		BigDecimal unit = new BigDecimal(myForm.getAmountUnit());
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO BIRA15_RPT ");
		sqljob.appendSQL("select ?,?,null,B.ISSUE_SERIAL, (select bank_no from central_bank_ref C where C.id=B.UNIT_CODE) as unit_name,B.gotbid_rate,B.BID_AMOUNT/?,B.GOTBID_AMOUNT/?,B.IS_USE,");
		sqljob.appendSQL("B.ISSUE_PRICE/?,B.PRICE_10000,B.PRICE_1000,B.PRICE_500,B.PRICE_100,B.PRICE_50 ");
		sqljob.appendSQL("from issue_main A,central_issue_det B ");
		sqljob.appendSQL("where B.issue_id=a.id ");
		sqljob.addParameter(usrId);
		sqljob.addParameter(new Timestamp(new Date().getTime()));
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		if (!"".equals(myForm.getAccountSYear()) ){
			sqljob.appendSQL("and A.account_year >= ? ");
			sqljob.addParameter(myForm.getAccountSYear());
		}
		if (!"".equals(myForm.getAccountEYear())){
			sqljob.appendSQL("and A.account_year <= ?  ");
			sqljob.addParameter(myForm.getAccountEYear());
		}
		if (0 != myForm.getIssueId()){
			sqljob.appendSQL("and A.id = ? ");
			sqljob.addParameter(myForm.getIssueId());
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
		ConvertTBBCF03 convert = new ConvertTBBCF03();
		convert.setConnection(connection);
		convert.initialize();
		convert.convert();
		run.update(connection,insTemp(form,usrId));
	}
}
