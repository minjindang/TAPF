/* Cpma0101Form.java
程式目的：CPMA01
程式代號：CPMA01
程式日期：0950306
程式作者：Eric.Chen
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
*/
package tw.gov.nta.debt.form;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.IssueExchangeDet;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.IssueTicketDet;
import tw.gov.nta.sql.debt.PaymentMain;
import tw.gov.nta.sql.debt.PaymentTicketDet;
import tw.gov.nta.sql.debt.dao.IssueMainDAO;
import gov.dnt.tame.common.LabelValueBean;
import gov.dnt.tame.common.SupportForm;
import gov.dnt.tame.util.DateUtil;

public class Cpma0101Form extends SupportForm {
	private static final long serialVersionUID = 1L;

	private String qryaccountYear;		//查詢用年度
	private String qrydebtName;		//查詢用名稱
	private String debtType;
	private int issueId;
	private int oklist;
	private String ischeck[];
	private BigDecimal totalAmount;
	private BigDecimal totalReturn;
	private String[] interestDate;
	private BigDecimal[] capitalAmountPay;
	private BigDecimal[] interestAmountPay;
	private Date qryrepayDate;
	private int[] days;
	private Integer[] debtMainId;
	private Integer[] paymentId;
	private Date startDate;
	private Date endDate;
	
	PaymentMain myPay = new PaymentMain();
	IssueMain myMain = new IssueMain();
	

	public BigDecimal[] getCapitalAmountPay() {
		return capitalAmountPay;
	}

	public void setCapitalAmountPay(BigDecimal[] capitalAmountPay) {
		this.capitalAmountPay = capitalAmountPay;
	}

	public BigDecimal[] getInterestAmountPay() {
		return interestAmountPay;
	}

	public void setInterestAmountPay(BigDecimal[] interestAmountPay) {
		this.interestAmountPay = interestAmountPay;
	}

	public IssueMain getMyMain() {
		return myMain;
	}

	public BigDecimal getBalanceCapitalAmount() {
		return myPay.getBalanceCapitalAmount();
	}

	public BigDecimal getBuyAmount() {
		return myPay.getBuyAmount();
	}

	public String getBuyStatus() {
		return myPay.getBuyStatus();
	}

	public String getCapitalSerial() {
		return myPay.getCapitalSerial();
	}

	public Integer getDebtId() {
		return myPay.getDebtId();
	}

	public Integer getInterestDays() {
		return myPay.getInterestDays();
	}

	public String getInterestSerial() {
		return myPay.getInterestSerial();
	}

	public Integer getIssueId() {
		return myPay.getIssueId();
	}

	public BigDecimal getManageCapitalAmount() {
		return myPay.getManageCapitalAmount();
	}

	public BigDecimal getManageInterestAmount() {
		return myPay.getManageInterestAmount();
	}

	public Set<PaymentTicketDet> getPaymentTicketDets() {
		return myPay.getPaymentTicketDets();
	}

	public Date getRepayDate() {
		return myPay.getRepayDate();
	}

	public void setBalanceCapitalAmount(BigDecimal balanceCapitalAmount) {
		myPay.setBalanceCapitalAmount(balanceCapitalAmount);
	}

	public void setBuyAmount(BigDecimal buyAmount) {
		myPay.setBuyAmount(buyAmount);
	}

	public void setBuyStatus(String buyStatus) {
		myPay.setBuyStatus(buyStatus);
	}

	public void setCapitalSerial(String capitalSerial) {
		myPay.setCapitalSerial(capitalSerial);
	}

	public void setDebtId(Integer debtId) {
		myPay.setDebtId(debtId);
	}

	public void setInterestDays(Integer interestDays) {
		myPay.setInterestDays(interestDays);
	}

	public void setInterestSerial(String interestSerial) {
		myPay.setInterestSerial(interestSerial);
	}

	public void setIssueId(Integer issueId) {
		myPay.setIssueId(issueId);
	}

	public void setManageCapitalAmount(BigDecimal manageCapitalAmount) {
		myPay.setManageCapitalAmount(manageCapitalAmount);
	}

	public void setManageInterestAmount(BigDecimal manageInterestAmount) {
		myPay.setManageInterestAmount(manageInterestAmount);
	}

	public void setPaymentTicketDets(Set<PaymentTicketDet> paymentTicketDets) {
		myPay.setPaymentTicketDets(paymentTicketDets);
	}
	public void setRepayDate(Date repayDate) {
		myPay.setRepayDate(repayDate);
	}
	public void setRepayDate(String repayDate) {
		myPay.setRepayDate(DateUtil.str2Date(DateUtil.ROCDate2Date(repayDate)));
	}
	public void setMyMain(IssueMain myMain) {
		this.myMain = myMain;
	}

	public PaymentMain getMyPay() {
		return myPay;
	}

	public void setMyPay(PaymentMain myPay) {
		this.myPay = myPay;
	}

	public String getQryaccountYear() {
		return qryaccountYear;
	}

	public void setQryaccountYear(String qryaccountYear) {
		this.qryaccountYear = qryaccountYear;
	}

	public String getQrydebtName() {
		return qrydebtName;
	}

