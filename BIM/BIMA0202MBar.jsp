<!-- BIMA0201MBar.jsp
程式目的：BIMA02
程式代號：BIMA02
程式日期：0950302
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
			<html:submit styleClass='formcss_rbutton' property='doDel2' value='刪除'/>
			<html:submit styleClass='formcss_rbutton' property='doUpd2' value='更新'/>
			<html:button styleClass='formcss_rbutton' property='doClear' value='清畫面' onclick="clearForm(this.form)"/>
			<html:submit styleClass='formcss_rbutton' property='goTick2' value='到新增債票'/>
			<html:submit styleClass='formcss_rbutton' property='goTick' value='回清單'/>
		</td>
	</tr>
</table>