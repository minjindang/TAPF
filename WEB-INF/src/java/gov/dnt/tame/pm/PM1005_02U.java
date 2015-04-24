package gov.dnt.tame.pm;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.Messages;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class PM1005_02U extends DefaultAction {

    protected SQLJob getDeleteSypermission(ActionForm form)
    {
        RoleToFunForm roleToFunForm = (RoleToFunForm) form;
        SQLJob sqljob = new SQLJob("");
        sqljob.appendSQL("delete from PM0006_DB ");
        sqljob.appendSQL("where PM0004ID = ? ");
        sqljob.addParameter(new Integer(roleToFunForm.getRoleid().trim()));
        return sqljob;
    }

    protected SQLJob getMultipleAddSyPermissionSQL(HttpServletRequest request,
            ActionForm form, int programid)
    {
        RoleToFunForm roleToFunForm = (RoleToFunForm) form;
        SQLJob sqljob = new SQLJob();
        sqljob.appendSQL("insert into PM0006_DB (PM0004ID, PM0003ID, USER_ID, MOD_DATE) ");
        sqljob.appendSQL("values(?,?,?,?)");
        sqljob.addParameter(new Integer(roleToFunForm.getRoleid().trim()));
        sqljob.addParameter(new Integer(programid));
        sqljob.addParameter(this.getUserId(request));
        sqljob.addParameter(DateUtil.getSystemDate());
        return sqljob;
    }

	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
        SQLRunner run = new ConnectionSQLRunner(connection);

        RoleToFunForm roleToFunForm = (RoleToFunForm) form;

        SQLJob delSyPermissionJob = this.getDeleteSypermission(form);
        run.update(delSyPermissionJob);
        
        String items[] = roleToFunForm.getItems();
        for (int i = 0; i < items.length; ++i)
        {
        	String[] item = items[i].split("-");
        	String parentId = item[0];
        	if("2".equals(parentId))
        	{
                SQLJob multipleAddSyPermissionJob = this.getMultipleAddSyPermissionSQL(request, form, Integer.parseInt(item[1]));
                run.update(multipleAddSyPermissionJob);
        	}
        }
        request.setAttribute("insert_success", Messages.SUCCESS_ADD);
	}
}
