/* GARA3301.java 報表
 程式目的：DIRA0401
 程式代號：DIRA0401
 程式日期：0950308
 程式作者：Eric.Chen
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

import tw.gov.nta.surplusage.common.CommonReportSQL;
import tw.gov.nta.surplusage.form.Gara3301Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class GARA3301 extends ExcelReportRemainAction {
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Gara3301Form myForm = (Gara3301Form) form;
		BigDecimal unit = new BigDecimal(myForm.getAmountUnit());
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delSQLJob("GARA33_RPT",usrId));
		//執行 insert
		List queryList1 = (List) run.query(CommonReportSQL.Gara33SQL(myForm.getIssueEDate(),unit), new MapListHandler());
		String [] otherField = {"item","account_kind","account_year"};
		String [] issueField = {"TA1","TB1","TA2","TB2","TA3","TA4","TA5"};
		String [] noPayField = {"SA1","SA2","SA3","SA4","SA5"};
		List queryList2 = countNOPayListGara33(queryList1,otherField,issueField,noPayField,"account_kind");
		Map tMap = null;
		Map dMap = new HashMap();
		for(Iterator tIterator = queryList2.iterator(); tIterator.hasNext(); ){
			tMap = (Map) tIterator.next();
			dMap.putAll(getCommonMap(usrId));
			dMap.put("item",(String)tMap.get("item"));
			dMap.put("account_kind",(String)tMap.get("account_kind"));
			dMap.put("t1",(BigDecimal)tMap.get("TA1"));
			dMap.put("t2",(BigDecimal)tMap.get("TB1"));
			dMap.put("t3",(BigDecimal)tMap.get("TA2"));
			dMap.put("s1",((BigDecimal)dMap.get("t2")).add((BigDecimal)dMap.get("t3")));
			dMap.put("t4",(BigDecimal)tMap.get("TA4"));
			dMap.put("t5",(BigDecimal)tMap.get("TA5"));
			dMap.put("s2",((BigDecimal)dMap.get("t1")).add((BigDecimal)dMap.get("s1")).add((BigDecimal)dMap.get("t4")));
			String year = ((String)tMap.get("item")).substring(0, ((String)tMap.get("item")).length()-3);
			if(!year.equals("088上半及089") && Integer.parseInt(year) >= new Date().getYear()-11 
					&& !((String)tMap.get("account_kind")).equals("1")){
				if(((BigDecimal)dMap.get("t1")).compareTo(new BigDecimal(0))==0)
					dMap.put("t6",new BigDecimal(0));
				else
					dMap.put("t6",(BigDecimal)tMap.get("SA1"));
				if(((BigDecimal)dMap.get("s1")).compareTo(new BigDecimal(0))==0)
					dMap.put("t7",new BigDecimal(0));
				else
					dMap.put("t7",(BigDecimal)tMap.get("SA2"));
				dMap.put("t8",new BigDecimal(0));
				if(((BigDecimal)dMap.get("t4")).compareTo(new BigDecimal(0))==0)
					dMap.put("t9",new BigDecimal(0));
				else
					dMap.put("t9",(BigDecimal)tMap.get("SA4"));
				if(((BigDecimal)dMap.get("t5")).compareTo(new BigDecimal(0))==0)
					dMap.put("t10",new BigDecimal(0));
				else
					dMap.put("t10",(BigDecimal)tMap.get("SA5"));
				if (Integer.parseInt(((String)tMap.get("item")).substring(0,3)) < 91)
					dMap.put("s3",((BigDecimal)dMap.get("t6")).add((BigDecimal)dMap.get("t7")).add((BigDecimal)dMap.get("t8")).add((BigDecimal)dMap.get("t9")).add((BigDecimal)dMap.get("t10")));
				else
					dMap.put("s3",((BigDecimal)dMap.get("t6")).add((BigDecimal)dMap.get("t8")).add((BigDecimal)dMap.get("t9")).add((BigDecimal)dMap.get("t10")));
				if(((BigDecimal)dMap.get("s3")).compareTo(new BigDecimal(0))!=0){
					if (Integer.parseInt(((String)tMap.get("account_year")).substring(0,3)) < 90)
						dMap.put("budget_amount",this.getYearAmountKind(connection,((String)tMap.get("account_year")).substring(0,3),unit,"1",(String)dMap.get("account_kind")));
					else if (Integer.parseInt(((String)tMap.get("account_year")).substring(0,3)) >= 90)
						dMap.put("budget_amount",this.getYearAmountKind(connection,((String)tMap.get("account_year")).substring(0,3),unit,"2",(String)dMap.get("account_kind")));
					if (Integer.parseInt(((String)tMap.get("account_year")).substring(0,3))==89)
						dMap.put("gnp_amount",(this.getGNP(connection,((String)tMap.get("account_year")).substring(0,3),unit)).divide(new BigDecimal(1.5)));
					else
						dMap.put("gnp_amount",this.getGNP(connection,((String)tMap.get("account_year")).substring(0,3),unit));
				}
				else{
					dMap.put("budget_amount",new BigDecimal(0));
					dMap.put("gnp_amount",new BigDecimal(0));
				}
				
			}else{
				dMap.put("t6",(BigDecimal)tMap.get("SA1"));
				dMap.put("t7",(BigDecimal)tMap.get("SA2"));
				dMap.put("t8",(BigDecimal)tMap.get("SA3"));
				dMap.put("t9",(BigDecimal)tMap.get("SA4"));
				dMap.put("t10",(BigDecimal)tMap.get("SA5"));
				if (Integer.parseInt(((String)tMap.get("item")).substring(0,3)) < 91)
					dMap.put("s3",((BigDecimal)dMap.get("t6")).add((BigDecimal)dMap.get("t7")).add((BigDecimal)dMap.get("t8")).add((BigDecimal)dMap.get("t9")).add((BigDecimal)dMap.get("t10")));
				else
					dMap.put("s3",((BigDecimal)dMap.get("t6")).add((BigDecimal)dMap.get("t8")).add((BigDecimal)dMap.get("t9")).add((BigDecimal)dMap.get("t10")));
//				支(歲)出 090開始抓uamount
				if (Integer.parseInt(((String)tMap.get("account_year")).substring(0,3)) < 90)
					dMap.put("budget_amount",this.getYearAmountKind(connection,((String)tMap.get("account_year")).substring(0,3),unit,"1",(String)dMap.get("account_kind")));
				else if (Integer.parseInt(((String)tMap.get("account_year")).substring(0,3)) >= 90)
					dMap.put("budget_amount",this.getYearAmountKind(connection,((String)tMap.get("account_year")).substring(0,3),unit,"2",(String)dMap.get("account_kind")));
				if (Integer.parseInt(((String)tMap.get("account_year")).substring(0,3))==89)
					dMap.put("gnp_amount",(this.getGNP(connection,((String)tMap.get("account_year")).substring(0,3),unit)).divide(new BigDecimal(1.5)));
				else
					dMap.put("gnp_amount",this.getGNP(connection,((String)tMap.get("account_year")).substring(0,3),unit));
			}
			BigDecimal limitAmount= this.getLimitAmount(connection,((String)tMap.get("account_year")).substring(0,3),(String)dMap.get("account_kind"),unit);
			//dMap.put("CAL1",this.divideCheck(((BigDecimal)dMap.get("t1")).add((BigDecimal)dMap.get("t2")).subtract(new BigDecimal(0)),(BigDecimal)dMap.get("budget_amount")));
			//t1+t2-排限(limitAmount)/t14(budget_amount)
			dMap.put("CAL1",this.divideCheck(((BigDecimal)dMap.get("t1")).add((BigDecimal)dMap.get("t2")).subtract(limitAmount),(BigDecimal)dMap.get("budget_amount")).multiply(new BigDecimal(100)));
			dMap.put("CAL2",this.divideCheck((BigDecimal)dMap.get("t3"),(BigDecimal)dMap.get("budget_amount")));
			dMap.put("CAL3",this.divideCheck(((BigDecimal)dMap.get("t1")).add((BigDecimal)dMap.get("t2")).subtract(limitAmount).add((BigDecimal)dMap.get("t3")),(BigDecimal)dMap.get("budget_amount")).multiply(new BigDecimal(100)));
			
			if (Integer.parseInt(((String)tMap.get("account_year")).substring(0,3))==89){
				dMap.put("CAL4",this.divideCheck(((BigDecimal)dMap.get("t6")).add((BigDecimal)dMap.get("t9")).add((BigDecimal)dMap.get("t10")),(BigDecimal)dMap.get("budget_amount")).multiply(new BigDecimal(1.5)).multiply(new BigDecimal(100)));
				dMap.put("CAL5",this.divideCheck((BigDecimal)dMap.get("t7"),(BigDecimal)dMap.get("budget_amount")).multiply(new BigDecimal(1.5)).multiply(new BigDecimal(100)));
				dMap.put("CAL6",this.divideCheck(((BigDecimal)dMap.get("t6")).add((BigDecimal)dMap.get("t9")).add((BigDecimal)dMap.get("t10")).add((BigDecimal)dMap.get("t7")),(BigDecimal)dMap.get("budget_amount")).multiply(new BigDecimal(1.5)).multiply(new BigDecimal(100)));
			}
			else if (Integer.parseInt(((String)tMap.get("item")).substring(0,3)) < 91){
				dMap.put("CAL4",this.divideCheck(((BigDecimal)dMap.get("t6")).add((BigDecimal)dMap.get("t9")).add((BigDecimal)dMap.get("t10")),(BigDecimal)dMap.get("budget_amount")).multiply(new BigDecimal(100)));
				dMap.put("CAL5",this.divideCheck((BigDecimal)dMap.get("t7"),(BigDecimal)dMap.get("budget_amount")).multiply(new BigDecimal(100)));
				dMap.put("CAL6",this.divideCheck(((BigDecimal)dMap.get("t6")).add((BigDecimal)dMap.get("t9")).add((BigDecimal)dMap.get("t10")).add((BigDecimal)dMap.get("t7")),(BigDecimal)dMap.get("budget_amount")).multiply(new BigDecimal(100)));
			}else{
				dMap.put("CAL4",this.divideCheck(((BigDecimal)dMap.get("t6")).add((BigDecimal)dMap.get("t9")).add((BigDecimal)dMap.get("t10")),(BigDecimal)dMap.get("budget_amount")).multiply(new BigDecimal(100)));
				dMap.put("CAL5",new BigDecimal(0));
				dMap.put("CAL6",this.divideCheck(((BigDecimal)dMap.get("t6")).add((BigDecimal)dMap.get("t9")).add((BigDecimal)dMap.get("t10")),(BigDecimal)dMap.get("budget_amount")).multiply(new BigDecimal(100)));
			}
			if (Integer.parseInt(((String)tMap.get("account_year")).substring(0,3))==89){
				dMap.put("CAL7",this.divideCheck(((BigDecimal)dMap.get("t6")).add((BigDecimal)dMap.get("t9")).add((BigDecimal)dMap.get("t10")),((BigDecimal)dMap.get("gnp_amount"))).multiply(new BigDecimal(100)));
				dMap.put("CAL8",this.divideCheck((BigDecimal)dMap.get("t7"),((BigDecimal)dMap.get("gnp_amount"))).multiply(new BigDecimal(100)));
				dMap.put("CAL9",this.divideCheck(((BigDecimal)dMap.get("t6")).add((BigDecimal)dMap.get("t9")).add((BigDecimal)dMap.get("t10")).add((BigDecimal)dMap.get("t7")),((BigDecimal)dMap.get("gnp_amount"))).multiply(new BigDecimal(100)));
			}else{
				dMap.put("CAL7",this.divideCheck(((BigDecimal)dMap.get("t6")).add((BigDecimal)dMap.get("t9")).add((BigDecimal)dMap.get("t10")),(BigDecimal)dMap.get("gnp_amount")).multiply(new BigDecimal(100)));
				if (Integer.parseInt(((String)tMap.get("item")).substring(0,3)) < 91){
					dMap.put("CAL8",this.divideCheck((BigDecimal)dMap.get("t7"),(BigDecimal)dMap.get("gnp_amount")).multiply(new BigDecimal(100)));
					dMap.put("CAL9",this.divideCheck(((BigDecimal)dMap.get("t6")).add((BigDecimal)dMap.get("t9")).add((BigDecimal)dMap.get("t10")).add((BigDecimal)dMap.get("t7")),((BigDecimal)dMap.get("gnp_amount"))).multiply(new BigDecimal(100)));
				}
				else{
					dMap.put("CAL8",new BigDecimal(0));
					dMap.put("CAL9",this.divideCheck(((BigDecimal)dMap.get("t6")).add((BigDecimal)dMap.get("t9")).add((BigDecimal)dMap.get("t10")),((BigDecimal)dMap.get("gnp_amount"))).multiply(new BigDecimal(100)));
				}
			}
			if (!"".equals(myForm.getIssueSDate())) {
				if (Integer.parseInt(((String) dMap.get("item")).substring(0,3)) >= Integer.parseInt(myForm.getIssueSDate()))
					run.update(connection,insTemp("GARA33_RPT",dMap));
			}
			else
				run.update(connection,insTemp("GARA33_RPT",dMap));
		}
        SQLJob queryJob1 = selTemp1();
        List queryListx = (List) run.query(queryJob1, new MapListHandler());
        String remark = "	六、";
        for(Iterator it1=queryListx.iterator();it1.hasNext();)
        {
        	Map mapQry1 = (Map) it1.next();
        	remark += (String)mapQry1.get("debit_name")+",";
        }
        request.setAttribute("remark",remark.substring(0,remark.length()-1));

	}

	protected SQLJob selTemp1(){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select debit_name from debit_ref where remark = '90年度以後新增特別預算'");
		return sqljob;
	}
}
