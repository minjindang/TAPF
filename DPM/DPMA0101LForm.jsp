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
<table class='table_1' width='100%'>
	<tr>
		<td>
			<display:table class="table_list" name="collection" id="row">
				<display:column title="年度">
					<bean:write name='row' property='accountYear'/>
				</display:column>
				<display:column title="期次">
					<bean:write name='row' property='serialNo'/>
				</display:column>
				<display:column title="期別">
					<bean:define id="id" name="row" property="id" type="java.lang.Integer"/>
					<%
						String myLink = "DPMA0108?";
						myLink +="&id=" + id;
					%>
					<A href="<%=myLink%>">
						<bean:write name='row' property='issueSerial'/>
					</A>
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