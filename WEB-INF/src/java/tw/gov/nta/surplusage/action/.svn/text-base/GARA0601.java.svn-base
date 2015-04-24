/**
 * @author Avery Yeh
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
import tw.gov.nta.sql.dao.NationDebitMainDAO;
import tw.gov.nta.sql.debt.GaraNote;
import tw.gov.nta.surplusage.common.Gara33ReMainList;
import tw.gov.nta.surplusage.common.Gara34ReMainList;
import tw.gov.nta.surplusage.common.GaraNoteManager;
import tw.gov.nta.surplusage.form.Gara0601Form;
import tw.gov.nta.system.common.NationCodeManager;
import tw.gov.nta.system.common.NationDebitManager;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class GARA0601 extends ExcelReportRemainAction
{

	@SuppressWarnings("unchecked")
	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception{
		Gara0601Form myForm = (Gara0601Form) form;
		
		GaraNote garaNote = new GaraNoteManager().getGaraNote(myForm.getPath());
		garaNote.setMemo(myForm.getMemo());
		garaNote.setPath(myForm.getPath());
		new GaraNoteManager().confirm(garaNote);
		request.setAttribute("memo",garaNote.getMemo());
		
		//輸入的金額單位
		BigDecimal unit = myForm.getAmountUnit();
		//輸入的起始年
		Integer startYear = Integer.parseInt(myForm.getStartYear());
		//輸入的結束年
		Integer endYear = Integer.parseInt(myForm.getEndYear());
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delSQLJob("GARA06_RPT",usrId));
		//執行 insert
		
		//取得grar33未償餘額List物件
		//List qryGara33 = (List) run.query(CommonReportSQL.Gara33SQL(myForm.getEndYear(),unit), new MapListHandler());
		//Gara33ReMainList gara33 = new Gara33ReMainList(qryGara33);
		Gara33ReMainList gara33 = new Gara33ReMainList(connection,myForm.getEndYear(),unit);
		//取得grar34未償餘額List物件
		//List qryGara34 = (List) run.query(CommonReportSQL.Gara34SQL(myForm.getEndYear(),unit), new MapListHandler());
		//Gara34ReMainList gara34 = new Gara34ReMainList(qryGara34);
		Gara34ReMainList gara34 = new Gara34ReMainList(connection,myForm.getEndYear(),unit);
		
		String accountYear="";
		String accountKind="";
		
		Map dMap = new HashMap();
		
		//總計
		BigDecimal total = new BigDecimal(0);

		//跑年度的迴圈
		for(int i=startYear;i<=endYear;i++)
		{
			dMap.putAll(getCommonMap(usrId));
			//初始化為起始年
			accountYear = this.getStrYear(String.valueOf(i));
			
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
			
			/**
			 *	公債 
			 */
				//年度別
				dMap.put("account_year",accountYear);
				//甲類公債
				dMap.put("t1",gara33.getReMainField(1));
				//乙類公債
				dMap.put("t2",gara33.getReMainField(2));
				//九二一.....及軍購
				dMap.put("t3",gara33.getReMainField(4));
				//債務基金
				dMap.put("t4",gara33.getReMainField(5));
				//合計
				dMap.put("t_total",gara33.getReMainTotal());
			
			/**
			 * 借貸
			 */	
				//甲類借款 = 總預算 + 戰機(特別預算) + 北二高(特別預算) +　立法院(特別預算)
				if(i==73)
					dMap.put("r1",new BigDecimal("2433000000").divide(unit));
				else if(i==74)
					dMap.put("r1",new BigDecimal("2008000000").divide(unit));
				else
					dMap.put("r1",gara34.getReMainField(1).add(
						gara34.getReMainField(2).add(
						gara34.getReMainField(3).add(
						gara34.getReMainField(5)))));
				
				//特別預算-乙類借款未償餘額
				dMap.put("r2",gara34.getReMainField(4));
				//九二一等未償餘額
				dMap.put("r3",gara34.getReMainField(6));
				//省債未償餘額
				dMap.put("r4",gara34.getReMainField(7));
				//債務基金未償餘額
				dMap.put("r5",gara34.getReMainField(10));
				//糧食平準基金基金未償餘額
				dMap.put("r6",gara34.getReMainField(9));
				//新生地開發未償餘額
				dMap.put("r7",gara34.getReMainField(8));
				//非營業基金未償餘額
				dMap.put("r8",gara34.getReMainField(11));
				//未償餘額總數
				if(i==73)
					dMap.put("r_total",new BigDecimal("2433000000").divide(unit));
				else if(i==74)
					dMap.put("r_total",new BigDecimal("2008000000").divide(unit));
				else
					dMap.put("r_total",gara34.getReMainTotal());
				//公債 + 借貸
				total = gara33.getReMainTotal()
				.add((BigDecimal)dMap.get("r_total"));
				dMap.put("t_r_total",total);
			/**
			 * 總計及百分比
			 */	
				//GNP
				if(i==89)
					dMap.put("GNP_amount",this.getGNP(connection,accountYear,unit).divide(new BigDecimal(1.5)));
				else
					dMap.put("GNP_amount",this.getGNP(connection,accountYear,unit));
				//前三年度GNP平均數
				dMap.put("perGNP_amount",this.getPerGNP(connection,accountYear,unit));
				//GDP
				dMap.put("GDP_amount",this.getGDP(connection,accountYear,unit));
				//政府債務未償餘額占GNP%
				if(i==89)
					dMap.put("GNP_percent",total.divide(this.getGNP(connection,accountYear,unit),4,4).multiply(new BigDecimal(1.5)).multiply(new BigDecimal(100)));
				else
					dMap.put("GNP_percent",total.divide(this.getGNP(connection,accountYear,unit),4,4).multiply(new BigDecimal(100)));
				//政府債務未償餘額占perGNP%
				dMap.put("perGNP_percent",total.divide(this.getPerGNP(connection,accountYear,unit),4,4).multiply(new BigDecimal(100)));
				//政府債務未償餘額占GDP%
				dMap.put("GDP_percent",total.divide(this.getGDP(connection,accountYear,unit),4,4).multiply(new BigDecimal(100)));
				//將政府債務未償餘額占GDP%更新至gama02的中華民國各年度之"債務餘額/GDP"
				upNationDebitMain(accountYear,(BigDecimal)dMap.get("GDP_percent"));
				//新增到TempTable
				run.update(connection,insTemp("GARA06_RPT",dMap));
		}	
        SQLJob queryJob1 = selTemp1();
        List queryList1 = (List) run.query(queryJob1, new MapListHandler());
        String remark = "註1：";
        for(Iterator it1=queryList1.iterator();it1.hasNext();)
        {
        	Map mapQry1 = (Map) it1.next();
        	remark += (String)mapQry1.get("debit_name")+",";
        }
        request.setAttribute("remark",remark.substring(0,remark.length()-1));
        request.setAttribute("remarkRow",endYear-startYear);
	}
	private void upNationDebitMain(String tAccountYear , BigDecimal tRemainRate){
		NationDebitMain nationDebitMain = new NationDebitMain();
		nationDebitMain.setAccountYear(tAccountYear);
		nationDebitMain.setNationCode(NationCodeManager.get(24));
		@SuppressWarnings("unused")
		List collection = NationDebitManager.query(nationDebitMain);
		for(Iterator it = collection.iterator();it.hasNext();){
			NationDebitMain pNationDebitMain = (NationDebitMain)it.next();
			pNationDebitMain.setRemainRate(tRemainRate);
			new NationDebitMainDAO().update(pNationDebitMain);
		}
	}

	protected SQLJob selTemp1(){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select debit_name from debit_ref where remark = '90年度以後新增特別預算'");
		return sqljob;
	}
}