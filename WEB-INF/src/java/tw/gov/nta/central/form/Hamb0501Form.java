/*
�{���ت��GHAMB05��r
�{���N���GHAMB05
�{������G0950220
�{���@�̡GFormBean Generator
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
*/
package tw.gov.nta.central.form;

import gov.dnt.tame.common.SupportForm;

import java.util.Date;

import tw.gov.nta.sql.MailContentRef;

public class Hamb0501Form extends SupportForm
{
	private static final long serialVersionUID = 1L;


	private MailContentRef mailContentRef = new MailContentRef();

	
	public MailContentRef getMailContentRef() {
		return mailContentRef;
	}


	public void setMailContentRef(MailContentRef mailContentRef) {
		this.mailContentRef = mailContentRef;
	}


	public String getContenta() {
		return mailContentRef.getContenta();
	}


	public String getContentb() {
		return mailContentRef.getContentb();
	}


	public Date getCreateDate() {
		return mailContentRef.getCreateDate();
	}


	public Integer getId() {
		return mailContentRef.getId();
	}


	public Date getModDate() {
		return mailContentRef.getModDate();
	}


	public String getMonKind() {
		return mailContentRef.getMonKind();
	}


	public String getRemark() {
		return mailContentRef.getRemark();
	}


	public String getTitlea() {
		return mailContentRef.getTitlea();
	}


	public String getTitleb() {
		return mailContentRef.getTitleb();
	}


	public String getUsrid() {
		return mailContentRef.getUsrid();
	}


	public void setContenta(String contenta) {
		mailContentRef.setContenta(contenta);
	}


	public void setContentb(String contentb) {
		mailContentRef.setContentb(contentb);
	}


	public void setCreateDate(Date createDate) {
		mailContentRef.setCreateDate(createDate);
	}


	public void setId(Integer id) {
		mailContentRef.setId(id);
	}


	public void setModDate(Date modDate) {
		mailContentRef.setModDate(modDate);
	}


	public void setMonKind(String monKind) {
		mailContentRef.setMonKind(monKind);
	}


	public void setRemark(String remark) {
		mailContentRef.setRemark(remark);
	}


	public void setTitlea(String titlea) {
		mailContentRef.setTitlea(titlea);
	}


	public void setTitleb(String titleb) {
		mailContentRef.setTitleb(titleb);
	}


	public void setUsrid(String usrid) {
		mailContentRef.setUsrid(usrid);
	}
	
}
    