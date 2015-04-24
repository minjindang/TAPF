package tw.gov.nta.exchequer.action;

import gov.dnt.tame.common.ExcelReportBaseAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.exchequer.form.Bira1001Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class BIRA1001 extends ExcelReportBaseAction{

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM BIRA10_RPT ");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	
	//主sql
	protected SQLJob SQL1(ActionForm form){
		Bira1001Form myForm = (Bira1001Form)form;
		
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select datediff(dd,ｐ.repay_date,i.due_date) as date_period,"); //天期
		sqljob.appendSQL("i.debt_name as debt_name, "); //發行期別
		sqljob.appendSQL("b.id as bank_id, "); //出售單位
		sqljob.appendSQL("isNull(c.sell_amount,0) as sell_amount, "); //發行額
		sqljob.appendSQL("isNull(c.sell_rate,0)/100 as account_rate, "); //標回利率
		sqljob.appendSQL("b.bank_name as unit_code, "); //出售單位
		sqljob.appendSQL("c.issue_price as issue_price, "); //發行價格
		sqljob.appendSQL("c.free_amount as free_amount, "); //免稅額
		
		sqljob.appendSQL("i.issue_date as issue_date, "); //發行日期
		sqljob.appendSQL("i.due_date as due_date, "); //到期日期
		sqljob.appendSQL("(select min(repay_date) from payment_main p where p.issue_id = i.id) as repay_date "); //提早買回日期
		
		sqljob.appendSQL("from issue_main i, central_debt_det c, central_bank_ref b, payment_main p");
		if (!"".equals(myForm.getIssueId()))	{
			sqljob.appendSQL("where i.id = ?");
			sqljob.addParameter(myForm.getIssueId());
		}
		sqljob.appendSQL("and c.unit_code = b.id");
		sqljob.appendSQL("and c.issue_id = i.id");
		sqljob.appendSQL("and p.issue_id = i.id");
		sqljob.appendSQL("and p.repay_date < i.due_date and p.capital_serial=(select min(p.capital_serial) from payment_main p where p.issue_id = i.id and p.capital_serial <> 0)");
		sqljob.appendSQL("and interest_days = (select min(interest_days) from payment_main p where p.issue_id = i.id)");
		sqljob.appendSQL("Order by account_rate DESC, issue_price DESC");
		System.out.println("BIRA1001-SQL1-::"+sqljob.toString());
		return sqljob;
	}
	
	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		
		Bira1001Form myForm =(Bira1001Form) form;
		
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection); 
		//執行 delete 
		run.update(connection,delTemp(form,usrId)); 
		//執行insert
		List tList = (List) run.query(SQL1(myForm), new MapListHandler());
		Map tMap = null;

		//資料Map

		for(Iterator tIterator = tList.iterator(); tIterator.hasNext(); )
		{
			tMap = (Map) tIterator.next();
			Map dMap = new HashMap();

			BigDecimal tmp3_1 = new BigDecimal(0);
			BigDecimal tmp9_1 = new BigDecimal(0);
			BigDecimal tmp9_2 = new BigDecimal(0);
			BigDecimal tmp10_1 = new BigDecimal(0);
			BigDecimal tmp10_2 = new BigDecimal(0);

			//放入usrid,mod_date,remark資料
			dMap.putAll(getCommonMap(usrId));
			System.out.println(tMap.get("bank_id"));		
			//(1)出售單位
			dMap.put("bank_name",(String)tMap.get("unit_code"));
					
			//(2)面額
			dMap.put("getbid_amount",(BigDecimal)tMap.get("sell_amount"));
					
			//(3)每萬元價格 issue_price/10000
			tmp3_1 = ((BigDecimal)tMap.get("issue_price"));
			dMap.put("issue_price",tmp3_1);
					
			//(4)累積免稅額 
			dMap.put("free_amount",((BigDecimal)tMap.get("free_amount")));
					
			//(5)標回利率 
			dMap.put("account_rate",(((BigDecimal) tMap.get("account_rate"))));
					
			//(6)原始成本 (2)*(3)/10000
			dMap.put("orginal_amount",((BigDecimal)dMap.get("getbid_amount")).multiply((BigDecimal)dMap.get("issue_price")).divide(new BigDecimal(10000),20,5));
					
			//(7)全部負稅 (2)-(6))* 0.2
			if (((Integer)tMap.get("bank_id"))== 64)
//				if (((BigDecimal)dMap.get("free_amount")).compareTo(new BigDecimal(0)) == 0)
				dMap.put("total_free_amount",new BigDecimal(0));
			else			
				dMap.put("total_free_amount",((BigDecimal)dMap.get("getbid_amount")).subtract((BigDecimal)dMap.get("orginal_amount")).multiply(new BigDecimal(0.2)));

			//(8)到期值 (2)-(7)
			dMap.put("due_value",((BigDecimal)dMap.get("getbid_amount")).subtract((BigDecimal)dMap.get("total_free_amount")));
	
			//(9)買進金額 ((8)+(4))/(1+(5)*0.8*(SQL1.date_period)/365)
			if (((Integer)tMap.get("bank_id"))== 64){
				//--((8)+(4))
				tmp9_1 = ((BigDecimal)dMap.get("due_value")).add((BigDecimal)dMap.get("free_amount"));
				//--(5)*0.8*(SQL1.date_period)/365
				tmp9_2 = ((BigDecimal)dMap.get("account_rate")).multiply(new BigDecimal((Integer)tMap.get("date_period"))).divide(new BigDecimal(365),20,5);
				dMap.put("buy_amount",tmp9_1.divide(new BigDecimal(1).add(tmp9_2),20,5));
			}
				else{
		    	//--((8)+(4))
		    	tmp9_1 = ((BigDecimal)dMap.get("due_value")).add((BigDecimal)dMap.get("free_amount"));
				System.out.println(tmp9_1);
				//--(5)*0.8*(SQL1.date_period)/365
				tmp9_2 = ((BigDecimal)dMap.get("account_rate")).multiply(new BigDecimal(0.8)).multiply(new BigDecimal((Integer)tMap.get("date_period"))).divide(new BigDecimal(365),20,5);
				System.out.println(tmp9_2);
				dMap.put("buy_amount",tmp9_1.divide(new BigDecimal(1).add(tmp9_2),20,5));
				}
			
//			//(9)買進金額 ((8)+(4))/(1+(5)*0.8*(SQL1.date_period)/365)
//			//--((8)+(4))
//			tmp9_1 = ((BigDecimal)dMap.get("due_value")).add((BigDecimal)dMap.get("free_amount"));
//			System.out.println(tmp9_1);
//			//--(5)*0.8*(SQL1.date_period)/365
//			tmp9_2 = ((BigDecimal)dMap.get("account_rate")).multiply(new BigDecimal(0.8)).multiply(new BigDecimal((Integer)tMap.get("date_period"))).divide(new BigDecimal(365),20,5);
//			System.out.println(tmp9_2);
//			dMap.put("buy_amount",tmp9_1.divide(new BigDecimal(1).add(tmp9_2),20,5));
					
			//(10)前手稅款 ((9)-(6)-(4)*5)/4
			System.out.println(tMap.get("bank_id"));
			if (((Integer)tMap.get("bank_id"))== 64)
//			if (((BigDecimal)dMap.get("free_amount")).compareTo(new BigDecimal(0)) == 0)
				dMap.put("pre_free_amount",new BigDecimal(0));
			else
			
			dMap.put("pre_free_amount",(((BigDecimal)dMap.get("buy_amount")).subtract((BigDecimal)dMap.get("orginal_amount")).subtract(((BigDecimal)dMap.get("free_amount")).multiply(new BigDecimal(5)))).divide(new BigDecimal(4),20,5));
				
			//(11)買進成本甲 (9)+(10)
			dMap.put("real_amount1",((BigDecimal)dMap.get("buy_amount")).add((BigDecimal)dMap.get("pre_free_amount")));
					
			//(12)利息總額 ((2)-(6))-((9)*(5)*(SQL1.date_period)/365)
			//--((2)-(6))
			tmp10_1 = ((BigDecimal)dMap.get("getbid_amount")).subtract((BigDecimal)dMap.get("orginal_amount"));
			//--((9)*(5)*(SQL1.date_period)/365)
			tmp10_2 = ((BigDecimal)dMap.get("buy_amount")).multiply((BigDecimal)dMap.get("account_rate")).multiply(new BigDecimal((Integer)tMap.get("date_period"))).divide(new BigDecimal(365),20,5);
			dMap.put("intrest_amount",tmp10_1.subtract(tmp10_2));
					
			//(13)買進成本乙 (6)+(12)
			dMap.put("real_amount2",((BigDecimal)dMap.get("orginal_amount")).add((BigDecimal)dMap.get("intrest_amount")));
					
			//(14)檢查項目(13)-(11)
			dMap.put("check_item",((BigDecimal)dMap.get("real_amount2")).subtract((BigDecimal)dMap.get("real_amount1")));
			run.update(connection,insTemp("BIRA10_RPT",dMap));
			
			request.setAttribute("debt_name", tMap.get("debt_name")); //發行期別名稱
			request.setAttribute("issue_date", tMap.get("issue_date")); //發行日期
			request.setAttribute("cash_due_date", tMap.get("due_date")); //到期日期
			request.setAttribute("due_date", tMap.get("repay_date")); //提早買回日期
			request.setAttribute("early_due_date", tMap.get("date_period")); //距到期日
			
		}
	}
}
