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

import java.util.Date;

public class Airb1101Form extends SupportForm {
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
	
	

}
