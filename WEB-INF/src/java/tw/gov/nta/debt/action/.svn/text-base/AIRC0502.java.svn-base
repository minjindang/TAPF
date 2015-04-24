/* AIRC0502.java 報表
 程式目的：AIRC05
 程式代號：AIRC05
程式日期：0950316
 程式作者：icefire
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

import tw.gov.nta.debt.form.Airc0501Form;

public class AIRC0502 extends ExcelReportAction {
	public final short DEFAULT_PAPERSIZE = PageSize.A3_PAPERSIZE;
	public final boolean LANDSCAPE = true;
	protected boolean isLANDSCAPE() {return LANDSCAPE;}
	protected short getDEFAULT_PAPERSIZE() {return DEFAULT_PAPERSIZE;}
	
	@Override
	public String getJasperFileName() {
		return "AIRC05_RPT1.jasper";
	}

	@Override
	public Map getReportParameter(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			Connection connection) {
		Map<String,Object> parameters = new HashMap<String,Object>();
		Airc0501Form myform = (Airc0501Form)form;
		//取得使用者帳號
		String limitDate = "";
		if(null != myform.getLimitDate())
		{
			limitDate = DateUtil.date2ChineseROC2(myform.getLimitDate());
		}	
		parameters.put("usrId", this.getUserId(request) );
		//取得製表日期
		parameters.put("createDate", DateUtil.date2ChineseROC2(DateUtil.date()) );
		parameters.put("P1",limitDate);
		return parameters;
	}
}
