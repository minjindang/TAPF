<!-- FAMA0601LFrom.jsp
�{���ت��GFAMA06
�{���N���GFAMA06
�{������G0950222
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
				<display:column title="��O�N��">	
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
				<display:column title="�w�O�N��">
					<bean:write name='row' property='continentNo'/>
				</display:column>
				<display:column title="��a����W��">
					<bean:write name='row' property='nationCname'/>
				</display:column>
				<display:column title="��a�^��W��">
					<bean:write name='row' property='nationEname'/>
				</display:column>
				<display:column title="�Ƶ�">
					<bean:write name='row' property='remark'/>
				</display:column>
			</display:table>
		</td>
	</tr>
</table>

