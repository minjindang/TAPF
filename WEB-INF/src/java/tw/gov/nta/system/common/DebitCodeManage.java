/*
 * 在 2006/2/22 建立
 *
 * TODO 如果要變更這個產生的檔案的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
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

import tw.gov.nta.sql.BudgetRef;
import tw.gov.nta.sql.DebitRef;
import tw.gov.nta.sql.dao.DebitRefDAO;

/**
 * @author AndrewSung
 */
public class DebitCodeManage
{
    public static DebitRef get(Integer id) throws HibernateException
    {	
    	DebitRefDAO dao = new DebitRefDAO();
		return dao.get(id);
    }

    public static int create(DebitRef debitRef) throws HibernateException
    {
    	DebitRefDAO dao = new DebitRefDAO();
    	Integer pk = dao.save(debitRef);
    	return pk.intValue();
    }

    public static boolean update(DebitRef debitRef) throws HibernateException
    {
    	DebitRefDAO dao = new DebitRefDAO();
    	dao.saveOrUpdate(debitRef);
        return true;
    }
    
    public static void delete(DebitRef debitRef) throws HibernateException
    {
    	DebitRefDAO dao = new DebitRefDAO();
    	dao.delete(debitRef.getId());
    }

    public static List query(DebitRef debitRef) throws HibernateException
    {
    	DebitRefDAO dao = new DebitRefDAO();
        Criteria criteria = dao.getSession().createCriteria(DebitRef.class);
        if ((null != debitRef.getDebitType()) && (!"".equals(debitRef.getDebitType())))
            criteria.add(Expression.like("debitType", debitRef.getDebitType()+"%"));
        if ((null != debitRef.getDebitName()) && (!"".equals(debitRef.getDebitName())))
            criteria.add(Expression.like("debitName", debitRef.getDebitName()+"%"));
        if ((debitRef.getBudgetCode().getId()).intValue()!= 0)
            criteria.add(Expression.eq("budgetCode", debitRef.getBudgetCode()));
        criteria.addOrder(Order.asc("debitType"));
        return criteria.list();
    }
    public static List<LabelValueBean> getDebitInfo() throws HibernateException
	{
        List<LabelValueBean> labelValueBeanList = new LinkedList<LabelValueBean>();
        DebitRefDAO dao = new DebitRefDAO();
		Session session = dao.getSession();
        Criteria criteria = session.createCriteria(DebitRef.class);
        List collection = criteria.list();
        if(collection!=null)
        {
            for (Iterator it = collection.iterator(); it.hasNext();)
            {
            	DebitRef debitRef = (DebitRef) it.next();
            	LabelValueBean labelValueBean = new LabelValueBean();
            	labelValueBean.setLabel(debitRef.getDebitName());
            	labelValueBean.setValuess((debitRef.getId()).toString());
            	labelValueBeanList.add(labelValueBean);
            }
        }
        session.close();
        return labelValueBeanList;
	}
    
    public static String findDebitName(int pId){
    	DebitRef tDebitRef = new DebitRefDAO().get(new Integer(pId));
    	if(tDebitRef == null)
    		return "";
    	else
    		return tDebitRef.getDebitName();
    }
    @SuppressWarnings("unused") 
    /**
     * 以預算別帶出債務別
     * @return
     * @throws HibernateException
     */
    public static List<LabelValueBean> getDebitInfo(int budgetCode) throws HibernateException{
    	return getDebitInfo(new Integer(budgetCode));
    }
    public static List<LabelValueBean> getDebitInfo(Integer budgetCode) throws HibernateException
	{
        List<LabelValueBean> labelValueBeanList = new LinkedList<LabelValueBean>();
        BudgetRef tBudgetRef = BudgetCodeManager.get(budgetCode);
        DebitRefDAO dao = new DebitRefDAO();
		Session session = dao.getSession();
        Criteria criteria = session.createCriteria(DebitRef.class);
        criteria.add(Expression.eq("budgetCode",tBudgetRef));
        List collection = criteria.list();
        if(collection!=null)
        {
            for (Iterator it = collection.iterator(); it.hasNext();)
            {
            	DebitRef debitRef = (DebitRef) it.next();
            	LabelValueBean labelValueBean = new LabelValueBean();
            	labelValueBean.setLabel(debitRef.getDebitName());
            	labelValueBean.setValuess((debitRef.getId()).toString());
            	labelValueBeanList.add(labelValueBean);
            }
        }
        session.close();
        return labelValueBeanList;
	}
}
