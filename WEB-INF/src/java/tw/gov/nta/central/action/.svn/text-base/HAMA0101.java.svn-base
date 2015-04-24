/*
 * 在 2006/2/17 建立
 *
 * TODO 如果要變更這個產生的檔案的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
package tw.gov.nta.central.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.central.common.UnitInfo;
import tw.gov.nta.central.common.UnitPercent;
import tw.gov.nta.central.form.Hama0101Form;
/**
 * @author Jack Du
 *
 * TODO 如果要變更這個產生的類別註解的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
public class HAMA0101 extends DefaultAction {

	/* (non-Javadoc)
	 * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
	 */
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		//取得 formBean
		Hama0101Form hama0101form = (Hama0101Form) form;

		//使用Service:UnitInfo
		//使用 UnitInfo.getUnitInfoMain 查詢單筆
		//回傳 ActionForm
		hama0101form.setUnitInfoMain(UnitInfo.get(hama0101form.getId()));
		if(hama0101form.getQryTyear().trim().length() == 0){
			hama0101form.setQryTyear(UnitPercent.getMaxYear(hama0101form.getUnitInfoMain()));
		}
	}
}
