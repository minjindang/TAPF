<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>
<table class='table_1' width='100%'>
	<tr>
		<td>
			<display:table class="table_list" name="collection" id="row">
				<display:column title="�~��">
					<bean:define id='dto' name='row' type='tw.gov.nta.sql.UserStatisticsDet'/>
					<%
						String myLink="GAMA0506?";
						myLink += "&id="+dto.getId();
						myLink += "&mainId="+dto.getUserStatisticsMain().getId();
					
					%>
					<A href="<%=myLink%>">
						<bean:write name="row" property="accountYear"/>
					</A>	
				</display:column>
				<display:column title="���O">
					<logic:notEmpty name="row" property="dataType">
					<bean:define id="dataType" name="row" property="dataType" type="java.lang.String"/>
					<%=(dataType.equals("A"))?"����":"������" %>
					</logic:notEmpty>
				</display:column>
				<display:column title="��K��">
					<p align="right"><bean:write name="row" property="subAmount" format="#,###"/></p>
				</display:column>
				<display:column title="��~�W�[��ڼ�">
					<p align="right"><bean:write name="row" property="plusdebtAmount" format="#,###"/></p>
				</display:column>
				<display:column title="�֭p��ڼ�">
					<p align="right"><bean:write name="row" property="realAmount" format="#,###"/></p>
				</display:column>
				<display:column title="�O�d��">
					<p align="right"><bean:write name="row" property="keepAmount" format="#,###"/></p>
				</display:column>
				<display:column title="�M���">
					<p align="right"><bean:write name="row" property="auditAmount" format="#,###"/></p>
				</display:column>
			</display:table>
		</td>
	</tr>
</table>

