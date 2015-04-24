/**
*
* @author Andrew Sung
* @createDate 2006/12/5
*/
package tw.gov.nta.exchequer.form;

import java.math.BigDecimal;
import java.util.Date;

import tw.gov.nta.sql.debt.AheadpayMain;
import gov.dnt.tame.common.SupportForm;

public class Bima0401Form extends SupportForm {
	private AheadpayMain aheadpayMain = new AheadpayMain();
	private String qryAccountYear = new String();
	
	public String getQryAccountYear() {
		return qryAccountYear;
	}

	public void setQryAccountYear(String qryAccountYear) {
		this.qryAccountYear = qryAccountYear;
	}

	public AheadpayMain getAheadpayMain() {
		return aheadpayMain;
	}

	public void setAheadpayMain(AheadpayMain aheadpayMain) {
		this.aheadpayMain = aheadpayMain;
	}

	public String getAccountYear() {
		return aheadpayMain.getAccountYear();
	}

	public Date getAheadDate() {
		return aheadpayMain.getAheadDate();
	}

	public BigDecimal getAverageRate() {
		return aheadpayMain.getAverageRate();
	}

	public BigDecimal getBidAmount() {
		return aheadpayMain.getBidAmount();
	}

	public BigDecimal getBidRate() {
		return aheadpayMain.getBidRate();
	}

	public Integer getBondType() {
		return aheadpayMain.getBondType();
	}

	public Date getCreateDate() {
		return aheadpayMain.getCreateDate();
	}

	public String getDebtName() {
		return aheadpayMain.getDebtName();
	}

	public Date getDueDate() {
		return aheadpayMain.getDueDate();
	}

	public String getFileNo() {
		return aheadpayMain.getFileNo();
	}

	public BigDecimal getGotbidAmount() {
		return aheadpayMain.getGotbidAmount();
	}

	public BigDecimal getHightRate() {
		return aheadpayMain.getHightRate();
	}

	public Integer getId() {
		return aheadpayMain.getId();
	}

	public BigDecimal getInterestAmount() {
		return aheadpayMain.getInterestAmount();
	}

	public BigDecimal getIssueAmount() {
		return aheadpayMain.getIssueAmount();
	}

	public Date getIssueDate() {
		return aheadpayMain.getIssueDate();
	}

	public Integer getIssueDays() {
		return aheadpayMain.getIssueDays();
	}

	public Integer getIssueId() {
		return aheadpayMain.getIssueId();
	}

	public String getIssueSerial() {
		return aheadpayMain.getIssueSerial();
	}

	public BigDecimal getLowRate() {
		return aheadpayMain.getLowRate();
	}

	public Date getModDate() {
		return aheadpayMain.getModDate();
	}

	public BigDecimal getOrgissueAmount() {
		return aheadpayMain.getOrgissueAmount();
	}

	public Integer getPaymentId() {
		return aheadpayMain.getPaymentId();
	}

	public String getUserId() {
		return aheadpayMain.getUserId();
	}

	public void setAccountYear(String accountYear) {
		aheadpayMain.setAccountYear(accountYear);
	}

	public void setAheadDate(Date aheadDate) {
		aheadpayMain.setAheadDate(aheadDate);
	}

	public void setAverageRate(BigDecimal averageRate) {
		aheadpayMain.setAverageRate(averageRate);
	}

	public void setBidAmount(BigDecimal bidAmount) {
		aheadpayMain.setBidAmount(bidAmount);
	}

	public void setBidRate(BigDecimal bidRate) {
		aheadpayMain.setBidRate(bidRate);
	}

	public void setBondType(Integer bondType) {
		aheadpayMain.setBondType(bondType);
	}

	public void setCreateDate(Date createDate) {
		aheadpayMain.setCreateDate(createDate);
	}

	public void setDebtName(String debtName) {
		aheadpayMain.setDebtName(debtName);
	}

	public void setDueDate(Date dueDate) {
		aheadpayMain.setDueDate(dueDate);
	}

	public void setFileNo(String fileNo) {
		aheadpayMain.setFileNo(fileNo);
	}

	public void setGotbidAmount(BigDecimal gotbidAmount) {
		aheadpayMain.setGotbidAmount(gotbidAmount);
	}

	public void setHightRate(BigDecimal hightRate) {
		aheadpayMain.setHightRate(hightRate);
	}

	public void setId(Integer id) {
		aheadpayMain.setId(id);
	}

	public void setInterestAmount(BigDecimal interestAmount) {
		aheadpayMain.setInterestAmount(interestAmount);
	}

	public void setIssueAmount(BigDecimal issueAmount) {
		aheadpayMain.setIssueAmount(issueAmount);
	}

	public void setIssueDate(Date issueDate) {
		aheadpayMain.setIssueDate(issueDate);
	}

	public void setIssueDays(Integer issueDays) {
		aheadpayMain.setIssueDays(issueDays);
	}

	public void setIssueId(Integer issueId) {
		aheadpayMain.setIssueId(issueId);
	}

	public void setIssueSerial(String issueSerial) {
		aheadpayMain.setIssueSerial(issueSerial);
	}

	public void setLowRate(BigDecimal lowRate) {
		aheadpayMain.setLowRate(lowRate);
	}

	public void setManager(boolean manager) {
		aheadpayMain.setManager(manager);
	}

	public void setModDate(Date modDate) {
		aheadpayMain.setModDate(modDate);
	}

	public void setOrgissueAmount(BigDecimal orgissueAmount) {
		aheadpayMain.setOrgissueAmount(orgissueAmount);
	}

	public void setPaymentId(Integer paymentId) {
		aheadpayMain.setPaymentId(paymentId);
	}

	public void setUserId(String userId) {
		aheadpayMain.setUserId(userId);
	}
	
}
