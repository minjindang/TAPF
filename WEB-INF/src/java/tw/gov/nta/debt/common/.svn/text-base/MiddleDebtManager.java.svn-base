package tw.gov.nta.debt.common;

import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.DebtPlanDet;
import tw.gov.nta.sql.debt.DebtRateDet;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.dao.DebtPlanDetDAO;

public class MiddleDebtManager extends DebtManager{
	
	/**
	 * 確認借款
	 * @param pDebtMainDto:借款資料物件
	 * @throws Exception 
	 */
	public void confirm(DebtMain pDebtMainDto) throws Exception{
		super.confirm(pDebtMainDto);
		//2.如果目前無利率資料，則新增利率
		List tList = new RateManager().getEffectiveRate(pDebtMainDto.getId()); 
		if(tList == null || tList.size() == 0){
			DebtRateDet tDebtRateDetDto = new RateManager().createBean(pDebtMainDto.getId());
			tDebtRateDetDto.setDebt(pDebtMainDto);
			tDebtRateDetDto.setDebtRate(pDebtMainDto.getCompareRate());
			tDebtRateDetDto.setEffectiveDate(pDebtMainDto.getIssue().getIssueDate());
			tDebtRateDetDto.setSuspendDate(pDebtMainDto.getIssue().getDueDate());
			new RateManager().confirm(tDebtRateDetDto);
		}
		
		IssueMain myIssue = pDebtMainDto.getIssue();
		PlanManager planManager = new PlanManager();
		Calendar startDate = Calendar.getInstance();
		Calendar endDate = Calendar.getInstance();
		startDate.setTime(myIssue.getIssueDate());
		endDate.setTime(myIssue.getDueDate());
		int isOver = 1;
		int monthCompare = startDate.get(Calendar.MONTH) - endDate.get(Calendar.MONTH);
		int dayCompare = startDate.get(Calendar.DAY_OF_MONTH) - endDate.get(Calendar.DAY_OF_MONTH);
		int years = DateUtil.getDays(startDate.getTime(),endDate.getTime())/365;
		List planBeans = new LinkedList();
		DebtPlanDet newPlan = new DebtPlanDet();
		if((monthCompare == 0) && (dayCompare == 0))
		{
			isOver = 0;
		}
		
				/**
				 * 付息計劃和還本計劃 start 當debtMain.issueAmount大於0才新增
				 */
		PayManager paymanager = new PayManager();
		List paymentList = paymanager.getListByDebt(pDebtMainDto.getId());
		if(null == paymentList || 0 == paymentList.size())
		{
			if(null != pDebtMainDto.getIssueAmount() && new BigDecimal(0).longValue() < pDebtMainDto.getIssueAmount().setScale(0,BigDecimal.ROUND_HALF_UP).longValue())
			{	
					if(0 != isOver)
					{
						years = years + 1;	//判斷是否為同天
					}	
					for(int i = 0 ;i<years;i++)
					{
						newPlan = new DebtPlanDet();
						newPlan.setId(null);
						newPlan.setIssueId(myIssue.getId());
						newPlan.setDebt(pDebtMainDto);
						newPlan.setDeleteMark("N");
						newPlan.setCapitalAmount(new BigDecimal(0));
						newPlan.setChargeAmount(new BigDecimal(0));
						newPlan.setInterestAmount(new BigDecimal(0));
						newPlan.setRepayDate(DateUtil.str2Date(DateUtil.dateFlipMonth(DateUtil.date2Str(startDate.getTime()),12*(1+i))));
						if(i >= years - 1)									//為最後1筆時
						{
							newPlan.setRepayDate(endDate.getTime());				//付息日為dueDate
							newPlan.setCapitalAmount(pDebtMainDto.getIssueAmount());	//還本計劃和付息計劃最後一筆差在CapitalAmount
						}
						planBeans.add(newPlan);							//加到List
					}
			
					
					if(null != planBeans && 0 != planBeans.size())
					{
						StringBuffer strBuf = new StringBuffer();
						Session session = new DebtPlanDetDAO().createNewSession();
						strBuf.append("Update DebtPlanDet debtPlanDet Set debtPlanDet.deleteMark = 'Y' Where debtPlanDet.debt.id = ");
						strBuf.append(pDebtMainDto.getId());
						Query query = session.createQuery(strBuf.toString());
						query.executeUpdate();
						
						new InterestCounter().planListCountInterest(planBeans);//算利息

						BigDecimal interestAmount = new BigDecimal("0");
						for(Iterator it = planBeans.iterator();it.hasNext();)
						{
							DebtPlanDet debtPlan = (DebtPlanDet)it.next();
							planManager.confirm(debtPlan);				//新增付息計劃和還本計劃
							interestAmount = interestAmount.add(debtPlan.getInterestAmount());
						}
						if(!pDebtMainDto.getOriginInterestAmount().equals(interestAmount)){
							pDebtMainDto.setOriginInterestAmount(interestAmount);
							strBuf = new StringBuffer("");
							strBuf.append("Update DebtMain debtMain Set debtMain.originInterestAmount =");
							strBuf.append(interestAmount);
							strBuf.append(" Where debtMain.id = ");
							strBuf.append(pDebtMainDto.getId());
							query = session.createQuery(strBuf.toString());
							query.executeUpdate();
						}
						session.close();
					}
			}
			
			
			/** 等於零時刪除 plan **/
			if(pDebtMainDto.getIssueAmount().equals(new BigDecimal(0)))
			{	
				if(null != pDebtMainDto.getId())
				{	
					planManager.cancelByDebt(pDebtMainDto.getId());
				}	
			}
			
			
			
		}	
		/**
		 * 付息計劃和還本計劃 end
		 */
		
	
		updateIssueData(pDebtMainDto.getIssue().getId());			
	}

	/**
	 * 取消借款
	 */
	public void cancel(int pDebtId) throws Exception{
		int issueId = getBean(pDebtId).getIssue().getId().intValue();
		new RateManager().deleteByDebtId(pDebtId);
		new PlanManager().cancelByDebt(pDebtId);
		super.cancel(pDebtId);
		updateIssueData(issueId);
	}
	
	/**
	 * 更新發行資料(實際借款金額，加權平均利率)
	 * @param pIssueId
	 * @throws Exception
	 */
	private void updateIssueData(int pIssueId) throws Exception{
		IssueMain tIssueMainDto = new IssueManager().getBean(pIssueId);
		//計算發行金額
		BigDecimal tIssueAmount = new DebtManager().getAmountByIssue(pIssueId);
		//計算發行加權利率
		double tPowerRate = 0;
		List tDebtList = new DebtManager().getBeanByIssue(pIssueId);
		DebtMain tDebtMainDto = null;
		Iterator tIterator = tDebtList.iterator();
		while(tIterator.hasNext()){
			tDebtMainDto = (DebtMain) tIterator.next();
			if(!"Y".equalsIgnoreCase(tDebtMainDto.getAccrue()))
				continue;
			tPowerRate += tDebtMainDto.getIssueAmount().doubleValue() * tDebtMainDto.getCompareRate().doubleValue();
		}
		if(tIssueAmount.intValue() == 0)
			tIssueMainDto.setAverageRate(new BigDecimal(0));
		else
			tIssueMainDto.setAverageRate((new BigDecimal(tPowerRate)).divide(tIssueAmount,4,5));
		tIssueMainDto.setIssueAmount(tIssueAmount);
		new IssueManager().confirm(tIssueMainDto);		
	}
}