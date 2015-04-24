/*
 * 在 2006/2/23 建立
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

import tw.gov.nta.sql.NationRef;
import tw.gov.nta.sql.dao.NationRefDAO;


/**
 * @author EricChen
 *
 * TODO 如果要變更這個產生的類別註解的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
public class NationCodeManager {
	
	public static List query(NationRef nationref) throws HibernateException
	{
		NationRefDAO dao = new NationRefDAO();
        Criteria criteria = dao.getSession().createCriteria(NationRef.class);
        if ((null != nationref.getNationNo()) && (!"null".equals(nationref.getNationNo())) && (!"".equals(nationref.getNationNo())))
            criteria.add(Expression.like("nationNo", nationref.getNationNo()+"%"));
        if ((null != nationref.getContinentNo()) && (!"null".equals(nationref.getContinentNo())) && (!"".equals(nationref.getContinentNo())))
            criteria.add(Expression.like("continentNo", nationref.getContinentNo()+"%"));
        if ((null != nationref.getNationCname()) && (!"null".equals(nationref.getNationCname())) && (!"".equals(nationref.getNationCname())))	
            criteria.add(Expression.like("nationCname", nationref.getNationCname()+"%"));
        if ((null != nationref.getNationEname()) && (!"null".equals(nationref.getNationEname())) && (!"".equals(nationref.getNationEname())))
            criteria.add(Expression.like("nationEname", nationref.getNationEname()+"%"));
        criteria.addOrder(Order.asc("nationNo"));
        return criteria.list();
	}
	
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws HibernateException
	 */
	public static List isModify(NationRef nationref) throws HibernateException
	{
		NationRefDAO dao = new NationRefDAO();
        Criteria criteria = dao.getSession().createCriteria(NationRef.class);
        if ((null != nationref.getNationNo()) && (!"null".equals(nationref.getNationNo())) && (!"".equals(nationref.getNationNo())))
            criteria.add(Expression.like("nationNo", nationref.getNationNo()));
        if ((null != nationref.getContinentNo()) && (!"null".equals(nationref.getContinentNo())) && (!"".equals(nationref.getContinentNo())))
            criteria.add(Expression.like("continentNo", nationref.getContinentNo()));
        if ((null != nationref.getNationCname()) && (!"null".equals(nationref.getNationCname())) && (!"".equals(nationref.getNationCname())))	
            criteria.add(Expression.like("nationCname", nationref.getNationCname()));
        if ((null != nationref.getNationEname()) && (!"null".equals(nationref.getNationEname())) && (!"".equals(nationref.getNationEname())))
            criteria.add(Expression.like("nationEname", nationref.getNationEname()));
        criteria.addOrder(Order.asc("nationNo"));
        return criteria.list();
	}		
	
	/*
	 * TODO 查詢單筆
	 */
	public static NationRef get(int id) throws HibernateException {
		
		NationRefDAO dao = new NationRefDAO();
		return dao.get(new Integer(id));
	}
	
	/*
	 * TODO 更新
	 */
	public static void update(NationRef  nationRef ) throws HibernateException {
		NationRefDAO dao = new NationRefDAO();
		dao.saveOrUpdate(nationRef);
		
	}
	
	/*
	 * TODO 刪除
	 */
	public static void delete(int id) throws HibernateException {
		
		NationRefDAO dao = new NationRefDAO();
		dao.delete(new Integer(id));

	}
	
	/*
	 * 
	 * TODO 新增 
	 *  
	 */
	public static void  create(NationRef nationRef) throws HibernateException
	{
		NationRefDAO dao = new NationRefDAO();
		dao.save(nationRef);
	}
	//國別複合式下拉 by Andrew Sung 
	public static List<LabelValueBean> getNationInfo() throws HibernateException
	{
        List<LabelValueBean> labelValueBeanList = new LinkedList<LabelValueBean>();
        NationRefDAO dao = new NationRefDAO();
		Session session = dao.getSession();
        Criteria criteria = session.createCriteria(NationRef.class);
        List collection = criteria.list();
        if(collection!=null)
        {
            for (Iterator it = collection.iterator(); it.hasNext();)
            {
            	NationRef nationRef = (NationRef) it.next();
            	LabelValueBean labelValueBean = new LabelValueBean();
            	labelValueBean.setLabel(nationRef.getNationCname());
            	labelValueBean.setValuess(Integer.toString(nationRef.getId()));
            	labelValueBeanList.add(labelValueBean);
            }
        }
        session.close();
        return labelValueBeanList;
	}

}
