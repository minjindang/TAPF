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

import java.math.BigDecimal;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Apra0601Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

public class APRA0601 extends DefaultAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM APRA06_RPT ");
		System.out.println(sqljob.toString());
		return sqljob;
	}

	protected SQLJob insTemp(ActionForm form,String usrId ,Map map){
		Apra0601Form apra0601form = (Apra0601Form) form;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO APRA06_RPT ");
		sqljob.appendSQL(" ( ");
		sqljob.appendSQL(" USRID, MOD_DATE, REMARK, repay_date ,debt_name ,");
		sqljob.appendSQL(" issue_amount ) ");
		sqljob.appendSQL(" VALUES(?,?,?,?,?,?)");
		
		sqljob.addParameter(usrId);
		sqljob.addParameter(new Date());
		sqljob.addParameter(new String());
		sqljob.addParameter((Date)map.get("REPAY_DATE"));
		sqljob.addParameter((String)map.get("DEBT_NAME"));
		sqljob.addParameter((String)map.get("ROC_AMOUNT"));
		
		System.out.println(sqljob.toString());
		return sqljob;
	}
	public SQLJob getSQL1(ActionForm form)
	{
		Apra0601Form apra0601form = (Apra0601Form) form;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("SELECT (dateadd(day,(-1),repay_date)) AS REPAY_DATE , ");
		sqljob.appendSQL(" tmp+(case when capital_serial>0 then '本金' else '第' + convert(varchar, interest_serial)+'次利息' end) AS DEBT_NAME ,  ");
		sqljob.appendSQL(" (case when capital_serial>0 then sum(capital_amount) else sum(interest_amount)  end) AS AMOUNT ");
		sqljob.appendSQL(" from v_apra06 ");
		if( null != apra0601form.getRepayDate())
		{
			String repayYM = apra0601form.getRepayDate();
			int year = Integer.parseInt(repayYM.substring(0, 3));
			int month = Integer.parseInt(repayYM.substring(3, 5));
			Date startDate = new Date(year+11 , month-1 , 2);
			Date endDate = new Date(year+11 , month, 1);
			sqljob.appendSQL(" WHERE REPAY_DATE >= ? AND REPAY_DATE <= ? ");
			sqljob.addParameter(DateUtil.date2Str(startDate, "yyyy/MM/dd"));
			sqljob.addParameter(DateUtil.date2Str(endDate, "yyyy/MM/dd"));
			
		}
		sqljob.appendSQL("group by repay_date , tmp , capital_serial , interest_serial");
		sqljob.appendSQL("order by repay_date");
		System.out.println(sqljob.toString());
		return sqljob;
	}
//	舊程式
//	public SQLJob getSQL1(ActionForm form)
//	{
//		Apra0601Form apra0601form = (Apra0601Form) form;
//		SQLJob sqljob = new SQLJob();
//		sqljob.appendSQL("SELECT P.REPAY_DATE , ");
//		sqljob.appendSQL(" I.DEBT_NAME , SUM(P.CAPITAL_AMOUNT) AS AMOUNT ");
//		sqljob.appendSQL(" FROM ISSUE_MAIN I, DEBT_PLAN_DET P");
//		sqljob.appendSQL(" WHERE I.ID=P.ISSUE_ID AND (I.DEBT_TYPE='A' OR I.DEBT_TYPE='B') ");
//		if( null != apra0601form.getRepayDate())
//		{
//			sqljob.appendSQL("AND P.REPAY_DATE=? ");
//			sqljob.addParameter(apra0601form.getRepayDate());
//		}
//		sqljob.appendSQL("GROUP BY P.REPAY_DATE,I.DEBT_NAME");
//		sqljob.appendSQL("ORDER BY P.REPAY_DATE");
//		System.out.println(sqljob.toString());
//		return sqljob;
//	}
//	public SQLJob getSQL2(ActionForm form)
//	{
//		Apra0601Form apra0601form = (Apra0601Form) form;
//		SQLJob sqljob = new SQLJob();		
//		sqljob.appendSQL("SELECT  P.REPAY_DATE , ");
//		sqljob.appendSQL(" I.DEBT_NAME ,SUM(P.INTEREST_AMOUNT) AS AMOUNT ");
//		sqljob.appendSQL(" FROM ISSUE_MAIN I, DEBT_PLAN_DET P");
//		sqljob.appendSQL(" WHERE I.ID=P.ISSUE_ID AND (I.DEBT_TYPE='A' OR I.DEBT_TYPE='B') ");
//		if( null != apra0601form.getRepayDate())
//		{
//			sqljob.appendSQL("AND P.REPAY_DATE=? ");
//			sqljob.addParameter(apra0601form.getRepayDate());
//		}
//		sqljob.appendSQL("GROUP BY P.REPAY_DATE,I.DEBT_NAME");
//		sqljob.appendSQL("ORDER BY P.REPAY_DATE");
//		System.out.println(sqljob.toString());
//		return sqljob;
//	}
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {

		//取得使用者帳號
		String usrId = request.getSession().getAttribute("ACCOUNT").toString();
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delTemp(form,usrId));
		//執行 insert
		
		List list1 = (List) run.query(getSQL1(form), new MapListHandler()); 
//		List list2 = (List) run.query(getSQL2(form), new MapListHandler()); 
		
		if(null != list1 && 0 != list1.size())
		{
			for(Iterator it=list1.iterator();it.hasNext();)
			{	
				Map map =(Map)it.next();
				BigDecimal amount = ((BigDecimal)(map.get("AMOUNT"))).setScale(0,5);
				map.put("ROC_AMOUNT",getROCAmount(amount));
				System.out.println(amount.toString());
				run.update(connection,insTemp(form,usrId,map));
			}
		}	
			
//		if(null != list2 && 0 != list2.size())
//		{
//			for(Iterator it=list2.iterator();it.hasNext();)
//			{	
//				Map map =(Map)it.next();
//				BigDecimal amount = ((BigDecimal)(map.get("AMOUNT"))).setScale(0,5);
//				System.out.println(amount.toString());
//				map.put("ROC_AMOUNT",getROCAmount(amount));
//				run.update(connection,insTemp(form,usrId,map));
//			}
//		}	
	
	}
	
	public String getROCAmount(BigDecimal money)
	{
		StringBuffer str = new StringBuffer();
		BigDecimal tempMoney = new BigDecimal(0);
		
		if(1 == money.compareTo(new BigDecimal(0)) || 0 == money.compareTo(new BigDecimal(0)))
		{
			tempMoney = money.remainder(new BigDecimal(10000));
			money = money.divide(new BigDecimal(10000),BigDecimal.ROUND_DOWN);
			if(1 == tempMoney.compareTo(new BigDecimal(0)))
			{
				str.append(tempMoney);
			}	
			if(1 == money.compareTo(new BigDecimal(0)))
			{
				tempMoney = money.remainder(new BigDecimal(10000));
				money = money.divide(new BigDecimal(10000),BigDecimal.ROUND_DOWN);
				if(1 == tempMoney.compareTo(new BigDecimal(0)) && 0 != tempMoney.compareTo(new BigDecimal(0)))
				{
					str.insert(0,new DecimalFormat("#,###").format(tempMoney)  +"萬");
				}
				if(1 == money.compareTo(new BigDecimal(0)))
				{
					str.insert(0,new DecimalFormat("#,###").format(money)+"億");
				}
			}	

		}	
		return "新台幣"+str.toString()+"元整";
	}

}
