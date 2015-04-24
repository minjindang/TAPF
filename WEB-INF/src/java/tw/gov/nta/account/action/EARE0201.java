package tw.gov.nta.account.action;

import gov.dnt.tame.common.ExcelReportBaseAction;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class EARE0201 extends ExcelReportBaseAction
{
	private final static String TEMP_TABLE_NAME = "EARE02_RPT";

	protected SQLJob getAllDebtMainId(Date qryDate)
	{
		SQLJob sqljob = new SQLJob();
//		sqljob.appendSQL("SELECT distinct case when d.debt_code = 24 then 0 else d.debt_code end as sort_rule ,d.debt_code,\n");
//		sqljob.appendSQL("case when  d.debt_code=24 or d.debt_code=62 then i.account_year else '' end as account_year,\n");
//		sqljob.appendSQL(" case when d.debt_code=24 or d.debt_code=62 then i.account_year+'年度' else '' end + e.debit_name  as debt_name ,\n");
//		sqljob.appendSQL("case i.bond_type when 2 then '乙' else '甲' end as type \n");
//		sqljob.appendSQL("FROM issue_main i,debt_main d,debit_ref e \n");
//		sqljob.appendSQL("WHERE i.id=d.issue_id AND d.debt_code=e.id AND i.debt_type='A' AND i.issue_date<=? \n");
//		sqljob.appendSQL("order by case when d.debt_code = 24 or d.debt_code=62 then 0 else d.debt_code end,\n");
//		sqljob.appendSQL("case when  d.debt_code=24 or d.debt_code=62 then i.account_year else '' end,\n");
//		sqljob.appendSQL("case i.bond_type  when 2 then '乙' else '甲' end \n");
		
		sqljob.appendSQL("SELECT  distinct \n");
		sqljob.appendSQL("case when d.debt_code = 24 or d.debt_code=62 or d.debt_code = 63 then '0' else case when d.debt_code in (select id  from debit_ref where debit_name like '擴大公共投資建設%') then 'S' else   cast(d.debt_code as char) end  end as sort_rule , \n");
		sqljob.appendSQL("case when d.debt_code in (select id  from debit_ref where debit_name like '擴大公共投資建設%') then 'S' else cast(d.debt_code as char) end as debt_code, \n");
		sqljob.appendSQL("case when d.debt_code=24 or d.debt_code=62 then i.account_year else case when d.debt_code = 63 then 63 else '9999999'  end end  as account_year,\n");
		sqljob.appendSQL("case when d.debt_code in (select id  from debit_ref where debit_name like '擴大公共投資建設%') then '擴大公共投資建設計劃特別預算' else case when  d.debt_code=24 or d.debt_code=62 then i.account_year+'年度'  else  '' end  + e.debit_name end as debt_name , \n");
		sqljob.appendSQL("case i.bond_type when 2 then '乙' else '甲' end as type FROM issue_main i,debt_main d,debit_ref e\n");
		sqljob.appendSQL("WHERE i.id=d.issue_id AND d.debt_code=e.id \n");
		sqljob.appendSQL("AND i.debt_type='A' AND i.issue_date<=?\n");
		sqljob.appendSQL("and not (i.account_year  in (48,49,50) and i.bond_type = 2)\n");
		sqljob.appendSQL("order by \n");
		//sqljob.appendSQL("case when d.debt_code = 24 or d.debt_code=62 or d.debt_code = 63 then '0' else case when d.debt_code in (select id  from debit_ref where debit_name like '擴大公共投資建設%') then 'S' else   cast(d.debt_code as char) end  end,\n");
		sqljob.appendSQL("case when d.debt_code=24 or d.debt_code=62 then i.account_year else case when d.debt_code = 63 then 63 else '9999999'  end end, \n");
		sqljob.appendSQL("case i.bond_type  when 2 then '乙' else '甲' end\n");

		
		
		
//		sqljob.appendSQL("SELECT  distinct \n");
//		sqljob.appendSQL("case when d.debt_code = 24 or d.debt_code=62 or d.debt_code = 63 then 0 else d.debt_code end as sort_rule  \n");
//		sqljob.appendSQL(",d.debt_code, \n");
//		sqljob.appendSQL("case when  d.debt_code=24 or d.debt_code=62 then i.account_year else case when d.debt_code = 63 then 63 else ''  end end as account_year, \n");
//		sqljob.appendSQL("case when  d.debt_code=24 or d.debt_code=62 then i.account_year+'年度' else '' end + e.debit_name  as debt_name ,  \n");
//		sqljob.appendSQL("case i.bond_type when 2 then '乙' else '甲' end as type  \n");
//		sqljob.appendSQL("FROM issue_main i,debt_main d,debit_ref e  \n");
//		sqljob.appendSQL("WHERE i.id=d.issue_id  \n");
//		sqljob.appendSQL("AND d.debt_code=e.id  \n");
//		sqljob.appendSQL("AND i.debt_type='A'  \n");
//		sqljob.appendSQL("AND i.issue_date<=? \n");
//		sqljob.appendSQL("and not (i.account_year  in (48,49,50) and i.bond_type = 2) \n");
//		sqljob.appendSQL("order by \n");
//		sqljob.appendSQL("case when d.debt_code = 24 or d.debt_code=62 or d.debt_code = 63 then 0 else d.debt_code end,  \n");
//		sqljob.appendSQL("case when  d.debt_code=24 or d.debt_code=62 then i.account_year else case when d.debt_code = 63 then 63 else ''  end end, \n");
//		sqljob.appendSQL("case i.bond_type  when 2 then '乙' else '甲' end \n");
		
		sqljob.addParameter( new Timestamp( qryDate.getTime() ) );
		System.out.println(sqljob.toString());
		return sqljob;		
	}

	protected String getVoucherAmountSql(String debtName,String usrId,String type,
			String debtCode,String accountYear,Date qryDate,String typeCode)
	{
		//產生各項資料
			
		Map reportAccountInfo = getReportAccountInfo();
		StringBuffer queryString = new StringBuffer();
		queryString.append("SELECT ");
		
		for(Iterator iterator=reportAccountInfo.keySet().iterator();iterator.hasNext();) {
			String columnName = (String)iterator.next();
			String accountRule = (String)reportAccountInfo.get(columnName);
			
			StringTokenizer accountTokenizer = new StringTokenizer(accountRule,";");
			while(accountTokenizer.hasMoreTokens()) {
				String detailAccount = accountTokenizer.nextToken(); 
				StringTokenizer typeTokenizer = new StringTokenizer(detailAccount,":");
				
				String accountCode = typeTokenizer.nextToken();
				String accountType = typeTokenizer.nextToken();
//				20100928配合公債提前買回，將第二欄加入“撥交提前買回公債款”
				if(!"PD07".equals(accountCode) && !"PD08".equals(accountCode) && !"PD018".equals(accountCode)){
					queryString.append(" isnull(sum(case when a.account_code = '"+accountCode+"' then ");
					if("A".equals(accountType) || "B".equals(accountType) ) {
						if("B".equals(accountType)) {
							queryString.append(" case when m.phase_id = 6 or m.phase_id = 9 then 0 else ");
						}
						queryString.append(" case when d.account_type = a.account_type ");
						
						queryString.append(" then d.account_amount else d.account_amount * -1 end ");
						if("B".equals(accountType)) {
							queryString.append(" end");
						}
							
					}else {
						queryString.append(" case when d.account_type = '"+accountType+"' then d.account_amount else 0 end ");
					}	
					queryString.append(" else 0 end),0) ");
					if(accountTokenizer.hasMoreTokens()) {
						queryString.append("+");
					}else {
						queryString.append("as "+columnName+", \n");
					}
				}else if("PD07".equals(accountCode) || "PD08".equals(accountCode)){
					queryString.append(" isnull(sum(case when a.account_code = '"+accountCode+"' then ");
					if("A".equals(accountType) || "B".equals(accountType) ) {
						if("B".equals(accountType)) {
							queryString.append(" case when m.phase_id = 6 or m.phase_id = 9 then 0 else ");
						}
						queryString.append(" case when d.account_type = a.account_type ");
						
						queryString.append(" then d.account_amount else d.account_amount * -1 end ");
						if("B".equals(accountType)) {
							queryString.append(" end");
						}
							
					}else {
						queryString.append(" case when d.account_type = '"+accountType+"' then d.account_amount else 0 end ");
					}	
					queryString.append(" else 0 end),0) + ");
					if("PD07".equals(accountCode)){
						queryString.append(" isnull(sum(case when a.account_code = 'PD017' then");
						queryString.append(" case when d.account_type = a.account_type ");
						queryString.append(" then d.account_amount else 0 end");
						queryString.append(" else 0 end),0)");
					}else{
						queryString.append(" isnull(sum(case when a.account_code = 'PD018' then");
						queryString.append(" case when d.account_type = a.account_type ");
						queryString.append(" then d.account_amount else 0 end");
						queryString.append(" else 0 end),0)");
					}
					if(accountTokenizer.hasMoreTokens()) {
						queryString.append("+");
					}else {
						queryString.append("as "+columnName+", \n");
					}					
				}else{
					queryString.append(" isnull(sum(case when a.account_code = 'PC02' then ");
					queryString.append(" case when d.account_type = 'C' ");				
					queryString.append(" then case when m.phase_id = 175 then d.account_amount else 0 end");
					queryString.append(" else 0 end");
					queryString.append(" else 0 end),0) ");
					if(accountTokenizer.hasMoreTokens()) {
						queryString.append("+");
					}else {
						queryString.append("as "+columnName+", \n");
					}					
				}
			}
		}		
		queryString.append("'"+debtName+"' As DEBT_NAME,");
		queryString.append("'"+usrId+"' As usrId,");
		queryString.append("'"+type+"'  As type ");
		queryString.append("  FROM issue_main i,voucher_main M, voucher_det D ,account_ref A \n");
		queryString.append(" WHERE m.id=d.voucher_id \n");
		queryString.append("   AND i.id = M.issue_id \n");
		queryString.append("   AND A.id = D.account_code \n");
		if(debtCode.trim().equals("S"))
			queryString.append("   AND M.debt_code in (select id  from debit_ref where debit_name like '擴大公共投資建設%') \n");
		else
			queryString.append("   AND M.debt_code = "+debtCode+"\n");
		queryString.append("   AND case when M.debt_code = 24 or M.debt_code = 62 then case when i.account_year="+accountYear+" then 1 else 0 end else 1 end = 1 \n");
		queryString.append("   and M.voucher_Date <='"+DateUtil.date2Str(qryDate, "yyyy/MM/dd")+"' \n");
		queryString.append("   AND i.bond_type = "+typeCode+" \n");
		queryString.append("   And I.debt_type= 'A' \n");
		queryString.append("   And M.debt_type_id=1 \n");
		queryString.append("   And a.debt_type=1 \n And m.phase_id not in (20,19)");
		System.out.println(queryString.toString());

		return queryString.toString();
		
	}

	protected SQLJob insTemp(Map map)
	{
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO " + TEMP_TABLE_NAME);
		sqljob.appendSQL(" ( DEBT_NAME, type ");
		sqljob.appendSQL(" ,p11,p12,p13,p14 ");
		sqljob.appendSQL(" ,p21,p22,p23 ");
		sqljob.appendSQL(" ,p31,p32,p33 ");
		sqljob.appendSQL(" ,p41,p42,p43 ");
		sqljob.appendSQL(" ,p51,p52,p53 ");
		sqljob.appendSQL(" ,p61,p62,p63 ");
		sqljob.appendSQL(" ,p71,p72,p73,p74 ");
		sqljob.appendSQL(" ,USRID, MOD_DATE, REMARK ");
		sqljob.appendSQL(" ,t1 ");
		sqljob.appendSQL(" ) VALUES ( ");
		sqljob.appendSQL(" ?,?");
		sqljob.appendSQL(",?,?,?,?");
		sqljob.appendSQL(",?,?,?");
		sqljob.appendSQL(",?,?,?");
		sqljob.appendSQL(",?,?,?");
		sqljob.appendSQL(",?,?,?");
		sqljob.appendSQL(",?,?,?");
		sqljob.appendSQL(",?,?,?,?");
		sqljob.appendSQL(",?,?,?");
		sqljob.appendSQL(",?");
		sqljob.appendSQL(" ) ");
		
		BigDecimal capitalAmount=null,interestAmount = null;
		BigDecimal payableInterestAmount = null;
		BigDecimal advanceInterestAmount = null;
		sqljob.addParameter( map.get("DEBT_NAME") );
		sqljob.addParameter( map.get("type") );
		//應償付金額
		capitalAmount = (BigDecimal) map.get("p11");
		interestAmount = (BigDecimal)map.get("p12");
		payableInterestAmount = (BigDecimal)map.get("p13");
		sqljob.addParameter(capitalAmount);
		sqljob.addParameter(interestAmount);
		sqljob.addParameter(payableInterestAmount);
		sqljob.addParameter( capitalAmount.add(interestAmount).add(payableInterestAmount));
		
		//撥入基金總額
		capitalAmount = (BigDecimal) map.get("p21");
		interestAmount = (BigDecimal)map.get("p22");
		sqljob.addParameter(capitalAmount);
		sqljob.addParameter(interestAmount);
		sqljob.addParameter( capitalAmount.add(interestAmount));
		//償付國庫券
		capitalAmount = (BigDecimal) map.get("p31");
		interestAmount = (BigDecimal)map.get("p32");
		sqljob.addParameter(capitalAmount);
		sqljob.addParameter(interestAmount);
		sqljob.addParameter( capitalAmount.add(interestAmount));
		//基金存款餘額(兌付期限內已撥未付)
		capitalAmount = (BigDecimal) map.get("p41");
		interestAmount = (BigDecimal)map.get("p42");
		sqljob.addParameter(capitalAmount);
		sqljob.addParameter(interestAmount);
		sqljob.addParameter( capitalAmount.add(interestAmount));	

		//基金剩餘收回數
		capitalAmount = (BigDecimal) map.get("p51");
		interestAmount = (BigDecimal)map.get("p52");
		sqljob.addParameter(capitalAmount);
		sqljob.addParameter(interestAmount);
		sqljob.addParameter( capitalAmount.add(interestAmount));
		//撥入基金淨額
		capitalAmount = ((BigDecimal) map.get("p21")).subtract((BigDecimal) map.get("p51"));
		interestAmount = ((BigDecimal) map.get("p22")).subtract((BigDecimal) map.get("p52"));
		sqljob.addParameter(capitalAmount);
		sqljob.addParameter(interestAmount);
		sqljob.addParameter( capitalAmount.add(interestAmount));	
		
		//未到期數額
		capitalAmount = (BigDecimal) map.get("p71");
		interestAmount = (BigDecimal)map.get("p72");
		payableInterestAmount = (BigDecimal)map.get("p73");
		sqljob.addParameter(capitalAmount);
		sqljob.addParameter(interestAmount);
		sqljob.addParameter(payableInterestAmount);
		sqljob.addParameter( capitalAmount.add(interestAmount).add(payableInterestAmount));
		
		sqljob.addParameter( map.get("usrId") );
		sqljob.addParameter( new Timestamp( new Date().getTime() ) );
		sqljob.addParameter("");
		
		//公債提前買回-國庫提前買回公債(當月前)-國庫應撥數-利息
		interestAmount = (BigDecimal)map.get("t1");
		sqljob.addParameter(interestAmount);
//		System.out.println(sqljob.toString());
		return sqljob;
	}

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update( connection, delSQLJob(TEMP_TABLE_NAME,usrId) );
		run.update( connection, deleteSQL());

		AccountQueryForm myForm = (AccountQueryForm) form;
		Date qryDate = DateUtil.str2Date( DateUtil.getLastDateOfMonth(myForm.getAccountYear(),myForm.getMonth()) );
		List debtIdList = (List) run.query( getAllDebtMainId(qryDate), new MapListHandler());
		//String querySql = getVoucherAmountSql();
		Map type1SumMap = new HashMap();
		Map type2SumMap = new HashMap();
		Map totalSumMap = new HashMap();
		for(Iterator it=debtIdList.iterator();it.hasNext();)
		{
			Map debtMap = (Map) it.next();
			String debtCode = (String) debtMap.get("debt_code");
			String accountYear = debtMap.get("account_year").toString();
			String debtName = (String) debtMap.get("debt_name") ;
			System.out.println(debtName);
			String type = (String)debtMap.get("type");
			String typeCode = type.trim().equals("甲")?"1":"2";
			//Object[] parameters = {debtName,usrId,type,debtCode,accountYear,qryDate,typeCode};
			//SQLJob sqljob = new SQLJob(querySql,parameters);
			SQLJob sqljob = new SQLJob(getVoucherAmountSql(debtName,usrId,type,debtCode,accountYear,qryDate,typeCode));
			//getVoucherAmountSql()
			System.out.println(sqljob.toString());
			Map<String,Object> insertMap = (Map) run.query( sqljob, new MapHandler());
			
			Map sumMap = null;
			if("1".equals(typeCode)){
				sumMap = type1SumMap;
			}else{
				sumMap = type2SumMap;
			}
			
			for(Iterator sumIterator = insertMap.keySet().iterator();sumIterator.hasNext();){
				String keyString = (String)sumIterator.next();
				BigDecimal srcAmount = (BigDecimal)sumMap.get(keyString);
				BigDecimal srcTotalAmount = (BigDecimal)totalSumMap.get(keyString);
				
				if(srcAmount == null){
					srcAmount = new BigDecimal(0);
				}
				
				if(srcTotalAmount == null){
					srcTotalAmount = new BigDecimal(0);
				}		
				
				if (insertMap.get(keyString) instanceof BigDecimal) {
					BigDecimal trgAmount = (BigDecimal)insertMap.get(keyString);
					if(trgAmount == null){
						trgAmount = new BigDecimal(0);
					}
					sumMap.put(keyString,srcAmount.add(trgAmount));
					totalSumMap.put(keyString,srcTotalAmount.add(trgAmount));			
				}

				
			}
			if(null != insertMap.get("p23") && !"".equals(insertMap.get("p23")) && new BigDecimal(insertMap.get("p23").toString()).compareTo(new BigDecimal(0)) != 0)
				System.out.println(insertMap.get("p23"));
			run.update(connection,insTemp(insertMap));
		}
		type1SumMap.put("DEBT_NAME","合計(甲)");
		type1SumMap.put("type","甲");
		type1SumMap.put("usrId",usrId);
		run.update(connection,insTemp(type1SumMap));
		type2SumMap.put("DEBT_NAME","合計(乙)");
		type2SumMap.put("type","乙");
		type2SumMap.put("usrId",usrId);
		run.update(connection,insTemp(type2SumMap));
		totalSumMap.put("DEBT_NAME","總計");
		totalSumMap.put("type","");
		totalSumMap.put("usrId",usrId);
		run.update(connection,insTemp(totalSumMap));
	}

	private Map getReportAccountInfo(){

		String[] accountRules = {"PC01:D","PC02:D","PC13:D","PD07:C","PD08:C","PC07:D","PC08:D",
				                 "PC04:B","PC05:B","PC10:B","PC11:B","PD01:A","PD02:A","PC13:A","PD018:A"};
		
		String[] columnName = {"p11","p12","p13","p21","p22","p31","p32",
								"p41","p42","p51","p52","p71","p72","p73","t1"};
		
		Map reportAccountInfo = new HashMap();
		for(int i=0;i<accountRules.length;i++) {
			reportAccountInfo.put(columnName[i],accountRules[i]);
		}
		
		return reportAccountInfo;
	}

	/**
	 * 實況彙總表，刪除生產的過往傳票
	 * @return
	 */
	protected SQLJob deleteSQL()
	{
		SQLJob sqljob = new SQLJob();
		String systemDate = DateUtil.getSystemDate();
		String systemYear = systemDate.substring(0,3);
		String systemMonth = systemDate.substring(3,5);
		String lastDate = DateUtil.dateFlipMonth(systemDate,-1);
		String lastYear = lastDate.substring(0,3);
		String lastMonth = lastDate.substring(3,5);
		String modDateS = systemYear+systemMonth+"01";//製作月份-起
		String modDateE = DateUtil.getLastDateOfMonth(systemYear,systemMonth);//製作月份-迄
		String voucherDateS = lastYear+lastMonth+"01";//非該月會計傳票月份-起
		String voucherDateE = DateUtil.getLastDateOfMonth(lastYear,lastMonth);//非該月會計傳票月份-迄
		
		modDateS = String.valueOf(Integer.parseInt(modDateS.substring(0,3))+1911)+modDateS.subSequence(3,modDateS.length());
		modDateE = String.valueOf(Integer.parseInt(modDateE.substring(0,3))+1911)+modDateE.subSequence(3,modDateE.length());
		voucherDateS = String.valueOf(Integer.parseInt(voucherDateS.substring(0,3))+1911)+voucherDateS.subSequence(3,voucherDateS.length());
		voucherDateE = String.valueOf(Integer.parseInt(voucherDateE.substring(0,3))+1911)+voucherDateE.subSequence(3,voucherDateE.length());
		
		sqljob.appendSQL(" delete voucher_main where id in (");
		sqljob.appendSQL(" select v.id from voucher_main v, issue_main i");
		sqljob.appendSQL(" where v.issue_id = i.id");
		sqljob.appendSQL(" and v.mod_date between ? and ?");
		sqljob.appendSQL(" and v.voucher_date not between ? and ?");
		sqljob.appendSQL(" and v.post_date is null");
		sqljob.appendSQL(" and i.debt_type = 'A')");
		sqljob.addParameter(modDateS);
		sqljob.addParameter(modDateE);
		sqljob.addParameter(voucherDateS);
		sqljob.addParameter(voucherDateE);
		System.out.println(sqljob.toString());
		return sqljob;
	}
}