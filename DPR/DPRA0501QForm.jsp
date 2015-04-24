<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<input type='hidden' name='title' value='DPRA05'>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'><font color="red">*</font>償付日期</td>
		<td class='table_td'>
			<html:text name='DpraReportForm' property='date(payDate)' size='7' maxlength='7' onblur=''/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(payDate)",new Integer(0))%>
			~
			<html:text name='DpraReportForm' property='date(payDateEnd)' size='7' maxlength='7' onblur=''/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(payDateEnd)",new Integer(1))%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>債務別</td>
		<td class='table_td'>
			<select name="debtCode" >	
				<option value="">請選擇</option>
				<option value ="24">總預算</option>
				<option value ="25">民營化基金</option>
				<option value ="31">債務基金</option>
			</select>
		</td>
	</tr>
</table>