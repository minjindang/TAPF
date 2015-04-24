package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.hibernate.Query;
import org.hibernate.Session;

import tw.gov.nta.debt.common.InterestCounter;
import tw.gov.nta.debt.common.RateManager;
import tw.gov.nta.debt.form.Cima0101Form;
import tw.gov.nta.sql.debt.DebtRateDet;
import tw.gov.nta.sql.debt.dao.PaymentMainDAO;

public class CIMA0102MCOUNT extends DefaultAction {

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		Cima0101Form myform = (Cima0101Form)form;
		myform.setRatelist((List)request.getSession().getAttribute("ratelist"));
		myform.setCaplist((List)request.getSession().getAttribute("caplist"));
		request.setAttribute("ratelist",myform.getRatelist());
		request.setAttribute("caplist",myform.getCaplist());
		BigDecimal originInterestAmount = new BigDecimal(0);
		List list = new LinkedList();
		if(null == myform.getIssueAmountDet())
		{
			myform.setIssueAmountDet(new BigDecimal(0));
		}
		if(null != myform.getAccrue())
		{
			myform.setAccrue("on");
		}	
		if(null != myform.getMyDMain().getId())
		{
			RateManager myRate = new RateManager();
			list = myRate.getEffectiveRate(myform.getMyDMain().getId());
		}
		else
		{
			DebtRateDet debtRateDet = new DebtRateDet();
			debtRateDet.setDebtRate(myform.getCompareRate());
			debtRateDet.setEffectiveDate(myform.getIssueDate());	//起始日
			debtRateDet.setSuspendDate(myform.getDueDate());		//結束日
			list.add(debtRateDet);
		}
		
		originInterestAmount = getOriginInterestAmount(myform,list);
		myform.setOriginInterestAmount(originInterestAmount.setScale(0,5));
		myform.setTotalAmount(myform.getIssueAmountDet().add(myform.getOriginInterestAmount()).setScale(0,5));
		
		/** 顯示 第三個 List 參考cpma0101MLform.jsp cpma0101MLOAD.java**/
		Session session = new PaymentMainDAO().createNewSession();
		StringBuffer str3 = new StringBuffer();
		str3.append("from PaymentMain pay where pay.issueId = ");
		str3.append(myform.getId());
		str3.append(" and pay.debtId = ");
		str3.append(myform.getDebtId());
		Query query = session.createQuery(str3.toString());
		List list3 = query.list();
		request.setAttribute("collection",list3);
		session.close();

	}
	
	/**
	 * 取得應付利息
	 * 算法
	 * 足年的就直接算  年數 * 年利率 * 發行金額
	 * 不足年的再呼叫利率計算機做運算
	 * ex. 發行日期 2006/1/1   結束日期2010/3/20 年利率3% 發行10,000,000
	 * 先算足年 2010 - 2006 = 4   4 * 0.03 * 10,000,000 = 1,200,000
	 * 再算不足年 將2010/1/1 - 2010/3/20 傳入利息計算機計算日期
	 * 最後再加總
	 * @param myform 畫面資料
	 * @param list //利率組合
	 * @return
	 */
	private BigDecimal getOriginInterestAmount(Cima0101Form myform, List list) {
		// TODO Auto-generated method stub
		//設定計算初值
		BigDecimal originInterestAmount = new BigDecimal(0);
		BigDecimal issueAmount = myform.getMyDMain().getIssueAmount();
		BigDecimal compareRate = myform.getCompareRate();
		InterestCounter interestCounter = new InterestCounter();
		Calendar calendar1 = new GregorianCalendar();
		Calendar calendar2 = new GregorianCalendar();
		Calendar calendar3 = new GregorianCalendar();
		calendar1.setTime(myform.getIssueDate());
		calendar3.setTime(myform.getIssueDate());
		calendar2.setTime(myform.getDueDate());
		
		
		//取得發行及結束日期的年度
		int issueYear = calendar1.get(Calendar.YEAR);
		int dueYear = calendar2.get(Calendar.YEAR);
		
		if (!(calendar1.get(Calendar.DAY_OF_YEAR) == calendar2.get(Calendar.DAY_OF_YEAR))){
			System.out.println("最後一年償還日期不滿一年");
			
			//如果結束年大於發行年(足年)就先取整年的利息
			if(issueYear < dueYear) {
				originInterestAmount = issueAmount.multiply(compareRate).divide(new BigDecimal(100));
				originInterestAmount = originInterestAmount.multiply(new BigDecimal((dueYear-1) - issueYear));
			}
			
		}else{
			//如果結束年大於發行年(足年)就先取整年的利息
			if(issueYear < dueYear) {
				originInterestAmount = issueAmount.multiply(compareRate).divide(new BigDecimal(100));
				originInterestAmount = originInterestAmount.multiply(new BigDecimal(dueYear - issueYear));
			}
		}
			
		//計算餘日期的利息金額
		calendar1.add(Calendar.YEAR,dueYear - issueYear);
		calendar3.add(Calendar.YEAR,dueYear - issueYear - 1);
		if (!calendar1.getTime().equals(calendar2.getTime())) {
			originInterestAmount = originInterestAmount.add(interestCounter.countInterest(calendar3.getTime(),calendar2.getTime(),list,
					myform.getIssueAmountDet().doubleValue(),0));
		}
		
		return originInterestAmount;
	}

}
