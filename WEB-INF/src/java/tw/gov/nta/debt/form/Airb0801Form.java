/* Airb0801Form.java 報表
程式目的：AIRB08
程式代號：AIRB08
程式日期：0950317
程式作者：icefire
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
*/
package tw.gov.nta.debt.form;

import gov.dnt.tame.common.SupportForm;

public class Airb0801Form extends SupportForm {
	private static final long serialVersionUID = 1L;
		private String repaydate ; //還本到期年度
		private Integer budgetCode ; //預算別
		private Integer debtCode;
		private String kind;
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
		public String getKind() {
			return kind;
		}
		public void setKind(String kind) {
			this.kind = kind;
		}
		
}
