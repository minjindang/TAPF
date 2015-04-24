<!--
程式目的：HARA04文字
程式代號：HARA04
程式日期：0950221
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
		<td class='table_item'>債務別：</td>
		<td class='table_td'>
			<input Type='text' name='qryDebitType' size='50' maxlength='10'/>
		</td>
		<td class='table_td'>
		</td>
	</tr>
	<tr>
		<td class='table_item'>債務別名稱：</td>
		<td class='table_td'>
			<input Type='text' name='qryDebitName' size='50' maxlength='50'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>所屬預算別：</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.BudgetCodeManager.getBudgetInfo(),"qryBudgetCode",10)%>

		</td>
	</tr>
</table>
