<!-- HAMB0201MForm.jsp
�{���ت��GHAMB02
�{���N���GHAMB02
�{������G0950222
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
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'><font color="red">*</font>�O�b�~��</td>
		<td class='table_td'>
			<html:text name='Hamb0201Form' property='taxYear' size='60' maxlength='3' onblur = 'getHiddenValues()'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>���t�~��</td>
		<td class='table_td'>
			<html:text name='Hamb0201Form' property='taxMonth' size='60' maxlength='5' onblur = 'getHiddenValues()'/>
		</td>
	</tr>
	<html:hidden name="Hamb0201Form" property="taxKind"/>
	<html:hidden name="Hamb0201Form" property="id"/>
	<tr>
		<td class='table_item'><font color="red">*</font>�帹</td>
		<td class='table_td'>
			<html:text name='Hamb0201Form' property='monNo' size='60' maxlength='20'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>�״ڦ�渹</td>
		<td class='table_td'>
			<html:text name='Hamb0201Form' property='bankno' size='60' maxlength='20'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>����</td>
		<td class='table_td'>
			<logic:notEmpty name="Hamb0201Form" property='monKind'>
				<bean:define id="monKind" name="Hamb0201Form" property="monKind" type="java.lang.String"/>
				<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("MK"),"monKind",monKind)%>
			</logic:notEmpty>
			<logic:empty name="Hamb0201Form" property='monKind'>
				<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("MK"),"monKind")%>
			</logic:empty>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>�״ڤH�m�W</td>
		<td class='table_td'>
			<html:text name='Hamb0201Form' property='pname' size='60' maxlength='100'/>
		</td>
	</tr>
</table>
