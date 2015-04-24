/* DIRA0401.java 報表
 程式目的：DIRA0401
 程式代號：DIRA0401
 程式日期：0950308
 程式作者：Eric.Chen
 ////////////////////////////////////////////////////////
 修改作者　　修改日期　　　修改目的
 ////////////////////////////////////////////////////////
 */
package tw.gov.nta.surplusage.action;

import gov.dnt.tame.common.ExcelReportRemainAction;
import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.Numeral2Chinese;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.sql.debt.GaraNote;
import tw.gov.nta.surplusage.common.Gara30ReMainList;
import tw.gov.nta.surplusage.common.Gara33ReMainList;
import tw.gov.nta.surplusage.common.Gara34ReMainList;
import tw.gov.nta.surplusage.common.GaraNoteManager;
import tw.gov.nta.surplusage.form.Gara2501Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLRunner;

public class GARA2501 extends ExcelReportRemainAction {
	/*
	protected SQLJob SQL1(String sYear , String eYear , BigDecimal unit){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select ");
		//第一個區間年度
		if (sYear.equals(eYear))
			sqljob.appendSQL("'"+eYear+"'+'年度' as Item,"); 
		else
			sqljob.appendSQL("'"+sYear+"'+'-'+'"+eYear+"'+'年度' as Item,"); 
		
		        //公債發行、 總預算、 甲種 =>舉借額數     
		sqljob.appendSQL("sum(case when ( debt_type = 'A' and budget_code='1' and bound_code ='1'  and is_account='N' and account_type='Y' )  then  isnull(issue_amount,0) else 0 end)/"+unit+" as AA1 ,");
			//公債發行、特別預算、甲類、非十大建設=>舉借額數" 
		sqljob.appendSQL("sum(case when ( debt_type = 'A' and budget_code='2' and bound_code ='1'  and is_account='N' and account_type='Y' )  then  isnull(issue_amount,0) else 0 end)/"+unit+"  as AA2 ,");
			//公債發行、特別預算、乙類、非十大建設=>舉借額數
		sqljob.appendSQL("sum(case when ( debt_type = 'A' and budget_code='2' and bound_code ='2'  and is_account='N' and account_type='Y' )  then  isnull(issue_amount,0) else 0 end)/"+unit+"  as AA3 ,");
			//公債發行、特別預算、十大建設=>舉借額數
		sqljob.appendSQL("sum(case when ( debt_type = 'A' and budget_code='2'   and is_account='Y'  and account_type='Y' )  then  isnull(issue_amount,0) else 0 end)/"+unit+"  as AA4 ,");
			//公債發行、債務基金=>舉借額數
		sqljob.appendSQL("sum(case when ( debt_type = 'A' and budget_code='3' and account_type='Y')  then  isnull(issue_amount,0)  else 0 end )/"+unit+"  as AA5 ,");
			//賒借、非債務基金、甲類、非十大建設=>舉借額數
		sqljob.appendSQL("sum(case when ( debt_type in ('C','E') and  budget_code<>'3' and bound_code ='1'  and is_account='N' and account_type='Y' )  then isnull(issue_amount,0)  else 0 end )/"+unit+"  as AB1 ,");
			//賒借、非債務基金、乙類、非十大建設=>舉借額數
		sqljob.appendSQL("sum(case when ( debt_type in ('C','E')  and budget_code<>'3' and  bound_code ='2'  and is_account='N'  and account_type='Y')  then  isnull(issue_amount,0)  else 0 end )/"+unit+"  as AB2 ,");
			//賒借、非債務基金、十大建設=>舉借額數
		sqljob.appendSQL("sum(case when ( debt_type in ('C','E')  and budget_code<>'3' and is_account='Y'  and account_type='Y')  then  isnull(issue_amount,0)  else 0 end )/"+unit+"  as AB3 ,");
			//賒借、債務基金=>舉借額數
		sqljob.appendSQL("sum(case when ( debt_type in ('C','E')  and budget_code='3'  and account_type='Y')  then  isnull(issue_amount,0)  else 0 end )/"+unit+"  as AB4 ,");


		        //公債還本、 總預算、 甲種 =>舉借額數  
		sqljob.appendSQL("sum(case when ( debt_type = 'A' and budget_code='1' and bound_code ='1'  and is_account='N' and account_type='Y' )  then  isnull(issue_amount,0) else 0 end)/"+unit+"");
		sqljob.appendSQL("-   ");
		sqljob.appendSQL("sum(case when ( debt_type = 'A' and budget_code='1' and bound_code ='1'  and is_account='N' and account_type='Y' )  then  isnull(pay_amount,0) else 0 end)/"+unit+"");      
		sqljob.appendSQL("+");
			
			//公債還本、特別預算、甲類、非十大建設=>舉借額數" 
		sqljob.appendSQL("sum(case when ( debt_type = 'A' and budget_code='2' and bound_code ='1'  and is_account='N' and account_type='Y' )  then  isnull(issue_amount,0) else 0 end)/"+unit+"");
		sqljob.appendSQL("-");
		sqljob.appendSQL("sum(case when ( debt_type = 'A' and budget_code='2' and bound_code ='1'  and is_account='N' and account_type='Y' )  then  isnull(pay_amount,0) else 0 end)/"+unit+"  ");
			
		sqljob.appendSQL("+");
			//賒借、非債務基金、甲類、非十大建設=>舉借額數
		sqljob.appendSQL("sum(case when ( debt_type in ('C','E') and  budget_code<>'3' and bound_code ='1'  and is_account='N' and account_type='Y' )  then isnull(issue_amount,0)  else 0 end )/"+unit+"");   
		sqljob.appendSQL("-");
		sqljob.appendSQL("sum(case when ( debt_type in ('C','E') and  budget_code<>'3' and bound_code ='1'  and is_account='N' and account_type='Y' )  then isnull(pay_amount,0)  else 0 end )/"+unit+"  as RA1 ,");
			

			//公債還本、特別預算、乙類、非十大建設=>舉借額數
		sqljob.appendSQL("sum(case when ( debt_type = 'A' and budget_code='2' and bound_code ='2'  and is_account='N' and account_type='Y' )  then  isnull(issue_amount,0) else 0 end)/"+unit+"");
		sqljob.appendSQL("-");
		sqljob.appendSQL("sum(case when ( debt_type = 'A' and budget_code='2' and bound_code ='2'  and is_account='N' and account_type='Y' )  then  isnull(pay_amount,0) else 0 end)/"+unit+"");  
			
		sqljob.appendSQL("+");
			
			//賒借、非債務基金、乙類、非十大建設=>舉借額數
		sqljob.appendSQL("sum(case when ( debt_type in ('C','E')  and budget_code<>'3' and  bound_code ='2'  and is_account='N'  and account_type='Y')  then  isnull(issue_amount,0)  else 0 end )/"+unit+"");   
		sqljob.appendSQL("-");
		sqljob.appendSQL("sum(case when ( debt_type in ('C','E')  and budget_code<>'3' and  bound_code ='2'  and is_account='N'  and account_type='Y')  then  isnull(pay_amount,0)  else 0 end )/"+unit+"  as RA2 ,");
			


			//公債還本、特別預算、十大建設=>舉借額數
		sqljob.appendSQL("sum(case when ( debt_type = 'A' and budget_code='2'   and is_account='Y'  and account_type='Y' )  then  isnull(issue_amount,0) else 0 end)/"+unit+"");
		sqljob.appendSQL("-");
		sqljob.appendSQL("sum(case when ( debt_type = 'A' and budget_code='2'   and is_account='Y'  and account_type='Y' )  then  isnull(pay_amount,0) else 0 end)/"+unit+"  as RA3 ,");
			
		sqljob.appendSQL("+");
			
			//賒借、非債務基金、十大建設=>舉借額數
		sqljob.appendSQL("sum(case when ( debt_type in ('C','E')  and budget_code<>'3' and is_account='Y'  and account_type='Y')  then  isnull(issue_amount,0)  else 0 end )/"+unit+"");   
		sqljob.appendSQL("-");
		sqljob.appendSQL("sum(case when ( debt_type in ('C','E')  and budget_code<>'3' and is_account='Y'  and account_type='Y')  then  isnull(pay_amount,0)  else 0 end )/"+unit+"  as RA4 ,");
			


			//公債還本、債務基金=>舉借額數
		sqljob.appendSQL("sum(case when ( debt_type = 'A' and budget_code='3' and account_type='Y')  then  isnull(issue_amount,0)  else 0 end )/"+unit+"");
		sqljob.appendSQL("-");
		sqljob.appendSQL("sum(case when ( debt_type = 'A' and budget_code='3' and account_type='Y')  then  isnull(pay_amount,0)  else 0 end )/"+unit+"  as RA5 ,");
			
		sqljob.appendSQL("+");
			
			//賒借、債務基金=>舉借額數
		sqljob.appendSQL("sum(case when ( debt_type in ('C','E')  and budget_code='3'  and account_type='Y')  then  isnull(issue_amount,0)  else 0 end )/"+unit+"");   
		sqljob.appendSQL("-");
		sqljob.appendSQL("sum(case when ( debt_type in ('C','E')  and budget_code='3'  and account_type='Y')  then  isnull(pay_amount,0)  else 0 end )/"+unit+"  as RA6"); 
		sqljob.appendSQL("from central_statistics_main ");
		sqljob.appendSQL("where   account_year>='"+sYear+"' ");//第一個區間年度起
		sqljob.appendSQL("and account_year<='"+eYear+"' ");//第一個區間年度迄
		System.out.println(sqljob.toString());
		return sqljob;
	}
	*/
	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		Gara2501Form myForm = (Gara2501Form) form;
		GaraNote garaNote = new GaraNoteManager().getGaraNote(myForm.getPath());
		garaNote.setMemo(myForm.getMemo());
		garaNote.setPath(myForm.getPath());
		new GaraNoteManager().confirm(garaNote);
		request.setAttribute("memo",garaNote.getMemo());
		
