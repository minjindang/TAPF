<!-- DIMA0201ABar.jsp
程式目的：DIMA02
程式代號：DIMA02
程式日期：0950223
程式作者：Andrew Sung
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
			<html:reset styleClass='formcss_rbutton' property='doClear' value='復原'/>
			<html:submit styleClass='formcss_rbutton' property='doDel' value='刪除'/>
			<html:submit styleClass='formcss_rbutton' property='goQry' value='到查詢'/>
			<html:submit styleClass='formcss_rbutton' property='goList' value='回上一頁'/>
			<html:submit styleClass='formcss_rbutton' property='goAdd' value='到新增'/>
			<html:submit styleClass='formcss_rbutton' property='goQry' value='到查詢'/>
			<html:submit styleClass='formcss_rbutton' property='goBankAdd' value='銀行資料新增'/>
			<html:submit styleClass='formcss_rbutton' property='doAccrue' value='確認得標'/>
		</td>
	</tr>
</table>