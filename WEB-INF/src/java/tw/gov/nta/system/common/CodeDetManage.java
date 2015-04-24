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
import org.hibernate.criterion.Restrictions;

import tw.gov.nta.sql.CodeDet;
import tw.gov.nta.sql.dao.CodeDetDAO;

public class CodeDetManage
{
	/**
	 * @param id
	 * @return
	 * @throws HibernateException
	 */
	public static CodeDet get(Integer id) throws HibernateException
    {	
		//依照主鍵值找出代碼類別資料
    	CodeDetDAO dao = new CodeDetDAO();
		return dao.get(id);
    }

    /**
     * @param codeDet
     * @throws HibernateException
     */
    public static void create(CodeDet codeDet) throws HibernateException
    {
    	//將代碼新增於資料檔中
    	CodeDetDAO dao = new CodeDetDAO();
    	//傳入代碼類別資料CodeDet並將資料儲存至資料檔
    	dao.save(codeDet);
    }

    /**
     * @param id
     * @param codeDet
     * @return boolean
     * @throws HibernateException
     */
    public static boolean update(Integer id,CodeDet codeDet) throws HibernateException
    {
    	//將代碼類別更新相關資料欄位於資料檔中
    	CodeDetDAO dao = new CodeDetDAO();
    	//更新所對應，並以傳路之CodeDet更新相關資料
    	dao.saveOrUpdate(codeDet);
        return true;
    }
    
    /**
     * @param id
     * @throws HibernateException
     */
    public static void delete(Integer id) throws HibernateException
    {
    	//將代碼資料刪除
    	CodeDetDAO dao = new CodeDetDAO();
    	//以傳入之主鍵值找出對應的代碼類別資料並刪除
    	dao.delete(id);
    }

    /**
     * @param CodeDet
     * @return List
     * @throws HibernateException
     */
    public static List query(CodeDet CodeDet) throws HibernateException
    {
    	//以代碼類別(代碼類別、代碼類別名稱)找出相符的資料
    	
    	CodeDetDAO dao = new CodeDetDAO();
        Criteria criteria = dao.getSession().createCriteria(CodeDet.class);
        if ((null != CodeDet.getKind().getId()) && (!"".equals(CodeDet.getKind().getId())))
        {
        	criteria.add(Expression.eq("kind", CodeDet.getKind()));
        }
        criteria.addOrder(Order.asc("kind"));
        return criteria.list();
    }
    
    /**
     * 取得債種下拉式選單代號
     * @param pCodeKind 類別代碼
     * @return List<LabelValueBean>
     * @throws HibernateException
     */
    public static List<LabelValueBean> getCodeDet(String pCodeKind) throws HibernateException
	{
        List<LabelValueBean> labelValueBeanList = new LinkedList<LabelValueBean>();
        Session session = new CodeDetDAO().getSession();
        Criteria tCodeDetCriteria = session.createCriteria(CodeDet.class);
        Criteria tCodeMainCriteria = tCodeDetCriteria.createCriteria("kind");
        
        tCodeMainCriteria.add(Restrictions.eq("kindNo", pCodeKind));
        
        List collection = tCodeDetCriteria.list();
        if(collection!=null && collection.size() != 0)
        {
        	LabelValueBean labelValueBean = null;
            for (Iterator it = collection.iterator(); it.hasNext();)
            {
            	CodeDet codeDetDto = (CodeDet) it.next();
            	labelValueBean = new LabelValueBean();
            	labelValueBean.setLabel(codeDetDto.getCodeName());
            	labelValueBean.setValuess(codeDetDto.getCodeNo());
            	labelValueBeanList.add(labelValueBean);
            }
        }
        session.close();
        return labelValueBeanList;
	}
    
    
    /**
     * 取得債種下拉式選單代號
     * @param pCodeKind 類別代碼
     * @return List<LabelValueBean>
     * @throws HibernateException
     */
    public static List<LabelValueBean> getCodeDet(String pCodeKind, String pCodeType) throws HibernateException
	{
        List<LabelValueBean> labelValueBeanList = new LinkedList<LabelValueBean>();
        Session session = new CodeDetDAO().getSession();
        Criteria tCodeDetCriteria = session.createCriteria(CodeDet.class);
        Criteria tCodeMainCriteria = tCodeDetCriteria.createCriteria("kind");
        tCodeMainCriteria.add(Restrictions.eq("kindNo", pCodeKind));
        tCodeDetCriteria.add(Restrictions.eq("codeType", pCodeType));
        
        List collection = tCodeDetCriteria.list();
        if(collection!=null && collection.size() != 0)
        {
        	LabelValueBean labelValueBean = null;
            for (Iterator it = collection.iterator(); it.hasNext();)
            {
            	CodeDet codeDetDto = (CodeDet) it.next();
            	labelValueBean = new LabelValueBean();
            	labelValueBean.setLabel(codeDetDto.getCodeName());
            	labelValueBean.setValuess(codeDetDto.getCodeNo());
            	labelValueBeanList.add(labelValueBean);
            }
        }
        session.close();
        return labelValueBeanList;
	}
    /**
     * 取得代碼名稱
     * @param codeKind 類別代碼
     * @param codeNo 代碼
     * @return String
     * @throws HibernateException
     */
    public static String getCodeName(String codeKind,String codeNo) throws HibernateException
    {
    	List codeDetList = getCodeDet(codeKind);
        for (Iterator it = codeDetList.iterator(); it.hasNext();)
        {
        	LabelValueBean labelValueBean = (LabelValueBean) it.next();
        	if( codeNo.equals( labelValueBean.getValuess() ) )
        		return labelValueBean.getLabel();
        }
        return "";
    }
}
