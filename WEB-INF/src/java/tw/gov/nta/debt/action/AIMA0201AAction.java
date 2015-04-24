package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.Messages;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.struts.action.ActionForm;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.debt.common.InterestCounter;
import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.common.RateManager;
import tw.gov.nta.debt.form.Aima0201MForm;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.IssueMain;

public class AIMA0201AAction extends DefaultAction
{
	private final static String ERROR_ISSUE_SERIAL_REPEAT = "公債代號重複!!";
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		Aima0201MForm aima0201MForm = (Aima0201MForm) form;
		IssueMain tIssueMain = aima0201MForm.getIssueMain();
		tIssueMain.setBondKind("3");
		tIssueMain.setCapitalAmount(new BigDecimal(0));
		tIssueMain.setDebtType("A");
		tIssueMain.setModDate(Calendar.getInstance().getTime());
		tIssueMain.setPayableInterestAmount(aima0201MForm.getRepayInterestAmount());
//		List tList = new DebtManager().getBeanByIssue(tIssueMain.getSourceIssueId().intValue());
//		if(tList != null && tList.size() != 0){
//			tList = new RateManager().getEffectiveRate(((DebtMain)tList.get(0)).getId());
//			tIssueMain.setInterestAmount(new InterestCounter().countInterest(tIssueMain.getIssueDate(), tIssueMain.getDueDate(), tList, tIssueMain.getIssueAmount().doubleValue(), 0).setScale(4,BigDecimal.ROUND_HALF_UP));
//		}
		tIssueMain.setCapitalAmount(new BigDecimal(0));
		tIssueMain.setInterestAmount(new BigDecimal(0));
//		20090901 將手續費利率調降為0.0075
//		tIssueMain.setChargeRate(new BigDecimal("0.0009"));
//		tIssueMain.setChargeRate(new BigDecimal("0.00075"));
		//20130918 將手續費改為抓取資料庫的值(feerate)
		tIssueMain.setChargeRate(new BigDecimal(getChargeRate(connection,aima0201MForm.getAccountYear())));
		
		List tList = new IssueManager().Search(new String[]{"issueSerial","debtType"}, new Object[]{tIssueMain.getIssueSerial(),"A"}, new String[]{"=","="}, null);
		if(tList != null && !tList.isEmpty() ){
			setAlertMessage(request, ERROR_ISSUE_SERIAL_REPEAT);
			throw new Exception("ERROR_ISSUE_SERIAL_REPEAT");
		}
		try{
			
			new IssueManager().confirm(tIssueMain);
			setAlertMessage(request,Messages.SUCCESS_ADD);
			request.setAttribute("issueMainId",tIssueMain.getId());
		}
		catch(Exception e){
			System.out.println(e);
			setAlertMessage(request,Messages.FAILURE_ADD);
			throw new Exception(Messages.FAILURE_ADD);
		}
	}
	private String getChargeRate(Connection connection,String accountYear)throws Exception{
		String debt_type = "A";
		SQLRunner run = new ConnectionSQLRunner(connection);
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select charge_rate from FeeRate where year <= ? and debt_type=? order by cast(year as int) desc");
		sqljob.addParameter(accountYear);
		sqljob.addParameter(debt_type);
		Map map = (Map)run.query(sqljob,new MapHandler());
		if(map!=null && map.get("charge_rate") != null && !"".equals(map.get("charge_rate"))){
			return String.valueOf(map.get("charge_rate"));
		}
		return "0.00075";
	}
}
