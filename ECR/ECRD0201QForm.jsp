

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>

<html:hidden name="Ecrd0101Form" property="debtType"/>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>�|�p�~��</td>
		<td class='table_td'>
			<html:text name="Ecrd0101Form" property="accountYear" onblur="form.action='ECRD0201';form.submit();"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�|�p���</td>
		<td class='table_td'>	
			<html:select name="Ecrd0101Form" property="month" value="3">
			<%
				for(int i = 0;i<12;i++){
			%>
				<html:option value="<%=String.valueOf(i+1)%>"/>
			<%}%>
			</html:select>
		</td>
	</tr>
	<tr>
		<td class='table_td' colspan="2">
			<html:radio name="AccountQueryForm" property="isClose" value="Y"/>�����C�L
			<html:radio name="AccountQueryForm" property="isClose" value="N"/>�����M�C�L
		</td>
	</tr>
</table>