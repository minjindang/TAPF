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

import tw.gov.nta.debt.form.Apra2501Form;
public class APRA2502 extends ExcelReportAction
{
	public final short DEFAULT_PAPERSIZE = PageSize.A3_PAPERSIZE;
	public final boolean LANDSCAPE = true;
	protected boolean isLANDSCAPE() {return LANDSCAPE;}
	protected short getDEFAULT_PAPERSIZE() {return DEFAULT_PAPERSIZE;}

	@Override
	public String getJasperFileName() {
		return "APRA25_RPT1.jasper";
	}

	@Override
	public Map getReportParameter(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			Connection connection) {
		Apra2501Form myForm = (Apra2501Form)form;
		// TODO Auto-generated method stub
		Map<String,Object> parameters = new HashMap<String,Object>();
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得製表日期
		String createDate = DateUtil.date2ChineseROC2(DateUtil.date());
		parameters.put("usrId",usrId);
		parameters.put("createDate",createDate);
		parameters.put("limitDate",DateUtil.date2ChineseROC2(myForm.getLimitDate()));
		parameters.put("type",myForm.getBudgetName());
		return parameters;
	}
}
