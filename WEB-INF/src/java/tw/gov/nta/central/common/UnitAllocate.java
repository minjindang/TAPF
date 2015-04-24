/*
 * �b 2006/2/20 �إ�
 *
 * TODO �p�G�n�ܧ�o�Ӳ��ͪ��ɮת��d���A�в���
 * ���� - �ߦn�]�w - Java - �{���X�˦� - �{���X�d��
 */
package tw.gov.nta.central.common;

import gov.dnt.tame.common.LabelValueBean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import tw.gov.nta.sql.UnitAllocateMain;
import tw.gov.nta.sql.dao.TaxactionDetDAO;
import tw.gov.nta.sql.dao.UnitAllocateMainDAO;

/**
 * @author Jack Du
 *
 * TODO �p�G�n�ܧ�o�Ӳ��ͪ����O���Ѫ��d���A�в���
 * ���� - �ߦn�]�w - Java - �{���X�˦� - �{���X�d��
 */
public class UnitAllocate {

	/**
	 * �s�W�������t���B���
	 * @param unitAllocateMain:������(�ѷ�UnitAllocate_main����ɤ��e)
	 * @return:�^�Ƿs�W��ӵ���ƥD���
	 * @throws HibernateException
	 */
	public static int create(UnitAllocateMain unitAllocateMain) throws HibernateException 
	{
		UnitAllocateMainDAO tUnitAllocateMainDao = new UnitAllocateMainDAO();
		return tUnitAllocateMainDao.save(unitAllocateMain).intValue();
	}

	/**
	 * �̷ӶǤJ�D��ȧ�s�������t���B���
	 * @param UnitAllocateMain:������(�ѷ�UnitAllocate_main����ɤ��e)
	 */
	public static void update(UnitAllocateMain unitAllocateMain) throws HibernateException 
	{
		UnitAllocateMainDAO tUnitAllocateMainDaoImpl = new UnitAllocateMainDAO();
		tUnitAllocateMainDaoImpl.saveOrUpdate(unitAllocateMain);
	}
	
	/**
	 * �̷ӶǤJ�D��ȧR���������t���B���
	 * @param id:�D���
	 */
	public static void delete(int id) throws HibernateException 
	{
		UnitAllocateMainDAO tUnitAllocateMainDaoImpl = new UnitAllocateMainDAO();
		tUnitAllocateMainDaoImpl.delete(new Integer(id));
	}
	
	/**
	 * �̷ӶǤJ�D��Ȩ��o�������t���B���
	 * @param id
	 * @return UnitAllocateMain
	 */
	public static UnitAllocateMain getBean(int id) throws HibernateException 
	{
		UnitAllocateMainDAO tUnitAllocateMainDaoImpl = new UnitAllocateMainDAO();
		return tUnitAllocateMainDaoImpl.get(id);
	}
	
