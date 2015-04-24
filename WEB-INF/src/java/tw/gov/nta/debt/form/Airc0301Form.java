/* Airc0301Form.java 報表
程式目的：AIRC03
程式代號：AIRC03
程式日期：0950317
程式作者：icefire
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
*/
package tw.gov.nta.debt.form;

import java.util.Date;
import java.util.List;

import gov.dnt.tame.common.SupportForm;
import gov.dnt.tame.util.ListToolManager;

public class Airc0301Form extends SupportForm {
	private static final long serialVersionUID = 1L;
		private Date limitDate ; //截止日期
		private String issueSerial ; //交換公債代號
		private Integer issueId;
		
		public Integer getIssueId() {
			return issueId;
		}
		public void setIssueId(Integer issueId) {
			this.issueId = issueId;
		}
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
			return new ListToolManager().getList("select issueMain.id , issueMain.issueSerial from IssueMain issueMain where issueMain.bondKind = '4' and issueMain.debtType = 'A' ");
		}
}
