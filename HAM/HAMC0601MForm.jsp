<!--
程式目的：HAMB06文字
程式代號：HAMB06
程式日期：0950220
程式作者：Andrew Sung
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
		<td class='table_item'><font color="red">*</font>記帳年度：</td>
		<td 'table_td'>
			<html:select name="Hamb0601Form" property="SUP_YEAR" onchange="form.action='HAMC06'; form.submit();">
				<html:option value = "">請選擇</html:option>
				<html:optionsCollection name="Hamb0601Form" property="supYearList" label="label" value="valuess" />
			</html:select>
		</td>
		
	</tr>	
	<tr>
		<td class='table_item'><font color="red">*</font>撥款年月：</td>
		<td 'table_td'>
			<html:select name="Hamb0601Form" property="SUP_MONTH">
				<html:option value = "">請選擇</html:option>
				<html:optionsCollection name="Hamb0601Form" property="supMonthList" label="label" value="valuess" />
			</html:select>
		</td>
		
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>匯款日期：</td>
		<td 'table_td'>
			<input type='text' name='SUP_DATE' maxlength='7' >
			<%=gov.dnt.tame.util.CommonFun.addCalendar("SUP_DATE")%>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>撥款次數：</td>
		<td 'table_td'>
			<input type='text' name='supCount' maxlength='10'>
		</td>
	</tr>
</table>
