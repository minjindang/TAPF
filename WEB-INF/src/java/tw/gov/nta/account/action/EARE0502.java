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
import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.IssueMain;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class EARE0502 extends DefaultAction {
	
	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM EARE05_RPT ");
		////sqljob.appendSQL("WHERE USRID='"+usrId+"'");
		//System.out.println(sqljob.toString());
		return sqljob;
	}

	/*查詢日期 = 會計年度 + 會計月份 + 月份最後一天
	 * 由a.account_type 來判定 D借   C貸
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
	  AND  (b.voucher_date <= [查詢日期])
	  AND  (b.issue_id =[發行id]) 
	  AND  (b.voucher_type = [傳票類別] )
	  AND  d.debt_type = 'A'
	GROUP BY   a.account_type,d.debt_name,a.account_name,e.budget_name,f.debit_name,d.issue_serial
	 *
	 */
 	  protected SQLJob mainsql(ActionForm form, String voucherDate,Integer sourceIssueId, Integer issueId,Integer voucherType,String debtTypeCode,String issueKind,Integer debtId, int i){
			SQLJob sqljob = new SQLJob();
			AccountQueryForm myForm = (AccountQueryForm) form;
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
			sqljob.appendSQL(" ABS(SUM(CASE WHEN c.account_type = a.account_type  then c.account_amount ");
			sqljob.appendSQL(" WHEN c.account_type <>  a.account_type  then c.account_amount * -1 ELSE 0 END)) AS account_total ");
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
			
			//------------
			//原發行跟增額在第一次付息前平衡表應分開
			int changIntString = 0;
			String reportDate = "";
			reportDate = myForm.getAccountYear();			
			changIntString = Integer.parseInt(reportDate, 10);
			changIntString = changIntString+1911;
			reportDate = reportDate.valueOf(changIntString)+"/"+myForm.getMonth()+"/01";
			/**
			 * 1.增額
			 * 2.原發
			 * 3.合併
			 */
			if (i==1){
				sqljob.appendSQL(" AND  (b.voucher_date >= '"+reportDate+"') ");
				sqljob.appendSQL(" AND  (b.voucher_date <= '"+voucherDate+"') ");
			}

			if (i==2){
				sqljob.appendSQL(" AND  (b.voucher_date <= '"+voucherDate+"') ");
			}
			
			if (i==0){
				sqljob.appendSQL(" AND  (b.voucher_date <= '"+voucherDate+"') ");
			}
			//-----------
			
//			sqljob.appendSQL(" AND  (b.voucher_date <= '"+voucherDate+"') ");
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
//		System.out.println(sqljob.toString());
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
//		System.out.println("補上會計科目 ： " + sqljob.toString());
		return sqljob;
	}
	
