<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<table class='table_1' width='100%'>
	<tr>
		<td>
			<display:table class="table_list" name="collection" id="row">
				<display:column title="還本日期">
					<bean:define id="id" name="row" property="id" type="java.lang.Integer"/>
					<%
						java.util.Map paramMap = new java.util.HashMap();
							paramMap.put("id", id);
						pageContext.setAttribute("paramMap", paramMap);
					%>
					<html:link action='/GAMA0603' name='paramMap'>
						<bean:define id='repayDate' name='row' property='repayDate' type='java.util.Date'/>
						<%= gov.dnt.tame.util.DateUtil.date2ROCStr(repayDate,"yyy/mm/dd") %>
					</html:link>
				</display:column>
				<display:column title="還本金額" >
					<logic:notEmpty name='row' property='capitalAmount'>
						<bean:define id='capitalAmount' name='row' property='capitalAmount' type='java.math.BigDecimal' />
						<%= new java.text.DecimalFormat("#,##0").format(capitalAmount) %>
					</logic:notEmpty>
				</display:column>
				<display:column title="還本期數">
					<bean:write name='row' property='capitalSerial'/>
				</display:column>
			</display:table>
		</td>
	</tr>
</table>
