/*
程式目的：FAMA04文字
程式代號：FAMA04
程式日期：0950223
程式作者：FormBean Generator
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
*/
package tw.gov.nta.system.form;

import gov.dnt.tame.common.SupportForm;

import java.util.Date;

import tw.gov.nta.sql.ExstockRef;

public class Fama0401Form extends SupportForm
{
	private static final long serialVersionUID = 1L;

	ExstockRef exstockRef = new ExstockRef();
	private String qryStockId;
	private String qryStockName;
	
	

	public String getQryStockId()
	{
		return qryStockId;
	}

	public void setQryStockId(String qryStockId)
	{
		this.qryStockId = qryStockId;
	}

	public String getQryStockName()
	{
		return qryStockName;
	}

	public void setQryStockName(String qryStockName)
	{
		this.qryStockName = qryStockName;
	}

	public ExstockRef getExstockRef()
	{
		return exstockRef;
	}

	public void setExstockRef(ExstockRef exstockRef)
	{
		this.exstockRef = exstockRef;
	}

	public Date getCreateDate()
	{
		return exstockRef.getCreateDate();
	}

	public Integer getId()
	{
		return exstockRef.getId();
	}

	public Date getModDate()
	{
		return exstockRef.getModDate();
	}

	public String getRemark()
	{
		return exstockRef.getRemark();
	}

	public String getStockId()
	{
		return exstockRef.getStockId();
	}

	public String getStockName()
	{
		return exstockRef.getStockName();
	}

	public String getUsrid()
	{
		return exstockRef.getUsrid();
	}

	public void setCreateDate(Date createDate)
	{
		exstockRef.setCreateDate(createDate);
	}

	public void setId(Integer id)
	{
		exstockRef.setId(id);
	}

	public void setModDate(Date modDate)
	{
		exstockRef.setModDate(modDate);
	}

	public void setRemark(String remark)
	{
		exstockRef.setRemark(remark);
	}

	public void setStockId(String stockId)
	{
		exstockRef.setStockId(stockId);
	}

	public void setStockName(String stockName)
	{
		exstockRef.setStockName(stockName);
	}

	public void setUsrid(String usrid)
	{
		exstockRef.setUsrid(usrid);
	}
	
}