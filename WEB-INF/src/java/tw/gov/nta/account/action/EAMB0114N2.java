package tw.gov.nta.account.action;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.sql.debt.DebtTypeRef;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;

public class EAMB0114N2 extends JacobReportAction {

	private final static String TEMP_TABLE_NAME = "EAMB01_RPT";
	private final static String PROGRAM_ID = "EAMB01";

	protected String getProgramId(HttpServletRequest request) {
		return PROGRAM_ID;
	}
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> parameters = new HashMap<String,Object>();
		parameters.put("Z1",DateUtil.date2Str(new Date(), "yyyy/MM/dd"));
		DebtTypeRef debtType = (DebtTypeRef)request.getSession().getAttribute("debtType");
		String debtTypeName = "";
		if ("A".equals(debtType.getTypeCode().trim())) {
			debtTypeName = "公　　債";
		}else if("B".equals(debtType.getTypeCode().trim())) {
			debtTypeName = "國　庫　券";
		}else if("C".equals(debtType.getTypeCode().trim())) {
			debtTypeName = "中　長　期　借　款";
		}else if("D".equals(debtType.getTypeCode().trim())) {
			debtTypeName = "短　期　借　款";
		}
		
		parameters.put("Z2",debtTypeName);
		return parameters;
		
	}
}
