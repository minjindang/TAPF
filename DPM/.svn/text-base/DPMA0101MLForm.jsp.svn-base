<!--
程式目的：GAMA02文字
程式代號：GAMA02
程式日期：0950301
程式作者：FormBean Generator
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>
<%@ page import="gov.dnt.tame.util.DateUtil,java.math.BigDecimal" %>
<html:hidden name='Dpma0101Form' property='Date(repayDate)'/>
<html:hidden name='Dpma0101Form' property='repayDays'/>
<html:hidden name='Dpma0101Form' property='payType'/>
<table class='table_1' width='100%'>
	<tr>
		<td>
			<display:table class="table_list" name="collection" id="row">
				<display:column title="銀行代碼">
					<bean:write name='row' property='bankCode'/>
				</display:column>
				<display:column title="銀行名稱">
					<bean:write name='row' property='bankName'/>
				</display:column>
				<display:column title="利率">
					<bean:write name='row' property='rate' format="#,###.###"/>
				</display:column>
				<display:column title="償還日期">
					<logic:notEmpty name='row' property='repayDate'>
						<bean:define id="repayDate" name='row' property='repayDate' type="java.util.Date" />
						<%=DateUtil.date2ROCStr(repayDate)%>
					</logic:notEmpty>
				</display:column>
				<display:column title="天數">
					<bean:write name='row' property='repayDays'/>
				</display:column>
				<display:column title="方式">
					<bean:write name='row' property='repayType'/>
				</display:column>
				<display:column title="借款金額">
					<bean:write name='row' property='issueAmount' format="#,###"/>
				</display:column>	
				<display:column title="實付金額">
					<bean:write name='row' property='capitalAmount' format="#,###"/>
				</display:column>
				<display:column title="實付利息">
					<bean:write name='row' property='interestAmount' format="#,###"/>
				</display:column>
				<display:column title="實付本息合計">
					<bean:write name='row' property='totalCount' format="#,###"/>
				</display:column>
			</display:table>
		</td>
	</tr>
</table>
