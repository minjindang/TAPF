<!--
�{���ت��GAIMA01��r
�{���N���GAIMA01
�{������G0950306
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

<table class='table_1'>
<tr>
	<th class='table_item'>��إN��</th>
	<th class='table_item'>��ئW��</th>
	<th class='table_item'>�ɤ���B</th>
	<th class='table_item'>�U����B</th>
</tr>
<logic:iterate id="detail" name="Eamb0103Form" property="voucherDets">
	<tr>
		<td class='table_td'>
			<bean:write name="detail" property="account.accountCode"/>
		</td>
		<td class='table_td'>
			<bean:write name="detail" property="account.accountName"/>
		</td>
		<td class='table_td'>
			<div align="right">
				<logic:equal value="D" name="detail" property="accountType">
					<bean:write name="detail" property="accountAmount" format="#,###"/>
				</logic:equal> 	�@
			</div>
			�@
		</td>
		<td class='table_td'>
			<div align="right">
				<logic:equal value="C" name="detail" property="accountType">
					<bean:write name="detail" property="accountAmount" format="#,###"/>
				</logic:equal> 
			</div>
			�@
		</td>
	</tr>
</logic:iterate>
</table>
