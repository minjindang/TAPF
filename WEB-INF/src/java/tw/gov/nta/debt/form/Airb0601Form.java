/* Airb0601Form.java 報表
程式目的：AIRB06
程式代號：AIRB06
程式日期：0950317
程式作者：icefire
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
*/
package tw.gov.nta.debt.form;

import gov.dnt.tame.common.SupportForm;

public class Airb0601Form extends SupportForm {
	private static final long serialVersionUID = 1L;
	private String repayDate ; //還本年度
	private Integer budgetCode ; //預算別
	private Integer debtCode ;
	public Integer getBudgetCode() {
		return budgetCode;
	}
	public void setBudgetCode(Integer budgetCode) {
		this.budgetCode = budgetCode;
	}
	public Integer getDebtCode() {
		return debtCode;
	}
	public void setDebtCode(Integer debtCode) {
		this.debtCode = debtCode;
	}
	public String getRepayDate() {
		return repayDate;
	}
	public void setRepayDate(String repayDate) {
		this.repayDate = repayDate;
	}
	
	
}
