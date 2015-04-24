/* AIRC0702.java 報表
 程式目的：AIRC07
 程式代號：AIRC07
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

import tw.gov.nta.debt.form.Airc0701Form;

public class AIRC0702 extends ExcelReportAction {
	public static short DEFAULT_PAPERSIZE = PageSize.A3_PAPERSIZE;
	public static boolean LANDSCAPE = true;

	@Override
	public String getJasperFileName() {
		return "AIRC07_RPT1.jasper";
	}

	@Override
	public Map getReportParameter(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			Connection connection) {
		// TODO Auto-generated method stub
		Airc0701Form myform = (Airc0701Form) form;
		Map<String,Object> parameters = new HashMap<String,Object>();
		//取得使用者帳號
		String usrId = this.getUserId(request);
		String year = new String();
		String month = new String();
		//取得製表日期
		if(null != myform.getLimitDate() && !"".equals(myform.getLimitDate()))
		{
			year = Integer.toString(Integer.parseInt(myform.getLimitDate().substring(0,3)));
			month = Integer.toString(Integer.parseInt(myform.getLimitDate().substring(3,5)));
		}	
		String createDate = DateUtil.date2ChineseROC2(DateUtil.date());
		parameters.put("usrId",usrId);
		parameters.put("createDate",createDate);
		parameters.put("issueSerial",myform.getIssueSerial());
		parameters.put("limitDate",year +"年"+ month +"月");
		return parameters;
	}

	@Override
	protected boolean isLANDSCAPE() {
		// TODO 自動產生方法 Stub
		return LANDSCAPE;
	}

	@Override
	protected short getDEFAULT_PAPERSIZE() {
		// TODO 自動產生方法 Stub
		return DEFAULT_PAPERSIZE;
	}

}
