<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item' width='20%'><font color="#ff000">*</font>還本付息年</td>
		<td class='table_td'>
			<html:text name='Apra3001Form' property='payYear' size='3' maxlength='3'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>甲類或乙類</td>
		<td class='table_td'>
			<html:select name="Apra3001Form" property="bondType">	
				<html:option value="">請選擇</html:option>
				<html:option value="1">甲類</html:option>	
				<html:option value="2">乙類</html:option>		
			</html:select>
		</td>
	</tr>
</table>
