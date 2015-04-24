/* APRA1101.java 報表
 程式目的：APRA11
 程式代號：APRA11
 程式日期：0950308
 程式作者：Eric.Chen
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
 --------------------------------------------------------
 */
package tw.gov.nta.debt.action;

import gov.dnt.tame.common.ExcelReportBaseAction;
import gov.dnt.tame.util.DateUtil;

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

import tw.gov.nta.debt.form.Apra1101Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class APRA1101 extends ExcelReportBaseAction {

	protected SQLJob SQL1(Integer bankId,int Year,int sMonth,int eMonth)
	{
		/*
		Apra1101Form apra1101form = (Apra1101Form) form;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("   ");
		sqljob.appendSQL("INSERT INTO APRA11_RPT ( USRID, MOD_DATE, t_flag , pay_period ,debt_name , t1 , t2 ,t3 , t4 , t5 ,t6 ) ");
        //                                         1      2         3        4           5           6   7    8    9   10   11                  
		sqljob.appendSQL(" select '" + usrId + "' , CURRENT_TIMESTAMP , ");//1,2
		sqljob.appendSQL(" (case when p_flag='P' then 1 else 2 end ) t_flag, ");//3
		sqljob.appendSQL(" max(convert(varchar,p_year))+'年'+(case when p_period='1' then '1月-6月' else '7月-12月' end) pay_period,  ");//4
		sqljob.appendSQL(" max(b.debt_name) as debt_name,  ");//5
		sqljob.appendSQL(" (case when p_flag='P'  then  p_times else 0 end) as t1,  "); //6--本次別
		sqljob.appendSQL(" (case when p_flag='I'  then  p_times else 0 end) as t2,  ");//7--息次別
		sqljob.appendSQL(" sum(i_amt) as T3,  "); //8--撥入基金
		sqljob.appendSQL(" sum(p_amt) as T4, "); //9--本期經付數 
		sqljob.appendSQL(" sum(t_amt) as T5, "); //10--累計經付數 
		sqljob.appendSQL(" sum(bal) as T6  "); //11--基金餘額 
		sqljob.appendSQL(" from issue_main b,paida c  ");
		sqljob.appendSQL(" where  '0'+substring(c.bond_id,2,2) = b.account_year  ");
		sqljob.appendSQL(" and cast(right(c.bond_id,2) as int)  = b.serial_no  ");
		sqljob.appendSQL(" and substring(c.bond_id,4,1) = b.bond_type  ");
		sqljob.appendSQL(" and debt_type = 'A'  ");
		
		if(null != apra1101form.getBankId() && !apra1101form.getBankId().equals(0))
		{
			sqljob.appendSQL("and c.bank_code = ? ");
			sqljob.addParameter(apra1101form.getBankId());
		}	
		if(null != apra1101form.getCloseSdate())
		{
			sqljob.appendSQL("and p_year >= ? ");
			sqljob.addParameter(DateUtil.date2ROCStr(apra1101form.getCloseSdate()).substring(0,3));
		}	
		if(null != apra1101form.getCloseEdate())
		{
			sqljob.appendSQL("and p_year <= ? ");
			sqljob.addParameter(DateUtil.date2ROCStr(apra1101form.getCloseEdate()).substring(0,3));
		}	
		sqljob.appendSQL(" group by c.p_flag,p_times,p_period ");
		sqljob.appendSQL(" order by 1,2,3 ");
		*/
		
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select distinct ");
		sqljob.appendSQL("P.BOND_ID,");
		sqljob.appendSQL("P.P_FLAG,");
		sqljob.appendSQL("P.P_TIMES,");
		sqljob.appendSQL("(case when P.P_FLAG='P' then 1 else 2 end ) t_flag,");
		sqljob.appendSQL("convert(varchar,p_year)+'年'+(case when p_period='1' then '1月-6月' else '7月-12月' end) pay_period,");
		sqljob.appendSQL("(case when P.P_FLAG='P' then P.P_TIMES else 0 end) as t1,");
		sqljob.appendSQL("(case when P.P_FLAG='I'  then P.P_TIMES else 0 end) as t2,");
		sqljob.appendSQL("P.I_AMT as t3,"); 
		sqljob.appendSQL("P.P_AMT as t4,"); 
		sqljob.appendSQL("P.T_AMT as t5,"); 
		sqljob.appendSQL("P.BAL as t6,");
		sqljob.appendSQL("B.BANK_FNAME,");
		sqljob.appendSQL("B.BANK_CODE ");
		sqljob.appendSQL("from PAIDA P, BANKF B ");
		sqljob.appendSQL("where B.BANK_CODE=P.BANK_CODE ");
		sqljob.appendSQL("and B.BANK_CODE="+bankId+" ");
		sqljob.appendSQL("and P.P_YEAR="+Year+" ");
		//sqljob.appendSQL("and P.P_PERIOD=2 ");
		sqljob.appendSQL(getPeriod(sMonth,eMonth));
		sqljob.appendSQL("ORDER BY B.BANK_FNAME,P.BOND_ID,P.P_FLAG, P.P_TIMES ");
		System.out.println("APRA1101-SQL1:"+sqljob);
		return sqljob;
	}
	
	protected String getPeriod(int sMonth , int eMonth){
		String sql = "";
		if (sMonth < 7 && eMonth  < 7){
			sql = "and P.P_PERIOD=1 ";
		}else if (sMonth < 7 && eMonth >= 7){
			sql = "and P.P_PERIOD in (1,2) ";
		}else if (sMonth >= 7 && eMonth >= 7){
			sql = "and P.P_PERIOD=2 ";
		}
		return sql;
	}
	
	public String getPaidaName(String bondID)
	{	
		String bondName = "";
		switch (Integer.parseInt(bondID.substring(3,4))){
		case 1:
			bondName = "中央政府公債 " + Integer.parseInt(bondID.substring(1,3)) + " 年甲類第 " + Integer.parseInt(bondID.substring(4,6)) + " 期";
			break;
		case 2:
			bondName = "中央政府公債 " + Integer.parseInt(bondID.substring(1,3)) + " 年乙類第 " + Integer.parseInt(bondID.substring(4,6)) + " 期";
			break;
		case 3:
			bondName = "中央政府公債 " + Integer.parseInt(bondID.substring(1,3)) + " 年重大交通建設甲類第" + Integer.parseInt(bondID.substring(4,6)) + " 期";
			break;
		case 4:
			bondName = "中央政府公債 " + Integer.parseInt(bondID.substring(1,3)) + " 年重大交通建設乙類第" + Integer.parseInt(bondID.substring(4,6)) + " 期";
			break;
		}
		return bondName;
	}
	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request, 
			Connection connection) throws Exception 
	{
		Apra1101Form myForm = (Apra1101Form) form;
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delSQLJob("APRA11_RPT",usrId)); 
		//執行 insert
		//預設 sYear及eYear為今年度
		int sYear = Integer.parseInt(DateUtil.date2ROCStr(new Date()).substring(0,3));
		int eYear = Integer.parseInt(DateUtil.date2ROCStr(new Date()).substring(0,3));
		//預設sMonth及eMonth為本月份
		int sMonth = Integer.parseInt(DateUtil.date2ROCStr(new Date()).substring(3,5));
		int eMonth = Integer.parseInt(DateUtil.date2ROCStr(new Date()).substring(3,5));
		//取得開始年度
		if( null != myForm.getCloseSdate() && !"".equals(myForm.getCloseSdate())){
			sYear = Integer.parseInt(DateUtil.date2ROCStr(myForm.getCloseSdate()).substring(0,3));
			sMonth = Integer.parseInt(DateUtil.date2ROCStr(myForm.getCloseSdate()).substring(3,5));
		}
		//取得結束年度
		if( null != myForm.getCloseEdate() && !"".equals(myForm.getCloseEdate())){
			eYear = Integer.parseInt(DateUtil.date2ROCStr(myForm.getCloseEdate()).substring(0,3));
			eMonth = Integer.parseInt(DateUtil.date2ROCStr(myForm.getCloseEdate()).substring(3,5));
		}
		
		for (int i = sYear; i <= eYear; i++){
			int selectSMonth = 1;
			int selectEMonth = 12;
			if (i == sYear ){
				selectSMonth = sMonth;
			}
			if ( i == eYear ){
				selectEMonth = eMonth;
			}
			List queryList1 = (List) run.query(SQL1(myForm.getBankId(),i,selectSMonth,selectEMonth), new MapListHandler());
			Map tMap = null;
			Map dMap = new HashMap();
			for (Iterator it1 = queryList1.iterator(); it1.hasNext();){
				tMap = (Map) it1.next();
				dMap.putAll(getCommonMap(usrId));
				dMap.put("t_flag",String.valueOf(tMap.get("t_flag")));
				dMap.put("pay_period",(String)tMap.get("pay_period"));//--經付期間
				dMap.put("debt_name",getPaidaName((String)tMap.get("BOND_ID")));//--公債名稱
				dMap.put("t1",String.valueOf(tMap.get("t1")));//--本次別
				dMap.put("t2",String.valueOf(tMap.get("t2")));//--息次別
				dMap.put("t3",new BigDecimal((Double)tMap.get("t3")));//--撥入基金
				dMap.put("t4",new BigDecimal((Double)tMap.get("t4")));//--本期經付數
				dMap.put("t5",new BigDecimal((Double)tMap.get("t5")));//--累計經付數
				dMap.put("t6",new BigDecimal((Double)tMap.get("t6")));//--基金餘額
				run.update(connection,insTemp("APRA11_RPT",dMap));
			}
		}
	}


}
