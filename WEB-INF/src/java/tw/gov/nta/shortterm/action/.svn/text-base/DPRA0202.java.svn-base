/**
 * @author Andrew Sung
 * @create 2006/4/14
 */

package tw.gov.nta.shortterm.action;

import gov.dnt.tame.util.DateUtil;
import gov.dnt.tame.util.JacobReportAction;
import gov.dnt.tame.util.ReportManager;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.shortterm.form.DpraReportForm;
import tw.gov.nta.sql.debt.IssueMain;

public class DPRA0202 extends JacobReportAction
{

	@Override
	protected ReportManager getReportManager(ActionForm form,
			HttpServletRequest request)
	{
		DpraReportForm myForm = (DpraReportForm)form;
		return new ReportManager(myForm.getTitle(),getReportParameter(form, request),getRealPath());
	}

	@Override
	protected String getProgramId(HttpServletRequest request)
	{
		return (String) request.getAttribute("title");
	}

	@Override
	protected Map getReportParameter(ActionForm form, HttpServletRequest request)
	{
		DpraReportForm myForm = (DpraReportForm)form;
		Map<String,String> map = new LinkedHashMap<String,String>();
		StringBuffer title = new StringBuffer();
		String createDate = DateUtil.date2Str(new Date(),"yyyy/MM/dd");
		IssueMain issueMain = new IssueManager().getBean(myForm.getIssueId());
		//map.put( position, value );
		if("DPRA02".equals(myForm.getTitle()))
		{
			map.put("I5",createDate);
			map.put("A2",issueMain.getAccountYear()+"年度第"+issueMain.getSerialNo()+"期短期借款還本付息明細表");
		}
		else if ("DPRA03".equals(myForm.getTitle()))
		{
			title.append(issueMain.getSerialNo());
			if("公".equals(title.substring(0,1)))
			{	
				title.insert(1,"第");
			}
			map.put("I5",createDate);
			map.put("A2",issueMain.getAccountYear()+"年度" + title.toString() + "期短期借款還本付息明細表");
			
		}
		else
		{
			map.put("I5",createDate);
			String serialNoBuffer = new StringBuffer(issueMain.getSerialNo()).insert(issueMain.getSerialNo().lastIndexOf("債")+1,"第").toString();
			//new StringBuffer(reValue).insert(reValue.lastIndexOf(",") - 1,"萬").toString();
			map.put("A2",issueMain.getAccountYear()+"年度"+serialNoBuffer+"期短期借款還本付息明細表");			
		}
		return map;
	}
}
