<!--
程式目的：HARA04文字
程式代號：HARA04
程式名稱：HARA0401QBar.jsp
程式日期：0950221
程式作者：Andrew Sung
程式內容：受分配單位分配比例資料查詢列印
程式說明：提供使用者查詢及列印各分配單位的分配比例
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_function' align='right'>
			<html:submit styleClass='formcss_rbutton' property='doQry' value='查詢'/>
		</td>
	</tr>
</table>
