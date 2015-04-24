package tw.gov.nta.account.action;

import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.AccountQueryForm;
import tw.gov.nta.debt.account.common.DebtAccountManager;

public class ECRE0603 extends JacobReportAction
{
	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request) {
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}

	@Override
	protected String getProgramId(HttpServletRequest request) {

		String DEBTTYPE = (String)request.getSession().getAttribute("debtTypeCode");
        if ("A".equals(DEBTTYPE)){
    		return "ECRE06";
        }else{
        	return "ECRE06";
        }

	}

	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		AccountQueryForm myform = (AccountQueryForm)form;
		String issueSerial= (String)request.getAttribute("issueSerial");
		String budgetName= (String)request.getAttribute("budgetName");
		String debitName= (String)request.getAttribute("debitName");
		String debt_name= (String)request.getAttribute("debt_name");
		String voucherDate1= (String)request.getAttribute("voucherDate1");
		String voucherDate2= (String)request.getAttribute("voucherDate2");
		//Date voucherDate= (Date)request.getAttribute("voucherDate");
		//map.put( position, value );
		String DEBTTYPE = (String)request.getSession().getAttribute("debtTypeCode");
        if ("A".equals(DEBTTYPE)){
        	map.put("A2","公     債");
        }else if("B".equals(DEBTTYPE)){
        	map.put("A2","國  庫  券");
        }else if("C".equals(DEBTTYPE)){
        	map.put("A2","中  長  借");
        }else if("D".equals(DEBTTYPE)){
        	map.put("A2","短  期  借  款");
        } 
        
        if("A".equals(DEBTTYPE)){
        	String issueKindName = "";
        	if(myform.getIssueKind().equals("1")){
        		issueKindName = "債票形式";
        	}else{
        		issueKindName = "登錄形式";
        	}
        	map.put("A3","平　　衡　　表("+issueKindName+")");
        }
        if(!"C".equals(DEBTTYPE)){
	    	map.put("A5","預算別："+budgetName);
	        map.put("A6","債務別："+debitName);
        }
    	Integer voucherType = (Integer)request.getAttribute("voucherType");
    	if (voucherType.intValue()== 0)
    		map.put("A7","");
    	else if ( ("D".equals(DEBTTYPE) || "C".equals(DEBTTYPE))  &&  
    			(voucherType.intValue()==DebtAccountManager.Pay || 
    			 voucherType.intValue()==DebtAccountManager.Charge ||
    			  voucherType.intValue()==DebtAccountManager.PayCharge)){
    		map.put("A7","償付類期別："+issueSerial+ " "+debt_name);
    	}else if (("D".equals(DEBTTYPE) || "C".equals(DEBTTYPE))){
    		map.put("A7","舉借類期別："+issueSerial+ " "+debt_name);
    	}else if (voucherType.intValue()==DebtAccountManager.Pay || voucherType.intValue()==DebtAccountManager.Charge)
    		map.put("A7","經付類期別："+issueSerial+ " "+debt_name);
    	else
    		map.put("A7","經售類期別："+issueSerial+ " "+debt_name);
    	
        map.put("Z2",voucherDate1.substring(0,3));
        map.put("Z1",voucherDate2);
		return map;
	}
}