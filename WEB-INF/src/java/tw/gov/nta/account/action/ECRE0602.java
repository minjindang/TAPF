package tw.gov.nta.account.action;

import gov.dnt.tame.common.CheckNullValue;
import gov.dnt.tame.common.DefaultAction;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.math.BigInteger;
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

public class ECRE0602 extends DefaultAction {
	
	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM EARE05_RPT ");
		////sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		System.out.println(sqljob.toString());
		return sqljob;
	}

	/*�d�ߤ�� = �|�p�~�� + �|�p��� + ����̫�@��
	 * ��a.account_type �ӧP�w D��   C�U
	SELECT  a.account_type,d.issue_serial,d.debt_name As debt_name,e.budget_name,f.debit_name,
	        a.account_name As account_name, 
	       SUM(CASE WHEN c.account_type = a.account_type  then c.account_amount 
	          WHEN c.account_type <>  a.account_type  then c.account_amount * -1 ELSE 0 END) AS account_total
	FROM    account_ref a,voucher_main b,voucher_det c,issue_main d,budget_ref e,debit_ref f
	WHERE   c.account_code = a.id 
	  AND   b.id = c.voucher_id
	  AND   d.id = b.issue_id
	  AND   d.budget_code = e.id
	  AND   d.debt_code = f.id 
	  AND  (b.voucher_date <= [�d�ߤ��])
	  AND  (b.issue_id =[�o��id]) 
	  AND  (b.voucher_type = [�ǲ����O] )
	  AND  d.debt_type = 'A'
	GROUP BY   a.account_type,d.debt_name,a.account_name,e.budget_name,f.debit_name,d.issue_serial
	 *
	 */
 	  protected SQLJob mainsql(String voucherDate,Integer sourceIssueId, Integer issueId,Integer voucherType,String debtTypeCode,String issueKind,Integer debtId){
			SQLJob sqljob = new SQLJob();
			sqljob.appendSQL(" SELECT a.account_type,min(d.issue_serial) as issue_serial,min(d.debt_name) As debt_name, ");
			if("A".equals(debtTypeCode)){
				sqljob.appendSQL("isnull(e.budget_name,'') as budget_name,isnull(f.debit_name,'') as debit_name, ");
			}
			if("B".equals(debtTypeCode)){
				sqljob.appendSQL("isnull(e.budget_name,'') as budget_name,isnull(f.debit_name,'') as debit_name, ");
			}
			if("D".equals(debtTypeCode)){
				sqljob.appendSQL("isnull(e.budget_name,'') as budget_name,isnull(f.debit_name,'') as debit_name, ");
			}
			sqljob.appendSQL(" a.account_name As account_name, ");
			sqljob.appendSQL(" SUM(CASE WHEN c.account_type = a.account_type  then round(c.account_amount,0) ");
			sqljob.appendSQL(" WHEN c.account_type <>  a.account_type  then round(c.account_amount,0) * -1 ELSE 0 END) AS account_total ");
			sqljob.appendSQL(" FROM    account_ref a,voucher_main b,voucher_det c,issue_main d");
			if("A".equals(debtTypeCode)){
				sqljob.appendSQL(",budget_ref e,debit_ref f ");
			}
			if("B".equals(debtTypeCode)){
				sqljob.appendSQL(",budget_ref e,debit_ref f ");
			}
			if("D".equals(debtTypeCode)){
				sqljob.appendSQL(",budget_ref e,debit_ref f ");
			}
			sqljob.appendSQL(" WHERE   c.account_code = a.id ");
			sqljob.appendSQL(" AND   b.id = c.voucher_id ");
			sqljob.appendSQL(" AND   d.id = b.issue_id ");
			if("A".equals(debtTypeCode)){
				sqljob.appendSQL(" AND   b.budget_code *= e.id ");
				sqljob.appendSQL(" AND   b.debt_code *= f.id ");
			}
			if("B".equals(debtTypeCode)){
				sqljob.appendSQL(" AND   b.budget_code *= e.id ");
				sqljob.appendSQL(" AND   b.debt_code *= f.id ");
			}
			if("D".equals(debtTypeCode)){
				sqljob.appendSQL(" AND   b.budget_code *= e.id ");
				sqljob.appendSQL(" AND   b.debt_code *= f.id ");
			}
			if (issueKind!=null && !"".equals(issueKind)) {
				sqljob.appendSQL(" AND   b.issue_kind = '"+issueKind+"' ");
			}
			if ( issueId != 0   ){
				sqljob.appendSQL(" AND  (");
//				sqljob.appendSQL("         (((d.source_issue_id = "+issueId+" and Not(Year(d.issue_date) = Year('"+voucherDate+"') and Month(d.issue_date) = Month('"+voucherDate+"'))) or (d.id = "+issueId+" and (Year(d.issue_date) = Year('"+voucherDate+"') and Month(d.issue_date) = Month('"+voucherDate+"'))))) ");
				sqljob.appendSQL("         (((d.source_issue_id = "+sourceIssueId+" and Not(Year(d.issue_date) = Year('"+voucherDate+"') and Month(d.issue_date) = Month('"+voucherDate+"'))) or (d.id = "+issueId+" and (Year(d.issue_date) = Year('"+voucherDate+"') and Month(d.issue_date) = Month('"+voucherDate+"'))))) ");
				sqljob.appendSQL("       or  (d.id = "+issueId+" and not exists (select 1 from debt_main x,debt_main y where x.id = "+debtId+" and x.budget_code = y.budget_code and x.debt_code = y.debt_code and y.issue_id = d.source_issue_id) )");
				sqljob.appendSQL("      )			");	
			}
			if ( voucherType != 0   ){
				if (voucherType == DebtAccountManager.Pay) {
					sqljob.appendSQL(" AND  (b.voucher_type = "+voucherType+" or b.voucher_type = "+DebtAccountManager.Charge+" or b.voucher_type ="+DebtAccountManager.PayCharge+" )");
				}else {
					sqljob.appendSQL(" AND  (b.voucher_type = "+voucherType+" ) ");
				}
			}
			sqljob.appendSQL(" AND  (b.voucher_date <= '"+voucherDate+"') ");
			sqljob.appendSQL(" AND  d.debt_type = '"+debtTypeCode+"' ");
			sqljob.appendSQL(" AND  b.post_date is not null ");
			
			if("A".equals(debtTypeCode) && debtId != null && debtId.intValue() !=0){
				sqljob.appendSQL(" AND  exists(select 1 from debt_main  where id = "+debtId+" and debt_code = b.debt_code and budget_code = b.budget_code) ");
			}
			if("B".equals(debtTypeCode) && debtId != null && debtId.intValue() !=0){
				sqljob.appendSQL(" AND  exists(select 1 from debt_main  where id = "+debtId+" and debt_code = b.debt_code and budget_code = b.budget_code) ");
			}
			if("D".equals(debtTypeCode) && debtId != null && debtId.intValue() !=0){
				sqljob.appendSQL(" AND  exists(select 1 from debt_main  where id = "+debtId+" and debt_code = b.debt_code and budget_code = b.budget_code) ");
			}
			sqljob.appendSQL(" GROUP BY   a.account_code,a.account_type,a.account_name");
			if("A".equals(debtTypeCode)){
				sqljob.appendSQL(",e.budget_name,f.debit_name ");
			}
			if("B".equals(debtTypeCode)){
				sqljob.appendSQL(",e.budget_name,f.debit_name ");
			}
			if("D".equals(debtTypeCode)){
				sqljob.appendSQL(",e.budget_name,f.debit_name ");
			}
			sqljob.appendSQL(" ORDER BY   a.account_code ");
			System.out.println(sqljob.toString());
			return sqljob;
		}
