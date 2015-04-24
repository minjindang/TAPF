package tw.gov.nta.system.common;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import tw.gov.nta.sql.CentralStatisticsMain;
import tw.gov.nta.sql.dao.CentralStatisticsMainDAO;

public class CentralStatisticsManager
{
	public static CentralStatisticsMain get(Integer id) throws HibernateException
    {	
		//依照主鍵值找出代碼類別資料
		CentralStatisticsMainDAO dao = new CentralStatisticsMainDAO();
		return dao.get(id);
    }

    public static void create(CentralStatisticsMain csMain) throws HibernateException
    {
    	//將代碼新增於資料檔中
    	CentralStatisticsMainDAO dao = new CentralStatisticsMainDAO();
    	//傳入代碼類別資料BankRef並將資料儲存至資料檔
    	dao.save(csMain);
    }

    public static boolean update(Integer id,CentralStatisticsMain csMain) throws HibernateException
    {
    	//將代碼類別更新相關資料欄位於資料檔中
    	CentralStatisticsMainDAO dao = new CentralStatisticsMainDAO();
    	//更新所對應，並以傳路之BankRef更新相關資料
    	dao.saveOrUpdate(csMain);
        return true;
    }
    
    public static void delete(Integer id) throws HibernateException
    {
    	//將代碼資料刪除
    	CentralStatisticsMainDAO dao = new CentralStatisticsMainDAO();
    	//以傳入之主鍵值找出對應的代碼類別資料並刪除
    	dao.delete(id);
    }

    public static List query(CentralStatisticsMain csMain) throws HibernateException
    {
    	CentralStatisticsMainDAO dao = new CentralStatisticsMainDAO();
    	Session tSession = dao.getSession();
        Criteria criteria = tSession.createCriteria(CentralStatisticsMain.class);
        if ((null != csMain.getAccountYear()) && (!"".equals(csMain.getAccountYear())))
            criteria.add(Expression.like("accountYear", csMain.getAccountYear()+"%"));
        if (0 != csMain.getBudgetCode()) 
            criteria.add(Expression.eq("budgetCode", csMain.getBudgetCode()));
        if (0 != csMain.getDebtCode())
            criteria.add(Expression.eq("debtCode", csMain.getDebtCode()));
        if ((null != csMain.getDebtType()) && (!"".equals(csMain.getDebtType())))
            criteria.add(Expression.eq("debtType", csMain.getDebtType()));
        if ((null != csMain.getBoundCode()) && (!"".equals(csMain.getBoundCode())))
            criteria.add(Expression.eq("boundCode", csMain.getBoundCode()));
        if ((null != csMain.getAccountKind()) && (!"".equals(csMain.getAccountKind())))
            criteria.add(Expression.eq("accountKind", csMain.getAccountKind()));
        criteria.addOrder(Order.asc("accountYear"));
		List tResultList = criteria.list();
		tSession.close();
        return tResultList;
    }

    @SuppressWarnings("unchecked")
	public static List<CentralStatisticsMain> search(String[] pCols,Object[] pValues,String[] pConds,String[] pOrderby )
	{
    	CentralStatisticsMainDAO dao = new CentralStatisticsMainDAO();
		Session tSession = dao.getSession();
		Criteria criteria = tSession.createCriteria(CentralStatisticsMain.class);
		if(pCols != null && pValues != null && pConds != null)
		{
			for(int i = 0 ; i < pCols.length ; i++)
			{
				if(pCols[i] == null || pValues[i] == null || pConds[i] == null || 
						"".equals(pCols[i]) || "".equals(pValues[i]) || "".equals(pConds[i]))
					continue;
				if(pConds[i].equals("="))
					criteria.add(Expression.eq(pCols[i], pValues[i]));
				else if(pConds[i].equals(">"))
					criteria.add(Expression.gt(pCols[i], pValues[i]));
				else if(pConds[i].equals("<"))
					criteria.add(Expression.lt(pCols[i], pValues[i]));
				else if(pConds[i].equals(">="))
					criteria.add(Expression.ge(pCols[i], pValues[i]));
				else if(pConds[i].equals("<="))
					criteria.add(Expression.le(pCols[i], pValues[i]));
				else if(pConds[i].equals("like"))
					criteria.add(Expression.like(pCols[i], pValues[i]+"%"));
			}
		}
		if(pOrderby != null){
			for(int i = 0 ; i < pOrderby.length ; i++){
				if(pOrderby[i] == null || "".equals(pOrderby[i])) continue;
				criteria.addOrder(Order.asc(pOrderby[i]));
			}
		}
		List tResultList = criteria.list();
		tSession.close();
		return tResultList;
	}
}