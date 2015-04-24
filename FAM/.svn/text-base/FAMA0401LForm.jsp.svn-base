<!--
程式目的：FAMA04文字
程式代號：FAMA04
程式日期：0950223
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
				<display:column title="交換標的代號">
					<bean:define id="id" name="row" property="id" type="java.lang.Integer"/>
					<bean:define id="qryStockId" name="Fama0401Form" property="qryStockId" type="java.lang.String"/>
					<bean:define id="qryStockName" name="Fama0401Form" property="qryStockName" type="java.lang.String"/>
					
					<%			
						String myLink = "FAMA0403?";
						myLink += "id=" + id;
						myLink += "&qryStockId=" + qryStockId;
						myLink += "&qryStockName=" + qryStockName;
					%>
					
					<A href="<%=myLink%>">
						<bean:write name='row' property='stockId'/>
					</A>
				</display:column>
				<display:column title="交換標的名稱">
					<bean:write name='row' property='stockName'/>
				</display:column>
				<display:column title="備註">
					<bean:write name='row' property='remark'/>
				</display:column>
			</display:table>
		</td>
	</tr>
</table>
