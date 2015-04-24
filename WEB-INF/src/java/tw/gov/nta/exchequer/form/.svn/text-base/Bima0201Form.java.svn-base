/* Bima0201Form.java
 程式目的：BIMA02
 程式代號：BIMA02
 程式日期：0950301
 程式作者：Eric.Chen
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
 --------------------------------------------------------
 */
package tw.gov.nta.exchequer.form;

import gov.dnt.tame.common.SupportForm;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.beanutils.PropertyUtils;

import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.debt.common.PlanManager;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.DebtPlanDet;
import tw.gov.nta.sql.debt.PaymentMain;
import tw.gov.nta.sql.debt.PaymentTicketDet;

public class Bima0201Form extends SupportForm 
{
	private static final long serialVersionUID = 1L;
	PaymentMain paymentMain = new PaymentMain();
	private BigDecimal totalAmount;
	private Integer qryIssueId; //查詢用pr
	private Date issueDate;
	private String debtName;
	private BigDecimal issueAmount;
	private Integer paymentMainId;
	private Integer planId;
	private BigDecimal realAmount;
	private Date dueDate;
	private BigDecimal dueIssueAmount;
	public BigDecimal getRealAmount() {
		return realAmount;
	}
	public void setRealAmount(BigDecimal realAmount) {
		this.realAmount = realAmount;
	}
	public Integer getPlanId() {
		return planId;
	}
	public void setPlanId(Integer planId) {
		this.planId = planId;
	}
	public Integer getPaymentMainId()
	{
		return paymentMainId;
	}
	public void setPaymentMainId(Integer paymentMainId)
	{
		this.paymentMainId = paymentMainId;
	}
	public BigDecimal getIssueAmount()
	{
		return issueAmount;
	}
	public void setIssueAmount(BigDecimal issueAmount)
	{
		this.issueAmount = issueAmount;
	}
	public BigDecimal getTotalAmount()
	{
		return totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount)
	{
		this.totalAmount = totalAmount;
	}
	public String getDebtName()
	{
		return debtName;
	}
	public void setDebtName(String debtName)
	{
		this.debtName = debtName;
	}
	public Integer getQryIssueId()
	{
		return qryIssueId;
	}
	public void setQryIssueId(Integer qryIssueId)
	{
		this.qryIssueId = qryIssueId;
	}
	public Date getIssueDate()
	{
		return issueDate;
	}
	public void setIssueDate(Date issueDate)
	{
		this.issueDate = issueDate;
	}
	public PaymentMain getPaymentMain()
	{
		return paymentMain;
	}
	public void setPaymentMain(PaymentMain paymentMain)
	{
		this.paymentMain = paymentMain;
	}
	public BigDecimal getBalanceCapitalAmount()
	{
		return paymentMain.getBalanceCapitalAmount();
	}
	public BigDecimal getBuyAmount()
	{
		return paymentMain.getBuyAmount();
	}
	public String getBuyStatus()
	{
		return paymentMain.getBuyStatus();
	}
	public String getCapitalSerial()
	{
		return paymentMain.getCapitalSerial();
	}
	public Integer getDebtId()
	{
		return paymentMain.getDebtId();
	}
	public Integer getInterestDays()
	{
		return paymentMain.getInterestDays();
	}
	public String getInterestSerial()
	{
		return paymentMain.getInterestSerial();
	}
	public Integer getIssueId()
	{
		return paymentMain.getIssueId();
	}
	public BigDecimal getManageCapitalAmount()
	{
		return paymentMain.getManageCapitalAmount();
	}
	public BigDecimal getManageInterestAmount()
	{
		return paymentMain.getManageInterestAmount();
	}
	public Set<PaymentTicketDet> getPaymentTicketDets()
	{
		return paymentMain.getPaymentTicketDets();
	}
	public DebtPlanDet getPlan()
	{
		return paymentMain.getPlan();
	}
	public Date getPlanRepayDate()
	{
		return paymentMain.getPlanRepayDate();
	}
	public Date getRepayDate()
	{
		return paymentMain.getRepayDate();
	}
	public void setBalanceCapitalAmount(BigDecimal balanceCapitalAmount)
	{
		paymentMain.setBalanceCapitalAmount(balanceCapitalAmount);
	}
	public void setBuyAmount(BigDecimal buyAmount)
	{
		paymentMain.setBuyAmount(buyAmount);
	}
	public void setBuyStatus(String buyStatus)
	{
		paymentMain.setBuyStatus(buyStatus);
	}
	public void setCapitalSerial(String capitalSerial)
	{
		paymentMain.setCapitalSerial(capitalSerial);
	}
	public void setDebtId(Integer debtId)
	{
		paymentMain.setDebtId(debtId);
		DebtMain debtMain = new DebtManager().getBean(debtId);
		List debtPlanDetList = new PlanManager().getAllPlanListByDebt(debtMain);
		DebtPlanDet debtPlanDet = new DebtPlanDet();
		if(debtPlanDetList.size()>0)
		 debtPlanDet = (DebtPlanDet) debtPlanDetList.get(0);
		this.setPlan(debtPlanDet);
	}
	public void setInterestDays(Integer interestDays)
	{
		paymentMain.setInterestDays(interestDays);
	}
	public void setInterestSerial(String interestSerial)
	{
		paymentMain.setInterestSerial(interestSerial);
	}
	public void setIssueId(Integer issueId)
	{
		paymentMain.setIssueId(issueId);
		if(issueId !=0 && issueId != null)
			this.setDebtId(((DebtMain)new DebtManager().getBeanByIssue(issueId).get(0)).getId());
	}
	public void setManageCapitalAmount(BigDecimal manageCapitalAmount)
	{
		paymentMain.setManageCapitalAmount(manageCapitalAmount);
	}
	public void setManageInterestAmount(BigDecimal manageInterestAmount)
	{
		paymentMain.setManageInterestAmount(manageInterestAmount);
	}
	public void setPaymentTicketDets(Set<PaymentTicketDet> paymentTicketDets)
	{
		paymentMain.setPaymentTicketDets(paymentTicketDets);
	}
	public void setPlan(DebtPlanDet debtPlanDet)
	{
		paymentMain.setPlan(debtPlanDet);
	}
	public void setPlanRepayDate(Date planRepayDate)
	{
		paymentMain.setPlanRepayDate(planRepayDate);
	}
	public void setRepayDate(Date repayDate)
	{
		paymentMain.setRepayDate(repayDate);
	}
	
