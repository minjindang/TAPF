package tw.gov.nta.surplusage.common;

import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import tw.gov.nta.surplusage.form.Gara3901Form;

import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class Gara39Report_1021021 {
	//公債 total
	public SQLJob selectSheet1ByDebtTypeA(Gara3901Form form)
	{
		String year = String.valueOf( Integer.parseInt( form.getYear() ) );
		String month = String.valueOf( Integer.parseInt( form.getMonth() ) );
		Date queryLastDate = DateUtil.getLastDateOfMonth(new Date(Integer.parseInt(year)+11 , Integer.parseInt(month)-1,1));
		String strLastDate = DateUtil.date2Str(queryLastDate,"yyyy/MM/dd");
		
		SQLJob sqljob = new SQLJob();
		
		sqljob.appendSQL(" SELECT '公債' AS debt_type, ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911)="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year1 , ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911+1)="+year+"  THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year2 , ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911+2)="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year3 , ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911+3)="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year4 , ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911+4)="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year5 , ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911+5)="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year6 , ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911+6)="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year7 , ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911+7)="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year8 , ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911+8)="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year9, ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911+9)="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year10, ");
		sqljob.appendSQL(" ROUND(SUM(case when DATEPART( yy , DP.REPAY_DATE )-(1911+10) >="+year+" AND DATEPART( yy , DP.REPAY_DATE )-(1911+13) <="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END) ,2) AS year_5_1, ");
		sqljob.appendSQL(" ROUND(SUM(case when DATEPART( yy , DP.REPAY_DATE )-(1911+14) >="+year+" AND DATEPART( yy , DP.REPAY_DATE )-(1911+18) <="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END) ,2) AS year_5_2, ");
		sqljob.appendSQL(" ROUND(SUM(case when DATEPART( yy , DP.REPAY_DATE )-(1911+19) >="+year+" AND DATEPART( yy , DP.REPAY_DATE )-(1911+23) <="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END) ,2) AS year_5_3, ");
		sqljob.appendSQL(" ROUND(SUM(case when DATEPART( yy , DP.REPAY_DATE )-(1911+24) >="+year+" AND DATEPART( yy , DP.REPAY_DATE )-(1911+30) <="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END) ,2) AS year_5_4  ");
		sqljob.appendSQL(" FROM  ");
		sqljob.appendSQL(" DEBT_PLAN_DET DP LEFT JOIN ISSUE_MAIN I ON DP.ISSUE_ID=I.ID ");
		sqljob.appendSQL(" WHERE 1=1  ");
		sqljob.appendSQL(" AND DP.ISSUE_ID IN (SELECT ID FROM ISSUE_MAIN WHERE ISSUE_DATE <='"+strLastDate+"' AND DEBT_CODE NOT IN ('42','35') AND BOND_TYPE = '1' AND DEBT_TYPE='A' ) ");
		sqljob.appendSQL(" AND ISNULL(DP.REPORT_FLAG,'0') = '0'  ");
		sqljob.appendSQL(" AND DP.DELETE_MARK='N'  ");
		sqljob.appendSQL(" AND DP.CAPITAL_AMOUNT>0 ");
		
		return sqljob;
	}
	//中長借 total
	public List selectSheet1ByDebtTypeC(Gara3901Form form,SQLRunner run) throws Exception
	{
		String year = String.valueOf( Integer.parseInt( form.getYear() ) );
		String month = String.valueOf( Integer.parseInt( form.getMonth() ) );
		Date queryLastDate = DateUtil.getLastDateOfMonth(new Date(Integer.parseInt(year)+11 , Integer.parseInt(month)-1,1));
		String strLastDate = DateUtil.date2Str(queryLastDate,"yyyy/MM/dd");
		
		
		//計畫
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL(" SELECT '中長期借款' AS debt_type, ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911)="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year1 , ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911+1)="+year+"  THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year2 , ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911+2)="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year3 , ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911+3)="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year4 , ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911+4)="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year5 , ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911+5)="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year6 , ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911+6)="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year7 , ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911+7)="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year8 , ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911+8)="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year9, ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911+9)="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year10, ");
		sqljob.appendSQL(" ROUND(SUM(case when DATEPART( yy , DP.REPAY_DATE )-(1911+10) >="+year+" AND DATEPART( yy , DP.REPAY_DATE )-(1911+13) <="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END) ,2) AS year_5_1, "); 
		sqljob.appendSQL(" ROUND(SUM(case when DATEPART( yy , DP.REPAY_DATE )-(1911+14) >="+year+" AND DATEPART( yy , DP.REPAY_DATE )-(1911+18) <="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END) ,2) AS year_5_2,  ");
		sqljob.appendSQL(" ROUND(SUM(case when DATEPART( yy , DP.REPAY_DATE )-(1911+19) >="+year+" AND DATEPART( yy , DP.REPAY_DATE )-(1911+23) <="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END) ,2) AS year_5_3,  ");
		sqljob.appendSQL(" ROUND(SUM(case when DATEPART( yy , DP.REPAY_DATE )-(1911+24) >="+year+" AND DATEPART( yy , DP.REPAY_DATE )-(1911+30) <="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END) ,2) AS year_5_4  ");
		sqljob.appendSQL(" FROM  ");
		sqljob.appendSQL(" DEBT_PLAN_DET DP "); 
		sqljob.appendSQL(" WHERE 1=1  ");
		sqljob.appendSQL(" AND DP.ISSUE_ID IN (SELECT ID FROM ISSUE_MAIN WHERE ISSUE_DATE <='"+strLastDate+"' AND DEBT_CODE NOT IN ('42','35') AND DEBT_TYPE='C' ) ");
		sqljob.appendSQL(" AND ISNULL(DP.REPORT_FLAG,'0') = '0'  ");
		sqljob.appendSQL(" AND DP.DELETE_MARK='N'  ");
		sqljob.appendSQL(" AND DP.CAPITAL_AMOUNT>0 ");		
		
		//已償1(提前償還不在自己的年度顯示)
		SQLJob sqljob_1 = new SQLJob();
		sqljob_1.appendSQL(" SELECT '中長期借款' , ");
		sqljob_1.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,P.PLAN_REPAY_DATE)-(1911)="+year+" THEN P.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year1 , ");
		sqljob_1.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,P.PLAN_REPAY_DATE)-(1911+1)="+year+"  THEN P.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year2 , ");
		sqljob_1.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,P.PLAN_REPAY_DATE)-(1911+2)="+year+" THEN P.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year3 , ");
		sqljob_1.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,P.PLAN_REPAY_DATE)-(1911+3)="+year+" THEN P.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year4 , ");
		sqljob_1.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,P.PLAN_REPAY_DATE)-(1911+4)="+year+" THEN P.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year5 , ");
		sqljob_1.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,P.PLAN_REPAY_DATE)-(1911+5)="+year+" THEN P.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year6 , ");
		sqljob_1.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,P.PLAN_REPAY_DATE)-(1911+6)="+year+" THEN P.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year7 , ");
		sqljob_1.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,P.PLAN_REPAY_DATE)-(1911+7)="+year+" THEN P.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year8 , ");
		sqljob_1.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,P.PLAN_REPAY_DATE)-(1911+8)="+year+" THEN P.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year9, ");
		sqljob_1.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,P.PLAN_REPAY_DATE)-(1911+9)="+year+" THEN P.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year10, ");
		sqljob_1.appendSQL(" ROUND(SUM(case when DATEPART(YY,P.PLAN_REPAY_DATE)-(1911+10) >="+year+" AND DATEPART(YY,P.PLAN_REPAY_DATE)-(1911+13) <="+year+" THEN P.CAPITAL_AMOUNT/100000000 ELSE 0 END) ,2) AS year_5_1, "); 
		sqljob_1.appendSQL(" ROUND(SUM(case when DATEPART(YY,P.PLAN_REPAY_DATE)-(1911+14) >="+year+" AND DATEPART(YY,P.PLAN_REPAY_DATE)-(1911+18) <="+year+" THEN P.CAPITAL_AMOUNT/100000000 ELSE 0 END) ,2) AS year_5_2,  ");
		sqljob_1.appendSQL(" ROUND(SUM(case when DATEPART(YY,P.PLAN_REPAY_DATE)-(1911+19) >="+year+" AND DATEPART(YY,P.PLAN_REPAY_DATE)-(1911+23) <="+year+" THEN P.CAPITAL_AMOUNT/100000000 ELSE 0 END) ,2) AS year_5_3,  ");
		sqljob_1.appendSQL(" ROUND(SUM(case when DATEPART(YY,P.PLAN_REPAY_DATE)-(1911+24) >="+year+" AND DATEPART(YY,P.PLAN_REPAY_DATE)-(1911+30) <="+year+" THEN P.CAPITAL_AMOUNT/100000000 ELSE 0 END) ,2) AS year_5_4  ");
		sqljob_1.appendSQL(" FROM  ");
		sqljob_1.appendSQL(" PAYMENT_MAIN P "); 
		sqljob_1.appendSQL(" WHERE 1=1  ");
		sqljob_1.appendSQL(" AND P.ISSUE_ID IN (SELECT ID FROM ISSUE_MAIN WHERE ISSUE_DATE <='"+strLastDate+"' AND DEBT_CODE NOT IN ('42','35') AND DEBT_TYPE='C' ) ");
		sqljob_1.appendSQL(" AND P.REPAY_DATE<P.plan_REPAY_DATE ");
		sqljob_1.appendSQL(" AND P.CAPITAL_AMOUNT>0 ");
		sqljob_1.appendSQL(" GROUP BY DATEPART( yy , P.plan_REPAY_DATE ),DATEPART( yy , P.REPAY_DATE ) ");
		sqljob_1.appendSQL(" HAVING DATEPART( yy , P.plan_REPAY_DATE )<>DATEPART( yy , P.REPAY_DATE ) ");
		
		//已償2(提前償還不在自己的年度顯示)
		SQLJob sqljob_2 = new SQLJob();
		sqljob_2.appendSQL(" SELECT '中長期借款' , ");
		sqljob_2.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,P.REPAY_DATE)-(1911)="+year+" THEN P.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year1 , ");
		sqljob_2.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,P.REPAY_DATE)-(1911+1)="+year+"  THEN P.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year2 , ");
		sqljob_2.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,P.REPAY_DATE)-(1911+2)="+year+" THEN P.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year3 , ");
		sqljob_2.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,P.REPAY_DATE)-(1911+3)="+year+" THEN P.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year4 , ");
		sqljob_2.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,P.REPAY_DATE)-(1911+4)="+year+" THEN P.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year5 , ");
		sqljob_2.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,P.REPAY_DATE)-(1911+5)="+year+" THEN P.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year6 , ");
		sqljob_2.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,P.REPAY_DATE)-(1911+6)="+year+" THEN P.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year7 , ");
		sqljob_2.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,P.REPAY_DATE)-(1911+7)="+year+" THEN P.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year8 , ");
		sqljob_2.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,P.REPAY_DATE)-(1911+8)="+year+" THEN P.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year9, ");
		sqljob_2.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,P.REPAY_DATE)-(1911+9)="+year+" THEN P.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year10, ");
		sqljob_2.appendSQL(" ROUND(SUM(case when DATEPART(YY,P.REPAY_DATE)-(1911+10) >="+year+" AND DATEPART(YY,P.REPAY_DATE)-(1911+13) <="+year+" THEN P.CAPITAL_AMOUNT/100000000 ELSE 0 END) ,2) AS year_5_1, "); 
		sqljob_2.appendSQL(" ROUND(SUM(case when DATEPART(YY,P.REPAY_DATE)-(1911+14) >="+year+" AND DATEPART(YY,P.REPAY_DATE)-(1911+18) <="+year+" THEN P.CAPITAL_AMOUNT/100000000 ELSE 0 END) ,2) AS year_5_2,  ");
		sqljob_2.appendSQL(" ROUND(SUM(case when DATEPART(YY,P.REPAY_DATE)-(1911+19) >="+year+" AND DATEPART(YY,P.REPAY_DATE)-(1911+23) <="+year+" THEN P.CAPITAL_AMOUNT/100000000 ELSE 0 END) ,2) AS year_5_3,  ");
		sqljob_2.appendSQL(" ROUND(SUM(case when DATEPART(YY,P.REPAY_DATE)-(1911+24) >="+year+" AND DATEPART(YY,P.REPAY_DATE)-(1911+30) <="+year+" THEN P.CAPITAL_AMOUNT/100000000 ELSE 0 END) ,2) AS year_5_4  ");
		sqljob_2.appendSQL(" FROM  ");
		sqljob_2.appendSQL(" PAYMENT_MAIN P "); 
		sqljob_2.appendSQL(" WHERE 1=1  ");
		sqljob_2.appendSQL(" AND P.ISSUE_ID IN (SELECT ID FROM ISSUE_MAIN WHERE ISSUE_DATE <='"+strLastDate+"' AND DEBT_CODE NOT IN ('42','35') AND DEBT_TYPE='C' ) ");
		sqljob_2.appendSQL(" AND P.REPAY_DATE<P.plan_REPAY_DATE ");
		sqljob_2.appendSQL(" AND P.CAPITAL_AMOUNT>0 ");
		sqljob_2.appendSQL(" GROUP BY DATEPART( yy , P.plan_REPAY_DATE ),DATEPART( yy , P.REPAY_DATE ) ");
		sqljob_2.appendSQL(" HAVING DATEPART( yy , P.plan_REPAY_DATE )<>DATEPART( yy , P.REPAY_DATE ) ");
		
		//當年度是已payment為主未發生則以Plan為主,因此當年度比照年報計算方式處理,調整計算公式改為" 計劃" - "已償1" + "已償2"
		
		Map tempMap_1 = (Map)run.query(sqljob,new MapHandler());//計畫
		List tempList_1 = (List)run.query(sqljob_1,new MapListHandler());//已償1
		List tempList_2 = (List)run.query(sqljob_2,new MapListHandler());//已償2
		//再減去已償1
		if(tempList_1 != null && tempList_1.size() != 0  && tempMap_1 != null){
			for(int i = 0 ; i < tempList_1.size() ; i ++){
				Map tempMap = (Map)tempList_1.get(i);
				for(Iterator it = tempMap_1.keySet().iterator();it.hasNext();){
					String key = String.valueOf(it.next());
					if(!"debt_type".equals(key))
						tempMap_1.put(key, ((BigDecimal)tempMap_1.get(key)).subtract((BigDecimal)tempMap.get(key)));
				}
			}
		}
		//再加上已償2
		if(tempList_2 != null && tempList_2.size() != 0  && tempMap_1 != null){
			for(int i = 0 ; i < tempList_2.size() ; i ++){
				Map tempMap = (Map)tempList_2.get(i);
				for(Iterator it = tempMap_1.keySet().iterator();it.hasNext();){
					String key = String.valueOf(it.next());
					if(!"debt_type".equals(key))
						tempMap_1.put(key, ((BigDecimal)tempMap_1.get(key)).add((BigDecimal)tempMap.get(key)));
				}
			}
		}
		List resultList = new ArrayList();
		resultList.add(tempMap_1);
		return resultList;
	}
	//短借 total
	public SQLJob selectSheet1ByDebtTypeD(Gara3901Form form)
	{
		String year = String.valueOf( Integer.parseInt( form.getYear() ) );
		String month = String.valueOf( Integer.parseInt( form.getMonth() ) );
		Date queryLastDate = DateUtil.getLastDateOfMonth(new Date(Integer.parseInt(year)+11 , Integer.parseInt(month)-1,1));
		String strLastDate = DateUtil.date2Str(queryLastDate,"yyyy/MM/dd");
		
		SQLJob sqljob = new SQLJob();
		
		sqljob.appendSQL(" SELECT '債務基金(短借)' AS debt_type, ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911)="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year1 , ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911+1)="+year+"  THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year2 , ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911+2)="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year3, ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911+3)="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year4 , ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911+4)="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year5 , ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911+5)="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year6 , ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911+6)="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year7 , ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911+7)="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year8 , ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911+8)="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year9, ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911+9)="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year10, ");
		sqljob.appendSQL(" ROUND(SUM(case when DATEPART( yy , DP.REPAY_DATE )-(1911+10) >="+year+" AND DATEPART( yy , DP.REPAY_DATE )-(1911+13) <="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END) ,2) AS year_5_1, "); 
		sqljob.appendSQL(" ROUND(SUM(case when DATEPART( yy , DP.REPAY_DATE )-(1911+14) >="+year+" AND DATEPART( yy , DP.REPAY_DATE )-(1911+18) <="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END) ,2) AS year_5_2, "); 
		sqljob.appendSQL(" ROUND(SUM(case when DATEPART( yy , DP.REPAY_DATE )-(1911+19) >="+year+" AND DATEPART( yy , DP.REPAY_DATE )-(1911+23) <="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END) ,2) AS year_5_3,  ");
		sqljob.appendSQL(" ROUND(SUM(case when DATEPART( yy , DP.REPAY_DATE )-(1911+24) >="+year+" AND DATEPART( yy , DP.REPAY_DATE )-(1911+30) <="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END) ,2) AS year_5_4  ");
		sqljob.appendSQL(" FROM  ");
		sqljob.appendSQL(" DEBT_PLAN_DET DP LEFT JOIN ISSUE_MAIN I ON DP.ISSUE_ID=I.ID ");
		sqljob.appendSQL(" WHERE 1=1  ");
		sqljob.appendSQL(" AND DP.ISSUE_ID IN (SELECT ID FROM ISSUE_MAIN WHERE ISSUE_DATE <='"+strLastDate+"' AND DEBT_CODE='31' AND DEBT_TYPE='D' ) ");
		sqljob.appendSQL(" AND ISNULL(DP.REPORT_FLAG,'0') = '0'  ");
		sqljob.appendSQL(" AND DP.DELETE_MARK='N'  ");
		sqljob.appendSQL(" AND DP.CAPITAL_AMOUNT>0 ");
		
		
		return sqljob;
	}
	public void insertSheet1(Connection connection, SQLRunner run, List list,String usrId) throws SQLException
	{
		for(Iterator it=list.iterator();it.hasNext();)
		{
			Map map = (Map) it.next();
			String	debtType	=	(String)	(map.get("debt_type")==null?"":map.get("debt_type"));
			BigDecimal	year1	=	(BigDecimal)	(map.get("year1")==null?new BigDecimal(0.0):map.get("year1"));
			BigDecimal	year2	=	(BigDecimal)	(map.get("year2")==null?new BigDecimal(0.0):map.get("year2"));
			BigDecimal	year3	=	(BigDecimal)	(map.get("year3")==null?new BigDecimal(0.0):map.get("year3"));
			BigDecimal	year4	=	(BigDecimal)	(map.get("year4")==null?new BigDecimal(0.0):map.get("year4"));
			BigDecimal	year5	=	(BigDecimal)	(map.get("year5")==null?new BigDecimal(0.0):map.get("year5"));
			BigDecimal	year6	=	(BigDecimal)	(map.get("year6")==null?new BigDecimal(0.0):map.get("year6"));
			BigDecimal	year7	=	(BigDecimal)	(map.get("year7")==null?new BigDecimal(0.0):map.get("year7"));
			BigDecimal	year8	=	(BigDecimal)	(map.get("year8")==null?new BigDecimal(0.0):map.get("year8"));
			BigDecimal	year9	=	(BigDecimal)	(map.get("year9")==null?new BigDecimal(0.0):map.get("year9"));
			BigDecimal	year10	=	(BigDecimal)	(map.get("year10")==null?new BigDecimal(0.0):map.get("year10"));
			BigDecimal	subTotal=	year1.add(year2).add(year3).add(year4).add(year5).add(year6).add(year7).add(year8).add(year9).add(year10);
			BigDecimal	year_5_1=	(BigDecimal)	(map.get("year_5_1")==null?new BigDecimal(0.0):map.get("year_5_1"));
			BigDecimal	year_5_2=	(BigDecimal)	(map.get("year_5_2")==null?new BigDecimal(0.0):map.get("year_5_2"));
			BigDecimal	year_5_3=	(BigDecimal)	(map.get("year_5_3")==null?new BigDecimal(0.0):map.get("year_5_3"));
			BigDecimal	year_5_4=	(BigDecimal)	(map.get("year_5_4")==null?new BigDecimal(0.0):map.get("year_5_4"));
			BigDecimal	total	=	subTotal.add(year_5_1).add(year_5_2).add(year_5_3).add(year_5_4);

			SQLJob sqljob = new SQLJob();
			sqljob.appendSQL("INSERT INTO GARA39_RPT4 ");
			sqljob.appendSQL(" ( year1, year2, year3, year4, year5, ");
			sqljob.appendSQL(" year6, year7, year8, year9, year10, ");
			sqljob.appendSQL("  SUBTOTAL, year_5_1, year_5_2, year_5_3, year_5_4,");
			sqljob.appendSQL(" TOTAL, debt_type, USRID, MOD_DATE, REMARK ) ");
			sqljob.appendSQL(" VALUES ( ?,?,?,?,?,");
			sqljob.appendSQL(" ?,?,?,?,?,");
			sqljob.appendSQL(" ?,?,?,?,?,");
			sqljob.appendSQL(" ?,?,?,CURRENT_TIMESTAMP,'' ) ");
			sqljob.addParameter( year1 );
			sqljob.addParameter( year2 );
			sqljob.addParameter( year3 );
			sqljob.addParameter( year4 );
			sqljob.addParameter( year5 );
			sqljob.addParameter( year6 );
			sqljob.addParameter( year7 );
			sqljob.addParameter( year8 );
			sqljob.addParameter( year9 );
			sqljob.addParameter( year10 );
			sqljob.addParameter( subTotal );
			sqljob.addParameter( year_5_1 );
			sqljob.addParameter( year_5_2 );
			sqljob.addParameter( year_5_3 );
			sqljob.addParameter( year_5_4 );
			sqljob.addParameter( total );
			sqljob.addParameter( debtType );
			sqljob.addParameter( usrId );
			System.out.println(sqljob);
			run.update(connection, sqljob );
		}
	}
	//公債detail
	public SQLJob selectSheet3ByDebtTypeA(Gara3901Form form)
	{
		String year = String.valueOf( Integer.parseInt( form.getYear() ) );
		String month = String.valueOf( Integer.parseInt( form.getMonth() ) );
		Date queryLastDate = DateUtil.getLastDateOfMonth(new Date(Integer.parseInt(year)+11 , Integer.parseInt(month)-1,1));
		String strLastDate = DateUtil.date2Str(queryLastDate,"yyyy/MM/dd");
		
		SQLJob sqljob = new SQLJob();
		
		sqljob.appendSQL(" SELECT  ");
		sqljob.appendSQL(" MONTH(DP.REPAY_DATE) AS mon, ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911)="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year1 , ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911+1)="+year+"  THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year2 , ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911+2)="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year3 , ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911+3)="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year4 , ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911+4)="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year5 , ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911+5)="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year6 , ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911+6)="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year7 , ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911+7)="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year8 , ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911+8)="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year9, ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911+9)="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year10, ");
		sqljob.appendSQL(" ROUND(SUM(case when DATEPART( yy , DP.REPAY_DATE )-(1911+10) >="+year+" AND DATEPART( yy , DP.REPAY_DATE )-(1911+13) <="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END) ,2) AS year_5_1, "); 
		sqljob.appendSQL(" ROUND(SUM(case when DATEPART( yy , DP.REPAY_DATE )-(1911+14) >="+year+" AND DATEPART( yy , DP.REPAY_DATE )-(1911+18) <="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END) ,2) AS year_5_2,  ");
		sqljob.appendSQL(" ROUND(SUM(case when DATEPART( yy , DP.REPAY_DATE )-(1911+19) >="+year+" AND DATEPART( yy , DP.REPAY_DATE )-(1911+23) <="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END) ,2) AS year_5_3,  ");
		sqljob.appendSQL(" ROUND(SUM(case when DATEPART( yy , DP.REPAY_DATE )-(1911+24) >="+year+" AND DATEPART( yy , DP.REPAY_DATE )-(1911+30) <="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END) ,2) AS year_5_4  ");
		sqljob.appendSQL(" FROM   ");
		sqljob.appendSQL(" DEBT_PLAN_DET DP ");
		sqljob.appendSQL(" WHERE 1=1  ");
		sqljob.appendSQL(" AND DP.ISSUE_ID IN (SELECT ID FROM ISSUE_MAIN WHERE ISSUE_DATE <='"+strLastDate+"' AND DEBT_CODE NOT IN ('42','35') AND BOND_TYPE = '1' AND DEBT_TYPE='A' ) ");
		sqljob.appendSQL(" AND ISNULL(DP.REPORT_FLAG,'0') = '0'  ");
		sqljob.appendSQL(" AND DP.DELETE_MARK='N'  ");
		sqljob.appendSQL(" AND DP.CAPITAL_AMOUNT>0 ");
		sqljob.appendSQL(" GROUP BY MONTH(DP.REPAY_DATE) "); 
		sqljob.appendSQL(" ORDER BY MONTH(DP.REPAY_DATE) ");
		
		return sqljob;
	}
	//中長借detail
	public List selectSheet3ByDebtTypeC(Gara3901Form form,SQLRunner run)throws Exception
	{
		String year = String.valueOf( Integer.parseInt( form.getYear() ) );
		String month = String.valueOf( Integer.parseInt( form.getMonth() ) );
		Date queryLastDate = DateUtil.getLastDateOfMonth(new Date(Integer.parseInt(year)+11 , Integer.parseInt(month)-1,1));
		String strLastDate = DateUtil.date2Str(queryLastDate,"yyyy/MM/dd");
		
		//計畫
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL(" SELECT  ");
		sqljob.appendSQL(" MONTH(DP.REPAY_DATE) AS mon, ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-1911="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 end),2) as year1 , ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-1912="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 end),2) as year2 , ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-1913="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 end),2) as year3 , ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-1914="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 end),2) as year4 , ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-1915="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 end),2) as year5 , ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-1916="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 end),2) as year6 , ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-1917="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 end),2) as year7 , ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-1918="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 end),2) as year8 , ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-1919="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 end),2) as year9, ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-1920="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 end),2) as year10, ");
		sqljob.appendSQL(" ROUND(SUM(case when DATEPART( yy , DP.REPAY_DATE )-1921 >="+year+" and DATEPART( yy , DP.REPAY_DATE )-1924 <= 102 THEN DP.CAPITAL_AMOUNT/100000000 else 0 end) ,2) as year_5_1, "); 
		sqljob.appendSQL(" ROUND(SUM(case when DATEPART( yy , DP.REPAY_DATE )-1925 >="+year+" and DATEPART( yy , DP.REPAY_DATE )-1929 <= 102 THEN DP.CAPITAL_AMOUNT/100000000 else 0 end) ,2) as year_5_2,  ");
		sqljob.appendSQL(" ROUND(SUM(case when DATEPART( yy , DP.REPAY_DATE )-1930 >="+year+" and DATEPART( yy , DP.REPAY_DATE )-1934 <= 102 THEN DP.CAPITAL_AMOUNT/100000000 else 0 end) ,2) as year_5_3,  ");
		sqljob.appendSQL(" ROUND(SUM(case when DATEPART( yy , DP.REPAY_DATE )-1935 >="+year+" THEN DP.CAPITAL_AMOUNT/100000000 else 0 end) ,2) as year_5_4  ");
		sqljob.appendSQL(" FROM  ");
		sqljob.appendSQL(" DEBT_PLAN_DET DP "); 
		sqljob.appendSQL(" WHERE 1=1  ");
		sqljob.appendSQL(" AND DP.ISSUE_ID IN (SELECT ID FROM ISSUE_MAIN WHERE ISSUE_DATE <='"+strLastDate+"' AND DEBT_CODE NOT IN ('42','35') AND DEBT_TYPE='C' ) ");
		sqljob.appendSQL(" AND ISNULL(DP.REPORT_FLAG,'0') = '0'  ");
		sqljob.appendSQL(" AND DP.DELETE_MARK='N'  ");
		sqljob.appendSQL(" AND DP.CAPITAL_AMOUNT>0 ");		
		sqljob.appendSQL(" AND DP.ID NOT IN  ");
		sqljob.appendSQL(" ( ");
		sqljob.appendSQL(" SELECT PLAN_ID FROM PAYMENT_MAIN P LEFT JOIN DEBT_PLAN_DET DP ON DP.ID=P.PLAN_ID "); 
		sqljob.appendSQL(" WHERE P.REPAY_DATE<='"+strLastDate+"'  ");
		sqljob.appendSQL(" GROUP BY PLAN_ID,DP.CAPITAL_AMOUNT ");
		sqljob.appendSQL(" HAVING DP.CAPITAL_AMOUNT-SUM(P.CAPITAL_AMOUNT)=0 ");
		sqljob.appendSQL(" ) ");
		sqljob.appendSQL(" GROUP BY MONTH(DP.REPAY_DATE) ");
		sqljob.appendSQL(" ORDER BY MONTH(DP.REPAY_DATE)  ");
		
		//已償1
		SQLJob sqljob_1 = new SQLJob();
		sqljob_1.appendSQL(" SELECT  ");
		sqljob_1.appendSQL(" MONTH(P.PLAN_REPAY_DATE) AS mon, ");
		sqljob_1.appendSQL(" ROUND(SUM(0.0),2) as year1 , ");
		sqljob_1.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,P.plan_REPAY_DATE)-1912="+year+" THEN P.CAPITAL_AMOUNT/100000000 ELSE 0 end),2) as year2 , ");
		sqljob_1.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,P.plan_REPAY_DATE)-1913="+year+" THEN P.CAPITAL_AMOUNT/100000000 ELSE 0 end),2) as year3 , ");
		sqljob_1.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,P.plan_REPAY_DATE)-1914="+year+" THEN P.CAPITAL_AMOUNT/100000000 ELSE 0 end),2) as year4 , ");
		sqljob_1.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,P.plan_REPAY_DATE)-1915="+year+" THEN P.CAPITAL_AMOUNT/100000000 ELSE 0 end),2) as year5 , ");
		sqljob_1.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,P.plan_REPAY_DATE)-1916="+year+" THEN P.CAPITAL_AMOUNT/100000000 ELSE 0 end),2) as year6 , ");
		sqljob_1.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,P.plan_REPAY_DATE)-1917="+year+" THEN P.CAPITAL_AMOUNT/100000000 ELSE 0 end),2) as year7 , ");
		sqljob_1.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,P.plan_REPAY_DATE)-1918="+year+" THEN P.CAPITAL_AMOUNT/100000000 ELSE 0 end),2) as year8 , ");
		sqljob_1.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,P.plan_REPAY_DATE)-1919="+year+" THEN P.CAPITAL_AMOUNT/100000000 ELSE 0 end),2) as year9, ");
		sqljob_1.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,P.plan_REPAY_DATE)-1920="+year+" THEN P.CAPITAL_AMOUNT/100000000 ELSE 0 end),2) as year10, ");
		sqljob_1.appendSQL(" ROUND(SUM(case when DATEPART( yy , P.plan_REPAY_DATE )-1921 >="+year+" and DATEPART( yy , P.REPAY_DATE )-1924 <= 102 THEN P.CAPITAL_AMOUNT/100000000 else 0 end) ,2) as year_5_1, "); 
		sqljob_1.appendSQL(" ROUND(SUM(case when DATEPART( yy , P.plan_REPAY_DATE )-1925 >="+year+" and DATEPART( yy , P.REPAY_DATE )-1929 <= 102 THEN P.CAPITAL_AMOUNT/100000000 else 0 end) ,2) as year_5_2, "); 
		sqljob_1.appendSQL(" ROUND(SUM(case when DATEPART( yy , P.plan_REPAY_DATE )-1930 >="+year+" and DATEPART( yy , P.REPAY_DATE )-1934 <= 102 THEN P.CAPITAL_AMOUNT/100000000 else 0 end) ,2) as year_5_3,  ");
		sqljob_1.appendSQL(" ROUND(SUM(case when DATEPART( yy , P.plan_REPAY_DATE )-1935 >="+year+" THEN P.CAPITAL_AMOUNT/100000000 else 0 end) ,2) as year_5_4 ");
		sqljob_1.appendSQL(" FROM  ");
		sqljob_1.appendSQL(" PAYMENT_MAIN P ");
		sqljob_1.appendSQL(" WHERE 1=1  ");
		sqljob_1.appendSQL(" AND P.ISSUE_ID IN (SELECT ID FROM ISSUE_MAIN WHERE ISSUE_DATE <='"+strLastDate+"' AND DEBT_CODE NOT IN ('42','35') AND DEBT_TYPE='C' ) ");
		sqljob_1.appendSQL(" AND P.REPAY_DATE<P.plan_REPAY_DATE ");
		//sqljob_1.appendSQL(" AND DATEPART( yy , P.plan_REPAY_DATE )<>DATEPART( yy , P.REPAY_DATE ) ");
		sqljob_1.appendSQL(" AND P.CAPITAL_AMOUNT>0 ");
		sqljob_1.appendSQL(" GROUP BY MONTH(P.PLAN_REPAY_DATE) ");
		sqljob_1.appendSQL(" ORDER BY MONTH(P.PLAN_REPAY_DATE) ");
		
		//已償2
		SQLJob sqljob_2 = new SQLJob();
		sqljob_2.appendSQL(" SELECT  ");
		sqljob_2.appendSQL(" MONTH(P.REPAY_DATE) AS mon, ");
		sqljob_2.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,P.REPAY_DATE)-1911="+year+" THEN P.CAPITAL_AMOUNT/100000000 ELSE 0 end),2) as year1 , ");
		sqljob_2.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,P.REPAY_DATE)-1912="+year+" THEN P.CAPITAL_AMOUNT/100000000 ELSE 0 end),2) as year2 , ");
		sqljob_2.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,P.REPAY_DATE)-1913="+year+" THEN P.CAPITAL_AMOUNT/100000000 ELSE 0 end),2) as year3 , ");
		sqljob_2.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,P.REPAY_DATE)-1914="+year+" THEN P.CAPITAL_AMOUNT/100000000 ELSE 0 end),2) as year4 , ");
		sqljob_2.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,P.REPAY_DATE)-1915="+year+" THEN P.CAPITAL_AMOUNT/100000000 ELSE 0 end),2) as year5 , ");
		sqljob_2.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,P.REPAY_DATE)-1916="+year+" THEN P.CAPITAL_AMOUNT/100000000 ELSE 0 end),2) as year6 , ");
		sqljob_2.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,P.REPAY_DATE)-1917="+year+" THEN P.CAPITAL_AMOUNT/100000000 ELSE 0 end),2) as year7 , ");
		sqljob_2.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,P.REPAY_DATE)-1918="+year+" THEN P.CAPITAL_AMOUNT/100000000 ELSE 0 end),2) as year8 , ");
		sqljob_2.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,P.REPAY_DATE)-1919="+year+" THEN P.CAPITAL_AMOUNT/100000000 ELSE 0 end),2) as year9, ");
		sqljob_2.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,P.REPAY_DATE)-1920="+year+" THEN P.CAPITAL_AMOUNT/100000000 ELSE 0 end),2) as year10, ");
		sqljob_2.appendSQL(" ROUND(SUM(case when DATEPART( yy , P.REPAY_DATE )-1921 >="+year+" and DATEPART( yy , P.REPAY_DATE )-1924 <= 102 THEN P.CAPITAL_AMOUNT/100000000 else 0 end) ,2) as year_5_1, "); 
		sqljob_2.appendSQL(" ROUND(SUM(case when DATEPART( yy , P.REPAY_DATE )-1925 >="+year+" and DATEPART( yy , P.REPAY_DATE )-1929 <= 102 THEN P.CAPITAL_AMOUNT/100000000 else 0 end) ,2) as year_5_2, "); 
		sqljob_2.appendSQL(" ROUND(SUM(case when DATEPART( yy , P.REPAY_DATE )-1930 >="+year+" and DATEPART( yy , P.REPAY_DATE )-1934 <= 102 THEN P.CAPITAL_AMOUNT/100000000 else 0 end) ,2) as year_5_3,  ");
		sqljob_2.appendSQL(" ROUND(SUM(case when DATEPART( yy , P.REPAY_DATE )-1935 >="+year+" THEN P.CAPITAL_AMOUNT/100000000 else 0 end) ,2) as year_5_4 ");
		sqljob_2.appendSQL(" FROM  ");
		sqljob_2.appendSQL(" PAYMENT_MAIN P ");
		sqljob_2.appendSQL(" WHERE 1=1  ");
		sqljob_2.appendSQL(" AND P.ISSUE_ID IN (SELECT ID FROM ISSUE_MAIN WHERE ISSUE_DATE <='"+strLastDate+"' AND DEBT_CODE NOT IN ('42','35') AND DEBT_TYPE='C' ) ");
		sqljob_2.appendSQL(" AND P.REPAY_DATE<= '"+strLastDate+"' ");
		//sqljob_2.appendSQL(" AND DATEPART( yy , P.plan_REPAY_DATE )<>DATEPART( yy , P.REPAY_DATE ) ");
		sqljob_2.appendSQL(" AND P.CAPITAL_AMOUNT>0 ");
		sqljob_2.appendSQL(" GROUP BY MONTH(P.REPAY_DATE) ");
		sqljob_2.appendSQL(" ORDER BY MONTH(P.REPAY_DATE) ");
		
		List tempList_1 = (List)run.query(sqljob,new MapListHandler());//計畫
		List tempList_2 = (List)run.query(sqljob_1,new MapListHandler());//已償1
		List tempList_3 = (List)run.query(sqljob_2,new MapListHandler());//已償2
		//再減去已償1
		if(tempList_1 != null && tempList_1.size() != 0 && tempList_2 != null && tempList_2.size() != 0){
			for(int t = 0 ; t < tempList_1.size() ; t++){
				Map tempMap_1 = (Map)tempList_1.get(t);
				for(int i = 0 ; i < tempList_2.size() ; i ++){
					Map tempMap_2 = (Map)tempList_2.get(i);
					if(tempMap_1.get("mon").equals(tempMap_2.get("mon"))){
						for(int count = 1 ; count < 11 ; count++)
							tempMap_1.put("year"+count, ((BigDecimal)tempMap_1.get("year"+count)).subtract((BigDecimal)tempMap_2.get("year"+count)));
						for(int count = 1 ; count < 4 ; count++)
							tempMap_1.put("year_5_"+count, ((BigDecimal)tempMap_1.get("year_5_"+count)).subtract((BigDecimal)tempMap_2.get("year_5_"+count)));
					}
				}
			}
		}
		//再加上已償2
		if(tempList_1 != null && tempList_1.size() != 0 && tempList_3 != null && tempList_3.size() != 0){
			for(int t = 0 ; t < tempList_1.size() ; t++){
				Map tempMap_1 = (Map)tempList_1.get(t);
				for(int i = 0 ; i < tempList_3.size() ; i ++){
					Map tempMap_2 = (Map)tempList_3.get(i);
					if(tempMap_1.get("mon").equals(tempMap_2.get("mon"))){
						for(int count = 1 ; count < 11 ; count++)
							tempMap_1.put("year"+count, ((BigDecimal)tempMap_1.get("year"+count)).add((BigDecimal)tempMap_2.get("year"+count)));
						for(int count = 1 ; count < 4 ; count++)
							tempMap_1.put("year_5_"+count, ((BigDecimal)tempMap_1.get("year_5_"+count)).add((BigDecimal)tempMap_2.get("year_5_"+count)));
					}
				}
			}
		}
		return tempList_1;
	}
	//短借detail
	public SQLJob selectSheet3ByDebtTypeD(Gara3901Form form)
	{
		String year = String.valueOf( Integer.parseInt( form.getYear() ) );
		String month = String.valueOf( Integer.parseInt( form.getMonth() ) );
		Date queryLastDate = DateUtil.getLastDateOfMonth(new Date(Integer.parseInt(year)+11 , Integer.parseInt(month)-1,1));
		String strLastDate = DateUtil.date2Str(queryLastDate,"yyyy/MM/dd");
		
		SQLJob sqljob = new SQLJob();
		
		sqljob.appendSQL(" SELECT  ");
		sqljob.appendSQL(" MONTH(DP.REPAY_DATE) AS mon, ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911)="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year1 , ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911+1)="+year+"  THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year2 , ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911+2)="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year3 , ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911+3)="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year4 , ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911+4)="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year5 , ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911+5)="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year6 , ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911+6)="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year7 , ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911+7)="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year8 , ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911+8)="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year9, ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911+9)="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS year10, ");
		sqljob.appendSQL(" ROUND(SUM(case when DATEPART( yy , DP.REPAY_DATE )-(1911+10) >="+year+" AND DATEPART( yy , DP.REPAY_DATE )-(1911+13) <="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END) ,2) AS year_5_1, "); 
		sqljob.appendSQL(" ROUND(SUM(case when DATEPART( yy , DP.REPAY_DATE )-(1911+14) >="+year+" AND DATEPART( yy , DP.REPAY_DATE )-(1911+18) <="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END) ,2) AS year_5_2,  ");
		sqljob.appendSQL(" ROUND(SUM(case when DATEPART( yy , DP.REPAY_DATE )-(1911+19) >="+year+" AND DATEPART( yy , DP.REPAY_DATE )-(1911+23) <="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END) ,2) AS year_5_3,  ");
		sqljob.appendSQL(" ROUND(SUM(case when DATEPART( yy , DP.REPAY_DATE )-(1911+24) >="+year+" AND DATEPART( yy , DP.REPAY_DATE )-(1911+30) <="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END) ,2) AS year_5_4  ");
		sqljob.appendSQL(" FROM   ");
		sqljob.appendSQL(" DEBT_PLAN_DET DP ");
		sqljob.appendSQL(" WHERE 1=1  ");
		sqljob.appendSQL(" AND DP.ISSUE_ID IN (SELECT ID FROM ISSUE_MAIN WHERE ISSUE_DATE <='"+strLastDate+"' AND DEBT_CODE='31' AND DEBT_TYPE='D' ) ");
		sqljob.appendSQL(" AND ISNULL(DP.REPORT_FLAG,'0') = '0'  ");
		sqljob.appendSQL(" AND DP.DELETE_MARK='N'  ");
		sqljob.appendSQL(" AND DP.CAPITAL_AMOUNT>0 ");
		sqljob.appendSQL(" GROUP BY MONTH(DP.REPAY_DATE) "); 
		sqljob.appendSQL(" ORDER BY MONTH(DP.REPAY_DATE) ");
		
		return sqljob;
	}
	public void insertSheet3(Connection connection, SQLRunner run, List list,String usrId) throws SQLException
	{
		for(Iterator it=list.iterator();it.hasNext();)
		{
			Map map = (Map) it.next();
			Integer	mon	=	(Integer)	(map.get("mon")==null?(new Integer(0)):map.get("mon"));
			BigDecimal	year1	=	(BigDecimal)	(map.get("year1")==null?new BigDecimal(0.0):map.get("year1"));
			BigDecimal	year2	=	(BigDecimal)	(map.get("year2")==null?new BigDecimal(0.0):map.get("year2"));
			BigDecimal	year3	=	(BigDecimal)	(map.get("year3")==null?new BigDecimal(0.0):map.get("year3"));
			BigDecimal	year4	=	(BigDecimal)	(map.get("year4")==null?new BigDecimal(0.0):map.get("year4"));
			BigDecimal	year5	=	(BigDecimal)	(map.get("year5")==null?new BigDecimal(0.0):map.get("year5"));
			BigDecimal	year6	=	(BigDecimal)	(map.get("year6")==null?new BigDecimal(0.0):map.get("year6"));
			BigDecimal	year7	=	(BigDecimal)	(map.get("year7")==null?new BigDecimal(0.0):map.get("year7"));
			BigDecimal	year8	=	(BigDecimal)	(map.get("year8")==null?new BigDecimal(0.0):map.get("year8"));
			BigDecimal	year9	=	(BigDecimal)	(map.get("year9")==null?new BigDecimal(0.0):map.get("year9"));
			BigDecimal	year10	=	(BigDecimal)	(map.get("year10")==null?new BigDecimal(0.0):map.get("year10"));

			SQLJob sqljob = new SQLJob();
			sqljob.appendSQL("INSERT INTO GARA39_RPT5 ");
			sqljob.appendSQL(" ( mon, year1, year2, year3, year4, ");
			sqljob.appendSQL(" year5, year6, year7, year8, year9, ");
			sqljob.appendSQL(" year10, USRID, MOD_DATE, REMARK ) ");
			sqljob.appendSQL(" VALUES ( ?,?,?,?,?,");
			sqljob.appendSQL(" ?,?,?,?,?,");
			sqljob.appendSQL(" ?,?,CURRENT_TIMESTAMP,'' ) ");
			sqljob.addParameter( mon );
			sqljob.addParameter( year1 );
			sqljob.addParameter( year2 );
			sqljob.addParameter( year3 );
			sqljob.addParameter( year4 );
			sqljob.addParameter( year5 );
			sqljob.addParameter( year6 );
			sqljob.addParameter( year7 );
			sqljob.addParameter( year8 );
			sqljob.addParameter( year9 );
			sqljob.addParameter( year10 );
			sqljob.addParameter( usrId );
			System.out.println(sqljob);
			run.update(connection, sqljob );
		}
	}
	public SQLJob getRemarkMapLine1(Gara3901Form form){
		String year = String.valueOf( Integer.parseInt( form.getYear() ) );
		String month = String.valueOf( Integer.parseInt( form.getMonth() ) );
		Date queryLastDate = DateUtil.getLastDateOfMonth(new Date(Integer.parseInt(year)+11 , Integer.parseInt(month)-1,1));
		String strLastDate = DateUtil.date2Str(queryLastDate,"yyyy/MM/dd");
		SQLJob sqljob = new SQLJob();
	
		sqljob.appendSQL(" SELECT TOP 1 ISSUE_DATE,DEBT_SHORT_NAME,ISSUE_AMOUNT/100000000 AS  ISSUE_AMOUNT,ISSUE_SERIAL AS ISSUE_SERIAL ");
		sqljob.appendSQL(" FROM ISSUE_MAIN WHERE DEBT_TYPE='A' AND DEBT_CODE NOT IN ('42','35') AND BOND_TYPE='1' ");
		sqljob.appendSQL(" AND ISSUE_DATE <= '"+strLastDate + "' ");
		sqljob.appendSQL(" ORDER BY ID DESC ");
		
		return sqljob;
	}
	public SQLJob getRemarkMapLine2(Gara3901Form form){
		String year = String.valueOf( Integer.parseInt( form.getYear() ) );
		String month = String.valueOf( Integer.parseInt( form.getMonth() ) );
		Date queryLastDate = DateUtil.getLastDateOfMonth(new Date(Integer.parseInt(year)+11 , Integer.parseInt(month)-1,1));
		String strLastDate = DateUtil.date2Str(queryLastDate,"yyyy/MM/dd");
		SQLJob sqljob = new SQLJob();
	
		sqljob.appendSQL(" SELECT TOP 1 ISSUE_DATE,DEBT_SHORT_NAME,ISSUE_AMOUNT/100000000 AS ISSUE_AMOUNT,ISSUE_SERIAL AS ISSUE_SERIAL  ");
		sqljob.appendSQL(" FROM ISSUE_MAIN WHERE DEBT_TYPE='C' AND DEBT_CODE NOT IN ('42','35')  ");
		sqljob.appendSQL(" AND ISSUE_DATE <= '"+strLastDate + "' ");
        sqljob.appendSQL(" ORDER BY ID DESC ");
		
		return sqljob;
	}
	public SQLJob getRemarkMapLine3(Gara3901Form form){
		String year = String.valueOf( Integer.parseInt( form.getYear() ) );
		String month = String.valueOf( Integer.parseInt( form.getMonth() ) );
		Date queryLastDate = DateUtil.getLastDateOfMonth(new Date(Integer.parseInt(year)+11 , Integer.parseInt(month)-1,1));
		String strLastDate = DateUtil.date2Str(queryLastDate,"yyyy/MM/dd");
		SQLJob sqljob = new SQLJob();
	
		sqljob.appendSQL(" SELECT TOP 1 ISSUE_DATE,DEBT_SHORT_NAME,ISSUE_AMOUNT/100000000 AS ISSUE_AMOUNT,ISSUE_SERIAL AS ISSUE_SERIAL ");
		sqljob.appendSQL(" FROM ISSUE_MAIN WHERE DEBT_TYPE='D' AND DEBT_CODE ='31'  ");
		sqljob.appendSQL(" AND ISSUE_DATE <= '"+strLastDate + "' ");
		sqljob.appendSQL(" ORDER BY ID DESC ");
		
		return sqljob;
	}
	public SQLJob getRemarkMapLine4(Gara3901Form form){
		String year = String.valueOf( Integer.parseInt( form.getYear() ) );
		String month = String.valueOf( Integer.parseInt( form.getMonth() ) );
		Date queryLastDate = DateUtil.getLastDateOfMonth(new Date(Integer.parseInt(year)+11 , Integer.parseInt(month)-1,1));
		String strLastDate = DateUtil.date2Str(queryLastDate,"yyyy/MM/dd");
		SQLJob sqljob = new SQLJob();
	
		sqljob.appendSQL(" SELECT "); 
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911)="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS CAPITAL_AMOUNT "); 
		sqljob.appendSQL(" FROM  ");
		sqljob.appendSQL(" DEBT_PLAN_DET DP LEFT JOIN ISSUE_MAIN I ON DP.ISSUE_ID=I.ID ");
		sqljob.appendSQL(" WHERE 1=1  ");
		sqljob.appendSQL(" AND DP.ISSUE_ID IN (SELECT ID FROM ISSUE_MAIN WHERE ISSUE_DATE <= '"+strLastDate+"' AND DEBT_CODE='31' AND DEBT_TYPE='D' ) ");
		sqljob.appendSQL(" AND ISNULL(DP.REPORT_FLAG,'0') = '0'  ");
		sqljob.appendSQL(" AND DP.DELETE_MARK='N'  ");
		sqljob.appendSQL(" AND DP.CAPITAL_AMOUNT>0 ");
		
		return sqljob;
	}
	public SQLJob getRemarkMapLine5(Gara3901Form form){
		String year = String.valueOf( Integer.parseInt( form.getYear() ) );
		String month = String.valueOf( Integer.parseInt( form.getMonth() ) );
		Date queryLastDate = DateUtil.getLastDateOfMonth(new Date(Integer.parseInt(year)+11 , Integer.parseInt(month)-1,1));
		String strLastDate = DateUtil.date2Str(queryLastDate,"yyyy/MM/dd");
		SQLJob sqljob = new SQLJob();
	
		sqljob.appendSQL(" SELECT  ");
		sqljob.appendSQL(" ROUND(SUM(CASE WHEN DATEPART(YY,DP.REPAY_DATE)-(1911)="+year+" THEN DP.CAPITAL_AMOUNT/100000000 ELSE 0 END),2) AS CAPITAL_AMOUNT"); 
		sqljob.appendSQL(" FROM  ");
		sqljob.appendSQL(" payment_main DP ");
		sqljob.appendSQL(" WHERE 1=1  ");
		sqljob.appendSQL(" AND DP.ISSUE_ID IN (SELECT ID FROM ISSUE_MAIN WHERE ISSUE_DATE <= '"+strLastDate+"' AND DEBT_CODE='31' AND DEBT_TYPE='D' ) ");
		sqljob.appendSQL(" AND DP.CAPITAL_AMOUNT>0	 ");
		sqljob.appendSQL(" AND DP.REPAY_DATE <= '"+strLastDate + "' ");
		
		return sqljob;
	}
		
}
