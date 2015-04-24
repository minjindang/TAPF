package tw.gov.nta.system.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.Messages;

import java.sql.Connection;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.system.common.BankCodeManage;
import tw.gov.nta.system.form.Fama0501Form;

/**
 * @author AndrewSung
 *�I�sExstockCodeManage����update(),�ǤJID��exstockRef��s���
 */
public class FAMA0505 extends DefaultAction
{
	private final static Date TODAY = new Date();

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception
	{
		Fama0501Form fama0501Form = (Fama0501Form) form;
		fama0501Form.setUsrid(this.getUserId(request));
		fama0501Form.setModDate(TODAY);
		fama0501Form.setCreateDate(fama0501Form.getCreateDate());
		BankCodeManage.update(fama0501Form.getBankRef());
		setAlertMessage(request,Messages.SUCCESS_MODIFY);
	}
}