package gov.dnt.tame.pm;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
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
public class PM1003_01Q extends DefaultAction {

	protected SQLJob selectJob(HttpServletRequest request)
	{
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("SELECT A1.*, A1.NAME NAME, A1.DEPT DEPT, A2.NAME GNAME");
		sqljob.appendSQL("FROM pm0005_db A1, pm0004_db A2 ");
		sqljob.appendSQL("WHERE A1.PM0004ID = A2.ID AND A1.ID=?");
		sqljob.addParameter(new Integer(request.getParameter("GCODE"))); 
		return sqljob;
	}
	
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		SQLRunner run = new ConnectionSQLRunner(connection);
		MapListHandler mlh = new MapListHandler();
		SQLJob queryJob = selectJob(request);
		List queryList = (List) run.query(queryJob, mlh);
		request.setAttribute("queryList", queryList);		
	}

}
