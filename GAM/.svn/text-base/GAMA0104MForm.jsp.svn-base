<!-- CIMA0104AForm.jsp
程式目的：CIMA01
程式代號：CIMA01
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
<table class='table_1' width='100%'>
<html:hidden name='Cima0101Form' property='id'/>
<html:hidden name='Cima0101Form' property='qryaccountYear'/>
<html:hidden name='Cima0101Form' property='qryserialNo'/>
<html:hidden name='Cima0101Form' property='qryissueSerial'/>
<html:hidden name='Cima0101Form' property='qrydebtName'/>
<html:hidden name='Cima0101Form' property='date(issueDate)'/>
<html:hidden name='Cima0101Form' property='date(dueDate)'/>	
<html:hidden name='Cima0101Form' property='bankId'/>
<html:hidden name='Cima0101Form' property='debtId'/>	
<html:hidden name='Cima0101Form' property='nowindex' />
	<tr>
		<td class='table_item'><font color="red">*</font>還本付息日期</td>
		<td class='table_td'>
			<html:text name='Cima0101Form' property='date(repayDate)' size='10' maxlength='7' onblur=""/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(repayDate)")%>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>預計還本金額</td>
		<td class='table_td'>
			<html:text name='Cima0101Form' style="text-align: right" property='bigDecimal(capitalAmount)' size='50' maxlength='20'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>實際還本金額</td>
		<td class='table_td'>	
			<p align="right"><bean:write name='Cima0101Form' property='bigDecimal(capitalAmountDPT)' format='#,##0'/></p>
		</td>
	</tr>
	<tr>
		<td class='table_item'>實際付息金額</td>
		<td class='table_td' >
			<p align="right"><bean:write name='Cima0101Form' property='bigDecimal(interestAmountDPT)' format='#,##0'/></p>
		</td>
	</tr>
	<tr>
		<td class='table_item' >實付本息合計</td>
		<td class='table_td' >
			<p align="right"><bean:write name='Cima0101Form' property='bigDecimal(totalAmount)' format='#,##0'/></p>
		</td>
	</tr>
</table>
