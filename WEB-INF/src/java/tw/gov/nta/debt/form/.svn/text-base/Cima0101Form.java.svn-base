/* Cima0101Form.java
程式目的：CIMA01
程式代號：CIMA01
程式日期：0950306
程式作者：Eric.Chen
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
*/
package tw.gov.nta.debt.form;

import gov.dnt.tame.common.LabelValueBean;
import gov.dnt.tame.common.SupportForm;
import gov.dnt.tame.util.ListToolManager;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import tw.gov.nta.sql.BudgetRef;
import tw.gov.nta.sql.CodeDet;
import tw.gov.nta.sql.DebitRef;
import tw.gov.nta.sql.dao.BudgetRefDAO;
import tw.gov.nta.sql.dao.CodeDetDAO;
import tw.gov.nta.sql.dao.DebitRefDAO;
import tw.gov.nta.sql.debt.BankRef;
import tw.gov.nta.sql.debt.ContractBankMain;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.DebtPlanDet;
import tw.gov.nta.sql.debt.DebtRateDet;
import tw.gov.nta.sql.debt.DefaultBankRef;
import tw.gov.nta.sql.debt.InterestAdjustMain;
import tw.gov.nta.sql.debt.IssueDet;
import tw.gov.nta.sql.debt.IssueExchangeDet;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.IssueTicketDet;
import tw.gov.nta.sql.debt.PaymentMain;
import tw.gov.nta.sql.debt.PaymentTicketDet;
import tw.gov.nta.sql.debt.dao.IssueMainDAO;

public class Cima0101Form extends SupportForm {
	private static final long serialVersionUID = 1L;

	private String qryaccountYear;	//查詢用 年度
	private String qryserialNo;		//查詢用 期次
	private String qryissueSerial;		//查詢用 期別
	private String qrydebtName;		//查詢用 名稱
	private String labelCount;
	private String textCount;
	private int[] countRow;
	private BigDecimal totalAmount;
	private Set<DebtMain> debtMains;
	private Integer bankId;
	private String isReturn;
	private String[] ischeck;
	private int[] rateindex;
	private int[] capindex;
	private List ratelist;
	private List caplist;
	private List newcaplist;
	private int nowindex;
	private int oklist;
	private int debtId;
	private Date oldIssueDate;
	private Date oldDueDate;
	private String checkGetMark;
	private BigDecimal commitFirstRate;
	private BigDecimal sumCapitalAmountFuture;
	private BigDecimal nowAverageRate;
	PaymentTicketDet myDet = new PaymentTicketDet();
	DebtRateDet myRate = new DebtRateDet();
	DebtPlanDet myDPDet = new DebtPlanDet();
	IssueMain myIss = new IssueMain();
	BankRef bankRef= new DefaultBankRef();
	DebtMain myDMain = new DebtMain();
	IssueDet myIssDet = new IssueDet();
	public String getDeleteRemark() {
		return myIssDet.getDeleteRemark();
	}
	public BigDecimal getPlanAmount() {
		return myIssDet.getPlanAmount();
	}
	public void setDeleteRemark(String deleteRemark) {
		myIssDet.setDeleteRemark(deleteRemark);
	}
	public void setPlanAmount(BigDecimal planAmount) {
		myIssDet.setPlanAmount(planAmount);
	}
	public IssueDet getMyIssDet() {
		return myIssDet;
	}
	public void setMyIssDet(IssueDet myIssDet) {
		this.myIssDet = myIssDet;
	}
	public BigDecimal getCapitalAmountDPT() {
		return myDPDet.getCapitalAmount();
	}
	public void setCapitalAmountDPT(BigDecimal capitalAmountDPT) {
		myDPDet.setCapitalAmount(capitalAmountDPT);
	}
	public BigDecimal getInterestAmountDPT() {
		return myDPDet.getInterestAmount();
	}
	public void setInterestAmountDPT(BigDecimal interestAmountDPT) {
		myDPDet.setInterestAmount(interestAmountDPT);
	}
	
