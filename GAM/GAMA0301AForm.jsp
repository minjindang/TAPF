<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<html:hidden name="Gama0301Form" property="qryAccountYear"/>
<html:hidden name="Gama0301Form" property="qryBudgetCode"/>
<html:hidden name="Gama0301Form" property="qryDebtCode"/>
<html:hidden name="Gama0301Form" property="qryDebtType"/>
<html:hidden name="Gama0301Form" property="qryBoundCode"/>
<html:hidden name="Gama0301Form" property="qryAccountKind"/>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'><font color="red">*</font>�~��</td>
		<td class='table_td'>
			<html:text name='Gama0301Form' property='accountYear' size='3' maxlength='3' />
		</td>
		<td class='table_item'><font color="#ff0000">*</font>�~�����O</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("YK"),"yearKind",10,false)%>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="#ff0000">*</font>�w��O</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.BudgetCodeManager.getBudgetInfo(),"budgetCode","","","getDebtCode(this.form.budgetCode.value,'debtCode')",10,false)%>
		</td>
		<td class='table_item'><font color="#ff0000">*</font>�ŰȧO</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.DebitCodeManage.getDebitInfo(0),"debtCode",false)%>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="#ff0000">*</font>�ź�</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("DT"),"debtType",10,false)%>
		</td>
		<td class='table_item'><font color="#ff0000">*</font>���v�_</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("BT"),"boundCode",10,false)%>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="#ff0000">*</font>�O�_�ŭ�</td>
		<td class='table_td'>
			<select size="1" name="debt">
			    <option value=''>�п��</option>
				<option value=true>�O</option>
				<option value=false>�_</option>
			</select>
		</td>
		<td class='table_item'><font color="#ff0000">*</font>���B����</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("AK"),"accountKind",10,false)%>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="#ff0000">*</font>�ɴڪ��B</td>
		<td class='table_td'>
			<html:text name='Gama0301Form' property='bigDecimal(issueAmount)' size='20'maxlength='13' />
		</td>
		<td class='table_item'><font color="#ff0000">*</font>�ٴڪ��B</td>
		<td class='table_td'>
			<html:text name='Gama0301Form' property='bigDecimal(payAmount)' size='20' maxlength='13' />
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="#ff0000">*</font>���v�پl�B</td>
		<td class='table_td'>
			<html:text name='Gama0301Form' property='bigDecimal(remainAmount)' size='20' maxlength='13' />
		</td>
		<td class='table_item'><font color="#ff0000">*</font>�Q�����B</td>
		<td class='table_td'>
			<html:text name='Gama0301Form' property='bigDecimal(interestAmount)' size='20' maxlength='13' />
		</td>
	</tr>
</table>