	/**
	 * �̷ӶǤJ�D��Ȩ��o�������t���B���
	 * @param id
	 * @return UnitAllocateMain
	 */
	public static List get(UnitAllocateMain unitAllocateMain) throws HibernateException 
	{
	    UnitAllocateMainDAO tUnitAllocateMainDao = new UnitAllocateMainDAO();
        Criteria tCriteria = tUnitAllocateMainDao.getSession().createCriteria(UnitAllocateMain.class);
        if ((null != unitAllocateMain.getMonKind()) && (!"".equals(unitAllocateMain.getMonKind())))
            tCriteria.add(Expression.eq("monKind", unitAllocateMain.getMonKind()));
        if ((null != unitAllocateMain.getAllYear()) && (!"".equals(unitAllocateMain.getAllYear())))
            tCriteria.add(Expression.eq("allYear", unitAllocateMain.getAllYear()));
        if ((null != unitAllocateMain.getAllMonth()) && (!"".equals(unitAllocateMain.getAllMonth())))
            tCriteria.add(Expression.eq("allMonth", unitAllocateMain.getAllMonth()));
        
//        tCriteria.add(Expression.gt("founda",new BigDecimal(0)));
//        tCriteria.add(Expression.gt("foundb",new BigDecimal(0)));
        
        tCriteria.createAlias("unitInfo", "ui");
        if ((null != unitAllocateMain.getUnitInfo().getUnitId()) && (!"".equals(unitAllocateMain.getUnitInfo().getUnitId())))
            tCriteria.add(Expression.like("ui.unitId", unitAllocateMain.getUnitInfo().getUnitId()));
        if ((null != unitAllocateMain.getUnitInfo().getUnitName()) && (!"".equals(unitAllocateMain.getUnitInfo().getUnitName())))
            tCriteria.add(Expression.like("ui.unitName", unitAllocateMain.getUnitInfo().getUnitName()));
		tCriteria.addOrder(Order.asc("ui.groupid"));
		tCriteria.addOrder(Order.asc("ui.seqNo"));
        
        return tCriteria.list();
	}
	public static List getForFound(UnitAllocateMain unitAllocateMain) throws HibernateException 
	{
	    UnitAllocateMainDAO tUnitAllocateMainDao = new UnitAllocateMainDAO();
        Criteria tCriteria = tUnitAllocateMainDao.getSession().createCriteria(UnitAllocateMain.class);
        if ((null != unitAllocateMain.getMonKind()) && (!"".equals(unitAllocateMain.getMonKind())))
            tCriteria.add(Expression.eq("monKind", unitAllocateMain.getMonKind()));
        if ((null != unitAllocateMain.getAllYear()) && (!"".equals(unitAllocateMain.getAllYear())))
            tCriteria.add(Expression.eq("allYear", unitAllocateMain.getAllYear()));
        if ((null != unitAllocateMain.getAllMonth()) && (!"".equals(unitAllocateMain.getAllMonth())))
            tCriteria.add(Expression.eq("allMonth", unitAllocateMain.getAllMonth()));
        
        //tCriteria.add(Expression.or(Expression.gt("founda",new BigDecimal(0)),Expression.gt("foundb",new BigDecimal(0))));
        
        tCriteria.createAlias("unitInfo", "ui");
        if ((null != unitAllocateMain.getUnitInfo().getUnitId()) && (!"".equals(unitAllocateMain.getUnitInfo().getUnitId())))
            tCriteria.add(Expression.like("ui.unitId", unitAllocateMain.getUnitInfo().getUnitId()));
        if ((null != unitAllocateMain.getUnitInfo().getUnitName()) && (!"".equals(unitAllocateMain.getUnitInfo().getUnitName())))
            tCriteria.add(Expression.like("ui.unitName", unitAllocateMain.getUnitInfo().getUnitName()));
        //tCriteria.addOrder(Order.asc("ui.groupid"));
		tCriteria.addOrder(Order.asc("ui.seqNo"));
		
        return tCriteria.list();
	}

	/**
	 * �H�~�פΤ���d�ߩҹ������������t���B���
	 * @param year
	 * @param month
	 * @param kind
	 * @return:�ҹ������������t���B���(�h��)
	 * @throws HibernateException
	 */
	public static List<UnitAllocateMain> getByYear(String year, String month, String kind) throws HibernateException {
	    return exportAllocate(year, month, kind);
	}
	
	public static List<UnitAllocateMain> getByYearOrderBySeq(String year, String month, String kind) throws HibernateException {
		  UnitAllocateMainDAO tUnitAllocateMainDao = new UnitAllocateMainDAO();
		  Criteria tCriteria = tUnitAllocateMainDao.getSession().createCriteria(UnitAllocateMain.class);
		  tCriteria.createAlias("unitInfo", "ui");
		  if ((null != year) && (!"".equals(year)))
			  tCriteria.add(Expression.eq("allYear", year));
		  if ((null != month) && (!"".equals(month)))
			  tCriteria.add(Expression.eq("allMonth", month));
		  if ((null != kind) && (!"".equals(kind)))
			  tCriteria.add(Expression.eq("monKind", kind));
		  tCriteria.addOrder(Order.asc("ui.groupid"));
		  tCriteria.addOrder(Order.asc("ui.seqNo"));
		  return tCriteria.list();	
		
		
		
//		UnitInfoMainDAO tUnitInfoMainDao = new UnitInfoMainDAO();
//		Criteria tCriteria = tUnitInfoMainDao.getSession().createCriteria(UnitInfoMain.class);
//		tCriteria.createAlias("unitAllocateMains", "ua");
//        if ((null != year) && (!"".equals(year)))
//            tCriteria.add(Expression.eq("ua.allYear", year));
//        if ((null != month) && (!"".equals(month)))
//            tCriteria.add(Expression.eq("ua.allMonth", month));
//        if ((null != kind) && (!"".equals(kind)))
//            tCriteria.add(Expression.eq("ua.monKind", kind));
//        tCriteria.addOrder(Order.asc("seqNo"));
//        return tCriteria.list();	
	}
	/**
	 * �̷Ӧ~�סB��������O�p��U���������w���t�ڡA�æ^�Ǹ���`�M
	 * @param year
	 * @param month
	 * @param kind
	 * @return:����`�M
	 * @throws HibernateException
	 */
	public static BigDecimal Account(String year, String month, String kind) throws HibernateException{
		BigDecimal tResult = new BigDecimal(0);
	    List tList = getByYear(year, month, kind);
	    if(tList == null) return tResult;
	    Iterator tIterator = tList.iterator();
	    UnitAllocateMain tUnitAllocateMainDto = null;
	    while(tIterator.hasNext()){
	        tUnitAllocateMainDto = (UnitAllocateMain) tIterator.next();
	        if("1".equals(kind))
	        	tResult = tResult.add( tUnitAllocateMainDto.getNowFound() );
	        else
	        	tResult = tResult.add( tUnitAllocateMainDto.getAllMoney() );
	    }
		return tResult;
	}
	/**
	 * �̷Ӧ~�סB��������O�p��U���������w���t�ڡA�æ^�Ǹ���`�M
	 * @param year
	 * @param month
	 * @param kind
	 * @return:����`�M SrcMoney
	 * @throws HibernateException
	 */
	public static BigDecimal SrcAccount(String year, String month, String kind) throws HibernateException{
		BigDecimal tResult = new BigDecimal(0);
	    List tList = getByYear(year, month, kind);
	    if(tList == null) return tResult;
	    Iterator tIterator = tList.iterator();
	    UnitAllocateMain tUnitAllocateMainDto = null;
	    while(tIterator.hasNext()){
	        tUnitAllocateMainDto = (UnitAllocateMain) tIterator.next();
	        if("2".equals(kind))
	        	tResult = tResult.add( tUnitAllocateMainDto.getAllMoney() );
	        else
	        	tResult = tResult.add( tUnitAllocateMainDto.getSrcMoney() );
	    }
		return tResult;
	}
	
