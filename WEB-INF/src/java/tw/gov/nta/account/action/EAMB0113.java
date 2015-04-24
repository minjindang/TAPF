package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import tw.gov.nta.account.common.AccountException;
import tw.gov.nta.debt.account.common.DebtAccountManager;
import tw.gov.nta.sql.debt.DebtTypeRef;

import com.kangdainfo.ast.common.GlobalForwardNames;

/**
 * 批次產生傳票
 * @author Linus
 *
 */
public class EAMB0113 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
	// TODO Auto-generated method stub
		DebtAccountManager manager = new DebtAccountManager();
		
		String ids[] = request.getParameterValues("id");
		int[] issueIds = new int[ids.length];
		for(int i=0;i<ids.length;i++)
			issueIds[i] = Integer.parseInt(ids[i]);
		
		int voucherType = (Integer)request.getSession().getAttribute("voucherType");
		DebtTypeRef debtType = (DebtTypeRef)request.getSession().getAttribute("debtType");
		try {
			manager.batchMakeVoucherByIssue(issueIds,voucherType,this.getUserId(request),debtType);
			setAlertMessage(request,"批次製作傳票成功!");
		}catch (AccountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			setAlertMessage(request,e.getMessage());
		}
		
	}

	/* (non-Javadoc)
	 * @see com.kangdainfo.ast.action.SafeAction#getSuccessForward(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward getSuccessForward(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = mapping.findForward(GlobalForwardNames.SUCCESS);
		String path  = forward.getPath();
		String newPath = (String)request.getSession().getAttribute("SYSID");
		//path = path.replaceAll("EAMB01",newPath);
		ActionForward newForward = new ActionForward(path);
		return newForward;
	}

}
