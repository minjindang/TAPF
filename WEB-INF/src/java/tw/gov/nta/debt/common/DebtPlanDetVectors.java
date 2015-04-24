package tw.gov.nta.debt.common;

import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.DebtPlanDet;

public class DebtPlanDetVectors {
	private static final long serialVersionUID = 1L;
	private DebtPlanDet debtPlanDet = new DebtPlanDet();

	private Integer id;
	private String capitalAmount;
	private String interestAmount;
	private String capitalSerial;
	private String interestSerial;
	private String totalCount;
	private String repay;
	private String originInterestAmount;
	
	public String getOriginInterestAmount() {
		return originInterestAmount;
	}
	public void setOriginInterestAmount(String originInterestAmount) {
		this.originInterestAmount = originInterestAmount;
	}
	public String getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}
	public DebtPlanDet getDebtPlanDet() {
		return debtPlanDet;
	}
	public void setDebtPlanDet(DebtPlanDet debtPlanDet) {
		this.debtPlanDet = debtPlanDet;
	}
	public DebtMain getDebt() {
		return debtPlanDet.getDebt();
	}
	public void setDebt(DebtMain debt) {
		debtPlanDet.setDebt(debt);
	}
	public String getCapitalAmount() {
		return capitalAmount;
	}
	public void setCapitalAmount(String capitalAmount) {
		this.capitalAmount = capitalAmount;
	}
	public String getInterestAmount() {
		return interestAmount;
	}
	public void setInterestAmount(String interestAmount) {
		this.interestAmount = interestAmount;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRepay() {
		return repay;
	}
	public void setRepay(String repay) {
		if( "on".equals( repay ) )
			this.repay = "Y";
		else
			this.repay = "N";
		this.repay = repay;
	}
	public String getCapitalSerial() {
		return capitalSerial;
	}
	public void setCapitalSerial(String capitalSerial) {
		this.capitalSerial = capitalSerial;
	}
	public String getInterestSerial() {
		return interestSerial;
	}
	public void setInterestSerial(String interestSerial) {
		this.interestSerial = interestSerial;
	}
}
