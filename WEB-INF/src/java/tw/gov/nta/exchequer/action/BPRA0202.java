/**
 * @author Andrew Sung
 * @create 2006/4/11
 */

package tw.gov.nta.exchequer.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.exchequer.form.Bpra0201Form;

public class BPRA0202 extends JacobReportAction
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
		// TODO Auto-generated method stub
		return "BPRA02";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request)
	{
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		Bpra0201Form myForm = (Bpra0201Form)form;
		String DateStart = DateUtil.date2ChineseROC2(myForm.getStatrDate());
		String DateEnd = DateUtil.date2ChineseROC2(myForm.getEndDate());
		String createDate = DateUtil.date2ChineseROC2(new Date());
		String usrId = this.getUserId(request);
		
		map.put("Y1",DateStart);
		map.put("Y2",DateEnd);
		map.put("Y3",createDate);
	    map.put("A3","中華民國 "+DateStart+" 至 "+DateEnd+" 止");
		map.put("B5","　　　　　製表日期："+createDate);
		map.put("Z1","新台幣元");
		map.put("Z2","財政部國庫署(3)");
		map.put("Z3",usrId);
		return map;
	}

}
