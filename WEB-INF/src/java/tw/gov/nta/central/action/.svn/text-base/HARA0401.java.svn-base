/*
 * 在 2006/2/20 建立
 *
 * TODO 如果要變更這個產生的檔案的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
package tw.gov.nta.central.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.central.common.UnitPercent;
import tw.gov.nta.central.form.Hara0401Form;

/**
 * @author AndrewSung
 * 呼叫UnitPercent之getByYear(),以計帳年度進行查詢受分配單位受分配比例資料
 */
public class HARA0401 extends DefaultAction
{ 
    public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception 
	{
        Hara0401Form hara0401Form = (Hara0401Form) form;  
		List list =(List)UnitPercent.getByYear(hara0401Form.getUnitPercentDet());	
		//return to jsp
		request.setAttribute("collection",list);
	}
}