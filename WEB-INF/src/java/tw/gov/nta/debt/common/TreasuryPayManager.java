/**
 * @author Andrew Sung
 *
 */
package tw.gov.nta.debt.common;
import gov.dnt.tame.common.LabelValueBean;
import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.ListToolManager;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import tw.gov.nta.sql.debt.DebtPlanDet;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.PaymentMain;
import tw.gov.nta.sql.debt.dao.DebtPlanDetDAO;
import tw.gov.nta.sql.debt.dao.IssueExchangeDetDAO;
import tw.gov.nta.sql.debt.dao.IssueMainDAO;
import tw.gov.nta.sql.debt.dao.PaymentMainDAO;

/**
 * 尚未實做
 * @author nicetea
 *
 */
public class TreasuryPayManager extends PayManager
{	
	private PaymentMain paymentMainDto = new PaymentMain(); 
	
	public List getDataByIssue(int pIssueId){
		Session tSession = new PaymentMainDAO().getSession();
		Criteria criteria = tSession.createCriteria(PaymentMain.class);
	    criteria.add(Expression.eq("issueId", new Integer(pIssueId)));
	    criteria.add(Expression.gt("interestSerial", "0"));
	    criteria.add(Expression.ltProperty("repayDate", "planRepayDate"));
	    criteria.addOrder(Order.asc("interestSerial"));
	    List tResult = criteria.list();
	    tSession.close();
	    return tResult;
	}
	/**
	 * 判斷是否為交換公債
	 * @param int plandId
	 * @return
	 */
	protected boolean isExgStock(int planId)
	{
		DebtPlanDet pm = new PlanManager().getBean(planId);
		if (new IssueExchangeDetDAO().get(pm.getIssueId())==null)
			return true;
		else
			return false;
	}
	
	/**
	 * 給定初值
	 * @param int plandId
	 * 
	 */
	public void payManager(int pPlanId)
	{
		if (isExgStock(pPlanId))
			new PayCapitalManager().payCaptialByStock(pPlanId,paymentMainDto.getCapitalAmount().doubleValue(),paymentMainDto);
		else
			new PayCapitalManager().payCaptialByCash(pPlanId,paymentMainDto.getCapitalAmount().doubleValue(),paymentMainDto);
		new PayInterestManager().payInterest(pPlanId,paymentMainDto.getCapitalAmount().doubleValue(),paymentMainDto);
		paymentMainDto = new PaymentMain();
	}
	
	/**
	 * 產生還本付息資料
	 * @param int capitalNo,int interestNo,double capitalAmount,
	 * 		  double interstAmount,Date repayDate
	 */
	public void repayDebt(int capitalNo,int interestNo,double capitalAmount,double interstAmount,Date repayDate)
	{
		new PayCapitalManager();
		new PayInterestManager();
		//new PaymentMainDAO().save();
	}
	
