package tw.gov.nta.surplusage.form;

import gov.dnt.tame.common.SupportForm;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import tw.gov.nta.sql.UserStatisticsMain;

public class Gama0501Form extends SupportForm {
	private static final long serialVersionUID = 1L;
	private String qryStartYear;
	private String qryEndYear;
	private Integer qryBudgetCode;
	private Integer qryDebtCode;
	private String qryBoundCode;
	private String qryInoutType;
	private Integer mainId;
	private UserStatisticsMain userStatisticsMain = new UserStatisticsMain();

	public void reset(ActionMapping arg0, HttpServletRequest arg1) {
		super.reset(arg0, arg1);

		if( userStatisticsMain==null )
		{
			userStatisticsMain = new UserStatisticsMain();
			setAccountYear( DateUtil.date2ROCStr( new Date() ).substring(0,3) );
		}
	}

	public Integer getMainId() {
		return mainId;
	}

	public void setMainId(Integer mainId) {
		this.mainId = mainId;
	}

	public String getQryBoundCode() {
		return qryBoundCode;
	}

	public void setQryBoundCode(String qryBoundCode) {
		this.qryBoundCode = qryBoundCode;
	}

	public Integer getQryBudgetCode() {
		return qryBudgetCode;
	}

	public void setQryBudgetCode(Integer qryBudgetCode) {
		this.qryBudgetCode = qryBudgetCode;
	}

	public Integer getQryDebtCode() {
		return qryDebtCode;
	}

	public void setQryDebtCode(Integer qryDebtCode) {
		this.qryDebtCode = qryDebtCode;
	}

	public UserStatisticsMain getUserStatisticsMain() {
		return userStatisticsMain;
	}

	public void setUserStatisticsMain(UserStatisticsMain userStatisticsMain) {
		this.userStatisticsMain = userStatisticsMain;
	}

	public String getAccountYear() {
		return userStatisticsMain.getAccountYear();
	}

	public BigDecimal getAuditBamount1() {
		return userStatisticsMain.getAuditBamount1();
	}

	public BigDecimal getAuditBamount2() {
		return userStatisticsMain.getAuditBamount2();
	}

	public BigDecimal getAuditPamount1() {
		return userStatisticsMain.getAuditPamount1();
	}

	public BigDecimal getAuditPamount2() {
		return userStatisticsMain.getAuditPamount2();
	}

	public BigDecimal getAuditRamount1() {
		return userStatisticsMain.getAuditRamount1();
	}

	public BigDecimal getAuditRamount2() {
		return userStatisticsMain.getAuditRamount2();
	}

	public BigDecimal getAuditUamount1() {
		return userStatisticsMain.getAuditUamount1();
	}

	public BigDecimal getAuditUamount2() {
		return userStatisticsMain.getAuditUamount2();
	}

	public String getBoundCode() {
		return userStatisticsMain.getBoundCode();
	}

	public BigDecimal getBudgetBamount1() {
		return userStatisticsMain.getBudgetBamount1();
	}

	public BigDecimal getBudgetBamount2() {
		return userStatisticsMain.getBudgetBamount2();
	}

	public Integer getBudgetCode() {
		return userStatisticsMain.getBudgetCode();
	}

	public BigDecimal getBudgetPamount1() {
		return userStatisticsMain.getBudgetPamount1();
	}

	public BigDecimal getBudgetPamount2() {
		return userStatisticsMain.getBudgetPamount2();
	}

	public BigDecimal getBudgetRamount1() {
		return userStatisticsMain.getBudgetRamount1();
	}

	public BigDecimal getBudgetRamount2() {
		return userStatisticsMain.getBudgetRamount2();
	}

	public BigDecimal getBudgetUamount1() {
		return userStatisticsMain.getBudgetUamount1();
	}

	public BigDecimal getBudgetUamount2() {
		return userStatisticsMain.getBudgetUamount2();
	}

	public Integer getDebtCode() {
		return userStatisticsMain.getDebtCode();
	}

	public Integer getId() {
		return userStatisticsMain.getId();
	}

	public BigDecimal getKeepBamount1() {
		return userStatisticsMain.getKeepBamount1();
	}

	public BigDecimal getKeepBamount2() {
		return userStatisticsMain.getKeepBamount2();
	}

	public BigDecimal getKeepPamount1() {
		return userStatisticsMain.getKeepPamount1();
	}

	public BigDecimal getKeepPamount2() {
		return userStatisticsMain.getKeepPamount2();
	}

	public BigDecimal getKeepRamount1() {
		return userStatisticsMain.getKeepRamount1();
	}

	public BigDecimal getKeepRamount2() {
		return userStatisticsMain.getKeepRamount2();
	}

	public BigDecimal getKeepUamount1() {
		return userStatisticsMain.getKeepUamount1();
	}

	public BigDecimal getKeepUamount2() {
		return userStatisticsMain.getKeepUamount2();
	}

