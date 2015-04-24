/* Airc0901Form.java 報表
程式目的：AIRC09
程式代號：AIRC09
程式日期：0950308
程式作者：Eric.Chen
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
*/
package tw.gov.nta.debt.form;

import gov.dnt.tame.common.SupportForm;
import gov.dnt.tame.util.ListToolManager;

import java.util.Date;
import java.util.List;

public class Airc0901Form extends SupportForm {
	private static final long serialVersionUID = 1L;

	private String issueSerial;	//債券代號
	private Date limitDate;	//年月
	public String getIssueSerial() {
		return issueSerial;
	}
	public void setIssueSerial(String issueSerial) {
		this.issueSerial = issueSerial;
	}
	public Date getLimitDate() {
		return limitDate;
	}
	public void setLimitDate(Date limitDate) {
		this.limitDate = limitDate;
	}
	
	public List getIssueSerialList()
	{
		return new ListToolManager().getList("select issueMain.issueSerial , issueMain.issueSerial from IssueMain issueMain where issueMain.bondKind = '4' and issueMain.debtType = 'A' ");
	}

}
