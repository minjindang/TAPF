<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>

<html:hidden name="Hama0601Form" property="page"/>
<input type='hidden' name='xaction' value='HAMA0603'>

<table class="table_function" width="100%">
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
</table>