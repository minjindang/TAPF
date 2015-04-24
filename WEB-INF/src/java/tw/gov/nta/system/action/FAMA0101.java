/*
 * ¦b 2006/2/22 «Ø¥ß
 */
package tw.gov.nta.system.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.system.common.CodeMainManage;
import tw.gov.nta.system.form.Fama0101Form;

/**
 * @author AndrewSung
 */
public class FAMA0101 extends DefaultAction
{

    /* (non-Javadoc)
     * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
     */
    public void executeQuery(ActionForm form, HttpServletRequest request,
            Connection connection) throws Exception
    {
    	Fama0101Form myForm = (Fama0101Form) form;
    	myForm.setKindNo(myForm.getQryKindNo());
    	myForm.setKindName(myForm.getQryKindName());
    	List collection = CodeMainManage.query(myForm.getCodeMain());
        request.setAttribute("collection",collection);
    }
}
