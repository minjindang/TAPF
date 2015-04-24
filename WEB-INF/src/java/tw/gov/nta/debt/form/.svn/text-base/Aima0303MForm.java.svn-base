/**
*
* @author Andrew Sung
* @createDate 2006/6/21
*/
package tw.gov.nta.debt.form;

import java.math.BigDecimal;
import java.util.Date;

import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.sql.debt.IssueExgpriceDet;
import tw.gov.nta.sql.debt.IssueMain;
import gov.dnt.tame.common.SupportForm;

public class Aima0303MForm extends SupportForm {
	Integer issueMainId;
	IssueMain issueMain = new IssueMain();
	IssueExgpriceDet issueExgpriceDet = new IssueExgpriceDet();

	public BigDecimal getChangeAmount() {
		return issueExgpriceDet.getChangeAmount();
	}

	public Date getChangeDate() {
		return issueExgpriceDet.getChangeDate();
	}

	public BigDecimal getChangePrice() {
		return issueExgpriceDet.getChangePrice();
	}

	public String getChangeReason() {
		return issueExgpriceDet.getChangeReason();
	}

	public Integer getId() {
		return issueExgpriceDet.getId();
	}

	public IssueMain getIssue() {
		return issueExgpriceDet.getIssue();
	}

	public BigDecimal getNotAmount() {
		return issueExgpriceDet.getNotAmount();
	}

	public BigDecimal getStockAmount() {
		return issueExgpriceDet.getStockAmount();
	}

	public BigDecimal getSumStock() {
		return issueExgpriceDet.getSumStock();
	}

	public void setChangeAmount(BigDecimal changeAmount) {
		issueExgpriceDet.setChangeAmount(changeAmount);
	}

	public void setChangeDate(Date changeDate) {
		issueExgpriceDet.setChangeDate(changeDate);
	}

	public void setChangePrice(BigDecimal changePrice) {
		issueExgpriceDet.setChangePrice(changePrice);
	}

	public void setChangeReason(String changeReason) {
		issueExgpriceDet.setChangeReason(changeReason);
	}

	public void setId(Integer id) {
		issueExgpriceDet.setId(id);
	}

	public void setIssue(IssueMain issue) {
		issueExgpriceDet.setIssue(issue);
	}

	public void setNotAmount(BigDecimal notAmount) {
		issueExgpriceDet.setNotAmount(notAmount);
	}

	public void setStockAmount(BigDecimal stockAmount) {
		issueExgpriceDet.setStockAmount(stockAmount);
	}

	public void setSumStock(BigDecimal sumStock) {
		issueExgpriceDet.setSumStock(sumStock);
	}

	public IssueExgpriceDet getIssueExgpriceDet() {
		return issueExgpriceDet;
	}

	public void setIssueExgpriceDet(IssueExgpriceDet issueExgpriceDet) {
		this.issueExgpriceDet = issueExgpriceDet;
	}

	public Integer getIssueMainId() {
		return this.issueMain.getId();
	}
	public void setIssueMainId(Integer id) {
		if(id == null) return;
		if(issueMain == null || issueMain.getId() == null || issueMain.getId().intValue() != id.intValue()){
			IssueMain tIssueMain = new IssueManager().getBean(id);
			if(tIssueMain != null)
				setIssueMain(tIssueMain);
		}
	}

	public IssueMain getIssueMain() {
		return issueMain;
	}

	public void setIssueMain(IssueMain issueMain) {
		this.issueMain = issueMain;
	}
	
}
