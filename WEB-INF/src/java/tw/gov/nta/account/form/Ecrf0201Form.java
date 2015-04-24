package tw.gov.nta.account.form;

import java.util.Date;

import gov.dnt.tame.common.SupportForm;

public class Ecrf0201Form extends SupportForm {
	private static final long serialVersionUID = 1L;
	private Integer qryBudgetCode = null;
	private Integer qryDebtCode = null;
	private Integer qryType = null;
	private Date qryDate = null;

	public void clear(){
		qryDate = null;
		qryDebtCode = null;
		qryBudgetCode = null;
		qryType = null;
	}

	public Integer getQryBudgetCode() {
		return qryBudgetCode;
	}

	public void setQryBudgetCode(Integer qryBudgetCode) {
		this.qryBudgetCode = qryBudgetCode;
	}

	public Date getQryDate() {
		return qryDate;
	}

	public void setQryDate(Date qryDate) {
		this.qryDate = qryDate;
	}

	public Integer getQryDebtCode() {
		return qryDebtCode;
	}

	public void setQryDebtCode(Integer qryDebtCode) {
		this.qryDebtCode = qryDebtCode;
	}

	public Integer getQryType() {
		return qryType;
	}

	public void setQryType(Integer qryType) {
		this.qryType = qryType;
	}

}
