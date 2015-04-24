<!--
程式目的：HARA04文字
程式代號：HARA04
程式名稱：HARA0401QForm.jsp
程式日期：0950221
程式作者：Andrew Sung
程式內容：受分配單位分配比例資料查詢列印
程式說明：提供使用者查詢及列印各分配單位的分配比例
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>受分配單位代號</td>
		<td class='table_td'>
			<!-- 使用複合式下拉選單(共用元件) -->
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.central.common.UnitInfo.getUnitInfoMain(),"id",10)%>
		</td>
		<td class='table_td'>
		</td>
	</tr>
	<tr>
		<td class='table_item'>受分配單位名稱</td>
		<td class='table_td'>
			<html:text name='Hara0401Form' property='unitName' size='60' maxlength='100' onfocus="this.value=this.form.id_options.options[this.form.id_options.selectedIndex].text"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>記帳年度</td>
		<td class='table_td'>
			<html:text name='Hara0401Form' property='tyear' size='3' maxlength='3'/>
		</td>
	</tr>
</table>
