<!--
程式目的：歸扣借資料維護-資料匯入EXCEL
程式代號：HAMA0410
程式日期：1021111
程式作者：Abner Chiu
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
		<td class='table_item' width='30%'><font color="red">*</font>記帳年度</td>
		<td class='table_td'>
			<%request.setAttribute("impYearList",tw.gov.nta.central.common.UnitAllocate.getImpYearLabelList()); %>
			<html:select name="Hamb0401Form" property="impYear">
				<html:optionsCollection name="impYearList"  label="label" value="valuess" />
			</html:select>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>類別</td>
		<td class='table_td'>
			<html:select name="Hamb0401Form" property="impMonKind">
				<html:option value="1">普通</html:option>
				<html:option value="2">專案補助</html:option>
			</html:select>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>檔案路徑</td>
		<td class='table_td'>
			<html:file name='Hamb0401Form' property='filePath' size='60' maxlength='255'/>
		</td>
	</tr>
	<tr>
			<td class='table_item'>
				<font color="red">*</font><html:link action="/Download">資料匯入範本</html:link><br/>
				<font color="red">*</font>註二：檔案副檔名限定為.xls
			</td>
	</tr>
</table>
