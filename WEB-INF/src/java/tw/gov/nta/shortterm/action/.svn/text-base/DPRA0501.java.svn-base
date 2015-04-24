package tw.gov.nta.shortterm.action;

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

import tw.gov.nta.shortterm.form.DpraReportForm;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

public class DPRA0501 extends DefaultAction 
{
	protected SQLJob delTemp(ActionForm form,String usrId,String tempTable){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM "+tempTable+"_RPT ");
		System.out.println(sqljob.toString());
		return sqljob;
	}
	protected SQLJob selAllDPMA05(ActionForm form){
		DpraReportForm myForm =(DpraReportForm)form;
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("SELECT B.ID, ");
		sqljob.appendSQL("(SELECT BANK_NAME FROM BANK_REF WHERE ID = B.BANK_ID) AS BANK_NAME, ");
		sqljob.appendSQL("B.ISSUE_AMOUNT, A.ISSUE_DATE, A.DUE_DATE,B.origin_interest_amount as interest_amount ,");
		sqljob.appendSQL("P.REPAY_DATE, ");
		sqljob.appendSQL("DATEDIFF(DD,A.ISSUE_DATE, A.DUE_DATE) AS DAYS, B.REMARK,B.COMPARE_RATE AS RATE, a.issue_serial as serial_no");
		sqljob.appendSQL("FROM ISSUE_MAIN A ,DEBT_MAIN B, PAYMENT_MAIN P ");
		sqljob.appendSQL("WHERE A.ID = B.ISSUE_ID ");
		sqljob.appendSQL("AND A.DEBT_TYPE = 'D' ");
		sqljob.appendSQL("AND A.ID = P.ISSUE_ID ");
		sqljob.appendSQL("AND B.ID = P.DEBT_ID ");
		sqljob.appendSQL("AND P.REPAY_DATE BETWEEN ? AND ? ");
		sqljob.addParameter(myForm.getPayDate());
		sqljob.addParameter(myForm.getPayDateEnd());
		if (myForm.getDebtCode() != null && !myForm.getDebtCode().equals(0)){
			sqljob.appendSQL("AND B.DEBT_CODE = ? ");
			sqljob.addParameter(myForm.getDebtCode());
		}
		sqljob.appendSQL("ORDER BY A.ISSUE_SERIAL");
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
		sqljob.appendSQL("SUM_INTEREST, REMARK, serial_no)");
		sqljob.appendSQL("VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" );
		sqljob.addParameter(usrId);
		sqljob.addParameter(map.get("bank_name"));
		sqljob.addParameter(map.get("issue_amount"));
		sqljob.addParameter(new BigDecimal(map.get("rate").toString()).divide(new BigDecimal(100)));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss.S");
		
		String startDate = DateUtil.date2ROCStr(sdf.parse(map.get("issue_date").toString()));
		String endDate = DateUtil.date2ROCStr(sdf.parse(map.get("due_date").toString()));
		sqljob.addParameter(startDate+"~"+endDate);
		sqljob.addParameter((map.get("repay_date")!=null)?map.get("repay_date"):"");
		sqljob.addParameter(map.get("days"));
		sqljob.addParameter(map.get("interest_amount"));
		sqljob.addParameter(map.get("sum_interest")!=null?map.get("sum_interest"):0);
		sqljob.addParameter("");
		sqljob.addParameter(map.get("serial_no"));
		System.out.println(sqljob.toString());
		return sqljob;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception
	{
		DpraReportForm myForm =(DpraReportForm)form;
		SQLRunner run = new ConnectionSQLRunner(connection);
		SQLJob queryAll = null;
		String usrId = this.getUserId(request);
		run.update(connection,delTemp(form,usrId,"DPRA05"));
		queryAll = selAllDPMA05(form);
		List listAll = (List) run.query(queryAll, new MapListHandler());
		for(Iterator it=listAll.iterator();it.hasNext();)
		{
			Map map = (Map)it.next();
			if(map!=null)
			{
				map.put("sum_interest",((BigDecimal)map.get("issue_amount")).add(new BigDecimal( map.get("interest_amount").toString())));
				run.update(connection,insTemp(form,usrId,"DPRA05",map));
			}
		}
		request.setAttribute("statrDate",DateUtil.date2ChineseROC2(myForm.getPayDate()));
		request.setAttribute("endDate",DateUtil.date2ChineseROC2(myForm.getPayDateEnd()));
	}
}
