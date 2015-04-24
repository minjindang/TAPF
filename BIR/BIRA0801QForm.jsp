<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>報表類型</td>
		<td class='table_td'>
			<%pageContext.setAttribute("collectionbudgetcode",tw.gov.nta.system.common.BudgetCodeManager.getBudgetInfo()); %>
			<html:select name='Bira0801Form' property='budgetCode'>
				<html:option value="">請選擇</html:option>
				<html:options collection="collectionbudgetcode" labelName="valuess" labelProperty='label' property="valuess"/>
			</html:select>
		</td>
	</tr>
	<tr>
		<td class='table_item'>發行日期</td>
		<td class='table_td'>
			<html:text name='Bira0801Form' property='date(issueSdate)' size='7' maxlength='7' onblur=''/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(issueSdate)", new Integer(0))%>
			 ~ 
			<html:text name='Bira0801Form' property='date(issueEdate)' size='7' maxlength='7' onblur=''/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(issueEdate)", new Integer(1))%>
		</td>
	</tr>
</table>