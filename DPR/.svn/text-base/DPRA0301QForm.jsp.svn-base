<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<input type='hidden' name='title' value='DPRA03'>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'><font color="red">*</font>期別</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.debt.common.IssueManager.getIssueSerialByBudget("D",new Integer(4)),"issueId",10,false)%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>償付日期</td>
		<td class='table_td'>
			<html:text name='DpraReportForm' property='date(payDate)' size='7' maxlength='7'/>
			<a href="javascript: myCalendar.setCallBackObj('date(payDate)');myCalendar.show();"><img src="/tapf/assets/images/calendar/dynCalendar.gif" border="0" align="absmiddle" width="16" height="16" title="選擇日期"/></a> 
		</td>
	</tr>
</table>