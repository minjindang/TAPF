package tw.gov.nta.central.action;
import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.central.common.Service;
import tw.gov.nta.central.form.Hamb1201Form;
public class HAMB1208 extends DefaultAction  {
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
	}
	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request, HttpServletResponse response, Connection connection) throws Exception {
		Hamb1201Form myForm = (Hamb1201Form)form;
		Service service = new Service();
		service.executeQuery(myForm.getQryAllYear(),myForm.getQryAllMonth(),"1","C:\\"+DateUtil.date2ROCStr(DateUtil.date())+".txt",connection,response);
	}
}
