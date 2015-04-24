<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'><font color="#FF0000">*</font>銀行代號</td>
		<td class='table_td'>
			<html:text name='Fama0501Form' property='bankCode' size='30' maxlength='5'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="#FF0000">*</font>銀行名稱</td>
		<td class='table_td'>
			<html:text name='Fama0501Form' property='bankName' size='30' maxlength='50'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="#FF0000">*</font>銀行簡稱</td>
		<td class='table_td'>
			<html:text name='Fama0501Form' property='shortBankName' size='30' maxlength='20'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>行業別</td>
		<td class='table_td'>
			<html:text name='Fama0501Form' property='businessKind' size='4' maxlength='4'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>免稅額</td>
		<td class='table_td'>
			<html:text name='Fama0501Form' property='freeAmount' size='20' maxlength='30'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>所屬銀行編號</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(gov.dnt.tame.util.ListToolManager.getList("select id, bankCode+bankName from BankRef where 1=1 order by bankCode"),"belongToBankId","",10, false)%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>合併銀行編號</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(gov.dnt.tame.util.ListToolManager.getList("select id, bankCode+bankName from BankRef where 1=1 order by bankCode"),"combinationBankId","",10, false)%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>合併日期</td>
		<td class='table_td'>
			<html:text name='Fama0501Form' property='date(combinationDate)' size='30' maxlength='13'/>
		</td>							  
		</tr>
	<tr>
		<td class='table_item'>儲匯銀行代號</td>
		<td class='table_td'>
			<html:text name='Fama0501Form' property='tpsbankCode' size='30' maxlength='7'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>備註</td>
		<td class='table_td'>
			<html:text name='Fama0501Form' property='remark' size='60' maxlength='100'/>
		</td>
	</tr>
</table>
<html:hidden name='Fama0501Form'property='id'/>
<html:hidden name='Fama0501Form' property="qryBankCode"/>
<html:hidden name='Fama0501Form' property="qryBankName"/>
<html:hidden name='Fama0501Form' property="qryShortBankName"/>
<html:hidden name='Fama0501Form' property="qryBelongToBankId"/>
<html:hidden name='Fama0501Form' property="qryCombinationBankId"/>