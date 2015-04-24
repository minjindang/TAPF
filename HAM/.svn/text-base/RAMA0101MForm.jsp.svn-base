<!-- RAMA0101MForm.jsp
程式目的：RAMA01
程式代號：RAMA01
程式日期：1001005
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
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ page import="gov.dnt.tame.util.DateUtil,java.math.BigDecimal"%>
<input type="button" id='btnGroupthree' value ='縮放' onclick='trigerForGroupThree();' />
<table class='table_1' width='100%' id='grid'>

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
		<td colspan="3" name="forgroupthree" >會計室</td>
		<td name="forgroupthree" >秘書室</td>
	</tr>
	<tr class='table_item' align="center">
		<td>還本付息<br />簽辦日期</td>
		<td rowspan="2">文號</td>
		<td name="forgroupthree" >開立憑單<br />日期</td>
		<td rowspan="2" name="forgroupthree" >付款憑單<br />
		編號</td>
		<td rowspan="2" name="forgroupthree" >債務基金<br />
		憑單編號</td>
		<td name="forgroupthree" >檢送付款<br />憑單日期</td>
	</tr>
	<tr class='table_item' align="center">
		<td>年月日</td>
		<td>年月日</td>
		<td name="forgroupthree" >年月日</td>
		<td name="forgroupthree" >年月日</td>
	</tr>
	<%int row_rowNum = 0;

			%>
	<c:forEach items="${collection}" var="na" varStatus="status">
		<%row_rowNum++;%>
		<tr onclick="setRowIndex(this)" >
			<td style=" border-bottom:1 solid #000000; "><bean:define id='repayDate' name='na' property='repayDate'
				type="java.util.Date" /> <%=DateUtil.date2ROCStr(repayDate)%>
			<html:hidden name='na' property='id' />
			<html:hidden name='na' property='state' />
			</td>
			<td style=" border-bottom:1 solid #000000; ">
				<c:out value="${na.debtName}" />
			</td>
			<td align="center" style=" border-bottom:1 solid #000000; ">
				<c:out value="${na.capitalSerial}" />
			</td>
			<td align="center" style=" border-bottom:1 solid #000000; ">
				<c:out value="${na.interestSerial}" />
			</td>
			<td align="right" style=" border-bottom:1 solid #000000; "><bean:define id="capitalAmount" name="na"
				property="capitalAmount" type="java.math.BigDecimal" /> <%java.text.NumberFormat formatter = new java.text.DecimalFormat(
						"#,###");
				out.print((capitalAmount != null) ? formatter
						.format(capitalAmount) : "0");

				%>
				<input type="hidden" name="capitalAmount" value='<c:out value="${na.capitalAmount}" />'  />
			</td>
			<td  align="right" style=" border-bottom:1 solid #000000; "><bean:define id="interestAmount" name="na"
				property="interestAmount" type="java.math.BigDecimal" /> <%out.print((interestAmount != null) ? formatter
						.format(interestAmount) : "0");

				%>
				<input type="hidden" name="interestAmount" value='<c:out value="${na.interestAmount}" />'  />
			</td>
			<td style=" border-bottom:1 solid #000000; ">
				<logic:notEmpty name="na" property="repayHandle">
					<bean:define id="repayHandle" name="na" property="repayHandle" type="java.util.Date"></bean:define>
					
					<input type="text" name='repayHandle' id='repayHandle<%=row_rowNum %>' size='7' value='<%=DateUtil.date2ROCStr(repayHandle)%>' maxlength='7' onchange='checkPermission(1);' />
				</logic:notEmpty>
				<logic:empty name="na" property='repayHandle'>						
					
					<input type="text" name='repayHandle' id='repayHandle<%=row_rowNum %>' size='7' value='<c:out value="${na.repayHandle}" />' onchange='checkPermission(1);' maxlength='7' />
				</logic:empty>
				<%=tw.gov.nta.central.common.NationalDebtDueDateMainController.addCalendar("repayHandle" + row_rowNum,new Integer(row_rowNum),1)%>
			</td>
			<td style=" border-bottom:1 solid #000000; ">
				<html:text name='na' property='repayNumber' size='10' maxlength='10'  onchange='checkPermission(1);'/>
			</td>
			<td name="forgroupthree" style=" border-bottom:1 solid #000000; ">
				<logic:notEmpty name="na" property="accountDate">
					<bean:define id="accountDate" name="na" property="accountDate" type="java.util.Date"></bean:define>
					
					<input type="text" name='accountDate' id='accountDate<%=row_rowNum %>' size='7' value='<%=DateUtil.date2ROCStr(accountDate)%>' maxlength='7' onchange='checkPermission(2);' />
				</logic:notEmpty>
				<logic:empty name="na" property='accountDate'>						
					
					<input type="text" name='accountDate' id='accountDate<%=row_rowNum %>' size='7' value='<c:out value="${na.accountDate}" />' onchange='checkPermission(2);' maxlength='7' />
				</logic:empty>
				<%=tw.gov.nta.central.common.NationalDebtDueDateMainController.addCalendar("accountDate" + row_rowNum,new Integer(row_rowNum*100),2)%>
			</td>
			<td name="forgroupthree" style=" border-bottom:1 solid #000000; ">
				<html:text name='na' property='accountNumber' size='10' onchange='checkPermission(2);'/>
			</td>
			<td name="forgroupthree" style=" border-bottom:1 solid #000000; ">
				<html:text name='na' property='fundNumber' size='10' onblur='checkPermission(2);'/>
			</td>
			<td name="forgroupthree" style=" border-bottom:1 solid #000000; ">
				<logic:notEmpty name="na" property="secretaryDate">
					<bean:define id="secretaryDate" name="na"  property="secretaryDate" type="java.util.Date"></bean:define>
					
					<input type="text" name='secretaryDate' id='secretaryDate<%=row_rowNum %>' size='7' value='<%=DateUtil.date2ROCStr(secretaryDate)%>' maxlength='7' onchange='checkPermission(3);' />
				</logic:notEmpty>
				<logic:empty name="na" property='secretaryDate'>						
					
					<input type="text" name='secretaryDate' id='secretaryDate<%=row_rowNum %>' size='7' value='<c:out value="${na.secretaryDate}" />' onchange='checkPermission(3);' maxlength='7' />
				</logic:empty>
				<%=tw.gov.nta.central.common.NationalDebtDueDateMainController.addCalendar("secretaryDate" + row_rowNum,new Integer(row_rowNum*1000),3)%>
			</td>
		</tr>
	</c:forEach>
</table>
<input type="hidden" id="clickedRowIndex"  />
<input type="hidden"
	value='<%= request.getAttribute("CurrentUserDeptId") %>'
	name='CurrentUserDeptId' />

