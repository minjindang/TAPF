<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>發行年度</td>
		<td class='table_td'>
			<html:text name='Bira1401Form' property='accountSYear' size='3' maxlength='3'/>
			~
			<html:text name='Bira1401Form' property='accountEYear' size='3' maxlength='3'/>
			
		</td>
	</tr>
	<tr>
		<td class='table_item'>發行期別</td>
		<td class='table_td'>
			<%pageContext.setAttribute("collectionIssuecode",tw.gov.nta.debt.common.IssueManager.getDebtNameLabelList("B")); %>
			<html:select name='Bira1401Form' property='issueId'>
					<html:option value="">請選擇</html:option>
					<html:options collection="collectionIssuecode" labelName="valuess" labelProperty='label' property="valuess"/>
			</html:select>	
		</td>
	</tr>
</table>