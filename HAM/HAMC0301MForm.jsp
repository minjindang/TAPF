<!-- HAMB0301MForm.jsp
�{���ت��GHAMB03
�{���N���GHAMB03
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
<%@ taglib uri="/tags/displaytag" prefix="display" %>
<bean:define id="taxKind" name="Hamb0301Form" property="taxKind" type="java.lang.String"/>
<%=gov.dnt.tame.util.CommonFun.checkOfConfirm(tw.gov.nta.central.common.Taxaction.getAlloted(taxKind),"valuess","tValue","checkAlloted","����w���t�A�O�_���s���t?")%>

<%=gov.dnt.tame.util.CommonFun.checkOfAlert(tw.gov.nta.central.common.UnitAllocate.getAllotedByIsOkList(taxKind),"valuess","xValue","checkIsOk","����w�T�{���I")%>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'><font color="red">*</font>�O�b�~��</td>
		<td class='table_td'>
			<html:text name='Hamb0301Form' property='taxYear' size='3' maxlength='3'
				onblur=";getHiddenValues();"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>���t�~��</td>
		<td class='table_td'>
			<html:text name='Hamb0301Form' property='taxMonth' size='5' maxlength='5'
				onblur="this.value=parseMonth(this.value);getHiddenValues();"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>��|���J</td>
		<td class='table_td'>
			<html:text name='Hamb0301Form' style="text-align: right" property='bigDecimal(nationTax)' size='15' />��
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>�a�覬�J</td>
		<td class='table_td'>
			<html:text name='Hamb0301Form' style="text-align: right" property='bigDecimal(localTax)' size='15' />��
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>�Q�����J</td>
		<td class='table_td'>
			<html:text name='Hamb0301Form' style="text-align: right" property='bigDecimal(intTax)' size='15' />��
		</td>
	</tr>
	<tr>
		<td class='table_item'>������(���^)���B</td>
		<td class='table_td'>
			<html:text name='Hamb0301Form' style="text-align: right" property='bigDecimal(fillAmount)' size='15' />��
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>�w�w���I</td>
		<td class='table_td'>
			<html:text name='Hamb0301Form' style="text-align: right" size='15' property='bigDecimal(totMon)' readonly = "true"/>��
		</td>
	</tr>
	<html:hidden name="Hamb0301Form" property="taxKind"/>
	<html:hidden name="Hamb0301Form" property="id"/>
</table>
