<!--
�{���ت��GGAMA03��r
�{���N���GGAMA03
�{������G0950301
�{���@�̡GFormBean Generator
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/displaytag" prefix="display"%>

<bean:define id="qryBudgetCode" name="Gama0301Form" property="qryBudgetCode" type="java.lang.Integer"/>
<bean:define id="qryDebtCode" name="Gama0301Form" property="qryDebtCode" type="java.lang.Integer"/>
<bean:define id="qryDebtType" name="Gama0301Form" property="qryDebtType" type="java.lang.String"/>
<bean:define id="qryBoundCode" name="Gama0301Form" property="qryBoundCode" type="java.lang.String"/>
<bean:define id="qryAccountKind" name="Gama0301Form" property="qryAccountKind" type="java.lang.String"/>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>�~��</td>
		<td class='table_td'>
			<html:text name='Gama0301Form' property='qryAccountYear' size='3' maxlength='3' />
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>�w��O</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.BudgetCodeManager.getBudgetInfo(),"qryBudgetCode","","","getDebtCode(this.form.qryBudgetCode.value,'qryDebtCode')",10,false)%>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>�ŰȧO</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.DebitCodeManage.getDebitInfo(0),"qryDebtCode",false)%>
		</td>
	</tr>
	
	<tr>
		<td class='table_item'>�ź�</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("DT"),"qryDebtType",10,false)%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>���v�_</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("BT"),"qryBoundCode",10,false)%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�O�_�ŭ�</td>
		<td class='table_td'>
			<select size="1" name="debt">
			    <option value=''>�п��</option>
				<option value=true>�O</option>
				<option value=false>�_</option>
			</select>
		</td>
	</tr>
	<tr>
		<td class='table_item'>���B����</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("AK"),"qryAccountKind",10,false)%>
		</td>
	</tr>
</table>
