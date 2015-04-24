/*
 * �b 2006/2/27 �إ�
 *
 * TODO �p�G�n�ܧ�o�Ӳ��ͪ��ɮת��d���A�в���
 * ���� - �ߦn�]�w - Java - �{���X�˦� - �{���X�d��
 */
package tw.gov.nta.exchequer.form;

import gov.dnt.tame.common.SupportForm;

/**
 * @author Jack Du
 *
 * TODO �p�G�n�ܧ�o�Ӳ��ͪ����O���Ѫ��d���A�в���
 * ���� - �ߦn�]�w - Java - �{���X�˦� - �{���X�d��
 */
public class Bira0601Form extends SupportForm  {
	private static final long serialVersionUID = 1L;
	private String budgetCode;
	private String debtCode;
	private String accountSYear;
	private String accountEYear;

	/**
	 * @return �Ǧ^ budgetCode�C
	 */
	public String getBudgetCode() {
		return budgetCode;
	}
	/**
	 * @param budgetCode �n�]�w�� budgetCode�C
	 */
	public void setBudgetCode(String budgetCode) {
		this.budgetCode = budgetCode;
	}
	/**
	 * @return �Ǧ^ debtCode�C
	 */
	public String getDebtCode() {
		return debtCode;
	}
	/**
	 * @param debtCode �n�]�w�� debtCode�C
	 */
	public void setDebtCode(String debtCode) {
		this.debtCode = debtCode;
	}
	public String getAccountEYear() {
		return accountEYear;
	}
	public void setAccountEYear(String accountEYear) {
		accountEYear=accountEYear.trim();
		if (accountEYear.length() < 3 && !"".equals(accountEYear)){
			for (int i = 0 ; i < 3-accountEYear.length() ; i++){
				accountEYear = "0" + accountEYear;
			}	
		}
		this.accountEYear = accountEYear;
	}
	public String getAccountSYear() {
		return accountSYear;
	}
	public void setAccountSYear(String accountSYear) {
		accountSYear=accountSYear.trim();
		if (accountSYear.length() < 3 && !"".equals(accountSYear)){
			for (int i = 0 ; i < 3-accountSYear.length() ; i++){
				accountSYear = "0" + accountSYear;
			}	
		}
		this.accountSYear = accountSYear;
	}


}
