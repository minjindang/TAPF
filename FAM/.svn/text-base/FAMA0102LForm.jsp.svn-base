<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<table class='table_1' width='100%'>
	<tr>
		<td>
			<display:table class="table_list" name="collection" id="row">
				<display:column title="代碼">
					<bean:define id="id" name="row" property="id" type="java.lang.Integer"/>
					<bean:define id="qryKindNo" name="Fama0101Form" property="qryKindNo" type="java.lang.String"/>
					<bean:define id="qryKindName" name="Fama0101Form" property="qryKindName" type="java.lang.String"/>
					<bean:define id="kindId" name="Fama0101Form" property="kindId" type="java.lang.Integer"/>
					<%			
						String myLink = "FAMA0110?";
						myLink += "id=" + id;
						myLink += "&qryKindNo=" + qryKindNo;
						myLink += "&qryKindName=" + qryKindName;
						myLink += "&kindId=" + kindId;
					%>
					
					<A href="<%=myLink%>">
						<bean:write name='row' property='codeNo'/>
					</A>
				</display:column>
				<display:column title="代碼名稱">
					<bean:write name='row' property='codeName'/>
				</display:column>
				<display:column title="備註">
					<bean:write name='row' property='remark'/>
				</display:column>
			</display:table>
		</td>
	</tr>
</table>
