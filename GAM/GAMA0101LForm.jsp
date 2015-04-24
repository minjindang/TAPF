<!-- CIMA0101LForm.jsp
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
<%@ page import="gov.dnt.tame.util.DateUtil" %>
<table class='table_1' width='100%'>
	<tr>
		<td>
			<display:table class="table_list" name="collection" id="row">
				<display:column title="年度">
					<bean:define id="id" name="row" property="id" type="java.lang.Integer"/>
					<bean:define id="qryaccountYear" name="Cima0101Form" property="qryaccountYear" type="java.lang.String"/>
					<bean:define id="qryserialNo" name="Cima0101Form" property="qryserialNo" type="java.lang.String"/>
					<bean:define id="qryissueSerial" name="Cima0101Form" property="qryissueSerial" type="java.lang.String"/>
					<bean:define id="qrydebtName" name="Cima0101Form" property="qrydebtName" type="java.lang.String"/>
					<%
							java.util.Map paramMap = new java.util.HashMap();
								paramMap.put("id",id);
								paramMap.put("qryaccountYear",qryaccountYear);
								paramMap.put("qrydebtName",java.net.URLEncoder.encode(qrydebtName));
								paramMap.put("qryserialNo",qryserialNo);
								paramMap.put("qryissueSerial",qryissueSerial);
							pageContext.setAttribute("paramMap", paramMap);
					%>  
					<html:link action='/GAMA0110' name='paramMap'>
						<bean:write name='row' property='accountYear'/>
					</html:link>  
				</display:column>
				<display:column title="期次">
					<html:link action='/GAMA0110' name='paramMap'>		
						<bean:write name='row' property='serialNo'/>
					</html:link>  	
				</display:column>
				<display:column title="期別">
					<html:link action='/GAMA0110' name='paramMap'>
						<bean:write name='row' property='issueSerial'/>
					</html:link>  	
				</display:column>
				<display:column title="名稱">
					<html:link action='/GAMA0110' name='paramMap'>
						<bean:write name='row' property='debtName'/>
					</html:link>  	
				</display:column>
				<display:column title="借款期間">
					<html:link action='/GAMA0110' name='paramMap'>
					<logic:notEmpty name='row' property='issueDate'>
						<bean:define id="issueDate" name="row" property="issueDate" type="java.util.Date"/>
							<%=DateUtil.date2ROCStr(issueDate,"yyy/mm/dd")%>~
					</logic:notEmpty>
					<logic:empty name='row' property='issueDate'>
							<%="000/00/00"%>~
					</logic:empty>
					<logic:notEmpty name='row' property='dueDate'>
						<bean:define id="dueDate" name="row" property="dueDate" type="java.util.Date"/>
							<%=DateUtil.date2ROCStr(dueDate,"yyy/mm/dd")%>
					</logic:notEmpty>
					<logic:empty name='row' property='dueDate'>
							<%="000/00/00"%>
					</logic:empty>
					</html:link>  
				</display:column>
				<display:column title="承接日期">
					<html:link action='/GAMA0110' name='paramMap'>
					<logic:notEmpty name='row' property='continueDate'>
						<bean:define id="continueDate" name="row" property="continueDate" type="java.util.Date"/>
							<%=DateUtil.date2ROCStr(continueDate,"yyy/mm/dd")%>
					</logic:notEmpty>
					<logic:empty name='row' property='continueDate'>
							<%="000/00/00"%>
					</logic:empty>
					</html:link>  
				</display:column>
			</display:table>
		</td>
	</tr>
</table>

