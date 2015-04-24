package tw.gov.nta.account.action;


import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;


/**
 * @author Mulder
 *
 * TODO �p�G�n�ܧ�o�Ӳ��ͪ����O���Ѫ��d���A�в���
 * ���� - �ߦn�]�w - Java - �{���X�˦� - �{���X�d��
 */
public class EARE1003 extends JacobReportAction{
	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "EARE10";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
//		if (request.getAttribute("debt_name")!=null)
//			map.put("A2",request.getAttribute("debt_name"));

//		map.put("A3", "�o�����G" + DateUtil.date2ChineseROC2((Date)request.getAttribute("issue_date")));
//		map.put("B3", "�������G" + DateUtil.date2ChineseROC2((Date)request.getAttribute("cash_due_date")));
//		map.put("A4", "�R�^����G" + DateUtil.date2ChineseROC2((Date)request.getAttribute("due_date")));
//		map.put("B4", "�Z�����ѼơG" + request.getAttribute("early_due_date") + "��");
//		map.put("A5", "�s����:" + DateUtil.date2ChineseROC2(new Date()));
		return map;
	}

	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}
}
