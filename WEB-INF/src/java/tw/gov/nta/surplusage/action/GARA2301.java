/* GARA2301.java ����
 �{���ت��GGARA2301
 �{���N���GGARA2301
 �{������G0950602
 �{���@�̡GAvery Yeh
 --------------------------------------------------------
 �ק�@�̡@�@�ק����@�@�@�ק�ت�
 --------------------------------------------------------
 */
package tw.gov.nta.surplusage.action;

import gov.dnt.tame.common.ExcelReportBaseAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.surplusage.form.Gara2301Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class GARA2301 extends ExcelReportBaseAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM GARA23_RPT ");
		////sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	protected SQLJob SQL1(Gara2301Form myForm){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("Select account_year ");
		sqljob.appendSQL(",sum(isnull(budget_Uamount1,0))+sum(isnull(budget_Uamount2,0))+sum(isnull(budget_Bamount1,0))+sum(isnull(budget_Bamount2,0)) as p_amount");
		sqljob.appendSQL("from User_Statistics_main ");
		sqljob.appendSQL("where 1=1 ");
		if (!"".equals(myForm.getBudgetCode())){
			sqljob.appendSQL("and budget_code = ? ");
			sqljob.addParameter(myForm.getBudgetCode());
		}
		if (!"".equals(myForm.getDebtCode())){
			sqljob.appendSQL("and debt_code = ? ");
			sqljob.addParameter(myForm.getDebtCode());
		}
		sqljob.appendSQL("group by account_year ");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	protected SQLJob SQL2(String accountYear , Gara2301Form myForm){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("Select  ");
		sqljob.appendSQL("isnull(sum(isnull(issue_amount,0)),0) as r_amount ");
		sqljob.appendSQL("from debt_main ");
		sqljob.appendSQL("where 1=1 ");
		if (!"".equals(accountYear)){
			sqljob.appendSQL("and (select account_year from issue_main where id = issue_id) = ? ");
			sqljob.addParameter(accountYear);
		}
		if (!"".equals(myForm.getBudgetCode())){
			sqljob.appendSQL("and budget_code = ? ");
			sqljob.addParameter(myForm.getBudgetCode());
		}
		if (!"".equals(myForm.getDebtCode())){
			sqljob.appendSQL("and debt_code = ? ");
			sqljob.addParameter(myForm.getDebtCode());
		}
		System.out.println(sqljob.toString());
		return sqljob;
	}

	
	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception {
		Gara2301Form myForm = (Gara2301Form) form;
		
		//���o�ϥΪ̱b��
		String usrId = this.getUserId(request);
		//���oSQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//���� delete 
		run.update(connection,delTemp(form,usrId));
		//���� insert
		List queryList1 = (List) run.query(SQL1(myForm), new MapListHandler());
		BigDecimal amountUnit = new BigDecimal(0);
		if (myForm.getAmountUnit().equals("0"))
			amountUnit = new BigDecimal(1);
		else 
			amountUnit = new BigDecimal(myForm.getAmountUnit());
		for(Iterator tIterator = queryList1.iterator(); tIterator.hasNext(); ){
			Map tMap = (Map) tIterator.next();
			tMap.putAll(getCommonMap(usrId));
			//List queryList2 = (List) run.query(SQL2(tMap.get("account_year").toString(),myForm), new MapListHandler());
			BigDecimal rAmount = (BigDecimal) ((Map)((List) run.query(SQL2(tMap.get("account_year").toString(),myForm), new MapListHandler())).get(0)).get("r_amount");
			tMap.put("account_year",String.valueOf(Integer.parseInt((String)tMap.get("account_year"))));
			tMap.put("r_amount",rAmount);
			if (((BigDecimal)tMap.get("p_amount")).intValue() != 0 )
				tMap.put("range",((BigDecimal)tMap.get("r_amount")).divide((BigDecimal)tMap.get("p_amount"),4,5));
			else
				tMap.put("range",new BigDecimal(0));
			tMap.put("r_amount",((BigDecimal)tMap.get("r_amount")).divide(amountUnit, 0, BigDecimal.ROUND_HALF_UP));
			tMap.put("p_amount",((BigDecimal)tMap.get("p_amount")).divide(amountUnit, 0, BigDecimal.ROUND_HALF_UP));
			run.update(connection,insTemp("GARA23_RPT",tMap));
		}

	}
}
