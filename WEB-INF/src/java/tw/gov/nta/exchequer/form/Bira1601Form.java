/*
 * �b 2006/2/27 �إ�
 *
 * TODO �p�G�n�ܧ�o�Ӳ��ͪ��ɮת��d���A�в���
 * ���� - �ߦn�]�w - Java - �{���X�˦� - �{���X�d��
 */
package tw.gov.nta.exchequer.form;

import gov.dnt.tame.common.SupportForm;

import java.util.Date;

/**
 * @author Jack Du
 *
 * TODO �p�G�n�ܧ�o�Ӳ��ͪ����O���Ѫ��d���A�в���
 * ���� - �ߦn�]�w - Java - �{���X�˦� - �{���X�d��
 */
public class Bira1601Form extends SupportForm  {
	private static final long serialVersionUID = 1L;
	private String amountUnit;
	private Date issueSdate;
	private Date issueEdate;
	private String accountSYear;
	private String accountEYear;
	
	public String getAmountUnit() {
		return amountUnit;
	}
	public void setAmountUnit(String amountUnit) {
		this.amountUnit = amountUnit;
	}
	/**
	 * @return �Ǧ^ issueEdate�C
	 */
	public Date getIssueEdate() {
		return issueEdate;
	}
	/**
	 * @param issueEdate �n�]�w�� issueEdate�C
	 */
	public void setIssueEdate(Date issueEdate) {
		this.issueEdate = issueEdate;
	}
	/**
	 * @return �Ǧ^ issueSdate�C
	 */
	public Date getIssueSdate() {
		return issueSdate;
	}
	/**
	 * @param issueSdate �n�]�w�� issueSdate�C
	 */
	public void setIssueSdate(Date issueSdate) {
		this.issueSdate = issueSdate;
	}
	public String getAccountEYear() {
		return accountEYear;
	}
	public void setAccountEYear(String accountEYear) {
		this.accountEYear = accountEYear;
	}
	public String getAccountSYear() {
		return accountSYear;
	}
	public void setAccountSYear(String accountSYear) {
		this.accountSYear = accountSYear;
	}
}
