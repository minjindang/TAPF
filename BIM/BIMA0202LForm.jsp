<!-- BIMA0202LForm.jsp
�{���ت��GBIMA02
�{���N���GBIMA02
�{������G0950302
�{���@�̡GEric.Chen
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->


<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>
<%@ page import="java.math.BigDecimal" %>
<input type='hidden' name='paymentMainId' value='0'/>
<table class='table_1' width='100%'>
	<tr>
		<td>
			<display:table class="table_list" name="collection" id="row">
				<display:column title="�����W��">
					<bean:define id="id" name="row" property="id" type="java.lang.Integer"/>
					<bean:define id="qryIssueId" name="Bima0201Form" property="qryIssueId" type="java.lang.Integer"/>
					<bean:define id="paymentMainId" name="Bima0201Form" property="id" type="java.lang.Integer"/>
					<%			
						String myLink = "BIMA0209?";
						myLink += "qryIssueId=" + qryIssueId;
						myLink += "&id=" + id ; 
						myLink += "&paymentMainId=" + paymentMainId ; 
					%>   
					<A href="<%=myLink%>">
						<bean:define id="ticketAmount" name="row" property="ticketAmount" type="java.math.BigDecimal"/>
						<%=tw.gov.nta.system.common.CodeDetManage.getCodeName("MY",(ticketAmount.setScale(0)).toString())%>
					</A>	
				</display:column>
				<display:column title="�������B">
					<bean:write name='row' property='ticketAmount' format='#,###'/>
				</display:column>
				<display:column title="�i��">
					<bean:write name='row' property='ticketCount' format='#,###'/>
				</display:column>
				<display:column title="���B">
					<bean:define id="ticketAmount" name="row" property="ticketAmount" type="java.math.BigDecimal"/>
					<bean:define id="ticketCount" name="row" property="ticketCount" type="java.lang.Long"/>
					<% 
						out.print(new java.text.DecimalFormat("#,###").format(ticketAmount.multiply(BigDecimal.valueOf(ticketCount.longValue() ))));
					%>
				</display:column>
			</display:table>
		</td>
	</tr>
</table>

