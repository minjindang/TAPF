/* Airb1001Form.java 報表
程式目的：AIRB10
程式代號：AIRB10
程式日期：0950317
程式作者：icefire
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
*/
package tw.gov.nta.debt.form;

import java.util.Date;

import gov.dnt.tame.common.SupportForm;


public class Airb1001Form extends SupportForm {
	private static final long serialVersionUID = 1L;
	private Date limitDate ; //截止日期
	private Integer budgetCode ; //預算別
	public Integer getBudgetCode() {
		return budgetCode;
	}
	public void setBudgetCode(Integer budgetCode) {
		this.budgetCode = budgetCode;
	}
	public Date getLimitDate() {
		return limitDate;
	}
	public void setLimitDate(Date limitDate) {
		this.limitDate = limitDate;
	}
}
