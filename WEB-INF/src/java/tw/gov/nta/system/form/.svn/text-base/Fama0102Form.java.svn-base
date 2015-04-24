package tw.gov.nta.system.form;

import gov.dnt.tame.common.SupportForm;

import java.util.Date;

import tw.gov.nta.sql.CodeDet;
import tw.gov.nta.sql.CodeMain;
import tw.gov.nta.sql.dao.CodeMainDAO;

public class Fama0102Form extends SupportForm
{
	private static final long serialVersionUID = 1L;

	CodeDet codeDet = new CodeDet();
	CodeMain codeMain = new CodeMain();
	private Integer qryKindId;
	private String qryKindNo;
	private String qryKindName;
	public CodeDet getCodeDet()
	{
		return codeDet;
	}

	public void setCodeDet(CodeDet codeDet)
	{
		this.codeDet = codeDet;
	}

	public String getCodeName()
	{
		return codeDet.getCodeName();
	}

	public String getCodeNo()
	{
		return codeDet.getCodeNo();
	}

	public Date getCreateDate()
	{
		return codeDet.getCreateDate();
	}

	public Integer getId()
	{
		return codeDet.getId();
	}

	public Date getModDate()
	{
		return codeDet.getModDate();
	}

	public String getRemark()
	{
		return codeDet.getRemark();
	}

	public String getUsrid()
	{
		return codeDet.getUsrid();
	}

	public void setCodeName(String codeName)
	{
		codeDet.setCodeName(codeName);
	}

	public void setCodeNo(String codeNo)
	{
		codeDet.setCodeNo(codeNo);
	}

	public void setCreateDate(Date createDate)
	{
		codeDet.setCreateDate(createDate);
	}

	public void setId(Integer id)
	{
		codeDet.setId(id);
	}

	public void setModDate(Date modDate)
	{
		codeDet.setModDate(modDate);
	}

	public void setRemark(String remark)
	{
		codeDet.setRemark(remark);
	}

	public void setUsrid(String usrid)
	{
		codeDet.setUsrid(usrid);
	}

	public CodeMain getKind()
	{
		return codeDet.getKind();
	}

	public void setKind(CodeMain id)
	{
		codeDet.setKind(id);
	}

	public Integer getQryKindId()
	{
		return qryKindId;
	}

	public void setQryKindId(Integer qryKindId)
	{
		this.qryKindId = qryKindId;
	}

	public String getQryKindName()
	{
		return qryKindName;
	}

	public void setQryKindName(String qryKindName)
	{
		this.qryKindName = qryKindName;
	}

	public String getQryKindNo()
	{
		return qryKindNo;
	}

	public void setQryKindNo(String qryKindNo)
	{
		this.qryKindNo = qryKindNo;
	}
	public Integer getKindId()
	{
		return codeDet.getKind().getId();
	}

	public void setKindId(Integer id)
	{
		CodeMainDAO codeMainDao = new CodeMainDAO();
		CodeMain codeMain = codeMainDao.get(id);
		codeDet.setKind(codeMain);
	}

	
}
