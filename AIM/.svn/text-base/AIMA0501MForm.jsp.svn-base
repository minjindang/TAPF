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
<html:hidden name='Aima0501Form' property='id' />
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
		<td class='table_item'>調整日期</td>
		<td class='table_td'>
			<html:text name='Aima0501Form' property='date(changeDate)' onblur='' />
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(changeDate)",new Integer(0))%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>交換價格</td>
		<td class='table_td'>
			<html:text name='Aima0501Form' property='bigDecimal(changePrice)' />
		</td>
		<td class='table_item'>累計交換股數</td>
		<td class='table_td'>
			<html:text name='Aima0501Form' property='bigDecimal(sumStock)' />
		</td>
	</tr>
	<tr>
		<td class='table_item'>累計釋股金額</td>
		<td class='table_td'>
			<html:text name='Aima0501Form' property='bigDecimal(stockAmount)' />
		</td>
		<td class='table_item'>累計不足一股償付金額</td>
		<td class='table_td'>
			<html:text name='Aima0501Form' property='bigDecimal(notAmount)' />
		</td>
	</tr>
	<tr>
		<td class='table_item'>累計交換面額</td>
		<td class='table_td'>
			<html:text name='Aima0501Form' property='bigDecimal(changeAmount)' />
		</td>
		<td class='table_item'>調整價格原因</td>
		<td class='table_td'>
			<html:text name='Aima0501Form' property='changeReason' />
		</td>
	</tr>
</table>