<!--
�{���ت��GRAMA0101��r
�{���N���GRAMA0101
�{������G1001027
�{���@�̡GPowen Hsueh
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
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
		<td rowspan="2">�����</td>
		<td rowspan="3">�ŰȧO</td>
		<td rowspan="3">�٥�<br />
		����</td>
		<td rowspan="3">�I��<br />
		����</td>
		<td rowspan="3">�٥�<br />
		���B</td>
		<td rowspan="3">�I��<br />
		���B</td>
		<td colspan="2">��3��</td>
		<td colspan="3">�|�p��</td>
		<td>���ѫ�</td>
	</tr>
	<tr class='table_item' align="center">
		<td>�٥��I��<br />ñ����</td>
		<td rowspan="2">�帹</td>
		<td>�}�߾̳�<br />���</td>
		<td rowspan="2">�I�ھ̳�<br />
		�s��</td>
		<td rowspan="2">�ŰȰ��<br />
		�̳�s��</td>
		<td>�˰e�I��<br />�̳���</td>
	</tr>
	<tr class='table_item' align="center">
		<td>�~���</td>
		<td>�~���</td>
		<td>�~���</td>
		<td>�~���</td>
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
