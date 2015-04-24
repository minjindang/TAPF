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
			bondName = "�����F������ " + Integer.parseInt(bondID.substring(1,3)) + " �~������ " + Integer.parseInt(bondID.substring(4,6)) + " ��";
			break;
		case 2:
			bondName = "�����F������ " + Integer.parseInt(bondID.substring(1,3)) + " �~�A���� " + Integer.parseInt(bondID.substring(4,6)) + " ��";
			break;
		case 3:
			bondName = "�����F������ " + Integer.parseInt(bondID.substring(1,3)) + " �~���j��q�س]������" + Integer.parseInt(bondID.substring(4,6)) + " ��";
			break;
		case 4:
			bondName = "�����F������ " + Integer.parseInt(bondID.substring(1,3)) + " �~���j��q�س]�A����" + Integer.parseInt(bondID.substring(4,6)) + " ��";
			break;
		}
		return bondName;
	}
}
