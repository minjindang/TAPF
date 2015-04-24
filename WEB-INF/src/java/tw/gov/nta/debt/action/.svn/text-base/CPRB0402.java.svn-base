/* CIRA0502.java 報表
 程式目的：CIRA05
 程式代號：CIRA05
 程式日期：0950308
 程式作者：Eric.Chen
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
 --------------------------------------------------------
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

import tw.gov.nta.debt.form.Cprb0401Form;

public class CPRB0402 extends ExcelReportAction {
	public final short DEFAULT_PAPERSIZE = PageSize.A4_PAPERSIZE;
	public final boolean LANDSCAPE = false;
	protected boolean isLANDSCAPE() {return LANDSCAPE;}
	protected short getDEFAULT_PAPERSIZE() {return DEFAULT_PAPERSIZE;}

	@Override
	public String getJasperFileName() {
		return "CPRB04_RPT.jasper";
	}

	@Override
	public Map getReportParameter(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			Connection connection) {
		// TODO Auto-generated method stub
		Cprb0401Form myform = (Cprb0401Form) form;
		Map<String,Object> parameters = new HashMap<String,Object>();
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得製表日期
		String createDate = DateUtil.date2ChineseROC(DateUtil.date());
		parameters.put("usrId",usrId);
		parameters.put("createDate",createDate);
		parameters.put("year",myform.getYear());
		return parameters;
	}
}
