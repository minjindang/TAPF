package tw.gov.nta.surplusage.action;

import gov.dnt.tame.common.ExcelReportRemainAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.sql.debt.GaraNote;
import tw.gov.nta.surplusage.common.GaraNoteManager;
import tw.gov.nta.surplusage.form.Gara0401Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class GARA0401 extends ExcelReportRemainAction {

	protected SQLJob SQL1(Gara0401Form myForm,BigDecimal unit)
	{
		SQLJob sqljob = new SQLJob();
		//--年度
		sqljob.appendSQL("select account_year,");
		//--還本(總預算編列)
		sqljob.appendSQL("isNull(budget_capital,0)/"+unit+" as t1,");
		//--還本(償還已到期債務)
		sqljob.appendSQL("isNull(fundation_capital,0)/"+unit+" as t2,");
		//--付息
		sqljob.appendSQL("isNull(interest_payed,0)/"+unit+" as t3,");
		//--合計
		sqljob.appendSQL("isNull(budget_capital+interest_payed,0)/"+unit+" as TOTAL, ");
		//--歲出
		sqljob.appendSQL("isNull(year_amount,0)/"+unit+" as BUDGET_AMOUNT ");
		sqljob.appendSQL("from GARA04_TEMP");
		sqljob.appendSQL("where 1=1");
		
		if (!"".equals(myForm.getStartYear()) && !"".equals(myForm.getEndYear())){
			sqljob.appendSQL("and account_year between '"+myForm.getStartYear()+"' and '"+myForm.getEndYear()+"' ");
			
		}
		System.out.println("GARA0401-SQL1:"+sqljob.toString());
		return sqljob;
	}
	
	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception 
	{
		Gara0401Form myForm = (Gara0401Form) form;
		GaraNote garaNote = new GaraNoteManager().getGaraNote(myForm.getPath());
		garaNote.setMemo(myForm.getMemo());
		garaNote.setPath(myForm.getPath());
		new GaraNoteManager().confirm(garaNote);
		request.setAttribute("memo",garaNote.getMemo());
		BigDecimal unit = new BigDecimal(myForm.getAmountUnit());
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delSQLJob("GARA04_RPT",usrId));
		//執行 insert
		List queryList1 = (List) run.query(SQL1(myForm,unit), new MapListHandler());
		Map tMap = null;
		
		for(Iterator tIterator = queryList1.iterator(); tIterator.hasNext(); ){
			tMap = (Map) tIterator.next();
			tMap.putAll(getCommonMap(usrId));
			//歲出
			//tMap.put("BUDGET_AMOUNT",this.getYearAmount(connection,(String)tMap.get("account_year"),unit,"1"));
			//GNP 
			if(tMap.get("account_year").toString().trim().equals("089"))
				tMap.put("GNP_AMOUNT",new BigDecimal("15109063000000").divide(unit,2,BigDecimal.ROUND_UP));
			else	
				tMap.put("GNP_AMOUNT",this.getGNP(connection,(String)tMap.get("account_year"),unit));
			//還本付息/歲出
			tMap.put("AUDIT_PERCENT",this.divideCheck((BigDecimal)tMap.get("TOTAL"),(BigDecimal)tMap.get("BUDGET_AMOUNT")).multiply(new BigDecimal(100)));
			//還本付息/GNP
			tMap.put("GNP_PERCENT",this.divideCheck((BigDecimal)tMap.get("TOTAL"),(BigDecimal)tMap.get("GNP_AMOUNT")).multiply(new BigDecimal(100)));
			run.update(connection,insTemp("GARA04_RPT",tMap));		
		}
		request.setAttribute("memo",garaNote.getMemo());
		
  	}
}
