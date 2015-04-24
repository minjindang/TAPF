package tw.gov.nta.surplusage.common;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import tw.gov.nta.sql.debt.Gara04Temp;
import tw.gov.nta.sql.debt.dao.Gara04TempDAO;

public class Gara04TempManager
{

	public static Gara04Temp get(Integer id) throws HibernateException
    {	
		Gara04TempDAO dao = new Gara04TempDAO();
		return dao.get(id);
    }

    public static Integer create(Gara04Temp dto) throws HibernateException
    {
    	Gara04TempDAO dao = new Gara04TempDAO();
		return dao.save(dto);
    }

    public static void update(Gara04Temp dto) throws HibernateException
    {
    	Gara04TempDAO dao = new Gara04TempDAO();
    	dao.saveOrUpdate(dto);
    }
    
    public static void delete(Integer id) throws HibernateException
    {
    	Gara04TempDAO dao = new Gara04TempDAO();
    	dao.delete(id);
    }
    
	public static List query(Gara04Temp gara04Temp) throws HibernateException
    {
		Gara04TempDAO dao = new Gara04TempDAO();
        Criteria criteria = dao.getSession().createCriteria(Gara04Temp.class);
        if (!"".equals(gara04Temp.getAccountYear()))
            criteria.add(Expression.eq("accountYear", gara04Temp.getAccountYear()));
        criteria.addOrder(Order.asc("accountYear"));
        return criteria.list();
    }
	
	public static boolean isModify(Gara04Temp gara04Temp)throws HibernateException
    {
		Gara04TempDAO dao = new Gara04TempDAO();
        Criteria criteria = dao.getSession().createCriteria(Gara04Temp.class);
        if ((null != gara04Temp.getAccountYear()) && (!"".equals(gara04Temp.getAccountYear())))
            criteria.add(Expression.eq("accountYear", gara04Temp.getAccountYear()));
        if(criteria.list().size()>0)
        	return false;
		return true;
    }
}
