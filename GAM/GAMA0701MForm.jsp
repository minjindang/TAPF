<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>
<table class='table_1' width='100%'>
	<html:hidden name='Gama0701Form' property='qryAccountYear'/>
	<html:hidden name='Gama0701Form' property='id'/>
	<html:hidden name='Gama0701Form' property='accountYear'/>
	<tr>
		<td class='table_item'>�~��</td>
		<td class='table_td'>
			<bean:write name='Gama0701Form' property='accountYear'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�j���٥����B</td>
		<td class='table_td'>
			<html:text name='Gama0701Form' property='bigDecimal(budgetAmount)' size='20' maxlength='20'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�I�����B</td>
		<td class='table_td'>
			<html:text name='Gama0701Form' property='bigDecimal(interestAmount)' size='20' maxlength='20'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>���X�`�B(�`�w��ίS�O�w��)</td>
		<td class='table_td'>
			<html:text name='Gama0701Form' property='bigDecimal(yearAmount)' size='20' maxlength='20'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�ŰȰ������٥���</td>
		<td class='table_td'>
			<html:text name='Gama0701Form' property='bigDecimal(fundationAmount)' size='20' maxlength='20'/>
		</td>
	</tr>
</table>