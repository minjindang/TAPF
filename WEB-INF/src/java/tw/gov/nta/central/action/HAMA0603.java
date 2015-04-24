package tw.gov.nta.central.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.PagedProcesser;
import java.sql.Connection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.central.common.UnitInfo;
import tw.gov.nta.central.form.Hama0601Form;

public class HAMA0603 extends DefaultAction {
	public static final int DEFAULT_PAGE_SIZE = 20;
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		Hama0601Form hama0601form = (Hama0601Form) form;
		//使用 UnitInfo.getByNo 取得 list
		List list = (List) UnitInfo.getByNo("","",hama0601form.getQryYear());
		List pagedlist = (List) UnitInfo.getByNo("","",hama0601form.getPage(),DEFAULT_PAGE_SIZE,hama0601form.getQryYear());
		//return to jsp
		request.setAttribute("collection",pagedlist);
//		begin get Page Hidden String
		int page = hama0601form.getPage()+1;
		PagedProcesser pagedProcesser = new PagedProcesser(page,DEFAULT_PAGE_SIZE);
		request.setAttribute("PAGEBAR", pagedProcesser.getButtonStr(list));
//		end get Page Hidden String
	}
}
