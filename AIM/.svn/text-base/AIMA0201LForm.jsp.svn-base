<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<table class='table_1' width='100%'>
	<tr>
		<td>
			<display:table class="table_list" name="collection" id="row">
				<display:column title="公債代號">
					<bean:define id="issueMainId" name="row" property="id" type="java.lang.Integer"/>
					<%
						String	myLink	=	"AIMA0205?";
						myLink	+= "issueMainId=" + issueMainId;
					%>
					<A href="<%=myLink%>">
						<bean:write name='row' property='issueSerial'/>
					</A>&nbsp;
				</display:column>
				<display:column title="發行日期">
					<script>
						document.write( addDateMask( '<bean:write name='row' property='issueDate'/>' ) );
					</script>&nbsp;
				</display:column>
				<display:column title="公債名稱">
					<bean:write name='row' property='debtName'/>&nbsp;
				</display:column>
			</display:table>
		</td>
	</tr>
</table>
