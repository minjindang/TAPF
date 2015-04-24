package tw.gov.nta.central.common;

import org.hibernate.HibernateException;
import tw.gov.nta.sql.LawPercentRef101;
import tw.gov.nta.sql.dao.LawPercentRef101DAO;

/**
 * @author Powen Hsueh 提供系統操作法定單位受分配比例資料(修改、查詢)
 */
public class LawPercent101 {
	/**
	 * 以主鍵值找出對應的法定單位受分配比例資料
	 * 
	 * @param id:主鍵值
	 * @return:回傳所對應的法定單位受分配比例資料
	 * @throws HibernateException
	 * @throws LawPercentRefDaoException
	 */
	public static LawPercentRef101 get(int id) throws HibernateException {
		LawPercentRef101DAO tLawPercentRef101DAO = new LawPercentRef101DAO();
		return tLawPercentRef101DAO.get(new Integer(id));
	}

	/**
	 * 以輸入的資料欄位值更新法定單位受分配比例資料
	 * 
	 * @param id:主鍵值
	 * @param dto:資料欄位值
	 * @throws HibernateException
	 * @throws LawPercentRefDaoException
	 */
	public static void update(LawPercentRef101 dto) throws HibernateException {
		LawPercentRef101DAO tLawPercentRef101DAO = new LawPercentRef101DAO();
		tLawPercentRef101DAO.saveOrUpdate(dto);
	}
}