		BigDecimal unit = new BigDecimal(myForm.getAmountUnit());
		String [][] year = {
							{myForm.getAccountSyear1(),myForm.getAccountEyear1()},
							{myForm.getAccountSyear2(),myForm.getAccountEyear2()},
							{myForm.getAccountSyear3(),myForm.getAccountEyear3()},
							{myForm.getAccountSyear4(),myForm.getAccountEyear4()},
							{myForm.getAccountSyear5(),myForm.getAccountEyear5()},
							};
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delSQLJob("GARA25_RPT",usrId));
		//執行 insert
		
		//取得今年年度
		String thisYear = DateUtil.date2ROCStr(new Date()).substring(0,3);
		//取得grar33未償餘額List物件
		//List qryGara33 = (List) run.query(CommonReportSQL.Gara33SQL(thisYear,unit), new MapListHandler());
		//Gara33ReMainList gara33 = new Gara33ReMainList(qryGara33);
		//Gara33ReMainList gara33 = new Gara33ReMainList(connection,thisYear,unit,"0");
		//取得grar34未償餘額List物件
		//List qryGara34 = (List) run.query(CommonReportSQL.Gara34SQL(thisYear,unit), new MapListHandler());
		//Gara34ReMainList gara34 = new Gara34ReMainList(qryGara34);	
		//Gara34ReMainList gara34 = new Gara34ReMainList(connection,thisYear,unit,"0");
		Gara30ReMainList gara30 = new Gara30ReMainList(connection,thisYear,unit);
		BigDecimal sum1 = new BigDecimal(0);
		BigDecimal sum2 = new BigDecimal(0);
		BigDecimal sum3 = new BigDecimal(0);
		//累計公債發行暫存陣列
		BigDecimal[] amountAA = {new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),
								new BigDecimal(0),new BigDecimal(0)};
		//累計賒借暫存陣列
		BigDecimal[] amountAB = {new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0)};
		
		String sYear = "";
		String eYear = "";
		String accountKind = "";
		Map tMap = new HashMap();
		for (int i = 0 ; i < 5 ; i++){
			sYear = year[i][0];
			eYear = year[i][1];
			if (!"".equals(sYear) && !"".equals(eYear)) {
				sum1=new BigDecimal(0);
				sum2=new BigDecimal(0);
				sum3=new BigDecimal(0);
				tMap = new HashMap();
				
				tMap.putAll(getCommonMap(usrId));
				
				//年度
				if (year[i][0].equals(year[i][1]))
					tMap.put("Item",String.valueOf(sYear)+"年度               "+"("+(i+1)+")"); 
				else
					tMap.put("Item",String.valueOf(sYear)+"-"+String.valueOf(eYear)+"年度                  "+"("+(i+1)+")"); 
				
				//清空累計陣列
//				for (int AA = 0 ; AA < amountAA.length ; AA++){
//					amountAA;
//				}
//				for (int AB = 0 ; AB < amountAB.length ; AB++){
//					amountAA[AB]=new BigDecimal(0);
//				}
				Arrays.fill(amountAA, new BigDecimal(0)); 
				Arrays.fill(amountAB, new BigDecimal(0)); 
				//計算各舉借數額累計金額
				for (int j = Integer.parseInt(sYear); j <= Integer.parseInt(eYear); j++){
					//設定取得gara33哪一年資料
					accountKind = getAccountKind(connection,this.getStrYear(String.valueOf(j)),"'A'");
					gara30.setQryMap(this.getStrYear(String.valueOf(j)),accountKind);
					//設定取得gara34哪一年資料
					accountKind = getAccountKind(connection,this.getStrYear(String.valueOf(j)),"'C','E'");
					gara30.setQryMap(this.getStrYear(String.valueOf(j)),accountKind);
					amountAA[0] = amountAA[0].add(gara30.getIssueFieldA(1));
					if( j < 91)
						amountAA[1] = amountAA[1].add(gara30.getIssueFieldA(2));
					else
						amountAA[1] = amountAA[1].add(new BigDecimal(0));
					System.out.println(j+"===="+amountAA[1]);
					amountAA[2] = amountAA[2].add(gara30.getIssueFieldA(3));
					amountAA[3] = amountAA[3].add(gara30.getIssueFieldA(4));
					amountAA[4] = amountAA[4].add(gara30.getIssueFieldA(5));
					
					amountAB[0] = amountAB[0].add(gara30.getIssueFieldA(10)).add(gara30.getIssueFieldA(14));
					if(j<91)
						amountAB[1] = amountAB[1].add(gara30.getIssueFieldA(11));
					else
						amountAB[1] = amountAB[1].add(new BigDecimal(0));
						
					System.out.println(sYear+"===="+amountAB[1]);
					amountAB[2] = amountAB[2].add(gara30.getIssueFieldA(12));
					amountAB[3] = amountAB[3].add(gara30.getIssueFieldA(13));
				}
				//將各公債累計金額放入tMap並計算總計
				for (int j = 1 ; j < 6 ; j++){
					tMap.put("AA"+String.valueOf(j),amountAA[j-1]);
					sum1 = sum1.add((BigDecimal)tMap.get("AA"+String.valueOf(j)));
				}
				tMap.put("sum1",sum1);
				//將各賒借累計金額放入tMap並計算總計
				for (int k = 1 ; k < 5 ; k++){
					tMap.put("AB"+String.valueOf(k),amountAB[k-1]);
					sum2 = sum2.add((BigDecimal)tMap.get("AB"+String.valueOf(k)));
				}
				tMap.put("sum2",sum2);
				tMap.put("total",sum1.add(sum2));
				
				//設定取得gara33哪一年資料
				accountKind = getAccountKind(connection,this.getStrYear(eYear),"'A'");
				gara30.setQryMap(this.getStrYear(eYear),accountKind);
				//設定取得gara34哪一年資料
				accountKind = getAccountKind(connection,this.getStrYear(eYear),"'C','E'");
				gara30.setQryMap(this.getStrYear(eYear),accountKind);
				tMap.put("RA1",gara30.getReMainField(1).add(gara30.getReMainField(2)).add(gara30.getReMainField(10)));
				if(Integer.parseInt(eYear)>=91)
					tMap.put("RA2",new BigDecimal(0));
				else
					tMap.put("RA2",gara30.getReMainField(3).add(gara30.getReMainField(11)));
				tMap.put("RA3",gara30.getReMainField(6).add(gara30.getReMainField(14)));
				tMap.put("RA4",gara30.getReMainField(4).add(gara30.getReMainField(12)));
				tMap.put("RA5",gara30.getReMainField(5).add(gara30.getReMainField(13)));
				tMap.put("RA6",gara30.getReMainField(7).add(gara30.getReMainField(15)));
				
				for (int h = 1 ; h < 7 ; h++){
					sum3 = sum3.add((BigDecimal)tMap.get("RA"+String.valueOf(h)));
				}
				tMap.put("sum3",sum3);
				
				run.update(connection,insTemp("GARA25_RPT",tMap));
			}
		}
	}
}
