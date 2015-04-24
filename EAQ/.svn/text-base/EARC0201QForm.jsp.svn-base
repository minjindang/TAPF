<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>發行年度</td>
		<td class='table_td'>
			<input type='text' name='accountYear'  />
		</td>
	</tr>
	<tr>
		<td class='table_item'>發行月份</td>
		<td class='table_td'>	
			<select name="month" >
			<%
				for(int i = 0;i<12;i++){
			%>
				<option><%=String.valueOf(i+1)%></option>
			<%}%>
			</select>
		</td>
	</tr>
	<tr>
		<td class='table_item'>兌付日期</td>
		<td class='table_td'><input type='text' property="payDay" value="0950410"/></td>
	</tr>
</table>
