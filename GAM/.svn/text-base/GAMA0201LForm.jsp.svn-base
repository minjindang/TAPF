<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<table class='table_1' width='100%'>
	<tr>
		<td>
			<display:table class="table_list" name="collection" id="row">
				<display:column title="年度">
					<bean:write name='row' property='accountYear'/>
				</display:column>
				<display:column title="國別">
					<bean:define id="id" name="row" property="id" type="java.lang.Integer"/>
					<bean:define id="qryAccountYear" name="Gama0201Form" property="qryAccountYear" type="java.lang.String"/>
					<bean:define id="qryNationCode" name="Gama0201Form" property="qryNationCode" type="java.lang.Integer"/>
					<%			
						String myLink = "GAMA0204?";
						myLink += "id=" + id;
						myLink +="&qryAccountYear="+qryAccountYear;
						myLink +="&qryNationCode="+qryNationCode;
					%>
					
					<A href="<%=myLink%>">
						<bean:define id="NationRef" name="row" property="nationCode" type="tw.gov.nta.sql.NationRef"/>
						<bean:write name='NationRef' property='nationCname'/>
					</A>
					
				</display:column>
				<display:column title="GDP">
					<p align="right"><bean:write name='row' property='gdpAmount' format='#,###'/></p>
				</display:column>
				<display:column title="會計GNP">
					<p align="right"><bean:write name='row' property='gnpAmount' format='#,###'/></p>
				</display:column>
				<display:column title="歷年GNP">
					<p align="right"><bean:write name='row' property='gnpYearAmount' format='#,###'/></p>
				</display:column>
				<display:column title="前三年平均GNP">
					<p align="right"><bean:write name='row' property='pergnpAmount' format='#,###'/></p>
				</display:column>
				<display:column title="債務餘額/GDP比例">
					<p align="right"><bean:write name='row' property='remainRate' format='#,##0.000'/></p>
				</display:column>
				<display:column title="未償餘額/支(歲)出比例">
					<p align="right"><bean:write name='row' property='remainPayRate' format='#,##0.000'/></p>
				</display:column>
				<display:column title="各國依存度">
					<p align="right"><bean:write name='row' property='caseRate' format='#,##0.000'/></p>
				</display:column>
				
				
				
				
				
				
				
				
				
			</display:table>
		</td>
	</tr>
</table>
