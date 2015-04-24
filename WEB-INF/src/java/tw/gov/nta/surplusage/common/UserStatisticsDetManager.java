package tw.gov.nta.surplusage.common;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import tw.gov.nta.sql.UserStatisticsDet;
import tw.gov.nta.sql.UserStatisticsMain;
import tw.gov.nta.sql.dao.UserStatisticsDetDAO;
import tw.gov.nta.sql.debt.IssueMain;

public class UserStatisticsDetManager
{
	private UserStatisticsDetDAO dao;

	public UserStatisticsDetManager() {
		dao = new UserStatisticsDetDAO();
	}

	public UserStatisticsDet get(Integer id) throws HibernateException
    {	
		return dao.get(id);
    }

    public void delete(Integer id) throws HibernateException
    {
    	UserStatisticsDet userStatisticsDet = new UserStatisticsDet();
    	syncUserStatisticsMainByDetDel(get(id));
    	dao.delete(id);
    }
    public void confirm(UserStatisticsDet userStatisticsDet){
    	dao.saveOrUpdate(userStatisticsDet);
    	syncUserStatisticsMainByDet(userStatisticsDet);
    }
    public void syncUserStatisticsMainByDetDel(UserStatisticsDet userStatisticsDet){
    	UserStatisticsMain tUserStatisticsMain = userStatisticsDet.getUserStatisticsMain();
    	if(userStatisticsDet.getDataType().equals("A")){
			if(userStatisticsDet.getBanish().equals("U")){
		    	if(tUserStatisticsMain.getAccountYear().trim().equals(userStatisticsDet.getAccountYear().trim())){
		    		tUserStatisticsMain.setKeepUamount1(tUserStatisticsMain.getKeepUamount1().add(userStatisticsDet.getSubAmount()));
		    		tUserStatisticsMain.setOddKeepUamount1(tUserStatisticsMain.getOddKeepUamount1().add(userStatisticsDet.getSubAmount()));
		    	}
		    	else{
		    		tUserStatisticsMain.setKeepUamount1(tUserStatisticsMain.getKeepUamount1().add(userStatisticsDet.getSubAmount()));
		    		tUserStatisticsMain.setOddKeepUamount1(tUserStatisticsMain.getOddKeepUamount1().add(userStatisticsDet.getSubAmount()).add(userStatisticsDet.getPlusdebtAmount()));
		    	}
		    }else if(userStatisticsDet.getBanish().equals("B")){
	    		if(tUserStatisticsMain.getAccountYear().trim().equals(userStatisticsDet.getAccountYear().trim())){
		    		tUserStatisticsMain.setKeepBamount1(tUserStatisticsMain.getKeepBamount1().add(userStatisticsDet.getSubAmount()));
		    		tUserStatisticsMain.setOddKeepBamount1(tUserStatisticsMain.getOddKeepBamount1().add(userStatisticsDet.getSubAmount()));
	    		}
	    		else{
	    			tUserStatisticsMain.setKeepBamount1(tUserStatisticsMain.getKeepBamount1().add(userStatisticsDet.getSubAmount()));
	    			tUserStatisticsMain.setOddKeepBamount1(tUserStatisticsMain.getOddKeepBamount1().add(userStatisticsDet.getSubAmount()).add(userStatisticsDet.getPlusdebtAmount()));
	    		}
	    	}
		}
		if(userStatisticsDet.getDataType().equals("C")){
			if(userStatisticsDet.getBanish().equals("U")){
		    	if(tUserStatisticsMain.getAccountYear().trim().equals(userStatisticsDet.getAccountYear().trim())){
		    		tUserStatisticsMain.setKeepUamount2(tUserStatisticsMain.getKeepUamount2().add(userStatisticsDet.getSubAmount()));
		    		tUserStatisticsMain.setOddKeepUamount2(tUserStatisticsMain.getOddKeepUamount2().add(userStatisticsDet.getSubAmount()));
		    	}
		    	else{
		    		tUserStatisticsMain.setKeepUamount2(tUserStatisticsMain.getKeepUamount2().add(userStatisticsDet.getSubAmount()));
		    		tUserStatisticsMain.setOddKeepUamount2(tUserStatisticsMain.getOddKeepUamount2().add(userStatisticsDet.getSubAmount()).add(userStatisticsDet.getPlusdebtAmount()));
		    	}
	    	}else if(userStatisticsDet.getBanish().equals("B")){
	    		if(tUserStatisticsMain.getAccountYear().equals(userStatisticsDet.getAccountYear())){
		    		tUserStatisticsMain.setKeepBamount2(tUserStatisticsMain.getKeepBamount2().add(userStatisticsDet.getSubAmount()));
		    		tUserStatisticsMain.setOddKeepBamount2(tUserStatisticsMain.getOddKeepBamount2().add(userStatisticsDet.getSubAmount()));
	    		}
		    	else{
		    		tUserStatisticsMain.setKeepBamount2(tUserStatisticsMain.getKeepBamount2().add(userStatisticsDet.getSubAmount()));
		    		tUserStatisticsMain.setOddKeepBamount2(tUserStatisticsMain.getOddKeepBamount2().add(userStatisticsDet.getSubAmount()).add(userStatisticsDet.getPlusdebtAmount()));
		    	}
	    	}
		}
		new UserStatisticsManager().update(tUserStatisticsMain);
    }
    public void syncUserStatisticsMainByDet(UserStatisticsDet userStatisticsDet){
    	UserStatisticsMain tUserStatisticsMain = userStatisticsDet.getUserStatisticsMain();
    	BigDecimal keepAmount = userStatisticsDet.getKeepAmount();
    	if(userStatisticsDet.getDataType().equals("A")){
			if(userStatisticsDet.getBanish().equals("U")){
		    	tUserStatisticsMain.setKeepUamount1(tUserStatisticsMain.getKeepUamount1().subtract(userStatisticsDet.getSubAmount()));
		    	tUserStatisticsMain.setOddKeepUamount1(keepAmount);
			}
	    	else if(userStatisticsDet.getBanish().equals("B")){
		    	tUserStatisticsMain.setKeepBamount1(tUserStatisticsMain.getKeepBamount1().subtract(userStatisticsDet.getSubAmount()));
		    	tUserStatisticsMain.setOddKeepBamount1(keepAmount);
	    	}
		}
		if(userStatisticsDet.getDataType().equals("C")){
			if(userStatisticsDet.getBanish().equals("U")){
		    	tUserStatisticsMain.setKeepUamount2(tUserStatisticsMain.getKeepUamount2().subtract(userStatisticsDet.getSubAmount()));
		    	tUserStatisticsMain.setOddKeepUamount2(keepAmount);
			}
	    	else if(userStatisticsDet.getBanish().equals("B")){
		    	tUserStatisticsMain.setKeepBamount2(tUserStatisticsMain.getKeepBamount2().subtract(userStatisticsDet.getSubAmount()));
		    	tUserStatisticsMain.setOddKeepBamount2(keepAmount);
	    	}
		}
		new UserStatisticsManager().update(tUserStatisticsMain);
//    	List list = getBeanByMainMaxYear(tUserStatisticsMain.getId());
//    	BigDecimal keepAmountA = new BigDecimal(0);
//    	BigDecimal keepAmountC = new BigDecimal(0);
//    	BigDecimal auditAmountA = new BigDecimal(0);
//    	BigDecimal auditAmountC = new BigDecimal(0);
//    	for(Iterator it = list.iterator();it.hasNext();){
//    		UserStatisticsDet dto = (UserStatisticsDet)it.next();
//    		if(dto.getDataType().equals("A")){
//    			if(tUserStatisticsMain.getAccountYear().equals(userStatisticsDet.getAccountYear()))
//    				keepAmountA = keepAmountA.add(dto.getKeepAmount());
//    			else
//    				keepAmountA = keepAmountA.add(dto.getKeepAmount()).add(dto.getPlusdebtAmount()).add(dto.getRealAmount());
//    			auditAmountA = auditAmountA.add(dto.getAuditAmount());
//    			if(userStatisticsDet.getId()!= null){
//	    			if(userStatisticsDet.getBanish().equals("U")){
//	    		    	tUserStatisticsMain.setAuditUamount1(auditAmountA);
//	    		    	if(tUserStatisticsMain.getAccountYear().equals(userStatisticsDet.getAccountYear()))
//	    		    		tUserStatisticsMain.setKeepUamount1(keepAmountA);
//	    		    	else
//	    		    		tUserStatisticsMain.setKeepUamount1(keepAmountA.subtract(tUserStatisticsMain.getRealUamount1()));
//	    	    	}else if(userStatisticsDet.getBanish().equals("B")){
//	    	    		tUserStatisticsMain.setAuditBamount1(auditAmountA);
//	    	    		if(tUserStatisticsMain.getAccountYear().equals(userStatisticsDet.getAccountYear()))
//	    		    		tUserStatisticsMain.setKeepBamount1(keepAmountA);
//	    	    		else
//	    	    			tUserStatisticsMain.setKeepBamount1(keepAmountA.subtract(tUserStatisticsMain.getRealBamount1()));
//	    	    	}
//    			}
//    			else{
//    				if(dto.getBanish().equals("U")){
//	    		    	tUserStatisticsMain.setAuditUamount1(auditAmountA);
//	    		    	tUserStatisticsMain.setKeepUamount1(keepAmountA.subtract(tUserStatisticsMain.getRealUamount1()));
//	    	    	}else if(dto.getBanish().equals("B")){
//	    	    		tUserStatisticsMain.setAuditBamount1(auditAmountA);
//	    	    		tUserStatisticsMain.setKeepBamount1(keepAmountA.subtract(tUserStatisticsMain.getRealBamount1()));
//	    	    	}
//    			}
//	    			
//    		}
//    		if(dto.getDataType().equals("C")){
//    			if(tUserStatisticsMain.getAccountYear().equals(userStatisticsDet.getAccountYear()))
//    				keepAmountC = keepAmountC.add(dto.getKeepAmount());
//    			else
//    				keepAmountC = keepAmountC.add(dto.getKeepAmount().add(dto.getPlusdebtAmount()).add(dto.getRealAmount()));
//    			auditAmountC = auditAmountC.add(dto.getAuditAmount());
//    			if(userStatisticsDet.getId()!= null){
//	    			if(userStatisticsDet.getBanish().equals("U")){
//	    		    	tUserStatisticsMain.setAuditUamount2(auditAmountC);
//	    		    	if(tUserStatisticsMain.getAccountYear().equals(userStatisticsDet.getAccountYear()))
//	    		    		tUserStatisticsMain.setKeepUamount2(keepAmountC);
//	    		    	else
//	    		    		tUserStatisticsMain.setKeepUamount2(keepAmountC.subtract(tUserStatisticsMain.getRealUamount2()));
//	    	    	}else if(userStatisticsDet.getBanish().equals("B")){
//	    	    		tUserStatisticsMain.setAuditBamount2(auditAmountC);
//	    	    		if(tUserStatisticsMain.getAccountYear().equals(userStatisticsDet.getAccountYear()))
//	    		    		tUserStatisticsMain.setKeepBamount2(keepAmountC);
//	    		    	else
//	    		    		tUserStatisticsMain.setKeepBamount2(keepAmountC.subtract(tUserStatisticsMain.getRealBamount2()));
//	    	    	}
//    			}
//    			else{
//    				if(dto.getBanish().equals("U")){
//	    		    	tUserStatisticsMain.setAuditUamount2(auditAmountC);
//	    		    	tUserStatisticsMain.setKeepUamount2(keepAmountC.subtract(tUserStatisticsMain.getRealUamount2()));
//	    	    	}else if(dto.getBanish().equals("B")){
//	    	    		tUserStatisticsMain.setAuditBamount2(auditAmountC);
//	    	    		tUserStatisticsMain.setKeepBamount2(keepAmountC.subtract(tUserStatisticsMain.getRealBamount2()));
//	    	    	}
//    			}
//    		}
//    	}
    }
    public List getBeanByMain(int pMainId)
	{
		Session tSession = dao.getSession();
		Criteria tCriteria = tSession.createCriteria(UserStatisticsDet.class);
		tCriteria.add(Expression.eq("userStatisticsMain.id", pMainId));
		tCriteria.addOrder(Order.asc("accountYear"));
		List tResult = tCriteria.list();
		tSession.close();
		return tResult;
	}
    public List getBeanByMainMaxYear(int pMainId)
	{
		Session tSession = dao.getSession();
		StringBuffer hqlStr = new StringBuffer("select isNull(max(det.accountYear),'') from UserStatisticsDet det where 1 = 1");
		hqlStr.append( "  and det.userStatisticsMain.id=" +pMainId);
        Query query = tSession.createQuery(hqlStr.toString());
        String maxYear = "";
        List list = query.list();
        for(Iterator it = list.iterator();it.hasNext();){
        	maxYear = ((String)it.next()).trim();
        }
		Criteria tCriteria = tSession.createCriteria(UserStatisticsDet.class);
		tCriteria.add(Expression.eq("userStatisticsMain.id", pMainId));
		tCriteria.add(Expression.eq("accountYear", maxYear));
		List tResult = tCriteria.list();
		return tResult;
	}
    public List getBeanByMaxYearDiacriticTypeBanish(int pMainId)
	{
		Session tSession = dao.getSession();
//		StringBuffer hqlStr = new StringBuffer("select isNull(max(det.accountYear),'') from UserStatisticsDet det where 1 = 1");
//		hqlStr.append( "  and det.userStatisticsMain.id=" +pMainId);
		
		StringBuffer hqlStr = new StringBuffer("from UserStatisticsDet det where det.userStatisticsMain.id = " +pMainId);
		hqlStr.append( " and det.accountYear = ");
		hqlStr.append( " (select max(this_det.accountYear) from UserStatisticsDet this_det");
		hqlStr.append( " where this_det.userStatisticsMain.id = " +pMainId+"  and this_det.dataType = det.dataType and this_det.banish = det.banish)");
		
        Query query = tSession.createQuery(hqlStr.toString());
		List tResult = query.list();
		return tResult;
	}
    /**取得最大年份
     *
     */
    public String getMaxAccountYearByMainId(int pMainId)
	{
		Session tSession = dao.getSession();
		StringBuffer hqlStr = new StringBuffer("select max(det.accountYear) from UserStatisticsDet det where 1 = 1");
		hqlStr.append( "  and det.userStatisticsMain.id=" +pMainId);
        Query query = tSession.createQuery(hqlStr.toString());
        String maxYear = "";
        for(Iterator it = query.list().iterator();it.hasNext();){
        	maxYear = ((String)it.next()).trim();
        }
		return maxYear;
	}
    public List Search(String[] pCols, Object[] pValues, String[] pConds, String[] pOrderby){
		Session tSession = dao.getSession();
		Criteria criteria = tSession.createCriteria(UserStatisticsDet.class);
		if(pCols != null && pValues != null && pConds != null){
			for(int i = 0 ; i < pCols.length ; i++){
				if(pCols[i] == null || pValues[i] == null || pConds[i] == null || "".equals(pCols[i]) || "".equals(pValues[i]) || "".equals(pConds[i]))
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
					criteria.add(Expression.like(pCols[i], pValues[i]));
				else if(pConds[i].equals("in"))
					criteria.add(Expression.in(pCols[i], (Object [])pValues[i]));
			}
		}
		if(pOrderby != null){
			for(int i = 0 ; i < pOrderby.length ; i++){
				if(pOrderby[i] == null || "".equals(pOrderby[i])) continue;
				criteria.addOrder(Order.desc(pOrderby[i]));
			}
		}
		List tResultList = criteria.list();
		tSession.close();
		return tResultList;
	}
    
}
