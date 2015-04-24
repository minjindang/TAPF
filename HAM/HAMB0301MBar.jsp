<!-- HAMB0301MBar.jsp
程式目的：HAMB03
程式代號：HAMB03
程式日期：0950221
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
			<html:submit styleClass='formcss_rbutton' property='doCount' value='試算' onclick="javascript:return(checkValue(this.form));"/>
			<html:submit styleClass='formcss_rbutton' property='doUpd' value='分配確認' onclick="javascript:return(checkValue1(this.form));"/>
		</td>
	</tr>
</table>
