/**
*
* @author Andrew Sung
* @createDate 2006/5/29
*/
package tw.gov.nta.central.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.central.common.Service;
import tw.gov.nta.central.form.Hamb0401Form;

public class HAMC0408 extends DefaultAction {
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
	}
	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request, HttpServletResponse response, Connection connection) throws Exception {
		Hamb0401Form myForm = (Hamb0401Form)form;
		Service service = new Service();
		service.executeQuery(myForm.getQryAllYear(),myForm.getQryAllMonth(),"2","C:\\"+DateUtil.date2ROCStr(DateUtil.date())+".txt",connection,response);
	}
}
	
