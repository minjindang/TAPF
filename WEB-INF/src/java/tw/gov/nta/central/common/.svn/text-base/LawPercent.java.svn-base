/*
 * 在 2006/2/21 建立
 *
 * TODO 如果要變更這個產生的檔案的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
package tw.gov.nta.central.common;

import org.hibernate.HibernateException;

import tw.gov.nta.sql.LawPercentRef;
import tw.gov.nta.sql.dao.LawPercentRefDAO;

/**
 * @author WeiMing-Lee
 * 提供系統操作法定單位受分配比例資料(修改、查詢)
 */
public class LawPercent {

	/**
	 * 以主鍵值找出對應的法定單位受分配比例資料
	 * @param id:主鍵值
	 * @return:回傳所對應的法定單位受分配比例資料
	 * @throws HibernateException
	 * @throws LawPercentRefDaoException
	 */
	public static LawPercentRef get(int id) throws HibernateException{
	    LawPercentRefDAO tLawPercentRefDAO = new LawPercentRefDAO();
	    return tLawPercentRefDAO.get(new Integer(id));
	}
	
	/**
	 * 以輸入的資料欄位值更新法定單位受分配比例資料
	 * @param id:主鍵值
	 * @param dto:資料欄位值
	 * @throws HibernateException
	 * @throws LawPercentRefDaoException
	 */
	public static void update(LawPercentRef dto) throws HibernateException{
	    LawPercentRefDAO tLawPercentRefDAO = new LawPercentRefDAO();
	    tLawPercentRefDAO.saveOrUpdate(dto);
	}
}
