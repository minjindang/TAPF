<!--	APRA0501Q.jsp
程式目的：APRA05中央政府交換公債還本付息資料表
程式代號：APRA05
程式日期：0950316
程式作者：ERIC CHEN
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
		<td class='table_item'><font color="red">*</font>截止日期</td>
		<td class='table_td'>
			<html:text name='Apra0501Form' property='date(limitDate)' size='10' maxlength='7'/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(limitDate)", new Integer(0))%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>發行日期</td>
		<td class='table_td'>
			<html:text name='Apra0501Form' property='date(issueSdate)' size='10' maxlength='7'/>
			<a href="javascript: myCalendar.setCallBackObj('date(issueSdate)');myCalendar.show();"><img src="/tapf/assets/images/calendar/dynCalendar.gif" border="0" align="absmiddle" width="16" height="16" title="選擇日期"/></a> ~
			<html:text name='Apra0501Form' property='date(issueEdate)' size='10' maxlength='7'/>
			<a href="javascript: myCalendar.setCallBackObj('date(issueEdate)');myCalendar.show();"><img src="/tapf/assets/images/calendar/dynCalendar.gif" border="0" align="absmiddle" width="16" height="16" title="選擇日期"/></a>
		</td>
	</tr>
	<tr>
		<td class='table_item'>預算別</td>
		<td class='table_td'>
			<%pageContext.setAttribute("budgetCodeList",tw.gov.nta.system.common.BudgetCodeManager.getBudgetInfo());%>
			<html:select name='Apra0501Form' property='budgetCode'>
				<html:option value="">請選擇</html:option>
				<html:options collection="budgetCodeList" labelName="valuess" labelProperty='label' property="valuess"/>
			</html:select>
		</td>
	</tr>
</table>