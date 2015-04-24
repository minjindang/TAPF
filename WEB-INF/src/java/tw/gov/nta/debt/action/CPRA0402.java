package tw.gov.nta.debt.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Apra0101Form;
import tw.gov.nta.debt.form.Cpra0401Form;
import tw.gov.nta.system.common.BudgetCodeManager;
import tw.gov.nta.system.common.DebitCodeManage;

public class CPRA0402 extends JacobReportAction {

	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "CPRA04";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		// TODO Auto-generated method stub
		Cpra0401Form myform = (Cpra0401Form) form;
		Map<String,Object> map = new HashMap<String,Object>();
		myform.getBaseDate();
		map.put("Z2", myform.getBaseDate().subSequence(0, 3));
		map.put("Z3", myform.getBaseDate().subSequence(3, 5));
		map.put("Z4", new DateUtil().date2Str(new Date(), "yyyy/MM/dd"));
		map.put("Z5", request.getAttribute("sumChargeAmount").toString());
		map.put("Z6", request.getAttribute("sumTotalInterestAmount").toString());
		return map;
	}
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}

}