
package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
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


public class EARF0105 extends DefaultAction{
	
	protected final static String TEMP_TABLE_NAME = "EARF01_RPT";
	
	protected SQLJob delTemp(ActionForm form){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM "+TEMP_TABLE_NAME);

		return sqljob;
	}


	protected SQLJob getSql(ActionForm form){
		AccountQueryForm myForm = (AccountQueryForm) form;
		SQLJob sqljob = new SQLJob();
		//若FLAG為0，則查發行的SQL，若為1，則查還本付息
		
		Date qryDate = DateUtil.str2Date( DateUtil.getLastDateOfMonth(myForm.getAccountYear(),myForm.getMonth()) );
		//System.out.println("dateutil=="+DateUtil.date2Str(qryDate, "yyyy/MM/dd"));

		sqljob.appendSQL(" SELECT * FROM GBA_TRANSFORM  ");
		
		sqljob.appendSQL(" WHERE 1=1");

		
		if(null!=myForm.getStartIssueDate() ){
			sqljob.appendSQL(" AND MOD_DATE >= '"+new Timestamp(myForm.getStartIssueDate().getTime())+"' ");
		}
		if(null!=myForm.getEndIssueDate() ){
			//所選日期的下一天凌晨12點
			sqljob.appendSQL(" AND MOD_DATE <= '"+new Timestamp(myForm.getEndIssueDate().getTime()+1000*60*60*24)+"'");			
		}

		System.out.println("EARF0105.sqljob=="+sqljob);
		return sqljob;
		
		
	}
	
	

	
	

	
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		//TEMPTABLE裡的欄位名稱必需與主計處要求的欄位名稱相同
		
		
//		取得使用者帳號
		AccountQueryForm myForm = (AccountQueryForm) form;
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//刪除temptable
		run.update(connection,delTemp(form));
		
		
	
		
		//insert temptable
		List tList = null;

			tList = (List) run.query(getSql(form), new MapListHandler());
			System.out.println("EARF0105.tList"+tList);
			request.setAttribute("collection",tList);

	}
}