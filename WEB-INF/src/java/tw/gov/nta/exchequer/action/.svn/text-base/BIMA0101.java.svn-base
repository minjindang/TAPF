/**
 * @author Andrew Sung
 */
package tw.gov.nta.exchequer.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.Messages;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.TreasuryIssueManager;
import tw.gov.nta.exchequer.form.Bima0101Form;
import tw.gov.nta.sql.debt.IssueMain;

public class BIMA0101 extends DefaultAction {
	private final static Date TODAY = new Date();

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Bima0101Form myForm = (Bima0101Form)form;
		IssueMain tIssueMain = myForm.getIssueMain();
		tIssueMain.setId(null);
		tIssueMain.setDebtType("B");
		tIssueMain.setIssueSerial("F"+repairZero(myForm.getAccountYear(),3)+"_"+repairZero(myForm.getSerialNo(),2));
		tIssueMain.setCreateDate(TODAY);
		tIssueMain.setModDate(TODAY);
		tIssueMain.setUserid( this.getUserId(request) );
		tIssueMain.setRepayAlternate(new Integer(1));
		tIssueMain.setInterestAlternate(new Integer(1));
		tIssueMain.setFirstInterestDate(myForm.getDueDate());
		tIssueMain.setFirstRepayDate(myForm.getDueDate());
		tIssueMain.setChargeRate(tIssueMain.getChargeRate().divide(new BigDecimal(1000)));
		TreasuryIssueManager myManager = new TreasuryIssueManager();
		myManager.confirm(tIssueMain);
		myForm.setIssueMain(myManager.getBean(myForm.getId()));
		setAlertMessage(request,Messages.SUCCESS_ADD);
		request.setAttribute("Add",request.getAttribute("Add"));
	}
	private String repairZero(String key,int count){
		if(key.length() < count){
			for(int i = key.length(); i < count ; i++)
				key = "0"+key;
		}
		return key;
	}
}
