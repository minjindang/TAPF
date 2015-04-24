<!--
程式目的：AIMA01文字
程式代號：AIMA01
程式日期：0950306
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
				<display:column title="發行/調整日期">
					<bean:define id='id' name='row' property='id' type='java.lang.Integer' />
					<bean:define id='issue' name='row' property='issue' type='tw.gov.nta.sql.debt.IssueMain' />
					<%			
								String myLink = "AIMA0507?";
								myLink += "&id="+id;
								myLink += "&issueId="+issue.getId();
					%>   
					<A href="<%=myLink%>">
						<bean:define id='changeDate' name='row' property='changeDate' type='java.util.Date' />
						<%= new gov.dnt.tame.util.DateUtil().date2ROCStr(changeDate,"yyy/mm/dd") %>
					</A>	
				</display:column>
				<display:column title="交換價格">
					<p align="right"><bean:write name='row' property='changePrice' format='#,###.###'/></p>
				</display:column>
				<display:column title="累計交換股數">
					<p align="right"><bean:write name='row' property='sumStock' format='#,###'/></p>
				</display:column>
				<display:column title="累計釋股金額">
					<p align="right"><bean:write name='row' property='stockAmount' format='#,###'/></p>
				</display:column>
				<display:column title="累計不足一股償付金額">
					<p align="right"><bean:write name='row' property='notAmount' format='#,###'/></p>
				</display:column>
				<display:column title="累計交換金額">
					<p align="right"><bean:write name='row' property='changeAmount' format='#,###'/></p>	
				</display:column>
				<display:column title="調整價格原因">
					<bean:write name='row' property='changeReason'/>	
				</display:column>
			</display:table>
		</td>
	</tr>
</table>
