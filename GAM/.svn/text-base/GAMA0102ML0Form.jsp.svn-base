<!-- CIMA0101ML0Form.jsp
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
			<display:table class="table_list" name="ratelist" id="row">
				<display:column title="利率起算日">
				<input type="hidden" name="rateindex" value="<%=row_rowNum%>" />
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
				<logic:notEmpty name='row' property='effectiveDate'>
					<bean:define id="effectiveDate" name='row' property='effectiveDate' type="java.util.Date"/>
					<%request.setAttribute("effectiveDate",effectiveDate);%>	
				</logic:notEmpty>	
				<logic:notEmpty name='row' property='suspendDate'>
					<bean:define id="suspendDate" name='row' property='suspendDate' type="java.util.Date"/>
					<%request.setAttribute("suspendDate",suspendDate);%>		
				</logic:notEmpty>
				<logic:notEmpty name='row' property='debtRate'>
					<bean:define id="debtRate" name='row' property='debtRate' type="java.math.BigDecimal"/>
					<%request.setAttribute("debtRate",debtRate.setScale(4,5));%>			
				</logic:notEmpty>
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
							
							if(null != (java.util.Date)(request.getAttribute("effectiveDate")))
							{
								paramMap.put("date(effectiveDate)",DateUtil.date2ROCStr((java.util.Date)(request.getAttribute("effectiveDate"))));
							}

							if(null != (java.util.Date)(request.getAttribute("suspendDate")))
							{
								paramMap.put("date(suspendDate)",DateUtil.date2ROCStr((java.util.Date)(request.getAttribute("suspendDate"))));
							}

							if(null != (java.math.BigDecimal)(request.getAttribute("debtRate")))
							{ paramMap.put("debtRate",(java.math.BigDecimal)(request.getAttribute("debtRate")));}
							
							pageContext.setAttribute("paramMap", paramMap);
				%>  
					<html:link action='/GAMA0116' name='paramMap'>
						<logic:notEmpty name='row' property='effectiveDate'>
							<bean:define id="effectiveDate" name='row' property='effectiveDate' type="java.util.Date"/>
								<%=DateUtil.date2ROCStr(effectiveDate)%>	
						</logic:notEmpty>
						<logic:empty name='row' property='effectiveDate'>
							<%="000/00/00"%>
						</logic:empty>	
					</html:link>	
				</display:column>
				<display:column title="利率到期日">
					<html:link action='/GAMA0116' name='paramMap'>
						<logic:notEmpty name='row' property='suspendDate'>
							<bean:define id="suspendDate" name='row' property='suspendDate' type="java.util.Date"/>
								<%=DateUtil.date2ROCStr(suspendDate)%>	
						</logic:notEmpty>
						<logic:empty name='row' property='suspendDate'>
							<%="000/00/00"%>
						</logic:empty>	
					</html:link>
				</display:column>
				<display:column title="利率">
					<html:link action='/GAMA0116' name='paramMap'>
						<logic:notEmpty name='row' property='debtRate'>
							<bean:define id="debtRate" name='row' property='debtRate' type="java.math.BigDecimal"/>
								<p align="right"><%= debtRate.setScale(3,5)%></p>	
						</logic:notEmpty>
						<logic:empty name='row' property='debtRate'>
							<p align="right"><%="0.000"%></p>
						</logic:empty>	
					</html:link>	
				</display:column>	
			</display:table>
		</td>
	</tr>
</table>

