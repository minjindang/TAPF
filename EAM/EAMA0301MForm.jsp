<!--
�{���ت��GEAMA01��r
�{���N���GEAMA01
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


<html:hidden name='Eama0301Form' property='debtMain.id' />
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>���ťN��</td>
            <td class='table_td'>
			<bean:write name="Eama0301Form" property="debtSerial"/>
		</td>

		<td class='table_item'>�����ѧO�X</td>
		<td class='table_td'>
			<bean:write name="Eama0301Form" property="issue.bondType"/>
		</td>
		<td class='table_item'>�w��O</td>
		<td class='table_td'>
			<bean:write name="Eama0301Form" property="budgetCode"/>
		</td>
		
		<td class='table_item'>�ŰȧO	</td>
		<td class='table_td'>		
			<bean:write name="Eama0301Form" property="debtCode"/>
		</td>
	</tr>

	<tr>
		<td class='table_item'>�o��~��</td>
		<td class='table_td'>	
			<bean:write name="Eama0301Form" property="issue.accountYear"/>
		</td>		
		<td class='table_item'>�o�����</td>
		<td class='table_td'>
			<bean:write name="Eama0301Form" property="issue.serialNo"/>
		</td>
		<td class='table_item'>���ŵo�����</td>
		<td class='table_td'>
			<bean:write name="Eama0301Form" property="bondKind"/>
		</td>
		<td class='table_item'>�o��Φ�</td>
		<td class='table_td'>
			<bean:write name="Eama0301Form" property="issueKind"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>
        	���ŦW�� 
		</td>
		<td class='table_td' colspan="7">
        	<bean:write name="Eama0301Form" property="issue.debtName"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�o����</td>
		<td class='table_td'>
			<bean:write name="Eama0301Form" property="issue.issueDate" format="yyyy/MM/dd" />
		</td>
		<td class='table_item'>����</td>
		<td class='table_td'>
			<bean:write name='Eama0301Form' property='issue.issueInterval'/>�~
		</td>
		<td class='table_item'>�����</td>
		<td class='table_td'>
			<bean:write name='Eama0301Form' property='issue.dueDate' format="yyyy/MM/dd" />
		</td>
	</tr>
	<tr>
		<td class='table_item'>�o���B</td>
		<td class='table_td'>
			<bean:write name="Eama0301Form" property="issueAmount" format="#,###.##"/>		
		</td>
		
		<td class='table_item'>�ꦬ�B</td>
		<td class='table_td'>
			<bean:write name="Eama0301Form" property="realAmount" format="#,###.##"/>		
		</td>
		
		<td class='table_item'>��(��)�����B</td>
		<td class='table_td'>
			<bean:write name="Eama0301Form" property="diversityAmount" format="#,###.##"/>	
		</td>
	</tr>
	<tr>
		<td class='table_item'>�Q�v�ܰʧO</td>
		<td class='table_td'>
			<bean:write name='Eama0301Form' property='issue.rateKind'/>
		</td>
		<td class='table_item'>�Q�v�~��</td>
		<td class='table_td'>
			<bean:write name='Eama0301Form' property='issue.averageRate'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�����I�����</td>
		<td class='table_td'>
        	<bean:write name='Eama0301Form' property='issue.firstInterestDate' format="yyyy/MM/dd" />
  		</td>
		<td class='table_item'>�I������</td>
		<td class='table_td'> 
        	<bean:write name="Eama0301Form" property="issue.interestAlternate"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�����٥����</td>
		<td class='table_td'>
       		<bean:write name='Eama0301Form' property='issue.firstRepayDate' format="yyyy/MM/dd" />
  		</td>
		<td class='table_item'>�٥�����</td>
		<td class='table_td'>
        	<bean:write name="Eama0301Form" property='issue.repayAlternate'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>���ħI�I����</td>
		<td class='table_td'>
        	<bean:write name='Eama0301Form' property='issue.payLimit'/>�~
  		</td>
		<td class='table_item'>�I��I�I���</td>
		<td class='table_td'>
			<bean:write name='Eama0301Form' property="issue.cashDueDate" format="yyyy/MM/dd" />
		</td>
	</tr>
	<tr>
		<td class='table_item'>�w�����I�Q��</td>
		<td class='table_td'>
			<bean:write name='Eama0301Form' property="originInterestAmount" format="#,###.##" />
		</td>
		
		<td class='table_item'>�W�B���I�Q�����B</td>
		<td class='table_td'>
			<bean:write name='Eama0301Form' property="payableInterestAmount" format="#,###.##" />
		</td>
	</tr>
</table>
