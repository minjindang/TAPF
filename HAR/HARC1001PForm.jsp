<!-- HARB0801PForm.jsp
�{���ت��GHARB08��r
�{���N���GHARB08
�{������G0950221
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
<html:hidden name='Harb1001Form' property='monKind' value="2"/>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>�O�b�~��</td>
		<td class='table_td'>
			<html:select name="Harb1001Form" property="supYear" onchange="form.action='HARC10'; form.submit();">
				<html:option value = "">�п��</html:option>
				<html:optionsCollection name="Harb1001Form" property="supYearList" label="label" value="valuess" />
			</html:select>
		</td>
	</tr>
	<tr>
		<td class='table_item'>���ڦ~��</td>
		<td class='table_td'>
			<html:select name="Harb1001Form" property="supMonth">
				<html:option value = "">�п��</html:option>
				<html:optionsCollection name="Harb1001Form" property="supMonthList" label="label" value="valuess" />
			</html:select>
		</td>
	</tr>
</table>
