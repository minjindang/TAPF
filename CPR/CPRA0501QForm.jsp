<!--	CPRA0401QForm.jsp
程式目的：CPRA0401
程式代號：CPRA0401
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

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'><font color="red">*</font>高性能戰機借款名稱</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(gov.dnt.tame.util.ListToolManager.getList("select id,debtName from IssueMain where debtCode = 58 "),"id","",10,false)%>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red"></font>計算日期起訖</td>
		<td class='table_td'>
			<html:text name='Cpra0501Form' property='Date(startDate)' size='7' maxlength='7' onblur="" />
			<%=gov.dnt.tame.util.CommonFun.addCalendar("Date(issueDate)",new Integer(0))%>~
			<html:text name='Cpra0501Form' property='Date(endDate)' size='7' maxlength='7' onblur="" />
			<%=gov.dnt.tame.util.CommonFun.addCalendar("Date(endDate)",new Integer(1))%>
		</td>
	</tr>
</table>