/*
 * 在 2006/2/22 建立
 */
package tw.gov.nta.system.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.system.common.CentralStatisticsManager;
import tw.gov.nta.system.form.Gama0301Form;

/**
 * @author AndrewSung
 */
public class GAMA0307 extends DefaultAction
{

    /* (non-Javadoc)
     * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
     */
    public void executeQuery(ActionForm form, HttpServletRequest request,
            Connection connection) throws Exception
    {
    	Gama0301Form myForm = (Gama0301Form) form;
    	CentralStatisticsManager.create(myForm.getCsMain());
    	setAlertMessage(request,"新增成功");
    }

}
