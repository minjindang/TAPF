/* AIRC0802.java 報表
 程式目的：AIRC08
 程式代號：AIRC08
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

import tw.gov.nta.debt.form.Airc0801Form;

public class AIRC0802 extends ExcelReportAction {
	public final short DEFAULT_PAPERSIZE = PageSize.A3_PAPERSIZE;
	public final boolean LANDSCAPE = true;
	protected boolean isLANDSCAPE() {return LANDSCAPE;}
	protected short getDEFAULT_PAPERSIZE() {return DEFAULT_PAPERSIZE;}

	@Override
	public String getJasperFileName() {
		return "AIRC08_RPT1.jasper";
	}

	@Override
	public Map getReportParameter(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			Connection connection) {
//		 TODO Auto-generated method stub
		Airc0801Form myform = (Airc0801Form) form;
		Map<String,Object> parameters = new HashMap<String,Object>();
		//取得使用者帳號
		String usrId = this.getUserId(request);
		String year = new String();
		String month = new String();
		if(null != myform.getLimitDate() && !"".equals(myform.getLimitDate()))
		{
			year = Integer.toString(Integer.parseInt(myform.getLimitDate().substring(0,3)));
			month = Integer.toString(Integer.parseInt(myform.getLimitDate().substring(3,5)));
		}
		//取得製表日期
		String createDate = DateUtil.date2ChineseROC2(DateUtil.date());
		parameters.put("usrId",usrId);
		parameters.put("createDate",createDate);
		parameters.put("issueSerial",myform.getIssueSerial());
		parameters.put("limitDate",year +"年"+ month +"月");
		return parameters;
	}

}
