<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

</head>


<body>

<%@ page language="java" contentType="text/html;charset=Big5"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/displaytag" prefix="display"%>
<table class="table_1" width="100%">

	<tbody>
		<tr>

			<td class="table_item">�|�p��إN��</td>

			<td class="table_td"><html:text name="Eama0101Form" property="accountCode" size="50" maxlength="50">
			</html:text></td>

		</tr>

		<tr>

			<td class="table_item">�|�p��ئW��</td>

			<td class="table_td"><html:text name="Eama0101Form"
				property="accountName" size="50" maxlength="50">
			</html:text></td>

		</tr>
		<tr>

			<td class="table_item">������O</td>

			<td class="table_td">
				<html:select name="Eama0101Form" property="accountType">
					<html:option value="" >����</html:option>
					<html:option value="D">�ɤ�</html:option>
					<html:option value="C">�U��</html:option>
				</html:select>
			</td>

		</tr>
	</tbody>
</table>

</body>
</html>
