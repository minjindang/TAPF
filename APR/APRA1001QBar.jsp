<!--	APRA1001QBar.jsp
程式目的：APRA10中央政府登錄公債核結累計表列印
程式代號：APRA10
程式日期：0950331
程式作者：ERIC CHEN
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->


<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_function' align='right'>
			<html:submit styleClass='formcss_rbutton' property='doPrt' value='開啟Excel' onclick="javascript:return(checkValue(this.form));"/>
			<html:button  styleClass='formcss_rbutton' property='reset' value='清畫面' onclick="clearForm(this.form)"/>
		</td>
	</tr>
</table>