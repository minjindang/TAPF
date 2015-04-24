package tw.gov.nta.account.form;

import gov.dnt.tame.common.SupportForm;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

import tw.gov.nta.sql.dao.BudgetRefDAO;
import tw.gov.nta.sql.dao.DebitRefDAO;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.IssueExchangeDet;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.IssueTicketDet;

public class Eamb0102Form extends SupportForm {
	private static final long serialVersionUID = 1L;

	private IssueMain issueMain = new IssueMain();
	private List voucherLists;
	private BudgetRefDAO budgetDao = BudgetRefDAO.getInstance();
	private DebitRefDAO debtDao = DebitRefDAO.getInstance();
	
	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#addTodebtMains(tw.gov.nta.sql.debt.DebtMain)
	 */
	public void addTodebtMains(DebtMain debtMain) {
		issueMain.addTodebtMains(debtMain);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#addToissueExchangeDets(tw.gov.nta.sql.debt.IssueExchangeDet)
	 */
	public void addToissueExchangeDets(IssueExchangeDet issueExchangeDet) {
		issueMain.addToissueExchangeDets(issueExchangeDet);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#addToissueTicketDets(tw.gov.nta.sql.debt.IssueTicketDet)
	 */
	public void addToissueTicketDets(IssueTicketDet issueTicketDet) {
		issueMain.addToissueTicketDets(issueTicketDet);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#getAccountYear()
	 */
	public String getAccountYear() {
		return issueMain.getAccountYear();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#getAverageRate()
	 */
	public BigDecimal getAverageRate() {
		return issueMain.getAverageRate();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#getBondKind()
	 */
	public String getBondKind() {
		return issueMain.getBondKind();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#getBondSellStatus()
	 */
	public String getBondSellStatus() {
		return issueMain.getBondSellStatus();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#getBondType()
	 */
	public String getBondType() {
		if ("2".equals(issueMain.getBondType()))
			return "¤AÃþ";
		else if ("1".equals(issueMain.getBondType()))
			return "¥ÒÃþ"; 
		return issueMain.getBondType();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#getBudgetCode()
	 */
	public String getBudgetCode() {
		int budgetRefId = issueMain.getBudgetCode();
		if (budgetRefId !=0)
			return budgetDao.get(budgetRefId).getBudgetName();
		else
			return "";
			
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#getCapitalAmount()
	 */
	public BigDecimal getCapitalAmount() {
		return issueMain.getCapitalAmount();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#getCashDueDate()
	 */
	public Date getCashDueDate() {
		return issueMain.getCashDueDate();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#getChargeRate()
	 */
	public BigDecimal getChargeRate() {
		return issueMain.getChargeRate();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#getCreateDate()
	 */
	public Date getCreateDate() {
		return issueMain.getCreateDate();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#getDebtCode()
	 */
	public String getDebtCode() {
		int debtRefId = issueMain.getDebtCode();
		if (debtRefId !=0)
			return debtDao.get(debtRefId).getDebitName();
		else
			return "";
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#getDebtMains()
	 */
	public Set<DebtMain> getDebtMains() {
		return issueMain.getDebtMains();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#getDebtName()
	 */
	public String getDebtName() {
		return issueMain.getDebtName();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#getDebtType()
	 */
	public String getDebtType() {
		return issueMain.getDebtType();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#getDueDate()
	 */
	public Date getDueDate() {
		return issueMain.getDueDate();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#getExpectAmount()
	 */
	public BigDecimal getExpectAmount() {
		return issueMain.getExpectAmount();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#getFirstInterestDate()
	 */
	public Date getFirstInterestDate() {
		return issueMain.getFirstInterestDate();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#getFirstRepayDate()
	 */
	public Date getFirstRepayDate() {
		return issueMain.getFirstRepayDate();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#getInterestAlternate()
	 */
	public Integer getInterestAlternate() {
		return issueMain.getInterestAlternate();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#getInterestAmount()
	 */
	public BigDecimal getInterestAmount() {
		return issueMain.getInterestAmount();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#getIssueAmount()
	 */
	public BigDecimal getIssueAmount() {
		return issueMain.getIssueAmount();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#getIssueDate()
	 */
	public Date getIssueDate() {
		return issueMain.getIssueDate();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#getIssueExchangeDets()
	 */
	public Set<IssueExchangeDet> getIssueExchangeDets() {
		return issueMain.getIssueExchangeDets();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#getIssueInterval()
	 */
	public Integer getIssueInterval() {
		return issueMain.getIssueInterval();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#getIssueKind()
	 */
	public String getIssueKind() {
		if ("1".equals(issueMain.getIssueKind()))
			return "¶Å²¼";
		else
			return "µn¿ý";
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#getIssueSerial()
	 */
	public String getIssueSerial() {
		return issueMain.getIssueSerial();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#getIssueTicketDets()
	 */
	public Set<IssueTicketDet> getIssueTicketDets() {
		return issueMain.getIssueTicketDets();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#getModDate()
	 */
	public Date getModDate() {
		return issueMain.getModDate();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#getPayLimit()
	 */
	public Integer getPayLimit() {
		return issueMain.getPayLimit();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#getRateKind()
	 */
	public String getRateKind() {
		return issueMain.getRateKind();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#getRemark()
	 */
	public String getRemark() {
		return issueMain.getRemark();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#getRepayAlternate()
	 */
	public Integer getRepayAlternate() {
		return issueMain.getRepayAlternate();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#getSellAmount()
	 */
	public BigDecimal getSellAmount() {
		return issueMain.getSellAmount();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#getSellStatus()
	 */
	public String getSellStatus() {
		return issueMain.getSellStatus();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#getSerialNo()
	 */
	public String getSerialNo() {
		return issueMain.getSerialNo();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#getShowType()
	 */
	public String getShowType() {
		return issueMain.getShowType();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#getSourceIssueId()
	 */
	public Integer getSourceIssueId() {
		return issueMain.getSourceIssueId();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#getUserid()
	 */
	public String getUserid() {
		return issueMain.getUserid();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#setAccountYear(java.lang.String)
	 */
	public void setAccountYear(String accountYear) {
		issueMain.setAccountYear(accountYear);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#setAverageRate(java.math.BigDecimal)
	 */
	public void setAverageRate(BigDecimal averageRate) {
		issueMain.setAverageRate(averageRate);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#setBondKind(java.lang.String)
	 */
	public void setBondKind(String bondKind) {
		issueMain.setBondKind(bondKind);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#setBondSellStatus(java.lang.String)
	 */
	public void setBondSellStatus(String bondSellStatus) {
		issueMain.setBondSellStatus(bondSellStatus);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#setBondType(java.lang.String)
	 */
	public void setBondType(String bondType) {
		issueMain.setBondType(bondType);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#setBudgetCode(java.lang.Integer)
	 */
	public void setBudgetCode(Integer budgetCode) {
		issueMain.setBudgetCode(budgetCode);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#setCapitalAmount(java.math.BigDecimal)
	 */
	public void setCapitalAmount(BigDecimal capitalAmount) {
		issueMain.setCapitalAmount(capitalAmount);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#setCashDueDate(java.util.Date)
	 */
	public void setCashDueDate(Date cashDueDate) {
		issueMain.setCashDueDate(cashDueDate);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#setChargeRate(java.math.BigDecimal)
	 */
	public void setChargeRate(BigDecimal chargeRate) {
		issueMain.setChargeRate(chargeRate);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#setCreateDate(java.util.Date)
	 */
	public void setCreateDate(Date createDate) {
		issueMain.setCreateDate(createDate);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#setDebtCode(java.lang.Integer)
	 */
	public void setDebtCode(Integer debtCode) {
		issueMain.setDebtCode(debtCode);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#setDebtMains(java.util.Set)
	 */
	public void setDebtMains(Set<DebtMain> debtMains) {
		issueMain.setDebtMains(debtMains);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#setDebtName(java.lang.String)
	 */
	public void setDebtName(String debtName) {
		issueMain.setDebtName(debtName);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#setDebtType(java.lang.String)
	 */
	public void setDebtType(String debtType) {
		issueMain.setDebtType(debtType);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#setDueDate(java.util.Date)
	 */
	public void setDueDate(Date dueDate) {
		issueMain.setDueDate(dueDate);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#setExpectAmount(java.math.BigDecimal)
	 */
	public void setExpectAmount(BigDecimal expectAmount) {
		issueMain.setExpectAmount(expectAmount);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#setFirstInterestDate(java.util.Date)
	 */
	public void setFirstInterestDate(Date firstInterestDate) {
		issueMain.setFirstInterestDate(firstInterestDate);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#setFirstRepayDate(java.util.Date)
	 */
	public void setFirstRepayDate(Date firstRepayDate) {
		issueMain.setFirstRepayDate(firstRepayDate);
	}


	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#setInterestAlternate(java.lang.Integer)
	 */
	public void setInterestAlternate(Integer interestAlternate) {
		issueMain.setInterestAlternate(interestAlternate);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#setInterestAmount(java.math.BigDecimal)
	 */
	public void setInterestAmount(BigDecimal interestAmount) {
		issueMain.setInterestAmount(interestAmount);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#setIssueAmount(java.math.BigDecimal)
	 */
	public void setIssueAmount(BigDecimal issueAmount) {
		issueMain.setIssueAmount(issueAmount);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#setIssueDate(java.util.Date)
	 */
	public void setIssueDate(Date issueDate) {
		issueMain.setIssueDate(issueDate);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#setIssueExchangeDets(java.util.Set)
	 */
	public void setIssueExchangeDets(Set<IssueExchangeDet> issueExchangeDets) {
		issueMain.setIssueExchangeDets(issueExchangeDets);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#setIssueInterval(java.lang.Integer)
	 */
	public void setIssueInterval(Integer issueInterval) {
		issueMain.setIssueInterval(issueInterval);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#setIssueKind(java.lang.String)
	 */
	public void setIssueKind(String issueKind) {
		issueMain.setIssueKind(issueKind);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#setIssueSerial(java.lang.String)
	 */
	public void setIssueSerial(String issueSerial) {
		issueMain.setIssueSerial(issueSerial);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#setIssueTicketDets(java.util.Set)
	 */
	public void setIssueTicketDets(Set<IssueTicketDet> issueTicketDets) {
		issueMain.setIssueTicketDets(issueTicketDets);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#setModDate(java.util.Date)
	 */
	public void setModDate(Date modDate) {
		issueMain.setModDate(modDate);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#setPayLimit(java.lang.Integer)
	 */
	public void setPayLimit(Integer payLimit) {
		issueMain.setPayLimit(payLimit);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#setRateKind(java.lang.String)
	 */
	public void setRateKind(String rateKind) {
		issueMain.setRateKind(rateKind);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#setRemark(java.lang.String)
	 */
	public void setRemark(String remark) {
		issueMain.setRemark(remark);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#setRepayAlternate(java.lang.Integer)
	 */
	public void setRepayAlternate(Integer repayAlternate) {
		issueMain.setRepayAlternate(repayAlternate);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#setSellAmount(java.math.BigDecimal)
	 */
	public void setSellAmount(BigDecimal sellAmount) {
		issueMain.setSellAmount(sellAmount);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#setSellStatus(java.lang.String)
	 */
	public void setSellStatus(String sellStatus) {
		issueMain.setSellStatus(sellStatus);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#setSerialNo(java.lang.String)
	 */
	public void setSerialNo(String serialNo) {
		issueMain.setSerialNo(serialNo);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#setShowType(java.lang.String)
	 */
	public void setShowType(String showType) {
		issueMain.setShowType(showType);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#setSourceIssueId(java.lang.Integer)
	 */
	public void setSourceIssueId(Integer sourceIssueId) {
		issueMain.setSourceIssueId(sourceIssueId);
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#setUserid(java.lang.String)
	 */
	public void setUserid(String userid) {
		issueMain.setUserid(userid);
	}

	/**
	 * @return Returns the issueMain.
	 */
	public IssueMain getIssueMain() {
		return issueMain;
	}

	/**
	 * @param issueMain The issueMain to set.
	 */
	public void setIssueMain(IssueMain issueMain) {
		this.issueMain = issueMain;
	}

	/**
	 * @return Returns the voucherLists.
	 */
	public List getVoucherLists() {
		return voucherLists;
	}

	/**
	 * @param voucherLists The voucherLists to set.
	 */
	public void setVoucherLists(List voucherLists) {
		this.voucherLists = voucherLists;
	}



	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#getDebtShortName()
	 */
	public String getDebtShortName() {
		return issueMain.getDebtShortName();
	}


	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#getRealAmount()
	 */
	public BigDecimal getRealAmount() {
		return issueMain.getRealAmount();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#setDebtShortName(java.lang.String)
	 */
	public void setDebtShortName(String debtShortName) {
		issueMain.setDebtShortName(debtShortName);
	}


	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#setRealAmount(java.math.BigDecimal)
	 */
	public void setRealAmount(BigDecimal realAmount) {
		issueMain.setRealAmount(realAmount);
	}
}
