<!--
程式目的：銀行歷年簽約額度報表
程式代號：DIRA14
程式日期：0980310
程式作者：chris
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'><font color='red'>*</font>年度:</td>
		<td class='table_td'>
			<html:text name='Dira1401Form' property='accountYear' size='3' maxlength='3'/>
			
		</td>
	</tr>
</table>