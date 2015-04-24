/* Airc0601Form.java 報表
程式目的：AIRC06
程式代號：AIRC06
程式日期：0950317
程式作者：icefire
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
*/
package tw.gov.nta.debt.form;

import java.util.List;

import gov.dnt.tame.common.SupportForm;
import gov.dnt.tame.util.ListToolManager;

public class Airc0601Form extends SupportForm {
	private static final long serialVersionUID = 1L;
		private String limitDate ; //年月
		private String issueSerial ; //債券代號
		
		public String getLimitDate() {
			return limitDate;
		}
		public void setLimitDate(String limitDate) {
			this.limitDate = limitDate;
		}
		public String getissueSerial() {
			return issueSerial;
		}
		public void setissueSerial(String issueSerial) {
			this.issueSerial = issueSerial;
		}
		public List getIssueSerialList()
		{
			return new ListToolManager().getList("select issueMain.issueSerial , issueMain.issueSerial from IssueMain issueMain where issueMain.bondKind = '4' and issueMain.debtType = 'A' ");	
		}
}
