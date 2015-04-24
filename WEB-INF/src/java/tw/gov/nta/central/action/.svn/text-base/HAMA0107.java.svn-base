/*
 * 在 2006/2/17 建立
 *
 * TODO 如果要變更這個產生的檔案的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
package tw.gov.nta.central.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.PagedProcesser;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.central.common.UnitInfo;
import tw.gov.nta.central.form.Hama0101Form;

/**
 * @author Jack Du
 *
 * TODO 如果要變更這個產生的類別註解的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
public class HAMA0107 extends DefaultAction {
	public static final int DEFAULT_PAGE_SIZE = 20;

	/* (non-Javadoc)
	 * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
	 */
	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		// TODO 自動產生方法 Stub
		//取得 formBean
		Hama0101Form myForm = (Hama0101Form) form;
		List list = null;
		List pagedlist = null;
		list = (List) UnitInfo.getByNo(myForm.getQryUnitId(),myForm.getQryUnit(),myForm.getQryTyear());
		pagedlist = (List) UnitInfo.getByNo(myForm.getQryUnitId(),myForm.getQryUnit(),myForm.getPage(),DEFAULT_PAGE_SIZE);
		//request.setAttribute("collection",list);
		//return to jsp
		request.setAttribute("collection",pagedlist);
		
		//begin get Page Hidden String
		int page = myForm.getPage()+1;
		PagedProcesser pagedProcesser = new PagedProcesser(page,DEFAULT_PAGE_SIZE);
		request.setAttribute("PAGEBAR", pagedProcesser.getButtonStr(list));
		//end get Page Hidden String
	}
}
