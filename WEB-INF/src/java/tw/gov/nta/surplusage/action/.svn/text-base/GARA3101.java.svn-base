/* GARA3101.java 報表
 程式目的：GARA3101
 程式代號：GARA3101
 程式日期：0950602
 程式作者：Avery
 ////////////////////////////////////////////////////////
 修改作者　　修改日期　　　修改目的
 ////////////////////////////////////////////////////////
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

import tw.gov.nta.surplusage.common.Gara30ReMainList;
import tw.gov.nta.surplusage.common.Gara33ReMainList;
import tw.gov.nta.surplusage.common.Gara34ReMainList;
import tw.gov.nta.surplusage.form.Gara3101Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class GARA3101 extends ExcelReportRemainAction {
	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Gara3101Form myForm = (Gara3101Form) form;
		BigDecimal unit = new BigDecimal(myForm.getAmountUnit());
		//輸入的起始年
		Integer startYear = Integer.parseInt(myForm.getIssueSDate());
		//輸入的結束年
		Integer endYear = Integer.parseInt(myForm.getIssueEDate());
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delSQLJob("GARA31_RPT",usrId));
		//執行 insert
		//取得grar30未償餘額List物件
		//List qryGara30 = (List) run.query(CommonReportSQL.Gara30SQL(myForm.getIssueEDate(),unit), new MapListHandler());
		//Gara30ReMainList gara30 = new Gara30ReMainList(qryGara30);
		Gara30ReMainList gara30 = new Gara30ReMainList(connection,myForm.getIssueEDate(),new BigDecimal(1));
		Gara33ReMainList gara33 = new Gara33ReMainList(connection,myForm.getIssueEDate(),new BigDecimal(1));
		Gara34ReMainList gara34 = new Gara34ReMainList(connection,myForm.getIssueEDate(),new BigDecimal(1));
		String[] accountKind = {"1","2","4"};
		String qryYear = "";
		Map dMap = new HashMap();
		for (int i = startYear; i <= endYear; i++){
			for (int j = 0; j < accountKind.length; j++){
				qryYear = this.getStrYear(String.valueOf(i));
				//設定取得gara30哪一年資料
				gara30.setQryMap(qryYear,accountKind[j]);
				//設定取得gara33哪一年資料
				gara33.setQryMap(qryYear,accountKind[j]);
				//設定取得gara34哪一年資料
				gara34.setQryMap(qryYear,accountKind[j]);
				dMap.putAll(getCommonMap(usrId));
				//年度別
				dMap.put("item",gara30.getOtherKind("item"));
				/**
				 * 未償餘額
				 */
				//92年後使用gara33 gara34資料因為資料來源不同
				if(i<92){
					//甲類公債 
					dMap.put("t1",gara30.getReMainField(1).add(gara30.getReMainField(2)));
					//甲類借款
					dMap.put("t2",gara30.getReMainField(10));
					//甲類小計
					dMap.put("s1",((BigDecimal)dMap.get("t1")).add((BigDecimal)dMap.get("t2")));
					//乙類公債
					dMap.put("t3",gara30.getReMainField(3));
					//乙類借款
					dMap.put("t4",gara30.getReMainField(11));
					//省債
					dMap.put("t5",gara30.getReMainField(6).add(gara30.getReMainField(14)));
					//九二一等
					dMap.put("t6",gara30.getReMainField(4).add(gara30.getReMainField(12)));
					//債務基金
					dMap.put("t7",gara30.getReMainField(5).add(gara30.getReMainField(13)));
					//新生開發
					dMap.put("t8",gara30.getReMainField(7).add(gara30.getReMainField(15)));
					//糧食平準基金
					dMap.put("t9",gara30.getReMainField(8).add(gara30.getReMainField(16)));
					//非營業基金
					dMap.put("t10",gara30.getReMainField(18).add(gara30.getReMainField(19)));
					//總計
					if(i<91)
						dMap.put("s2",((BigDecimal)dMap.get("s1")).add((BigDecimal)dMap.get("t3")).add((BigDecimal)dMap.get("t4")).add((BigDecimal)dMap.get("t5")).add((BigDecimal)dMap.get("t6")).add((BigDecimal)dMap.get("t7")).add((BigDecimal)dMap.get("t8")).add((BigDecimal)dMap.get("t9")).add((BigDecimal)dMap.get("t10")));
					else
						dMap.put("s2",((BigDecimal)dMap.get("s1")).add((BigDecimal)dMap.get("t5")).add((BigDecimal)dMap.get("t6")).add((BigDecimal)dMap.get("t7")).add((BigDecimal)dMap.get("t8")).add((BigDecimal)dMap.get("t9")).add((BigDecimal)dMap.get("t10")));
				}
				else{
//					甲類公債 
					dMap.put("t1",gara33.getReMainField(1));
					//甲類借款
					dMap.put("t2",gara34.getReMainField(1).add(gara34.getReMainField(2)).add(gara34.getReMainField(3)));
					//甲類小計
					dMap.put("s1",((BigDecimal)dMap.get("t1")).add((BigDecimal)dMap.get("t2")));
					//乙類公債
					dMap.put("t3",gara33.getReMainField(2));
					//乙類借款
					dMap.put("t4",gara34.getReMainField(2));
					//省債
					dMap.put("t5",gara34.getReMainField(7));
					//九二一等
					dMap.put("t6",gara33.getReMainField(4).add(gara34.getReMainField(6)));
					//債務基金
					dMap.put("t7",gara33.getReMainField(5).add(gara34.getReMainField(10)));
					//新生開發
					dMap.put("t8",gara34.getReMainField(8));
					//糧食平準基金
					dMap.put("t9",gara34.getReMainField(9));
					//非營業基金
					dMap.put("t10",gara34.getReMainField(11));
					//總計
					dMap.put("s2",((BigDecimal)dMap.get("s1")).add((BigDecimal)dMap.get("t5")).add((BigDecimal)dMap.get("t6")).add((BigDecimal)dMap.get("t7")).add((BigDecimal)dMap.get("t8")).add((BigDecimal)dMap.get("t9")).add((BigDecimal)dMap.get("t10")));
				}
				//歲出
				if (i < 90)
					dMap.put("Budget_amount",this.getYearAmountKind(connection,qryYear,new BigDecimal(1),"1",accountKind[j]));
				else if (i >= 90)
					dMap.put("Budget_amount",this.getYearAmountKind(connection,qryYear,new BigDecimal(1),"2",accountKind[j]));
				//dMap.put("Budget_amount",this.getYearAmountBKind(connection,qryYear,unit,accountKind[j]));
				//GNP
				dMap.put("GNP_amount",this.getGNP(connection,qryYear,new BigDecimal(1)));
				//GDP
				dMap.put("GDP_amount",this.getGDP(connection,qryYear,new BigDecimal(1)));
				if(!accountKind[j].equals("1") && i>=new Date().getYear()-11)
					dMap.putAll(setZero(dMap));
				//各類/歲出
				dMap.putAll(setRate(dMap,"Budget",i));
				//各類/GNP
				dMap.putAll(setRate(dMap,"GNP",i));
				//各類/GDP
				dMap.putAll(setRate(dMap,"GDP",i));
				if(i == 89)
					dMap.put("GNP_amount",((BigDecimal)dMap.get("GNP_amount")).divide(new BigDecimal(1.5)));
				dMap.putAll(reduce(dMap,unit));
				run.update(connection,insTemp("GARA31_RPT",dMap));
			}
		}
        SQLJob queryJob1 = selTemp1();
        List queryList1 = (List) run.query(queryJob1, new MapListHandler());
        String remark = "	四、";
        for(Iterator it1=queryList1.iterator();it1.hasNext();)
        {
        	Map mapQry1 = (Map) it1.next();
        	remark += (String)mapQry1.get("debit_name")+",";
        }
        request.setAttribute("remark",remark.substring(0,remark.length()-1));
        request.setAttribute("remarkRow",endYear-startYear);
	}
	protected Map reduce(Map tMap,BigDecimal tUnit){
		String[] columnName = {"t1","t2","t3","t4","t5","t6","t7","t8","t9","t10","s1","s2","Budget_amount","GNP_amount","GDP_amount","Budget_sum","GNP_sum","GDP_sum"};
		for(int i = 0 ; i < columnName.length ; i ++){
			if(((BigDecimal)tMap.get(columnName[i])).intValue() != 0)
				tMap.put(columnName[i], ((BigDecimal)tMap.get(columnName[i])).divide(tUnit,0,BigDecimal.ROUND_HALF_UP));
		}
		return tMap;
	}
	@SuppressWarnings("unchecked")
	protected Map setZero(Map tMap){
		tMap.put("t1", new BigDecimal(0));
		tMap.put("t2", new BigDecimal(0));
		tMap.put("t3", new BigDecimal(0));
		tMap.put("t4", new BigDecimal(0));
		tMap.put("t5", new BigDecimal(0));
		tMap.put("t6", new BigDecimal(0));
		tMap.put("t7", new BigDecimal(0));
		tMap.put("t8", new BigDecimal(0));
		tMap.put("t9", new BigDecimal(0));
		tMap.put("t10", new BigDecimal(0));
		tMap.put("s1", new BigDecimal(0));
		tMap.put("s2", new BigDecimal(0));
		tMap.put("GDP_amount", new BigDecimal(0));
		tMap.put("GNP_amount", new BigDecimal(0));
		return tMap;
	}
	protected Map setRate(Map tMap,String key,int year){
		Map dMap = new HashMap();
		BigDecimal sum = new BigDecimal(0);
		BigDecimal rate = new BigDecimal(1);
		if(year==89 && key.equals("GNP"))
			rate = new BigDecimal(1.5);
		dMap.put(key+"_r1",divideCheck((BigDecimal)tMap.get("s1"),(BigDecimal)tMap.get(key+"_amount")).multiply(rate).multiply(new BigDecimal(100)));
		dMap.put(key+"_r2",divideCheck(((BigDecimal)tMap.get("t3")).add((BigDecimal)tMap.get("t4")),(BigDecimal)tMap.get(key+"_amount")).multiply(rate).multiply(new BigDecimal(100)));
		dMap.put(key+"_r3",divideCheck((BigDecimal)tMap.get("t5"),(BigDecimal)tMap.get(key+"_amount")).multiply(rate).multiply(new BigDecimal(100)));
		dMap.put(key+"_r4",divideCheck((BigDecimal)tMap.get("t6"),(BigDecimal)tMap.get(key+"_amount")).multiply(rate).multiply(new BigDecimal(100)));
		dMap.put(key+"_r5",divideCheck((BigDecimal)tMap.get("t7"),(BigDecimal)tMap.get(key+"_amount")).multiply(rate).multiply(new BigDecimal(100)));
		dMap.put(key+"_r6",divideCheck((BigDecimal)tMap.get("t8"),(BigDecimal)tMap.get(key+"_amount")).multiply(rate).multiply(new BigDecimal(100)));
		dMap.put(key+"_r7",divideCheck((BigDecimal)tMap.get("t9"),(BigDecimal)tMap.get(key+"_amount")).multiply(rate).multiply(new BigDecimal(100)));
		for (int i = 0 ; i < 7 ; i++){
			if(year >=91 && i+1 == 2)
				continue;
			sum = sum.add((BigDecimal)dMap.get(key+"_r"+String.valueOf(i+1)));
		}
		//dMap.put(key+"_sum",sum);
		//0970401 jyun
		dMap.put(key+"_sum",sum.multiply((BigDecimal)tMap.get(key+"_amount")).multiply(rate));
		return dMap;
	}

	protected SQLJob selTemp1(){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select debit_name from debit_ref where remark = '90年度以後新增特別預算'");
		return sqljob;
	}
}
