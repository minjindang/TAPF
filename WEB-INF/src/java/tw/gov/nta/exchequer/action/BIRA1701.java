/*
 * 在 2006/2/27 建立
 *
 * TODO 如果要變更這個產生的檔案的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
package tw.gov.nta.exchequer.action;

import gov.dnt.tame.common.DefaultAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.conversion.ConvertTBBCF05;
import tw.gov.nta.exchequer.form.Bira1701Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

/**
 * @author Jack Du
 *
 * TODO 如果要變更這個產生的類別註解的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
public class BIRA1701 extends DefaultAction{
	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM BIRA17_RPT ");
		//sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}

	protected SQLJob insTemp(ActionForm form,String usrId){
		Bira1701Form myForm = (Bira1701Form) form;
		BigDecimal unit = new BigDecimal(myForm.getAmountUnit());
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO BIRA17_RPT ");
		sqljob.appendSQL("select ?,?,null,file_no,");
		sqljob.appendSQL("B.issue_serial,");
		sqljob.appendSQL("C.bank_name,");
		sqljob.appendSQL("isNull(B.issue_price,0)/? as issue_price,");
		sqljob.appendSQL("isNull(B.sell_rate,0)/100 as sell_rate,");
		sqljob.appendSQL("isNull(B.sell_amount,0)/? as sell_amount,");
		sqljob.appendSQL("isNull(B.free_amount,0)/? as free_amount ");
		sqljob.appendSQL("from issue_main A,central_debt_det B,central_bank_ref  C ");
		sqljob.appendSQL("where B.issue_id = A.id and C.id = B.unit_code ");
		sqljob.addParameter(usrId);
		sqljob.addParameter(new Timestamp(new Date().getTime()));
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		
		if (!"".equals(myForm.getAccountSYear()) ){
			sqljob.appendSQL("and A.account_year >= ? ");
			sqljob.addParameter(myForm.getAccountSYear());
		}
		if (!"".equals(myForm.getAccountEYear())){
			sqljob.appendSQL("and A.account_year <= ?  ");
			sqljob.addParameter(myForm.getAccountEYear());
		}
		if (0 != myForm.getIssueId()){
			sqljob.appendSQL("and A.id = ? ");
			sqljob.addParameter(myForm.getIssueId());
		}
		sqljob.appendSQL("order by B.issue_serial ");
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
		
		ConvertTBBCF05 convert = new ConvertTBBCF05();
		convert.setConnection(connection);
		convert.initialize();
		convert.convert();
		run.update(connection,insTemp(form,usrId));
	}
}
