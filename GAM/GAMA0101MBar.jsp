<!-- CIMA0101MBar.jsp
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
<table class='table_1' width='100%'>
	<tr>
		<td class='table_function' align='right'>
			<html:submit styleClass='formcss_rbutton' property='doUpd' value='更新' onclick="javascript:return(checkValue(this.form));"/>
			<html:reset styleClass='formcss_rbutton' property='reset' value='復原'/>
			<html:submit styleClass='formcss_rbutton' property='doDel' value='刪除'/>
			<html:submit styleClass='formcss_rbutton' property='goQry' value='回上一頁'/>
			<html:submit styleClass='formcss_rbutton' property='goAdd' value='到新增'/>
			<html:submit styleClass='formcss_rbutton' property='goQry' value='到查詢'/>
			<html:submit styleClass='formcss_rbutton' property='goAddBank' value='新增投標銀行'/>
			<html:submit styleClass='formcss_rbutton' property='goAddDebtPlan' value='新增借款計劃'/>
		</td>
	</tr>
</table>