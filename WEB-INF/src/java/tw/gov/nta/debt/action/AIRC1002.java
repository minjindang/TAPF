/* AIRC1002.java 報表
 程式目的：AIRC10
 程式代號：AIRC10
 程式日期：0950308
 程式作者：Eric.Chen
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
 --------------------------------------------------------
 */
package tw.gov.nta.debt.action;

import gov.dnt.tame.common.PageSize;
import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.ExcelReportAction;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import tw.gov.nta.debt.form.Airc0901Form;
import tw.gov.nta.debt.form.Airc1001Form;
import tw.gov.nta.system.common.CodeDetManage;

public class AIRC1002 extends JacobReportAction {

	private final static String PROGRAM_ID = "AIRC10";
	protected ReportManager getReportManager(ActionForm form,
			HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}
	protected String getProgramId(HttpServletRequest request) {
		return PROGRAM_ID;
	}
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Airc1001Form airc1001Form = (Airc1001Form) form;
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		String AmountUnit = airc1001Form.getAmountUnit();
		String AmountUnitLabel = "";
		String queryYear = "";
		String kind = request.getParameter("kind");
		
		/**
		如選擇種類：公債
		產出報表標題：中央登錄債券持有對象分析彙總表
		如選擇種類：國庫券
		產出報表標題：登錄國庫券持有對象分析彙總表
		**/
		if("B".equals(kind))
			map.put("A2","登錄國庫券持有對象分析彙總表");
		else
			map.put("A2","中央登錄債券持有對象分析彙總表");
		
		if(!airc1001Form.getLimitSDate().equals(""))
			queryYear = queryYear+airc1001Form.getLimitSDate().substring(0, 3)+"年"+airc1001Form.getLimitSDate().substring(3, 5)+"月";
		if(!airc1001Form.getLimitEDate().equals(""))
			queryYear = queryYear+"至"+airc1001Form.getLimitEDate().substring(0, 3)+"年"+airc1001Form.getLimitEDate().substring(3, 5)+"月";
		//if (AmountUnit.equals("0"))
			//AmountUnit ="1";
		//因為使用新版SQL，此數值已不處理，改為在EXCEL處理，並將其設定為億元
		map.put("A3",queryYear);
		//map.put("N6","新台幣"+CodeDetManage.getCodeName("BU",AmountUnit));
		
		List dataList = (List)request.getAttribute("dataList");
		if(dataList != null){
			int startRow = 10;
			for(int i = 0 ; i < dataList.size() ; i ++){
				Map dataMap = (Map)dataList.get(i);
				map.put("A"+startRow,String.valueOf(dataMap.get("year_month")));
				map.put("B"+startRow,String.valueOf(dataMap.get("sum_1")));
				map.put("D"+startRow,String.valueOf(dataMap.get("sum_2")));
				map.put("F"+startRow,String.valueOf(dataMap.get("sum_3")));
				map.put("H"+startRow,String.valueOf(dataMap.get("sum_4")));
				map.put("J"+startRow,String.valueOf(dataMap.get("sum_5")));
				map.put("L"+startRow,String.valueOf(dataMap.get("sum_6")));
				map.put("N"+startRow,String.valueOf(dataMap.get("sum_7")));
				map.put("P"+startRow,String.valueOf(dataMap.get("sum_8")));
				map.put("R"+startRow,String.valueOf(dataMap.get("sum_9")));
				map.put("T"+startRow,String.valueOf(dataMap.get("sum_10")));
			}
		}
		return map;
	}
	
}