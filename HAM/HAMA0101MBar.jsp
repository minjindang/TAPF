<!--
程式目的：受分配單位資料維護
程式代號：HAMA01
程式日期：0950218
程式作者：JackDu
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_function' align='right'>
			<html:submit styleClass='formcss_rbutton' property='doUpd' value='更新'/>
			<html:reset  styleClass='formcss_rbutton' property='reset' value='復原'/>
			<html:submit styleClass='formcss_rbutton' property='doQry' value='回上頁'/>
			<html:submit styleClass='formcss_rbutton' property='goQry' value='到查詢'/>
		</td>
	</tr>
</table>