	/**
	 * �̷өҿ�J�~�סB��������O��X�۹������״ڸ��
	 * @param year
	 * @param month
	 * @param kind
	 * @return
	 * @throws HibernateException
	 */
	@SuppressWarnings("unchecked")
	public static List<UnitAllocateMain> exportAllocate(String year, String month, String kind) throws HibernateException{
//	    UnitAllocateMainDAO tUnitAllocateMainDao = new UnitAllocateMainDAO();
//        Criteria tCriteria = tUnitAllocateMainDao.getSession().createCriteria(UnitAllocateMain.class);
//        if ((null != year) && (!"".equals(year)))
//            tCriteria.add(Expression.eq("allYear", year));
//        if ((null != month) && (!"".equals(month)))
//            tCriteria.add(Expression.eq("allMonth", month));
//        if ((null != kind) && (!"".equals(kind)))
//            tCriteria.add(Expression.eq("monKind", kind));
//
//        return tCriteria.list();	
//        
        
  	  UnitAllocateMainDAO tUnitAllocateMainDao = new UnitAllocateMainDAO();
	  Criteria tCriteria = tUnitAllocateMainDao.getSession().createCriteria(UnitAllocateMain.class);
	  tCriteria.createAlias("unitInfo", "ui");
	  if ((null != year) && (!"".equals(year)))
		  tCriteria.add(Expression.eq("allYear", year));
	  if ((null != month) && (!"".equals(month)))
		  tCriteria.add(Expression.eq("allMonth", month));
	  if ((null != kind) && (!"".equals(kind)))
		  tCriteria.add(Expression.eq("monKind", kind));
	  tCriteria.addOrder(Order.asc("ui.groupid"));
	  tCriteria.addOrder(Order.asc("ui.seqNo"));
	  return tCriteria.list();	
	}
	
	/**
	 * �T�{����ΨϥΪ̸��
	 * @param year
	 * @param month
	 * @param kind
	 * @throws HibernateException
	 */
	public static void confirm(String year, String month, String kind) throws HibernateException 
	{
	    UnitAllocateMainDAO tUnitAllocateMainDao = new UnitAllocateMainDAO();
		List tDataList = exportAllocate(year, month, kind);
		if(tDataList == null) return;//�d�L��ƻݳQupdate
		Iterator iterator = tDataList.iterator();
		UnitAllocateMain tUnitAllocateMainDto = null;
		Calendar calendar = new GregorianCalendar();
		while(iterator.hasNext()){
			tUnitAllocateMainDto = (UnitAllocateMain) iterator.next();
			tUnitAllocateMainDto.setOkDate(calendar.getTime());//�Ȯɨ��ثe���ɶ�
			tUnitAllocateMainDto.setOkUser("usr");//�Ȯɼg��
			tUnitAllocateMainDto.setOk(true);
			tUnitAllocateMainDao.update(tUnitAllocateMainDto);
		}
	}
	
