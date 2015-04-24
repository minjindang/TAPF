/* Airc0801Form.java 報表
程式目的：AIRC08
程式代號：AIRC08
程式日期：0950308
程式作者：Eric.Chen
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
*/
package tw.gov.nta.debt.form;

import java.util.List;

import gov.dnt.tame.common.SupportForm;
import gov.dnt.tame.util.ListToolManager;

public class Airc0801Form extends SupportForm {
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
	public List getIssueSerialList()
	{
		return new ListToolManager().getList("select issueMain.issueSerial , issueMain.issueSerial from IssueMain issueMain where issueMain.bondKind = '4' and issueMain.debtType = 'A' ");
	}
	
	

}
