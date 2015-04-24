package tw.gov.nta.debt.common;

import java.math.BigDecimal;
import java.util.Iterator;

import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.DebtPlanDet;
import tw.gov.nta.sql.debt.DebtRateDet;
import tw.gov.nta.sql.debt.IssueMain;


public class ShortDebtManager extends DebtManager{

	/**
	 * 確認借款
	 * @param pDebtMainDto
	 * @param pRate
	 * @throws Exception
	 */
	public void confirm(DebtMain pDebtMainDto) throws Exception {
		//執行super
		if(pDebtMainDto.getBudgetYear() == null || !pDebtMainDto.getBudgetYear().equals("Y")){
			pDebtMainDto.setBudgetYear("N");
			//若非另訂新約需檢核是否大於可借餘額
//			BigDecimal borrowAmount = new BigDecimal(0);
//			borrowAmount = new ContractBankManager().recountBorrowAmount(pDebtMainDto.getBank().getId(),pDebtMainDto.getIssue().getAccountYear());
//			if (pDebtMainDto.getIssueAmount().compareTo(borrowAmount) == 1 )
//				throw new Exception("checkBean false!");
		}
		super.confirm(pDebtMainDto);
		//2.新增利率
		RateManager tRateManager = new RateManager();
		tRateManager.deleteByDebtId(pDebtMainDto.getId());
		DebtRateDet tDebtRateDetDto = tRateManager.createBean(pDebtMainDto.getId());
		tDebtRateDetDto.setDebt(pDebtMainDto);
		tDebtRateDetDto.setDebtRate(pDebtMainDto.getCompareRate());
		tDebtRateDetDto.setEffectiveDate(pDebtMainDto.getIssue().getIssueDate());
		tDebtRateDetDto.setSuspendDate(pDebtMainDto.getIssue().getDueDate());
		tDebtRateDetDto.setDeleteMark("N");
		tRateManager.confirm(tDebtRateDetDto);
		//3.新增計劃
		if("Y".equals(pDebtMainDto.getAccrue())){
			PlanManager tPlanManager = new PlanManager();
			tPlanManager.cancelByDebt(pDebtMainDto.getId());
			DebtPlanDet tDebtPlanDetDto = tPlanManager.createBean(pDebtMainDto.getId().intValue());
			tDebtPlanDetDto.setIssueId(pDebtMainDto.getIssue().getId());
			tDebtPlanDetDto.setDebt(pDebtMainDto);
			tDebtPlanDetDto.setCapitalAmount(pDebtMainDto.getIssueAmount());
			tDebtPlanDetDto.setInterestAmount(pDebtMainDto.getOriginInterestAmount());
			tDebtPlanDetDto.setChargeAmount(new BigDecimal(0));
			tDebtPlanDetDto.setRepayDate(pDebtMainDto.getIssue().getDueDate());
			tDebtPlanDetDto.setDeleteMark("N");
			tDebtPlanDetDto.setInterestSerial(0);
			tDebtPlanDetDto.setCapitalSerial(0);
			tPlanManager.confirm(tDebtPlanDetDto);
		}
		updateIssueData(pDebtMainDto.getIssue().getId());
	}
	
	/**
	 * 取消借款
	 * @param pDebtId:借款主鍵值
	 * @throws Exception
	 */
	public void cancel(int pDebtId) throws Exception{
		int tIssueId = getBean(pDebtId).getIssue().getId();
		
		//1.刪除利率
		new RateManager().deleteByDebtId(pDebtId);
		//2.刪除計劃
		new PlanManager().cancelByDebt(pDebtId);
		//3.更新發行資料
		updateIssueData(tIssueId);
		//5.super.cancel
		super.cancel(pDebtId);
	}
	
	/**
	 * 更新發行資料(實際借款金額,加權平均利率)
	 * @param pIssueId
	 * @throws Exception
	 */
	private void updateIssueData(int pIssueId) throws Exception{
		IssueMain tIssueMainDto = new IssueManager().getBean(pIssueId);
		//計算發行金額
		BigDecimal tIssueAmount = new DebtManager().getAmountByIssue(pIssueId);
		//計算發行加權利率
		double tPowerRate = 0;
		Iterator tIterator = new DebtManager().getBeanByIssue(pIssueId).iterator();
		DebtMain tDebtMainDto = null;
		while(tIterator.hasNext()){
			tDebtMainDto = (DebtMain) tIterator.next();
			if(!"Y".equalsIgnoreCase(tDebtMainDto.getAccrue()))
				continue;
			tPowerRate += tDebtMainDto.getIssueAmount().doubleValue() * tDebtMainDto.getCompareRate().doubleValue();
			if(tIssueAmount.intValue() == 0)
				tIssueMainDto.setAverageRate(new BigDecimal(0));
			else
				tIssueMainDto.setAverageRate(new BigDecimal(tPowerRate).divide(tIssueAmount, 4,5));
			
		}
		tIssueMainDto.setIssueAmount(tIssueAmount);
		new IssueManager().confirm(tIssueMainDto);
	}
}
 
