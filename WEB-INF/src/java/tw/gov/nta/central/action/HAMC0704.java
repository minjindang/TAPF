/* HAMB0704.java
 程式目的：HAMB07文字
 程式代號：HAMB07
 程式日期：0950222
 程式作者：Eric.Chen
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
 --------------------------------------------------------
 */
package tw.gov.nta.central.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.central.common.UnitAllocate;
import tw.gov.nta.central.form.Hamb0701Form;

public class HAMC0704 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		//	更新各單位電子郵件接收紀錄
		Hamb0701Form myform = (Hamb0701Form) form;
		myform.setUsrid(this.getUserId(request));
		myform.setModDate(new Date());
		//用 Service updateForRecive 更新
		UnitAllocate.updateForRecieve(myform.getId(),myform.getRecvDate());
		setAlertMessage(request, "更新成功");
		
	}

}
