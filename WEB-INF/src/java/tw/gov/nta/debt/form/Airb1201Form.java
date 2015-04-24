/* Airc1001Form.java 報表
程式目的：AIRC10
程式代號：AIRC10
程式日期：0950308
程式作者：Eric.Chen
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
*/
package tw.gov.nta.debt.form;

import gov.dnt.tame.common.SupportForm;

public class Airb1201Form extends SupportForm {
	private static final long serialVersionUID = 1L;

	private String issueSerial;	//債券代號
	private String limitDate;	//年月
	public String getIssueSerial() {
		return issueSerial;
	}
	public void setIssueSerial(String issueSerial) {
		this.issueSerial = issueSerial;
	}
	public String getLimitDate() {
		return limitDate;
	}
	public void setLimitDate(String limitDate) {
		this.limitDate = limitDate;
	}
	
	

}
