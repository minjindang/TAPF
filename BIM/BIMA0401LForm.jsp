<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<table class='table_1' width='100%'>
	<tr>
		<td>
			<display:table class="table_list" name="collection" id="row">
				<display:column title="�o��~��">
					<bean:define id="id" name="row" property="id" type="java.lang.Integer"/>
					<%
						String myLink = "BIMA0406?";

						myLink +=  "&id=" + id ; 
					%>
					<A href="<%=myLink%>">
						<bean:write name='row' property='accountYear'/>
					</A>
				</display:column>
				<display:column title="�R�^���O">
					<bean:write name='row' property='issueSerial'/>
				</display:column>
				<display:column title="��w��W��">
					<bean:write name='row' property='debtName'/>
				</display:column>
			</display:table>
		</td>
	</tr>
</table>