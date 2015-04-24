/*
 * 在 2006/2/23 建立
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

import tw.gov.nta.central.common.UnitAllocate;
import tw.gov.nta.central.form.Hamb0401Form;
import tw.gov.nta.sql.UnitAllocateMain;
import tw.gov.nta.sql.UnitInfoMain;

/**
 * @author Jack Du
 *
 * TODO 如果要變更這個產生的類別註解的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
public class HAMB0407 extends DefaultAction {

	/* (non-Javadoc)
	 * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
	 */
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		//取得 formBean
		Hamb0401Form hamb0401form = (Hamb0401Form) form;

		UnitAllocateMain unitAllocateMain = new UnitAllocateMain();
		unitAllocateMain.setAllYear( hamb0401form.getQryAllYear() );
		unitAllocateMain.setAllMonth( hamb0401form.getQryAllMonth() );
		UnitInfoMain unitInfoMain = new UnitInfoMain();
		unitInfoMain.setUnitId( hamb0401form.getQryUnitId() );
		unitInfoMain.setUnitName( hamb0401form.getQryUnitName() );
		unitAllocateMain.setUnitInfo( unitInfoMain );
		unitAllocateMain.setMonKind("1");
		hamb0401form.setQryTotal( UnitAllocate.Account(hamb0401form.getQryAllYear(),hamb0401form.getQryAllMonth(),"1") );

		List collection = UnitAllocate.getForFound(unitAllocateMain);
		request.setAttribute("collection",collection);
	}
}
