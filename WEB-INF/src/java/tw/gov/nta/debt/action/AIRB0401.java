/* AIRB0401.java 報表
 程式目的：AIRB04
 程式代號：AIRB04
 程式日期：0950416
 程式作者：icefire
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
 --------------------------------------------------------
 */
package tw.gov.nta.debt.action;

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

import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Airb0401Form;
import tw.gov.nta.debt.form.Airb0401Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

public class AIRB0401 extends DefaultAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM AIRB04_RPT ");
		//sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}

	protected SQLJob insTemp(ActionForm form,String usrId,Map map,String name){
		Airb0401Form myform = (Airb0401Form) form;
		BigDecimal totalAmount = new BigDecimal(0);
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO AIRB04_RPT ");
		sqljob.appendSQL(" ( ");
		sqljob.appendSQL(" USRID, MOD_DATE, REMARK,");
		sqljob.appendSQL(" ACCOUNT_YEAR,BOND_KIND, ");
		sqljob.appendSQL(" JAN_AMOUNT,FEB_AMOUNT,MAR_AMOUNT, ");
		sqljob.appendSQL(" APR_AMOUNT,MAY_AMOUNT,JUE_AMOUNT, ");
		sqljob.appendSQL(" JUL_AMOUNT,AUG_AMOUNT,SEP_AMOUNT, ");
		sqljob.appendSQL(" OCT_AMOUNT,NOV_AMOUNT,DEC_AMOUNT, ");
		sqljob.appendSQL(" TOTAL_AMOUNT ) ");	
		sqljob.appendSQL(" VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
		sqljob.addParameter(usrId);
		sqljob.addParameter(new Date());
		sqljob.addParameter("");
		sqljob.addParameter((String)(map.get("yy")));
		sqljob.addParameter(("o".equals(name)?"原始":"增額"));
		sqljob.addParameter(((BigDecimal)(map.get(name+"_Interest_1"))).divide(new BigDecimal(100000000)));
		sqljob.addParameter(((BigDecimal)(map.get(name+"_Interest_2"))).divide(new BigDecimal(100000000)));
		sqljob.addParameter(((BigDecimal)(map.get(name+"_Interest_3"))).divide(new BigDecimal(100000000)));
		sqljob.addParameter(((BigDecimal)(map.get(name+"_Interest_4"))).divide(new BigDecimal(100000000)));
		sqljob.addParameter(((BigDecimal)(map.get(name+"_Interest_5"))).divide(new BigDecimal(100000000)));
		sqljob.addParameter(((BigDecimal)(map.get(name+"_Interest_6"))).divide(new BigDecimal(100000000)));
		sqljob.addParameter(((BigDecimal)(map.get(name+"_Interest_7"))).divide(new BigDecimal(100000000)));
		sqljob.addParameter(((BigDecimal)(map.get(name+"_Interest_8"))).divide(new BigDecimal(100000000)));
		sqljob.addParameter(((BigDecimal)(map.get(name+"_Interest_9"))).divide(new BigDecimal(100000000)));
		sqljob.addParameter(((BigDecimal)(map.get(name+"_Interest_10"))).divide(new BigDecimal(100000000)));
		sqljob.addParameter(((BigDecimal)(map.get(name+"_Interest_11"))).divide(new BigDecimal(100000000)));
		sqljob.addParameter(((BigDecimal)(map.get(name+"_Interest_12"))).divide(new BigDecimal(100000000)));
		BigDecimal total = new BigDecimal(0);
		for(int i=1;i<=12;i++){
			total = total.add((BigDecimal)(map.get(name+"_Interest_"+i)));
		}
		sqljob.addParameter(total.divide(new BigDecimal(100000000)));
		System.out.println(sqljob);
		return sqljob;
	}
  	@SuppressWarnings("deprecation")
	public SQLJob getOriginal(ActionForm form,int i,int month)
  	{
  		Airb0401Form myform = (Airb0401Form) form;
  		SQLJob sqljob = new SQLJob();
  		sqljob.appendSQL("select  isnull(sum(b.Interest_amount),0) as Interest");
  		sqljob.appendSQL("from debt_main a,debt_plan_det b,issue_main c  ");
  		sqljob.appendSQL("where c.debt_type='A' and c.bond_kind='1'"); 
  		sqljob.appendSQL("and a.issue_id=c.id"); 
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
        sqljob.appendSQL("and b.repay_date > ?");
        sqljob.appendSQL("and b.repay_date <= ?");
        sqljob.addParameter(new Date(i+11,month,1));
        Calendar tCalendar = GregorianCalendar.getInstance();
		tCalendar.setTime(DateUtil.getLastDateOfMonth(new Date(i+11,month,1)));
		tCalendar.add(tCalendar.DATE,1);
		sqljob.addParameter(tCalendar.getTime());
		
		sqljob.appendSQL("union ");
  		sqljob.appendSQL("select  isnull(sum(b.Interest_amount),0) as Interest ");
        sqljob.appendSQL("from debt_main a,payment_main b,issue_main c ");
  		sqljob.appendSQL("where c.debt_type='A' and c.bond_kind='1' "); 
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
        sqljob.appendSQL("and b.repay_date > ?");
        sqljob.appendSQL("and b.repay_date <= ?");
        sqljob.addParameter(new Date(i+11,month,1));
        tCalendar = GregorianCalendar.getInstance();
		tCalendar.setTime(DateUtil.getLastDateOfMonth(new Date(i+11,month,1)));
		tCalendar.add(tCalendar.DATE,1);
		sqljob.addParameter(tCalendar.getTime());
  		
  		System.out.println(sqljob);
  		return sqljob;
  	}
  	@SuppressWarnings("deprecation")
	public SQLJob getAdd(ActionForm form,int i,int month)
  	{
  		Airb0401Form myform = (Airb0401Form) form;
  		SQLJob sqljob = new SQLJob();
  		sqljob.appendSQL("select isnull(sum(b.Interest_amount),0) as Interest ");
  		sqljob.appendSQL("from debt_main a,debt_plan_det b,issue_main c  ");
  		sqljob.appendSQL("where c.debt_type='A' and c.bond_kind='3' "); 
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
        sqljob.appendSQL("and b.repay_date > ?");
        sqljob.appendSQL("and b.repay_date <= ?");
        sqljob.addParameter(new Date(i+11,month,1));
        Calendar tCalendar = GregorianCalendar.getInstance();
		tCalendar.setTime(DateUtil.getLastDateOfMonth(new Date(i+11,month,1)));
		tCalendar.add(tCalendar.DATE,1);
		sqljob.addParameter(tCalendar.getTime());

		sqljob.appendSQL("union ");
  		sqljob.appendSQL("select isnull(sum(b.Interest_amount),0) as Interest ");
		sqljob.appendSQL("from debt_main a,payment_main b,issue_main c ");
  		sqljob.appendSQL("where c.debt_type='A' and c.bond_kind='3' "); 
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
        sqljob.appendSQL("and b.repay_date > ?");
        sqljob.appendSQL("and b.repay_date <= ?");
        sqljob.addParameter(new Date(i+11,month,1));
        tCalendar = GregorianCalendar.getInstance();
		tCalendar.setTime(DateUtil.getLastDateOfMonth(new Date(i+11,month,1)));
		tCalendar.add(tCalendar.DATE,1);
		sqljob.addParameter(tCalendar.getTime());
		
		
		
  		System.out.println(sqljob);
  		return sqljob;
  	}
	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {

		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delTemp(form,usrId));
		//執行 insert
		Airb0401Form myform = (Airb0401Form) form;
		List originalList = new LinkedList();
		List addList =  new LinkedList();
		for(int i = Integer.parseInt(myform.getrepay_SDate()) ; i <= Integer.parseInt(myform.getrepay_EDate()) ; i++){
			Map originalMap = new HashMap();
			Map addMap = new HashMap();
			originalMap.put("yy", String.valueOf(i));
			addMap.put("yy", String.valueOf(i));
			for(int month = 0;month<=11;month++){
				List dataList = (List)run.query(getOriginal(myform,i,month), new MapListHandler());
				Map map = (Map)(dataList).get(0);
				originalMap.put("o_Interest_"+String.valueOf(month+1), map.get("Interest"));
				if(dataList.size()>1){
					map = (Map)(dataList).get(1);
					originalMap.put("o_Interest_"+String.valueOf(month+1), 
							((BigDecimal)originalMap.get("o_Interest_"+String.valueOf(month+1))).add((BigDecimal)map.get("Interest")));
				}
			}
			for(int month = 0;month<=11;month++){
				List dataList = (List)run.query(getAdd(myform,i,month), new MapListHandler());
				Map map = (Map)(dataList).get(0);
				addMap.put("i_Interest_"+String.valueOf(month+1), map.get("Interest"));
				if(dataList.size() > 1){
					map = (Map)(dataList).get(1);
					addMap.put("i_Interest_"+String.valueOf(month+1), 
							((BigDecimal)addMap.get("i_Interest_"+String.valueOf(month+1))).add((BigDecimal)map.get("Interest")));
				}
			}
			originalList.add(originalMap);
			addList.add(addMap);
		}
		if(null != originalList &&  0 != originalList.size())
		{
			for(Iterator it=originalList.iterator();it.hasNext();)
			{	
				Map map = (Map)it.next();
				run.update(connection,insTemp(form,usrId,map,"o"));
			}
		}
		if(null != addList && 0 != addList.size())
		{
			for(Iterator it=addList.iterator();it.hasNext();)
			{	
				Map map = (Map)it.next();
				run.update(connection,insTemp(form,usrId,map,"i"));
			}
		}	
	}
}
