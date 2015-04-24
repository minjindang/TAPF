package tw.gov.nta.central.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.Messages;
import java.sql.Connection;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.central.common.LawPercent101;
import tw.gov.nta.central.form.Hama0501Form;
/**
 * @author Powen Hsueh
 *
 * TODO �p�G�n�ܧ�o�Ӳ��ͪ����O���Ѫ��d���A�в���
 * ���� - �ߦn�]�w - Java - �{���X�˦� - �{���X�d��
 */
public class HAMA0501 extends DefaultAction{
	/* (non-Javadoc)
	 * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
	 */
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Hama0501Form hama0501form = (Hama0501Form) form;
		hama0501form.setModDate( new Date() );
		hama0501form.setUsrid( this.getUserId(request) );
		LawPercent101.update(hama0501form.getLawPercentRef101());
		setAlertMessage(request,Messages.SUCCESS_MODIFY);
	}
}
