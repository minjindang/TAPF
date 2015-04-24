<!--
程式目的：中央登錄債券還本付息基金收付餘額月報總表
程式代號：AIRC06
程式日期：0950227
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
			<html:submit styleClass='formcss_rbutton' property='doPrt' value='開啟Excel'/>
			<html:reset  styleClass='formcss_rbutton' property='reset' value='清畫面'/>
		</td>
	</tr>
</table>