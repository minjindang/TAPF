<!--
程式目的：核撥公債本息基金明細表(特別預算乙)
程式代號：APRA03
程式日期：0950308
程式作者：ERIC CHEN
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'><font color="red">*</font>還本付息日期</td>
		<td class='table_td'>
			<html:text name='Apra0301Form' property='date(repaySdate)' size='10' maxlength='7'/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(repaySdate)",new Integer(0))%>~
			<html:text name='Apra0301Form' property='date(repayEdate)' size='10' maxlength='7'/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(repayEdate)",new Integer(1))%>
		</td>
	</tr>
</table>