/**
 * @author AndrewSung
 * @date 2006/3/10
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
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import tw.gov.nta.debt.form.Apra2001Form;
import tw.gov.nta.debt.form.Apra2101Form;
public class APRA2002 extends JacobReportAction{

	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "APRA20";
	}
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		Apra2001Form myform = (Apra2001Form)form;
		String debtName = "";
		String[] key = new String[]{"55C","56C","57A","57C","58A","59A","60A","61A","62A","64B","70B","71B","72B","73B","74B","75B","76B","77B","78B","80B","81B","82B","83B","84B","85B","86B","BAB","BCB","BDB甲","BDB乙"};
		String[] values = new String[]{"五十五年度愛國公債","五十六年度愛國公債","五十七年度公債","五十七年度愛國公債","五十八年度公債","五十九年度公債","六十年度公債","六十一年度公債","六十二年度公債","中央政府建設公債64年度公債","中央政府建設公債70年度公債","中央政府建設公債71年度公債","中央政府建設公債72年度公債","中央政府建設公債73年度公債","中央政府建設公債74年度公債","中央政府建設公債75年度公債","中央政府建設公債76年度公債","中央政府建設公債77年度公債","中央政府建設公債78年度公債","中央政府建設公債80年度公債","中央政府建設公債81年度公債","中央政府建設公債82年度公債","中央政府建設公債83年度公債","中央政府建設公債84年度公債","中央政府建設公債85年度公債","中央政府建設公債86年度公債","高速公路債票","北二高債票","中央政府重大交通建設公債(甲類)","中央政府重大交通建設公債(乙類)"};
		for(int i = 0 ; i < key.length;i++){
			if(myform.getDebtName().trim().equals(key[i]))
				debtName = values[i];
		}
		map.put("K4", "製表日期："+new DateUtil().date2ChineseROC2(new Date()));
		map.put("A6", "公債名稱："+debtName);
		return map;
	}
}