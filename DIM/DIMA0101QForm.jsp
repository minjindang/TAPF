<!-- DIMA0101QForm.jsp
�{���ت��GDIMA01
�{���N���GDIMA01
�{������G0950223
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
		<td class='table_item'>�~��</td>
		<td class='table_td'>
			<html:text name='Dima0101Form' property='qrycontractyear' size='5' maxlength='3'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>�Ȧ�s��</td>
		<td class='table_td'>
			<html:select name="Dima0101Form" property="bankId">
				<html:option value="">�п��</html:option>
				<html:optionsCollection name="Dima0101Form" property="bankList" label="name" value="id"/>
			</html:select>
		</td>
	</tr>
</table>
