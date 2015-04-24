<!-- DIMA0301LForm.jsp
程式目的：DIMA03
程式代號：DIMA03
程式日期：0950224
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
<%@ page import="gov.dnt.tame.util.DateUtil" %>
<table class='table_1' width='100%'>
	<tr>
		<td>
			<display:table class="table_list" name="collection" id="row">
				<display:column title="年度">
					<bean:write name='row' property='accountYear'/>	
				</display:column>
				<display:column title="期次">
					<bean:write name='row' property='serialNo'/>
				</display:column>
				<display:column title="期別">
					<bean:write name='row' property='issueSerial'/>
				</display:column>
				<display:column title="名稱">
				<bean:define id="id" name="row" property="id" type="java.lang.Integer"/>
					<bean:define id="qryAccountYear" name="Dima0201Form" property="qryAccountYear" type="java.lang.String"/>
					<bean:define id="qrySerialNo" name="Dima0201Form" property="qrySerialNo" type="java.lang.String"/>
					<bean:define id="qryId" name="Dima0201Form" property="qryId" type="java.lang.Integer"/>
					<%			
								String myLink = "DIMA0213?";
								myLink += "&id="+id;
								myLink += "&qryAccountYear="+qryAccountYear;
								myLink += "&qrySerialNo="+qrySerialNo;
								myLink += "&qryId="+qryId;
					%>   
					<A href="<%=myLink%>">
						<bean:write name='row' property='debtName'/>
					</A>	
				</display:column>
				<display:column title="借款期間">
					<bean:define id='issueDate' name='row' property='issueDate' type="java.util.Date"/>
					<bean:define id='dueDate' name='row' property='dueDate' type="java.util.Date"/>
					<%= DateUtil.date2ROCStr(issueDate,"yyy/mm/dd")+"~"+DateUtil.date2ROCStr(dueDate,"yyy/mm/dd")%>
				</display:column>
			</display:table>
		</td>
	</tr>
</table>

