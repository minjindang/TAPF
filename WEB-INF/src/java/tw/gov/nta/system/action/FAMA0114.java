/**
 * @author AndrewSung
 * @date 2006/3/9
 */

package tw.gov.nta.system.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.system.common.CodeDetManage;
import tw.gov.nta.system.form.Fama0102Form;
public class FAMA0114 extends DefaultAction
{

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception
	{
		Fama0102Form myForm = (Fama0102Form) form;
    	CodeDetManage.delete(myForm.getId());
    	setAlertMessage(request,"§R°£¦¨¥\");

	}

}
