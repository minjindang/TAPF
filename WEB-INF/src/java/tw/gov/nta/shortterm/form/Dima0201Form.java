
/**
 * @author AndrewSung
 */


package tw.gov.nta.shortterm.form;

import gov.dnt.tame.common.SupportForm;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.Set;
import java.util.Vector;

import tw.gov.nta.debt.common.DebtMainVectors;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.IssueExchangeDet;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.IssueTicketDet;

public class Dima0201Form extends SupportForm
{
	private static final long serialVersionUID = 1L;
	IssueMain issuMain = new IssueMain();
	private Vector<Object> debtMains = new Vector<Object>();

	public void setDebtMains(Vector<Object> debtMains)
    {
        this.debtMains = debtMains;
    }
	public Collection getDebtMains()
	{
		return debtMains;
	}
	public void setDebtMains(Collection<Object> debtMains)
	{
		this.debtMains = new Vector<Object>(debtMains);
	}
	public Object getdebtMain(int index)
	{
		if (this.debtMains.size() <= index)
		{
			DebtMainVectors debtMainVectors = new DebtMainVectors();
			setDebtMain(index, debtMainVectors);
			return debtMainVectors;
		}
		else
		{
			Object obj = debtMains.get(index);
			if (obj == null)
			{
				DebtMainVectors debtMainVectors = new DebtMainVectors();
				setDebtMain(index, debtMainVectors);
				return debtMainVectors;
			}
			else
				return obj;
		}
	}
	public void setDebtMain(int index, Object debtMain)
	{
		if (this.debtMains.size() <= index)
			debtMains.setSize(index + 1);
		this.debtMains.set(index, debtMain);
	}
	
	private String qryAccountYear;
	private String qrySerialNo;
	private Integer qryId;
	private String days ;
	private Integer kindId;
	private BigDecimal nonAmount;
	

