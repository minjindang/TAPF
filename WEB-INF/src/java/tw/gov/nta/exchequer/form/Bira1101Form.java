/*
 * �b 2006/5/26 �إ�
 *
 * TODO �p�G�n�ܧ�o�Ӳ��ͪ��ɮת��d���A�в���
 * ���� - �ߦn�]�w - Java - �{���X�˦� - �{���X�d��
 */
package tw.gov.nta.exchequer.form;

import gov.dnt.tame.common.SupportForm;
//import java.math.BigDecimal;
//import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

/**
 * @author Avery
 *
 * TODO �p�G�n�ܧ�o�Ӳ��ͪ����O���Ѫ��d���A�в���
 * ���� - �ߦn�]�w - Java - �{���X�˦� - �{���X�d��
 */
public class Bira1101Form extends SupportForm  {
	private static final long serialVersionUID = 1L;
//	private BigDecimal accountRate;
	private String issueId;
//	private Date repayDate;
//	private BigDecimal departRate;

	
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
//		super.reset(mapping, request);
//		setDepartRate(new BigDecimal(20));
	}
	public String getIssueId() {
		return issueId;
	}
	public void setIssueId(String issueId) {
		this.issueId = issueId;
	}
//	public Date getRepayDate() {
//		return repayDate;
//	}
//	public void setRepayDate(Date repayDate) {
//		this.repayDate = repayDate;
//	}
//	public BigDecimal getAccountRate() {
//		return accountRate;
//	}
//	public void setAccountRate(BigDecimal accountRate) {
//		this.accountRate = accountRate;
//	}
//	public BigDecimal getDepartRate() {
//		return departRate;
//	}
//	public void setDepartRate(BigDecimal departRate) {
//		this.departRate = departRate;
//	}
}
