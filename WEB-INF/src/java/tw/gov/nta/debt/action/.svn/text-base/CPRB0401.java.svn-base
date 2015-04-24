/* CPRB0401.java 報表
 程式目的：CPRB04
 程式代號：CPRB04
 程式日期：0950308
 程式作者：Eric.Chen
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
 --------------------------------------------------------
 */
package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

import java.sql.Connection;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import tw.gov.nta.debt.form.Cprb0401Form;
import tw.gov.nta.sql.debt.DebtPlanDet;
import tw.gov.nta.sql.debt.dao.DebtPlanDetDAO;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class CPRB0401 extends DefaultAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM CPRB04_RPT ");
		//sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}

	protected SQLJob insTemp(ActionForm form,String usrId){
		Cprb0401Form cprb040101Form = (Cprb0401Form) form;
		SQLJob sqljob = new SQLJob();
		List mylist = new LinkedList();
		Session session = new DebtPlanDetDAO().getSession();
		Criteria criteria = session.createCriteria(DebtPlanDet.class); 
		if(null != cprb040101Form.getYear() && ! "".equals(cprb040101Form.getYear()))
		{
			criteria.add(Expression.between("repayDate",new Date(Integer.parseInt(cprb040101Form.getYear())+ 11 ,0,1),new Date(Integer.parseInt(cprb040101Form.getYear())+ 11 ,11,31)));
			//criteria.add(Expression.ge("repayDate",new Date(Integer.parseInt(cprb040101Form.getYear())+ 1911 ,0,1)));
			//criteria.add(Expression.le("repayDate",new Date(Integer.parseInt(cprb040101Form.getYear())+ 1911 ,11,31)));		
		}
		criteria.addOrder(Order.asc("repayDate"));
		mylist = criteria.list();
		Calendar myCalendar = Calendar.getInstance();
		if(null != mylist && 0 != mylist.size())
		{	
			for(Iterator it = mylist.iterator();it.hasNext();)
			{
				DebtPlanDet myPlan = (DebtPlanDet)it.next();
				sqljob.appendSQL("INSERT INTO CPRB04_RPT (Repay_date, Issue_name, Issue_amount, remark , usrid , mod_date )  VALUES ( '");
				sqljob.appendSQL(DateUtil.date2Str(myPlan.getRepayDate(),"YYYY/MM/DD")+ "' , '" + myPlan.getDebt().getIssue().getIssueSerial()+ "' ," + myPlan.getCapitalAmount());
				myCalendar.setTime(myPlan.getRepayDate());
				if(1 == myCalendar.get(Calendar.DAY_OF_WEEK) )
				{
					sqljob.appendSQL("," + " '提前於" + DateUtil.date2ChineseROC(new Date(myPlan.getRepayDate().getYear(),myPlan.getRepayDate().getMonth(),(myPlan.getRepayDate().getDate()-2))) + "還' ");
				}
				else if(7 == myCalendar.get(Calendar.DAY_OF_WEEK) )
				{
					sqljob.appendSQL("," + " '提前於" + DateUtil.date2ChineseROC(new Date(myPlan.getRepayDate().getYear(),myPlan.getRepayDate().getMonth(),(myPlan.getRepayDate().getDate()-1))) + "還'  ");
				}
				else
				{
					sqljob.appendSQL(" , '' ");
				}	
				sqljob.appendSQL(", '"+ usrId + "' , '" + DateUtil.date2Str(new Date(),"YYYY/MM/DD")+ "' ) ;");
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
		SQLJob sqljob = insTemp(form,usrId); 
		
		if(null != sqljob.getSQL() && ! "".equals(sqljob.getSQL()))
		{	
			run.update(connection,sqljob);
		}	
	}


}
