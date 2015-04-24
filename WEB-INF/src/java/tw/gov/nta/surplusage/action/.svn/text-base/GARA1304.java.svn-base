package tw.gov.nta.surplusage.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.surplusage.form.Gara1301Form;


public class GARA1304 extends JacobReportAction {

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		
		//String createDate = DateUtil.date2Str(new Date(),"yyyy/mm/dd");
		//String createDate = DateUtil.date2ChineseROC(DateUtil.date());
		
		Gara1301Form myForm = (Gara1301Form)form;
		String createDate = DateUtil.date2ChineseROC2(new Date());
		if (myForm.getCreateDate() != null){
			createDate = DateUtil.date2ChineseROC2(myForm.getCreateDate());
		}
		int year_2 = Integer.parseInt(myForm.getIssueSdate())+2;
		String yearStr_2 = null;
		if (year_2<10)
			yearStr_2 = "00" + year_2;
		else if (year_2<100)
			yearStr_2 = "0" + year_2;
		else
			yearStr_2 = "" + year_2;
		int year_1 = Integer.parseInt(myForm.getIssueSdate())+1;
		String yearStr_1 = null;
		if (year_1<10)
			yearStr_1 = "00" + year_1;
		else if (year_1<100)
			yearStr_1 = "0" + year_1;
		else
			yearStr_1 = "" + year_1;
		String AmountUnit = myForm.getAmountUnit();
		String AmountUnitLabel = "";
		if (AmountUnit.equals("1"))
			AmountUnitLabel = "元" ;
		else if (AmountUnit.equals("1000"))
			AmountUnitLabel = "千元" ;
		else if (AmountUnit.equals("1000000"))
			AmountUnitLabel = "百萬元" ;
		else if (AmountUnit.equals("100000000"))
			AmountUnitLabel = "億元" ;
		else if (AmountUnit.equals("1000000000"))
			AmountUnitLabel = "十億元" ;
        map.put("F2","("+AmountUnitLabel+")");
		map.put("A2","製表日期："+createDate);
		map.put("C3",myForm.getIssueSdate());
		map.put("D3",yearStr_1);
		map.put("E3",yearStr_2);
		map.put("Z1",request.getAttribute("memoB"));
		map.put("Z2",request.getAttribute("memoD"));
		String memo = request.getAttribute("memo").toString();
		map.put("Z200",memo);

		return map;
	}


	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}

	@Override
	protected String getProgramId(HttpServletRequest request)
	{
		return "GARA13_2";
	}
	
	/*
	@Override
	protected String getProgramId(HttpServletRequest request)
	{
		return (String)request.getAttribute("file");
	}

	@Override
	protected String getProgramName(Connection connection, String programId) throws SQLException {
		// TODO Auto-generated method stub
		return super.getProgramName(connection,"GARA64");
	}
	
	*/
}
