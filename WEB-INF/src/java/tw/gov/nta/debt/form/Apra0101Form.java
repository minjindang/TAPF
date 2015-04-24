/* Apra0101Form.java 報表
程式目的：APRA01
程式代號：APRA01
程式日期：0950309
程式作者：Eric.Chen
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
*/
package tw.gov.nta.debt.form;

import java.util.Date;

import gov.dnt.tame.common.SupportForm;

public class Apra0101Form extends SupportForm {
	private static final long serialVersionUID = 1L;
		private Date repaySdate ; //還本付息日期起 開始
		private Date repayEdate ; //還本付息日期起 結束
		private String budgetCode ; //預算別
		private String debtCode; //債務別
		private String reportType;
		private String bondType; //甲類或乙累 
		private String display;
		
		public String getDisplay() {
			return display;
		}
		public void setDisplay(String display) {
			this.display = display;
		}
		public String getReportType() {
			return reportType;
		}
		public void setReportType(String reportType) {
			this.reportType = reportType;
		}
		public String getBudgetCode() {
			return budgetCode;
		}
		public void setBudgetCode(String budgetCode) {
			this.budgetCode = budgetCode;
		}
		public Date getRepayEdate() {
			return repayEdate;
		}
		public void setRepayEdate(Date repayEdate) {
			this.repayEdate = repayEdate;
		}
		public Date getRepaySdate() {
			return repaySdate;
		}
		public void setRepaySdate(Date repaySdate) {
			this.repaySdate = repaySdate;
		}
		public String getDebtCode() {
			return debtCode;
		}
		public void setDebtCode(String debtCode) {
			this.debtCode = debtCode;
		}
		public String getBondType() {
			return bondType;
		}
		public void setBondType(String bondType) {
			this.bondType = bondType;
		}
		
}