	/**
	 * 查詢付息資料
	 * @param Date repayDate,int planId
	 * @return
	 */
	public PaymentMain getInterest(Date pRepayDate,int pPlanId)
	{
		IssueMainDAO tIssueMainDao = new IssueMainDAO();
		IssueMain tIssueMainDto = new IssueMain();
		PaymentMainDAO tPaymentMainDAO = new PaymentMainDAO();
		Session tSession = tPaymentMainDAO.getSession();
		Criteria criteria = tSession.createCriteria(PaymentMain.class);
		criteria.add(Expression.eq("planId", new Integer(pPlanId)));
		List tPaymentMainDtoList = criteria.list();
		BigDecimal tTotalCapitalAmount = new BigDecimal(0);
		Date tBigestDate = null;
		PaymentMain tTempPaymentMainDto = null;
		if(tPaymentMainDtoList == null)
		   	tBigestDate = tIssueMainDto.getIssueDate();
		else
		{
			Iterator tIterator = tPaymentMainDtoList.iterator();//若List為null則會爆出Exception
			while(tIterator.hasNext())
			{//計算Capital_amount總合
				tTempPaymentMainDto = (PaymentMain) tIterator.next();
				tTotalCapitalAmount.add(tTempPaymentMainDto.getCapitalAmount());
				if(tBigestDate == null || tBigestDate.getTime() < tTempPaymentMainDto.getRepayDate().getTime())
					tBigestDate = tTempPaymentMainDto.getRepayDate();
			}
		}    
		DebtPlanDet tDebtPlanDetDto = new DebtPlanDetDAO().get(new Integer(pPlanId));
		PaymentMain tPaymentMainDto = new PaymentMain();
		tPaymentMainDto.setRepayDate(pRepayDate);
		tPaymentMainDto.setCapitalAmount(tDebtPlanDetDto.getCapitalAmount().subtract(tTotalCapitalAmount));
		tPaymentMainDto.setRepayDate(tDebtPlanDetDto.getRepayDate());
		tPaymentMainDto.setBalanceCapitalAmount((tIssueMainDao.get(tDebtPlanDetDto.getIssueId()).getIssueAmount()).subtract(tIssueMainDao.get(tDebtPlanDetDto.getIssueId()).getCapitalAmount()).subtract(paymentMainDto.getCapitalAmount()));
		tPaymentMainDto.setManageCapitalAmount(tDebtPlanDetDto.getCapitalAmount());
		tPaymentMainDto.setInterestAmount
		(calculateInterest(new RateManager().getEffectiveRate(tPaymentMainDto.getDebtId()),tPaymentMainDto.getCapitalAmount().doubleValue(),tBigestDate,pRepayDate,0));
		if(tPaymentMainDtoList == null)
			tPaymentMainDto.setInterestDays(DateUtil.getDays(tIssueMainDto.getIssueDate(),(DateUtil.computeDueDate(pRepayDate,1))));
		else
			tPaymentMainDto.setInterestDays(DateUtil.getDays(tIssueMainDto.getIssueDate(),pRepayDate));
		System.out.println("paymentMainDto.getInterestDays()======"+paymentMainDto.getInterestDays());
		return tPaymentMainDto;
	}
	
	/**
	 * 計算利息資料
	 * @param List pRate,double pBalanceCapitalAmount, String pStartDate , String pEndDate , String pCountType
	 * @return BigDecimal
	 */
	public BigDecimal calculateInterest(List pRate,double pBalanceCapitalAmount, Date pStartDate , Date pEndDate , int pCountType )
	{
		return new InterestCounter().countInterest(pStartDate,pEndDate,pRate,pBalanceCapitalAmount,pCountType);
	}
	
	/**
	 * 確定是否可以修改
	 * @param PaymentMain
	 * @return 規格書未說明,一律回傳true
	 */
	public boolean isModify(PaymentMain pPaymentMainDto)
	{
		return true;
	}
	/**
	 * 更新國庫券還本付息之相對應之發行資料相關欄位
	 * @param pId
	 * @throws Exception 
	 */
	public void updateIssue(int pId) throws Exception
	{
		//IssueMain tIssueMainDto = new IssueManager().getBean(pId);
		List tPaymentMainDtoList = new PayManager().getDataByIssue(pId);
		BigDecimal tTotalCapitalAmount = new BigDecimal(0);
		BigDecimal tTotalInterestAmount = new BigDecimal(0);
		PaymentMain tTempPaymentMainDto = new PaymentMain();
		if(tPaymentMainDtoList != null)
		{
			Iterator tIterator = tPaymentMainDtoList.iterator();//若List為null則會爆出Exception
			while(tIterator.hasNext())
			{//計算Capital_amount總合
				tTempPaymentMainDto = (PaymentMain) tIterator.next();
				tTotalCapitalAmount = tTotalCapitalAmount.add(tTempPaymentMainDto.getCapitalAmount());
				tTotalInterestAmount = tTotalInterestAmount.add((tTempPaymentMainDto.getManageInterestAmount()!=null)?tTempPaymentMainDto.getManageInterestAmount():new BigDecimal(0));
			}
		} 
		IssueMain tIssueMainDto = new IssueManager().getBean(pId);
		tIssueMainDto.setCapitalAmount(tTotalCapitalAmount);
		tIssueMainDto.setInterestAmount(tTotalInterestAmount);
		new IssueManager().confirm(tIssueMainDto);
	}
	
