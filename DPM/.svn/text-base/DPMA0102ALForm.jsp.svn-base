<!--
程式目的：GAMA02文字
程式代號：GAMA02
程式日期：0950301
程式作者：FormBean Generator
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>
<%@ page import="gov.dnt.tame.util.DateUtil,java.math.BigDecimal" %>
<html:hidden name='Dpma0101Form' property='Date(repayDate)'/>
<html:hidden name='Dpma0101Form' property='repayDays'/>
<html:hidden name='Dpma0101Form' property='payType'/>
<html:hidden name='Dpma0101Form' property='Date(issueDate)'/>
<table class='table_1' width='100%'>
	<tr>
		<td>
			<display:table class="table_list" name="Dpma0101Form.debtPlanDets" id="row">
				<display:column title="銀行代碼">
					<logic:present name="row" property="debt.bank">
						<bean:define id='bank' name="row" property="debt.bank" type="tw.gov.nta.sql.debt.BankRef"/>
						<bean:write name='bank' property='bankCode'/>
					</logic:present>
				</display:column>
				<display:column title="銀行名稱">
					<logic:present name="row" property="debt.bank">
						<bean:write name='bank' property='bankName'/>
					</logic:present>
				</display:column>
				<display:column title="利率">
					<bean:define id='rate' name='row' property='debt.compareRate' type='java.math.BigDecimal'/>
					<%= rate.setScale(3,4) +"%"%>
				</display:column>
				<display:column title="償還否">
					<input type='checkbox' name="debtPlanDet[<%=row_rowNum%>].repay" />
					<bean:define id="id" name="row" property="debtPlanDet.id" type="java.lang.Integer"/>
					<input type="hidden" name="debtPlanDet[<%=row_rowNum%>].id" value="<%=id%>">
				</display:column>
				<display:column title="償還日期">
					<bean:define id='repayDate' name='Dpma0101Form' property='repayDate' type="java.util.Date"/>
					<%= DateUtil.date2ROCStr(repayDate,"yyy/mm/dd")%>
				</display:column>
				<display:column title="天數">
					<bean:write name='Dpma0101Form' property='repayDays'/>
				</display:column>
				<display:column title="方式">
					<bean:write name='Dpma0101Form' property='payType'/>
				</display:column>
				<display:column title="償還金額">
					<bean:write name='row' property='debtPlanDet.capitalAmount' format='#,##0'/>
				</display:column>
				<display:column title="償還利息">
					<bean:write name='row' property='debtPlanDet.interestAmount' format='#,##0'/>
				</display:column>
				<display:column title="償還本息合計">
					<bean:define id='capitalAmount' name='row' property='debtPlanDet.capitalAmount' type='java.math.BigDecimal'/>
					<bean:define id='interestAmount' name='row' property='debtPlanDet.interestAmount' type='java.math.BigDecimal'/>
					<%= new java.text.DecimalFormat("#,###").format(capitalAmount.add(interestAmount)) %>
				</display:column>
				<display:column title="實付金額">
					<bean:define id='rate' name='row' property='debt.compareRate' type='java.math.BigDecimal'/>
					<input type="hidden" name="rate" value="<%=rate %>"/>
					<bean:define id="capitalSerial" name='row' property='debtPlanDet.capitalSerial' type="java.lang.Integer"/>
					<input type="hidden" name="debtPlanDet[<%=row_rowNum%>].capitalSerial" value="<%=capitalSerial%>" />
					<bean:define id="capitalAmount" name='row' property='capitalAmount' type="java.lang.String"/>
					<bean:define id='repayDays' name='Dpma0101Form' property='repayDays' type="java.lang.String"/>
					<bean:define id='debt' name="row" property="debt" type="tw.gov.nta.sql.debt.DebtMain"/>
					
					<logic:notEmpty name='row' property='capitalAmount'>
						<%request.setAttribute("capitalAmountGuess",new BigDecimal(capitalAmount));%>
					</logic:notEmpty>
					<logic:empty name='row' property='capitalAmount'>
						<%request.setAttribute("capitalAmountGuess",new BigDecimal(0));%>
					</logic:empty>
					<input type="hidden" name="debtPlanDet[<%=row_rowNum%>].capitalAmount" value="<%=request.getAttribute("capitalAmountGuess").toString()%>" />
					<html:text name='Dpma0101Form' property='capitalAmountPay'
							style="text-align:right;border-top:0 px;border-bottom:0 px;border-left:0 px;border-right:0 px" size="10" maxlength="20"  
							value="<%=((java.math.BigDecimal)(request.getAttribute("capitalAmountGuess"))).toString()%>" readonly="false" 
							onblur="changeInterestAmount(this.form)"/>
				</display:column>
				<display:column title="實付利息">
					<bean:define id='days' name='Dpma0101Form' property='repayDays' type='java.lang.String'/>
					<bean:define id='rate' name='row' property='debt.compareRate' type='java.math.BigDecimal'/>
					<bean:define id="capitalAmount" name='row' property='capitalAmount' type="java.lang.String"/>
					<bean:define id='issueDate' name='Dpma0101Form' property='issueDate' type="java.util.Date"/>
					<bean:define id='repayDate' name='Dpma0101Form' property='repayDate' type="java.util.Date"/>
					<logic:notEmpty name='row' property='interestAmount'>
					<%
						BigDecimal countDay = null;
						tw.gov.nta.debt.common.InterestCounter myCounter = new tw.gov.nta.debt.common.InterestCounter();
						if(!myCounter.isLeap(issueDate,repayDate)){
							countDay = new BigDecimal(365);
						}else{
							countDay = new BigDecimal(366);
						}
						BigDecimal interestAmount = new BigDecimal(capitalAmount).multiply(rate.divide(new BigDecimal(100))).multiply(new BigDecimal(days)).divide(countDay,5).setScale(0,BigDecimal.ROUND_HALF_UP);
						request.setAttribute("interestAmountGuess",interestAmount);
					%>
					</logic:notEmpty>
					<logic:empty name='row' property='interestAmount'>
						<%request.setAttribute("interestAmountGuess",new BigDecimal(0)); %>
					</logic:empty>
					<bean:define id="interestSerial" name='row' property='debtPlanDet.interestSerial' type="java.lang.Integer"/>
					<input type="hidden" name="debtPlanDet[<%=row_rowNum%>].interestSerial" value="<%=interestSerial%>"/>
					<input type="hidden" name="debtPlanDet[<%=row_rowNum%>].interestAmount" value="<%=request.getAttribute("interestAmountGuess").toString()%>"/>
					<html:text name='Dpma0101Form' property='interestAmountPay'
							style="text-align:right;border-top:0 px;border-bottom:0 px;border-left:0 px;border-right:0 px" size="10" maxlength="20"  
							value="<%=((java.math.BigDecimal)(request.getAttribute("interestAmountGuess"))).toString()%>" readonly="false"/>
				</display:column>
				<display:column title="實際本息合計">
					<bean:define id='rate' name='row' property='debt.compareRate' type='java.math.BigDecimal'/>
					<bean:define id="capitalSerial" name='row' property='debtPlanDet.capitalSerial' type="java.lang.Integer"/>
					<bean:define id="capitalAmount" name='row' property='capitalAmount' type="java.lang.String"/>
					<bean:define id='repayDays' name='Dpma0101Form' property='repayDays' type="java.lang.String"/>
					<bean:define id='debt' name="row" property="debt" type="tw.gov.nta.sql.debt.DebtMain"/>
					<bean:define id='days' name='Dpma0101Form' property='repayDays' type='java.lang.String'/>
					<bean:define id='issueDate' name='Dpma0101Form' property='issueDate' type="java.util.Date"/>
					<bean:define id='repayDate' name='Dpma0101Form' property='repayDate' type="java.util.Date"/>
					<%
						BigDecimal capitalAmountGuess = (java.math.BigDecimal)request.getAttribute("capitalAmountGuess");
						BigDecimal interestAmountGuess = (java.math.BigDecimal)request.getAttribute("interestAmountGuess");
						BigDecimal totalAmount = capitalAmountGuess.add(interestAmountGuess);
						request.setAttribute("totalAmountGuess",totalAmount);
					%>
					<input type="hidden" name="debtPlanDet[<%=row_rowNum%>].totalCount" value="<%= request.getAttribute("totalAmountGuess").toString()%>">
					<%= new java.text.DecimalFormat("#,###").format((java.math.BigDecimal)request.getAttribute("totalAmountGuess")) %>
				</display:column>
			</display:table>
		</td>
	</tr>
</table>
