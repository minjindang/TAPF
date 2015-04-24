/* APRA0601.java ����
 �{���ت��GAPRA06
 �{���N���GAPRA06
 �{������G0950308
 �{���@�̡GEric.Chen
 --------------------------------------------------------
 �ק�@�̡@�@�ק����@�@�@�ק�ت�
 --------------------------------------------------------
 */
package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Cpra0501Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class CPRA0501 extends DefaultAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM CPRA05_RPT ");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	protected SQLJob insTemp(ActionForm form,String usrId){
		Cpra0501Form myForm = (Cpra0501Form)form;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO CPRA05_RPT ");
		sqljob.appendSQL("( ");
		sqljob.appendSQL("USRID, MOD_DATE, REMARK, repay_date , capital_amount , charge_amount ,");
		sqljob.appendSQL(" transfer_capital_amount , transfer_interest_amount , ought_interest_amount ,");
		sqljob.appendSQL(" interest_amount, total_capital_amount , total_interest_amount ");
		sqljob.appendSQL(")");
		sqljob.appendSQL("select ? , CURRENT_TIMESTAMP, null , repay_date , capital_amount , charge_amount, ");
		sqljob.appendSQL("transfer_capital_amount/100,transfer_interest_amount ,");
		sqljob.appendSQL("(charge_amount * transfer_capital_amount/100 * transfer_interest_amount /365) as ought_interest_amount,");
		sqljob.appendSQL("interest_amount ,");
		sqljob.appendSQL("(select sum(capital_amount) from debt_plan_det where issue_id = ? and repay_date <= D.repay_date),");
		sqljob.appendSQL("(select sum(interest_amount) from debt_plan_det where issue_id = ? and repay_date <= D.repay_date)");
		sqljob.appendSQL("from debt_plan_det D where issue_id = ? ");
		sqljob.addParameter(usrId);
		sqljob.addParameter(myForm.getId());
		sqljob.addParameter(myForm.getId());
		sqljob.addParameter(myForm.getId());
		if(myForm.getStartDate()!=null){
			sqljob.appendSQL("and repay_date >= ?");
			sqljob.addParameter(myForm.getStartDate());
		}
		if(myForm.getEndDate()!=null){
			sqljob.appendSQL("and repay_date <= ?");
			sqljob.addParameter(myForm.getEndDate());
		}
		sqljob.appendSQL("order by repay_date");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		//���o�ϥΪ̱b��
		String usrId = getUserId(request);
		//���oSQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//���� delete 
		run.update(connection,delTemp(form,usrId));
		//���� insert
		run.update(connection,insTemp(form,usrId));

	}
}
