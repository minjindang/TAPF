<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>
<html:hidden name='Aima0102MForm' property='issueMainId' />
<html:hidden name='Aima0102MForm' property='debtId' />
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>預算別</td>
		<td class='table_td'><bean:write name='Aima0102MForm' property='debitCodeName'/></td>
	</tr>
	<tr>
		<td class='table_item'>債務別</td>
		<td class='table_td'><bean:write name='Aima0102MForm' property='budgetCodeName'/></td>
	</tr>
	<tr>
		<td class='table_item'>發行額</td>
		<td class='table_td'><bean:write name='Aima0102MForm' property='BigDecimal(issueAmountx)' format='###,###'/>元</td>
	</tr>
	<tr>
		<td class='table_item'>實收額</td>
		<td class='table_td'><bean:write name='Aima0102MForm' property='BigDecimal(realAmount)' format='###,###'/>元</td>
	</tr>
	<tr>
		<td class='table_item'>提前買回金額</td>
		<td class='table_td'><html:text name='Aima0102MForm' property='BigDecimal(advanceAmount)' size='20' maxlength='20'/>元</td>
	</tr>
	<tr>
		<td class='table_item'>最低得標利率</td>
		<td class='table_td'><html:text name='Aima0102MForm' property='BigDecimal(advanceRate)' size='10' maxlength='10'/>%</td>
	</tr>
	<tr>
		<td class='table_item'>提前買回日期</td>
		<td class='table_td'>
			<html:text name='Aima0102MForm' property='Date(advanceDate)' size='10' maxlength='7'/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("Date(advanceDate)",new Integer(0))%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>買回價款</td>
		<!-- 
		<td class='table_td'>
			<bean:write name='Aima0102MForm' property='BigDecimal(buyAmount)' format='###,###'/>元
			<html:hidden name='Aima0102MForm' property='BigDecimal(buyAmount)' />
		</td>
		 -->
		<td class='table_td'><html:text name='Aima0102MForm' property='BigDecimal(buyAmount)' size='20' maxlength='20'/>元</td>
	</tr>
	<tr>
		<td class='table_item'>應計利息</td>
		<!-- 
		<td class='table_td'>
			<bean:write name='Aima0102MForm' property='BigDecimal(advanceInterest)' format='###,###'/>元
			<html:hidden name='Aima0102MForm' property='BigDecimal(advanceInterest)' />
		</td>
		 -->
		<td class='table_td'><html:text name='Aima0102MForm' property='BigDecimal(advanceInterest)' size='20' maxlength='20'/>元</td>
	</tr>
	<tr>
		<td class='table_item'>買回溢(折)價</td>
		<!-- 
		<td class='table_td'>
			<bean:write name='Aima0102MForm' property='BigDecimal(buyPremium)' format='###,###'/>元
			<html:hidden name='Aima0102MForm' property='BigDecimal(buyPremium)' />
		</td>
		 -->
		<td class='table_td'><html:text name='Aima0102MForm' property='BigDecimal(buyPremium)' size='20' maxlength='20'/>元</td>
	</tr>
	<tr>
		<td class='table_item'>應扣累計稅款</td>
		<!-- 
		<td class='table_td'>
			<bean:write name='Aima0102MForm' property='BigDecimal(advanceTax)' format='###,###'/>元
			<html:hidden name='Aima0102MForm' property='BigDecimal(advanceTax)' />
		</td>
		 -->
		<td class='table_td'><html:text name='Aima0102MForm' property='BigDecimal(advanceTax)' size='20' maxlength='20'/>元</td>
	</tr>
	<tr>
		<td class='table_item'>稅後買進金額</td>
		<!-- 
		<td class='table_td'>
			<bean:write name='Aima0102MForm' property='BigDecimal(finalAmount)' format='###,###'/>元
			<html:hidden name='Aima0102MForm' property='BigDecimal(finalAmount)' />
		</td>
		 -->
		<td class='table_td'><html:text name='Aima0102MForm' property='BigDecimal(finalAmount)' size='20' maxlength='20'/>元</td>
	</tr>
</table>