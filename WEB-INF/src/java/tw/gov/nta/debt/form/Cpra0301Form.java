package tw.gov.nta.debt.form;

import gov.dnt.tame.common.LabelValueBean;
import gov.dnt.tame.common.SupportForm;
import gov.dnt.tame.util.DateUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import tw.gov.nta.sql.debt.dao.IssueMainDAO;
import tw.gov.nta.sql.debt.dao.PaymentMainDAO;

public class Cpra0301Form extends SupportForm {
	private static final long serialVersionUID = 1L;

	public Cpra0301Form() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String issueSerial;
	private Date payDate;
	private String note;
	private Integer issueId;
	IssueMainDAO myIssue = new IssueMainDAO();
	PaymentMainDAO myPay = new PaymentMainDAO();
	public String getIssueSerial() {
		return issueSerial;
	}
	public void setIssueSerial(String issueSerial) {
		this.issueSerial = issueSerial;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public List getPayDateList()
	{
		List<LabelValueBean> datelist = new LinkedList();
		if(null != getIssueId() && 0 != getIssueId())
		{	
			StringBuffer str1 = new StringBuffer("select paymentmain.repayDate from PaymentMain paymentmain where paymentmain.issueId = ");
			str1.append(getIssueId());
			str1.append(" group by paymentmain.repayDate ");
			Session session = new PaymentMainDAO().createNewSession();
			Query query = session.createQuery(str1.toString());
			List list = query.list();
			if(null !=list && 0!=list.size())
			{
				for(Iterator it = list.iterator();it.hasNext();)
				{
					Object myPMain = (Object)it.next();
					LabelValueBean myBean = new LabelValueBean();
					myBean.setLabel(DateUtil.date2ROCStr((Date)myPMain));
					myBean.setValuess(DateUtil.date2ROCStr((Date)myPMain));
					datelist.add(myBean);
				}
	
			}
		}		
		return datelist;
	}
	public List getSerialNoList()
	{
		ArrayList<LabelValueBean> tList = new ArrayList<LabelValueBean>();
        Session session = new IssueMainDAO().getSession();
        Query query = session.createQuery("select id , issueSerial from IssueMain where debtType = 'C' order by issueSerial asc ");
        List collection = query.list();
        if(collection!=null && collection.size() != 0)
        {
        	LabelValueBean labelValueBean = null;
            for (Iterator it = collection.iterator(); it.hasNext();)
            {
            	Object[] tIssueMainDto = (Object[]) it.next();
            	labelValueBean = new LabelValueBean();
            	labelValueBean.setLabel((String)tIssueMainDto[1]);
            	labelValueBean.setValuess(((Integer)tIssueMainDto[0]).toString());
            	tList.add(labelValueBean);
            }
        }
        session.close();
		return tList;
	}
	public Integer getIssueId() {
		return issueId;
	}
	public void setIssueId(Integer issueId) {
		this.issueId = issueId;
	}
}
