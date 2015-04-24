package tw.gov.nta.surplusage.form;

import gov.dnt.tame.util.DateUtil;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

public class Gara4201Form extends GaraBaseForm{
	
	private static final long serialVersionUID = 1L;
	private String accountYear;
	private Date statrDate;
	private Date endDate;
	
	public String getAccountYear() {
		return accountYear;
	}
	public void setAccountYear(String accountYear) {
		this.accountYear = accountYear;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Date getStatrDate() {
		return statrDate;
	}
	public void setStatrDate(Date statrDate) {
		this.statrDate = statrDate;
	}
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
		super.reset(mapping, request);
		
		String systemDate = DateUtil.getSystemDate();
		setAccountYear(systemDate.substring(0,3));
		
	}

}
