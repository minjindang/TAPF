/**
*
* @author Andrew Sung
* @createDate 2006/6/22
*/
package tw.gov.nta.central.action;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

import tw.gov.nta.central.form.Hama0101Form;
import tw.gov.nta.central.form.Hama0301Form;
import tw.gov.nta.debt.form.Airb0101Form;
import tw.gov.nta.debt.form.Airb0501Form;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

public class HAMA0105 extends JacobReportAction {
	@Override
	protected ReportManager getReportManager(ActionForm form,
			HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}

	@Override
	protected String getProgramId(HttpServletRequest request)
	{
		return "HAMA01";
	}
	@SuppressWarnings({"static-access","unchecked"})
	protected Map getReportParameter(ActionForm form, HttpServletRequest request)
	{
		Map<String,String> map = new LinkedHashMap<String,String>();
		map.put("F3","製表日期:"+DateUtil.date2ROCStr(new Date(),"yyy/mm/dd"));
		return map;
	}


}
