package tw.gov.nta.debt.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.form.Apra2301Form;

public class APRA2302 extends JacobReportAction
{
	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "APRA23";
	}
	
	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		String createDate = DateUtil.date2ChineseROC2(DateUtil.date());
		Apra2301Form myform = (Apra2301Form)form;
		//���o���ŦW��
		IssueManager manager = new IssueManager();
		map.put("B4","�@.���ŦW�١G" + manager.getBean(myform.getIssueId()).getDebtName() );
		//���o�P�����
		map.put("B5","�G.�P�����G���إ���" + DateUtil.date2ChineseROC2(myform.getKillDate()));
		//���o�P��a�I
		map.put("B6","�T.�P��a�I�G" + myform.getKillPlace());
		map.put("I5","�s�����G" + createDate);
		return map;
	}
	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}
	
}





























//��jasper
//ExcelReportAction
//{
//	public final short DEFAULT_PAPERSIZE = PageSize.A4_PAPERSIZE;
//	public final boolean LANDSCAPE = true;
//	protected boolean isLANDSCAPE() {return LANDSCAPE;}
//	protected short getDEFAULT_PAPERSIZE() {return DEFAULT_PAPERSIZE;}
//
//	@Override
//	public String getJasperFileName() {
//		return "APRA23_RPT1.jasper";
//	}
//
//	@Override
//	public Map getReportParameter(ActionMapping mapping, ActionForm form,
//			HttpServletRequest request, HttpServletResponse response,
//			Connection connection) {
//		Apra2301Form myForm = (Apra2301Form)form;
//		Map<String,Object> parameters = new HashMap<String,Object>();
//		//���o�ϥΪ̱b��
//		parameters.put("usrId",this.getUserId(request));
//		//���o�s����
//		parameters.put("createDate",DateUtil.date2ChineseROC2(DateUtil.date()));
//		//���o���ŦW��
//		IssueManager manager = new IssueManager();
//		parameters.put("debtName",manager.getBean(myForm.getIssueId()).getDebtName() );
//		//���o�P�����
//		parameters.put("closeDate",DateUtil.date2ChineseROC2(myForm.getKillDate()));
//		return parameters;
//	}
//
//}
