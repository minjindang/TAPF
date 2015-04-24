<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>年度</td>
		<td class='table_td'>
			<input type='text' name='qryAccountYear' size='3' maxlength='3'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>國別</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.NationCodeManager.getNationInfo(),"qryNationCode",10,false)%>	
		</td>
	</tr>
</table>