	/**
	 * ��s�����
	 * @param id
	 * @param FundA
	 * @param FundB
	 * @throws HibernateException
	 */
	public static void updateforRepay(int id, BigDecimal FundA, BigDecimal FundB) throws HibernateException {
	    UnitAllocateMainDAO tUnitAllocateMainDao = new UnitAllocateMainDAO();
        UnitAllocateMain tUnitAllocateMainDto = tUnitAllocateMainDao.get(new Integer(id));
        if(tUnitAllocateMainDto == null) return;//���ӥ�XException
        tUnitAllocateMainDto.setFounda(FundA);
        tUnitAllocateMainDto.setFoundb(FundB);
        tUnitAllocateMainDao.update(tUnitAllocateMainDto);
	}
	
	/**
	 * ��s�q�l�l�󱵦��������
	 * @param id
	 * @param time
	 * @throws HibernateException
	 */
	public static void updateForRecieve(int id, Date time) throws HibernateException{
	    UnitAllocateMainDAO tUnitAllocateMainDao = new UnitAllocateMainDAO();
        UnitAllocateMain tUnitAllocateMainDto = tUnitAllocateMainDao.get(new Integer(id));
        if(tUnitAllocateMainDto == null) return;//���ӥ�XException
        tUnitAllocateMainDto.setRecvDate(time);
        tUnitAllocateMainDao.update(tUnitAllocateMainDto);
	}
	
	/**
	 * ���o�q�l�l�󱵦��������
	 * @param year
	 * @param month
	 * @param kind
	 * @return
	 * @throws HibernateException
	 */
	public static List<UnitAllocateMain> getMailRecord(String year, String month, String kind) throws HibernateException{
		return exportAllocate(year, month, kind);
	}	
	
	/**
	 * ���o�O�b�~��CombinText List
	 * @param null
	 * @return List<LabelValueBean>
	 * @throws HibernateException
	 */
	public static List<LabelValueBean> getYearLabelList(String monKind) throws HibernateException
	{
        List<LabelValueBean> labelValueBeanList = new LinkedList<LabelValueBean>();
        UnitAllocateMainDAO dao = new UnitAllocateMainDAO();
		Session session = dao.getSession();
        Criteria criteria = session.createCriteria(UnitAllocateMain.class);
        //criteria.setProjection(Projections.projectionList().add(Projections.property("allYear")).add(Projections.property("allMonth")));
        criteria.add(Expression.eq("monKind", monKind));
        criteria.setProjection(Projections.property("allYear"));
        criteria.setProjection(Projections.groupProperty("allYear"));
        criteria.addOrder(Order.desc("allYear"));
        List collection = criteria.list();
        System.out.println(collection);
        if(collection!=null)
        {
            for (Iterator it = collection.iterator(); it.hasNext();)
            {
            	//UnitAllocateMain dto = (UnitAllocateMain) it.next();
            	String year = (String)it.next();
            	LabelValueBean labelValueBean = new LabelValueBean();
            	labelValueBean.setLabel(year);
            	labelValueBean.setValuess(year);
            	labelValueBeanList.add(labelValueBean);
            }
        }
        session.close();
        return labelValueBeanList;
	}
	
	/**
	 * ���o�O�b�~��CombinText List
	 * @param null
	 * @return List<LabelValueBean>
	 * @throws HibernateException
	 */
	public static List<LabelValueBean> getMonthLabelList() throws HibernateException
	{
        List<LabelValueBean> labelValueBeanList = new LinkedList<LabelValueBean>();
        UnitAllocateMainDAO dao = new UnitAllocateMainDAO();
		Session session = dao.getSession();
        Criteria criteria = session.createCriteria(UnitAllocateMain.class);
        criteria.setProjection(Projections.property("allMonth"));
        criteria.setProjection(Projections.groupProperty("allMonth"));
        criteria.addOrder(Order.desc("allMonth"));
        List collection = criteria.list();
        System.out.println(collection);
        if(collection!=null)
        {
            for (Iterator it = collection.iterator(); it.hasNext();)
            {
            	String month = (String)it.next();
            	LabelValueBean labelValueBean = new LabelValueBean();
            	labelValueBean.setLabel(month);
            	labelValueBean.setValuess(month);
            	labelValueBeanList.add(labelValueBean);
            }
        }
        session.close();
        return labelValueBeanList;
	}
	
