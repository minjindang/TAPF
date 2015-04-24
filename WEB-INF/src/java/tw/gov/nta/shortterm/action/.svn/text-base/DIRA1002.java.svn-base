/**
 * @author Andrew Sung
 * @create 2006/4/18
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

import tw.gov.nta.shortterm.form.Dira0701Form;
import tw.gov.nta.sql.BudgetRef;
import tw.gov.nta.system.common.BudgetCodeManager;

public class DIRA1002 extends JacobReportAction
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
		return "DIRA10";
	}

	@Override
	protected Map getReportParameter(ActionForm form, HttpServletRequest request)
	{
		Dira0701Form myForm = (Dira0701Form)form;
		Map<String,String> map = new LinkedHashMap<String,String>();
		//String createDate = DateUtil.date2Str(new Date(),"yyyy/mm/dd");
		//map.put( position, value );
		//map.put("Z1","TAPF");
		//map.put("H5",createDate);
		if(myForm.getBudgetCode()==null || myForm.getBudgetCode()==0)
				map.put("A2","短期借款含民營化基金及債務基金未償餘額彙總表-總表");
		else
		{
			BudgetRef dto = new BudgetRef();
			dto = BudgetCodeManager.get(myForm.getBudgetCode());
			map.put("A2","短期借款未償餘額彙總表-"+dto.getBudgetName());
		}
		if(myForm.getStartDate()!=null && myForm.getEndDate()!=null){
			map.put("A3","期間："+DateUtil.date2ChineseROC2(myForm.getStartDate())+"至"+DateUtil.date2ChineseROC2(myForm.getEndDate())+"止");
		}
		else if(myForm.getEndDate()!=null){
			map.put("A3","期間：至"+DateUtil.date2ChineseROC2(myForm.getEndDate())+"止");
		}else{
			map.put("A3","期間：至"+DateUtil.date2ChineseROC2(new Date())+"止");
		}
		return map;
	}

}
