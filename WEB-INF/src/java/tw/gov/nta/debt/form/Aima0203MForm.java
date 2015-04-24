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
import tw.gov.nta.debt.common.TicketManager;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.IssueTicketDet;
import tw.gov.nta.sql.debt.converter.IssueTicketDetConverter;
import tw.gov.nta.sql.debt.virtual.IssueTicketDetVirtual;

public class Aima0203MForm extends SupportForm{

	private static final long serialVersionUID = 4152949513674075551L;
	private IssueMain issueMain = new IssueMain();
	private IssueTicketDet issueTicketDet = new IssueTicketDet();
	public Integer getIssueTicketDetId() {
		return issueTicketDet.getId();
	}
	public String getTicketAmount() {
		if(issueTicketDet.getTicketAmount() == null)
			return "";
		else
			return issueTicketDet.getTicketAmount().toString();
	}
	public String getTicketCount() {
		if(issueTicketDet.getTicketCount() == null)
			return "";
		else
		return issueTicketDet.getTicketCount().toString();
	}
	public void setIssueTicketDetId(Integer id) {
		issueTicketDet.setId(id);
	}
	public void setTicketAmount(String ticketAmount) {
		issueTicketDet.setTicketAmount(new BigDecimal(ticketAmount.replaceAll(",","")));
	}
	public void setTicketCount(String ticketCount) {
		issueTicketDet.setTicketCount(Long.valueOf(!(ticketCount.equals(""))?ticketCount.replaceAll(",",""):"0"));
	}
	public IssueTicketDet getIssueTicketDet() {
		return issueTicketDet;
	}
	public void setIssueTicketDet(IssueTicketDet issueTicketDet) {
		this.issueTicketDet = issueTicketDet;
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
	public BigDecimal getTotalAmount() {
		if(issueTicketDet.getTicketAmount()!= null && issueTicketDet.getTicketCount()!=null)
			return issueTicketDet.getTicketAmount().multiply(new BigDecimal(issueTicketDet.getTicketCount()));
		else
			return new BigDecimal(0);
		
	}
}