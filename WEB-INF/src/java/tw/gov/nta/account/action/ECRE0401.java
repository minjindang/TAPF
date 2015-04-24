package tw.gov.nta.account.action;

import gov.dnt.tame.common.ExcelReportBaseAction;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class ECRE0401 extends ExcelReportBaseAction
{
	private final static String TEMP_TABLE_NAME = "ECRE04_RPT";

	protected SQLJob getAllIssueMainId(Date qryDate)
	{
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("SELECT I.id");
		sqljob.appendSQL(",I.debt_name");
		sqljob.appendSQL("  FROM issue_main I ");
		sqljob.appendSQL(" WHERE I.debt_type='C'");
		sqljob.appendSQL("   AND I.issue_date<=?");
		sqljob.appendSQL("   AND isnumeric(I.serial_no) = 1");
		sqljob.appendSQL("   order by account_year,serial_no");
		sqljob.addParameter( new Timestamp( qryDate.getTime() ) );
		return sqljob;
	}

	protected String getVoucherAmountSql()
	{
		//���ͦU�����
			
		Map reportAccountInfo = getReportAccountInfo();
		StringBuffer queryString = new StringBuffer();
		queryString.append("SELECT ");
		
		for(Iterator iterator=reportAccountInfo.keySet().iterator();iterator.hasNext();) {
			String columnName = (String)iterator.next();
			String accountRule = (String)reportAccountInfo.get(columnName);
			
			StringTokenizer accountTokenizer = new StringTokenizer(accountRule,";");
			while(accountTokenizer.hasMoreTokens()) {
				String detailAccount = accountTokenizer.nextToken(); 
				StringTokenizer typeTokenizer = new StringTokenizer(detailAccount,":");
				
				String accountCode = typeTokenizer.nextToken();
				String accountType = typeTokenizer.nextToken();
				queryString.append(" isnull(sum(case when a.account_code = '"+accountCode+"' then ");
				if("A".equals(accountType)) {
					queryString.append(" case when d.account_type = a.account_type then d.account_amount else d.account_amount * -1 end ");
				}else if("C".equals(accountType)) {
					queryString.append(" case when d.account_type = a.account_type  then d.account_amount else case when m.phase_id = 75 then d.account_amount * -1 else 0 end end ");
				}else {
					queryString.append(" case when d.account_type = '"+accountType+"' then d.account_amount else 0 end ");
				}	
				queryString.append(" else 0 end),0) ");
				if(accountTokenizer.hasMoreTokens()) {
					queryString.append("+");
				}else {
					queryString.append("as "+columnName+", \n");
				}
			}
		}		
		queryString.append(" ? As DEBT_NAME,");
		queryString.append(" ? As usrId");
		queryString.append("  FROM voucher_main M, voucher_det D ,account_ref A \n");
		queryString.append(" WHERE M.id=D.voucher_id \n");
		queryString.append("   AND A.id=D.account_code \n");
		queryString.append("   AND M.issue_id=? \n");
		queryString.append("   and M.voucher_Date <=? \n");
		queryString.append("   And M.debt_type_id=3 \n");
		queryString.append("   And a.debt_type=3 \n");
		queryString.append("   And M.post_date is not null \n");
		System.out.println(queryString.toString());

		return queryString.toString();
		
	}

	protected SQLJob insTemp(Map map)
	{
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO " + TEMP_TABLE_NAME);
		sqljob.appendSQL(" ( DEBT_NAME ,");
		sqljob.appendSQL(" PLANPAY_CAPITAL, PLANPAY_INTEREST, PLANPAY_TOTAL, ");//1.���v�I�`�B
		sqljob.appendSQL("  PREPAY_CAPITAL,  PREPAY_INTEREST,  PREPAY_TOTAL, ");//2.�w����δ��e�v�I�`�B
		sqljob.appendSQL("  NOWPAY_CAPITAL,  NOWPAY_INTEREST,  NOWPAY_TOTAL, ");//3.��������B
		sqljob.appendSQL("     PAY_CAPITAL,     PAY_INTEREST,     PAY_TOTAL, ");//4.�w���I���B
		sqljob.appendSQL("   NOPAY_CAPITAL,   NOPAY_INTEREST,   NOPAY_TOTAL, ");//5.����|�����I���B(2-4)
		sqljob.appendSQL("  DUEPAY_CAPITAL,  DUEPAY_INTEREST,  DUEPAY_TOTAL, ");//6.��������Υ�������B(3+5)
		sqljob.appendSQL(" AHEAD_INTEREST, ");//7.���e�v�٧Q���R�P��
		sqljob.appendSQL(" USRID, MOD_DATE, REMARK");
		sqljob.appendSQL(" ) VALUES ( ");
		sqljob.appendSQL(" ?,?,?,?,?");
		sqljob.appendSQL(",?,?,?,?,?");
		sqljob.appendSQL(",?,?,?,?,?");
		sqljob.appendSQL(",?,?,?,?,?");
		sqljob.appendSQL(",?,?,?");
		sqljob.appendSQL(" ) ");

		sqljob.addParameter( map.get("DEBT_NAME") );
		//1.���v�I�`�B
		BigDecimal planpayInterest = (BigDecimal)map.get("PLANPAY_INTEREST");
		sqljob.addParameter( map.get("PLANPAY_CAPITAL") );
		sqljob.addParameter( planpayInterest.setScale(0,BigDecimal.ROUND_HALF_UP) );
		sqljob.addParameter( ((BigDecimal) map.get("PLANPAY_CAPITAL")).add( planpayInterest.setScale(0,BigDecimal.ROUND_HALF_UP) ) );
		//2.�w����δ��e�v�I�`�B
		BigDecimal prepayInterest = (BigDecimal)map.get("PREPAY_INTEREST");
		sqljob.addParameter( map.get("PREPAY_CAPITAL") );
		sqljob.addParameter( prepayInterest.setScale(0,BigDecimal.ROUND_HALF_UP) );
		sqljob.addParameter( ((BigDecimal) map.get("PREPAY_CAPITAL")).add( prepayInterest.setScale(0,BigDecimal.ROUND_HALF_UP) ) );
		//3.��������B
		BigDecimal nowpayInterest = (BigDecimal)map.get("NOWPAY_INTEREST");
		sqljob.addParameter( map.get("NOWPAY_CAPITAL") );
		BigDecimal nowpayCapital = (BigDecimal)map.get("NOWPAY_CAPITAL");
		if(nowpayCapital.compareTo(new BigDecimal(0)) == 0){
			sqljob.addParameter(new BigDecimal(0));
			sqljob.addParameter(new BigDecimal(0));			
		}else{
			sqljob.addParameter( nowpayInterest.setScale(0,BigDecimal.ROUND_HALF_UP) );
			sqljob.addParameter( ((BigDecimal) map.get("NOWPAY_CAPITAL")).add(nowpayInterest.setScale(0,BigDecimal.ROUND_HALF_UP)));			
		}
		//4.�w���I���B
		BigDecimal payInterest = (BigDecimal)map.get("PAY_INTEREST");
		sqljob.addParameter( map.get("PAY_CAPITAL") );
		sqljob.addParameter( payInterest.setScale(0,BigDecimal.ROUND_HALF_UP) );
		sqljob.addParameter( ((BigDecimal) map.get("PAY_CAPITAL")).add( payInterest.setScale(0,BigDecimal.ROUND_HALF_UP) ) );
		//5.����|�����I���B(2-4)
		sqljob.addParameter( ((BigDecimal) map.get("PREPAY_CAPITAL")).subtract( (BigDecimal) map.get("PAY_CAPITAL") ) );
		sqljob.addParameter( ((BigDecimal) map.get("PREPAY_INTEREST")).subtract( (BigDecimal) map.get("PAY_INTEREST") ) );
		sqljob.addParameter( ((BigDecimal) map.get("PREPAY_CAPITAL")).subtract( (BigDecimal) map.get("PAY_CAPITAL") ).add( ((BigDecimal) map.get("PREPAY_INTEREST")).subtract( (BigDecimal) map.get("PAY_INTEREST") ) ) );
		//6.��������Υ�������B(3+5)
		BigDecimal duepayCapital = new BigDecimal(0);
		duepayCapital = ((BigDecimal) map.get("NOWPAY_CAPITAL")).add( ((BigDecimal) map.get("PREPAY_CAPITAL")).subtract( (BigDecimal) map.get("PAY_CAPITAL") ) );
		sqljob.addParameter( duepayCapital );
		if(duepayCapital.compareTo(new BigDecimal(0)) == 0){
			sqljob.addParameter(new BigDecimal(0));
			sqljob.addParameter(new BigDecimal(0));
		}else{
			sqljob.addParameter( (nowpayInterest.setScale(0,BigDecimal.ROUND_HALF_UP)).add( (prepayInterest.setScale(0,BigDecimal.ROUND_HALF_UP)).subtract( payInterest.setScale(0,BigDecimal.ROUND_HALF_UP) ) ) );
			sqljob.addParameter( ((BigDecimal) map.get("NOWPAY_CAPITAL")).add( ((BigDecimal) map.get("PREPAY_CAPITAL")).subtract( (BigDecimal) map.get("PAY_CAPITAL") ) ).add( (nowpayInterest.setScale(0,BigDecimal.ROUND_HALF_UP)).add( (prepayInterest.setScale(0,BigDecimal.ROUND_HALF_UP)).subtract( payInterest.setScale(0,BigDecimal.ROUND_HALF_UP) ) ) ) );
		}
		//7.���e�v�٧Q���R�P��
		
		BigDecimal upgetInterestAmount = (BigDecimal) map.get("UPGET_INTEREST");
		sqljob.addParameter(upgetInterestAmount );

		sqljob.addParameter( map.get("usrId") );
		sqljob.addParameter( new Timestamp( new Date().getTime() ) );
		String remark = "";
		
		sqljob.addParameter(remark);

		System.out.println(sqljob);
		return sqljob;
	}

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		//���o�ϥΪ̱b��
		String usrId = this.getUserId(request);
		//���oSQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//���� delete 
		run.update( connection, delSQLJob(TEMP_TABLE_NAME,usrId) );

		AccountQueryForm myForm = (AccountQueryForm) form;
		Date qryDate = DateUtil.str2Date( DateUtil.getLastDateOfMonth(myForm.getAccountYear(),myForm.getMonth()) );
		List issueIdList = (List) run.query( getAllIssueMainId(qryDate), new MapListHandler());
		String querySql = getVoucherAmountSql();

		for(Iterator it=issueIdList.iterator();it.hasNext();)
		{
			
			Map issueMap = (Map) it.next();
			Integer issueId = (Integer) issueMap.get("id");
			String debtName = (String) issueMap.get("debt_name") ;
			Object[] parameters = {debtName,usrId,issueId,qryDate};
			SQLJob sqljob = new SQLJob(querySql,parameters);
//			Map<String,Object> insertMap = (Map) run.query( sqljob, new MapHandler());
			List insertList = (List) run.query(sqljob, new MapListHandler());
			for (Iterator ins = insertList.iterator();ins.hasNext();)
			{
				Map insertMap = (Map) ins.next();
//				if (null != (BigDecimal)insertMap.get("PLANPAY_CAPITAL"))
//					insertMap.put("PLANPAY_CAPITAL",getIntegral((BigDecimal)insertMap.get("PLANPAY_CAPITAL")));
//				if (null != (BigDecimal)insertMap.get("planpay_interest"))
//					insertMap.put("planpay_interest",getIntegral((BigDecimal)insertMap.get("planpay_interest")));
//				
//				if (null != (BigDecimal)insertMap.get("PREPAY_CAPITAL"))
//					insertMap.put("PREPAY_CAPITAL",getIntegral((BigDecimal)insertMap.get("PREPAY_CAPITAL")));
//				if (null != (BigDecimal)insertMap.get("PREPAY_INTEREST"))
//					insertMap.put("PREPAY_INTEREST",getIntegral((BigDecimal)insertMap.get("PREPAY_INTEREST")));
//				
//				if (null != (BigDecimal)insertMap.get("NOWPAY_CAPITAL"))
//					insertMap.put("NOWPAY_CAPITAL",getIntegral((BigDecimal)insertMap.get("NOWPAY_CAPITAL")));
//				if (null != (BigDecimal)insertMap.get("nowpay_interest"))
//					insertMap.put("nowpay_interest",getIntegral((BigDecimal)insertMap.get("nowpay_interest")));
//				
//				if (null != (BigDecimal)insertMap.get("PAY_CAPITAL"))
//					insertMap.put("PAY_CAPITAL",getIntegral((BigDecimal)insertMap.get("PAY_CAPITAL")));
//				if (null != (BigDecimal)insertMap.get("PAY_INTEREST"))
//					insertMap.put("PAY_INTEREST",getIntegral((BigDecimal)insertMap.get("PAY_INTEREST")));
//				
//				if (null != (BigDecimal)insertMap.get("NOPAY_CAPITAL"))
//					insertMap.put("NOPAY_CAPITAL",getIntegral((BigDecimal)insertMap.get("NOPAY_CAPITAL")));
//				if (null != (BigDecimal)insertMap.get("NOPAY_INTEREST"))
//					insertMap.put("NOPAY_INTEREST",getIntegral((BigDecimal)insertMap.get("NOPAY_INTEREST")));
//				
//				if (null != (BigDecimal)insertMap.get("DUEPAY_CAPITAL"))
//					insertMap.put("DUEPAY_CAPITAL",getIntegral((BigDecimal)insertMap.get("DUEPAY_CAPITAL")));
//				if (null != (BigDecimal)insertMap.get("duepay_interest"))
//					insertMap.put("duepay_interest",getIntegral((BigDecimal)insertMap.get("duepay_interest")));
				run.update(connection,insTemp(insertMap));
			}

		}
	}
	
