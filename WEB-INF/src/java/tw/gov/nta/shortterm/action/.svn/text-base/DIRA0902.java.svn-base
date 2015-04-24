/**
 * @author Andrew Sung
 * @create 2006/4/14
 */

package tw.gov.nta.shortterm.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.shortterm.form.Dira0901Form;
import tw.gov.nta.sql.BudgetRef;
import tw.gov.nta.system.common.BudgetCodeManager;

public class DIRA0902 extends JacobReportAction
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
		return "DIRA09";
	}

	@Override
	protected Map getReportParameter(ActionForm form, HttpServletRequest request)
	{
		Dira0901Form myForm = (Dira0901Form)form;
		Map<String,String> map = new LinkedHashMap<String,String>();
		//String createDate = DateUtil.date2Str(new Date(),"yyyy/mm/dd");
		//map.put( position, value );
		map.put("Z1","TAPF");
		//map.put("G5",createDate);
		if(myForm.getBudgetCode()==null || myForm.getBudgetCode()==0)
				map.put("A2","短期借款未償餘額-總表");
		else
		{
			BudgetRef dto = new BudgetRef();
			dto = BudgetCodeManager.get(myForm.getBudgetCode());
			map.put("A2","短期借款未償餘額-"+dto.getBudgetName());
		}
		
		map.put("A3","自"+myForm.getStartAccountYear()+"年度至"+myForm.getEndAccountYear()+"年度");
		map.put("G5","製表日期："+DateUtil.date2ChineseROC2(new Date()));
		return map;
	}

}
