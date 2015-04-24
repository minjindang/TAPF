<!--
程式目的：中央政府公債發行與還本概況表
程式代號：AIRB02
程式日期：0950317
程式作者：icefire
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'><font color="red">*</font>還本年度</td>
		<td class='table_td'>
			<html:text name='Airb0201Form' property='repay_SDate' size='3' maxlength='3'/>~
			<html:text name='Airb0201Form' property='repay_EDate' size='3' maxlength='3'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>發行日期</td>
		<td class='table_td'>
			<html:text name='Airb0201Form' property='date(issue_SDate)' size='7' maxlength='7'/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(issue_SDate)", new Integer(0))%>
			~
			<html:text name='Airb0201Form' property='date(issue_EDate)' size='7' maxlength='7'/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(issue_EDate)", new Integer(1))%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>公債類別</td>
		<td class='table_td'>
			<select name="bondSellStatus">
				<option value="">請選擇</option>
				<option value="Y">可分割公債</option>
				<option value="4">交換公債</option>
			</select>
		</td>	
	</tr>
</table>