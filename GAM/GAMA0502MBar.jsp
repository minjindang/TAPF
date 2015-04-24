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
			<!--  html:submit styleClass='formcss_rbutton' property='doUpdDet' value='更新' onclick="return(checkForm(form));"/-->
			<html:submit styleClass='formcss_rbutton' property='doDelDet' value='刪除'/>
			<html:reset styleClass='formcss_rbutton' property='doClear' value='回復'/>
			<html:submit styleClass='formcss_rbutton' property='goQry' value='回查詢' />
			<html:submit styleClass='formcss_rbutton' property='blackMain' value='中央政府債務歷史資料維護' />
		</td>
	</tr>
</table>