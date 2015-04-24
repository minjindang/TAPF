package tw.gov.nta.debt.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.form.Apra0101Form;
import tw.gov.nta.system.common.BudgetCodeManager;
import tw.gov.nta.system.common.DebitCodeManage;

public class APRA0106 extends JacobReportAction {

	@Override
	protected String getProgramId(HttpServletRequest request) {
		return "APRA01C";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		// TODO Auto-generated method stub
		Apra0101Form myform = (Apra0101Form) form;
		String debitName = "�`��";
		String budgetName = "�`��";
		Map<String,Object> map = new HashMap<String,Object>();
		//String usrId = this.getUserId(request);
		String createDate = DateUtil.date2ChineseROC2(new Date());
		if(myform.getBudgetCode()!=null && !myform.getBudgetCode().equals("")){
			budgetName = BudgetCodeManager.get(Integer.parseInt(myform.getBudgetCode())).getBudgetName();
		}
		if(myform.getDebtCode()!=null && !myform.getDebtCode().equals("")){
			debitName = DebitCodeManage.get(Integer.parseInt(myform.getDebtCode())).getDebitName();
		}
//		map.put("A1","��  ��  ��  ��  ��  ��  ��  ��  ��  ��  ��  - "+budgetName);
		map.put("A2","���إ���"+DateUtil.date2ChineseROC2(myform.getRepaySdate()) +"��"+DateUtil.date2ChineseROC2(myform.getRepayEdate()));
		map.put("G4","�s�����G"+createDate);
		map.put("A6","���ŧO�G"+debitName);
		return map;
	}
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request)
	{
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}

}


///* APRA0102.java ����
// �{���ت��GAPRA01
// �{���N���GAPRA01
// �{������G0950308
// �{���@�̡GEric.Chen
// --------------------------------------------------------
// �ק�@�̡@�@�ק����@�@�@�ק�ت�
// --------------------------------------------------------
// */
//package tw.gov.nta.debt.action;
//
//import gov.dnt.tame.common.PageSize;
//import gov.dnt.tame.util.DateUtil;
//import gov.dnt.tame.util.ExcelReportAction;
//import java.util.Map;
//import org.apache.commons.dbutils.handlers.MapHandler;
//import java.sql.Connection;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.struts.action.ActionForm;
//import org.apache.struts.action.ActionMapping;
//
//import com.kangdainfo.ast.sql.ConnectionSQLRunner;
//import com.kangdainfo.ast.sql.SQLJob;
//import com.kangdainfo.ast.sql.SQLRunner;
//
//import tw.gov.nta.debt.form.Apra0101Form;
//
//public class APRA0102 extends ExcelReportAction {
//	public final short DEFAULT_PAPERSIZE = PageSize.A3_PAPERSIZE;
//	public final boolean LANDSCAPE = true;
//	protected boolean isLANDSCAPE() {return LANDSCAPE;}
//	protected short getDEFAULT_PAPERSIZE() {return DEFAULT_PAPERSIZE;}
//
//	@Override
//	public String getJasperFileName() {
//		return "APRA01_RPT1.jasper";
//	}
//
//	@Override
//	public Map getReportParameter(ActionMapping mapping, ActionForm form,
//			HttpServletRequest request, HttpServletResponse response,
//			Connection connection) 
//	{
//		// TODO Auto-generated method stub
//		Apra0101Form myform = (Apra0101Form) form;
//		String debtName = "�`��";
//		
//		Map<String,Object> parameters = new HashMap<String,Object>();
//		//���o�ϥΪ̱b��
//		String usrId = this.getUserId(request);
//		//���o�w��O/�ŰȧO
//		SQLJob job = new SQLJob();
//		SQLRunner run = new ConnectionSQLRunner(connection);
//		
//		
//		//�w��O
//		job.appendSQL("SELECT (SELECT B.BUDGET_NAME  FROM BUDGET_REF B WHERE B.ID = ? ) AS BUDGET_NAME , ");
//		job.appendSQL("(SELECT D.DEBIT_NAME FROM  DEBIT_REF D WHERE D.ID = ?) AS DEBIT_NAME  ");
//		job.addParameter(myform.getBudgetCode());
//		job.addParameter(myform.getDebtCode());
//		try
//		{
//			Map map = (Map)run.query(job , new MapHandler());
//			if((String)map.get("BUDGET_NAME") != null)
//			{
//				debtName = (String)map.get("BUDGET_NAME");
//				if((String)map.get("DEBIT_NAME") !=null)
//				{
//					debtName = debtName + "/" + (String)map.get("DEBIT_NAME");
//				}
//			}
//		}catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		
//		job.appendSQL("");
//		job.appendSQL("");
//		job.appendSQL("");
//		
//		
//		//���o�s����
//		String createDate = DateUtil.date2ChineseROC2(DateUtil.date());
//		parameters.put("usrId",usrId);
//		parameters.put("createDate",createDate);
//		parameters.put("repayEdate",DateUtil.date2ChineseROC2(myform.getRepayEdate()));
//		parameters.put("repaySdate",DateUtil.date2ChineseROC2(myform.getRepaySdate()));
//		parameters.put("budgetCode",myform.getBudgetCode());
//		parameters.put("debtName",debtName);
//		return parameters;
//	}
//
//
//}
