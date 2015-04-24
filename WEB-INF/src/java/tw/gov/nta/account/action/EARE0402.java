package tw.gov.nta.account.action;

import gov.dnt.tame.common.CheckNullValue;
import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;
import tw.gov.nta.debt.account.common.DebtAccountManager;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class EARE0402 extends DefaultAction {
	
	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM EARE04_RPT ");
		////sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}

	/*琩高ら戳 = 穦璸 + 穦璸る + る程ぱ
	 * パa.account_type ㄓ﹚ D   C禪
SELECT  a.account_type,a.account_name As account_name, 
       SUM(CASE WHEN c.account_type = a.account_type  then c.account_amount 
          WHEN c.account_type <>  a.account_type  then c.account_amount * -1 ELSE 0 END) AS account_total
FROM    account_ref a,voucher_main b,voucher_det c
WHERE   c.account_code = a.id 
  AND   b.id = c.voucher_id
  AND  (b.voucher_date <= [琩高ら戳])
  AND  (b.voucher_type = [肚布摸] )
  AND  d.debt_type = 'A'
GROUP BY   a.account_type,a.account_name
	 *
	 */
 	  protected SQLJob mainsql(String voucherDate,Integer voucherType,String debtTypeCode,String issueKind){
			SQLJob sqljob = new SQLJob();
			sqljob.appendSQL(" SELECT  a.account_code,a.account_type,a.account_name As account_name, ");
			sqljob.appendSQL(" SUM(CASE WHEN c.account_type = a.account_type  then c.account_amount ");
			sqljob.appendSQL(" WHEN c.account_type <>  a.account_type  then c.account_amount * -1 ELSE 0 END) AS account_total ");
			sqljob.appendSQL(" FROM    account_ref a,voucher_main b,voucher_det c,issue_main d ");
			sqljob.appendSQL(" WHERE   c.account_code = a.id ");
			sqljob.appendSQL(" AND   b.id = c.voucher_id ");
			sqljob.appendSQL(" AND   d.id = b.issue_id ");
			if(null!=issueKind &&!"".equals(issueKind) &&"A".equals(debtTypeCode)) {
				sqljob.appendSQL(" AND  b.issue_kind = '"+issueKind+"' ");
			}
			sqljob.appendSQL(" AND  (b.voucher_date <= '"+voucherDate+"') ");
			if ( voucherType != 0   ){
				if (voucherType == DebtAccountManager.Pay) {
					sqljob.appendSQL(" AND  (b.voucher_type = "+voucherType+" or b.voucher_type = "+DebtAccountManager.Charge+" or" +
							" b.voucher_type = "+DebtAccountManager.PayCharge+" )");
				}else {
					sqljob.appendSQL(" AND  (b.voucher_type = "+voucherType+" ) ");
				}
			}
			sqljob.appendSQL(" AND  d.debt_type = '"+debtTypeCode+"' ");
			sqljob.appendSQL(" AND  b.post_date is not null ");
			sqljob.appendSQL(" GROUP BY   a.account_code,a.account_type,a.account_name Order by a.account_code ");
			System.out.println(sqljob.toString());
			return sqljob;
		}

	protected SQLJob insertJob(Object debtor, Object debitAmount,
			                   Object creditor, Object creditAmount,String usrId,Timestamp today,String accountCode
			                   ){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO EARE04_RPT");
		sqljob.appendSQL("(DEBTOR ,DEBIT_AMOUNT,CREDITOR,CREDIT_AMOUNT,USRID,MOD_DATE,account_code )");
		sqljob.appendSQL("VALUES (?,?,?,?,?,?,?)");
		sqljob.addParameter(debtor);
		sqljob.addParameter(debitAmount);
		sqljob.addParameter(creditor);
		sqljob.addParameter(creditAmount);
		sqljob.addParameter(usrId);
		sqljob.addParameter(today);
		sqljob.addParameter(accountCode);
		System.out.println(sqljob.toString());
		return sqljob;
	}
	

	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		AccountQueryForm myForm = (AccountQueryForm) form;
		String usrId = this.getUserId(request);
		String voucherDate ;
		Calendar calendar = Calendar.getInstance();
		calendar.set(Integer.parseInt(myForm.getAccountYear())+1911,Integer.parseInt(myForm.getMonth()),1);
		calendar.add(Calendar.DATE,-1);
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		// 琩高兵ン
		Timestamp today = new Timestamp( new Date().getTime() );
		voucherDate = df.format(calendar.getTime());
		String debtTypeCode  = (String)request.getSession().getAttribute("debtTypeCode");
		Integer  voucherType = CheckNullValue.checkNullPasueZero(myForm.getVoucherType());
		//----
		SQLRunner run = new ConnectionSQLRunner(connection);
		run.update(connection,delTemp(myForm,usrId));
		MapHandler mh = new MapHandler();
	    SQLJob queryJob1 = mainsql(voucherDate,voucherType,debtTypeCode,myForm.getIssueKind());
	    List queryList1 = (List) run.query(queryJob1, new MapListHandler());
	    String accountType ;
		String accountName ;
		String accountCode = "" ;
    	 request.setAttribute("voucherType",voucherType);
		 request.setAttribute("voucherDate1",DateUtil.date2ROCStr(calendar.getTime(),"yyyMMdd"));
		 request.setAttribute("voucherDate2",voucherDate);
		Map cMap = new LinkedHashMap();
		Map dMap = new LinkedHashMap(); 
		BigDecimal accountAmount =  new BigDecimal(0); 
		 for(Iterator it1=queryList1.iterator();it1.hasNext();){
			 accountType = "";
			 accountName = "";
			 accountAmount =  new BigDecimal(0); 		
	    	Map mapQry1 = (Map) it1.next();
			if (mapQry1 != null)
			{	 
			    //---	
				accountCode    = (String) mapQry1.get("account_code");
				accountType    = (String) mapQry1.get("account_type");
				accountName    = (String) mapQry1.get("account_name");
				accountAmount  = (BigDecimal) mapQry1.get("account_total"); 		
				if ("D".equals(accountType.trim())){
					Object[] accountData = {accountName,accountAmount};
					dMap.put(accountCode,accountData);
				}
				else if("C".equals(accountType.trim())){
					Object[] accountData = {accountName,accountAmount};
					cMap.put(accountCode,accountData);
						
				}
			 }								
			
	    }	
        //
		String      debtAccountCode = "";
		String      debtor = "";
	    BigDecimal  debitAmount =  new BigDecimal(0);
	    String      creditAccountCode = "";
	    String      creditor = "";
	    BigDecimal  creditAmount =new BigDecimal(0);
	    
	    Iterator iterator  = dMap.keySet().iterator();
	    Iterator iterator2 = cMap.keySet().iterator(); 
	    while(iterator.hasNext() || iterator2.hasNext()){
			if (iterator.hasNext()){
				debtAccountCode = (String)iterator.next();
				Object[] accountData = (Object[])dMap.get(debtAccountCode);
				debtor = (String)accountData[0];
				debitAmount = (BigDecimal)accountData[1];

			}else{
				debtor = "";
				debtAccountCode = "";
				debitAmount = new BigDecimal(0);
			}	
			if (iterator2.hasNext()){
				creditAccountCode = (String)iterator2.next();
				Object[] accountData = (Object[])cMap.get(creditAccountCode);
				creditor = (String)accountData[0];
				creditAmount = (BigDecimal)accountData[1];
			}else{
				creditor = "";
				creditAccountCode = "";
				creditAmount = new BigDecimal(0);
			}
		    run.update(connection,insertJob(debtor,debitAmount,creditor,creditAmount,usrId,today,(!debtAccountCode.equals(""))?debtAccountCode:creditAccountCode));
		}
	}
}

