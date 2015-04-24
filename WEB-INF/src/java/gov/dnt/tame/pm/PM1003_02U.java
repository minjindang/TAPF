/*
 * 在 2005/5/2 建立
 *
 * TODO 如果要變更這個產生的檔案的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
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
 * TODO 如果要變更這個產生的類別註解的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
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