	public BigDecimal getRealBamount1() {
		return userStatisticsMain.getRealBamount1();
	}

	public BigDecimal getRealBamount2() {
		return userStatisticsMain.getRealBamount2();
	}

	public BigDecimal getRealPamount1() {
		return userStatisticsMain.getRealPamount1();
	}

	public BigDecimal getRealPamount2() {
		return userStatisticsMain.getRealPamount2();
	}

	public BigDecimal getRealRamount1() {
		return userStatisticsMain.getRealRamount1();
	}

	public BigDecimal getRealRamount2() {
		return userStatisticsMain.getRealRamount2();
	}

	public BigDecimal getRealUamount1() {
		return userStatisticsMain.getRealUamount1();
	}

	public BigDecimal getRealUamount2() {
		return userStatisticsMain.getRealUamount2();
	}

	public String getRemark() {
		return userStatisticsMain.getRemark();
	}

	public void setAccountYear(String accountYear) {
		accountYear=accountYear.trim();
		if (accountYear.length() < 3 && !"".equals(accountYear)){
			for (int i = 0 ; i < 3-accountYear.length() ; i++){
				accountYear = "0" + accountYear;
			}	
		}
		userStatisticsMain.setAccountYear(accountYear);
	}

	public void setAuditBamount1(BigDecimal auditBamount1) {
		userStatisticsMain.setAuditBamount1(auditBamount1);
	}

	public void setAuditBamount2(BigDecimal auditBamount2) {
		userStatisticsMain.setAuditBamount2(auditBamount2);
	}

	public void setAuditPamount1(BigDecimal auditPamount1) {
		userStatisticsMain.setAuditPamount1(auditPamount1);
	}

	public void setAuditPamount2(BigDecimal auditPamount2) {
		userStatisticsMain.setAuditPamount2(auditPamount2);
	}

	public void setAuditRamount1(BigDecimal auditRamount1) {
		userStatisticsMain.setAuditRamount1(auditRamount1);
	}

	public void setAuditRamount2(BigDecimal auditRamount2) {
		userStatisticsMain.setAuditRamount2(auditRamount2);
	}

	public void setAuditUamount1(BigDecimal auditUamount1) {
		userStatisticsMain.setAuditUamount1(auditUamount1);
	}

	public void setAuditUamount2(BigDecimal auditUamount2) {
		userStatisticsMain.setAuditUamount2(auditUamount2);
	}

	public void setBoundCode(String boundCode) {
		userStatisticsMain.setBoundCode(boundCode);
	}

	public void setBudgetBamount1(BigDecimal budgetBamount1) {
		userStatisticsMain.setBudgetBamount1(budgetBamount1);
	}

	public void setBudgetBamount2(BigDecimal budgetBamount2) {
		userStatisticsMain.setBudgetBamount2(budgetBamount2);
	}

	public void setBudgetCode(Integer budgetCode) {
		userStatisticsMain.setBudgetCode(budgetCode);
	}

	public void setBudgetPamount1(BigDecimal budgetPamount1) {
		userStatisticsMain.setBudgetPamount1(budgetPamount1);
	}

	public void setBudgetPamount2(BigDecimal budgetPamount2) {
		userStatisticsMain.setBudgetPamount2(budgetPamount2);
	}

	public void setBudgetRamount1(BigDecimal budgetRamount1) {
		userStatisticsMain.setBudgetRamount1(budgetRamount1);
	}

	public void setBudgetRamount2(BigDecimal budgetRamount2) {
		userStatisticsMain.setBudgetRamount2(budgetRamount2);
	}

	public void setBudgetUamount1(BigDecimal budgetUamount1) {
		userStatisticsMain.setBudgetUamount1(budgetUamount1);
	}

	public void setBudgetUamount2(BigDecimal budgetUamount2) {
		userStatisticsMain.setBudgetUamount2(budgetUamount2);
	}

	public void setDebtCode(Integer debtCode) {
		userStatisticsMain.setDebtCode(debtCode);
	}

	public void setId(Integer id) {
		userStatisticsMain.setId(id);
	}

	public void setKeepBamount1(BigDecimal keepBamount1) {
		userStatisticsMain.setKeepBamount1(keepBamount1);
	}

	public void setKeepBamount2(BigDecimal keepBamount2) {
		userStatisticsMain.setKeepBamount2(keepBamount2);
	}

	public void setKeepPamount1(BigDecimal keepPamount1) {
		userStatisticsMain.setKeepPamount1(keepPamount1);
	}

	public void setKeepPamount2(BigDecimal keepPamount2) {
		userStatisticsMain.setKeepPamount2(keepPamount2);
	}

	public void setKeepRamount1(BigDecimal keepRamount1) {
		userStatisticsMain.setKeepRamount1(keepRamount1);
	}

