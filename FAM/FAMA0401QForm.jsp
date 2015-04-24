<!--
程式目的：FAMA04文字
程式代號：FAMA04
程式日期：0950223
程式作者：FormBean Generator
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>交換標的代號</td>
		<td class='table_td'>
			<html:text name='Fama0401Form' property='qryStockId' size='10' maxlength='10'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>交換標的名稱</td>
		<td class='table_td'>
			<html:text name='Fama0401Form' property='qryStockName' size='60' maxlength='200'/>
		</td>
	</tr>
</table>
