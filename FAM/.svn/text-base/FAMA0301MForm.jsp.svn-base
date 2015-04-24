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
<html:hidden name='Fama0301Form' property="id"/>
<html:hidden name='Fama0301Form' property="qryDebitType"/>
<html:hidden name='Fama0301Form' property="qryDebitName"/>
<html:hidden name='Fama0301Form' property="qryBudgetCode"/>
<html:hidden name='Fama0301Form' property="date(createDate)"/>
<input type='hidden' name='qry' value='Y'/>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'> ＊債務別：</td>
		<td class='table_td'>
			<html:text name='Fama0301Form' property='debitType' size='50' maxlength='10'/>
			
		</td>
		<td class='table_td'>
		</td>
	</tr>
	<tr>
		<td class='table_item'>＊債務別名稱：</td>
		<td class='table_td'>
			<html:text name='Fama0301Form' property='debitName' size='50' maxlength='50'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>＊所屬預算別：</td>
		<td class='table_td'>
			<bean:define id='budgetId' name='Fama0301Form' property='budgetId' type='java.lang.Integer' />
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.BudgetCodeManager.getBudgetInfo(),"budgetId",(budgetId).toString())%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>備註：</td>
		<td class='table_td'>
			<html:text name='Fama0301Form' property='remark' size='50' maxlength='100'/>
		</td>
	</tr>
</table>
