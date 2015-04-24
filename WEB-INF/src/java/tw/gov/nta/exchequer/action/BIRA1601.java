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

import tw.gov.nta.conversion.ConvertTBBCF04;
import tw.gov.nta.exchequer.form.Bira1601Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

/**
 * @author Jack Du
 *
 * TODO �p�G�n�ܧ�o�Ӳ��ͪ����O���Ѫ��d���A�в���
 * ���� - �ߦn�]�w - Java - �{���X�˦� - �{���X�d��
 */
public class BIRA1601 extends DefaultAction{

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM BIRA16_RPT ");
		////sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}

	protected SQLJob insTemp(ActionForm form,String usrId){
		Bira1601Form myForm = (Bira1601Form) form;
		BigDecimal unit = new BigDecimal(myForm.getAmountUnit());
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO BIRA16_RPT ");
		sqljob.appendSQL(" ( ");
		sqljob.appendSQL(" USRID, MOD_DATE, REMARK,file_no");
		sqljob.appendSQL(" ,issue_serial, bond_type,back_type,account_year,issue_date,issue_amount,bid_amount,bid_rate");
		sqljob.appendSQL(" ,gotbid_amount, orgissue_amount,interest_amount,hight_rate,low_rate,average_rate,due_date,issue_days");
		sqljob.appendSQL(" ,debt_name, ahead_date");
		sqljob.appendSQL(" ) ");
		sqljob.appendSQL("Select ?,?,null,file_no");//�ɮץN��
		sqljob.appendSQL(",issue_serial");//�R�^���O
		sqljob.appendSQL(",(select code_name from code_det where kind_id = 17 and code_no = bond_type)");//�R�^����
		sqljob.appendSQL(",'' as back_type"); //�R�^�������A
		sqljob.appendSQL(",account_year");//�o��~��
		sqljob.appendSQL(",issue_date");//�o����
		sqljob.appendSQL(",issue_amount/? as issue_amount");//�o����B
		sqljob.appendSQL(",bid_amount/? as bid_amount");//�����`���B
		sqljob.appendSQL(",bid_rate/100 ");//�����Q�v
		sqljob.appendSQL(",gotbid_amount/? as gotbid_amount");//�R�^�`���B
		sqljob.appendSQL(",orgissue_amount/? as orgissue_amount");//��l����
		sqljob.appendSQL(",interest_amount/? as interest_amount");//�Q���`�B
		sqljob.appendSQL(",hight_rate/100 ");//�̰��R�^�Q�v
		sqljob.appendSQL(",low_rate/100 ");//�̧C�R�^�Q�v
		sqljob.appendSQL(",average_rate/100 ");//�[�v�����Q�v
		sqljob.appendSQL(",due_date");//�����
		sqljob.appendSQL(",issue_days");//�o��Ѵ�
		sqljob.appendSQL(",debt_name");//��w���W��
		sqljob.appendSQL(",ahead_date");//�R�^���   
		sqljob.appendSQL("From aheadpay_main");
		sqljob.addParameter(usrId);
		sqljob.addParameter(new Timestamp(new Date().getTime()));
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		if (myForm.getIssueSdate() != null && myForm.getIssueEdate() != null){
			sqljob.appendSQL("where issue_date between ? and ? ");
			sqljob.addParameter(myForm.getIssueSdate());
			sqljob.addParameter(myForm.getIssueEdate());
		}
		sqljob.appendSQL("order by issue_serial ASC");
		System.out.println("SQL1::"+sqljob.toString());
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
		ConvertTBBCF04 convert = new ConvertTBBCF04();
		convert.setConnection(connection);
		convert.initialize();
		convert.convert();
	}
}
