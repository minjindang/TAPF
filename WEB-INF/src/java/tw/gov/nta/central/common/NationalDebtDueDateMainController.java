package tw.gov.nta.central.common;

import java.math.BigDecimal;
import java.sql.Connection;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import gov.dnt.tame.util.DateUtil;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

import tw.gov.nta.sql.NationalDebtDueDateMain;
import tw.gov.nta.sql.UnitInfoMain;
import tw.gov.nta.sql.dao.NationalDebtDueDateMainDAO;
import tw.gov.nta.sql.dao.UnitInfoMainDAO;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.base.BaseIssueMain;
import tw.gov.nta.sql.debt.dao.IssueMainDAO;
public class NationalDebtDueDateMainController {

	public static List get() throws HibernateException {
		NationalDebtDueDateMainDAO nationalDebtDueDateMainDAO = new NationalDebtDueDateMainDAO();
		Criteria tCriteria = nationalDebtDueDateMainDAO.getSession()
				.createCriteria(NationalDebtDueDateMain.class);
		return tCriteria.list();
	}

	// 更新
	public static void update(int id, Date repayHandle, String repayNumber,
			Date accountDate, String accountNumber, String fundNumber,
			Date secretaryDate) throws HibernateException {
		NationalDebtDueDateMainDAO nationalDebtDueDateMainDAO = new NationalDebtDueDateMainDAO();
		NationalDebtDueDateMain nationalDebtDueDateMain = nationalDebtDueDateMainDAO
				.get(id);
		nationalDebtDueDateMain.setRepayHandle(repayHandle);
		nationalDebtDueDateMain.setRepayNumber(repayNumber);
		nationalDebtDueDateMain.setAccountDate(accountDate);
		nationalDebtDueDateMain.setAccountNumber(accountNumber);
		nationalDebtDueDateMain.setFundNumber(fundNumber);
		nationalDebtDueDateMain.setSecretaryDate(secretaryDate);
		nationalDebtDueDateMainDAO.saveOrUpdate(nationalDebtDueDateMain);
	}


	// 查看有無權限
	public static String getCurrentUserDeptId(String userId,
			Connection connection) throws Exception {
		String deptId = "-1";
		SQLJob sqljob = new SQLJob();
		sqljob
				.appendSQL("select pm0004id from dbo.PM0005_DB where account = ?");
		sqljob.addParameter(userId);
		SQLRunner run = new ConnectionSQLRunner(connection);
		List pm0004id = (List) run.query(sqljob, new MapListHandler());
		if (pm0004id != null && pm0004id.size() > 0) {
			Iterator it = pm0004id.iterator();
			Map mp = (Map) it.next();
			deptId = mp.get("pm0004id").toString();
		}
		return deptId;
	}

	public static List getNationalDebtDueDateList()  throws Exception {
		NationalDebtDueDateMainDAO nationalDebtDueDateMainDAO = new NationalDebtDueDateMainDAO();
		Criteria tCriteria = nationalDebtDueDateMainDAO.getSession()
				.createCriteria(NationalDebtDueDateMain.class);
		Calendar afterWeekAgo = Calendar.getInstance();
		afterWeekAgo.add(Calendar.DATE ,7);//七天後
		Calendar now = Calendar.getInstance();
		String year = String.valueOf(afterWeekAgo.get(Calendar.YEAR));
		String month = String.valueOf(afterWeekAgo.get(Calendar.MONTH) + 1) ;
		String day = String.valueOf(afterWeekAgo.get(Calendar.DATE) ) ;
		String endtDateStr = year + "-" + month + "-" + day ;
		year = String.valueOf(now.get(Calendar.YEAR));
		month = String.valueOf(now.get(Calendar.MONTH) + 1);
		day = String.valueOf(now.get(Calendar.DATE));
		String startDateStr = year + "-" + month + "-" + day;
		java.text.DateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		java.util.Date startDate =(java.util.Date) format.parse(startDateStr + " 00:00:00");
		java.util.Date endDate = (java.util.Date) format.parse(endtDateStr+" 00:00:00");
			
		
		tCriteria.add(Expression.between("repayDate", new java.util.Date(
				startDate.getTime()), new java.util.Date(endDate.getTime())));
		tCriteria.addOrder(Order.asc("secretaryDate"));
		tCriteria.addOrder(Order.asc("repayDate"));
		//tCriteria.addOrder(Order.asc("repayHandle"));
		System.out.print(tCriteria.toString());
		List dueList = getDueRow();
		List resultList = tCriteria.list();
		for(Iterator i=resultList.iterator();i.hasNext();){
			dueList.add(i.next());
		}
		return dueList;
	}
	
