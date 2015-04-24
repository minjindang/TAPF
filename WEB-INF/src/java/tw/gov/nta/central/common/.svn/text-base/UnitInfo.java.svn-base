/*
 * 在 2006/2/18 建立
 *
 * TODO 如果要變更這個產生的檔案的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
package tw.gov.nta.central.common;

import gov.dnt.tame.common.LabelValueBean;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import tw.gov.nta.sql.UnitInfoMain;
import tw.gov.nta.sql.dao.UnitInfoMainDAO;

/**
 * @author Jack Du
 *
 * TODO UnitInfo 單位資料物件
 */
public class UnitInfo {

	/**
	 * 依照傳入參數(資料欄位)新增至單位資料檔
	 * @param unitInfoMain
	 * @return 回傳新增後該筆資料主鍵值
	 * @throws HibernateException
	 */
	public static int create(UnitInfoMain unitInfoMain) throws HibernateException
	{
		UnitInfoMainDAO dao = new UnitInfoMainDAO();
		Integer integer = dao.save(unitInfoMain);
		return integer.intValue();
	}

	/**
	 * 依傳入之主鍵刪除對應的單位資料
	 * @param id
	 * @throws HibernateException
	 */
	public static void delete(int id) throws HibernateException
	{
		UnitInfoMainDAO dao = new UnitInfoMainDAO();
		dao.delete(new Integer(id));
	}
	
	/**
	 * 更新單位資料檔
	 * @param unitInfoMain
	 * @throws HibernateException
	 */
	public static void update(UnitInfoMain unitInfoMain) throws HibernateException
	{
		UnitInfoMainDAO dao = new UnitInfoMainDAO();
		dao.saveOrUpdate(unitInfoMain);
	}

	/**
	 * 以主鍵值傳回所對應單位資料
	 * @param id
	 * @return UnitInfoMain
	 * @throws HibernateException
	 */
	public static UnitInfoMain get(int id) throws HibernateException
	{
		UnitInfoMainDAO dao = new UnitInfoMainDAO();
		return dao.get(new Integer(id));
	}
	/**
	 * 以單位代號及名稱查詢出所對應的單位清單
	 * @param unitInfoMain
	 * @return List
	 * @throws HibernateException
	 */
	public static List getByNo(String pUnitId, String pUnit,String tYear) throws HibernateException
	{
		UnitInfoMainDAO dao = new UnitInfoMainDAO();
		Session session = dao.getSession();
        Criteria criteria = session.createCriteria(UnitInfoMain.class);
        if(tYear != null && tYear.trim().length() > 0 ){
        	criteria.createAlias("unitPercentDets","det");
        	criteria.add(Expression.eq("det.tyear",tYear));
        }
        if(pUnit != null && pUnit.trim().length() > 0)
        	criteria.add(Expression.like("unitId", pUnit+"%"));
        if(pUnitId != null && pUnitId.trim().length() != 0)
        	criteria.add(Expression.eq("unitId", pUnitId));
        criteria.addOrder(Order.asc("groupid"));
        criteria.addOrder(Order.asc("seqNo"));
//        criteria.addOrder(Order.asc("seqNo"));
//        criteria.addOrder(Order.asc("unitId"));
        List collection = criteria.list();
        session.close();
        return collection;
	}	
	
	/**
	 * 以單位代號及名稱查詢出所對應的單位清單
	 * @param unitInfoMain
	 * @param pagenum
	 * @return PagedList
	 * @throws HibernateException
	 */
	public static List getByNo(String pUnitId, String pUnit,int pagenum,int PAGE_SIZE,String tYear) throws HibernateException
	{
		//Hibernate.initialize(unitInfoMain);
		UnitInfoMainDAO dao = new UnitInfoMainDAO();
		Session session = dao.getSession();
        Criteria criteria = session.createCriteria(UnitInfoMain.class);
        if(tYear != null && tYear.trim().length() != 0 ){
        	criteria.createAlias("unitPercentDets","det");
        	criteria.add(Expression.eq("det.tyear",tYear));
        }
        criteria.setMaxResults(PAGE_SIZE);
        criteria.setFirstResult(PAGE_SIZE*pagenum);
        
        if(pUnit != null && pUnit.trim().length() != 0)
        	criteria.add(Expression.like("unitId", pUnit+"%"));
        if(pUnitId != null && pUnitId.trim().length() != 0)
        	criteria.add(Expression.eq("unitId", pUnitId));
        criteria.addOrder(Order.asc("groupid"));
        criteria.addOrder(Order.asc("seqNo"));
//        criteria.addOrder(Order.asc("seqNo"));
//        criteria.addOrder(Order.asc("unitId"));
        List collection = criteria.list();
        session.close();
        return collection;
	}

	public static List getByNo(String pUnitId, String pUnit,int pagenum,int PAGE_SIZE) throws HibernateException
	{
        return getByNo(pUnitId,pUnit,pagenum,PAGE_SIZE,null);
	}
	
	/**
	 * 取得CombinText List
	 * @param null
	 * @return List<LabelValueBean>
	 * @throws HibernateException
	 */
	public static List<LabelValueBean> getUnitInfoMain() throws HibernateException
	{
        List<LabelValueBean> labelValueBeanList = new LinkedList<LabelValueBean>();
		UnitInfoMainDAO dao = new UnitInfoMainDAO();
		Session session = dao.getSession();
        Criteria criteria = session.createCriteria(UnitInfoMain.class);
        criteria.addOrder(Order.asc("seqNo"));
        List collection = criteria.list();
        if(collection!=null)
        {
            for (Iterator it = collection.iterator(); it.hasNext();)
            {
            	UnitInfoMain unitInfoMain = (UnitInfoMain) it.next();
            	LabelValueBean labelValueBean = new LabelValueBean();
            	labelValueBean.setLabel(unitInfoMain.getUnitName());
            	labelValueBean.setValuess(unitInfoMain.getUnitId());
            	labelValueBeanList.add(labelValueBean);
            }
        }
        session.close();
        return labelValueBeanList;
	}
	
	/**
	 * 取得CombinText List
	 * @param null
	 * @return List<LabelValueBean>
	 * @throws HibernateException
	 */
	public static List<LabelValueBean> getUnitName() throws HibernateException
	{
        List<LabelValueBean> labelValueBeanList = new LinkedList<LabelValueBean>();
		UnitInfoMainDAO dao = new UnitInfoMainDAO();
		Session session = dao.getSession();
        Criteria criteria = session.createCriteria(UnitInfoMain.class);
        criteria.addOrder(Order.asc("seqNo"));
        List collection = criteria.list();
        if(collection!=null)
        {
            for (Iterator it = collection.iterator(); it.hasNext();)
            {
            	UnitInfoMain unitInfoMain = (UnitInfoMain) it.next();
            	LabelValueBean labelValueBean = new LabelValueBean();
            	labelValueBean.setLabel(unitInfoMain.getUnitName());
            	labelValueBean.setValuess(unitInfoMain.getUnitName());
            	labelValueBeanList.add(labelValueBean);
            }
        }
        session.close();
        return labelValueBeanList;
	}
}