	public Integer getBudgetCodeDebt() {
		return myDMain.getBudgetCode();
	}
	public Integer getDebtCodeDebt() {
		return myDMain.getDebtCode();
	}
	public void setBudgetCodeDebt(Integer budgetCodeDebt) {
		myDMain.setBudgetCode(budgetCodeDebt);
	}
	public void setDebtCodeDebt(Integer debtCodeDebt) {
		myDMain.setDebtCode(debtCodeDebt);
	}
	public Integer getBankId() {
		return bankId;
	}
	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}
	public BankRef getBankRef() {
		return bankRef;
	}
	public void setBankRef(BankRef bankRef) {
		this.bankRef = bankRef;
	}
	public Set<DebtMain> getDebtMains() {
		return debtMains;
	}
	public void setDebtMains(Set<DebtMain> debtMains) {
		this.debtMains = debtMains;
	}
	public String getLabelCount() {
		return labelCount;
	}
	public void setLabelCount(String labelCount) {
		this.labelCount = labelCount;
	}
	public PaymentTicketDet getMyDet() {
		return myDet;
	}
	public void setMyDet(PaymentTicketDet myDet) {
		this.myDet = myDet;
	}
	public DebtMain getMyDMain() {
		return myDMain;
	}
	public void setMyDMain(DebtMain myDMain) {
		this.myDMain = myDMain;
	}
	public IssueMain getMyIss() {
		return myIss;
	}
	public void setMyIss(IssueMain myIss) {
		this.myIss = myIss;
	}
	public DebtRateDet getMyRate() {
		return myRate;
	}
	public void setMyRate(DebtRateDet myRate) {
		this.myRate = myRate;
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
	public String getQryissueSerial() {
		return qryissueSerial;
	}
	public void setQryissueSerial(String qryissueSerial) {
		this.qryissueSerial = qryissueSerial;
	}
	public String getQryserialNo() {
		return qryserialNo;
	}
	public void setQryserialNo(String qryserialNo) {
		this.qryserialNo = qryserialNo;
	}
	public String getTextCount() {
		return textCount;
	}
	public void setTextCount(String textCount) {
		this.textCount = textCount;
	}
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Integer getId() {
		return myIss.getId();
	}
	public void setId(Integer id) {
		myIss.setId(id);
	}
	public BigDecimal getRealAmount() {
		return myDMain.getRealAmount();
	}
	public Integer getBudgetCode() {
		return myIss.getBudgetCode();
	}
	public Integer getDebtCode() {
		return myIss.getDebtCode();
	}
	public void setBudgetCode(Integer budgetCode) {
		myIss.setBudgetCode(budgetCode);
	}
	public void setDebtCode(Integer debtCode) {
		myIss.setDebtCode(debtCode);
	}
	public void setRealAmount(BigDecimal realAmount) {
		myDMain.setRealAmount(realAmount);
	}
	public BigDecimal getIssueAmountDet() {
		return myDMain.getIssueAmount();
	}
	public void setIssueAmountDet(BigDecimal issueAmountDet) {
		myDMain.setIssueAmount(issueAmountDet);
	}
	public BigDecimal getIssueAmount() {
		return myIss.getIssueAmount();
	}
	public void setIssueAmount(BigDecimal issueAmount) {
		myIss.setIssueAmount(issueAmount);
	}
	public BigDecimal getOriginInterestAmount() {
		return myDMain.getOriginInterestAmount();
	}
	public void setOriginInterestAmount(BigDecimal originInterestAmount) {
		myDMain.setOriginInterestAmount(originInterestAmount);
	}
	public BigDecimal getCompareAmount() {
		return myDMain.getCompareAmount();
	}
	public void setCompareAmount(BigDecimal compareAmount) {
		myDMain.setCompareAmount(compareAmount);
	}
	public String getAccrue() {
		return myDMain.getAccrue();
	}
	public void setAccrue(String accrue) {
		myDMain.setAccrue(accrue);
	}
	public Date getAccrueDate() {
		return myDMain.getAccrueDate();
	}
	public void setAccrueDate(Date accrueDate) {
		myDMain.setAccrueDate(accrueDate);
	}
	public BigDecimal getCompareRate() {
		return myDMain.getCompareRate().setScale(3,BigDecimal.ROUND_HALF_UP);
	}
	public void setCompareRate(BigDecimal compareRate) {
		myDMain.setCompareRate(compareRate);
	}
	public String getUserid() {
		return myDMain.getUserid();
	}
	public void setUserid(String userid) {
		myDMain.setUserid(userid);
	}
	public Date getModDate() {
		return myDMain.getModDate();
	}
	public void setModDate(Date modDate) {
		myDMain.setModDate(modDate);
	}
	public IssueMain getIssue() {
		return myDMain.getIssue();
	}
	public void setIssue(IssueMain issue) {
		myDMain.setIssue(issue);
	}
	public BankRef getBank() {
		return myDMain.getBank();
	}
	public void setBank(BankRef bank) {
		myDMain.setBank(bank);
	}
	public Date getFinishDate() {
		return myIss.getFinishDate();
	}
	public void setFinishDate(Date finishDate) {
		myIss.setFinishDate(finishDate);
	}
	public Set<InterestAdjustMain> getInterestAdjustMains() {
		return myDMain.getInterestAdjustMains();
	}
	public void setInterestAdjustMains(Set<InterestAdjustMain> interestAdjustMains) {
		myDMain.setInterestAdjustMains(interestAdjustMains);
	}
	public void addTointerestAdjustMains(InterestAdjustMain interestAdjustMain) {
		myDMain.addTointerestAdjustMains(interestAdjustMain);
	}
	public Set<DebtRateDet> getDebtRateDets() {
		return myDMain.getDebtRateDets();
	}
	public void setDebtRateDets(Set<DebtRateDet> debtRateDets) {
		myDMain.setDebtRateDets(debtRateDets);
	}
	public void addTodebtRateDets(DebtRateDet debtRateDet) {
		myDMain.addTodebtRateDets(debtRateDet);
	}
	public Set<DebtPlanDet> getDebtPlanDets() {
		return myDMain.getDebtPlanDets();
	}
	public void setDebtPlanDets(Set<DebtPlanDet> debtPlanDets) {
		myDMain.setDebtPlanDets(debtPlanDets);
	}
	public void addTodebtPlanDets(DebtPlanDet debtPlanDet) {
		myDMain.addTodebtPlanDets(debtPlanDet);
	}
	public boolean equals(Object obj) {
		return myDMain.equals(obj);
	}
	public int hashCode() {
		return myDMain.hashCode();
	}
	public int compareTo(Object obj) {
		return myDMain.compareTo(obj);
	}
	public String toString() {
		return myDMain.toString();
	}
	public String getTicketName() {
		return myDet.getTicketName();
	}
	public void setTicketName(String ticketName) {
		myDet.setTicketName(ticketName);
	}
	public BigDecimal getTicketAmount() {
		return myDet.getTicketAmount();
	}
	public void setTicketAmount(BigDecimal ticketAmount) {
		myDet.setTicketAmount(ticketAmount);
	}
	public Long getTicketCount() {
		return myDet.getTicketCount();
	}
	public void setTicketCount(Long ticketCount) {
		myDet.setTicketCount(ticketCount);
	}
	public PaymentMain getPayment() {
		return myDet.getPayment();
	}
	public void setPayment(PaymentMain payment) {
		myDet.setPayment(payment);
	}
	public Date getIssueDate() {
		return myIss.getIssueDate();
	}
	public void setIssueDate(Date issueDate) {
		myIss.setIssueDate(issueDate);
	}
	public String getIssueSerial() {
		return myIss.getIssueSerial();
	}
	public void setIssueSerial(String issueSerial) {
		myIss.setIssueSerial(issueSerial);
	}
	public String getAccountYear() {
		return myIss.getAccountYear();
	}
	public void setAccountYear(String accountYear) {
		myIss.setAccountYear(accountYear);
	}
	public String getSerialNo() {
		return myIss.getSerialNo();
	}
	public void setSerialNo(String serialNo) {
		myIss.setSerialNo(serialNo);
	}
	public String getDebtType() {
		return myIss.getDebtType();
	}
	public void setDebtType(String debtType) {
		myIss.setDebtType(debtType);
	}
	public String getDebtName() {
		return myIss.getDebtName();
	}
	public void setDebtName(String debtName) {
		myIss.setDebtName(debtName);
	}
	public BigDecimal getAverageRate() {
		return myIss.getAverageRate();
	}
	public void setAverageRate(BigDecimal averageRate) {
		myIss.setAverageRate(averageRate);
	}
	public Date getDueDate() {
		return myIss.getDueDate();
	}
	public void setDueDate(Date dueDate) {
		myIss.setDueDate(dueDate);
	}
	public String getShowType() {
		return myIss.getShowType();
	}
	public void setShowType(String showType) {
		myIss.setShowType(showType);
	}
	public String getIssueKind() {
		return myIss.getIssueKind();
	}
	public void setIssueKind(String issueKind) {
		myIss.setIssueKind(issueKind);
	}
	public BigDecimal getExpectAmount() {
		return myIss.getExpectAmount();
	}
	public void setExpectAmount(BigDecimal expectAmount) {
		myIss.setExpectAmount(expectAmount);
	}
	public String getRemark() {
		return myIss.getRemark();
	}
	public void setRemark(String remark) {
		myIss.setRemark(remark);
	}
	public String getBondType() {
		return myIss.getBondType();
	}
	public void setBondType(String bondType) {
		myIss.setBondType(bondType);
	}
	public Date getCashDueDate() {
		return myIss.getCashDueDate();
	}
	public void setCashDueDate(Date cashDueDate) {
		myIss.setCashDueDate(cashDueDate);
	}
	public BigDecimal getChargeRate() {
		return myIss.getChargeRate();
	}
	public void setChargeRate(BigDecimal chargeRate) {
		myIss.setChargeRate(chargeRate);
	}
	public String getSellStatus() {
		return myIss.getSellStatus();
	}
	public void setSellStatus(String sellStatus) {
		myIss.setSellStatus(sellStatus);
	}
	public String getBondSellStatus() {
		return myIss.getBondSellStatus();
	}
	public void setBondSellStatus(String bondSellStatus) {
		myIss.setBondSellStatus(bondSellStatus);
	}
	public BigDecimal getCapitalAmount() {
		return myIss.getCapitalAmount();
	}
	public void setCapitalAmount(BigDecimal capitalAmount) {
		myIss.setCapitalAmount(capitalAmount);
	}
	public BigDecimal getInterestAmount() {
		return myIss.getInterestAmount();
	}
	public void setInterestAmount(BigDecimal interestAmount) {
		myIss.setInterestAmount(interestAmount);
	}
	public Date getFirstRepayDate() {
		return myIss.getFirstRepayDate();
	}
	public void setFirstRepayDate(Date firstRepayDate) {
		myIss.setFirstRepayDate(firstRepayDate);
	}
	public Date getFirstInterestDate() {
		return myIss.getFirstInterestDate();
	}
	public void setFirstInterestDate(Date firstInterestDate) {
		myIss.setFirstInterestDate(firstInterestDate);
	}
	public Integer getRepayAlternate() {
		return myIss.getRepayAlternate();
	}
	public void setRepayAlternate(Integer repayAlternate) {
		myIss.setRepayAlternate(repayAlternate);
	}
	public Integer getInterestAlternate() {
		return myIss.getInterestAlternate();
	}
	public void setInterestAlternate(Integer interestAlternate) {
		myIss.setInterestAlternate(interestAlternate);
	}
	public Integer getSourceIssueId() {
		return myIss.getSourceIssueId();
	}
	public void setSourceIssueId(Integer sourceIssueId) {
		myIss.setSourceIssueId(sourceIssueId);
	}
	public Integer getIssueInterval() {
		return myIss.getIssueInterval();
	}
	public void setIssueInterval(Integer issueInterval) {
		myIss.setIssueInterval(issueInterval);
	}
	public String getBondKind() {
		return myIss.getBondKind();
	}
	public void setBondKind(String bondKind) {
		myIss.setBondKind(bondKind);
	}
	public BigDecimal getSellAmount() {
		return myIss.getSellAmount();
	}
	public void setSellAmount(BigDecimal sellAmount) {
		myIss.setSellAmount(sellAmount);
	}
	public Integer getPayLimit() {
		return myIss.getPayLimit();
	}
	public void setPayLimit(Integer payLimit) {
		myIss.setPayLimit(payLimit);
	}
	public String getRateKind() {
		return myIss.getRateKind();
	}
	public void setRateKind(String rateKind) {
		myIss.setRateKind(rateKind);
	}
	public Set<IssueTicketDet> getIssueTicketDets() {
		return myIss.getIssueTicketDets();
	}
	public void setIssueTicketDets(Set<IssueTicketDet> issueTicketDets) {
		myIss.setIssueTicketDets(issueTicketDets);
	}

	public Set<IssueExchangeDet> getIssueExchangeDets() {
		return myIss.getIssueExchangeDets();
	}
	public void setIssueExchangeDets(Set<IssueExchangeDet> issueExchangeDets) {
		myIss.setIssueExchangeDets(issueExchangeDets);
	}
	public BigDecimal getDebtRate() {
		return myRate.getDebtRate();
	}
	public void setDebtRate(BigDecimal debtRate) {
		myRate.setDebtRate(debtRate);
	}
	public Date getEffectiveDate() {
		return myRate.getEffectiveDate();
	}
	public void setEffectiveDate(Date effectiveDate) {
		myRate.setEffectiveDate(effectiveDate);
	}
	public Date getSuspendDate() {
		return myRate.getSuspendDate();
	}
	public void setSuspendDate(Date suspendDate) {
		myRate.setSuspendDate(suspendDate);
	}
	public String getDeleteMark() {
		return myRate.getDeleteMark();
	}
	public void setDeleteMark(String deleteMark) {
		myRate.setDeleteMark(deleteMark);
	}
	public Integer getGroupId() {
		return myRate.getGroupId();
	}
	public void setGroupId(Integer groupId) {
		myRate.setGroupId(groupId);
	}
	public DebtMain getDebt() {
		return myRate.getDebt();
	}
	public void setDebt(DebtMain debt) {
		myRate.setDebt(debt);
	}
	public String getBankCode() {
		return bankRef.getBankCode();
	}
	public void setBankCode(String bankCode) {
		bankRef.setBankCode(bankCode);
	}
	public String getBankName() {
		return bankRef.getBankName();
	}
	public void setBankName(String bankName) {
		bankRef.setBankName(bankName);
	}
	public String getShortBankName() {
		return bankRef.getShortBankName();
	}
	public void setShortBankName(String shortBankName) {
		bankRef.setShortBankName(shortBankName);
	}
	public Integer getBelongToBankId() {
		return bankRef.getBelongToBankId();
	}
	public void setBelongToBankId(Integer belongToBankId) {
		bankRef.setBelongToBankId(belongToBankId);
	}
	public Integer getCombinationBankId() {
		return bankRef.getCombinationBankId();
	}
	public void setCombinationBankId(Integer combinationBankId) {
		bankRef.setCombinationBankId(combinationBankId);
	}
	public Date getCombinationDate() {
		return bankRef.getCombinationDate();
	}
	public void setCombinationDate(Date combinationDate) {
		bankRef.setCombinationDate(combinationDate);
	}
	public String getTpsbankCode() {
		return bankRef.getTpsbankCode();
	}
	public void setTpsbankCode(String tpsbankCode) {
		bankRef.setTpsbankCode(tpsbankCode);
	}
	public String getUsrid() {
		return bankRef.getUsrid();
	}
	public void setUsrid(String usrid) {
		bankRef.setUsrid(usrid);
	}
	public Date getCreateDate() {
		return bankRef.getCreateDate();
	}
	public void setCreateDate(Date createDate) {
		bankRef.setCreateDate(createDate);
	}
	public Date getBeginDate() {
		return bankRef.getBeginDate();
	}
	public void setBeginDate(Date beginDate) {
		bankRef.setBeginDate(beginDate);
	}
	public Date getEndDate() {
		return bankRef.getEndDate();
	}
	public void setEndDate(Date endDate) {
		bankRef.setEndDate(endDate);
	}
	public Set<ContractBankMain> getContractBankMains() {
		return bankRef.getContractBankMains();
	}
	public void setContractBankMains(Set<ContractBankMain> contractBankMains) {
		bankRef.setContractBankMains(contractBankMains);
	}
	public void addTocontractBankMains(ContractBankMain contractBankMain) {
		bankRef.addTocontractBankMains(contractBankMain);
	}
	public DebtPlanDet getMyDPDet() {
		return myDPDet;
	}
	public void setMyDPDet(DebtPlanDet myDPDet) {
		this.myDPDet = myDPDet;
	}
	public void addTopaymentMains(PaymentMain paymentMain) {
		myDPDet.addTopaymentMains(paymentMain);
	}
	public Integer getCapitalSerial() {
		return myDPDet.getCapitalSerial();
	}
	public BigDecimal getChargeAmount() {
		return myDPDet.getChargeAmount();
	}
	public Integer getInterestSerial() {
		return myDPDet.getInterestSerial();
	}
	public Integer getIssueId() {
		return myDPDet.getIssueId();
	}
	public Set<PaymentMain> getPaymentMains() {
		return myDPDet.getPaymentMains();
	}
	public Date getRepayDate() {
		return myDPDet.getRepayDate();
	}
	public void setCapitalSerial(Integer capitalSerial) {
		myDPDet.setCapitalSerial(capitalSerial);
	}
	public void setChargeAmount(BigDecimal chargeAmount) {
		myDPDet.setChargeAmount(chargeAmount);
	}
	public void setInterestSerial(Integer interestSerial) {
		myDPDet.setInterestSerial(interestSerial);
	}
	public void setIssueId(Integer issueId) {
		myDPDet.setIssueId(issueId);
	}
	public void setPaymentMains(Set<PaymentMain> paymentMains) {
		myDPDet.setPaymentMains(paymentMains);
	}
	public void setRepayDate(Date repayDate) {
		myDPDet.setRepayDate(repayDate);
	}
	public String getIsReturn() {
		return isReturn;
	}
	public void setIsReturn(String isReturn) {
		this.isReturn = isReturn;
	}
	public String[] getIscheck() {
		return ischeck;
	}
	public void setIscheck(String[] ischeck) {
		this.ischeck = ischeck;
	}
	public int[] getCountRow() {
		return countRow;
	}
	public void setCountRow(int[] countRow) {
		this.countRow = countRow;
	}
	public int[] getCapindex() {
		return capindex;
	}
	public void setCapindex(int[] capindex) {
		this.capindex = capindex;
	}
	public List getCaplist() {
		return caplist;
	}
	public void setCaplist(List caplist) {
		this.caplist = caplist;
	}
	public int[] getRateindex() {
		return rateindex;
	}
	public void setRateindex(int[] rateindex) {
		this.rateindex = rateindex;
	}
	public List getRatelist() {
		return ratelist;
	}
	public void setRatelist(List ratelist) {
		this.ratelist = ratelist;
	}
	public int getNowindex() {
		return nowindex;
	}
	public void setNowindex(int nowindex) {
		this.nowindex = nowindex;
	}
	public int getDebtId() {
		return debtId;
	}
	public void setDebtId(int debtId) {
		this.debtId = debtId;
	}
	public int getOklist() {
		return oklist;
	}
	public void setOklist(int oklist) {
		this.oklist = oklist;
	}
	public List getTypeList()
	{
        return new ListToolManager().getList("select codeDet.codeNo , codeDet.codeName from CodeDet codeDet where codeDet.kind.kindNo = 'YMD' order by codeDet.codeName ");
	}
	
	public List getIssueKindList()
	{
        Session session = new CodeDetDAO().getSession();
        Criteria tCodeDetCriteria = session.createCriteria(CodeDet.class);
        Criteria tCodeMainCriteria = tCodeDetCriteria.createCriteria("kind");
        tCodeMainCriteria.add(Restrictions.eq("kindNo", "CKP"));
        List myList = tCodeDetCriteria.list();
        session.close();
        return myList;
	}
	
	public List getBudgetList()
	{
		Session session = new BudgetRefDAO().getSession();
		Criteria criteria = session.createCriteria(BudgetRef.class);	
		List myList = criteria.list();
		session.close();
		return myList; 
		//return new BudgetRefDAO().findAll(); 
	}
	public List getDebtList()
	{
		 Session session = new DebitRefDAO().getSession();
	     Criteria criteria = session.createCriteria(DebitRef.class);
	     List myList = new LinkedList();
		if(null != getBudgetCode() && !"".equals(getBudgetCode()))	
		{	 
		     criteria.add(Expression.eq("budgetCode.id",getBudgetCode()));
	    	 myList = criteria.list();
		     session.close();
		     return myList; 
		}
		else if(null != getBudgetCodeDebt() && !"".equals(getBudgetCodeDebt()))
		{
		     criteria.add(Expression.eq("budgetCode.id",getBudgetCodeDebt()));
	    	 myList = criteria.list();
		     session.close();
		     return myList;
		}
		else if(null != getMyIssDet().getBudgetCode() && !"".equals(getMyIssDet().getBudgetCode()))
		{
		     criteria.add(Expression.eq("budgetCode.id",getMyIssDet().getBudgetCode()));
	    	 myList = criteria.list();
		     session.close();
		     return myList;
		}
		else
		{
			return null;
		}
		
	}
	public String getBudgetYear() {
		return myDMain.getBudgetYear();
	}
	public String getGet() {
		return myDMain.getGet();
	}
	public void setBudgetYear(String arg0) {
		myDMain.setBudgetYear(arg0);
	}
	public void setGet(String get) {
		myDMain.setGet(get);
	}
	
	public List<LabelValueBean>  getQryDebtNameList()
	{
		Session session = new IssueMainDAO().getSession();
		Query query = session.createQuery("select debtName from IssueMain where debtType = 'C' order by accountYear");
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
	public List getNewcaplist() {
		return newcaplist;
	}
	public void setNewcaplist(List newcaplist) {
		this.newcaplist = newcaplist;
	}
	public BigDecimal getNowAverageRate() {
		return nowAverageRate;
	}
	public void setNowAverageRate(BigDecimal nowAverageRate) {
		this.nowAverageRate = nowAverageRate;
	}
	public Date getContinueDate() {
		return myIss.getContinueDate();
	}
	public void setContinueDate(Date continueDate) {
		myIss.setContinueDate(continueDate);
	}
	public BigDecimal getSumCapitalAmountFuture() {
		return sumCapitalAmountFuture;
	}
	public void setSumCapitalAmountFuture(BigDecimal sumCapitalAmountFuture) {
		this.sumCapitalAmountFuture = sumCapitalAmountFuture;
	}
	public Date getOldDueDate() {
		return oldDueDate;
	}
	public void setOldDueDate(Date oldDueDate) {
		this.oldDueDate = oldDueDate;
	}
	public Date getOldIssueDate() {
		return oldIssueDate;
	}
	public void setOldIssueDate(Date oldIssueDate) {
		this.oldIssueDate = oldIssueDate;
	}
	public String getCompareFlag() {
		return myDMain.getCompareFlag();
	}
	public void setCompareFlag(String compareFlag) {
		myDMain.setCompareFlag(compareFlag);
	}
	public String getCheckGetMark() {
		return checkGetMark;
	}
	public void setCheckGetMark(String checkGetMark) {
		this.checkGetMark = checkGetMark;
	}
	public BigDecimal getCommitFirstRate() {
		return commitFirstRate;
	}
	public void setCommitFirstRate(BigDecimal commitFirstRate) {
		this.commitFirstRate = commitFirstRate;
	}
}
