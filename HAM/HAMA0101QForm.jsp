<!--
�{���ت��G�����t����ƺ��@
�{���N���GHAMA01
�{������G0950218
�{���@�̡GJackDu
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
		<td class='table_item' colspan="20%">�����t���N��</td>
		<td class='table_td' colspan="80%">
			<html:text name='Hama0101Form' property='qryUnit' size='20' maxlength='10'/>
		</td>
	</tr>
	<tr>
		<td class='table_item' colspan="20%">�����t���W��</td>
		<td class='table_td' colspan="80%">
			<logic:notEmpty name="Hama0101Form" property='qryUnitId'>
				<bean:define id="qryUnitId" name="Hama0101Form" property="qryUnitId" type="java.lang.String"/>
				<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.central.common.UnitInfo.getUnitInfoMain(),"qryUnitId",qryUnitId,10,false)%>
			</logic:notEmpty>
			<logic:empty name="Hama0101Form" property='qryUnitId'>
				<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.central.common.UnitInfo.getUnitInfoMain(),"qryUnitId",10,false)%>
			</logic:empty>
		</td>
	</tr>
	<tr>
		<td class='table_item' colspan="20%">���t�~��</td>
		<td class='table_td' colspan="80%">
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.central.common.UnitPercent.getYearLabelList(),"qryTyear",10,false)%>
		</td>
	</tr>
</table>