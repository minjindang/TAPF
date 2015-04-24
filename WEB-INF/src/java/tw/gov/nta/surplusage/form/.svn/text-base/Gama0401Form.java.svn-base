package tw.gov.nta.surplusage.form;

import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import tw.gov.nta.sql.YearAmountRef;
import gov.dnt.tame.common.SupportForm;
import gov.dnt.tame.util.DateUtil;

public class Gama0401Form extends SupportForm {
	private static final long serialVersionUID = 1L;

	private String qryYear;
	private Integer qryBudgetCode;
	private Integer qryDebtCode;
	private Integer  qryDataType;
	private YearAmountRef yearAmountRef;

	public void reset(ActionMapping arg0, HttpServletRequest arg1) {
		super.reset(arg0, arg1);

		if( yearAmountRef==null )
		{
			yearAmountRef = new YearAmountRef();
			setAccountYear( DateUtil.date2ROCStr( new Date() ).substring(0,3) );
		}
	}
	
	public Integer getQryBudgetCode() {
		return qryBudgetCode;
	}
	public void setQryBudgetCode(Integer qryBudgetCode) {
		this.qryBudgetCode = qryBudgetCode;
	}
	public Integer getQryDebtCode() {
		return qryDebtCode;
	}
	public void setQryDebtCode(Integer qryDebtCode) {
		this.qryDebtCode = qryDebtCode;
	}
	public String getQryYear() {
		return qryYear;
	}
	public void setQryYear(String qryYear) {
		qryYear=qryYear.trim();
		if (qryYear.length() < 3 && !"".equals(qryYear)){
			for (int i = 0 ; i < 3-qryYear.length() ; i++){
				qryYear = "0" + qryYear;
			}	
		}
		this.qryYear = qryYear;
	}
	public String getAccountYear() {
		return yearAmountRef.getAccountYear();
	}
	public BigDecimal getAuditAmount() {
		return yearAmountRef.getAuditAmount();
	}
	public BigDecimal getAuditDamount() {
		return yearAmountRef.getAuditDamount();
	}
	public BigDecimal getAuditUamount() {
		return yearAmountRef.getAuditUamount();
	}
	public BigDecimal getBudgetAmount() {
		return yearAmountRef.getBudgetAmount();
	}
	public Integer getBudgetCode() {
		return yearAmountRef.getBudgetCode();
	}
	public BigDecimal getBudgetDamount() {
		return yearAmountRef.getBudgetDamount();
	}
	public BigDecimal getBudgetUamount() {
		return yearAmountRef.getBudgetUamount();
	}
	public Date getCreateDate() {
		return yearAmountRef.getCreateDate();
	}
	public Integer getDebtCode() {
		return yearAmountRef.getDebtCode();
	}
	public Integer getId() {
		return yearAmountRef.getId();
	}
	public BigDecimal getKeepAmount() {
		return yearAmountRef.getKeepAmount();
	}
	public BigDecimal getKeepDamount() {
		return yearAmountRef.getKeepDamount();
	}
	public BigDecimal getKeepUamount() {
		return yearAmountRef.getKeepUamount();
	}
	public BigDecimal getRealAmount() {
		return yearAmountRef.getRealAmount();
	}
	public BigDecimal getRealDamount() {
		return yearAmountRef.getRealDamount();
	}
	public BigDecimal getRealUamount() {
		return yearAmountRef.getRealUamount();
	}
	public String getRemark() {
		return yearAmountRef.getRemark();
	}
	public void setAccountYear(String accountYear) {
		yearAmountRef.setAccountYear(accountYear);
	}
	public void setAuditAmount(BigDecimal auditAmount) {
		yearAmountRef.setAuditAmount(auditAmount);
	}
	public void setAuditDamount(BigDecimal auditDamount) {
		yearAmountRef.setAuditDamount(auditDamount);
	}
	public void setAuditUamount(BigDecimal auditUamount) {
		yearAmountRef.setAuditUamount(auditUamount);
	}
	public void setBudgetAmount(BigDecimal budgetAmount) {
		yearAmountRef.setBudgetAmount(budgetAmount);
	}
	public void setBudgetCode(Integer budgetCode) {
		yearAmountRef.setBudgetCode(budgetCode);
	}
	public void setBudgetDamount(BigDecimal budgetDamount) {
		yearAmountRef.setBudgetDamount(budgetDamount);
	}
	public void setBudgetUamount(BigDecimal budgetUamount) {
		yearAmountRef.setBudgetUamount(budgetUamount);
	}
	public void setCreateDate(Date createDate) {
		yearAmountRef.setCreateDate(createDate);
	}
	public void setDebtCode(Integer debtCode) {
		yearAmountRef.setDebtCode(debtCode);
	}
	public void setId(Integer id) {
		yearAmountRef.setId(id);
	}
	public void setKeepAmount(BigDecimal keepAmount) {
		yearAmountRef.setKeepAmount(keepAmount);
	}
	public void setKeepDamount(BigDecimal keepDamount) {
		yearAmountRef.setKeepDamount(keepDamount);
	}
	public void setKeepUamount(BigDecimal keepUamount) {
		yearAmountRef.setKeepUamount(keepUamount);
	}
	public void setRealAmount(BigDecimal realAmount) {
		yearAmountRef.setRealAmount(realAmount);
	}
	public void setRealDamount(BigDecimal realDamount) {
		yearAmountRef.setRealDamount(realDamount);
	}
	public void setRealUamount(BigDecimal realUamount) {
		yearAmountRef.setRealUamount(realUamount);
	}
	public void setRemark(String remark) {
		yearAmountRef.setRemark(remark);
	}
	public YearAmountRef getYearAmountRef() {
		return yearAmountRef;
	}
	public void setYearAmountRef(YearAmountRef yearAmountRef) {
		this.yearAmountRef = yearAmountRef;
	}

	public boolean isAuditYn() {
		return yearAmountRef.isAuditYn();
	}

	public boolean isBudgetYn() {
		return yearAmountRef.isBudgetYn();
	}

	public boolean isKeepYn() {
		return yearAmountRef.isKeepYn();
	}

	public boolean isRealYn() {
		return yearAmountRef.isRealYn();
	}

	public void setAuditYn(boolean auditYn) {
		yearAmountRef.setAuditYn(auditYn);
	}

	public void setBudgetYn(boolean budgetYn) {
		yearAmountRef.setBudgetYn(budgetYn);
	}

	public void setKeepYn(boolean keepYn) {
		yearAmountRef.setKeepYn(keepYn);
	}

	public void setRealYn(boolean realYn) {
		yearAmountRef.setRealYn(realYn);
	}

	public Integer getDataType() {
		return yearAmountRef.getDataType();
	}

	public void setDataType(Integer dataType) {
		yearAmountRef.setDataType(dataType);
	}

	public Integer getQryDataType() {
		return qryDataType;
	}

	public void setQryDataType(Integer qryDataType) {
		this.qryDataType = qryDataType;
	}
	
}
