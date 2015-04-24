package tw.gov.nta.surplusage.common;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import tw.gov.nta.sql.YearAmountRef;
import tw.gov.nta.sql.dao.YearAmountRefDAO;

public class YearAmountManager
{
	private YearAmountRefDAO dao;

	public YearAmountManager() {
		dao = YearAmountRefDAO.getInstance();
	}

	public YearAmountRef get(Integer id) throws HibernateException
    {	
		return dao.get(id);
    }

    public Integer create(YearAmountRef dto) throws HibernateException
    {
    	return dao.save(dto);
    }

    public void update(YearAmountRef dto) throws HibernateException
    {
    	dao.saveOrUpdate(dto);
    }
    
    public void delete(Integer id) throws HibernateException
    {
    	dao.delete(id);
    }

    @SuppressWarnings("unchecked")
	public List<YearAmountRef> query(YearAmountRef dto) throws HibernateException
    {
    	Session session = dao.getSession();
        Criteria criteria = session.createCriteria(YearAmountRef.class);
        if ((null != dto.getAccountYear()) && (!"".equals(dto.getAccountYear())))
            criteria.add(Expression.eq("accountYear", dto.getAccountYear()));
        if (!dto.getBudgetCode().equals(0)) 
            criteria.add(Expression.eq("budgetCode", dto.getBudgetCode()));
        if (!dto.getDebtCode().equals(0))
            criteria.add(Expression.eq("debtCode", dto.getDebtCode()));
        if (dto.getDataType() != null && 0 != dto.getDataType() )
            criteria.add(Expression.eq("dataType", dto.getDataType()));
        criteria.addOrder(Order.asc("accountYear"));
        criteria.addOrder(Order.asc("budgetCode"));
        List<YearAmountRef> list = criteria.list();
        session.close();
        return list;
    }

	public YearAmountRefDAO getDao() {
		return dao;
	}

	public void setDao(YearAmountRefDAO dao) {
		this.dao = dao;
	}
}
