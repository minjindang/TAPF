<!--
程式目的：Aima02文字
程式代號：Aima02
程式日期：0950306
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
		<td class='table_item'>交換公債名稱</td>
		<td class='table_td'>
			<logic:empty name='Aima0501Form' property='issueId'>
				<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(gov.dnt.tame.util.ListToolManager.getList("select id, debtName from IssueMain where debtType='A' and bondKind='4'"),"issueId","",10, false)%>
			</logic:empty>
			<logic:notEmpty name='Aima0501Form' property='issueId'>
				<bean:define id='issueId' name='Aima0501Form' property='issueId' type='java.lang.Integer'/>
				<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(gov.dnt.tame.util.ListToolManager.getList("select id, debtName from IssueMain where debtType='A' and bondKind='4'"),"issueId",issueId.toString(),10, false)%>
			</logic:notEmpty>
		</td>
	</tr>
</table>