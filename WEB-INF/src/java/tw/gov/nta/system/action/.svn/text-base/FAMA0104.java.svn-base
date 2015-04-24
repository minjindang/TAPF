/*
 * 在 2006/2/22 建立
 */
package tw.gov.nta.system.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import tw.gov.nta.system.common.CodeMainManage;
import tw.gov.nta.system.form.Fama0101Form;

/**
 * @author AndrewSung
 */
public class FAMA0104 extends DefaultAction
{
	public ActionForward executeQuery(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, Connection connection) throws Exception
	{
		Fama0101Form myForm = (Fama0101Form) form;
		myForm.setCreateDate(new Date());
    	myForm.setModDate(new Date());
    	myForm.setUsrid(this.getUserId(request));
    	if(CodeMainManage.isModify(myForm.getCodeMain()))
    	{
    		 CodeMainManage.create(myForm.getCodeMain());
    		 setAlertMessage(request,"新增成功");
    		 return mapping.findForward("success");
    	}
    	else
    	{
    		myForm.setId(null);
    		myForm.setKindNo(null);
    		setAlertMessage(request,"新增失敗:類別代碼重複");
   		 	return mapping.findForward("fail");
    	}
		
	}
    /* (non-Javadoc)
     * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
     */
    public void executeQuery(ActionForm form, HttpServletRequest request,
            Connection connection) throws Exception
    {

    }
}
