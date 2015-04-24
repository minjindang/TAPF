
package tw.gov.nta.account.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;


public class EARE0301 extends DefaultAction{
	
	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM EARE03_RPT ");
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
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL(" INSERT INTO EARE03_RPT (USRID,MOD_DATE,remark,debt_name,issue_date,due_date,average_rate,issue_amount,capital_amount,pay_amount,remain_capital,interest_amount, origin_interest_amount,total_amount ) ");
		//                                         1     2        3      4         5          6        7            8            9              10         11             12               13                     14
		sqljob.appendSQL(" select  ?,?,null,");//1,2,3
		sqljob.addParameter(usrId);
		sqljob.addParameter(new Timestamp(new Date().getTime())); 
		sqljob.appendSQL(" min(isnull(debt_short_name,debt_name)) + '(' + debit_name+')' as debt_name , ");//4--公債名稱
		sqljob.appendSQL(" (select issue_date from issue_main where id = a.source_issue_id) as issue_date,");//--5發行日期 
//		sqljob.appendSQL(" a.issue_date,");
//		sqljob.appendSQL(" min(due_date) due_date, ");//--6償還日期
		sqljob.appendSQL(" min(first_repay_date) due_date, ");//--6償還日期
		sqljob.appendSQL(" max(a.average_rate) average_rate , ");//7--票面利率
		sqljob.appendSQL(" sum(b.issue_amount)as issue_amount, ");//8--預計發行總額
		sqljob.appendSQL(" sum(b.issue_amount) as real_amount , ");//9--實售面額 
//		sqljob.appendSQL(" 0 as remain_amount, ");//10--償還額
		sqljob.appendSQL(" isnull((select sum(p.capital_amount) from payment_main p where p.issue_id = a.source_issue_id and p.repay_date <> p.plan_repay_date),0) as remain_amount,");
//		sqljob.appendSQL(" (sum(b.issue_amount) - 0) as close_amount, ");//11--結欠額
		sqljob.appendSQL(" (sum(b.issue_amount) - (isnull((select sum(p.capital_amount) from payment_main p where p.issue_id = a.source_issue_id and p.repay_date <> p.plan_repay_date),0))) as close_amount,");
		sqljob.appendSQL(" ( select sum( isnull(origin_interest_amount,0)) from debt_plan_det "+
						 "   where  debt_id in  (select id from debt_main g where g.debt_code = b.debt_code  and issue_id in  "+
                         " ( select id from issue_main where source_issue_id = a.source_issue_id  and right('0000000'+convert(varchar,(convert(varchar,issue_date, 112)-19110000)),7) <=? "+
  			             " and right('0000000'+convert(varchar,(convert(varchar,due_date, 112)-19110000)),7) > ? )  ) "+ 
                         " and right('0000000'+convert(varchar,(convert(varchar,repay_date, 112)-19110000)),7) >? "+
                         //delete_mark
                         " and isnull(delete_mark,'N') <> 'Y'" +
//                         " )as close_amount, ");//12--利息支出  ? X 3  = '0950331'
                         " ) as close_amount,");
		sqljob.appendSQL(" ( select sum(isnull(interest_amount,0) - isnull(origin_interest_amount,0)) from debt_plan_det " +
				         " where  debt_id in " +
				         "    (select id from debt_main g where g.debt_code = b.debt_code and issue_id in " +
				         "           ( select id from issue_main where source_issue_id = a.source_issue_id and right('0000000'+convert(varchar,(convert(varchar,issue_date, 112)-19110000)),7) <= ? " +
				         " 			  and right('0000000'+convert(varchar,(convert(varchar,due_date, 112)-19110000)),7) > ? ) ) " +
				         "       and right('0000000'+convert(varchar,(convert(varchar,repay_date, 112)-19110000)),7) > ?  " +
                         //delete_mark
				         " and isnull(delete_mark,'N') <> 'Y'"+
				         " )  - isnull((select sum(p.interest_amount) from payment_main p where p.issue_id = a.source_issue_id and p.repay_date <> p.plan_repay_date and p.capital_amount > 0),0) as payable_interest_amount, ");//13--應付利息    ? X 3  = '0950331'
//		sqljob.appendSQL(" ( select g.payable_interest_amount from debt_main g " +
//        				 " where g.debt_code = b.debt_code " +
//        				 "    and issue_id in ( select id from issue_main where source_issue_id = a.source_issue_id ) " +
//        				 "           and right('0000000'+convert(varchar,(convert(varchar,issue_date, 112)-19110000)),7) <= ? )" +
//        				 " 			 and right('0000000'+convert(varchar,(convert(varchar,due_date, 112)-19110000)),7) > ? ) " +
//        				 " )  payable_interest_amount, ");
		sqljob.appendSQL(" (  "+
				         " sum(b.issue_amount) - 0  "+//--結欠額
		                 " + "+
				         " ( select sum( isnull(origin_interest_amount,0)) from debt_plan_det "+
						 "   where  debt_id in  (select id from debt_main g where g.debt_code = b.debt_code  and issue_id in  "+
                         " ( select id from issue_main where source_issue_id = a.source_issue_id  and right('0000000'+convert(varchar,(convert(varchar,issue_date, 112)-19110000)),7) <=? "+
  			             " and right('0000000'+convert(varchar,(convert(varchar,due_date, 112)-19110000)),7) > ? )  ) "+ 
                         " and right('0000000'+convert(varchar,(convert(varchar,repay_date, 112)-19110000)),7) >? "+
                         //delete_mark
				         " and isnull(delete_mark,'N') <> 'Y'"+
                         " ) "+//--利息支出 
		                 " + "+
		                 " ( select sum(isnull(interest_amount,0) - isnull(origin_interest_amount,0)) from debt_plan_det " +
				         " where  debt_id in " +
				         "    (select id from debt_main g where g.debt_code = b.debt_code and issue_id in " +
				         "           ( select id from issue_main where source_issue_id = a.source_issue_id and right('0000000'+convert(varchar,(convert(varchar,issue_date, 112)-19110000)),7) <= ? " +
				         " 			  and right('0000000'+convert(varchar,(convert(varchar,due_date, 112)-19110000)),7) > ? ) ) " +
				         "       and right('0000000'+convert(varchar,(convert(varchar,repay_date, 112)-19110000)),7) > ?  " +
                         //delete_mark
				         " and isnull(delete_mark,'N') <> 'Y'"+
				         " ) "+//--應付利息  
//		                 " ) as total_amount ");//14 --結欠本金利息 = 結欠額+利息支出+應付利息  ? X 6  = '0950331'
				         " ) - (isnull((select sum(p.capital_amount)+(sum(p.interest_amount)) from payment_main p where p.issue_id = a.source_issue_id and p.repay_date <> p.plan_repay_date and p.capital_amount > 0),0)) as total_amount");
		sqljob.appendSQL(" from issue_main a, debt_main b, debit_ref e ");
		sqljob.appendSQL(" where a.id = b.issue_id ");
		sqljob.appendSQL(" and b.debt_code = e.id ");
		sqljob.appendSQL(" and debt_type = 'A' ");
		sqljob.appendSQL(" and right('0000000'+convert(varchar,(convert(varchar,issue_date, 112)-19110000)),7) <= ?  ");
		sqljob.appendSQL(" and right('0000000'+convert(varchar,(convert(varchar,due_date, 112)-19110000)),7) > ? ");
		sqljob.appendSQL(" group by a.account_year,a.source_issue_id,b.debt_code, e.DEBIT_NAME");
		//sqljob.appendSQL(" order by a.issue_date,b.debt_code");
		sqljob.appendSQL(" order by a.issue_date");
		sqljob.addParameter(myForm.getLastDate());
	    sqljob.addParameter(myForm.getLastDate());
	    sqljob.addParameter(myForm.getLastDate());
	    sqljob.addParameter(myForm.getLastDate());
	    sqljob.addParameter(myForm.getLastDate());//5
	    sqljob.addParameter(myForm.getLastDate());
	    sqljob.addParameter(myForm.getLastDate());
	    sqljob.addParameter(myForm.getLastDate());
	    sqljob.addParameter(myForm.getLastDate());
	    sqljob.addParameter(myForm.getLastDate());//10
	    sqljob.addParameter(myForm.getLastDate());
	    sqljob.addParameter(myForm.getLastDate());
	    sqljob.addParameter(myForm.getLastDate());
	    sqljob.addParameter(myForm.getLastDate());//14
	    System.out.println(sqljob.toString());
		return sqljob;
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