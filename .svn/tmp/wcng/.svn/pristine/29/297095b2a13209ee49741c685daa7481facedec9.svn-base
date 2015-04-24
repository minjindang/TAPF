<!-- CIMA0101ML2Form.jsp
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
<%@ page import="gov.dnt.tame.util.DateUtil" %>
<table class='table_1' width='100%'>
	<tr>
		<td>
			<display:table class="table_list" name="issueDetList" id="row">
			<display:column title="預算年度">
			<bean:define id="myIssDetId" name="row" property="id" type="java.lang.Integer"/>
			<bean:define id="issueId" name="row" property="issueId" type="java.lang.Integer"/>
				<%
						java.util.Map paramMap = new java.util.HashMap();
							paramMap.put("myIssDet.id",myIssDetId);
							paramMap.put("myIssDet.issueId",issueId);
							paramMap.put("id",issueId);
						pageContext.setAttribute("paramMap", paramMap);
				%>
				<html:link action='/CIMA0128' name='paramMap'>
						<logic:notEmpty name="row" property="budgetYear">
							<bean:write name='row' property='budgetYear'/>		
						</logic:notEmpty>
				</html:link>	
				</display:column>
				<display:column title="預算別">  
				<html:link action='/CIMA0128' name='paramMap'>
						<bean:define id="budgetCode" name='row' property='budgetCode' type="java.lang.Integer"/>
						<%=tw.gov.nta.system.common.BudgetCodeManager.get(budgetCode).getBudgetName()%>
				</html:link>	
				</display:column>
				<display:column title="債務別">
				<html:link action='/CIMA0128' name='paramMap'>
						<bean:define id="debtCode" name="row" property="debtCode" type="java.lang.Integer"/>
						<%=tw.gov.nta.system.common.DebitCodeManage.get(debtCode).getDebitName()%>
				</html:link>	
				</display:column>		
				<display:column title="預計借款金額">
				<html:link action='/CIMA0128' name='paramMap'>
					<logic:notEmpty name='row' property='planAmount'>
						<bean:define id="planAmount" name='row' property='planAmount' type="java.math.BigDecimal"/>
							<p align="right"><%=new java.text.DecimalFormat("#,##0").format(planAmount.setScale(0,5))%></p>
					</logic:notEmpty>
					<logic:empty name='row' property='planAmount'>
							<p align="right"><%="0"%></p>
					</logic:empty>
				</html:link>	
				</display:column>	
				<display:column title="實際借款金額">
				<html:link action='/CIMA0128' name='paramMap'>
					<logic:notEmpty name='row' property='realAmount'>
						<bean:define id="realAmount" name='row' property='realAmount' type="java.math.BigDecimal"/>
							<p align="right"><%=new java.text.DecimalFormat("#,##0").format(realAmount.setScale(0,5))%></p>
					</logic:notEmpty>
					<logic:empty name='row' property='realAmount'>
							<p align="right"><%="0"%></p>
					</logic:empty>
				</html:link>	
				</display:column>			
			</display:table>
		</td>
	</tr>
</table>

