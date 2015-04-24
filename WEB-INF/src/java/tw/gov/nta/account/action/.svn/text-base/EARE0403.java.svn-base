package tw.gov.nta.account.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.account.common.DebtAccountManager;

public class EARE0403 extends JacobReportAction
{
	@Override
	protected ReportManager getReportManager(ActionForm form, HttpServletRequest request) {
		return new ReportManager(getProgramId(request),getReportParameter(form, request),getRealPath());
	}

	@Override
	protected String getProgramId(HttpServletRequest request) {

		String DEBTTYPE = (String)request.getSession().getAttribute("debtTypeCode");
        if ("A".equals(DEBTTYPE)){
        	return "EARE04";
        }else{
        	return "EBRE02";
        }
	}		


	@Override
	protected Map<String,Object> getReportParameter(ActionForm form, HttpServletRequest request) {
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		String createDate = DateUtil.date2Str(new Date(),"yyyy/mm/dd");
		String voucherDate1= (String)request.getAttribute("voucherDate1");
		String voucherDate2= (String)request.getAttribute("voucherDate2");
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
    	map.put("Z2",voucherDate1.substring(0,3));
    	map.put("Z1",voucherDate2);
    	Integer voucherType = (Integer)request.getAttribute("voucherType");
    	if (voucherType.intValue()== 0 )
    		map.put("A5","");
    	else if (("D".equals(DEBTTYPE) || "C".equals(DEBTTYPE)) && voucherType.intValue()==DebtAccountManager.Sell ) {
    		map.put("A5","舉借類");
    	}else if("D".equals(DEBTTYPE) || "C".equals(DEBTTYPE)){
    		map.put("A5","償付類");
    	}else if (voucherType.intValue()==DebtAccountManager.Sell)
    		map.put("A5","經售類");
    	else
    		map.put("A5","經付類");
    	
    	return map;
	}
}