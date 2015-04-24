package tw.gov.nta.account.form;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;

import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.dao.IssueMainDAO;

import gov.dnt.tame.common.LabelValueBean;
import gov.dnt.tame.common.SupportForm;

public class Ebrc0301Form extends SupportForm {
	private static final long serialVersionUID = 1L;

	
	private Integer issueId;
	private String debtName;
	private Date queryDate;
	public String getDebtName() {
		return debtName;
	}
	public void setDebtName(String debtName) {
		this.debtName = debtName;
	}
	public Integer getIssueId() {
		return issueId;
	}
	public void setIssueId(Integer issueId) {
		this.issueId = issueId;
	}
	public Date getQueryDate() {
		return queryDate;
	}
	public void setQueryDate(Date queryDate) {
		this.queryDate = queryDate;
	}
	public List getDebtNameList()
	{
		List myList = new LinkedList();
        IssueMainDAO dao = new IssueMainDAO();
		Session session = dao.getSession();
        Criteria criteria = session.createCriteria(IssueMain.class);
        criteria.add(Expression.eq("debtType","B"));
        List collection = criteria.list();
        if(collection!=null)
        {
            for (Iterator it = collection.iterator(); it.hasNext();)
            {
            	IssueMain issueMain = (IssueMain) it.next();
            	LabelValueBean labelValueBean = new LabelValueBean();
            	labelValueBean.setLabel(issueMain.getDebtName());
            	labelValueBean.setValuess(issueMain.getId().toString());
            	myList.add(labelValueBean);
            }
        }
        session.close();
        return myList;
	}
	
}
