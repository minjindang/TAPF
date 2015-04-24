package tw.gov.nta.account.action;

import gov.dnt.tame.common.ExcelReportRemainAction;

import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class EAMB0114N1 extends ExcelReportRemainAction {

	protected SQLJob delTemp(){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM EAMB01_RPT ");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	protected SQLJob selTemp(List<Integer> voucherIdList){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select b.id as voucher_id,");
		sqljob.appendSQL("b.voucher_date as voucher_date,");
		sqljob.appendSQL("b.voucher_no as voucher_no,");
		sqljob.appendSQL("a.issue_serial as issue_serial,");
		sqljob.appendSQL("case c.account_type when 'D' then f.account_name else '    '+f.account_name end As account_name,");
		sqljob.appendSQL("b.remark as remark,");
		sqljob.appendSQL("case c.account_type when 'D' then account_amount else 0 end As debit_amount,");
		sqljob.appendSQL("case c.account_type when 'C' then account_amount else 0 end As credit_amount");
		sqljob.appendSQL("from issue_main a,voucher_main b,voucher_det c,account_ref f");
		sqljob.appendSQL("where a.id = b.issue_id");
		sqljob.appendSQL("and b.id = c.voucher_id");
		sqljob.appendSQL("and c.account_code = f.id");
		if( !voucherIdList.isEmpty() )
			sqljob.appendSQL(" and b.id in ( ");

		for(Iterator it=voucherIdList.iterator();it.hasNext();)
		{
			Integer id = (Integer) it.next();
			if( it.hasNext() )
				sqljob.appendSQL(id+",");
			else
				sqljob.appendSQL(id.toString());
		}

		if( !voucherIdList.isEmpty() )
			sqljob.appendSQL(" ) ");
		sqljob.appendSQL("order by c.account_type desc");
		return sqljob;
	}
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		// TODO Auto-generated method stub
//		取得使用者帳號
		String usrId = request.getSession().getAttribute("ACCOUNT").toString();
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delTemp());
		List<Integer> voucherIdList = (List<Integer>) request.getAttribute("voucherIdList");
		List list = (List)run.query(selTemp(voucherIdList),new MapListHandler());
		for(Iterator it = list.iterator();it.hasNext();){
			Map map = (Map)it.next();
			run.update(connection,this.insTemp("eamb01_rpt", map));
		}

	}

}
