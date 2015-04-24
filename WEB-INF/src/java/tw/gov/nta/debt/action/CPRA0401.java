/* APRA0601.java 報表
 程式目的：APRA06
 程式代號：APRA06
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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.hibernate.Query;

import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.common.PlanManager;
import tw.gov.nta.debt.form.Cpra0401Form;
import tw.gov.nta.sql.debt.DebtPlanDet;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.dao.DebtPlanDetDAO;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class CPRA0401 extends DefaultAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM CPRA04_RPT ");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	protected SQLJob insTemp(Map map){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO CPRA04_RPT ");
		sqljob.appendSQL("( ");
		sqljob.appendSQL("USRID, MOD_DATE, REMARK, issue_serial , issue_amount ,");
		sqljob.appendSQL("issue_date , continue_date , due_date , repay_date ,");
		sqljob.appendSQL("capital_amount , charge_amount , transfer_interest_amount ,");
		sqljob.appendSQL("transfer_capital_amount , interest_amount , total_interest_amount , interim");
		sqljob.appendSQL(")values('TAPF',CURRENT_TIMESTAMP,null,'"+map.get("issueSerial")+"','"+map.get("issueAmount")+"',");
		sqljob.appendSQL("'"+DateUtil.date2Str((Date)map.get("issueDate"), "yyyy/MM/dd")+"'," );
		sqljob.appendSQL("'"+DateUtil.date2Str((Date)map.get("continueDate"), "yyyy/MM/dd")+"'," );
		sqljob.appendSQL("'"+DateUtil.date2Str((Date)map.get("dueDate"), "yyyy/MM/dd")+"'," );
		sqljob.appendSQL(((map.get("repayDate")==null)?"null":"'"+DateUtil.date2Str((Date)map.get("repayDate"), "yyyy/MM/dd")+"'")+"," );
		sqljob.appendSQL(map.get("capitalAmount")+"," );
		sqljob.appendSQL(map.get("chargeAmount")+"," );
		sqljob.appendSQL(map.get("transferInterestAmount")+"," );
		sqljob.appendSQL(map.get("transferCapitalAmount")+"," );
		sqljob.appendSQL(map.get("interestAmount")+"," );
		sqljob.appendSQL(map.get("totalInterestAmount")+"," );
		sqljob.appendSQL("'"+map.get("interim")+"')" );
		System.out.println(sqljob.toString());
		return sqljob;
	}
	protected SQLJob selTemp(){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select id , transfer_interest_amount from CPRA04_RPT");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	protected SQLJob updTemp(Integer id, String interim){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("update CPRA04_RPT set interim = ? where id = ?");
		sqljob.addParameter(interim);
		sqljob.addParameter( id);
		System.out.println(sqljob.toString());
		return sqljob;
	}
	@SuppressWarnings({ "unchecked", "static-access", "deprecation" })
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		//取得使用者帳號
		String usrId = getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delTemp(form,usrId));
		//執行 insert
		Cpra0401Form myForm = (Cpra0401Form) form;
		int year = Integer.parseInt(myForm.getBaseDate().substring(0,3));
		int month = Integer.parseInt(myForm.getBaseDate().substring(3,5));
		List listMain = new IssueManager().Search(new String[]{"debtCode"}, new Integer[]{58}, new String[]{"="}, new String[]{"issueDate"});
		BigDecimal sumTotalInterestAmount = new BigDecimal(0);
		BigDecimal sumChargeAmount = new BigDecimal(0);
		for(Iterator it = listMain.iterator();it.hasNext();){
			IssueMain issueMain = (IssueMain)it.next();
			Map map = new HashMap();
			BigDecimal totalInterestAmount = new BigDecimal(0);
			map.put("issueSerial",issueMain.getIssueSerial());
			map.put("issueAmount",issueMain.getIssueAmount());
			map.put("issueDate",issueMain.getIssueDate());
			map.put("continueDate",issueMain.getContinueDate());
			map.put("dueDate",issueMain.getDueDate());
			List listDet = new LinkedList();
			Date repayDate = new Date(year+11,month-1,1);
			String hql = " from DebtPlanDet where issueId ="+issueMain.getId();
			hql+= " and repayDate >= '"+DateUtil.date2Str(repayDate, "yyyy/MM/dd")+"'";
			hql+= " and repayDate <= '"+DateUtil.date2Str(DateUtil.getLastDateOfMonth(repayDate), "yyyy/MM/dd")+"'";
			@SuppressWarnings("unused")
			Query query =  new DebtPlanDetDAO().getSession().createQuery(hql);
			listDet = query.list();
			String hqlPlan = "select sum(interestAmount) from DebtPlanDet where issueId ="+issueMain.getId();
			hqlPlan +=" and repayDate < '"+DateUtil.date2Str(new Date(year+11,month-1,1), "yyyy/MM/dd")+"'";
			@SuppressWarnings("unused")
			Query queryPlan =  new DebtPlanDetDAO().getSession().createQuery(hqlPlan);
			queryPlan.list();
			totalInterestAmount = (BigDecimal)queryPlan.list().get(0);
			sumTotalInterestAmount = sumTotalInterestAmount.add(totalInterestAmount);
			if(listDet.size()==0){
				map.put("repayDate",null);
				map.put("capitalAmount","null");
				map.put("chargeAmount","0");
				map.put("transferInterestAmount","null");
				map.put("transferCapitalAmount","null");
				map.put("interestAmount","0");
				map.put("totalInterestAmount",totalInterestAmount );
				map.put("interim","");
				run.update(connection,insTemp(map));
			}else{
				BigDecimal interestAmount = new BigDecimal(0);
				for(Iterator itDet = listDet.iterator();itDet.hasNext();){
					DebtPlanDet det = (DebtPlanDet)itDet.next();
					BigDecimal chargeAmount = (det.getChargeAmount()!=null)?det.getChargeAmount():new BigDecimal(0);
					BigDecimal transferInterestAmount = (det.getTransferInterestAmount()!=null)?det.getTransferInterestAmount():new BigDecimal(0);
					BigDecimal transferCapitalAmount =(det.getTransferCapitalAmount()!=null)?det.getTransferCapitalAmount().divide(new BigDecimal (100)):new BigDecimal(0);
					Calendar tCalendar = GregorianCalendar.getInstance();
					String interim = "null";
					if(det.getTransferInterestAmount()!=null){	
						tCalendar.setTime(new Date(year+11,month-1,20));
						tCalendar.add(tCalendar.DATE, -(det.getTransferInterestAmount()).intValue());
						interim = new DateUtil().date2ROCStr(tCalendar.getTime(), "yyy/mm/dd")+"~"+new DateUtil().date2ROCStr(new Date(year+11,month-1,20), "yyy/mm/dd");
					}
					map.put("repayDate",(det.getCapitalAmount().compareTo(new BigDecimal(0))!=0)?det.getRepayDate():null);
					map.put("capitalAmount",(det.getCapitalAmount().compareTo(new BigDecimal(0))==0)?"null":det.getCapitalAmount());
					map.put("chargeAmount",chargeAmount);
					map.put("transferInterestAmount",transferInterestAmount);
					map.put("transferCapitalAmount",transferCapitalAmount);
					map.put("interestAmount",chargeAmount.multiply(transferInterestAmount).multiply(transferCapitalAmount).divide(new BigDecimal(365),0,4));
					map.put("totalInterestAmount",totalInterestAmount );
					map.put("interim",interim);
					run.update(connection,insTemp(map));
					if(!itDet.hasNext())
						sumChargeAmount = sumChargeAmount.add(chargeAmount);
				}
			}
		}
		request.setAttribute("sumChargeAmount", sumChargeAmount);
		request.setAttribute("sumTotalInterestAmount", sumTotalInterestAmount);
	}
}
