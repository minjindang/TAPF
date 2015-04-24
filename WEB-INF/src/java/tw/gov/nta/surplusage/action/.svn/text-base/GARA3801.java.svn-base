
package tw.gov.nta.surplusage.action;

import gov.dnt.tame.common.ExcelReportRemainAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;
import tw.gov.nta.sql.debt.GaraNote;
import tw.gov.nta.surplusage.common.GaraNoteManager;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;


public class GARA3801 extends ExcelReportRemainAction{
	
	protected SQLJob SQL1(ActionForm form){
		AccountQueryForm myForm = (AccountQueryForm) form;
		SQLJob sqljob = new SQLJob();
		//sqljob.appendSQL("INSERT INTO GARA38_RPT (USRID,MOD_DATE,mth,mon,issue_serial,DEBIT_TIME,budget_A,special_A,debit_A,budget_C,special_C,debit_C,total_B,total_D,REMARK ) ");
		//sqljob.appendSQL("select  ?,?,substring(right('0000000'+convert(varchar,(convert(varchar,ISSUE_DATE, 112)-19110000)),7),4,2) as  mth  ,");
		//sqljob.addParameter(usrId);
		//sqljob.addParameter(new Timestamp( new Date().getTime() ));
		sqljob.appendSQL("select  id,substring(right('0000000'+convert(varchar,(convert(varchar,ISSUE_DATE, 112)-19110000)),7),4,2) as  mth  ,");
		sqljob.appendSQL(" ( case substring(right('0000000'+convert(varchar,(convert(varchar,ISSUE_DATE, 112)-19110000)),7),4,2) ");
		sqljob.appendSQL(" when '01' then '一月份' when '02' then '二月份' when '03' then '三月份' ");
		sqljob.appendSQL(" when '04' then '四月份' when '05' then '五月份' when '06' then '六月份' ");
		sqljob.appendSQL(" when '07' then '七月份' when '08' then '八月份' when '09' then '九月份' ");
		sqljob.appendSQL(" when '10' then '十月份'  when '11' then '十一月份' when '12' then '十二月份'  else '' end ) as mon,  ");//--月份
		//sqljob.appendSQL(" issue_serial, "); // --期別
		sqljob.appendSQL("((case when bond_kind=3 then '增' else '' end)+account_year+");
		sqljob.appendSQL("(case when bond_type = 1 then '甲' when bond_type=2 then '-' else '' end)+");
		sqljob.appendSQL("serial_no+");
		sqljob.appendSQL("(case when debt_type='A' then '公債' when debt_type='B' then '國庫券' when debt_type='C' then '中長借' when debt_type='D' then '短借' else ''  end)) as issue_serial,");
		sqljob.appendSQL(" SUBSTRING(right('0000000'+convert(varchar,(convert(varchar,ISSUE_DATE, 112)-19110000)),7),1,3)+'.'+ ");
		sqljob.appendSQL(" SUBSTRING(right('0000000'+convert(varchar,(convert(varchar,ISSUE_DATE, 112)-19110000)),7),4,2)+'.'+ ");
		sqljob.appendSQL(" SUBSTRING(right('0000000'+convert(varchar,(convert(varchar,ISSUE_DATE, 112)-19110000)),7),6,2)+'('+ ");
		
		sqljob.appendSQL("(case when debt_type='D' then  convert(varchar,datediff(dd,issue_date,due_date))+'天期)'");
		sqljob.appendSQL(" else (case show_type ");
		sqljob.appendSQL(" when  'A' then  convert(varchar,datediff(yy,issue_date,due_date))+'年期)' ");
		sqljob.appendSQL(" when 'B' then  convert(varchar,datediff(mm,issue_date,due_date))+')' ");
		sqljob.appendSQL(" when 'C' then  convert(varchar,datediff(dd,issue_date,due_date))+'天期)' ");
		sqljob.appendSQL(" when 'D' then  convert(varchar,round(datediff(yy,issue_date,due_date),0))+'年'+convert(varchar,(datediff(mm,issue_date,due_date)%12))+'月)' ");
		sqljob.appendSQL(" else convert(varchar,datediff(yy,issue_date,due_date))+'年期)' end ");
		sqljob.appendSQL(" ) end )AS DEBIT_TIME, "); //--時間 
		//修改
		sqljob.appendSQL(" isNull((select sum(B.issue_amount) from debt_main B ,issue_main C where  B.issue_id = C.id and C.debt_type='A' and B.budget_code='1' and C.bond_type='1' and C.id=A.id),0)/100000000 as budget_A,  "); //--公債總預算
		sqljob.appendSQL(" isNull((select sum(B.issue_amount) from debt_main B ,issue_main C where  B.issue_id = C.id and C.debt_type='A' and B.budget_code='2' and C.bond_type='1' and C.id=A.id),0)/100000000 as special_A,  "); //--公債特別預算
		sqljob.appendSQL(" isNull((select sum(B.issue_amount) from debt_main B ,issue_main C where  B.issue_id = C.id and C.debt_type='A' and B.budget_code='3' and C.bond_type='1' and C.id=A.id),0)/100000000 as debit_A,  ");//--公債債務基金
		sqljob.appendSQL(" isNull((select sum(B.issue_amount) from debt_main B ,issue_main C where  B.issue_id = C.id and C.debt_type='C' and B.budget_code='1' and C.bond_type='2' and C.id=A.id),0)/100000000 as budget_C,  ");//--借款總預算
		sqljob.appendSQL(" isNull((select sum(B.issue_amount) from debt_main B ,issue_main C where  B.issue_id = C.id and C.debt_type='C' and B.budget_code='2' and C.bond_type='2' and C.id=A.id),0)/100000000 as special_C,  ");//--借款特別預算
		sqljob.appendSQL(" isNull((select sum(B.issue_amount) from debt_main B ,issue_main C where  B.issue_id = C.id and C.debt_type='C' and B.budget_code='3' and C.bond_type='2' and C.id=A.id),0)/100000000 as debit_C,  ");//--借款債務基金
		/*
		sqljob.appendSQL(" sum(case when debt_type='A' and Budget_code='1'  then issue_amount/100000000 else 0 end) as budget_A,  "); //--公債總預算
		sqljob.appendSQL(" sum(case when debt_type='A' and Budget_code='2'  then issue_amount/100000000 else 0 end) as special_A,  "); //--公債特別預算
		sqljob.appendSQL(" sum(case when debt_type='A' and Budget_code='3'  then issue_amount/100000000 else 0 end) as debit_A,  ");//--公債債務基金
		sqljob.appendSQL(" sum(case when debt_type='C' and Budget_code='1'  then issue_amount/100000000 else 0 end) as budget_C, ");// --借款總預算
		sqljob.appendSQL(" sum(case when debt_type='C' and Budget_code='2'  then issue_amount/100000000 else 0 end) as special_C,  ");//--借款特別預算
		sqljob.appendSQL(" sum(case when debt_type='C' and Budget_code='3'  then issue_amount/100000000 else 0 end) as debit_C,  ");//--借款債務基金
		*/
		sqljob.appendSQL(" sum(case when debt_type='B'  then issue_amount/100000000 else 0 end) as total_B, ");// --國庫卷
		sqljob.appendSQL(" sum(case when debt_type='D' and debt_code<>25  then issue_amount/100000000 else 0 end) as total_D,   ");//--短期借款
		sqljob.appendSQL("(case  debt_type when 'A' then '票面利率' + convert(varchar,convert(decimal(18,3),average_rate)) + ' ' + isNull(REMARK,'') + '%' ");
		sqljob.appendSQL("when 'B' then '貼現率:' + convert(varchar,convert(decimal(18,3),average_rate)) + ' ' + isNull(REMARK,'') + '%' ");
		sqljob.appendSQL("when 'C' then isNull(REMARK,'') ");
		sqljob.appendSQL("when 'D' then isNull(REMARK,'') else '' end) as REMARK1  ");
		sqljob.appendSQL(" from issue_main A ");
		sqljob.appendSQL(" where year(issue_date)-1911 =  "+myForm.getAccountYear()+" ");
		sqljob.appendSQL(" and month(issue_date) <= " + myForm.getMonth() + " " );
		sqljob.appendSQL(" and A.DEBT_CODE<> (SELECT ID FROM DEBIT_REF WHERE DEBIT_TYPE='DA')" );
		sqljob.appendSQL(" group by id,issue_serial,issue_date,due_date,show_type,debt_type,REMARK, ");
		sqljob.appendSQL("((case when bond_kind=3 then '增' else '' end)+account_year+");
		sqljob.appendSQL("(case when bond_type = 1 then '甲' when bond_type=2 then '-' else '' end)+");
		sqljob.appendSQL("serial_no+");
		sqljob.appendSQL("(case when debt_type='A' then '公債' when debt_type='B' then '國庫券' when debt_type='C' then '中長借' when debt_type='D' then '短借' else ''  end)),");
		sqljob.appendSQL("(case  debt_type when 'A' then '票面利率' + convert(varchar,convert(decimal(18,3),average_rate)) + ' ' + isNull(REMARK,'') + '%' ");
		sqljob.appendSQL("when 'B' then '貼現率:' + convert(varchar,convert(decimal(18,3),average_rate)) + ' ' + isNull(REMARK,'') + '%' ");
		sqljob.appendSQL("when 'C' then isNull(REMARK,'') ");
		sqljob.appendSQL("when 'D' then isNull(REMARK,'') else '' end) ");
		sqljob.appendSQL(" order by ISSUE_DATE ");
		System.out.println("GARA3801-SQL1:"+sqljob.toString());
		return sqljob;
	}
	
	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {

		AccountQueryForm myForm = (AccountQueryForm) form;
		GaraNote garaNote = new GaraNoteManager().getGaraNote(myForm.getPath());
		garaNote.setMemo(myForm.getMemo());
		garaNote.setPath(myForm.getPath());
		new GaraNoteManager().confirm(garaNote);
		request.setAttribute("memo",garaNote.getMemo());
		
		//		取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delSQLJob("GARA38_RPT",usrId));
		//執行 insert
		List queryList1 = (List) run.query(SQL1(form), new MapListHandler());
		Map tMap = null;
		//Map dMap = new HashMap();
		for(Iterator tIterator = queryList1.iterator(); tIterator.hasNext(); ){
			tMap = (Map) tIterator.next();
			tMap.putAll(getCommonMap(usrId));
			String [] field = {"budget_A","special_A","debit_A","budget_C","special_C","debit_C","total_B","total_D"};
			for (int i = 0 ; i < field.length ; i++){
				tMap.put(field[i],getNullValue((BigDecimal)tMap.get(field[i])));
			}
			tMap.put("remark",(String)tMap.get("REMARK1"));
			tMap.remove("id");
			tMap.remove("REMARK1");
			run.update(connection,insTemp("GARA38_RPT",tMap));
		}
	}
}