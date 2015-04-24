<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>
<%@ page import="gov.dnt.tame.util.DateUtil" %>
<table class='table_1' width='100%'>
	<tr>
		<td>
			<display:table class="table_list" name="collection" id="row">
				<display:column title="公債代號">
				<bean:define id="issueMainId" name="row" property="id" type="java.lang.Integer"/>
				<%
					String	myLink	=	"AIMA0105?";
					myLink	+= "issueMainId=" + issueMainId;
				%>
				<A href="<%=myLink%>">
					<bean:write name='row' property='issueSerial'/>
				</A>
				</display:column>
				<display:column title="發行日期">
					<%
					tw.gov.nta.sql.debt.IssueMain tIssueMain = (tw.gov.nta.sql.debt.IssueMain)row;
					if(tIssueMain != null && tIssueMain.getIssueDate() != null)
						out.print(DateUtil.date2ROCStr(tIssueMain.getIssueDate(),"yyy/MM/dd"));
					%>
				</display:column>
				<display:column title="公債名稱">
					<bean:write name='row' property='debtName'/>
				</display:column>
			</display:table>
		</td>
	</tr>
</table>
