<!-- BIMA0102MForm.jsp
程式目的：BIMA01
程式代號：BIMA01
程式日期：0950301
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
<html:hidden name='Bima0102Form' property='id'/>
<html:hidden name='Bima0102Form' property='issueId'/>
<html:hidden name='Bima0102Form' property='qrydebtCode'/>
<html:hidden name='Bima0102Form' property='qrybudgetCode'/>
<html:hidden name='Bima0102Form' property='qryaccountYear'/>
<html:hidden name='Bima0102Form' property='qrydebtName'/>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>面額種類:</td>
		<td class='table_td'>
			<%pageContext.setAttribute("moneyKindList",tw.gov.nta.system.common.CodeDetManage.getCodeDet("MY")); %>
			<html:select name='Bima0102Form' property='bigDecimal(ticketAmount)' onchange="getTotalAmount()">
				<html:option value="">請選擇</html:option>
				<html:options collection="moneyKindList" labelName="valuess" labelProperty='label' property="valuess"/>
			</html:select>
		</td>
	</tr>	
	<tr>	
		<td class='table_item'>張數:</td>
		<td class='table_td'>
			<html:text name='Bima0102Form' property='ticketCount' size='50' maxlength='10' onblur="getTotalAmount()"/>
		</td>
	</tr>
	<tr>	
		<td class='table_item'>金額:</td>
		<td class='table_td'>
			<html:text name='Bima0102Form' property='bigDecimal(totalAmount)' size='50' maxlength='20' readonly='true'/>
		</td>
	</tr>
</table>
