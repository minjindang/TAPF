<!--
�{���ت��GAima02��r
�{���N���GAima02
�{������G0950306
�{���@�̡GFormBean Generator
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
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
		<td class='table_item'>�洫���ŦW��</td>
		<td class='table_td'>
			<logic:empty name='Aima0501Form' property='issueId'>
				<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(gov.dnt.tame.util.ListToolManager.getList("select id, debtName from IssueMain where debtType='A' and bondKind='4'"),"issueId","",10, false)%>
			</logic:empty>
			<logic:notEmpty name='Aima0501Form' property='issueId'>
				<bean:define id='issueId' name='Aima0501Form' property='issueId' type='java.lang.Integer'/>
				<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(gov.dnt.tame.util.ListToolManager.getList("select id, debtName from IssueMain where debtType='A' and bondKind='4'"),"issueId",issueId.toString(),10, false)%>
			</logic:notEmpty>
		</td>
		<td class='table_item'>�վ���</td>
		<td class='table_td'>
			<html:text name='Aima0501Form' property='date(changeDate)' onblur='' />
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(changeDate)",new Integer(0))%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�洫����</td>
		<td class='table_td'>
			<html:text name='Aima0501Form' property='bigDecimal(changePrice)' />
		</td>
		<td class='table_item'>�֭p�洫�Ѽ�</td>
		<td class='table_td'>
			<html:text name='Aima0501Form' property='bigDecimal(sumStock)' />
		</td>
	</tr>
	<tr>
		<td class='table_item'>�֭p���Ѫ��B</td>
		<td class='table_td'>
			<html:text name='Aima0501Form' property='bigDecimal(stockAmount)' />
		</td>
		<td class='table_item'>�֭p�����@���v�I���B</td>
		<td class='table_td'>
			<html:text name='Aima0501Form' property='bigDecimal(notAmount)' />
		</td>
	</tr>
	<tr>
		<td class='table_item'>�֭p�洫���B</td>
		<td class='table_td'>
			<html:text name='Aima0501Form' property='bigDecimal(changeAmount)' />
		</td>
		<td class='table_item'>�վ�����]</td>
		<td class='table_td'>
			<html:text name='Aima0501Form' property='changeReason' />
		</td>
	</tr>
</table>