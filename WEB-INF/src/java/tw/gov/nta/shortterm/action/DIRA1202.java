/**
 * @author Andrew Sung
 * @create 2006/4/18
 */

package tw.gov.nta.shortterm.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.shortterm.form.Dira1201Form;

public class DIRA1202 extends JacobReportAction
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
		return "DIRA12";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request)
	{
		Dira1201Form myForm = (Dira1201Form)form;
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		String createDate = DateUtil.date2ChineseROC2(new Date());
		//map.put( position, value );
		//map.put("F4",createDate);
		String baseDate = DateUtil.date2ROCStr(new Date());
		if(myForm.getBaseDate() != null )
			baseDate = DateUtil.date2ROCStr(myForm.getBaseDate());
		
		if(myForm.getAccountYear() != null && !"".equals(myForm.getAccountYear()))
			map.put("A2",myForm.getAccountYear()+"�~�׵u���ɴڦU�Ȧ��B�ת�");
		
		map.put("A3","�I��"+baseDate.substring(0,3)+"�~"+baseDate.substring(3,5)+"��"+baseDate.substring(5,7)+"���");
		//map.put("A3","�I��"+String.valueOf(myForm.getBaseDate().getDate()-11)+"�~"+(myForm.getBaseDate().getMonth()+1)+"��"+myForm.getBaseDate().getDate()+"���");
		map.put("Z4",request.getAttribute("memo").toString());
		map.put("F5","�s�����G"+createDate);
		map.put("Z1",request.getAttribute("contractAmount").toString());
		map.put("Z2",request.getAttribute("borrow").toString());
		return map;
	}

}