	public static List getDueRow()  throws Exception {
		NationalDebtDueDateMainDAO nationalDebtDueDateMainDAO = new NationalDebtDueDateMainDAO();
		Criteria tCriteria = nationalDebtDueDateMainDAO.getSession()
				.createCriteria(NationalDebtDueDateMain.class);
		Calendar now = Calendar.getInstance();
		String year = String.valueOf(now.get(Calendar.YEAR));
		String month = String.valueOf(now.get(Calendar.MONTH) + 1);
		String day = String.valueOf(now.get(Calendar.DATE));
		String nowStr = year + "-" + month + "-" + day;
		java.text.DateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		java.util.Date nowDate =(java.util.Date) format.parse(nowStr + " 00:00:00");
		tCriteria.add(Expression.or(Expression.isNull("repayHandle"),
				Expression.or(Expression.isNull("repayNumber"),
				Expression.or(Expression.isNull("accountDate"),
				Expression.or(Expression.isNull("accountNumber"),
				Expression.or(Expression.isNull("fundNumber"),Expression.isNull("secretaryDate")))))));

		tCriteria.add(Expression.lt("repayDate",new java.util.Date(nowDate.getTime())));
		System.out.print(tCriteria.toString());
		List resultList = tCriteria.list();
		List resultList2 = new java.util.ArrayList();
		//針對公債   付息金額為0  秘書室跟付款憑單編號不需輸入將不須出現在未完成清單
		for(Iterator i=resultList.iterator();i.hasNext();){
			NationalDebtDueDateMain n = (NationalDebtDueDateMain)i.next();
			IssueMainDAO imDao = new IssueMainDAO();
			Session session = imDao.getSession();
			IssueMainDAO issueDAO = new IssueMainDAO();
			IssueMain issue = issueDAO.get(n.getIsseId(),session);
			if("A".equals(issue.getDebtType()) && BigDecimal.ZERO.compareTo(n.getInterestAmount()) == 0){
				System.out.println(issue.getDebtName()+"_"+n.getIsseId()+"_"+n.getRepayDate());
				
			}else{
				resultList2.add(n);
			}
		}
		return resultList2;
	}

	/**
	 * 國債還本付息處理進度維護作業提供查尋歷史資料，查尋條件為國債還本付息到期日區間，歷史資料只可查詢並不可修改。
	 * 
	 * @param unitInfoMain
	 * @return List
	 * @throws HibernateException
	 */
	public static List getByRange(String repayDateB, String repayDateE,
			Connection connection) throws Exception {
		NationalDebtDueDateMainDAO dao = new NationalDebtDueDateMainDAO();
		Session session = dao.getSession();
		Criteria criteria = session
				.createCriteria(NationalDebtDueDateMain.class);
		if (repayDateB != null && repayDateB.trim().length() > 0
				&& repayDateE != null && repayDateE.trim().length() > 0) {
			String year = String.valueOf(Integer.parseInt(repayDateB.substring(0, 3)) + 1911);
			String month = repayDateB.substring(3, 5);
			String day = repayDateB.substring(5, 7);
			String startDateStr = year + "-" + month + "-" + day ;
			year = String.valueOf(Integer.parseInt(repayDateE.substring(0, 3)) + 1911);
			month = repayDateE.substring(3, 5);
			day = String.valueOf(Integer.parseInt(repayDateE.substring(5, 7)) + 7);
			String endtDateStr = year + "-" + month + "-" + day;
			java.text.DateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			java.util.Date startDate = (java.util.Date) format.parse(startDateStr+" 00:00:00");
			java.util.Date endDate = (java.util.Date) format.parse(endtDateStr+" 00:00:00");
			criteria.add(Expression.between("repayDate", startDate, endDate));
		}
		//Calendar cal = Calendar.getInstance();
		//Date now = cal.getTime();
		//Calendar afterWeekAgo = Calendar.getInstance();
		//afterWeekAgo.add(Calendar.DATE ,7);//七天後
		//Date afterWeek = afterWeekAgo.getTime();
		///criteria.add(Expression.lt("repayDate", afterWeek)); 
		criteria.addOrder(Order.desc("repayDate"));
		System.out.println(criteria.toString());
		List collection = criteria.list();
		session.close();
		return collection;
	}
	
