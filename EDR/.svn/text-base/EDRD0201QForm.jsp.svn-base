
<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>

<html:hidden name="Edrd0101Form" property="debtType"/>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>發行年度</td>
		<td class='table_td'>
			<html:text name="Edrd0101Form" property="accountYear" onblur="form.action='EDRD0201';form.submit();"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>發行月份</td>
		<td class='table_td'>	
			<html:select name="Edrd0101Form" property="month" value="3">
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
			<html:select name="Edrd0101Form" property="issueMainId">
				<html:optionsCollection name='Edrd0101Form' property='issueList' label="debtName" value="id" />
			</html:select>
		</td>
	</tr>
</table>