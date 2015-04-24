package tw.gov.nta.system.common;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import tw.gov.nta.sql.NationDebitMain;
import tw.gov.nta.sql.dao.NationDebitMainDAO;

public class NationDebitManager
{
	public static NationDebitMain get(Integer id) throws HibernateException
    {	
		//依照主鍵值找出代碼類別資料
    	NationDebitMainDAO dao = new NationDebitMainDAO();
		return dao.get(id);
    }

    public static void create(NationDebitMain dto) throws HibernateException
    {
    	//將代碼新增於資料檔中
    	NationDebitMainDAO dao = new NationDebitMainDAO();
    	//傳入代碼類別資料NationDebitMain並將資料儲存至資料檔
    	dao.save(dto);
    }

    public static boolean update(Integer id,NationDebitMain dto) throws HibernateException
    {
    	//將代碼類別更新相關資料欄位於資料檔中
    	NationDebitMainDAO dao = new NationDebitMainDAO();
    	NationDebitMain sorDto = dao.get(id);
    	dao.saveOrUpdate(dto);
    	syncUpdatePergnpAmount(dto);
    	//更新所對應，並以傳路之NationDebitMain更新相關資料
        return true;
    }
    private static void syncUpdatePergnpAmount(NationDebitMain dto){
    	NationDebitMainDAO dao = new NationDebitMainDAO();
    	Session session = dao.getSession();
		StringBuffer hqlStr = new StringBuffer(" from NationDebitMain NDM where 1 = 1");
		hqlStr.append(" and NDM.nationCode.id =" + dto.getNationCode().getId());
		hqlStr.append(" and NDM.accountYear in (" + String.valueOf(Integer.parseInt(dto.getAccountYear())+1)+"," + String.valueOf(Integer.parseInt(dto.getAccountYear())+2)+"," + String.valueOf(Integer.parseInt(dto.getAccountYear())+3)+")");
		Query query = session.createQuery(hqlStr.toString());
		List list = query.list();
		for(Iterator it = list.iterator();it.hasNext();){
			Session newSession = dao.getSession();
			NationDebitMain tempDto = (NationDebitMain) it.next();
			String key = "";
			if(Integer.parseInt(tempDto.getAccountYear()) <= 88)
				key = "gnpAmount";
			else
				key = "gnpYearAmount";
			hqlStr = new StringBuffer("select isNull(sum(NDM."+key+")/3,0) from NationDebitMain NDM where 1 = 1");
			hqlStr.append(" and NDM.nationCode.id =" + dto.getNationCode().getId());
			hqlStr.append(" and NDM.accountYear in (" + String.valueOf(Integer.parseInt(tempDto.getAccountYear())-1)+"," + String.valueOf(Integer.parseInt(tempDto.getAccountYear())-2)+"," + String.valueOf(Integer.parseInt(tempDto.getAccountYear())-3)+")");
			query = newSession.createQuery(hqlStr.toString());
			List tempList = query.list();
			newSession.close();
			if(list!=null && !list.isEmpty()){
				tempDto.setPergnpAmount(new BigDecimal(tempList.iterator().next().toString()));
			}
			dao.saveOrUpdate(tempDto);
		}
    }
    public static void delete(Integer id) throws HibernateException
    {
    	//將代碼資料刪除
    	NationDebitMainDAO dao = new NationDebitMainDAO();
    	//以傳入之主鍵值找出對應的代碼類別資料並刪除
    	dao.delete(id);
    }
    public static List query(NationDebitMain nationDebitMain ) throws HibernateException{
    	return query(nationDebitMain ,"");
    }
    public static List query(NationDebitMain nationDebitMain ,String key) throws HibernateException
    {
    	NationDebitMainDAO dao = new NationDebitMainDAO();
        Criteria criteria = dao.getSession().createCriteria(NationDebitMain.class);
        if ((Integer.parseInt(nationDebitMain.getAccountYear()) != 0)&&(null != nationDebitMain.getAccountYear()) && (!"".equals(nationDebitMain.getAccountYear())))
            criteria.add(Expression.like("accountYear", nationDebitMain.getAccountYear()+key));
        if (null != nationDebitMain.getNationCode())
            criteria.add(Expression.eq("nationCode", nationDebitMain.getNationCode()));
        criteria.addOrder(Order.asc("accountYear"));
        return criteria.list();

    	//以代碼類別(代碼類別、代碼類別名稱)找出相符的資料
    }
    
    public static boolean isModify(NationDebitMain nationDebitMain)throws HibernateException
    {
    	NationDebitMainDAO dao = new NationDebitMainDAO();
        Criteria criteria = dao.getSession().createCriteria(NationDebitMain.class);
        if ((null != nationDebitMain.getAccountYear()) && (!"".equals(nationDebitMain.getAccountYear())))
            criteria.add(Expression.eq("accountYear", nationDebitMain.getAccountYear()));
        if (null!= nationDebitMain.getNationCode())
            criteria.add(Expression.eq("nationCode", nationDebitMain.getNationCode()));
        if(criteria.list().size()>0)
        	return false;
		return true;
    }
}
