/*
 * 在 2006/2/20 建立
 *
 * 匯出資料
 */
package tw.gov.nta.central.action;

import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.central.form.Hama0301Form;

/**
 * @author Mindy
 */
public class HAMA0301 extends JacobReportAction {

	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "HAMA03";
	}
	@Override
	protected Map getReportParameter(ActionForm form, HttpServletRequest request) {
		Hama0301Form hama0301Form = (Hama0301Form) form;
		Map<String,String> map = new LinkedHashMap<String,String>();
		String year = "0".equals(hama0301Form.getQryYear().substring(0,1))?hama0301Form.getQryYear().substring(1,3):hama0301Form.getQryYear();
		map.put("A1",year + "年度中央普通統籌分配稅款及專案補助撥付比率表");
		return map;
	}

	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}
}
