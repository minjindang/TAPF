<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>
<html:hidden name='Aima0102MForm' property='issueMainId' />
<html:hidden name='Aima0102MForm' property='debtId' />
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>�w��O</td>
		<td class='table_td'><bean:write name='Aima0102MForm' property='debitCodeName'/></td>
	</tr>
	<tr>
		<td class='table_item'>�ŰȧO</td>
		<td class='table_td'><bean:write name='Aima0102MForm' property='budgetCodeName'/></td>
	</tr>
	<tr>
		<td class='table_item'>�o���B</td>
		<td class='table_td'><bean:write name='Aima0102MForm' property='BigDecimal(issueAmountx)' format='###,###'/>��</td>
	</tr>
	<tr>
		<td class='table_item'>�ꦬ�B</td>
		<td class='table_td'><bean:write name='Aima0102MForm' property='BigDecimal(realAmount)' format='###,###'/>��</td>
	</tr>
	<tr>
		<td class='table_item'>���e�R�^���B</td>
		<td class='table_td'><html:text name='Aima0102MForm' property='BigDecimal(advanceAmount)' size='20' maxlength='20'/>��</td>
	</tr>
	<tr>
		<td class='table_item'>�̧C�o�ЧQ�v</td>
		<td class='table_td'><html:text name='Aima0102MForm' property='BigDecimal(advanceRate)' size='10' maxlength='10'/>%</td>
	</tr>
	<tr>
		<td class='table_item'>���e�R�^���</td>
		<td class='table_td'>
			<html:text name='Aima0102MForm' property='Date(advanceDate)' size='10' maxlength='7'/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("Date(advanceDate)",new Integer(0))%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�R�^����</td>
		<!-- 
		<td class='table_td'>
			<bean:write name='Aima0102MForm' property='BigDecimal(buyAmount)' format='###,###'/>��
			<html:hidden name='Aima0102MForm' property='BigDecimal(buyAmount)' />
		</td>
		 -->
		<td class='table_td'><html:text name='Aima0102MForm' property='BigDecimal(buyAmount)' size='20' maxlength='20'/>��</td>
	</tr>
	<tr>
		<td class='table_item'>���p�Q��</td>
		<!-- 
		<td class='table_td'>
			<bean:write name='Aima0102MForm' property='BigDecimal(advanceInterest)' format='###,###'/>��
			<html:hidden name='Aima0102MForm' property='BigDecimal(advanceInterest)' />
		</td>
		 -->
		<td class='table_td'><html:text name='Aima0102MForm' property='BigDecimal(advanceInterest)' size='20' maxlength='20'/>��</td>
	</tr>
	<tr>
		<td class='table_item'>�R�^��(��)��</td>
		<!-- 
		<td class='table_td'>
			<bean:write name='Aima0102MForm' property='BigDecimal(buyPremium)' format='###,###'/>��
			<html:hidden name='Aima0102MForm' property='BigDecimal(buyPremium)' />
		</td>
		 -->
		<td class='table_td'><html:text name='Aima0102MForm' property='BigDecimal(buyPremium)' size='20' maxlength='20'/>��</td>
	</tr>
	<tr>
		<td class='table_item'>�����֭p�|��</td>
		<!-- 
		<td class='table_td'>
			<bean:write name='Aima0102MForm' property='BigDecimal(advanceTax)' format='###,###'/>��
			<html:hidden name='Aima0102MForm' property='BigDecimal(advanceTax)' />
		</td>
		 -->
		<td class='table_td'><html:text name='Aima0102MForm' property='BigDecimal(advanceTax)' size='20' maxlength='20'/>��</td>
	</tr>
	<tr>
		<td class='table_item'>�|��R�i���B</td>
		<!-- 
		<td class='table_td'>
			<bean:write name='Aima0102MForm' property='BigDecimal(finalAmount)' format='###,###'/>��
			<html:hidden name='Aima0102MForm' property='BigDecimal(finalAmount)' />
		</td>
		 -->
		<td class='table_td'><html:text name='Aima0102MForm' property='BigDecimal(finalAmount)' size='20' maxlength='20'/>��</td>
	</tr>
</table>