package tw.gov.nta.central.action;

import gov.dnt.tame.common.DefaultAction;
import java.sql.Connection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.central.common.UnitPercent101;
import tw.gov.nta.central.form.Hama0601Form;

public class HAMA0602 extends DefaultAction {
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Boolean isImport = true;
		Hama0601Form hama0601Form = (Hama0601Form) form;
		List dataList = UnitPercent101.parseExcel(hama0601Form.getFilePath());
		isImport = UnitPercent101.checkDate(dataList);
		if (isImport) {
			UnitPercent101.importData(hama0601Form.getQryYear(), dataList);
			setAlertMessage(request, "匯入成功!");
		} else
			setAlertMessage(request, "匯入失敗!");
	}
}
