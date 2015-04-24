/**
 * @author AndrewSung
 * @date 2006/3/8
 */

package tw.gov.nta.system.action;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.system.common.CentralStatisticsManager;
import tw.gov.nta.system.form.Gama0301Form;

import gov.dnt.tame.common.DefaultAction;
public class GAMA0305 extends DefaultAction
{

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception
	{
		Gama0301Form myForm = (Gama0301Form) form;
		CentralStatisticsManager.update(myForm.getId(),myForm.getCsMain());
    	setAlertMessage(request,"更新成功");
	}

}
