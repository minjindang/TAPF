/*
 * �b 2006/2/27 �إ�
 *
 * TODO �p�G�n�ܧ�o�Ӳ��ͪ��ɮת��d���A�в���
 * ���� - �ߦn�]�w - Java - �{���X�˦� - �{���X�d��
 */
package tw.gov.nta.exchequer.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.conversion.ConvertTBBCF01;
import tw.gov.nta.conversion.ConvertTBBCF02;
import tw.gov.nta.exchequer.form.Bira1301Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

/**
 * @author Jack Du
 *
 * TODO �p�G�n�ܧ�o�Ӳ��ͪ����O���Ѫ��d���A�в���
 * ���� - �ߦn�]�w - Java - �{���X�˦� - �{���X�d��
 */
public class BIRA1301 extends DefaultAction{
	protected Date today=new Date();
	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM BIRA13_RPT ");
		////sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}

	protected SQLJob insTemp(ActionForm form,String usrId){
		Bira1301Form myForm = (Bira1301Form) form;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO BIRA13_RPT ");
		sqljob.appendSQL("select ?,?,null,bank_no,bank_name,bank_type,free_unit ");
		sqljob.appendSQL("from central_bank_ref ");
		sqljob.appendSQL("where 1=1 ");
		sqljob.addParameter(usrId);
		sqljob.addParameter(today);
		if(!"".equals(myForm.getBandNo())){
			sqljob.appendSQL("and bank_no = ? ");
			sqljob.addParameter(myForm.getBandNo());
		}
		if(!"".equals(myForm.getBankName())){
			sqljob.appendSQL("and bank_name like '%'+?+'%' ");
			sqljob.addParameter(myForm.getBankName());
		}
		sqljob.appendSQL("and bank_name not like '%�Ш|%' and bank_name not like '%����%'");
		sqljob.appendSQL("order by bank_no ");
//		sqljob.appendSQL("INSERT INTO BIRA13_RPT ");
//		sqljob.appendSQL("select ?,?,null,B1ACCT,B1NME1,B1PND,B1FLAG ");
//		sqljob.appendSQL("from TB0001 ");
//		sqljob.appendSQL("where 1=1 ");
//		if(!"".equals(myForm.getBandNo())){
//			sqljob.appendSQL("and B1ACCT = ? ");
//			sqljob.addParameter(myForm.getBandNo());
//		}
//		if(!"".equals(myForm.getBankName())){
//			sqljob.appendSQL("and B1NME1 like '%'+?+'%' ");
//			sqljob.addParameter(myForm.getBankName());
//		}
//		sqljob.appendSQL("order by B1ACCT ");
//		sqljob.addParameter(usrId);
//		sqljob.addParameter(today);
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
		ConvertTBBCF01 convert = new ConvertTBBCF01();
		convert.setConnection(connection);
		convert.initialize();
		convert.convert();
		//���� insert
		run.update(connection,insTemp(form,usrId));
		
	}
}
