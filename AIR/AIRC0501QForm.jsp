<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item' width='20%'><font color="#ff000">*</font>交換公債代號</td>
		<td class='table_td'>
			<html:select name='Airc0501Form' property="issueSerial" value="issueSerial" >
				<html:option value="">請選擇</html:option>
				<html:optionsCollection name='Airc0501Form'  property="issueSerialList" label="label" value="valuess" />
			</html:select>
		</td>
	</tr>
	<tr>
		<td class='table_item'>提前賣回/收回基準日</td>
		<td class='table_td'>
			<html:text name='Airc0501Form' property='date(limitDate)' size='7' maxlength='7' onblur=''/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(limitDate)", new Integer(0))%>
			
		</td>
	</tr>
</table>