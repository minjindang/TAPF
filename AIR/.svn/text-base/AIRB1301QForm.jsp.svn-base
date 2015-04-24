<!--
程式目的：公債提前償付明細表
程式代號：AIRB13
程式日期：0990304
程式作者：CHRIS WU
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>

<table class='table_1' width='100%'>	
	<tr>
		<td class='table_item'>公債種類</td>
		<td class='table_td'>	
			<select name="bondKind" >	
				<option value ="1">一般公債</option>
				<option value ="3">增額公債</option>
			</select>
		</td>
	<tr>
		<td class='table_item'><font color="red">*</font>償付日期</td>
		<td class='table_td'>
			<html:text name='Airb1301Form' property='date(repayDateS)' size='7' maxlength='7' onblur=''/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(repayDateS)", new Integer(0))%>
			~
			<html:text name='Airb1301Form' property='date(repayDateE)' size='7' maxlength='7' onblur=''/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(repayDateE)", new Integer(1))%>
		</td>
	</tr>
</table>