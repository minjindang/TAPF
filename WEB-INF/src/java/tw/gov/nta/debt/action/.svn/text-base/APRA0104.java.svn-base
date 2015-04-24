package tw.gov.nta.debt.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Apra0101Form;

public class APRA0104 extends JacobReportAction {

	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "APRA01B";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		Apra0101Form myform = (Apra0101Form)form;
		map.put("A2","中華民國   " + addMark(DateUtil.date2ChineseROC2(myform.getRepaySdate()),3," ") + "至   "+ addMark(DateUtil.date2ChineseROC2(myform.getRepayEdate()),3," "));
		return map;
	}
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}
	public String addMark(String str,int value,String add)
	{
		StringBuffer newStr = new StringBuffer();
		
		for(int i=0;i<str.length();i++)
		{
			newStr.append(str.substring(i,i+1));
			for(int j=0;j<value;j++)
			{
				newStr.append(add);
			}	
		}	
		return newStr.toString();
	}

}
