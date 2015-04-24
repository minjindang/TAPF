package tw.gov.nta.surplusage.common;

import java.math.BigDecimal;

import com.kangdainfo.ast.sql.SQLJob;

public class CommonReportSQL 
{
	public static SQLJob Gara30SQL(String qryYear,BigDecimal unit){
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
		/*
		 * 發行,舉借數
		 */
		//公債 總預算 甲類
		sqljob.appendSQL("sum(case when bound_code = '1' and  budget_code = '1'   and debt_type = 'A' then  issue_amount  else 0 end)/"+unit+" TA1,");
		//公債 特別預算 甲類
		sqljob.appendSQL("sum(case when bound_code = '1' and  budget_code = '2' and is_account ='N'  and debt_type = 'A' then  issue_amount else 0 end)/"+unit+" TA2,");
		//公債 特別預算 乙類
		sqljob.appendSQL("sum(case when bound_code = '2' and  budget_code = '2' and is_account ='N'  and debt_type = 'A'  and account_year < 091 then  issue_amount else 0 end)/"+unit+" TA3,");
		//公債 特別預算 九二一
		sqljob.appendSQL("sum(case when is_account='Y'  and debt_type = 'A' then  issue_amount else 0 end )/"+unit+" TA4,");
		//公債 債務基金
		sqljob.appendSQL("sum(case when budget_code = '3'  and debt_type = 'A'   then  issue_amount else 0 end)/"+unit+" TA5,");
		//公債 省債
		sqljob.appendSQL("sum(case when debt_type = 'A' and debt_code = '35'  and  is_account<>'Y'  and  budget_code <> '3'   then issue_amount else 0 end)/"+unit+" TA6,");
		//公債 新生地開發
		sqljob.appendSQL("sum(case when debt_type = 'A' and budget_code = '5' and debt_code=48 and is_account ='N'  then  issue_amount else 0 end)/"+unit+" TA7,");
		//公債 糧食平準基金
		sqljob.appendSQL("sum(case when debt_type = 'A' and budget_code = '5' and debt_code=36 and is_account ='N'  then  issue_amount else 0 end)/"+unit+" TA8,");
		//公債 非營業基金
		sqljob.appendSQL("sum(case when debt_type = 'A' and budget_code = '5' and debt_code=37 and is_account ='N'  then  issue_amount else 0 end)/"+unit+" TA9, ");
		
		//賒借 甲類
		sqljob.appendSQL("sum(case when bound_code = '1' and  budget_code in ('1','2') and  is_account='N' and debt_type in ('C','E') then  issue_amount  else 0 end)/"+unit+" TA10,");
		//賒借  乙類
		sqljob.appendSQL("sum(case when bound_code = '2'      and debt_type in ('C','E')  then  issue_amount else 0 end)/"+unit+" TA11,");
		//賒借 九二一等
		sqljob.appendSQL("sum(case when budget_code = '2' and bound_code<>'2' and debt_code not in (26,44,42)  and debt_type  in ('C','E') then  issue_amount else 0 end )/"+unit+" TA12,");
		//賒借 債務基金
		sqljob.appendSQL("sum(case when budget_code = '3'  and debt_type in ('C','E')   then  issue_amount else 0 end)/"+unit+" TA13,");
		//賒借 省債
		sqljob.appendSQL("sum(case when debt_type in ('C','E') and debt_code = '35'  and  is_account<>'Y'  and  budget_code <> '3'   then issue_amount else 0 end)/"+unit+" TA14,");
		//省債89年開始未償餘額初始值 預:890.727(十億)決:904.769(十億)實:897.719(十億)
		sqljob.appendSQL("((case when account_year = 089 and account_kind='1'  then 890727000000.0 ");
		sqljob.appendSQL("when account_year = 089 and account_kind='2'  then 904769000000.0 ");
		sqljob.appendSQL("when account_year = 089 and account_kind='4'  then 897539000000.0 ");
		//sqljob.appendSQL("when account_year = 089 and account_kind='4'  then 897719000000 ");
		sqljob.appendSQL("else 0.0 end))/"+unit+" as TB14,");
		//賒借 新生地開發
		sqljob.appendSQL("sum(case when debt_type in ('C','E') and budget_code = '5' and debt_code=48 and is_account ='N'  then  issue_amount else 0 end)/"+unit+" TA15,");
		//新生地開發94年開始未償餘額初始值 預:0.450(十億)決:0.450(十億)實:0.450(十億)
		sqljob.appendSQL("((case when account_year = 094 and account_kind='1'  then 450000000.0 ");
		sqljob.appendSQL("when account_year = 094 and account_kind='2'  then 450000000.0 ");
		sqljob.appendSQL("when account_year = 094 and account_kind='4'  then 450000000.0 ");
		sqljob.appendSQL("else 0.0 end))/"+unit+" as TB15,");
		//賒借 糧食平準基金
		sqljob.appendSQL("sum(case when debt_type in ('C','E') and budget_code = '5' and debt_code=36 and is_account ='N'  then  issue_amount else 0 end)/"+unit+" TA16,");
		//糧食平準基金90年開始未償餘額初始值  預:93.170(十億) 決:93.976(十億) 實:93.976(十億)
		sqljob.appendSQL("((case when account_year = 090 and account_kind='1'  then 93170000000.0 ");
		sqljob.appendSQL("when account_year = 090 and account_kind='2'  then 93976000000.0 ");
		sqljob.appendSQL("when account_year = 090 and account_kind='4'  then 93976000000.0 ");
		sqljob.appendSQL("else 0.0 end))/"+unit+" as TB16,");
		//賒借 非營業基金
		sqljob.appendSQL("sum(case when debt_type in ('C','E') and budget_code = '5' and debt_code=37 and is_account ='N'  then  issue_amount else 0 end)/"+unit+" TA17, ");
		
		/*
		 * 還本數
		 */
		//公債 總預算 甲類
		sqljob.appendSQL("sum(case when bound_code = '1' and  budget_code = '1'   and debt_type = 'A' then  pay_amount  else 0 end)/"+unit+" SA1,");
		//公債 特別預算 甲類
		sqljob.appendSQL("sum(case when bound_code = '1' and  budget_code = '2' and is_account ='N'  and debt_type = 'A' then  pay_amount else 0 end)/"+unit+" SA2,");
		//公債 特別預算 乙類
		sqljob.appendSQL("sum(case when bound_code = '2' and  budget_code = '2' and is_account ='N'  and debt_type = 'A'  and account_year < 091 then  pay_amount else 0 end)/"+unit+" SA3,");
		//公債 特別預算 九二一
		sqljob.appendSQL("sum(case when is_account='Y'  and debt_type = 'A' then  pay_amount else 0 end )/"+unit+" SA4,");
		//公債 債務基金
		sqljob.appendSQL("sum(case when budget_code = '3'  and debt_type = 'A'   then  pay_amount else 0 end)/"+unit+" SA5,");
		//公債 省債
		sqljob.appendSQL("sum(case when debt_type = 'A' and debt_code = '35'  and  is_account<>'Y'  and  budget_code <> '3'   then pay_amount else 0 end)/"+unit+" SA6,");
		//公債 新生地開發
		sqljob.appendSQL("sum(case when debt_type = 'A' and budget_code = '5' and debt_code=48 and is_account ='N'  then  pay_amount else 0 end)/"+unit+" SA7,");
		//公債 糧食平準基金
		sqljob.appendSQL("sum(case when debt_type = 'A' and budget_code = '5' and debt_code=36 and is_account ='N'  then  pay_amount else 0 end)/"+unit+" SA8,");
		//公債 非營業基金
		sqljob.appendSQL("sum(case when debt_type = 'A' and budget_code = '5' and debt_code=37 and is_account ='N'  then  pay_amount else 0 end)/"+unit+" SA9, ");
		
		//賒借 甲類
		sqljob.appendSQL("sum(case when bound_code = '1' and budget_code in ('1','2') and  is_account='N' and debt_type in ('C','E') then  pay_amount  else 0 end)/"+unit+" SA10,");
		//賒借  乙類
		sqljob.appendSQL("sum(case when bound_code = '2' and debt_type in ('C','E')  then  pay_amount else 0 end)/"+unit+" SA11,");
		//賒借 九二一等
		sqljob.appendSQL("sum(case when budget_code = '2' and bound_code<>'2' and debt_code not in (26,44,42)  and debt_type  in ('C','E') then  pay_amount else 0 end )/"+unit+" SA12,");
		//賒借 債務基金
		sqljob.appendSQL("sum(case when budget_code = '3'  and debt_type in ('C','E')   then  pay_amount else 0 end)/"+unit+" SA13, ");
		//賒借 省債
		sqljob.appendSQL("sum(case when debt_type in ('C','E') and debt_code = '35'  and  is_account<>'Y'  and  budget_code <> '3'   then pay_amount else 0 end)/"+unit+" SA14,");
		//賒借 新生地開發
		sqljob.appendSQL("sum(case when debt_type in ('C','E') and budget_code = '5' and debt_code=48 and is_account ='N'  then  pay_amount else 0 end)/"+unit+" SA15,");
		//賒借 糧食平準基金
		sqljob.appendSQL("sum(case when debt_type in ('C','E') and budget_code = '5' and debt_code=36 and is_account ='N'  then  pay_amount else 0 end)/"+unit+" SA16,");
		//賒借 非營業基金
		sqljob.appendSQL("sum(case when debt_type in ('C','E') and budget_code = '5' and debt_code=37 and is_account ='N'  then  pay_amount else 0 end)/"+unit+" SA17, ");
//		賒借 非營業基金(非自償)
		sqljob.appendSQL("sum(case when bound_code = '1' and debt_type in ('C','E') and budget_code = '5' and debt_code=37 and is_account ='N'  then  pay_amount else 0 end)/"+unit+" SA18, ");
//		公債 非營業基金(非自償)
		sqljob.appendSQL("sum(case when bound_code = '1' and debt_type = 'A' and budget_code = '5' and debt_code=37 and is_account ='N'  then  pay_amount else 0 end)/"+unit+" SA19 ");

		sqljob.appendSQL("from Central_statistics_main ");
				//新增內外債條件
		sqljob.appendSQL("where 1=1 and inout_type='0' ");
				//不顯示保留數
		sqljob.appendSQL("and account_kind <> '3' ");
		if (!"".equals(qryYear)){
			sqljob.appendSQL("and account_year between 0 and ? +0 ");
			sqljob.addParameter(qryYear);
		}
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
		return sqljob;
	}
	public static SQLJob Gara34SQL(String qryYear,BigDecimal unit ){
		return Gara34SQL( qryYear, unit ,null);
	}
	public static SQLJob Gara34SQL(String qryYear,BigDecimal unit ,String inoutType){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select  case ");

		sqljob.appendSQL("when (account_year ='089' ) then '088上半及089' ");
		sqljob.appendSQL("else account_year ");
		sqljob.appendSQL("end as account_year,");
		sqljob.appendSQL("(case  ");
		sqljob.appendSQL("when  account_kind='1' then '(預)' ");
		sqljob.appendSQL("when account_kind='2' then '(決)' ");
		sqljob.appendSQL("when account_kind='3' then '(保)' ");
		sqljob.appendSQL("when account_kind='4'  then '(實)' ");
		sqljob.appendSQL("else '' ");
		sqljob.appendSQL("end ) as account_kind_name ,");
		sqljob.appendSQL("(case");
		sqljob.appendSQL("when account_kind='1'  then '1' ");
		sqljob.appendSQL("when account_kind='2' then '2' ");
		sqljob.appendSQL("when account_kind='3' then '3' ");
		sqljob.appendSQL("when account_kind='4' then '4' ");
		sqljob.appendSQL("else '' ");
		sqljob.appendSQL("end ) as account_kind,");
		//發行 總預算
		sqljob.appendSQL("sum(case when budget_code = '1' then  issue_amount else 0 end)/"+unit+" TA1,");
		//發行 總預算-調節數
		sqljob.appendSQL("isNull((select (case when A.account_kind='1' then budget_adjust_amount when A.account_kind='2' then audit_adjust_amount when A.account_kind='4' then real_adjust_amount else 0 end) ");
		sqljob.appendSQL("from current_adjust_main B where A.account_year=B.account_year),0)/"+unit+" as TB1,");
		//發行 總預算-未償餘額初始值
		sqljob.appendSQL("(case when account_year = 072 and account_kind='1' then 1982000000.0 ");
		sqljob.appendSQL("when account_year = 072 and account_kind='2'  then 1982000000.0 ");
		sqljob.appendSQL("when account_year = 072 and account_kind='4'  then 1982000000.0 ");
		sqljob.appendSQL("else 0.0 end)/"+unit+" as TC1,");
		//發行 特別預算 戰機
		sqljob.appendSQL("sum(case when budget_code = '2' and debt_code=42 and is_account ='N'  then  issue_amount else 0 end)/"+unit+" TA2,");
		//發行 特別預算 北二高
		sqljob.appendSQL("sum(case when bound_code='1' and budget_code = '2' and debt_code=26 and is_account ='N'  then  issue_amount else 0 end)/"+unit+" TA3,");
		//發行 特別預算 乙類
		sqljob.appendSQL("sum(case when bound_code = '2'  and budget_code = '2'  then  issue_amount else 0 end)/"+unit+" TA4,");
		//發行 特別預算 立院遷建
		sqljob.appendSQL("sum(case when budget_code = '2' and debt_code=44 and is_account ='N'  then  issue_amount else 0 end)/"+unit+" TA5,");
		//發行 特別預算 九二一等
		sqljob.appendSQL("sum(case when budget_code = '2' and bound_code<>'2' and debt_code not in (26,44,42)   then  issue_amount else 0 end)/"+unit+" TA6,");
		//發行 特別預算 省債
		sqljob.appendSQL("sum(case when budget_code = '5' and debt_code=35 and is_account ='N'  then  issue_amount else 0 end)/"+unit+" TA7,");
		//省債89年開始未償餘額初始值 預:890.727(十億)決:904.769(十億)實:897.719(十億)
		sqljob.appendSQL("(case when account_year = 089 and account_kind='1'  then 890727000000.0 ");
		sqljob.appendSQL("when account_year = 089 and account_kind='2'  then 904769000000.0 ");
		sqljob.appendSQL("when account_year = 089 and account_kind='4'  then 897539000000.0 ");
		//sqljob.appendSQL("when account_year = 089 and account_kind='4'  then 897719000000 ");
		sqljob.appendSQL("else 0.0 end)/"+unit+" as TB7,");
		//發行新生地開發
		sqljob.appendSQL("sum(case when budget_code = '5' and debt_code=48 and is_account ='N'  then  issue_amount else 0 end)/"+unit+" TA8,");
		//新生地開發94年開始未償餘額初始值 預:0.450(十億)決:0.450(十億)實:0.450(十億)
		sqljob.appendSQL("(case when account_year = 094 and account_kind='1'  then 450000000.0 ");
		sqljob.appendSQL("when account_year = 094 and account_kind='2'  then 450000000.0 ");
		sqljob.appendSQL("when account_year = 094 and account_kind='4'  then 450000000.0 ");
		sqljob.appendSQL("else 0.0 end)/"+unit+" as TB8,");
		//發行 特別預算 糧食平準基金
		sqljob.appendSQL("sum(case when budget_code = '5' and debt_code=36 and is_account ='N'  then  issue_amount else 0 end)/"+unit+" TA9,");
		//糧食平準基金90年開始未償餘額初始值  預:93.170(十億) 決:93.976(十億) 實:93.976(十億)
		sqljob.appendSQL("(case when account_year = 090 and account_kind='1'  then 93170000000.0 ");
		sqljob.appendSQL("when account_year = 090 and account_kind='2'  then 93976000000.0 ");
		sqljob.appendSQL("when account_year = 090 and account_kind='4'  then 93976000000.0 ");
		sqljob.appendSQL("else 0.0 end)/"+unit+" as TB9,");
		//發行 債務基金
		sqljob.appendSQL("sum(case when budget_code = '3'   then  issue_amount else 0 end)/"+unit+" TA10,");
		//發行 特別預算 非營業基金
		sqljob.appendSQL("sum(case when budget_code = '5' and debt_code=37 and is_account ='N'  then  issue_amount else 0 end)/"+unit+" TA11,");
		//還本 總預算
		sqljob.appendSQL("sum(case when budget_code = '1'  then  pay_amount else 0 end)/"+unit+" SA1,");		
		//還本 特別預算 戰機
		sqljob.appendSQL("sum(case when budget_code = '2' and debt_code=42 and is_account ='N' then  pay_amount else 0 end)/"+unit+" SA2,");
		//還本 特別預算 北二高
		sqljob.appendSQL("sum(case when bound_code='1' and budget_code = '2' and debt_code=26 and is_account ='N' then  pay_amount else 0 end)/"+unit+" SA3,");
		//還本 特別預算 乙類
		sqljob.appendSQL("sum(case when bound_code = '2'  and budget_code = '2' and is_account ='N' then  pay_amount else 0 end)/"+unit+" SA4,");
		//還本 特別預算 立院遷建
		sqljob.appendSQL("sum(case when budget_code = '2' and debt_code=44 and is_account ='N' then  pay_amount else 0 end)/"+unit+" SA5,");
		//還本 特別預算 九二一等
		sqljob.appendSQL("sum(case when budget_code = '2' and bound_code<>'2' and debt_code not in (26,44,42)   then  pay_amount else 0 end)/"+unit+" SA6,");
		//還本 特別預算 省債
		sqljob.appendSQL("sum(case when budget_code = '5' and debt_code=35 and is_account ='N' then  pay_amount else 0 end)/"+unit+" SA7,");
		//還本 新生地開發
		sqljob.appendSQL("sum(case when budget_code = '5' and debt_code=48 and is_account ='N' then  pay_amount else 0 end)/"+unit+" SA8,");
		//還本 特別預算 糧食平準基金
		sqljob.appendSQL("sum(case when budget_code = '5' and debt_code=36 and is_account ='N'  then  pay_amount else 0 end)/"+unit+" SA9,");
		//還本 債務基金
		sqljob.appendSQL("sum(case when budget_code = '3'   then  pay_amount else 0 end)/"+unit+" SA10,");
		//還本 特別預算 非營業基金
		sqljob.appendSQL("sum(case when budget_code = '5' and debt_code=37 and is_account ='N'  then  pay_amount else 0 end)/"+unit+" SA11 ");
		sqljob.appendSQL("from Central_statistics_main A");
		sqljob.appendSQL("where debt_type IN ('C','E') ");
		//不顯示保留數
		sqljob.appendSQL("and account_kind <> '3' ");
		if (!"".equals(qryYear)){
			sqljob.appendSQL("and account_year between 0 and ? +0 ");
			sqljob.addParameter(qryYear);
		}
		if(inoutType != null){
			sqljob.appendSQL("and inout_type=? ");
			sqljob.addParameter(inoutType);
		}
		sqljob.appendSQL("group by case ");
		sqljob.appendSQL("when (account_year ='089' ) then '088上半及089' ");
		sqljob.appendSQL("else account_year ");
		sqljob.appendSQL("end , ");
		sqljob.appendSQL("(case  ");
		sqljob.appendSQL("when  account_kind='1' then '(預)' ");
		sqljob.appendSQL("when account_kind='2' then '(決)' ");
		sqljob.appendSQL("when account_kind='3' then '(保)' ");
		sqljob.appendSQL("when account_kind='4'  then '(實)' ");
		sqljob.appendSQL("else '' ");
		sqljob.appendSQL("end ),");
		sqljob.appendSQL("(case");
		sqljob.appendSQL("when account_kind='1'  then '1' ");
		sqljob.appendSQL("when account_kind='2' then '2' ");
		sqljob.appendSQL("when account_kind='3' then '3' ");
		sqljob.appendSQL("when account_kind='4' then '4' ");
		sqljob.appendSQL("else '' ");
		sqljob.appendSQL("end ),account_year ,account_kind ");
		sqljob.appendSQL("order by 1,3");
		return sqljob;
	}
	public static SQLJob Gara33SQL(String qryYear,BigDecimal unit ){
		return Gara33SQL( qryYear, unit ,null);
	}
	public static SQLJob Gara33SQL(String qryYear,BigDecimal unit,String inoutType){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select  case ");
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
		sqljob.appendSQL("end item ,account_kind,account_year, ");
		//發行 總預算 甲類
		sqljob.appendSQL("sum(case when bound_code = '1' and  budget_code = '1' then  issue_amount else 0 end)/? TA1,");
		//發行 特別預算 甲類
		sqljob.appendSQL("sum(case when bound_code = '1' and  budget_code = '2' and is_account ='N'  then  issue_amount else 0 end)/? TB1,");
		//發行 特別預算 乙類  91年開始債務不列入計算
		sqljob.appendSQL("sum(case when bound_code = '2' and  budget_code = '2' and is_account ='N' and account_year<'091' then  issue_amount else 0 end)/? TA2,");
		sqljob.appendSQL("sum(case when bound_code = '2' and  budget_code = '1' and is_account ='N' and account_year<'091' then  issue_amount else 0 end)/? TB2,");
		//發行 省債
		sqljob.appendSQL("sum(case when  debt_code = '35'  and  is_account<>'Y'  and  budget_code <> '3'   then issue_amount else 0 end)/? TA3,");
		//發行 特別預算 九二一
		sqljob.appendSQL("sum(case when is_account='Y' then  issue_amount else 0 end )/? TA4,");
		//發行 債務基金
		sqljob.appendSQL("sum(case when budget_code = '3'   then  issue_amount else 0 end)/? TA5,");
		//還本 甲類
		sqljob.appendSQL("sum(case when  bound_code = '1'  and  debt_code <> '35' and  is_account<>'Y'  and  budget_code in ( '1','2')    then pay_amount  else 0 end)/? SA1,");
		//還本 乙類 91年開始債務不列入計算
		sqljob.appendSQL("sum(case when  bound_code = '2' and account_year<'091' then pay_amount  else 0 end)/? SA2,");
		//還本 省債
		sqljob.appendSQL("sum(case when  debt_code = '35'  and  is_account<>'Y'  and  budget_code <> '3'   then pay_amount  else 0 end)/? SA3,");
		//還本 九二一
		sqljob.appendSQL("sum(case when is_account='Y' and  debt_code <> '35' and   budget_code <> '3'  then  pay_amount  else 0 end )/? SA4,");
		//還本 債務基金
		sqljob.appendSQL("sum(case when budget_code = '3'  and  debt_code <> '35' and  is_account<>'Y'  then  pay_amount  else 0 end)/? SA5");
		sqljob.appendSQL("from Central_statistics_main ");
		sqljob.appendSQL("where debt_type = 'A' ");
		//不顯示保留數
		sqljob.appendSQL("and account_kind <> '3' ");
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		if (!"".equals(qryYear)){
			sqljob.appendSQL("and account_year between 0 and ? +0 ");
			sqljob.addParameter(qryYear);
		}
		if(inoutType != null){
			sqljob.appendSQL("and inout_type=? ");
			sqljob.addParameter(inoutType);
		}
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
		sqljob.appendSQL("end ,account_kind,account_year ");
		sqljob.appendSQL("order by account_year,account_kind ");
		System.out.println("GARA3301-SQL"+sqljob.toString());
		return sqljob;
	}
}
