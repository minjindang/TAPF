/* Airb0901Form.java ����
�{���ت��GAIRB09
�{���N���GAIRB09
�{������G0950317
�{���@�̡Gicefire
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
*/
package tw.gov.nta.debt.form;

import gov.dnt.tame.common.SupportForm;

public class Airb0901Form extends SupportForm {
	private static final long serialVersionUID = 1L;
	private String repaydate ; //�٥�����~��
	private Integer budgetCode ; //�w��O
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
