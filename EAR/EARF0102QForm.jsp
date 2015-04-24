<!--
程式目的：GBA XML
程式代號：EARF01
程式日期：0970605
程式作者：HOWARDDP
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->
<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@taglib uri="/tags/struts-bean" prefix="bean" %>
<%@taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %> 

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>日期</td>
		<td class='table_td'>
			<html:text name='AccountQueryForm' property='Date(startIssueDate)' size='10' maxlength='7'/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("Date(startIssueDate)",new Integer(1))%>
			~
			<html:text name='AccountQueryForm' property='Date(endIssueDate)' size='7' maxlength='7'/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("Date(endIssueDate)",new Integer(2))%>
		</td>
	</tr>
	
</table>