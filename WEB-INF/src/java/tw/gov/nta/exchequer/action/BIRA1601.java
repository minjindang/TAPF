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

import tw.gov.nta.conversion.ConvertTBBCF04;
import tw.gov.nta.exchequer.form.Bira1601Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

/**
 * @author Jack Du
 *
 * TODO 如果要變更這個產生的類別註解的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
public class BIRA1601 extends DefaultAction{

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM BIRA16_RPT ");
		////sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}

	protected SQLJob insTemp(ActionForm form,String usrId){
		Bira1601Form myForm = (Bira1601Form) form;
		BigDecimal unit = new BigDecimal(myForm.getAmountUnit());
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO BIRA16_RPT ");
		sqljob.appendSQL(" ( ");
		sqljob.appendSQL(" USRID, MOD_DATE, REMARK,file_no");
		sqljob.appendSQL(" ,issue_serial, bond_type,back_type,account_year,issue_date,issue_amount,bid_amount,bid_rate");
		sqljob.appendSQL(" ,gotbid_amount, orgissue_amount,interest_amount,hight_rate,low_rate,average_rate,due_date,issue_days");
		sqljob.appendSQL(" ,debt_name, ahead_date");
		sqljob.appendSQL(" ) ");
		sqljob.appendSQL("Select ?,?,null,file_no");//檔案代號
		sqljob.appendSQL(",issue_serial");//買回期別
		sqljob.appendSQL(",(select code_name from code_det where kind_id = 17 and code_no = bond_type)");//買回種類
		sqljob.appendSQL(",'' as back_type"); //買回票卷型態
		sqljob.appendSQL(",account_year");//發行年度
		sqljob.appendSQL(",issue_date");//發行日期
		sqljob.appendSQL(",issue_amount/? as issue_amount");//發行金額
		sqljob.appendSQL(",bid_amount/? as bid_amount");//報價總面額
		sqljob.appendSQL(",bid_rate/100 ");//底價利率
		sqljob.appendSQL(",gotbid_amount/? as gotbid_amount");//買回總面額
		sqljob.appendSQL(",orgissue_amount/? as orgissue_amount");//原始成本
		sqljob.appendSQL(",interest_amount/? as interest_amount");//利息總額
		sqljob.appendSQL(",hight_rate/100 ");//最高買回利率
		sqljob.appendSQL(",low_rate/100 ");//最低買回利率
		sqljob.appendSQL(",average_rate/100 ");//加權平均利率
		sqljob.appendSQL(",due_date");//到期日
		sqljob.appendSQL(",issue_days");//發行天期
		sqljob.appendSQL(",debt_name");//國庫卷名稱
		sqljob.appendSQL(",ahead_date");//買回日期   
		sqljob.appendSQL("From aheadpay_main");
		sqljob.addParameter(usrId);
		sqljob.addParameter(new Timestamp(new Date().getTime()));
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		if (myForm.getIssueSdate() != null && myForm.getIssueEdate() != null){
			sqljob.appendSQL("where issue_date between ? and ? ");
			sqljob.addParameter(myForm.getIssueSdate());
			sqljob.addParameter(myForm.getIssueEdate());
		}
		sqljob.appendSQL("order by issue_serial ASC");
		System.out.println("SQL1::"+sqljob.toString());
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
		ConvertTBBCF04 convert = new ConvertTBBCF04();
		convert.setConnection(connection);
		convert.initialize();
		convert.convert();
	}
}
