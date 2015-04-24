/* AIRB0902.java 報表
 程式目的：AIRB09
 程式代號：AIRB09
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

import tw.gov.nta.debt.form.Airb0901Form;

public class AIRB0902 extends ExcelReportAction {
	public final short DEFAULT_PAPERSIZE = PageSize.A3_PAPERSIZE;
	public final boolean LANDSCAPE = true;
	protected boolean isLANDSCAPE() {return LANDSCAPE;}
	protected short getDEFAULT_PAPERSIZE() {return DEFAULT_PAPERSIZE;}
	
	@Override
	public String getJasperFileName() {
		return "AIRB09_RPT1.jasper";
	}

	@Override
	public Map getReportParameter(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			Connection connection) {
		// TODO Auto-generated method stub
		Airb0901Form myform = (Airb0901Form) form;
		Map<String,Object> parameters = new HashMap<String,Object>();
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得製表日期
		String createDate = DateUtil.date2ChineseROC2(DateUtil.date());
		//parameters.put("usrId",usrId);
		parameters.put("P2",createDate);
		parameters.put("P1","中華民國"+myform.getRepaydate()+"年度");
//		String budName = "";
//		String debtName = "";
//		if (0 != myform.getBudgetCode())
//			budName = tw.gov.nta.system.common.BudgetCodeManager.get(myform.getBudgetCode()).getBudgetName();
//		if( 0 != myform.getDebtCode())
//			debtName = tw.gov.nta.system.common.DebitCodeManage.get(myform.getDebtCode()).getDebitName();
//		//都沒選擇
//		if ("".equals(budName) && "".equals(debtName))
//			parameters.put("P3","(總表)");
//		//兩個都選
//		else if (!"".equals(budName) && !"".equals(debtName))
//			parameters.put("P3","("+budName+"/"+debtName+")");
//		//選其中一個
//		else
//			parameters.put("P3","("+budName+debtName+")");
		parameters.put("P3",AIRB0302.budgetDebitName(myform.getBudgetCode().toString()  ,myform.getDebtCode().toString(),null ,myform.getKind() ));
		
		//parameters.put("repayEdate",DateUtil.date2ChineseROC(myform.getRepayEdate()));
		//parameters.put("repaySdate",DateUtil.date2ChineseROC(myform.getRepaySdate()));
		return parameters;
	}
}
