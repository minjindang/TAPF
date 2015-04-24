<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>

<logic:notPresent name="queryMap">
	<jsp:useBean id="queryMap" class="java.util.HashMap"/>
</logic:notPresent>
<%
	java.util.Map requestBean = new java.util.HashMap();
		requestBean.put("FIRST",request.getParameter("FIRST"));
	pageContext.setAttribute("requestBean", requestBean);
%>
<html:hidden name="requestBean" property="FIRST"/>
<table class="table_1" width="100%">
	<tr>
		<td class="table_item" width="30%"><font color="#FF0000" size="4">*</font>新密碼</td>
		<td class="table_td"  width="70%">
			<html:password name="queryMap" property="PASSWORD" size="20" maxlength="20"/>
		</td>
	</tr>
	<tr>
		<td class="table_item"><font color="#FF0000" size="4">*</font>確認密碼</td>
		<td class="table_td">			
			<html:password name="queryMap" property="CPASSWORD" size="20" maxlength="20"/>
			<br>提示：密碼不能低於七碼，其中必須包含數字、英文字大小寫、至少一個特殊符號
		</td>
	</tr>
</table>
<table class="table_1" width="100%">
	<tr>
		<td class="table_function" align="right">
			<html:submit styleClass="formcss_rbutton" property="doUpd" value="更新"/>
			<html:reset styleClass="formcss_rbutton" property="reset" value="復原"/>
		</td>
	</tr>
</table>