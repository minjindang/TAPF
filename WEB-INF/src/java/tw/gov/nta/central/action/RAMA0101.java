package tw.gov.nta.central.action;
import gov.dnt.tame.common.DefaultAction;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.central.common.NationalDebtDueDateMainController;
import tw.gov.nta.central.form.Rama0101Form;
import gov.dnt.tame.util.DateUtil;
public class RAMA0101 extends DefaultAction{

	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Rama0101Form myform = (Rama0101Form) form;
		for(int i=0;i<myform.getId().length;i++){
			//NationalDebtDueDateMainController.update(myform.getId()[i],DateUtil.str2Date(myform.getRepayHandle()[i]),myform.getRepayNumber()[i],DateUtil.str2Date(myform.getAccountDate()[i]),myform.getAccountNumber()[i],myform.getFundNumber()[i],DateUtil.str2Date(myform.getSecretaryDate()[i]));
			NationalDebtDueDateMainController.update(myform.getId()[i],DateUtil.str2Date(myform.getRepayHandle()[i]),myform.getRepayNumber()[i],DateUtil.str2Date(myform.getAccountDate()[i]),myform.getAccountNumber()[i],myform.getFundNumber()[i],DateUtil.str2Date(myform.getSecretaryDate()[i]));
		}
		//String userDeptId = NationalDebtDueDateMainController.getCurrentUserDeptId(this.getUserId(request),connection);
		List collection = NationalDebtDueDateMainController.getNationalDebtDueDateList();//getNationalDebtDueDateList(userDeptId);		
		request.setAttribute("collection",collection);
		request.setAttribute("CurrentUserDeptId",NationalDebtDueDateMainController.getCurrentUserDeptId(this.getUserId(request),connection));
	}
}
