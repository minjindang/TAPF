<!--
�{���ت��GHAMA06��r
�{���N���GHAMA06
�{������G1000915
�{���@�̡GFormBean Generator
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>
<%=gov.dnt.tame.util.CommonFun.checkOfConfirm(tw.gov.nta.central.common.UnitPercent.getYearLabelList(),"valuess","tValue","checkYear","���~�פw�פJ���t��ҡA�O�_���s�פJ?")%>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item' width='30%'>*�O�b�~��</td>
		<td class='table_td'>
			<html:text name='Hama0601Form' property='qryYear' size='10' maxlength='10'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�ɮ׸��|</td>
		<td class='table_td'>
			<html:file name='Hama0601Form' property='filePath' size='60' maxlength='255'/>
		</td>
	</tr>
</table>
