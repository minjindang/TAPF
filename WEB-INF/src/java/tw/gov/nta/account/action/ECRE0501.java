package tw.gov.nta.account.action;

import gov.dnt.tame.common.ExcelReportBaseAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;
import org.hibernate.Query;
import org.hibernate.Session;

import tw.gov.nta.account.form.AccountQueryForm;
import tw.gov.nta.sql.BudgetRef;
import tw.gov.nta.sql.dao.BudgetRefDAO;
import tw.gov.nta.sql.debt.dao.DebtMainDAO;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class ECRE0501 extends ExcelReportBaseAction{

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM ECRE05_RPT ");
		////sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	
	protected SQLJob SQL1(AccountQueryForm myForm){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select a.id as issue_id,a.debt_name, ");
		sqljob.appendSQL("min(e.bank_name)+case when count(distinct b.bank_id) > 1 then '��'+ cast(count(distinct b.bank_id) as varchar)+'�a�Ȧ�' else '' end as bank_name,");
		sqljob.appendSQL("a.issue_date as issue_date ,");
		sqljob.appendSQL("a.due_date as due_date ,");
		sqljob.appendSQL("round(cast((select sum(issue_amount) from debt_main where issue_id = a.id and debt_code  <> 35)as decimal(20,4)),0) as issue_amount,");
		sqljob.appendSQL("round(cast((select sum(issue_amount) from debt_main where issue_id = a.id and debt_code  <> 35)as decimal(20,4)),0) as real_amoun,");
		sqljob.appendSQL("round(cast(sum(c.capital_amount)as decimal(20,4)),0) AS pay_capital, ");
		sqljob.appendSQL("round(cast((select sum(issue_amount) from debt_main where issue_id = a.id and debt_code  <> 35) - sum(isnull(c.capital_amount,0))as decimal(20,4)),0) AS remain_capital,");
		sqljob.appendSQL("round(cast(sum(c.interest_amount)as decimal(20,4)),0) AS pay_interest");
//		sqljob.appendSQL(",round(cast((select sum(interest_amount) from debt_plan_det where  exists(select 1 from debt_main where id = debt_id and issue_id = a.id and debt_code <>35) and  delete_mark = 'N' and repay_date > '"+myForm.getSQLLastDate()+"' " +
//				" )as decimal(20,4)),0) as remain_interest");
//		sqljob.appendSQL(",round(cast((select sum(issue_amount) from debt_main where issue_id = a.id and debt_code  <> 35) - sum(isnull(c.capital_amount,0)) + (select sum(interest_amount) from debt_plan_det where  exists(select 1 from debt_main where id = debt_id and issue_id = a.id and debt_code <>35) and  delete_mark = 'N' and repay_date > '"+myForm.getSQLLastDate()+
//				"' )as decimal(20,4)),0) as total_remain "); 
		sqljob.appendSQL("from issue_main a,debt_main b,payment_main c,bank_ref e,debt_plan_det f");
		sqljob.appendSQL("where a.id = b.issue_id ");
		sqljob.appendSQL("and f.id *= c.plan_id");
		sqljob.appendSQL("and b.id = f.debt_id ");
		sqljob.appendSQL("and b.bank_id = e.id");
		sqljob.appendSQL("and debt_type = 'C' ");
		sqljob.appendSQL("and b.accrue = 'Y'");
		sqljob.appendSQL("and b.debt_code <> 35 and ISNUMERIC(a.serial_no) = 1 " );
		sqljob.appendSQL("and f.delete_mark = 'N'");
		sqljob.appendSQL("and a.ISSUE_DATE <= '"+myForm.getSQLLastDate()+"' ");
		sqljob.appendSQL("and c.repay_date <= '"+myForm.getSQLLastDate()+"' ");
		if("Y".equals(myForm.getIsClose())) {
			sqljob.appendSQL("and (a.issue_amount > a.capital_amount or a.capital_amount is null) ");
		}
		sqljob.appendSQL("group by a.debt_name,a.issue_date, a.due_date,a.id,a.account_year,a.serial_no");
//		sqljob.appendSQL("order by a.issue_serial");
		sqljob.appendSQL("order by a.account_year,a.serial_no");
		
		System.out.println(sqljob.toString());
		return sqljob;		
	}

	@SuppressWarnings("unchecked")
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		AccountQueryForm myForm = (AccountQueryForm)form;
		//���o�ϥΪ̱b��
		String usrId = this.getUserId(request);
		//���oSQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//���� delete 
		run.update(connection,delTemp(form,usrId));
		//���� insert
		
		//��ECRE0801�������Ӻ�w���Q��
		ECRE0801 ecre0801 = new ECRE0801();
		List queryList1 = (List) run.query(SQL1(myForm), new MapListHandler());
		Map tMap = null;
		Session session = DebtMainDAO.getInstance().getSession();
		String queryString = "select debt.budgetCode,sum(debt.issueAmount) from DebtMain debt " +
				"where debt.issue.id = :issueId and debt.budgetCode <> 35 and debt.budgetCode <> 5 " +
				"group by debt.budgetCode";
		Query query = session.createQuery(queryString);
		DecimalFormat df = new DecimalFormat("#,###");
		for(Iterator tIterator = queryList1.iterator(); tIterator.hasNext(); ){
			tMap = (Map) tIterator.next();
			//��J�Ƶ�
			int issueId = (Integer)tMap.get("issue_id");
			query.setInteger("issueId",issueId);
			List debtList = query.list();
			StringBuffer remark = new StringBuffer();
			for(Iterator iterator = debtList.iterator();iterator.hasNext();) {
				Object[] result = (Object[])iterator.next();
				int budgetCode = (Integer)result[0];
				
				
				String budgetName = ((BudgetRef)BudgetRefDAO.getInstance().get(budgetCode,session)).getBudgetName().trim();
//				if(debtList.size()==1) {
//					remark.append(budgetName);
//				}else {
					System.out.println(issueId);
					if(issueId == 4204){//2012/1/18 �|�p�ǪL�����p�j���Ƶ��ƭȼg�� Powen.Hsueh
						//remark.append("�`�w��o��84�� �S�O�w��416��");
						if("�`�w��".equals(budgetName))
							remark.append(budgetName+"�o��8,400,000,000��");
						else
							remark.append(budgetName+"�o��41,600,000,000��");	
//						2012/2/16 �|�p�Ǧ��p�j��T�ӽг�A�n�N�U�C�Ƶ��g�� chris Wu
					}else if(issueId == 4199){//100-01
						remark.append("�S�O�w��");
					}else if(issueId == 4205){//100-03
						if("�`�w��".equals(budgetName))
							remark.append(budgetName+"�o��1,700,000,000��");
						else
							remark.append(budgetName+"�o��28,300,000,000��");
						//20120301 ���p�j�S���S���n��F~~~Chris Wu
//					}else if(issueId == 4276){//101-00
//						remark.append("�S�O�w��");
//					}else if(issueId == 4282){//101-03
//						remark.append("�`�w��o��7,000,000,000���S�O�w��o��5,000,000,000��");					
					}else{
						if(debtList.size()==1) {
							remark.append(budgetName);
						}else{
							BigDecimal issueAmount = (BigDecimal)result[1];
							remark.append(budgetName+"�o��"+df.format(issueAmount)+"��");			
						}
					}
//				}
			}
			tMap.remove("issue_id");
			tMap.putAll(getCommonMap(usrId));
			tMap.put("remark",remark.toString());
					
			BigDecimal remainCapitalAmount = (BigDecimal)tMap.get("remain_capital");

			//�p�⵲��Q��
			List bankList = (List) run.query( ecre0801.getAllBankId(issueId), new MapListHandler());
			
			//���� insert
			BigDecimal remainInterestAmount = new BigDecimal(0);
			if(issueId == 4204)
				System.out.println();
			for(Iterator bankIterator = bankList.iterator();bankIterator.hasNext();) {
				Map bank = (Map)bankIterator.next();
				Map insertMap = ecre0801.countInterest(issueId,myForm.getSQLLastDate(),myForm.getSQLLastDate().substring(0,7)+"/01",(Integer)bank.get("bank_id"),run);
				remainInterestAmount = remainInterestAmount.add((BigDecimal)insertMap.get("nouse_interest"));
			}
			//�p�G��������0 ����Q���]��0	
			if(remainCapitalAmount ==null || remainCapitalAmount.intValue()==0){
				tMap.put("remain_interest",new BigDecimal(0));
				tMap.put("total_remain",new BigDecimal(0));				
			}else{
				tMap.put("remain_interest",remainInterestAmount);
				tMap.put("total_remain",remainInterestAmount.add(remainCapitalAmount));
			}

			run.update(connection,insTemp("ECRE05_RPT",tMap));
		}
		
		
	}


}
