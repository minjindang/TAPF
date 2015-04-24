<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>發行年度</td>
		<td class='table_td'>
			<html:text name='Bira1501Form' property='accountSYear' size='3' maxlength='3'/>
			~
			<html:text name='Bira1501Form' property='accountEYear' size='3' maxlength='3'/>
			
		</td>
	</tr>
	<tr>
		<td class='table_item'>發行期別</td>
		<td class='table_td'>
			<%pageContext.setAttribute("collectionIssuecode",tw.gov.nta.debt.common.IssueManager.getDebtNameLabelList("B")); %>
			<html:select name='Bira1501Form' property='issueId'>
					<html:option value="">請選擇</html:option>
					<html:options collection="collectionIssuecode" labelName="valuess" labelProperty='label' property="valuess"/>
			</html:select>	
		</td>
	</tr>
	<tr>
		<td class='table_item'>金額單位</td>
		<td class='table_td'>
			<%pageContext.setAttribute("collectionCodeDet",tw.gov.nta.system.common.CodeDetManage.getCodeDet("BU")); %>
			<html:select name='Bira1501Form' property='amountUnit'>
				<html:option value="0">請選擇</html:option>
				<html:options collection="collectionCodeDet" labelName="valuess" labelProperty='label' property="valuess"/>
			</html:select>
		</td>
	</tr>
</table>