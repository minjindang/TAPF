/*
 * �b 2005/5/2 �إ�
 *
 * TODO �p�G�n�ܧ�o�Ӳ��ͪ��ɮת��d���A�в���
 * ���� - �ߦn�]�w - Java - �{���X�˦� - �{���X�d��
 */
package gov.dnt.tame.pm;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.Messages;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

/**
 * @author JACK DU
 *
 * TODO �p�G�n�ܧ�o�Ӳ��ͪ����O���Ѫ��d���A�в���
 * ���� - �ߦn�]�w - Java - �{���X�˦� - �{���X�d��
 */
public class PM1003_02U extends DefaultAction {

	protected SQLJob updSQLJob(HttpServletRequest request){
        SQLJob sqljob = new SQLJob();
        sqljob.appendSQL(" UPDATE PM0005_DB SET ");
        sqljob.appendSQL(" PM0004ID=? ");
        sqljob.appendSQL(" WHERE ID=?");
        sqljob.addParameter(new Integer(request.getParameter("PM0004ID")));
        sqljob.addParameter(new Integer(request.getParameter("GCODE")));
        return sqljob;
    }

	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		SQLRunner run = new ConnectionSQLRunner(connection);
        SQLJob updJob = updSQLJob(request);
        run.update(connection,updJob);
        setAlertMessage(request,Messages.SUCCESS_MODIFY);
	}

}
