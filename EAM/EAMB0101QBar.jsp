<!--
�{���ت��GEAMA02��r
�{���N���GEAMA02
�{������G0950301
�{���@�̡GFormBean Generator
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_function' align='right'>
			<html:submit styleClass='formcss_rbutton' property='doQry' value='�d��'/>
			<logic:notEmpty name="collection">
				<%	//�S��ǲ����i��妸���Ͷǲ�
					if (!"3".equals(String.valueOf(((String)session.getAttribute("SYSID")).charAt(5)))){%>
					<html:submit styleClass='formcss_rbutton' property='batchMakeVoucher' value='�妸���Ͷǲ�'/>
				<%}%>
			</logic:notEmpty>
			<html:reset  styleClass='formcss_rbutton' property='reset' value='�M��'/>
		</td>
	</tr>
</table>
