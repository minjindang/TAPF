<!--
程式目的：中央政府交換公債交換月報總表
程式代號：AIRC10
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
		<td class='table_item' width="20%">查詢日期</td>
		<td class='table_td' colspan="3">
			<html:text name='Airc1101Form' property='Date(limitDate)' size='7' maxlength='7' />
			<%=gov.dnt.tame.util.CommonFun.addCalendar("Date(limitDate)",new Integer(1))%>
		</td>
	</tr>
	<tr>
		<td class='table_item' width="20%">金額單位</td>
		<td class='table_td'>
			<%pageContext.setAttribute("collectionCodeDet",tw.gov.nta.system.common.CodeDetManage.getCodeDet("BU")); %>
			<html:select name='Airc1101Form' property='amountUnit'>
				<html:option value="0">請選擇</html:option>
				<html:options collection="collectionCodeDet" labelName="valuess" labelProperty='label' property="valuess"/>
			</html:select>
		</td>
	</tr>
</table>