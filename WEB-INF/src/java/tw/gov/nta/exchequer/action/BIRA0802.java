package tw.gov.nta.exchequer.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.exchequer.form.Bira0801Form;

/**
 * @author Jack Du
 *
 * TODO �p�G�n�ܧ�o�Ӳ��ͪ����O���Ѫ��d���A�в���
 * ���� - �ߦn�]�w - Java - �{���X�˦� - �{���X�d��
 */
public class BIRA0802 extends JacobReportAction{
	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "BIRA08";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Bira0801Form bira0801Form = (Bira0801Form) form;
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		if ("".equals(bira0801Form.getBudgetCode()))
			map.put("A2","��@�w�@��@�o�@��@���@�e�@�R�@�^�@ ���@�p�@��@�]�`��^");
		else
			map.put("A2","��@�w�@��@�o�@��@���@�e�@�R�@�^�@ ���@�p�@��@�]"+tw.gov.nta.system.common.BudgetCodeManager.get(Integer.parseInt(bira0801Form.getBudgetCode())).getBudgetName()+"�^");
		if(bira0801Form.getIssueSdate() != null && bira0801Form.getIssueEdate() != null)
			map.put("A3","���إ��� " + DateUtil.date2ChineseROC2(bira0801Form.getIssueSdate())+" �� "+DateUtil.date2ChineseROC2(bira0801Form.getIssueEdate()) + " ��");
		else
			map.put("A3","");
		map.put("A5", "�s���� : " + DateUtil.date2ChineseROC2(new Date()));

		return map;
	}

	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}
}
