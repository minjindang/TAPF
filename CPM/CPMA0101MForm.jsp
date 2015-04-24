<!-- CPMA0101MForm.jsp
程式目的：CPMA01
程式代號：CPMA01
程式日期：0950306
程式作者：Eric.Chen
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>
<%@ page import="gov.dnt.tame.util.DateUtil" %>
<table class='table_1' width='100%'>
	<tr>	
		<td class='table_item'>名稱</td>
		<td class='table_td'>
			<bean:write name='Cpma0101Form' property='debtName'/>
		</td>
		<td class='table_item'>借款期間</td>
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
		<td class='table_item'>借款期限</td>
		<td class='table_td'>
				<%=request.getAttribute("DayCount").toString()%>
		</td>
	</tr>
	<tr>	
		<td class='table_item'>計劃借款金額</td>
		<td class='table_td'>
			<p align="right"><bean:write name='Cpma0101Form' property='amountDecimal(expectAmount)'/></p>
		</td>	
		<td class='table_item'>實際借款金額</td>
		<td class='table_td'>
			<p align="right"><bean:write name='Cpma0101Form' property='amountDecimal(issueAmount)'/></p>
		</td>
		<td class='table_item'>已償金額</td>
		<td class='table_td'>
			<p align="right"><bean:write name='Cpma0101Form' property='amountDecimal(capitalAmount)'/></p>
		</td>
		<td class='table_item'>未償金額</td>
		<td class='table_td'>
			<bean:define id="issueAmount" name="Cpma0101Form" property="bigDecimal(issueAmount)" type="java.math.BigDecimal"/>
			<bean:define id="capitalAmount" name="Cpma0101Form" property="bigDecimal(capitalAmount)" type="java.math.BigDecimal"/>
			<p align="right"><%=new gov.dnt.tame.common.SupportForm().getAmountDecimal(issueAmount.subtract(capitalAmount))%></p>	
		</td>
		<html:hidden name='Cpma0101Form' property='id'/>
		<html:hidden name='Cpma0101Form' property='qryaccountYear'/>
		<html:hidden name='Cpma0101Form' property='qrydebtName'/>
	</tr>
</table>
