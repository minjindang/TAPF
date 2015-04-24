/**
 * @author Andrew Sung
 * @create 2006/4/14
 */

package tw.gov.nta.shortterm.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.shortterm.form.Dira0701Form;

public class DIRA0602 extends JacobReportAction
{
	@Override
	protected ReportManager getReportManager(ActionForm form,
			HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}

	@Override
	protected String getProgramId(HttpServletRequest request)
	{
		return "DIRA06";
	}


	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request)
	{
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		Dira0701Form myForm = (Dira0701Form)form;
		if(myForm.getDueDate()!=null && !"".equals(myForm.getDueDate())){
			map.put("A2","截至"+DateUtil.date2ChineseROC2(myForm.getDueDate()));
		}else{
			map.put("A2","截至"+DateUtil.date2ChineseROC2(new Date()));
		}
		//map.put("Z1",this.getUserId(request));
		map.put("Z4",DateUtil.date2ROCStr(DateUtil.date()));
//		map.put("Z5",new DecimalFormat("#,###").format(new BigDecimal(request.getAttribute("totalAmount").toString())));
//		map.put("Z6",new DecimalFormat("#,###").format(new BigDecimal(request.getAttribute("totalAmountDa").toString())));
//		map.put("Z7",new DecimalFormat("#,###").format(new BigDecimal(request.getAttribute("totalAmountDet").toString())));
		map.put("I4","製表日期："+DateUtil.date2ChineseROC2(new Date()));
		map.put("Z7",request.getAttribute("memo").toString());
		map.put("Z1",request.getAttribute("total").toString());
		return map;
	}
//	public final short DEFAULT_PAPERSIZE = PageSize.A4_PAPERSIZE;
//	public final boolean LANDSCAPE = true;
//	protected boolean isLANDSCAPE() {return LANDSCAPE;}
//	protected short getDEFAULT_PAPERSIZE() {return DEFAULT_PAPERSIZE;}
//
//	@Override
//	public String getJasperFileName() {
//		return "DIRA06_RPT1.jasper";
//	}
//
//	@Override
//	public Map getReportParameter(ActionMapping mapping, ActionForm form,
//			HttpServletRequest request, HttpServletResponse response,
//			Connection connection) {
//		Dira0701Form myForm = (Dira0701Form)form;
//		// TODO Auto-generated method stub
//		Map<String,Object> parameters = new HashMap<String,Object>();
//		//取得使用者帳號
//		String usrId = this.getUserId(request);
//		//取得製表日期
//		String createDate = DateUtil.date2ROCStr(DateUtil.date());
//		String title = myForm.getAccountYear()+"年度國內借款還本付息估測表(年報)";
//		parameters.put("usrId",usrId);
//		parameters.put("createDate",createDate);
//		return parameters;
//	}
}
