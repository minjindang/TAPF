<!--
程式目的：年度付息明細表
程式代號：AIRB09
程式日期：0950227
程式作者：icefire
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item' colspan="15%"><font color='red'>*</font>付息到期年度:</td>
		<td class='table_td' colspan="85%">
			<html:text name='Airb0901Form' property='repaydate' size='3' maxlength='3'/>
		</td>
	</tr>
	<tr>
		<td class='table_item' colspan="15%">預算別</td>
		<td class='table_td' colspan="85%">
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.BudgetCodeManager.getBudgetInfo(),"budgetCode","","","getDebtCode(this.form.budgetCode.value,'debtCode')",10,false)%>
		</td>
	</tr>
	<tr>
		<td class='table_item' colspan="15%">債務別</td>
		<td class='table_td' colspan="85%">
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.DebitCodeManage.getDebitInfo(new Integer(0)),"debtCode",false)%>
		</td>
	</tr>
	<tr>
		<td class='table_item' colspan="15%">公債種類</td>
		<td class='table_td' colspan="85%">
			<%pageContext.setAttribute("collectionCode",tw.gov.nta.system.common.CodeDetManage.getCodeDet("DBK")); %>
			<html:select name='Airb0901Form' property='kind'>
				<html:option value="">請選擇</html:option>
				<html:options collection="collectionCode" labelName="valuess" labelProperty='label' property="valuess"/>
			</html:select>
		</td>
	</tr>
</table>