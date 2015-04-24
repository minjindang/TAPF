/*
程式目的：HAMA02文字
程式代號：HAMA02
程式日期：0950221
程式作者：FormBean Generator
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
*/
package tw.gov.nta.central.form;

import gov.dnt.tame.common.SupportForm;

import java.math.BigDecimal;
import java.util.Date;

import tw.gov.nta.sql.LawPercentRef;

public class Hama0201Form extends SupportForm{
	private static final long serialVersionUID = 1L;

	private LawPercentRef lawPercentRef = new LawPercentRef();

	public LawPercentRef getLawPercentRef() {
		return lawPercentRef;
	}

	public void setLawPercentRef(LawPercentRef lawPercentRef) {
		this.lawPercentRef = lawPercentRef;
	}

	public int compareTo(Object obj) {
		return lawPercentRef.compareTo(obj);
	}

	public boolean equals(Object obj) {
		return lawPercentRef.equals(obj);
	}

	public Date getCreateDate() {
		return lawPercentRef.getCreateDate();
	}

	public Integer getId() {
		return lawPercentRef.getId();
	}

	public BigDecimal getInta() {
		return lawPercentRef.getInta().setScale(2);
	}

	public BigDecimal getIntb() {
		return lawPercentRef.getIntb().setScale(2);
	}

	public BigDecimal getIntc() {
		return lawPercentRef.getIntc().setScale(2);
	}

	public BigDecimal getLocala() {
		return lawPercentRef.getLocala().setScale(2);
	}

	public BigDecimal getLocalb() {
		return lawPercentRef.getLocalb().setScale(2);
	}

	public BigDecimal getLocalc() {
		return lawPercentRef.getLocalc().setScale(2);
	}

	public Date getModDate() {
		return lawPercentRef.getModDate();
	}

	public BigDecimal getNationa() {
		return lawPercentRef.getNationa().setScale(2);
	}

	public BigDecimal getNationb() {
		return lawPercentRef.getNationb().setScale(2);
	}

	public BigDecimal getNationc() {
		return lawPercentRef.getNationc().setScale(2);
	}

	public String getRemark() {
		return lawPercentRef.getRemark();
	}

	public String getUsrid() {
		return lawPercentRef.getUsrid();
	}

	public int hashCode() {
		return lawPercentRef.hashCode();
	}

	public void setCreateDate(Date createDate) {
		lawPercentRef.setCreateDate(createDate);
	}

	public void setId(Integer id) {
		lawPercentRef.setId(id);
	}

	public void setInta(BigDecimal inta) {
		lawPercentRef.setInta(inta);
	}

	public void setIntb(BigDecimal intb) {
		lawPercentRef.setIntb(intb);
	}

	public void setIntc(BigDecimal intc) {
		lawPercentRef.setIntc(intc);
	}

	public void setLocala(BigDecimal locala) {
		lawPercentRef.setLocala(locala);
	}

	public void setLocalb(BigDecimal localb) {
		lawPercentRef.setLocalb(localb);
	}

	public void setLocalc(BigDecimal localc) {
		lawPercentRef.setLocalc(localc);
	}

	public void setModDate(Date modDate) {
		lawPercentRef.setModDate(modDate);
	}

	public void setNationa(BigDecimal nationa) {
		lawPercentRef.setNationa(nationa);
	}

	public void setNationb(BigDecimal nationb) {
		lawPercentRef.setNationb(nationb);
	}

	public void setNationc(BigDecimal nationc) {
		lawPercentRef.setNationc(nationc);
	}

	public void setRemark(String remark) {
		lawPercentRef.setRemark(remark);
	}

	public void setUsrid(String usrid) {
		lawPercentRef.setUsrid(usrid);
	}

	public String toString() {
		return lawPercentRef.toString();
	}

}