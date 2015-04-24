package tw.gov.nta.central.form;
import gov.dnt.tame.common.SupportForm;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.hibernate.Criteria;
import tw.gov.nta.sql.NationalDebtDueDateMain;
import tw.gov.nta.sql.dao.NationalDebtDueDateMainDAO;
/**
 * @author Powen Hsueh
 *
 * TODO 如果要變更這個產生的類別註解的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
public class Rama0101Form extends SupportForm {
	private static final long serialVersionUID = 1L;
	//NationalDebtDueDateMain myDto = new NationalDebtDueDateMain();
	

	//public NationalDebtDueDateMain getMyDto() {
		//return myDto;
	//}

	//public void setMyDto(NationalDebtDueDateMain myDto) {
		//this.myDto = myDto;
	//}


	private Integer[] id ;
	private Integer[] issueId;
	private Integer[] planId;
	private String[] repayDate ;
	private String[] debtName;
	private Integer[] capitalSerial;
	private Integer[] interestSerial;
	private BigDecimal[] capitalAmount;
	private BigDecimal[] interestAmount;
	private String[] repayHandle;
	private String[] repayNumber;
	private String[] accountDate;
	private String[] accountNumber;
	private String[] fundNumber;
	private String[] secretaryDate;
	private Integer[] state;
	private String currentUserDeptId;
	private String repayDateS;
	private String repayDateE;
	private int page;
	
	
	public String getRepayDateE() {
		return repayDateE;
	}
	public void setRepayDateE(String repayDateE) {
		this.repayDateE = repayDateE;
	}
	public String getRepayDateS() {
		return repayDateS;
	}
	public void setRepayDateS(String repayDateS) {
		this.repayDateS = repayDateS;
	}
	
	public Integer[] getId() {
		return id;
	}

	public Integer[] getIssueId() {
		return issueId;
	}

	public Integer[] getPlanId() {
		return planId;
	}
	
	public String[] getRepayDate() {
		return repayDate;
	}
	
	public String[] getDebtName() {
		return debtName;
	}

	public Integer[] getCapitalSerial() {
		return capitalSerial;
	}
	
	public Integer[] getInterestSerial() {
		return interestSerial;
	}
	
	public BigDecimal[] getCapitalAmount() {
		return capitalAmount;
	}
	
	public BigDecimal[] getInterestAmount() {
		return interestAmount;
	}
	
	public String[] getRepayHandle() {
		return repayHandle;
	}
	
	public String[] getRepayNumber() {
		return repayNumber;
	}
	
	public String[] getAccountDate() {
		return accountDate;
	}
	
	public String[] getAccountNumber() {
		return accountNumber;
	}
	
	public String[] getFundNumber() {
		return fundNumber;
	}
	
	public String[] getSecretaryDate() {
		return secretaryDate;
	}
	
	public void setId(Integer[] id) {
		this.id =id;
	}

	public void setIssueId(Integer[] issueId) {
		this.issueId = issueId;
	}

	public void setPlanId(Integer[] planId) {
		this.planId = planId;
	}
	
	public void setRepayDate(String[] repayDate) {
		this.repayDate = repayDate;
	}
	
	public void setDebtName(String[] debtName) {
		this.debtName = debtName;
	}

	public void setCapitalSerial(Integer[] capitalSerial) {
		this.capitalSerial = capitalSerial;
	}
	
	public void setInterestSerial(Integer[] interestSerial) {
		this.interestSerial = interestSerial;
	}
	
	public void setCapitalAmount(BigDecimal[] capitalAmount) {
		this.capitalAmount = capitalAmount;
	}
	
	public void setInterestAmount(BigDecimal[] interestAmount) {
		this.interestAmount = interestAmount;
	}
	
	public void setRepayHandle(String[] repayHandle) {
		this.repayHandle = repayHandle;
	}
	
	public void setRepayNumber(String[] repayNumber) {
		this.repayNumber = repayNumber;
	}
	
	public void setAccountDate(String[] accountDate) {
		this.accountDate = accountDate;
	}
	
	public void setAccountNumber(String[] accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public void setFundNumber(String[] fundNumber) {
		this.fundNumber = fundNumber;
	}
	
	public void setSecretaryDate(String[] secretaryDate) {
		this.secretaryDate = secretaryDate;
	}
	

	
	
	public String getCurrentUserDeptId() {
		return currentUserDeptId;
	}

	public void setCurrentUserDeptId(String currentUserDeptId) {
		this.currentUserDeptId = currentUserDeptId;
	}

	public Integer[] getState() {
		return state;
	}

	public void setState(Integer[] state) {
		this.state = state;
	}

	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	
}
