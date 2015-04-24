package tw.gov.nta.surplusage.action;

import gov.dnt.tame.common.DefaultAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.sql.debt.GaraNote;
import tw.gov.nta.surplusage.common.GaraNoteManager;
import tw.gov.nta.surplusage.form.Gara0701Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class GARA0701 extends DefaultAction {
	
	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM GARA07_RPT ");
		//sqljob.appendSQL("WHERE USRID=?");
		//sqljob.addParameter( usrId );
		System.out.println("delTemp==>"+sqljob.toString());
		return sqljob;
	}
                    
	
	protected SQLJob qryTemp(ActionForm form){
		
		Gara0701Form myForm = (Gara0701Form)form;

		/*
		int year_2 = Integer.parseInt(myForm.getEndYear())-2;
		String yearStr_2 = null;
		if (year_2<10)
			yearStr_2 = "00" + year_2;
		else if (year_2<100)
			yearStr_2 = "0" + year_2;
		else
			yearStr_2 = "" + year_2;
		
		//System.out.println("yearStr_2==>"+yearStr_2);
		
		
		int year_1 = Integer.parseInt(myForm.getEndYear())-1;
		String yearStr_1 = null;
		if (year_1<10)
			yearStr_1 = "00" + year_1;
		else if (year_1<100)
			yearStr_1 = "0" + year_1;
		else
			yearStr_1 = "" + year_1;
		*/
		//System.out.println("yearStr_1==>"+yearStr_1);
		
		
		
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select rtrim(ltrim(STR(account_year+1911))) AS account_year, ");
		sqljob.appendSQL("max(Case when A.nation_no='TW'  then isNull(B.case_rate,0) else 0 end) as homeland_rate, ");
		sqljob.appendSQL("max(Case when A.nation_no='US'  then isNull(B.case_rate,0) else 0 end) as America_rate, ");
		sqljob.appendSQL("max(Case when A.nation_no='JP'  then isNull(B.case_rate,0) else 0 end) as Japan_rate, ");
		sqljob.appendSQL("max(Case when A.nation_no='NK'  then isNull(B.case_rate,0) else 0 end) as Britain_rate, ");
		sqljob.appendSQL("max(Case when A.nation_no='FR'  then isNull(B.case_rate,0) else 0 end) as Franch_rate, ");
		sqljob.appendSQL("max(Case when A.nation_no='GE'  then isNull(B.case_rate,0) else 0 end) as Germery_rate, ");
		sqljob.appendSQL("max(Case when A.nation_no='KR'  then isNull(B.case_rate,0) else 0 end) as Korea_rate, ");
		sqljob.appendSQL("max(Case when A.nation_no='SG'  then isNull(B.case_rate,0) else 0 end) as Singapore_rate ");
		sqljob.appendSQL("from Nation_ref A,Nation_Debit_main B ");
		sqljob.appendSQL("where A.id = B.Nation_Code ");
		if (!"".equals(myForm.getStartYear()))
			sqljob.appendSQL("and account_year >='"+myForm.getStartYear()+"' ");
		if (!"".equals(myForm.getEndYear()))
			sqljob.appendSQL("and account_year <='"+myForm.getEndYear()+"' ");	
		sqljob.appendSQL("group by account_year "); 
													
		/*
		sqljob.appendSQL("union ");
		sqljob.appendSQL("select rtrim(ltrim(STR(account_year+1911))) AS account_year, ");
		sqljob.appendSQL("max(Case when A.nation_no='TW'  then isNull(B.case_rate,0) else 0 end) as homeland_rate, ");
		sqljob.appendSQL("max(Case when A.nation_no='US'  then isNull(B.case_rate,0) else 0 end) as America_rate, ");
		sqljob.appendSQL("max(Case when A.nation_no='JP'  then isNull(B.case_rate,0) else 0 end) as Japan_rate, ");
		sqljob.appendSQL("max(Case when A.nation_no='UK'  then isNull(B.case_rate,0) else 0 end) as Britain_rate, ");
		sqljob.appendSQL("max(Case when A.nation_no='FR'  then isNull(B.case_rate,0) else 0 end) as Franch_rate, ");
		sqljob.appendSQL("max(Case when A.nation_no='GE'  then isNull(B.case_rate,0) else 0 end) as Germery_rate, ");
		sqljob.appendSQL("max(Case when A.nation_no='KE'  then isNull(B.case_rate,0) else 0 end) as Korea_rate, ");
		sqljob.appendSQL("max(Case when A.nation_no='SG'  then isNull(B.case_rate,0) else 0 end) as Singapore_rate ");
		sqljob.appendSQL("from Nation_ref A,Nation_Debit_main B ");
		sqljob.appendSQL("where A.id = B.Nation_Code ");
		sqljob.appendSQL("and account_year ='"+yearStr_1+"' ");
		sqljob.appendSQL("group by account_year ");
		
		sqljob.appendSQL("union ");		
		sqljob.appendSQL("select rtrim(ltrim(STR(account_year+1911))) AS account_year, ");
		sqljob.appendSQL("max(Case when A.nation_no='TW'  then isNull(B.case_rate,0) else 0 end) as homeland_rate, ");
		sqljob.appendSQL("max(Case when A.nation_no='US'  then isNull(B.case_rate,0) else 0 end) as America_rate, ");
		sqljob.appendSQL("max(Case when A.nation_no='JP'  then isNull(B.case_rate,0) else 0 end) as Japan_rate, ");
		sqljob.appendSQL("max(Case when A.nation_no='UK'  then isNull(B.case_rate,0) else 0 end) as Britain_rate, ");
		sqljob.appendSQL("max(Case when A.nation_no='FR'  then isNull(B.case_rate,0) else 0 end) as Franch_rate, ");
		sqljob.appendSQL("max(Case when A.nation_no='GE'  then isNull(B.case_rate,0) else 0 end) as Germery_rate, ");
		sqljob.appendSQL("max(Case when A.nation_no='KE'  then isNull(B.case_rate,0) else 0 end) as Korea_rate, ");
		sqljob.appendSQL("max(Case when A.nation_no='SG'  then isNull(B.case_rate,0) else 0 end) as Singapore_rate ");
		sqljob.appendSQL("from Nation_ref A,Nation_Debit_main B ");
		sqljob.appendSQL("where A.id = B.Nation_Code ");
		sqljob.appendSQL("and account_year ="+myForm.getEndYear() );
		*/
		//sqljob.appendSQL("group by account_year ");
		sqljob.appendSQL("order by account_year ");	
		
		//System.out.println("qryTemp==>"+sqljob.toString());	
		return sqljob;
	}
	
	protected SQLJob insTemp(String usrId,Date today,Map map){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO GARA07_RPT");
		sqljob.appendSQL("(USRID, MOD_DATE, accountyear, ");
		sqljob.appendSQL("homeland_rate, America_rate, Japan_rate, Britain_rate, ");
		sqljob.appendSQL("Franch_rate,Germery_rate , ");
		sqljob.appendSQL("Korea_rate,Singapore_rate ) ");
		sqljob.appendSQL("VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		sqljob.addParameter(usrId);
		sqljob.addParameter(today);
		sqljob.addParameter((String)map.get("account_year"));//1
		sqljob.addParameter((BigDecimal)map.get("homeland_rate"));//2
		sqljob.addParameter((BigDecimal)map.get("America_rate"));//3
		sqljob.addParameter((BigDecimal)map.get("Japan_rate"));//4
		sqljob.addParameter((BigDecimal)map.get("Britain_rate"));//5
		sqljob.addParameter((BigDecimal)map.get("Franch_rate"));//6
		sqljob.addParameter((BigDecimal)map.get("Germery_rate"));//7
		sqljob.addParameter((BigDecimal)map.get("Korea_rate"));//8
		sqljob.addParameter((BigDecimal)map.get("Singapore_rate"));//9
		//System.out.println(sqljob.toString());
		return sqljob;
	}	
	
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		
		Gara0701Form myForm = (Gara0701Form)form;
		GaraNote garaNote = new GaraNoteManager().getGaraNote(myForm.getPath());
		garaNote.setMemo(myForm.getMemo());
		garaNote.setPath(myForm.getPath());
		new GaraNoteManager().confirm(garaNote);
		request.setAttribute("memo",garaNote.getMemo());
		//取得使用者帳號
		String usrId = this.getUserId(request);
		Date today = new Date();
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delTemp(form,usrId)); 

		
		List queryList1 = (List) run.query(qryTemp(form), new MapListHandler());
		for(Iterator it1=queryList1.iterator();it1.hasNext();){
			Map mapQry1 = (Map) it1.next();
			run.update(connection,insTemp(usrId,today,mapQry1));
		}
		
	}
	
	

	
}
