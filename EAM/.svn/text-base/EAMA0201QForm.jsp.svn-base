<!--
程式目的：EAMA02文字
程式代號：EAMA02
程式日期：0950301
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
		<td class='table_item'>會計階段代號</td>
		<td class='table_td'>
			<html:text name="Eama0201Form" property="phaseCode" size="30" maxlength="5"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>會計階段名稱</td>
		<td class='table_td' colspan="3">
			<html:text name="Eama0201Form" property="phaseName" size="30" maxlength="30"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>會計階段簡稱</td>
		<td class='table_td' colspan="3">
			<html:text name="Eama0201Form" property="phaseShortName" size="30" maxlength="30"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>傳票類別</td>
		<td class="table_td">
		
		<html:select name="Eama0201Form" property="phaseType">
			<html:optionsCollection name="Eama0201Form" property="phaseTypes" label="value" value="key" />
		</html:select>
		</td>
	</tr>
	<%
		tw.gov.nta.sql.debt.DebtTypeRef debtType = (tw.gov.nta.sql.debt.DebtTypeRef)session.getAttribute("debtType");
		if ("A".equals(debtType.getType()) || "B".equals(debtType.getType())){
	%>
	<tr>
		<td class='table_item'>發行形式</td>
		<td class="table_td">
			<html:radio name="Eama0201Form" property="issueKind" value="0" >登錄</html:radio>
			<html:radio name="Eama0201Form" property="issueKind" value="1" >債票</html:radio>
			<html:radio name="Eama0201Form" property="issueKind" value="2" >全部</html:radio>
		</td>
	</tr>		
	<%	}else{%>
		<html:hidden name="Eama0201Form"  property="issueKind" value="0"/>
	<%  }%>
</table>
