<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>
<%@page import="tw.gov.nta.debt.common.IssueManager"%>
<%@page import="tw.gov.nta.sql.debt.dao.CentralBankRefDAO"%>
<%@page import="tw.gov.nta.system.common.CentralBankManager"%>
<table class='table_1' width='100%'>
	<tr>
		<td>
			<display:table class="table_list" name="collection" id="row">
				<display:column title="發行期別">
					<bean:define id="id" name="row" property="id" type="java.lang.Integer"/>
					<%
						String myLink = "BIMA0506?";

						myLink +=  "&id=" + id ; 
					%>
					<A href="<%=myLink%>">
						<bean:write name='row' property='issueSerial'/>
					</A>
				</display:column>
				<display:column title="國庫券名稱">
					<bean:define id='issueId' name='row' property='issueId' type="java.lang.Integer"/>
					<%= new IssueManager().getBean(issueId.intValue()).getDebtName() %>
				</display:column>
				<display:column title="出售單位代號">
					<bean:define id='unitCode' name='row' property='unitCode' type="java.lang.Integer"/>
					<%= new CentralBankManager().get(unitCode.intValue()).getBankName() %>
				</display:column>
			</display:table>
		</td>
	</tr>
</table>