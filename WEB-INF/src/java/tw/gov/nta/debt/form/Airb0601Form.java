/* Airb0601Form.java ����
�{���ت��GAIRB06
�{���N���GAIRB06
�{������G0950317
�{���@�̡Gicefire
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
*/
package tw.gov.nta.debt.form;

import gov.dnt.tame.common.SupportForm;

public class Airb0601Form extends SupportForm {
	private static final long serialVersionUID = 1L;
	private String repayDate ; //�٥��~��
	private Integer budgetCode ; //�w��O
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
