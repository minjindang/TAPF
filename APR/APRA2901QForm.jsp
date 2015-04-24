<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'><font color="#ff0000">*</font>還本付息年月</td>
		<td class='table_td'>
			<html:text name='Apra2901Form' property='paySmonth' size='5' maxlength='5'/>
			~
			<html:text name='Apra2901Form' property='payEmonth' size='5' maxlength='5'/>ex:09801~09803
		</td>
	</tr>
	<tr>
		<td class='table_item'>甲類或乙類</td>
		<td class='table_td'>
			<html:select name="Apra2901Form" property="bondType">	
				<html:option value="">請選擇</html:option>
				<html:option value="1">甲類</html:option>	
				<html:option value="2">乙類</html:option>		
			</html:select>
		</td>
	</tr>
</table>
