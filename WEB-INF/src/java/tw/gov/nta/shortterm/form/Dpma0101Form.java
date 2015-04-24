/**
 * @author AndrewSung
 * @date 2006/3/7
 */

package tw.gov.nta.shortterm.form;

import gov.dnt.tame.common.SupportForm;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.Set;
import java.util.Vector;
import tw.gov.nta.debt.common.DebtPlanDetVectors;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.IssueExchangeDet;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.IssueTicketDet;

public class Dpma0101Form extends SupportForm
{
	private static final long serialVersionUID = 1L;

	IssueMain issuMain = new IssueMain();
	
	private Vector<Object> debtPlanDets = new Vector<Object>();

	public void setDebtPlanDets(Vector<Object> debtPlanDets)
    {
        this.debtPlanDets = debtPlanDets;
    }
	public Collection getDebtPlanDets()
	{
		return debtPlanDets;
	}
	public void setDebtPlanDets(Collection<Object> debtPlanDets)
	{
		this.debtPlanDets = new Vector<Object>(debtPlanDets);
	}
	public Object getDebtPlanDet(int index)
	{
		if (this.debtPlanDets.size() <= index)
		{
			DebtPlanDetVectors debtPlanDetVectors = new DebtPlanDetVectors();
			setDebtPlanDet(index, debtPlanDetVectors);
			return debtPlanDetVectors;
		}
		else
		{
			Object obj = debtPlanDets.get(index);
			if (obj == null)
			{
				DebtPlanDetVectors debtPlanDetVectors = new DebtPlanDetVectors();
				setDebtPlanDet(index, debtPlanDetVectors);
				return debtPlanDetVectors;
			}
			else
				return obj;
		}
	}
	public void setDebtPlanDet(int index, Object debtPlanDet)
	{
		if (this.debtPlanDets.size() <= index)
			debtPlanDets.setSize(index + 1);
		this.debtPlanDets.set(index, debtPlanDet);
	}
	
	private String qryAccountYear;
	private String payType;
	private Date repayDate;
	private String repayDays;
	private String isRepay;
	private String repay;
	private BigDecimal capitalAmountPay;
	private BigDecimal interestAmountPay;
	private BigDecimal rate;
	private BigDecimal totalAmount;
	private BigDecimal issueMainCapitalAmount;
	
	public BigDecimal getIssueMainCapitalAmount() {
		return issueMainCapitalAmount;
	}
	public void setIssueMainCapitalAmount(BigDecimal issueMainCapitalAmount) {
		this.issueMainCapitalAmount = issueMainCapitalAmount;
	}
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	public BigDecimal getRate() {
		return rate;
	}
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
	public BigDecimal getCapitalAmountPay() {
		return capitalAmountPay;
	}
	public void setCapitalAmountPay(BigDecimal capitalAmountPay) {
		this.capitalAmountPay = capitalAmountPay;
	}
	public BigDecimal getInterestAmountPay() {
		return interestAmountPay;
	}
	public void setInterestAmountPay(BigDecimal interestAmountPay) {
		this.interestAmountPay = interestAmountPay;
	}
	public String getRepay() {
		return repay;
	}
	public void setRepay(String repay) {
		this.repay = repay;
	}
	public String getIsRepay()
	{
		return isRepay;
	}
	public void setIsRepay(String isRepay)
	{
		this.isRepay = isRepay;
	}
	public String getRepayDays()
	{
		return repayDays;
	}
	public void setRepayDays(String repayDays)
	{
		this.repayDays = repayDays;
	}
	public Date getRepayDate()
	{
		return repayDate;
	}
	public void setRepayDate(Date repayDate)
	{
		this.repayDate = repayDate;
	}
	public String getDays()
	{
		return DateUtil.getDays(this.getIssueDate(),this.getDueDate()).toString();
	}

	public String getPayType()
	{
		return payType;
	}
	public void setPayType(String payType)
	{
		this.payType = payType;
	}
	public IssueMain getIssuMain()
	{
		return issuMain;
	}
	public void setIssuMain(IssueMain issuMain)
	{
		this.issuMain = issuMain;
	}
	public String getQryAccountYear()
	{
		return qryAccountYear;
	}
	public void setQryAccountYear(String qryAccountYear)
	{
		this.qryAccountYear = qryAccountYear;
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
	public String getDebtName()
	{
		return issuMain.getDebtName();
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
	public Date getModDate()
	{
		return issuMain.getModDate();
	}
	public Integer getPayLimit()
	{
		return issuMain.getPayLimit();
	}
	public String getRateKind()
	{
		return issuMain.getRateKind();
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
	public String getUserid()
	{
		return issuMain.getUserid();
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
	public void setDebtName(String debtName)
	{
		issuMain.setDebtName(debtName);
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
	public void setModDate(Date modDate)
	{
		issuMain.setModDate(modDate);
	}
	public void setPayLimit(Integer payLimit)
	{
		issuMain.setPayLimit(payLimit);
	}
	public void setRateKind(String rateKind)
	{
		issuMain.setRateKind(rateKind);
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
	public void setUserid(String userid)
	{
		issuMain.setUserid(userid);
	}
}
