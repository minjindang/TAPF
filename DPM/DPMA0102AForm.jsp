<!-- DIMA0101AForm.jsp
程式目的：DIMA01
程式代號：DIMA01
程式日期：0950223
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
<html:hidden name='Dpma0101Form' property='id'/>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>年度</td>
		<td class='table_td'>
			<bean:write name='Dpma0101Form' property='accountYear'/>
		</td>
		<td class='table_item'>期次</td>
		<td class='table_td'>
			<bean:write name='Dpma0101Form' property='serialNo'/>
		</td>
		<td class='table_item'>預算別</td>
		<td class='table_td'>
			<bean:define id='budgetCode' name='Dpma0101Form' property='budgetCode' type="java.lang.Integer"/>
			<%= tw.gov.nta.system.common.BudgetCodeManager.get(budgetCode).getBudgetName()%>
		</td>
		<td class='table_item'>債務別</td>
		<td class='table_td'>
			<bean:define id='debtCode' name='Dpma0101Form' property='debtCode' type="java.lang.Integer"/>
			<%=tw.gov.nta.system.common.DebitCodeManage.get(debtCode).getDebitName()%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>期別</td>
		<td class='table_td'>
			<bean:write name='Dpma0101Form' property='issueSerial'/>
		</td>
		<td class='table_item'>名稱</td>
		<td class='table_td' colspan="5">
			<bean:write name='Dpma0101Form' property='debtName'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>借款期間</td>
		<td class='table_td'>
			<bean:define id="issueDate" name="Dpma0101Form" property="issueDate" type="java.util.Date"/>
			<%=gov.dnt.tame.util.DateUtil.date2ROCStr(issueDate,"yyy/mm/dd")%>	~
			<bean:define id="dueDate" name="Dpma0101Form" property="dueDate" type="java.util.Date"/>
			<%=gov.dnt.tame.util.DateUtil.date2ROCStr(dueDate,"yyy/mm/dd")%>
		</td>
		<td class='table_item'>天數</td>
		<td class='table_td' colspan="5" id="days">
			<bean:write name='Dpma0101Form' property='days'/>日
		</td>
	</tr>
	<tr>
		<td class='table_item'>借款金額</td>
		<td class='table_td'>
			<bean:write name='Dpma0101Form' property='bigDecimal(issueAmount)' format='#,##0'/>
		</td>
		<td class='table_item'>已償金額</td>
		<td class='table_td'>
			<bean:write name='Dpma0101Form' property='bigDecimal(issueMainCapitalAmount)' format='#,##0'/>
		</td>
		<td class='table_item'>未償金額</td>
		<td class='table_td'>
			<bean:define id='issueMainCapitalAmount' name='Dpma0101Form' property='bigDecimal(issueMainCapitalAmount)' type='java.math.BigDecimal '/>
			<bean:define id='issueAmount' name='Dpma0101Form' property='bigDecimal(issueAmount)'  type='java.math.BigDecimal'/>
			<%= new java.text.DecimalFormat("#,##0").format(issueAmount.subtract(issueMainCapitalAmount)) %>
		</td>
		<td class='table_item'>平均加權利率</td>
		<td class='table_td'>
			<bean:write name='Dpma0101Form' property='bigDecimal(averageRate)' format='0.000'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>備註</td>
		<td class='table_td' colspan="5">
			<bean:write name='Dpma0101Form' property='remark'/>
		</td>
	</tr>
</table>
