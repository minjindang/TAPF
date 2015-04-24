/**
 * @author AndrewSung
 * @date 2006/3/10
 */

package tw.gov.nta.central.action;

import gov.dnt.tame.common.PageSize;
import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.ExcelReportAction;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import tw.gov.nta.central.form.Harb0901Form;
import tw.gov.nta.system.common.CodeDetManage;
public class HARC0902 extends JacobReportAction{
	protected ReportManager getReportManager(ActionForm form,
			HttpServletRequest request)
	{
		Harb0901Form myForm = (Harb0901Form)form;
		String prtKind = myForm.getPrtKind();
		return new ReportManager(getProgramId(request,prtKind),getReportParameter(form, request),getRealPath());
	}

	@Override
	protected String getProgramId(HttpServletRequest request)
	{
		return "HARB09";
	}
	protected String getProgramId(HttpServletRequest request, String prtKind)
	{
		if("1".equals(prtKind) || "2".equals(prtKind))
			return "HARB09";
		else if("3".equals(prtKind))
			return "HARC0901";
		else
			return "HARC0902";
	}
	@SuppressWarnings({"static-access","unchecked"})
	protected Map getReportParameter(ActionForm form, HttpServletRequest request)
	{
		Harb0901Form myForm = (Harb0901Form)form;
		Map<String,String> map = new LinkedHashMap<String,String>();
		if("1".equals(myForm.getPrtKind()) || "2".equals(myForm.getPrtKind()))
		{
			String minus = "";
			String lastTable = "";
			String city = "";
			if("Y".equals(myForm.getMinus())){
				minus = "(已扣款)";
				lastTable = "截至本月止累計歸扣金額";
			}
			else{
				minus = "(未扣款)";
				lastTable = "備註";
			}
			if("1".equals(myForm.getPrtKind()))
				city = "(直轄市、縣市)";
			String codeName = new CodeDetManage().getCodeName("CK",myForm.getPrtKind());
			map.put("F1",city);
			map.put("F2", myForm.getSupMonth());
			map.put("F3",DateUtil.date2ROCStr(new Date(),"yyy/mm/dd"));
			map.put("F4", myForm.getSupYear()+ codeName + minus);
			map.put("F5",lastTable);
			map.put("F6",String.valueOf(request.getAttribute("sum")));
			map.put("F７","專案補助款");
			return map;
		}else if("3".equals(myForm.getPrtKind())){
			String year = (String)myForm.getSupYear();
			String month = (String)myForm.getSupMonth();
			map.put("A2",year+"年"+month.substring(3,month.length())+"月專案補助撥付明細表");
			return map;
		}else{
			String year = (String)myForm.getSupYear();
			String month = (String)myForm.getSupMonth();
			map.put("A2",year+"年度專案補助累計撥付明細表");			
			map.put("A3","(累計至"+year+"年"+ month.substring(3,month.length()) +"月)");
			return map;
		}
	}
	
	
}
//public class HARB0902 extends ExcelReportAction
//{
//	public final short DEFAULT_PAPERSIZE = PageSize.A4_PAPERSIZE;
//	public final boolean LANDSCAPE = true;
//	protected boolean isLANDSCAPE() {return LANDSCAPE;}
//	protected short getDEFAULT_PAPERSIZE() {return DEFAULT_PAPERSIZE;}
//
//	@Override
//	public String getJasperFileName() {
//		return "HARB09_RPT1.jasper";
//	}
//
//	@Override
//	public Map getReportParameter(ActionMapping mapping, ActionForm form,
//			HttpServletRequest request, HttpServletResponse response,
//			Connection connection) {
//		Harb0901Form myForm = (Harb0901Form)form;
//		// TODO Auto-generated method stub
//		Map<String,Object> parameters = new HashMap<String,Object>();
//		//取得使用者帳號
//		String usrId = this.getUserId(request);
//		//取得製表日期
//		String createDate = DateUtil.date2ROCStr(DateUtil.date(),"yyy/mm/dd");
//		String minus = null;
//		String lastTable = null;
//		if("Y".equals(myForm.getMinus())){
//			minus = "(已扣款)";
//			lastTable = "截至本月止累計歸扣金額";
//		}
//		else{
//			minus = "(未扣款)";
//			lastTable = "備註";
//		}
//		String city = "";
//		if("2".equals(myForm.getPrtKind()))
//			city = "(直轄市、縣市)";
//		parameters.put("usrId",usrId);
//		parameters.put("createDate",createDate);
//		parameters.put("prtKind",myForm.getPrtKind());
//		parameters.put("supYear",myForm.getSupYear());
//		parameters.put("supMonth",myForm.getSupMonth());
//		parameters.put("minus",minus);
//		parameters.put("city",city);
//		parameters.put("lastTable",lastTable);
//		return parameters;
//	}
//
//}
