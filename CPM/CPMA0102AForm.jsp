<!-- CPMA0102AForm.jsp
�{���ت��GCPMA01
�{���N���GCPMA01
�{������G0950306
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
<%@ page import="gov.dnt.tame.util.DateUtil" %>
<table class='table_1' width='100%'>
<html:hidden name='Cpma0101Form' property='issueId'/>
<html:hidden name='Cpma0101Form' property='date(planRepayDate)'/>
	<tr>
		<td class='table_item'>�W��</td>
		<td class='table_td'>
			<bean:write name='Cpma0101Form' property='debtName'/>
		</td>	
		<td class='table_item'>�ɴڴ���</td>
		<td class='table_td'>
					<logic:notEmpty name='Cpma0101Form' property='issueDate'>
						<bean:define id="issueDate" name="Cpma0101Form" property="issueDate" type="java.util.Date"/>
							<%=DateUtil.date2ROCStr(issueDate)%> ~
					</logic:notEmpty>
					<logic:empty name='Cpma0101Form' property='issueDate'>
							<%="0000000"%> ~
					</logic:empty>
					<logic:notEmpty name='Cpma0101Form' property='dueDate'>
						<bean:define id="dueDate" name="Cpma0101Form" property="dueDate" type="java.util.Date"/>
							<%=DateUtil.date2ROCStr(dueDate)%>
					</logic:notEmpty>
					<logic:empty name='Cpma0101Form' property='dueDate'>
							<%="0000000"%>
					</logic:empty>
		</td>	
		<td class='table_item'>�ɴڴ���</td>
		<td class='table_td'colspan="3">
				<%=request.getAttribute("DayCount").toString()%>
		</td>
	</tr>
	<tr>	
		<td class='table_item'>�p���ɴڪ��B</td>
		<td class='table_td'>
			<logic:notEmpty name='Cpma0101Form' property='bigDecimal(issueAmount)'>
				<bean:define id="expectAmount" name="Cpma0101Form" property="amountDecimal(expectAmount)" type="java.lang.String"/>
				<p align="right"><%=expectAmount%></p>
			</logic:notEmpty>
			<logic:empty name='Cpma0101Form' property='expectAmount'>
				<%="0"%>
			</logic:empty>	
		</td>	
		<td class='table_item'>��ڭɴڪ��B</td>
		<td class='table_td'>
			<logic:notEmpty name='Cpma0101Form' property='bigDecimal(issueAmount)'>
				<bean:define id="issueAmount" name="Cpma0101Form" property="amountDecimal(issueAmount)" type="java.lang.String"/>
				<p align="right"><%=issueAmount%></p>
			</logic:notEmpty>
			<logic:empty name='Cpma0101Form' property='issueAmount'>
				<%="0"%>
			</logic:empty>		
		</td>
		<td class='table_item'>�w�v���B</td>
		<td class='table_td'>
			<logic:notEmpty name='Cpma0101Form' property='bigDecimal(capitalAmount)'>
				<bean:define id="capitalAmount" name="Cpma0101Form" property="amountDecimal(capitalAmount)" type="java.lang.String"/>
				<p align="right"><%=capitalAmount%></p>
			</logic:notEmpty>	
			<logic:empty name='Cpma0101Form' property='capitalAmount'>
				<%="0"%>
			</logic:empty>	
		</td>
		<td class='table_item'>���v���B</td>
		<td class='table_td'>
			<bean:define id="issueAmount" name="Cpma0101Form" property="bigDecimal(issueAmount)" type="java.math.BigDecimal"/>
			<bean:define id="capitalAmount" name="Cpma0101Form" property="bigDecimal(capitalAmount)" type="java.math.BigDecimal"/>
			<p align="right"><%=new gov.dnt.tame.common.SupportForm().getAmountDecimal(issueAmount.subtract(capitalAmount))%></p>	
		</td>
	</tr>
</table>
