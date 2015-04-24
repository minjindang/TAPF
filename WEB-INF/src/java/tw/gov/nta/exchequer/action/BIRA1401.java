/*
 * 在 2006/2/27 建立
 *
 * TODO 如果要變更這個產生的檔案的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
package tw.gov.nta.exchequer.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.conversion.ConvertTBBCF02;
import tw.gov.nta.exchequer.form.Bira1401Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

/**
 * @author Jack Du
 *
 * TODO 如果要變更這個產生的類別註解的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
public class BIRA1401 extends DefaultAction{

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM BIRA14_RPT ");
		////sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}
/*
	     ,
	A.account_year        ,
	A.issue_date        ,
	A.bid_amount        ,
	A.bid_rate        ,
	A.reachbid_amount        ,
	A.gotbid_amount        ,
	A.totalbid_amount        ,
	A.hight_rate        ,
	A.low_rate        ,
	A.average_rate        ,
	A.sell_amount        ,
	A.nouse_amount        ,
	A.due_date        ,
	A.debt_name       
	 ,A.issue_days 
	 From Central_issue_main A
	and A.account_year between 年度(起) and 年度(迄)
*/
	protected SQLJob insTemp(ActionForm form,String usrId){
		Bira1401Form myForm = (Bira1401Form) form;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO BIRA14_RPT ");
		sqljob.appendSQL(" ( ");
		sqljob.appendSQL(" usrid, mod_date, remark, ");
		sqljob.appendSQL(" issue_serial, bond_type, issue_kind, account_year, " +
				"issue_date, issue_amount, bid_amount, " +
				"bid_rate, reachbid_amount, gotbid_amount, totalbid_amount, " +
				"hight_rate, low_rate, average_rate, sell_amount, " +
				"nouse_amount, due_date, debt_name, issue_days");
		sqljob.appendSQL(" ) ");
		sqljob.appendSQL("select ?,?,null,A.issue_serial,");
		sqljob.addParameter(usrId);
		sqljob.addParameter(new Timestamp(new Date().getTime()));
		sqljob.appendSQL("CASE A.bond_type WHEN '1' THEN 'A' WHEN '2' THEN 'B' ELSE '' END,");
		sqljob.appendSQL("A.issue_kind,"); 
		sqljob.appendSQL("A.account_year,");
		sqljob.appendSQL("A.issue_date,");
		sqljob.appendSQL("isNull(A.issue_amount,0) as issue_amount,");
		sqljob.appendSQL("isNull(A.bid_amount,0) as bid_amount,");
		sqljob.appendSQL("isNull(A.bid_rate,0) as bid_rate,");
		sqljob.appendSQL("isNull(A.reachbid_amount,0) as reachbid_amount,");
		sqljob.appendSQL("isNull(A.gotbid_amount,0) as gotbid_amount,");
		sqljob.appendSQL("isNull(A.totalbid_amount,0) as totalbid_amount,");
		sqljob.appendSQL("isNull(A.hight_rate,0) as hight_rate,");
		sqljob.appendSQL("isNull(A.low_rate,0) as low_rate,");
		sqljob.appendSQL("isNull(A.average_rate,0) as average_rate,");
		sqljob.appendSQL("isNull(A.sell_amount,0) as sell_amount,");
		sqljob.appendSQL("isNull(A.nouse_amount,0) as nouse_amount,");
		sqljob.appendSQL("A.due_date,");
		sqljob.appendSQL("A.debt_name,");
		sqljob.appendSQL("A.issue_days ");
		sqljob.appendSQL("From Central_issue_main A where 1=1");
		if (!"".equals(myForm.getAccountSYear()) ){
			sqljob.appendSQL("and A.account_year >= ? ");
			sqljob.addParameter(myForm.getAccountSYear());
		}
		if (!"".equals(myForm.getAccountEYear())){
			sqljob.appendSQL("and A.account_year <= ?  ");
			sqljob.addParameter(myForm.getAccountEYear());
		}
		if (0 != myForm.getIssueId()){
			sqljob.appendSQL("and A.issue_id = ? ");
			sqljob.addParameter(myForm.getIssueId());
		}
		sqljob.appendSQL("order by  A.issue_date,A.issue_serial");
		System.out.println(sqljob.toString());
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
		ConvertTBBCF02 convert = new ConvertTBBCF02();
		convert.setConnection(connection);
		convert.initialize();
		convert.convert();
		run.update(connection,insTemp(form,usrId));
	}
}
