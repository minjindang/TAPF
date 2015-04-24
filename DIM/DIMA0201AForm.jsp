<!-- DIMA0101AForm.jsp
程式目的：DIMA01
程式代號：DIMA01
程式日期：0950223
程式作者：Eric.Chen
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
		<td class='table_item'><font color="red">*</font>年度</td>
		<td class='table_td'>
			<html:text name='Dima0201Form' property='accountYear' size='10' maxlength='3' onblur="getIssueSerial()"/>
		</td>
		<td class='table_item'><font color="red">*</font>期次</td>
		<td class='table_td'>
			<html:text name='Dima0201Form' property='serialNo' size='10' maxlength='3' onblur="getIssueSerial()"/>
		</td>
	<tr>
		<td class='table_item'><font color="red">*</font>預算別</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.BudgetCodeManager.getBudgetInfo(),"budgetCode","1","","getDebtCode(this.form.budgetCode.value,'debtCode')",10,false)%>
		</td>
		<td class='table_item'><font color="red">*</font>債務別</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.DebitCodeManage.getDebitInfo(new Integer(1)),"debtCode",false)%>
		</td>
	</tr>
	</tr>
	<tr>
		<td class='table_item'>期別</td>
		<td class='table_td'>
			<html:text name='Dima0201Form' property='issueSerial' readonly="true" />
		</td>
		<td class='table_item'>名稱</td>
		<td class='table_td' colspan="5">
			<html:text name='Dima0201Form' property='debtName' size='50' maxlength='50'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>借款期間</td>
		<td class='table_td'>
			<html:text name='Dima0201Form' property='date(issueDate)' size='10' onblur="getDays()" onchange="getDaysByChange()"/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(issueDate)",new Integer(0))%>
			~<html:text name='Dima0201Form' property='date(dueDate)'  size='10' onblur="getDays()" onchange="getDaysByChange()"/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(dueDate)",new Integer(1))%>
			
		</td>
		<td class='table_item'>天數</td>
		<td class='table_td' id="dayid" colspan="5">
			<bean:write name='Dima0201Form' property='days' />
		</td>
		<html:hidden name='Dima0201Form' property='days'/>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>預計借款金額</td>
		<td class='table_td'>
			<html:text name='Dima0201Form' property='bigDecimal(expectAmount)' size='20' maxlength='20'/>
		</td>
		<td class='table_item'>備註</td>
		<td class='table_td' colspan="5">
			<html:text name='Dima0201Form' property='remark' size='50' maxlength='50'/>
		</td>
	</tr>
</table>
