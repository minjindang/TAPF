<!-- CPMA0101LForm.jsp
�{���ت��GCPMA01
�{���N���GCPMA01
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
<%@ page import="gov.dnt.tame.util.DateUtil" %>
<table class='table_1' width='100%'>
	<tr>
		<td>
			<display:table class="table_list" name="collection" id="row">
				<display:column title="�~��">
				<bean:define id="id" name="row" property="id" type="java.lang.Integer"/>
				<bean:define id="qryaccountYear" name="Cpma0101Form" property="qryaccountYear" type="java.lang.String"/>
				<bean:define id="qrydebtName" name="Cpma0101Form" property="qrydebtName" type="java.lang.String"/>
				<bean:define id="issueId" name="row" property="id" type="java.lang.Integer"/>
				<%
						java.util.Map paramMap = new java.util.HashMap();
							paramMap.put("id",id);
							paramMap.put("issueId",issueId);
							paramMap.put("qryaccountYear",qryaccountYear);
							paramMap.put("qrydebtName",java.net.URLEncoder.encode(qrydebtName));
						pageContext.setAttribute("paramMap", paramMap);
				%>  
				<html:link action='/CPMA0101MLOAD' name='paramMap'>
					<bean:write name='row' property='accountYear'/>
				</html:link>	
				</display:column>
				<display:column title="����">
				<html:hidden name="Cpma0101Form" property="issueId"/>
					<html:link action='/CPMA0101MLOAD' name='paramMap'>	
						<bean:write name='row' property='serialNo'/>
					</html:link>	
				</display:column>
				<display:column title="���O">
					<html:link action='/CPMA0101MLOAD' name='paramMap'>
						<bean:write name='row' property='issueSerial'/>
					</html:link>	
				</display:column>
				<display:column title="�W��">
					<html:link action='/CPMA0101MLOAD' name='paramMap'>
						<bean:write name='row' property='debtName'/>
					</html:link>		
				</display:column>
				<display:column title="�ɴڴ���">
					<html:link action='/CPMA0101MLOAD' name='paramMap'>
					<logic:notEmpty name='row' property='issueDate'>
						<bean:define id="issueDate" name="row" property="issueDate" type="java.util.Date"/>
							<%=DateUtil.date2ROCStr(issueDate)%>~
					</logic:notEmpty>
					<logic:empty name='row' property='issueDate'>
							<%="0000000"%>~
					</logic:empty>
					<logic:notEmpty name='row' property='dueDate'>
						<bean:define id="dueDate" name="row" property="dueDate" type="java.util.Date"/>
							<%=DateUtil.date2ROCStr(dueDate)%>
					</logic:notEmpty>
					<logic:empty name='row' property='dueDate'>
							<%="0000000"%>
					</logic:empty>
					</html:link>  	
				</display:column>
			</display:table>
		</td>
	</tr>
</table>

