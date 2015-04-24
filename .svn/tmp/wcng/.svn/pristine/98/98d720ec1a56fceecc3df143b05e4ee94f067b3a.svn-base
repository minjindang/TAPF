<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>
<%@ page import="com.kangdainfo.ast.webmenu.menu.MenuComponent" %>
<%@ page import="com.kangdainfo.ast.webmenu.menu.MenuContext" %>
<%@ page import="com.kangdainfo.ast.webmenu.display.MenuDisplayer" %>
<%@ page import="com.kangdainfo.ast.webmenu.permission.PermissionAdaptor" %>
<%@ page import="com.kangdainfo.ast.webmenu.display.CollapsibleCheckboxMenuDisplayer" %>

<table class="table_function" width="100%">
	<tr>
		<td align="right">
			<html:submit styleClass="formcss_rbutton" property="doUpd" value="確定"/>
            <html:reset  styleClass="formcss_rbutton" property="reset" value="復原"/>
			<html:submit styleClass="formcss_rbutton" property="goQry" value="回查詢"/>
		</td>
	</tr>
</table>
<input type="hidden" name="roleid" value="<%=request.getParameter("roleid")%>">
<table class="table_1" width="100%">
	<tr>
		<td>
	<%
		try
		{
			MenuComponent[] menus = ((MenuContext) application.getAttribute(".menuContext")).getMenuComponents();
			MenuDisplayer displayer = new CollapsibleCheckboxMenuDisplayer();
			displayer.init(pageContext);
			displayer.setPermissionAdaptor((PermissionAdaptor) request.getAttribute("permissions"));
			((CollapsibleCheckboxMenuDisplayer)displayer).setCheckboxName("items");
			for (int i=0; i<menus.length; ++i)
				displayer.display(menus[i]);
		}
		catch (Exception e)
		{
			out.println("Exception: " + e);
			e.printStackTrace();
		}
	%>
		</td>
	</tr>
</table>

<table class="table_function" width="100%">
	<tr>
		<td align="right">
			<html:submit styleClass="formcss_rbutton" property="doUpd" value="確定"/>
            <html:reset  styleClass="formcss_rbutton" property="reset" value="復原"/>
			<html:submit styleClass="formcss_rbutton" property="goQry" value="回查詢"/>
		</td>
	</tr>
</table>
