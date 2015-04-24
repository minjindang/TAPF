/* HARB0801P.java
 * 在 2006/2/21 建立
 *
 * TODO 如果要變更這個產生的檔案的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
package tw.gov.nta.central.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.central.form.Harb0801Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

/**
 * @author EricChen
 *
 * TODO 如果要變更這個產生的類別註解的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */
public class HARC0801 extends DefaultAction  {
	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM HARB08_RPT ");
		////sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		//System.out.println(sqljob.toString());
		return sqljob;
	}

	protected SQLJob insTemp(ActionForm form,String usrId){
		Harb0801Form myForm = (Harb0801Form) form;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO HARB08_RPT ");
		sqljob.appendSQL("(usrid,mod_date,remark,all_year,all_month,unit_name,all_money,send_date,recv_date) ");
		sqljob.appendSQL("SELECT ?,?,null,");
		sqljob.addParameter(usrId);
		sqljob.addParameter(new Timestamp(new Date().getTime()));
		sqljob.appendSQL("Ua.ALL_YEAR , Ua.ALL_MONTH ,");
		sqljob.appendSQL("Ui.UNIT_NAME , Ua.ALL_MONEY , Ua.SEND_DATE ,");
		sqljob.appendSQL("Ua.RECV_DATE from Unit_allocate_main Ua ,");
		sqljob.appendSQL("Unit_info_main Ui where Ua.Unit_info_id = Ui.id and Ua.mon_kind ='2'");
		if(!"".equals(myForm.getAllYear()) && null != myForm.getAllYear())
		{
			sqljob.appendSQL(" and Ua.ALL_YEAR = '" + myForm.getAllYear() + "'");
		}
		if(!"".equals(myForm.getAllMonth()) && null != myForm.getAllMonth())
		{
			sqljob.appendSQL(" and Ua.ALL_MONTH = '" + myForm.getAllMonth() + "'");
		}
		if(!"".equals(myForm.getUnitId()) && null != myForm.getUnitId())
		{
			sqljob.appendSQL(" and Ui.UNIT_ID like " + myForm.getUnitId());
		}
		if(!"".equals(myForm.getUnitName()) && null != myForm.getUnitName())
		{
			sqljob.appendSQL(" and Ui.UNIT_NAME = '" + myForm.getUnitName() + "'");
		}
		if(null != myForm.getRecvSdate())
		{
			sqljob.appendSQL(" and Ua.RECV_DATE >= '" + DateUtil.date2Str(myForm.getRecvSdate()) + "'");
		}
		if(null != myForm.getRecvEdate())
		{
			sqljob.appendSQL(" and Ua.RECV_DATE <= '" + DateUtil.date2Str(myForm.getRecvEdate()) + "'");
		}
		sqljob.appendSQL("order by Ui.groupid,Ui.seq_no");
		System.out.println("HARB0801-SQL"+sqljob.toString());
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
