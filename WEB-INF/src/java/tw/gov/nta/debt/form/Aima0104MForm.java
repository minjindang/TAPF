/*
程式目的：AIMA01文字
程式代號：AIMA01
程式日期：0950306
程式作者：FormBean Generator
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
*/
package tw.gov.nta.debt.form;

import gov.dnt.tame.common.SupportForm;

import java.math.BigDecimal;
import java.util.Date;

import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.sql.debt.DebtRateDet;
import tw.gov.nta.sql.debt.IssueMain;

public class Aima0104MForm extends SupportForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7348917104891204592L;
	private IssueMain issueMain = new IssueMain();
	private DebtRateDet debtRateDet = new DebtRateDet();
	public DebtRateDet getDebtRateDet() {
		return debtRateDet;
	}
	public void setDebtRateDet(DebtRateDet debtRateDet) {
		this.debtRateDet = debtRateDet;
	}
	public IssueMain getIssueMain() {
		return issueMain;
	}
	public void setIssueMain(IssueMain issueMain) {
		this.issueMain = issueMain;
	}
	public Integer getIssueMainId() {
		return issueMain.getId();
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
	public void setIssueMainId(Integer id) {
		if(id == null) return;
		if(issueMain == null || issueMain.getId() == null || issueMain.getId().intValue() != id.intValue()){
			IssueMain tIssueMain = new IssueManager().getBean(id);  
			if(tIssueMain != null)
				setIssueMain(tIssueMain);
		}
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
	public String getDebtName() {
		return issueMain.getDebtName();
	}
	public void setDebtName(String debtName) {
		issueMain.setDebtName(debtName);
	}
	public BigDecimal getDebtRate() {
		return debtRateDet.getDebtRate();
	}
	public Date getEffectiveDate() {
		return debtRateDet.getEffectiveDate();
	}
	public Integer getDebtRateDetId() {
		return debtRateDet.getId();
	}
	public Date getSuspendDate() {
		return debtRateDet.getSuspendDate();
	}
	public void setDebtRate(BigDecimal debtRate) {
		debtRateDet.setDebtRate(debtRate);
	}
	public void setEffectiveDate(Date effectiveDate) {
		debtRateDet.setEffectiveDate(effectiveDate);
	}
	public void setDebtRateDetId(Integer id) {
		debtRateDet.setId(id);
	}
	public void setSuspendDate(Date suspendDate) {
		debtRateDet.setSuspendDate(suspendDate);
	}
	public Integer getGroupId() {
		return debtRateDet.getGroupId();
	}
	public void setGroupId(Integer groupId) {
		debtRateDet.setGroupId(groupId);
	}
	public String getDeleteMark() {
		return debtRateDet.getDeleteMark();
	}
	public void setDeleteMark(String deleteMark) {
		debtRateDet.setDeleteMark(deleteMark);
	}
	public Integer getSeqNo() {
		return debtRateDet.getSeqNo();
	}
	public void setSeqNo(Integer seqNo) {
		debtRateDet.setSeqNo(seqNo);
	}
	
}