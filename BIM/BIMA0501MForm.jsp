<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<html:hidden name='Bima0501Form' property='id' />



<table class='table_1' width='100%'>
	<tr><!--
		<td class='table_item' width='15%'>檔案代號</td>
		<td class='table_td'>
			<html:text name='Bima0501Form' property='fileNo' size='10' maxlength='10' />
		</td>-->
		<td class='table_item' width='15%'>發行期別</td>
		<td class='table_td' colspan="3">
			<%pageContext.setAttribute("collectionIssuecode",tw.gov.nta.debt.common.IssueManager.getDebtNameLabelList("B")); %>
			<html:select name='Bima0501Form' property='issueId'>
					<html:option value="">請選擇</html:option>
					<html:options collection="collectionIssuecode" labelName="valuess" labelProperty='label' property="valuess"/>
			</html:select>	
		</td>
	</tr>
	<tr>
		<td class='table_item' width='15%'>出售單位</td>
		<td class='table_td' colspan="3">
			<logic:empty name='Bima0501Form' property='unitCode'>
				<%= gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CentralBankManager.getCentralBankInfo(),"unitCode",10,false)%>
			</logic:empty>
			<logic:notEmpty name='Bima0501Form' property='unitCode'>
				<bean:define id='unitCode' name='Bima0501Form' property='unitCode' type='java.lang.Integer' />
				<%= gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CentralBankManager.getCentralBankInfo(),"unitCode",String.valueOf(unitCode),"",10,false)%>
			</logic:notEmpty>
		</td>
	</tr>
	<tr>
		<td class='table_item' width='15%'>發行價格</td>
		<td class='table_td'>
			<html:text name='Bima0501Form' property='bigDecimal(issuePrice)' size='10'  />
		</td>
		<td class='table_item' width='15%'>出售利率</td>
		<td class='table_td'>
			<html:text name='Bima0501Form' property='bigDecimal(sellRate)' size='10' maxlength='10' />%
		</td>
	</tr>
	<tr>
		<td class='table_item' width='15%'>出售面額</td>
		<td class='table_td'>
			<html:text name='Bima0501Form' property='bigDecimal(sellAmount)' size='10'  />
		</td>
		<td class='table_item' width='15%'>免稅額</td>
		<td class='table_td'>
			<html:text name='Bima0501Form' property='bigDecimal(freeAmount)' size='10'  />
		</td>
	</tr>
</table>
