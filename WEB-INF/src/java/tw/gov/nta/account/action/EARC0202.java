package tw.gov.nta.account.action;

import gov.dnt.tame.common.ExcelReportBaseAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class EARC0202 extends ExcelReportBaseAction{

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM EARC02_RPT ");
		////sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}

	protected SQLJob SQL1(AccountQueryForm myForm,String debtTypeCode){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select account_ref.account_code,account_name,issue_serial,debt_name,");
		sqljob.appendSQL("voucher_date,");
		sqljob.appendSQL("voucher_no,");
		sqljob.appendSQL("sum(case voucher_det.account_type when 'D' then account_amount else 0 end) As debt_amount,");
		sqljob.appendSQL("sum(case voucher_det.account_type when 'C' then account_amount else 0 end) As credit_amount,");
		sqljob.appendSQL("sum(case voucher_det.account_type when 'D' then account_amount else 0 end) - sum(case voucher_det.account_type when 'C' then account_amount else 0 end ) as balance_amount ");
		sqljob.appendSQL("from issue_main,voucher_main,voucher_det,account_ref ");
		sqljob.appendSQL("where issue_main.id = voucher_main.issue_id ");
		sqljob.appendSQL("and voucher_main.id = voucher_det.voucher_id ");
		sqljob.appendSQL("and voucher_det.account_code = account_ref.id ");
		sqljob.appendSQL("and voucher_det.account_code = ? ");
		sqljob.appendSQL("and issue_main.id = ? ");
		sqljob.addParameter(myForm.getAccountId());
		sqljob.addParameter(myForm.getIssueId());
		if(myForm.getIssueKind()!=null&&!"3".equals(myForm.getIssueKind())){
			sqljob.appendSQL("and voucher_main.issue_kind = ? ");
			sqljob.addParameter(myForm.getIssueKind());
		}
		if("A".equals(debtTypeCode) && myForm.getDebtId() != 0 ){
			sqljob.appendSQL(" AND  exists(select 1 from debt_main  where id = "+myForm.getDebtId()+" and debt_code = voucher_main.debt_code and budget_code = voucher_main.budget_code) ");
		}
		sqljob.appendSQL("group by account_ref.account_code,account_name,issue_serial,debt_name,");
		sqljob.appendSQL("voucher_date,voucher_no order by voucher_date");

		System.out.println(sqljob.toString());
		return sqljob;
	}

	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		AccountQueryForm myForm = (AccountQueryForm)form;
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delTemp(form,usrId));
		//執行 insert
		String debtTypeCode  = (String)request.getSession().getAttribute("debtTypeCode");
		List queryList1 = (List) run.query(SQL1(myForm,debtTypeCode), new MapListHandler());
		Map tMap = null;
		BigDecimal balanceAmount = new BigDecimal(0);
		
		for(Iterator tIterator = queryList1.iterator(); tIterator.hasNext(); ){
			tMap = (Map) tIterator.next();
			tMap.putAll(getCommonMap(usrId));
			request.setAttribute("account_code",tMap.get("account_code"));
			request.setAttribute("issue_serial",tMap.get("issue_serial"));
			request.setAttribute("debt_name",tMap.get("debt_name"));
			request.setAttribute("account_name",tMap.get("account_name"));
			BigDecimal temp = (BigDecimal)tMap.get("balance_amount");
			if (temp !=null) {
				balanceAmount = balanceAmount.add(temp);
				
			}
			if(1 == balanceAmount.compareTo(new BigDecimal(0)))
			{
				tMap.put("account_type","借");	
			}
			else if (-1 == balanceAmount.compareTo(new BigDecimal(0)))
			{
				tMap.put("account_type","貸");	
			}	
			tMap.put("balance_amount",balanceAmount.abs());	
			run.update(connection,insTemp("EARC02_RPT",tMap));
		}
		
		
	} 
}
