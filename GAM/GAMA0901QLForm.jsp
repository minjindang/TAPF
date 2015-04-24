<!-- GAMA0901QLForm.jsp
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
			<display:table class="table_list" name="collection" id="row">
				<display:column title="年度">
					<bean:define id="id" name="row" property="id" type="java.lang.Integer"/>
					<bean:define id="accountYear" name="row" property="accountYear" type="java.lang.String"/>
					<bean:define id="serialNo" name="row" property="serialNo" type="java.lang.String"/>
					<bean:define id="issueSerial" name="row" property="issueSerial" type="java.lang.String"/>
					<bean:define id="debtName" name="row" property="debtName" type="java.lang.String"/>
					<bean:define id="budgetCode" name="row" property="budgetCode" type="java.lang.Integer"/>
					<bean:define id="debtCode" name="row" property="debtCode" type="java.lang.Integer"/>
					<bean:define id="bondType" name="row" property="bondType" type="java.lang.String"/>
					<%
							java.util.Map paramMap = new java.util.HashMap();
								paramMap.put("id",id);
								paramMap.put("qryaccountYear",accountYear);
								paramMap.put("qrydebtName",java.net.URLEncoder.encode(debtName));
								paramMap.put("qryserialNo",serialNo);
								paramMap.put("qryissueSerial",issueSerial);
								paramMap.put("budgetCode",budgetCode);
								paramMap.put("debtCode",debtCode);
								paramMap.put("bondType",bondType);
							pageContext.setAttribute("paramMap", paramMap);
					%>  
					<html:link action='/GAMA0902' name='paramMap'>
						<bean:write name='row' property='accountYear'/>
					</html:link>  
				</display:column>
				<display:column title="期次">
					<html:link action='/GAMA0902' name='paramMap'>		
						<bean:write name='row' property='serialNo'/>
					</html:link>  	
				</display:column>
				<display:column title="期別">
					<html:link action='/GAMA0902' name='paramMap'>
						<bean:write name='row' property='issueSerial'/>
					</html:link>  	
				</display:column>
				<display:column title="名稱">
					<html:link action='/GAMA0902' name='paramMap'>
						<bean:write name='row' property='debtName'/>
					</html:link>  	
				</display:column>
				<display:column title="借款期間">
					<html:link action='/GAMA0902' name='paramMap'>
					<logic:notEmpty name='row' property='issueDate'>
						<bean:define id="issueDate" name="row" property="issueDate" type="java.util.Date"/>
							<%=DateUtil.date2ROCStr(issueDate)%>~
					</logic:notEmpty>
					<logic:empty name='row' property='issueDate'>
							<%="0000000"%>~
					</logic:empty>
					<logic:notEmpty name='row' property='dueDate'>
						<bean:define id="dueDate" name="row" property="dueDate" type="java.util.Date"/>
							<%=DateUtil.date2ROCStr(dueDate)%>
					</logic:notEmpty>
					<logic:empty name='row' property='dueDate'>
							<%="0000000"%>
					</logic:empty>
					</html:link>  
				</display:column>
			</display:table>
		</td>
	</tr>
</table>

