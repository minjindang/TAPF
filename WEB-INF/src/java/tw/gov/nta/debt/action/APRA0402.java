/* APRA0402.java ����
 �{���ت��GAPRA04
 �{���N���GAPRA04
 �{������G0950308
 �{���@�̡GEric.Chen
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

import tw.gov.nta.debt.form.Apra0401Form;

public class APRA0402 extends ExcelReportAction {
	public final short DEFAULT_PAPERSIZE = PageSize.A3_PAPERSIZE;
	public final boolean LANDSCAPE = true;
	protected boolean isLANDSCAPE() {return LANDSCAPE;}
	protected short getDEFAULT_PAPERSIZE() {return DEFAULT_PAPERSIZE;}

	@Override
	public String getJasperFileName() {
		return "APRA04_RPT1.jasper";
	}

	@Override
	public Map getReportParameter(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			Connection connection) {
		// TODO Auto-generated method stub
		Apra0401Form myform = (Apra0401Form) form;
		Map<String,Object> parameters = new HashMap<String,Object>();
		//���o�ϥΪ̱b��
		String usrId = this.getUserId(request);
		//���o�s�����
		String createDate = DateUtil.date2ChineseROC(DateUtil.date());
		parameters.put("usrId",usrId);
		parameters.put("createDate",createDate);
		parameters.put("repayEdate",DateUtil.date2ChineseROC(myform.getRepayEdate()));
		parameters.put("repaySdate",DateUtil.date2ChineseROC(myform.getRepaySdate()));
		return parameters;
	}
}