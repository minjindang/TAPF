/**
 * @author Andrew Sung
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

import tw.gov.nta.sql.dao.DebitRefDAO;
import tw.gov.nta.sql.debt.BankRef;
import tw.gov.nta.sql.debt.Bankf;
import tw.gov.nta.sql.debt.dao.BankRefDAO;

public class BankCodeManage {
	public String getBankNewName(BankRef bnakRef){
		String newName = bnakRef.getBankName();
		if(bnakRef.getBelongToBankId() != 0 )
			 newName = get(bnakRef.getBelongToBankId()).getBankName();
		return newName;
		
	}
	/**
	 * 以主鍵值找出對應的銀行代碼資料檢核銀行代碼是否重複
	 * @param id
	 * @return boolean
	 * @throws HibernateException
	 */
	public static boolean isModify(BankRef bankRef) throws HibernateException
	{
//		BankRefDAO dao = new BankRefDAO();
//		Session session = dao.getSession();
//        Criteria criteria = session.createCriteria(BankRef.class);
//        if ((null != bankRef.getBankCode()) && (!"".equals(bankRef.getBankCode())))
//            criteria.add(Expression.eq("bankCode", bankRef.getBankCode()));
//        if(criteria.list().size()==0)
//        	return true;
//		return false;
		return true;
	}

	/**
	 * 以主鍵值找出對應的銀行代碼資料
	 * @param id
	 * @return BankRef
	 * @throws HibernateException
	 */
	public static BankRef get(int id) throws HibernateException
	{
		BankRefDAO dao = new BankRefDAO();
		return dao.get( new Integer(id) );
	}
	
	/**
	 * 傳入銀行代碼及銀行名稱新增至資料檔中
	 * @param bankRef
	 * @return int
	 * @throws HibernateException
	 */
	public static int create(BankRef bankRef) throws HibernateException
	{
		BankRefDAO dao = new BankRefDAO();
		Integer integer = dao.save(bankRef);
		return integer.intValue();
	}
	
	/**
	 * 傳入銀行代碼及銀行名稱更新資料
	 * @param bankRef
	 * @throws HibernateException
	 */
	public static void update(BankRef bankRef) throws HibernateException
	{
		BankRefDAO dao = new BankRefDAO();
		dao.saveOrUpdate(bankRef);		
	}
	
	/**
	 * 刪除對應的銀行代碼資料
	 * @param id
	 * @throws HibernateException
	 */
	public static void delete(int id) throws HibernateException
	{
		BankRefDAO dao = new BankRefDAO();
		dao.delete( new Integer(id) );
	}

	/**
	 * 依查詢資料欄位找出對應的銀行代碼資料
	 * @param bankRef
	 * @return List
	 * @throws HibernateException
	 */
	@SuppressWarnings("unchecked")
	public static List<BankRef> query(BankRef bankRef) throws HibernateException
	{
		BankRefDAO dao = new BankRefDAO();
		Session session = dao.getSession();
        Criteria criteria = session.createCriteria(BankRef.class);
        if ((null != bankRef.getBankCode()) && (!"".equals(bankRef.getBankCode())))
            criteria.add(Expression.like("bankCode", bankRef.getBankCode()+"%"));
        if ((null != bankRef.getBankName()) && (!"".equals(bankRef.getBankName())))
            criteria.add(Expression.like("bankName", bankRef.getBankName()+"%"));
        if ((null != bankRef.getShortBankName()) && (!"".equals(bankRef.getShortBankName())))
            criteria.add(Expression.like("shortBankName", bankRef.getShortBankName()+"%"));
        if (!bankRef.getBelongToBankId().equals(0))
            criteria.add(Expression.like("belongToBankId", bankRef.getBelongToBankId()+"%"));
        if (!bankRef.getCombinationBankId().equals(0))
            criteria.add(Expression.like("combinationBankId", bankRef.getCombinationBankId()+"%"));
        criteria.addOrder(Order.asc("bankCode"));
        List<BankRef> collection = criteria.list();
        session.close();
        return collection;	
	}

	/** by eric 取bankname和bankcode
	 * 取得CombinText List
	 * @param null
	 * @return List<LabelValueBean>
	 * @throws HibernateException
	 */
	public static List<LabelValueBean> getBankCode() throws HibernateException
	{
        List<LabelValueBean> labelValueBeanList = new LinkedList<LabelValueBean>();
		BankRefDAO dao = new BankRefDAO();
		Session session = dao.getSession();
        Criteria criteria = session.createCriteria(BankRef.class);
        criteria.add(Expression.eq("belongToBankId",0));
        criteria.addOrder(Order.asc("bankCode"));
        List collection = criteria.list();
        if(collection!=null)
        {
            for (Iterator it = collection.iterator(); it.hasNext();)
            {
            	BankRef bankRef = (BankRef) it.next();
            	LabelValueBean labelValueBean = new LabelValueBean();
            	labelValueBean.setLabel(bankRef.getBankName());
            	labelValueBean.setValuess(String.valueOf(bankRef.getId()));
            	labelValueBeanList.add(labelValueBean);
            }
        }
        session.close();
        return labelValueBeanList;
	}

	public static List<LabelValueBean> getBankCodeDIM() throws HibernateException
	{
        List<LabelValueBean> labelValueBeanList = new LinkedList<LabelValueBean>();
		BankRefDAO dao = new BankRefDAO();
		Session session = dao.getSession();
		StringBuffer hql = new StringBuffer();
//		hql.append("select bank from BankRef bank where bank.belongToBankId = 0  ");
//		List collection = (List) session.createQuery(hql.toString());
        Criteria criteria = session.createCriteria(BankRef.class);
        criteria.addOrder(Order.asc("bankCode"));
        List collection = criteria.list();
        if(collection!=null)
        {
            for (Iterator it = collection.iterator(); it.hasNext();)
            {
            	BankRef bankRef = (BankRef) it.next();
            	LabelValueBean labelValueBean = new LabelValueBean();
            	labelValueBean.setLabel(bankRef.getBankName());
            	labelValueBean.setValuess(bankRef.getBankCode());
            	labelValueBeanList.add(labelValueBean);
            }
        }
        session.close();
        return labelValueBeanList;
	}
	public static List<LabelValueBean> getBankF() throws HibernateException
	{
        List<LabelValueBean> labelValueBeanList = new LinkedList<LabelValueBean>();
        DebitRefDAO dao = new DebitRefDAO();
		Session session = dao.getSession();
        Criteria criteria = session.createCriteria(Bankf.class);
        List collection = criteria.list();
        if(collection!=null)
        {
            for (Iterator it = collection.iterator(); it.hasNext();)
            {
            	Bankf bankf = (Bankf) it.next();
            	LabelValueBean labelValueBean = new LabelValueBean();
            	labelValueBean.setLabel(bankf.getBankFname());
            	labelValueBean.setValuess((bankf.getBankCode()).toString());
            	labelValueBeanList.add(labelValueBean);
            }
        }
        session.close();
        return labelValueBeanList;
	}

	public static List<LabelValueBean> getBankInfo() throws HibernateException
	{
        List<LabelValueBean> labelValueBeanList = new LinkedList<LabelValueBean>();
        DebitRefDAO dao = new DebitRefDAO();
		Session session = dao.getSession();
        Criteria criteria = session.createCriteria(BankRef.class);
        criteria.add(Expression.eq("belongToBankId",0));
        criteria.addOrder(Order.asc("bankCode"));
        List collection = criteria.list();
        if(collection!=null)
        {
            for (Iterator it = collection.iterator(); it.hasNext();)
            {
            	BankRef BankRef = (BankRef) it.next();
            	LabelValueBean labelValueBean = new LabelValueBean();
            	labelValueBean.setLabel(BankRef.getBankName());
            	labelValueBean.setValuess((BankRef.getId()).toString());
            	labelValueBeanList.add(labelValueBean);
            }
        }
        session.close();
        return labelValueBeanList;
	}	
}