<!--
�{���ت��GFAMA04��r
�{���N���GFAMA04
�{������G0950223
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
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>���洫�Ъ��N��</td>
		<td class='table_td'>
			<html:text name='Fama0401Form' property='stockId' size='10' maxlength='10'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>���洫�Ъ��W��</td>
		<td class='table_td'>
			<html:text name='Fama0401Form' property='stockName' size='60' maxlength='200'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�Ƶ�</td>
		<td class='table_td'>
			<html:text name='Fama0401Form' property='remark' size='60' maxlength='100'/>
		</td>
	</tr>
</table>
<html:hidden name='Fama0401Form'property='id'/>
<html:hidden name='Fama0401Form' property="qryStockName"/>
<html:hidden name='Fama0401Form' property="qryStockId"/>
<html:hidden name='Fama0401Form' property="date(createDate)"/>