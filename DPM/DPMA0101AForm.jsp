<!-- DIMA0101AForm.jsp
�{���ت��GDIMA01
�{���N���GDIMA01
�{������G0950223
�{���@�̡GEric.Chen
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>
<html:hidden name='Dpma0101Form' property="date(dueDate)"/>
<html:hidden name='Dpma0101Form' property="repayDays"/>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>�u���ɴڦW��</td>
		<td class='table_td'>
			<logic:empty name="Dpma0101Form" property="id">
				<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(gov.dnt.tame.util.ListToolManager.getList("select id, debtName from IssueMain where debtType='D' order by accountYear desc,serialNo desc"),"id","","","checkDate(form)",10,false)%>
			</logic:empty>		
			<logic:notEmpty name="Dpma0101Form" property="id">
				<bean:define id='id' name='Dpma0101Form' property='id' type='java.lang.Integer'/>	
				<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.shortterm.action.DPMA0106.getDebtName("D"),"id",id.toString(),"","checkDate(form)",10,false)%>	
			</logic:notEmpty>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�v�٤��</td>
		<td class='table_td'>
			<html:text name='Dpma0101Form' property='Date(repayDate)' size='10' maxlength='7' onblur="checkDate(form)"/>
			<a href="javascript: myCalendar.setCallBackObj('Date(repayDate)');myCalendar.show();">
			<img src="/tapf/assets/images/calendar/dynCalendar.gif" border="0" align="absmiddle" width="16" height="16" title="��ܤ��"/>
			</a>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�v�٤覡</td>
		<td class='table_td' id='pay'>
			<html:hidden name='Dpma0101Form' property='payType'/>
			<bean:write name='Dpma0101Form' property='payType'/>
		</td>
	</tr>
</table>
