/*
 * 在 2006/2/22 建立
 */
package tw.gov.nta.system.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.system.common.CodeMainManage;
import tw.gov.nta.system.form.Fama0101Form;

/**
 * @author AndrewSung
 */
public class FAMA0108 extends DefaultAction
{

    /* (non-Javadoc)
     * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
     */
    public void executeQuery(ActionForm form, HttpServletRequest request,
            Connection connection) throws Exception
    {
    	Fama0101Form myForm = (Fama0101Form) form;
    	myForm.setUsrid(this.getUserId(request));
    	myForm.setModDate(new Date());
    	CodeMainManage.update(myForm.getId(),myForm.getCodeMain());
    	setAlertMessage(request,"更新成功");
    	
    }

}
