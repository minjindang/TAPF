/**
 * @author Andrew Sung
 * @create 2006/4/12
 */

package tw.gov.nta.surplusage.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.surplusage.form.Gara0901Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class GARA0901 extends DefaultAction
{
	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM GARA09_RPT ");
		//sqljob.appendSQL("WHERE USRID=?");
		//sqljob.addParameter( usrId );
		System.out.println("delTemp==>"+sqljob.toString());
		return sqljob;
	}
                    
	protected SQLJob insTemp(ActionForm form,String usrId){
		Gara0901Form myForm = (Gara0901Form)form;
		//BigDecimal unit = new BigDecimal(myForm.getAmountUnit());
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO GARA09_RPT");
		sqljob.appendSQL("(USRID, MOD_DATE,REMARK,account_year, ");
		sqljob.appendSQL("homeland_rate, America_rate, Japan_rate, Birtain_rate, ");
		sqljob.appendSQL("Franch_rate,Germery_rate , ");
		sqljob.appendSQL("Korea_rate,Singapore_rate ) ");
		sqljob.appendSQL("select ?,?,null,account_year, ");
		sqljob.addParameter(usrId);
		sqljob.addParameter(new Timestamp(new Date().getTime()));
		sqljob.appendSQL("isNull(max(Case A.nation_no when 'TW' then isNull(B.remain_pay_rate,0) else 0 end),0) as homeland_rate, ");
		sqljob.appendSQL("isNull(max(Case A.nation_no when 'US' then isNull(B.remain_pay_rate,0) else 0 end),0) as America_rate, ");
		sqljob.appendSQL("isNull(max(Case A.nation_no when 'JP' then isNull(B.remain_pay_rate,0) else 0 end),0) as Japan_rate, ");
		sqljob.appendSQL("isNull(max(Case A.nation_no when 'NK' then isNull(B.remain_pay_rate,0) else 0 end),0) as Birtain_rate, ");
		sqljob.appendSQL("isNull(max(Case A.nation_no when 'FR' then isNull(B.remain_pay_rate,0) else 0 end),0) as Franch_rate, ");
		sqljob.appendSQL("isNull(max(Case A.nation_no when 'GE' then isNull(B.remain_pay_rate,0) else 0 end),0) as Germery_rate, ");
		sqljob.appendSQL("isNull(max(Case A.nation_no when 'KR' then isNull(B.remain_pay_rate,0) else 0 end),0) as Korea_rate, ");
		sqljob.appendSQL("isNull(max(Case A.nation_no when 'SG' then isNull(B.remain_pay_rate,0) else 0 end),0) as Singapore_rate ");
		sqljob.appendSQL(" from Nation_ref A,Nation_Debit_main B ");
		sqljob.appendSQL("where A.id = B.Nation_Code ");
		if (!"".equals(myForm.getStartYear()))
			sqljob.appendSQL("and account_year >="+myForm.getStartYear() );
		if (!"".equals(myForm.getEndYear()))
			sqljob.appendSQL("and account_year <="+myForm.getEndYear() );	
		sqljob.appendSQL("group by account_year ");
		sqljob.appendSQL("order by account_year ");	
		System.out.println(sqljob);
		return sqljob;
	}
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delTemp(form,usrId));
		//執行 insert
		run.update(connection,insTemp(form,usrId));
	}
}