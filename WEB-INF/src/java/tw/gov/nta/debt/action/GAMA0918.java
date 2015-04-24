package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.hibernate.Session;

import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.debt.common.InterestCounter;
import tw.gov.nta.debt.common.PayManager;
import tw.gov.nta.debt.common.PlanManager;
import tw.gov.nta.debt.common.RateManager;
import tw.gov.nta.debt.form.Cima0101Form;
import tw.gov.nta.sql.debt.DebtPlanDet;
import tw.gov.nta.sql.debt.PaymentMain;
import tw.gov.nta.sql.debt.dao.DebtPlanDetDAO;

public class GAMA0918 extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		// 新增
		Cima0101Form myform = (Cima0101Form)form ;
		List caplist = (List)request.getSession().getAttribute("caplist");
		int index = caplist.size();
		PlanManager myPManager = new PlanManager();
		DebtManager myDManager = new DebtManager();
		DebtPlanDet myPlan = new DebtPlanDet();
		myPlan.setRepayDate(myform.getRepayDate());
		myPlan.setIssueId(myform.getId());
		myPlan.setDeleteMark("N");
		
		myPlan.setCapitalSerial(0);
		myPlan.setInterestSerial(0);
		
		myPlan.setCapitalAmount(myform.getCapitalAmount());
		myPlan.setInterestAmount(myform.getInterestAmountDPT());
		myPlan.setDebt(myDManager.getBean(myform.getDebtId()));
		caplist.add(myPlan);	
		myform.setNowindex(index+1);
		
		Date repayDate = null;
		Date repayedDate = null;
		DebtPlanDet temp = null;
		for(int i=0;i<caplist.size();i++)
		{
			repayDate = ((DebtPlanDet)caplist.get(i)).getRepayDate();
			for(int j=i+1;j<caplist.size();j++)
			{	
				repayedDate = ((DebtPlanDet)caplist.get(j)).getRepayDate();
				if(repayDate.after(repayedDate))
				{
					temp = ((DebtPlanDet)caplist.get(i));

					caplist.set(i,((DebtPlanDet)caplist.get(j)));
					caplist.set(j,temp);
				}
			}	
		}
		new InterestCounter().planListCountInterest(caplist);
		//新增DebtPlanDet
		DebtPlanDetDAO planDao = DebtPlanDetDAO.getInstance();
		Session session = planDao.getSession();
		myPManager.confirmInterst(myPlan,session);
		//新增PaymentMain
		List debtPlanDetList = myPManager.byDebtId(myform.getDebtId());
		DebtPlanDet payDebtPlanDet = (DebtPlanDet)debtPlanDetList.get(debtPlanDetList.size()-1);
		DebtPlanDet payDebtPlanDet2 = (DebtPlanDet)debtPlanDetList.get(debtPlanDetList.size()-2);
		//寫入資料
		PayManager payManager = new PayManager();
		PaymentMain tPaymentMainDto = payManager.createBean(payDebtPlanDet.getId());
		tPaymentMainDto.setRepayDate(payDebtPlanDet.getRepayDate());
		tPaymentMainDto.setCapitalAmount(payDebtPlanDet.getCapitalAmount());
		tPaymentMainDto.setCapitalSerial(payDebtPlanDet.getCapitalSerial().toString());
		tPaymentMainDto.setInterestSerial(payDebtPlanDet.getInterestSerial().toString());
		tPaymentMainDto.setPlanRepayDate(payDebtPlanDet.getRepayDate());
		//計算利息
		Date startDate = payDebtPlanDet2.getRepayDate();
		Date endDate = payDebtPlanDet.getRepayDate();
		RateManager rateManager = new RateManager();
		List rateList = rateManager.getEffectiveRate(myform.getDebtId());
		InterestCounter doCount = new InterestCounter();
		tPaymentMainDto.setInterestAmount(doCount.countInterest(startDate,endDate,rateList,payDebtPlanDet.getDebt().getIssueAmount().doubleValue(),0));

		tPaymentMainDto.setStartDate(startDate);
		tPaymentMainDto.setEndDate(endDate);
		Integer intereatDays = DateUtil.getDays(startDate,endDate);
		tPaymentMainDto.setInterestDays(intereatDays);
		payManager.confirm(tPaymentMainDto);
		
		request.getSession().setAttribute("caplist",caplist);
		setAlertMessage(request,"新增成功");
		
		
		myPManager.confirm(caplist);
		
	}

}
