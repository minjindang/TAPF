/**
 * @author Avery Yeh
 * @create 2006/06/01
 */

package tw.gov.nta.surplusage.action;

import gov.dnt.tame.common.ExcelReportBaseAction;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.sql.debt.GaraNote;
import tw.gov.nta.surplusage.common.GaraNoteManager;
import tw.gov.nta.surplusage.form.Gara1101Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class GARA1101 extends ExcelReportBaseAction
{
	protected SQLJob SQL1(String year,BigDecimal unit){
		SQLJob sqljob = new SQLJob();
		
		sqljob.appendSQL("select Right('000'+convert(varchar(3),  ");
		sqljob.appendSQL("case when year(B.date1) < 2000 and month(B.date1) > 6 ");
		sqljob.appendSQL("then  year(B.date1)+1 ");
		sqljob.appendSQL("else  year(B.date1) ");
		sqljob.appendSQL("end-1911),3) as year1,");
		sqljob.appendSQL("sum(case when (kind = '1') and A.debt_type='B' then isnull(A_total,0) else 0 end)/"+unit+" as issue_total_B,");//國庫?發行數
		sqljob.appendSQL("sum(case when (kind = '2') and A.debt_type='B' then isnull(A_total,0) else 0 end)/"+unit+" as capital_total_B,");//國庫?還本數
		//sqljob.appendSQL("sum(case when (kind = '2') then isnull(B_total,0) else 0 end)/"+unit+" as interest_total_B,");//國庫?利息數
		//sqljob.appendSQL("sum(case when (kind = '1') then isnull(B_total,0) else 0 end)/"+unit+" as sub_amount_B,"); //國庫?利息節減數
		sqljob.appendSQL("sum(case when (kind = '3') and A.debt_type='D' then isnull(A_total,0) else 0 end)/"+unit+" as issue_total_D,");//短期借款發行數
		sqljob.appendSQL("sum(case when (kind = '4') and A.debt_type='D' then isnull(A_total,0) else 0 end)/"+unit+" as capital_total_D ");//短期借款還本數
		//sqljob.appendSQL("sum(case when (kind = '4') then isnull(B_total,0) else 0 end)/"+unit+" as interest_total_D,");//短期借款利息數
		//sqljob.appendSQL("sum(case when (kind = '3') then isnull(B_total,0) else 0 end)/"+unit+" as sub_amount_D ");//短期借款利息節減數
		sqljob.appendSQL("from issue_main A,v_debtT B ");
		sqljob.appendSQL("where A.issue_serial = B.issue_serial ");
		sqljob.appendSQL("and B.date1 <= '"+new Timestamp(new Date().getTime())+"' ");
		sqljob.appendSQL("and Right('000'+convert(varchar(3),  ");
		sqljob.appendSQL("case when year(B.date1) < 2000 and month(B.date1) > 6 ");
		sqljob.appendSQL("then  year(B.date1)+1 ");
		sqljob.appendSQL("else  year(B.date1) ");
		sqljob.appendSQL("end-1911),3) < "+ year +" ");
		
		sqljob.appendSQL("group by Right('000'+convert(varchar(3),");
		sqljob.appendSQL("case when year(B.date1) < 2000 and month(B.date1) > 6 ");
		sqljob.appendSQL("then  year(B.date1)+1 ");
		sqljob.appendSQL("else  year(B.date1) ");
		sqljob.appendSQL("end-1911),3) ");
		sqljob.appendSQL("order by Right('000'+convert(varchar(3),");
		sqljob.appendSQL("case when year(B.date1) < 2000 and month(B.date1) > 6 ");
		sqljob.appendSQL("then  year(B.date1)+1 ");
		sqljob.appendSQL(" else  year(B.date1) ");
		sqljob.appendSQL("end-1911),3)");
		System.out.println("GARA1101-SQL1::"+sqljob.toString());
		return sqljob;
	}
	protected SQLJob SQL2(String year,BigDecimal unit){
		SQLJob sqljob = new SQLJob();
		
		sqljob.appendSQL("select month(B.date1) as month1,");
		sqljob.appendSQL("sum(case when (kind = '1') and A.debt_type='B' then isnull(A_total,0) else 0 end)/"+unit+" as issue_total_B,");	//國庫?發行數
		sqljob.appendSQL("sum(case when (kind = '2') and A.debt_type='B' then isnull(A_total,0) else 0 end)/"+unit+" as capital_total_B,");//國庫?還本數
		//sqljob.appendSQL("sum(case when (kind = '2') then isnull(B_total,0) else 0 end)/"+unit+" as interest_total_B,");//國庫?利息數
		//sqljob.appendSQL("sum(case when (kind = '1') then isnull(B_total,0) else 0 end)/"+unit+" as sub_amount_B,");  //國庫?利息節減數
		sqljob.appendSQL("sum(case when (kind = '3') and A.debt_type='D' then isnull(A_total,0) else 0 end)/"+unit+" as issue_total_D,");	//短期借款發行數
		sqljob.appendSQL("sum(case when (kind = '4') and A.debt_type='D' then isnull(A_total,0) else 0 end)/"+unit+" as capital_total_D ");//短期借款還本數
		//sqljob.appendSQL("sum(case when (kind = '4') then isnull(B_total,0) else 0 end)/"+unit+" as interest_total_D,");//短期借款利息數
		//sqljob.appendSQL("sum(case when (kind = '3') then isnull(B_total,0) else 0 end)/"+unit+" as sub_amount_D "); //短期借款利息節減數
		sqljob.appendSQL("from issue_main A,v_debtT B ");
		sqljob.appendSQL("where A.issue_serial = B.issue_serial ");
		sqljob.appendSQL("and B.date1 <= '"+new Timestamp(new Date().getTime())+"' ");
		sqljob.appendSQL("and Right('000'+convert(varchar(3),");
		sqljob.appendSQL("case when year(B.date1) < 2000 and month(B.date1) > 6 ");
		sqljob.appendSQL("then  year(B.date1)+1");
		sqljob.appendSQL("else  year(B.date1)end-1911),3) = " + year + " ");
		sqljob.appendSQL("group by month(B.date1) ");
		sqljob.appendSQL("order by month(B.date1) ");
		System.out.println("GARA1101-SQL2::"+sqljob.toString());
		return sqljob;
	}
	//取得當月提前償付國庫券
	protected SQLJob SQL3(String year, String month){
		SQLJob sqljob = new SQLJob();
		
		sqljob.appendSQL("select sum(p.capital_amount) + sum(p.interest_amount) as capital_amount ");
		sqljob.appendSQL("from issue_main i, payment_main p ");
		sqljob.appendSQL("where i.id = p.issue_id ");
		sqljob.appendSQLCondition("i.debt_type = 'B' ");
		sqljob.appendSQLCondition("year(p.repay_date)-1911 = " + Integer.parseInt(year));
		sqljob.appendSQLCondition("month(p.repay_date) = " + Integer.valueOf(month));
		sqljob.appendSQLCondition("p.repay_date <> plan_repay_date ");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	
	@SuppressWarnings("unchecked")
	protected Map setDMap (BigDecimal treasury_amount,BigDecimal short_amount){
		Map dMap = new HashMap();
		dMap.put("treasury_amount",treasury_amount);
		dMap.put("short_amount",short_amount);
		if (treasury_amount == null && short_amount == null)
			dMap.put("total_amount",null);
		else
			dMap.put("total_amount",treasury_amount.add(short_amount));
		return dMap;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception{
		
		Gara1101Form myForm = (Gara1101Form) form;
//		Calendar tCalendar = GregorianCalendar.getInstance();
//		tCalendar.setTime(new Date());
//		tCalendar.add(Calendar.MONTH,1);
//		String thisYearMonth = DateUtil.date2ROCStr(tCalendar.getTime()).substring(0,5);
//		Date createDate = myForm.getCreateDate();
//		String createDate = DateUtil.date2Str(myForm.getCreateDate(),"yyyy-mm-dd");
		
		String thisYearMonth = null;
		if (myForm.getCreateDate() != null)
			thisYearMonth = DateUtil.date2ROCStr(myForm.getCreateDate()).substring(0,5);
		else
			thisYearMonth = DateUtil.date2ROCStr(new Date()).substring(0,5);
		
		
//		String createDate = DateUtil.getSystemDate().substring(0.3);
		
		
		GaraNote garaNote = new GaraNoteManager().getGaraNote(myForm.getPath());
		garaNote.setMemo(myForm.getMemo());
		garaNote.setPath(myForm.getPath());
		new GaraNoteManager().confirm(garaNote);
		request.setAttribute("memo",garaNote.getMemo());
		BigDecimal unit = myForm.getAmountUnit();
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delSQLJob("GARA11_RPT",usrId));
		//執行 insert
		

		//前年底國庫短期債務未償餘額實際數
		List queryList1 = (List) run.query(SQL1(myForm.getStartYear(),unit), new MapListHandler());
//		List queryList1 = (List) run.query(SQL1(myForm.getCreateDate(),unit), new MapListHandler());
		Map countMap = null;
		Map lastMap = new HashMap();
		BigDecimal lastYearNoPay_B = new BigDecimal(0);
		BigDecimal lastYearNoPay_D = new BigDecimal(0);
		for (Iterator it1=queryList1.iterator(); it1.hasNext();){
			countMap = (Map)it1.next();
			lastYearNoPay_B = lastYearNoPay_B.add((BigDecimal)countMap.get("issue_total_B")).subtract((BigDecimal)countMap.get("capital_total_B"));
			lastYearNoPay_D = lastYearNoPay_D.add((BigDecimal)countMap.get("issue_total_D")).subtract((BigDecimal)countMap.get("capital_total_D"));
		}
		lastMap.putAll(getCommonMap(usrId));
		lastMap.put("treasury_amount",lastYearNoPay_B);
		lastMap.put("short_amount",lastYearNoPay_D);
		lastMap.put("total_amount",lastYearNoPay_B.add(lastYearNoPay_D));
		run.update(connection,insTemp("GARA11_RPT",lastMap));
			
		//今年底國庫與短期借貸 1~12月		
		Map dMap = new HashMap();
		Map thisMap = new HashMap();
		List queryList2 = (List) run.query(SQL2(myForm.getStartYear(),unit), new MapListHandler());
		String month[] = {"01","02","03","04","05","06","07","08","09","10","11","12"};
		int index = 0;
		for (int i=0 ; i < month.length ; i++){
			if (queryList2.size() > 0)
				dMap = (Map)queryList2.get(index);
			else
				dMap.put("month1",0);
			if (((Integer)dMap.get("month1")).intValue() != Integer.parseInt(month[i])){
				//實際發行數或舉借數
				thisMap.putAll(getCommonMap(usrId));
				
				if (Integer.parseInt(thisYearMonth) >= Integer.parseInt(myForm.getStartYear()+month[i]))
					thisMap.putAll(setDMap(new BigDecimal(0),new BigDecimal(0)));
				else
					thisMap.putAll(setDMap(null,null));
				run.update(connection,insTemp("GARA11_RPT",thisMap));
				//還本數
				thisMap.putAll(getCommonMap(usrId));
				if (Integer.parseInt(thisYearMonth) >= Integer.parseInt(myForm.getStartYear()+month[i]))
					thisMap.putAll(setDMap(new BigDecimal(0),new BigDecimal(0)));
				else
					thisMap.putAll(setDMap(null,null));
				run.update(connection,insTemp("GARA11_RPT",thisMap));
				//未償餘額
				thisMap.putAll(getCommonMap(usrId));
				if (Integer.parseInt(thisYearMonth) >= Integer.parseInt(myForm.getStartYear()+month[i]))
					thisMap.putAll(setDMap(lastYearNoPay_B,lastYearNoPay_D));
				else
					thisMap.putAll(setDMap(null,null));
				run.update(connection,insTemp("GARA11_RPT",thisMap));
			}else{
				//listIndex值加1
				if (index < queryList2.size()-1)
					index++;
//				實際發行數或舉借數
				thisMap.putAll(getCommonMap(usrId));
				if (Integer.parseInt(thisYearMonth) >= Integer.parseInt(myForm.getStartYear()+month[i]))
					thisMap.putAll(setDMap((BigDecimal)dMap.get("issue_total_B"),(BigDecimal)dMap.get("issue_total_D")));
				else
					thisMap.putAll(setDMap(null,null));
				run.update(connection,insTemp("GARA11_RPT",thisMap));
				List queryList3 = (List) run.query(SQL3(myForm.getStartYear(),month[i]), new MapListHandler());
				Map bMap = (Map)queryList3.get(0);
				BigDecimal capitalAmount = (BigDecimal)bMap.get("capital_amount");
				//還本數
				thisMap.putAll(getCommonMap(usrId));
				if (Integer.parseInt(thisYearMonth) >= Integer.parseInt(myForm.getStartYear()+month[i])){
					if (null != capitalAmount)
					{
						thisMap.putAll(setDMap(((BigDecimal)dMap.get("capital_total_B")).add(capitalAmount.divide(unit,BigDecimal.ROUND_HALF_UP)),(BigDecimal)dMap.get("capital_total_D")));
					} else 
						thisMap.putAll(setDMap((BigDecimal)dMap.get("capital_total_B"),(BigDecimal)dMap.get("capital_total_D")));
				}else
					thisMap.putAll(setDMap(null,null));
				run.update(connection,insTemp("GARA11_RPT",thisMap));
				//未償餘額
				thisMap.putAll(getCommonMap(usrId));
				if (Integer.parseInt(thisYearMonth) >= Integer.parseInt(myForm.getStartYear()+month[i])){
					if (null != capitalAmount)
					{
						lastYearNoPay_B = lastYearNoPay_B.add((BigDecimal)dMap.get("issue_total_B")).subtract((BigDecimal)dMap.get("capital_total_B")).subtract(capitalAmount.divide(unit,BigDecimal.ROUND_HALF_UP));
					} else 
						lastYearNoPay_B = lastYearNoPay_B.add((BigDecimal)dMap.get("issue_total_B")).subtract((BigDecimal)dMap.get("capital_total_B"));
					lastYearNoPay_D = lastYearNoPay_D.add((BigDecimal)dMap.get("issue_total_D")).subtract((BigDecimal)dMap.get("capital_total_D"));
					thisMap.putAll(setDMap(lastYearNoPay_B,lastYearNoPay_D));
				}else
					thisMap.putAll(setDMap(null,null));
				run.update(connection,insTemp("GARA11_RPT",thisMap));
			}			
		}
		request.setAttribute("lastYearNoPay_B",lastYearNoPay_B);
		request.setAttribute("lastYearNoPay_D",lastYearNoPay_D);
	}
}