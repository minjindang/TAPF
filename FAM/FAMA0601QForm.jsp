<!-- FAMA0601QForm.jsp
程式目的：FAMA06
程式代號：FAMA06
程式日期：0950222
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
	<tr>
		<td class='table_item'>國別代號</td>
		<td class='table_td'>
			<html:text name='Fama0601Form' property='qrynationNo' size='50' maxlength='5'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>洲別代號</td>
		<td class='table_td'>
			<html:text name='Fama0601Form' property='qrycontinentNo' size='50' maxlength='1'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>國家中文名稱</td>
		<td class='table_td'>
			<html:text name='Fama0601Form' property='qrynationCname' size='50' maxlength='50'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>國家英文名稱</td>
		<td class='table_td'>
			<html:text name='Fama0601Form' property='qrynationEname' size='50' maxlength='50'/>
		</td>
	</tr>
</table>
