package tw.gov.nta.central.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.PagedProcesser;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.central.common.UnitInfo;
import tw.gov.nta.central.form.Hama0301Form;

public class HAMA0303 extends DefaultAction {
	public static final int DEFAULT_PAGE_SIZE = 20;

	/* (non-Javadoc)
	 * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
	 */
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		// TODO 自動產生方法 Stub
		//取得 formBean
		Hama0301Form hama0301form = (Hama0301Form) form;

//		UnitPercentDet unitPercentDet = new UnitPercentDet();
//		unitPercentDet.setTyear( hama0301form.getQryYear() );
		//unitPercentDet.setUnitInfo( new UnitInfoMain() );

		//使用Service:UnitInfo
		//使用 UnitInfo.getByNo 取得 list
		List list = (List) UnitInfo.getByNo("","",hama0301form.getQryYear());
		List pagedlist = (List) UnitInfo.getByNo("","",hama0301form.getPage(),DEFAULT_PAGE_SIZE,hama0301form.getQryYear());
		//return to jsp
		request.setAttribute("collection",pagedlist);

//		begin get Page Hidden String
		int page = hama0301form.getPage()+1;
		PagedProcesser pagedProcesser = new PagedProcesser(page,DEFAULT_PAGE_SIZE);
		request.setAttribute("PAGEBAR", pagedProcesser.getButtonStr(list));
//		end get Page Hidden String
	}
}
