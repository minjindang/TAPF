<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'><font color="#ff0000">*</font>截止日期</td>
		<td class='table_td'>
			<html:text name='Apra2401Form' property='date(issueDate)' size='7' maxlength='7' onblur=''/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(issueDate)",new Integer(0))%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>發行起迄日期</td>
		<td class='table_td'>
			<html:text name='Apra2401Form' property='date(issueSDate)' size='7' maxlength='7' onblur=''/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(issueSDate)",new Integer(1))%>~
			<html:text name='Apra2401Form' property='date(issueEDate)' size='7' maxlength='7' onblur=''/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(issueEDate)",new Integer(2))%>
		</td>
	</tr>
</table>
