<!-- HAMB0101QForm.jsp
�{���ت��GHAMB01��r
�{���N���GHAMB01
�{������G0950220
�{���@�̡GEric.Chen
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>�O�b�~��:</td>
		<td class='table_td'>
			<html:select name="Hamb0101Form" property="allYear" onchange="form.action='HAMC01'; form.submit();">
				<html:option value = "">�п��</html:option>
				<html:optionsCollection name="Hamb0101Form" property="allYearList" label="label" value="valuess" />
			</html:select>
		</td>
	</tr>
	
	<tr>
		<td class='table_item'>���t�~��:</td>
		<td class='table_td'>
			<html:select name="Hamb0101Form" property="allMonth">
				<html:option value = "">�п��</html:option>
				<html:optionsCollection name="Hamb0101Form" property="allMonthList" label="label" value="valuess" />
			</html:select>
		</td>
	</tr>
	<html:hidden name="Hamb0101Form" property="monKind" value="2"/>
</table>
