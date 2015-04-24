/**
 * @author AndrewSung
 * @date 2006/3/10
 */

package tw.gov.nta.debt.action;

import gov.dnt.tame.common.PageSize;
import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.ExcelReportAction;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import tw.gov.nta.debt.form.Apra1801Form;
public class APRA1802 extends ExcelReportAction
{
	public final short DEFAULT_PAPERSIZE = PageSize.A4_PAPERSIZE;
	public final boolean LANDSCAPE = true;
	protected boolean isLANDSCAPE() {return LANDSCAPE;}
	protected short getDEFAULT_PAPERSIZE() {return DEFAULT_PAPERSIZE;}

	@Override
	public String getJasperFileName() {
		return "APRA18_RPT1.jasper";
	}

	@Override
	public Map getReportParameter(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			Connection connection) {
		Apra1801Form myForm = (Apra1801Form)form;
		// TODO Auto-generated method stub
		Map<String,Object> parameters = new HashMap<String,Object>();
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得製表日期
		String createDate = DateUtil.date2ChineseROC2(DateUtil.date());
		String closeDate = DateUtil.date2ChineseROC2(myForm.getCloseDate());
		Integer issueId = (Integer) request.getAttribute("issueId");
		parameters.put("usrId",usrId);
		parameters.put("createDate",createDate);
		parameters.put("issueId",issueId);
		parameters.put("debtName",myForm.getDebtName());
		parameters.put("closeDate",closeDate);
		return parameters;
	}

}
