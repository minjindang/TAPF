<!-- DIMA0201AForm.jsp
程式目的：DIMA02
程式代號：DIMA02
程式日期：0950223
程式作者：Andrew Sung
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
		<td class='table_item'>年度</td>
		<td class='table_td'>
			<html:text name='Dima0201Form' property='qryAccountYear' size='10' maxlength='3'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>期次</td>
		<td class='table_td'>
			<html:text name='Dima0201Form' property='qrySerialNo' size='10' maxlength='3'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>名稱</td>
		<td class='table_td' colspan="5">
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.debt.common.IssueManager.getDebtNameLabelList("D"),"qryId",10, false)%>
		</td>
	</tr>
</table>