	public static List getByRange(String repayDateB, String repayDateE,
			Connection connection,int pagenum,int PAGE_SIZE) throws Exception {
		NationalDebtDueDateMainDAO dao = new NationalDebtDueDateMainDAO();
		Session session = dao.getSession();
		Criteria criteria = session
				.createCriteria(NationalDebtDueDateMain.class);
		if (repayDateB != null && repayDateB.trim().length() > 0
				&& repayDateE != null && repayDateE.trim().length() > 0) {
			String year = String.valueOf(Integer.parseInt(repayDateB.substring(0, 3)) + 1911);
			String month = repayDateB.substring(3, 5);
			String day = repayDateB.substring(5, 7);
			String startDateStr = year + "-" + month + "-" + day ;
			year = String.valueOf(Integer.parseInt(repayDateE.substring(0, 3)) + 1911);
			month = repayDateE.substring(3, 5);
			day = String.valueOf(Integer.parseInt(repayDateE.substring(5, 7)) + 7);
			String endtDateStr = year + "-" + month + "-" + day;
			java.text.DateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			java.util.Date startDate = (java.util.Date) format.parse(startDateStr+" 00:00:00");
			java.util.Date endDate = (java.util.Date) format.parse(endtDateStr+" 00:00:00");
			criteria.add(Expression.between("repayDate", startDate, endDate));
		}
		//Calendar cal = Calendar.getInstance();
		//Date now = cal.getTime();
		//Calendar afterWeekAgo = Calendar.getInstance();
		//afterWeekAgo.add(Calendar.DATE ,7);//七天後
		//Date afterWeek = afterWeekAgo.getTime();
		//criteria.add(Expression.lt("repayDate", afterWeek)); 
		//criteria.add(Expression.lt("repayDate", now)); 
		criteria.setMaxResults(PAGE_SIZE);
        criteria.setFirstResult(PAGE_SIZE*pagenum);
		criteria.addOrder(Order.desc("repayDate"));
		System.out.println(criteria.toString());
		List collection = criteria.list();
		session.close();
		return collection;
	}
	//RAMA小日曆
	public static String addCalendar(String textName,Integer num ,int typeId)
	{
		if( null == textName || "" == textName )	return null;
        String realName = "";
        if( "".equals(num) )
			realName	=	textName.substring(5,textName.length()-1);
        else
			realName	=	num.toString();
        StringBuffer sb = null;
        sb=new StringBuffer("\r\n<script language=\"JavaScript\" type=\"text/javascript\">\r\n");
        sb.append("<!--\r\n");
        sb.append("fooCalendar_"+realName+" = new dynCalendar('fooCalendar_"+realName+"', 'calendarCallback_"+realName+"', '/tapf/assets/images/calendar/');\r\n");
        sb.append("function calendarCallback_"+realName+"(date, month, year)\r\n");
        sb.append("{\r\n");
        sb.append("checkPermission("+typeId+");");
        sb.append("if(year-1911 < 100) {year = '0' + (year-1911)} else {year = ''+(year-1911)} ;\r\n");
        sb.append("if(month < 10) month = '0' + month ;\r\n");
        sb.append("if(date < 10) date = '0' + date ;\r\n");
        sb.append("document.getElementById('"+textName+"').value = year + month + date;\r\n");
        sb.append("}\r\n");
        sb.append("//-->\r\n");
        sb.append("</script>\r\n");
        return (sb.toString());
    }
}
