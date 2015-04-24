/* CPRB0201.java 報表
 程式目的：CPRB02
 程式代號：CPRB02
 程式日期：0950308
 程式作者：Eric.Chen
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
 --------------------------------------------------------
 */
package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;

import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.debt.common.InterestCounter;
import tw.gov.nta.debt.common.RateManager;
import tw.gov.nta.debt.form.Cprb0201Form;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.dao.DebtPlanDetDAO;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class CPRB0201 extends DefaultAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM CPRB02_RPT ");
		//sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}

	protected SQLJob insTemp(ActionForm form,String usrId){
		Cprb0201Form cprb0201Form = (Cprb0201Form) form;
		SQLJob sqljob = new SQLJob();
		List mylist = new LinkedList();
		Session session = new DebtPlanDetDAO().getSession();
		Criteria criteria = session.createCriteria(IssueMain.class); 
		criteria.add(Expression.eq("debtType","E"));					//為了計算 InterestCounter().countInterest 先select 出issue 一次
		mylist = criteria.list();
		BigDecimal tempValue = new BigDecimal(0);
		String baseDate = (Integer.parseInt(cprb0201Form.getBaseDate().substring(0,3))+ new Integer(1911)) + "/" + cprb0201Form .getBaseDate().substring(3);
		//將畫面的輸入值串成日期
		
		if(null != mylist && 0 != mylist.size())
		{	
			for(Iterator it = mylist.iterator();it.hasNext();)
			{
				IssueMain myIssue = (IssueMain)it.next();
				if(null == myIssue.getIssueAmount()){myIssue.setIssueAmount(new BigDecimal(0));}	//防 null
				if(null == myIssue.getCapitalAmount()){myIssue.setCapitalAmount(new BigDecimal(0));}	//防 null
				if(null == myIssue.getInterestAmount()){myIssue.setInterestAmount(new BigDecimal(0));}	//防 null
				
				List debtList = new DebtManager().getBeanByIssue(myIssue.getId());
				if(null != debtList && 0 == debtList.size()){continue;}		//若無debtId 則不做           debtid : issueid 只會有一筆
				
				List tempList = new RateManager().getEffectiveRate(((DebtMain)debtList.get(0)).getId());
				tempValue = new InterestCounter().countInterest(myIssue.getIssueDate(),myIssue.getDueDate(),tempList,myIssue.getIssueAmount().subtract(myIssue.getCapitalAmount()).doubleValue(),0);
			
				String condiction = "from debt_plan_det where issue_id =" + myIssue.getId() +		//重覆性高的sql
					" and repay_date between '" + baseDate + "/01' and '" +
					baseDate + "/31')";
				
				String tempString = "( Select min(repay_date) " + condiction ;			//重覆性高的sql
				String tempString2 = "( Select sum(capital_amount)" + condiction ;		//重覆性高的sql
				String tempString3 = "( Select sum("+ myIssue.getIssueAmount().subtract(myIssue.getCapitalAmount()) +" - capital_amount) " + condiction ;	//和tempString 差多減一個值
		
				
				
				sqljob.appendSQL("INSERT INTO CPRB02_RPT ( USRID, MOD_DATE, REMARK,Issue_serial,Issue_amount," +			//insert temptable 的欄位名稱
														  "First_date,Start_date,Finish_date,Pay_date,Pay_capital," +
														  "Last_capital,Interest_date,Days,Rate,Interest_amount,Pre_interest," +
														  "Sum_interest )");
				
				
				sqljob.appendSQL("Select '" + usrId + "', CURRENT_TIMESTAMP , null , issue_serial , issue_amount , '" + 
						DateUtil.date2Str(myIssue.getIssueDate(),"yyyy/MM/dd") + "'," +
						"( Select min(repay_date) from payment_main where issue_id =" + myIssue.getId() + ") ,'" +
						DateUtil.date2Str(myIssue.getDueDate(),"yyyy/MM/dd") + "'," +
						tempString + "," +
						tempString2 + ", " +
						tempString3 + "," +
						tempString + "," +
						"DateDiff(dd,(Select min(repay_date) + 1 from payment_main where issue_id = " + myIssue.getId() + ") ," +
						"(Select min(repay_date) + 1 from payment_main where issue_id = " + myIssue.getId() + " ))," +
						"(Select debt_rate from debt_rate_det, debt_main where debt_rate_det .delete_mark='N' and debt_rate_det .debt_id = debt_main.id and effective_date <= '" 
						+ baseDate +"/01' " + " and suspend_date >= '" + baseDate+"/31'  and debt_main.issue_id = " + myIssue.getId() + ") ," 
						+ tempValue.setScale(4,5).toString() + "," 
						+ myIssue.getInterestAmount().setScale(4,5) + ","
						+ tempValue.add(myIssue.getInterestAmount()).setScale(4,5) + " From Issue_Main Where DEBT_TYPE = 'E' AND id = " + myIssue.getId()+ ";");
							
			}
		}
		session.close();
		System.out.println(sqljob.toString());
		return sqljob;
	}
	
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {

		//取得使用者帳號
		String usrId = request.getSession().getAttribute("ACCOUNT").toString();
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delTemp(form,usrId));
		//執行 insert
		run.update(connection,insTemp(form,usrId));
	}


}
