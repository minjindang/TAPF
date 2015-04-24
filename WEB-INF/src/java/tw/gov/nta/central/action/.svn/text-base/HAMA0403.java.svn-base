package tw.gov.nta.central.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.central.form.Hama0401Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class HAMA0403 extends DefaultAction{
	protected SQLJob delTemp(ActionForm form){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM HAMA04_RPT ");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	 protected SQLJob insTemp(ActionForm form){
		Hama0401Form myForm =(Hama0401Form)form;

		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO HAMA04_RPT ");
		sqljob.appendSQL(" ( ");
		sqljob.appendSQL(" UNIT_ID,CITY, REMITTER, COLLECT,");
		sqljob.appendSQL(" COLLECT_EMAIL, LIAISE,SEQ_NO");
		sqljob.appendSQL(" ) ");	
		sqljob.appendSQL(" Select UNIT_ID,UNIT_NAME, '=\"行名:' + isNull(SBANK1,'') +'\" & CHAR(10) & \"分支單位:' + isNull(SBRANCH1,'') + '\" & CHAR(10)& \"行號(七碼):'+isNull(SNO1,'')+'\"',");
		sqljob.appendSQL(" '=\"戶名:' + isNull(TBANK1,'') + '\" & CHAR(10) & \"帳號:'+ isNull(TACCT1,'') +'\"', ");
		sqljob.appendSQL("  TEMAIL ,");
		sqljob.appendSQL("'=\"承辦人姓名:'+ isNull(TNAME,'') + '\" & CHAR(10) & \"聯絡人電話:'  + isNull(TTEL,'') + '\" & CHAR(10) & \"傳真:' + isNull(TFAX,'') +'\"' , SEQ_NO");

		sqljob.appendSQL(" from Unit_info_main where 1 = 1 ");
		if(!"".equals(myForm.getQryUnitId()) && null != myForm.getQryUnitId())
		{
			sqljob.appendSQL( " and UNIT_ID = '" + myForm.getQryUnitId() + "'");
		}
		if(!"".equals(myForm.getQryUnit()) && null != myForm.getQryUnit())
		{
			sqljob.appendSQL( " and UNIT_ID like '" + myForm.getQryUnit() + "%'");
		}
		System.out.println(sqljob.toString());
		return sqljob;
	}

	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		SQLRunner run = new ConnectionSQLRunner(connection);
		run.update(connection,delTemp(form));
		run.update(connection,insTemp(form));
	}
}