	public void setKeepRamount2(BigDecimal keepRamount2) {
		userStatisticsMain.setKeepRamount2(keepRamount2);
	}

	public void setKeepUamount1(BigDecimal keepUamount1) {
		userStatisticsMain.setKeepUamount1(keepUamount1);
	}

	public void setKeepUamount2(BigDecimal keepUamount2) {
		userStatisticsMain.setKeepUamount2(keepUamount2);
	}

	public void setRealBamount1(BigDecimal realBamount1) {
		userStatisticsMain.setRealBamount1(realBamount1);
	}

	public void setRealBamount2(BigDecimal realBamount2) {
		userStatisticsMain.setRealBamount2(realBamount2);
	}

	public void setRealPamount1(BigDecimal realPamount1) {
		userStatisticsMain.setRealPamount1(realPamount1);
	}

	public void setRealPamount2(BigDecimal realPamount2) {
		userStatisticsMain.setRealPamount2(realPamount2);
	}

	public void setRealRamount1(BigDecimal realRamount1) {
		userStatisticsMain.setRealRamount1(realRamount1);
	}

	public void setRealRamount2(BigDecimal realRamount2) {
		userStatisticsMain.setRealRamount2(realRamount2);
	}

	public void setRealUamount1(BigDecimal realUamount1) {
		userStatisticsMain.setRealUamount1(realUamount1);
	}

	public void setRealUamount2(BigDecimal realUamount2) {
		userStatisticsMain.setRealUamount2(realUamount2);
	}

	public void setRemark(String remark) {
		userStatisticsMain.setRemark(remark);
	}
	
	
	public Date getCreateDate() {
		return userStatisticsMain.getCreateDate();
	}

	public void setCreateDate(Date createDate) {
		userStatisticsMain.setCreateDate(createDate);
	}

	public String getQryEndYear() {
		return qryEndYear;
	}

	public void setQryEndYear(String qryEndYear) {
		qryEndYear=qryEndYear.trim();
		if (qryEndYear.length() < 3 && !"".equals(qryEndYear)){
			for (int i = 0 ; i < 3-qryEndYear.length() ; i++){
				qryEndYear = "0" + qryEndYear;
			}	
		}
		this.qryEndYear = qryEndYear;
	}

	public String getQryStartYear() {
		return qryStartYear;
	}

	public void setQryStartYear(String qryStartYear) {
		qryStartYear=qryStartYear.trim();
		if (qryStartYear.length() < 3 && !"".equals(qryStartYear)){
			for (int i = 0 ; i < 3-qryStartYear.length() ; i++){
				qryStartYear = "0" + qryStartYear;
			}	
		}
		this.qryStartYear = qryStartYear;
	}

	public BigDecimal getRealBuamount1() {
		return userStatisticsMain.getRealBuamount1();
	}

	public BigDecimal getRealBuamount2() {
		return userStatisticsMain.getRealBuamount2();
	}

	public void setRealBuamount1(BigDecimal realBuamount1) {
		userStatisticsMain.setRealBuamount1(realBuamount1);
	}

	public void setRealBuamount2(BigDecimal realBuamount2) {
		userStatisticsMain.setRealBuamount2(realBuamount2);
	}

	public String getAccountType() {
		return userStatisticsMain.getAccountType();
	}

	public void setAccountType(String accountType) {
		userStatisticsMain.setAccountType(accountType);
	}

	public String getQryInoutType() {
		return qryInoutType;
	}

	public void setQryInoutType(String qryInoutType) {
		this.qryInoutType = qryInoutType;
	}

	public String getInoutType() {
		return userStatisticsMain.getInoutType();
	}

	public void setInoutType(String inoutType) {
		userStatisticsMain.setInoutType(inoutType);
	}

	public BigDecimal getOddKeepBamount1() {
		return userStatisticsMain.getOddKeepBamount1();
	}

	public BigDecimal getOddKeepBamount2() {
		return userStatisticsMain.getOddKeepBamount2();
	}

	public BigDecimal getOddKeepUamount1() {
		return userStatisticsMain.getOddKeepUamount1();
	}

	public BigDecimal getOddKeepUamount2() {
		return userStatisticsMain.getOddKeepUamount2();
	}

	public void setOddKeepBamount1(BigDecimal oddKeepBamount1) {
		userStatisticsMain.setOddKeepBamount1(oddKeepBamount1);
	}

	public void setOddKeepBamount2(BigDecimal oddKeepBamount2) {
		userStatisticsMain.setOddKeepBamount2(oddKeepBamount2);
	}

	public void setOddKeepUamount1(BigDecimal oddKeepUamount1) {
		userStatisticsMain.setOddKeepUamount1(oddKeepUamount1);
	}

	public void setOddKeepUamount2(BigDecimal oddKeepUamount2) {
		userStatisticsMain.setOddKeepUamount2(oddKeepUamount2);
	}
	
}
