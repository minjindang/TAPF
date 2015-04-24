<!-- CIMA0104MBar.jsp
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
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_function' align='right'>
			<html:submit styleClass='formcss_rbutton' property='doUpdCap' value='更新'/>
			<html:reset styleClass='formcss_rbutton' property='reset' value='復原'/>
			<logic:equal value=""  scope="" parameter="showDate">
				<html:submit styleClass='formcss_rbutton' property='doDelCap' value='刪除'/>
			</logic:equal>
			<html:submit styleClass='formcss_rbutton' property='goUp2' value='回上頁'/>
		</td>
	</tr>
</table>