//	protected SQLJob diffDebtCode(Integer issueId){
//		SQLJob sqljob = new SQLJob();
//		sqljob.appendSQL(" select debt_code as num from debt_main");
//		sqljob.appendSQL(" where issue_id in (select id from issue_main where source_issue_id in (select source_issue_id from issue_main where id="+issueId+"))");
//		System.out.println("非同預算別 ： " + sqljob.toString());
//		return sqljob;
//	}
	protected SQLJob getIssueDedtCode(Integer issueId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL(" select debt_code as num from debt_main");
		sqljob.appendSQL(" where issue_id = " + issueId);
		return sqljob;
	}
	protected SQLJob getSourceIssueDedtCode(Integer issueId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL(" select debt_code as num from debt_main");
		sqljob.appendSQL(" where issue_id in (select id from issue_main where source_issue_id in (select source_issue_id from issue_main where id = " + issueId + "))");
		return sqljob;
	}
	
	protected SQLJob sourceIssueId(Integer issueId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL(" select source_issue_id as sourceIssueId from issue_main where id="+issueId+"");
//		System.out.println("原發行 ： " + sqljob.toString());
		return sqljob;
	}
	
	protected SQLJob planFirstRepayDate(Integer issueId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL(" select min(repay_date) as repay_date from debt_plan_det where issue_id="+issueId+"");
//		System.out.println("同預算別，第一次付息前平衡表分開 ： " + sqljob.toString());
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
		// 查詢條件
		Timestamp today = new Timestamp( new Date().getTime() );
		voucherDate = df.format(calendar.getTime());
		
		String debtTypeCode  = (String)request.getSession().getAttribute("debtTypeCode");
		Integer  issueId     = CheckNullValue.checkNullPasueZero(myForm.getIssueId());	
		Integer  voucherType = CheckNullValue.checkNullPasueZero(myForm.getVoucherType());
		Integer debtId = myForm.getDebtId();
		if(debtId == null){
			debtId = new Integer(0);
		}
		DebtMain debtMain = new DebtManager().getBean(debtId);
		IssueMain issueMain = debtMain.getIssue();
		SQLRunner run = new ConnectionSQLRunner(connection);
		run.update(connection,delTemp(myForm,usrId));
		
		//判斷是否增額發行與原始發行預算別是否不同
		//20100929
//		SQLJob queryJob2 = getIssueDedtCode(issueId);
//		List queryList2 = (List) run.query(queryJob2, new MapListHandler());
		SQLJob queryJob5 = getIssueDedtCode(issueMain.getSourceIssueId());
		List queryList5 = (List) run.query(queryJob5, new MapListHandler());
		Integer diff=2;//預設預算別不同
		Date firstRepayDate = null;
//		Map mapQry2 = null;
//		if(null!=queryList2 && !queryList2.isEmpty()){
//			mapQry2 = (Map)queryList2.get(0);
			for(Iterator it5 = queryList5.iterator(); it5.hasNext();){
				Map mapQry5 = (Map)it5.next();
				if(debtMain.getDebtCode().equals(mapQry5.get("num")) && debtTypeCode.equals("A")){
//					System.out.println("相同預算別");
					diff = 1;
					SQLJob queryJob4 = planFirstRepayDate(issueId);
					List queryList4 = (List) run.query(queryJob4, new MapListHandler());
					for(Iterator it4=queryList4.iterator();it4.hasNext();){
						Map mapQry4 = (Map) it4.next();
						firstRepayDate = (Date) mapQry4.get("repay_date");
					}
				}
			}
//		}
//		//20100630
//		SQLJob queryJob2 = getIssueDedtCode(issueId);
//		List queryList2 = (List) run.query(queryJob2, new MapListHandler());
//		SQLJob queryJob5 = getSourceIssueDedtCode(issueId);
//		List queryList5 = (List) run.query(queryJob5, new MapListHandler());
//		Integer diff=2;//預設預算別不同
//		Date firstRepayDate = null;
//		for(Iterator it5 = queryList5.iterator(); it5.hasNext();){
//			Map mapQry5 = (Map)it5.next();
//			if((boolean)debtMain.getDebtCode().equals(mapQry5.get("num")) && debtTypeCode.equals("A")){
//				System.out.println("相同預算別");
//				diff = 1;
//				SQLJob queryJob4 = planFirstRepayDate(issueId);
//				List queryList4 = (List) run.query(queryJob4, new MapListHandler());
//				for(Iterator it4=queryList4.iterator();it4.hasNext();){
//					Map mapQry4 = (Map) it4.next();
//					firstRepayDate = (Date) mapQry4.get("repay_date");
//				}
//			}
//		}

//		SQLJob queryJob2 = diffDebtCode(issueId);
//		List queryList2 = (List) run.query(queryJob2, new MapListHandler());
//		Integer i = null;
//		Integer diff=null;
//		Date firstRepayDate = null;
//		for(Iterator it2=queryList2.iterator();it2.hasNext();){
//			Map mapQry3 = (Map) it2.next();
//			//0970709修改----
//			if ((boolean)mapQry3.get("num").equals(i) && debtTypeCode.equals("A")){
//			//0970709修改----
//				System.out.println("是否有不同預算別："+i);
//				diff = 1;
//				
//				//------------------------
//				
//				SQLJob queryJob4 = planFirstRepayDate(issueId);
//				List queryList4 = (List) run.query(queryJob4, new MapListHandler());
//				for(Iterator it5=queryList4.iterator();it5.hasNext();){
//					Map mapQry4 = (Map) it5.next();
//					firstRepayDate = (Date) mapQry4.get("repay_date");
//				}
//				
//				//------------------------
//			}else
//				diff = 2;
//				i = (Integer)mapQry3.get("num");		
//		}
		
		SQLJob queryJob3 = sourceIssueId(issueId);
		List queryList3 = (List) run.query(queryJob3, new MapListHandler());
		Integer sourceIssueId = null;
		for(Iterator it4=queryList3.iterator();it4.hasNext();){
			Map mapQry4 = (Map) it4.next();
			sourceIssueId = (Integer)mapQry4.get("sourceIssueId");
//			System.out.println("是否有不同預算別的issueID："+sourceIssueId);
		}
		
		
		
		//----
		SQLJob queryJob1;
		
		int changIntString = 0;
		String reportDate = "";
		reportDate = myForm.getAccountYear();			
		changIntString = Integer.parseInt(reportDate, 10);
		changIntString = changIntString+1911;
		Date nowDate = new Date(Integer.parseInt(myForm.getAccountYear())+11,Integer.parseInt(myForm.getMonth(),10)-1,30);

		
		int j = 0;
		//不同預算別各自拆開平衡表		
		if (!diff.equals(1) && !issueId.equals(sourceIssueId))
			queryJob1 = mainsql(myForm, voucherDate,sourceIssueId,issueId,voucherType,debtTypeCode,myForm.getIssueKind(),debtId, j);
		//同預算別的原發行及增額第一次付息前不合併平衡表
		else if (diff.equals(1) && !issueId.equals(sourceIssueId) && nowDate.before(firstRepayDate))
			queryJob1 = mainsql(myForm, voucherDate,sourceIssueId,issueId,voucherType,debtTypeCode,myForm.getIssueKind(),debtId, j+1);
		else if (diff.equals(1) && issueId.equals(sourceIssueId) && nowDate.before(firstRepayDate))
			queryJob1 = mainsql(myForm, voucherDate,sourceIssueId,issueId,voucherType,debtTypeCode,myForm.getIssueKind(),debtId, j+2);
		//跟原分發行合併平衡表
		else
			queryJob1 = mainsql(myForm, voucherDate,issueId,issueId,voucherType,debtTypeCode,myForm.getIssueKind(),debtId, j);

		
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
				//填入表頭
				if ("".equals(issueSerial) && ( !mapQry1.get("issue_serial").equals(null) ) ){
//				 System.out.println("有資料"); 
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
	    while(iterator.hasNext() || iterator2.hasNext()){
			if (iterator.hasNext()){
				debtor = (String)iterator.next();
				debitAmount = (BigDecimal)dMap.get(debtor);
			}else{
				debtor = "";
				debitAmount = new BigDecimal(0);
			}	
			if (iterator2.hasNext()){
				creditor = (String)iterator2.next();
				creditAmount = (BigDecimal)cMap.get(creditor);
			}else{
				creditor = "";
				creditAmount = new BigDecimal(0);
			}

			/**
			 * 085中央政府重大交通建設公債乙類第2期
			 * 因舊資料不正確，導致到期後，平衡表不正確無法修正
			 * 故在此寫死 公債基金存款－本金
			 */
			if(issueId == 3720 && "0".equals(myForm.getIssueKind()) && 
					("國庫應撥數－本金".equals(debtor) || "國庫應撥數－利息".equals(debtor))){
				if("國庫應撥數－本金".equals(debtor))
					run.update(connection,insertJob(budgetName,debitName,debtor,new BigDecimal("0"),creditor,new BigDecimal("0"),usrId,today));
				if("國庫應撥數－利息".equals(debtor))
					run.update(connection,insertJob(budgetName,debitName,debtor,new BigDecimal("0"),creditor,new BigDecimal("0"),usrId,today));
			}else if(issueId == 3720 && "1".equals(myForm.getIssueKind()) &&
					("國庫應撥數－本金".equals(debtor) || "國庫應撥數－利息".equals(debtor))){
				if("國庫應撥數－本金".equals(debtor))
					run.update(connection,insertJob(budgetName,debitName,debtor,new BigDecimal("0"),creditor,new BigDecimal("0"),usrId,today));
				if("國庫應撥數－利息".equals(debtor))
					run.update(connection,insertJob(budgetName,debitName,debtor,new BigDecimal("0"),creditor,new BigDecimal("0"),usrId,today));
			}else{
				run.update(connection,insertJob(budgetName,debitName,debtor,debitAmount,creditor,creditAmount,usrId,today));
			}
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

