/*
 * 在 2006/2/22 建立
 */
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
 * FAMA0507.java
 * 呼叫BankCodeManage之create(),傳入BankRef新增資料
 */
public class FAMA0507 extends DefaultAction
{
	private final static Date TODAY = new Date();
	
	public void executeQuery(ActionForm form, HttpServletRequest request,Connection connection) throws Exception
	{
		Fama0501Form fama0501Form = (Fama0501Form) form;
		
		fama0501Form.setUsrid(this.getUserId(request));
		fama0501Form.setModDate(TODAY);
		fama0501Form.setCreateDate(TODAY);

		if(BankCodeManage.isModify(fama0501Form.getBankRef()))
		{
			fama0501Form.setBeginDate( fama0501Form.getBeginDate()==null?TODAY:fama0501Form.getBeginDate() );
			fama0501Form.setEndDate( fama0501Form.getEndDate()==null?TODAY:fama0501Form.getEndDate() );

			int id = BankCodeManage.create(fama0501Form.getBankRef());
			fama0501Form.setBankRef(BankCodeManage.get(id));
			setAlertMessage(request,Messages.SUCCESS_ADD);
		}
		else
		{
			fama0501Form.setBankCode(null);
			setAlertMessage(request,"新增失敗:銀行編號代號重複");
			throw new Exception("銀行編號代號重複");
		}
	}
}