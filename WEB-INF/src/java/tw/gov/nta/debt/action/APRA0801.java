/* APRA0401.java 報表
 程式目的：APRA08
 程式代號：APRA08
 程式日期：0950308
 程式作者：Eric.Chen
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
 --------------------------------------------------------
 */
package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.conversion.ConvertTRBPAYP;
import tw.gov.nta.debt.form.Apra0801Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class APRA0801 extends DefaultAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM APRA08_RPT ");
		//sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}

	
	/*
	 一.APRA08
   1.條件：年度
           截止日期:6/30或12/31
           
   2.SQL:
   
     select (select bank_aname from bankf where bank_code=paida.bank_code),sum(i_amt)
       from paida
      where 1=1
        and p_year=93--輸入年度
        and p_period=2(1:上半年;2:下半年)
      group by bank_code order by bank_code
	 */
	
	
	
	
	protected SQLJob insTemp(ActionForm form,String usrId){
		Apra0801Form apra0801form = (Apra0801Form) form;
		String subsql = "(select distinct(bank_name) from bank_ref where bank_code in " +
					"(select subString(bankf.TpsBank,1,3) from bankf where bankf.bank_code = paida.bank_code))";

		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO APRA08_RPT ");
		sqljob.appendSQL(" ( ");
		sqljob.appendSQL(" USRID, MOD_DATE, REMARK, bank_id , bank_name ,total_amount ");
		sqljob.appendSQL(" ) ");	
		sqljob.appendSQL("SELECT '"+usrId+"', CURRENT_TIMESTAMP , null , bank_code ,  ");
		sqljob.appendSQL(" isnull((select bank_fname from bankf where bank_code=paida.bank_code),'') , ");
//		sqljob.appendSQL(" "+subsql+", ");
		sqljob.appendSQL(" isnull(sum(i_amt),0) ");
		sqljob.appendSQL(" from paida ");
		sqljob.appendSQL(" WHERE 1=1 ");
		if( null != apra0801form.getCloseSdate() && !"".equals(apra0801form.getCloseSdate()))
		{
			sqljob.appendSQL(" AND p_year >= ? ");
			sqljob.addParameter(DateUtil.date2ROCStr(apra0801form.getCloseSdate()).substring(0,3));
		}
		
		if( null != apra0801form.getCloseEdate() && !"".equals(apra0801form.getCloseEdate()))
		{
			sqljob.appendSQL(" AND p_year <= ? ");
			sqljob.addParameter(DateUtil.date2ROCStr(apra0801form.getCloseEdate()).substring(0,3));
		}
		int sMonth = apra0801form.getCloseSdate().getMonth() + 1;
		int eMonth = apra0801form.getCloseEdate().getMonth() + 1;
		int range = eMonth - sMonth;
		
		if(range > 6 || range < 0)
		{
			sqljob.appendSQL("and( p_period = 1 or p_period = 2) ");
			apra0801form.setType("中華民國 " + Integer.parseInt(DateUtil.date2ROCStr(apra0801form.getCloseSdate()).substring(0,3)) + " 年 1 月 1 日 至 "+ Integer.parseInt(DateUtil.date2ROCStr(apra0801form.getCloseEdate()).substring(0,3)) +" 年 12 月 31 日" );
		}	
		else
		{
			if(sMonth<=6)
			{
				sqljob.appendSQL("and p_period = 1 ");
				apra0801form.setType("中華民國 " + Integer.parseInt(DateUtil.date2ROCStr(apra0801form.getCloseSdate()).substring(0,3)) + " 年 1 月 1 日 至 " + Integer.parseInt(DateUtil.date2ROCStr(apra0801form.getCloseEdate()).substring(0,3)) +" 年 6 月 30 日" );
			}
			else
			{
				sqljob.appendSQL("and p_period = 2 ");
				apra0801form.setType("中華民國 " + Integer.parseInt(DateUtil.date2ROCStr(apra0801form.getCloseSdate()).substring(0,3)) + " 年 7 月 1 日 至 " + Integer.parseInt(DateUtil.date2ROCStr(apra0801form.getCloseEdate()).substring(0,3)) +" 年 12 月 31 日" );
			}
		}	
		sqljob.appendSQL("group by bank_code order by bank_code");
		System.out.println(sqljob.toString());
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
		ConvertTRBPAYP convert = new ConvertTRBPAYP(connection);
		convert.initialize();
		convert.convert();
		//執行 insert
		run.update(connection,insTemp(form,usrId));
		Apra0801Form myform = (Apra0801Form)form;
		request.setAttribute("Type",myform.getType());
	}


}
