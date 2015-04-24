/**
 * @author AndrewSung
 * @date 2006/3/7
 */

package tw.gov.nta.shortterm.action;

import gov.dnt.tame.common.DefaultAction;

import java.math.BigDecimal;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.shortterm.form.Dima0201Form;
public class DIMA0201 extends DefaultAction
{

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception
	{
		Dima0201Form myForm = (Dima0201Form)form;
		myForm.setDebtType("D");
		myForm.setShowType("C");
		myForm.setIssueAmount(new BigDecimal(0));
		myForm.setAverageRate(new BigDecimal(0));
		myForm.setCapitalAmount(new BigDecimal(0));
		myForm.setInterestAmount(new BigDecimal(0));
		IssueManager issueManager = new IssueManager();
		if(issueManager.checkSerialNo(myForm.getIssuMain())){
			issueManager.confirm(myForm.getIssuMain());
			setAlertMessage(request,"新增成功");
		}else{
			setAlertMessage(request,"失敗，代碼期次重複。");
			throw new Exception("checkBean false!");
		}
		/*debtManager.getBeanByIssue(myForm.getIssuMain().getId());
		List collection = debtManager.getBeanByIssue(myForm.getIssuMain().getId());
		request.setAttribute("collection",collection);*/
	}

}
