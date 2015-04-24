<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<table class='table_1' width='100%'>
		<tr>
			<td class='table_item'>公債代號：</td>
			<td class='table_td'><bean:write name='Aima0103MForm' property='issueSerial'/></td>
			<td class='table_item'>發行日期：</td>
			<td class='table_td'><bean:write name='Aima0103MForm' property='DateFormat(issueDate)'/></td>
        </tr>
        <tr>
			<td class='table_item'>發行金額：</td>
			<td class='table_td'><bean:write name='Aima0103MForm' property='BigDecimal(issueAmount)' format='#,##0'/>元</td>
			<td class='table_item'>公債名稱：</td>
			<td class='table_td'><bean:write name='Aima0103MForm' property='debtName'/></td>
        </tr>
        <tr>
			<td class='table_item'>面額：</td>
			<td class='table_td'>
				<logic:empty name='Aima0103MForm' property='ticketAmount'>
					<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("MY"),"ticketAmount","","","countTotalAmount(this.form);",10,true)%>元
				</logic:empty>
				<logic:notEmpty name='Aima0103MForm' property='ticketAmount'>
					<bean:define id='ticketAmount' name='Aima0103MForm' property='ticketAmount' type='java.lang.String'/>
					<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("MY"),"ticketAmount",ticketAmount,"","countTotalAmount(this.form);",10,true)%>元
				</logic:notEmpty>
			</td>
			<td class='table_item'>張數：</td>
			<td class='table_td'><html:text name='Aima0103MForm' property='ticketCount' onblur="countTotalAmount(this.form);total(this.form);" />張</td>
        </tr>
        <tr>
			<td class='table_item'>金額：</td>
			<td colspan="3" class='table_td' id="totalAmount"><bean:write name='Aima0103MForm' property='BigDecimal(totalAmount)' format='#,###'/>元</td>
        </tr>
        <html:hidden name='Aima0103MForm' property='issueMainId' />
        <html:hidden name='Aima0103MForm' property='issueTicketDetId' />
</table>