package gov.dnt.tame.util;

import gov.dnt.tame.common.LabelValueBean;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import tw.gov.nta.sql.debt.dao.IssueMainDAO;

public class ListToolManager {
	
	/** 用HSQL拿下拉選單 sql 的 select 第一個是 value 第二個是 label  請依順序排 
	 * sample : "select id , debtName from IssueMain " **/
	public static List<LabelValueBean> getList(String hql)
	{
		List<LabelValueBean> labelValueBeanList = new LinkedList<LabelValueBean>();
		Session session = new IssueMainDAO().getSession();
		Query query = session.createQuery(hql);
		List collection = query.list();
        if(collection!=null && !collection.isEmpty())
        {
            for (Iterator it = collection.iterator(); it.hasNext();)
            {
            	Object[] obj = (Object[])it.next();
            	labelValueBeanList.add(  new LabelValueBean( obj[0].toString(), obj[1].toString() ) );
            }
        }
        session.close();
        return labelValueBeanList;
	}
}
