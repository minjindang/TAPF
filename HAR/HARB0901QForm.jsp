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
<%@ include file="/common/taglibs.jsp"%>
<html:hidden name='Harb0901Form' property='monKind' value="1"/>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>�������:</td>
		<td class='table_td'>
			<html:select name="Harb0901Form" property="prtKind">
				<html:option value = "0">�п��</html:option>
				<html:optionsCollection name="Harb0901Form" property="prtKindList2" label="label" value="valuess" />
			</html:select>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�O�_����:</td>
		<td class='table_td'>
			<html:select name="Harb0901Form" size="1" property="minus">
				<html:option value="">�п��</html:option>
				<html:option value="Y">�O</html:option>
				<html:option value="N">�_</html:option>
			</html:select>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�O�b�~��:</td>
		<td class='table_td'>
			<html:select name="Harb0901Form" property="supYear" onchange="form.action='HARB09'; form.submit();">
				<html:option value = "">�п��</html:option>
				<html:optionsCollection name="Harb0901Form" property="supYearList" label="label" value="valuess" />
			</html:select>
		</td>
	</tr>
	
	<tr>
		<td class='table_item'>���ڦ~��:</td>
		<td class='table_td'>
			<html:select name="Harb0901Form" property="supMonth">
				<html:option value = "">�п��</html:option>
				<html:optionsCollection name="Harb0901Form" property="supMonthList" label="label" value="valuess" />
			</html:select>
		</td>
	</tr>
	
</table>
