package tw.gov.nta.debt.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Apra0101Form;
import tw.gov.nta.system.common.BudgetCodeManager;
import tw.gov.nta.system.common.DebitCodeManage;

public class APRA0102 extends JacobReportAction {

	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "APRA01";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		// TODO Auto-generated method stub
		Apra0101Form myform = (Apra0101Form) form;
		String debitName = "�`��";
		String budgetName = "�`��";
		Map<String,Object> map = new HashMap<String,Object>();
		//String usrId = this.getUserId(request);
		String createDate = DateUtil.date2ChineseROC2(new Date());
		if(myform.getBudgetCode()!=null && !myform.getBudgetCode().equals("")){
			budgetName = BudgetCodeManager.get(Integer.parseInt(myform.getBudgetCode())).getBudgetName();
		}
		if(myform.getDebtCode()!=null && !myform.getDebtCode().equals("")){
			debitName = DebitCodeManage.get(Integer.parseInt(myform.getDebtCode())).getDebitName();
		}
//		map.put("A1","��  ��  ��  ��  ��  ��  ��  ��  ��  ��  ��  - "+budgetName);
		map.put("A2","���إ���"+DateUtil.date2ChineseROC2(myform.getRepaySdate()) +"��"+DateUtil.date2ChineseROC2(myform.getRepayEdate()));
		map.put("K4","�s�����G"+createDate);
		map.put("A6","���ŧO�G"+debitName);
		return map;
	}
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}

}
