package tw.gov.nta.system.form;

import gov.dnt.tame.common.SupportForm;

import java.util.Date;

import tw.gov.nta.sql.CodeDet;
import tw.gov.nta.sql.CodeMain;
import tw.gov.nta.sql.dao.CodeMainDAO;

public class Fama0101Form extends SupportForm
{
	private static final long serialVersionUID = 1L;

	CodeMain codeMain = new CodeMain();
	CodeDet codeDet = new CodeDet();
	private String qryKindNo;
	private String qryKindName;
	private Integer kindId;
	

	public CodeMain getCodeMain(){
		return codeMain;
	}

	public void setCodeMain(CodeMain codeMain){
		this.codeMain = codeMain;
	}

	public String getQryKindName(){
		return qryKindName;
	}

	public void setQryKindName(String qryKindName){
		this.qryKindName = qryKindName;
	}

	public String getQryKindNo(){
		return qryKindNo;
	}

	public void setQryKindNo(String qryKindNo){
		this.qryKindNo = qryKindNo;
	}

	public Date getCreateDate(){
		return codeMain.getCreateDate();
	}

	public Integer getId(){
		return codeMain.getId();
	}

	public String getKindName(){
		return codeMain.getKindName();
	}

	public String getKindNo(){
		return codeMain.getKindNo();
	}

	public Date getModDate(){
		return codeMain.getModDate();
	}

	public String getRemark(){
		return codeMain.getRemark();
	}

	public String getUsrid(){
		return codeMain.getUsrid();
	}

	public void setCreateDate(Date createDate){
		codeMain.setCreateDate(createDate);
	}

	public void setId(Integer id){
		codeMain.setId(id);
	}

	public void setKindName(String kindName){
		codeMain.setKindName(kindName);
	}

	public void setKindNo(String kindNo){
		codeMain.setKindNo(kindNo);
	}

	public void setModDate(Date modDate){
		codeMain.setModDate(modDate);
	}

	public void setRemark(String remark){
		codeMain.setRemark(remark);
	}

	public void setUsrid(String usrid){
		codeMain.setUsrid(usrid);
	}

	public CodeMain getKind(){
		return codeDet.getKind();
	}

	public void setKind(CodeMain kindId){
		codeDet.setKind(kindId);
	}

	public Integer getKindId(){
		return codeDet.getKind().getId();
	}

	public void setKindId(Integer kindId){
		CodeMainDAO codeMainDao = new CodeMainDAO();
		CodeMain codeMain = codeMainDao.get(kindId);
		codeDet.setKind(codeMain);
	}
}