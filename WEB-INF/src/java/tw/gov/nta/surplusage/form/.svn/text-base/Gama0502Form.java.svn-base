/**
*
* @author Andrew Sung
* @createDate 2006/7/12
*/
package tw.gov.nta.surplusage.form;

import java.math.BigDecimal;

import gov.dnt.tame.common.SupportForm;
import tw.gov.nta.sql.UserStatisticsDet;
import tw.gov.nta.sql.UserStatisticsMain;

public class Gama0502Form extends SupportForm {
	private UserStatisticsDet userStatisticsDet = new UserStatisticsDet();
	private Integer mainId;
	private BigDecimal lastKeepAmount;
	
	public Integer getMainId() {
		return mainId;
	}

	public void setMainId(Integer mainId) {
		this.mainId = mainId;
	}

	public UserStatisticsDet getUserStatisticsDet() {
		return userStatisticsDet;
	}

	public void setUserStatisticsDet(UserStatisticsDet userStatisticsDet) {
		this.userStatisticsDet = userStatisticsDet;
	}

	public String getAccountYear() {
		return userStatisticsDet.getAccountYear();
	}

	public BigDecimal getAuditAmount() {
		return userStatisticsDet.getAuditAmount();
	}

	public String getDataType() {
		return userStatisticsDet.getDataType();
	}

	public Integer getId() {
		return userStatisticsDet.getId();
	}

	public BigDecimal getKeepAmount() {
		return userStatisticsDet.getKeepAmount();
	}

	public BigDecimal getPlusdebtAmount() {
		return userStatisticsDet.getPlusdebtAmount();
	}

	public BigDecimal getRealAmount() {
		return userStatisticsDet.getRealAmount();
	}

	public BigDecimal getSubAmount() {
		return userStatisticsDet.getSubAmount();
	}

	public BigDecimal getSubdebtAmount() {
		return userStatisticsDet.getSubdebtAmount();
	}

	public UserStatisticsMain getUserStatisticsMain() {
		return userStatisticsDet.getUserStatisticsMain();
	}

	public void setAccountYear(String accountYear) {
		if(accountYear.trim().length()>0){
			if(Integer.parseInt(accountYear.trim())<10)
				accountYear = "00"+String.valueOf(Integer.parseInt(accountYear.trim()));
			else if(Integer.parseInt(accountYear.trim())<100)
				accountYear = "0"+String.valueOf(Integer.parseInt(accountYear.trim()));
		}
		userStatisticsDet.setAccountYear(accountYear);
	}

	public void setAuditAmount(BigDecimal auditAmount) {
		userStatisticsDet.setAuditAmount(auditAmount);
	}

	public void setDataType(String dataType) {
		userStatisticsDet.setDataType(dataType);
	}

	public void setId(Integer id) {
		userStatisticsDet.setId(id);
	}

	public void setKeepAmount(BigDecimal keepAmount) {
		userStatisticsDet.setKeepAmount(keepAmount);
	}

	public void setPlusdebtAmount(BigDecimal plusdebtAmount) {
		userStatisticsDet.setPlusdebtAmount(plusdebtAmount);
	}

	public void setRealAmount(BigDecimal realAmount) {
		userStatisticsDet.setRealAmount(realAmount);
	}

	public void setSubAmount(BigDecimal subAmount) {
		userStatisticsDet.setSubAmount(subAmount);
	}

	public void setSubdebtAmount(BigDecimal subdebtAmount) {
		userStatisticsDet.setSubdebtAmount(subdebtAmount);
	}

	public void setUserStatisticsMain(UserStatisticsMain userStatisticsMain) {
		userStatisticsDet.setUserStatisticsMain(userStatisticsMain);
	}

	public BigDecimal getLastKeepAmount() {
		if(lastKeepAmount != null)
			return lastKeepAmount;
		else
			return new BigDecimal(0);
	}

	public void setLastKeepAmount(BigDecimal lastKeepAmount) {
		this.lastKeepAmount = lastKeepAmount;
	}

	public String getBanish() {
		return userStatisticsDet.getBanish();
	}

	public void setBanish(String banish) {
		userStatisticsDet.setBanish(banish);
	}

	public BigDecimal getOldKeepAmount() {
		return userStatisticsDet.getOldKeepAmount();
	}

	public void setOldKeepAmount(BigDecimal oldKeepAmount) {
		userStatisticsDet.setOldKeepAmount(oldKeepAmount);
	}
	
}
