<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>

<%
	java.util.Map requestBean = new java.util.HashMap();
		requestBean.put("GCODE",request.getParameter("GCODE"));
	
	pageContext.setAttribute("requestBean", requestBean);
%>
<html:hidden name="requestBean" property="GCODE"/>

<table class="table_1" width="100%">
<tr>
	<td>
		<logic:present name="queryList">		
			<display:table class="table_list" name="queryList" id="row">
				<display:column title="姓名">
					<%
						String myLink = "PM1003_03L?";
						myLink += "&GCODE="+request.getParameter("GCODE");
					%>
					<A href="<%=myLink%>">
						<bean:write name='row' property='NAME'/>&nbsp;
					</A>
				</display:column>
				
				<display:column title="單位">
					<bean:write name='row' property='DEPT'/>&nbsp;
				</display:column>
								
				<display:column title="群組">
					<bean:write name='row' property='GNAME'/>&nbsp;
				</display:column>
				
			</display:table>
		</logic:present>
	</td>
</tr>
</table>

<table class="table_function" width="100%">
<%=((null == request.getAttribute("HIDDENDATA"))?"":request.getAttribute("HIDDENDATA"))%>
<%
		String PAGEBAR = (String) request.getAttribute("PAGEBAR");
		if(null != PAGEBAR)
		{
%>
	<tr>
		<td align="right">
			<%=PAGEBAR%>
		</td>
	</tr>
<% 
		}
%>
	<tr>
		<td align="right">
			<html:submit property="goQry" value="回查詢" styleClass="formcss_rbutton"/>
		</td>
	</tr>
</table>