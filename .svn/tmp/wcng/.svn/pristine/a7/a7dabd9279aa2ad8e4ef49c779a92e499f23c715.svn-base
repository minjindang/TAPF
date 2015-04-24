<!-- CPMA0102ALForm.jsp
程式目的：CPMA01
程式代號：CPMA01
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
<%@ page import="java.math.BigDecimal" %>
<table class='table_1' width='100%'>
	<tr>
		<td>
			<display:table class="table_list" name="collection" id="row">
			<display:column title="銀行代號">
				<logic:notEmpty name='row' property='plan.debt.bank'>			
					<logic:notEmpty name='row' property='plan.debt.bank.bankCode'>
						<bean:define id="bankCode" name='row' property='plan.debt.bank.bankCode'
							type="java.lang.String" />
						<%=bankCode%>
					</logic:notEmpty>
					<logic:empty name='row' property='plan.debt.bank.bankCode'>
						<%=""%>
					</logic:empty>
				</logic:notEmpty>
			</display:column>
			<display:column title="銀行名稱">
				<logic:notEmpty name='row' property='plan.debt.bank'>			
					<logic:notEmpty name='row' property='plan.debt.bank.bankName'>
						<bean:define id="bankName" name='row' property='plan.debt.bank.bankName'
							type="java.lang.String" />
						<%=bankName%>
					</logic:notEmpty>
					<logic:empty name='row' property='plan.debt.bank.bankName'>
						<%=""%>
					</logic:empty>
				</logic:notEmpty>	
			</display:column>
			<display:column title="償還日期">
				<logic:notEmpty name='row' property='repayDate'>
					<bean:define id="repayDate" name='row' property='repayDate'
						type="java.util.Date" />
					<%=DateUtil.date2ROCStr(repayDate)%>
				</logic:notEmpty>
				<logic:empty name='row' property='repayDate'>
					<%="000/00/00"%>
				</logic:empty>
			</display:column>
			<display:column title="計息天數">
				<logic:notEmpty name='row' property='interestDays'>
					<bean:define id="interestDays" name='row'
						property='interestDays' type="java.lang.Integer" />
					<%=interestDays%>
				</logic:notEmpty>
				<logic:empty name='row' property='interestDays'>
					<%="0"%>
				</logic:empty>
			</display:column>
			<display:column title="方式">
				<logic:notEmpty name='row' property='planRepayDate'>
					<bean:define id="planRepayDate" name='row' property='planRepayDate' />
						<%request.setAttribute("planRepayDate",planRepayDate);%>
				</logic:notEmpty>
				<logic:empty name='row' property='planRepayDate'>
						<%request.setAttribute("planRepayDate",new java.util.Date(1900,1,1));%>
				</logic:empty>
				<logic:notEmpty name='row' property='repayDate'>
					<bean:define id="repayDate" name='row' property='repayDate' />
						<%request.setAttribute("repayDate",repayDate);%>
				</logic:notEmpty>
				<logic:empty name='row' property='repayDate'>
						<%request.setAttribute("repayDate",new java.util.Date(1900,1,1));%>
				</logic:empty>
				<logic:notEmpty name='row' property='capitalAmount'>
					<bean:define id="capitalAmount" name='row' property='capitalAmount'
						type="java.math.BigDecimal" />
						<%request.setAttribute("capitalAmount",capitalAmount);%>
				</logic:notEmpty>
				<% java.util.Date repayDate = (java.util.Date)request.getAttribute("repayDate");
				   java.util.Date planRepayDate = (java.util.Date)request.getAttribute("planRepayDate");
				   java.math.BigDecimal capitalAmount = (java.math.BigDecimal)request.getAttribute("capitalAmount");
				   java.lang.String dateType = new java.lang.String();
				   if(null == capitalAmount)
				   {
				   	 capitalAmount = new java.math.BigDecimal(0);
				   }
					if(repayDate.equals(planRepayDate))
					{
						dateType = "正常";
					}	
					if(repayDate.before(planRepayDate))
					{
						dateType = "提前";
					}
					if(repayDate.after(planRepayDate))
					{
						dateType = "延後";
					}
					if(1 == capitalAmount.compareTo(new java.math.BigDecimal(0)))
					{
						dateType = dateType + "還款";
					}
					else
					{
						dateType = dateType + "付息";
					}
					request.setAttribute("DateType",dateType);
				%>
				<%=request.getAttribute("DateType")%>
			</display:column>
			<display:column title="償還金額">
				<logic:notEmpty name='row' property='capitalAmount'>
					<bean:define id="capitalAmount" name='row' property='capitalAmount'
						type="java.math.BigDecimal" />
						<%request.setAttribute("capitalAmount",capitalAmount);%>
						<p align="right"><%=new gov.dnt.tame.common.SupportForm().getAmountDecimal(capitalAmount)%></p>
				</logic:notEmpty>
				<logic:empty name='row' property='capitalAmount'>
					<%="<P align=right>0</P>"%>
					<%request.setAttribute("capitalAmount",new BigDecimal(0));%>
				</logic:empty>
			</display:column>
			<display:column title="償還利息">
				<logic:notEmpty name='row' property='interestAmount'>	
					<bean:define id="interestAmount" name='row' property='interestAmount'
							type="java.math.BigDecimal" />
							<%request.setAttribute("interestAmount",interestAmount);%>
							<p align="right"><%=new gov.dnt.tame.common.SupportForm().getAmountDecimal(interestAmount.setScale(0,5))%></p>
				</logic:notEmpty>
				<logic:empty name='row' property='interestAmount'>
					<%="<P align=right>0</P>"%>
					<%request.setAttribute("interestAmount",new BigDecimal(0));%>
				</logic:empty>
			</display:column>
			<display:column title="本息合計">
				<p align="right"><%=new gov.dnt.tame.common.SupportForm().getAmountDecimal(((java.math.BigDecimal)request.getAttribute("capitalAmount")).add((java.math.BigDecimal)(request.getAttribute("interestAmount"))))%></p>
			</display:column>
		</display:table>
		</td>
	</tr>	
</talbe>
