package gov.dnt.tame.pm;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.struts.action.ActionForm;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;
import com.kangdainfo.ast.webmenu.permission.IdArrayPermissionAdaptor;

public class PM1005_01Q extends DefaultAction {

	protected SQLJob getSyUserToRoleSQL(ActionForm form)
	{
		RoleToFunForm roleToFunForm = (RoleToFunForm)form;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("SELECT '0-'+CONVERT(varchar,PM0001_DB.ID) as ID FROM PM0001_DB ");
		sqljob.appendSQL(" WHERE ID IN ( SELECT PM0002_DB.ID FROM PM0002_DB ");
		sqljob.appendSQL(" WHERE ID IN (select PM0002ID from PM0003_DB ");
		sqljob.appendSQL(" WHERE ID IN (select PM0006_DB.PM0003ID from PM0006_DB, PM0004_DB ");
		sqljob.appendSQL(" WHERE PM0006_DB.PM0004ID=PM0004_DB.ID and PM0004_DB.ID=?) ");
		sqljob.appendSQL(" )) UNION ");
		sqljob.appendSQL(" SELECT '1-'+CONVERT(varchar,PM0002_DB.ID) as ID FROM PM0002_DB ");
		sqljob.appendSQL(" WHERE ID IN (SELECT PM0002ID FROM PM0003_DB ");
		sqljob.appendSQL(" WHERE ID IN (select PM0006_DB.PM0003ID from PM0006_DB, PM0004_DB ");
		sqljob.appendSQL(" WHERE PM0006_DB.PM0004ID=PM0004_DB.ID and PM0004_DB.ID=?) ");
		sqljob.appendSQL(" ) UNION ");
		sqljob.appendSQL(" SELECT '2-'+CONVERT(varchar,PM0006_DB.PM0003ID) as ID FROM PM0006_DB, PM0004_DB ");
		sqljob.appendSQL(" WHERE PM0006_DB.PM0004ID=PM0004_DB.ID and PM0004_DB.ID=? ");
		sqljob.appendSQL(" ORDER by ID ");
		sqljob.addParameter(new Integer(roleToFunForm.getRoleid().trim()));
		sqljob.addParameter(new Integer(roleToFunForm.getRoleid().trim()));
		sqljob.addParameter(new Integer(roleToFunForm.getRoleid().trim()));
		//System.out.println(sqljob.toString());
		return sqljob;
	}

	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		SQLRunner run = new ConnectionSQLRunner(connection);
		
        SQLJob syPermissionJob = this.getSyUserToRoleSQL(form);
        List syPermissionList = (List) run.query(syPermissionJob, new ArrayListHandler());

		String[] syPermissions = new String[syPermissionList.size()];

		for (int i=0; i<syPermissionList.size();i++ )
		{
			Object[] objects = (Object[])syPermissionList.get(i);
			for (int j=0; j<objects.length;j++ )
			{
				syPermissions[i] = String.valueOf(objects[j]);
				//System.out.println(syPermissions[i]);
			}
		}

		IdArrayPermissionAdaptor permissions = new IdArrayPermissionAdaptor( syPermissions );

		request.setAttribute("permissions", permissions);
		request.setAttribute("syPermissionList", syPermissionList);
	}
}
