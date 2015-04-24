/*
 * 在 2006/2/17 建立
 *
 * TODO 如果要變更這個產生的檔案的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
package tw.gov.nta.central.action;

import gov.dnt.tame.common.DefaultAction;
import java.sql.Connection;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.central.common.UnitInfo;
import tw.gov.nta.central.form.Hama0101Form;
import tw.gov.nta.sql.UnitInfoMain;

/**
 * @author Jack Du
 *
 * TODO 如果要變更這個產生的類別註解的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
public class HAMA0104 extends DefaultAction {

	/* (non-Javadoc)
	 * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
	 */
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		//取得 formBean
		Hama0101Form hama0101form = (Hama0101Form) form;

		UnitInfoMain unitInfoMain = new UnitInfoMain();
		BeanUtils.copyProperties(unitInfoMain, hama0101form);

		// setModDate 寫入修改日期
		unitInfoMain.setModDate(new Date());

		//使用Service:UnitInfo
		//使用 UnitInfo.update 更新
		UnitInfo.update(unitInfoMain);
		setAlertMessage(request, "更新成功");
	}
}
