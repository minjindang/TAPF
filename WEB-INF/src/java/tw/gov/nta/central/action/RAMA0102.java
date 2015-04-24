package tw.gov.nta.central.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.PagedProcesser;
import java.sql.Connection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.central.common.NationalDebtDueDateMainController;
import tw.gov.nta.central.form.Rama0101Form;

public class RAMA0102 extends DefaultAction {
	public static final int DEFAULT_PAGE_SIZE = 20;

	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Rama0101Form myForm = (Rama0101Form) form;
		myForm.setCurrentUserDeptId(NationalDebtDueDateMainController
				.getCurrentUserDeptId(this.getUserId(request), connection));
		List list = (List) NationalDebtDueDateMainController.getByRange(myForm
				.getRepayDateS(), myForm.getRepayDateE(), connection);
		List pagedlist = (List) NationalDebtDueDateMainController.getByRange(
				myForm.getRepayDateS(), myForm.getRepayDateE(), connection,
				myForm.getPage(), DEFAULT_PAGE_SIZE);
		request.setAttribute("collection", pagedlist);
		int page = myForm.getPage() + 1;
		PagedProcesser pagedProcesser = new PagedProcesser(page,
				DEFAULT_PAGE_SIZE);
		request.setAttribute("PAGEBAR", pagedProcesser.getButtonStr(list));
	}
}
