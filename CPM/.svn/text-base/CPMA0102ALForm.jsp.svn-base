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
<%@ page import="tw.gov.nta.debt.common.PayManager"%>
<%@ page import="tw.gov.nta.sql.debt.DebtPlanDet"%>
<table class='table_1' width='100%'>
	<tr>
		<td>
			<display:table class="table_list" name="collection" id="row">
			<display:column title="償還否">
				<bean:define id="id" name='row' property='id' type="java.lang.Integer" />
				<%
					DebtPlanDet debtPlanDet = (DebtPlanDet)row;
					tw.gov.nta.debt.common.PayManager payManager = new tw.gov.nta.debt.common.PayManager();
					BigDecimal issueAmount = debtPlanDet.getDebt().getIssueAmount();
					BigDecimal payAmount = payManager.getCapitalByDebt(debtPlanDet.getDebt().getId().intValue());
					if(issueAmount.compareTo(payAmount)==0){
						out.println("以償還");
					}
					else{
						out.println("<input type='hidden' name='paymentId' value='"+id+"'/>");
						out.println("<input type='checkbox' name='ischeck' value='"+row_rowNum+"'/>");
					}
				%>
				
				
			</display:column>
			<display:column title="銀行代號">
				<logic:notEmpty name='row' property='debt.id'>
					<bean:define id="debtId" name='row' property='debt.id'
							type="java.lang.Integer" />
					<input type="hidden" name="debtMainId" value="<%=debtId%>"/>		
				</logic:notEmpty>
				<logic:notEmpty name='row' property='debt.bank'>			
					<logic:notEmpty name='row' property='debt.bank.bankCode'>
						<bean:define id="bankCode" name='row' property='debt.bank.bankCode'
							type="java.lang.String" />
						<%=bankCode%>
					</logic:notEmpty>
					<logic:empty name='row' property='debt.bank.bankCode'>
						<%=""%>
					</logic:empty>
				</logic:notEmpty>
			</display:column>
			<display:column title="銀行名稱">
				<logic:notEmpty name='row' property='debt.bank'>			
					<logic:notEmpty name='row' property='debt.bank.bankName'>
						<bean:define id="bankName" name='row' property='debt.bank.bankName'
							type="java.lang.String" />
						<%=bankName%>
					</logic:notEmpty>
					<logic:empty name='row' property='debt.bank.bankName'>
						<%=""%>
					</logic:empty>
				</logic:notEmpty>	
			</display:column>
			<display:column title="借款總額">
				<logic:notEmpty name='row' property='debt.issueAmount'>
					<bean:define id="issueAmount" name='row' property='debt.issueAmount'
						type="java.math.BigDecimal" />
					<p align="right"><%=new java.text.DecimalFormat("#,##0").format(issueAmount)%></p>
				</logic:notEmpty>
				<logic:empty name='row' property='debt.issueAmount'>
					<P align=right>0</P>
				</logic:empty>
			</display:column>
			<display:column title="計畫日期">
				<logic:notEmpty name='row' property='repayDate'>
					<bean:define id="repayDate" name='row' property='repayDate'
						type="java.util.Date" />
					<html:hidden name='Cpma0101Form' property='date(planRepayDate)' value="<%=DateUtil.date2Str(repayDate)%>" />	
					<%=DateUtil.date2ROCStr(repayDate)%>
				</logic:notEmpty>
				<logic:empty name='row' property='repayDate'>
					<%="000/00/00"%>
				</logic:empty>
			</display:column>
			<display:column title="利息起算日期">
				<logic:notEmpty name='row' property='debt.interestDate'>	
					<bean:define id="interestDate" name='row' property='debt.interestDate' type="java.util.Date" />	
					<%request.setAttribute("interestDate",interestDate);%>
				</logic:notEmpty>
				<logic:empty name='row' property='debt.interestDate'>
					<logic:notEmpty name='row' property='debt.issue.issueDate'>
						<bean:define id="interestDate" name='row' property='debt.issue.issueDate' type="java.util.Date" />	
						<%request.setAttribute("interestDate",interestDate);%>
					</logic:notEmpty>	
				</logic:empty>
				<%
					java.util.Date startDate = (java.util.Date)(request.getAttribute("interestDate"));
					request.setAttribute("startDate",startDate);
				%>
				<%=DateUtil.date2ROCStr(startDate)%>
				<html:hidden name="Cpma0101Form" property="interestDate" value="<%=DateUtil.date2Str((java.util.Date)(request.getAttribute("startDate")),"yyyy/MM/dd")%>" />
			</display:column>
			<display:column title="還款日期">
			<html:hidden name='Cpma0101Form' property='date(qryrepayDate)' />
				<logic:notEmpty name='Cpma0101Form' property='qryrepayDate'>
					<bean:define id="qryrepayDate" name='Cpma0101Form' property='qryrepayDate' type="java.util.Date" />
					<%=DateUtil.date2ROCStr(qryrepayDate)%>
					<%request.setAttribute("qryrepayDate",qryrepayDate);%>
				</logic:notEmpty>
				<logic:empty name='Cpma0101Form' property='qryrepayDate'>
					<%="000/00/00"%>
				</logic:empty>
			</display:column>			
			<display:column title="天期">
				<bean:define id="issueDate" name='row' property='debt.issue.issueDate' type="java.util.Date" />	
				<%
					java.util.Date startDate = (java.util.Date)(request.getAttribute("interestDate"));
					java.util.Date endDate = (java.util.Date)(request.getAttribute("qryrepayDate"));
					Integer days = new Integer(0);
					if(null == startDate)
					{
						startDate = issueDate;
					}
					if(null == endDate)
					{
						endDate = issueDate;
					}
					days = gov.dnt.tame.util.DateUtil.getDays(startDate,endDate);
				%>
				<%=days%>
			<input type="hidden" name="date(endDate)" value="<%=DateUtil.date2Str(endDate)%>" />	
			<input type="hidden" name="date(startDate)" value="<%=DateUtil.date2Str(startDate)%>" />		
			<input type="hidden" name="days" value="<%=days%>" />	
			</display:column>
			<display:column title="利率">
				<bean:define id="Debtid" name='row' property='debt.id' type="java.lang.Integer" />
				<bean:define id="issueDate" name='row' property='debt.issue.issueDate' type="java.util.Date" />	
				<%
					java.util.Date startDate = (java.util.Date)(request.getAttribute("interestDate"));
					tw.gov.nta.debt.common.RateManager myRate = new tw.gov.nta.debt.common.RateManager();
					if(null == startDate)
					{
						startDate = issueDate;
					}
					BigDecimal	debtRate = myRate.getEffectiveRate(Debtid.intValue(),startDate);
					request.setAttribute("debtRate",debtRate);
				%>
				<%=debtRate.setScale(3,5)%>
			</display:column>
			<display:column title="累計償本金額">
				<bean:define id="id" name='row' property='debt.id'
					type="java.lang.Integer" />	
				 <%
					 	tw.gov.nta.debt.common.PayManager amount = new tw.gov.nta.debt.common.PayManager();
				 		BigDecimal capitalAmountPay = new BigDecimal(0);
				 		capitalAmountPay = amount.getCapitalByDebt(id.intValue()).setScale(0,5);
				 		if (null != capitalAmountPay )
				 		{
				 			request.setAttribute("capitalAmountPay",capitalAmountPay);
				 		}
				 		else
				 		{
				 			request.setAttribute("capitalAmountPay",new BigDecimal(0));
				 		}	
				 %>
				<p align="right"><%=new gov.dnt.tame.common.SupportForm().getAmountDecimal((java.math.BigDecimal)request.getAttribute("capitalAmountPay"))%></p>
			</display:column>
			<display:column title="實際金額">
				
				<logic:notEmpty name='row' property='capitalAmount'>
					<bean:define id="capitalAmount" name='row' property='capitalAmount'
						type="java.math.BigDecimal" />
					<bean:define id="id" name='row' property='id' type="java.lang.Integer" />
					<% 
					String thisPay = "";
					if(request.getAttribute("thisPay") != null)
						thisPay = request.getAttribute("thisPay").toString();
					if(thisPay.equals("") || !thisPay.equals("T")){
						DebtPlanDet debtPlanDet = (DebtPlanDet)row;
						tw.gov.nta.debt.common.PayManager payManager = new tw.gov.nta.debt.common.PayManager();
						request.setAttribute("capitalAmountDebtPlan",capitalAmount);
						//BigDecimal value1 = (java.math.BigDecimal)(request.getAttribute("capitalAmountDebtPlan"));
						if(capitalAmount.compareTo(new BigDecimal(0))==0)
							request.setAttribute("capitalAmountGuess",new BigDecimal(0));
						else{
							BigDecimal value1 = capitalAmount;
							BigDecimal value2 = payManager.getCapitalByDebt(debtPlanDet.getDebt().getId().intValue());
							request.setAttribute("capitalAmountGuess",value1.subtract(value2).setScale(0,5));
						}
					}
					else{
						request.setAttribute("capitalAmountGuess",capitalAmount);
					}
					%>
				</logic:notEmpty>
				<logic:empty name='row' property='capitalAmount'>
					<%request.setAttribute("capitalAmountGuess",new BigDecimal(0));%>
				</logic:empty>
			<html:text name='Cpma0101Form' property='capitalAmountPay'
					style="text-align:right;border-top:0 px;border-bottom:0 px;border-left:0 px;border-right:0 px" size="10" maxlength="20"  value="<%=((java.math.BigDecimal)(request.getAttribute("capitalAmountGuess"))).toString()%>" readonly="false" onblur="changeInterestAmount(this.form)"/>
			</display:column>
			<display:column title="實際利息">
			<logic:notEmpty name='row' property='debt'>
						<bean:define id="Debtid" name='row' property='debt.id'
							type="java.lang.Integer" />
						<bean:define id="qryrepayDate" name='Cpma0101Form' property='qryrepayDate'
							type="java.util.Date" />
						<bean:define id="issueDate" name='row' property='debt.issue.issueDate' type="java.util.Date" />	
						<bean:define id="issueAmount" name='row' property='debt.issueAmount' type="java.math.BigDecimal" />		
						<bean:define id="capitalAmount" name='row' property='capitalAmount'type="java.math.BigDecimal" />
						<%
							String thisPay = "";
							if(request.getAttribute("thisPay") != null)
								thisPay = request.getAttribute("thisPay").toString();
							tw.gov.nta.debt.common.InterestCounter myCounter = new tw.gov.nta.debt.common.InterestCounter();
							tw.gov.nta.debt.common.PayManager myPayManager = new tw.gov.nta.debt.common.PayManager();
							tw.gov.nta.debt.common.RateManager myRate = new tw.gov.nta.debt.common.RateManager();
							BigDecimal capitalAmountPay = (java.math.BigDecimal)request.getAttribute("capitalAmountPay");
							BigDecimal countAmount = new BigDecimal(0);
							BigDecimal interestAmount = new BigDecimal(0);
							java.util.Date startDate = (java.util.Date)(request.getAttribute("interestDate"));
							if(thisPay.equals("") || !thisPay.equals("T")){
								if(null != issueAmount)
									countAmount = issueAmount.subtract(capitalAmountPay);
							}
							else 
								countAmount = capitalAmount;
							if(null == startDate)
								startDate = issueDate;
							try{
								interestAmount = myCounter.countInterest(startDate
										,qryrepayDate
										,myRate.getEffectiveRate(Debtid.intValue())
										,countAmount.doubleValue(),0) ;
							}
							catch(Exception e){}
							if(null != interestAmount)	{	
								request.setAttribute("interestAmount",interestAmount.setScale(0,BigDecimal.ROUND_HALF_DOWN));
							}
							else{
								request.setAttribute("interestAmount",new BigDecimal(0));
							}	
						%>	
					</logic:notEmpty>
					<logic:empty name='row' property='debt'>
						<%request.setAttribute("interestAmount",new BigDecimal(0));%>
					</logic:empty>			
			<html:text name='Cpma0101Form' property='interestAmountPay'
					style="text-align:right;border-top:0 px;border-bottom:0 px;border-left:0 px;border-right:0 px" size="10" maxlength="20" onblur="changeValue()" value="<%=((java.math.BigDecimal)(request.getAttribute("interestAmount"))).toString()%>" readonly="false"/>
			</display:column>
			<display:column title="實際本息合計">
				<html:text name='Cpma0101Form' property='bigDecimal(totalAmount)' style="text-align:right;border-top:0 px;border-bottom:0 px;border-left:0 px;border-right:0 px" readonly="false"/>
			</display:column>
		</display:table>
		</td>
	</tr>	
</table>
