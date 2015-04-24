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
		<td class='table_item' width="20%"><font color="red">*</font>年月起</td>
		<td class='table_td'>
			<html:text name='Airc1001Form' property='limitSDate' size='5'/>
		</td>
	</tr>
	<tr>
		<td class='table_item' width="20%"><font color="red">*</font>年月迄</td>
		<td class='table_td'>
			<html:text name='Airc1001Form' property='limitEDate' size='5'/>
		</td>
	</tr>
	<tr>
		<%-- 
		<td class='table_item'>金額單位</td>
		<td class='table_td'>
			<%pageContext.setAttribute("collectionCodeDet",tw.gov.nta.system.common.CodeDetManage.getCodeDet("BU")); %>
			<html:select name='Airc1001Form' property='amountUnit'>
				<html:option value="0">請選擇</html:option>
				<html:options collection="collectionCodeDet" labelName="valuess" labelProperty='label' property="valuess"/>
			</html:select>
		</td>
		--%>
		<td class='table_item'>種類</td>
		<td class='table_td'>
			<html:select name='Airc1001Form' property='kind'>
				<html:option value="A">公債</html:option>
				<html:option value="B">國庫券</html:option>
			</html:select>
		</td>		
	</tr>
</table>