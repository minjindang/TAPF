/* Hamb0201Form.java
�{���ت��GHARB02��r
�{���N���GHARB02
�{������G0950222
�{���@�̡GEric.Chen
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
*/
package tw.gov.nta.central.form;

import gov.dnt.tame.common.SupportForm;

import java.math.BigDecimal;
import java.util.Date;

import tw.gov.nta.sql.TaxactionDet;

/**
 * @author EricChen
 *
 * TODO �p�G�n�ܧ�o�Ӳ��ͪ����O���Ѫ��d���A�в���
 * ���� - �ߦn�]�w - Java - �{���X�˦� - �{���X�d��
 */
public class Hamb0201Form extends SupportForm {
	private static final long serialVersionUID = 1L;
	TaxactionDet myDto = new TaxactionDet();
	

	public TaxactionDet getMyDto() {
		return myDto;
	}

	public void setMyDto(TaxactionDet myDto) {
		this.myDto = myDto;
	}

	public String getBankno() {
		return myDto.getBankno();
	}

	public Date getCreateDate() {
		return myDto.getCreateDate();
	}

	public Integer getId() {
		return myDto.getId();
	}

	public BigDecimal getIntTax() {
		return myDto.getIntTax();
	}

	public BigDecimal getLocalTax() {
		return myDto.getLocalTax();
	}

	public Date getModDate() {
		return myDto.getModDate();
	}

	public String getMonKind() {
		return myDto.getMonKind();
	}

	public String getMonNo() {
		return myDto.getMonNo();
	}

	public BigDecimal getNationTax() {
		return myDto.getNationTax();
	}

	public String getPname() {
		return myDto.getPname();
	}

	public String getRemark() {
		return myDto.getRemark();
	}

	public String getTaxKind() {
		return myDto.getTaxKind();
	}

	public String getTaxMonth() {
		return myDto.getTaxMonth();
	}

	public String getTaxYear() {
		return myDto.getTaxYear();
	}

	public String getUsrid() {
		return myDto.getUsrid();
	}

	public void setBankno(String bankno) {
		myDto.setBankno(bankno);
	}

	public void setCreateDate(Date createDate) {
		myDto.setCreateDate(createDate);
	}

	public void setId(Integer id) {
		myDto.setId(id);
	}

	public void setIntTax(BigDecimal intTax) {
		myDto.setIntTax(intTax);
	}

	public void setLocalTax(BigDecimal localTax) {
		myDto.setLocalTax(localTax);
	}

	public void setModDate(Date modDate) {
		myDto.setModDate(modDate);
	}

	public void setMonKind(String monKind) {
		myDto.setMonKind(monKind);
	}

	public void setMonNo(String monNo) {
		myDto.setMonNo(monNo);
	}

	public void setNationTax(BigDecimal nationTax) {
		myDto.setNationTax(nationTax);
	}

	public void setPname(String pname) {
		myDto.setPname(pname);
	}

	public void setRemark(String remark) {
		myDto.setRemark(remark);
	}

	public void setTaxKind(String taxKind) {
		myDto.setTaxKind(taxKind);
	}

	public void setTaxMonth(String taxMonth) {
		myDto.setTaxMonth(taxMonth);
	}

	public void setTaxYear(String taxYear) {
		myDto.setTaxYear(taxYear);
	}

	public void setUsrid(String usrid) {
		myDto.setUsrid(usrid);
	}

	public String toString() {
		return myDto.toString();
	}
	
	
	
	
}
