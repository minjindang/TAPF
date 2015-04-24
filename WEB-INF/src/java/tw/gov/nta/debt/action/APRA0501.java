/* APRA0501.java 報表
 程式目的：APRA05
 程式代號：APRA05
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

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Apra0501Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class APRA0501 extends DefaultAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM APRA05_RPT ");
		System.out.println(sqljob.toString());
		return sqljob;
	}

	protected SQLJob insTemp(ActionForm form,String usrId){
		Apra0501Form apra0501form = (Apra0501Form) form;
		SQLJob sqljob = new SQLJob();
		String limitDate = null;
		StringBuffer strb1 = new StringBuffer();
		StringBuffer strb2 = new StringBuffer();
		StringBuffer strb3 = new StringBuffer();
		StringBuffer strb4 = new StringBuffer();
		
		if(null != apra0501form.getLimitDate() )
		{
			limitDate = DateUtil.date2Str(apra0501form.getLimitDate());
		}
		
		/** 累計交換面額*/
		strb1.append(getMoneySql("0",limitDate));
		/** 累計提前賣回*/
		strb2.append(getMoneySql("1",limitDate));
		/** 累計提前收回*/
		strb3.append(getMoneySql("2",limitDate));
		/** 付息累計數*/
		strb4.append(getInterestSql(limitDate));

		
		sqljob.appendSQL("INSERT INTO APRA05_RPT ");
		sqljob.appendSQL(" ( ");
		sqljob.appendSQL(" usrid, MOD_DATE, REMARK, debt_name, issue_date, ");
		sqljob.appendSQL(" issue_amount, total_exg_amount, total_buy_amount, total_back_amount, nopay_capital_amount, ");
		sqljob.appendSQL(" pay_interest_amount ");
		sqljob.appendSQL(" ) ");
		sqljob.appendSQL("SELECT '"+usrId+"', CURRENT_TIMESTAMP, null ,");
		sqljob.appendSQL("DEBT_NAME , ISSUE_DATE , SUM(D.ISSUE_AMOUNT) ,");
		sqljob.appendSQL("("+strb1+"),");
		sqljob.appendSQL("("+strb2+"),");
		sqljob.appendSQL("("+strb3+"),");
		/** 尚未償還面額 */
		sqljob.appendSQL("(SUM(D.ISSUE_AMOUNT) -" + "("+strb1+") - " + "("+strb2+") - " + "("+strb3+") ),");
		sqljob.appendSQL("("+strb4+") ");
		
		sqljob.appendSQL("FROM ISSUE_MAIN I, DEBT_MAIN D ");
		sqljob.appendSQL("WHERE I.DEBT_TYPE = 'A' AND I.BOND_KIND = '4' AND D.ISSUE_ID = I.ID ");
		if( null != apra0501form.getIssueSdate())
		{
			sqljob.appendSQL("AND I.ISSUE_DATE >= ? ");
			sqljob.addParameter(DateUtil.date2Str(apra0501form.getIssueSdate()));
		}
		if( null != apra0501form.getIssueEdate())
		{
			sqljob.appendSQL("AND I.ISSUE_DATE <= ? ");
			sqljob.addParameter(DateUtil.date2Str(apra0501form.getIssueEdate()));
		}
		
		if( null != apra0501form.getBudgetCode() && !"".equals(apra0501form.getBudgetCode()))
		{
			sqljob.appendSQL("AND D.BUDGET_CODE = ? ");
			sqljob.addParameter(apra0501form.getBudgetCode());
		}
		sqljob.appendSQL("group by I.Debt_NAME , I.ISSUE_DATE , I.ID");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	public String getMoneySql(String type,String repayDate)
	{
		StringBuffer str1 = new StringBuffer();
		str1.append(" select isnull(sum(C.capital_amount),cast(0 as int)) from  payment_main1 c ");
		str1.append(" where a.debt_type = 'A' and A.bond_kind = '4' and b.issue_id = a.id and a.id = I.id ");
		str1.append(" and c.repay_type = '");
		str1.append(type);
		str1.append("' ");
		str1.append("and c.repay_date < = '");
		str1.append(repayDate);
		str1.append("' ");
		return str1.toString();
	}
	public String getInterestSql(String repayDate)
	{
		StringBuffer str1 = new StringBuffer();
		str1.append(" select isnull(sum(C.interest_amount),cast(0 as int)) from issue_main a , debt_main b , payment_main1 c ");
		str1.append(" where a.debt_type = 'A' and A.bond_kind = '4' and b.issue_id = a.id and a.id = I.id ");
		str1.append("and c.repay_date < = '");
		str1.append(repayDate);
		str1.append("' ");
		return str1.toString();
	}
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {

		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delTemp(form,usrId));
		//執行 insert
		run.update(connection,insTemp(form,usrId));
	}
}
