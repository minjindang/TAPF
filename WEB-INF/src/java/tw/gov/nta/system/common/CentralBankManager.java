package tw.gov.nta.system.common;

import gov.dnt.tame.common.LabelValueBean;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import tw.gov.nta.sql.dao.DebitRefDAO;
import tw.gov.nta.sql.debt.BankRef;
import tw.gov.nta.sql.debt.CentralBankRef;
import tw.gov.nta.sql.debt.dao.BankRefDAO;
import tw.gov.nta.sql.debt.dao.CentralBankRefDAO;

public class CentralBankManager {
	public static CentralBankRef get(int id) throws HibernateException
	{
		CentralBankRefDAO dao = new CentralBankRefDAO();
		return dao.get( new Integer(id) );
	}
	public static List<LabelValueBean> getCentralBankInfo() throws HibernateException
	{
        List<LabelValueBean> labelValueBeanList = new LinkedList<LabelValueBean>();
        CentralBankRefDAO dao = new CentralBankRefDAO();
		Session session = dao.getSession();
        Criteria criteria = session.createCriteria(CentralBankRef.class);
//        criteria.add(Expression.eq("belongToBankId",0));
//        criteria.addOrder(Order.asc("bankCode"));
        List collection = criteria.list();
        if(collection!=null)
        {
            for (Iterator it = collection.iterator(); it.hasNext();)
            {
            	CentralBankRef centralBankRef = (CentralBankRef) it.next();
            	LabelValueBean labelValueBean = new LabelValueBean();
            	labelValueBean.setLabel(centralBankRef.getBankName());
            	labelValueBean.setValuess((centralBankRef.getId()).toString());
            	labelValueBeanList.add(labelValueBean);
            }
        }
        session.close();
        return labelValueBeanList;
	}
}
