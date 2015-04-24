package tw.gov.nta.surplusage.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.surplusage.form.Gara2501Form;
import tw.gov.nta.system.common.CodeDetManage;

public class GARA2502 extends JacobReportAction {
	
	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "GARA25";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		Gara2501Form myform = (Gara2501Form)form;
		String createDate = DateUtil.date2ChineseROC2(new Date());
		String memo = request.getAttribute("memo").toString();
		map.put("Z200",memo);
		map.put("A4","製表日期："+createDate);
		map.put("S3","單位：新台幣"+CodeDetManage.getCodeName("BU",myform.getAmountUnit().toString()));
		return map;
	}
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}
	
	@Override
	protected String getProgramName(Connection connection, String programId) throws SQLException {
		// TODO Auto-generated method stub
		return super.getProgramName(connection,"GARA25");
	}
}
