
package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;


public class EARE1301 extends DefaultAction{
	
	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM EARE13_RPT ");
		////sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		return sqljob;
	}
	/*
select 
a.account_year,a.source_issue_id,b.debt_code,substring(b.debt_serial,1,5)+SUBSTRING(b.debt_serial,7,1),
--公債名稱
min(debt_short_name) + '(' + debit_name+')' ,
--發行名稱
(select issue_date from issue_main where id = a.source_issue_id) as issue_date,
--償還日期
min(due_date) due_date,

max(a.average_rate) average_rate ,
--預計發行總額
sum(b.issue_amount)as issue_amount,
--實售面額
sum(b.issue_amount) as real_amount , 
--償還額
0 as remain_amount,
--結欠額
sum(b.issue_amount) - 0 as close_amount,

--繳庫數
0 as return_amount,

--利息支出
( select sum( isnull(interest_amount,0)) from debt_plan_det
   where  debt_id in
     (select id from debt_main g where g.debt_code = b.debt_code
                                                   and issue_id in 
                                         ( select id from issue_main where source_issue_id = a.source_issue_id
                                                   and right('0000000'+convert(varchar,(convert(varchar,issue_date, 112)-19110000)),7) <='0950331'
  			  and right('0000000'+convert(varchar,(convert(varchar,due_date, 112)-19110000)),7) > '0950331')
      )
    and right('0000000'+convert(varchar,(convert(varchar,repay_date, 112)-19110000)),7) >'0950331'
) close_amount,
--應付利息
( select sum(isnull(origin_interest_amount,0) - isnull(interest_amount,0)) from debt_plan_det
   where  debt_id in
     (select id from debt_main g where g.debt_code = b.debt_code
                                                    and issue_id in 
                                           ( select id from issue_main where source_issue_id = a.source_issue_id
                                                   and right('0000000'+convert(varchar,(convert(varchar,issue_date, 112)-19110000)),7) <='0950331'
  			  and right('0000000'+convert(varchar,(convert(varchar,due_date, 112)-19110000)),7) > '0950331')
     )
    and right('0000000'+convert(varchar,(convert(varchar,repay_date, 112)-19110000)),7) >'0950331'
) payable_interest_amount

from issue_main a, debt_main b, debit_ref e
where a.id = b.issue_id
  and b.debt_code = e.id
  and debt_type = 'A'
  and right('0000000'+convert(varchar,(convert(varchar,issue_date, 112)-19110000)),7) <='0950331'
  and right('0000000'+convert(varchar,(convert(varchar,due_date, 112)-19110000)),7) > '0950331'
  and debt_short_name is not null

group by a.account_year,a.source_issue_id,b.debt_code, e.DEBIT_NAME,substring(b.debt_serial,1,5)+SUBSTRING(b.debt_serial,7,1)
order by a.account_year,substring(b.debt_serial,1,5)+SUBSTRING(b.debt_serial,7,1),b.debt_code

	 */
	 

	protected SQLJob insTemp(ActionForm form,String usrId){
		AccountQueryForm myForm = (AccountQueryForm) form;
	    String yyy="",mm="", lastDate = myForm.getLastDate();
	    yyy = lastDate.substring(0,3);
	    mm  = lastDate.substring(3,5);
	    System.out.println(lastDate);
	    if (mm.equals("01")){
	    	yyy = strPad(String.valueOf(Integer.parseInt(yyy)-1).trim(), 3, '0', true)	;
	    	mm  = "12";
	    }else{
	    	mm  = strPad(String.valueOf(Integer.parseInt(mm)-1).trim(), 2, '0', true)	;
	    }
	    String oldDate1,oldDate2;
	    oldDate1 = yyy+mm+"01";
	    oldDate2 = yyy+mm+"31";
		SQLJob sqljob = new SQLJob();
		//公債	
		sqljob.appendSQL(" INSERT INTO EARE13_RPT (remark,col01,col02,col03,col04,col05,col06, col07,col08,col09,remark2,remark3 ) ");
		sqljob.appendSQL(" (select '公債',col1,col2,col3,col4,col5,col6,col7,col8,null,'小計','1' ");  
		sqljob.appendSQL(" from ");
		sqljob.appendSQL(" (");
		sqljob.appendSQL(" select col1,col2,col3,col4,col5,col6,col7,col8  ");
		sqljob.appendSQL(" from "); 
		sqljob.appendSQL(" (");
		sqljob.appendSQL(" select sum(b.issue_amount) as col1,sum(b.o_divided - b.d_divided) as col2 ");
		sqljob.appendSQL(" from issue_main a, debt_main b, debit_ref e ");
		sqljob.appendSQL(" where a.id = b.issue_id ");
		sqljob.appendSQL(" and b.debt_code = e.id ");
		sqljob.appendSQL(" and debt_type = 'A' ");
		sqljob.appendSQL(" and right('0000000'+convert(varchar,(convert(varchar,issue_date, 112)-19110000)),7) <= ? ");
		sqljob.appendSQL(" and right('0000000'+convert(varchar,(convert(varchar,due_date, 112)-19110000)),7) > ? ");
		sqljob.appendSQL(" ) table1 ");
		sqljob.appendSQL(" ,");
		sqljob.appendSQL(" (");
		sqljob.appendSQL(" select sum(b.issue_amount) as col3,sum(b.o_divided - b.d_divided) as col4 ");
		sqljob.appendSQL(" from issue_main a, debt_main b, debit_ref e ");
		sqljob.appendSQL(" where a.id = b.issue_id ");
		sqljob.appendSQL(" and b.debt_code = e.id ");
		sqljob.appendSQL(" and debt_type = 'A' ");
		sqljob.appendSQL(" and right('0000000'+convert(varchar,(convert(varchar,due_date, 112)-19110000)),7) >= ? ");
		sqljob.appendSQL(" and right('0000000'+convert(varchar,(convert(varchar,due_date, 112)-19110000)),7) <= ? ");
		sqljob.appendSQL(" ) as table2");
		sqljob.appendSQL(" ,");
		sqljob.appendSQL(" (");
		sqljob.appendSQL(" select sum(b.issue_amount) as col5 ,sum(b.o_divided - b.d_divided) as col6 ");
		sqljob.appendSQL(" from issue_main a, debt_main b, debit_ref e ");
		sqljob.appendSQL(" where a.id = b.issue_id ");
		sqljob.appendSQL(" and b.debt_code = e.id ");
		sqljob.appendSQL(" and debt_type = 'A' ");
		sqljob.appendSQL(" and right('0000000'+convert(varchar,(convert(varchar,issue_date, 112)-19110000)),7) >= ? ");
		sqljob.appendSQL(" and right('0000000'+convert(varchar,(convert(varchar,issue_date, 112)-19110000)),7) <= ?  ");
		sqljob.appendSQL(" ) table3,");
		sqljob.appendSQL(" (");
		sqljob.appendSQL(" select sum(b.issue_amount) as col7 ,sum(b.o_divided - b.d_divided) as col8 ");
		sqljob.appendSQL(" from issue_main a, debt_main b, debit_ref e  ");
		sqljob.appendSQL(" where a.id = b.issue_id ");
		sqljob.appendSQL(" and b.debt_code = e.id ");
		sqljob.appendSQL(" and debt_type = 'A' ");
		sqljob.appendSQL(" and right('0000000'+convert(varchar,(convert(varchar,issue_date, 112)-19110000)),7) <= ? ");
		sqljob.appendSQL(" and right('0000000'+convert(varchar,(convert(varchar,due_date, 112)-19110000)),7) > ? ");
		sqljob.appendSQL(" ) table4 )");
		sqljob.appendSQL(" ear13A ) union ");
		sqljob.addParameter(oldDate2);
		sqljob.addParameter(oldDate2);
		sqljob.addParameter(lastDate.substring(0,5)+"01");
		sqljob.addParameter(lastDate);
		sqljob.addParameter(lastDate.substring(0,5)+"01");
		sqljob.addParameter(lastDate);
		sqljob.addParameter(lastDate);
		sqljob.addParameter(lastDate);
		//中長借	
		sqljob.appendSQL(" (select '中長期借款',col1,col2,col3,col4,col5,col6,col7,col8,null,'小計','2' ");  
		sqljob.appendSQL(" from ");
		sqljob.appendSQL(" (");
		sqljob.appendSQL(" select col1,col2,col3,col4,col5,col6,col7,col8  ");
		sqljob.appendSQL(" from "); 
		sqljob.appendSQL(" (");
		sqljob.appendSQL(" select sum(b.issue_amount) as col1,sum(b.o_divided - b.d_divided) as col2 ");
		sqljob.appendSQL(" from issue_main a, debt_main b, debit_ref e ");
		sqljob.appendSQL(" where a.id = b.issue_id ");
		sqljob.appendSQL(" and b.debt_code = e.id ");
		sqljob.appendSQL(" and debt_type = 'A' ");
		sqljob.appendSQL(" and right('0000000'+convert(varchar,(convert(varchar,issue_date, 112)-19110000)),7) <= ? ");
		sqljob.appendSQL(" and right('0000000'+convert(varchar,(convert(varchar,due_date, 112)-19110000)),7) > ? ");
		sqljob.appendSQL(" ) table1 ");
		sqljob.appendSQL(" ,");
		sqljob.appendSQL(" (");
		sqljob.appendSQL(" select sum(b.issue_amount) as col3,sum(b.o_divided - b.d_divided) as col4 ");
		sqljob.appendSQL(" from issue_main a, debt_main b, debit_ref e ");
		sqljob.appendSQL(" where a.id = b.issue_id ");
		sqljob.appendSQL(" and b.debt_code = e.id ");
		sqljob.appendSQL(" and debt_type = 'A' ");
		sqljob.appendSQL(" and right('0000000'+convert(varchar,(convert(varchar,due_date, 112)-19110000)),7) >= ? ");
		sqljob.appendSQL(" and right('0000000'+convert(varchar,(convert(varchar,due_date, 112)-19110000)),7) <= ? ");
		sqljob.appendSQL(" ) as table2");
		sqljob.appendSQL(" ,");
		sqljob.appendSQL(" (");
		sqljob.appendSQL(" select sum(b.issue_amount) as col5 ,sum(b.o_divided - b.d_divided) as col6 ");
		sqljob.appendSQL(" from issue_main a, debt_main b, debit_ref e ");
		sqljob.appendSQL(" where a.id = b.issue_id ");
		sqljob.appendSQL(" and b.debt_code = e.id ");
		sqljob.appendSQL(" and debt_type = 'A' ");
		sqljob.appendSQL(" and right('0000000'+convert(varchar,(convert(varchar,issue_date, 112)-19110000)),7) >= ? ");
		sqljob.appendSQL(" and right('0000000'+convert(varchar,(convert(varchar,issue_date, 112)-19110000)),7) <= ?  ");
		sqljob.appendSQL(" ) table3,");
		sqljob.appendSQL(" (");
		sqljob.appendSQL(" select sum(b.issue_amount) as col7 ,sum(b.o_divided - b.d_divided) as col8 ");
		sqljob.appendSQL(" from issue_main a, debt_main b, debit_ref e  ");
		sqljob.appendSQL(" where a.id = b.issue_id ");
		sqljob.appendSQL(" and b.debt_code = e.id ");
		sqljob.appendSQL(" and debt_type = 'A' ");
		sqljob.appendSQL(" and right('0000000'+convert(varchar,(convert(varchar,issue_date, 112)-19110000)),7) <= ? ");
		sqljob.appendSQL(" and right('0000000'+convert(varchar,(convert(varchar,due_date, 112)-19110000)),7) > ? ");
		sqljob.appendSQL(" ) table4 )");
		sqljob.appendSQL(" ear13B ) ");
		
		sqljob.addParameter(oldDate2);
		sqljob.addParameter(oldDate2);
		sqljob.addParameter(lastDate.substring(0,5)+"01");
		sqljob.addParameter(lastDate);
		sqljob.addParameter(lastDate.substring(0,5)+"01");
		sqljob.addParameter(lastDate);
		sqljob.addParameter(lastDate);
		sqljob.addParameter(lastDate);

		System.out.println(sqljob.toString());
		return sqljob;
	}
	public static String strPad(String s, int len, char ch, boolean left)
	{
	    StringBuffer strBuf = new StringBuffer();
	    if (s == null)
	    {
	        s = "";
	    }
	    if (!left)
	    {
	        strBuf.append(s);
	        while (strBuf.toString().getBytes().length < len)
	        {
	            strBuf.append(ch);
	        }
	    }
	    else
	    {
	        while (strBuf.toString().getBytes().length < len - s.length())
	        {
	            strBuf.append(ch);
	        }
	        strBuf.append(s);
	    }
	    return strBuf.toString();
	}
	
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
//		取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delTemp(form,usrId));
		//執行 insert
		run.update(connection,insTemp(form,usrId));
	}
}