	public void setQrydebtName(String qrydebtName) {
		qrydebtName = java.net.URLDecoder.decode(qrydebtName);
		this.qrydebtName = qrydebtName;
	}

	public String getAccountYear() {
		return myMain.getAccountYear();
	}

	public BigDecimal getAverageRate() {
		return myMain.getAverageRate();
	}

	public String getBondKind() {
		return myMain.getBondKind();
	}

	public String getBondSellStatus() {
		return myMain.getBondSellStatus();
	}

	public String getBondType() {
		return myMain.getBondType();
	}

	public Integer getBudgetCode() {
		return myMain.getBudgetCode();
	}

	public Date getCashDueDate() {
		return myMain.getCashDueDate();
	}

	public BigDecimal getChargeRate() {
		return myMain.getChargeRate();
	}

	public Integer getDebtCode() {
		return myMain.getDebtCode();
	}

	public Set<DebtMain> getDebtMains() {
		return myMain.getDebtMains();
	}

	public String getDebtName() {
		return myMain.getDebtName();
	}

	public Date getDueDate() {
		return myMain.getDueDate();
	}

	public BigDecimal getExpectAmount() {
		return myMain.getExpectAmount();
	}

	public Date getFirstInterestDate() {
		return myMain.getFirstInterestDate();
	}

	public Date getFirstRepayDate() {
		return myMain.getFirstRepayDate();
	}

	public Integer getId() {
		return myMain.getId();
	}

	public Integer getInterestAlternate() {
		return myMain.getInterestAlternate();
	}

	public BigDecimal getIssueAmount() {
		return myMain.getIssueAmount();
	}

	public BigDecimal getCapitalAmount() {
		return myMain.getCapitalAmount();
	}

	public BigDecimal getInterestAmount() {
		return myMain.getInterestAmount();
	}

	public void setCapitalAmount(BigDecimal capitalAmount) {
		myMain.setCapitalAmount(capitalAmount);
	}

	public void setInterestAmount(BigDecimal interestAmount) {
		myMain.setInterestAmount(interestAmount);
	}

	public Date getIssueDate() {
		return myMain.getIssueDate();
	}

	public Set<IssueExchangeDet> getIssueExchangeDets() {
		return myMain.getIssueExchangeDets();
	}

	public Integer getIssueInterval() {
		return myMain.getIssueInterval();
	}

	public String getIssueKind() {
		return myMain.getIssueKind();
	}

	public String getIssueSerial() {
		return myMain.getIssueSerial();
	}

	public Set<IssueTicketDet> getIssueTicketDets() {
		return myMain.getIssueTicketDets();
	}

	public Date getModDate() {
		return myMain.getModDate();
	}

	public Integer getPayLimit() {
		return myMain.getPayLimit();
	}

	public String getRateKind() {
		return myMain.getRateKind();
	}

	public String getRemark() {
		return myMain.getRemark();
	}

	public Integer getRepayAlternate() {
		return myMain.getRepayAlternate();
	}

	public BigDecimal getSellAmount() {
		return myMain.getSellAmount();
	}

	public String getSellStatus() {
		return myMain.getSellStatus();
	}

	public String getSerialNo() {
		return myMain.getSerialNo();
	}

	public String getShowType() {
		return myMain.getShowType();
	}

	public Integer getSourceIssueId() {
		return myMain.getSourceIssueId();
	}

	public String getUserid() {
		return myMain.getUserid();
	}

	public void setAccountYear(String accountYear) {
		myMain.setAccountYear(accountYear);
	}

	public void setAverageRate(BigDecimal averageRate) {
		myMain.setAverageRate(averageRate);
	}

	public void setBondKind(String bondKind) {
		myMain.setBondKind(bondKind);
	}

	public void setBondSellStatus(String bondSellStatus) {
		myMain.setBondSellStatus(bondSellStatus);
	}

	public void setBondType(String bondType) {
		myMain.setBondType(bondType);
	}

	public void setBudgetCode(Integer budgetCode) {
		myMain.setBudgetCode(budgetCode);
	}

	public void setCashDueDate(Date cashDueDate) {
		myMain.setCashDueDate(cashDueDate);
	}

	public void setChargeRate(BigDecimal chargeRate) {
		myMain.setChargeRate(chargeRate);
	}

	public void setDebtCode(Integer debtCode) {
		myMain.setDebtCode(debtCode);
	}

	public void setDebtMains(Set<DebtMain> debtMains) {
		myMain.setDebtMains(debtMains);
	}

	public void setDebtName(String debtName) {
		myMain.setDebtName(debtName);
	}


	public void setDueDate(Date dueDate) {
		myMain.setDueDate(dueDate);
	}

	public void setExpectAmount(BigDecimal expectAmount) {
		myMain.setExpectAmount(expectAmount);
	}

	public void setFirstInterestDate(Date firstInterestDate) {
		myMain.setFirstInterestDate(firstInterestDate);
	}

	public void setFirstRepayDate(Date firstRepayDate) {
		myMain.setFirstRepayDate(firstRepayDate);
	}

	public void setId(Integer id) {
		myMain.setId(id);
	}

