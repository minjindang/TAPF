<!-- EAMA0101QBar.jsp
程式目的：EAMA01
程式代號：EAMA01
程式日期：0950306
程式作者：Linus.Tseng
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_function' align='right'>
			<html:submit styleClass='formcss_rbutton' property='doQry' value='查詢'/>
			<html:submit styleClass='formcss_rbutton' property='goAdd' value='到新增'/>
			<html:button styleClass='formcss_rbutton' property='doClear' value='清畫面' onclick="clearForm(this.form)"/>
		</td>
	</tr>
</table>