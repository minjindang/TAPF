<!-- CIMA0101QForm.jsp
�{���ت��GCIMA01
�{���N���GCIMA01
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
<table class='table_1' width='100%'>
<html:hidden name='Cima0101Form' property='id'/>
<html:hidden name='Cima0101Form' property='qryaccountYear'/>
<html:hidden name='Cima0101Form' property='qryserialNo'/>
<html:hidden name='Cima0101Form' property='qryissueSerial'/>
<html:hidden name='Cima0101Form' property='qrydebtName'/>
<html:hidden name='Cima0101Form' property='date(issueDate)'/>
<html:hidden name='Cima0101Form' property='date(dueDate)'/>	
<html:hidden name='Cima0101Form' property='bankId'/>
<html:hidden name='Cima0101Form' property='nowindex' />
<html:hidden name='Cima0101Form' property='debtId'/>
	<tr>
		<td class='table_item'><font color="red">*</font>�Q�v�ͮĤ��</td>
		<td class='table_td'>
			<html:text name='Cima0101Form' property='date(effectiveDate)' size='50' maxlength='7' onblur=""/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(effectiveDate)")%>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>�Q�v�פ���</td>
		<td class='table_td'>
			<html:text name='Cima0101Form' property='date(suspendDate)' size='50' maxlength='7' onblur=""/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(suspendDate)")%>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>�Q�v</td>
		<td class='table_td'>
			<html:text name='Cima0101Form' style="text-align: right" property='bigDecimal(debtRate)' size='50' maxlength='20' onmousemove="rateLimit(this.form)"/>
		</td>
	</tr>
</table>
