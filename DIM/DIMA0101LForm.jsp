<!-- DIMA0101LForm.jsp
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

<table class='table_1' width='100%'>
	<tr>
		<td>
			<display:table class="table_list" name="collection" id="row">
				<display:column title="年度">
				<bean:define id="id" name="row" property="id" type="java.lang.Integer"/>
				<bean:define id="qrycontractyear" name="Dima0101Form" property="qrycontractyear" type="java.lang.String"/>
				<bean:define id="qryBankId" name="Dima0101Form" property="qryBankId" type="java.lang.Integer"/>
				<%
						java.util.Map paramMap = new java.util.HashMap();
							paramMap.put("id",id);
							paramMap.put("qrycontractyear",qrycontractyear);
							paramMap.put("qryBankId",qryBankId);
						pageContext.setAttribute("paramMap", paramMap);
				%>		  
					<html:link action='/DIMA0101MLOAD' name='paramMap'>
						<bean:write name='row' property='contractYear'/>
					</html:link>   	
				</display:column>
				<display:column title="銀行編號">
					<html:link action='/DIMA0101MLOAD' name='paramMap'>
						<logic:notEmpty name="row" property="bank">	
							<bean:define id="bank" name="row" property="bank" type="tw.gov.nta.sql.debt.BankRef"/>
							<logic:notEmpty name="bank" property='bankCode'>	
									<bean:write name='bank' property='bankCode'/>	
							</logic:notEmpty>		
						</logic:notEmpty>		
					</html:link>   	
				</display:column>
				<display:column title="銀行名稱">
				<html:link action='/DIMA0101MLOAD' name='paramMap'>
						<logic:notEmpty name="row" property="bank">
							<bean:define id="bank" name="row" property="bank" type="tw.gov.nta.sql.debt.BankRef"/>	
							<bean:write name='bank' property='bankName'/>
						</logic:notEmpty>	
					</html:link>   	
				</display:column>
				<display:column title="借款總額">
					<html:link action='/DIMA0101MLOAD' name='paramMap'>
						<p align="right"><bean:write name='row' property='contractAmount' format='#,###'/></p>
					</html:link>   	
				</display:column>
				<display:column title="目前己借額度">
					<html:link action='/DIMA0101MLOAD' name='paramMap'>
						<p align="right"><bean:write name='row' property='borrowAmount' format='#,###'/></p>
					</html:link> 
				</display:column>
				<display:column title="目前可借額度">
					<html:link action='/DIMA0101MLOAD' name='paramMap'>
							<bean:define id="contractAmount" name="row" property="contractAmount" type="java.math.BigDecimal"/>
							<bean:define id="borrowAmount" name="row" property="borrowAmount" type="java.math.BigDecimal"/>
							<bean:define id="contractYear" name='row' property='contractYear' type="java.lang.String"/>
							<p align="right">
							<% 
								if (Integer.parseInt(contractYear)< new java.util.Date().getYear()-11 )
									out.println(0);
								else
									out.println(new java.text.DecimalFormat("#,###").format((contractAmount.subtract(borrowAmount).doubleValue()< 0)? new java.math.BigDecimal("0") :contractAmount.subtract(borrowAmount)));
							%>
							</p>
					</html:link>   	
				</display:column>
			</display:table>
		</td>
	</tr>
</table>

