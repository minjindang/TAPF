<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>
<html:hidden name='Aima0203MForm' property='issueMainId' />
<html:hidden name='Aima0203MForm' property='issueTicketDetId' />
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>���ťN���G</td>
		<td class='table_td'><bean:write name='Aima0203MForm' property='issueSerial'/>
	</tr>
    <tr>
		<td class='table_item'>�o�����G</td>
		<td class='table_td'><bean:write name='Aima0203MForm' property='DateFormat(issueDate)'/></td>
    </tr>
    <tr>
		<td class='table_item'>�o����B�G</td>
		<td class='table_td'><bean:write name='Aima0203MForm' property='BigDecimal(issueAmount)' format="#,###"/>��</td>
    </tr>
 	<tr>
		<td class='table_item'>���ŦW�١G</td>
		<td class='table_td'><bean:write name='Aima0203MForm' property='debtName'/></td>
    </tr>
    <tr>
		<td class='table_item'>���B�G</td>
		<td class='table_td'>
			<logic:empty name='Aima0203MForm' property='ticketAmount'>
					<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("MY"),"ticketAmount","","","calculateAmount(this.form);total(this.form);",10,false)%>��
				</logic:empty>
				<logic:notEmpty name='Aima0203MForm' property='ticketAmount'>
					<bean:define id='ticketAmount' name='Aima0203MForm' property='ticketAmount' type='java.lang.String' />
					<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("MY"),"ticketAmount",new java.math.BigDecimal(ticketAmount).setScale(0).toString(),"","calculateAmount(this.form);total(this.form);",10,false)%>��
				</logic:notEmpty>
		</td>
	</tr>	
	<tr>
		<td class='table_item'>�i�ơG</td>
		<td class='table_td'><html:text name='Aima0203MForm' property='ticketCount' onblur="total(this.form);calculateAmount(this.form);"/></td>
    </tr>
    <tr>
		<td class='table_item'>���B�G</td>
		<td class='table_td' id="totalAmount"><bean:write name='Aima0203MForm' property='BigDecimal(totalAmount)' format="#,###"/>��</td>
    </tr>
</table>