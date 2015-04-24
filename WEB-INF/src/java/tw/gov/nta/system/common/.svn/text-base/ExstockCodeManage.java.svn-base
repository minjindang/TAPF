/*
 * 在 2006/2/23 建立
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

import tw.gov.nta.sql.ExstockRef;
import tw.gov.nta.sql.dao.ExstockRefDAO;


/**
 * @author AndrewSung
 * ExstockCodeManage.java
 * 交換標的代碼物件
 * 提供系統操作交換標的代碼資料(新增、刪除、修改、查詢)
 */
public class ExstockCodeManage
{
	/**
	 * 將交換標的代碼新增於資料檔中
     * @param exstockRef
     * @return null
     * @process 傳入交換標的代碼資料(ExstockRef)並將資料儲存至資料檔
     */ 
    public static void create(ExstockRef exstockRef) throws HibernateException
    {
        ExstockRefDAO dao = new ExstockRefDAO();
    	dao.save(exstockRef);
    }
    
    /**
     * 檢核交換標的代碼是否重複
     * @param exstockRef
     * @return
     * @process 以傳入交換標的代碼資料(ExstockRef)找出相對應的交換標的代碼資料
     */ 
    public static Boolean isModify(ExstockRef exstockRef)throws HibernateException
    {
    	ExstockRefDAO dao = new ExstockRefDAO();
    	Criteria criteria = dao.getSession().createCriteria(ExstockRef.class);
        if ((null != exstockRef.getStockId()) && (!"".equals(exstockRef.getStockId())))
            criteria.add(Expression.eq("stockId", exstockRef.getStockId()));
        else return false;
        if(criteria.list().size()==0)
        	return true;
		return false;
    }

    /**
     * 以交換標的代碼(交換標的代碼、銀行名稱)找出相符的交換標的資料
     * @param exstockRef
     * @return exstockRef[]
     * @process 以傳入交換標的代碼資料(ExstockRef)找出相對應的交換標的代碼資料
     */ 
    public static List query(ExstockRef exstockRef) throws HibernateException
    {
      
    	ExstockRefDAO dao = new ExstockRefDAO();
        Criteria criteria = dao.getSession().createCriteria(ExstockRef.class);
        if ((null != exstockRef.getStockId()) && (!"".equals(exstockRef.getStockId())))
            criteria.add(Expression.like("stockId", exstockRef.getStockId()+"%"));
        if ((null != exstockRef.getStockName()) && (!"".equals(exstockRef.getStockName())))
            criteria.add(Expression.like("stockName", exstockRef.getStockName()+"%"));
        criteria.addOrder(Order.asc("stockId"));
        return criteria.list();
    }

    /**
     * 依照主鍵值找出交換標的代碼資料
     * @param id
     * @return exstockRef
     * @process 以資料主鍵值找出所對應的交換標的代碼資料
     */ 
    public static ExstockRef get(int kind) throws HibernateException
    {	
    	ExstockRefDAO dao = new ExstockRefDAO();
		return dao.get(new Integer(kind));
    }

    /**
     * 將交換標的代碼資料刪除
     * @param id
     * @return null
     * @process 以傳入之主鍵值找出對應的交換標的代碼資料並刪除
     */ 
    public static void delete(Integer id) throws HibernateException
    {
    	ExstockRefDAO dao = new ExstockRefDAO();
    	dao.delete(id);
    }

    /**
     * 將交換標的代碼更新相關資料欄位於資料檔中
     * @param id,exstockRef
     * @return true or false
     * @process 更新所對應主鍵值之交換標的代碼資料,並以傳入之exstockRef更新相關資料
     */ 
    public static boolean update(ExstockRef exstockRef) throws HibernateException
    {
        ExstockRefDAO dao = new ExstockRefDAO();
    	dao.saveOrUpdate(exstockRef);
        return true;
    }
    
	public static List<LabelValueBean> getExstockInfo() throws HibernateException
	{
        List<LabelValueBean> labelValueBeanList = new LinkedList<LabelValueBean>();
        ExstockRefDAO tExstockRefDAOdao = new ExstockRefDAO();
		Session session = tExstockRefDAOdao.getSession();
        Criteria criteria = session.createCriteria(ExstockRef.class);
        List collection = criteria.list();
        if(collection!=null)
        {
        	LabelValueBean labelValueBean = null;
            for (Iterator it = collection.iterator(); it.hasNext();)
            {
            	ExstockRef tStockRef = (ExstockRef) it.next();
            	labelValueBean = new LabelValueBean();
            	labelValueBean.setLabel(tStockRef.getStockName());
            	labelValueBean.setValuess(tStockRef.getId().toString());
            	labelValueBeanList.add(labelValueBean);
            }
        }
        session.close();
        return labelValueBeanList;
	}
}
