/* GARA30.java 報表
 程式目的：GARA3001
 程式代號：GARA3001
 程式日期：0950731
 程式作者：Avery.Yeh
 ////////////////////////////////////////////////////////
 修改作者　　修改日期　　　修改目的
 ////////////////////////////////////////////////////////
 */
package tw.gov.nta.surplusage.action;

import gov.dnt.tame.common.ExcelReportRemainAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.surplusage.common.Gara30ReMainList;
import tw.gov.nta.surplusage.form.Gara3001Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class GARA3001 extends ExcelReportRemainAction {

	/*
	protected SQLJob SQL1(Gara3001Form myForm,BigDecimal unit){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select case ");
		sqljob.appendSQL("when (account_year ='088' and year_kind='1' ) then '088' "); 
		sqljob.appendSQL("when ((account_year ='088' and year_kind='2') or account_year ='089' ) then '088上半及089' ");
		sqljob.appendSQL("else account_year ");
		sqljob.appendSQL("end + ");
		sqljob.appendSQL("case account_kind ");
		sqljob.appendSQL("when '1' then '(預)' ");
		sqljob.appendSQL("when '2' then '(決)' ");
		sqljob.appendSQL("when '3' then '(保)' ");
		sqljob.appendSQL("when '4' then '(實)' ");
		sqljob.appendSQL("else '' ");
		sqljob.appendSQL("end item ,account_year,account_kind,");
				//發行 總預算 甲類
		sqljob.appendSQL("sum(case when bound_code = '1' and  budget_code = '1'   and debt_type = 'A' then  issue_amount  else 0 end)/"+unit+" T1,");
				//發行 特別預算 甲類
		sqljob.appendSQL("sum(case when bound_code = '1' and  budget_code = '2' and is_account ='N'  and debt_type = 'A' then  issue_amount else 0 end)/"+unit+" T2,");
				//發行 特別預算 乙類
		sqljob.appendSQL("sum(case when bound_code = '2' and  budget_code = '2' and is_account ='N'  and debt_type = 'A' then  issue_amount else 0 end)/"+unit+" T3,");
				//發行 特別預算 九二一
		sqljob.appendSQL("sum(case when is_account='Y'  and debt_type = 'A' then  issue_amount else 0 end )/"+unit+" T4,");
				//發行 債務基金
		sqljob.appendSQL("sum(case when budget_code = '3'  and debt_type = 'A'   then  issue_amount else 0 end)/"+unit+" T5,");
				//賒借 總預算 甲類
		sqljob.appendSQL("sum(case when bound_code = '1' and  budget_code in ('1','2','5') and  is_account='N' and debt_type in ('C','E') then  issue_amount  else 0 end)/"+unit+" T6,");
		//sqljob.appendSQL("sum(case when bound_code = '1' and  budget_code in ('1','2') and  is_account='N' and debt_type in ('C','E') then  issue_amount  else 0 end)/"+unit+" T6,");
				//賒借 特別預算 乙類
		sqljob.appendSQL("sum(case when bound_code = '2'  and is_account ='N'  and debt_type in ('C','E')  then  issue_amount else 0 end)/"+unit+" T7,");
				//賒借 特別預算 九二一
		sqljob.appendSQL("sum(case when is_account='Y'  and debt_type  in ('C','E') then  issue_amount else 0 end )/"+unit+" T8,");
				//賒借 債務基金
		sqljob.appendSQL("sum(case when budget_code = '3'  and debt_type in ('C','E')   then  issue_amount else 0 end)/"+unit+" T9 ");
		sqljob.appendSQL("from Central_statistics_main ");
		//新增內外債條件
		sqljob.appendSQL("where 1=1 and inout_type='0' ");
		//不顯示保留數
		sqljob.appendSQL("and account_kind <> '3' ");
		//sqljob.appendSQL("where 1=1 ");
		if (!"".equals(myForm.getAccountSyear()) && !"".equals(myForm.getAccountEyear()))
			sqljob.appendSQL("and account_year between " + myForm.getAccountSyear() + " and " + myForm.getAccountEyear() + " ");
		sqljob.appendSQL("group by case ");
		sqljob.appendSQL("when (account_year ='088' and year_kind='1' ) then '088' ");
		sqljob.appendSQL("when ((account_year ='088' and year_kind='2') or account_year ='089' ) then '088上半及089' ");
		sqljob.appendSQL("else account_year ");
		sqljob.appendSQL("end + ");
		sqljob.appendSQL("case account_kind ");
		sqljob.appendSQL("when '1' then '(預)' ");
		sqljob.appendSQL("when '2' then '(決)' ");
		sqljob.appendSQL("when '3' then '(保)' ");
		sqljob.appendSQL("when '4' then '(實)' ");
		sqljob.appendSQL("else '' ");
		sqljob.appendSQL("end ,account_kind,account_year");
		sqljob.appendSQL("order by account_year,account_kind ");
		System.out.println("GARA3001-SQL1:"+sqljob);
		return sqljob;
	}
	*/
	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Gara3001Form myForm = (Gara3001Form) form;
		//輸入的金額單位
		BigDecimal unit = new BigDecimal(myForm.getAmountUnit());
		//輸入的起始年
		Integer startYear = Integer.parseInt(myForm.getAccountSyear());
		//輸入的結束年
		Integer endYear = Integer.parseInt(myForm.getAccountEyear());
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delSQLJob("GARA30_RPT",usrId));
		
		//執行 insert
		
		
		//取得grar30未償餘額List物件
		//List qryGara30 = (List) run.query(CommonReportSQL.Gara30SQL(myForm.getAccountEyear(),unit), new MapListHandler());
		//Gara30ReMainList gara30 = new Gara30ReMainList(qryGara30);
		Gara30ReMainList gara30 = new Gara30ReMainList(connection,myForm.getAccountEyear(),new BigDecimal(1));
		
		String[] accountKind = {"1","2","4"};
		String qryYear = "";
		Map dMap = new HashMap();
		for (int i = startYear; i <= endYear; i++){
			for (int j = 0; j < accountKind.length; j++){
				qryYear = this.getStrYear(String.valueOf(i));
				//設定取得gara30哪一年資料
				gara30.setQryMap(qryYear,accountKind[j]);
				//設定取得gara34哪一年資料
				gara30.setQryMap(qryYear,accountKind[j]);
				
				dMap.putAll(getCommonMap(usrId));
				//年度別
				dMap.put("item",gara30.getOtherKind("item"));
				/**
				 * 公債 
				 */
				//甲類公債
				dMap.put("t1",gara30.getIssueFieldA(1));
				//特別預算甲類
				dMap.put("t2",gara30.getIssueFieldA(2));
				//特別預算乙類
				dMap.put("t3",gara30.getIssueFieldA(3));
				//特別預算小計
				dMap.put("t123_total",gara30.getIssueFieldA(2).add(gara30.getIssueFieldA(3)));
				//九二一.....及軍購
				dMap.put("t4",gara30.getIssueFieldA(4));
				//債務基金
				dMap.put("t5",gara30.getIssueFieldA(5));
				//總計
				dMap.put("t145_total",gara30.getIssueFieldA(1).add(gara30.getIssueFieldA(2)).add(gara30.getIssueFieldA(3)).add(gara30.getIssueFieldA(4)));
				
				
				/**
				 * 借款
				 */
				//總預算甲類
				dMap.put("t6",gara30.getIssueFieldA(10).add(gara30.getIssueFieldA(14)));
				//特別預算乙類包含特別預算債務
				dMap.put("t7",gara30.getIssueFieldA(11));
				//九二一
				dMap.put("t8",gara30.getIssueFieldA(12));
				//債務基金
				dMap.put("t9",gara30.getIssueFieldA(13));
				//總計
				if (Integer.parseInt(qryYear) < 91)
					dMap.put("t8910_total",((BigDecimal)dMap.get("t6")).add(((BigDecimal)dMap.get("t7"))).add(((BigDecimal)dMap.get("t8"))));
				else if (Integer.parseInt(qryYear) >= 91)
					dMap.put("t8910_total",((BigDecimal)dMap.get("t6")).add(((BigDecimal)dMap.get("t8"))));
				
				/**
				 * 當年度總舉借數
				 */
				if (Integer.parseInt(qryYear) < 91)
					dMap.put("t128_total",((BigDecimal)dMap.get("t145_total")).add(((BigDecimal)dMap.get("t8910_total"))).subtract(((BigDecimal)dMap.get("t3")).add(((BigDecimal)dMap.get("t7")))));
				else if (Integer.parseInt(qryYear) >= 91)
					dMap.put("t128_total",((BigDecimal)dMap.get("t145_total")).add(((BigDecimal)dMap.get("t8910_total"))).subtract(((BigDecimal)dMap.get("t3"))));
				dMap.put("t29_total",((BigDecimal)dMap.get("t3")).add(((BigDecimal)dMap.get("t7"))));
				dMap.put("t1314_total",((BigDecimal)dMap.get("t128_total")).add(((BigDecimal)dMap.get("t29_total"))));
//				支(歲)出 090開始抓uamount
				if (Integer.parseInt(qryYear) < 90)
					dMap.put("budget_amount",this.getYearAmountKind(connection,qryYear,new BigDecimal(1),"1",accountKind[j]));
				else if (Integer.parseInt(qryYear) >= 90)
					dMap.put("budget_amount",this.getYearAmountKind(connection,qryYear,new BigDecimal(1),"2",accountKind[j]));
				BigDecimal t128Total = ((BigDecimal)dMap.get("t128_total"));
				BigDecimal t29Total = ((BigDecimal)dMap.get("t29_total"));
				BigDecimal budgetAmount = ((BigDecimal)dMap.get("budget_amount"));
				
//				dMap.put("Atotal_rate",this.divideCheck(((BigDecimal)dMap.get("t128_total")).divide(unit,0,BigDecimal.ROUND_HALF_UP),((BigDecimal)dMap.get("budget_amount")).divide(unit,0,BigDecimal.ROUND_HALF_UP)));
//				dMap.put("Btotal_rate",this.divideCheck(((BigDecimal)dMap.get("t29_total")).divide(unit,0,BigDecimal.ROUND_HALF_UP),((BigDecimal)dMap.get("budget_amount")).divide(unit,0,BigDecimal.ROUND_HALF_UP)));
//				dMap.put("total_rate",((BigDecimal)dMap.get("Atotal_rate")).add((BigDecimal)dMap.get("Btotal_rate")));
				BigDecimal limitAmount= this.getLimitAmount(connection,qryYear,accountKind[j],new BigDecimal(1),"'A','C'");
				dMap.put("Atotal_rate",this.divideCheck(t128Total.subtract(limitAmount),budgetAmount,8).multiply(new BigDecimal(100)));
				dMap.put("Btotal_rate",this.divideCheck(t29Total,budgetAmount,8).multiply(new BigDecimal(100)));
				dMap.put("total_rate",((BigDecimal)dMap.get("Atotal_rate")).add((BigDecimal)dMap.get("Btotal_rate")));
				String[] column = {"t1","t2","t3","t123_total","t4","t5","t145_total","t6","t7","t8","t9",
						"t8910_total","t128_total","t29_total","t1314_total","budget_amount"};
				for(int columnLength = 0 ; columnLength < column.length ; columnLength ++)
					dMap.put(column[columnLength], ((BigDecimal)dMap.get(column[columnLength])).divide(unit,0,BigDecimal.ROUND_HALF_UP));
				run.update(connection,insTemp("GARA30_RPT",dMap));
			}
		}
        SQLJob queryJob1 = selTemp1();
        List queryList1 = (List) run.query(queryJob1, new MapListHandler());
        String remark = "九、90年後特別預算包括：";
        for(Iterator it1=queryList1.iterator();it1.hasNext();)
        {
        	Map mapQry1 = (Map) it1.next();
        	remark += (String)mapQry1.get("debit_name")+",";
        }
        request.setAttribute("remark",remark.substring(0,remark.length()-1));
        request.setAttribute("remarkRow",endYear-startYear);
		/*
		List queryList1 = (List) run.query(SQL1(myForm,unit), new MapListHandler());
		Map tMap = null;
		for(Iterator tIterator = queryList1.iterator(); tIterator.hasNext(); ){
			tMap = (Map) tIterator.next();
			tMap.putAll(getCommonMap(usrId));
			//支(歲)出 090開始抓uamount
			if (Integer.parseInt(((String)tMap.get("item")).substring(0,3)) < 90)
				tMap.put("budget_amount",this.getYearAmountKind(connection,((String)tMap.get("item")).substring(0,3),unit,"1",(String)tMap.get("account_kind")));
			else if (Integer.parseInt(((String)tMap.get("item")).substring(0,3)) >= 90)
				tMap.put("budget_amount",this.getYearAmountKind(connection,((String)tMap.get("item")).substring(0,3),unit,"2",(String)tMap.get("account_kind")));
			//歲出
			//tMap.put("budget_amount",this.getYearAmountBKind(connection,((String)tMap.get("item")).substring(0,3),unit,(String)tMap.get("account_kind")));
			//總計
			tMap.put("t123_total",((BigDecimal)tMap.get("t2")).add((BigDecimal)tMap.get("t3")));
			tMap.put("t145_total",((BigDecimal)tMap.get("t1")).add((BigDecimal)tMap.get("t123_total")).add((BigDecimal)tMap.get("t4")));
			tMap.put("t8910_total",((BigDecimal)tMap.get("t6")).add((BigDecimal)tMap.get("t7")).add((BigDecimal)tMap.get("t8")));
			tMap.put("t128_total",((BigDecimal)tMap.get("t1")).add((BigDecimal)tMap.get("t2")).add((BigDecimal)tMap.get("t6")));
			tMap.put("t29_total",((BigDecimal)tMap.get("t3")).add((BigDecimal)tMap.get("t7")));
			tMap.put("t1314_total",((BigDecimal)tMap.get("t128_total")).add((BigDecimal)tMap.get("t29_total")));
			
			tMap.put("Atotal_rate",this.divideCheck((BigDecimal)tMap.get("t128_total"),(BigDecimal)tMap.get("budget_amount")));
			tMap.put("Btotal_rate",this.divideCheck((BigDecimal)tMap.get("t29_total"),(BigDecimal)tMap.get("budget_amount")));
			tMap.put("total_rate",((BigDecimal)tMap.get("Atotal_rate")).add((BigDecimal)tMap.get("Btotal_rate")));
			run.update(connection,insTemp("GARA30_RPT",tMap));
		}
		*/
	}

	protected SQLJob selTemp1(){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select debit_name from debit_ref where remark = '90年度以後新增特別預算'");
		return sqljob;
	}
}
