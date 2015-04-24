/* DIRA0401.java 報表
 程式目的：DIRA0401
 程式代號：DIRA0401
 程式日期：0950308
 程式作者：Eric.Chen
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
 --------------------------------------------------------
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

import tw.gov.nta.sql.NationDebitMain;
import tw.gov.nta.surplusage.common.Gara33ReMainList;
import tw.gov.nta.surplusage.common.Gara34ReMainList;
import tw.gov.nta.surplusage.form.Gara2901Form;
import tw.gov.nta.system.common.NationCodeManager;
import tw.gov.nta.system.common.NationDebitManager;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class GARA2901 extends ExcelReportRemainAction {

	@SuppressWarnings("unchecked")
	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception{
		Gara2901Form myForm = (Gara2901Form) form;
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
		run.update(connection,delSQLJob("GARA29_RPT",usrId));
		//執行 insert
		
		//取得grar33未償餘額List物件
		//List qryGara33 = (List) run.query(CommonReportSQL.Gara33SQL(myForm.getAccountEyear(),unit), new MapListHandler());
		//Gara33ReMainList gara33 = new Gara33ReMainList(qryGara33);
		Gara33ReMainList gara33 = new Gara33ReMainList(connection,myForm.getAccountEyear(),unit);
		//取得grar34未償餘額List物件
		//List qryGara34 = (List) run.query(CommonReportSQL.Gara34SQL(myForm.getAccountEyear(),unit), new MapListHandler());
		//Gara34ReMainList gara34 = new Gara34ReMainList(qryGara34);
		Gara34ReMainList gara34 = new Gara34ReMainList(connection,myForm.getAccountEyear(),unit);	
		
		String accountYear="";
		String accountKind="";
		
		Map dMap = new HashMap();
		
		//總計
		BigDecimal total = new BigDecimal(0);
		//GNP
		BigDecimal gdpAmount = new BigDecimal(0);
		
		//跑年度的迴圈
		for(int i=startYear;i<=endYear;i++)
		{
			dMap.putAll(getCommonMap(usrId));
			//初始化為起始年
			accountYear = this.getStrYear(String.valueOf(i));
			//設定取得gara33哪一年資料
			accountKind = getAccountKind(connection,accountYear,"'A'");
			gara33.setQryMap(accountYear,accountKind);
			//設定取得gara34哪一年資料
			accountKind = getAccountKind(connection,accountYear,"'C','E'");
			gara34.setQryMap(accountYear,accountKind);
			
			/**
			 *	公債 
			 */
				//年度別
				dMap.put("account_year",accountYear);
				//甲類公債
				dMap.put("BA1",gara33.getReMainField(1));
				//乙類公債
				dMap.put("BA2",gara33.getReMainField(2));
				//九二一.....及軍購
				dMap.put("BA3",gara33.getReMainField(4));
				//債務基金
				dMap.put("BA4",gara33.getReMainField(5));
				//合計
				dMap.put("sum1",gara33.getReMainTotal());
			
			/**
			 * 借貸
			 */	
				//甲類借款 = 總預算 + 戰機(特別預算) + 北二高(特別預算) +　立法院(特別預算)
				//73,74年固定金額
				if(i == 73)
					dMap.put("BA5",new BigDecimal("2433000000").divide(unit,4,BigDecimal.ROUND_HALF_UP));
				else if(i == 74)
					dMap.put("BA5",new BigDecimal("2008000000").divide(unit,4,BigDecimal.ROUND_HALF_UP));
				else
					dMap.put("BA5",gara34.getReMainField(1).add(
							gara34.getReMainField(2).add(
							gara34.getReMainField(3).add(
							gara34.getReMainField(5)))));
				
				
				
				//特別預算-乙類借款未償餘額
				dMap.put("BA6",gara34.getReMainField(4));
				//九二一等未償餘額
				dMap.put("BA7",gara34.getReMainField(6));
				//省債未償餘額
				dMap.put("BA8",gara34.getReMainField(7));
				//債務基金未償餘額
				dMap.put("BA9",gara34.getReMainField(10));
				//新生地開發未償餘額
				dMap.put("BA10",gara34.getReMainField(8));
				//糧食平準基金基金未償餘額
				dMap.put("BA11",gara34.getReMainField(9));				
				//非營業基金未償餘額
				dMap.put("BA12",gara34.getReMainField(11));
				//未償餘額總數
				//dMap.put("sum2",gara34.getReMainTotal());
				dMap.put("sum2",((BigDecimal)dMap.get("BA5")).add((BigDecimal)dMap.get("BA6"))
						.add((BigDecimal)dMap.get("BA7")).add((BigDecimal)dMap.get("BA8"))
						.add((BigDecimal)dMap.get("BA9")).add((BigDecimal)dMap.get("BA10"))
						.add((BigDecimal)dMap.get("BA11")).add((BigDecimal)dMap.get("BA12")));
				//公債 + 借貸
				//total = gara33.getReMainTotal().add(gara34.getReMainTotal());
				total = ((BigDecimal)dMap.get("sum1")).add((BigDecimal)dMap.get("sum2"));
				dMap.put("t1",total);
			/**
			 * 總計及百分比
			 */	
				//GDP
				gdpAmount = this.getGDP(connection,accountYear,unit);
				dMap.put("gdp_amount",gdpAmount);
				//公債 占 支出總額 %
				dMap.put("T_rate",gara33.getReMainTotal()
						.divide(gdpAmount,4,4));
				//借款 占 支出總額 %
				dMap.put("R_rate",gara34.getReMainTotal().divide(gdpAmount,4,4));
				//總計 占 支出總額 %
				dMap.put("Sum_rate",total.divide(gdpAmount,4,4));
				//新增到TempTable
				run.update(connection,insTemp("GARA29_RPT",dMap));
				NationDebitMain nationDebitMain = new NationDebitMain();
				nationDebitMain.setAccountYear(accountYear);
				nationDebitMain.setNationCode(NationCodeManager.get(24));
				List list = new NationDebitManager().query(nationDebitMain);
				for(Iterator it = list.iterator() ; it.hasNext() ;){
					nationDebitMain = (NationDebitMain)it.next();
					nationDebitMain.setRemainRate(total.divide(gdpAmount,4,4).multiply(new BigDecimal(100)));
					new NationDebitManager().update(nationDebitMain.getId(), nationDebitMain);
				}
		}	
        SQLJob queryJob1 = selTemp1();
        List queryList1 = (List) run.query(queryJob1, new MapListHandler());
        String remark = "	三、";
        for(Iterator it1=queryList1.iterator();it1.hasNext();)
        {
        	Map mapQry1 = (Map) it1.next();
        	remark += (String)mapQry1.get("debit_name")+",";
        }
        request.setAttribute("remark",remark.substring(0,remark.length()-1));
        request.setAttribute("remarkRow",endYear-startYear);
	}

	protected SQLJob selTemp1(){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select debit_name from debit_ref where remark = '90年度以後新增特別預算'");
		return sqljob;
	}
}
