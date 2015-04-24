<!-- GAMA0101ABar.jsp
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
			<html:submit styleClass='formcss_rbutton' property='doAdd' value='新增' onclick="javascript:return(checkValue(this.form));"/>
			<html:button styleClass='formcss_rbutton' property='doClear' value='清畫面' onclick="clearForm(this.form)"/>
			<html:submit styleClass='formcss_rbutton' property='goQry' value='到查詢' />
		</td>
	</tr>
</table>