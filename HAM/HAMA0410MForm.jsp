<!--
�{���ت��G�k���ɸ�ƺ��@-��ƶפJEXCEL
�{���N���GHAMA0410
�{������G1021111
�{���@�̡GAbner Chiu
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
		<td class='table_item' width='30%'><font color="red">*</font>�O�b�~��</td>
		<td class='table_td'>
			<%request.setAttribute("impYearList",tw.gov.nta.central.common.UnitAllocate.getImpYearLabelList()); %>
			<html:select name="Hamb0401Form" property="impYear">
				<html:optionsCollection name="impYearList"  label="label" value="valuess" />
			</html:select>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>���O</td>
		<td class='table_td'>
			<html:select name="Hamb0401Form" property="impMonKind">
				<html:option value="1">���q</html:option>
				<html:option value="2">�M�׸ɧU</html:option>
			</html:select>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>�ɮ׸��|</td>
		<td class='table_td'>
			<html:file name='Hamb0401Form' property='filePath' size='60' maxlength='255'/>
		</td>
	</tr>
	<tr>
			<td class='table_item'>
				<font color="red">*</font><html:link action="/Download">��ƶפJ�d��</html:link><br/>
				<font color="red">*</font>���G�G�ɮװ��ɦW���w��.xls
			</td>
	</tr>
</table>
