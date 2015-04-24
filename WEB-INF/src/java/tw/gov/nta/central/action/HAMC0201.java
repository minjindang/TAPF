/* HAMB0201.java
 程式目的：HAMB02文字
 程式代號：HAMB02
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
import tw.gov.nta.central.common.Taxaction;
import tw.gov.nta.central.form.Hamb0201Form;

/**
 * @author EricChen
 * 
 * TODO 如果要變更這個產生的類別註解的範本，請移至 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
public class HAMC0201 extends DefaultAction {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm,
	 *      javax.servlet.http.HttpServletRequest, java.sql.Connection)
	 */
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// 取得 formBean
		Hamb0201Form myform = (Hamb0201Form) form;
		myform.setUsrid(this.getUserId(request));	
		myform.setTaxKind("2");
//		myform.setMonKind("2");	//此值為下拉選單值(測試用) 
		myform.setModDate(new Date());
		//使用Service:Taxactioin
		//使用 Taxaction.updateforInfo更新
		if(myform.getId()== 0){
			Taxaction.create(myform.getTaxYear(),myform.getTaxMonth(),myform.getTaxKind(),myform.getMonNo(),myform
					.getBankno(),myform.getMonKind(),myform.getPname(),this.getUserId(request));
			setAlertMessage(request, "新增成功");
		}
		else{
			Taxaction.updateforInfo(myform.getId(), myform.getMonNo(), myform
					.getBankno(), myform.getMonKind(), myform.getPname());
			setAlertMessage(request, "更新成功");
		}
		
	}
}