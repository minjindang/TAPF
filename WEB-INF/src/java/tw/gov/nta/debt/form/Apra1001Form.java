package tw.gov.nta.debt.form;

import gov.dnt.tame.common.LabelValueBean;
import gov.dnt.tame.common.SupportForm;

import java.util.Date;
import java.util.List;

public class Apra1001Form extends SupportForm {
	private static final long serialVersionUID = 1L;

	public Apra1001Form() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String debtName;
	private Integer debtId;
	private Date closeDate;
	private String bankName;
	private Integer bankId;
	private String closeYear;
	private List<LabelValueBean> debtNameList;
	public List<LabelValueBean> getDebtNameList() {
		return debtNameList;
	}
	public void setDebtNameList(List<LabelValueBean> debtNameList) {
		this.debtNameList = debtNameList;
	}
	public String getCloseYear() {
		return closeYear;
	}
	public void setCloseYear(String closeYear) {
		this.closeYear = closeYear;
	}
	public Date getCloseDate() {
		return closeDate;
	}
	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}
	public String getDebtName() {
		return debtName;
	}
	public void setDebtName(String debtName) {
		this.debtName = debtName;
	}
	public Integer getBankId() {
		return bankId;
	}
	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public Integer getDebtId() {
		return debtId;
	}
	public void setDebtId(Integer debtId) {
		this.debtId = debtId;
	}
	public String getPaidaName()
	{	
		String bondID = this.getDebtName();
		String bondName = "";
		switch (Integer.parseInt(bondID.substring(3,4))){
		case 1:
			bondName = "中央政府公債 " + Integer.parseInt(bondID.substring(1,3)) + " 年甲類第 " + Integer.parseInt(bondID.substring(4,6)) + " 期";
			break;
		case 2:
			bondName = "中央政府公債 " + Integer.parseInt(bondID.substring(1,3)) + " 年乙類第 " + Integer.parseInt(bondID.substring(4,6)) + " 期";
			break;
		case 3:
			bondName = "中央政府公債 " + Integer.parseInt(bondID.substring(1,3)) + " 年重大交通建設甲類第" + Integer.parseInt(bondID.substring(4,6)) + " 期";
			break;
		case 4:
			bondName = "中央政府公債 " + Integer.parseInt(bondID.substring(1,3)) + " 年重大交通建設乙類第" + Integer.parseInt(bondID.substring(4,6)) + " 期";
			break;
		}
		return bondName;
	}
}
