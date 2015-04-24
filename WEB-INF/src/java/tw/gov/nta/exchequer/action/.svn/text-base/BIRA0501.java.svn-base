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

import tw.gov.nta.exchequer.form.Bira0501Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

/**
 * @author Jack Du
 *
 * TODO 如果要變更這個產生的類別註解的範本，請移至
 * 視窗 - 喜好設定 - Java - 程式碼樣式 - 程式碼範本
 */

/*
 * 
 * 
 * select issue_serial --期別
,average_rate  --年息
,datediff(dd,issue_date,due_date) as date_period --天期
,right( '0000000' +ltrim(str(convert(varchar, issue_date , 112)-19110000)),7) as issue_date --發行日
,right( '0000000' +ltrim(str(convert(varchar, due_date , 112)-19110000)),7) as due_date --到期日
,issue_amount , --發行額
    sum(case B.ticket_amount when 10000000 then B.ticket_count else 0 end) as ticket_1000,
    sum(case B.ticket_amount when 1000000 then B.ticket_count else 0 end) as ticket_100,
sum(case B.ticket_amount when 500000 then B.ticket_count else 0 end) as ticket_50,
    sum(case B.ticket_amount when 100000 then B.ticket_count else 0 end) as ticket_10,
    sum(case B.ticket_amount when 50000 then B.ticket_count else 0 end) as ticket_5,
    sum(case B.ticket_amount when 10000 then B.ticket_count else 0 end) as ticket_1
  from issue_main A left outer join Issue_ticket_det B on  B.issue_id = A.id
  where  A.debt_type = 'B'
  and right( '0000000' +ltrim(str(convert(varchar, issue_date , 112)-19110000)),7)  between '0990101' and '0991231'
group by  bond_type,issue_serial,issue_date,due_date,average_rate,issue_amount

 */
public class BIRA0501 extends DefaultAction{

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM BIRA05_RPT ");
		////sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		//System.out.println(sqljob.toString());
		return sqljob;
	}

	protected SQLJob insTemp(ActionForm form,String usrId){
		Bira0501Form myForm = (Bira0501Form) form;
		Date today = new Date();
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO BIRA05_RPT ");
		sqljob.appendSQL("SELECT ?,?,null,");
		sqljob.appendSQL("issue_serial,average_rate,");
		sqljob.appendSQL("datediff(dd,issue_date,due_date) as date_period,");
		sqljob.appendSQL("issue_date,due_date,isNull(issue_amount,0) as issue_amount,");
		sqljob.appendSQL("isNull(sum(case B.ticket_amount when 10000000 then B.ticket_count else 0 end),0) as ticket_1000,");
		sqljob.appendSQL("isNull(sum(case B.ticket_amount when 1000000 then B.ticket_count else 0 end),0) as ticket_100,");
		sqljob.appendSQL("isNull(sum(case B.ticket_amount when 500000 then B.ticket_count else 0 end),0) as ticket_50,");
		sqljob.appendSQL("isNull(sum(case B.ticket_amount when 100000 then B.ticket_count else 0 end),0) as ticket_10,");
		sqljob.appendSQL("isNull(sum(case B.ticket_amount when 50000 then B.ticket_count else 0 end),0) as ticket_5,");
		sqljob.appendSQL("isNull(sum(case B.ticket_amount when 10000 then B.ticket_count else 0 end),0) as ticket_1 ");
		sqljob.appendSQL("from issue_main A left outer join Issue_ticket_det B on  B.issue_id = A.id ");
		sqljob.appendSQL("where A.debt_type = 'B' ");
		sqljob.addParameter(usrId);
		sqljob.addParameter(today);
		if (null != myForm.getIssueSdate() && null != myForm.getIssueEdate()){
			sqljob.appendSQL("and issue_date between ? and ? ");
			sqljob.addParameter(myForm.getIssueSdate());
			sqljob.addParameter(myForm.getIssueEdate());
		}
		if (!"".equals(myForm.getBudgetCode())){
			sqljob.appendSQL("and A.budget_code = ? ");
			sqljob.addParameter(myForm.getBudgetCode());
		}
		if (!"".equals(myForm.getDebtCode())){
			sqljob.appendSQL("and A.debt_code = ? ");
			sqljob.addParameter(myForm.getDebtCode());
		}
		sqljob.appendSQL("group by  bond_type,issue_serial,issue_date,due_date,average_rate,issue_amount");
		sqljob.appendSQL("order by  issue_serial");
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
		run.update(connection,insTemp(form,usrId));
	}
}
