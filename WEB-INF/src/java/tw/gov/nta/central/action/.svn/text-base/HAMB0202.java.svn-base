/* HAMB0202.java
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

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.central.common.Taxaction;
import tw.gov.nta.central.form.Hamb0201Form;
import tw.gov.nta.sql.TaxactionDet;

/**
 * @author EricChen
 *
 * TODO 如果要變更這個產生的類別註解的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
public class HAMB0202 extends DefaultAction {

	/* (non-Javadoc)
	 * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
	 */
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO 自動產生方法 Stub 兩個text的觸發事件 OnExit
		Hamb0201Form myform = (Hamb0201Form) form;
		
		myform.setTaxKind("1"); //load page 時get的
		
		//測試用 目前無load page 
		//service 的 getByYear 
		TaxactionDet myDet = new TaxactionDet();
		myDet = Taxaction.getByYear(myform.getTaxYear(),myform.getTaxMonth(),myform.getTaxKind());
		if( null == myDet )
		{
//			setAlertMessage(request,"查無符合記帳年度和分配年月的資料!!");
//			myform.setId(0);
//			myform.setTaxYear("");
//			myform.setTaxMonth("");
//			myform.setMonNo("");
//			myform.setBankno("");
//			myform.setMonKind("");
//			myform.setPname("");
			myform.setId(null);
		}
		else
		{
			myform.setMyDto(myDet);
		}
	}

}
