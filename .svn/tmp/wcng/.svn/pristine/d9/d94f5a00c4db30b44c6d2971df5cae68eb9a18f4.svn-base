<!-- BIMA0202MForm.jsp
程式目的：BIMA02
程式代號：BIMA02
程式日期：0950302
程式作者：Eric.Chen
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>
<html:hidden name='Bima0202Form' property='id'/>
<html:hidden name='Bima0202Form' property='qryIssueId'/>
<html:hidden name='Bima0202Form' property='paymentMainId'/>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>票面名稱:</td>
		<td class='table_td'>
			<logic:notEmpty name='Bima0202Form' property='ticketAmount'>
				<bean:define id='ticketAmount' name='Bima0202Form' property='ticketAmount' type='java.math.BigDecimal' />
				<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("MY"),"ticketAmount",ticketAmount.toString(),"","getTotalAmount()",10)%>
			</logic:notEmpty>
			<logic:empty name='Bima0202Form' property='ticketAmount'>
				<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("MY"),"ticketAmount","","","getTotalAmount()",10)%>
			</logic:empty>
		</td>
	</tr>
	<tr>
		<td class='table_item'>提前買回張數:</td>
		<td class='table_td'>
			<html:text name='Bima0202Form' property='ticketCount' size='50' maxlength='10'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>總金額:</td>
		<td class='table_td'>
			<html:text name='Bima0202Form' property='bigDecimal(totalAmount)' size='50' maxlength='20' readonly="true"/>
		</td>
	</tr>
</table>
