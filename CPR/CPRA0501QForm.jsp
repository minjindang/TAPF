<!--	CPRA0401QForm.jsp
�{���ت��GCPRA0401
�{���N���GCPRA0401
�{������G0950316
�{���@�̡GERIC CHEN
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'><font color="red">*</font>���ʯ�Ծ��ɴڦW��</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(gov.dnt.tame.util.ListToolManager.getList("select id,debtName from IssueMain where debtCode = 58 "),"id","",10,false)%>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red"></font>�p�����_�W</td>
		<td class='table_td'>
			<html:text name='Cpra0501Form' property='Date(startDate)' size='7' maxlength='7' onblur="" />
			<%=gov.dnt.tame.util.CommonFun.addCalendar("Date(issueDate)",new Integer(0))%>~
			<html:text name='Cpra0501Form' property='Date(endDate)' size='7' maxlength='7' onblur="" />
			<%=gov.dnt.tame.util.CommonFun.addCalendar("Date(endDate)",new Integer(1))%>
		</td>
	</tr>
</table>