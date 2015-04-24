package tw.gov.nta.shortterm.action;

import gov.dnt.tame.common.ExcelReportRemainAction;

import java.math.BigDecimal;
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

import tw.gov.nta.shortterm.common.ShorttermNoPayCount;
import tw.gov.nta.shortterm.form.Dira0701Form;
import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class DIRA0601 extends ExcelReportRemainAction
{
	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM DIRA06_RPT ");
		System.out.println(sqljob.toString());
		return sqljob;
	}

	protected SQLJob sql(ActionForm form){
		Dira0701Form myForm = (Dira0701Form)form;
		SQLJob sqljob = new SQLJob();
		
		sqljob.appendSQL("Select b.bank_name as BANK_NAME, i.issue_serial as ISSUE_SERIAL, ");
		sqljob.appendSQL("datediff(d, i.issue_date, i.due_date) as DAYS, ");
		sqljob.appendSQL("i.issue_date as ISSUE_DATE, i.due_date as DUE_DATE, ");
		sqljob.appendSQL("d.compare_rate/100 as COMPARE_RATE, d.issue_amount/100000000 as issue_amount");
				
		sqljob.appendSQL(",(SELECT SUM(d2.ISSUE_AMOUNT) /100000000 ");
		sqljob.appendSQL("FROM DEBT_MAIN d2");
		sqljob.appendSQL("WHERE d2.BANK_ID =  b.id and d2.issue_id in ");
		sqljob.appendSQL("(select id from issue_main where debt_type='D' ");
		sqljob.appendSQL("and due_date> ? ) ");
		sqljob.appendSQL("and d2.issue_amount > (select isnull(sum(capital_amount),0) from payment_main where debt_id = d2.id and repay_date <= ? )) as TOTAL_AMOUNT, ");		
		sqljob.appendSQL("d.debt_code ");
		if(myForm.getDueDate()!=null && !"".equals(myForm.getDueDate())){
		    sqljob.addParameter( myForm.getDueDate() );
		}else{
		    sqljob.addParameter( new Timestamp(new Date().getTime()) );
		}		
		if(myForm.getDueDate()!=null && !"".equals(myForm.getDueDate())){
		    sqljob.addParameter( myForm.getDueDate() );
		}else{
		    sqljob.addParameter( new Timestamp(new Date().getTime()) );
		}				
		sqljob.appendSQL("from issue_main i, debt_main d, bank_ref b");
		sqljob.appendSQL("where i.debt_type = 'D' ");
		sqljob.appendSQL("and b.id= d.bank_id ");
		sqljob.appendSQL("and i.id = d.issue_id ");
		
		if(myForm.getBegAccYear()!=null && myForm.getBegAccYear().trim().length()>0)
			sqljob.appendSQL("AND i.ACCOUNT_YEAR >= "+myForm.getBegAccYear());
		if(myForm.getEndAccYear()!=null && myForm.getEndAccYear().trim().length()>0)
			sqljob.appendSQL("AND i.ACCOUNT_YEAR <= "+myForm.getEndAccYear());
		
		sqljob.appendSQL("and i.due_date > ? ");
		if(myForm.getDueDate()!=null && !"".equals(myForm.getDueDate())){
		    sqljob.addParameter( myForm.getDueDate() );
		}else{
		    sqljob.addParameter( new Timestamp(new Date().getTime()) );
		}
		sqljob.appendSQL(" and d.issue_amount > (select isnull(sum(capital_amount),0) from payment_main where debt_id = d.id and repay_date <= ? ) ");
		if(myForm.getDueDate()!=null && !"".equals(myForm.getDueDate())){
		    sqljob.addParameter( myForm.getDueDate() );
		}else{
		    sqljob.addParameter( new Timestamp(new Date().getTime()) );
		}
		sqljob.appendSQL("Group by b.bank_name, i.issue_date, i.issue_serial, d.compare_rate, i.due_date, d.issue_amount, b.ID, d.id, d.debt_code");
		sqljob.appendSQL("Order by b.bank_name");
		
		System.out.println(sqljob.toString());
		return sqljob;
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception
	{
		Dira0701Form myForm = (Dira0701Form)form;
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delTemp(form,usrId));
		//執行 insert		
		List queryList1 = (List) run.query(sql(myForm), new MapListHandler());
		Map tMap = null;
		Map dMap = new HashMap();
		BigDecimal ShorttermAmount1 = new BigDecimal(0);	//一般短借
		BigDecimal ShorttermAmount2 = new BigDecimal(0);	//債務基金
		BigDecimal ShorttermAmount3 = new BigDecimal(0);	//民營化基金
		
		for(Iterator tIterator = queryList1.iterator(); tIterator.hasNext(); )
		{			
			tMap = (Map) tIterator.next();
			
			//承貸銀行
			dMap.put("BANK_NAME",tMap.get("BANK_NAME"));			
			//期別
			dMap.put("ISSUE_SERIAL",tMap.get("ISSUE_SERIAL"));			
			//天期
			dMap.put("DAYS",tMap.get("DAYS"));			
			//借款日
			dMap.put("ISSUE_DATE",tMap.get("ISSUE_DATE"));			
			//到期日
			dMap.put("DUE_DATE",tMap.get("DUE_DATE"));			
			//借款利率
			dMap.put("COMPARE_RATE",tMap.get("COMPARE_RATE"));			
			//借款金額
			dMap.put("ISSUE_AMOUNT",tMap.get("ISSUE_AMOUNT"));
			//銀行未償餘額總額
			dMap.put("TOTAL_AMOUNT",tMap.get("TOTAL_AMOUNT"));
			//合計
			Integer debtCode = (Integer)tMap.get("debt_code");
			if (debtCode.equals(24))
				ShorttermAmount1 = ShorttermAmount1.add((BigDecimal)tMap.get("ISSUE_AMOUNT"));
			else if (debtCode.equals(31))
				ShorttermAmount2 = ShorttermAmount2.add((BigDecimal)tMap.get("ISSUE_AMOUNT"));
			else if (debtCode.equals(25))
				ShorttermAmount3 = ShorttermAmount3.add((BigDecimal)tMap.get("ISSUE_AMOUNT"));
			
			run.update(connection,insTemp("DIRA06_RPT",dMap));			
		}
		
//		String memo = "(內含短期借款"+new ShorttermNoPayCount().noPayAmount(myForm.getBegAccYear(),myForm.getEndAccYear(),null,myForm.getDueDate(),"2").divide(new BigDecimal(100000000),0,4)+"億元及債務基金"+new ShorttermNoPayCount().noPayAmount(myForm.getBegAccYear(),myForm.getEndAccYear(),null,myForm.getDueDate(),"4").divide(new BigDecimal(100000000),0,4)+"億元,民營化基金"+new ShorttermNoPayCount().noPayAmount(myForm.getBegAccYear(),myForm.getEndAccYear(),null,myForm.getDueDate(),"3").divide(new BigDecimal(100000000),0,4)+"億元)";
//		String total = ""+new ShorttermNoPayCount().noPayAmount(myForm.getBegAccYear(),myForm.getEndAccYear(),null,myForm.getDueDate(),"1").divide(new BigDecimal(100000000),0,4);
		String memo = "(內含短期借款"+ShorttermAmount1.setScale(0)+"億元,債務基金"+ShorttermAmount2.setScale(0)+"億元及民營化基金"+ShorttermAmount3.setScale(0)+"億元)";
		String total = ""+ShorttermAmount1.add(ShorttermAmount2).add(ShorttermAmount3);
		request.setAttribute("memo",memo);
		request.setAttribute("total",total);
	}
}