	/**
	 * 更新國庫券還本付息資料檔相關資料
	 * @param pPaymentMainDto
	 * @return
	 */
	public boolean confirm(PaymentMain pPaymentMainDto) throws Exception
	{
		
		super.confirm(pPaymentMainDto);
		updateIssue(pPaymentMainDto.getIssueId());
		confirmByPayment(pPaymentMainDto);
		return true;
		
		
//		try
//		{
//			super.confirm(pPaymentMainDto);
//			updateIssue(pPaymentMainDto.getIssueId());
//			System.out.println("1");
//			return true;
//		}
//		catch(Exception exception)
//		{
//			System.out.println("2");
//			return false;
//		}
	}
	public void confirmByPayment(PaymentMain pPaymentMainDto) throws Exception
	{
		PaymentMain paymentMain = getBySourcId(pPaymentMainDto.getId());
		paymentMain.setIssueId(pPaymentMainDto.getIssueId());
		paymentMain.setDebtId(pPaymentMainDto.getDebtId());
		paymentMain.setPlan(pPaymentMainDto.getPlan());
		paymentMain.setRepayDate(pPaymentMainDto.getRepayDate());
		paymentMain.setCapitalAmount(pPaymentMainDto.getBalanceCapitalAmount().subtract(pPaymentMainDto.getManageCapitalAmount()));
		paymentMain.setInterestSerial("0");
		paymentMain.setCapitalSerial(pPaymentMainDto.getInterestSerial());
		paymentMain.setInterestAmount(new BigDecimal(0));
		paymentMain.setPlanRepayDate(new IssueManager().getBean(pPaymentMainDto.getIssueId()).getDueDate());
		paymentMain.setInterestDays(pPaymentMainDto.getInterestDays());
		paymentMain.setSourcId(pPaymentMainDto.getId());
		new PaymentMainDAO().saveOrUpdate(paymentMain);
	}
	/**
	 * 刪除國庫券還本付息資料檔相關資料
	 * @param pPaymentMainDto
	 * @return
	 */
	public boolean cancel(PaymentMain pPaymentMainDto)
	{
		try
		{
			PaymentMainDAO tPaymentMainDAO = new PaymentMainDAO();
			tPaymentMainDAO.delete(pPaymentMainDto.getId());
			updateIssue(pPaymentMainDto.getIssueId());
			return true;
		}
		catch(Exception exception)
		{
			return false;
		}
	}
	public static PaymentMain getBySourcId(int pId) throws HibernateException
	{
        PaymentMainDAO dao = new PaymentMainDAO();
		Session session = dao.getSession();
        Criteria criteria = session.createCriteria(PaymentMain.class);
        criteria.add(Expression.eq("sourcId", new Integer(pId)));
        List collection = criteria.list();
        session.close();
        return (collection.size() != 0)?(PaymentMain)collection.get(0): new PaymentMain();
	}
	/**
	 * 取得CombinText List
	 * @param null
	 * @return List<LabelValueBean>
	 * @throws HibernateException
	 */
	public static List<LabelValueBean> getIssueId() throws HibernateException
	{
        List<LabelValueBean> labelValueBeanList = new LinkedList<LabelValueBean>();
        PaymentMainDAO dao = new PaymentMainDAO();
		Session session = dao.getSession();
        Criteria criteria = session.createCriteria(PaymentMain.class);
        List collection = criteria.list();
        if(collection!=null)
        {
            for (Iterator it = collection.iterator(); it.hasNext();)
            {
            	PaymentMain paymentMain = (PaymentMain) it.next();
            	LabelValueBean labelValueBean = new LabelValueBean();
            	labelValueBean.setLabel(paymentMain.getCapitalSerial());
            	labelValueBean.setValuess(paymentMain.getIssueId().toString());
            	labelValueBeanList.add(labelValueBean);
            }
        }
        session.close();
        return labelValueBeanList;
//		StringBuffer hqlStr = new StringBuffer("select issueId, capitalSerial from PaymentMain ");
//        hqlStr.append( " where debtType='" +pType+ "' ");
//        hqlStr.append( "   and budgetCode=" +budgetCode+ " ");
//        return ListToolManager.getList(hqlStr.toString());
	}
}