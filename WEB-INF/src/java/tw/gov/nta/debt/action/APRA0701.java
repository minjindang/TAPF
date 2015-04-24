/* APRA0701.java 報表
 程式目的：APRA07
 程式代號：APRA07
 程式日期：0950308
 程式作者：Eric.Chen
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
 --------------------------------------------------------
 */
package tw.gov.nta.debt.action;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.conversion.ConvertTPSBF8;
import tw.gov.nta.debt.form.Apra0701Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

public class APRA0701 extends DefaultAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM APRA07_RPT ");
		//sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	
//	protected SQLJob insTemp(ActionForm form,String usrId){
//		Apra0701Form apra0701form = (Apra0701Form) form;
//		SQLJob sqljob = new SQLJob();
//		sqljob.appendSQL("INSERT INTO APRA07_RPT ");
//		sqljob.appendSQL(" ( ");
//		sqljob.appendSQL(" USRID, MOD_DATE, REMARK, B.bank_id , bank_name ,ticket_count ,");
//		sqljob.appendSQL(" total_amount ");
//		sqljob.appendSQL(" ) ");	
//		sqljob.appendSQL("SELECT '"+usrId+"', CURRENT_TIMESTAMP , null , B.bank_id, ISNULL((SELECT bank_fname FROM bankf WHERE bank_code =B.BANK_ID),'') as bank_name , ");
//		sqljob.appendSQL(" sum(ISNULL(b.ticket_count,CAST(0 AS INT)) - ISNULL(b.duplicate_count,CAST(0 AS INT))) ,  ");
//		sqljob.appendSQL("(select  sum(m.interest_amount + m.capital_amount ) ");
//		sqljob.appendSQL(" from payment_main1 m,issue_main n  ");
//		sqljob.appendSQL(" where m.issue_id = n.id and m.bank_id = b.bank_id ");
//		sqljob.appendSQL(" and m.repay_date between ? and ? and n.debt_type = 'A') ");
//		sqljob.addParameter(apra0701form.getCloseSdate());
//		sqljob.addParameter(apra0701form.getCloseEdate());
//		sqljob.appendSQL(" FROM payment_main1 A, payment_ticket_det1 B, issue_main C");
//		sqljob.appendSQL(" WHERE B.payment_id=A.id and A.issue_id=C.id and C.debt_type='A' ");
//		if( null != apra0701form.getCloseSdate())
//		{
//			sqljob.appendSQL("and A.repay_date>= ? ");
//			sqljob.addParameter(apra0701form.getCloseSdate());
//		}
//		if( null != apra0701form.getCloseEdate())
//		{
//			sqljob.appendSQL("AND A.repay_date<= ? ");
//			sqljob.addParameter(apra0701form.getCloseEdate());
//		}
//		sqljob.appendSQL("group by B.bank_id");
//		sqljob.appendSQL("order by B.bank_id");
//		System.out.println(sqljob.toString());
//		return sqljob;
//	}
	protected SQLJob insTemp(ActionForm form,String usrId){
		Apra0701Form apra0701form = (Apra0701Form) form;
		String subsql = "(select distinct(bank_name) from bank_ref where bank_code in " +
							"(select subString(bankf.TpsBank,1,3) from bankf where bankf.bank_code = TPSBF8.bank_code))";
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO APRA07_RPT ");
		sqljob.appendSQL(" ( ");
		sqljob.appendSQL(" USRID, MOD_DATE, REMARK, B.bank_id , bank_name ,ticket_count ,");
		sqljob.appendSQL(" total_amount ");
		sqljob.appendSQL(" ) ");	
		sqljob.appendSQL("SELECT");         
		sqljob.appendSQL("'"+usrId+"', CURRENT_TIMESTAMP , null , TPSBF8.BANK_CODE,(select bank_fname from bankf where bankf.bank_code = TPSBF8.BANK_CODE), ");
//		sqljob.appendSQL("'"+usrId+"', CURRENT_TIMESTAMP , null , TPSBF8.BANK_CODE, "+subsql+", ");
		;
		sqljob.appendSQL("SUM(DET_PCS) AS Expr1,SUM(DET_AMT) AS Expr2");
		sqljob.appendSQL("FROM TPSBF8");
		sqljob.appendSQL("WHERE 1=1");
		int sMonth = apra0701form.getCloseSdate().getMonth() + 1;
		int eMonth = apra0701form.getCloseEdate().getMonth() + 1;
		int range = eMonth - sMonth;
//		if(range > 6 || range < 0)
//		{
//			sqljob.appendSQL("and ((TPSBF8.EVAL_DATE >='"+(apra0701form.getCloseSdate().getYear()+1900)+"/1/1'");
//			sqljob.appendSQL("AND TPSBF8.EVAL_DATE <= '"+(apra0701form.getCloseSdate().getYear()+1900)+"/6/30')");
//			sqljob.appendSQL("or (TPSBF8.EVAL_DATE >= '"+(apra0701form.getCloseEdate().getYear()+1900)+"/7/1'");
//			sqljob.appendSQL("AND TPSBF8.EVAL_DATE <= '"+(apra0701form.getCloseEdate().getYear()+1900)+"/12/31'))");
//
//		}	
//		else
//		{
			if( null != apra0701form.getCloseSdate())
			{
				sqljob.appendSQL("and TPSBF8.EVAL_DATE >= ? ");
				sqljob.addParameter(apra0701form.getCloseSdate());
			}
			if( null != apra0701form.getCloseEdate())
			{
				sqljob.appendSQL("AND TPSBF8.EVAL_DATE <= ? ");
				sqljob.addParameter(apra0701form.getCloseEdate());
			}
//		}	
		
		sqljob.appendSQL("GROUP BY  BANK_CODE");
		sqljob.appendSQL("ORDER BY BANK_CODE");
		System.out.println("APRA07 = "+sqljob.toString());
		return sqljob;
	}

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {

		//取得使用者帳號
		String usrId = request.getSession().getAttribute("ACCOUNT").toString();
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delTemp(form,usrId));
		//執行轉檔程式
		ConvertTPSBF8 convert = new ConvertTPSBF8();
		convert.initialize();
		convert.convert();
		//執行 insert
		run.update(connection,insTemp(form,usrId));
	}


}
