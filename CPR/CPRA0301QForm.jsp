<!--	CPRA0301QForm.jsp
�{���ت��GCPRA0301
�{���N���GCPRA0301
�{������G0950316
�{���@�̡GERIC CHEN
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
		<td class='table_item'><font color="red">*</font>���O</td>
		<td class='table_td'>
			<html:select name="Cpra0301Form" property="issueId" onchange="getSelectItem(this.form)" >
					<html:option value="">�п��</html:option>
					<html:optionsCollection name="Cpra0301Form" property="serialNoList" label="label" value="valuess" />
			</html:select>
			<html:hidden name="Cpra0301Form" property="issueSerial" />
		</td>
	</tr>
	<tr>
		<td class='table_item'>�I�����</td>
		<td class='table_td'>
			<html:select name="Cpra0301Form" property="date(payDate)">
					<html:option value="">�п��</html:option>
					<html:optionsCollection name="Cpra0301Form" property="payDateList" label="label" value="valuess" />
			</html:select>
		</td>
	</tr>
	<tr>
		<td class='table_item' rowspan="2">�Q���Ƶ�</td>
		<td class='table_td'>
			<html:radio name="Cpra0301Form" property="note" value="�T�w�p��,���~��I,�C�~�̦U�U�ڦ�P�i�򥻩�کT�w�Q�v�վ�@��."/>�T�w�p��,���~��I,�C�~�̦U�U�ڦ�P�i�򥻩�کT�w�Q�v�վ�@��.
		</td>
	</tr>
	<tr>
		<td class='table_td'>
			<html:radio name="Cpra0301Form" property="note" value="�T�w�p��,���~��I,�C�~�̤��ضl�F���q�P�i�@�~���w���x�W�s�کT�w�Q�v�վ�@��."/>�T�w�p��,���~��I,�C�~�̤��ضl�F���q�P�i�@�~���w���x�W�s�کT�w�Q�v�վ�@��.
		</td>
	</tr>			
</table>