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
		//�̷ӥD��ȧ�X�N�X���O���
    	CodeDetDAO dao = new CodeDetDAO();
		return dao.get(id);
    }

    /**
     * @param codeDet
     * @throws HibernateException
     */
    public static void create(CodeDet codeDet) throws HibernateException
    {
    	//�N�N�X�s�W�����ɤ�
    	CodeDetDAO dao = new CodeDetDAO();
    	//�ǤJ�N�X���O���CodeDet�ñN����x�s�ܸ����
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
    	//�N�N�X���O��s��������������ɤ�
    	CodeDetDAO dao = new CodeDetDAO();
    	//��s�ҹ����A�åH�Ǹ���CodeDet��s�������
    	dao.saveOrUpdate(codeDet);
        return true;
    }
    
    /**
     * @param id
     * @throws HibernateException
     */
    public static void delete(Integer id) throws HibernateException
    {
    	//�N�N�X��ƧR��
    	CodeDetDAO dao = new CodeDetDAO();
    	//�H�ǤJ���D��ȧ�X�������N�X���O��ƨçR��
    	dao.delete(id);
    }

    /**
     * @param CodeDet
     * @return List
     * @throws HibernateException
     */
    public static List query(CodeDet CodeDet) throws HibernateException
    {
    	//�H�N�X���O(�N�X���O�B�N�X���O�W��)��X�۲Ū����
    	
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
     * ���o�źؤU�Ԧ����N��
     * @param pCodeKind ���O�N�X
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
     * ���o�źؤU�Ԧ����N��
     * @param pCodeKind ���O�N�X
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
     * ���o�N�X�W��
     * @param codeKind ���O�N�X
     * @param codeNo �N�X
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
