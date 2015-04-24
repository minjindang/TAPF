/*
 * 在 2006/2/22 建立
 */
package tw.gov.nta.system.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import tw.gov.nta.system.common.ExstockCodeManage;
import tw.gov.nta.system.form.Fama0401Form;

/**
 * @author AndrewSung
 * FAMA0407.java
 * 呼叫ExstockCodeManage之create(),傳入ExstockRef新增資料
 */
public class FAMA0407 extends DefaultAction
{
	 public ActionForward executeQuery(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, Connection connection) throws Exception
	 {
		 Fama0401Form fama0401Form = (Fama0401Form) form;
		 fama0401Form.setId(null);
		 //設定登入之使用者ID
		 fama0401Form.setUsrid(this.getUserId(request));
		 //設定建立日期與修改日期
		 fama0401Form.setModDate(new Date());
		 fama0401Form.setCreateDate(new Date());
		 if(ExstockCodeManage.isModify(fama0401Form.getExstockRef()))
		 {
			 ExstockCodeManage.create(fama0401Form.getExstockRef());
			 fama0401Form.setExstockRef(ExstockCodeManage.get(fama0401Form.getId()));
			 setAlertMessage(request,"新增成功");
			 return mapping.findForward("success");
		 }
		 else
		 {
			 setAlertMessage(request,"新增失敗:標的代號重複");
			 fama0401Form.setStockId(null);
			 return mapping.findForward("fail");
		 }
	 }
	
    public void executeQuery(ActionForm form, HttpServletRequest request,
            Connection connection) throws Exception
    {

    }
}