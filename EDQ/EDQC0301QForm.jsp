<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>發行日期</td>
		<td class='table_td'>
			<html:text name='AccountQueryForm' property='date(startIssueDate)' size='7' maxlength='7'/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(startIssueDate)", new Integer(0))%>
			 ~ 
			<html:text name='AccountQueryForm' property='date(endIssueDate)' size='7' maxlength='7'/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(endIssueDate)", new Integer(1))%>
		</td>
	</tr>
</table>
