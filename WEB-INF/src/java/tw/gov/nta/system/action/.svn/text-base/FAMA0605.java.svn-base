/* FAMA0605.java
程式目的：FAMA06
程式代號：FAMA06
程式日期：0950223
程式作者：Eric.Chen
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
*/
package tw.gov.nta.system.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.system.common.NationCodeManager;
import tw.gov.nta.system.form.Fama0601Form;

/**
 * @author EricChen
 *
 * TODO 如果要變更這個產生的類別註解的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
public class FAMA0605 extends DefaultAction {

	/* (non-Javadoc)
	 * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
	 */
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO 自動產生方法 Stub
		//取得 formBean
		Fama0601Form myform = (Fama0601Form) form;
		myform.setModDate(new Date());
		myform.setUsrid(this.getUserId(request));
		//使用Service:NationCodeManager
		//使用 NationCodeManager.update 更新

		if(0 != myform.getId())
		{	
			NationCodeManager.update(myform.getMyDto());
			setAlertMessage(request,"更新成功");
		}
		else
		{
			setAlertMessage(request,"更新失敗");
		}
		
	}

}
