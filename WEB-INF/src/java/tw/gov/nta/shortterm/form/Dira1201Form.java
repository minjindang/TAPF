/* Dira1201Form.java ����
�{���ت��GDIRA12
�{���N���GDIRA12
�{������G0950317
�{���@�̡Gicefire
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
*/
package tw.gov.nta.shortterm.form;

import java.util.Date;

import gov.dnt.tame.common.SupportForm;

public class Dira1201Form extends SupportForm {
	private static final long serialVersionUID = 1L;
	private String accountYear ; //�~��
	private Date baseDate ; //�p���Ǥ�
	public String getAccountYear()
	{
		return accountYear;
	}
	public void setAccountYear(String accountYear)
	{
		this.accountYear = accountYear;
	}
	public Date getBaseDate()
	{
		return baseDate;
	}
	public void setBaseDate(Date baseDate)
	{
		this.baseDate = baseDate;
	}
	
}
