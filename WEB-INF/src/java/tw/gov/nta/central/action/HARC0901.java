/**
 * @author AndrewSung
 * @date 2006/3/10
 */

package tw.gov.nta.central.action;

import gov.dnt.tame.common.DefaultAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.central.form.Harb0901Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;
public class HARC0901 extends DefaultAction
{

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM HARB09_RPT ");
		//sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		return sqljob;
	}

	protected SQLJob delTemp1(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM HARC09_RPT1 ");
		return sqljob;
	}
	
	protected SQLJob selTemp1(String year,String month,String prtKind)
	{
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("Select A.All_YEAR, A.All_MONTH, A.Unit_Info_id, A.All_MONEY,");
		sqljob.appendSQL("SRC_MONEY, SEQ_NO ,");
		sqljob.appendSQL("I.UNIT_ID, I.UNIT_NAME, ");
		sqljob.appendSQL("isNull((select sum(FoundA+FoundB) from Unit_allocate_main where mon_kind='2' and unit_info_id = A.Unit_Info_id and all_year = A.All_YEAR and All_MONTH <= A.All_MONTH),0) AS remark");
		sqljob.appendSQL(" From Unit_allocate_main A, Unit_info_main I");
		sqljob.appendSQL("Where A.All_YEAR = '"+year+"'");
		sqljob.appendSQL("And A.All_MONTH = '"+month+"'");
		sqljob.appendSQL("And I.ID = A.Unit_Info_id");
		sqljob.appendSQL("And A.MON_KIND = '2'");
		if("1".equals(prtKind))
			sqljob.appendSQL("And (I.groupId=01 or I.groupId=02)");
		sqljob.appendSQL("ORDER BY SEQ_NO,UNIT_ID");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	
	protected SQLJob selTemp2(String year,String month ,Object unitInfoId,String prtKind)
	{
		SQLJob sqljob = new SQLJob();
		
		sqljob.appendSQL("Select Sum(All_MONEY) as All_MONEY,");
		sqljob.appendSQL("Sum(SRC_MONEY) as SRC_MONEY");
		sqljob.appendSQL(" From Unit_allocate_main I");
		sqljob.appendSQL("Where All_YEAR = '"+year+"'");
		sqljob.appendSQL("And All_MONTH <= '"+month+"'");
		sqljob.appendSQL("And Unit_Info_id = "+ unitInfoId);
		sqljob.appendSQL("And mon_kind = '2'");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	
	protected SQLJob insTemp(String usrId,Object unitId,Object unitName,Object allMoney,Object totalMoney,Object remark,Object seqNo)
	{
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO HARB09_RPT ");
		sqljob.appendSQL(" ( ");
		sqljob.appendSQL(" USRID,UNIT_ID,UNIT_NAME,ALL_MONEY,TOTAL_MONEY,REMARK,SEQ_NO");
		sqljob.appendSQL(" ) ");
		sqljob.appendSQL(" values ( ? , ? , ? , ? ,? ,"+remark+" ,?) ");
		sqljob.addParameter(usrId);
		sqljob.addParameter(unitId);
		sqljob.addParameter(unitName);
		sqljob.addParameter(allMoney);
		sqljob.addParameter(totalMoney);
		sqljob.addParameter(seqNo);
		return sqljob;
	}
	
	protected SQLJob selTemp3(String year,String month,String prtKind)
	{
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("Select i.Unit_Name, ");
		sqljob.appendSQL("sum(u.Src_Money) as Src_Money, ");
		sqljob.appendSQL("sum(u.Last_Found) as Last_Found, ");
		sqljob.appendSQL("sum(u.Now_Found) as Now_Found, ");
		sqljob.appendSQL("sum(u.founda) as current_last, ");
		sqljob.appendSQL("sum(u.all_money) as current_now, ");
		sqljob.appendSQL("i.groupid, ");
		sqljob.appendSQL("i.seq_no ");
		sqljob.appendSQL("From Unit_Allocate_Main u,  Unit_Info_Main i ");
		sqljob.appendSQL("Where u.unit_info_id = i.id ");
		sqljob.appendSQL("And u.All_Year = '"+year+"' ");
		sqljob.appendSQL("And u.All_MONTH = '"+month+"' ");
		sqljob.appendSQL("And u.MON_KIND = '2' ");
		sqljob.appendSQL("GROUP BY u.Unit_Info_Id,i.unit_id, i.unit_name,i.groupid,i.seq_no ");
		sqljob.appendSQL("ORDER BY i.groupid,i.seq_no ");
		System.out.println(sqljob.toString());
		return sqljob;		
	}
	
	protected SQLJob selTemp4(String year,String month,String prtKind)
	{
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("Select i.Unit_Name, ");
		sqljob.appendSQL("(select x.last_found from Unit_Allocate_Main x where x.All_Year = "+year+" and x.Mon_Kind = '2' ");
		sqljob.appendSQL("and all_month = '"+month+"' and x.unit_info_id = u.unit_info_id) as current_Last, ");
		sqljob.appendSQL("sum(u.Last_Found) as Last_Found, ");
		sqljob.appendSQL("(select x.all_money from Unit_Allocate_Main x where x.All_Year = "+year+" and x.Mon_Kind = '2' ");
		sqljob.appendSQL("and all_month = '"+month+"' and x.unit_info_id = u.unit_info_id) as current_Now, ");
		sqljob.appendSQL("sum(u.all_money) as Now_Found, ");
		sqljob.appendSQL("i.groupid, i.seq_no ");
		sqljob.appendSQL("From Unit_Allocate_Main u,  Unit_Info_Main i ");
		sqljob.appendSQL("Where u.unit_info_id = i.id ");
		sqljob.appendSQL("And u.All_Year = '"+year+"' ");
		sqljob.appendSQL("And u.MON_KIND = '2' ");
		sqljob.appendSQL("And substring(u.all_month,4,5) <= substring('"+month+"',4,5)");
		sqljob.appendSQL("GROUP BY u.Unit_Info_Id,i.unit_id, i.unit_name,i.groupid,i.seq_no ");
		sqljob.appendSQL("ORDER BY i.groupid,i.seq_no ");
		System.out.println(sqljob.toString());
		return sqljob;		
	}
	
	protected SQLJob insTemp1(Object unitName,Object allMoney,Object lastFound,Object nowFound, Object current_last, Object current_now)
	{
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO HARC09_RPT1 ");
		sqljob.appendSQL(" ( ");
		sqljob.appendSQL(" unit_name, all_money,last_found, now_found, current_last, current_now");
		sqljob.appendSQL(" ) ");
		sqljob.appendSQL(" values ( ? , ? , ? , ? , ? , ?) ");
		sqljob.addParameter(unitName);
		sqljob.addParameter(allMoney);
		sqljob.addParameter(lastFound);
		sqljob.addParameter(nowFound);
		sqljob.addParameter(current_last);
		sqljob.addParameter(current_now);
		return sqljob;
	}
	
	protected SQLJob insTemp2(Object unitName,Object current_Last,Object lastFound,Object nowFound, Object current_Now)
	{
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO HARC09_RPT1 ");
		sqljob.appendSQL(" ( ");
		sqljob.appendSQL(" unit_name, current_Last,last_found, now_found, current_Now");
		sqljob.appendSQL(" ) ");
		sqljob.appendSQL(" values ( ? , ? , ? , ?, ? ) ");
		sqljob.addParameter(unitName);
		sqljob.addParameter(current_Last);
		sqljob.addParameter(lastFound);
		sqljob.addParameter(nowFound);
		sqljob.addParameter(current_Now);
		return sqljob;
	}

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		Harb0901Form myForm = (Harb0901Form)form;
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delTemp(form,usrId));
		run.update(connection,delTemp1(form,usrId));
		
		if("1".equals(myForm.getPrtKind()) || "2".equals(myForm.getPrtKind()))
		{
	        SQLJob queryJob1 = selTemp1(myForm.getSupYear(),myForm.getSupMonth(),myForm.getPrtKind());
	        
	        List queryList1 = (List) run.query(queryJob1, new MapListHandler());
	        
	        BigDecimal sum = new BigDecimal(0);
		
	        for(Iterator it1=queryList1.iterator();it1.hasNext();)
			{
				Map mapQry1 = (Map) it1.next();
				if (mapQry1 != null)
				{
					SQLJob queryJob2 = selTemp2(myForm.getSupYear(),myForm.getSupMonth(),mapQry1.get("Unit_Info_id"),myForm.getPrtKind());
					List queryList2 = (List) run.query(queryJob2, new MapListHandler());
					for(Iterator it2=queryList2.iterator();it2.hasNext();)
					{
						 Map mapQry2 = (Map) it2.next();
						 if(mapQry2 != null)
						 {
							 if("N".equals(myForm.getMinus()))
							 {
								run.update(connection,insTemp(usrId,mapQry1.get("UNIT_ID"),mapQry1.get("UNIT_NAME"),mapQry1.get("SRC_MONEY"),mapQry2.get("SRC_MONEY"),"null",mapQry1.get("SEQ_NO")));
							 }
							 if("Y".equals(myForm.getMinus()))
							 {
								run.update(connection,insTemp(usrId,mapQry1.get("UNIT_ID"),mapQry1.get("UNIT_NAME"),mapQry1.get("ALL_MONEY"),mapQry2.get("ALL_MONEY"),mapQry1.get("remark"),mapQry1.get("SEQ_NO")));
								sum = sum.add((BigDecimal)mapQry1.get("remark"));
							 }
						 }
					}
					request.setAttribute("sum",sum);
				}
			}
		}else if("3".equals(myForm.getPrtKind())){
			run.update(connection,delTemp1(form,usrId));
			SQLJob queryJob1 = selTemp3(myForm.getSupYear(),myForm.getSupMonth(),myForm.getPrtKind());
	        List queryList1 = (List) run.query(queryJob1, new MapListHandler());
	        for(Iterator it1=queryList1.iterator();it1.hasNext();)
	        {
	        	Map mapQry1 = (Map) it1.next();
	        	run.update(connection,insTemp1(mapQry1.get("Unit_Name"),mapQry1.get("Src_Money"),mapQry1.get("Last_Found"),mapQry1.get("Now_Found"),mapQry1.get("current_last"),mapQry1.get("current_now")));
	        }
		}else if("4".equals(myForm.getPrtKind())){
			run.update(connection,delTemp1(form,usrId));
			SQLJob queryJob1 = selTemp4(myForm.getSupYear(),myForm.getSupMonth(),myForm.getPrtKind());
	        List queryList1 = (List) run.query(queryJob1, new MapListHandler());
	        for(Iterator it1=queryList1.iterator();it1.hasNext();)
	        {
	        	Map mapQry1 = (Map) it1.next();
	        	run.update(connection,insTemp2(mapQry1.get("Unit_Name"),mapQry1.get("current_Last"),mapQry1.get("Last_Found"),mapQry1.get("Now_Found"),mapQry1.get("current_Now")));
	        }
		}
	}
}
