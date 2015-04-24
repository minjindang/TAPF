/**
 * @author AndrewSung
 * @date 2006/3/10
 */

package tw.gov.nta.debt.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Apra2101Form;
public class APRA2102 extends JacobReportAction
{
	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "APRA21";
	}
	
	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		Apra2101Form myform = (Apra2101Form)form;
		map.put("C5",myform.getDebtName());
		if (request.getAttribute("issueDate")!= null)
			map.put("C6","中華民國"+DateUtil.date2ChineseROC2((Date)request.getAttribute("issueDate")));
		if (request.getAttribute("dueDate")!= null)
			map.put("C7","中華民國"+DateUtil.date2ChineseROC2((Date)request.getAttribute("dueDate")));
		return map;
	}
	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}
	
} 

//原jasper
//ExcelReportAction
//{
//	public final short DEFAULT_PAPERSIZE = PageSize.A4_PAPERSIZE;
//	public final boolean LANDSCAPE = true;
//	protected boolean isLANDSCAPE() {return LANDSCAPE;}
//	protected short getDEFAULT_PAPERSIZE() {return DEFAULT_PAPERSIZE;}
//
//	@Override
//	public String getJasperFileName() {
//		return "APRA21_RPT1.jasper";
//	}
//
//	@Override
//	public Map getReportParameter(ActionMapping mapping, ActionForm form,
//			HttpServletRequest request, HttpServletResponse response,
//			Connection connection) {
//		//Apra2101Form myForm = (Apra2101Form)form;
//		// TODO Auto-generated method stub
//		Map<String,Object> parameters = new HashMap<String,Object>();
//		//取得使用者帳號
//		String usrId = this.getUserId(request);
//		//取得製表日期
//		Apra2101Form myform = (Apra2101Form)form;
//		String createDate = DateUtil.date2ChineseROC2(DateUtil.date());
//		parameters.put("usrId",usrId);
//		parameters.put("createDate",createDate);
//		parameters.put("debtName",myform.getDebtName());
//		return parameters;
//	}
//
//}
