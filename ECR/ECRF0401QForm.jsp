<!--
程式目的：總分類帳
程式代號：EARD01
程式日期：0950317
程式作者：
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