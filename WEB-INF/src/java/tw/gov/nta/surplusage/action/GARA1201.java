/**
 * @author Avery Yeh
 * @create 2006/06/01
 */

package tw.gov.nta.surplusage.action;

import gov.dnt.tame.common.ExcelReportRemainAction;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;
import tw.gov.nta.sql.debt.GaraNote;
import tw.gov.nta.surplusage.common.GaraNoteManager;
import tw.gov.nta.surplusage.form.Gara1201Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class GARA1201 extends ExcelReportRemainAction
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
		sqljob.appendSQL("end-1911),3) < " + year +" ");
		
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
	
	@SuppressWarnings("unchecked")
	protected Map setDMap (BigDecimal treasury_amount,BigDecimal short_amount){
		Map dMap = new HashMap();
		dMap.put("treasury_pre_amount",treasury_amount);
		dMap.put("short_pre_amount",short_amount);
		if (treasury_amount == null && short_amount == null)
			dMap.put("treasury_issue_amount",null);
		else
			dMap.put("treasury_issue_amount",treasury_amount.add(short_amount));
		return dMap;
	}
	
	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception{
		
		
		Gara1201Form myForm = (Gara1201Form) form;
		String thisYearMonth = null;
		if (myForm.getCreateDate() != null)
			thisYearMonth = DateUtil.date2ROCStr(myForm.getCreateDate()).substring(0,5);
		else
			thisYearMonth = DateUtil.date2ROCStr(new Date()).substring(0,5);
		
		
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
		run.update(connection,delSQLJob("GARA12_RPT",usrId));
		//執行 insert
		//前年底國庫短期債務未償餘額實際數
		List queryList1 = (List) run.query(SQL1(myForm.getIssueYear(),unit), new MapListHandler());
		Map countMap = null;
		BigDecimal lastYearNoPay_B = new BigDecimal(0);
		BigDecimal lastYearNoPay_D = new BigDecimal(0);
		for (Iterator it1=queryList1.iterator(); it1.hasNext();){
			countMap = (Map)it1.next();
			lastYearNoPay_B = lastYearNoPay_B.add((BigDecimal)countMap.get("issue_total_B")).subtract((BigDecimal)countMap.get("capital_total_B"));
			lastYearNoPay_D = lastYearNoPay_D.add((BigDecimal)countMap.get("issue_total_D")).subtract((BigDecimal)countMap.get("capital_total_D"));
		}
		
		//今年底國庫與短期借貸 1~12月		
		Map dMap = new HashMap();
		Map thisMap = new HashMap();
		List queryList2 = (List) run.query(SQL2(myForm.getIssueYear(),unit), new MapListHandler());
		String month[] = {"01","02","03","04","05","06","07","08","09","10","11","12"};
		int index = 0;
		BigDecimal yearAmount= new BigDecimal(0);
		yearAmount = this.getYearAmount(connection,myForm.getIssueYear(),unit,"1");
		for (int i=0 ; i < month.length ; i++){
			if (queryList2.size() > 0)
				dMap = (Map)queryList2.get(index);
			else
				dMap.put("month1",0);
			if (((Integer)dMap.get("month1")).intValue() == Integer.parseInt(month[i])){
				if (!(index >= queryList2.size()-1))
					index++;
				lastYearNoPay_B = lastYearNoPay_B.add((BigDecimal)dMap.get("issue_total_B")).subtract((BigDecimal)dMap.get("capital_total_B"));
				lastYearNoPay_D = lastYearNoPay_D.add((BigDecimal)dMap.get("issue_total_D")).subtract((BigDecimal)dMap.get("capital_total_D"));
			}		
			thisMap.putAll(getCommonMap(usrId));
			thisMap.put("item",myForm.getIssueYear()+"年"+month[i]+"月底");
			if (Integer.parseInt(thisYearMonth) >= Integer.parseInt(myForm.getIssueYear()+month[i])){
				thisMap.putAll(setDMap(lastYearNoPay_B,lastYearNoPay_D));
				thisMap.put("treasury_payment_amount",this.divideCheck((BigDecimal)thisMap.get("treasury_issue_amount"),yearAmount));
			}else{
				thisMap.putAll(setDMap(null,null));
				thisMap.put("treasury_payment_amount",null);
			}
			run.update(connection,insTemp("GARA12_RPT",thisMap));
			AccountQueryForm pAccountQueryForm = new AccountQueryForm();
			pAccountQueryForm.setAccountYear(myForm.getIssueYear());
			request.setAttribute("remark2",GARA3601.setRemark2(pAccountQueryForm,connection,"2"));
		}
		
	}
}