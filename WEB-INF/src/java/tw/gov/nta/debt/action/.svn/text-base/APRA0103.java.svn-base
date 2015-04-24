package tw.gov.nta.debt.action;

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

import tw.gov.nta.debt.form.Apra0101Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class APRA0103 extends ExcelReportRemainAction {
	
	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM APRA01B_RPT ");
		System.out.println(sqljob);
		return sqljob;
	}
	protected SQLJob sqlTemp(ActionForm form,String usrId, String debtCode , String bondType){
		Apra0101Form myform = (Apra0101Form)form;
		SQLJob sqljob = new SQLJob();
		//sqljob.appendSQL("insert into APRA01B_RPT (usrid,mod_date,budget_name,debt_name,bond_type,capital_amount,interest_amount,charge_amount) ");
		//sqljob.appendSQL("select '"+usrId+"' , CURRENT_TIMESTAMP , ");
		sqljob.appendSQL("select d.budget_code as budget_code , ");
		sqljob.appendSQL("d.debt_code as debt_code ,  ");
		sqljob.appendSQL("'(' + case i.bond_type when '1'then '甲類' when '2' then '乙類' end +')' as bond_type,");
//		sqljob.appendSQL("i.bond_type ,");
		sqljob.appendSQL("sum(isnull(p.capital_amount,cast(0 as int))) as capital_amount , ");
		sqljob.appendSQL("sum(isnull(p.interest_amount,cast(0 as int))) as interest_amount , ");
		//sqljob.appendSQL("sum(isnull(p.charge_amount,cast(0 as int))) as charge_amount ");
		//20090901 將手續費利率調降為0.0075
//		sqljob.appendSQL("(sum(isnull(p.capital_amount,cast(0 as int)))+sum(isnull(p.interest_amount,cast(0 as int))))*0.0009 as charge_amount ");
		sqljob.appendSQL("case when P.REPAY_DATE < '2009-09-01' then ");
		sqljob.appendSQL("(sum(isnull(p.capital_amount,cast(0 as int)))+sum(isnull(p.interest_amount,cast(0 as int))))*0.0009 ");
		sqljob.appendSQL("else (sum(isnull(p.capital_amount,cast(0 as int)))+sum(isnull(p.interest_amount,cast(0 as int))))*0.00075 end as charge_amount ");
		sqljob.appendSQL("from issue_main i , debt_main d , debt_plan_det p ");
		sqljob.appendSQL("where i.id = d.issue_id and d.id = p.debt_id and i.debt_type = 'A' ");
		sqljob.appendSQL("and d.debt_code in ("+debtCode+")");
		sqljob.appendSQL("and i.bond_type = ? ");
		sqljob.appendSQL("and P.delete_mark <> 'Y' ");
		sqljob.addParameter(bondType);
		if(null != myform.getRepaySdate())
		{
			sqljob.appendSQL("and p.repay_date-1 >= ? ");
			sqljob.addParameter(myform.getRepaySdate());
		}	
		if(null != myform.getRepaySdate())
		{
			sqljob.appendSQL("and p.repay_date-1 <= ? ");
			sqljob.addParameter(myform.getRepayEdate());
		}
		sqljob.appendSQL("group by d.budget_code , d.debt_code , i.bond_type , p.repay_date");
//		sqljob.appendSQL("group by d.budget_code , d.debt_code , i.bond_type");
		sqljob.appendSQL("order by d.budget_code , d.debt_code , i.bond_type ");
		System.out.println(sqljob);
		return sqljob;
	}
	
	protected SQLJob sqlPayment2(ActionForm form, String debtCode , String bondType){
		SQLJob sqljob = new SQLJob();
		Apra0101Form myform = (Apra0101Form)form;
		
		sqljob.appendSQL("SELECT I.ACCOUNT_YEAR, I.SERIAL_NO, I.DUE_DATE AS REPAY_DATE, P.REPAY_DATE as ADVANCE_REPAY_DATE, ");
		sqljob.appendSQL("I.BOND_TYPE, I.DEBT_NAME, ");
		sqljob.appendSQL("(select debit_name from debit_ref where id = d.debt_code) as debit_name, ");
		sqljob.appendSQL("'1.'+convert(varchar,CAPITAL_SERIAL) as CAPITAL_SERIAL, ");
		sqljob.appendSQL("convert(varchar,p.interest_serial)+'.'+convert(varchar,p.CAPITAL_SERIAL) as interest_serial, ");
		sqljob.appendSQL("SUM(P.CAPITAL_AMOUNT) AS CAPITAL_AMOUNT, ");
		sqljob.appendSQL("SUM(P.INTEREST_AMOUNT) AS INTEREST_AMOUNT , ");
		sqljob.appendSQL("case when P.REPAY_DATE < '2009-09-01' then (SUM(P.CAPITAL_AMOUNT)+SUM(P.INTEREST_AMOUNT))*0.0009 ");
		sqljob.appendSQL("else (SUM(P.CAPITAL_AMOUNT)+SUM(P.INTEREST_AMOUNT))*0.00075 end AS CHARGE_AMOUNT , I.ID AS ISSUE_ID ");
		sqljob.appendSQL("FROM ISSUE_MAIN I, DEBT_MAIN D,payment_main P ");
		sqljob.appendSQL("WHERE I.id=D.ISSUE_ID AND D.ID=P.DEBT_ID AND I.DEBT_TYPE='A' ");
		sqljob.appendSQL("AND P.REPAY_DATE >= ? AND P.REPAY_DATE <= ? ");
		sqljob.appendSQL("and  P.REPAY_DATE <> P.PLAN_REPAY_DATE ");
		sqljob.appendSQL("and d.debt_code in ("+debtCode+")");
		sqljob.appendSQL("and i.bond_type = ? ");
		sqljob.appendSQL("GROUP BY p.interest_serial,p.CAPITAL_SERIAL,P.REPAY_DATE,I.DEBT_NAME,I.ACCOUNT_YEAR,I.SERIAL_NO,d.debt_code,I.BOND_TYPE,I.ID,I.DUE_DATE ");
		sqljob.appendSQL("ORDER BY P.REPAY_DATE,I.ACCOUNT_YEAR,I.SERIAL_NO ");

		sqljob.addParameter(myform.getRepaySdate());
		sqljob.addParameter(myform.getRepayEdate());
		sqljob.addParameter(bondType);
		System.out.println(sqljob.toString());
		return sqljob;
	}
	
	protected SQLJob debtCode(ActionForm form){
		SQLJob sqljob = new SQLJob();
		Apra0101Form myform = (Apra0101Form)form;
		
		sqljob.appendSQL("select DISTINCT i.bond_Type, d.debt_Code, ");
		sqljob.appendSQL("(select debit_name from debit_ref where id = d.debt_code) as debit_name ");
		sqljob.appendSQL("from issue_main i, debt_main d ");
		sqljob.appendSQL("where i.id = d.issue_id ");
		sqljob.appendSQL("and debt_type='A' ");
		if("1".equals(myform.getBondType()))
			sqljob.appendSQL("and i.bond_Type = 1");
		else if("2".equals(myform.getBondType()))
			sqljob.appendSQL("and i.bond_Type = 2");

		return sqljob;
	}
	
	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
		// 取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delTemp(form,usrId));
		//執行 insert
		
		Apra0101Form myform = (Apra0101Form)form;
		
		String[] debtCode = null;
		String[] bondType = null;
		String[] debtName = null;
		
		List debtCodeList = (List) run.query(debtCode(form), new MapListHandler());
		if(null!=debtCodeList && !debtCodeList.isEmpty()){
			debtCode = new String[debtCodeList.size()];
			bondType = new String[debtCodeList.size()];
			debtName = new String[debtCodeList.size()];
			int tmp = 0;
			for(Iterator it = debtCodeList.iterator();it.hasNext();){
				Map map = (Map)it.next();
				debtCode[tmp] = map.get("debt_Code").toString();
				bondType[tmp] = (String)map.get("bond_Type");
				debtName[tmp] = (String)map.get("debit_name");
				tmp++;
			}
		}
