/* CIRA0201.java 報表
 程式目的：CIRA02
 程式代號：CIRA02
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
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.hibernate.Query;
import org.hibernate.Session;

import tw.gov.nta.debt.form.Cira0201Form;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.dao.DebtMainDAO;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class CIRA0201 extends DefaultAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM CIRA02_RPT ");
		//sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}

	protected SQLJob insTemp(ActionForm form,String usrId){
		Cira0201Form cira0201Form = (Cira0201Form) form;
		SQLJob sqljob = new SQLJob();
		/**
		 * 由 debtMain 取資料
		 */
		Session session = new DebtMainDAO().createNewSession();
		StringBuffer str = new StringBuffer();
		str.append("from DebtMain debtMain where debtMain.issue.debtType = 'C' ");
		if( null != cira0201Form.getIssueSerial() && !"".equals(cira0201Form.getIssueSerial()))
		{    
			str.append("and debtMain.issue.issueSerial = '" + cira0201Form.getIssueSerial()+ "' ");
		}
		str.append("order by debtMain.compareFlag asc , debtMain.compareRate asc ");
		Query query = session.createQuery(str.toString());
		List myList = query.list();
		/**
		 * 將資料併成 insert 的 SQL
		 */
		int no = 1;
		if(null != myList && 0 != myList.size())
		{
			for(Iterator it = myList.iterator();it.hasNext();)
			{	
				DebtMain debtMain = (DebtMain)it.next();
				
				sqljob.appendSQL("INSERT INTO CIRA02_RPT ");
				sqljob.appendSQL(" ( ");
				sqljob.appendSQL(" average_rate , issue_Date , due_date , USRID, MOD_DATE, REMARK, Bank_name,compare_amount,compare_rate,No,accrue,issue_amount,finish_date )");
				sqljob.appendSQL(" Values(");
				sqljob.appendSQL(debtMain.getIssue().getAverageRate().toString());		//AverageRate
				sqljob.appendSQL(" , ");
				sqljob.appendSQL(null!=debtMain.getIssue().getIssueDate()?"'"+DateUtil.date2Str(debtMain.getIssue().getIssueDate(),"yyyy/MM/dd")+"'":"null");//issue_Date
				sqljob.appendSQL(" , ");
				sqljob.appendSQL(null!=debtMain.getIssue().getDueDate()?"'"+DateUtil.date2Str(debtMain.getIssue().getDueDate(),"yyyy/MM/dd")+"'":"null");//due_date
				sqljob.appendSQL(" , '");
				sqljob.appendSQL(usrId);										//USRID
				sqljob.appendSQL("' , ");
				sqljob.appendSQL(DateUtil.date2Str(new Date(),"yyyy/MM/dd"));	//MOD_DATE
				sqljob.appendSQL(" , ");
				sqljob.appendSQL(" null ");										//REMARK
				sqljob.appendSQL(" , '");
				sqljob.appendSQL(debtMain.getBank().getBankName());				//Bank_name
				sqljob.appendSQL("' , ");
				sqljob.appendSQL(debtMain.getCompareAmount().divide(new BigDecimal(cira0201Form.getBaseUnit())).toString());//compare_amount 除 單位
				sqljob.appendSQL(" , ");
				sqljob.appendSQL(debtMain.getCompareRate().divide(new BigDecimal(100),5,5).toString());					//compare_rate
				sqljob.appendSQL(" , ");
				sqljob.appendSQL(Integer.toString(no));							//No
				sqljob.appendSQL(" , '");
				sqljob.appendSQL("Y".equals(debtMain.getCompareFlag())?"廢標":" ");					//accrue
				sqljob.appendSQL("' , ");
				sqljob.appendSQL(debtMain.getIssueAmount().divide(new BigDecimal(cira0201Form.getBaseUnit())).toString());//issue_amount 除 單位
				sqljob.appendSQL(" , ");
				sqljob.appendSQL(null!=debtMain.getIssue().getFinishDate()?"'"+DateUtil.date2Str(debtMain.getIssue().getFinishDate(),"yyyy/MM/dd")+"'":"null");
				sqljob.appendSQL(" )");
				no = no + 1;													//累加的流水號
			}
		}	
		System.out.println(sqljob);
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