	public BigDecimal getNonAmount()
	{
		nonAmount = this.getIssueAmount().subtract((this.getCapitalAmount() != null)?this.getCapitalAmount():new BigDecimal(0));
		return nonAmount;
	}
	public void setNonAmount(BigDecimal nonAmount)
	{
		this.nonAmount = nonAmount;
	}
	public Integer getKindId()
	{
		return kindId;
	}
	public void setKindId(Integer kindId)
	{
		this.kindId = kindId;
	}
	public String getQryAccountYear()
	{
		return qryAccountYear;
	}
	public void setQryAccountYear(String qryAccountYear)
	{
		this.qryAccountYear = qryAccountYear;
	}
	public String getQrySerialNo()
	{
		return qrySerialNo;
	}
	public void setQrySerialNo(String qrySerialNo)
	{
		this.qrySerialNo = qrySerialNo;
	}
	public IssueMain getIssuMain()
	{
		return issuMain;
	}
	public void setIssuMain(IssueMain issuMain)
	{
		this.issuMain = issuMain;
	}
	public String getAccountYear()
	{
		return issuMain.getAccountYear();
	}
	public BigDecimal getAverageRate()
	{
		return issuMain.getAverageRate();
	}
	public String getBondKind()
	{
		return issuMain.getBondKind();
	}
	public String getBondSellStatus()
	{
		return issuMain.getBondSellStatus();
	}
	public String getBondType()
	{
		return issuMain.getBondType();
	}
	public Integer getBudgetCode()
	{
		return issuMain.getBudgetCode();
	}
	public BigDecimal getCapitalAmount()
	{
		return issuMain.getCapitalAmount();
	}
	public Date getCashDueDate()
	{
		return issuMain.getCashDueDate();
	}
	public BigDecimal getChargeRate()
	{
		return issuMain.getChargeRate();
	}
	public Integer getDebtCode()
	{
		return issuMain.getDebtCode();
	}
	
	
	public String getDebtType()
	{
		return issuMain.getDebtType();
	}
	public Date getDueDate()
	{
		return issuMain.getDueDate();
	}
	public BigDecimal getExpectAmount()
	{
		return issuMain.getExpectAmount();
	}
	public Date getFirstInterestDate()
	{
		return issuMain.getFirstInterestDate();
	}
	public Date getFirstRepayDate()
	{
		return issuMain.getFirstRepayDate();
	}
	public Integer getId()
	{
		return issuMain.getId();
	}
	public Integer getInterestAlternate()
	{
		return issuMain.getInterestAlternate();
	}
	public BigDecimal getInterestAmount()
	{
		return issuMain.getInterestAmount();
	}
	public BigDecimal getIssueAmount()
	{
		return issuMain.getIssueAmount();
	}
	public Date getIssueDate()
	{
		return issuMain.getIssueDate();
	}
	public Set<IssueExchangeDet> getIssueExchangeDets()
	{
		return issuMain.getIssueExchangeDets();
	}
	public Integer getIssueInterval()
	{
		return issuMain.getIssueInterval();
	}
	public String getIssueKind()
	{
		return issuMain.getIssueKind();
	}
	public String getIssueSerial()
	{
		return issuMain.getIssueSerial();
	}
	public Set<IssueTicketDet> getIssueTicketDets()
	{
		return issuMain.getIssueTicketDets();
	}
	public String getRemark()
	{
		return issuMain.getRemark();
	}
	public Integer getRepayAlternate()
	{
		return issuMain.getRepayAlternate();
	}
	public BigDecimal getSellAmount()
	{
		return issuMain.getSellAmount();
	}
	public String getSellStatus()
	{
		return issuMain.getSellStatus();
	}
	public String getSerialNo()
	{
		return issuMain.getSerialNo();
	}
	public String getShowType()
	{
		return issuMain.getShowType();
	}
	public Integer getSourceIssueId()
	{
		return issuMain.getSourceIssueId();
	}
	public void setAccountYear(String accountYear)
	{
		issuMain.setAccountYear(accountYear);
	}
	public void setAverageRate(BigDecimal averageRate)
	{
		issuMain.setAverageRate(averageRate);
	}
	public void setBondKind(String bondKind)
	{
		issuMain.setBondKind(bondKind);
	}
	public void setBondSellStatus(String bondSellStatus)
	{
		issuMain.setBondSellStatus(bondSellStatus);
	}
	public void setBondType(String bondType)
	{
		issuMain.setBondType(bondType);
	}
	public void setBudgetCode(Integer budgetCode)
	{
		issuMain.setBudgetCode(budgetCode);
	}
	public void setCapitalAmount(BigDecimal capitalAmount)
	{
		issuMain.setCapitalAmount(capitalAmount);
	}
	public void setCashDueDate(Date cashDueDate)
	{
		issuMain.setCashDueDate(cashDueDate);
	}
	public void setChargeRate(BigDecimal chargeRate)
	{
		issuMain.setChargeRate(chargeRate);
	}
	public void setDebtCode(Integer debtCode)
	{
		issuMain.setDebtCode(debtCode);
	}
	public void setDebtMains(Set<DebtMain> debtMains)
	{
		issuMain.setDebtMains(debtMains);
	}
	public void setDebtType(String debtType)
	{
		issuMain.setDebtType(debtType);
	}
	public void setDueDate(Date dueDate)
	{
		issuMain.setDueDate(dueDate);
	}
	public void setExpectAmount(BigDecimal expectAmount)
	{
		issuMain.setExpectAmount(expectAmount);
	}
	public void setFirstInterestDate(Date firstInterestDate)
	{
		issuMain.setFirstInterestDate(firstInterestDate);
	}
	public void setFirstRepayDate(Date firstRepayDate)
	{
		issuMain.setFirstRepayDate(firstRepayDate);
	}
	public void setId(Integer id)
	{
		issuMain.setId(id);
	}
	public void setInterestAlternate(Integer interestAlternate)
	{
		issuMain.setInterestAlternate(interestAlternate);
	}
	public void setInterestAmount(BigDecimal interestAmount)
	{
		issuMain.setInterestAmount(interestAmount);
	}
	public void setIssueAmount(BigDecimal issueAmount)
	{
		issuMain.setIssueAmount(issueAmount);
	}
	public void setIssueDate(Date issueDate)
	{
		issuMain.setIssueDate(issueDate);
	}
	public void setIssueExchangeDets(Set<IssueExchangeDet> issueExchangeDets)
	{
		issuMain.setIssueExchangeDets(issueExchangeDets);
	}
	public void setIssueInterval(Integer issueInterval)
	{
		issuMain.setIssueInterval(issueInterval);
	}
	public void setIssueKind(String issueKind)
	{
		issuMain.setIssueKind(issueKind);
	}
	public void setIssueSerial(String issueSerial)
	{
		issuMain.setIssueSerial(issueSerial);
	}
	public void setIssueTicketDets(Set<IssueTicketDet> issueTicketDets)
	{
		issuMain.setIssueTicketDets(issueTicketDets);
	}
	public void setRemark(String remark)
	{
		issuMain.setRemark(remark);
	}
	public void setRepayAlternate(Integer repayAlternate)
	{
		issuMain.setRepayAlternate(repayAlternate);
	}
	public void setSellAmount(BigDecimal sellAmount)
	{
		issuMain.setSellAmount(sellAmount);
	}
	public void setSellStatus(String sellStatus)
	{
		issuMain.setSellStatus(sellStatus);
	}
	public void setSerialNo(String serialNo)
	{
		issuMain.setSerialNo(serialNo);
	}
	public void setShowType(String showType)
	{
		issuMain.setShowType(showType);
	}
	public void setSourceIssueId(Integer sourceIssueId)
	{
		issuMain.setSourceIssueId(sourceIssueId);
	}
	public String getDays()
	{
		return days;
	}
	public void setDays(String days)
	{
		this.days = days;
	}
	public String getDebtName()
	{
		return issuMain.getDebtName();
	}
	public void setDebtName(String debtName)
	{
		issuMain.setDebtName(debtName);
	}
	public Integer getQryId() {
		return qryId;
	}
	public void setQryId(Integer qryId) {
		this.qryId = qryId;
	}
	public Date getContinueDate() {
		return issuMain.getContinueDate();
	}
	public Date getCreateDate() {
		return issuMain.getCreateDate();
	}
	public String getDebtShortName() {
		return issuMain.getDebtShortName();
	}
	public Date getFinishDate() {
		return issuMain.getFinishDate();
	}
	public Date getModDate() {
		return issuMain.getModDate();
	}
	public BigDecimal getPayableInterestAmount() {
		return issuMain.getPayableInterestAmount();
	}
	public Integer getPayLimit() {
		return issuMain.getPayLimit();
	}
	public String getRateKind() {
		return issuMain.getRateKind();
	}
	public BigDecimal getRealAmount() {
		return issuMain.getRealAmount();
	}
	public String getUserid() {
		return issuMain.getUserid();
	}
	public String getZeroInterestStatus() {
		return issuMain.getZeroInterestStatus();
	}
	public void setContinueDate(Date continueDate) {
		issuMain.setContinueDate(continueDate);
	}
	public void setCreateDate(Date createDate) {
		issuMain.setCreateDate(createDate);
	}
	public void setDebtShortName(String debtShortName) {
		issuMain.setDebtShortName(debtShortName);
	}
	public void setFinishDate(Date finishDate) {
		issuMain.setFinishDate(finishDate);
	}
	public void setModDate(Date modDate) {
		issuMain.setModDate(modDate);
	}
	public void setPayableInterestAmount(BigDecimal payableInterestAmount) {
		issuMain.setPayableInterestAmount(payableInterestAmount);
	}
	public void setPayLimit(Integer payLimit) {
		issuMain.setPayLimit(payLimit);
	}
	public void setRateKind(String rateKind) {
		issuMain.setRateKind(rateKind);
	}
	public void setRealAmount(BigDecimal realAmount) {
		issuMain.setRealAmount(realAmount);
	}
	public void setUserid(String userid) {
		issuMain.setUserid(userid);
	}
	public void setZeroInterestStatus(String zeroInterestStatus) {
		issuMain.setZeroInterestStatus(zeroInterestStatus);
	}
	
}
