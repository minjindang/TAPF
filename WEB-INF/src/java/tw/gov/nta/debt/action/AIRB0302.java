/* AIRB0302.java 報表
 程式目的：AIRB03
 程式代號：AIRB03
 程式日期：0950316
 程式作者：icefire
 --------------------------------------------------------
 修改作者　　修改日期　　　修改目的
 --------------------------------------------------------
 */

package tw.gov.nta.debt.action;

import gov.dnt.tame.common.PageSize;
import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.ExcelReportAction;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import tw.gov.nta.account.form.BudgetCodeNameDecorator;
import tw.gov.nta.debt.form.Airb0301Form;
import tw.gov.nta.sql.BudgetRef;
import tw.gov.nta.sql.DebitRef;
import tw.gov.nta.sql.dao.BudgetRefDAO;
import tw.gov.nta.sql.dao.DebitRefDAO;

public class AIRB0302 extends ExcelReportAction {
	public final short DEFAULT_PAPERSIZE = PageSize.A3_PAPERSIZE;
	public final boolean LANDSCAPE = true;
	protected boolean isLANDSCAPE() {return LANDSCAPE;}
	protected short getDEFAULT_PAPERSIZE() {return DEFAULT_PAPERSIZE;}
	
	@Override
	public String getJasperFileName() {
		return "AIRB03_RPT1.jasper";
	}

	
	public static String budgetDebitName (String budget,String debt,String bondSellStatus,String kindStatus){
		String budgetName = "",debtName= "" ,end = "",bond = "" , kind = "";
		if (budget != null && !budget.equals("") && !budget.equals("0")){
			budgetName = tw.gov.nta.system.common.BudgetCodeManager.get(Integer.parseInt(budget)).getBudgetName();
		}
		if (debt != null && !debt.equals("") && !debt.equals("0")){
			debtName = tw.gov.nta.system.common.DebitCodeManage.get(Integer.parseInt(debt)).getDebitName();
		}
		if (kindStatus != null && !kindStatus.equals("") && !kindStatus.equals("0")){
			if(kindStatus.equals("Y"))
				kind = "可分割公債";
			else
				kind = "交換公債";
		}
		if (bondSellStatus != null && !bondSellStatus.equals("") && !bondSellStatus.equals("0") && bondSellStatus.equals("Y")){
			bond = "可分割公債";
		}
		if  ( !budgetName.equals("") && !debtName.equals("")  ){
			end = "("+budgetName+"/"+debtName+")";
		}else if( !budgetName.equals("") ){
			end = "("+budgetName+")";
		}else{
			end = "(總表)";
		}
		if  ( !bond.equals("") ){
			end += "(可分割公債)";
		}
		if(!kind.equals(""))
			end += "("+kind+")";
		return 	end;
	}
	
	
	
	
	
	@Override
	public Map getReportParameter(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			Connection connection) {
		// TODO Auto-generated method stub
		Airb0301Form myform = (Airb0301Form) form;
		Map<String,Object> parameters = new HashMap<String,Object>();
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得製表日期
		String createDate = DateUtil.date2ChineseROC2(DateUtil.date());
		//parameters.put("usrId",usrId);
		parameters.put("P2",createDate);
		//parameters.put("P1",myform.getrepayDate()+"年度");
		
		parameters.put("P3",AIRB0302.budgetDebitName(myform.getbudgetCode().toString()  ,myform.getDebtCode().toString() ,myform.getBondSellStatus(),null  ));
		
		
		String tmpS = myform.getrepay_SDate();
		String tmpE = myform.getrepay_EDate();
		parameters.put("P1","中華民國"+tmpS+"年度至"+tmpE+"年度止");
		//parameters.put("repaySdate",DateUtil.date2ChineseROC(myform.getRepaySdate()));
		return parameters;
	}
} 
