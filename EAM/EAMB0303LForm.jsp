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
<%@ taglib uri="/tags/displaytag" prefix="display" %>
<table class='table_1' width='100%'>
	<tr>
		<td>
			<display:table class="table_list" name="collection" id="row">
				<display:column title="�|�p�N��" property="accountCode.accountCode"  href="EAMA0210" paramId="id" paramProperty="id"/>
				<display:column title="�|�p�W��" property="accountCode.accountName"/>
				<display:column title="��/�U��">
					<bean:define id="dc" name="row" property="accountType"/>
					<logic:equal name="dc" value="D">
						��
					</logic:equal>
					<logic:equal name="dc" value="C">
						�U
					</logic:equal>
				</display:column>
			</display:table>
		</td>
	</tr>
</table>
