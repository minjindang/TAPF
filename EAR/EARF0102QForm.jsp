<!--
�{���ت��GGBA XML
�{���N���GEARF01
�{������G0970605
�{���@�̡GHOWARDDP
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->
<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@taglib uri="/tags/struts-bean" prefix="bean" %>
<%@taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %> 

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>���</td>
		<td class='table_td'>
			<html:text name='AccountQueryForm' property='Date(startIssueDate)' size='10' maxlength='7'/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("Date(startIssueDate)",new Integer(1))%>
			~
			<html:text name='AccountQueryForm' property='Date(endIssueDate)' size='7' maxlength='7'/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("Date(endIssueDate)",new Integer(2))%>
		</td>
	</tr>
	
</table>