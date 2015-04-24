<!-- HAMB0101QForm.jsp
程式目的：HAMB01文字
程式代號：HAMB01
程式日期：0950220
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
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>記帳年度:</td>
		<td class='table_td'>
			<html:select name="Hamb0101Form" property="allYear" onchange="form.action='HAMC01'; form.submit();">
				<html:option value = "">請選擇</html:option>
				<html:optionsCollection name="Hamb0101Form" property="allYearList" label="label" value="valuess" />
			</html:select>
		</td>
	</tr>
	
	<tr>
		<td class='table_item'>分配年月:</td>
		<td class='table_td'>
			<html:select name="Hamb0101Form" property="allMonth">
				<html:option value = "">請選擇</html:option>
				<html:optionsCollection name="Hamb0101Form" property="allMonthList" label="label" value="valuess" />
			</html:select>
		</td>
	</tr>
	<html:hidden name="Hamb0101Form" property="monKind" value="2"/>
</table>
