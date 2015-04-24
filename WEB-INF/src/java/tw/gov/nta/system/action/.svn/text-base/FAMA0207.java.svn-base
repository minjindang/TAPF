/* FAMA0207.java
程式目的：FAMA02
程式代號：FAMA02
程式日期：0950222
程式作者：Eric.Chen
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
*/
package tw.gov.nta.system.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import tw.gov.nta.sql.BudgetRef;
import tw.gov.nta.system.common.BudgetCodeManager;
import tw.gov.nta.system.form.Fama0201Form;

/**
 * @author EricChen
 *
 * TODO 如果要變更這個產生的類別註解的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
public class FAMA0207 extends DefaultAction {

	/* (non-Javadoc)
	 * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
	 */
	public ActionForward executeQuery(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, Connection connection) throws Exception
	 {
		// TODO 自動產生方法 Stub
		Fama0201Form myform = (Fama0201Form) form;
		
		myform.setCreateDate( new Date() );
		myform.setModDate( new Date() );
		myform.setUsrid(this.getUserId(request));

		BudgetRef myBudget = new BudgetRef();
		myBudget.setBudgetType(myform.getBudgetType());
		List list = BudgetCodeManager.isModify(myBudget);
		
		if(null == list || 0 == list.size())
		{	
			//使用Service:BudgetCodeManager
			//使用 BudgetCodeManager.create 新增
			BudgetCodeManager.create(myform.getMyDto());
			setAlertMessage(request,"新增成功");
			return mapping.findForward("success");
		}
		else
		{
			setAlertMessage(request,"新增失敗");
			myform.setBudgetName("");
			myform.setBudgetType("");
			myform.setRemark("");
			return mapping.findForward("failure");
		}	
	}
	public void executeQuery(ActionForm form, HttpServletRequest request,
            Connection connection) throws Exception
    {
    	
    }
}
