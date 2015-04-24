/* Fama0201Form.java
程式目的：FAMA02
程式代號：FAMA02
程式日期：0950222
程式作者：Eric.Chen
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
*/
package tw.gov.nta.system.form;

import gov.dnt.tame.common.SupportForm;

import java.util.Date;
import java.util.Set;

import tw.gov.nta.sql.BudgetRef;
import tw.gov.nta.sql.DebitRef;

/**
 * @author EricChen
 *
 * TODO 如果要變更這個產生的類別註解的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
public class Fama0201Form extends SupportForm {
	private static final long serialVersionUID = 1L;

	private String qrybudgetType;	//預算別
	private String qrybudgetName;	//預算別名稱
	//private String budgetType;	//預算別
	//private String budgetName;	//預算別名稱
	//private String remark;		//備註
	//private int id;				//主鍵值
	//private String usrid;		//使用者id
	//private Date modDate;		//修改日期
	//private Date createDate;	//新增日期
	
	BudgetRef myDto = new BudgetRef();
	public BudgetRef getMyDto() {
		return myDto;
	}
	public void setMyDto(BudgetRef myDto) {
		this.myDto = myDto;
	}
	public String getQrybudgetName() {
		return qrybudgetName;
	}
	public void setQrybudgetName(String qrybudgetName) {
		qrybudgetName = java.net.URLDecoder.decode(qrybudgetName);
		this.qrybudgetName = qrybudgetName;
	}
	public String getQrybudgetType() {
		return qrybudgetType;
	}
	public void setQrybudgetType(String qrybudgetType) {
		this.qrybudgetType = qrybudgetType;
	}
	public String getBudgetName() {
		return myDto.getBudgetName();
	}
	public String getBudgetType() {
		return myDto.getBudgetType();
	}
	public Date getCreateDate() {
		return myDto.getCreateDate();
	}
	public Set<DebitRef> getDebitRefs() {
		return myDto.getDebitRefs();
	}
	public Integer getId() {
		return myDto.getId();
	}
	public Date getModDate() {
		return myDto.getModDate();
	}
	public String getRemark() {
		return myDto.getRemark();
	}
	public String getUsrid() {
		return myDto.getUsrid();
	}
	public void setBudgetName(String budgetName) {
		myDto.setBudgetName(budgetName);
	}
	public void setBudgetType(String budgetType) {
		myDto.setBudgetType(budgetType);
	}
	public void setCreateDate(Date createDate) {
		myDto.setCreateDate(createDate);
	}
	public void setDebitRefs(Set<DebitRef> debitRefs) {
		myDto.setDebitRefs(debitRefs);
	}
	public void setId(Integer id) {
		myDto.setId(id);
	}
	public void setModDate(Date modDate) {
		myDto.setModDate(modDate);
	}
	public void setRemark(String remark) {
		myDto.setRemark(remark);
	}
	public void setUsrid(String usrid) {
		myDto.setUsrid(usrid);
	}
	
	
}
