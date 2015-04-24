<!-- CIMA0101MLForm.jsp
程式目的：CIMA01
程式代號：CIMA01
程式日期：0950306
程式作者：Eric.Chen
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
					<bean:define id="id" name="row" property="id" type="java.lang.Integer"/>
					<bean:define id="qryAccountYear" name="Gama0701Form" property="qryAccountYear" type="java.lang.String"/>
					<%			
						String myLink = "GAMA0702?";
						myLink += "id=" + id;
						myLink += "&qryAccountYear="+qryAccountYear;
					%>
					<A href="<%=myLink%>">
						<bean:write name='row' property='accountYear'/>
					</A>
				</display:column>
				<display:column title="強制還本金額">
					<p align="right"><bean:write name='row' property='budgetCapital' format='#,###'/></p>
				</display:column>
				<display:column title="付息金額">
					<p align="right"><bean:write name='row' property='interestPayed' format='#,###'/></p>
				</display:column>
				<display:column title="歲出總額(總預算及特別預算)">
					<p align="right"><bean:write name='row' property='yearAmount' format='#,###'/></p>
				</display:column>
				<display:column title="債務基金到期還本數">
					<p align="right"><bean:write name='row' property='fundationCapital' format='#,###'/></p>
				</display:column>
			</display:table>
		</td>
	</tr>
</table>

