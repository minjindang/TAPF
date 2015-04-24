/* Airb0201Form.java ����
�{���ت��GAIRB02
�{���N���GAIRB02
�{������G0950317
�{���@�̡Gicefire
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
*/
package tw.gov.nta.debt.form;

import java.util.Date;

import gov.dnt.tame.common.SupportForm;

public class Airb0201Form extends SupportForm {
	private static final long serialVersionUID = 1L;
		private String repay_SDate ; //�٥��~�װ_
		private String repay_EDate ; //�٥��~�ר�
		private Date issue_SDate ; //�o�����_
		private Date issue_EDate ; //�o������
		private String budgetCode;
		private String debtCode;
		private String bondSellStatus ;
		public String getBudgetCode() {
			return budgetCode;
		}
		public void setBudgetCode(String budgetCode) {
			this.budgetCode = budgetCode;
		}
		public String getDebtCode() {
			return debtCode;
		}
		public void setDebtCode(String debtCode) {
			this.debtCode = debtCode;
		}
		public Date getIssue_EDate() {
			return issue_EDate;
		}
		public void setIssue_EDate(Date issue_EDate) {
			this.issue_EDate = issue_EDate;
		}
		public Date getIssue_SDate() {
			return issue_SDate;
		}
		public void setIssue_SDate(Date issue_SDate) {
			this.issue_SDate = issue_SDate;
		}
		public String getRepay_EDate() {
			return repay_EDate;
		}
		public void setRepay_EDate(String repay_EDate) {
			this.repay_EDate = repay_EDate;
		}
		public String getRepay_SDate() {
			return repay_SDate;
		}
		public void setRepay_SDate(String repay_SDate) {
			this.repay_SDate = repay_SDate;
		}
		public String getBondSellStatus() {
			return bondSellStatus;
		}
		public void setBondSellStatus(String bondSellStatus) {
			this.bondSellStatus = bondSellStatus;
		}
		
		
}

