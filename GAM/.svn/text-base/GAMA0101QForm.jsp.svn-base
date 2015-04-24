<!-- CIMA0101QForm.jsp -->
<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>年度</td>
		<td class='table_td'>
			<html:text name='Cima0101Form' property='qryaccountYear' size='3' maxlength='3'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>期次</td>
		<td class='table_td'>
			<html:text name='Cima0101Form' property='qryserialNo' size='3' maxlength='3'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>期別</td>
		<td class='table_td'>
			<html:text name='Cima0101Form' property='qryissueSerial' size='20' maxlength='20'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>名稱</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.debt.common.IssueManager.getDebtName("E"),"qrydebtName",10,false)%>
		</td>
	</tr>
</table>
