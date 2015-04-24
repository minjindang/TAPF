package tw.gov.nta.exchequer.action;

import gov.dnt.tame.common.ExcelReportBaseAction;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.exchequer.form.Bira0901Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class BIRA0901 extends ExcelReportBaseAction{
	
	protected SQLJob QrySQL(Bira0901Form myForm,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select '"+usrId+"' as usrId,'"+new Timestamp( new Date().getTime())+"' as mod_date,'財'+substring(A.issue_serial,2,20) as issue_serial,"); //期別
		sqljob.appendSQL("datediff(dd,A.issue_date, A.due_date) as date_period,"); //天期
		sqljob.appendSQL("A.issue_date,A.due_date,");//發行日及到期日
		sqljob.appendSQL("isNull(A.issue_amount,0) as issue_amount,");//發行數
		sqljob.appendSQL("A.remark,");//備註
		sqljob.appendSQL("isNull(A.real_amount,0) as real_amount,");//實收額
		sqljob.appendSQL("isNull(B.bid_Amount,0) as bid_Amount,");//投標金額
		sqljob.appendSQL("isNull(B.hight_rate,0) as low_rate,");//最高得標價格-貼現率
		sqljob.appendSQL("isNull(B.low_rate,0) as hight_rate,");//最低得標價格-貼現率
		sqljob.appendSQL("(isnull((select max(issue_price) from central_issue_det where issue_id = A.id and isnull(gotbid_amount,0) > 0) ,0)) as hight_price,");
		sqljob.appendSQL("(isnull((select min(issue_price) from central_issue_det where issue_id = A.id and isnull(gotbid_amount,0) > 0) ,0)) as low_price,");
		sqljob.appendSQL("(isnull((select sum(issue_price*gotbid_amount)/isnull(sum(gotbid_amount) +1,1) from central_issue_det where issue_id = A.id and gotbid_amount is not null) ,0)) as average_price,");
		sqljob.appendSQL("isNull(case when isNull(B.average_rate,0) = 0 then isNull(A.average_rate,0) else isNull(B.average_rate,0) end,0)  as average_rate,");//平均得標價格-貼現率
		sqljob.appendSQL("(isNull(A.issue_amount,0) - isNull(A.real_amount,0) - isNull(A.interest_amount,0)) as sub_amount ");
		sqljob.appendSQL("from issue_main A left outer join central_issue_main B on A.id=B.issue_id ");
		sqljob.appendSQL("where A.debt_type='B' ");
		if (null != myForm.getIssueSdate() && null != myForm.getIssueEdate()){
			sqljob.appendSQL("and A.issue_date between ? and ? ");
			sqljob.addParameter(myForm.getIssueSdate());
			sqljob.addParameter(myForm.getIssueEdate());
		}
		if (null != myForm.getPrintDate()){
			sqljob.appendSQL("and A.issue_date <= ? ");
			sqljob.addParameter(myForm.getPrintDate());
		}
		sqljob.appendSQL("order by A.issue_serial ");
		return sqljob;
	}
	
	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		Bira0901Form bira0901Form = (Bira0901Form) form;
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delSQLJob("BIRA09_RPT",usrId));
		//執行 insert
		List queryList1 = (List) run.query(QrySQL(bira0901Form,usrId), new MapListHandler());
		Map tMap = null;
		
		/*user要求期別F090_03之後的改採單一利率標及登記形式發行。
		 *F090_03發行日為0901008
		 */
		Date chooseDate = DateUtil.str2Date("0901007");
		for(Iterator tIterator = queryList1.iterator(); tIterator.hasNext(); ){
			tMap = (Map) tIterator.next();
			
			//利息費用=發行數-實收額-利息節數
			if(tMap.get("issue_serial").toString().equals("F075_01"))
				tMap.put("interest_amount",new BigDecimal("25277600"));
			else if (tMap.get("issue_serial").toString().equals("F083_03"))
				tMap.put("interest_amount",new BigDecimal("383867303"));
			else
				tMap.put("interest_amount",((BigDecimal)tMap.get("issue_amount")).subtract((BigDecimal)tMap.get("real_amount")));
				//tMap.put("interest_amount",((BigDecimal)tMap.get("issue_amount")).subtract((BigDecimal)tMap.get("real_amount")).subtract((BigDecimal)tMap.get("sub_amount")));
			//投標倍數=投標金額/發行數
			if(((BigDecimal)tMap.get("issue_amount")).intValue() != 0)
				tMap.put("bid_rate",((BigDecimal)tMap.get("bid_amount")).divide(((BigDecimal)tMap.get("issue_amount")),4,5));
			else
				tMap.put("bid_rate",new BigDecimal(0));
			
			//user要求期別F090_03之後的改採單一利率標及登記形式發行。
			if (((Date)tMap.get("issue_date")).after(chooseDate)){
				tMap.put("hight_rate",new BigDecimal(0));
				tMap.put("average_rate",new BigDecimal(0));
				tMap.put("hight_price",new BigDecimal(0));
				tMap.put("average_price",new BigDecimal(0));
			}
			
			if(tMap.get("issue_serial").toString().equals("F085_03")){
				tMap.put("hight_price",new BigDecimal("9804.48"));
				tMap.put("low_price",new BigDecimal("9782.38"));
				tMap.put("average_price",new BigDecimal("9793.77"));
			}
			else if(tMap.get("issue_serial").toString().equals("F087_02")){
				tMap.put("hight_price",new BigDecimal("9840.53"));
				tMap.put("low_price",new BigDecimal("9826.07"));
			}
			else if(tMap.get("issue_serial").toString().equals("F087_03")){
				tMap.put("hight_price",new BigDecimal("9764.06"));
				tMap.put("low_price",new BigDecimal("9756.82"));
			}
			else if(tMap.get("issue_serial").toString().equals("F089_04"))
				tMap.put("average_price",new BigDecimal("9760.02"));
			else if(tMap.get("issue_serial").toString().equals("F089_06"))
				tMap.put("average_price",new BigDecimal("9723.92"));
			else if(tMap.get("issue_serial").toString().equals("F089_10"))
				tMap.put("average_price",new BigDecimal("9804.02"));
			else if(tMap.get("issue_serial").toString().equals("F091_07"))
				tMap.put("low_price",new BigDecimal("9849.29"));
			else if(tMap.get("issue_serial").toString().equals("F092_02"))
				tMap.put("low_price",new BigDecimal("9947.15"));
			else if(tMap.get("issue_serial").toString().equals("F093_03"))
				tMap.put("low_price",new BigDecimal("9946.40"));
			else if(tMap.get("issue_serial").toString().equals("F095_01"))
				tMap.put("low_price",new BigDecimal("9923.31"));
			else if(tMap.get("issue_serial").toString().equals("F093_04")){
				tMap.put("bid_rate",new BigDecimal(2.15));
			}
			else if(tMap.get("issue_serial").toString().equals("F093_03")){
				tMap.put("low_rate",new BigDecimal(1.075));
			}
			else if(tMap.get("issue_serial").toString().equals("F096_01"))
				tMap.put("low_price",new BigDecimal("9898.16"));
			else if(tMap.get("issue_serial").toString().equals("F096_02"))
				tMap.put("low_price",new BigDecimal("9868.36"));
			//最高得標價格==>每萬元
			if (((BigDecimal)tMap.get("hight_price")).intValue() == 0){
				 if (((BigDecimal)tMap.get("hight_rate")).intValue() == 0)
					tMap.put("hight_price",new BigDecimal(0));
				else
					tMap.put("hight_price",(new BigDecimal(100).subtract((BigDecimal)tMap.get("hight_rate"))).multiply(new BigDecimal(100)));
			}
			//最低得標價格==>每萬元
			if (((BigDecimal)tMap.get("low_price")).intValue() == 0){
//				if (((BigDecimal)tMap.get("low_rate")).intValue() == 0)
				if (((BigDecimal)tMap.get("low_rate")).doubleValue() == 0)
					tMap.put("low_price",new BigDecimal(0));
				else
					tMap.put("low_price", (new BigDecimal(1).subtract(((BigDecimal.valueOf(Integer.valueOf(tMap.get("date_period").toString()))).divide(new BigDecimal(365),5,5)).multiply(((BigDecimal)tMap.get("low_rate")).divide(new BigDecimal(100),5,5)))).multiply(new BigDecimal(10000)));
//					tMap.put("low_price",(new BigDecimal(100).subtract((BigDecimal)tMap.get("low_rate"))).multiply(new BigDecimal(100)));
			}
			//加權平均價格==>每萬元
			if (((BigDecimal)tMap.get("average_price")).intValue() == 0){
				if(tMap.get("issue_serial").toString().equals("F075_01"))
					tMap.put("average_price",new BigDecimal(0));
				else if (((BigDecimal)tMap.get("average_rate")).intValue() == 0)
					tMap.put("average_price",new BigDecimal(0));
				else
					tMap.put("average_price",((new BigDecimal(100).subtract((BigDecimal)tMap.get("average_rate"))).multiply(new BigDecimal(100))));
			}
			tMap.put("issue_amount",((BigDecimal)tMap.get("issue_amount")).divide(new BigDecimal(100000000),2,4));
			run.update(connection,insTemp("BIRA09_RPT",tMap));
		}
	}
}
