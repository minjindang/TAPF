/*
�{���ت��GAIMA01��r
�{���N���GAIMA01
�{������G0950306
�{���@�̡GFormBean Generator
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
*/
package tw.gov.nta.debt.form;

import gov.dnt.tame.common.SupportForm;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.sql.debt.IssueMain;

public class Aima0303LForm extends SupportForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6701035938525888045L;
	IssueMain issueMain = new IssueMain();
	List debtMainList = null;
	public List getDebtMainList() {
		return debtMainList;
	}
	public void setDebtMainList(List debtMainList) {
		this.debtMainList = debtMainList;
	}
	public IssueMain getIssueMain() {
		return issueMain;
	}
	public void setIssueMain(IssueMain issueMain) {
		this.issueMain = issueMain;
	}
	public BigDecimal getIssueAmount() {
		return issueMain.getIssueAmount();
	}
	public Date getIssueDate() {
		return issueMain.getIssueDate();
	}
	public String getIssueSerial() {
		return issueMain.getIssueSerial();
	}
	public void setIssueAmount(BigDecimal issueAmount) {
		issueMain.setIssueAmount(issueAmount);
	}
	public void setIssueDate(Date issueDate) {
		issueMain.setIssueDate(issueDate);
	}
	public void setIssueSerial(String issueSerial) {
		issueMain.setIssueSerial(issueSerial);
	}
	public Integer getIssueMainId() {
		return issueMain.getId();
	}
	public void setIssueMainId(Integer id) {
		if(id == null) return;
		if(issueMain == null || issueMain.getId() == null || issueMain.getId().intValue() != id.intValue()){
			IssueMain tIssueMain = new IssueManager().getBean(id);
			if(tIssueMain != null)
				setIssueMain(tIssueMain);
		}
	}
}