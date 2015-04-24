<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>銀行代號</td>
		<td class='table_td'>
			<html:text name='Bira1301Form' property='bandNo' size='15' maxlength='15'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>銀行名稱</td>
		<td class='table_td'>
			<html:text name='Bira1301Form' property='bankName' size='20' maxlength='15'/>
		</td>
	</tr>
</table>