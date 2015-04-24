package tw.gov.nta.surplusage.action;

import gov.dnt.tame.common.PageSize;
import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.ExcelReportAction;
import gov.dnt.tame.util.StringUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import tw.gov.nta.account.form.AccountQueryForm;

public class GARA3502 extends ExcelReportAction 
{
	public final short DEFAULT_PAPERSIZE = PageSize.A3_PAPERSIZE;

	@Override
	protected boolean isLANDSCAPE() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected short getDEFAULT_PAPERSIZE() {
		// TODO Auto-generated method stub
		return DEFAULT_PAPERSIZE;
	}

	@Override
	public String getJasperFileName() {
		// TODO Auto-generated method stub
		return "GARA35_RPT.jasper";
	}

	@Override
	public Map getReportParameter(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			Connection connection) 
	{
		AccountQueryForm myForm = (AccountQueryForm) form;
		Map<String,Object> parameters = new HashMap<String,Object>();
		String usrId = this.getUserId(request);//使用者
		StringUtil util = new StringUtil();
		BigDecimal amount = (BigDecimal)request.getAttribute("amount");
		String amountStr = "0";
		
		if (amount != null){
			amountStr = util.addThousandMark2(amount);
		}else{
			amount = new BigDecimal(0);
		}
			
		
		
		String titleYM ;//抬頭
		String printDate = DateUtil.date2ROCStr(new Date());//列印日期
		titleYM = "截至 " + myForm.getAccountYear() + " 年 "+myForm.getMonth()+" 月 底止";
		printDate = printDate.substring(0,3) + "年" + printDate.substring(3,5) + 
						"月" + printDate.substring(5,7) + "日";
		
		parameters.put("titleYM",titleYM);//抬頭
		parameters.put("printDate",printDate);//列印日期
		parameters.put("usrId", usrId);//使用者
		parameters.put("amount",amount);
		parameters.put("amountStr",amountStr);
		
		//表尾
		parameters.put("cutDate",DateUtil.date2ROCStr(DateUtil.str2Date(DateUtil.getLastDateOfMonth(myForm.getAccountYear(),myForm.getMonth())),"yyy.mm.dd"));
		// TODO Auto-generated method stub
		return parameters;
	}

}
