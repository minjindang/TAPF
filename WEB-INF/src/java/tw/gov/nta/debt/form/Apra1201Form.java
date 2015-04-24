package tw.gov.nta.debt.form;

import gov.dnt.tame.common.LabelValueBean;
import gov.dnt.tame.common.SupportForm;

import java.util.Date;
import java.util.List;

public class Apra1201Form extends SupportForm {

	private static final long serialVersionUID = 1L;
	private String debtName;
	private Date closeSdate;
	private Date closeEdate;
	private List<LabelValueBean> debtNameList;

	
	public List<LabelValueBean> getDebtNameList() {
		return debtNameList;
	}
	public void setDebtNameList(List<LabelValueBean> debtNameList) {
		this.debtNameList = debtNameList;
	}
	public String getDebtName() {
		return debtName;
	}
	public void setDebtName(String debtName) {
		this.debtName = debtName;
	}
	public Date getCloseEdate() {
		return closeEdate;
	}
	public void setCloseEdate(Date closeEdate) {
		this.closeEdate = closeEdate;
	}
	public Date getCloseSdate() {
		return closeSdate;
	}
	public void setCloseSdate(Date closeSdate) {
		this.closeSdate = closeSdate;
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
