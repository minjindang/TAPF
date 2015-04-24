/* AIRB0501.java 報表
 程式目的：AIRB05
 程式代號：AIRB05
程式日期：0950416
 程式作者：icefire
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Airb0501Form;
import tw.gov.nta.debt.form.Airb0501Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class AIRB0501 extends DefaultAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM AIRB05_RPT ");
		//sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}

	 protected SQLJob insTemp(ActionForm form,String usrId,Map map,String name){
			Airb0501Form myform = (Airb0501Form) form;
			BigDecimal totalAmount = new BigDecimal(0);
			SQLJob sqljob = new SQLJob();
			sqljob.appendSQL("INSERT INTO AIRB05_RPT ");
			sqljob.appendSQL(" ( ");
			sqljob.appendSQL(" USRID, MOD_DATE, REMARK,");
			sqljob.appendSQL(" PAY_TYPE,ACCOUNT_YEAR,BOND_KIND, ");
			sqljob.appendSQL(" JAN_AMOUNT,FEB_AMOUNT,MAR_AMOUNT, ");
			sqljob.appendSQL(" APR_AMOUNT,MAY_AMOUNT,JUE_AMOUNT, ");
			sqljob.appendSQL(" JUL_AMOUNT,AUG_AMOUNT,SEP_AMOUNT, ");
			sqljob.appendSQL(" OCT_AMOUNT,NOV_AMOUNT,DEC_AMOUNT, ");
			sqljob.appendSQL(" TOTAL_AMOUNT ) ");	
			sqljob.appendSQL(" VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
			sqljob.addParameter(usrId);
			sqljob.addParameter(new Date());
			sqljob.addParameter("");
			sqljob.addParameter((String)(map.get("type")));
			sqljob.addParameter((String)(map.get("yy")));
			sqljob.addParameter(("o".equals(name)?"原始":"增額"));
			sqljob.addParameter(((BigDecimal)(map.get(name+"_Capital_1"))).divide(new BigDecimal(100000000)));
			sqljob.addParameter(((BigDecimal)(map.get(name+"_Capital_2"))).divide(new BigDecimal(100000000)));
			sqljob.addParameter(((BigDecimal)(map.get(name+"_Capital_3"))).divide(new BigDecimal(100000000)));
			sqljob.addParameter(((BigDecimal)(map.get(name+"_Capital_4"))).divide(new BigDecimal(100000000)));
			sqljob.addParameter(((BigDecimal)(map.get(name+"_Capital_5"))).divide(new BigDecimal(100000000)));
			sqljob.addParameter(((BigDecimal)(map.get(name+"_Capital_6"))).divide(new BigDecimal(100000000)));
			sqljob.addParameter(((BigDecimal)(map.get(name+"_Capital_7"))).divide(new BigDecimal(100000000)));
			sqljob.addParameter(((BigDecimal)(map.get(name+"_Capital_8"))).divide(new BigDecimal(100000000)));
			sqljob.addParameter(((BigDecimal)(map.get(name+"_Capital_9"))).divide(new BigDecimal(100000000)));
			sqljob.addParameter(((BigDecimal)(map.get(name+"_Capital_10"))).divide(new BigDecimal(100000000)));
			sqljob.addParameter(((BigDecimal)(map.get(name+"_Capital_11"))).divide(new BigDecimal(100000000)));
			sqljob.addParameter(((BigDecimal)(map.get(name+"_Capital_12"))).divide(new BigDecimal(100000000)));
			for(int i=1;i<13;i++)
			{
				if(null !=(BigDecimal)(map.get(name+"_Capital_"+ i)))
				{
					totalAmount = totalAmount.add((BigDecimal)(map.get(name+"_Capital_"+ i)));
				}	
			}	
			sqljob.addParameter((totalAmount).divide(new BigDecimal(100000000)));
			System.out.println(sqljob);
			return sqljob;
		}
	  	public SQLJob getOriginal(ActionForm form)
	  	{
	  		Airb0501Form myform = (Airb0501Form) form;
	  		SQLJob sqljob = new SQLJob();
	  		sqljob.appendSQL("select substring(right('0000000'+convert(varchar,(convert(varchar,b.repay_date, 112)-19110000)),7),1,3) as yy,'本' as type, ");
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='1' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/1/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/2/1' then b.capital_amount else 0 end)),2) as o_Capital_1, ");
			sqljob.appendSQL("round(sum((case when c.bond_kind='1' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/2/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/3/1' then b.capital_amount else 0 end)),2) as o_Capital_2, ");
			sqljob.appendSQL("round(sum((case when c.bond_kind='1' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/3/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/4/1' then b.capital_amount else 0 end)),2) as o_Capital_3, ");
			sqljob.appendSQL("round(sum((case when c.bond_kind='1' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/4/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/5/1' then b.capital_amount else 0 end)),2) as o_Capital_4, ");
			sqljob.appendSQL("round(sum((case when c.bond_kind='1' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/5/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/6/1' then b.capital_amount else 0 end)),2) as o_Capital_5, ");
			sqljob.appendSQL("round(sum((case when c.bond_kind='1' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/6/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/7/1' then b.capital_amount else 0 end)),2) as o_Capital_6, ");
			sqljob.appendSQL("round(sum((case when c.bond_kind='1' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/7/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/8/1' then b.capital_amount else 0 end)),2) as o_Capital_7, ");
			sqljob.appendSQL("round(sum((case when c.bond_kind='1' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/8/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/9/1' then b.capital_amount else 0 end)),2) as o_Capital_8, ");
			sqljob.appendSQL("round(sum((case when c.bond_kind='1' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/9/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/10/1' then b.capital_amount else 0 end)),2) as o_Capital_9, ");
			sqljob.appendSQL("round(sum((case when c.bond_kind='1' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/10/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/11/1' then b.capital_amount else 0 end)),2) as o_Capital_10, ");
			sqljob.appendSQL("round(sum((case when c.bond_kind='1' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/11/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/12/1' then b.capital_amount else 0 end)),2) as o_Capital_11, ");
			sqljob.appendSQL("round(sum((case when c.bond_kind='1' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/12/1' and  b.repay_date <=  Cast(Cast(Year(b.repay_date) as int(10))+1 as varchar(10))+'/1/1' then b.capital_amount else 0 end)),2) as o_Capital_12 ");
	        sqljob.appendSQL("from debt_main a,debt_plan_det b,issue_main c ");
	        sqljob.appendSQL("where c.debt_type='A' ");
	        sqljob.appendSQL("and a.issue_id=c.id ");
	        if(null != myform.getbudgetCode() && !"".equals(myform.getbudgetCode()))
	        {
	            sqljob.appendSQL("and (a.Budget_code= ? ) ");
	            sqljob.addParameter(Integer.parseInt(myform.getbudgetCode()));
	        }	
	        if(null != myform.getDebtCode() && !"".equals(myform.getDebtCode()))
	        {
	            sqljob.appendSQL("and a.Debt_code= ? ");
	            sqljob.addParameter(Integer.parseInt(myform.getDebtCode()));
	        }
	        if(null != myform.getBondSellStatus() && !"".equals(myform.getBondSellStatus()))
	        {	
	        	if("Y".equals(myform.getBondSellStatus()))
	        	{
	        		sqljob.appendSQL("and bond_sell_status= ? ");
	            	sqljob.addParameter(myform.getBondSellStatus());
	        	}
	        	else
	        	{
	        		sqljob.appendSQL("and bond_kind=4 "); 
	        	}	
	        }	
	        sqljob.appendSQL("and a.id=b.debt_id ");
	        sqljob.appendSQL("and substring(right('0000000'+convert(varchar,(convert(varchar,b.repay_date, 112)-19110000)),7),1,3)>= ? ");
	        sqljob.addParameter(myform.getrepay_SDate());
	  		sqljob.appendSQL("and substring(right('0000000'+convert(varchar,(convert(varchar,b.repay_date, 112)-19110000)),7),1,3)<= ? ");
	        sqljob.addParameter(myform.getrepay_EDate());
	  		sqljob.appendSQL("group by substring(right('0000000'+convert(varchar,(convert(varchar,b.repay_date, 112)-19110000)),7),1,3) ");
	  		
	  		sqljob.appendSQL("union ");
	  		
	  		sqljob.appendSQL("select substring(right('0000000'+convert(varchar,(convert(varchar,b.repay_date, 112)-19110000)),7),1,3) as yy, '息' as type, ");
	  		
	  		
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='1' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/1/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/2/1' then b.Interest_amount else 0 end)),2) as o_Interest_1, ");
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='1' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/2/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/3/1' then b.Interest_amount else 0 end)),2) as o_Interest_2, ");
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='1' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/3/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/4/1' then b.Interest_amount else 0 end)),2) as o_Interest_3, ");
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='1' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/4/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/5/1' then b.Interest_amount else 0 end)),2) as o_Interest_4, ");
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='1' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/5/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/6/1' then b.Interest_amount else 0 end)),2) as o_Interest_5, ");
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='1' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/6/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/7/1' then b.Interest_amount else 0 end)),2) as o_Interest_6, ");
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='1' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/7/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/8/1' then b.Interest_amount else 0 end)),2) as o_Interest_7, ");
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='1' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/8/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/9/1' then b.Interest_amount else 0 end)),2) as o_Interest_8, ");
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='1' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/9/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/10/1' then b.Interest_amount else 0 end)),2) as o_Interest_9, ");
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='1' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/10/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/11/1' then b.Interest_amount else 0 end)),2) as o_Interest_10, ");
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='1' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/11/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/12/1' then b.Interest_amount else 0 end)),2) as o_Interest_11, ");
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='1' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/12/1' and  b.repay_date <=  Cast(Cast(Year(b.repay_date) as int(10))+1 as varchar(10))+'/1/1' then b.Interest_amount else 0 end)),2) as o_Interest_12 ");
	        sqljob.appendSQL("from debt_main a,debt_plan_det b,issue_main c ");
	        sqljob.appendSQL("where c.debt_type='A' ");
	        sqljob.appendSQL("and a.issue_id=c.id ");
	        if(null != myform.getbudgetCode() && !"".equals(myform.getbudgetCode()))
	        {
	            sqljob.appendSQL("and (a.Budget_code= ? ) ");
	            sqljob.addParameter(Integer.parseInt(myform.getbudgetCode()));
	        }	
	        if(null != myform.getDebtCode() && !"".equals(myform.getDebtCode()))
	        {
	            sqljob.appendSQL("and a.Debt_code= ? ");
	            sqljob.addParameter(Integer.parseInt(myform.getDebtCode()));
	        }
	        if(null != myform.getBondSellStatus() && !"".equals(myform.getBondSellStatus()))
	        {	
	        	if("Y".equals(myform.getBondSellStatus()))
	        	{
	        		sqljob.appendSQL("and bond_sell_status= ? ");
	            	sqljob.addParameter(myform.getBondSellStatus());
	        	}
	        	else
	        	{
	        		sqljob.appendSQL("and bond_kind=4 "); 
	        	}	
	        }	
	        sqljob.appendSQL("and a.id=b.debt_id ");
	        sqljob.appendSQL("and substring(right('0000000'+convert(varchar,(convert(varchar,b.repay_date, 112)-19110000)),7),1,3)>= ? ");
	        sqljob.addParameter(myform.getrepay_SDate());
	  		sqljob.appendSQL("and substring(right('0000000'+convert(varchar,(convert(varchar,b.repay_date, 112)-19110000)),7),1,3)<= ? ");
	        sqljob.addParameter(myform.getrepay_EDate());
	  		sqljob.appendSQL("group by substring(right('0000000'+convert(varchar,(convert(varchar,b.repay_date, 112)-19110000)),7),1,3) ");
//	  		sqljob.appendSQL("order by 1,2 ");
	  		//提前買回
	  		sqljob.appendSQL("union ");
	  		sqljob.appendSQL("select substring(right('0000000'+convert(varchar,(convert(varchar,b.repay_date, 112)-19110000)),7),1,3) as yy,'本' as type, ");
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='1' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/1/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/2/1' then b.capital_amount else 0 end)),2) as o_Capital_1, ");
			sqljob.appendSQL("round(sum((case when c.bond_kind='1' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/2/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/3/1' then b.capital_amount else 0 end)),2) as o_Capital_2, ");
			sqljob.appendSQL("round(sum((case when c.bond_kind='1' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/3/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/4/1' then b.capital_amount else 0 end)),2) as o_Capital_3, ");
			sqljob.appendSQL("round(sum((case when c.bond_kind='1' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/4/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/5/1' then b.capital_amount else 0 end)),2) as o_Capital_4, ");
			sqljob.appendSQL("round(sum((case when c.bond_kind='1' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/5/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/6/1' then b.capital_amount else 0 end)),2) as o_Capital_5, ");
			sqljob.appendSQL("round(sum((case when c.bond_kind='1' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/6/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/7/1' then b.capital_amount else 0 end)),2) as o_Capital_6, ");
			sqljob.appendSQL("round(sum((case when c.bond_kind='1' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/7/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/8/1' then b.capital_amount else 0 end)),2) as o_Capital_7, ");
			sqljob.appendSQL("round(sum((case when c.bond_kind='1' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/8/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/9/1' then b.capital_amount else 0 end)),2) as o_Capital_8, ");
			sqljob.appendSQL("round(sum((case when c.bond_kind='1' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/9/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/10/1' then b.capital_amount else 0 end)),2) as o_Capital_9, ");
			sqljob.appendSQL("round(sum((case when c.bond_kind='1' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/10/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/11/1' then b.capital_amount else 0 end)),2) as o_Capital_10, ");
			sqljob.appendSQL("round(sum((case when c.bond_kind='1' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/11/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/12/1' then b.capital_amount else 0 end)),2) as o_Capital_11, ");
			sqljob.appendSQL("round(sum((case when c.bond_kind='1' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/12/1' and  b.repay_date <=  Cast(Cast(Year(b.repay_date) as int(10))+1 as varchar(10))+'/1/1' then b.capital_amount else 0 end)),2) as o_Capital_12 ");
	        sqljob.appendSQL("from debt_main a,payment_main b,issue_main c ");
	        sqljob.appendSQL("where c.debt_type='A' ");
	        sqljob.appendSQL("and a.issue_id=c.id ");
			sqljob.appendSQL("and b.REPAY_DATE <> b.PLAN_REPAY_DATE ");
			sqljob.appendSQL("and b.CAPITAL_AMOUNT > 0 ");
			sqljob.appendSQL("and 'Y' <> (select d.delete_mark from debt_plan_det d where d.id = plan_id) ");
	        if(null != myform.getbudgetCode() && !"".equals(myform.getbudgetCode()))
	        {
	            sqljob.appendSQL("and (a.Budget_code= ? ) ");
	            sqljob.addParameter(Integer.parseInt(myform.getbudgetCode()));
	        }	
	        if(null != myform.getDebtCode() && !"".equals(myform.getDebtCode()))
	        {
	            sqljob.appendSQL("and a.Debt_code= ? ");
	            sqljob.addParameter(Integer.parseInt(myform.getDebtCode()));
	        }
	        if(null != myform.getBondSellStatus() && !"".equals(myform.getBondSellStatus()))
	        {	
	        	if("Y".equals(myform.getBondSellStatus()))
	        	{
	        		sqljob.appendSQL("and bond_sell_status= ? ");
	            	sqljob.addParameter(myform.getBondSellStatus());
	        	}
	        	else
	        	{
	        		sqljob.appendSQL("and bond_kind=4 "); 
	        	}	
	        }	
	        sqljob.appendSQL("and a.id=b.debt_id ");
	        sqljob.appendSQL("and substring(right('0000000'+convert(varchar,(convert(varchar,b.repay_date, 112)-19110000)),7),1,3)>= ? ");
	        sqljob.addParameter(myform.getrepay_SDate());
	  		sqljob.appendSQL("and substring(right('0000000'+convert(varchar,(convert(varchar,b.repay_date, 112)-19110000)),7),1,3)<= ? ");
	        sqljob.addParameter(myform.getrepay_EDate());
	  		sqljob.appendSQL("group by substring(right('0000000'+convert(varchar,(convert(varchar,b.repay_date, 112)-19110000)),7),1,3) ");
	  		
	  		sqljob.appendSQL("union ");
	  		
	  		sqljob.appendSQL("select substring(right('0000000'+convert(varchar,(convert(varchar,b.repay_date, 112)-19110000)),7),1,3) as yy, '息' as type, ");
	  		
	  		
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='1' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/1/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/2/1' then b.Interest_amount else 0 end)),2) as o_Interest_1, ");
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='1' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/2/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/3/1' then b.Interest_amount else 0 end)),2) as o_Interest_2, ");
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='1' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/3/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/4/1' then b.Interest_amount else 0 end)),2) as o_Interest_3, ");
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='1' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/4/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/5/1' then b.Interest_amount else 0 end)),2) as o_Interest_4, ");
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='1' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/5/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/6/1' then b.Interest_amount else 0 end)),2) as o_Interest_5, ");
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='1' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/6/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/7/1' then b.Interest_amount else 0 end)),2) as o_Interest_6, ");
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='1' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/7/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/8/1' then b.Interest_amount else 0 end)),2) as o_Interest_7, ");
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='1' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/8/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/9/1' then b.Interest_amount else 0 end)),2) as o_Interest_8, ");
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='1' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/9/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/10/1' then b.Interest_amount else 0 end)),2) as o_Interest_9, ");
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='1' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/10/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/11/1' then b.Interest_amount else 0 end)),2) as o_Interest_10, ");
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='1' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/11/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/12/1' then b.Interest_amount else 0 end)),2) as o_Interest_11, ");
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='1' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/12/1' and  b.repay_date <=  Cast(Cast(Year(b.repay_date) as int(10))+1 as varchar(10))+'/1/1' then b.Interest_amount else 0 end)),2) as o_Interest_12 ");
	        sqljob.appendSQL("from debt_main a,payment_main b,issue_main c ");
	        sqljob.appendSQL("where c.debt_type='A' ");
	        sqljob.appendSQL("and a.issue_id=c.id ");
			sqljob.appendSQL("and b.REPAY_DATE <> b.PLAN_REPAY_DATE ");
			sqljob.appendSQL("and b.CAPITAL_AMOUNT > 0 ");
			sqljob.appendSQL("and 'Y' <> (select d.delete_mark from debt_plan_det d where d.id = plan_id) ");
	        if(null != myform.getbudgetCode() && !"".equals(myform.getbudgetCode()))
	        {
	            sqljob.appendSQL("and (a.Budget_code= ? ) ");
	            sqljob.addParameter(Integer.parseInt(myform.getbudgetCode()));
	        }	
	        if(null != myform.getDebtCode() && !"".equals(myform.getDebtCode()))
	        {
	            sqljob.appendSQL("and a.Debt_code= ? ");
	            sqljob.addParameter(Integer.parseInt(myform.getDebtCode()));
	        }
	        if(null != myform.getBondSellStatus() && !"".equals(myform.getBondSellStatus()))
	        {	
	        	if("Y".equals(myform.getBondSellStatus()))
	        	{
	        		sqljob.appendSQL("and bond_sell_status= ? ");
	            	sqljob.addParameter(myform.getBondSellStatus());
	        	}
	        	else
	        	{
	        		sqljob.appendSQL("and bond_kind=4 "); 
	        	}	
	        }	
	        sqljob.appendSQL("and a.id=b.debt_id ");
	        sqljob.appendSQL("and substring(right('0000000'+convert(varchar,(convert(varchar,b.repay_date, 112)-19110000)),7),1,3)>= ? ");
	        sqljob.addParameter(myform.getrepay_SDate());
	  		sqljob.appendSQL("and substring(right('0000000'+convert(varchar,(convert(varchar,b.repay_date, 112)-19110000)),7),1,3)<= ? ");
	        sqljob.addParameter(myform.getrepay_EDate());
	  		sqljob.appendSQL("group by substring(right('0000000'+convert(varchar,(convert(varchar,b.repay_date, 112)-19110000)),7),1,3) ");
	  		sqljob.appendSQL("order by 1,2 ");
	  
	  		System.out.println(sqljob);
	  		return sqljob;
	  	}
	  	public SQLJob getAdd(ActionForm form)
	  	{
	  		Airb0501Form myform = (Airb0501Form) form;
	  		SQLJob sqljob = new SQLJob();
	  		sqljob.appendSQL("select substring(right('0000000'+convert(varchar,(convert(varchar,b.repay_date, 112)-19110000)),7),1,3) as yy, '本' as type, ");
	  		
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='3' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/1/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/2/1' then b.capital_amount else 0 end)),2) as i_Capital_1, ");
			sqljob.appendSQL("round(sum((case when c.bond_kind='3' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/2/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/3/1' then b.capital_amount else 0 end)),2) as i_Capital_2, ");
			sqljob.appendSQL("round(sum((case when c.bond_kind='3' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/3/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/4/1' then b.capital_amount else 0 end)),2) as i_Capital_3, ");
			sqljob.appendSQL("round(sum((case when c.bond_kind='3' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/4/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/5/1' then b.capital_amount else 0 end)),2) as i_Capital_4, ");
			sqljob.appendSQL("round(sum((case when c.bond_kind='3' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/5/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/6/1' then b.capital_amount else 0 end)),2) as i_Capital_5, ");
			sqljob.appendSQL("round(sum((case when c.bond_kind='3' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/6/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/7/1' then b.capital_amount else 0 end)),2) as i_Capital_6, ");
			sqljob.appendSQL("round(sum((case when c.bond_kind='3' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/7/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/8/1' then b.capital_amount else 0 end)),2) as i_Capital_7, ");
			sqljob.appendSQL("round(sum((case when c.bond_kind='3' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/8/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/9/1' then b.capital_amount else 0 end)),2) as i_Capital_8, ");
			sqljob.appendSQL("round(sum((case when c.bond_kind='3' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/9/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/10/1' then b.capital_amount else 0 end)),2) as i_Capital_9, ");
			sqljob.appendSQL("round(sum((case when c.bond_kind='3' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/10/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/11/1' then b.capital_amount else 0 end)),2) as i_Capital_10, ");
			sqljob.appendSQL("round(sum((case when c.bond_kind='3' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/11/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/12/1' then b.capital_amount else 0 end)),2) as i_Capital_11, ");
			sqljob.appendSQL("round(sum((case when c.bond_kind='3' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/12/1' and  b.repay_date <=  Cast(Cast(Year(b.repay_date) as int(10))+1 as varchar(10))+'/1/1' then b.capital_amount else 0 end)),2) as i_Capital_12 ");
	        sqljob.appendSQL("from debt_main a,debt_plan_det b,issue_main c ");
	        sqljob.appendSQL("where c.debt_type='A' ");
	        sqljob.appendSQL("and a.issue_id=c.id ");
	        if(null != myform.getbudgetCode() && !"".equals(myform.getbudgetCode()))
	        {
	            sqljob.appendSQL("and (a.Budget_code= ? ) ");
	            sqljob.addParameter(Integer.parseInt(myform.getbudgetCode()));
	        }	
	        if(null != myform.getDebtCode() && !"".equals(myform.getDebtCode()))
	        {
	            sqljob.appendSQL("and a.Debt_code= ? ");
	            sqljob.addParameter(Integer.parseInt(myform.getDebtCode()));
	        }
	        if(null != myform.getBondSellStatus() && !"".equals(myform.getBondSellStatus()))
	        {	
	        	if("Y".equals(myform.getBondSellStatus()))
	        	{
	        		sqljob.appendSQL("and bond_sell_status= ? ");
	            	sqljob.addParameter(myform.getBondSellStatus());
	        	}
	        	else
	        	{
	        		sqljob.appendSQL("and bond_kind=4 "); 
	        	}	
	        }	
	        sqljob.appendSQL("and a.id=b.debt_id ");
	        sqljob.appendSQL("and substring(right('0000000'+convert(varchar,(convert(varchar,b.repay_date, 112)-19110000)),7),1,3)>= ? ");
	        sqljob.addParameter(myform.getrepay_SDate());
	  		sqljob.appendSQL("and substring(right('0000000'+convert(varchar,(convert(varchar,b.repay_date, 112)-19110000)),7),1,3)<= ? ");
	        sqljob.addParameter(myform.getrepay_EDate());
	  		sqljob.appendSQL("group by substring(right('0000000'+convert(varchar,(convert(varchar,b.repay_date, 112)-19110000)),7),1,3) ");
	  		
	  		sqljob.appendSQL("union ");
	  		
	  		sqljob.appendSQL("select substring(right('0000000'+convert(varchar,(convert(varchar,b.repay_date, 112)-19110000)),7),1,3) as yy, '息' as type,");
	  		
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='3' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/1/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/2/1' then b.Interest_amount else 0 end)),2) as i_Interest_1, ");
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='3' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/2/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/3/1' then b.Interest_amount else 0 end)),2) as i_Interest_2, ");
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='3' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/3/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/4/1' then b.Interest_amount else 0 end)),2) as i_Interest_3, ");
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='3' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/4/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/5/1' then b.Interest_amount else 0 end)),2) as i_Interest_4, ");
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='3' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/5/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/6/1' then b.Interest_amount else 0 end)),2) as i_Interest_5, ");
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='3' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/6/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/7/1' then b.Interest_amount else 0 end)),2) as i_Interest_6, ");
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='3' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/7/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/8/1' then b.Interest_amount else 0 end)),2) as i_Interest_7, ");
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='3' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/8/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/9/1' then b.Interest_amount else 0 end)),2) as i_Interest_8, ");
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='3' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/9/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/10/1' then b.Interest_amount else 0 end)),2) as i_Interest_9, ");
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='3' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/10/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/11/1' then b.Interest_amount else 0 end)),2) as i_Interest_10, ");
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='3' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/11/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/12/1' then b.Interest_amount else 0 end)),2) as i_Interest_11, ");
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='3' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/12/1' and  b.repay_date <=  Cast(Cast(Year(b.repay_date) as int(10))+1 as varchar(10))+'/1/1' then b.Interest_amount else 0 end)),2) as i_Interest_12 ");
	        sqljob.appendSQL("from debt_main a,debt_plan_det b,issue_main c ");
	        sqljob.appendSQL("where c.debt_type='A' ");
	        sqljob.appendSQL("and a.issue_id=c.id ");
	        if(null != myform.getbudgetCode() && !"".equals(myform.getbudgetCode()))
	        {
	            sqljob.appendSQL("and (a.Budget_code= ? ) ");
	            sqljob.addParameter(Integer.parseInt(myform.getbudgetCode()));
	        }	
	        if(null != myform.getDebtCode() && !"".equals(myform.getDebtCode()))
	        {
	            sqljob.appendSQL("and a.Debt_code= ? ");
	            sqljob.addParameter(Integer.parseInt(myform.getDebtCode()));
	        }
	        if(null != myform.getBondSellStatus() && !"".equals(myform.getBondSellStatus()))
	        {	
	        	if("Y".equals(myform.getBondSellStatus()))
	        	{
	        		sqljob.appendSQL("and bond_sell_status= ? ");
	            	sqljob.addParameter(myform.getBondSellStatus());
	        	}
	        	else
	        	{
	        		sqljob.appendSQL("and bond_kind=4 "); 
	        	}	
	        }	
	        sqljob.appendSQL("and a.id=b.debt_id ");
	        sqljob.appendSQL("and substring(right('0000000'+convert(varchar,(convert(varchar,b.repay_date, 112)-19110000)),7),1,3)>= ? ");
	        sqljob.addParameter(myform.getrepay_SDate());
	  		sqljob.appendSQL("and substring(right('0000000'+convert(varchar,(convert(varchar,b.repay_date, 112)-19110000)),7),1,3)<= ? ");
	        sqljob.addParameter(myform.getrepay_EDate());
	  		sqljob.appendSQL("group by substring(right('0000000'+convert(varchar,(convert(varchar,b.repay_date, 112)-19110000)),7),1,3) ");
//	  		sqljob.appendSQL("order by 1,2 ");
	  		//提前買回
	  		sqljob.appendSQL("union ");
	  		sqljob.appendSQL("select substring(right('0000000'+convert(varchar,(convert(varchar,b.repay_date, 112)-19110000)),7),1,3) as yy, '本' as type, ");
	  		
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='3' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/1/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/2/1' then b.capital_amount else 0 end)),2) as i_Capital_1, ");
			sqljob.appendSQL("round(sum((case when c.bond_kind='3' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/2/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/3/1' then b.capital_amount else 0 end)),2) as i_Capital_2, ");
			sqljob.appendSQL("round(sum((case when c.bond_kind='3' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/3/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/4/1' then b.capital_amount else 0 end)),2) as i_Capital_3, ");
			sqljob.appendSQL("round(sum((case when c.bond_kind='3' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/4/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/5/1' then b.capital_amount else 0 end)),2) as i_Capital_4, ");
			sqljob.appendSQL("round(sum((case when c.bond_kind='3' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/5/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/6/1' then b.capital_amount else 0 end)),2) as i_Capital_5, ");
			sqljob.appendSQL("round(sum((case when c.bond_kind='3' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/6/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/7/1' then b.capital_amount else 0 end)),2) as i_Capital_6, ");
			sqljob.appendSQL("round(sum((case when c.bond_kind='3' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/7/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/8/1' then b.capital_amount else 0 end)),2) as i_Capital_7, ");
			sqljob.appendSQL("round(sum((case when c.bond_kind='3' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/8/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/9/1' then b.capital_amount else 0 end)),2) as i_Capital_8, ");
			sqljob.appendSQL("round(sum((case when c.bond_kind='3' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/9/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/10/1' then b.capital_amount else 0 end)),2) as i_Capital_9, ");
			sqljob.appendSQL("round(sum((case when c.bond_kind='3' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/10/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/11/1' then b.capital_amount else 0 end)),2) as i_Capital_10, ");
			sqljob.appendSQL("round(sum((case when c.bond_kind='3' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/11/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/12/1' then b.capital_amount else 0 end)),2) as i_Capital_11, ");
			sqljob.appendSQL("round(sum((case when c.bond_kind='3' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/12/1' and  b.repay_date <=  Cast(Cast(Year(b.repay_date) as int(10))+1 as varchar(10))+'/1/1' then b.capital_amount else 0 end)),2) as i_Capital_12 ");
	        sqljob.appendSQL("from debt_main a,payment_main b,issue_main c ");
	        sqljob.appendSQL("where c.debt_type='A' ");
	        sqljob.appendSQL("and a.issue_id=c.id ");
			sqljob.appendSQL("and b.REPAY_DATE <> b.PLAN_REPAY_DATE ");
			sqljob.appendSQL("and b.CAPITAL_AMOUNT > 0 ");
			sqljob.appendSQL("and 'Y' <> (select d.delete_mark from debt_plan_det d where d.id = plan_id) ");
	        if(null != myform.getbudgetCode() && !"".equals(myform.getbudgetCode()))
	        {
	            sqljob.appendSQL("and (a.Budget_code= ? ) ");
	            sqljob.addParameter(Integer.parseInt(myform.getbudgetCode()));
	        }	
	        if(null != myform.getDebtCode() && !"".equals(myform.getDebtCode()))
	        {
	            sqljob.appendSQL("and a.Debt_code= ? ");
	            sqljob.addParameter(Integer.parseInt(myform.getDebtCode()));
	        }
	        if(null != myform.getBondSellStatus() && !"".equals(myform.getBondSellStatus()))
	        {	
	        	if("Y".equals(myform.getBondSellStatus()))
	        	{
	        		sqljob.appendSQL("and bond_sell_status= ? ");
	            	sqljob.addParameter(myform.getBondSellStatus());
	        	}
	        	else
	        	{
	        		sqljob.appendSQL("and bond_kind=4 "); 
	        	}	
	        }	
	        sqljob.appendSQL("and a.id=b.debt_id ");
	        sqljob.appendSQL("and substring(right('0000000'+convert(varchar,(convert(varchar,b.repay_date, 112)-19110000)),7),1,3)>= ? ");
	        sqljob.addParameter(myform.getrepay_SDate());
	  		sqljob.appendSQL("and substring(right('0000000'+convert(varchar,(convert(varchar,b.repay_date, 112)-19110000)),7),1,3)<= ? ");
	        sqljob.addParameter(myform.getrepay_EDate());
	  		sqljob.appendSQL("group by substring(right('0000000'+convert(varchar,(convert(varchar,b.repay_date, 112)-19110000)),7),1,3) ");
	  		
	  		sqljob.appendSQL("union ");
	  		
	  		sqljob.appendSQL("select substring(right('0000000'+convert(varchar,(convert(varchar,b.repay_date, 112)-19110000)),7),1,3) as yy, '息' as type,");
	  		
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='3' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/1/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/2/1' then b.Interest_amount else 0 end)),2) as i_Interest_1, ");
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='3' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/2/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/3/1' then b.Interest_amount else 0 end)),2) as i_Interest_2, ");
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='3' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/3/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/4/1' then b.Interest_amount else 0 end)),2) as i_Interest_3, ");
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='3' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/4/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/5/1' then b.Interest_amount else 0 end)),2) as i_Interest_4, ");
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='3' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/5/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/6/1' then b.Interest_amount else 0 end)),2) as i_Interest_5, ");
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='3' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/6/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/7/1' then b.Interest_amount else 0 end)),2) as i_Interest_6, ");
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='3' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/7/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/8/1' then b.Interest_amount else 0 end)),2) as i_Interest_7, ");
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='3' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/8/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/9/1' then b.Interest_amount else 0 end)),2) as i_Interest_8, ");
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='3' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/9/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/10/1' then b.Interest_amount else 0 end)),2) as i_Interest_9, ");
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='3' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/10/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/11/1' then b.Interest_amount else 0 end)),2) as i_Interest_10, ");
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='3' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/11/1' and  b.repay_date <=  Cast(Year(b.repay_date) as varchar(10)) + '/12/1' then b.Interest_amount else 0 end)),2) as i_Interest_11, ");
	  		sqljob.appendSQL("round(sum((case when c.bond_kind='3' and b.repay_date > Cast(Year(b.repay_date) as varchar(10)) + '/12/1' and  b.repay_date <=  Cast(Cast(Year(b.repay_date) as int(10))+1 as varchar(10))+'/1/1' then b.Interest_amount else 0 end)),2) as i_Interest_12 ");
	        sqljob.appendSQL("from debt_main a,payment_main b,issue_main c ");
	        sqljob.appendSQL("where c.debt_type='A' ");
	        sqljob.appendSQL("and a.issue_id=c.id ");
			sqljob.appendSQL("and b.REPAY_DATE <> b.PLAN_REPAY_DATE ");
			sqljob.appendSQL("and b.CAPITAL_AMOUNT > 0 ");
			sqljob.appendSQL("and 'Y' <> (select d.delete_mark from debt_plan_det d where d.id = plan_id) ");
	        if(null != myform.getbudgetCode() && !"".equals(myform.getbudgetCode()))
	        {
	            sqljob.appendSQL("and (a.Budget_code= ? ) ");
	            sqljob.addParameter(Integer.parseInt(myform.getbudgetCode()));
	        }	
	        if(null != myform.getDebtCode() && !"".equals(myform.getDebtCode()))
	        {
	            sqljob.appendSQL("and a.Debt_code= ? ");
	            sqljob.addParameter(Integer.parseInt(myform.getDebtCode()));
	        }
	        if(null != myform.getBondSellStatus() && !"".equals(myform.getBondSellStatus()))
	        {	
	        	if("Y".equals(myform.getBondSellStatus()))
	        	{
	        		sqljob.appendSQL("and bond_sell_status= ? ");
	            	sqljob.addParameter(myform.getBondSellStatus());
	        	}
	        	else
	        	{
	        		sqljob.appendSQL("and bond_kind=4 "); 
	        	}	
	        }	
	        sqljob.appendSQL("and a.id=b.debt_id ");
	        sqljob.appendSQL("and substring(right('0000000'+convert(varchar,(convert(varchar,b.repay_date, 112)-19110000)),7),1,3)>= ? ");
	        sqljob.addParameter(myform.getrepay_SDate());
	  		sqljob.appendSQL("and substring(right('0000000'+convert(varchar,(convert(varchar,b.repay_date, 112)-19110000)),7),1,3)<= ? ");
	        sqljob.addParameter(myform.getrepay_EDate());
	  		sqljob.appendSQL("group by substring(right('0000000'+convert(varchar,(convert(varchar,b.repay_date, 112)-19110000)),7),1,3) ");
	  		sqljob.appendSQL("order by 1,2 ");
	  		
	  		
	  		System.out.println(sqljob);
	  		return sqljob;
	  	}
		public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {

			//取得使用者帳號
			String usrId = this.getUserId(request);
			//取得SQLRunner
			SQLRunner run = new ConnectionSQLRunner(connection);
			//執行 delete 
			run.update(connection,delTemp(form,usrId));
			//執行 insert
			Airb0501Form myform = (Airb0501Form) form;
			List originalList = (List) run.query(getOriginal(myform), new MapListHandler());
			List addList = (List) run.query(getAdd(myform), new MapListHandler()); 
			if(null != originalList &&  0 != originalList.size())
			{
				Map insMap = new HashMap();
				int tmp = 0 ;
				String yy = "";
				String type = "";
				BigDecimal capital1 = new BigDecimal("0");
				BigDecimal capital2 = new BigDecimal("0");
				BigDecimal capital3 = new BigDecimal("0");
				BigDecimal capital4 = new BigDecimal("0");
				BigDecimal capital5 = new BigDecimal("0");
				BigDecimal capital6 = new BigDecimal("0");
				BigDecimal capital7 = new BigDecimal("0");
				BigDecimal capital8 = new BigDecimal("0");
				BigDecimal capital9 = new BigDecimal("0");
				BigDecimal capital10 = new BigDecimal("0");
				BigDecimal capital11 = new BigDecimal("0");
				BigDecimal capital12 = new BigDecimal("0");
				for(Iterator it=originalList.iterator();it.hasNext();)
				{	
					Map map = (Map)it.next();
					if(tmp == 0){	
						capital1 = new BigDecimal("0");
						capital2 = new BigDecimal("0");
						capital3 = new BigDecimal("0");
						capital4 = new BigDecimal("0");
						capital5 = new BigDecimal("0");
						capital6 = new BigDecimal("0");
						capital7 = new BigDecimal("0");
						capital8 = new BigDecimal("0");
						capital9 = new BigDecimal("0");
						capital10 = new BigDecimal("0");
						capital11 = new BigDecimal("0");
						capital12 = new BigDecimal("0");
						capital1 = (BigDecimal)map.get("o_Capital_1");
						capital2 = (BigDecimal)map.get("o_Capital_2");
						capital3 = (BigDecimal)map.get("o_Capital_3");
						capital4 = (BigDecimal)map.get("o_Capital_4");
						capital5 = (BigDecimal)map.get("o_Capital_5");
						capital6 = (BigDecimal)map.get("o_Capital_6");
						capital7 = (BigDecimal)map.get("o_Capital_7");
						capital8 = (BigDecimal)map.get("o_Capital_8");
						capital9 = (BigDecimal)map.get("o_Capital_9");
						capital10 = (BigDecimal)map.get("o_Capital_10");
						capital11 = (BigDecimal)map.get("o_Capital_11");
						capital12 = (BigDecimal)map.get("o_Capital_12");
					}else{
						capital1 = capital1.add((BigDecimal)map.get("o_Capital_1"));
						capital2 = capital2.add((BigDecimal)map.get("o_Capital_2"));
						capital3 = capital3.add((BigDecimal)map.get("o_Capital_3"));
						capital4 = capital4.add((BigDecimal)map.get("o_Capital_4"));
						capital5 = capital5.add((BigDecimal)map.get("o_Capital_5"));
						capital6 = capital6.add((BigDecimal)map.get("o_Capital_6"));
						capital7 = capital7.add((BigDecimal)map.get("o_Capital_7"));
						capital8 = capital8.add((BigDecimal)map.get("o_Capital_8"));
						capital9 = capital9.add((BigDecimal)map.get("o_Capital_9"));
						capital10 = capital10.add((BigDecimal)map.get("o_Capital_10"));
						capital11 = capital11.add((BigDecimal)map.get("o_Capital_11"));
						capital12 = capital12.add((BigDecimal)map.get("o_Capital_12"));
					}
					if(("".equals(yy) || !yy.equals(map.get("yy"))) || !type.equals(map.get("type"))){
						yy = (String)map.get("yy");
						insMap.put("yy",yy);
						type = (String)map.get("type");
						insMap.put("type",type);		
						tmp++;
					}else{
						insMap.put("o_Capital_1",capital1);
						insMap.put("o_Capital_2",capital2);
						insMap.put("o_Capital_3",capital3);
						insMap.put("o_Capital_4",capital4);
						insMap.put("o_Capital_5",capital5);
						insMap.put("o_Capital_6",capital6);
						insMap.put("o_Capital_7",capital7);
						insMap.put("o_Capital_8",capital8);
						insMap.put("o_Capital_9",capital9);
						insMap.put("o_Capital_10",capital10);
						insMap.put("o_Capital_11",capital11);
						insMap.put("o_Capital_12",capital12);
						run.update(connection,insTemp(form,usrId,insMap,"o"));
						tmp = 0;
						yy = "";
						type = "";
					}			
//					Map map = (Map)it.next();
//					run.update(connection,insTemp(form,usrId,map,"o"));
				}
			}
			if(null != addList && 0 != addList.size())
			{
				Map insMap = new HashMap();
				int tmp = 0 ;
				String yy = "";
				String type = "";
				BigDecimal capital1 = new BigDecimal("0");
				BigDecimal capital2 = new BigDecimal("0");
				BigDecimal capital3 = new BigDecimal("0");
				BigDecimal capital4 = new BigDecimal("0");
				BigDecimal capital5 = new BigDecimal("0");
				BigDecimal capital6 = new BigDecimal("0");
				BigDecimal capital7 = new BigDecimal("0");
				BigDecimal capital8 = new BigDecimal("0");
				BigDecimal capital9 = new BigDecimal("0");
				BigDecimal capital10 = new BigDecimal("0");
				BigDecimal capital11 = new BigDecimal("0");
				BigDecimal capital12 = new BigDecimal("0");
				for(Iterator it=addList.iterator();it.hasNext();)
				{	
					Map map = (Map)it.next();
					if(tmp == 0){	
						capital1 = new BigDecimal("0");
						capital2 = new BigDecimal("0");
						capital3 = new BigDecimal("0");
						capital4 = new BigDecimal("0");
						capital5 = new BigDecimal("0");
						capital6 = new BigDecimal("0");
						capital7 = new BigDecimal("0");
						capital8 = new BigDecimal("0");
						capital9 = new BigDecimal("0");
						capital10 = new BigDecimal("0");
						capital11 = new BigDecimal("0");
						capital12 = new BigDecimal("0");
						capital1 = (BigDecimal)map.get("i_Capital_1");
						capital2 = (BigDecimal)map.get("i_Capital_2");
						capital3 = (BigDecimal)map.get("i_Capital_3");
						capital4 = (BigDecimal)map.get("i_Capital_4");
						capital5 = (BigDecimal)map.get("i_Capital_5");
						capital6 = (BigDecimal)map.get("i_Capital_6");
						capital7 = (BigDecimal)map.get("i_Capital_7");
						capital8 = (BigDecimal)map.get("i_Capital_8");
						capital9 = (BigDecimal)map.get("i_Capital_9");
						capital10 = (BigDecimal)map.get("i_Capital_10");
						capital11 = (BigDecimal)map.get("i_Capital_11");
						capital12 = (BigDecimal)map.get("i_Capital_12");
					}else{
						capital1 = capital1.add((BigDecimal)map.get("i_Capital_1"));
						capital2 = capital2.add((BigDecimal)map.get("i_Capital_2"));
						capital3 = capital3.add((BigDecimal)map.get("i_Capital_3"));
						capital4 = capital4.add((BigDecimal)map.get("i_Capital_4"));
						capital5 = capital5.add((BigDecimal)map.get("i_Capital_5"));
						capital6 = capital6.add((BigDecimal)map.get("i_Capital_6"));
						capital7 = capital7.add((BigDecimal)map.get("i_Capital_7"));
						capital8 = capital8.add((BigDecimal)map.get("i_Capital_8"));
						capital9 = capital9.add((BigDecimal)map.get("i_Capital_9"));
						capital10 = capital10.add((BigDecimal)map.get("i_Capital_10"));
						capital11 = capital11.add((BigDecimal)map.get("i_Capital_11"));
						capital12 = capital12.add((BigDecimal)map.get("i_Capital_12"));
					}
					if(("".equals(yy) || !yy.equals(map.get("yy"))) || !type.equals(map.get("type"))){
						yy = (String)map.get("yy");
						insMap.put("yy",yy);
						type = (String)map.get("type");
						insMap.put("type",type);			
						tmp++;
					}else{
						insMap.put("i_Capital_1",capital1);
						insMap.put("i_Capital_2",capital2);
						insMap.put("i_Capital_3",capital3);
						insMap.put("i_Capital_4",capital4);
						insMap.put("i_Capital_5",capital5);
						insMap.put("i_Capital_6",capital6);
						insMap.put("i_Capital_7",capital7);
						insMap.put("i_Capital_8",capital8);
						insMap.put("i_Capital_9",capital9);
						insMap.put("i_Capital_10",capital10);
						insMap.put("i_Capital_11",capital11);
						insMap.put("i_Capital_12",capital12);
						run.update(connection,insTemp(form,usrId,insMap,"i"));
						tmp = 0;
						yy = "";
						type = "";
					}		
//					Map map = (Map)it.next();
//					run.update(connection,insTemp(form,usrId,map,"i"));
				}
			}	
		}

}
