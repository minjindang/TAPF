<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>

<table class='table_1' width='100%'>
	<!--  
	<tr>
		<td class='table_item'>�Ȧ�N��</td>
		<td class='table_td'>
			<html:text name='Bira1701Form' property='bandNo' size='7' maxlength='7'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�Ȧ�W��</td>
		<td class='table_td'>
			<html:text name='Bira1701Form' property='bankName' size='15' maxlength='15'/>
		</td>
	</tr>
	-->
	<tr>
		<td class='table_item'>�o��~��</td>
		<td class='table_td'>
			<html:text name='Bira1701Form' property='accountSYear' size='3' maxlength='3'/>
			~
			<html:text name='Bira1701Form' property='accountEYear' size='3' maxlength='3'/>
			
		</td>
	</tr>
	<tr>
		<td class='table_item'>�o����O</td>
		<td class='table_td'>
			<%pageContext.setAttribute("collectionIssuecode",tw.gov.nta.debt.common.IssueManager.getDebtNameLabelList("B")); %>
			<html:select name='Bira1701Form' property='issueId'>
					<html:option value="">�п��</html:option>
					<html:options collection="collectionIssuecode" labelName="valuess" labelProperty='label' property="valuess"/>
			</html:select>	
		</td>
	</tr>
	<tr>
		<td class='table_item'>���B���</td>
		<td class='table_td'>
			<%pageContext.setAttribute("collectionCodeDet",tw.gov.nta.system.common.CodeDetManage.getCodeDet("BU")); %>
			<html:select name='Bira1701Form' property='amountUnit'>
				<html:option value="1">�п��</html:option>
				<html:options collection="collectionCodeDet" labelName="valuess" labelProperty='label' property="valuess"/>
			</html:select>
		</td>
	</tr>
</table>