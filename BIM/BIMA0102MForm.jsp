<!-- BIMA0102MForm.jsp
�{���ت��GBIMA01
�{���N���GBIMA01
�{������G0950301
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
<html:hidden name='Bima0102Form' property='id'/>
<html:hidden name='Bima0102Form' property='issueId'/>
<html:hidden name='Bima0102Form' property='qrydebtCode'/>
<html:hidden name='Bima0102Form' property='qrybudgetCode'/>
<html:hidden name='Bima0102Form' property='qryaccountYear'/>
<html:hidden name='Bima0102Form' property='qrydebtName'/>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>���B����:</td>
		<td class='table_td'>
			<%pageContext.setAttribute("moneyKindList",tw.gov.nta.system.common.CodeDetManage.getCodeDet("MY")); %>
			<html:select name='Bima0102Form' property='bigDecimal(ticketAmount)' onchange="getTotalAmount()">
				<html:option value="">�п��</html:option>
				<html:options collection="moneyKindList" labelName="valuess" labelProperty='label' property="valuess"/>
			</html:select>
		</td>
	</tr>	
	<tr>	
		<td class='table_item'>�i��:</td>
		<td class='table_td'>
			<html:text name='Bima0102Form' property='ticketCount' size='50' maxlength='10' onblur="getTotalAmount()"/>
		</td>
	</tr>
	<tr>	
		<td class='table_item'>���B:</td>
		<td class='table_td'>
			<html:text name='Bima0102Form' property='bigDecimal(totalAmount)' size='50' maxlength='20' readonly='true'/>
		</td>
	</tr>
</table>
