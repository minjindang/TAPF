package tw.gov.nta.account.action;

import gov.dnt.tame.common.PageSize;
import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.ExcelReportAction;

import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import tw.gov.nta.sql.debt.DebtTypeRef;

public class EAMB0114 extends ExcelReportAction
{
	public final short DEFAULT_PAPERSIZE = PageSize.A4_PAPERSIZE;
	public final boolean LANDSCAPE = true;
	protected boolean isLANDSCAPE() {return LANDSCAPE;}
	protected short getDEFAULT_PAPERSIZE() {return DEFAULT_PAPERSIZE;}

	public String getJasperFileName() {
		return "EAMB01_RPT1.jasper";
	}

	@SuppressWarnings("unchecked")
	public Map getReportParameter(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, Connection connection) {
		StringBuffer sqlStr = new StringBuffer("");
		List<Integer> voucherIdList = (List<Integer>) request.getAttribute("voucherIdList");

		if( !voucherIdList.isEmpty() )
			sqlStr.append(" and b.id in ( ");

		for(Iterator it=voucherIdList.iterator();it.hasNext();)
		{
			Integer id = (Integer) it.next();
			if( it.hasNext() )
				sqlStr.append(id+",");
			else
				sqlStr.append(id);
		}

		if( !voucherIdList.isEmpty() )
			sqlStr.append(" ) ");

		Map<String,Object> parameters = new HashMap<String,Object>();
		parameters.put("sqlStr",sqlStr.toString());
		parameters.put("createDate",DateUtil.date2ChineseROC2(new Date()));
		DebtTypeRef debtType = (DebtTypeRef)request.getSession().getAttribute("debtType");
		String debtTypeName = "";
		if ("A".equals(debtType.getTypeCode().trim())) {
			debtTypeName = "公　　債";
		}else if("B".equals(debtType.getTypeCode().trim())) {
			debtTypeName = "國　庫　券";
		}else if("C".equals(debtType.getTypeCode().trim())) {
			debtTypeName = "中　長　期　借　款";
		}else if("D".equals(debtType.getTypeCode().trim())) {
			debtTypeName = "短　期　借　款";
		}
		
		parameters.put("debtType",debtTypeName);
		return parameters;
	}
}
