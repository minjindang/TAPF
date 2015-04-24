package tw.gov.nta.surplusage.action;

import gov.dnt.tame.common.ExcelReportBaseAction;
import gov.dnt.tame.util.DateUtil;

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

import tw.gov.nta.surplusage.form.Gara4201Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class GARA4401 extends ExcelReportBaseAction {
	private final static String TEMP_TABLE_NAME = "GARA44_RPT";
	
	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM GARA44_RPT ");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	
	protected SQLJob SQL(Gara4201Form myForm){
		SQLJob sqljob = new SQLJob();
		String year = myForm.getAccountYear();
		String statrDate = Integer.parseInt(year)+1911 + "-01-01";
		String endDate = Integer.parseInt(year)+1911 + "-12-31";
		
		//暫不考慮"公債"
		sqljob.appendSQL("select i.debt_type as first_code, ");
		sqljob.appendSQL("d.repay_date, ");
		sqljob.appendSQL("d.interest_amount, ");
		sqljob.appendSQL("sum(p.interest_amount) as real_interest_amount ");
		sqljob.appendSQL("from issue_main i, debt_plan_det d, payment_main p ");
		sqljob.appendSQL("where i.id = d.issue_id ");
		sqljob.appendSQLCondition("i.id = p.issue_id ");
		sqljob.appendSQLCondition("d.id = p.plan_id ");
		sqljob.appendSQLCondition("i.debt_type not in ('E','D','A') ");
		sqljob.appendSQLCondition("d.delete_mark <> 'Y' ");
		sqljob.appendSQLCondition("(d.interest_amount-p.interest_amount) <> 0 ");
		sqljob.appendSQLCondition("d.repay_date between '"+statrDate+"' and '"+endDate+"' ");
		sqljob.appendSQL("group by i.debt_type,d.repay_date,d.interest_amount ");
		//因短借需分成"一般"、"債務基金"和"民營化基金"，故分開抓
		sqljob.appendSQL("union ");
		sqljob.appendSQL("select REPLACE(str(i.debt_code),' ','') as first_code, ");
		sqljob.appendSQL("d.repay_date, ");
		sqljob.appendSQL("sum(d.interest_amount) as interest_amount, ");
		sqljob.appendSQL("sum(p.interest_amount) as real_interest_amount ");
		sqljob.appendSQL("from issue_main i, debt_plan_det d, payment_main p ");
		sqljob.appendSQL("where i.id = d.issue_id ");
		sqljob.appendSQLCondition("i.id = p.issue_id ");
		sqljob.appendSQLCondition("d.id = p.plan_id ");
		sqljob.appendSQLCondition("i.debt_type = 'D' ");
		sqljob.appendSQLCondition("d.delete_mark <> 'Y' ");
		sqljob.appendSQLCondition("(d.interest_amount-p.interest_amount) <> 0 ");
		sqljob.appendSQLCondition("d.repay_date between '"+statrDate+"' and '"+endDate+"' ");
		sqljob.appendSQL("group by i.debt_code,d.repay_date ");
		sqljob.appendSQL("order by d.repay_date ");
		
		System.out.println(sqljob.toString());
		return sqljob;
	}

	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {

		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update( connection, delSQLJob(TEMP_TABLE_NAME,usrId) );	
		Gara4201Form myForm = (Gara4201Form) form;

		SQLJob sqljob = SQL(myForm);
		List tList = (List) run.query(sqljob, new MapListHandler());
		Map tMap = null;	
		int tmpMonth = 1;
		String newMouth = "";
		BigDecimal meetInterest[] = new BigDecimal[6];
		BigDecimal realInterest[] = new BigDecimal[6];
		for(int i=0; i<6; i++){
			meetInterest[i] = new BigDecimal(0);
			realInterest[i] = new BigDecimal(0);
		}

		for(Iterator tIterator = tList.iterator(); tIterator.hasNext(); ){
			tMap = (Map) tIterator.next();
			if (tmpMonth != DateUtil.getMonth((Date)tMap.get("repay_date"))+1){
				Map dMap = new HashMap();
				newMouth = tmpMonth + "月";
				dMap = calculation(newMouth,meetInterest,realInterest);
				run.update(connection,insTemp(TEMP_TABLE_NAME,dMap));	
				for(int i=0; i<6; i++){
					meetInterest[i] = new BigDecimal(0);
					realInterest[i] = new BigDecimal(0);
				}			
				tmpMonth = DateUtil.getMonth((Date)tMap.get("repay_date"))+1;	
			}
			BigDecimal iterestAmount = null!=tMap.get("interest_amount")?(BigDecimal)tMap.get("interest_amount"):new BigDecimal(0);
			BigDecimal realIterestAmount = null!=tMap.get("real_interest_amount")?(BigDecimal)tMap.get("real_interest_amount"):new BigDecimal(0);
			String firstCode = (String)tMap.get("first_code");
			if ("A".equals(firstCode)){
				meetInterest[0] = meetInterest[0].add(iterestAmount);
				realInterest[0] = realInterest[0].add(realIterestAmount);
			} else if ("B".equals(firstCode)){
				meetInterest[1] = meetInterest[1].add(iterestAmount);
				realInterest[1] = realInterest[1].add(realIterestAmount);
			} else if ("C".equals(firstCode)){
				meetInterest[2] = meetInterest[2].add(iterestAmount);
				realInterest[2] = realInterest[2].add(realIterestAmount);
			} else if ("24".equals(firstCode)){
				meetInterest[3] = meetInterest[3].add(iterestAmount);
				realInterest[3] = realInterest[3].add(realIterestAmount);
			} else if ("25".equals(firstCode)){
				meetInterest[4] = meetInterest[4].add(iterestAmount);
				realInterest[4] = realInterest[4].add(realIterestAmount);
			} else if ("31".equals(firstCode)){
				meetInterest[5] = meetInterest[5].add(iterestAmount);
				realInterest[5] = realInterest[5].add(realIterestAmount);
			}
		}
		//加上最後一筆
		Map dMap = new HashMap();
		newMouth = tmpMonth + "月";
		dMap = calculation(newMouth, meetInterest,realInterest);
		run.update(connection,insTemp(TEMP_TABLE_NAME,dMap));	
		//報表年度
		request.setAttribute("accountYear",myForm.getAccountYear());
	}
	
	public Map calculation(String newMouth, BigDecimal[] meetInterest, BigDecimal[] realInterest)
	{
		Map dMap = new HashMap();
		BigDecimal saveInterest[] = new BigDecimal[6];
		for (int i=0; i<6; i++)
			saveInterest[i] = meetInterest[i].subtract(realInterest[i]);

		dMap.put("newMouth",newMouth);
		dMap.put("A_Meet_interest",meetInterest[0]);
		dMap.put("A_Real_interest",realInterest[0]);
		dMap.put("A_Save_interest",saveInterest[0]);
		dMap.put("B_Meet_interest",meetInterest[1]);
		dMap.put("B_Real_interest",realInterest[1]);
		dMap.put("B_Save_interest",saveInterest[1]);
		dMap.put("C_Meet_interest",meetInterest[2]);
		dMap.put("C_Real_interest",realInterest[2]);
		dMap.put("C_Save_interest",saveInterest[2]);
		dMap.put("D24_Meet_interest",meetInterest[3]);
		dMap.put("D24_Real_interest",realInterest[3]);
		dMap.put("D24_Save_interest",saveInterest[3]);
		dMap.put("D25_Meet_interest",meetInterest[4]);
		dMap.put("D25_Real_interest",realInterest[4]);
		dMap.put("D25_Save_interest",saveInterest[4]);
		dMap.put("D31_Meet_interest",meetInterest[5]);
		dMap.put("D31_Real_interest",realInterest[5]);
		dMap.put("D31_Save_interest",saveInterest[5]);
		return dMap;
	}
}