//		if(null == myform.getBondType() || "".equals(myform.getBondType())){
//			debtCode = new String[]{"24","31","30,49,50,51,52","27","27","26","29","28","47","60","23","67"};
//			bondType = new String[]{"1","1","1","1","2","2","1","1","2","1","1","1"};
//			debtName = new String[]{"總預算中央政府建設公債合計","債務基金公債","特別預算擴大公共投資建設計劃公債合計",
//					"特別預算重大交通建設公債合計","特別預算重大交通建設公債合計","特別預算北二高建設公債合計","特別預算SARS建設公債合計",
//					"特別預算921震災建設公債合計","非營業類基金公債","科學園區購地","特別預算基隆河整治建設公債合計","中央政府振興經濟消費券發放特別預算"};
//		}else if("1".equals(myform.getBondType())){
//			debtCode = new String[]{"24","31","30,49,50,51,52","27","29","28","60","23","67"};
//			bondType = new String[]{"1","1","1","1","1","1","1","1","1"};
//			debtName = new String[]{"總預算中央政府建設公債合計","債務基金公債","特別預算擴大公共投資建設計劃公債合計",
//					"特別預算重大交通建設公債合計","特別預算SARS建設公債合計",
//					"特別預算921震災建設公債合計","科學園區購地","特別預算基隆河整治建設公債合計","中央政府振興經濟消費券發放特別預算"};
//		}else if("2".equals(myform.getBondType())){
//			debtCode = new String[]{"27","26","47,37"};
//			bondType = new String[]{"2","2","2"};
//			debtName = new String[]{"特別預算重大交通建設公債合計","特別預算北二高建設公債合計","非營業類基金公債"};
//		}

		for(int i = 0 ; i < debtCode.length ; i++){
			Map newMap = new HashMap();
			newMap.put("budget_name", debtName[i]+((bondType[i].equals("1"))?"(甲類)":"(乙類)"));
			newMap.put("capital_amount", new BigDecimal(0));
			newMap.put("interest_amount", new BigDecimal(0));
			newMap.put("charge_amount", new BigDecimal(0));
			List queryList = (List) run.query(sqlTemp(form, usrId,debtCode[i],bondType[i]), new MapListHandler());
			for(Iterator it = queryList.iterator();it.hasNext();){
				Map map = (Map)it.next();
				newMap.put("capital_amount", ((BigDecimal)newMap.get("capital_amount")).add((BigDecimal)map.get("capital_amount")));
				newMap.put("interest_amount", ((BigDecimal)newMap.get("interest_amount")).add((BigDecimal)map.get("interest_amount")));
				newMap.put("charge_amount", ((BigDecimal)newMap.get("charge_amount")).add((BigDecimal)map.get("charge_amount")));
			}
//			if("1".equals(myform.getDisplay())){
				List paymentList = (List) run.query(sqlPayment2(form, debtCode[i],bondType[i]), new MapListHandler());
				if(null!=paymentList && !paymentList.isEmpty()){
					for(Iterator it2 = paymentList.iterator();it2.hasNext();){
						Map map2 = (Map)it2.next();
						newMap.put("capital_amount", ((BigDecimal)newMap.get("capital_amount")).add((BigDecimal)map2.get("capital_amount")));
						newMap.put("interest_amount", ((BigDecimal)newMap.get("interest_amount")).add((BigDecimal)map2.get("interest_amount")));
						newMap.put("charge_amount", ((BigDecimal)newMap.get("charge_amount")).add((BigDecimal)map2.get("charge_amount")));						
					}					
				}
//			}
			run.update(connection,insTemp("APRA01B_RPT",newMap));
		}
