/* BIMA0207.java
 程式目的：BIMA02
 程式代號：BIMA02
 程式日期：0950301
 程式作者：Eric.Chen
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
 --------------------------------------------------------
 */
package tw.gov.nta.exchequer.action;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.TreasuryPayManager;
import tw.gov.nta.exchequer.form.Bima0201Form;

import gov.dnt.tame.common.DefaultAction;

public class BIMA0207 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		// 用TreasuryPaymentManager.isModify來檢查是否有達到刪除的條件
		// 用TreasuryPaymentManager.comform來刪除資料
		Bima0201Form myForm = (Bima0201Form)form;
		TreasuryPayManager myManager = new TreasuryPayManager();
		if(myManager.isModify(myForm.getPaymentMain()))
		{
			myForm.setAverageRate(myForm.getAverageRate().divide(new BigDecimal(100)));
			myForm.setInterestAmount(myForm.getManageInterestAmount());
			myManager.confirm(myForm.getPaymentMain());
			setAlertMessage(request,"更新成功");
		}
		else
		{
			setAlertMessage(request,"不准刪除資料");
		}
	}
}
