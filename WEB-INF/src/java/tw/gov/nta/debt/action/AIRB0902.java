/* AIRB0902.java ����
 �{���ت��GAIRB09
 �{���N���GAIRB09
 �{������G0950316
 �{���@�̡Gicefire
 --------------------------------------------------------
 �ק�@�̡@�@�ק����@�@�@�ק�ت�
 --------------------------------------------------------
 */
package tw.gov.nta.debt.action;

import gov.dnt.tame.common.PageSize;
import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.ExcelReportAction;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import tw.gov.nta.debt.form.Airb0901Form;

public class AIRB0902 extends ExcelReportAction {
	public final short DEFAULT_PAPERSIZE = PageSize.A3_PAPERSIZE;
	public final boolean LANDSCAPE = true;
	protected boolean isLANDSCAPE() {return LANDSCAPE;}
	protected short getDEFAULT_PAPERSIZE() {return DEFAULT_PAPERSIZE;}
	
	@Override
	public String getJasperFileName() {
		return "AIRB09_RPT1.jasper";
	}

	@Override
	public Map getReportParameter(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			Connection connection) {
		// TODO Auto-generated method stub
		Airb0901Form myform = (Airb0901Form) form;
		Map<String,Object> parameters = new HashMap<String,Object>();
		//���o�ϥΪ̱b��
		String usrId = this.getUserId(request);
		//���o�s����
		String createDate = DateUtil.date2ChineseROC2(DateUtil.date());
		//parameters.put("usrId",usrId);
		parameters.put("P2",createDate);
		parameters.put("P1","���إ���"+myform.getRepaydate()+"�~��");
//		String budName = "";
//		String debtName = "";
//		if (0 != myform.getBudgetCode())
//			budName = tw.gov.nta.system.common.BudgetCodeManager.get(myform.getBudgetCode()).getBudgetName();
//		if( 0 != myform.getDebtCode())
//			debtName = tw.gov.nta.system.common.DebitCodeManage.get(myform.getDebtCode()).getDebitName();
//		//���S���
//		if ("".equals(budName) && "".equals(debtName))
//			parameters.put("P3","(�`��)");
//		//��ӳ���
//		else if (!"".equals(budName) && !"".equals(debtName))
//			parameters.put("P3","("+budName+"/"+debtName+")");
//		//��䤤�@��
//		else
//			parameters.put("P3","("+budName+debtName+")");
		parameters.put("P3",AIRB0302.budgetDebitName(myform.getBudgetCode().toString()  ,myform.getDebtCode().toString(),null ,myform.getKind() ));
		
		//parameters.put("repayEdate",DateUtil.date2ChineseROC(myform.getRepayEdate()));
		//parameters.put("repaySdate",DateUtil.date2ChineseROC(myform.getRepaySdate()));
		return parameters;
	}
}
