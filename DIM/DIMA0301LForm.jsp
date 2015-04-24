<!-- DIMA0301LForm.jsp
程式目的：DIMA03
程式代號：DIMA03
程式日期：0950224
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
					<bean:define id="qryAccountYear" name="Dima0301Form" property="qryAccountYear" type="java.lang.String"/>
					<bean:define id="qrySerialNo" name="Dima0301Form" property="qrySerialNo" type="java.lang.String"/>
					<bean:define id="qryId" name="Dima0301Form" property="qryId" type="java.lang.Integer"/>
					<%
						java.util.Map paramMap = new java.util.HashMap();
							paramMap.put("id",id);
							paramMap.put("qryAccountYear",qryAccountYear);
							paramMap.put("qryId",qryId);
							paramMap.put("qrySerialNo",qrySerialNo);
						pageContext.setAttribute("paramMap", paramMap);
					%>  
					<html:link action='/DIMA0302' name='paramMap'>
						<bean:write name='row' property='accountYear'/>
					</html:link>   	
				</display:column>
				<display:column title="期次">
					<bean:write name='row' property='serialNo'/>
				</display:column>
				<display:column title="期別">
					<bean:write name='row' property='issueSerial'/>
				</display:column>
				<display:column title="名稱">
					<bean:write name='row' property='debtName'/>
				</display:column>
				<display:column title="借款期間">
					<logic:present name="row" property="issueDate">
						<bean:define id="issueDate" name="row" property="issueDate" type="java.util.Date"/>
						<%=gov.dnt.tame.util.DateUtil.date2ROCStr(issueDate,"yyy/mm/dd")%>	~
					</logic:present>
					<logic:present name="row" property="dueDate">
						<bean:define id="dueDate" name="row" property="dueDate" type="java.util.Date"/>
						<%=gov.dnt.tame.util.DateUtil.date2ROCStr(dueDate,"yyy/mm/dd")%>
					</logic:present>
				</display:column>
			</display:table>
		</td>
	</tr>
</table>

