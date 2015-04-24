/* Airc0601Form.java ����
�{���ت��GAIRC06
�{���N���GAIRC06
�{������G0950317
�{���@�̡Gicefire
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
*/
package tw.gov.nta.debt.form;

import java.util.List;

import gov.dnt.tame.common.SupportForm;
import gov.dnt.tame.util.ListToolManager;

public class Airc0601Form extends SupportForm {
	private static final long serialVersionUID = 1L;
		private String limitDate ; //�~��
		private String issueSerial ; //�Ũ�N��
		
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
