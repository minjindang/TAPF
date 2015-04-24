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
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import tw.gov.nta.sql.BudgetRef;
import tw.gov.nta.sql.dao.BudgetRefDAO;

/**
 * @author EricChen
 *
 * TODO 如果要變更這個產生的類別註解的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
public class BudgetCodeManager {
	
	public static List query(BudgetRef budgetref) throws HibernateException
	{	
		BudgetRefDAO dao = new BudgetRefDAO();
        Criteria criteria = dao.getSession().createCriteria(BudgetRef.class);
        if ((null != budgetref.getBudgetName()) && (!"null".equals(budgetref.getBudgetName())) && (!"".equals(budgetref.getBudgetName())))
        {	
            criteria.add(Expression.like("budgetName", budgetref.getBudgetName()+"%"));
        }	
        if ((null != budgetref.getBudgetType()) && (!"null".equals(budgetref.getBudgetType())) && (!"".equals(budgetref.getBudgetType())))
        {
            criteria.add(Expression.like("budgetType", budgetref.getBudgetType()+"%"));
        }	
        
        
        criteria.addOrder(Order.asc("budgetType"));
        return criteria.list();	
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws HibernateException
	 */
	public static List isModify(BudgetRef budgetref) throws HibernateException
	{	
		BudgetRefDAO dao = new BudgetRefDAO();
        Criteria criteria = dao.getSession().createCriteria(BudgetRef.class);
        if ((null != budgetref.getBudgetName()) && (!"null".equals(budgetref.getBudgetName())) && (!"".equals(budgetref.getBudgetName())))
        {	
            criteria.add(Expression.like("budgetName", budgetref.getBudgetName()));
        }	
        if ((null != budgetref.getBudgetType()) && (!"null".equals(budgetref.getBudgetType())) && (!"".equals(budgetref.getBudgetType())))
        {
            criteria.add(Expression.like("budgetType", budgetref.getBudgetType()));
        }	
        criteria.addOrder(Order.asc("budgetType"));
        return criteria.list();	
	}
	
	/*
	 * TODO 查詢單筆
	 */
	public static BudgetRef get(Integer id) throws HibernateException {
		BudgetRefDAO dao = new BudgetRefDAO();
		return dao.get(id);
	}
	
	/*
	 * TODO 更新
	 */
	public static void update(BudgetRef  budgetRef) throws HibernateException {

		BudgetRefDAO dao = new BudgetRefDAO();
		dao.saveOrUpdate(budgetRef);
	}
	
	/*
	 * TODO 刪除
	 */
	public static void delete(int id) throws HibernateException {
		BudgetRefDAO dao = new BudgetRefDAO();
		dao.delete(new Integer(id));
	}
	
	/*
	 * 
	 * TODO 新增 
	 *  
	 */
	public static void  create(BudgetRef budgetRef) throws HibernateException
	{
		BudgetRefDAO dao = new BudgetRefDAO();
		dao.save(budgetRef);
	}
	
    public static List<LabelValueBean> getBudgetInfo() throws HibernateException
	{
        List<LabelValueBean> labelValueBeanList = new LinkedList<LabelValueBean>();
        BudgetRefDAO dao = new BudgetRefDAO();
		Session session = dao.getSession();
        Criteria criteria = session.createCriteria(BudgetRef.class);
        criteria.setFetchMode("debitRefs",FetchMode.SELECT);

        List collection = criteria.list();
        if(collection!=null)
        {
            for (Iterator it = collection.iterator(); it.hasNext();)
            {
            	BudgetRef budgetRef = (BudgetRef) it.next();
            	LabelValueBean labelValueBean = new LabelValueBean();
            	labelValueBean.setLabel(budgetRef.getBudgetName());
            	labelValueBean.setValuess(String.valueOf(budgetRef.getId()));
            	labelValueBeanList.add(labelValueBean);
            }
        }
        session.close();
        return labelValueBeanList;
	}
    
    public static String findBudgetName(int pId){
    	BudgetRef tBudetRef = new BudgetRefDAO().get(new Integer(pId));
    	if(tBudetRef == null)
    		return "";
    	else
    		return tBudetRef.getBudgetName();
    }
    
    public static List<LabelValueBean> getBudgetType() throws HibernateException
	{
        List<LabelValueBean> labelValueBeanList = new LinkedList<LabelValueBean>();
        BudgetRefDAO dao = new BudgetRefDAO();
		Session session = dao.getSession();
        Criteria criteria = session.createCriteria(BudgetRef.class);
        List collection = criteria.list();
        if(collection!=null)
        {
            for (Iterator it = collection.iterator(); it.hasNext();)
            {
            	BudgetRef budgetRef = (BudgetRef) it.next();
            	LabelValueBean labelValueBean = new LabelValueBean();
            	labelValueBean.setLabel(budgetRef.getBudgetName());
            	labelValueBean.setValuess(budgetRef.getBudgetType());
            	labelValueBeanList.add(labelValueBean);
            }
        }
        session.close();
        return labelValueBeanList;
	}
}
