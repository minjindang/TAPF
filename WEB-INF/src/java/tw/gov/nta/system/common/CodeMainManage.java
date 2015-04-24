package tw.gov.nta.system.common;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import tw.gov.nta.sql.CodeMain;
import tw.gov.nta.sql.dao.CodeMainDAO;

public class CodeMainManage 
{
	public static CodeMain get(Integer id) throws HibernateException
    {	
		//依照主鍵值找出代碼類別資料
    	CodeMainDAO dao = new CodeMainDAO();
		return dao.get(id);
    }

    public static void create(CodeMain codeMain) throws HibernateException
    {
    	//將代碼新增於資料檔中
    	CodeMainDAO dao = new CodeMainDAO();
    	//傳入代碼類別資料codeMain並將資料儲存至資料檔
    	dao.save(codeMain);
    }

    public static boolean update(Integer id,CodeMain codeMain) throws HibernateException
    {
    	//將代碼類別更新相關資料欄位於資料檔中
    	CodeMainDAO dao = new CodeMainDAO();
    	//更新所對應，並以傳路之CodeMain更新相關資料
    	dao.saveOrUpdate(codeMain);
        return true;
    }
    
    public static void delete(Integer id) throws HibernateException
    {
    	//將代碼資料刪除
    	CodeMainDAO dao = new CodeMainDAO();
    	//以傳入之主鍵值找出對應的代碼類別資料並刪除
    	dao.delete(id);
    }

    public static List query(CodeMain codeMain) throws HibernateException
    {
    	//以代碼類別(代碼類別、代碼類別名稱)找出相符的資料
    	
    	CodeMainDAO dao = new CodeMainDAO();
    	//Session session = dao.getSession();
        //Criteria criteria = session.createCriteria(CodeMain.class);
        Criteria criteria = dao.getSession().createCriteria(CodeMain.class);
        if ((null != codeMain.getKindNo()) && (!"".equals(codeMain.getKindNo())))
            criteria.add(Expression.like("kindNo", codeMain.getKindNo()+"%"));
        if ((null != codeMain.getKindName()) && (!"".equals(codeMain.getKindName())))
            criteria.add(Expression.like("kindName", codeMain.getKindName()+"%"));
        criteria.addOrder(Order.asc("kindNo"));
        List collection = criteria.list();
        return criteria.list();
        //session.close();
        //return collection;
    }
    
    /**
	 * 以主鍵值找出對應的銀行代碼資料檢核銀行代碼是否重複
	 * @param id
	 * @return boolean
	 * @throws HibernateException
	 */
	public static boolean isModify(CodeMain codeMain) throws HibernateException
	{
		CodeMainDAO dao = new CodeMainDAO();
		Session session = dao.getSession();
		Criteria criteria = session.createCriteria(CodeMain.class);
	    if ((null != codeMain.getKindNo()) && (!"".equals(codeMain.getKindNo())))
	        criteria.add(Expression.eq("kindNo",codeMain.getKindNo()));
	    if(criteria.list().size()==0)
	    	return true;
		return false;
	}
}
