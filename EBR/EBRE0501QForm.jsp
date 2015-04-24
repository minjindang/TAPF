

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>

<html:hidden name="Ebre0501Form" property="debtType"/>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>會計年度</td>
		<td class='table_td'>
			<html:text name="Ebre0501Form" property="accountYear" />
		</td>
	</tr>
	<tr>
		<td class='table_item'>會計月份</td>
		<td class='table_td'>	
			<html:select name="Ebre0501Form" property="month" value="3">
			<%
				for(int i = 0;i<12;i++){
			%>
				<html:option value="<%=String.valueOf(i+1)%>"/>
			<%}%>
			</html:select>
		</td>
	</tr>
	<tr>
		<td class='table_item'>債務名稱</td>
		<td class='table_td'>
			<html:text name="Ebre0501Form" property="debtType" />
		</td>
	</tr>
	<tr>
		<td class='table_item'>國庫券/公債</td>
		<td class='table_td'>
			<html:text name="Ebre0501Form" property="Typeid" />
		</td>
	</tr>
</table>