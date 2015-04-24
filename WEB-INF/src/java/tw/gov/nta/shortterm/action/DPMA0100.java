/* DPMA0101.java
程式目的：DPMA01
程式代號：DPMA01
程式日期：0950223
程式作者：Andrew.Sung
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
*/
package tw.gov.nta.shortterm.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.shortterm.form.Dpma0101Form;




/**
 * @author EricChen
 *
 * TODO 如果要變更這個產生的類別註解的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
public class DPMA0100 extends DefaultAction {
	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		Dpma0101Form myform = (Dpma0101Form) form;
		myform.setRepayDate(new Date());
	}	
}
