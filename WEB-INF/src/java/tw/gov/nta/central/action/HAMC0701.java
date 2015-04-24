/*
 * 在 2006/2/23 建立
 *
 * TODO 如果要變更這個產生的檔案的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
package tw.gov.nta.central.action;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.central.common.UnitAllocate;
import tw.gov.nta.central.form.Hamb0701Form;
import gov.dnt.tame.common.DefaultAction;

/**
 * @author Jack Du
 *
 * TODO 如果要變更這個產生的類別註解的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
public class HAMC0701 extends DefaultAction {

	/* (non-Javadoc)
	 * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
	 */
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		//取得 formBean
		//查詢各單位電子郵件接收紀錄
		Hamb0701Form myform = (Hamb0701Form) form;
		//myform.setMonKind("1");  //loadpage時設置 目前沒有 Action 先用測試
		
		myform.setAllYear(myform.getQryallYear());
		myform.setAllMonth(myform.getQryallMonth());
		myform.setUnitId(myform.getQryunitId());
		myform.setUnitName(myform.getQryunitName());
		
		List list = UnitAllocate.getMailRecord(myform.getAllYear(),myform.getAllMonth(),myform.getMonKind());
		//return to jsp
	    request.setAttribute("collection",list);
	}
	
}
