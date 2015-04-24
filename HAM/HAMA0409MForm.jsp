<!--
程式目的：歸扣借資料維護-資料匯入上年度受分配金額
程式代號：HAMA0409
程式日期：0991018
程式作者：Chris Wu
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
		<td class='table_item' width='30%'><font color="red">*</font>撥款年月</td>
		<td class='table_td'>
			<html:text name='Hamb0401Form' property='qryYear' size='10' maxlength='10'/>ex:09909
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>檔案路徑</td>
		<td class='table_td'>
			<html:file name='Hamb0401Form' property='filePath' size='60' maxlength='255'/>
		</td>
	</tr>
</table>
