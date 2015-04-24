/* BIMA0208.java
 程式目的：BIMA02
 程式代號：BIMA02
 程式日期：0950302
 程式作者：Eric.Chen
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
 --------------------------------------------------------
 */
package tw.gov.nta.exchequer.action;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.TreasuryPayManager;
import tw.gov.nta.exchequer.form.Bima0201Form;

import gov.dnt.tame.common.DefaultAction;

public class BIMA0208 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
//		 用TreasuryPaymentManager.isModify來檢查是否有達到刪除的條件
		// 用TreasuryPaymentManager.cancel來刪除資料
		Bima0201Form myForm = (Bima0201Form)form;
		TreasuryPayManager myManager = new TreasuryPayManager();
		if(myManager.isModify(myForm.getPaymentMain()))
		{
			myManager.cancel(myForm.getPaymentMain());
			setAlertMessage(request,"刪除成功");
		}
		else
		{
			setAlertMessage(request,"刪除失敗");
		}
	}
}
