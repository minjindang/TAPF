/**
 * @author Avery
 * @create 2006/06/01
 */

package tw.gov.nta.surplusage.action;

import gov.dnt.tame.common.ExcelReportRemainAction;

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

import tw.gov.nta.sql.NationDebitMain;
import tw.gov.nta.sql.debt.GaraNote;
import tw.gov.nta.surplusage.common.Gara33ReMainList;
import tw.gov.nta.surplusage.common.Gara34ReMainList;
import tw.gov.nta.surplusage.common.GaraNoteManager;
import tw.gov.nta.surplusage.form.Gara0401Form;
import tw.gov.nta.system.common.NationCodeManager;
import tw.gov.nta.system.common.NationDebitManager;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class GARA0501 extends ExcelReportRemainAction
{

	protected SQLJob SQL1(Gara0401Form myForm,BigDecimal unit){
		SQLJob sqljob = new SQLJob();

		sqljob.appendSQL("select  account_year,");
		//當年度舉借公債發行數 -91年度起排除乙類
		sqljob.appendSQL("sum(case when ( account_year < 091 and debt_type = 'A' and bound_code in ('1','2') and budget_code in ('1','2') and account_type='Y' )  then  isnull(issue_amount,0) ");
		sqljob.appendSQL("when ( account_year>=091 and debt_type = 'A' and bound_code = '1' and budget_code in ('1','2')  and account_type='Y' )  then  isnull(issue_amount,0) ");
		sqljob.appendSQL("else 0 end)/"+unit+" as AA1 ,");
		//當年度舉借借款發行數(總預算及特別預算)-91年度起排除乙類
		//sqljob.appendSQL("sum(case when ( debt_type IN ('C','E') and budget_code in ('1','2') and account_type='Y' )  then  isnull(issue_amount,0) else 0 end)/"+unit+"  as AA3 ,");
		sqljob.appendSQL("sum(case when ( account_year<091 and debt_type IN ('C','E') and bound_code  in ('1','2')  and budget_code in ('1','2') and account_type='Y' )  then  isnull(issue_amount,0) ");
		sqljob.appendSQL("when ( account_year>=091 and debt_type IN ('C','E') and bound_code  in ('1')  and budget_code in ('1','2') and account_type='Y' )  then  isnull(issue_amount,0) ");
		sqljob.appendSQL("else 0 end)/"+unit+"  as AA2 ,");
		//當年度舉借列入債限
		//sqljob.appendSQL("sum(case when ( is_debt='Y' and account_type='Y' )  then isnull(issue_amount,0)  else 0 end )/"+unit+"  as AA5 ,");
		sqljob.appendSQL("sum(case when ( account_year<091 and is_debt='Y' and bound_code in ('1','2')  and budget_code in ('1','2') and account_type='Y' )  then  isnull(issue_amount,0) ");
		sqljob.appendSQL("when ( account_year>=091 and is_debt='Y' and bound_code = '1'  and budget_code in ('1','2') and account_type='Y' )  then  isnull(issue_amount,0) ");
		sqljob.appendSQL("else 0 end)/"+unit+"  as AA3 ,");
		//當年度舉借不列入債限	
		//sqljob.appendSQL("sum(case when ( is_debt='N' and account_type='Y' )  then isnull(issue_amount,0)  else 0 end )/"+unit+"  as AA6 ,");
		sqljob.appendSQL("sum(case when ( account_year<091 and is_debt='N' and bound_code in ('1','2')  and budget_code in ('1','2') and account_type='Y' )  then  isnull(issue_amount,0) ");
		sqljob.appendSQL("when ( account_year>=091 and is_debt='N' and bound_code = '1'  and budget_code in ('1','2') and account_type='Y' )  then  isnull(issue_amount,0) ");
		sqljob.appendSQL("else 0 end)/"+unit+"  as AA4 ");
		
		sqljob.appendSQL("from central_statistics_main ");
		if (!"".equals(myForm.getEndYear())){
			sqljob.appendSQL("where account_year between 0 and ? +0 ");
			sqljob.addParameter(myForm.getEndYear());
		}
		sqljob.appendSQL(" group by account_year");
		sqljob.appendSQL(" order by account_year ");
        System.out.println("GARA0501-SQL:"+sqljob);
 		return sqljob;
	}
	
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception{	
		/*
		 *t1當年度公債發行數額 
		 *t2當年度借款數額
		 *t3當年度舉借合計//列入債權部分
		 *t4當年度舉借合計//不列入債權部分
		 *t5當年度債務未償餘額--公債
		 *t6當年度債務未償餘額//借款、總預算及特別預算
		 *t7當年度債務未償餘額//借款、非營業基金(非自償性)
		 */
		Gara0401Form myForm = (Gara0401Form) form;
		BigDecimal unit = new BigDecimal(myForm.getAmountUnit());
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delSQLJob("GARA05_RPT",usrId));
		//執行 insert
		List queryList1 = (List) run.query(SQL1(myForm,unit), new MapListHandler());
		
		
		//取得grar33未償餘額List物件
		//List qryGara33 = (List) run.query(CommonReportSQL.Gara33SQL(myForm.getEndYear(),unit), new MapListHandler());
		//Gara33ReMainList gara33 = new Gara33ReMainList(qryGara33);
		Gara33ReMainList gara33 = new Gara33ReMainList(connection,myForm.getEndYear(),unit);
		//取得grar34未償餘額List物件
		//List qryGara34 = (List) run.query(CommonReportSQL.Gara34SQL(myForm.getEndYear(),unit), new MapListHandler());
		//Gara34ReMainList gara34 = new Gara34ReMainList(qryGara34);
		Gara34ReMainList gara34 = new Gara34ReMainList(connection,myForm.getEndYear(),unit);
		
		Map tMap = null;
		Map dMap = new HashMap();
		String accountYear="";
		String accountKind="";
		BigDecimal perGNP = new BigDecimal(0);
		//支(歲)出總額-含排除債限
		BigDecimal yearAmountKind1 = new BigDecimal(0);
		//支(歲)出總額-不含排除債限(預)
		BigDecimal yearAmountKind2AK1 = new BigDecimal(0);
		//支(歲)出總額-不含排除債限(決)
		BigDecimal yearAmountKind2AK2 = new BigDecimal(0);
//		支(歲)出總額-含排除債限(預)
		BigDecimal yearAmountKind1AK1 = new BigDecimal(0);
		//支(歲)出總額-含排除債限(決)
		BigDecimal yearAmountKind1AK2 = new BigDecimal(0);
		
		for(Iterator tIterator = queryList1.iterator(); tIterator.hasNext(); ){
			tMap = (Map) tIterator.next();
			dMap.putAll(getCommonMap(usrId));
			accountYear = (String)tMap.get("account_year");
			//設定取得gara33哪一年資料
			accountKind = getAccountKind(connection,accountYear,"'A'");
			if(Integer.parseInt(accountYear) >= new Date().getYear()-11)
				gara33.setQryMap(accountYear,"1");
			else
				gara33.setQryMap(accountYear,accountKind);
			//設定取得gara34哪一年資料
			accountKind = getAccountKind(connection,accountYear,"'C','E'");
			if(Integer.parseInt(accountYear) >= new Date().getYear()-11)
				gara34.setQryMap(accountYear,"1");
			else
				gara34.setQryMap(accountYear,accountKind);
			
			
			//年度
			dMap.put("account_year",(String)tMap.get("account_year"));
			//t1當年度公債發行數額
			dMap.put("t1",(BigDecimal)tMap.get("AA1"));
			//t2當年度借款數額
			dMap.put("t2",(BigDecimal)tMap.get("AA2"));
			//t3當年度舉借合計--列入債權部分
			dMap.put("t3",(BigDecimal)tMap.get("AA3"));
			//t4當年度舉借合計--不列入債權部分
			dMap.put("t4",(BigDecimal)tMap.get("AA4"));
			//t5當年度債務未償餘額--公債
			dMap.put("t5",gara33.getReMainTotal());
			//t6當年度債務未償餘額//借款、總預算及特別預算
			if(Integer.parseInt(accountYear)==73)
				dMap.put("t6",new BigDecimal("2433000000").divide(unit));
			else if(Integer.parseInt(accountYear)==74)
				dMap.put("t6",new BigDecimal("2008000000").divide(unit));
			else
				dMap.put("t6",gara34.getReMainTotal());
			//t7當年度債務未償餘額//借款、非營業基金(非自償性)
			dMap.put("t7",new BigDecimal(0));
			//s1借款合計
			dMap.put("s1",((BigDecimal)dMap.get("t6")).add((BigDecimal)dMap.get("t7")));
			//s2合計
			dMap.put("s2",((BigDecimal)dMap.get("s1")).add((BigDecimal)dMap.get("t5")));
			
			/*支(歲)出總額-不含排除債限
			 *user要求93年之後,請分出　預,決　的支(歲)出總額-不含排除債限
			 *93年前不分　預,決　的支(歲)出總額-不含排除債限
			 */
			dMap.put("budget_amount",this.getYearAmount(connection,(String)dMap.get("account_year"),unit,"2"));
			//支(歲)出總額-不含排除債限(預)
			yearAmountKind2AK1 = this.getYearAmountKind(connection,(String)dMap.get("account_year"),unit,"2","1");
			//支(歲)出總額-不含排除債限(決)
			yearAmountKind2AK2 = this.getYearAmountKind(connection,(String)dMap.get("account_year"),unit,"2","2");
			yearAmountKind1AK1 = this.getYearAmountKind(connection,(String)dMap.get("account_year"),unit,"1","1");
			yearAmountKind1AK2 = this.getYearAmountKind(connection,(String)dMap.get("account_year"),unit,"1","2");
			//當年度舉借數/支(歲)出總額-不含排除債限
			dMap.put("p1",this.divideCheck((BigDecimal)dMap.get("t3"),(BigDecimal)dMap.get("budget_amount")).multiply(new BigDecimal(100)));
			//支(歲)出總額-含排除債限
			yearAmountKind1 = this.getYearAmount(connection,(String)dMap.get("account_year"),unit,"1");
			//未償餘額/支(歲)出-含排除債限
			if(Integer.parseInt(accountYear)==89)
				dMap.put("p2",this.divideCheck((BigDecimal)dMap.get("s2"),yearAmountKind1).multiply(new BigDecimal(1.5)).multiply(new BigDecimal(100)));
			else
				dMap.put("p2",this.divideCheck((BigDecimal)dMap.get("s2"),yearAmountKind1).multiply(new BigDecimal(100)));
			//未償餘額/前三年度GNP
			perGNP = this.getPerGNP(connection,(String)dMap.get("account_year"),unit);
			dMap.put("perGNP_amount",this.divideCheck((BigDecimal)dMap.get("s2"),perGNP).multiply(new BigDecimal(100)));
			if (!"".equals(myForm.getStartYear())) {
				if (Integer.parseInt((String) dMap.get("account_year")) >= Integer.parseInt(myForm.getStartYear())){
					if(Integer.parseInt((String) dMap.get("account_year")) >= 93){
						dMap.put("budget_amount",yearAmountKind2AK1);
						dMap.put("p1",this.divideCheck((BigDecimal)dMap.get("t3"),(BigDecimal)dMap.get("budget_amount")).multiply(new BigDecimal(100)));
						dMap.put("p2",this.divideCheck((BigDecimal)dMap.get("s2"),yearAmountKind1AK1).multiply(new BigDecimal(100)));
						dMap.put("yearAmount_Kind","(預)");
						upNationDebitMain(accountYear , (BigDecimal)dMap.get("p1"),(BigDecimal)dMap.get("p2"));
						run.update(connection,insTemp("GARA05_RPT",dMap));
						dMap.put("budget_amount",yearAmountKind2AK2);
						dMap.put("p1",this.divideCheck((BigDecimal)dMap.get("t3"),(BigDecimal)dMap.get("budget_amount")).multiply(new BigDecimal(100)));
						dMap.put("p2",this.divideCheck((BigDecimal)dMap.get("s2"),yearAmountKind1AK2).multiply(new BigDecimal(100)));
						dMap.put("yearAmount_Kind","(決)");
						run.update(connection,insTemp("GARA05_RPT",dMap));
						
					}else{
						run.update(connection,insTemp("GARA05_RPT",dMap));
						upNationDebitMain(accountYear , (BigDecimal)dMap.get("p1"),(BigDecimal)dMap.get("p2"));
					}
				}
			}
			else{
				if(Integer.parseInt((String) dMap.get("account_year")) >= 93){
					dMap.put("budget_amount",yearAmountKind2AK1);
					dMap.put("p1",this.divideCheck((BigDecimal)dMap.get("t3"),(BigDecimal)dMap.get("budget_amount")).multiply(new BigDecimal(100)));
					dMap.put("p2",this.divideCheck((BigDecimal)dMap.get("s2"),yearAmountKind1AK1).multiply(new BigDecimal(100)));
					run.update(connection,insTemp("GARA05_RPT",dMap));
					upNationDebitMain(accountYear , (BigDecimal)dMap.get("p1"),(BigDecimal)dMap.get("p2"));
					dMap.put("budget_amount",yearAmountKind2AK2);
					dMap.put("p1",this.divideCheck((BigDecimal)dMap.get("t3"),(BigDecimal)dMap.get("budget_amount")).multiply(new BigDecimal(100)));
					dMap.put("p2",this.divideCheck((BigDecimal)dMap.get("s2"),yearAmountKind1AK2).multiply(new BigDecimal(100)));
					run.update(connection,insTemp("GARA05_RPT",dMap));
				}else{
					run.update(connection,insTemp("GARA05_RPT",dMap));
					upNationDebitMain(accountYear , (BigDecimal)dMap.get("p1"),(BigDecimal)dMap.get("p2"));
				}
			}
		}

		GaraNote garaNote = new GaraNoteManager().getGaraNote(myForm.getPath());
		garaNote.setMemo(myForm.getMemo());
		garaNote.setPath(myForm.getPath());
		new GaraNoteManager().confirm(garaNote);
		request.setAttribute("memo",garaNote.getMemo());
	}
	private void upNationDebitMain(String accountYear , BigDecimal caseRate , BigDecimal remainPayRate){
		NationDebitMain nationDebitMain = new NationDebitMain();
		nationDebitMain.setAccountYear(accountYear);
		nationDebitMain.setNationCode(NationCodeManager.get(24));
		List list = new NationDebitManager().query(nationDebitMain);
		for(Iterator it = list.iterator() ; it.hasNext() ;){
			nationDebitMain = (NationDebitMain)it.next();
			nationDebitMain.setCaseRate(caseRate);
			nationDebitMain.setRemainPayRate(remainPayRate);
			new NationDebitManager().update(nationDebitMain.getId(), nationDebitMain);
		}
	}
}