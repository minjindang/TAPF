<!-- BIMA0201MForm.jsp
�{���ت��GBIMA02
�{���N���GBIMA02
�{������G0950302
�{���@�̡GEric.Chen
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
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
		<td class='table_item'>��l�o����O:</td>
		<td class='table_td'>
			<bean:define id='issueId' name='Bima0201Form' property='issueId' type='java.lang.Integer'/>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.debt.common.IssueManager.getIssueSerial("B"),"issueId",issueId.toString(),"","getIssueData(this.form)",10,false)%>
		</td>
		<td class='table_item'>��w��W��:</td>
		<td class='table_td' colspan="3">
			<bean:write name='Bima0201Form' property='debtName'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>���e�R�^���:</td>
		<td class='table_td'>
			<html:text name='Bima0201Form' property='date(repayDate)' size='20' maxlength='7' onblur='getIssueData(this.form)'/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(repayDate)",new Integer(0))%>
		</td>
		<td class='table_item'>���e�R�^�Ѽ�:</td>
		<td class='table_td' colspan="3">
			<bean:write name='Bima0201Form' property='interestDays' />��
		</td>
	<tr>
		<td class='table_item'>���e�R�^���B:</td>
		<td class='table_td' colspan="5">
			<html:text name='Bima0201Form' property='bigDecimal(balanceCapitalAmount)' size='20' maxlength='20' onblur="setDueIssueAmount(this.form)"/>
		</td>
	</tr>
	</tr>
	<tr>
		<td class='table_item'>�����R�^��I�Q��:</td>
		<td class='table_td'>
			<html:text name='Bima0201Form' property='bigDecimal(manageInterestAmount)' size='20' maxlength='20'/>
		</td>
		<td class='table_item'>��l����:</td>
		<td class='table_td'>
			<html:text name='Bima0201Form' property='bigDecimal(manageCapitalAmount)' size='20' maxlength='20'/>
		</td>
		<td class='table_item'>���e�R�^�[�v�����Q�v:</td>
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
		<td class='table_item'>��w�髬��:</td>
		<td class='table_td'>
			<logic:notEmpty name='Bima0201Form' property='buyStatus'>
				<bean:define id='buyStatus' name='Bima0201Form' property='buyStatus' type='java.lang.String'/>
				<%//gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("TS"),"buyStatus",buyStatus,false)%>
			</logic:notEmpty>
			<logic:empty name='Bima0201Form' property='buyStatus'>
				<%//gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("TS"),"buyStatus","",false)%>
			</logic:empty>
		</td>
		<td class='table_item'>���Ъ��B:</td>
		<td class='table_td' colspan="3">
			<html:text name='Bima0201Form' property='bigDecimal(buyAmount)' size='20' maxlength='20'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�o���B:</td>
		<td class='table_td'>
			<html:text name='Bima0201Form' property='bigDecimal(issueAmount)' size='20' maxlength='20' onblur="setDueIssueAmount(this.form)"/>
		</td>
		<td class='table_item'>�ꦬ�B:</td>
		<td class='table_td'>
			<html:text name='Bima0201Form' property='bigDecimal(capitalAmount)' size='20' maxlength='20'/>
		</td>
		<td class='table_item'>����I�I���B:</td>
		<td class='table_td'>
			<html:text name='Bima0201Form' property='bigDecimal(dueIssueAmount)' size='20' maxlength='20'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�̷s�󥿤��:</td>
		<td class='table_td' colspan="5">
			<bean:write name='Bima0201Form' property='dateFormat(modDate)'/>
		</td>
	</tr-->
</table>
