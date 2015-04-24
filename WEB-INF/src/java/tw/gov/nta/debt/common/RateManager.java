package tw.gov.nta.debt.common;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.DebtRateDet;
import tw.gov.nta.sql.debt.dao.DebtRateDetDAO;
import tw.gov.nta.sql.debt.dao.IssueMainDAO;

public class RateManager extends IManager {
	 
	/**
	 * 更新issueMain下所有debt之rate
	 * @param issueId,debtRateList
	 * @return null
	 */
	public void upDateIssueRate(int pIssueId,List pDebtRateList){
		List tDebtMainList = new DebtManager().getBeanByIssue(pIssueId);
		for(Iterator debtIt = tDebtMainList.iterator();debtIt.hasNext();){
			DebtMain tDebtMain = (DebtMain)debtIt.next();
			List tRateList = getEffectiveRate(tDebtMain.getId());
			for(Iterator rateIt = tRateList.iterator();rateIt.hasNext();){
				DebtRateDet tDebtRateDet = (DebtRateDet)rateIt.next();
				setDeleteRemark(tDebtMain.getId(),tDebtRateDet.getGroupId());
			}
			List tDebtRateDetList = new LinkedList();
			for(Iterator rateIt = pDebtRateList.iterator();rateIt.hasNext();){
				DebtRateDet tDebtRateDet = (DebtRateDet)rateIt.next();
				tDebtRateDet.setDebt(tDebtMain);
				tDebtRateDet.setId(null);
				tDebtRateDetList.add(tDebtRateDet);
			}
			confirm(tDebtRateDetList);
		}
	}
	
	
	
	
	
	/**
	 * 新增利率
	 * @param pDebtId
	 * @return
	 */
	public DebtRateDet createBean(int pDebtId) {
		DebtRateDet tDebtRateDetDto = new DebtRateDet();
		tDebtRateDetDto.setDebt(new DebtManager().getBean(pDebtId));
		tDebtRateDetDto.setDeleteMark("N");
		return tDebtRateDetDto;
	}
	 
	/**
	 * 取得該筆借款目前有效利率
	 * @param pDebtId
	 * @return
	 */
	public List getEffectiveRate(int pDebtId) {
		int tGroupId = getEffectRateGroupId(pDebtId);
		return this.getRateByGroupId(pDebtId, tGroupId);
	}
	/** **/
	public BigDecimal getEffectiveRate(int pDebtId,Date effectiveDate) {
		int tGroupId = getEffectRateGroupId(pDebtId);
		List list = this.getRateByGroupId(pDebtId, tGroupId);
		if(null != list && 0 != list.size())
		{
			for(Iterator it = list.iterator();it.hasNext();)
			{
				DebtRateDet debtRatedet = (DebtRateDet)it.next();
				if((effectiveDate.equals(debtRatedet.getEffectiveDate()) || 
						(1 == effectiveDate.compareTo(debtRatedet.getEffectiveDate()))) 
						&&  (effectiveDate.equals(debtRatedet.getSuspendDate()) || 
								(-1 == effectiveDate.compareTo(debtRatedet.getSuspendDate()))))
				{
					return debtRatedet.getDebtRate();
				}	
			}	
			
		}	
		return new BigDecimal(0);
	}

	/**
	 * 取得該筆借款目前有效利率
	 * @param debt
	 * @return
	 */
	public List getEffectiveRate(DebtMain debt,Session session) {
		int tGroupId = getEffectRateGroupId(debt,session);
		return this.getRateByGroupId(debt, tGroupId,session);
	}	
	
	/**
	 * 取得利率Dto
	 */
	public Object getBean(int pRateId) {
		return new DebtRateDetDAO().get(new Integer(pRateId));
	}
	 
	/**
	 * 確定是否可修改，目前只回應true
	 * @param bean
	 * @return
	 */
	public boolean isModify(DebtRateDet bean) {
		return true;
	}
	 
	/**
	 * 取得目前有效利率
	 * @param pDebtId
	 * @return
	 */
	public int getEffectRateGroupId(int pDebtId) {
		Session tSession = new DebtRateDetDAO().getSession();
		Criteria criteria = tSession.createCriteria(DebtRateDet.class);
		DebtMain tDebtMainDto = new DebtMain();
		tDebtMainDto.setId(new Integer(pDebtId));
		criteria.add(Expression.eq("debt", tDebtMainDto));		
		criteria.add(Restrictions.eq("deleteMark", "N"));
		List tList = criteria.list();
		DebtRateDet tDebtRateDet = null;
		int tMax = Integer.MIN_VALUE;
		for(Iterator tIterator = tList.iterator(); tIterator.hasNext();){
			tDebtRateDet = (DebtRateDet) tIterator.next();
			if(tMax < tDebtRateDet.getGroupId().intValue())
				tMax = tDebtRateDet.getGroupId().intValue();
		}
		tSession.close();
		return tMax;
	}

