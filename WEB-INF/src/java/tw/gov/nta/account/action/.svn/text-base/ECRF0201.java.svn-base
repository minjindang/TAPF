package tw.gov.nta.account.action;

import gov.dnt.tame.common.PageSize;
import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.ExcelReportAction;

import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import tw.gov.nta.account.form.Ecrf0201Form;

public class ECRF0201 extends ExcelReportAction
{
	public final short DEFAULT_PAPERSIZE = PageSize.A4_PAPERSIZE;
	public final boolean LANDSCAPE = false;
	protected boolean isLANDSCAPE() {return LANDSCAPE;}
	protected short getDEFAULT_PAPERSIZE() {return DEFAULT_PAPERSIZE;}
	
	public String jasperFileName;

	public String getJasperFileName() {
		return jasperFileName;
	}

	public Map getReportParameter(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			Connection connection) {
		Map<String,Object> parameters = new HashMap<String,Object>();
		Ecrf0201Form myForm = (Ecrf0201Form) form;
		if( myForm.getQryType().equals( new Integer(1) ) )
		{
			setJasperFileName("ECRF02_RPT1.jasper");

			String sqlStr = "";
			if( myForm.getQryBudgetCode()!=null )
				sqlStr += " and b.budget_code="+myForm.getQryBudgetCode();
			if( myForm.getQryDebtCode()!=null )
				sqlStr += " and b.debt_code="+myForm.getQryDebtCode();
			parameters.put("sqlStr"," "+sqlStr+" ");
			parameters.put("createDate",DateUtil.date2ChineseROC(new Date()));
		}
		else
		{			
			setJasperFileName("ECRF02_RPT2.jasper");
			parameters.put("createDate","(截至"+DateUtil.date2ChineseROC(new Date())+"止)(未償／已償金額)");
		}
		
		parameters.put("qryDate",myForm.getQryDate());
		return parameters;
	}

	public void setJasperFileName(String jasperFileName) {
		this.jasperFileName = jasperFileName;
	}
}
