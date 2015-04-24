/**
 * @author AndrewSung
 * @date 2006/3/10
 */

package tw.gov.nta.central.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.central.form.Harb1001Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;
public class HARC1001 extends DefaultAction
{

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM HARB10_RPT ");
		//sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		return sqljob;
	}
	//取得Taxaction_det 匯款行,批號,種類,條件為form傳入之 年,月
	protected SQLJob selTemp1(String year,String month,String monKind)
	{
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("SELECT BANKNO, MON_NO,MON_KIND , TAX_KIND" );
		sqljob.appendSQL("FROM Taxaction_det ");
		sqljob.appendSQL("WHERE (TAX_YEAR = '"+year+"') AND (TAX_MONTH = '"+month+"') AND (TAX_KIND ='"+monKind+"')");
//		sqljob.appendSQL("FROM Taxaction_det A , Unit_info_main B , Unit_allocate_main C");
//		sqljob.appendSQL("WHERE (TAX_YEAR = '"+year+"') AND (TAX_MONTH = '"+month+"') ");
//		sqljob.appendSQL(" AND C.MON_KIND = A.TAX_KIND");
//		sqljob.appendSQL(" AND B.ID = C.UNIT_INFO_ID");
//		sqljob.appendSQL("ORDER BY B.SEQ_NO,A.UNIT_ID,BANKNO");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	//取得Unit_allocate_main條件為查詢1之種類與傳入之年月
//	protected SQLJob selTemp2(String year,String month,String monKind)
//	{
//		SQLJob sqljob = new SQLJob();
//		
//		sqljob.appendSQL("SELECT ALL_MONEY, UNIT_INFO_ID");
//		sqljob.appendSQL("FROM Unit_allocate_main");
//		sqljob.appendSQL("WHERE (ALL_YEAR = '"+year+"') AND (MON_KIND = '"+monKind+"') ");
//		sqljob.appendSQL("AND (ALL_MONTH = '"+month+"')");
//		System.out.println(sqljob.toString());
//		return sqljob;
//	}
//	//若傳入種類編號為1(中央統籌)查詢Unit_info_main之SBANK,TBANK,TACCT
//	protected SQLJob selTemp3(String kind,Integer unitInfoId)
//	{
//		SQLJob sqljob = new SQLJob();
//		
//		sqljob.appendSQL("SELECT SEQ_NO,UNIT_ID,SNO"+ kind +" AS SBANK, TBANK"+ kind +" AS TBANK, TACCT"+ kind +" AS TACCT");
//		sqljob.appendSQL("FROM Unit_info_main");
//		sqljob.appendSQL("WHERE (ID = "+unitInfoId+") ORDER BY SEQ_NO,UNIT_ID,SBANK"+ kind );
//		System.out.println(sqljob.toString());
//		return sqljob;
//	}
	protected SQLJob selTemp2(String year,String month,String monKind)
	{
		SQLJob sqljob = new SQLJob();
		
		sqljob.appendSQL("SELECT ");
		sqljob.appendSQL("A.SEQ_NO,A.UNIT_ID , A.SNO"+monKind+" AS SBANK , A.TBANK"+monKind+" AS TBANK, A.TACCT"+monKind+" AS TACCT ,");
		sqljob.appendSQL("B.all_money as Now_Found, B.UNIT_INFO_ID FROM UNIT_INFO_MAIN A , Unit_allocate_main B ");
		sqljob.appendSQL("WHERE (A.ID = B.UNIT_INFO_ID)");
		sqljob.appendSQL("AND (ALL_YEAR = '"+year+"') ");
		sqljob.appendSQL("AND (MON_KIND = '"+monKind+"') ");
		sqljob.appendSQL("AND (ALL_MONTH = '"+month+"')");
		sqljob.appendSQL("ORDER BY groupid,SEQ_NO,UNIT_ID");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	protected SQLJob insTemp(String code, String usrId,Object bankNo,Object monNo,String serialNo,String day,
			Object monKind,Object sbank,Object tacct,Object tbank,Object allMoney){
		
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO HARB10_RPT ");
		sqljob.appendSQL(" ( ");
		sqljob.appendSQL(" CODE, USRID ,BANKNO,MON_NO,SERIAL_NO,SEND_DATE,");
		sqljob.appendSQL("MOD_KIND,SBANK,TACCT,TBANK,ALL_MONEY");
		sqljob.appendSQL(" ) ");
		sqljob.appendSQL(" values ( ? , ? , ? , ? , ?  , ? , ? , ? , ? , ? , "+allMoney+" ) ");
		sqljob.addParameter(code);
		sqljob.addParameter(usrId);
		sqljob.addParameter(bankNo);
		sqljob.addParameter(monNo);
		sqljob.addParameter(serialNo);
		sqljob.addParameter(day);
		sqljob.addParameter(monKind);
		sqljob.addParameter(sbank);
		sqljob.addParameter(tacct);
		sqljob.addParameter(tbank);
		//sqljob.addParameter(allMoney);
		System.out.println(sqljob.toString());
		return sqljob;
	}
	private String LengthFillter(String pData, int pLength){
		if(pData.getBytes().length == pLength)
			return pData;
		if(pData.getBytes().length > pLength)
			return pData.substring(0,pLength);
		return LengthFillter("0" + pData, pLength);
	}
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		Harb1001Form myForm = (Harb1001Form)form;
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delTemp(form,usrId));
		Integer seralNo = 1;
        SQLJob queryJob1 = selTemp1(myForm.getSupYear(),myForm.getSupMonth(),myForm.getMonKind());
        List queryList1 = (List) run.query(queryJob1, new MapListHandler());
        String sendDate = DateUtil.date2ROCStr(DateUtil.date());
        String taxDate ="";
        for(Iterator it1=queryList1.iterator();it1.hasNext();)
		{
			Map mapQry1 = (Map) it1.next();
			if (mapQry1 != null)
			{
				String monNo = (String)mapQry1.get("MON_NO");
				if(!"1".equals(monNo.subSequence(0,1)))
					taxDate = LengthFillter((String)mapQry1.get("MON_NO") ,6);
				else
					taxDate = LengthFillter((String)mapQry1.get("MON_NO") ,7);
				BigDecimal totalAmount = new BigDecimal(0);
				BigDecimal lastAmount = null;
				run.update(connection,insTemp("1",usrId,mapQry1.get("BANKNO"),mapQry1.get("MON_NO"),LengthFillter(String.valueOf(seralNo) ,5),taxDate,"","","","財政部國庫署",null));
				String taxKind = "";
				if(mapQry1.get("TAX_KIND") != null)
					taxKind = mapQry1.get("TAX_KIND").toString();
				SQLJob queryJob2 = selTemp2(myForm.getSupYear(),myForm.getSupMonth(),taxKind);
				List queryList2 = (List) run.query(queryJob2, new MapListHandler());
				
				for(Iterator it2=queryList2.iterator();it2.hasNext();)
				{
					 Map mapQry2 = (Map) it2.next();
					 if(mapQry2 != null)
					 {
						 seralNo++;
						 run.update(connection,insTemp("2",usrId,mapQry1.get("BANKNO"),
								 mapQry1.get("MON_NO"),LengthFillter(String.valueOf(seralNo),5),taxDate,mapQry1.get("MON_KIND"),
								 mapQry2.get("SBANK"),mapQry2.get("TACCT"),mapQry2.get("TBANK"),mapQry2.get("Now_Found")));
						 totalAmount = totalAmount.add(new BigDecimal(null!=mapQry2.get("Now_Found")?mapQry2.get("Now_Found").toString():"0"));
//						 SQLJob queryJob3 = selTemp3(mapQry1.get("TAX_KIND").toString(),Integer.parseInt(mapQry2.get("UNIT_INFO_ID").toString()));
//						 List queryList3 = (List) run.query(queryJob3, new MapListHandler());
//						 for(Iterator it3=queryList3.iterator();it3.hasNext();)
//						 {
//							 seralNo++;
//							 Map mapQry3 = (Map) it3.next();
//							 if (mapQry3 != null)
//							 {	 
//								 run.update(connection,insTemp("2",usrId,mapQry1.get("BANKNO"),mapQry1.get("MON_NO"),LengthFillter(String.valueOf(seralNo),5),sendDate,mapQry1.get("MON_KIND"),mapQry3.get("SBANK"),mapQry3.get("TACCT"),mapQry3.get("TBANK"),mapQry2.get("ALL_MONEY"),mapQry3.get("SEQ_NO").toString(),mapQry3.get("UNIT_ID").toString()));
//								 //System.out.println(usrId+"+"+mapQry1.get("BANKNO")+"+"+mapQry1.get("MON_NO")+"+"+seralNo+"+"+sendDate+"+"+mapQry1.get("MOD_KIND")+"+"+mapQry3.get("SBANK")+"+"+mapQry3.get("TACCT")+"+"+mapQry3.get("TBANK")+"+"+mapQry2.get("ALL_MONEY"));
//								 totalAmount = totalAmount.add(new BigDecimal(mapQry2.get("ALL_MONEY").toString()));
//							 }																			
//						 }
					 }
				}
				run.update(connection,insTemp("3",usrId,mapQry1.get("BANKNO"),mapQry1.get("MON_NO"),"99999",taxDate,"","0000233","","",totalAmount));
			}
		}
	}
}
