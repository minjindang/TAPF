<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item' width='20%'><font color="#ff000">*</font>交換公債代號</td>
		<td class='table_td'>
			<html:select name='Airc0301Form' property="issueId">
				<html:option value="">請選擇</html:option>
				<html:optionsCollection name='Airc0301Form' property="issueSerialList" label="label" value="valuess" />
			</html:select>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="#ff0000">*</font>截止日期</td>
		<td class='table_td'>
			<html:text name='Airc0301Form' property='date(limitDate)' size='7' maxlength='7'/>
			<a href="javascript: myCalendar.setCallBackObj('date(limitDate)');myCalendar.show();"><img src="/tapf/assets/images/calendar/dynCalendar.gif" border="0" align="absmiddle" width="16" height="16" title="選擇日期"/></a>
		</td>
	</tr>
</table>