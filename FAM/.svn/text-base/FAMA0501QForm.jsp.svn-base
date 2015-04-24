<!--
程式目的：FAMA04文字
程式代號：FAMA04
程式日期：0950223
程式作者：FormBean Generator
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>銀行代號</td>
		<td class='table_td'>
			<html:text name='Fama0501Form' property='qryBankCode' size='30' maxlength='5'/>
		</td>
	<tr>
	</tr>
		<td class='table_item'>銀行名稱</td>
		<td class='table_td'>
			<html:text name='Fama0501Form' property='qryBankName' size='30' maxlength='50'/>
		</td>
	<tr>
	</tr>
		<td class='table_item'>銀行簡稱</td>
		<td class='table_td'>
			<html:text name='Fama0501Form' property='qryShortBankName' size='30' maxlength='20'/>
		</td>
	<tr>
	</tr>
		<td class='table_item'>所屬銀行編號</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(gov.dnt.tame.util.ListToolManager.getList("select id, bankCode+bankName from BankRef where 1=1 order by bankCode"),"qryBelongToBankId","",10, false)%>
		</td>
	<tr>
	</tr>
		<td class='table_item'>合併銀行編號</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(gov.dnt.tame.util.ListToolManager.getList("select id, bankCode+bankName from BankRef where 1=1 order by bankCode"),"qryCombinationBankId","",10, false)%>
		</td>
	</tr>
</table>