/*		
	protected SQLJob mainsql(String voucherDate,Integer issueId,Integer voucherType){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("");
		sqljob.appendSQL("SELECT  d.debt_name As debt_name,");
		sqljob.appendSQL("d.issue_serial,e.budget_name,f.debit_name,a.account_name As account_name,");
		sqljob.appendSQL("SUM(c.account_amount) AS account_total,c.account_type");
		sqljob.appendSQL("FROM    account_ref a,voucher_main b,voucher_det c,issue_main d,budget_ref e,debit_ref f");
		sqljob.appendSQL("WHERE   c.account_code = a.id");
		sqljob.appendSQL("AND   b.id = c.voucher_id");
		sqljob.appendSQL("AND   d.id = b.issue_id");
		sqljob.appendSQL("AND   d.budget_code = e.id");
		sqljob.appendSQL("AND   d.debt_code = f.id");
		sqljob.appendSQL("AND  (b.voucher_date <= '"+voucherDate+"')");
		if (     voucherType!= 0  ){
			if (voucherType==DebtAccountManager.Pay ||voucherType==DebtAccountManager.Charge)
				sqljob.appendSQL("AND  (b.voucher_type = "+DebtAccountManager.Pay+" or b.voucher_type ="+DebtAccountManager.Pay+" )");
			else
				sqljob.appendSQL("AND  (b.voucher_type = "+voucherType+")");
		}
		sqljob.appendSQL("GROUP BY  d.debt_name,a.account_name,e.budget_name,f.debit_name,c.account_type,d.issue_serial");
		System.out.println(sqljob.toString());	
		return sqljob;
	}
*/	

	protected SQLJob insertJob(Object budgetName,  Object debitName ,     
			                   Object debtor, Object debitAmount,
			                   Object creditor, Object creditAmount,String usrId,Timestamp today
			                   ){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO EARE05_RPT");
		sqljob.appendSQL("(budget_name,debit_name, ");
		sqljob.appendSQL("DEBTOR ,DEBIT_AMOUNT,CREDITOR,CREDIT_AMOUNT,USRID,MOD_DATE )");
		sqljob.appendSQL("VALUES (?,?,?,?,?,?,?,?)");
		sqljob.addParameter(budgetName);
		sqljob.addParameter(debitName);
		sqljob.addParameter(debtor);
		sqljob.addParameter(debitAmount);
		sqljob.addParameter(creditor);
		sqljob.addParameter(creditAmount);
		sqljob.addParameter(usrId);
		sqljob.addParameter(today);
		//System.out.println(sqljob.toString());
		return sqljob;
	}
	
	protected SQLJob insertOtherAccountName(Integer voucherType){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO EARE05_RPT");
		sqljob.appendSQL("(USRID, DEBTOR, DEBIT_AMOUNT, CREDITOR, CREDIT_AMOUNT, DEBT_NAME, BUDGET_NAME, DEBIT_NAME, MOD_DATE ) ");
		sqljob.appendSQL("select distinct 'TAPF', ");
		sqljob.appendSQL("(case when a.account_type='D' then a.account_name else '' end), 0, ");
		sqljob.appendSQL("(case when a.account_type='C' then a.account_name else '' end), 0, '',");
		sqljob.appendSQL("(select max(budget_name) from eare05_rpt), ");
		sqljob.appendSQL("(select max(debit_name) from eare05_rpt), ");
		sqljob.appendSQL("(select max(mod_date) from eare05_rpt) ");
		sqljob.appendSQL("from account_phase_main m,account_phase_det d,account_ref a,eare05_rpt e");
		sqljob.appendSQL("where m.id = d.account_phase_id");
		if (voucherType == 1)
			sqljob.appendSQL("and m.debt_type=1 and m.phase_type = 1");
		else
			sqljob.appendSQL("and m.debt_type=1 and m.phase_type in (2,3,4)");
		sqljob.appendSQL("and m.debt_type=1 and m.phase_type=1 ");
		sqljob.appendSQL("and d.account_code_id = a.id ");
		sqljob.appendSQL("and (select count(id) from eare05_rpt where debtor=a.account_name or creditor=a.account_name)=0");
		System.out.println("�ɤW�|�p��� �G " + sqljob.toString());
		return sqljob;
	}
	
	protected SQLJob diffDebtCode(Integer issueId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL(" select debt_code as num from debt_main");
		sqljob.appendSQL(" where issue_id in (select id from issue_main where source_issue_id in (select source_issue_id from issue_main where id="+issueId+"))");
		System.out.println("�D�P�w��O �G " + sqljob.toString());
		return sqljob;
	}
	
	protected SQLJob sourceIssueId(Integer issueId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL(" select source_issue_id as sourceIssueId from issue_main where id="+issueId+"");
		System.out.println("��o�� �G " + sqljob.toString());
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
		// �d�߱���
		Timestamp today = new Timestamp( new Date().getTime() );
		voucherDate = df.format(calendar.getTime());
		
		String debtTypeCode  = (String)request.getSession().getAttribute("debtTypeCode");
		Integer  issueId     = CheckNullValue.checkNullPasueZero(myForm.getIssueId());	
		Integer  voucherType = CheckNullValue.checkNullPasueZero(myForm.getVoucherType());
		Integer debtId = myForm.getDebtId();
		if(debtId == null){
			debtId = new Integer(0);
		}
		SQLRunner run = new ConnectionSQLRunner(connection);
		run.update(connection,delTemp(myForm,usrId));
		
		//�P�_�O�_�W�B�o��P��l�o��w��O�O�_���P
		SQLJob queryJob2 = diffDebtCode(issueId);
		List queryList2 = (List) run.query(queryJob2, new MapListHandler());
		Integer i = null;
		Integer diff=null;
		for(Iterator it2=queryList2.iterator();it2.hasNext();){
			Map mapQry3 = (Map) it2.next();
			if ((boolean)mapQry3.get("num").equals(i)){
				System.out.println("�O�_�����P�w��O�G"+i);
				diff = 1;
			}else
				diff = 2;
				i = (Integer)mapQry3.get("num");		
		}
		
		SQLJob queryJob3 = sourceIssueId(issueId);
		List queryList3 = (List) run.query(queryJob3, new MapListHandler());
		Integer sourceIssueId = null;
		for(Iterator it4=queryList3.iterator();it4.hasNext();){
			Map mapQry4 = (Map) it4.next();
			sourceIssueId = (Integer)mapQry4.get("sourceIssueId");
			System.out.println("�O�_�����P�w��O��issueID�G"+sourceIssueId);
		}
		
		
		
		
		//----
		SQLJob queryJob1;
		if (!diff.equals(1) && !issueId.equals(sourceIssueId))
			queryJob1 = mainsql(voucherDate,sourceIssueId,issueId,voucherType,debtTypeCode,myForm.getIssueKind(),debtId);
		else
			queryJob1 = mainsql(voucherDate,issueId,issueId,voucherType,debtTypeCode,myForm.getIssueKind(),debtId);
		
	    List queryList1 = (List) run.query(queryJob1, new MapListHandler());
	    String issueSerial = "";
	    String budgetName = "";
	    String debitName  = "";
	    String debt_name = "";
		String accountType ;
		String accountName ;
    	 request.setAttribute("voucherType",voucherType);
		 request.setAttribute("issueSerial",""); 
		 request.setAttribute("budgetName",""); 
		 request.setAttribute("debitName","");
		 request.setAttribute("debt_name","");
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
				//��J���Y
				if ("".equals(issueSerial) && ( !mapQry1.get("issue_serial").equals(null) ) ){
				 System.out.println("�����"); 
     		   	 issueSerial   =   (String) mapQry1.get("issue_serial");
				 budgetName    =   (String) mapQry1.get("budget_name");
			     debitName     =   (String) mapQry1.get("debit_name");
			     debt_name     =   (String) mapQry1.get("debt_name");
			     
			     if (budgetName == null)
			    	 budgetName = "";
			     
			     if (debitName == null)
			    	 debitName = "";
			     
				 request.setAttribute("issueSerial",issueSerial(issueId,connection)); 
				 request.setAttribute("budgetName",budgetName); 
				 request.setAttribute("debitName",debitName);
				 request.setAttribute("debt_name",debt_name);
				}
			    //---	
				accountType    = (String) mapQry1.get("account_type");
				accountName    = (String) mapQry1.get("account_name");
				accountAmount  = (BigDecimal) mapQry1.get("account_total"); 		
				if ("D".equals(accountType)){
					dMap.put(accountName,accountAmount);
				}
				else if("C".equals(accountType)){
					cMap.put(accountName,accountAmount);
				}
			 }	
	    }	
        //
		String      debtor = "";
	    BigDecimal  debitAmount =  new BigDecimal(0);
	    String      creditor = "";
	    BigDecimal  creditAmount =new BigDecimal(0);
	    Iterator iterator  = dMap.keySet().iterator();
	    Iterator iterator2 = cMap.keySet().iterator(); 
	    //while(iterator.hasNext() || iterator2.hasNext()){
	    int j=0;
	    while(j<11){
			if (iterator.hasNext()){
				debtor = (String)iterator.next();
				debitAmount = (BigDecimal)dMap.get(debtor);
//				String debitString = String.valueOf((BigDecimal)dMap.get(debtor));
//				int debtLength = debitString.indexOf(".");
//				debitAmount = new BigDecimal(debitString.substring(0,debtLength));
			}else{
				debtor = "";
				debitAmount = new BigDecimal(0);
			}	
			if (iterator2.hasNext()){
				creditor = (String)iterator2.next();
				creditAmount = (BigDecimal)cMap.get(creditor);
//				String creditString = String.valueOf((BigDecimal)cMap.get(creditor));
//				int creditLength = creditString.indexOf(".");
//				creditAmount = new BigDecimal(creditString.substring(0,creditLength));
			}else{
				creditor = "";
				creditAmount = new BigDecimal(0);
			}
		    run.update(connection,insertJob(budgetName,debitName,debtor,debitAmount,creditor,creditAmount,usrId,today));
		j++;
	    }
	    if (myForm.getDebtType().equals(1))
	    	run.update(connection,insertOtherAccountName(voucherType));
	}
	
	public String issueSerial(int id,Connection connection)throws Exception
	{
		SQLRunner run = new ConnectionSQLRunner(connection);
		SQLJob job = new SQLJob();
		String querySql = "select issue_serial as issue_serial" +
				" from issue_main " +
				" where issue_main.id = ? ";
		job.appendSQL(querySql);
		job.addParameter(id);
		Map map = (Map)run.query(job,new MapHandler());
		return (String)map.get("ISSUE_SERIAL");
	}
}
