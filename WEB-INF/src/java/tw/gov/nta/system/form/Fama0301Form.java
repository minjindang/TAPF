/*
 * ¦b 2006/2/22 «Ø¥ß
 */
package tw.gov.nta.system.form;

import gov.dnt.tame.common.SupportForm;

import java.util.Date;

import tw.gov.nta.sql.BudgetRef;
import tw.gov.nta.sql.DebitRef;

/**
 * @author AndrewSung
 */
public class Fama0301Form extends SupportForm 
{
	private static final long serialVersionUID = 1L;

	DebitRef debitRef = new DebitRef();
    private String qryDebitType;
    private String qryDebitName;
    private Integer qryBudgetCode;
    private Integer budgetId;
    private String qry;
	public String getQry()
	{
		return qry;
	}
	public void setQry(String qry)
	{
		this.qry = qry;
	}
	public Integer getBudgetId()
	{
		
		return debitRef.getBudgetCode().getId();
	}
	public void setBudgetId(Integer budgetId)
	{
		this.budgetId = budgetId;
		BudgetRef budgetRef = new BudgetRef ();
		budgetRef.setId(budgetId);
		debitRef.setBudgetCode(budgetRef);
	}
	public void setBudgetCode(BudgetRef budgetRef)
	{
		debitRef.setBudgetCode(budgetRef);
	}
	public DebitRef getDebitRef()
	{
		return debitRef;
	}
	public void setDebitRef(DebitRef debitRef)
	{
		this.debitRef = debitRef;
	}
	public Integer getQryBudgetCode()
	{
		return qryBudgetCode;
	}
	public void setQryBudgetCode(Integer qryBudgetCode)
	{
		this.qryBudgetCode = qryBudgetCode;
	}
	public String getQryDebitName()
	{
		return qryDebitName;
	}
	public void setQryDebitName(String qryDebitName)
	{
		this.qryDebitName = qryDebitName;
	}
	public String getQryDebitType()
	{
		return qryDebitType;
	}
	public void setQryDebitType(String qryDebitType)
	{
		this.qryDebitType = qryDebitType;
	}
	public BudgetRef getBudgetCode()
	{
		return debitRef.getBudgetCode();
	}
	public Date getCreateDate()
	{
		return debitRef.getCreateDate();
	}
	public String getDebitName()
	{
		return debitRef.getDebitName();
	}
	public String getDebitType()
	{
		return debitRef.getDebitType();
	}
	public Integer getId()
	{
		return debitRef.getId();
	}
	public Date getModDate()
	{
		return debitRef.getModDate();
	}
	public String getRemark()
	{
		return debitRef.getRemark();
	}
	public String getUsrid()
	{
		return debitRef.getUsrid();
	}
	/*public void setBudgetCode(BudgetRef budgetCode)
	{
		debitRef.setBudgetCode(budgetCode);
	}*/
	public void setCreateDate(Date createDate)
	{
		debitRef.setCreateDate(createDate);
	}
	public void setDebitName(String debitName)
	{
		debitRef.setDebitName(debitName);
	}
	public void setDebitType(String debitType)
	{
		debitRef.setDebitType(debitType);
	}
	public void setId(Integer id)
	{
		debitRef.setId(id);
	}
	public void setModDate(Date modDate)
	{
		debitRef.setModDate(modDate);
	}
	public void setRemark(String remark)
	{
		debitRef.setRemark(remark);
	}
	public void setUsrid(String usrid)
	{
		debitRef.setUsrid(usrid);
	}
    
}