	public void setInterestAlternate(Integer interestAlternate) {
		myMain.setInterestAlternate(interestAlternate);
	}

	public void setIssueDate(Date issueDate) {
		myMain.setIssueDate(issueDate);
	}

	public void setIssueExchangeDets(Set<IssueExchangeDet> issueExchangeDets) {
		myMain.setIssueExchangeDets(issueExchangeDets);
	}

	public void setIssueInterval(Integer issueInterval) {
		myMain.setIssueInterval(issueInterval);
	}

	public void setIssueKind(String issueKind) {
		myMain.setIssueKind(issueKind);
	}

	public void setIssueSerial(String issueSerial) {
		myMain.setIssueSerial(issueSerial);
	}

	public void setIssueTicketDets(Set<IssueTicketDet> issueTicketDets) {
		myMain.setIssueTicketDets(issueTicketDets);
	}

	public void setModDate(Date modDate) {
		myMain.setModDate(modDate);
	}

	public void setPayLimit(Integer payLimit) {
		myMain.setPayLimit(payLimit);
	}

	public void setRateKind(String rateKind) {
		myMain.setRateKind(rateKind);
	}

	public void setRemark(String remark) {
		myMain.setRemark(remark);
	}

	public void setRepayAlternate(Integer repayAlternate) {
		myMain.setRepayAlternate(repayAlternate);
	}

	public void setSellAmount(BigDecimal sellAmount) {
		myMain.setSellAmount(sellAmount);
	}

	public void setSellStatus(String sellStatus) {
		myMain.setSellStatus(sellStatus);
	}

	public void setSerialNo(String serialNo) {
		myMain.setSerialNo(serialNo);
	}

	public void setShowType(String showType) {
		myMain.setShowType(showType);
	}

	public void setSourceIssueId(Integer sourceIssueId) {
		myMain.setSourceIssueId(sourceIssueId);
	}

	public void setUserid(String userid) {
		myMain.setUserid(userid);
	}

	public String getDebtType() {
		return debtType;
	}

	public void setDebtType(String debtType) {
		this.debtType = debtType;
	}

	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}




	public BigDecimal getTotalReturn() {
		return totalReturn;
	}

	public void setTotalReturn(BigDecimal totalReturn) {
		this.totalReturn = totalReturn;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getOklist() {
		return oklist;
	}

	public void setOklist(int oklist) {
		this.oklist = oklist;
	}

	public String[] getIscheck() {
		return ischeck;
	}

	public void setIscheck(String[] ischeck) {
		this.ischeck = ischeck;
	}

	public Date getQryrepayDate() {
		return qryrepayDate;
	}

	public void setQryrepayDate(Date qryrepayDate) {
		this.qryrepayDate = qryrepayDate;
	}

	public Date getPlanRepayDate() {
		return myPay.getPlanRepayDate();
	}

	public void setPlanRepayDate(Date planRepayDate) {
		myPay.setPlanRepayDate(planRepayDate);
	}
	
	public List<LabelValueBean>  getQryDebtNameList()
	{
		Session session = new IssueMainDAO().getSession();
		Query query = session.createQuery("select debtName from IssueMain where debtType = 'C' order by accountYear desc , serialNo desc ");
		List myList = query.list();
		List<LabelValueBean> labelValueBeanList = new LinkedList<LabelValueBean>();
        if(null != myList && 0 != myList.size())
        {
            for (Iterator it = myList.iterator(); it.hasNext();)
            {
            	Object obj = (Object) it.next();
            	LabelValueBean labelValueBean = new LabelValueBean();
            	labelValueBean.setLabel((String)obj);
            	labelValueBean.setValuess((String)obj);
            	labelValueBeanList.add(labelValueBean);
            }
        }
		session.close();
		return labelValueBeanList; 
	}
	
	public List<LabelValueBean>  getDebtNameList()
	{
		Session session = new IssueMainDAO().getSession();
		Query query = session.createQuery("select id , debtName from IssueMain where debtType = 'C' order by accountYear desc , serialNo desc ");
		List myList = query.list();
		List<LabelValueBean> debtNameList = new LinkedList<LabelValueBean>();
        if(null != myList && 0 != myList.size())
        {
            for (Iterator it = myList.iterator(); it.hasNext();)
            {
            	Object[] obj = (Object[]) it.next();
            	LabelValueBean labelValueBean = new LabelValueBean();
            	labelValueBean.setLabel((String)obj[1]);
            	labelValueBean.setValuess(((Integer)obj[0]).toString());
            	debtNameList.add(labelValueBean);
            }
        }
		session.close();
		return debtNameList; 
	}

	public int[] getDays() {
		return days;
	}

	public void setDays(int[] days) {
		this.days = days;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer[] getDebtMainId() {
		return debtMainId;
	}

	public void setDebtMainId(Integer[] debtMainId) {
		this.debtMainId = debtMainId;
	}

	public Integer[] getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer[] paymentId) {
		this.paymentId = paymentId;
	}

	public String[] getInterestDate() {
		return interestDate;
	}

	public void setInterestDate(String[] interestDate) {
		this.interestDate = interestDate;
	}





}
