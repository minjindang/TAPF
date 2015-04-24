<!-- BIMA0201MForm.jsp
程式目的：BIMA02
程式代號：BIMA02
程式日期：0950302
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
<html:hidden name='Bima0201Form' property='id'/>
<html:hidden name='Bima0201Form' property='qryIssueId'/>
<html:hidden name='Bima0201Form' property='debtName'/>
<html:hidden name='Bima0201Form' property='interestDays'/>
<html:hidden name='Bima0201Form' property='planId'/>
<html:hidden name='Bima0201Form' property='interestSerial'/>
<html:hidden name='Bima0201Form' property='capitalSerial'/>
<html:hidden name='Bima0201Form' property='date(planRepayDate)'/>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>原始發行期別:</td>
		<td class='table_td'>
			<bean:define id='issueId' name='Bima0201Form' property='issueId' type='java.lang.Integer'/>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.debt.common.IssueManager.getIssueSerial("B"),"issueId",issueId.toString(),"","getIssueData(this.form)",10,false)%>
		</td>
		<td class='table_item'>國庫券名稱:</td>
		<td class='table_td' colspan="3">
			<bean:write name='Bima0201Form' property='debtName'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>提前買回日期:</td>
		<td class='table_td'>
			<html:text name='Bima0201Form' property='date(repayDate)' size='20' maxlength='7' onblur='getIssueData(this.form)'/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(repayDate)",new Integer(0))%>
		</td>
		<td class='table_item'>提前買回天數:</td>
		<td class='table_td' colspan="3">
			<bean:write name='Bima0201Form' property='interestDays' />日
		</td>
	<tr>
		<td class='table_item'>提前買回金額:</td>
		<td class='table_td' colspan="5">
			<html:text name='Bima0201Form' property='bigDecimal(balanceCapitalAmount)' size='20' maxlength='20' onblur="setDueIssueAmount(this.form)"/>
		</td>
	</tr>
	</tr>
	<tr>
		<td class='table_item'>提早買回實付利息:</td>
		<td class='table_td'>
			<html:text name='Bima0201Form' property='bigDecimal(manageInterestAmount)' size='20' maxlength='20'/>
		</td>
		<td class='table_item'>原始成本:</td>
		<td class='table_td'>
			<html:text name='Bima0201Form' property='bigDecimal(manageCapitalAmount)' size='20' maxlength='20'/>
		</td>
		<td class='table_item'>提前買回加權平均利率:</td>
		<td class='table_td'>
			<html:text name='Bima0201Form' property='averageRate' size='30' maxlength='20'/>%
		</td>
	</tr>
	<html:hidden name='Bima0201Form' property='buyStatus' />
	<html:hidden name='Bima0201Form' property='bigDecimal(buyAmount)' />
	<html:hidden name='Bima0201Form' property='bigDecimal(issueAmount)'/>
	<html:hidden name='Bima0201Form' property='bigDecimal(capitalAmount)'/>
	<html:hidden name='Bima0201Form' property='bigDecimal(dueIssueAmount)'/>
	<!-- tr>
		<td class='table_item'>國庫券型式:</td>
		<td class='table_td'>
			<logic:notEmpty name='Bima0201Form' property='buyStatus'>
				<bean:define id='buyStatus' name='Bima0201Form' property='buyStatus' type='java.lang.String'/>
				<%//gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("TS"),"buyStatus",buyStatus,false)%>
			</logic:notEmpty>
			<logic:empty name='Bima0201Form' property='buyStatus'>
				<%//gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("TS"),"buyStatus","",false)%>
			</logic:empty>
		</td>
		<td class='table_item'>落標金額:</td>
		<td class='table_td' colspan="3">
			<html:text name='Bima0201Form' property='bigDecimal(buyAmount)' size='20' maxlength='20'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>發行額:</td>
		<td class='table_td'>
			<html:text name='Bima0201Form' property='bigDecimal(issueAmount)' size='20' maxlength='20' onblur="setDueIssueAmount(this.form)"/>
		</td>
		<td class='table_item'>實收額:</td>
		<td class='table_td'>
			<html:text name='Bima0201Form' property='bigDecimal(capitalAmount)' size='20' maxlength='20'/>
		</td>
		<td class='table_item'>到期兌付金額:</td>
		<td class='table_td'>
			<html:text name='Bima0201Form' property='bigDecimal(dueIssueAmount)' size='20' maxlength='20'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>最新更正日期:</td>
		<td class='table_td' colspan="5">
			<bean:write name='Bima0201Form' property='dateFormat(modDate)'/>
		</td>
	</tr-->
</table>
