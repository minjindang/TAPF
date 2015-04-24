/*
 * ¦b 2006/2/22 «Ø¥ß
 */
package tw.gov.nta.system.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.system.common.CodeDetManage;
import tw.gov.nta.system.form.Fama0102Form;

/**
 * @author AndrewSung
 */
public class FAMA0110 extends DefaultAction
{

    /* (non-Javadoc)
     * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
     */
    public void executeQuery(ActionForm form, HttpServletRequest request,
            Connection connection) throws Exception
    {
    	Fama0102Form myForm = (Fama0102Form) form;
    	myForm.setCodeDet(CodeDetManage.get(myForm.getId()));
    }

}
