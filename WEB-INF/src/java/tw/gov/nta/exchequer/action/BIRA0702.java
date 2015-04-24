package tw.gov.nta.exchequer.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.exchequer.form.Bira0701Form;

/**
 * @author Jack Du
 *
 * TODO �p�G�n�ܧ�o�Ӳ��ͪ����O���Ѫ��d���A�в���
 * ���� - �ߦn�]�w - Java - �{���X�˦� - �{���X�d��
 */
public class BIRA0702 extends JacobReportAction{
	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "BIRA07";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Bira0701Form myForm = (Bira0701Form) form;
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		//map.put( position, value );
		if ("".equals(myForm.getBudgetCode())){
			map.put("A2","��w�饼�v�l�B�J�`��]�`��^");
			map.put("H7","�e��~�׷��X�`�B�H�Υe��~�פΫe�@�~�׹w���X�`�B�H");
		}
		else{
			map.put("A2","��w�饼�v�l�B�J�`��]"+tw.gov.nta.system.common.BudgetCodeManager.get(Integer.parseInt(myForm.getBudgetCode())).getBudgetName()+"�^");
			map.put("H7","�e��~�׷��X�`�B�H");
		}
		if (myForm.getIssueSdate() != null && myForm.getIssueEdate() != null)
			map.put("A3",DateUtil.date2ChineseROC2(myForm.getIssueSdate()) + "��" + DateUtil.date2ChineseROC2(myForm.getIssueEdate()));
		else
			map.put("A3","");
		map.put("A5", "�s����:" + DateUtil.date2ChineseROC2(new Date()));
		return map;
	}

	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}
}
