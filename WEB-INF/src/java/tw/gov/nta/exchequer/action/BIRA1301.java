/*
 * 在 2006/2/27 建立
 *
 * TODO 如果要變更這個產生的檔案的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
package tw.gov.nta.exchequer.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.conversion.ConvertTBBCF01;
import tw.gov.nta.conversion.ConvertTBBCF02;
import tw.gov.nta.exchequer.form.Bira1301Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

/**
 * @author Jack Du
 *
 * TODO 如果要變更這個產生的類別註解的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
public class BIRA1301 extends DefaultAction{
	protected Date today=new Date();
	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM BIRA13_RPT ");
		////sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}

	protected SQLJob insTemp(ActionForm form,String usrId){
		Bira1301Form myForm = (Bira1301Form) form;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO BIRA13_RPT ");
		sqljob.appendSQL("select ?,?,null,bank_no,bank_name,bank_type,free_unit ");
		sqljob.appendSQL("from central_bank_ref ");
		sqljob.appendSQL("where 1=1 ");
		sqljob.addParameter(usrId);
		sqljob.addParameter(today);
		if(!"".equals(myForm.getBandNo())){
			sqljob.appendSQL("and bank_no = ? ");
			sqljob.addParameter(myForm.getBandNo());
		}
		if(!"".equals(myForm.getBankName())){
			sqljob.appendSQL("and bank_name like '%'+?+'%' ");
			sqljob.addParameter(myForm.getBankName());
		}
		sqljob.appendSQL("and bank_name not like '%教育%' and bank_name not like '%測試%'");
		sqljob.appendSQL("order by bank_no ");
//		sqljob.appendSQL("INSERT INTO BIRA13_RPT ");
//		sqljob.appendSQL("select ?,?,null,B1ACCT,B1NME1,B1PND,B1FLAG ");
//		sqljob.appendSQL("from TB0001 ");
//		sqljob.appendSQL("where 1=1 ");
//		if(!"".equals(myForm.getBandNo())){
//			sqljob.appendSQL("and B1ACCT = ? ");
//			sqljob.addParameter(myForm.getBandNo());
//		}
//		if(!"".equals(myForm.getBankName())){
//			sqljob.appendSQL("and B1NME1 like '%'+?+'%' ");
//			sqljob.addParameter(myForm.getBankName());
//		}
//		sqljob.appendSQL("order by B1ACCT ");
//		sqljob.addParameter(usrId);
//		sqljob.addParameter(today);
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
		ConvertTBBCF01 convert = new ConvertTBBCF01();
		convert.setConnection(connection);
		convert.initialize();
		convert.convert();
		//執行 insert
		run.update(connection,insTemp(form,usrId));
		
	}
}
