<!-- BIMA0202AForm.jsp
�{���ت��GBIMA02
�{���N���GBIMA02
�{������G0950302
�{���@�̡GEric.Chen
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>
<html:hidden name='Bima0201Form' property='id'/>
<html:hidden name='Bima0201Form' property='qryIssueId'/>
<html:hidden name='Bima0202Form' property='paymentMainId'/>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>�����W��:</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("MY"),"ticketAmount"," ","","getTotalAmount()",10)%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>���e�R�^�i��:</td>
		<td class='table_td'>
			<html:text name='Bima0202Form' property='ticketCount' size='50' maxlength='10' onblur='getTotalAmount()'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�`���B:</td>
		<td class='table_td'>
			<html:text name='Bima0202Form' property='bigDecimal(totalAmount)' size='50' maxlength='20'/>
		</td>
	</tr>
</table>
