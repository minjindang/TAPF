<!--
�{���ت��G�����t����ƺ��@
�{���N���GHAMA04
�{������G1000920
�{���@�̡GPowen Hsueh
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>
<%@ page import="gov.dnt.tame.util.Converter"%>
<%
	java.util.List list = new java.util.LinkedList();
	list.add(0, new gov.dnt.tame.common.LabelValueBean("","�п��"));
	list.add(1, new gov.dnt.tame.common.LabelValueBean("T","�O"));
	list.add(2, new gov.dnt.tame.common.LabelValueBean("F","�_"));

	pageContext.setAttribute("isMailList", list);
%>

<html:hidden name='Hama0401Form' property='id'/>
<html:hidden name='Hama0401Form' property='usrid'/>
<html:hidden name='Hama0401Form' property='groupid'/>
<html:hidden name='Hama0401Form' property='date(createDate)'/>
<html:hidden name='Hama0401Form' property='qryTyear'/>
<html:hidden name='Hama0401Form' property='qryUnitId'/>
<html:hidden name='Hama0401Form' property='qryUnit'/>
<html:hidden name="Hama0401Form" property="page"/>
<html:hidden name="Hama0401Form" property="seqNo"/>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>�����t���N��</td>
		<td class='table_td' colspan='3'>
			<html:text name='Hama0401Form' property='unitId' size='10' maxlength='10' readonly='true' />
		</td>
	</tr>
	<tr>
		<td class='table_item'>�����t���W��</td>
		<td class='table_td' colspan='3'>
			<html:text name='Hama0401Form' property='unitName' size='20' maxlength='100'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�����t���</td>
		<td class='table_td'>
			<bean:write name='Hama0401Form' property='tpercent'/>
			<logic:notEmpty name="Hama0401Form" property='qryTyear'>
				(���t�~��<bean:write name='Hama0401Form' property='qryTyear'/>�~)
			</logic:notEmpty>
		</td>
	</tr>
</table>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item' colspan='7'>[�Ѵڦ���]</td>
	</tr>
	<tr>
		<td class='table_item'>�������w��</td>
		<td class='table_item'>��W</td>
		<td class='table_td'>
			<html:text name='Hama0401Form' property='sbank1' size='20' maxlength='100'/>
		</td>
		<td class='table_item'>������</td>
		<td class='table_td'>
			<html:text name='Hama0401Form' property='sbranch1' size='20' maxlength='100'/>
		</td>
		<td class='table_item'>�渹</td>
		<td class='table_td'>
			<html:text name='Hama0401Form' property='sno1' size='20' maxlength='20'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�M�׸ɧU</td>
		<td class='table_item'>��W</td>
		<td class='table_td'>
			<html:text name='Hama0401Form' property='sbank2' size='20' maxlength='100'/>
		</td>
		<td class='table_item'>������</td>
		<td class='table_td'>
			<html:text name='Hama0401Form' property='sbranch2' size='20' maxlength='100'/>
		</td>
		<td class='table_item'>�渹</td>
		<td class='table_td'>
			<html:text name='Hama0401Form' property='sno2' size='20' maxlength='20'/>
		</td>
	</tr>
</table>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item' colspan='5'>[���ڳ����]</td>
	</tr>
	<tr>
		<td class='table_item'>�������w��</td>
		<td class='table_item'>��W</td>
		<td class='table_td'>
			<html:text name='Hama0401Form' property='tbank1' size='50' maxlength='100'/>
		</td>
		<td class='table_item'>�b��</td>
		<td class='table_td'>
			<html:text name='Hama0401Form' property='tacct1' size='20' maxlength='20'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�M�׸ɧU</td>
		<td class='table_item'>��W</td>
		<td class='table_td'>
			<html:text name='Hama0401Form' property='tbank2' size='50' maxlength='100'/>
		</td>
		<td class='table_item'>�b��</td>
		<td class='table_td'>
			<html:text name='Hama0401Form' property='tacct2' size='20' maxlength='20'/>
		</td>
	</tr>
</table>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item' colspan='6'>[���ڳ��]</td>
	</tr>
	<tr>
		<td class='table_item'>�ӿ�H�m�W</td>
		<td class='table_td'>
			<html:text name='Hama0401Form' property='tname' size='20' maxlength='20'/>
		</td>
		<td class='table_item'>�p���q��</td>
		<td class='table_td'>
			<html:text name='Hama0401Form' property='ttel' size='30' maxlength='30'/>
		</td>
		<td class='table_item'>�ǯu</td>
		<td class='table_td'>
			<html:text name='Hama0401Form' property='tfax' size='30' maxlength='30'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�O�_�o�e�l��</td>
		<td class='table_td' colspan='2'>
			<html:select name="Hama0401Form" property="mail">
				<html:options collection="isMailList" property="valuess" labelProperty="label"/>
			</html:select>
		</td>
		<td class='table_item'>���ڳ��X�q�l�l��H�c</td>
		<td class='table_td' colspan='2'>
			<html:text name='Hama0401Form' property='temail' size='20' maxlength='100'/>
		</td>
	</tr>
</table>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item' colspan='2'>[�����s��]</td>
	</tr>
	<tr>
		<td class='table_item'>�������w��</td>
		<td class='table_td'>
			<html:text name='Hama0401Form' property='notea' size='50' maxlength='255'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�M�׸ɧU</td>
		<td class='table_td'>
			<html:text name='Hama0401Form' property='noteb' size='50' maxlength='255'/>
		</td>
	</tr>
</table>