	/**
	 * 取得目前有效利率
	 * @param pDebtId
	 * @return
	 */
	public int getEffectRateGroupId(DebtMain debt ,Session session) {
		Criteria criteria = session.createCriteria(DebtRateDet.class);
		criteria.add(Expression.eq("debt", debt));		
		criteria.add(Expression.eq("deleteMark", "N"));
		List tList = criteria.list();
		DebtRateDet tDebtRateDet = null;
		int tMax = Integer.MIN_VALUE;
		for(Iterator tIterator = tList.iterator(); tIterator.hasNext();){
			tDebtRateDet = (DebtRateDet) tIterator.next();
			if(tMax < tDebtRateDet.getGroupId().intValue())
				tMax = tDebtRateDet.getGroupId().intValue();
		}
		return tMax;
	}	
	/**
	 * 依利率groupId取得一組利率
	 * @param pGroupId
	 * @return
	 */
	public List<DebtRateDet> getRateByGroupId(int pDebtId, int pGroupId){
		Session tSession = new DebtRateDetDAO().getSession();
		Criteria criteria = tSession.createCriteria(DebtRateDet.class);
		criteria.add(Expression.eq("groupId", pGroupId));
		DebtMain tDebtMain = new DebtMain();
		tDebtMain.setId(new Integer(pDebtId));
		criteria.add(Expression.eq("debt", tDebtMain));
		List<DebtRateDet> tList = criteria.list();
		tSession.close();
		return tList;
	}

	
	/**
	 * 依利率groupId取得一組利率
	 * @param pGroupId
	 * @return
	 */
	public List<DebtRateDet> getRateByGroupId(DebtMain debt, int pGroupId,Session session){
		Criteria criteria = session.createCriteria(DebtRateDet.class);
		criteria.add(Expression.eq("groupId", pGroupId));
		criteria.add(Expression.eq("debt", debt));
		List<DebtRateDet> tList = criteria.list();
		return tList;
	}	
	/**
	 * 取得該筆借款之下一筆groupId
	 * @return
	 */
	public int getNextGroupId(int pDebtId) {
		Session tSession = new DebtRateDetDAO().getSession();
		Criteria criteria = tSession.createCriteria(DebtRateDet.class);
		DebtMain tDebtMain = new DebtMain();
		tDebtMain.setId(pDebtId);
		criteria.add(Expression.eq("debt", tDebtMain));
		criteria.setProjection(Projections.max("groupId"));
		List tResultList = criteria.list();
		tSession.close();
		if(tResultList == null || tResultList.size() == 0 || tResultList.get(0) == null)
			return 1;
		else
			return ((Integer)tResultList.get(0)).intValue() + 1;
	}
	 
	/**
	 *新增利率
	 */
	public void confirm(Object pDto) {
		if(pDto == null) return;
		List tList = new LinkedList();
		tList.add(pDto);
		confirm(tList);
//		DebtRateDet tDebtRateDetDto = (DebtRateDet)pDto;
//		DebtRateDet tTempDebtRateDetDto = null;
//		DebtRateDetDAO tDebtRateDetDAO = new DebtRateDetDAO();
//		List<DebtRateDet> tList = null;
//		if(tDebtRateDetDto.getGroupId() != null)
//			tList = this.getRateByGroupId(tDebtRateDetDto.getDebt().getId().intValue(), tDebtRateDetDto.getGroupId());
//		if(tList == null || tList.size() == 0){
//			tDebtRateDetDto.setGroupId(new RateManager().getNextGroupId(tDebtRateDetDto.getDebt().getId().intValue()));
//			tDebtRateDetDto.setDeleteMark(String.valueOf(tDebtRateDetDto.getGroupId()));
//			tDebtRateDetDAO.saveOrUpdate(tDebtRateDetDto);
//			if(tDebtRateDetDto.getGroupId().intValue() != 1)
//				new InterestAdjustManager().countInterestAdjust(tDebtRateDetDto.getDebt().getId(), tDebtRateDetDto.getGroupId(), 0);
//		}
//		else{
//			for(int i = 0 ; i < tList.size() ;i++){
//				tTempDebtRateDetDto = (DebtRateDet) tList.get(i);
//				if(tTempDebtRateDetDto.getId().intValue() == tDebtRateDetDto.getId().intValue()){
//					tList.set(i, tDebtRateDetDto);
//					break;
//				}					
//			}
//			confirm(tList);
//		}
	}
	 
