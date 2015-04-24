package tw.gov.nta.debt.form;

import gov.dnt.tame.common.LabelValueBean;
import gov.dnt.tame.common.SupportForm;

import java.util.Date;
import java.util.List;

public class Apra0901Form extends SupportForm {

	private static final long serialVersionUID = 1L;
	private String debtName;
	private Date closeDate;
	private List<LabelValueBean> debtNameList;
	public List<LabelValueBean> getDebtNameList() {
		return debtNameList;
	}
	public void setDebtNameList(List<LabelValueBean> debtNameList) {
		this.debtNameList = debtNameList;
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
