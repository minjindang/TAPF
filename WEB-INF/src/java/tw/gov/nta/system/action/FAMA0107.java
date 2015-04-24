/*
 * ¦b 2006/2/22 «Ø¥ß
 */
package tw.gov.nta.system.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.system.common.CodeDetManage;
import tw.gov.nta.system.common.CodeMainManage;
import tw.gov.nta.system.form.Fama0101Form;
import tw.gov.nta.system.form.Fama0102Form;

/**
 * @author AndrewSung
 */
public class FAMA0107 extends DefaultAction
{

    /* (non-Javadoc)
     * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
     */
    public void executeQuery(ActionForm form, HttpServletRequest request,
            Connection connection) throws Exception
    {
    	Fama0101Form myForm = (Fama0101Form) form;
    	Fama0102Form gama0102Form = new Fama0102Form ();
    	if (myForm.getKindId() != 0)
    		myForm.setId(myForm.getKindId());
    	gama0102Form.setKind(myForm.getCodeMain());
    	List collection = CodeDetManage.query(gama0102Form.getCodeDet());
        request.setAttribute("collection",collection);
        if ((null != gama0102Form.getKind().getId()) && (!"".equals(gama0102Form.getKind().getId())))
        	myForm.setCodeMain(CodeMainManage.get((gama0102Form.getKind()).getId())) ;
    }

}
