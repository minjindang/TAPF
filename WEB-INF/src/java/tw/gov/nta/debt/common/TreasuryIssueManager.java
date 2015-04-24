package tw.gov.nta.debt.common;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.DebtPlanDet;
import tw.gov.nta.sql.debt.DebtRateDet;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.dao.IssueMainDAO;

public class TreasuryIssueManager extends IssueManager
{
	/**
	 * 取得發行Bean
	 */
	public IssueMain getBean(Integer pId)
	{
		return new IssueMainDAO().get(pId);
	}
	/**
	 * 新增發行Bean
	 */
	public IssueMain createBean(String debtType)
	{
		IssueMain tIssueMain = new IssueMain(); 
		tIssueMain.setDebtType(debtType);
		return tIssueMain;
	}
	
	public boolean checkBean(Object pDto)
	{
		//IssueMain pIssueMain = (IssueMain) pDto;
		return true;
	}
	/**
	 * 新增發行
	 * @return
	 * @throws Exception 
	 */
	public void confirm(Object pDto) throws Exception
	{
		IssueMain tIssueMainDto = (IssueMain) pDto;
		if(!checkBean(tIssueMainDto))
			return;
		super.confirm(tIssueMainDto);
		DebtMain tDebtMainDto = new DebtMain();
		List tDebtMainDtoList = new DebtManager().getBeanByIssue(tIssueMainDto.getId());
		if ( tDebtMainDtoList.isEmpty() )
		{
			System.out.println(tIssueMainDto);
			tDebtMainDto.setDebtCode(tIssueMainDto.getDebtCode());
			tDebtMainDto.setBudgetCode(tIssueMainDto.getBudgetCode());
			tDebtMainDto.setIssueAmount(tIssueMainDto.getIssueAmount());
			tDebtMainDto.setRealAmount(tIssueMainDto.getRealAmount());
			tDebtMainDto.setIssue(tIssueMainDto);
			tDebtMainDto.setDiversityAmount(tDebtMainDto.getIssueAmount().subtract(tDebtMainDto.getRealAmount()));
			new DebtManager().confirm(tDebtMainDto);
		}
		else
			tDebtMainDto = (DebtMain)new DebtManager().getBeanByIssue(tIssueMainDto.getId()).get(0);
		
		if(new RateManager().getEffectiveRate(tDebtMainDto.getId()).size()>0)
			new RateManager().deleteByDebtId(tDebtMainDto.getId());
		
		DebtRateDet tDebtRateDet = new RateManager().createBean(tDebtMainDto.getId());
		tDebtRateDet.setDebt(tDebtMainDto);
		tDebtRateDet.setDebtRate(tIssueMainDto.getAverageRate());
		tDebtRateDet.setEffectiveDate(tIssueMainDto.getIssueDate());
		tDebtRateDet.setSuspendDate(tIssueMainDto.getDueDate());
		tDebtRateDet.setDeleteMark("N");
		new RateManager().confirm(tDebtRateDet);
		new PlanManager().cancelByDebt(tDebtMainDto.getId());
		DebtPlanDet tDebtPlanDet = new PlanManager().createBean(tDebtMainDto.getId());
		tDebtPlanDet.setIssueId(tIssueMainDto.getId());
		tDebtPlanDet.setDebt(tDebtMainDto);
		tDebtPlanDet.setCapitalAmount(tIssueMainDto.getRealAmount());
		tDebtPlanDet.setRepayDate(tIssueMainDto.getDueDate());
		tDebtPlanDet.setInterestAmount(tDebtMainDto.getIssueAmount().subtract(tDebtMainDto.getRealAmount()));
//		tDebtPlanDet.setInterestAmount(new InterestCounter().countInterest(tIssueMainDto.getIssueDate(),tIssueMainDto.getDueDate(),new RateManager().getEffectiveRate(tDebtMainDto.getId()),tIssueMainDto.getIssueAmount().doubleValue(),0));
		tDebtPlanDet.setChargeAmount(tIssueMainDto.getIssueAmount().multiply(tIssueMainDto.getChargeRate()));
		new PlanManager().confirm(tDebtPlanDet);
		
	}
	
	/**
	 * 確認是否可修改
	 */
	public boolean isModify(IssueMain issueMain)
	{
		if(new PayManager().hasPayment(issueMain.getId()))
			return false;
		
		return true;

	}
	/**
	 * 	取消發行
	 */
	public void cancel(int pIssueId)
	{
		IssueMain issueMain = new IssueMain();
		//查詢是否該發行可修改
		IssueManager issueManager = new IssueManager();
		issueMain = issueManager.getBean(pIssueId);
		if(isModify(issueMain))
			new IssueMainDAO().delete(new Integer(pIssueId));
		else return;
		DebtManager debtManager = new DebtManager();
		List list=debtManager.getBeanByIssue(pIssueId);
		for(int i=0;i < list.size();i++)
		{
			DebtMain debtMain = (DebtMain)list.get(i);
			new RateManager().deleteByDebtId(debtMain.getId());
		}
		new PlanManager().cancelByIssue(pIssueId);
	}
	public List search(String[] pCols,Object[] pValues,String[] pConds,String[] pOrderby ,boolean desc)
	{
		Session tSession = new IssueMainDAO().getSession();
		Criteria criteria = tSession.createCriteria(IssueMain.class);
		if(pCols != null && pValues != null && pConds != null)
		{
			for(int i = 0 ; i < pCols.length ; i++)
			{
				if(pCols[i] == null || pValues[i] == null || pConds[i] == null || 
						"".equals(pCols[i]) || "".equals(pValues[i]) || "".equals(pConds[i]))
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
					criteria.add(Expression.like(pCols[i], pValues[i]+"%"));
			}
		}
		if(desc)
		{	
			if(pOrderby != null){
				for(int i = 0 ; i < pOrderby.length ; i++){
					if(pOrderby[i] == null || "".equals(pOrderby[i])) continue;
					criteria.addOrder(Order.desc(pOrderby[i]));
				}
			}
		}
		else
		{
			if(pOrderby != null){
				for(int i = 0 ; i < pOrderby.length ; i++){
					if(pOrderby[i] == null || "".equals(pOrderby[i])) continue;
					criteria.addOrder(Order.asc(pOrderby[i]));
				}
			}
		}	
		List tResultList = criteria.list();
		tSession.close();
		return tResultList;
	}
	
}