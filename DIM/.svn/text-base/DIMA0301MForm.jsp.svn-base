<!-- DIMA0301MForm.jsp
程式目的：DIMA03
程式代號：DIMA03
程式日期：0950224
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

<html:hidden name='Dima0301Form' property="id"/>
<html:hidden name='Dima0301Form' property="qryId"/>
<html:hidden name='Dima0301Form' property="qryAccountYear"/>
<html:hidden name='Dima0301Form' property="qrySerialNo"/>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>年度</td>
		<td class='table_td'>
			<bean:write name='Dima0301Form' property='issueMain.accountYear'/>
		</td>
		<td class='table_item'>期次</td>
		<td class='table_td'>
			<bean:write name='Dima0301Form' property='issueMain.serialNo'/>
		</td>
		<td class='table_item'>預算別</td>
		<td class='table_td'>
			<logic:notEmpty  name='Dima0301Form' property='issueMain.budgetCode' >
				<bean:define id="budgetCode" name='Dima0301Form' property='issueMain.budgetCode' type="java.lang.Integer" />
					<%
						tw.gov.nta.system.common.BudgetCodeManager mybcode = new tw.gov.nta.system.common.BudgetCodeManager();
						tw.gov.nta.sql.BudgetRef myBudget = new tw.gov.nta.sql.BudgetRef();
						myBudget = mybcode.get(budgetCode);
						request.setAttribute("budgetName",myBudget.getBudgetName());
					%>
					<%=request.getAttribute("budgetName") %>
			</logic:notEmpty>
		</td>
		<td class='table_item'>債務別</td>
		<td class='table_td'>
			<logic:notEmpty  name='Dima0301Form' property='issueMain.debtName' >
				<bean:define id="debtCode" name='Dima0301Form' property='issueMain.debtCode' type="java.lang.Integer" />
					<%=tw.gov.nta.system.common.DebitCodeManage.get(debtCode).getDebitName()%>
			</logic:notEmpty>
		</td>
	</tr>
	<tr>
		<td class='table_item'>期別</td>
		<td class='table_td'>
			<bean:write name='Dima0301Form' property='issueMain.issueSerial'/>
		</td>
		<td class='table_item'>預算別名稱</td>
		<td class='table_td' colspan='5'>
			<bean:write name='Dima0301Form' property='issueMain.debtName'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>借款期間</td>
		<td class='table_td'>
			<logic:present name="Dima0301Form" property="issueMain.issueDate">
				<bean:define id="issueDate" name="Dima0301Form" property="issueMain.issueDate" type="java.util.Date"/>
				<%=gov.dnt.tame.util.DateUtil.date2ROCStr(issueDate,"yyy/mm/dd")%>	~
				<%request.setAttribute("issueDate",issueDate);%>
			</logic:present>
			<logic:present name="Dima0301Form" property="issueMain.dueDate">
				<bean:define id="dueDate" name="Dima0301Form" property="issueMain.dueDate" type="java.util.Date"/>
				<%=gov.dnt.tame.util.DateUtil.date2ROCStr(dueDate,"yyy/mm/dd")%>
				<%request.setAttribute("dueDate",dueDate);%>
			</logic:present>
		</td>
		<td class='table_item'>天數</td>
		<td class='table_td' colspan='5'>
			<%
				java.util.Date issueDate = (java.util.Date)(request.getAttribute("issueDate"));
				java.util.Date dueDate = (java.util.Date)(request.getAttribute("dueDate"));
				tw.gov.nta.debt.common.DayCount days = new tw.gov.nta.debt.common.DayCount();
				request.setAttribute("days",days.dayCount(issueDate,dueDate,"C"));
			%>
			<%=request.getAttribute("days")%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>借款金額</td>
		<td class='table_td'>
			<p align="right"><bean:write name='Dima0301Form' property='issueMain.issueAmount' format='#,##0'/></p>
		</td>
		<td class='table_item'>已償金額</td>
		<td class='table_td'>
			<p align="right"><bean:write name='Dima0301Form' property='bigDecimal(capitalAmount)' format='#,##0'/></p>
		</td>
		<td class='table_item'>未償金額</td>
		<td class='table_td'>
			<logic:notEmpty name='Dima0301Form' property='issueMain.issueAmount'> 
				<logic:notEmpty name='Dima0301Form' property='issueMain.capitalAmount'>
					<bean:define id="issueAmount" name='Dima0301Form' property='issueMain.issueAmount' type="java.math.BigDecimal"/>
					<bean:define id="capitalAmount" name='Dima0301Form' property='bigDecimal(capitalAmount)' type="java.math.BigDecimal"/>
						<p align="right"><%= new java.text.DecimalFormat("#,##0").format(issueAmount.subtract(capitalAmount))%></p> 
				</logic:notEmpty>	
			</logic:notEmpty>
			<logic:empty name='Dima0301Form' property='issueMain.issueAmount'> 
				<p align="right"><%=0%></p> 
			</logic:empty>
		</td>
		<td class='table_item'>加權平均利率</td>
		<td class='table_td'>
			<p align="right"><bean:write name='Dima0301Form' property='bigDecimal(issueMain.averageRate)' format='0.000'/></p>
		</td>
	</tr>
	<tr>
		<td class='table_item'>備註</td>
		<td class='table_td' colspan='7'>
			<bean:write name='Dima0301Form' property='issueMain.remark'/>
		</td>
	</tr>
</table>