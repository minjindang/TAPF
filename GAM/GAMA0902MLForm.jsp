<!-- GAMA0902MLForm.jsp
程式目的：GAMA09
程式代號：GAMA09
程式日期：0980409
程式作者：Chris
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
			<display:table class="table_list" name="debtMains" id="row">
			<display:column title="編號"><%=row_rowNum%></display:column>
			<display:column title="預算年度">
			<bean:define id="id" name="Cima0101Form" property="id" type="java.lang.Integer"/>
			<bean:define id="debtId" name="row" property="id" type="java.lang.Integer"/>
			<bean:define id='issueDate' name='Cima0101Form' property='issueDate' type="java.util.Date"/>
			<bean:define id='dueDate' name='Cima0101Form' property='dueDate' type="java.util.Date"/>	
			<logic:notEmpty name="row" property="bank">
				<bean:define id='bankId' name='row' property='bank.id' type="java.lang.Integer"/>
				<%request.setAttribute("bankId",bankId);%>		
			</logic:notEmpty>
			<logic:empty name="row" property="bank">
				<%request.setAttribute("bankId",new java.lang.Integer(0));%>		
			</logic:empty>	
			
				<%
						java.util.Map paramMap = new java.util.HashMap();
							paramMap.put("id",id);
							paramMap.put("debtId",debtId);
							paramMap.put("date(issueDate)",DateUtil.date2ROCStr(issueDate) );
							paramMap.put("date(dueDate)",DateUtil.date2ROCStr(dueDate));
							if(0 != ((java.lang.Integer)(request.getAttribute("bankId"))).intValue())
							{
								paramMap.put("bankId",(java.lang.Integer)(request.getAttribute("bankId")));
							}
						pageContext.setAttribute("paramMap", paramMap);
				%>
				<html:link action='/GAMA0902MLOAD' name='paramMap'>
						<logic:notEmpty name="row" property="budgetYear">
							<bean:write name='row' property='budgetYear'/>		
						</logic:notEmpty>
				</html:link>	
				</display:column>
				<display:column title="預算別">  
				<html:link action='/GAMA0902MLOAD' name='paramMap'>
					<logic:notEmpty name="row" property="budgetCode">
						<bean:define id="budgetCode" name='row' property='budgetCode' type="java.lang.Integer"/>
						<%
							if(0 != budgetCode.intValue())
							{	
								out.print(tw.gov.nta.system.common.BudgetCodeManager.get(budgetCode).getBudgetName());
							}	
						%>
					</logic:notEmpty>	
				</html:link>	
				</display:column>
				<display:column title="債務別">
				<html:link action='/GAMA0902MLOAD' name='paramMap'>
					<logic:notEmpty name="row" property="debtCode">
						<bean:define id="debtCode" name="row" property="debtCode" type="java.lang.Integer"/>
						<%
							if(0 != debtCode.intValue())
							{
								out.print(tw.gov.nta.system.common.DebitCodeManage.get(debtCode).getDebitName());
							}	
						%>
					</logic:notEmpty>	
				</html:link>	
				</display:column>		
				<display:column title="銀行代號">
				<html:link action='/GAMA0902MLOAD' name='paramMap'>
					<logic:notEmpty name="row" property="bank">
						<bean:write name='row' property='bank.bankCode'/>		
					</logic:notEmpty>	
				</html:link>	
				</display:column>	
				<display:column title="銀行名稱">
				<html:link action='/GAMA0902MLOAD' name='paramMap'>
					<logic:notEmpty name="row" property="bank">
						<bean:write name='row' property='bank.bankName'/>	
					</logic:notEmpty>				
				</html:link>	
				</display:column>	
				<display:column title="比價/議價金額">
				<html:link action='/GAMA0902MLOAD' name='paramMap'>
					<logic:notEmpty name='row' property='compareAmount'>
						<bean:define id="compareAmount" name='row' property='compareAmount' type="java.math.BigDecimal"/>
							<p align="right"><%= new java.text.DecimalFormat("#,##0").format(compareAmount.setScale(0,5))%></p>
					</logic:notEmpty>
					<logic:empty name='row' property='compareAmount'>
							<p align="right"><%="0"%></p>
					</logic:empty>
				</html:link>	
				</display:column>	
				<display:column title="利率%">
				<html:link action='/GAMA0902MLOAD' name='paramMap'>
					<logic:notEmpty name='row' property='compareRate'>
						<bean:define id="compareRate" name='row' property='compareRate' type="java.math.BigDecimal"/>
							<p align="right"><%=compareRate.setScale(3,5)%></p>
					</logic:notEmpty>
					<logic:empty name='row' property='compareRate'>
							<p align="right"><%="0.0000"%></p>	
					</logic:empty>
				</html:link>	
				</display:column>	
				<display:column title="得標">
				<html:hidden name="Cima0101Form" property="ischeck"/>
						<bean:define id="id" name='row' property='id' type="java.lang.Integer" />
						<bean:define id="accrue" name="row" property="accrue" type="java.lang.String"/>
						<input type="checkbox" name='accrue' value="<%=id%>" <%="Y".equals(accrue)?"checked":"N"%> />
						<input type="hidden" name="countRow" value="<%=id%>"/>	
				</display:column>	
				<display:column title="得標金額">
				<html:link action='/GAMA0902MLOAD' name='paramMap'>
					<logic:notEmpty name='row' property='issueAmount'>
						<bean:define id="issueAmount" name='row' property='issueAmount' type="java.math.BigDecimal"/>
							<p align="right"><%=new java.text.DecimalFormat("#,##0").format(issueAmount.setScale(4,5))%></p>
					</logic:notEmpty>
					<logic:empty name='row' property='issueAmount'>
							<p align="right"><%="0"%></p>
					</logic:empty>
				</html:link>	
				</display:column>	
				<display:column title="利息">
				<html:link action='/GAMA0902MLOAD' name='paramMap'>
					<logic:notEmpty name='row' property='originInterestAmount'>
						<bean:define id="originInterestAmount" name='row' property='originInterestAmount' type="java.math.BigDecimal"/>
							<p align="right"><%=new java.text.DecimalFormat("#,##0").format(originInterestAmount.setScale(4,5))%></p>
					</logic:notEmpty>
					<logic:empty name='row' property='originInterestAmount'>
							<p align="right"><%="0"%></p>	
					</logic:empty>
				</html:link>	
				</display:column>
				<display:column title="本息合計">
				<html:link action='/GAMA0902MLOAD' name='paramMap'>
						<bean:define id="issueAmount" name="row" property="issueAmount" type="java.math.BigDecimal"/>
						<bean:define id="originInterestAmount" name="row" property="originInterestAmount" type="java.math.BigDecimal"/>
						<p align="right"><%=new java.text.DecimalFormat("#,##0").format(issueAmount.add(originInterestAmount))%></p>	
				</html:link>		
				</display:column>			
			</display:table>
		</td>
	</tr>
</table>

