/* Airc0901Form.java ����
�{���ت��GAIRC09
�{���N���GAIRC09
�{������G0950308
�{���@�̡GEric.Chen
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
*/
package tw.gov.nta.debt.form;

import gov.dnt.tame.common.SupportForm;
import gov.dnt.tame.util.ListToolManager;

import java.util.Date;
import java.util.List;

public class Airc0901Form extends SupportForm {
	private static final long serialVersionUID = 1L;

	private String issueSerial;	//�Ũ�N��
	private Date limitDate;	//�~��
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
