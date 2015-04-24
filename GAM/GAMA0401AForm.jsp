<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item' width='20%'><font color="red">*</font>年度</td>
		<td class='table_td'>
			<html:text name='Gama0401Form' property='accountYear' size='3' maxlength='3' />
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="#ff0000">*</font>預算別</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.BudgetCodeManager.getBudgetInfo(),"budgetCode","","","getDebtCode(this.form.budgetCode.value,'debtCode')",10,false)%>
		</td>
	</tr>
	<tr>
		<td class='table_item' width='20%'><font color="#ff0000">*</font>債務別</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.DebitCodeManage.getDebitInfo(0),"debtCode",false)%>
		</td>
	</tr>
	<tr>
		<td class='table_item' width='20%'>類別</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("DF"),"dataType","","",10, false)%>&nbsp;
		</td>
	</tr>
</table>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item' rowspan='4' width='15%'>預算數</td>
		<td class='table_item' width='15%'>總額</td>
		<td class='table_td' width='20%'><html:text name='Gama0401Form' property='bigDecimal(budgetAmount)' size='20' maxlength='20' onkeyup="calculate(this.form);"/></td>
		<td class='table_item' rowspan='4' width='15%'>決算數</td>
		<td class='table_item' width='15%'>總額</td>
		<td class='table_td' width='20%'><html:text name='Gama0401Form' property='bigDecimal(auditAmount)' size='20' maxlength='20' onkeyup="calculate(this.form);"/></td>
	</tr>
	<tr>
		<td class='table_item' width='20%'>排限金額</td>
		<td class='table_td'><html:text name='Gama0401Form' property='bigDecimal(budgetDamount)' size='20' maxlength='20' onkeyup="calculate(this.form);"/></td>
		<td class='table_item'>排限金額</td>
		<td class='table_td'><html:text name='Gama0401Form' property='bigDecimal(auditDamount)' size='20' maxlength='20' onkeyup="calculate(this.form);"/></td>
	</tr>
	<tr>
		<td class='table_item'>未排限餘額</td>
		<td class='table_td'><html:text name='Gama0401Form' property='bigDecimal(budgetUamount)' size='20' maxlength='20' onkeyup="calculate2(this.form);"/></td>
		<td class='table_item'>未排限餘額</td>
		<td class='table_td'><html:text name='Gama0401Form' property='bigDecimal(auditUamount)' size='20' maxlength='20' onkeyup="calculate2(this.form);"/></td>
	</tr>
	<tr>
		<td class='table_td' colspan='2'><html:checkbox name='Gama0401Form' property="budgetYn" onclick='checkBudget(this.form)'/>是否為歲(入)出</td>
		<td class='table_td' colspan='2'><html:checkbox name='Gama0401Form' property="auditYn" onclick='checkAudit(this.form)'/>是否為歲(入)出</td>
	</tr>
	<tr>
		<td class='table_item' rowspan='4'>實際數</td>
		<td class='table_item'>總額</td>
		<td class='table_td'><html:text name='Gama0401Form' property='bigDecimal(realAmount)' size='20' maxlength='20' onkeyup="calculate(this.form);"/></td>
		<td class='table_item' rowspan='4'>保留數</td>
		<td class='table_item'>總額</td>
		<td class='table_td'><html:text name='Gama0401Form' property='bigDecimal(keepAmount)' size='20' maxlength='20' onkeyup="calculate(this.form);"/></td>
	</tr>
	<tr>
		<td class='table_item'>排限金額</td>
		<td class='table_td'><html:text name='Gama0401Form' property='bigDecimal(realDamount)' size='20' maxlength='20' onkeyup="calculate(this.form);"/></td>
		<td class='table_item'>排限金額</td>
		<td class='table_td'><html:text name='Gama0401Form' property='bigDecimal(keepDamount)' size='20' maxlength='20' onkeyup="calculate(this.form);"/></td>
	</tr>
	<tr>
		<td class='table_item'>未排限餘額</td>
		<td class='table_td'><html:text name='Gama0401Form' property='bigDecimal(realUamount)' size='20' maxlength='20' onkeyup="calculate2(this.form);"/></td>
		<td class='table_item'>未排限餘額</td>
		<td class='table_td'><html:text name='Gama0401Form' property='bigDecimal(keepUamount)' size='20' maxlength='20' onkeyup="calculate2(this.form);"/></td>
	</tr>
	<tr>
		<td class='table_td' colspan='2'><html:checkbox name='Gama0401Form' property="realYn" onclick="checkReal(this.form);"/>是否為歲(入)出</td>
		<td class='table_td' colspan='2'><html:checkbox name='Gama0401Form' property="keepYn" />是否為歲(入)出</td>
	</tr>
</table>
