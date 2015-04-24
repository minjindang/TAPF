/**
 * @author AndrewSung
 * @date 2006/3/9
 */

package tw.gov.nta.shortterm.action;

import gov.dnt.tame.common.LabelValueBean;

import java.sql.Connection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;

import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.dao.IssueMainDAO;
public  class DPMA0106
{
	public static List<LabelValueBean> getDebtName(String debtType) throws HibernateException
	{
        List<LabelValueBean> labelValueBeanList = new LinkedList<LabelValueBean>();
        IssueMainDAO dao = new IssueMainDAO();
		Session session = dao.getSession();
        Criteria criteria = session.createCriteria(IssueMain.class);
        criteria.add(Expression.eq("debtType", debtType));
        List collection = criteria.list();
        if(collection!=null)
        {
            for (Iterator it = collection.iterator(); it.hasNext();)
            {
            	IssueMain issueMain = (IssueMain) it.next();
            	LabelValueBean labelValueBean = new LabelValueBean();
            	labelValueBean.setLabel(issueMain.getDebtName());
            	labelValueBean.setValuess((issueMain.getId()).toString());
            	labelValueBeanList.add(labelValueBean);
            }
        }
        session.close();
        return labelValueBeanList;
	}
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception
	{

	}
}
