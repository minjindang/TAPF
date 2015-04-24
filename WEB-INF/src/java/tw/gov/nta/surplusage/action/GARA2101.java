package tw.gov.nta.surplusage.action;

import gov.dnt.tame.common.ExcelReportBaseAction;

import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;
import org.hibernate.Criteria;
import org.hibernate.Session;

import tw.gov.nta.sql.BudgetRef;
import tw.gov.nta.sql.dao.BudgetRefDAO;
import tw.gov.nta.sql.debt.GaraNote;
import tw.gov.nta.surplusage.common.GaraNoteManager;
import tw.gov.nta.surplusage.form.Gara2101Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class GARA2101 extends ExcelReportBaseAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM GARA21_RPT ");
		System.out.println("delTemp==>"+sqljob.toString());
		return sqljob;
	}


	public Integer getCodeId (String codeName)
	{
		Session codeSession = new BudgetRefDAO().createNewSession();
		Criteria codeCriteria = codeSession.createCriteria(BudgetRef.class);
		List codeList = codeCriteria.list();
		Integer codeId = new Integer(0);
		if(null != codeList && 0 != codeList.size())
		{	
			for(Iterator it = codeList.iterator();it.hasNext();)
			{
				BudgetRef myBudget = (BudgetRef)it.next();
				if(codeName.equals(myBudget.getBudgetName()))
				{
					codeId = myBudget.getId();
				}
			}	
		}	
		codeSession.close();
		return codeId;
	}


	//查詢資料,
	//op = 1 為公債, op = 2 為?借
	public SQLJob selTmp(Gara2101Form form , int op)
	{
		
		String reportDate = DateUtil.date2Str(new Date(),"yyyy/MM/dd" );
		
		SQLJob job = new SQLJob();
		job.appendSQL("SELECT  A.DEBT_CODE, ");
//		job.appendSQL("datediff(yy,A.ISSUE_DATE , DUE_DATE) AS ISSUE_RANGE,");
		job.appendSQL("dbo.countDay(max(a.issue_date),max(a.due_date),max(a.show_type)) AS ISSUE_RANGE,");
		job.appendSQL("	A.DEBT_NAME , (select issue_date from issue_main where id=a.source_issue_id) as issue_date , A.DUE_DATE,");
		if(op == 1)
		{
			job.appendSQL("	A.Average_rate, ");
		}else
		{
			job.appendSQL("	(select debt_rate from debt_rate_det where debt_id=D.id and effective_date < '"+reportDate+"' and suspend_date > '"+reportDate+"' and delete_mark='N') as Average_rate, ");
		}
		job.appendSQL("	(ISNULL((A.ISSUE_AMOUNT - A.CAPITAL_AMOUNT),0)/"+ form.getAmountUnit() + ") AS REMAIN_AMOUNT ,");
		job.appendSQL("	ISNULL(B.INTEREST_SERIAL,'0') AS INTEREST_SERIAL, (ISNULL(B.INTEREST_AMOUNT,0)/"+ form.getAmountUnit() + ") AS INTEREST_AMOUNT ");
		job.appendSQL("FROM ISSUE_MAIN A, DEBT_PLAN_DET B , DEBT_MAIN D");
		job.appendSQL("WHERE B.ISSUE_ID = A.ID ");
		job.appendSQL(" AND D.ISSUE_ID = A.ID AND B.DEBT_ID = D.ID ");
		if ( form.getIssueYear() != null && !"".equals(form.getIssueYear())){
			job.appendSQL("	AND year(B.REPAY_DATE)-1911 = " + form.getIssueYear() + " ");
		}
		job.appendSQL("	AND D.BUDGET_CODE = '1' ");
		
		if(op == 1)
		{
			job.appendSQL("	AND A.DEBT_TYPE = 'A' ");
		}else
		{
			job.appendSQL("	AND A.DEBT_TYPE = 'C' ");
		}
		job.appendSQL(" AND ISNULL(B.INTEREST_SERIAL,'0') > 0 ");
		job.appendSQL(" group by A.debt_code, A.debt_name, A.issue_date, A.due_date,a.show_type, d.id,D.issue_amount, A.Average_rate, B.INTEREST_SERIAL,B.INTEREST_AMOUNT,A.SOURCE_ISSUE_ID, A.ISSUE_AMOUNT, A.CAPITAL_AMOUNT, A.account_year, a.serial_no  ");
		job.appendSQL(" ORDER BY A.account_year, a.serial_no, A.DEBT_CODE , A.ISSUE_DATE , ISNULL(B.INTEREST_SERIAL,'0') , A.DEBT_NAME ");

		System.out.println("selTmp==>"+job.toString());
		return job;
	}

	@SuppressWarnings({"unchecked","unchecked"})
	public void executeQuery(ActionForm form, HttpServletRequest request, 
			Connection connection) throws Exception 
	{
		
		Gara2101Form myForm = (Gara2101Form) form;
		GaraNote garaNote = new GaraNoteManager().getGaraNote(myForm.getPath());
		garaNote.setMemo(myForm.getMemo());
		garaNote.setPath(myForm.getPath());
		new GaraNoteManager().confirm(garaNote);
		request.setAttribute("memo",garaNote.getMemo());
		
		@SuppressWarnings("unused") BigDecimal unit = (BigDecimal)myForm.getAmountUnit();
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delTemp(form,usrId));
		//執行 insert
		
		BigDecimal sum1 = new BigDecimal(0);
		BigDecimal sum2 = new BigDecimal(0);
		Map tMap = new HashMap();
		//tCommonMap.
		List queryList1 = (List) run.query(selTmp(myForm,1), new MapListHandler());
		for(Iterator tIterator = queryList1.iterator(); tIterator.hasNext(); ){
			tMap = (Map) tIterator.next();
			tMap.putAll(getCommonMap(usrId));
			tMap.put("Issue_name",(String)tMap.get("debt_name")+"-公債");
			tMap.put("debt_name",(String)tMap.get("debt_name")+"-公債");
			sum1 = sum1.add((BigDecimal)tMap.get("Interest_amount"));
			run.update(connection,insTemp("GARA21_RPT",tMap));
		}
		
		tMap.clear();
		tMap.putAll(getCommonMap(usrId));
		tMap.put("Interest_serial","公債小計");
		tMap.put("Interest_amount",sum1);
		run.update(connection,insTemp("GARA21_RPT",tMap));
		
		queryList1 = (List) run.query(selTmp(myForm,2), new MapListHandler());
		for(Iterator tIterator = queryList1.iterator(); tIterator.hasNext(); ){
			tMap = (Map) tIterator.next();
			tMap.putAll(getCommonMap(usrId));
			tMap.put("Issue_name",(String)tMap.get("debt_name")+"-賒借");
			tMap.put("debt_name",(String)tMap.get("debt_name")+"-賒借");
			sum2 = sum2.add((BigDecimal)tMap.get("Interest_amount"));
			run.update(connection,insTemp("GARA21_RPT",tMap));
		}
		
		tMap.clear();
		tMap.putAll(getCommonMap(usrId));
		tMap.put("Interest_serial","賒借小計");
		tMap.put("Interest_amount",sum2);
		run.update(connection,insTemp("GARA21_RPT",tMap));
		tMap.clear();
		
		tMap.putAll(getCommonMap(usrId));
		tMap.put("Interest_serial","總計");
		tMap.put("Interest_amount",sum1.add(sum2));
		run.update(connection,insTemp("GARA21_RPT",tMap));
	
	}

	
	
}