	public BigDecimal getAverageRate()
	{
		return paymentMain.getAverageRate();
	}
	public BigDecimal getCapitalAmount()
	{
		return paymentMain.getCapitalAmount();
	}
	public Integer getId()
	{
		return paymentMain.getId();
	}
	public BigDecimal getInterestAmount()
	{
		return paymentMain.getInterestAmount();
	}
	public Date getModDate()
	{
		return paymentMain.getModDate();
	}
	public String getUserid()
	{
		return paymentMain.getUserid();
	}
	public void setAverageRate(BigDecimal averageRate)
	{
		paymentMain.setAverageRate(averageRate);
	}
	public void setAverageRate(String averageRate)
	{
		if(averageRate.trim().equals(""))
			paymentMain.setAverageRate(new BigDecimal(0));
		else
			paymentMain.setAverageRate(new BigDecimal(averageRate));
	}
	public void setCapitalAmount(BigDecimal capitalAmount)
	{
		paymentMain.setCapitalAmount(capitalAmount);
	}
	public void setId(Integer id)
	{
		paymentMain.setId(id);
	}
	public void setInterestAmount(BigDecimal interestAmount)
	{
		paymentMain.setInterestAmount(interestAmount);
	}
	public void setModDate(Date modDate)
	{
		paymentMain.setModDate(modDate);
	}
	public void setUserid(String userid)
	{
		paymentMain.setUserid(userid);
	}
	public Integer getSourcId() {
		return paymentMain.getSourcId();
	}
	public void setSourcId(Integer sourcId) {
		paymentMain.setSourcId(sourcId);
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public BigDecimal getDueIssueAmount() {
		return issueAmount.subtract(getBalanceCapitalAmount());
	}
	public void setDueIssueAmount(BigDecimal dueIssueAmount) {
		this.dueIssueAmount = dueIssueAmount;
	}
}