	/**
	 * ���oHAMB04�פJEXCEL�~��
	 * @return
	 * @throws HibernateException
	 */
	public static List<LabelValueBean> getImpYearLabelList() throws HibernateException
	{
        List<LabelValueBean> labelValueBeanList = new LinkedList<LabelValueBean>();
        UnitAllocateMainDAO dao = new UnitAllocateMainDAO();
		Session session = dao.getSession();
		Criteria criteria = session.createCriteria(UnitAllocateMain.class);
		criteria.setProjection(Projections.property("allMonth"));
		ProjectionList projectionList = Projections.projectionList();  
		projectionList.add(Projections.property("allMonth"));  
		criteria.setProjection(Projections.distinct(projectionList));
		criteria.addOrder(Order.desc("allMonth"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List collection = criteria.list();
		
		Map distinctMap = new LinkedHashMap();
		if(collection!=null)
        {
            for (Iterator it = collection.iterator(); it.hasNext();)
            {
            	String month = (String)it.next();
            	month = month.substring(0,3);
            	distinctMap.put(month,month);
	        }    
        }
		for(Iterator it = distinctMap.keySet().iterator();it.hasNext();){
			String month = (String)it.next();
			LabelValueBean labelValueBean = new LabelValueBean();
	    	labelValueBean.setLabel(month);
	    	labelValueBean.setValuess(month);
	    	labelValueBeanList.add(labelValueBean);
		}
		return labelValueBeanList;	
	}
	
	
	/**
	 * ���o���ڦ~��CombinText List
	 * @param String year = �O�b�~��
	 * @return List<LabelValueBean>
	 * @throws HibernateException
	 */
	public static List<LabelValueBean> getMonthLabelWithYearList(String year,String kind) throws HibernateException
	{
		List<LabelValueBean> labelValueBeanList = new LinkedList<LabelValueBean>();
		UnitAllocateMainDAO dao = new UnitAllocateMainDAO();
		Session session = dao.getSession();
        Criteria tCriteria = session.createCriteria(UnitAllocateMain.class);
        if ((null != year) && (!"".equals(year)))
            tCriteria.add(Expression.eq("allYear", year));
        else
        	tCriteria.add(Expression.eq("allYear", null));
        if ((null != kind) && (!"".equals(kind)))
            tCriteria.add(Expression.eq("monKind", kind));
        else
        	tCriteria.add(Expression.eq("monKind", null));
        tCriteria.setProjection(Projections.groupProperty("allMonth"));
        tCriteria.addOrder(Order.desc("allMonth"));
        List collection = tCriteria.list();
        System.out.println(collection);
        if(collection!=null)
        {
            for (Iterator it = collection.iterator(); it.hasNext();)
            {
            	String month = (String)it.next();
            	LabelValueBean labelValueBean = new LabelValueBean();
            	labelValueBean.setLabel(month);
            	labelValueBean.setValuess(month);
            	labelValueBeanList.add(labelValueBean);
            }
        }
        session.close();
        return labelValueBeanList;	
	}
	
	
	/**
	 * ���o�w���ڹL���~��
	 * @return
	 * @throws HibernateException
	 */
	public static List<LabelValueBean> getAllotedByIsOkList() throws HibernateException{
		return getAllotedByIsOkList("1");
	}
	public static List<LabelValueBean> getAllotedByIsOkList(String monKind) throws HibernateException
	{
		List<LabelValueBean> labelValueBeanList = new LinkedList<LabelValueBean>();
		UnitAllocateMainDAO dao = new UnitAllocateMainDAO();
		Session session = dao.getSession();
		StringBuffer queryString = new StringBuffer();
		queryString.append("select d.allYear,d.allMonth from UnitAllocateMain d where d.monKind = '"+monKind+"' ");
		queryString.append(" and d.ok = 'Y' group by d.allYear,d.allMonth ");
		Query query = session.createQuery(queryString.toString());
		List collection = query.list();
        System.out.println(collection);
        System.out.println(collection);
        if(collection!=null)
        {
            for (Iterator it = collection.iterator(); it.hasNext();)
            {
            	Object[] obj = (Object[])it.next();
            	labelValueBeanList.add(new LabelValueBean(obj[0].toString(), obj[1].toString()));
            	LabelValueBean labelValueBean = new LabelValueBean();
            	labelValueBean.setLabel((String)obj[0].toString()+(String)obj[1].toString());
            	labelValueBean.setValuess((String)obj[0].toString()+(String)obj[1].toString());
            	labelValueBeanList.add(labelValueBean);
            	System.out.println("Alloted_Year_Month_isOK===>"+labelValueBean.getValuess());
            }
        }
        session.close();
		return labelValueBeanList;
	}
}