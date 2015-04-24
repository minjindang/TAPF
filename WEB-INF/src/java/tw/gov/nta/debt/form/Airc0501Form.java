/* Airc0501Form.java ����
�{���ت��GAIRC05
�{���N���GAIRC05
�{������G0950317
�{���@�̡Gicefire
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
*/
package tw.gov.nta.debt.form;

import java.util.Date;
import java.util.List;

import gov.dnt.tame.common.SupportForm;
import gov.dnt.tame.util.ListToolManager;

public class Airc0501Form extends SupportForm {
	private static final long serialVersionUID = 1L;
		private Date limitDate ; //���e��^ ���^��Ǥ�
		private String issueSerial ; //�洫���ťN��
		
		public Date getLimitDate() {
			return limitDate;
		}
		public void setLimitDate(Date limitDate) {
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

