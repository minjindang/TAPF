/**
 * @author AndrewSung
 * @date 2006/3/9
 */
package tw.gov.nta.shortterm.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.debt.common.DebtPlanDetVectors;
import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.common.PayManager;
import tw.gov.nta.debt.common.PlanManager;
import tw.gov.nta.shortterm.form.Dpma0101Form;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.DebtPlanDet;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.PaymentMain;

public class DPMA0101 extends DefaultAction
{
	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception
	{
		Dpma0101Form dpma0101Form = (Dpma0101Form)form;
		PayManager paymanager = new PayManager();
		IssueManager issueManager = new IssueManager();
		IssueMain issueMain = issueManager.getBean(dpma0101Form.getId());
		dpma0101Form.setIssuMain(issueMain);
		Vector<Object> debtMainPlan = new Vector<Object>();

		DebtManager debtManager = new DebtManager();
		List debtMainList = (List) debtManager.getBeanByIssue(issueMain.getId());
		BigDecimal issueMainCapitalAmount = new BigDecimal(0);
		for(Iterator it=debtMainList.iterator();it.hasNext();)
		{
			DebtPlanDetVectors debtPlanDetVectors = new DebtPlanDetVectors();

			DebtMain debtMain = (DebtMain) it.next();
			debtMain.setIssueAmount( debtMain.getIssueAmount()==null?new BigDecimal(0.0):debtMain.getIssueAmount() );
			debtMain.setOriginInterestAmount( debtMain.getOriginInterestAmount()==null?new BigDecimal(0.0):debtMain.getOriginInterestAmount() );
			debtPlanDetVectors.setDebt( debtMain );
			PlanManager planManager = new PlanManager();
			List debtPlanDetList = planManager.getAllPlanListByDebt(debtMain);
			BigDecimal capitalAmount = new BigDecimal(0);
			BigDecimal interestAmount = new BigDecimal(0);
			for(Iterator it2=debtPlanDetList.iterator();it2.hasNext();)
			{
				DebtPlanDet debtPlanDet = (DebtPlanDet) it2.next();
				debtPlanDetVectors.setDebtPlanDet( debtPlanDet );
				List payList = planManager.byDebtPlan(debtPlanDet);
				for(Iterator itPay = payList.iterator();itPay.hasNext();){
					PaymentMain payDto = (PaymentMain)itPay.next();
					if(payDto != null){
						if(capitalAmount == new BigDecimal(0)){
							capitalAmount = payDto.getCapitalAmount();
						}
						if(interestAmount == new BigDecimal(0)){
							interestAmount = payDto.getCapitalAmount();
							//interestAmount = payDto.getCapitalAmount().multiply(debtMain.getCompareRate().divide(new BigDecimal(100))).multiply(new BigDecimal(dpma0101Form.getDays())).divide(new BigDecimal(365));
						}
						else{
							capitalAmount = capitalAmount.add(payDto.getCapitalAmount());
							issueMainCapitalAmount = issueMainCapitalAmount.add(payDto.getCapitalAmount());
							interestAmount= interestAmount.add(payDto.getInterestAmount());
						}
					}
				}
				if (null != request.getAttribute("capitalAmountGuess") && !request.getAttribute("capitalAmountGuess").equals(""))
					debtPlanDetVectors.setCapitalAmount(request.getAttribute("capitalAmountGuess").toString());
				else
					debtPlanDetVectors.setCapitalAmount(debtMain.getIssueAmount().subtract(capitalAmount).toString());
				if (null != request.getAttribute("interestAmountPay") && !request.getAttribute("interestAmountPay").equals(""))
					debtPlanDetVectors.setInterestAmount(request.getAttribute("interestAmountPay").toString());
				else
					debtPlanDetVectors.setInterestAmount(debtMain.getOriginInterestAmount().subtract(interestAmount).toString());
				if (null != request.getAttribute("totalAmountGuess") && !request.getAttribute("totalAmountGuess").equals(""))
					debtPlanDetVectors.setTotalCount(request.getAttribute("totalAmountGuess").toString());
				else
					debtPlanDetVectors.setTotalCount(new BigDecimal(debtPlanDetVectors.getCapitalAmount()).add(new BigDecimal(debtPlanDetVectors.getInterestAmount())).toString());
				//如果有payment就不顯示清單出來
//				List hasPayment = paymanager.getListByPlan(debtPlanDet.getId());				
//				if(null == hasPayment || 0 == hasPayment.size())
//				{
				if (!"0".equals(debtMain.getIssueAmount().subtract(capitalAmount).setScale(0,BigDecimal.ROUND_DOWN).toString()))
					debtMainPlan.add( debtPlanDetVectors );
//				}	
				dpma0101Form.setCapitalAmount(capitalAmount);
				dpma0101Form.setIssueMainCapitalAmount(issueMainCapitalAmount);
				
			}
		}
		dpma0101Form.setDebtPlanDets( debtMainPlan );
		//102新增 不知道前面的人在幹麻 居然沒加repay_date，此為參照DPMA0107的程式邏輯
		Date issueDate = issueMain.getIssueDate();
		Date dueDate = issueMain.getDueDate();
		Date payDate = dpma0101Form.getRepayDate();
		 dpma0101Form.setDueDate(issueMain.getDueDate());
		 if(payDate.equals(dueDate))
			 dpma0101Form.setPayType("0 正常還款");
		 else if(payDate.after(dueDate))
			 dpma0101Form.setPayType("1 延後還款");
		 else if(payDate.before(dueDate))
			 dpma0101Form.setPayType("2 提前還款");
		 dpma0101Form.setRepayDays((DateUtil.getDays(issueDate,payDate)).toString());
	}
}
