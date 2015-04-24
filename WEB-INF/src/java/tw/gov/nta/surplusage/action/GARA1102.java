/**
 * @author Andrew Sung
 * @create 2006/4/12
 */

package tw.gov.nta.surplusage.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.surplusage.form.Gara1101Form;
import tw.gov.nta.system.common.CodeDetManage;

public class GARA1102 extends JacobReportAction
{
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Gara1101Form myForm = (Gara1101Form)form;
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		String createDate = DateUtil.date2ChineseROC2(new Date());
		if (myForm.getCreateDate() != null){
			createDate = DateUtil.date2ChineseROC2(myForm.getCreateDate());
		}
		BigDecimal lastYearNoPay_B = (BigDecimal)request.getAttribute("lastYearNoPay_B");
		BigDecimal lastYearNoPay_D = (BigDecimal)request.getAttribute("lastYearNoPay_D");
		map.put("Z3",DateUtil.date2Str(DateUtil.str2Date(DateUtil.getLastDateOfMonth(myForm.getStartYear(),"01")),"yyyy/mm/dd"));
		map.put("Z4","新台幣"+CodeDetManage.getCodeName("BU",myForm.getAmountUnit().toString()));
		map.put("Z5", DateUtil.numToChinese(String.valueOf( Integer.valueOf( (String) myForm.getStartYear())-1 )) );
		map.put("A3","製表日期："+createDate);
		map.put("C45",String.valueOf(lastYearNoPay_B));
		map.put("D45",String.valueOf(lastYearNoPay_D));
		map.put("E45",String.valueOf(lastYearNoPay_B.add(lastYearNoPay_D)));
		String memo = request.getAttribute("memo").toString();
		map.put("Z200",memo);
		return map;
	}

	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form,request),getRealPath());
	}

	@Override
	protected String getProgramId(HttpServletRequest request)
	{
		return "GARA11";
	}
}
