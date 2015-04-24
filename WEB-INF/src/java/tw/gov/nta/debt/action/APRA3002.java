package tw.gov.nta.debt.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.debt.form.Apra3001Form;

public class APRA3002 extends JacobReportAction
{	
	private final static String PROGRAM_ID = "APRA30";

	protected String getProgramId(HttpServletRequest request)
	{	return PROGRAM_ID;	}

	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Apra3001Form myForm = (Apra3001Form)form;
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		map.put("A1",myForm.getPayYear()+"�~�װꤺ�ɴ��٥��I��������(�~��)");
		if("1".equals(myForm.getBondType()))
			map.put("J6","����(����)");
		else if("2".equals(myForm.getBondType()))
			map.put("J6","����(�A��)");
		else
			map.put("J6","��      ��");
		return map;
	}
}
