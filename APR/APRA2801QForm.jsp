<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item' width='20%'><font color="#ff0000">*</font>�٥��I���~��</td>
		<td class='table_td'>
			<html:text name='Apra2801Form' property='payYearMonth' size='5' maxlength='5'/>ex:09807
		</td>
	</tr>
	<tr>
		<td class='table_item'>�����ΤA��</td>
		<td class='table_td'>
			<html:select name="Apra2801Form" property="bondType">	
				<html:option value="">�п��</html:option>
				<html:option value="1">����</html:option>	
				<html:option value="2">�A��</html:option>		
			</html:select>
		</td>
	</tr>
</table>
