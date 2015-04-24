<!-- CIMA0101MLForm.jsp
�{���ت��GCIMA01
�{���N���GCIMA01
�{������G0950306
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
<table class='table_1' width='100%'>
	<tr>
		<td>
			<display:table class="table_list" name="collection" id="row">
				<display:column title="���O">
					<bean:define id="id" name="row" property="id" type="java.lang.Integer"/>
					<%			
						String myLink = "GAMA0802?";
						myLink += "id=" + id;
					%>
					<A href="<%=myLink%>">
						<bean:write name='row' property='issueSerial'/>
					</A>
				</display:column>
				<display:column title="���O�W��" property='debtName'/>
				<display:column title="�ŰȧO" property='debtCode' decorator="tw.gov.nta.account.form.DebtCodeNameDecorator"/>
				<display:column title="�~��" property='years'/>
				<display:column title="�o����">
					<logic:notEmpty name='row' property='issueDate'>
						<bean:define id='issueDate' name="row" property="issueDate" type="java.util.Date"/>
						<%= new gov.dnt.tame.util.DateUtil().date2ROCStr(issueDate,"yyy/mm/dd")%>
					</logic:notEmpty>
				</display:column>
				<display:column title="�w�p�ٴڤ�">
					<logic:notEmpty name='row' property='repayDate'>
						<bean:define id='repayDate' name="row" property="repayDate" type="java.util.Date"/>
						<%= new gov.dnt.tame.util.DateUtil().date2ROCStr(repayDate,"yyy/mm/dd")%>
					</logic:notEmpty>
				</display:column>
			</display:table>
		</td>
	</tr>
</table>

