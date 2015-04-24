package gov.dnt.tame.common;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.handlers.MapHandler;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public abstract class ExcelReportRemainAction extends ExcelReportBaseAction {
	
	/*	歲出總額按照(預,決,實)分別
	 * 
	 * 	傳入:String accountYear=會計年度
	 * 		BigDecimal unit = 單位
	 * 
	 * 	傳出:budget_amount=預算數
	 * 		audit_amount=決算數
	 * 		real_amount=實際數	
	 */
	public SQLJob yearAmountBKindSQL(String accountYear,BigDecimal unit){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select Account_year,");
		sqljob.appendSQL("sum(isNull(Budget_amount,0))/" + unit + " as budget_amount,");
		sqljob.appendSQL("sum(isNull(Audit_amount,0))/" + unit + " as audit_amount,");
		sqljob.appendSQL("sum(isNull(real_amount,0))/" + unit + " as real_amount ");
		sqljob.appendSQL("from Year_amount_ref ");
		sqljob.appendSQL("where data_type = '1' ");
		sqljob.appendSQL("and account_year = '" + accountYear + "' ");
		sqljob.appendSQL("group by Account_year");
		return sqljob;
	}
	
	/*	歲出總額
	 *	傳入String accountYear=會計年度
	 * 	 BigDecimal unit = 單位
	 */
	public SQLJob yearAmountBSQL(String accountYear,BigDecimal unit){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select Account_year,");
		sqljob.appendSQL("isnull(sum(Budget_amount),0)/" + unit + " as year_amount ");
		sqljob.appendSQL("from Year_amount_ref ");
		sqljob.appendSQL("where data_type = '1' ");
		sqljob.appendSQL("and account_year <= '090' ");
		sqljob.appendSQL("and Budget_code = 1 ");
		sqljob.appendSQL("and account_year = '" + accountYear + "' ");
		sqljob.appendSQL("group by Account_year ");
		sqljob.appendSQL("union ");
		sqljob.appendSQL("select Account_year,");
		sqljob.appendSQL("isnull(sum(Budget_amount),0)/" + unit + " as year_amount ");
		sqljob.appendSQL("from Year_amount_ref ");
		sqljob.appendSQL("where data_type = '2' ");
		sqljob.appendSQL("and account_year > '090' ");
		sqljob.appendSQL("and Budget_code in (1,2) ");
		sqljob.appendSQL("and account_year = '" + accountYear + "' ");
		sqljob.appendSQL("group by Account_year ");
		sqljob.appendSQL("order by Account_year ");
		return sqljob;
	}
	
	/*	未償餘額使用=>(支)歲出總額按照(預,決,實)分別
	 * 	
	 *	傳入:String accountYear=會計年度
	 * 	 	BigDecimal unit = 單位
	 *		String kind==> "1"=含排除債限部份
	 *						"2"=不含排除債限
	 *
	 */
	public SQLJob yearAmountKindSQL(String accountYear,BigDecimal unit,String kind){
		SQLJob sqljob = new SQLJob();
		/*
		sqljob.appendSQL("select Account_year,");
		if ("1".equals(kind)){
			sqljob.appendSQL("sum(isNull(Budget_amount,0))/" + unit + " as budget_amount,");
			sqljob.appendSQL("sum(isNull(Audit_amount,0))/" + unit + " as audit_amount,");
			sqljob.appendSQL("sum(isNull(real_amount,0))/" + unit + " as real_amount ");
		}else if ("2".equals(kind)){
			sqljob.appendSQL("sum(isNull(Budget_uamount,0))/" + unit + " as budget_amount,");
			sqljob.appendSQL("sum(isNull(Audit_uamount,0))/" + unit + " as audit_amount,");
			sqljob.appendSQL("sum(isNull(real_uamount,0))/" + unit + " as real_amount ");
		}
		sqljob.appendSQL("from Year_amount_ref ");
		sqljob.appendSQL("where data_type = '2' ");
		sqljob.appendSQL("and account_year = '" + accountYear + "' ");
		sqljob.appendSQL("group by Account_year ");
		*/
		
		sqljob.appendSQL("select Account_year,");
		if ("1".equals(kind)){
			sqljob.appendSQL("sum(isNull(Budget_amount,0))/" + unit + " as budget_amount,");
			sqljob.appendSQL("sum(isNull(Audit_amount,0))/" + unit + " as audit_amount,");
			sqljob.appendSQL("sum(isNull(real_amount,0))/" + unit + " as real_amount ");
		}else if ("2".equals(kind)){
			sqljob.appendSQL("sum(isNull(Budget_uamount,0))/" + unit + " as budget_amount,");
			sqljob.appendSQL("sum(isNull(Audit_uamount,0))/" + unit + " as audit_amount,");
			sqljob.appendSQL("sum(isNull(real_uamount,0))/" + unit + " as real_amount ");
		}
		sqljob.appendSQL("from Year_amount_ref ");
		sqljob.appendSQL("where data_type = '1' ");
		sqljob.appendSQL("and account_year <= '090' ");
		sqljob.appendSQL("and account_year = '" + accountYear + "' ");
		sqljob.appendSQL("group by Account_year ");
		sqljob.appendSQL("union ");
		sqljob.appendSQL("select Account_year,");
		if ("1".equals(kind)){
			sqljob.appendSQL("sum(isNull(Budget_amount,0))/" + unit + " as budget_amount,");
			sqljob.appendSQL("sum(isNull(Audit_amount,0))/" + unit + " as audit_amount,");
			sqljob.appendSQL("sum(isNull(real_amount,0))/" + unit + " as real_amount ");
		}else if ("2".equals(kind)){
			sqljob.appendSQL("sum(isNull(Budget_uamount,0))/" + unit + " as budget_amount,");
			sqljob.appendSQL("sum(isNull(Audit_uamount,0))/" + unit + " as audit_amount,");
			sqljob.appendSQL("sum(isNull(real_uamount,0))/" + unit + " as real_amount ");
		}
		sqljob.appendSQL("from Year_amount_ref ");
		sqljob.appendSQL("where data_type = '2' ");
		sqljob.appendSQL("and account_year > '090' ");
		sqljob.appendSQL("and account_year = '" + accountYear + "' ");
		sqljob.appendSQL("group by Account_year ");
		sqljob.appendSQL("order by Account_year ");
		//System.out.println("year:"+accountYear+"年"+sqljob.toString());
		return sqljob;
	}
	
	/*	未償餘額使用=>(支)歲出總額
	 *	傳入:String accountYear=會計年度
	 * 	 	BigDecimal unit = 單位
	 *		String kind==> "1"=含排除債限部份
	 *						"2"=不含排除債限
	 *
	 */
	public SQLJob yearAmountSQL(String accountYear,BigDecimal unit,String kind){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select Account_year,");
		/*
		sqljob.appendSQL("(sum(case Budget_YN when 'Y' then isnull(Budget_amount,0) else 0 end) +");
		sqljob.appendSQL("sum(case  Audit_YN when 'Y' then isnull(Audit_amount,0) else 0 end) +");
		sqljob.appendSQL("sum(case real_YN when 'Y' then isnull(real_amount,0) else 0 end))/" + unit + " as year_amount ");
		*/
		if ("1".equals(kind)){
			sqljob.appendSQL("(sum(case Budget_YN when 'Y' then isnull(Budget_damount,0)+isnull(Budget_uamount,0) else 0 end) +");
			sqljob.appendSQL("sum(case  Audit_YN when 'Y' then isnull(Audit_damount,0)+isnull(Audit_uamount,0) else 0 end) +");
			sqljob.appendSQL("sum(case real_YN when 'Y' then isnull(real_damount,0)+isnull(real_uamount,0) else 0 end))");
		}else if ("2".equals(kind)){
			sqljob.appendSQL("(sum(case Budget_YN when 'Y' then isnull(Budget_uamount,0) else 0 end) +");
			sqljob.appendSQL("sum(case  Audit_YN when 'Y' then isnull(Audit_uamount,0) else 0 end) +");
			sqljob.appendSQL("sum(case real_YN when 'Y' then isnull(real_uamount,0) else 0 end))");
		}
		sqljob.appendSQL("/" + unit + " as year_amount ");
		sqljob.appendSQL("from Year_amount_ref ");
		sqljob.appendSQL("where data_type = '1' ");
		sqljob.appendSQL("and account_year <= '090' ");
		sqljob.appendSQL("and account_year = '" + accountYear + "' ");
		sqljob.appendSQL("group by Account_year ");
		sqljob.appendSQL("union ");
		sqljob.appendSQL("select Account_year,");
		
		if ("1".equals(kind)){
			sqljob.appendSQL("(sum(case Budget_YN when 'Y' then isnull(Budget_damount,0)+isnull(Budget_uamount,0) else 0 end) +");
			sqljob.appendSQL("sum(case  Audit_YN when 'Y' then isnull(Audit_damount,0)+isnull(Audit_uamount,0) else 0 end) +");
			sqljob.appendSQL("sum(case real_YN when 'Y' then isnull(real_damount,0)+isnull(real_uamount,0) else 0 end))");
		}else if ("2".equals(kind)){
			sqljob.appendSQL("(sum(case Budget_YN when 'Y' then isnull(Budget_uamount,0) else 0 end) +");
			sqljob.appendSQL("sum(case  Audit_YN when 'Y' then isnull(Audit_uamount,0) else 0 end) +");
			sqljob.appendSQL("sum(case real_YN when 'Y' then isnull(real_uamount,0) else 0 end))");
		}
		
		
		sqljob.appendSQL("/" + unit + " as year_amount ");
		sqljob.appendSQL("from Year_amount_ref ");
		sqljob.appendSQL("where data_type = '2' ");
		sqljob.appendSQL("and account_year > '090' ");
		sqljob.appendSQL("and account_year = '" + accountYear + "' ");
		sqljob.appendSQL("group by Account_year ");
		sqljob.appendSQL("order by Account_year ");
		return sqljob;
	}
	
	/*GNP
	 *傳入String accountYear=會計年度
	 * 	 BigDecimal unit = 單位 
	 * 
	 */
	public SQLJob GNPSQL(String accountYear,BigDecimal unit){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select A.account_year, ");
		sqljob.appendSQL("(case when A.account_year <= '088' and A.account_year <> '089' then isnull(A.GNP_amount,0) ");
		sqljob.appendSQL("when  A.account_year > '088' and A.account_year <> '089' then isnull(A.GNP_year_amount,0)");
		sqljob.appendSQL("when  A.account_year = '089' then isnull(A.GNP_year_amount1,0)");
		sqljob.appendSQL("else 0 end)/"+unit+" as GNP ");
		sqljob.appendSQL("from Nation_Debit_main A,Nation_ref B ");
		sqljob.appendSQL("where A.Nation_Code = B.id ");
		sqljob.appendSQL("and A.account_year = '" + accountYear + "' ");
		sqljob.appendSQL("and B.Nation_no = 'TW'");
		return sqljob;
	}
	
	/*perGNP
	 *傳入String accountYear=會計年度
	 * 	 BigDecimal unit = 單位   
	 */
	public SQLJob perGNPSQL(String accountYear,BigDecimal unit){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select A.account_year,isnull(A.perGNP_amount,0)/"+unit+" as perGNP ");
		sqljob.appendSQL("from Nation_Debit_main A,Nation_ref B ");
		sqljob.appendSQL("where A.Nation_Code = B.id ");
		sqljob.appendSQL("and A.account_year = '" + accountYear + "' ");
		sqljob.appendSQL("and B.Nation_no = 'TW'");
		return sqljob;
	}
	
	/*GDP
	 *傳入String accountYear=會計年度
	 * 	 BigDecimal unit = 單位  
	 */
	public SQLJob GDPSQL(String accountYear,BigDecimal unit){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select A.account_year,isnull(A.GDP_amount,0)/"+unit+" as GDP ");
		sqljob.appendSQL("from Nation_Debit_main A,Nation_ref B ");
		sqljob.appendSQL("where A.Nation_Code = B.id ");
		sqljob.appendSQL("and A.account_year = '" + accountYear + "' ");
		sqljob.appendSQL("and B.Nation_no = 'TW'");
		return sqljob;
	}
	
	/*調整數(外債)
	 *傳入String accountYear=會計年度
	 * 	 BigDecimal unit = 單位  
	 * 區分account_kind
	 */
	public SQLJob yearAdjustAmountKindSQL(String accountYear,BigDecimal unit){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select ");
		sqljob.appendSQL("isNull(sum(budget_adjust_amount),0)/" + unit + " as budget_adjust_amount,");
		sqljob.appendSQL("isNull(sum(audit_adjust_amount),0)/" + unit + " as audit_adjust_amount,");
		sqljob.appendSQL("isNull(sum(real_adjust_amount),0)/" + unit + " as real_adjust_amount ");
		sqljob.appendSQL("from current_adjust_main ");
		sqljob.appendSQL("where account_year <= '" + accountYear + "' ");
		return sqljob;
	}
	
	/*調整數(外債)
	 *傳入String accountYear=會計年度
	 * 	 BigDecimal unit = 單位  
	 */
	public SQLJob yearAdjustAmountSQL(String accountYear,BigDecimal unit){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select ");
		sqljob.appendSQL("isNull(sum(case account_type when 'Y' then isnull(audit_adjust_amount,0) else  isnull(budget_adjust_amount,0) end),0)/" + unit + " as adjust_amount "); 
		sqljob.appendSQL("from current_adjust_main ");
		sqljob.appendSQL("where account_year <= '" + accountYear + "' ");
		return sqljob;
	}
	
	/*取得當年甲類排限
	 *傳入String accountYear=會計年度
	 * 	 BigDecimal unit = 單位  
	 */
	public SQLJob yearLimitSQL(String accountYear,String accountKind,BigDecimal unit){
		return yearLimitSQL(accountYear,accountKind,unit,"'A'");
	}
	public SQLJob yearLimitSQL(String accountYear,String accountKind,BigDecimal unit , String debtType){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select ");
		//年度
		sqljob.appendSQL("case ");
		sqljob.appendSQL("when (account_year ='088' and year_kind='1' ) then '088' ");
		sqljob.appendSQL("when ((account_year ='088' and year_kind='2') or account_year ='089' ) then '088上半及089' ");
		sqljob.appendSQL("else account_year ");
		sqljob.appendSQL("end as account_year,");
		sqljob.appendSQL("account_kind,");
		//為排限(新增)
		sqljob.appendSQL("sum(case when (debt_type in ("+debtType+") and budget_code in ('1','2') and bound_code ='1' and is_account='N' and is_debt = 'N' ) then issue_amount else 0 end)/"+unit+" as T1_1 ");
		sqljob.appendSQL("from central_statistics_main ");
		sqljob.appendSQL("where account_year = '"+accountYear+"' ");
		sqljob.appendSQL("and account_kind = '"+accountKind+"' ");
		sqljob.appendSQL("group by ");
		sqljob.appendSQL("case ");
		sqljob.appendSQL("when (account_year ='088' and year_kind='1' ) then '088' ");
		sqljob.appendSQL("when ((account_year ='088' and year_kind='2') or account_year ='089' ) then '088上半及089' ");
		sqljob.appendSQL("else account_year end ,");
		sqljob.appendSQL("account_kind ");
		sqljob.appendSQL("order by 1,2 ");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	/**
	 * 計算累積未償餘額countNOPayList
	 * 傳入值:List tList = SQL查詢 發行額與還本額 歷年明細表
	 * 傳入值:String [] otherField = 不列為計算的欄位
	 * 傳入值:String [] issueField = 各債種發行額欄位
	 * 傳入值:String [] PayField = 各債種還本欄位
	 */
	protected List countNOPayList(List tList,String [] otherField,String [] issueField,String [] PayField){
		return countNOPayList(tList,otherField,issueField,PayField,"noKind");
	}
	
	/**
	 * 計算累積未償餘額countNOPayList
	 * 
	 * 傳入值:List tList = SQL查詢 發行額與還本額 歷年明細表
	 * 傳入值:String [] otherField = 不列為計算的欄位
	 * 傳入值:String [] issueField = 各債種發行額欄位
	 * 傳入值:String [] PayField = 各債種還本欄位
	 * 傳入值:String AccountKind = account_kind的欄位名稱(若AccountKind = "noKind" 不分類別計算)
	 * 傳回 List = 計算後的 發行額與未償餘額 歷年明細表
	 */
	@SuppressWarnings("unchecked")
	protected List countNOPayList(List tList,String [] otherField,String [] issueField,String [] PayField,String AccountKind){
		List dList = new ArrayList();
		Map tMap = new HashMap();
		Map dMap = new HashMap();
		
		//payAmount未償餘額陣列 [account_kind][未償餘額欄位]
		BigDecimal [][] noPayAmount = new BigDecimal[4][PayField.length];
		for (int ii = 0 ; ii  < 4 ; ii++ ){
			for (int jj = 0 ; jj < PayField.length ; jj++ ){
				noPayAmount[ii][jj] = new BigDecimal(0);
			}
		}
		
		//何種account_kind的index變數
		int kind = 0;
		
		//哪一個未償餘額欄位的index變數
		int rIndex = 0;
		
		//逐筆記算
		for (Iterator it1 = tList.iterator(); it1.hasNext();){
			tMap = (Map) it1.next();
			dMap = new HashMap();
			//何種account_kind,得到 payAmount[kind][?]的kind之index值
			if ("noKind".equals(AccountKind))
				kind=0;
			else
				kind = Integer.parseInt((String)tMap.get(AccountKind))-1;
			
			//先寫入其他不列入計算的欄位
			for (int k = 0 ; k < otherField.length ; k++ ){
				dMap.put(otherField[k],tMap.get(otherField[k]));
			}
			
			//依各債種將noPayAmount加上今年的發行數
			for (int j = 0 ; j < issueField.length ; j++ ){
				rIndex = Integer.parseInt(issueField[j].substring(2,issueField[j].length()))-1;
				noPayAmount[kind][rIndex] = noPayAmount[kind][rIndex].add((BigDecimal)tMap.get(issueField[j]));
				dMap.put(issueField[j],(BigDecimal)tMap.get(issueField[j]));
			}
			
			//依各債種將noPayAmount減掉今年的還本數
			for (int i = 0 ; i < PayField.length ; i++ ){
				noPayAmount[kind][i]=noPayAmount[kind][i].subtract((BigDecimal)tMap.get(PayField[i]));
				dMap.put(PayField[i],noPayAmount[kind][i]);
			}
			dList.add(dMap);
		}
		return dList;
	}
	
	/**GARA33使用
	 * 預算數的本年度未償餘額=上一年度的未償餘額(決算數)+本年度的舉借數(預算數)-本年度的還本數(預算數)
	 * 計算累積未償餘額countNOPayList
	 * 傳入值:List tList = SQL查詢 發行額與還本額 歷年明細表
	 * 傳入值:String [] otherField = 不列為計算的欄位
	 * 傳入值:String [] issueField = 各債種發行額欄位
	 * 傳入值:String [] PayField = 各債種還本欄位
	 * 傳入值:String AccountKind = account_kind的欄位名稱(若AccountKind = "noKind" 不分類別計算)
	 * 傳回 List = 計算後的 發行額與未償餘額 歷年明細表
	 */
	@SuppressWarnings("unchecked")
	protected List countNOPayListGara33(List tList,String [] otherField,String [] issueField,String [] PayField,String AccountKind){
		List dList = new ArrayList();
		Map tMap = new HashMap();
		Map dMap = new HashMap();
		
		//payAmount未償餘額陣列 [account_kind][未償餘額欄位]
		BigDecimal [][] noPayAmount = new BigDecimal[4][PayField.length];
		//發行數的暫存
		BigDecimal [] tempTotal = new BigDecimal[PayField.length];
		//上年度決算數的暫存
		BigDecimal [] lastAuditIssueAmount = new BigDecimal[PayField.length];
		BigDecimal [] lastAuditPayAmount = new BigDecimal[PayField.length];
		for (int ii = 0 ; ii  < 4 ; ii++ ){
			for (int jj = 0 ; jj < PayField.length ; jj++ ){
				noPayAmount[ii][jj] = new BigDecimal(0);
				tempTotal[jj] = new BigDecimal(0);
				lastAuditIssueAmount[jj] = new BigDecimal(0);
				lastAuditPayAmount[jj] = new BigDecimal(0);
			}
		}
		 
		//何種account_kind的index變數
		int kind = 0;
		
		//哪一個未償餘額欄位的index變數
		int rIndex = 0;
		
		//逐筆記算
		for (Iterator it1 = tList.iterator(); it1.hasNext();){
			tMap = (Map) it1.next();
			dMap = new HashMap();
			/*何種account_kind,得到 payAmount[kind][?]的kind之index值
			 * kind = 0 =>預算數
			 * 		= 1 =>決算數
			 * 		= 2 =>保留數
			 * 		= 3 =>實際數
			 */
			if ("noKind".equals(AccountKind))
				kind=0;
			else
				kind = Integer.parseInt((String)tMap.get(AccountKind))-1;
			
				
			//先寫入其他不列入計算的欄位
			for (int k = 0 ; k < otherField.length ; k++ ){
				dMap.put(otherField[k],tMap.get(otherField[k]));
			}
			
			//清除tempTotal發行數的暫存
			for (int jjj = 0 ; jjj < PayField.length ; jjj++ ){
				tempTotal[jjj] = new BigDecimal(0);
			}
			
			//依各債種計算出總發行數
			for (int j = 0 ; j < issueField.length ; j++ ){
				rIndex = Integer.parseInt(issueField[j].substring(2,issueField[j].length()))-1;
				tempTotal[rIndex] = tempTotal[rIndex].add((tMap.get(issueField[j])!=null)?(BigDecimal)tMap.get(issueField[j]):new BigDecimal(0));
				dMap.put(issueField[j],(BigDecimal)tMap.get(issueField[j]));
			}
			for(int z = 0 ; z < PayField.length ; z++){
				if(kind == 0){
					//預算數的本年度未償餘額=上一年度的未償餘額(X)+本年度的舉借數(預算數)-本年度的還本數(預算數)
					//先取得上年度決算數判斷是否為0,X取預算數反之取決算數
					if(!((String)tMap.get("account_year")).equals("088上半及089")){
						if(Integer.parseInt((String)((Map)tList.get(tList.size()-1)).get("account_year"))>new Date().getYear()-11 ){
							if(Integer.parseInt((String)((Map)tList.get(tList.size()-1)).get("account_year"))-1 <= Integer.parseInt((String)tMap.get("account_year"))){
								if(lastAuditIssueAmount[z].compareTo(new BigDecimal(0)) ==0 && lastAuditPayAmount[z].compareTo(new BigDecimal(0))==0)
									noPayAmount[kind][z] = noPayAmount[kind][z].add(tempTotal[z]).subtract((BigDecimal)tMap.get(PayField[z]));
								else
									noPayAmount[kind][z] = noPayAmount[kind+1][z].add(tempTotal[z]).subtract((BigDecimal)tMap.get(PayField[z]));
							}else
								noPayAmount[kind][z] = noPayAmount[kind+1][z].add(tempTotal[z]).subtract((BigDecimal)tMap.get(PayField[z]));
						}
						else
							noPayAmount[kind][z] = noPayAmount[kind+1][z].add(tempTotal[z]).subtract((BigDecimal)tMap.get(PayField[z]));
					}
					else
						noPayAmount[kind][z] = noPayAmount[kind+1][z].add(tempTotal[z]).subtract((BigDecimal)tMap.get(PayField[z]));
				}
				else
					noPayAmount[kind][z] = noPayAmount[kind][z].add(tempTotal[z]).subtract((BigDecimal)tMap.get(PayField[z]));
				//若當年發行與還本皆為0則未償餘額顯示為0
//				if(tempTotal[z].compareTo(new BigDecimal(0))==0 && ((BigDecimal)tMap.get(PayField[z])).compareTo(new BigDecimal(0))==0)
//					dMap.put(PayField[z],new BigDecimal(0));
//				else
					dMap.put(PayField[z],noPayAmount[kind][z]);
				//dMap.put(PayField[z],noPayAmount[kind][z]);
			}
			
			//或為決算數將資料放進暫存檔
			if(kind == 1){
				for (int i = 0 ; i < PayField.length ; i++ ){
					lastAuditIssueAmount[i] = new BigDecimal(0);
					lastAuditPayAmount[i] = new BigDecimal(0);
				}
				for(int i = 0 ; i < issueField.length ; i++){
					int tempIndex = Integer.parseInt(issueField[i].substring(2,issueField[i].length()))-1;
					lastAuditIssueAmount[tempIndex] = lastAuditIssueAmount[tempIndex].add((tMap.get(issueField[i])!=null)?(BigDecimal)tMap.get(issueField[i]):new BigDecimal(0));
				}
				for(int i = 0 ; i < PayField.length ; i ++){
					lastAuditPayAmount[i] = lastAuditPayAmount[i].add((BigDecimal)tMap.get(PayField[i]));
				}
			}
		/*  mark by Andrew 2006/10/23
			//依各債種將noPayAmount加上今年的發行數
			for (int z = 0 ; z < PayField.length ; z++ ){
				//預算數的本年度未償餘額=上一年度的未償餘額(決算數/預算數)+本年度的舉借數(預算數)-本年度的還本數(預算數)
				if (kind==0){
					if(((BigDecimal)tMap.get(issueField[z])).compareTo(new BigDecimal(0))==0 && ((BigDecimal)tMap.get(PayField[z])).compareTo(new BigDecimal(0))==0)
						noPayAmount[kind][z]=noPayAmount[kind][z].add(new BigDecimal(0));
					else
						noPayAmount[kind][z]=noPayAmount[kind+1][z].add(tempTotal[z]);
				}
				else
					noPayAmount[kind][z] = noPayAmount[kind][z].add(tempTotal[z]);
				
			}
			
			//依各債種將noPayAmount減掉今年的還本數
			for (int i = 0 ; i < PayField.length ; i++ ){
				if(((BigDecimal)tMap.get(issueField[i])).compareTo(new BigDecimal(0))==0 && ((BigDecimal)tMap.get(PayField[i])).compareTo(new BigDecimal(0))==0)
					noPayAmount[kind][i]=noPayAmount[kind][i].subtract(new BigDecimal(0));
				else
					noPayAmount[kind][i]=noPayAmount[kind][i].subtract((BigDecimal)tMap.get(PayField[i]));
				if(tempTotal[i].compareTo(new BigDecimal(0))==0 && ((BigDecimal)tMap.get(PayField[i])).compareTo(new BigDecimal(0))==0)
					dMap.put(PayField[i],new BigDecimal(0));
				else
					dMap.put(PayField[i],noPayAmount[kind][i]);
			}
		*/
			dList.add(dMap);
		}
		return dList;
	}
	
	
	//取得歲出總額值照(預,決,實)分別
	protected BigDecimal getYearAmountBKind(Connection conn,String accountYear,BigDecimal unit,String kind)throws Exception{
		Map bMap = getQueryMap(conn,yearAmountBKindSQL(accountYear,unit));
		BigDecimal amount = new BigDecimal(0);
		if (bMap != null && !bMap.isEmpty()){
			switch (Integer.parseInt(kind)){
			case 1:
				amount = (BigDecimal)bMap.get("budget_amount");
				break;
			case 2:
				amount = (BigDecimal)bMap.get("audit_amount");
				break;
			case 3:
				amount = new BigDecimal(0);
				break;
			case 4:
				amount = (BigDecimal)bMap.get("real_amount");
				break;
			}
		}else{
			amount = new BigDecimal(0);
		}
		return amount;
	}
	
	//取得歲出總額值
	public BigDecimal getYearAmountB(Connection conn,String accountYear,BigDecimal unit) throws Exception{
		Map bMap = getQueryMap(conn,yearAmountBSQL(accountYear,unit));
		return getAllAmount(bMap,"year_amount");
	}
	
	/*取得支(歲)出值 (kind="1"含排除債限,kind="2"不含排除債限)
	 *取得歲出總額值照(預,決,實)分別 (account_kind="1"(預),account_kind="2"(決),account_kind="4"(實))
	 */
	protected BigDecimal getYearAmountKind(Connection conn,String accountYear,BigDecimal unit,String kind,String accountKind)throws Exception{
		Map bMap = getQueryMap(conn,yearAmountKindSQL(accountYear,unit,kind));
		BigDecimal amount = new BigDecimal(0);
		if (bMap != null && !bMap.isEmpty()){
			switch (Integer.parseInt(accountKind)){
			case 1:
				amount = (BigDecimal)bMap.get("budget_amount");
				break;
			case 2:
				amount = (BigDecimal)bMap.get("audit_amount");
				break;
			case 3:
				amount = new BigDecimal(0);
				break;
			case 4:
				amount = (BigDecimal)bMap.get("real_amount");
				break;
			}
		}else{
			amount = new BigDecimal(0);
		}
		return amount;
	}
	
	//取得支(歲)出值 (kind="1"排限,kind="2"非排限)
	public BigDecimal getYearAmount(Connection conn,String accountYear,BigDecimal unit,String kind) throws Exception{
		Map bMap = getQueryMap(conn,yearAmountSQL(accountYear,unit,kind));
		return getAllAmount(bMap,"year_amount");
	}
	
	//取得GNP值
	protected BigDecimal getGNP(Connection conn,String accountYear,BigDecimal unit)throws Exception {
		Map GNPMap = getQueryMap(conn,GNPSQL(accountYear,unit));
//		if (Integer.parseInt(accountYear)==89)
//			return getAllAmount(GNPMap,"GNP");
//		else
			return getAllAmount(GNPMap,"GNP");
	}
	
	//取得GDP值
	protected BigDecimal getGDP(Connection conn,String accountYear,BigDecimal unit) throws Exception{
		Map GDPMap = getQueryMap(conn,GDPSQL(accountYear,unit));
		return getAllAmount(GDPMap,"GDP");
	}
	
	//取得perGNP值
	protected BigDecimal getPerGNP(Connection conn,String accountYear,BigDecimal unit) throws Exception{
		Map perGNPMap = getQueryMap(conn,perGNPSQL(accountYear,unit));
		return getAllAmount(perGNPMap,"perGNP");
	}
	
	/*取得調整數
	 * 取得歲出總額值照(預,決,實)分別 (account_kind="1"(預),account_kind="2"(決),account_kind="4"(實))
	 */
	protected BigDecimal getAdjustAmountKind(Connection conn,String accountYear,BigDecimal unit,String kind) throws Exception{
		Map bMap = getQueryMap(conn,yearAdjustAmountKindSQL(accountYear,unit));
		BigDecimal amount = new BigDecimal(0);
		if (bMap != null && !bMap.isEmpty()){
			switch (Integer.parseInt(kind)){
			case 1:
				amount = (BigDecimal)bMap.get("budget_adjust_amount");
				break;
			case 2:
				amount = (BigDecimal)bMap.get("audit_adjust_amount");
				break;
			case 3:
				amount = new BigDecimal(0);
				break;
			case 4:
				amount = (BigDecimal)bMap.get("real_adjust_amount");
				break;
			}
		}else{
			amount = new BigDecimal(0);
		}
		return amount;
	}
	//取取得調整數
	protected BigDecimal getAdjustAmount(Connection conn,String accountYear,BigDecimal unit) throws Exception{
		Map bMap = getQueryMap(conn,yearAdjustAmountSQL(accountYear,unit));
		return getAllAmount(bMap,"adjust_amount");
	}
	
	//得甲類調整數
	protected BigDecimal getLimitAmount(Connection conn,String accountYear,String accountKind,BigDecimal unit) throws Exception{
		return getLimitAmount(conn,accountYear,accountKind,unit,"'A'");
	}
	protected BigDecimal getLimitAmount(Connection conn,String accountYear,String accountKind,BigDecimal unit,String debtType) throws Exception{
		Map bMap = getQueryMap(conn,yearLimitSQL(accountYear,accountKind,unit,debtType));
		return getAllAmount(bMap,"T1_1");
	}
	//取得查詢的map
	protected Map getQueryMap(Connection conn,SQLJob job)throws Exception{
		SQLRunner runner = new ConnectionSQLRunner(conn);
		Map dMap = (Map) runner.query(job,new MapHandler());
		return dMap;
	}
	
	//是否除0 ,除0傳回0
	protected BigDecimal divideCheck(BigDecimal beAmount,BigDecimal divideAmount){
		return divideCheck(beAmount,divideAmount,4);
	}
	protected BigDecimal divideCheck(BigDecimal beAmount,BigDecimal divideAmount,int scale){
		BigDecimal amount = new BigDecimal(0);
		if (divideAmount.intValue() != 0)
			amount = beAmount.divide(divideAmount,scale,5);
		return amount;
	}
	//相除結果為百分比數值
	protected BigDecimal dividePercent(BigDecimal beAmount,BigDecimal divideAmount){
		BigDecimal amount = new BigDecimal(0);
		if (divideAmount.intValue() != 0)
			amount = beAmount.divide(new BigDecimal(100)).divide(divideAmount,4,5);
		return amount;
	}
	
	//為null給BigDeciaml(0)
	protected BigDecimal getAllAmount(Map tMap , String key){
		BigDecimal amount = new BigDecimal(0);
		if (tMap != null && !tMap.isEmpty())
			amount = (BigDecimal)tMap.get(key);
		return amount;
	}
	
	//為0給Null值
	protected BigDecimal getNullValue(BigDecimal amount){
		if (amount.intValue() == 0)
			amount=null;
		return amount;
	}
	
	public SQLJob accountKindSQL(String accountYear,String debtType){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select top 1 account_kind from Central_statistics_main A ");
		sqljob.appendSQL("where debt_type IN ("+debtType+") ");
		sqljob.appendSQL("and account_type='Y' ");
		sqljob.appendSQL("and account_year="+accountYear+" ");
		sqljob.appendSQL("group by account_year,account_kind ");
		return sqljob;
	}
	
	public String getAccountKind(Connection conn ,String accountYear,String debtType)throws Exception{
		String kind ="";
		SQLRunner runner = new ConnectionSQLRunner(conn);
		Map tMap = (Map) runner.query(accountKindSQL(accountYear,debtType),new MapHandler());
		if (tMap !=null && tMap.size()>0){
			kind = (String)tMap.get("account_kind");
		}
		return kind;
	}
	
	public String getStrYear(String qryYear){
		qryYear=qryYear.trim();
		if (qryYear.length() < 3 && !"".equals(qryYear)){
			for (int j = 0 ; j < 3-qryYear.length() ; j++){
				qryYear = "0" + qryYear;
			}	
		}
		return qryYear;
	}
	
}
