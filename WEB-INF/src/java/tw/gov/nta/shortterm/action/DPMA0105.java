/**
 * @author AndrewSung
 * @date 2006/3/9
 */

package tw.gov.nta.shortterm.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.shortterm.form.Dpma0101Form;
public class DPMA0105 extends DefaultAction
{

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception
	{
		Dpma0101Form myForm = (Dpma0101Form)form;
		IssueManager issueManager = new IssueManager();
		String[] name = {"accountYear","id","debtType"};
		Object[] value = {myForm.getQryAccountYear(),myForm.getId()==0?null:myForm.getId(),"D"};
		String[] conds = {"=","=","="};
		String[] order = {"accountYear"};
		List collection = issueManager.Search(name,value,conds,order);
		request.setAttribute("mod","true");
		request.setAttribute("collection",collection);
	}

}
