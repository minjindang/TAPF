<!--
程式目的：EAMA02文字
程式代號：EAMA02
程式日期：0950301
程式作者：FormBean Generator
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_function' align='right'>
			<html:submit styleClass='formcss_rbutton' property='doDetQry' value='回清單'/>
			<html:submit styleClass='formcss_rbutton' property='doDetUpd' value='更新' onclick="javascript:return(checkValue(this.form));"/>
			<html:submit styleClass='formcss_rbutton' property='goDetAdd' value='新增明細'/>
			<html:submit styleClass='formcss_rbutton' property='doDetDel' value='刪除'/>
			<html:reset  styleClass='formcss_rbutton' property='reset' value='復原'/>
		</td>
	</tr>
</table>
