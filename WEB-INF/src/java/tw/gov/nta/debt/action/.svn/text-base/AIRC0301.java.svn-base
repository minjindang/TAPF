package tw.gov.nta.debt.action;

import gov.dnt.tame.common.ExcelReportBaseAction;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;
import tw.gov.nta.debt.form.Airc0301Form;
import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class AIRC0301 extends ExcelReportBaseAction
{
	private final static String TEMP_TABLE_NAME = "AIRC03_RPT";

	protected SQLJob insTemp(ActionForm form,String usrId,Map map){
		Airc0301Form AIRC0301form = (Airc0301Form) form;
		SQLJob sqljob = new SQLJob();
		StringBuffer str1 = new StringBuffer();
		StringBuffer strDate = new StringBuffer(DateUtil.date2ROCStr(AIRC0301form.getLimitDate()));
		sqljob.appendSQL("INSERT INTO " + TEMP_TABLE_NAME );
		sqljob.appendSQL(" ( ");
		sqljob.appendSQL(" USRID, MOD_DATE, REMARK, debt_name , exchange_stock_code , ISSUE_DATE , DUE_DATE ,");
		sqljob.appendSQL(" EXG_PRICE, TOTAL_EXG_STOCK,"); 
		sqljob.appendSQL(" LIBERATE_STOCK_AMOUNT, EXCHANGE_LESS_AMOUNT, ");
		sqljob.appendSQL(" EXCHANGE_AMOUNT, CHG_REASON ");
		sqljob.appendSQL(" ) ");
		sqljob.appendSQL(" VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?) ");
		sqljob.addParameter(usrId);
		sqljob.addParameter(new Date());
		sqljob.addParameter(new String());
		sqljob.addParameter(null==(String)map.get("DEBT_NAME")?new String():(String)map.get("DEBT_NAME"));
		sqljob.addParameter(null==(String)map.get("STOCK_NAME")?new String():(String)map.get("STOCK_NAME"));
		sqljob.addParameter(null==(Date)map.get("ISSUE_DATE")?new Date():(Date)map.get("ISSUE_DATE"));
		sqljob.addParameter(null==(Date)map.get("DUE_DATE")?new Date():(Date)map.get("DUE_DATE"));
		sqljob.addParameter(null==(BigDecimal)map.get("EXG_PRICE")?new BigDecimal(0):(BigDecimal)map.get("EXG_PRICE"));
		sqljob.addParameter(null==(BigDecimal)map.get("TOTAL_EXG_STOCK")?new BigDecimal(0):(BigDecimal)map.get("TOTAL_EXG_STOCK"));
		sqljob.addParameter(null==(BigDecimal)map.get("LIBERATE_STOCK_AMOUNT")?new BigDecimal(0):(BigDecimal)map.get("LIBERATE_STOCK_AMOUNT"));
		sqljob.addParameter(null==(BigDecimal)map.get("EXCHANGE_LESS_AMOUNT")?new BigDecimal(0):(BigDecimal)map.get("EXCHANGE_LESS_AMOUNT"));
		sqljob.addParameter(null==(BigDecimal)map.get("EXCHANGE_AMOUNT")?new BigDecimal(0):(BigDecimal)map.get("EXCHANGE_AMOUNT"));
		sqljob.addParameter(null==(String)map.get("CHG_REASON")?new String():(String)map.get("CHG_REASON"));
		System.out.println(sqljob);
		return sqljob;
	}
	public SQLJob SQLOne(Airc0301Form form)
	{
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL(" select * from issue_exgprice_det ");
		sqljob.appendSQL(" where issue_id = ? ");
		sqljob.appendSQL(" and change_date <= ? ");
		sqljob.addParameter(form.getIssueId());
		sqljob.addParameter(form.getLimitDate());
		return sqljob;
	}
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception
	{
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection, delSQLJob(TEMP_TABLE_NAME,usrId) );
		//執行 insert
		Airc0301Form myform =(Airc0301Form)form;
		List list1 = (List) run.query(SQLOne(myform),new MapListHandler());
		List tempList = null;
		Map tempMap = null;
		SQLJob tempSQLJob = new SQLJob();
		int listSize = 0;
		
		Date startDate = null;
		Date endDate = null;
		BigDecimal price = new BigDecimal(0);
		String debtName = new String();
		String stockName = new String();
		
		if(null != list1 && 0 != list1.size())
		{
			listSize = list1.size();
			
			for(int i=0;i<listSize;i++)
			{
				tempMap = (Map)list1.get(i);
				if(0==i)	//第一筆
				{
					tempSQLJob.appendSQL("select issue_date , debt_name from issue_main where id = ? ");
					tempSQLJob.addParameter(((Integer)tempMap.get("issue_id")));
					System.out.println(tempSQLJob);
					tempList = (List)run.query(tempSQLJob,new MapListHandler());
					if(null != tempList && 0 !=tempList.size())
					{
						startDate = (Date)(((Map)tempList.get(0)).get("issue_date"));
						endDate = DateUtil.computeDueDate((Date)tempMap.get("change_date"),-1);
						debtName = (String)(((Map)tempList.get(0)).get("debt_name"));
					}
					tempSQLJob = new SQLJob();
					tempSQLJob.appendSQL("select original_price , (select stockref.stock_name from exstock_ref stockref where stockref.id = EXCHANGE_STOCK_CODE ) as stockName from issue_exchange_det where issue_id = ? ");
					tempSQLJob.addParameter(((Integer)tempMap.get("issue_id")));
					System.out.println(tempSQLJob);
					tempList = (List)run.query(tempSQLJob,new MapListHandler());
					if(null != tempList && 0 !=tempList.size())
					{	
						price = (BigDecimal)(((Map)tempList.get(0)).get("original_price"));
						stockName = (String)(((Map)tempList.get(0)).get("stockName"));
					}
					tempSQLJob = new SQLJob();
					tempSQLJob.appendSQL(" select B.sum_stock as TOTAL_EXG_STOCK ,  ");
					tempSQLJob.appendSQL(" B.stock_amount as LIBERATE_STOCK_AMOUNT ,  ");
					tempSQLJob.appendSQL(" B.not_amount as EXCHANGE_LESS_AMOUNT , ");
					tempSQLJob.appendSQL(" B.change_amount as EXCHANGE_AMOUNT ");
					tempSQLJob.appendSQL(" from issue_exgprice_det B  ");
					tempSQLJob.appendSQL(" where B.id= ?  "); 
					tempSQLJob.addParameter(((Integer)tempMap.get("id")));		
					System.out.println(tempSQLJob);
					tempList = (List)run.query(tempSQLJob,new MapListHandler());
					if(null != tempList && 0 !=tempList.size())
					{	
						tempMap = (Map)tempList.get(0);
						tempMap.put("ISSUE_DATE",startDate);
						tempMap.put("DUE_DATE",endDate);
						tempMap.put("EXG_PRICE",price);
						tempMap.put("DEBT_NAME",debtName);
						tempMap.put("CHG_REASON",new String());
						tempMap.put("STOCK_NAME",stockName);
					}
					run.update(connection,insTemp(form,usrId,tempMap));					
				}
				else //2~n-1筆
				{
					startDate = (Date)((Map)list1.get(i - 1)).get("change_date");
					endDate = DateUtil.computeDueDate((Date)((Map)list1.get(i)).get("change_date"),-1);
					tempSQLJob = new SQLJob();
					
					tempSQLJob.appendSQL("select ( select change_price from issue_exgprice_det C where C.id = ? ) as EXG_PRICE , ");
					
					tempSQLJob.addParameter(((Integer)((Map)list1.get(i - 1)).get("id")));
					
					tempSQLJob.appendSQL("( (select C.sum_stock from issue_exgprice_det C where C.id=?)-(select B.sum_stock from issue_exgprice_det B where B.id=?)) as TOTAL_EXG_STOCK , ");  //          --7改為B.id=Sn.id, C.id=S(n+1).id;

					tempSQLJob.addParameter((Integer)(tempMap.get("id")));
					tempSQLJob.addParameter(((Integer)((Map)list1.get(i - 1)).get("id")));
					
					tempSQLJob.appendSQL("( (select C.stock_amount from issue_exgprice_det C where C.id=?)-(select B.stock_amount from issue_exgprice_det B where B.id=?)) as LIBERATE_STOCK_AMOUNT, ");
					
					tempSQLJob.addParameter((Integer)(tempMap.get("id")));
					tempSQLJob.addParameter(((Integer)((Map)list1.get(i - 1)).get("id")));
					
					tempSQLJob.appendSQL("( (select C.not_amount from issue_exgprice_det C where C.id=?)-(select B.not_amount from issue_exgprice_det B where B.id=?)) as EXCHANGE_LESS_AMOUNT, ");
					
					tempSQLJob.addParameter((Integer)(tempMap.get("id")));
					tempSQLJob.addParameter(((Integer)((Map)list1.get(i - 1)).get("id")));
					
					tempSQLJob.appendSQL("( (select C.change_amount from issue_exgprice_det C where C.id=?)-(select B.change_amount from issue_exgprice_det B where B.id=?)) as EXCHANGE_AMOUNT ");
					
					tempSQLJob.addParameter((Integer)(tempMap.get("id")));
					tempSQLJob.addParameter(((Integer)((Map)list1.get(i - 1)).get("id")));
					
					System.out.println(tempSQLJob);
					tempList = (List)run.query(tempSQLJob,new MapListHandler());
					if(null != tempList && 0 !=tempList.size())
					{	
						tempMap = (Map)tempList.get(0);
						tempMap.put("ISSUE_DATE",startDate);
						tempMap.put("DUE_DATE",endDate);
						//tempMap.put("EXG_PRICE",price);
						tempMap.put("DEBT_NAME",debtName);
						tempMap.put("CHG_REASON",tempMap.get("change_reason"));
						tempMap.put("STOCK_NAME",stockName);
					}
					run.update(connection,insTemp(form,usrId,tempMap));		
				}
			}	
			//最後一筆
			startDate = (Date)((Map)list1.get(listSize - 1)).get("change_date");
			endDate = myform.getLimitDate();
			tempSQLJob = new SQLJob();
			tempSQLJob.appendSQL(" select ( select change_price from issue_exgprice_det C where C.id = ? ) as EXG_PRICE ,");
			tempSQLJob.addParameter(((Integer)((Map)list1.get(listSize - 1)).get("id")));
			tempSQLJob.appendSQL(" ( select change_reason from issue_exgprice_det C where C.id = ? ) as CHG_REASON ,");
			tempSQLJob.addParameter(((Integer)((Map)list1.get(listSize - 1)).get("id")));
			tempSQLJob.appendSQL("( sum(exg_stock) - (select B.sum_stock from issue_exgprice_det B where B.id= ? )) as TOTAL_EXG_STOCK, ");
			tempSQLJob.addParameter(((Integer)((Map)list1.get(listSize - 1)).get("id")));
			tempSQLJob.appendSQL("( sum(exg_amount-exg_less_amount) - (select B.stock_amount from issue_exgprice_det B where B.id= ? )) as LIBERATE_STOCK_AMOUNT, ");
			tempSQLJob.addParameter(((Integer)((Map)list1.get(listSize - 1)).get("id")));
			tempSQLJob.appendSQL("( sum(exg_less_amount) - (select B.not_amount from issue_exgprice_det B where B.id= ? )) as EXCHANGE_LESS_AMOUNT, ");
			tempSQLJob.addParameter(((Integer)((Map)list1.get(listSize - 1)).get("id")));
			tempSQLJob.appendSQL("( sum(exg_amount) - (select B.change_amount from issue_exgprice_det B where B.id= ? )) as EXCHANGE_AMOUNT ");
			tempSQLJob.addParameter(((Integer)((Map)list1.get(listSize - 1)).get("id")));
			tempSQLJob.appendSQL(" from central_exchange_month A ");
			tempSQLJob.appendSQL(" where issue_id= ?"); //--數值為條件選取之債務issue_id ");
			tempSQLJob.addParameter(myform.getIssueId());
			tempSQLJob.appendSQL(" and term_ym<= ? "); //--數值為date2之年月YYYMM
			tempSQLJob.addParameter(DateUtil.date2ROCStr(endDate).substring(0,5));
			System.out.println(tempSQLJob);
			tempList = (List)run.query(tempSQLJob,new MapListHandler());
			if(null != tempList && 0 !=tempList.size())
			{	
				tempMap = (Map)tempList.get(0);
				tempMap.put("ISSUE_DATE",startDate);
				tempMap.put("DUE_DATE",endDate);
				tempMap.put("DEBT_NAME",debtName);
				tempMap.put("STOCK_NAME",stockName);
			}
			run.update(connection,insTemp(form,usrId,tempMap));		
		}
		else
		{
			tempSQLJob.appendSQL("select issue_date , debt_name from issue_main where id = ? ");
			tempSQLJob.addParameter(myform.getIssueId());
			System.out.println(tempSQLJob);
			tempList = (List)run.query(tempSQLJob,new MapListHandler());
			if(null != tempList && 0 !=tempList.size())
			{
				startDate = (Date)(((Map)tempList.get(0)).get("issue_date"));
				endDate = myform.getLimitDate();
				debtName = (String)(((Map)tempList.get(0)).get("debt_name"));
			}
			tempSQLJob = new SQLJob();
			tempSQLJob.appendSQL(" select ( select original_price from issue_exchange_det C where C.issue_id = ? ) as EXG_PRICE ,");
			tempSQLJob.addParameter(myform.getIssueId());
			tempSQLJob.appendSQL(" ( select stock_name from issue_exchange_det C , exstock_ref D where D.id = C.EXCHANGE_STOCK_CODE AND C.issue_id = ? ) as STOCK_NAME ,");
			tempSQLJob.addParameter(myform.getIssueId());
			tempSQLJob.appendSQL(" sum(exg_stock) as TOTAL_EXG_STOCK, ");
			tempSQLJob.appendSQL(" sum(exg_amount-exg_less_amount) as LIBERATE_STOCK_AMOUNT, ");
			tempSQLJob.appendSQL(" sum(exg_less_amount) as EXCHANGE_LESS_AMOUNT, ");
			tempSQLJob.appendSQL(" sum(exg_amount) as EXCHANGE_AMOUNT ");
			tempSQLJob.appendSQL(" from central_exchange_month A ");
			tempSQLJob.appendSQL(" where issue_id= ?"); //--數值為條件選取之債務issue_id ");
			tempSQLJob.addParameter(myform.getIssueId());
			tempSQLJob.appendSQL(" and term_ym<= ? "); //--數值為date2之年月YYYMM
			tempSQLJob.addParameter(DateUtil.date2ROCStr(endDate).substring(0,5));
			System.out.println(tempSQLJob);
			tempList = (List)run.query(tempSQLJob,new MapListHandler());
			if(null != tempList && 0 !=tempList.size())
			{	
				tempMap = (Map)tempList.get(0);
				tempMap.put("ISSUE_DATE",startDate);
				tempMap.put("DUE_DATE",endDate);
				tempMap.put("DEBT_NAME",debtName);
				tempMap.put("CHG_REASON",new String());
			}
			run.update(connection,insTemp(form,usrId,tempMap));		
		}	
	}
}
