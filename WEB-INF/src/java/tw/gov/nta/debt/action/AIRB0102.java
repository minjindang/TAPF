/* AIRB0102.java ����
 �{���ت��GAIRB01
 �{���N���GAIRB01
�{������G0950316
 �{���@�̡Gicefire
 --------------------------------------------------------
 �ק�@�̡@�@�ק����@�@�@�ק�ت�
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
		//���Y���
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
			//���S���
			if ("".equals(budName) && "".equals(debtName))
				map.put("A1",debtShortName+"(�`��)");
			//��ӳ���
			else if (!"".equals(budName) && !"".equals(debtName))
				map.put("A1",debtShortName+"("+budName+"/"+debtName+")");
			//��䤤�@��
			else
				map.put("A1",debtShortName+"("+budName+debtName+")");
//			20110824�}���ͭn�D�n�W�B�o��A�n��ܭ�o���
			map.put("F2","���إ���"+DateUtil.date2ChineseROC2((Date)mainMap.get("origin_issue_date")));
			map.put("F3",(null==String.valueOf(mainMap.get("ticket_count"))?"0":new StringUtil().addThousandMark(new BigDecimal((Long)mainMap.get("ticket_count"))))+"�i");
			map.put("F4","�s�x��"+new StringUtil().addThousandMark(((BigDecimal)mainMap.get("issue_amount")))+"��");
			map.put("F5",String.valueOf((((BigDecimal)mainMap.get("average_rate")).setScale(3,5)).doubleValue())+"%");
			map.put("F6",("4".equals((String)mainMap.get("bond_kind"))?"�洫����":"")+("Y".equals((String)mainMap.get("bond_sell_status"))?"�i���Τ���":""));
		}
		map.put("J6","���إ���"+DateUtil.date2ChineseROC2(new Date()));
		//������
		Map backMap = new HashMap();
		int index = 0;
		String key = "Z";
		String wSet = "";
		
		//String [] field = {"budget_code","debt_code","issue_date","issue_amount","kind"};
		//String [] fieldName = {"�W�B���Źw��O�G","�W�B���ŵo�����G���إ���","�W�B�o����B�G","�Ƶ��G"};
		if(null != backList && 0 != backList.size())
		{	
			for(Iterator it1=backList.iterator();it1.hasNext();){
				backMap = (Map) it1.next();
				index++;
				wSet = key + String.valueOf(index);
				//�W�B���Źw��O
				String backbudName =  "";
				String backdebtName = "";
				String tailString = new String("");
				if("3".equals((String)(backMap.get("bond_kind"))))
				{
					tailString = "�W�B";
				}
	
				if (tw.gov.nta.system.common.BudgetCodeManager.get(Integer.parseInt(String.valueOf(backMap.get("budget_code")))) != null)
					backbudName = tw.gov.nta.system.common.BudgetCodeManager.get(Integer.parseInt(String.valueOf(backMap.get("budget_code")))).getBudgetName();
				if (tw.gov.nta.system.common.DebitCodeManage.get(Integer.parseInt(String.valueOf(backMap.get("debt_code")))) !=  null)
					backdebtName = tw.gov.nta.system.common.DebitCodeManage.get(Integer.parseInt(String.valueOf(backMap.get("debt_code")))).getDebitName();
				if ("".equals(backbudName) && "".equals(backdebtName))
					map.put(wSet,tailString + "���Źw��O�G" + "");
				else if (!"".equals(backbudName) && !"".equals(backdebtName))
					map.put(wSet,tailString + "���Źw��O�G"+backbudName + "/" + backdebtName);
				else
					map.put(wSet,tailString + "���Źw��O�G"+ backbudName + backdebtName);
				//�W�B���ŵo����
				index++;
				wSet = key + String.valueOf(index);
				if (backMap.get("issue_date") != null)
					map.put(wSet,tailString + "���ŵo�����G���إ���"+ DateUtil.date2ChineseROC2((Date)backMap.get("issue_date")));
				else
					map.put(wSet,tailString + "���ŵo�����G");
				//�W�B�o����B
				index++;
				wSet = key + String.valueOf(index);	
				map.put(wSet,tailString + "�o����B�G"+ new StringUtil().addThousandMark(((BigDecimal)backMap.get("issue_amount")).setScale(0,5))+" ��");
				//�Ƶ�
				index++;
				wSet = key + String.valueOf(index);
				map.put(wSet,"�Ƶ��G"+ backMap.get("kind"));
			}
		}	
		map.put("AA1", null!=request.getAttribute("totalCapitalAmount")?request.getAttribute("totalCapitalAmount").toString():"0");
		map.put("AA2", null!=request.getAttribute("totalInterestAmount")?request.getAttribute("totalInterestAmount").toString():"0");
		return map;
	}

} 
