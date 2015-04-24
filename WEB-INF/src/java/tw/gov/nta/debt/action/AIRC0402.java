/* AIRC0402.java ����
 �{���ت��GAIRC04
 �{���N���GAIRC04
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

import tw.gov.nta.debt.form.Airc0401Form;

public class AIRC0402 extends ExcelReportAction {
	public final short DEFAULT_PAPERSIZE = PageSize.A3_PAPERSIZE;
	public final boolean LANDSCAPE = true;
	protected boolean isLANDSCAPE() {return LANDSCAPE;}
	protected short getDEFAULT_PAPERSIZE() {return DEFAULT_PAPERSIZE;}
	
	@Override
	public String getJasperFileName() {
		return "AIRC04_RPT1.jasper";
	}

	@Override
	public Map getReportParameter(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			Connection connection) {
		Map<String,Object> parameters = new HashMap<String,Object>();
		//���o�ϥΪ̱b��
		parameters.put("usrId", this.getUserId(request) );
		//���o�s�����
		parameters.put("createDate", DateUtil.date2ChineseROC2(DateUtil.date()) );

		Airc0401Form myform = (Airc0401Form) form;
		parameters.put("P1","�I��"+DateUtil.date2ChineseROC2(myform.getLimitDate()));
		return parameters;
	}
}