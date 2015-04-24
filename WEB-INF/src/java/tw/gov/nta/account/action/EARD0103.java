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

public class EARD0103 extends JacobReportAction
{
	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request) {
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}

	@Override
	protected String getProgramId(HttpServletRequest request) {

		
		return "EARD01";
	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		AccountQueryForm myform = (AccountQueryForm)form;
		String createDate = DateUtil.date2Str(new Date(),"yyyy/mm/dd");
		String debtTypeCode = (String)request.getSession().getAttribute("debtTypeCode");
        System.out.print("DEBTTYP"+debtTypeCode);
		if ("A".equals(debtTypeCode)){
        	map.put("A2","��     ��");
        }else if("B".equals(debtTypeCode)){
        	map.put("A2","��  �w  ��");
        }else if("C".equals(debtTypeCode)){
        	map.put("A2","�������ɴ�");
        }else if("D".equals(debtTypeCode)){
        	map.put("A2","�u���ɴ�");
        } 
		
		AccountRefDAO dao = AccountRefDAO.getInstance();
		AccountRef account = dao.get(myform.getAccountId());
		map.put("G5",account.getAccountCode());
		map.put("G6",account.getAccountName());
    	map.put("A4","���إ���"+myform.getAccountYear()+"�~"+myform.getMonth()+"��");    	
    	
    	if(myform.getIssueId()!=0) {
    		IssueMain issue = IssueMainDAO.getInstance().get(myform.getIssueId());
    		map.put("A7",issue.getDebtName());
    	}else {
    		map.put("A7","�J�`�U��");
    	}
    	map.put("Z1",createDate);
		return map;
	}
}