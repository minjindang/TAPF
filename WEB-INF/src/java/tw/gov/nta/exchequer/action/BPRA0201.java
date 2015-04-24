/**
 * @author Andrew Sung
 * @create 2006/4/11
 */

package tw.gov.nta.exchequer.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.conversion.ConvertTRBPAYP;
import tw.gov.nta.exchequer.form.Bpra0201Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class BPRA0201 extends DefaultAction
{
	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM BPRA02_RPT ");
		////sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
		
	}
	/*
	 * select 
(select bank_fname from bankF where bankF.bank_code = FIBTICKET.bank_code),
sum(pay_fund) from FIBTICKET
where 1<>1 
or (p_year = '94'  and( iss_period1 = '1' or  iss_period1 = '2'))
group by  bank_code
	 */
	
	protected SQLJob insTemp(ActionForm form,String usrId){
		Bpra0201Form myForm = (Bpra0201Form)form;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO BPRA02_RPT "); 
		sqljob.appendSQL(" ( ");
		sqljob.appendSQL(" USRID, Account_bank, Pay_amount ");
		sqljob.appendSQL(" ) ");
		sqljob.appendSQL(" SELECT '"+usrId+"',");
		sqljob.appendSQL("(select bank_fname from bankF where bankF.bank_code = FIBTICKET.bank_code),");
//		sqljob.appendSQL("sum(distinct(pay_fund)) from FIBTICKET ");
		sqljob.appendSQL("sum(pay_fund) from FIBTICKET ");
		if (!"".equals(myForm.getStatrDate()) && !"".equals(myForm.getEndDate())){
			sqljob.appendSQL("where 1<>1 ");
			String sDate = DateUtil.date2ROCStr(myForm.getStatrDate());
			String eDate = DateUtil.date2ROCStr(myForm.getEndDate());
			
			//起始年度
			int sYear = Integer.parseInt(sDate.substring(0,3));
			
			//結束年度
			int eYear = Integer.parseInt(eDate.substring(0,3));
			
			//計算年度
			int tYear = sYear;
			
			//增加條件  起始年度~結束年度  
			for (int i = 0 ; i <= eYear-sYear ; i++){
				//起始年度 = 結束年度 = 計算年度
				if( sYear==tYear && eYear==tYear )
					sqljob.appendSQL(getSearch(String.valueOf(tYear),sDate.substring(3,5),eDate.substring(3,5)));	
				//計算年度=起始年度
				else if (sYear == tYear)
					sqljob.appendSQL(getSearch(String.valueOf(tYear),sDate.substring(3,5),"12"));
				//計算年度=結束年度
				else if (eYear == tYear)
					sqljob.appendSQL(getSearch(String.valueOf(tYear),"1",eDate.substring(3,5)));
				else
					sqljob.appendSQL(getSearch(String.valueOf(tYear),"1","12"));
				tYear++;
			}
		}
		sqljob.appendSQL("group by  bank_code ");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	
	/**
	 *得到增加的條件
	 *傳入year=年度,sMonth=起始月份,eMonth=結束月份
	 *上半年iss_period1='1',下半年iss_period1='2'
	 *傳回sqlSub增加條件
	 */
	protected String getSearch(String year, String sMonth, String eMonth){
		String [] Month = {sMonth,eMonth}; 
		String [] getChoose = {"",""};
		for (int i = 0 ; i < Month.length ; i++){
			if (Integer.parseInt(Month[i]) < 7){
				getChoose[i] = "1";
			}else if (Integer.parseInt(Month[i]) >= 7){
				getChoose[i] = "2";
			}
		}
		String sqlSub = "or (p_year = '" + year + "' and (iss_period1 = '" + getChoose[0] + "' or iss_period1 = '" + getChoose[1] + "')) ";
		return sqlSub;
	}
	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception
	{
		String usrId = this.getUserId(request);
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
	}
}
