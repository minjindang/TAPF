<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<html:hidden name="Gama0301Form" property="id"/>
<html:hidden name="Gama0301Form" property="qryAccountYear"/>
<html:hidden name="Gama0301Form" property="qryBudgetCode"/>
<html:hidden name="Gama0301Form" property="qryDebtCode"/>
<html:hidden name="Gama0301Form" property="qryDebtType"/>
<html:hidden name="Gama0301Form" property="qryBoundCode"/>
<html:hidden name="Gama0301Form" property="qryAccountKind"/>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'><font color="#ff0000">*</font>年度</td>
		<td class='table_td'>
			<html:text name='Gama0301Form' property='accountYear' size='3' maxlength='3' />
		</td>
		<td class='table_item'><font color="#ff0000">*</font>年度類別</td>
		<td class='table_td'>
			<bean:define id="yearKind" name="Gama0301Form" property="yearKind" type="java.lang.String"/>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("YK"),"yearKind",yearKind,10,false)%>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="#ff0000">*</font>預算別</td>
		<td class='table_td'>
			<bean:define id="budgetCode" name="Gama0301Form" property="budgetCode" type="java.lang.Integer"/>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.BudgetCodeManager.getBudgetInfo(),"budgetCode",(budgetCode).toString(),"","getDebtCode(this.form.budgetCode.value,'debtCode')",10,false)%>
		</td>
		<td class='table_item'><font color="#ff0000">*</font>債務別</td>
		<td class='table_td'>
			<bean:define id="debtCode" name="Gama0301Form" property="debtCode" type="java.lang.Integer"/>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.DebitCodeManage.getDebitInfo(),"debtCode",(debtCode).toString(),false)%>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="#ff0000">*</font>債種</td>
		<td class='table_td'>
			<bean:define id="debtType" name="Gama0301Form" property="debtType" type="java.lang.String"/>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("DT"),"debtType",debtType,false)%>
		</td>
		<td class='table_item'><font color="#ff0000">*</font>自償否</td>
		<td class='table_td'>
			<bean:define id="boundCode" name="Gama0301Form" property="boundCode" type="java.lang.String"/>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("BT"),"boundCode",boundCode,false)%>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color=#ff0000>*</font>是否債限</td>
		<td class='table_td'>
			<bean:define id="debt" name="Gama0301Form" property="debt" type="java.lang.Boolean"/>
			<select size="1" name="debt">
			    <option value=''>請選擇</option>
				<option value=true <%if(debt.booleanValue()) out.println(" selected"); %>>是</option>
				<option value=false<%if(! debt.booleanValue())out.println(" selected"); %>>否</option>
			</select>
		</td>
		<td class='table_item'><font color="#ff0000">*</font>金額種類</td>
		<td class='table_td'>
			<bean:define id="accountKind" name="Gama0301Form" property="accountKind" type="java.lang.String"/>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("AK"),"accountKind",accountKind,false)%>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="#ff0000">*</font>借款金額</td>
		<td class='table_td'>
			<html:text name='Gama0301Form' property='bigDecimal(issueAmount)' size='20'maxlength='13' />
		</td>
		<td class='table_item'><font color="#ff0000">*</font>還款金額</td>
		<td class='table_td'>
			<html:text name='Gama0301Form' property='bigDecimal(payAmount)' size='20' maxlength='13' />
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="#ff0000">*</font>未償還餘額</td>
		<td class='table_td'>
			<html:text name='Gama0301Form' property='bigDecimal(remainAmount)' size='20' maxlength='13' />
		</td>
		<td class='table_item'><font color="#ff0000">*</font>利息金額</td>
		<td class='table_td'>
			<html:text name='Gama0301Form' property='bigDecimal(interestAmount)' size='20' maxlength='13' />
		</td>
	</tr>
</table>
