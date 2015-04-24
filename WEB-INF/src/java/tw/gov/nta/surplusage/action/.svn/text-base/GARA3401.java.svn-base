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
import tw.gov.nta.surplusage.form.Gara3401Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class GARA3401 extends ExcelReportRemainAction {
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception 
	{
		Gara3401Form myForm = (Gara3401Form) form;
		BigDecimal unit = new BigDecimal(myForm.getAmountUnit());
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delSQLJob("GARA34_RPT",usrId));
		//執行 insert
		List queryList1 = (List) run.query(CommonReportSQL.Gara34SQL(myForm.getIssueEDate(),new BigDecimal(1)), new MapListHandler());
		if  (!queryList1.isEmpty() && queryList1 != null){
			String [] otherField = {"account_year","account_kind_name","account_kind"};
			String [] issueField = {"TA1","TB1","TC1","TA2","TA3","TA4","TA5","TA6","TA7","TB7","TA8","TB8","TA9","TB9","TA10","TA11"};
			String [] noPayField = {"SA1","SA2","SA3","SA4","SA5","SA6","SA7","SA8","SA9","SA10","SA11"};
			List queryList2 = countNOPayListGara33(queryList1,otherField,issueField,noPayField,"account_kind");
			Map t1Map = null;
			Map t2Map = null;
			Map dMap = new HashMap();
			//未償餘額合計
			BigDecimal sum3 = new BigDecimal(0);
			//發行數合計
			BigDecimal sum2 = new BigDecimal(0);
			//還本數合計
			BigDecimal sum1 = new BigDecimal(0);
			String accountYear ="";
			for(int i = 0 ; i < queryList1.size() ; i++){
				t1Map = (Map) queryList1.get(i);
				t2Map = (Map) queryList2.get(i);
				sum3 = new BigDecimal(0);
				dMap.putAll(getCommonMap(usrId));
				//放入發行數及還本數欄位
				dMap.putAll(t1Map);
				accountYear = ((String)dMap.get("account_year")).substring(((String)dMap.get("account_year")).length()-3,((String)dMap.get("account_year")).length());
				dMap.put("item",(String)dMap.get("account_year")+(String)dMap.get("account_kind_name"));
				for(int j = 1 ; j < 12 ; j++){
					//放入未償餘額欄位
					//user要求最後兩年可能尚未建立決算數若發行與決算均為0未償餘額"顯示為0"
					if(!accountYear.equals("088上半及089")){
						if(Integer.parseInt(myForm.getIssueEDate())> new Date().getYear()-11){
							if(Integer.parseInt(myForm.getIssueEDate())-1 <= Integer.parseInt(accountYear)){
								if( Integer.parseInt((String)dMap.get("account_kind"))!=1 &&((BigDecimal)dMap.get("ta"+String.valueOf(j))).compareTo(new BigDecimal(0))==0 && ((BigDecimal)dMap.get("sa"+String.valueOf(j))).compareTo(new BigDecimal(0))==0){
									dMap.put("RA"+String.valueOf(j),new BigDecimal(0));
								}else
									dMap.put("RA"+String.valueOf(j),(BigDecimal)t2Map.get("SA"+String.valueOf(j)));
							}else
								dMap.put("RA"+String.valueOf(j),(BigDecimal)t2Map.get("SA"+String.valueOf(j)));	
						}
						else
							dMap.put("RA"+String.valueOf(j),(BigDecimal)t2Map.get("SA"+String.valueOf(j)));
					}else
						dMap.put("RA"+String.valueOf(j),(BigDecimal)t2Map.get("SA"+String.valueOf(j)));
					
					//未償餘額合計
					if (Integer.parseInt(accountYear) >= 91 && j==4)
						sum3 = sum3.add(new BigDecimal(0));
					else
						sum3 = sum3.add((BigDecimal)dMap.get("RA"+String.valueOf(j)));
				}
				//發行數合計
				// 95/9/11修改單要求發行數合計於91年以後不含乙類借款
				if(!dMap.get("account_year").toString().equals("088上半及089")&& Integer.parseInt(dMap.get("account_year").toString()) < 91){
					sum1=((BigDecimal)dMap.get("ta1")).add((BigDecimal)dMap.get("ta2")).add((BigDecimal)dMap.get("ta3")).add((BigDecimal)dMap.get("ta4")).add((BigDecimal)dMap.get("ta5")).add((BigDecimal)dMap.get("ta6")).add((BigDecimal)dMap.get("ta7"));
					sum2=((BigDecimal)dMap.get("sa1")).add((BigDecimal)dMap.get("sa2")).add((BigDecimal)dMap.get("sa3")).add((BigDecimal)dMap.get("sa4")).add((BigDecimal)dMap.get("sa5")).add((BigDecimal)dMap.get("sa6")).add((BigDecimal)dMap.get("sa7")).add((BigDecimal)dMap.get("sa9")).add((BigDecimal)dMap.get("sa10"));
				}
				else if(!dMap.get("account_year").toString().equals("088上半及089")&& Integer.parseInt(dMap.get("account_year").toString()) >= 91){
					sum1=((BigDecimal)dMap.get("ta1")).add((BigDecimal)dMap.get("ta2")).add((BigDecimal)dMap.get("ta3")).add((BigDecimal)dMap.get("ta5")).add((BigDecimal)dMap.get("ta6")).add((BigDecimal)dMap.get("ta7"));
					sum2=((BigDecimal)dMap.get("sa1")).add((BigDecimal)dMap.get("sa2")).add((BigDecimal)dMap.get("sa3")).add((BigDecimal)dMap.get("sa5")).add((BigDecimal)dMap.get("sa6")).add((BigDecimal)dMap.get("sa7")).add((BigDecimal)dMap.get("sa9")).add((BigDecimal)dMap.get("sa10"));
				}
				else if(dMap.get("account_year").toString().equals("088上半及089")){
					sum1=((BigDecimal)dMap.get("ta1")).add((BigDecimal)dMap.get("ta2")).add((BigDecimal)dMap.get("ta3")).add((BigDecimal)dMap.get("ta4")).add((BigDecimal)dMap.get("ta5")).add((BigDecimal)dMap.get("ta6")).add((BigDecimal)dMap.get("ta7"));
					sum2=((BigDecimal)dMap.get("sa1")).add((BigDecimal)dMap.get("sa2")).add((BigDecimal)dMap.get("sa3")).add((BigDecimal)dMap.get("sa4")).add((BigDecimal)dMap.get("sa5")).add((BigDecimal)dMap.get("sa6")).add((BigDecimal)dMap.get("sa7")).add((BigDecimal)dMap.get("sa9")).add((BigDecimal)dMap.get("sa10"));
				}
				//還本數合計
				
				dMap.put("sum1",sum1.divide(unit).setScale(0,BigDecimal.ROUND_HALF_UP));
				dMap.put("sum2",sum2.divide(unit).setScale(0,BigDecimal.ROUND_HALF_UP));
				dMap.put("sum3",sum3.divide(unit).setScale(0,BigDecimal.ROUND_HALF_UP));
				
				//remove 調整數及初始值的欄位
				dMap.remove("tb1");
				dMap.remove("tc1");
				dMap.remove("tb7");
				dMap.remove("tb8");
				dMap.remove("tb9");
				//處裡金額單位
				
				if (!"".equals(myForm.getIssueSDate())) {
					if (Integer.parseInt(((String) dMap.get("item")).substring(0,3)) >= Integer.parseInt(myForm.getIssueSDate())){
						String[] issueColumn = {"ta1","ta2","ta3","ta4","ta5","ta6","ta7","ta10"};
						String[] payColumn = {"sa1","sa2","sa3","sa4","sa5","sa6","sa7","sa9","sa10"};
						String[] noPayColumn = {"RA1","RA2","RA3","RA4","RA5","RA6","RA7","RA8","RA9","RA10","RA11"};
						for(int issueColumnSize = 0 ; issueColumnSize < issueColumn.length ; issueColumnSize++)
							dMap.put(issueColumn[issueColumnSize], ((BigDecimal)dMap.get(issueColumn[issueColumnSize])).divide(unit,0,BigDecimal.ROUND_HALF_UP));
						for(int payColumnSize = 0 ; payColumnSize < payColumn.length ; payColumnSize++)
							dMap.put(payColumn[payColumnSize], ((BigDecimal)dMap.get(payColumn[payColumnSize])).divide(unit,0,BigDecimal.ROUND_HALF_UP));
						for(int noPayColumnSize = 0 ; noPayColumnSize < noPayColumn.length ; noPayColumnSize++)
							dMap.put(noPayColumn[noPayColumnSize], ((BigDecimal)dMap.get(noPayColumn[noPayColumnSize])).divide(unit,0,BigDecimal.ROUND_HALF_UP));
						run.update(connection,insTemp("GARA34_RPT",dMap));
					}
						
				}
				else
					run.update(connection,insTemp("GARA34_RPT",dMap));
			}
		}
        SQLJob queryJob1 = selTemp1();
        List queryListx = (List) run.query(queryJob1, new MapListHandler());
        String remark = "	4.";
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
