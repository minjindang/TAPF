/*
 程式目的：HAMA05文字
 程式代號：HAMA05
 程式日期：1000914
 程式作者：Powen Hsueh
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
 --------------------------------------------------------
 */
package tw.gov.nta.central.form;

import gov.dnt.tame.common.SupportForm;
import java.math.BigDecimal;
import java.util.Date;
import tw.gov.nta.sql.LawPercentRef101;

public class Hama0501Form extends SupportForm {
	private static final long serialVersionUID = 1L;

	private LawPercentRef101 LawPercentRef101 = new LawPercentRef101();

	public LawPercentRef101 getLawPercentRef101() {
		return LawPercentRef101;
	}

	public void setLawPercentRef(LawPercentRef101 lawPercentRef101) {
		this.LawPercentRef101 = lawPercentRef101;
	}

	public int compareTo(Object obj) {
		return LawPercentRef101.compareTo(obj);
	}

	public boolean equals(Object obj) {
		return LawPercentRef101.equals(obj);
	}

	public Integer getId() {
		return LawPercentRef101.getId();
	}

	public BigDecimal getInterest() {
		return LawPercentRef101.getInterest().setScale(2);
	}

	public Date getModDate() {
		return LawPercentRef101.getModDate();
	}

	public BigDecimal getNation() {
		return LawPercentRef101.getNation().setScale(2);
	}

	public String getRemark() {
		return LawPercentRef101.getRemark();
	}

	public String getUsrid() {
		return LawPercentRef101.getUsrid();
	}

	public int hashCode() {
		return LawPercentRef101.hashCode();
	}

	public void setId(Integer id) {
		LawPercentRef101.setId(id);
	}

	public void setModDate(Date modDate) {
		LawPercentRef101.setModDate(modDate);
	}

	public void setNation(BigDecimal nationa) {
		LawPercentRef101.setNation(nationa);
	}

	public void setInterest(BigDecimal interest) {
		LawPercentRef101.setInterest(interest);
	}

	public void setRemark(String remark) {
		LawPercentRef101.setRemark(remark);
	}

	public void setUsrid(String usrid) {
		LawPercentRef101.setUsrid(usrid);
	}

	public String toString() {
		return LawPercentRef101.toString();
	}
}
