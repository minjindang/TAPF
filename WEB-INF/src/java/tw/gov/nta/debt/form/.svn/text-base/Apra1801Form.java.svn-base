/**
 * @author AndrewSung
 * @date 2006/3/10
 */

package tw.gov.nta.debt.form;

import gov.dnt.tame.common.SupportForm;
import gov.dnt.tame.util.ListToolManager;

import java.util.Date;
import java.util.List;
public class Apra1801Form extends SupportForm
{
	private static final long serialVersionUID = 1L;
	private Date closeDate;
	private String issueSerial;
	private Integer issueId;
	private String debtName;
	public String getDebtName() {
		return debtName;
	}
	public void setDebtName(String debtName) {
		this.debtName = debtName;
	}
	public Date getCloseDate()
	{
		return closeDate;
	}
	public void setCloseDate(Date closeDate)
	{
		this.closeDate = closeDate;
	}
	public List getDebtNameList()
	{
//		List myList = new LinkedList();
//        IssueMainDAO dao = new IssueMainDAO();
//		Session session = dao.getSession();
//		Query query = session.createQuery("select debtName , issueSerial from IssueMain where debtType = 'A'");
//		List collection = query.list();
////        Criteria criteria = session.createCriteria(IssueMain.class);
////        criteria.add(Expression.eq("debtType","A"));
////        List collection = criteria.list();
//        if(collection!=null)
//        {
//            for (Iterator it = collection.iterator(); it.hasNext();)
//            {
//            	//IssueMain issueMain = (IssueMain) it.next();
//            	Object[] obj = (Object[])it.next();
//            	LabelValueBean labelValueBean = new LabelValueBean();
////            	labelValueBean.setLabel(issueMain.getDebtName());
////            	labelValueBean.setValuess(issueMain.getIssueSerial());
//            	labelValueBean.setLabel((String)obj[0]);
//            	labelValueBean.setValuess((String)obj[1]);
//            	myList.add(labelValueBean);
//            }
//        }
//        session.close();
        return ListToolManager.getList("select id , debtName from IssueMain where debtType = 'A' and issueKind = '1' order by  accountYear asc ,debtName ");
	}
	public String getIssueSerial() {
		return issueSerial;
	}
	public void setIssueSerial(String issueSerial) {
		this.issueSerial = issueSerial;
	}
	public Integer getIssueId() {
		return issueId;
	}
	public void setIssueId(Integer issueId) {
		this.issueId = issueId;
	}
}
