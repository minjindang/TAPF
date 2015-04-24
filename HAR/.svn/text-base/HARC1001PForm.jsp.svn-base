<!-- HARB0801PForm.jsp
程式目的：HARB08文字
程式代號：HARB08
程式日期：0950221
程式作者：Eric.Chen
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>
<html:hidden name='Harb1001Form' property='monKind' value="2"/>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>記帳年度</td>
		<td class='table_td'>
			<html:select name="Harb1001Form" property="supYear" onchange="form.action='HARC10'; form.submit();">
				<html:option value = "">請選擇</html:option>
				<html:optionsCollection name="Harb1001Form" property="supYearList" label="label" value="valuess" />
			</html:select>
		</td>
	</tr>
	<tr>
		<td class='table_item'>撥款年月</td>
		<td class='table_td'>
			<html:select name="Harb1001Form" property="supMonth">
				<html:option value = "">請選擇</html:option>
				<html:optionsCollection name="Harb1001Form" property="supMonthList" label="label" value="valuess" />
			</html:select>
		</td>
	</tr>
</table>
