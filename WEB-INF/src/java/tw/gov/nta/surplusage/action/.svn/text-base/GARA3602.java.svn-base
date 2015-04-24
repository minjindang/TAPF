package tw.gov.nta.surplusage.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;

public class GARA3602 extends JacobReportAction
{
	private final static String TEMP_TABLE_NAME = "GARA36_RPT";
	private final static String PROGRAM_ID = "GARA36";

	protected String getProgramId(HttpServletRequest request) {
		return PROGRAM_ID;
	}

	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		AccountQueryForm myForm = (AccountQueryForm) form;
		String qryYear = myForm.getAccountYear();
		String qryMonth = myForm.getMonth();
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		if (!"".equals(qryYear))
			map.put("A3","截至中華民國"+DateUtil.date2ChineseROC2( DateUtil.str2Date( DateUtil.getLastDateOfMonth(qryYear,qryMonth) ) ) +"止");
		else
			map.put("A3","");
		map.put("A5","製表日期:"+DateUtil.date2ChineseROC2(new Date()));

		List dataList = (List) request.getAttribute( TEMP_TABLE_NAME );
		for( Iterator it=dataList.iterator();it.hasNext(); )
		{
			Map dataMap = (Map) it.next();
			String type = (String) dataMap.get("type");
			if( !"X".equals( type ) )
			{
				String cell = String.valueOf(Integer.parseInt(type)+8);
				map.put("C"+cell, confirmObject( dataMap.get("budget_amount") ) );
				map.put("D"+cell, confirmObject( dataMap.get("real_amount") ) );
				map.put("E"+cell, confirmObject( dataMap.get("t1") ) );
				map.put("F"+cell, confirmObject( dataMap.get("t2") ) );
				map.put("G"+cell, confirmObject( dataMap.get("t3") ) );
				map.put("H"+cell, confirmObject( dataMap.get("t4") ) );
				map.put("I"+cell, confirmObject( dataMap.get("t5") ) );
				map.put("J"+cell, confirmObject( dataMap.get("t6") ) );
				map.put("K"+cell, confirmObject( dataMap.get("t7") ) );
			}
		}
		map.put("Z1",request.getAttribute("remark1") );
		map.put("Z2",request.getAttribute("remark2") );
		map.put("Z3",request.getAttribute("remark3") );
		return map;
	}
	
	private String confirmObject(Object obj)
	{
		String replaceStr = "0";
//		String replaceStr = "－";
		String str = String.valueOf( obj );
		if( "null".equals( str ) )
			return replaceStr;
		else if( "0".equals( str ) )
			return replaceStr;
		else if( "0.000000".equals( str ) )
			return replaceStr;
		else
			return str;
	}
}