//		for(int i = 0; i<queryList.size();i++){
//			System.out.println(queryList.get(i));
//			Map map = (Map)queryList.get(i);
//			Map newMap = new HashMap();
//			if(Integer.parseInt(map.get("debt_code").toString())==24)
//				newMap.put("budget_name", "總預算中央政府建設公債合計"+map.get("bond_type"));
//			else if(Integer.parseInt(map.get("debt_code").toString())==31)
//				newMap.put("budget_name", "債務基金公債"+map.get("bond_type"));
//			else if(Integer.parseInt(map.get("debt_code").toString())==30 || (Integer.parseInt(map.get("debt_code").toString())>=49 && Integer.parseInt(map.get("debt_code").toString())<=52))
//				newMap.put("budget_name", "特別預算擴大公共投資建設計劃公債合計"+map.get("bond_type"));
//			else if(Integer.parseInt(map.get("debt_code").toString())==27)
//				newMap.put("budget_name", "特別預算重大交通建設公債合計"+map.get("bond_type"));
//			else if(Integer.parseInt(map.get("debt_code").toString())==26)
//				newMap.put("budget_name", "特別預算北二高建設公債合計"+map.get("bond_type"));
//			else if(Integer.parseInt(map.get("debt_code").toString())==29)
//				newMap.put("budget_name", "特別預算SARS建設公債合計"+map.get("bond_type"));
//			else if(Integer.parseInt(map.get("debt_code").toString())==28)
//				newMap.put("budget_name", "特別預算921震災建設公債合計"+map.get("bond_type"));
//			else if(Integer.parseInt(map.get("debt_code").toString())==47)
//				newMap.put("budget_name", "非營業類基金公債"+map.get("bond_type"));
//			else if(Integer.parseInt(map.get("debt_code").toString())==60)
//				newMap.put("budget_name", "科學園區購地"+map.get("bond_type"));
//			else if(Integer.parseInt(map.get("debt_code").toString())==23)
//				newMap.put("budget_name", "特別預算基隆河整治建設公債合計"+map.get("bond_type"));
//			else 
//				break;
//			newMap.put("capital_amount", map.get("capital_amount"));
//			newMap.put("interest_amount", map.get("interest_amount"));
//			newMap.put("charge_amount", map.get("charge_amount"));
//			run.update(connection,insTemp("APRA01B_RPT",newMap));
//		}	
	}
}
