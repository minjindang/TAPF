/* Dima0301Form.java
�{���ت��GDIMA03
�{���N���GDIMA03
�{������G0950224
�{���@�̡GEric.Chen
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
*/
package tw.gov.nta.shortterm.form;

import gov.dnt.tame.common.SupportForm;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Vector;

import tw.gov.nta.debt.common.DebtMainVectors;
import tw.gov.nta.sql.debt.IssueMain;

public class Dima0301Form extends SupportForm {
	private static final long serialVersionUID = 1L;

	private IssueMain issueMain = new IssueMain();
	private Vector<Object> debtMains = new Vector<Object>();
	
	public void setDebtMains(Vector<Object> debtMains)
    {
        this.debtMains = debtMains;
    }
	public Collection getDebtMains()
	{
		return debtMains;
	}
	public void setDebtMains(Collection<Object> debtMains)
	{
		this.debtMains = new Vector<Object>(debtMains);
	}
	public Object getdebtMain(int index)
	{
		if (this.debtMains.size() <= index)
		{
			DebtMainVectors debtMainVectors = new DebtMainVectors();
			setDebtMain(index, debtMainVectors);
			return debtMainVectors;
		}
		else
		{
			Object obj = debtMains.get(index);
			if (obj == null)
			{
				DebtMainVectors debtMainVectors = new DebtMainVectors();
				setDebtMain(index, debtMainVectors);
				return debtMainVectors;
			}
			else
				return obj;
		}
	}
	public void setDebtMain(int index, Object debtMain)
	{
		if (this.debtMains.size() <= index)
			debtMains.setSize(index + 1);
		this.debtMains.set(index, debtMain);
	}

	private String qryAccountYear;		//�~��
	private String qrySerialNo;		//����
	private Integer qryId;		//�W��
	private int page;
	private BigDecimal capitalAmount; //�v�٥���

	public BigDecimal getCapitalAmount() {
		return capitalAmount;
	}
	public void setCapitalAmount(BigDecimal capitalAmount) {
		this.capitalAmount = capitalAmount;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public IssueMain getIssueMain() {
		return issueMain;
	}
	public void setIssueMain(IssueMain issueMain) {
		this.issueMain = issueMain;
	}
	public String getQryAccountYear() {
		return this.qryAccountYear;
	}
	public void setQryAccountYear(String qryAccountYear) {
		this.qryAccountYear = qryAccountYear;
	}
	public String getQrySerialNo() {
		return this.qrySerialNo;
	}
	public void setQrySerialNo(String qrySerialNo) {
		this.qrySerialNo = qrySerialNo;
	}
	public Integer getId() {
		return this.issueMain.getId();
	}
	public void setId(Integer id) {
		this.issueMain.setId(id);
	}
	public Integer getQryId() {
		return qryId;
	}
	public void setQryId(Integer qryId) {
		this.qryId = qryId;
	}
	
}
