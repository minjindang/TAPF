/**
*
* @author Andrew Sung
* @createDate 2006/10/3
*/
package tw.gov.nta.debt.action;

import java.sql.Connection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.ExtendDueDateManager;
import tw.gov.nta.debt.form.Cima0101Form;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

public class CIMA0136 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Cima0101Form myForm = (Cima0101Form)form;
		Date newDueDate = DateUtil.str2Date(DateUtil.ROCDate2Date(request.getParameter("newDueDate")));
		try{
			new ExtendDueDateManager().ExtendDueDateToRate(myForm.getId(), newDueDate,this.getUserId(request));
			setAlertMessage(request, "延長成功!!");
		}catch(Exception e){
			System.out.println(e);
			setAlertMessage(request, "延長失敗!!");
		}
	}

}
