/**
*
* @author Andrew Sung
* @createDate 2006/5/17
*/
package tw.gov.nta.shortterm.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

import java.sql.Connection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.hibernate.Query;
import org.hibernate.Session;

import tw.gov.nta.shortterm.form.Dpma0101Form;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.dao.IssueMainDAO;
public class DPMA0107 extends DefaultAction {

	@Override
	@SuppressWarnings("unused")
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		 Dpma0101Form myForm = (Dpma0101Form)form;
		 Session session = new IssueMainDAO().createNewSession();
		 StringBuffer hqlStr = new StringBuffer("select issue from IssueMain issue where id = "+myForm.getId());
		 Query query = session.createQuery(hqlStr.toString());
//		 List collection = query.list();
		 IssueMain issue = (IssueMain) query.list().get(0);
		 Date issueDate = issue.getIssueDate();
		 Date dueDate = issue.getDueDate();
//		 if(collection!=null && !collection.isEmpty()){
//			 Object[] obj = (Object[])collection.iterator().next();
//			 issueDate = (Date)obj[0];
//			 dueDate = (Date)obj[1];
//		 }
		 Date payDate = myForm.getRepayDate();
		 myForm.setDueDate(issue.getDueDate());
		 if(payDate.equals(dueDate))
			 myForm.setPayType("0 正常還款");
		 else if(payDate.after(dueDate))
			 myForm.setPayType("1 延後還款");
		 else if(payDate.before(dueDate))
			 myForm.setPayType("2 提前還款");
		 myForm.setRepayDays((DateUtil.getDays(issueDate,payDate)).toString());
		 
		 session.clear();
		 session.close();
	}

}
