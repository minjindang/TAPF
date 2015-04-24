<!-- DIMA0102MForm.jsp
程式目的：DIMA02
程式代號：DIMA02
程式日期：0950223
程式作者：Andrew Sung
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->
<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>
<html:hidden name='Dima0202Form' property='id' />
<html:hidden name='Dima0202Form' property='bankId' />
<html:hidden name='Dima0202Form' property='kindId' />
<html:hidden name='Dima0202Form' property='debtCode'/>
<html:hidden name='Dima0202Form' property='budgetCode'/>
<html:hidden name="Dima0202Form" property="qryAccountYear"/>
<html:hidden name="Dima0202Form" property="qrySerialNo"/>
<html:hidden name="Dima0202Form" property="qryId"/>
<html:hidden name='Dima0202Form' property='accrue'/>
<html:hidden name='Dima0202Form' property='days'/>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>債務名稱</td>
		<td class='table_td'>
			<bean:write  name="Dima0202Form" property="debtName" />
		</td>
	</tr>
	<tr>
		<td class='table_item'>借款期間</td>
		<td class='table_td'>
			<bean:define id='issueDate' name="Dima0202Form" property="issueDate" type="java.util.Date"/>
			<bean:define id='dueDate' name="Dima0202Form" property="dueDate" type="java.util.Date"/>
			<%= gov.dnt.tame.util.DateUtil.date2ROCStr(issueDate)+"~"+ gov.dnt.tame.util.DateUtil.date2ROCStr(dueDate)%>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>銀行編號</td>
		<td class='table_td'>
			<bean:define id='bank' name="Dima0202Form" property="bank" type="tw.gov.nta.sql.debt.BankRef"/>
			<bean:define id='accountYear' name='Dima0202Form' property='accountYear' type='java.lang.String' />
			<%// gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.debt.common.ContractBankManager.getBankByAccountYear(accountYear),"bankCode",bank.getBankCode(),"","getBankRefId(this.form.bankCode.value)",10,true)%>
			<%= gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.BankCodeManage.getBankCodeDIM(),"bankCode",bank.getBankCode(),"","getBankRefId(this.form.bankCode.value)",10,true)%>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>比價金額</td>
		<td class='table_td'>
			<html:text name='Dima0202Form' property='bigDecimal(compareAmount)'size='20' maxlength='20' />
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>利率</td>
		<td class='table_td'>
			<html:text name='Dima0202Form' property='bigDecimal(compareRate)' size='20' maxlength='20' onblur="getAmount()"/>%
		</td>
	</tr>
	<tr>
		<td class='table_item'> 得標金額</td>
		<td class='table_td'>
			<html:text name='Dima0202Form' property='bigDecimal(issueAmount)'size='20' maxlength='20' onblur="getAmount()"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>利息</td>
		<td class='table_td' colspan="5">
			<html:text name='Dima0202Form' property='bigDecimal(originInterestAmount)' size='20' maxlength='20' onblur="getTotalAmount()"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>本息合計</td>
		<td class='table_td'>
			<html:text name='Dima0202Form' property='bigDecimal(allAmount)' size='20' maxlength='20' readonly="true"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>另行訂定合約</td>
		<td class='table_td'>
			<logic:notEmpty name="Dima0202Form" property="budgetYear">
				<bean:define id="budgetYear" name="Dima0202Form" property="budgetYear" type="java.lang.String"/>
				<input type="checkbox" name="budgetYear" <%="Y".equals(budgetYear.trim())?"checked":""%>>
			</logic:notEmpty>
			<logic:empty name="Dima0202Form" property="budgetYear">
				<input type="checkbox" name="budgetYear" >
			</logic:empty>
		</td>
	</tr>
	<tr>
		<td class='table_item'>備註</td>
		<td class='table_td'>
			<html:text name='Dima0202Form' property='remark' size='50'/>
		</td>
	</tr>	
</table>