/* AIRB0102.java 報表
 程式目的：AIRB01
 程式代號：AIRB01
程式日期：0950316
 程式作者：icefire
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
 --------------------------------------------------------
 */

package tw.gov.nta.debt.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;
import gov.dnt.tame.util.StringUtil;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Airb0101Form;

public class AIRB0102 extends JacobReportAction {
	@Override
	protected ReportManager getReportManager(ActionForm form,
			HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}

	@Override
	protected String getProgramId(HttpServletRequest request)
	{
		return "AIRB01";
	}
	@SuppressWarnings({"static-access","unchecked"})
	protected Map getReportParameter(ActionForm form, HttpServletRequest request)
	{
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		Airb0101Form myform = (Airb0101Form) form;
		//表頭資料
		Map mainMap = (Map)request.getAttribute("mainMap");
		List backList = (List)request.getAttribute("backList");
		if (mainMap != null){
			String debtShortName = (String)mainMap.get("debt_name");
			String budName = "";
			String debtName = "";
			if (!"".equals(myform.getBudgetCode()))
				budName = tw.gov.nta.system.common.BudgetCodeManager.get(Integer.parseInt(myform.getBudgetCode())).getBudgetName();
			if (!"".equals(myform.getDebtCode()))
				debtName = tw.gov.nta.system.common.DebitCodeManage.get(Integer.parseInt(myform.getDebtCode())).getDebitName();
			//都沒選擇
			if ("".equals(budName) && "".equals(debtName))
				map.put("A1",debtShortName+"(總表)");
			//兩個都選
			else if (!"".equals(budName) && !"".equals(debtName))
				map.put("A1",debtShortName+"("+budName+"/"+debtName+")");
			//選其中一個
			else
				map.put("A1",debtShortName+"("+budName+debtName+")");
//			20110824徐先生要求要增額發行，要顯示原發行日
			map.put("F2","中華民國"+DateUtil.date2ChineseROC2((Date)mainMap.get("origin_issue_date")));
			map.put("F3",(null==String.valueOf(mainMap.get("ticket_count"))?"0":new StringUtil().addThousandMark(new BigDecimal((Long)mainMap.get("ticket_count"))))+"張");
			map.put("F4","新台幣"+new StringUtil().addThousandMark(((BigDecimal)mainMap.get("issue_amount")))+"元");
			map.put("F5",String.valueOf((((BigDecimal)mainMap.get("average_rate")).setScale(3,5)).doubleValue())+"%");
			map.put("F6",("4".equals((String)mainMap.get("bond_kind"))?"交換公債":"")+("Y".equals((String)mainMap.get("bond_sell_status"))?"可分割公債":""));
		}
		map.put("J6","中華民國"+DateUtil.date2ChineseROC2(new Date()));
		//表尾資料
		Map backMap = new HashMap();
		int index = 0;
		String key = "Z";
		String wSet = "";
		
		//String [] field = {"budget_code","debt_code","issue_date","issue_amount","kind"};
		//String [] fieldName = {"增額公債預算別：","增額公債發行日期：中華民國","增額發行金額：","備註："};
		if(null != backList && 0 != backList.size())
		{	
			for(Iterator it1=backList.iterator();it1.hasNext();){
				backMap = (Map) it1.next();
				index++;
				wSet = key + String.valueOf(index);
				//增額公債預算別
				String backbudName =  "";
				String backdebtName = "";
				String tailString = new String("");
				if("3".equals((String)(backMap.get("bond_kind"))))
				{
					tailString = "增額";
				}
	
				if (tw.gov.nta.system.common.BudgetCodeManager.get(Integer.parseInt(String.valueOf(backMap.get("budget_code")))) != null)
					backbudName = tw.gov.nta.system.common.BudgetCodeManager.get(Integer.parseInt(String.valueOf(backMap.get("budget_code")))).getBudgetName();
				if (tw.gov.nta.system.common.DebitCodeManage.get(Integer.parseInt(String.valueOf(backMap.get("debt_code")))) !=  null)
					backdebtName = tw.gov.nta.system.common.DebitCodeManage.get(Integer.parseInt(String.valueOf(backMap.get("debt_code")))).getDebitName();
				if ("".equals(backbudName) && "".equals(backdebtName))
					map.put(wSet,tailString + "公債預算別：" + "");
				else if (!"".equals(backbudName) && !"".equals(backdebtName))
					map.put(wSet,tailString + "公債預算別："+backbudName + "/" + backdebtName);
				else
					map.put(wSet,tailString + "公債預算別："+ backbudName + backdebtName);
				//增額公債發行日期
				index++;
				wSet = key + String.valueOf(index);
				if (backMap.get("issue_date") != null)
					map.put(wSet,tailString + "公債發行日期：中華民國"+ DateUtil.date2ChineseROC2((Date)backMap.get("issue_date")));
				else
					map.put(wSet,tailString + "公債發行日期：");
				//增額發行金額
				index++;
				wSet = key + String.valueOf(index);	
				map.put(wSet,tailString + "發行金額："+ new StringUtil().addThousandMark(((BigDecimal)backMap.get("issue_amount")).setScale(0,5))+" 元");
				//備註
				index++;
				wSet = key + String.valueOf(index);
				map.put(wSet,"備註："+ backMap.get("kind"));
			}
		}	
		map.put("AA1", null!=request.getAttribute("totalCapitalAmount")?request.getAttribute("totalCapitalAmount").toString():"0");
		map.put("AA2", null!=request.getAttribute("totalInterestAmount")?request.getAttribute("totalInterestAmount").toString():"0");
		return map;
	}

} 
