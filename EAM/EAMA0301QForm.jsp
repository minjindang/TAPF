<!--
程式目的：EAMA03文字
程式代號：EAMA03
程式日期：0950301
程式作者：Linus
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %> 

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>發行年度</td>
		<td class='table_td'>
			<html:text name="Eamb0101Form" property="accountYear" maxlength="5" size="30"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>期次</td>
		<td class='table_td' colspan="3">
			<html:text name="Eamb0101Form" property="serialNo" maxlength="5" size="30"/>	
		</td>
	</tr>
	<tr>
		<td class='table_item'>預算別</td>
		<td class='table_td' colspan="3">
			<html:select name="Eamb0101Form" property="budgetCode" >
				<html:option value="">  全部預算別   </html:option>
				<html:optionsCollection name="Eamb0101Form" property="allBudgetCode" label="budgetName" value="id"/>
			</html:select>
		</td>
	</tr>
	<tr>
		<td class='table_item'>債務別</td>
		<td class='table_td'>
			<html:select name="Eamb0101Form" property="debtCode" >
				<html:option value="">  全部債務別    </html:option>
				<html:optionsCollection name="Eamb0101Form" property="allDebtCode" label="debitName" value="id"/>
			</html:select>
		</td>
	</tr>
	<tr>
		<td class='table_item'>債務名稱</td>
		<td class='table_td' colspan="3">
			<html:text name="Eamb0101Form" property="debtName" maxlength="30" size="30"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>發行日期</td>
		<td class='table_td' colspan="3">
			<html:text name="Eamb0101Form" property="startIssueDate" maxlength="7" size="30"/>
			 至 
			<html:text name="Eamb0101Form" property="endIssueDate" maxlength="7" size="30"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>到期日期</td>
		<td class='table_td' colspan="3">
			<html:text name="Eamb0101Form" property="startDueDate" maxlength="7" size="30"/>
			 至 
			<html:text name="Eamb0101Form" property="endDueDate" maxlength="7" size="30"/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>發行形式</td>
		<td class='table_td' colspan="3">
			<html:select name="Eamb0101Form" property="issueKind">
				<html:option value="">請選擇</html:option>
				<html:option value="0">登錄</html:option>
				<html:option value="1">債票</html:option>
			</html:select>
		</td>
	</tr>
</table>
