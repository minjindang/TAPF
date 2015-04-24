<!-- BIMA0201LForm.jsp
程式目的：BIMA02
程式代號：BIMA02
程式日期：0950302
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
			
				<display:column title="提前買回期別">
					<bean:define id="id" name="row" property="id" type="java.lang.Integer"/>
					<bean:define id="qryIssueId" name="Bima0201Form" property="qryIssueId" type="java.lang.Integer"/>
					<%			
							String myLink = "BIMA0205?";
							myLink += "qryIssueId=" + qryIssueId;
							myLink += "&id=" + id ; 
					%>   
					<A href="<%=myLink%>">
						<bean:write name='row' property='interestSerial'/>
					</A>	
				</display:column>
				<display:column title="原始成本利息">
					<bean:write name='row' property='manageCapitalAmount' format='#,##0'/>
				</display:column>
				<display:column title="提早買回實付利息">
					<bean:write name='row' property='manageInterestAmount' format='#,##0'/>
				</display:column>
				
				<display:column title="提前買回金額">
					<bean:write name='row' property='balanceCapitalAmount' format='#,##0'/>
				</display:column>
				<display:column title="買回日期">
					<logic:empty name='row' property='repayDate'></logic:empty>
					<logic:notEmpty  name='row' property='repayDate' >
						<bean:define id='repayDate' name='row' property='repayDate' type='java.util.Date'/>
						<%= new gov.dnt.tame.util.DateUtil().date2ROCStr(repayDate,"yyy/mm/dd")  %>
					</logic:notEmpty>
					
				</display:column>
			</display:table>
		</td>
	</tr>
</table>

