<!-- BIMA0201AForm.jsp
程式目的：BIMA02
程式代號：BIMA02
程式日期：0950301
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
<html:hidden name='Bima0201Form' property='date(issueDate)'/>
<html:hidden name='Bima0201Form' property='date(dueDate)'/>
<html:hidden name='Bima0201Form' property='date(modDate)'/>
<html:hidden name='Bima0201Form' property='debtName'/>
<html:hidden name='Bima0201Form' property='interestDays'/>
<html:hidden name='Bima0201Form' property='planId'/>
<html:hidden name='Bima0201Form' property='interestSerial'/>
<html:hidden name='Bima0201Form' property='bigDecimal(issueAmount)'/>
<html:hidden name='Bima0201Form' property='bigDecimal(capitalAmount)' />
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'><font color="red">*</font>原始發行期別:</td>
		<td class='table_td'>
		<logic:empty  name='Bima0201Form' property='issueId' >
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.debt.common.IssueManager.getIssueSerial("B"),"issueId","","","getIssue(this.form)",10,false)%>
		</logic:empty>
		<logic:notEmpty name='Bima0201Form' property='issueId' >
			<bean:define id='issueId' name='Bima0201Form' property='issueId' type='java.lang.Integer'/>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.debt.common.IssueManager.getIssueSerial("B"),"issueId",issueId.toString(),"","getIssue(this.form)",10,false)%>
		</logic:notEmpty>
		</td>
		<td class='table_item'>國庫券名稱:</td>
		<td class='table_td' id='debt' >
         	<bean:write name='Bima0201Form' property='debtName' />&nbsp;
		</td>
	</tr>
	<tr>
		<td class='table_item'>提前買回日期:</td>
		<td class='table_td'>
			<html:text name='Bima0201Form' property='date(repayDate)' size='20' maxlength='7' onblur="getIssue(this.form)"/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(repayDate)",new Integer(0))%>
		</td>
		<td class='table_item'>提前買回天數:</td>
		<td class='table_td' >
			<bean:write name='Bima0201Form' property='interestDays' />日&nbsp;
		</td>
	</tr>
	<tr>
		<td class='table_item'>提前買回金額:</td>
		<td class='table_td' colspan="3">
			<input type='text' name='bigDecimal(balanceCapitalAmount)' size='20' maxlength='20' onblur="setIssue2(this.form)"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>提早買回實付利息:</td>
		<td class='table_td'>
			<input type='text' name='bigDecimal(manageInterestAmount)' size='20' maxlength='20'/>
		</td>
		<td class='table_item'>原始成本:</td>
		<td class='table_td'>
			<html:text name='Bima0201Form' property='bigDecimal(manageCapitalAmount)' size='20' maxlength='20'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>提前買回利率:</td>
		<td class='table_td' colspan="3">
			<input type='text' name='bigDecimal(averageRate)' size='20' maxlength='20'/>%
		</td>
	</tr>
	<!-- tr>
		<td class='table_item'>標購狀況:</td>
		<td class='table_td'>
			<%//gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("TS"),"buyStatus","","","changeAmount(form)",10,false)%>
		</td>
		<td class='table_item'>落標金額:</td>
		<td class='table_td'>
			<input type='text' name='bigDecimal(buyAmount)' size='20' maxlength='20'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>發行額:</td>

		<td class='table_td' >
			<bean:write name='Bima0201Form' property='bigDecimal(issueAmount)' format='#,###'/>&nbsp;
		</td>
		<td class='table_item'>實收額:</td>
		<td class='table_td'>
			<html:text name='Bima0201Form' property='bigDecimal(capitalAmount)' size='20' />
		</td>
	</tr>
	<tr>
		<td class='table_item'>到期兌付金額:</td>
		<td class='table_td' id='issue2' colspan="3">
			<bean:write name='Bima0201Form' property='bigDecimal(issueAmount)' format='#,###'/>&nbsp;
		</td>
	</tr-->
</table>
