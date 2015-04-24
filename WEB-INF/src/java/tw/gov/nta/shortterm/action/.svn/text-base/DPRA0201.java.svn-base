package tw.gov.nta.shortterm.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.shortterm.form.DpraReportForm;
import tw.gov.nta.sql.debt.IssueMain;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class DPRA0201 extends DefaultAction
{
	protected SQLJob delTemp(ActionForm form,String usrId,String tempTable){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM "+tempTable+"_RPT ");
		//sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	protected SQLJob selAllDPMA02(String issueId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("SELECT B.ID, ");
		sqljob.appendSQL("(SELECT BANK_NAME FROM BANK_REF WHERE ID = B.BANK_ID) AS BANK_NAME, ");
		sqljob.appendSQL("B.ISSUE_AMOUNT, A.ISSUE_DATE, A.DUE_DATE,B.origin_interest_amount as interest_amount ,");
		sqljob.appendSQL("(SELECT DISTINCT REPAY_DATE FROM DEBT_PLAN_DET WHERE DEBT_ID = B.ID) AS REPAY_DATE, ");
		sqljob.appendSQL("DATEDIFF(DD,A.ISSUE_DATE, A.DUE_DATE) AS DAYS, B.REMARK,B.COMPARE_RATE AS RATE");
		sqljob.appendSQL("FROM ISSUE_MAIN A ,DEBT_MAIN B ");
		sqljob.appendSQL("WHERE A.id = ? AND  A.ID = B.ISSUE_ID ");
		sqljob.addParameter(issueId);
		sqljob.appendSQL("AND A.DEBT_TYPE = 'D'");
		sqljob.appendSQL("ORDER BY  B.BANK_ID");
		System.out.println(sqljob);
		return sqljob;
	}
	protected SQLJob selAllDPMA03(String issueId,Date repayDate){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("SELECT B.BANK_NAME, D.CAPITAL_AMOUNT AS ISSUE_AMOUNT,");                          
		sqljob.appendSQL("C.ISSUE_DATE, C.DUE_DATE, D.REPAY_DATE,");                              
		sqljob.appendSQL("DATEDIFF(DD,C.ISSUE_DATE, D.REPAY_DATE) AS DAYS, A.COMPARE_RATE AS RATE,");                           
		sqljob.appendSQL("D.INTEREST_AMOUNT, A.REMARK");                               
		sqljob.appendSQL("FROM DEBT_MAIN A, BANK_REF B, ISSUE_MAIN C, PAYMENT_MAIN D"); 
		sqljob.appendSQL("WHERE C.id= ? "); 
		sqljob.addParameter(issueId);
		sqljob.appendSQL("AND A.ISSUE_ID=C.ID");                                 
		sqljob.appendSQL("AND A.BANK_ID = B.ID");                                 
		sqljob.appendSQL("AND D.DEBT_ID = A.ID");   
		sqljob.appendSQL("AND C.DEBT_TYPE = 'D'");
		if(null != repayDate)
		{
			sqljob.appendSQL("AND D.REPAY_DATE = ? ");
			sqljob.addParameter(repayDate);
		}
		sqljob.appendSQL(" ORDER BY A.BANK_ID, D.REPAY_DATE");  
		System.out.println(sqljob);
		return sqljob;
	}

	protected SQLJob insTemp(ActionForm form,String usrId,String tempTable,Map map) throws Exception{
		System.out.println(map);
		
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO "+tempTable+"_RPT");
		sqljob.appendSQL("(USRID, BANK_NAME, ISSUE_AMOUNT, ");
		sqljob.appendSQL("RATE, ");
		sqljob.appendSQL("ISSUE_DATE, REPAY_DATE,");
		sqljob.appendSQL("DAYS, INTEREST_AMOUNT, ");
		sqljob.appendSQL("SUM_INTEREST, REMARK)");
		sqljob.appendSQL("VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" );
		sqljob.addParameter(usrId);
		sqljob.addParameter(map.get("bank_name"));
		sqljob.addParameter(map.get("issue_amount"));
		sqljob.addParameter(new BigDecimal(map.get("rate").toString()).divide(new BigDecimal(100)));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss.S");
		
//		String startDate = DateUtil.date2ROCStr(DateUtil.str2Date(map.get("issue_date").toString()));
//		String endDate = DateUtil.date2ROCStr(DateUtil.str2Date(map.get("due_date").toString()));
		String startDate = DateUtil.date2ROCStr(sdf.parse(map.get("issue_date").toString()));
		String endDate = DateUtil.date2ROCStr(sdf.parse(map.get("due_date").toString()));
		sqljob.addParameter(startDate+"~"+endDate);
		sqljob.addParameter((map.get("repay_date")!=null)?map.get("repay_date"):"");
		sqljob.addParameter(map.get("days"));
		sqljob.addParameter(map.get("interest_amount"));
		sqljob.addParameter(map.get("sum_interest"));
		sqljob.addParameter((map.get("remark")!=null && !(map.get("remark").toString().equals("")))?map.get("remark"):"央行業務局 「 銀行業同業存款第  號 」 帳戶");
		System.out.println(sqljob.toString());
		return sqljob;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception
	{
		DpraReportForm myForm =(DpraReportForm)form;
		Date repayDate = myForm.getPayDate();	//償付日期
		IssueManager issueManager = new IssueManager();
		IssueMain dto = issueManager.getBean(myForm.getIssueId());
		String usrId = this.getUserId(request);
		SQLRunner run = new ConnectionSQLRunner(connection);
		SQLJob queryAll = null;
		if(myForm.getTitle().equals("DPRA02") || myForm.getTitle().equals("DPRA04"))
		{
			run.update(connection,delTemp(form,usrId,"DPRA02"));
			queryAll = selAllDPMA02(String.valueOf(myForm.getIssueId()));
		}
		else
		{
			run.update(connection,delTemp(form,usrId,myForm.getTitle()));
			queryAll = selAllDPMA03(String.valueOf(myForm.getIssueId()),repayDate);
		}
		List listAll = (List) run.query(queryAll, new MapListHandler()); 
		for(Iterator it=listAll.iterator();it.hasNext();)
		{
			Map map = (Map)it.next();
			if(map!=null)
			{
				System.out.print(map);
				//Date stratDate = DateUtil.str2Date(map.get("issue_date").toString());
				//Date endDate = DateUtil.str2Date(map.get("due_date").toString());
				//List rateList = new RateManager().getEffectiveRate((Integer)map.get("id"));
				//DebtRateDet debtRateDetDto = (DebtRateDet) rateList.get(0);
				map.put("sum_interest",((BigDecimal)map.get("issue_amount")).add(new BigDecimal( map.get("interest_amount").toString())));
				if(myForm.getTitle().equals("DPRA02") || myForm.getTitle().equals("DPRA04"))
					run.update(connection,insTemp(form,usrId,"DPRA02",map));
				else
					run.update(connection,insTemp(form,usrId,myForm.getTitle(),map));
			}
		}
		request.setAttribute("title",myForm.getTitle());
	}
}
