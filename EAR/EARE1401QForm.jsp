<!--
�{���ت��G�t�XGBA����J�|�p�ǲ�
�{���N���GEARE14
�{������G0961210
�{���@�̡G
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->
<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@taglib uri="/tags/struts-bean" prefix="bean" %>
<%@taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %> 

<table class='table_1' width='100%'>
	<tr>
		
		<td class='table_item'>�ǲ���J�ɶ�</td>		
		<td class='table_td'>
			<input type="text" name="convertDate" value='<c:out value="${Eare1401Form.convertDate}"/>' />2008/06/04
		</td> 
		 
	</tr>
	<tr>
		<td class='table_item'>��ܧ鷸��</td>
		<td class='table_td'>
			<select name="convertType"><option value="">�п��</option>
				<option value="A">����</option>	
				<option value="B">���</option></select>
		</td>
	</tr>

	<tr>
		<td class='table_item'>�ǲ���J����</td>
		<td class='table_td'>
			<select name="convertTiming"><option value="">�п��</option>
				<option value="1">�o��</option>	
				<option value="2">�u�P</option></select>
		</td>
	</tr>
	
		<tr>
		<td class='table_item'>�B�z������άO�o�榨���B</td>
		<td class='table_td'>
			<select name="convertKind"><option value="">�п��</option>
				<option value="3">�����</option>	
				<option value="4">�o�榨���B</option></select>
		</td>
	</tr>

</table>