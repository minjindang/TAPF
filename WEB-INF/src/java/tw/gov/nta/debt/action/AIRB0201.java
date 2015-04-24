/* AIRB0201.java 報表
 程式目的：AIRB02
 程式代號：AIRB02
 程式日期：0950316
 程式作者：icefire
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
 --------------------------------------------------------
 */
package tw.gov.nta.debt.action;

import gov.dnt.tame.common.DefaultAction;

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

import tw.gov.nta.debt.form.Airb0201Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class AIRB0201 extends DefaultAction {

	protected SQLJob delTemp(ActionForm form,String usrId){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("DELETE FROM AIRB02_RPT ");
		System.out.println(sqljob.toString());
		return sqljob;
	}

  protected SQLJob updTemp(ActionForm form,String usrId){
  	SQLJob sqljob = new SQLJob();
  	sqljob.appendSQL("UPDATE AIRB02_RPT ");
  	sqljob.appendSQL("SET TOTAL_AMOUNT=CAPITAL_SUB_AMOUNT+INTEREST_SUB_AMOUNT ");
	System.out.println(sqljob.toString());
	return sqljob;
  }

  protected SQLJob insTemp(ActionForm form,String usrId,int tmp_year,Map map){
		Airb0201Form AIRB0201form = (Airb0201Form) form;
		String str_year = "";
		String str1_year = "";
		System.out.println(tmp_year);
		if (tmp_year<100)
		{
		     str_year = "0"+Integer.toString(tmp_year);
		     str1_year = Integer.toString(tmp_year+1911);
		}
		else
		{
			str_year = Integer.toString(tmp_year);  
			str1_year = Integer.toString(tmp_year+1911);
		}
			
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("INSERT INTO AIRB02_RPT ");
		sqljob.appendSQL(" ( ");
		sqljob.appendSQL(" USRID, MOD_DATE, REMARK,");
		sqljob.appendSQL(" ACCOUNT_YEAR,BOND_KIND, ");
		sqljob.appendSQL(" CAPITAL_AA_AMOUNT,CAPITAL_BA_AMOUNT, ");
		sqljob.appendSQL(" CAPITAL_BB_AMOUNT,CAPITAL_CA_AMOUNT, ");
		sqljob.appendSQL(" CAPITAL_CB_AMOUNT,CAPITAL_SUB_AMOUNT, ");
		sqljob.appendSQL(" INTEREST_AA_AMOUNT,INTEREST_BA_AMOUNT, ");
		sqljob.appendSQL(" INTEREST_BB_AMOUNT,INTEREST_CA_AMOUNT, ");
		sqljob.appendSQL(" INTEREST_CB_AMOUNT,INTEREST_SUB_AMOUNT, ");
		sqljob.appendSQL(" TOTAL_AMOUNT) ");	
		sqljob.appendSQL(" VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		sqljob.addParameter(usrId);
		sqljob.addParameter(new Date());
		sqljob.addParameter(new String());
		sqljob.addParameter(str_year);
		sqljob.addParameter((String)map.get("BOND_KIND"));
		sqljob.addParameter((BigDecimal)map.get("CAPITAL_AA_AMOUNT"));
		sqljob.addParameter((BigDecimal)map.get("CAPITAL_BA_AMOUNT"));
		sqljob.addParameter((BigDecimal)map.get("CAPITAL_BB_AMOUNT"));
		sqljob.addParameter((BigDecimal)map.get("CAPITAL_CA_AMOUNT"));
		sqljob.addParameter((BigDecimal)map.get("CAPITAL_CB_AMOUNT"));
		sqljob.addParameter((BigDecimal)map.get("CAPITAL_SUB_AMOUNT"));
		sqljob.addParameter((BigDecimal)map.get("INTEREST_AA_AMOUNT"));
		sqljob.addParameter((BigDecimal)map.get("INTEREST_BA_AMOUNT"));
		sqljob.addParameter((BigDecimal)map.get("INTEREST_BB_AMOUNT"));
		sqljob.addParameter((BigDecimal)map.get("INTEREST_CA_AMOUNT"));
		sqljob.addParameter((BigDecimal)map.get("INTEREST_CB_AMOUNT"));
		sqljob.addParameter((BigDecimal)map.get("INTEREST_SUB_AMOUNT"));
		sqljob.addParameter((BigDecimal)map.get("TOTAL_AMOUNT"));
		
		System.out.println(sqljob.toString());
		return sqljob;
	}
  	public SQLJob getCapital(Airb0201Form form,int year ,int bondKind)
  	{
  		SQLJob sqljob = new SQLJob();
  		sqljob.appendSQL("SELECT ");
  		sqljob.appendSQL((0==bondKind?"'原始'":"'增額'"));
  		sqljob.appendSQL("AS BOND_KIND,");
  		sqljob.appendSQL("isnull(sum(case when B.budget_code=1 and A.bond_type='1' then C.capital_amount else 0 end)/1000,0) AS CAPITAL_AA_AMOUNT , ");   
  		sqljob.appendSQL("isnull(sum(case when B.budget_code=2 and A.bond_type='1' then C.capital_amount else 0 end)/1000,0) AS CAPITAL_BA_AMOUNT , ");   
  		sqljob.appendSQL("isnull(sum(case when B.budget_code=2 and A.bond_type='2' then C.capital_amount else 0 end)/1000,0) AS CAPITAL_BB_AMOUNT , ");   
  		sqljob.appendSQL("isnull(sum(case when B.budget_code=3 then C.capital_amount else 0 end)/1000,0) AS CAPITAL_CA_AMOUNT , ");   
  		sqljob.appendSQL("isnull(sum(case when B.debt_code=47 then C.capital_amount else 0 end)/1000,0) AS CAPITAL_CB_AMOUNT ");   
  		sqljob.appendSQL("FROM issue_main A, debt_main B, debt_plan_det C "); 
  		if(88 >= year)
  		{
  			sqljob.appendSQL("WHERE (C.REPAY_DATE > ? AND C.REPAY_DATE <= ?) ");   
  			sqljob.addParameter(Integer.toString(year+1911-1)+"/07/01");
  			sqljob.addParameter(Integer.toString(year+1911)+"/07/01");
  		}
  		else if(89 == year)
  		{
  			sqljob.appendSQL("WHERE (C.REPAY_DATE > ? AND C.REPAY_DATE <= ?) ");
  			sqljob.addParameter(Integer.toString(year+1911-1)+"/07/01");
  			sqljob.addParameter(Integer.toString(year+1911)+"/12/31");
  		}
  		else
  		{
  			sqljob.appendSQL("WHERE (C.REPAY_DATE > ? AND C.REPAY_DATE <= ?) ");
  			sqljob.addParameter(Integer.toString(year+1911)+"/01/01");
  			sqljob.addParameter(Integer.toString(year+1911+1)+"/01/01");
  		}	
  		sqljob.appendSQL("and A.debt_type='A' ");   
  		sqljob.appendSQL("and A.id=B.issue_id ");   
  		sqljob.appendSQL("and B.id=C.debt_id ");   
  		sqljob.appendSQL("and c.delete_mark='N' ");   
  		
  		sqljob.appendSQL("and a.bond_kind = ? ");
  		sqljob.addParameter((0==bondKind?"1":"3"));
  		
  		if(null != form.getIssue_SDate())
  		{
  			sqljob.appendSQL("and A.issue_date >= ? ");
  			sqljob.addParameter(form.getIssue_SDate());
  		}	
  		if(null != form.getIssue_EDate())
  		{
  			sqljob.appendSQL("and A.issue_date <= ? ");
  			sqljob.addParameter(form.getIssue_EDate());
  		}
		if(form.getBondSellStatus().equals("Y")){
			sqljob.appendSQL(" AND A.BOND_SELL_STATUS='Y' ");
		}
		if(form.getBondSellStatus().equals("4")){
			sqljob.appendSQL(" AND A.BOND_KIND='4' ");
		}
		sqljob.appendSQL(" GROUP BY a.bond_kind ");
  		System.out.println(sqljob);
  		return sqljob;
  	}
  	public SQLJob getInterest(Airb0201Form form,int year,int bondKind)
  	{
  		SQLJob sqljob = new SQLJob();
  		sqljob.appendSQL("SELECT "); 
  		sqljob.appendSQL((0==bondKind?"'原始'":"'增額'"));
  		sqljob.appendSQL("AS BOND_KIND,");
  		sqljob.appendSQL("isnull(sum(case when B.budget_code=1 and A.bond_type='1' then C.interest_amount else 0 end)/1000,0) AS INTEREST_AA_AMOUNT , "); 
  		sqljob.appendSQL("isnull(sum(case when B.budget_code=2 and A.bond_type='1' then C.interest_amount else 0 end)/1000,0) AS INTEREST_BA_AMOUNT, "); 
  		sqljob.appendSQL("isnull(sum(case when B.budget_code=2 and A.bond_type='2' then C.interest_amount else 0 end)/1000,0) AS INTEREST_BB_AMOUNT, "); 
  		sqljob.appendSQL("isnull(sum(case when B.budget_code=3 then C.interest_amount else 0 end)/1000,0) AS INTEREST_CA_AMOUNT, "); 
  		sqljob.appendSQL("isnull(sum(case when B.debt_code=47 then C.interest_amount else 0 end)/1000,0) AS INTEREST_CB_AMOUNT "); 
  		sqljob.appendSQL("FROM issue_main A, debt_main B, debt_plan_det C "); 
  		if(88 >= year)
  		{
  			sqljob.appendSQL("WHERE (C.REPAY_DATE > ? AND C.REPAY_DATE <= ?) ");   
  			sqljob.addParameter(Integer.toString(year+1911-1)+"/07/01");
  			sqljob.addParameter(Integer.toString(year+1911)+"/07/01");
  		}
  		else if(89 == year)
  		{
  			sqljob.appendSQL("WHERE (C.REPAY_DATE > ? AND C.REPAY_DATE <= ?) ");
  			sqljob.addParameter(Integer.toString(year+1911-1)+"/07/01");
  			sqljob.addParameter(Integer.toString(year+1911)+"/12/31");
  		}
  		else
  		{
  			sqljob.appendSQL("WHERE (C.REPAY_DATE > ? AND C.REPAY_DATE <= ?) ");
  			sqljob.addParameter(Integer.toString(year+1911)+"/01/01");
  			sqljob.addParameter(Integer.toString(year+1911+1)+"/01/01");
  		}	
  		sqljob.appendSQL("and A.debt_type='A' "); 
  		sqljob.appendSQL("and A.id=B.issue_id "); 
  		sqljob.appendSQL("and B.id=C.debt_id "); 
  		sqljob.appendSQL("and c.delete_mark='N' "); 
  		
  		sqljob.appendSQL("and a.bond_kind = ? ");
  		sqljob.addParameter((0==bondKind?"1":"3"));
  		
  		if(null != form.getIssue_SDate())
  		{
  			sqljob.appendSQL("and A.issue_date >= ? ");
  			sqljob.addParameter(form.getIssue_SDate());
  		}	
  		if(null != form.getIssue_EDate())
  		{
  			sqljob.appendSQL("and A.issue_date <= ? ");
  			sqljob.addParameter(form.getIssue_EDate());
  		}
		if(form.getBondSellStatus().equals("Y")){
			sqljob.appendSQL(" AND A.BOND_SELL_STATUS='Y' ");
		}
		if(form.getBondSellStatus().equals("4")){
			sqljob.appendSQL(" AND A.BOND_KIND='4' ");
		}
		sqljob.appendSQL(" GROUP BY a.bond_kind ");
  		System.out.println(sqljob);
  		return sqljob;
  		
  	}

	//提前買回
	protected SQLJob sqlPayment(int year, int bondKind){
		SQLJob sqljob = new SQLJob();
		
		sqljob.appendSQL("select ");
		sqljob.appendSQL("isnull(sum(case when d.budget_code=1 and i.bond_type='1' then p.capital_amount else 0 end)/1000,0) as CAPITAL_AA_AMOUNT,");
		sqljob.appendSQL("isnull(sum(case when d.budget_code=2 and i.bond_type='1' then p.capital_amount else 0 end)/1000,0) as CAPITAL_BA_AMOUNT,");
		sqljob.appendSQL("isnull(sum(case when d.budget_code=2 and i.bond_type='2' then p.capital_amount else 0 end)/1000,0) as CAPITAL_BB_AMOUNT,");
		sqljob.appendSQL("isnull(sum(case when d.budget_code=3 then p.capital_amount else 0 end)/1000,0) as CAPITAL_CA_AMOUNT,");
		sqljob.appendSQL("isnull(sum(case when d.debt_code=47 then p.capital_amount else 0 end)/1000,0) as CAPITAL_CB_AMOUNT,");
		sqljob.appendSQL("isnull(sum(case when d.budget_code=1 and i.bond_type='1' then p.interest_amount else 0 end)/1000,0) as INTEREST_AA_AMOUNT,");
		sqljob.appendSQL("isnull(sum(case when d.budget_code=2 and i.bond_type='1' then p.interest_amount else 0 end)/1000,0) as INTEREST_BA_AMOUNT,");
		sqljob.appendSQL("isnull(sum(case when d.budget_code=2 and i.bond_type='2' then p.interest_amount else 0 end)/1000,0) as INTEREST_BB_AMOUNT,");
		sqljob.appendSQL("isnull(sum(case when d.budget_code=3 then p.interest_amount else 0 end)/1000,0) as INTEREST_CA_AMOUNT,");
		sqljob.appendSQL("isnull(sum(case when d.debt_code=47 then p.interest_amount else 0 end)/1000,0) as INTEREST_CB_AMOUNT");
		sqljob.appendSQL("from issue_main i, payment_main p, debt_main d ");
		sqljob.appendSQL("where 1=1 ");
		sqljob.appendSQL("and i.debt_type = 'A' ");
		sqljob.appendSQL("and i.id = p.issue_id ");
		sqljob.appendSQL("and i.id = d.issue_id ");
		sqljob.appendSQL("and p.debt_id = d.id ");
		sqljob.appendSQL("and p.REPAY_DATE <> p.PLAN_REPAY_DATE ");
		sqljob.appendSQL("and p.CAPITAL_AMOUNT > 0 ");
		sqljob.appendSQL("and 'Y' <> (select d.delete_mark from debt_plan_det d where d.id = plan_id) ");
		sqljob.appendSQL("and p.repay_date >= ? and p.repay_date <= ?");
		sqljob.appendSQL("and i.bond_kind = ?");

		sqljob.addParameter(Integer.toString(year+1911)+"/01/01");
		sqljob.addParameter(Integer.toString(year+1911+1)+"/01/01");
  		sqljob.addParameter((0==bondKind?"1":"3"));
		
		System.out.println(sqljob.toString());
		return sqljob;
	}
	
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {

		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner
		SQLRunner run = new ConnectionSQLRunner(connection);
		//執行 delete 
		run.update(connection,delTemp(form,usrId));
		//執行 insert
		Airb0201Form tmpform = (Airb0201Form) form;
		System.out.println("#1"+tmpform.getRepay_SDate());
		System.out.println("#2"+tmpform.getRepay_EDate());
		int sii = Integer.parseInt(tmpform.getRepay_SDate());
		int eii = Integer.parseInt(tmpform.getRepay_EDate());
		System.out.println(sii);
		System.out.println(eii);
		
		BigDecimal interestAAamount = new BigDecimal(0);
		BigDecimal interestBAamount = new BigDecimal(0);
		BigDecimal interestBBamount = new BigDecimal(0);
		BigDecimal interestCAamount = new BigDecimal(0);
		BigDecimal interestCBamount = new BigDecimal(0);
		BigDecimal subInterestAmount = new BigDecimal(0);
		
		BigDecimal capitalAAamount = new BigDecimal(0);
		BigDecimal capitalBAamount = new BigDecimal(0);
		BigDecimal capitalBBamount = new BigDecimal(0);
		BigDecimal capitalCAamount = new BigDecimal(0);
		BigDecimal capitalCBamount = new BigDecimal(0);
		BigDecimal subCapitalAmount = new BigDecimal(0);
		
		Map tempMap = new HashMap<String,Object>();
		tempMap.put("CAPITAL_AA_AMOUNT",new BigDecimal(0));
		tempMap.put("CAPITAL_BA_AMOUNT",new BigDecimal(0));
		tempMap.put("CAPITAL_BB_AMOUNT",new BigDecimal(0));
		tempMap.put("CAPITAL_CA_AMOUNT",new BigDecimal(0));
		tempMap.put("CAPITAL_CB_AMOUNT",new BigDecimal(0));
		tempMap.put("CAPITAL_SUB_AMOUNT",new BigDecimal(0));
		tempMap.put("INTEREST_AA_AMOUNT",new BigDecimal(0));
		tempMap.put("INTEREST_BA_AMOUNT",new BigDecimal(0));
		tempMap.put("INTEREST_BB_AMOUNT",new BigDecimal(0));
		tempMap.put("INTEREST_CA_AMOUNT",new BigDecimal(0));
		tempMap.put("INTEREST_CB_AMOUNT",new BigDecimal(0));
		tempMap.put("INTEREST_SUB_AMOUNT",new BigDecimal(0));
		
		
		for (int ii=sii;ii<=eii;ii++)
		{
			for(int bondKind=0;bondKind<2;bondKind++)
			{	
			   List capitalList = (List) run.query(getCapital(tmpform,ii,bondKind), new MapListHandler());
			   List interestList = (List) run.query(getInterest(tmpform,ii,bondKind), new MapListHandler());
			   List listPayment = (List)run.query(sqlPayment(ii,bondKind),new MapListHandler());
			   if(null != listPayment && !listPayment.isEmpty()){
					interestAAamount = new BigDecimal(0);
					interestBAamount = new BigDecimal(0);
					interestBBamount = new BigDecimal(0);
					interestCAamount = new BigDecimal(0);
					interestCBamount = new BigDecimal(0);
					capitalAAamount = new BigDecimal(0);
					capitalBAamount = new BigDecimal(0);
					capitalBBamount = new BigDecimal(0);
					capitalCAamount = new BigDecimal(0);
					capitalCBamount = new BigDecimal(0);
					for(Iterator itPayment = listPayment.iterator();itPayment.hasNext();){
						Map mapPayment = (Map)itPayment.next();
						capitalAAamount = capitalAAamount.subtract((BigDecimal)mapPayment.get("CAPITAL_AA_AMOUNT"));
						capitalBAamount = capitalBAamount.subtract((BigDecimal)mapPayment.get("CAPITAL_BA_AMOUNT"));
						capitalBBamount = capitalBBamount.subtract((BigDecimal)mapPayment.get("CAPITAL_BB_AMOUNT"));
						capitalCAamount = capitalCAamount.subtract((BigDecimal)mapPayment.get("CAPITAL_CA_AMOUNT"));
						capitalCBamount = capitalCBamount.subtract((BigDecimal)mapPayment.get("CAPITAL_CB_AMOUNT"));
						interestAAamount = interestAAamount.subtract((BigDecimal)mapPayment.get("INTEREST_AA_AMOUNT"));
						interestBAamount = interestBAamount.subtract((BigDecimal)mapPayment.get("INTEREST_BA_AMOUNT"));
						interestBBamount = interestBBamount.subtract((BigDecimal)mapPayment.get("INTEREST_BB_AMOUNT"));
						interestCAamount = interestCAamount.subtract((BigDecimal)mapPayment.get("INTEREST_CA_AMOUNT"));
						interestCBamount = interestCBamount.subtract((BigDecimal)mapPayment.get("INTEREST_CB_AMOUNT"));
					}				   
			   }
			   
			   if(null == capitalList || 0 == capitalList.size())
			   {
				   tempMap.put("BOND_KIND",(0==bondKind?"原始":"增額"));
				   capitalList.add(tempMap);
			   }
			   
			   if(null == interestList || 0 == interestList.size())
			   {
				   tempMap.put("BOND_KIND",(0==bondKind?"原始":"增額"));
				   interestList.add(tempMap);
			   } 
			   
			   if(null != capitalList && 0 != capitalList.size())
			   {
				   for(Iterator capital=capitalList.iterator();capital.hasNext();)
				   {   
					   Map capitalMap = (Map)capital.next();
					   if(null != interestList && 0 != interestList.size())
					   {	   
						   	Iterator interest = interestList.iterator();
						   	if(interest.hasNext())
						   	{	
					   			Map interestMap = (Map)interest.next();
					   			
					   			interestAAamount = interestAAamount.add((BigDecimal)interestMap.get("INTEREST_AA_AMOUNT"));
					   			interestBAamount = interestBAamount.add((BigDecimal)interestMap.get("INTEREST_BA_AMOUNT"));
					   			interestBBamount = interestBBamount.add((BigDecimal)interestMap.get("INTEREST_BB_AMOUNT"));
					   			interestCAamount = interestCAamount.add((BigDecimal)interestMap.get("INTEREST_CA_AMOUNT"));
					   			interestCBamount = interestCBamount.add((BigDecimal)interestMap.get("INTEREST_CB_AMOUNT"));
					   			
					   			subInterestAmount = interestAAamount.add(interestBAamount.add(interestBBamount.add(interestCAamount.add(interestCBamount))));
					   			
					   			capitalMap.put("INTEREST_AA_AMOUNT",interestAAamount);
					   			capitalMap.put("INTEREST_BA_AMOUNT",interestBAamount);
					   			capitalMap.put("INTEREST_BB_AMOUNT",interestBBamount);
					   			capitalMap.put("INTEREST_CA_AMOUNT",interestCAamount);
					   			capitalMap.put("INTEREST_CB_AMOUNT",interestCBamount);
					   			capitalMap.put("INTEREST_SUB_AMOUNT",subInterestAmount);
					   			
					   			
					   			capitalAAamount = capitalAAamount.add((BigDecimal)capitalMap.get("CAPITAL_AA_AMOUNT"));
					   			capitalBAamount = capitalBAamount.add((BigDecimal)capitalMap.get("CAPITAL_BA_AMOUNT"));
					   			capitalBBamount = capitalBBamount.add((BigDecimal)capitalMap.get("CAPITAL_BB_AMOUNT"));
					   			capitalCAamount = capitalCAamount.add((BigDecimal)capitalMap.get("CAPITAL_CA_AMOUNT"));
					   			capitalCBamount = capitalCBamount.add((BigDecimal)capitalMap.get("CAPITAL_CB_AMOUNT"));
					   		
					   			subCapitalAmount = capitalAAamount.add(capitalBAamount.add(capitalBBamount.add(capitalCAamount.add(capitalCBamount))));

					   			capitalMap.put("CAPITAL_AA_AMOUNT",capitalAAamount);
					   			capitalMap.put("CAPITAL_BA_AMOUNT",capitalBAamount);
					   			capitalMap.put("CAPITAL_BB_AMOUNT",capitalBBamount);
					   			capitalMap.put("CAPITAL_CA_AMOUNT",capitalCAamount);
					   			capitalMap.put("CAPITAL_CB_AMOUNT",capitalCBamount);
					   			capitalMap.put("CAPITAL_SUB_AMOUNT",subCapitalAmount);
					   			
					   			capitalMap.put("TOTAL_AMOUNT",subCapitalAmount.add(subInterestAmount));
						   	}	
					   }
					   run.update(connection,insTemp(form,usrId,ii,capitalMap));
				   }	   
			   }
		   }	    
		}  
		//run.update(connection,updTemp(form,usrId));
	}


}
