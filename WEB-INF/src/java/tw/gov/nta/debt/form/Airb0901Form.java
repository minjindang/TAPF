/* Airb0901Form.java 報表
程式目的：AIRB09
程式代號：AIRB09
程式日期：0950317
程式作者：icefire
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
*/
package tw.gov.nta.debt.form;

import gov.dnt.tame.common.SupportForm;

public class Airb0901Form extends SupportForm {
	private static final long serialVersionUID = 1L;
	private String repaydate ; //還本到期年度
	private Integer budgetCode ; //預算別
	private Integer debtCode;
	private Integer issueId;
	private String kind;
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public Integer getIssueId() {
		return issueId;
	}
	public void setIssueId(Integer issueId) {
		this.issueId = issueId;
	}
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
	public String getRepaydate() {
		return repaydate;
	}
	public void setRepaydate(String repaydate) {
		this.repaydate = repaydate;
	}
	
}
