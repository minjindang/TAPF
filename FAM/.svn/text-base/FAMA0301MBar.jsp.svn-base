<!--
程式目的：HARA04文字
程式代號：HARA04
程式日期：0950221
程式作者：FormBean Generator
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_function' align='right'>
			<html:submit styleClass='formcss_rbutton' property='doUpd' value='更新'onclick="javascript:return(checkValue(this.form));"/>
			
			<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
			<logic:equal name='Fama0301Form' property='qry' value='Y' >
				<html:submit styleClass='formcss_rbutton' property='doQry' value='回查詢'/>
			</logic:equal>
			<logic:equal name='Fama0301Form' property='qry' value='N' >
				<html:submit styleClass='formcss_rbutton' property='goAdd' value='回新增'/>
			</logic:equal>
			
			<html:submit styleClass='formcss_rbutton' property='doDel' value='刪除'/>
		</td>
	</tr>
</table>
