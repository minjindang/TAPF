<!-- DIMA0101MBar.jsp
程式目的：DIMA01
程式代號：DIMA01
程式日期：0950223
程式作者：Eric.Chen
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_function' align='right'>
			<html:submit styleClass='formcss_rbutton' property='doUpd' value='更新' onclick="javascript:return(checkValue(this.form));"/>
			<html:reset styleClass='formcss_rbutton' property='reset' value='復原'/>
			<html:submit styleClass='formcss_rbutton' property='doDel' value='刪除'/>
			<html:submit styleClass='formcss_rbutton' property='doQry' value='回上一頁'/>
			<html:submit styleClass='formcss_rbutton' property='goAdd' value='到新增'/>
			<html:submit styleClass='formcss_rbutton' property='goQry' value='到查詢'/>
		</td>
	</tr>
</table>