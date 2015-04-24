/**
 * @author Andrew Sung
 * @create 2006/4/14
 */

package tw.gov.nta.shortterm.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.shortterm.form.Dira0701Form;
import tw.gov.nta.sql.BudgetRef;
import tw.gov.nta.system.common.BudgetCodeManager;

public class DIRA0502 extends JacobReportAction
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
		return "DIRA05";
	}

	@Override
	protected Map getReportParameter(ActionForm form, HttpServletRequest request)
	{
		Dira0701Form myForm = (Dira0701Form)form;
		Map<String,String> map = new LinkedHashMap<String,String>();
		String createDate = DateUtil.date2ROCStr(new Date(),"yyy/mm/dd");

		if(myForm.getBudgetCode()==null || myForm.getBudgetCode()==0)
				map.put("A1","表19     財政部國庫署短期借款債務概況表");
		else
		{
			
			if(myForm.getBudgetCode()!=0){
				BudgetRef dto = new BudgetRef();
				dto = BudgetCodeManager.get(myForm.getBudgetCode());
				map.put("A1","表19     財政部國庫署短期借款債務概況表-"+dto.getBudgetName());
			}
			else
				map.put("A1","表19     財政部國庫署短期借款債務概況表");
		}
//		map.put("Z1",noPayAmount.toString());
		map.put("Z1",request.getAttribute("total").toString());
		map.put("Z2",request.getAttribute("memo").toString());
		return map;
	}

}
