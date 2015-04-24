<!--
程式目的：中央政府公債還本付息報表
程式代號：AIRB01
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
		<td class='table_item'><font color='red'>*</font>年度:</td>
		<td class='table_td'>
			<html:text name='Dira1201Form' property='accountYear' size='3' maxlength='3'/>
			
		</td>
	<tr>
    <td class='table_item'>計算基準日:</td>
		<td class='table_td'>
			<html:text name='Dira1201Form' property='date(baseDate)' size='7' maxlength='7' onblur=''/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(baseDate)",new Integer(0))%>	
		</td>
	</tr>
</table>