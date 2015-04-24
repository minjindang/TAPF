<!--
程式目的：HAMA05文字
程式代號：HAMA05
程式日期：1000914
程式作者：Powen Hsueh
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>

<html:hidden name='Hama0501Form' property='id'/>
<html:hidden name='Hama0501Form' property='usrid'/>

<table class='table_1' width='100%'>	
	<tr>
		<td class='table_item'>地方政府比例：</td>
		<td class='table_td'>
			<html:text name='Hama0501Form' style="text-align: right" property='nation' size='14' maxlength='24'/>
		</td>
	</tr>	
	<tr>
		<td class='table_item'>利息比例：</td>
		<td class='table_td'>
			<html:text name='Hama0501Form' style="text-align: right" property='interest' size='14' maxlength='24'/>
		</td>
	</tr>
</table>
