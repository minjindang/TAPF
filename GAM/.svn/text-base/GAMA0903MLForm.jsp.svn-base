<!-- GAMA0903MLForm.jsp
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
			<display:table class="table_list" name="caplist" id="row">
				<display:column title="還本付息日">
				<input type="hidden" name="capindex" value="<%=row_rowNum%>" />
				<logic:notEmpty name='Cima0101Form' property='id'>
					<bean:define id="id" name="Cima0101Form" property="id" type="java.lang.Integer"/>
					<%request.setAttribute("id",id);%>	
				</logic:notEmpty>
				<logic:notEmpty name='Cima0101Form' property='debtId'>
					<bean:define id="debtId" name="Cima0101Form" property="debtId" type="java.lang.Integer"/>
					<%request.setAttribute("debtId",debtId);%>	
				</logic:notEmpty>	
				<logic:notEmpty name='Cima0101Form' property='issueDate'>
					<bean:define id='issueDate' name='Cima0101Form' property='issueDate' type="java.util.Date"/>
					<%request.setAttribute("issueDate",issueDate);%>	
				</logic:notEmpty>	
				<logic:notEmpty name='Cima0101Form' property='dueDate'>
					<bean:define id='dueDate' name='Cima0101Form' property='dueDate' type="java.util.Date"/>	
					<%request.setAttribute("dueDate",dueDate);%>	
				</logic:notEmpty>	
				<logic:notEmpty name='Cima0101Form' property='bankId'>
					<bean:define id='bankId' name='Cima0101Form' property='bankId' type="java.lang.Integer"/>
					<%request.setAttribute("bankId",bankId);%>	
				</logic:notEmpty>	
				<logic:notEmpty name='row' property='repayDate'>
					<bean:define id="repayDate" name='row' property='repayDate' type="java.util.Date"/>
						<%request.setAttribute("repayDate",repayDate);%>	
				</logic:notEmpty>
				<logic:empty name='row' property='repayDate'>
						<%request.setAttribute("repayDate","000/00/00");%>	
				</logic:empty>	
				
				<logic:notEmpty name='row' property='capitalAmount'>
					<bean:define id="capitalAmount" name='row' property='capitalAmount' type="java.math.BigDecimal"/>
						<%request.setAttribute("capitalAmountFuture",capitalAmount.setScale(4,5));%>	
				</logic:notEmpty>
				<logic:empty name='row' property='capitalAmount'>
						<%request.setAttribute("capitalAmountFuture",new java.math.BigDecimal(0));%>	
				</logic:empty>

				<logic:notEmpty name='row' property='id'>
					<bean:define id="id" name='row' property='id' type="java.lang.Integer"/>
							<% 
								tw.gov.nta.debt.common.PayManager myPay = new tw.gov.nta.debt.common.PayManager();
								java.math.BigDecimal capitalAmountDPT = myPay.getCapitalByPlan(id.intValue());
								if(null == capitalAmountDPT )
								{
									capitalAmountDPT = new java.math.BigDecimal(0);
								}
								request.setAttribute("capitalAmountDPT",capitalAmountDPT.setScale(4,5));
							%>	
				</logic:notEmpty>
				<logic:empty name='row' property='id'>
						<%request.setAttribute("capitalAmountDPT",new java.math.BigDecimal(0));%>
				</logic:empty>
				
				<logic:notEmpty name='row' property='id'>
						<bean:define id="id" name='row' property='id' type="java.lang.Integer"/>
							<% 
								tw.gov.nta.debt.common.PayManager myPay = new tw.gov.nta.debt.common.PayManager();
								java.math.BigDecimal interestAmountDPT = myPay.getInterestByPlan(id.intValue());
								if(null == interestAmountDPT )
								{
									interestAmountDPT = new java.math.BigDecimal(0);
								}	
								java.util.Date trueDate = myPay.getMaxDateByPlan(id);
								String showDate = new String();
								if(null != DateUtil.date2ROCStr(trueDate))
								{
									showDate = DateUtil.date2ROCStr(trueDate);
								}
								request.setAttribute("showDate",showDate);
								request.setAttribute("interestAmountDPT",interestAmountDPT.setScale(4,5));
							%>
				</logic:notEmpty>
				<logic:empty name='row' property='id'>
						<%request.setAttribute("interestAmountDPT",new java.math.BigDecimal(0));%>
				</logic:empty>
				
				<logic:notEmpty name='row' property='id'>
						<% 
							java.math.BigDecimal capital = ((java.math.BigDecimal)request.getAttribute("capitalAmountDPT"));
							java.math.BigDecimal interest = ((java.math.BigDecimal)request.getAttribute("interestAmountDPT"));
							java.math.BigDecimal total = capital.add(interest);
							if(null == total)
							{
								request.setAttribute("totalAmount",new java.math.BigDecimal(0)); 
							}
							else
							{
								request.setAttribute("totalAmount",total); 
							}
						%>		
				</logic:notEmpty>
				<logic:empty name='row' property='id'>
						<%request.setAttribute("totalAmount",new java.math.BigDecimal(0));%>
				</logic:empty>			
				<%		
						
						java.util.Map paramMap = new java.util.HashMap();
							if(null != (request.getAttribute("id")))
							{
								paramMap.put("id",request.getAttribute("id"));
							}
							if(null != row_rowNum)
							{
								paramMap.put("nowindex",row_rowNum);
							}
							if(null != request.getAttribute("debtId"))
							{
								paramMap.put("debtId",request.getAttribute("debtId"));
							}
							if(null != request.getAttribute("bankId"))
							{
								paramMap.put("bankId",request.getAttribute("bankId"));
							}
							if(null != (java.util.Date)(request.getAttribute("issueDate")))
							{
								paramMap.put("date(issueDate)",DateUtil.date2ROCStr((java.util.Date)(request.getAttribute("issueDate"))));
							}
							if(null != (java.util.Date)(request.getAttribute("dueDate")))
							{
								paramMap.put("date(dueDate)",DateUtil.date2ROCStr((java.util.Date)(request.getAttribute("dueDate"))));
							}
							if(null != (java.util.Date)(request.getAttribute("repayDate")))
							{ 
								paramMap.put("date(repayDate)",DateUtil.date2ROCStr(((java.util.Date)(request.getAttribute("repayDate")))));
							}
							if(null != (java.math.BigDecimal)(request.getAttribute("capitalAmountFuture")))
							{ 
								paramMap.put("capitalAmount",(java.math.BigDecimal)(request.getAttribute("capitalAmountFuture")));
							}
							if(null != (java.math.BigDecimal)(request.getAttribute("capitalAmountDPT")))
							{ 
								paramMap.put("capitalAmountDPT",(java.math.BigDecimal)(request.getAttribute("capitalAmountDPT")));
							}
							if(null != (java.math.BigDecimal)(request.getAttribute("interestAmountDPT")))
							{
								paramMap.put("interestAmountDPT",(java.math.BigDecimal)(request.getAttribute("interestAmountDPT")));
							}
							if(null != (java.math.BigDecimal)(request.getAttribute("totalAmount")))
							{ 
								paramMap.put("totalAmount",(java.math.BigDecimal)(request.getAttribute("totalAmount")));
							}
							if(null != (java.lang.String)(request.getAttribute("showDate")))
							{ 
								paramMap.put("showDate",(java.lang.String)(request.getAttribute("showDate")));
							}
						pageContext.setAttribute("paramMap", paramMap);
				%>  
					<html:link action='/GAMA0914' name='paramMap'>
						<%=DateUtil.date2ROCStr((java.util.Date)(request.getAttribute("repayDate")))%>	
					</html:link>
				</display:column>
				<display:column title="類別">
					<%
						java.math.BigDecimal capitalAmount = (java.math.BigDecimal)request.getAttribute("capitalAmountFuture");
						java.lang.String kind = new String();
						if(1 == capitalAmount.compareTo(new java.math.BigDecimal(0)))
						{
							kind = "還本付息" ;
						}
						else
						{
							kind = "付息" ;
						}
						request.setAttribute("kind",kind);
					%>
					<%=request.getAttribute("kind")%>
				</display:column>
				<display:column title="預計還本金額">
					<html:link action='/GAMA0914' name='paramMap'>
						<p align="right"><%= new java.text.DecimalFormat("#,##0").format(request.getAttribute("capitalAmountFuture"))%></p>
						<html:hidden name='Cima0101Form' property='sumCapitalAmountFuture' value="<%=((java.math.BigDecimal)(request.getAttribute("capitalAmountFuture"))).toString()%>"/> 
					</html:link>	
				</display:column>
				<display:column title="實際日期">
					<logic:notEmpty name='row' property='id'>
						<%=request.getAttribute("showDate")%>
					</logic:notEmpty>	
				</display:column>
				<display:column title="實際還本金額">
					<html:link action='/GAMA0914' name='paramMap'>
						<p align="right"><%= new java.text.DecimalFormat("#,##0").format(request.getAttribute("capitalAmountDPT"))%></p>
					</html:link>	
				</display:column>
				<display:column title="實際付息金額">
					<html:link action='/GAMA0914' name='paramMap'>
						<p align="right"><%= new java.text.DecimalFormat("#,##0").format(request.getAttribute("interestAmountDPT"))%></p>
					</html:link>	
				</display:column>
				<display:column title="實付本息合計">	
					<html:link action='/GAMA0914' name='paramMap'>
						<p align="right"><%= new java.text.DecimalFormat("#,##0").format(request.getAttribute("totalAmount"))%></p>	
					</html:link>	
				</display:column>
				<input type="hidden" name="capitalAmountDPT" value="<%=request.getAttribute("capitalAmountDPT")%>" />
				<input type="hidden" name="interestAmountDPT" value="<%=request.getAttribute("interestAmountDPT")%>" />
				<input type="hidden" name="totalAmount" value="<%=request.getAttribute("totalAmount")%>" />
			</display:table>
		</td>
	</tr>
</table>

