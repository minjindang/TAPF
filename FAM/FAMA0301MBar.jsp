<!--
�{���ت��GHARA04��r
�{���N���GHARA04
�{������G0950221
�{���@�̡GFormBean Generator
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_function' align='right'>
			<html:submit styleClass='formcss_rbutton' property='doUpd' value='��s'onclick="javascript:return(checkValue(this.form));"/>
			
			<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
			<logic:equal name='Fama0301Form' property='qry' value='Y' >
				<html:submit styleClass='formcss_rbutton' property='doQry' value='�^�d��'/>
			</logic:equal>
			<logic:equal name='Fama0301Form' property='qry' value='N' >
				<html:submit styleClass='formcss_rbutton' property='goAdd' value='�^�s�W'/>
			</logic:equal>
			
			<html:submit styleClass='formcss_rbutton' property='doDel' value='�R��'/>
		</td>
	</tr>
</table>
