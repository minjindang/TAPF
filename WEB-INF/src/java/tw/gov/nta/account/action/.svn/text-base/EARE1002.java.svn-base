/*
 * 在 2007/8/27 建立
 *
 * TODO 如果要變更這個產生的檔案的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
package tw.gov.nta.account.action;

import gov.dnt.tame.common.ExcelReportBaseAction;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.account.form.AccountQueryForm;
import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

/**
 * @author Mulder
 *
 * TODO 如果要變更這個產生的類別註解的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
public class EARE1002 extends ExcelReportBaseAction {
	
	private final static String TEMP_TABLE_NAME = "EARE10_RPT";
	
	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM EARE10_RPT ");
		System.out.println(sqljob.toString());
		return sqljob;
	}
 	
	protected SQLJob SQL(AccountQueryForm form){
		
		AccountQueryForm myForm = (AccountQueryForm) form;
		SQLJob sqljob = new SQLJob();
		//查詢欄位
		sqljob.appendSQL("select right(i.account_year,2) +'年度'+ b.code_name + '公債' + ");
		sqljob.appendSQL("c.debit_name + f.budget_name  as GROUP_YEAR,");
		sqljob.appendSQL("(Select t.debt_id From issue_exchange_ticket_det t ");
		sqljob.appendSQL("where t.debt_id = d.id group by t.debt_id ) as ISSUE_EXCHAGE, ");
		sqljob.appendSQL("i.debt_name as GROUP_DEBT_NAME, ");
		sqljob.appendSQL("i.issue_kind as ISSUE_KIND ");
		//查詢資料表
		sqljob.appendSQL("from issue_main i, debt_main d, debit_ref c, code_det b, budget_ref f");
		//查詢條件
		sqljob.appendSQL("where i.debt_type = 'A' ");
		sqljob.appendSQL("and i.id = d.issue_id  ");		
		if (!"".equals(myForm.getAccountYear()))	{
			sqljob.appendSQL("and i.account_year < ?");
			sqljob.addParameter(myForm.getAccountYear());
		}		
		sqljob.appendSQL("and i.cash_due_date > '"+new Timestamp(new Date().getTime())+"'");
		sqljob.appendSQL("and c.id = i.debt_code and i.bond_kind = b.id and i.budget_code = f.id");
		sqljob.appendSQL("order by i.ISSUE_DATE");
		System.out.println(sqljob.toString());
		System.out.println(myForm.getAccountYear());
		return sqljob;
	}	

	protected static String sort(int num){

	    int cont1 = Integer.parseInt(String.valueOf(num).substring(0,1));
	    int cont2 = 0;
	    String i = "";
	    String j = "";
	    if (num > 10){
	    	cont2 = Integer.parseInt(String.valueOf(num).substring(1,2));
	    	
			switch(cont2) {
	        case 0: 
	            j = "十"; 
	            break; 
	        case 1: 
	            j = "一"; 
	            break; 
	        case 2: 
	            j = "二"; 
	            break;
	        case 3: 
	            j = "三"; 
	            break;
	        case 4: 
	            j = "四"; 
	            break;
	        case 5: 
	            j = "五"; 
	            break;
	        case 6: 
	            j = "六"; 
	            break;
	        case 7: 
	            j = "七"; 
	            break;
	        case 8: 
	            j = "八"; 
	            break;
	        case 9: 
	            j = "九"; 
	            break;
	        case 10: 
	            j = "十"; 
	            break;
	        default: 
	            System.out.println(j); 
			}
	    }	    	

		switch(cont1) { 
        case 0: 
            i = ""; 
            break; 
        case 1: 
            i = "一"; 
            break; 
        case 2: 
            i = "二"; 
            break;
        case 3: 
            i = "三"; 
            break;
        case 4: 
            i = "四"; 
            break;
        case 5: 
            i = "五"; 
            break;
        case 6: 
            i = "六"; 
            break;
        case 7: 
            i = "七"; 
            break;
        case 8: 
            i = "八"; 
            break;
        case 9: 
            i = "九"; 
            break;
        case 10: 
            i = "十"; 
            break;
        default: 
            System.out.println(i); 
		}
				
		return i+j;
	
	}
	
	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update( connection, delSQLJob(TEMP_TABLE_NAME,usrId) );		
		
		SQLJob sqljob = SQL((AccountQueryForm)form);		
		List tList = (List) run.query(sqljob, new MapListHandler());		
		Map tMap = null;
		
		int i = 0;
		int j = 0;
		String test = "";
		
		for(Iterator tIterator = tList.iterator(); tIterator.hasNext(); ){		
			
			tMap = (Map) tIterator.next();
			Map dMap = new HashMap();
			Map cMap = new HashMap();
			
			if (tMap.get("GROUP_YEAR").equals(request.getAttribute("check"))){
				j = j + 1;
				dMap.put("GROUP_YEAR","         ("+sort(j)+")"  +(String)tMap.get("GROUP_DEBT_NAME"));
			}
			else{
				i = i +1;
				j = 1;
				cMap.put("GROUP_YEAR",sort(i) + "、" + (String)tMap.get("GROUP_YEAR"));
				run.update(connection,insTemp(TEMP_TABLE_NAME,cMap));
				dMap.put("GROUP_YEAR","         (一)" +(String)tMap.get("GROUP_DEBT_NAME"));
			}
			run.update(connection,insTemp(TEMP_TABLE_NAME,dMap));
			
			if (!(boolean)test.equals(tMap.get("ISSUE_EXCHAGE")) && (boolean)(tMap.get("ISSUE_KIND").equals("1"))) {
				dMap.put("GROUP_YEAR","                  (1)平衡表 - 經付類(債票形式)");
				run.update(connection,insTemp(TEMP_TABLE_NAME,dMap));			
				dMap.put("GROUP_YEAR","                  (2)償付本金利息明細月報表(債票形式)");
				run.update(connection,insTemp(TEMP_TABLE_NAME,dMap));			
				dMap.put("GROUP_YEAR","                  (3)平衡表 - 經付類(登錄形式)");
				run.update(connection,insTemp(TEMP_TABLE_NAME,dMap));			
				dMap.put("GROUP_YEAR","                  (4)償付本金利息明細月報表(登錄形式)");
				run.update(connection,insTemp(TEMP_TABLE_NAME,dMap));
			}
			
			if ((boolean)test.equals(tMap.get("ISSUE_EXCHAGE")) && (boolean)tMap.get("ISSUE_KIND").equals("1")) {
				dMap.put("GROUP_YEAR","                  (1)平衡表 - 經付類(債票形式)");
				run.update(connection,insTemp(TEMP_TABLE_NAME,dMap));			
				dMap.put("GROUP_YEAR","                  (2)償付本金利息明細月報表(債票形式)");
				run.update(connection,insTemp(TEMP_TABLE_NAME,dMap));
			}
			
			if ((boolean)tMap.get("ISSUE_KIND").equals("0") && !(boolean)test.equals(tMap.get("ISSUE_EXCHAGE"))) {
				dMap.put("GROUP_YEAR","                  (1)平衡表 - 經付類(登錄形式)");
				run.update(connection,insTemp(TEMP_TABLE_NAME,dMap));			
				dMap.put("GROUP_YEAR","                  (2)償付本金利息明細月報表(登錄形式)");
				run.update(connection,insTemp(TEMP_TABLE_NAME,dMap));
			}
			
			request.setAttribute("check", tMap.get("GROUP_YEAR"));
		}	
	}
}

