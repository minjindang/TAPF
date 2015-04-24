<!--
程式目的：HAMA06文字
程式代號：HAMA06
程式日期：1000915
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
<%=gov.dnt.tame.util.CommonFun.checkOfConfirm(tw.gov.nta.central.common.UnitPercent.getYearLabelList(),"valuess","tValue","checkYear","本年度已匯入分配比例，是否重新匯入?")%>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item' width='30%'>*記帳年度</td>
		<td class='table_td'>
			<html:text name='Hama0601Form' property='qryYear' size='10' maxlength='10'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>檔案路徑</td>
		<td class='table_td'>
			<html:file name='Hama0601Form' property='filePath' size='60' maxlength='255'/>
		</td>
	</tr>
</table>
