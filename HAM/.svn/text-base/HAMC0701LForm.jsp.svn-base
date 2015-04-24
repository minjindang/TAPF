<!--
程式目的：HAMB07文字
程式代號：HAMB07
程式日期：0950223
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
<%@ page import="gov.dnt.tame.util.DateUtil" %>
<table class='table_1' width='100%'>
	<tr>
		<td>
			<display:table class="table_list" name="collection" id="row">
				<display:column title="記帳年度">
					<bean:write name='row' property='allYear'/>
				</display:column>
				<display:column title="撥款月份">
					<bean:write name='row' property='allMonth'/>
				</display:column>
				<display:column title="受分配單位">
					<bean:define id="qryallYear" name="Hamb0701Form" property="qryallYear" type="java.lang.String"/>
					<bean:define id="qryallMonth" name="Hamb0701Form" property="qryallMonth" type="java.lang.String"/>
					<bean:define id="qryunitName" name="Hamb0701Form" property="qryunitName" type="java.lang.String"/>
					<bean:define id="unitInfo" name="row" property="unitInfo" type="tw.gov.nta.sql.UnitInfoMain"/>
					<bean:define id="unitName" name="unitInfo" property="unitName" type="java.lang.String"/>
					<bean:define id="qryunitId" name="Hamb0701Form" property="qryunitId" type="java.lang.String"/>
					<bean:define id="id" name="row" property="id" type="java.lang.Integer"/>
				<%
						java.util.Map paramMap = new java.util.HashMap();
							paramMap.put("id",id);
							paramMap.put("qryallYear",qryallYear);
							paramMap.put("qryallMonth",qryallMonth);
							paramMap.put("qryunitName",java.net.URLEncoder.encode(qryunitName));
							paramMap.put("unitName",java.net.URLEncoder.encode(unitName));
							paramMap.put("qryunitId",qryunitId);
						pageContext.setAttribute("paramMap", paramMap);
				%>  
				<html:link action='/HAMC0703' name='paramMap'>
					<bean:write name='unitInfo' property='unitName'/>
				</html:link>	
				</display:column>
				
				<display:column title="寄送日期">
					<logic:notEmpty name="row" property="sendDate">
						<bean:define id="sendDate" name="row" property="sendDate" type="java.util.Date"/>
							<%=DateUtil.toDateTimeRoc(sendDate)%>
					</logic:notEmpty>
					<logic:empty name="row" property="sendDate">
							<%//"0000000 00:00:00"%>
					</logic:empty>	
				</display:column>
				<display:column title="回條接收日期">
					<logic:notEmpty name="row" property="recvDate">
						<bean:define id="recvDate" name="row" property="recvDate" type="java.util.Date"/>
							<%=DateUtil.toDateTimeRoc(recvDate)%>
					</logic:notEmpty>
					<logic:empty name="row" property="recvDate">
							<%//"0000000 00:00:00"%>
					</logic:empty>
				</display:column>
			</display:table>	
		</td>
	</tr>
</table>