//	private BigDecimal getIntegral(BigDecimal amount){
//		String amountString = String.valueOf(amount);
//		BigDecimal amountIntegral = new BigDecimal(0);
//		int amountLength = amountString.indexOf(".");
//		amountIntegral = new BigDecimal(amountString.substring(0,amountLength));
//		return amountIntegral;
//	}

	private Map getReportAccountInfo(){
		//PC01 ��w������--����                      
		//PC02 ��w������--�Q��
		//PD03 ���I����u���ɴ�--����                  
		//PD04 ���I����u���ɴ�--�Q��                  
		//PD07 ����w�I(����)
		//PD08 ����w�I(�Q��)
		//
		String[] accountRules = {"PD04:D","PD05:C","PC04:C;PC08:C","PC05:C;PC09:C","PC02:A","PC03:A",
				                 "PC04:C;PC08:C","PC05:C;PC09:C","PC12:D"};
		
		String[] columnName = {"PLANPAY_CAPITAL","PLANPAY_INTEREST","PREPAY_CAPITAL","PREPAY_INTEREST",
								"NOWPAY_CAPITAL","NOWPAY_INTEREST","PAY_CAPITAL","PAY_INTEREST","UPGET_INTEREST"};
		
		Map reportAccountInfo = new HashMap();
		for(int i=0;i<accountRules.length;i++) {
			reportAccountInfo.put(columnName[i],accountRules[i]);
		}
		
		return reportAccountInfo;
	}
}