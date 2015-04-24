/*
 * 在 2006/2/20 建立
 *
 * 匯入資料
 */
package tw.gov.nta.central.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.central.common.UnitPercent;
import tw.gov.nta.central.form.Hama0301Form;

/**
 * @author Mindy
 *
 */
public class HAMA0302 extends DefaultAction {

	/* (non-Javadoc)
	 * @see com.kangdainfo.ast.action.connection.SimpleQueryAction#executeQuery(org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, java.sql.Connection)
	 */
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception
	{
		Boolean isImport= true;
		
		Hama0301Form hama0301Form = (Hama0301Form) form;
		List dataList = UnitPercent.parseExcel(hama0301Form.getFilePath());
		isImport = UnitPercent.checkDate(dataList);
		if (isImport) 
		{
			UnitPercent.importData(hama0301Form.getQryYear(), dataList);
			setAlertMessage(request,"匯入成功!");
		}
		else
			setAlertMessage(request,"匯入失敗!");
	}
}
