<!-- CIMA0105AForm.jsp
程式目的：CIMA01
程式代號：CIMA01
程式日期：0950306
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
<table class='table_1' width='100%'>
		<html:hidden name='Cima0101Form' property='id'/>
		<html:hidden name='Cima0101Form' property='qryaccountYear'/>
		<html:hidden name='Cima0101Form' property='qryserialNo'/>
		<html:hidden name='Cima0101Form' property='qryissueSerial'/>
		<html:hidden name='Cima0101Form' property='qrydebtName'/>
		<html:hidden name='Cima0101Form' property='date(issueDate)'/>
		<html:hidden name='Cima0101Form' property='date(dueDate)'/>	
		<html:hidden name='Cima0101Form' property='bankId'/>
		<html:hidden name='Cima0101Form' property='debtId'/>		
	<tr>
		<td class='table_item'><font color="red">*</font>預算年度</td>
		<td class='table_td'>
			<bean:define id="id" name="Cima0101Form" property="id" />
			<input type="hidden" name="myIssDet.issueId" value="<%=id%>" />
			<html:hidden name='Cima0101Form' property='myIssDet.deleteRemark' value="N"/>
			<html:hidden name='Cima0101Form' property='bigDecimal(myIssDet.realAmount)' value="0"/>
			<html:text name='Cima0101Form' property='myIssDet.budgetYear' maxlength='3' size='5' />
		</td>
	</tr>	
	<tr>
		<td class='table_item'><font color="red">*</font>預算別</td>
		<td class='table_td'>
			<html:select name='Cima0101Form' property='myIssDet.budgetCode' onchange="changeValue(this.form)">
					<html:option value="0">請選擇</html:option>
					<html:optionsCollection name="Cima0101Form" property="budgetList" label="budgetName" value="id"/>
			</html:select>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>債務別</td>
		<td class='table_td'>
			<html:select name='Cima0101Form' property='myIssDet.debtCode' >
					<html:option value="0">請選擇</html:option>
					<logic:notEmpty name="Cima0101Form" property="debtList">
						<html:optionsCollection name="Cima0101Form" property="debtList" label="debitName" value="id"/>
					</logic:notEmpty>
			</html:select>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>預計借款金額</td>
		<td class='table_td'>
			<html:text name='Cima0101Form' style="text-align: right" property='bigDecimal(myIssDet.planAmount)' size='20' maxlength='20'/>
		</td>
	</tr>
</table>
