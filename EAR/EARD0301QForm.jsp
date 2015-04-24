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
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>還本付息日期</td>
		<td class='table_td' colspan="3">
			<input type="text" name="date(startIssueDate)" maxlength="7" size="30" value="0950101">
			 至 
			<input type="text" name="date(endIssueDate)" maxlength="7" size="30" value="0950630">
		</td>
	</tr>
	<tr>
		<td class='table_item'>發行日期</td>
		<td class='table_td' colspan="3">
			<input type="text" name="date(startIssueDate)" maxlength="7" size="30" value="">
			 至 
			<input type="text" name="date(endIssueDate)" maxlength="7" size="30" value="">
		</td>
	</tr>
	<tr>
		<td class='table_item'>到期日期</td>
		<td class='table_td' colspan="3">
			<input type="text" name="date(startDueDate)" maxlength="7" size="30" value="">
			 至 
			<input type="text" name="date(endDueDate)" maxlength="7" size="30" value="">
		</td>
	</tr>
</table>