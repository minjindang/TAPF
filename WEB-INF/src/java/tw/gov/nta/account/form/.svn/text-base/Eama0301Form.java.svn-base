package tw.gov.nta.account.form;

import gov.dnt.tame.common.SupportForm;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import tw.gov.nta.sql.dao.BudgetRefDAO;
import tw.gov.nta.sql.dao.DebitRefDAO;
import tw.gov.nta.sql.debt.BankRef;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.DebtPlanDet;
import tw.gov.nta.sql.debt.DebtRateDet;
import tw.gov.nta.sql.debt.InterestAdjustMain;
import tw.gov.nta.sql.debt.IssueMain;

public class Eama0301Form extends SupportForm {
	private static final long serialVersionUID = 1L;

	private DebtMain debtMain = new DebtMain();
	private BudgetRefDAO budgetDao = BudgetRefDAO.getInstance();
	private DebitRefDAO debtDao = DebitRefDAO.getInstance();
	


	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#getBondType()
	 */
	public String getBondType() {
		if ("2".equals(getIssue().getBondType()))
			return "乙類";
		else if ("1".equals(getIssue().getBondType()))
			return "甲類"; 
		return getIssue().getBondType();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#getIssueKind()
	 */
	public String getIssueKind() {
		if ("1".equals(getIssue().getIssueKind()))
			return "債票";
		else
			return "登錄";
	}

	
	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseIssueMain#getIssueKind()
	 */
	public String getBondKind() {
		String bondKind = getIssue().getBondKind();
		if ("1".equals(bondKind))
			return "原始";
		else if ("3".equals(bondKind))
			return "增額";
		else if ("2".equals(bondKind))
			return "分割";
		else if ("4".equals(bondKind))
			return "交換";
		
		return getIssue().getIssueKind();

	}
	
	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseDebtMain#getAccrue()
	 */
	public String getAccrue() {
		return debtMain.getAccrue();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseDebtMain#getAccrueDate()
	 */
	public Date getAccrueDate() {
		return debtMain.getAccrueDate();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseDebtMain#getBank()
	 */
	public BankRef getBank() {
		return debtMain.getBank();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseDebtMain#getBudgetCode()
	 */
	public String getBudgetCode() {
		int budgetRefId = debtMain.getBudgetCode();
		if (budgetRefId !=0)
			return budgetDao.get(budgetRefId).getBudgetName();
		else
			return "";
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseDebtMain#getBudgetYear()
	 */
	public String getBudgetYear() {
		return debtMain.getBudgetYear();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseDebtMain#getCompareAmount()
	 */
	public BigDecimal getCompareAmount() {
		return debtMain.getCompareAmount();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseDebtMain#getCompareRate()
	 */
	public BigDecimal getCompareRate() {
		return debtMain.getCompareRate();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseDebtMain#getDebtCode()
	 */
	public String getDebtCode() {
		int debtRefId = debtMain.getDebtCode();
		if (debtRefId !=0)
			return debtDao.get(debtRefId).getDebitName();
		else
			return "";
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseDebtMain#getDebtPlanDets()
	 */
	public Set<DebtPlanDet> getDebtPlanDets() {
		return debtMain.getDebtPlanDets();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseDebtMain#getDebtRateDets()
	 */
	public Set<DebtRateDet> getDebtRateDets() {
		return debtMain.getDebtRateDets();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseDebtMain#getDiversityAmount()
	 */
	public BigDecimal getDiversityAmount() {
		return debtMain.getDiversityAmount();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseDebtMain#getFallAmount()
	 */
	public BigDecimal getFallAmount() {
		return debtMain.getFallAmount();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseDebtMain#getGet()
	 */
	public String getGet() {
		return debtMain.getGet();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseDebtMain#getId()
	 */
	public Integer getId() {
		return debtMain.getId();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseDebtMain#getInterestAdjustMains()
	 */
	public Set<InterestAdjustMain> getInterestAdjustMains() {
		return debtMain.getInterestAdjustMains();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseDebtMain#getInterestDate()
	 */
	public Date getInterestDate() {
		return debtMain.getInterestDate();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseDebtMain#getIssue()
	 */
	public IssueMain getIssue() {
		return debtMain.getIssue();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseDebtMain#getIssueAmount()
	 */
	public BigDecimal getIssueAmount() {
		return debtMain.getIssueAmount();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseDebtMain#getModDate()
	 */
	public Date getModDate() {
		return debtMain.getModDate();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseDebtMain#getOriginInterestAmount()
	 */
	public BigDecimal getOriginInterestAmount() {
		return debtMain.getOriginInterestAmount();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseDebtMain#getPayableInterestAmount()
	 */
	public BigDecimal getPayableInterestAmount() {
		return debtMain.getPayableInterestAmount();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseDebtMain#getRealAmount()
	 */
	public BigDecimal getRealAmount() {
		return debtMain.getRealAmount();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseDebtMain#getRemark()
	 */
	public String getRemark() {
		return debtMain.getRemark();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseDebtMain#getUserid()
	 */
	public String getUserid() {
		return debtMain.getUserid();
	}

	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseDebtMain#setId(java.lang.Integer)
	 */
	public void setId(Integer id) {
		debtMain.setId(id);
	}

	/**
	 * @return Returns the debtMain.
	 */
	public DebtMain getDebtMain() {
		return debtMain;
	}

	/**
	 * @param debtMain The debtMain to set.
	 */
	public void setDebtMain(DebtMain debtMain) {
		this.debtMain = debtMain;
	}


	/* (non-Javadoc)
	 * @see tw.gov.nta.sql.debt.base.BaseDebtMain#getDebtSerial()
	 */
	public String getDebtSerial() {
		return debtMain.getDebtSerial();
	}





}
