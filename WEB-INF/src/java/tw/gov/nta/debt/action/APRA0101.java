/* APRA0101.java 報表
 程式目的：APRA01
 程式代號：APRA01
 程式日期：0950308
 程式作者：Eric.Chen
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
 --------------------------------------------------------
 */
package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Apra0101Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class APRA0101 extends DefaultAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM APRA01_RPT ");
//		System.out.println(sqljob.toString());
		return sqljob;
	}

	protected SQLJob insTemp(ActionForm form,String usrId,Map map){
		//Apra0101Form apra0101form = (Apra0101Form) form;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO APRA01_RPT ");
		sqljob.appendSQL(" ( ");
		sqljob.appendSQL(" USRID, MOD_DATE, DUE_DATE, ");
		sqljob.appendSQL(" DEBT_NAME, CAPITAL_SERIAL ,");
		sqljob.appendSQL(" INTEREST_SERIAL, ");
		sqljob.appendSQL(" CAPITAL_AMOUNT, INTEREST_AMOUNT, FEE_AMOUNT");
		if(null!=map.get("ADVANCE_REPAY_DATE"))
			sqljob.appendSQL(", ADVANCE_REPAY_DATE");
		sqljob.appendSQL(", advance_capital_amount");
		sqljob.appendSQL(", advance_interest_amount");
		sqljob.appendSQL(", advance_FEE_amount");
		sqljob.appendSQL(", payable_interest_amount");		
		sqljob.appendSQL(" ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?");
		if(null!=map.get("ADVANCE_REPAY_DATE"))
			sqljob.appendSQL(",?");
		sqljob.appendSQL(", ?");
		sqljob.appendSQL(", ?");
		sqljob.appendSQL(", ?");
		sqljob.appendSQL(")");
		sqljob.addParameter(usrId);
		sqljob.addParameter(new Date());
		sqljob.addParameter(map.get("repay_date"));
		sqljob.addParameter(map.get("debt_name"));
		sqljob.addParameter(map.get("capital_serial"));
		sqljob.addParameter(map.get("interest_serial"));
		sqljob.addParameter(map.get("capital_amount"));
		sqljob.addParameter(map.get("interest_amount"));
		sqljob.addParameter(map.get("charge_amount"));
		if(null!=map.get("ADVANCE_REPAY_DATE"))
			sqljob.addParameter(map.get("ADVANCE_REPAY_DATE"));
		sqljob.addParameter(null!=map.get("advance_capital_amount")?map.get("advance_capital_amount"):"0");
		sqljob.addParameter(null!=map.get("advance_interest_amount")?map.get("advance_interest_amount"):"0");
		sqljob.addParameter(null!=map.get("advance_FEE_amount")?map.get("advance_FEE_amount"):"0");
		sqljob.addParameter(null!=map.get("payable_interest_amount")?map.get("payable_interest_amount"):"0");
//		System.out.println(sqljob.toString());
		return sqljob;
	}
	
	protected SQLJob debitNameSQL(Integer issueID){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select (select debit_name from debit_ref where id = debt_code) as debit_name from debt_main where issue_id = ?");
		sqljob.addParameter(issueID);
		return sqljob;
	}
	
	protected SQLJob sqlTemp(ActionForm form){
		Apra0101Form apra0101form = (Apra0101Form) form;
		SQLJob sqljob = new SQLJob();
		
		sqljob.appendSQL("SELECT ");
		sqljob.appendSQL("I.ACCOUNT_YEAR,");
		sqljob.appendSQL("I.SERIAL_NO,");
		sqljob.appendSQL("P.REPAY_DATE-1 as REPAY_DATE,");
		sqljob.appendSQL("I.BOND_TYPE,");
		sqljob.appendSQL("I.DEBT_NAME,");
		sqljob.appendSQL("max(P.CAPITAL_SERIAL) AS CAPITAL_SERIAL,");
		sqljob.appendSQL("max(P.INTEREST_SERIAL) AS INTEREST_SERIAL, ");
		sqljob.appendSQL("SUM(P.CAPITAL_AMOUNT) AS CAPITAL_AMOUNT , ");
		sqljob.appendSQL("SUM(P.INTEREST_AMOUNT) AS INTEREST_AMOUNT ," );
		//20090901 將手續費利率調降為0.0075
		sqljob.appendSQL("case when P.REPAY_DATE < '2009-09-01' then ");
		sqljob.appendSQL("(SUM(P.CAPITAL_AMOUNT)+SUM(P.INTEREST_AMOUNT))*0.0009 ");
		sqljob.appendSQL("else (SUM(P.CAPITAL_AMOUNT)+SUM(P.INTEREST_AMOUNT))*0.00075 end AS CHARGE_AMOUNT , ");
		//20100407公債提前買回，加入ISSUE_MAIN.ID
		sqljob.appendSQL("I.ID AS ISSUE_ID, ");
		sqljob.appendSQL("(case when max(P.INTEREST_SERIAL) = 1 then (case when I.payable_interest_amount is null then 0 else I.payable_interest_amount end) else 0 end) as payable_interest_amount");
		sqljob.appendSQL("FROM ISSUE_MAIN I, DEBT_MAIN D,DEBT_PLAN_DET P");
		sqljob.appendSQL("WHERE I.id=D.ISSUE_ID AND D.ID=P.DEBT_ID AND I.DEBT_TYPE='A' ");
		
		if( null != apra0101form.getRepaySdate()){
			sqljob.appendSQL("AND P.REPAY_DATE-1 >= ? ");
			sqljob.addParameter(apra0101form.getRepaySdate());
		}
		if( null != apra0101form.getRepayEdate()){
			sqljob.appendSQL("AND P.REPAY_DATE-1 <= ? ");
			sqljob.addParameter(apra0101form.getRepayEdate());
		}
		if( null != apra0101form.getBudgetCode() && !"".equals(apra0101form.getBudgetCode()) ){
			sqljob.appendSQL("AND D.BUDGET_CODE=? ");
			sqljob.addParameter(apra0101form.getBudgetCode());
		}
		if(null != apra0101form.getDebtCode() && !"".equals(apra0101form.getDebtCode())){
			sqljob.appendSQL("AND D.DEBT_CODE=? ");
			sqljob.addParameter(apra0101form.getDebtCode());
		}
		if(null != apra0101form.getBondType() && !"".equals(apra0101form.getBondType())){
			sqljob.appendSQL("AND I.BOND_TYPE=? ");
			sqljob.addParameter(apra0101form.getBondType());
		}
//		//20120306 去除已還本之公債 chris Wu
//		sqljob.appendSQL(" and (select sum(capital_amount) from payment_main where ISSUE_ID = i.id and repay_date < ?) < i.ISSUE_AMOUNT");
//		sqljob.addParameter(apra0101form.getRepaySdate());
		//20091021 chrisWu
		sqljob.appendSQLCondition(" P.delete_mark <> 'Y' ");
		sqljob.appendSQL("GROUP BY P.REPAY_DATE,I.DEBT_NAME,I.ACCOUNT_YEAR,I.SERIAL_NO,I.BOND_TYPE,I.ID,I.payable_interest_amount ");
		sqljob.appendSQL("ORDER BY P.REPAY_DATE,I.ACCOUNT_YEAR,I.SERIAL_NO,5 ");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	
	protected SQLJob sqlPayment(String issueId, String repayDate){
		SQLJob sqljob = new SQLJob();
		
		sqljob.appendSQL("SELECT REPAY_DATE AS ADVANCE_REPAY_DATE, CAPITAL_AMOUNT, INTEREST_AMOUNT as INTEREST_AMOUNT, ");
		sqljob.appendSQL("'1.'+convert(varchar,CAPITAL_SERIAL) as CAPITAL_SERIAL,");
		sqljob.appendSQL("convert(varchar,interest_serial)+'.'+convert(varchar,CAPITAL_SERIAL) as INTEREST_SERIAL, ");
		sqljob.appendSQL("case when REPAY_DATE < '2009-09-01' then (SUM(CAPITAL_AMOUNT)+SUM(INTEREST_AMOUNT))*0.0009 ");
		sqljob.appendSQL("else (SUM(CAPITAL_AMOUNT)+SUM(INTEREST_AMOUNT))*0.00075 end AS CHARGE_AMOUNT ");
		sqljob.appendSQL("FROM PAYMENT_MAIN ");
		sqljob.appendSQL("WHERE ISSUE_ID = ? ");
		sqljob.appendSQL("and REPAY_DATE <> PLAN_REPAY_DATE ");
		sqljob.appendSQL("and CAPITAL_AMOUNT > 0 ");
		sqljob.appendSQL("and REPAY_DATE < ? ");
		sqljob.appendSQL("and 'Y' <> (select d.delete_mark from debt_plan_det d where d.id = plan_id)");
		//20120306 去除已還本之公債 chris Wu
//		sqljob.appendSQL(" and (select sum(capital_amount) from PAYMENT_MAIN where issue_id = ?) < (select issue_amount from issue_main where id = ?)");
		sqljob.appendSQL("GROUP BY REPAY_DATE, CAPITAL_AMOUNT, INTEREST_AMOUNT, CAPITAL_SERIAL, INTEREST_SERIAL");

		sqljob.addParameter(issueId);
		sqljob.addParameter(repayDate);
//		sqljob.addParameter(issueId);
//		sqljob.addParameter(issueId);
//		System.out.println(issueId);
//		System.out.println(sqljob.toString());
		return sqljob;
	}
	
	protected SQLJob sqlPayment2(Date repaySdate, Date repayEdate){
		SQLJob sqljob = new SQLJob();
		
		sqljob.appendSQL("SELECT I.ACCOUNT_YEAR, I.SERIAL_NO, I.DUE_DATE AS REPAY_DATE, P.REPAY_DATE as ADVANCE_REPAY_DATE, ");
		sqljob.appendSQL("I.BOND_TYPE, I.DEBT_NAME, ");
		sqljob.appendSQL("(select debit_name from debit_ref where id = d.debt_code) as debit_name, ");
		sqljob.appendSQL("'1.'+convert(varchar,CAPITAL_SERIAL) as CAPITAL_SERIAL, ");
		sqljob.appendSQL("convert(varchar,p.interest_serial)+'.'+convert(varchar,p.CAPITAL_SERIAL) as interest_serial, ");
		sqljob.appendSQL("SUM(P.CAPITAL_AMOUNT) AS CAPITAL_AMOUNT, ");
		sqljob.appendSQL("SUM(P.INTEREST_AMOUNT) AS INTEREST_AMOUNT , ");
		sqljob.appendSQL("case when P.REPAY_DATE < '2009-09-01' then (SUM(P.CAPITAL_AMOUNT)+SUM(P.INTEREST_AMOUNT))*0.0009 ");
		sqljob.appendSQL("else (SUM(P.CAPITAL_AMOUNT)+SUM(P.INTEREST_AMOUNT))*0.00075 end AS CHARGE_AMOUNT , I.ID AS ISSUE_ID, ");
		sqljob.appendSQL("(case when max(P.INTEREST_SERIAL) = 1 then (case when I.payable_interest_amount is null then 0 else I.payable_interest_amount end) else 0 end) as payable_interest_amount");
		sqljob.appendSQL("FROM ISSUE_MAIN I, DEBT_MAIN D,payment_main P ");
		sqljob.appendSQL("WHERE I.id=D.ISSUE_ID AND D.ID=P.DEBT_ID AND I.DEBT_TYPE='A' ");
		sqljob.appendSQL("AND P.REPAY_DATE >= ? AND P.REPAY_DATE <= ? ");
		sqljob.appendSQL("and  P.REPAY_DATE <> P.PLAN_REPAY_DATE ");
		//20120306 去除已還本之公債 chris Wu
//		sqljob.appendSQL(" and (select sum(capital_amount) from payment_main where ISSUE_ID = i.id) < i.ISSUE_AMOUNT");
		sqljob.appendSQL("GROUP BY p.interest_serial,p.CAPITAL_SERIAL,P.REPAY_DATE,I.DEBT_NAME,I.ACCOUNT_YEAR,I.SERIAL_NO,d.debt_code,I.BOND_TYPE,I.ID,I.DUE_DATE,I.payable_interest_amount ");
		sqljob.appendSQL("ORDER BY P.REPAY_DATE,I.ACCOUNT_YEAR,I.SERIAL_NO ");
		
		sqljob.addParameter(repaySdate);
		sqljob.addParameter(repayEdate);
//		System.out.println(sqljob.toString());
		return sqljob;
	}
	
	
	@SuppressWarnings("deprecation")
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		Apra0101Form myForm = (Apra0101Form) form;
		String usrId = this.getUserId(request);
		SQLRunner run = new ConnectionSQLRunner(connection);
		run.update(connection,delTemp(form,usrId));
		List listAll = (List) run.query(sqlTemp(form), new MapListHandler()); 
		
		String sDate = DateUtil.date2ROCStr(new Date());
		String eDate = DateUtil.date2ROCStr(new Date());
		if( null != myForm.getRepaySdate())
			sDate = DateUtil.date2ROCStr(myForm.getRepaySdate());
		
		if( null != myForm.getRepayEdate())
			eDate = DateUtil.date2ROCStr(myForm.getRepayEdate());
		
		//判斷當月是否有資料的flag
		boolean isMonthDate = false;
		
		//1~12月
		String checkMonth[] = {"01","02","03","04","05","06","07","08","09","10","11","12"};
		
		//暫存查詢資料的repay_date
		String repayDate = "";
		
		//查詢的開始年度和結束年度
		int sYear = Integer.parseInt(sDate.substring(0,3));
		int eYear = Integer.parseInt(eDate.substring(0,3));
		
		
		//小計及合計
		BigDecimal capitalAmount = new BigDecimal(0);
		BigDecimal interestAmount = new BigDecimal(0);
		BigDecimal feeAmount = new BigDecimal(0);
		BigDecimal tCapitalAmount = new BigDecimal(0);
		BigDecimal tInterestAmount = new BigDecimal(0);
		BigDecimal tFeeAmount = new BigDecimal(0);
		BigDecimal advancecapitalAmount = new BigDecimal(0);
		BigDecimal advanceinterestAmount = new BigDecimal(0);
		BigDecimal advancefeeAmount = new BigDecimal(0);
		BigDecimal advancetCapitalAmount = new BigDecimal(0);
		BigDecimal advancetInterestAmount = new BigDecimal(0);
		BigDecimal advancetFeeAmount = new BigDecimal(0);
		BigDecimal payableInterestAmount = new BigDecimal(0);
		BigDecimal tPayableInterestAmount = new BigDecimal(0);
		
		for (int i=sYear ; i <= eYear ; i++){
			for (int j=0 ; j < checkMonth.length ; j++){
				//  String.valueOf(i+j) between sDate.substring(0,5) and eDate.substring(0,5)
				if (Integer.parseInt(String.valueOf(i)+checkMonth[j])>=Integer.parseInt(sDate.substring(0,5))
						&& Integer.parseInt(String.valueOf(i)+checkMonth[j])<=Integer.parseInt(eDate.substring(0,5))){
					
					//預設當月無資料
					isMonthDate = false;
					
					//小計開始為0
					capitalAmount = new BigDecimal(0);
					interestAmount = new BigDecimal(0);
					feeAmount = new BigDecimal(0);
					advancecapitalAmount = new BigDecimal(0);
					advanceinterestAmount = new BigDecimal(0);
					advancefeeAmount = new BigDecimal(0);
					payableInterestAmount = new BigDecimal(0);
					
					String debtName = "";
					//統計全部資料符合repay_date.yearMonth = String "i & checkMonth[j]"
					for(Iterator it = listAll.iterator();it.hasNext();){
						Map map = (Map)it.next();
						repayDate = DateUtil.date2ROCStr((Date)map.get("repay_date"));
						
						if (Integer.parseInt(repayDate.substring(0,5)) == Integer.parseInt(String.valueOf(i)+checkMonth[j])){
							
							//如果遇到有相同公債名稱時，將名稱改為"公債名稱-公債簡稱"
							debtName = (String)map.get("DEBT_NAME");
							//20090909 修改為，只要是乙類就顯示為"公債名稱-公債簡稱"
							if ("2".equals((String)map.get("BOND_TYPE"))){
								List debitNameList = (List)run.query(debitNameSQL((Integer)map.get("ISSUE_ID")), new MapListHandler());
								Map debitNameMap = (Map)debitNameList.get(0);
								map.put("DEBT_NAME",(String)map.get("DEBT_NAME")+"-"+(String)debitNameMap.get("debit_name"));
							}
							
							isMonthDate = true;
							//查尋payment中是否有提前買回的資料
							List listPayment = null;
							List listPayment2 = null;
							if("1".equals(myForm.getDisplay())){
								listPayment = (List) run.query(sqlPayment(map.get("ISSUE_ID").toString(),map.get("REPAY_DATE").toString()), new MapListHandler());
							}else{
								listPayment2 = (List) run.query(sqlPayment(map.get("ISSUE_ID").toString(),map.get("REPAY_DATE").toString()), new MapListHandler());
							}
							if(null != listPayment && !listPayment.isEmpty()){
								BigDecimal rCapitalAmount = new BigDecimal("0");
								BigDecimal rInterestAmount = new BigDecimal("0");
								BigDecimal rChargeAmount = new BigDecimal("0");
								for(Iterator itPayment = listPayment.iterator();itPayment.hasNext();){
									Map mapPayment = (Map)itPayment.next();
									rCapitalAmount = rCapitalAmount.add((BigDecimal)mapPayment.get("capital_amount"));
									rInterestAmount = rInterestAmount.add((BigDecimal)mapPayment.get("interest_amount"));
									rChargeAmount = rChargeAmount.add((BigDecimal)mapPayment.get("charge_amount"));
								}
								BigDecimal xCapitalAmount = (BigDecimal)map.get("capital_amount");
								BigDecimal xInterestAmount = (BigDecimal)map.get("interest_amount");
								BigDecimal xChargeAmount = (BigDecimal)map.get("charge_amount");
								map.put("capital_amount",xCapitalAmount.subtract(rCapitalAmount));
								map.put("interest_amount",xInterestAmount.subtract(rInterestAmount));
								map.put("charge_amount",xChargeAmount.subtract(rChargeAmount));
							}
							if(null != listPayment2 && !listPayment2.isEmpty()){
								BigDecimal rCapitalAmount = new BigDecimal("0");
								BigDecimal rInterestAmount = new BigDecimal("0");
								BigDecimal rChargeAmount = new BigDecimal("0");
								for(Iterator itPayment = listPayment2.iterator();itPayment.hasNext();){
									Map mapPayment = (Map)itPayment.next();
									rCapitalAmount = rCapitalAmount.add((BigDecimal)mapPayment.get("capital_amount"));
									rInterestAmount = rInterestAmount.add((BigDecimal)mapPayment.get("interest_amount"));
									rChargeAmount = rChargeAmount.add((BigDecimal)mapPayment.get("charge_amount"));
								}
								BigDecimal xCapitalAmount = (BigDecimal)map.get("capital_amount");
								BigDecimal xInterestAmount = (BigDecimal)map.get("interest_amount");
								BigDecimal xChargeAmount = (BigDecimal)map.get("charge_amount");
								map.put("capital_amount",xCapitalAmount.subtract(rCapitalAmount));
								map.put("interest_amount",xInterestAmount.subtract(rInterestAmount));
								map.put("charge_amount",xChargeAmount.subtract(rChargeAmount));
							}
							//小計計算
							capitalAmount = capitalAmount.add((BigDecimal)map.get("capital_amount"));
							interestAmount = interestAmount.add((BigDecimal)map.get("interest_amount"));
							feeAmount = feeAmount.add((BigDecimal)map.get("charge_amount"));	
							payableInterestAmount = payableInterestAmount.add((BigDecimal)map.get("payable_interest_amount"));
							run.update(connection,insTemp(form,usrId,map));
							if(null != listPayment && !listPayment.isEmpty())
							{
								for(Iterator itPayment = listPayment.iterator();itPayment.hasNext();){
									Map mapPayment = (Map)itPayment.next();
									map.put("ADVANCE_REPAY_DATE",DateUtil.date2ROCStr((Date)mapPayment.get("ADVANCE_REPAY_DATE"),"yyy/MM/dd"));
									
									//小計計算
									String capitalSerial = (String)mapPayment.get("CAPITAL_SERIAL");
									map.put("capital_amount",0);
									map.put("interest_amount",0);
									map.put("charge_amount",0);
									map.put("advance_capital_amount",(BigDecimal)mapPayment.get("capital_amount"));	
									map.put("advance_interest_amount",(BigDecimal)mapPayment.get("interest_amount"));	
									map.put("advance_FEE_amount",(BigDecimal)mapPayment.get("charge_amount"));
									map.put("CAPITAL_SERIAL",capitalSerial.trim());
									map.put("INTEREST_SERIAL",mapPayment.get("INTEREST_SERIAL"));
									advancecapitalAmount = advancecapitalAmount.add((BigDecimal)mapPayment.get("capital_amount"));
									advanceinterestAmount = advanceinterestAmount.add((BigDecimal)mapPayment.get("interest_amount"));
									advancefeeAmount = advancefeeAmount.add((BigDecimal)mapPayment.get("charge_amount"));
									run.update(connection,insTemp(form,usrId,map));
								}
							}
						}
					}
					String year = String.valueOf(i);
					String sPayDate = year+checkMonth[j]+"01";
					String ePayDate = DateUtil.getLastDateOfMonth(year,checkMonth[j]);
					if(sPayDate.length() < 7)
						sPayDate = "0"+sPayDate;
					if(ePayDate.length() < 7)
						ePayDate = "0"+ePayDate;
					List listAll2 = null;
					if("1".equals(myForm.getDisplay()))
						listAll2 = (List) run.query(sqlPayment2(DateUtil.str2Date(sPayDate),DateUtil.str2Date(ePayDate)), new MapListHandler()); 
					if(null != listAll2 && !listAll2.isEmpty()){
						for(Iterator it = listAll2.iterator();it.hasNext();){
							Map map = (Map)it.next();		
							map.put("ADVANCE_REPAY_DATE",DateUtil.date2ROCStr((Date)map.get("ADVANCE_REPAY_DATE"),"yyy/MM/dd"));
							map.put("CAPITAL_SERIAL",map.get("CAPITAL_SERIAL").toString().trim());
							//小計計算
							capitalAmount = capitalAmount.add((BigDecimal)map.get("capital_amount"));
							interestAmount = interestAmount.add((BigDecimal)map.get("interest_amount"));
							feeAmount = feeAmount.add((BigDecimal)map.get("charge_amount"));	
							payableInterestAmount = payableInterestAmount.add((BigDecimal)map.get("payable_interest_amount"));
							run.update(connection,insTemp(form,usrId,map));						
						}
					}
					
					//合計計算
					tCapitalAmount = tCapitalAmount.add(capitalAmount);
					tInterestAmount = tInterestAmount.add(interestAmount);
					tFeeAmount = tFeeAmount.add(feeAmount);
					advancetCapitalAmount = advancetCapitalAmount.add(advancecapitalAmount);
					advancetInterestAmount = advancetInterestAmount.add(advanceinterestAmount);
					advancetFeeAmount = advancetFeeAmount.add(advancefeeAmount);
					tPayableInterestAmount = tPayableInterestAmount.add(payableInterestAmount);
					
					//小計,該月無資料不show小計
					if (isMonthDate)
						run.update(connection,new SQLJob("INSERT INTO APRA01_RPT ( USRID, MOD_DATE, DUE_DATE, DEBT_NAME, CAPITAL_SERIAL , INTEREST_SERIAL, CAPITAL_AMOUNT, INTEREST_AMOUNT, FEE_AMOUNT,advance_capital_amount,advance_interest_amount,advance_FEE_amount,payable_interest_amount) " +
							"values ('"+usrId+"', CURRENT_TIMESTAMP, null, '"+Integer.parseInt(checkMonth[j])+"月小計', null, null, "+ capitalAmount+", "+interestAmount+","+ feeAmount+","+advancecapitalAmount+","+advanceinterestAmount+","+advancefeeAmount+","+payableInterestAmount+")"));
				}
			}
		}
		//寫入合計
		run.update(connection,new SQLJob("INSERT INTO APRA01_RPT ( USRID, MOD_DATE, DUE_DATE, DEBT_NAME, CAPITAL_SERIAL , INTEREST_SERIAL, CAPITAL_AMOUNT, INTEREST_AMOUNT, FEE_AMOUNT,advance_capital_amount,advance_interest_amount,advance_FEE_amount,payable_interest_amount) " +
				"values ('"+usrId+"', CURRENT_TIMESTAMP, null, '合          計', null, null, "+ tCapitalAmount+", "+tInterestAmount+","+ tFeeAmount+","+advancetCapitalAmount+","+advancetInterestAmount+","+advancetFeeAmount+","+tPayableInterestAmount+")"));		
	}

}


















