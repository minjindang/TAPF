/**
 * @author AndrewSung
 * @date 2006/3/9
 */
package tw.gov.nta.shortterm.action;

import gov.dnt.tame.common.DefaultAction;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import tw.gov.nta.debt.common.DebtManager;
import tw.gov.nta.debt.common.IssueManager;
import tw.gov.nta.debt.common.PayManager;
import tw.gov.nta.shortterm.form.Dpma0101Form;
import tw.gov.nta.sql.debt.DebtMain;
import tw.gov.nta.sql.debt.IssueMain;
import tw.gov.nta.sql.debt.PaymentMain;

public class DPMA0108 extends DefaultAction
{
	@SuppressWarnings("unchecked")
	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request,
			Connection connection) throws Exception
	{
		Dpma0101Form dpma0101Form = (Dpma0101Form)form;
		IssueManager issueManager = new IssueManager();
		IssueMain issueMain = issueManager.getBean(dpma0101Form.getId());
		List list = new LinkedList();
		dpma0101Form.setIssuMain(issueMain);
		PayManager payManager = new PayManager();
		List pay = payManager.getDataByIssue(issueMain.getId());
		BigDecimal issueMainCapitalAmount = new BigDecimal(0);
		if (pay.size() != 0){
			for(Iterator it = pay.iterator();it.hasNext();){
				Map map = new HashMap();
				PaymentMain payDto = (PaymentMain)it.next();
				DebtMain debtMain = new DebtManager().getBean(payDto.getDebtId());
				map.put("bankCode",debtMain.getBank().getBankCode());
				map.put("bankName",debtMain.getBank().getBankName());
				map.put("rate",debtMain.getCompareRate());
				map.put("repayDate",payDto.getRepayDate());
				map.put("repayDays",payDto.getInterestDays());
				String payType = null;
				 if(payDto.getRepayDate().equals(issueMain.getDueDate()))
					 payType = "0 正常還款";
				 if(payDto.getRepayDate().after(issueMain.getDueDate()))
					 payType = "1 延後還款";
				 if(payDto.getRepayDate().before(issueMain.getDueDate()))
					 payType = "2 提前還款";
				 map.put("repayType",payType);
				 map.put("issueAmount",debtMain.getIssueAmount());
				 map.put("capitalAmount",payDto.getCapitalAmount());
				 map.put("interestAmount",payDto.getInterestAmount());
				 map.put("totalCount",payDto.getCapitalAmount().add(payDto.getInterestAmount()));
				 list.add(map);
				 issueMainCapitalAmount = issueMainCapitalAmount.add(payDto.getCapitalAmount());
			}
		}
		request.setAttribute("mod","true");
		request.setAttribute("collection",list);
		dpma0101Form.setIssueMainCapitalAmount(issueMainCapitalAmount);
//		
//	<display:column title="償還日期">
//		<bean:write name='row' property='repayDate'/>
//	</display:column>
//	<display:column title="天數">
//		<bean:write name='row' property='repayDays'/>
//	</display:column>
//	<display:column title="方式">
//		<bean:write name='row' property='repayType'/>
//	</display:column>
//	<display:column title="借款金額">
//		<bean:write name='row' property='issueAmount'/>
//	</display:column>	
//	<display:column title="實付金額">
//		<bean:write name='row' property='capitalAmount'/>
//	</display:column>
//	<display:column title="實付利息">
//		<bean:write name='row' property='interestAmount'/>
//	</display:column>
//	<display:column title="實付本息合計">
//		<bean:write name='row' property='totalCount'/>
//	</display:column>
//</display:table>
	}
}
