<!-- FAMA0601LFrom.jsp
程式目的：FAMA06
程式代號：FAMA06
程式日期：0950222
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
				<display:column title="國別代號">	
				<bean:define id="id" name="row" property="id" type="java.lang.Integer"/>
				<bean:define id="qrynationNo" name="Fama0601Form" property="qrynationNo" type="java.lang.String"/>
				<bean:define id="qrycontinentNo" name="Fama0601Form" property="qrycontinentNo" type="java.lang.String"/>
				<bean:define id="qrynationCname" name="Fama0601Form" property="qrynationCname" type="java.lang.String"/>
				<bean:define id="qrynationEname" name="Fama0601Form" property="qrynationEname" type="java.lang.String"/>
					<%
						java.util.Map paramMap = new java.util.HashMap();
							paramMap.put("id",id);
							paramMap.put("qrynationNo",qrynationNo);
							paramMap.put("qrycontinentNo",qrycontinentNo);
							paramMap.put("qrynationCname",java.net.URLEncoder.encode(qrynationCname));
							paramMap.put("qrynationEname",java.net.URLEncoder.encode(qrynationEname));
						pageContext.setAttribute("paramMap", paramMap);
					%>  
					<html:link action='/FAMA0604' name='paramMap'>
							<bean:write name='row' property='nationNo'/>
					</html:link>       
				</display:column>
				<display:column title="洲別代號">
					<bean:write name='row' property='continentNo'/>
				</display:column>
				<display:column title="國家中文名稱">
					<bean:write name='row' property='nationCname'/>
				</display:column>
				<display:column title="國家英文名稱">
					<bean:write name='row' property='nationEname'/>
				</display:column>
				<display:column title="備註">
					<bean:write name='row' property='remark'/>
				</display:column>
			</display:table>
		</td>
	</tr>
</table>

