<!--
程式目的：RAMA0101文字
程式代號：RAMA0101
程式日期：1001027
程式作者：Powen Hsueh
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/displaytag" prefix="display"%>
<%@ page import="gov.dnt.tame.util.DateUtil"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ page import="gov.dnt.tame.util.DateUtil,java.math.BigDecimal"%>
<table class='table_list' width='100%'>

	<tr class='table_item'  align="center">
		<td rowspan="2">到期日</td>
		<td rowspan="3">債務別</td>
		<td rowspan="3">還本<br />
		期次</td>
		<td rowspan="3">付息<br />
		期次</td>
		<td rowspan="3">還本<br />
		金額</td>
		<td rowspan="3">付息<br />
		金額</td>
		<td colspan="2">第3組</td>
		<td colspan="3">會計室</td>
		<td>秘書室</td>
	</tr>
	<tr class='table_item' align="center">
		<td>還本付息<br />簽辦日期</td>
		<td rowspan="2">文號</td>
		<td>開立憑單<br />日期</td>
		<td rowspan="2">付款憑單<br />
		編號</td>
		<td rowspan="2">債務基金<br />
		憑單編號</td>
		<td>檢送付款<br />憑單日期</td>
	</tr>
	<tr class='table_item' align="center">
		<td>年月日</td>
		<td>年月日</td>
		<td>年月日</td>
		<td>年月日</td>
	</tr>
	<c:forEach items="${collection}" var="na" varStatus="status">
		<tr>
			<td style=" border-bottom:1 solid #000000; "><bean:define id='repayDate' name='na' property='repayDate'
				type="java.util.Date" /> <%=DateUtil.date2ROCStr(repayDate)%>
			<html:hidden name='na' property='id' />
			<html:hidden name='na' property='state' />
			</td>
			<td style=" border-bottom:1 solid #000000; "><c:out value="${na.debtName}" /></td>
			<td align="center" style=" border-bottom:1 solid #000000; "><c:out value="${na.capitalSerial}" /></td>
			<td align="center" style=" border-bottom:1 solid #000000; "><c:out value="${na.interestSerial}" /></td>
			<td align="right" style=" border-bottom:1 solid #000000; "><bean:define id="capitalAmount" name="na"
				property="capitalAmount" type="java.math.BigDecimal" /> <%java.text.NumberFormat formatter = new java.text.DecimalFormat(
						"#,###");
				out.print((capitalAmount != null) ? formatter
						.format(capitalAmount) : "0");

				%></td>
			<td  align="right" style=" border-bottom:1 solid #000000; "><bean:define id="interestAmount" name="na"
				property="interestAmount" type="java.math.BigDecimal" /> <%out.print((interestAmount != null) ? formatter
						.format(interestAmount) : "0");

				%></td>
			<td style=" border-bottom:1 solid #000000; ">
				<logic:notEmpty name="na" property="repayHandle">
					<bean:define id='repayHandle' name='na' property='repayHandle'
					type="java.util.Date" /> <%=DateUtil.date2ROCStr(repayHandle)%>
				</logic:notEmpty>
			</td>
			<td style=" border-bottom:1 solid #000000; ">
				<c:out value="${na.repayNumber}" />
			</td>
			<td style=" border-bottom:1 solid #000000; ">
				<logic:notEmpty name="na" property="accountDate">
					<bean:define id='accountDate' name='na' property='accountDate'
					type="java.util.Date" /> <%=DateUtil.date2ROCStr(accountDate)%>
				</logic:notEmpty>
			</td>
			<td style=" border-bottom:1 solid #000000; ">
				<c:out value="${na.accountNumber}" />
			</td>
			<td style=" border-bottom:1 solid #000000; ">
				<c:out value="${na.fundNumber}" />
			</td>
			<td style=" border-bottom:1 solid #000000; ">
				<logic:notEmpty name="na" property="secretaryDate">
					<bean:define id='secretaryDate' name='na' property='secretaryDate'
					type="java.util.Date" /> <%=DateUtil.date2ROCStr(secretaryDate)%>
				</logic:notEmpty>
			</td>
		</tr>
	</c:forEach>
</table>
