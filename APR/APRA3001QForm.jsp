<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item' width='20%'><font color="#ff000">*</font>�٥��I���~</td>
		<td class='table_td'>
			<html:text name='Apra3001Form' property='payYear' size='3' maxlength='3'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�����ΤA��</td>
		<td class='table_td'>
			<html:select name="Apra3001Form" property="bondType">	
				<html:option value="">�п��</html:option>
				<html:option value="1">����</html:option>	
				<html:option value="2">�A��</html:option>		
			</html:select>
		</td>
	</tr>
</table>