	/**
	 * 新增利率
	 */
	public void confirm(List pDebtRateDetDtoList){
		if(pDebtRateDetDtoList == null || pDebtRateDetDtoList.size() == 0)return;
		int tDebtId = ((DebtRateDet)pDebtRateDetDtoList.get(0)).getDebt().getId();
		int tGroupId = getNextGroupId(tDebtId);
		DebtRateDet tDebtRateDet = null;
		for(Iterator tIterator = pDebtRateDetDtoList.iterator(); tIterator.hasNext();){
			tDebtRateDet = (DebtRateDet) tIterator.next();
			if(tDebtRateDet.getGroupId() != null)
				break;
		}
		Integer tOldGroupId = tDebtRateDet.getGroupId();
//		boolean tIsGroupIdNull = tDebtRateDet.getGroupId() == null;
		if(tOldGroupId != null)
			setDeleteRemark(tDebtId, tDebtRateDet.getGroupId().intValue());
		DebtRateDetDAO tDebtRateDetDAO = new DebtRateDetDAO();
		Iterator tIterator = pDebtRateDetDtoList.iterator();
		DebtRateDet tDebtRateDetDto = null;
		while(tIterator.hasNext()){
			tDebtRateDetDto = (DebtRateDet) tIterator.next();
			tDebtRateDetDto.setGroupId(tGroupId);
			tDebtRateDetDAO.saveOrUpdate(tDebtRateDetDto);
			tDebtRateDetDto.setGroupId(tOldGroupId);
		}
	}
	
	/**
	 *check率利Dto
	 */
	public boolean checkBean(Object pDto) {
		DebtRateDet tDebtRateDetDto = (DebtRateDet)pDto;
		return tDebtRateDetDto.getEffectiveDate().before(tDebtRateDetDto.getSuspendDate()) && tDebtRateDetDto.getDebtRate().doubleValue() > 0;
	}
	
	/**
	 * 刪除某借款下之所有利率
	 * @param pDebtId
	 */
	public void deleteByDebtId(int pDebtId){
		DebtRateDetDAO tDebtRateDetDAO = new DebtRateDetDAO();
		Session tSession = tDebtRateDetDAO.getSession();
		Criteria criteria = tSession.createCriteria(DebtRateDet.class);
		DebtMain tDebtMain = new DebtMain();
		tDebtMain.setId(new Integer(pDebtId));
		criteria.add(Expression.eq("debt", tDebtMain));
		Iterator tIterator = criteria.list().iterator();
		while(tIterator.hasNext())
			tDebtRateDetDAO.delete((DebtRateDet)tIterator.next());
		tSession.close();
	}
	
	/**
	 * 將某一groupId之利率註記為刪除
	 * @param pGroupId
	 */
	public void setDeleteRemark(int pDebtId, int pGroupId){
		DebtRateDetDAO tDebtRateDetDAO = new DebtRateDetDAO();
		Session tSession = tDebtRateDetDAO.getSession();
		Criteria criteria = tSession.createCriteria(DebtRateDet.class);
		DebtMain tDebtMainDto = new DebtMain();
		tDebtMainDto.setId(new Integer(pDebtId));
		criteria.add(Expression.eq("debt", tDebtMainDto));
		criteria.add(Expression.eq("groupId", new Integer(pGroupId)));
		Iterator tIterator = criteria.list().iterator();
		DebtRateDet tDebtRateDetDto = null;
		while(tIterator.hasNext()){
			tDebtRateDetDto = (DebtRateDet) tIterator.next();
			tDebtRateDetDto.setDeleteMark("Y");
			tDebtRateDetDAO.update(tDebtRateDetDto);
		}
		tSession.close();
	}
	
	/**
	 * 刪除某筆利率資料
	 * @param pId
	 */
	public void cancel(int pId){
		DebtRateDet tDebtRateDet = (DebtRateDet) getBean(pId); 
		List tList = this.getRateByGroupId(tDebtRateDet.getDebt().getId().intValue(), tDebtRateDet.getGroupId());
		if(tDebtRateDet != null && isModify(tDebtRateDet)){
			for(Iterator tIterator = tList.iterator(); tIterator.hasNext() ; ){
				tDebtRateDet = (DebtRateDet) tIterator.next();
				tDebtRateDet.setDeleteMark("Y");
			}
			confirm(tList);
		}
	}
	public DebtRateDet getMaxDueDateRate(DebtMain tDebtMain){
		DebtRateDetDAO tDebtRateDetDAO = new DebtRateDetDAO();
		Session tSession = tDebtRateDetDAO.getSession();
		String hql = "select det.id from DebtRateDet det where 1=1";
		hql +=" and det.suspendDate = (select max(d.suspendDate) from DebtRateDet d where d.debt.id = "+tDebtMain.getId()+" and d.deleteMark = 'N')";
		hql +=" and det.debt.id = "+tDebtMain.getId();
		hql +=" and det.deleteMark = 'N'";
		Query query = tSession.createQuery(hql);
		Integer rateId = (Integer)query.list().get(0);
		return (DebtRateDet) getBean(rateId.intValue());
	}
}
 
