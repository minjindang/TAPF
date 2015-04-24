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
<html:hidden name='Dpma0101Form' property='id'/>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>�~��</td>
		<td class='table_td'>
			<bean:write name='Dpma0101Form' property='accountYear'/>
		</td>
		<td class='table_item'>����</td>
		<td class='table_td'>
			<bean:write name='Dpma0101Form' property='serialNo'/>
		</td>
		<td class='table_item'>�w��O</td>
		<td class='table_td'>
			<bean:define id='budgetCode' name='Dpma0101Form' property='budgetCode' type="java.lang.Integer"/>
			<%= tw.gov.nta.system.common.BudgetCodeManager.get(budgetCode).getBudgetName()%>
		</td>
		<td class='table_item'>�ŰȧO</td>
		<td class='table_td'>
			<bean:define id='debtCode' name='Dpma0101Form' property='debtCode' type="java.lang.Integer"/>
			<%=tw.gov.nta.system.common.DebitCodeManage.get(debtCode).getDebitName()%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>���O</td>
		<td class='table_td'>
			<bean:write name='Dpma0101Form' property='issueSerial'/>
		</td>
		<td class='table_item'>�W��</td>
		<td class='table_td' colspan="5">
			<bean:write name='Dpma0101Form' property='debtName'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�ɴڴ���</td>
		<td class='table_td'>
			<bean:define id="issueDate" name="Dpma0101Form" property="issueDate" type="java.util.Date"/>
			<%=gov.dnt.tame.util.DateUtil.date2ROCStr(issueDate,"yyy/mm/dd")%>	~
			<bean:define id="dueDate" name="Dpma0101Form" property="dueDate" type="java.util.Date"/>
			<%=gov.dnt.tame.util.DateUtil.date2ROCStr(dueDate,"yyy/mm/dd")%>
		</td>
		<td class='table_item'>�Ѽ�</td>
		<td class='table_td' colspan="5" id="days">
			<bean:write name='Dpma0101Form' property='days'/>��
		</td>
	</tr>
	<tr>
		<td class='table_item'>�ɴڪ��B</td>
		<td class='table_td'>
			<bean:write name='Dpma0101Form' property='bigDecimal(issueAmount)' format='#,##0'/>
		</td>
		<td class='table_item'>�w�v���B</td>
		<td class='table_td'>
			<bean:write name='Dpma0101Form' property='bigDecimal(issueMainCapitalAmount)' format='#,##0'/>
		</td>
		<td class='table_item'>���v���B</td>
		<td class='table_td'>
			<bean:define id='issueMainCapitalAmount' name='Dpma0101Form' property='bigDecimal(issueMainCapitalAmount)' type='java.math.BigDecimal '/>
			<bean:define id='issueAmount' name='Dpma0101Form' property='bigDecimal(issueAmount)'  type='java.math.BigDecimal'/>
			<%= new java.text.DecimalFormat("#,##0").format(issueAmount.subtract(issueMainCapitalAmount)) %>
		</td>
		<td class='table_item'>�����[�v�Q�v</td>
		<td class='table_td'>
			<bean:write name='Dpma0101Form' property='bigDecimal(averageRate)' format='0.000'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�Ƶ�</td>
		<td class='table_td' colspan="5">
			<bean:write name='Dpma0101Form' property='remark'/>
		</td>
	</tr>
</table>
