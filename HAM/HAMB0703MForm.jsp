<!--
程式目的：HAMB07文字
程式代號：HAMB07
程式日期：0950223
程式作者：FormBean Generator
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>記帳年度</td>
		<td class='table_td'>
			<html:text name='Hamb0701Form' property='qryallYear' size='3' maxlength='3'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>撥款月份</td>
		<td class='table_td'>
			<html:text name='Hamb0701Form' property='qryallMonth' size='5' maxlength='5'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>受分配單位代號</td>
		<td class='table_td'>
			<html:text name='Hamb0701Form' property='unitId' size='10' maxlength='10'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>受分配單位</td>
		<td class='table_td'>
			<html:text name='Hamb0701Form' property='unitName' size='100' maxlength='100'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>寄送日期</td>
		<td class='table_td'>
			<html:text name='Hamb0701Form' property='date(qrysendDate)' size='13' maxlength='13'/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(qrysendDate)")%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>回條接收日期</td>
		<td class='table_td'>
			<html:text name='Hamb0701Form' property='date(qryrecvDate)' size='13' maxlength='13'/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(qryrecvDate)")%>
		</td>
	</tr>
</table>
