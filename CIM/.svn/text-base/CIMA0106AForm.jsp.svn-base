<!-- CIMA0105AForm.jsp
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
	<tr>
		<td class='table_item'>原始借款期限</td>
		<td class='table_td'>
		<bean:write name='Cima0101Form' property='date(issueDate)'/>~
		<bean:write name='Cima0101Form' property='date(dueDate)'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>延長借款期限</td>
		<td class='table_td'>
			<input type="text" name="newDueDate" size="7" onblur="checkDueDate(this.form)">
			<%=gov.dnt.tame.util.CommonFun.addCalendar("newDueDate",new Integer(0))%>
		</td>
	</tr>
</table>
