<!-- GAMA0904MBar.jsp
程式目的：GAMA09
程式代號：GAMA09
程式日期：0980409
程式作者：Chris
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_function' align='right'>
			<html:submit styleClass='formcss_rbutton' property='doUpdRate' value='更新' onclick="javascript:return(checkValue(this.form));"/>
			<html:reset styleClass='formcss_rbutton' property='reset' value='復原'/>
			<html:submit styleClass='formcss_rbutton' property='doDelRate' value='刪除'/>
			<html:submit styleClass='formcss_rbutton' property='goUp2' value='回上頁'/>
		</td>
	</tr>
</table>