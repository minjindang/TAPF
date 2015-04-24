package tw.gov.nta.account.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;
import tw.gov.nta.sql.account.AccountRef;
import tw.gov.nta.sql.account.dao.AccountRefDAO;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.dao.IssueMainDAO;

public class EARD0203 extends JacobReportAction
{
	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request) {
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}

	@Override
	protected String getProgramId(HttpServletRequest request) {

		
		return "EARD02";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		AccountQueryForm myform = (AccountQueryForm)form;
		String createDate = DateUtil.date2Str(new Date(),"yyyy/mm/dd");
		String debtType = (String)request.getSession().getAttribute("debtTypeCode");
        System.out.print("DEBTTYP"+debtType);
		if ("A".equals(debtType)){
        	map.put("A2","公     債");
        }else if("B".equals(debtType)){
        	map.put("A2","國  庫  券");
        }else if("C".equals(debtType)){
        	map.put("A2","中長期借款");
        }else if("D".equals(debtType)){
        	map.put("A2","短期借款");
        } 
		AccountRefDAO dao = AccountRefDAO.getInstance();
		AccountRef account = dao.get(myform.getAccountId());
		map.put("H5",account.getAccountCode());
		map.put("H6",account.getAccountName());
    	map.put("A4","中華民國"+myform.getAccountYear()+"年"+myform.getMonth()+"月");    	
    	
    	if(myform.getIssueId()!=0) {
    		IssueMain issue = IssueMainDAO.getInstance().get(myform.getIssueId());
    		map.put("A6",issue.getDebtName());
    	}
        map.put("Z1",createDate);
		return map;
	}
}