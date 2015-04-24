package tw.gov.nta.debt.form;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;

import tw.gov.nta.sql.BudgetRef;
import tw.gov.nta.sql.DebitRef;
import tw.gov.nta.sql.dao.BudgetRefDAO;
import tw.gov.nta.sql.dao.DebitRefDAO;

import gov.dnt.tame.common.SupportForm;

public class Cira0601Form extends SupportForm {
	private static final long serialVersionUID = 1L;


	public Cira0601Form() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String status;
	private String startYear;
	private String endYear;
	private Date startDate;
	private Date endDate;
	private String budgetCode;
	private String debtCode;
	private String budgetLabel;
	private String debtLabel;
	private String startSerial;
	private String endSerial;
	private Date baseDate;
	private String bankCode;
	private String baseUnit;
	private String baseUnitValue;
	public String getBaseUnitValue() {
		return baseUnitValue;
	}
	public void setBaseUnitValue(String baseUnitValue) {
		this.baseUnitValue = baseUnitValue;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public Date getBaseDate() {
		return baseDate;
	}
	public void setBaseDate(Date baseDate) {
		this.baseDate = baseDate;
	}
	public String getBaseUnit() {
		return baseUnit;
	}
	public void setBaseUnit(String baseUnit) {
		this.baseUnit = baseUnit;
	}
	public String getBudgetCode() {
		return budgetCode;
	}
	public void setBudgetCode(String budgetCode) {
		this.budgetCode = budgetCode;
	}
	public String getDebtCode() {
		return debtCode;
	}
	public void setDebtCode(String debtCode) {
		this.debtCode = debtCode;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getEndSerial() {
		return endSerial;
	}
	public void setEndSerial(String endSerial) {
		this.endSerial = endSerial;
	}
	public String getEndYear() {
		return endYear;
	}
	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public String getStartSerial() {
		return startSerial;
	}
	public void setStartSerial(String startSerial) {
		this.startSerial = startSerial;
	}
	public String getStartYear() {
		return startYear;
	}
	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List getBudgetList()
	{
		Session session = new BudgetRefDAO().getSession();
		Criteria criteria = session.createCriteria(BudgetRef.class);	
		List myList = criteria.list();
		session.close();
		return myList; 
	}
	public List getDebtCodeList()
	{
		 Session session = new DebitRefDAO().getSession();
	     Criteria criteria = session.createCriteria(DebitRef.class);
	     List myList = new LinkedList();
		if(null != getBudgetCode() && !"".equals(getBudgetCode()))	
		{	 
		     criteria.add(Expression.eq("budgetCode.id",Integer.parseInt(getBudgetCode())));
	    	 myList = criteria.list();
		     session.close();
		     return myList; 
		}
		else
		{
			return null;
		}
		
	}
	public String getBudgetLabel() {
		return budgetLabel;
	}
	public void setBudgetLabel(String budgetLabel) {
		this.budgetLabel = budgetLabel;
	}
	public String getDebtLabel() {
		return debtLabel;
	}
	public void setDebtLabel(String debtLabel) {
		this.debtLabel = debtLabel;
	}
}
