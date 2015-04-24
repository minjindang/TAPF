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
				<display:column title="期別">
					<bean:define id="id" name="row" property="id" type="java.lang.Integer"/>
					<%			
						String myLink = "GAMA0802?";
						myLink += "id=" + id;
					%>
					<A href="<%=myLink%>">
						<bean:write name='row' property='issueSerial'/>
					</A>
				</display:column>
				<display:column title="期別名稱" property='debtName'/>
				<display:column title="債務別" property='debtCode' decorator="tw.gov.nta.account.form.DebtCodeNameDecorator"/>
				<display:column title="年期" property='years'/>
				<display:column title="發行日期">
					<logic:notEmpty name='row' property='issueDate'>
						<bean:define id='issueDate' name="row" property="issueDate" type="java.util.Date"/>
						<%= new gov.dnt.tame.util.DateUtil().date2ROCStr(issueDate,"yyy/mm/dd")%>
					</logic:notEmpty>
				</display:column>
				<display:column title="預計還款日">
					<logic:notEmpty name='row' property='repayDate'>
						<bean:define id='repayDate' name="row" property="repayDate" type="java.util.Date"/>
						<%= new gov.dnt.tame.util.DateUtil().date2ROCStr(repayDate,"yyy/mm/dd")%>
					</logic:notEmpty>
				</display:column>
			</display:table>
		</td>
	</tr>
</table>

