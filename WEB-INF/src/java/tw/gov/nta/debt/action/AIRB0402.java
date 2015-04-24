/* AIRB0402.java ����
 �{���ت��GAIRB04
 �{���N���GAIRB04
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

import tw.gov.nta.debt.form.Airb0401Form;

public class AIRB0402 extends ExcelReportAction {
	public final short DEFAULT_PAPERSIZE = PageSize.A3_PAPERSIZE;
	public final boolean LANDSCAPE = true;
	protected boolean isLANDSCAPE() {return LANDSCAPE;}
	protected short getDEFAULT_PAPERSIZE() {return DEFAULT_PAPERSIZE;}
	
	@Override
	public String getJasperFileName() {
		return "AIRB04_RPT1.jasper";
	}

	@Override
	public Map getReportParameter(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			Connection connection) {
		// TODO Auto-generated method stub
		Airb0401Form myform = (Airb0401Form) form;
		Map<String,Object> parameters = new HashMap<String,Object>();
		//���o�ϥΪ̱b��
		String usrId = this.getUserId(request);
		//���o�s����
		String createDate = DateUtil.date2ChineseROC2(DateUtil.date());
		//parameters.put("usrId",usrId);
		parameters.put("P2",createDate);
		//parameters.put("P1",myform.getrepayDate()+"�~��");
		String tmpS = myform.getrepay_SDate();
		String tmpE = myform.getrepay_EDate();
		parameters.put("P1","���إ���"+tmpS+"�~�צ�"+tmpE+"�~�פ�");
		parameters.put("P3",AIRB0302.budgetDebitName(myform.getbudgetCode().toString()  , myform.getDebtCode().toString(),myform.getBondSellStatus(),null  ));
		//parameters.put("repaySdate",DateUtil.date2ChineseROC(myform.getRepaySdate()));
		return parameters;
	}
} 
