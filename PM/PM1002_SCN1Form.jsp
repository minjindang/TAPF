<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>
<%@ page import="gov.dnt.tame.util.Converter"%>
<%
	pageContext.setAttribute("UserGroupList", Converter.getCodeListWithSpaceBySql("SELECT CONVERT(varchar,ID) AS valuess,NAME AS label FROM PM0004_DB ORDER BY ID"));
%>

<%
	java.util.Map requestBean = new java.util.HashMap();
		requestBean.put("GCODE",request.getParameter("GCODE"));
		requestBean.put("QACCOUNT",request.getParameter("QACCOUNT"));
		requestBean.put("QNAME",request.getParameter("QNAME"));

		requestBean.put("comeFrom",request.getParameter("comeFrom")==null?"A":request.getParameter("comeFrom"));
		requestBean.put("Page3",request.getParameter("Page3"));
	pageContext.setAttribute("requestBean", requestBean);
%>
<html:hidden name="requestBean" property="GCODE"/>
<html:hidden name="requestBean" property="QACCOUNT"/>
<html:hidden name="requestBean" property="QNAME"/>
<html:hidden name="requestBean" property="comeFrom"/>
<html:hidden name="requestBean" property="Page3"/>

<logic:notPresent name="queryMap">
	<jsp:useBean id="queryMap" class="java.util.HashMap"/>
	<%
		queryMap.put("STATUS","0");
	%>
</logic:notPresent>

<html:hidden name="queryMap" property="ID"/>
<table class="table_1" width="100%">
	<tr>
		<td class="table_item" width="20%">�m�W</td>
		<td class="table_td" width="30%">
			<html:text name="queryMap" property="NAME" size="20" maxlength="20"/>
		</td>
		<td class="table_item" width="20%">�����Ҧr��</td>
		<td class="table_td" width="30%">
			<html:text name="queryMap" property="IDNO" size="10" maxlength="10"/>
		</td>
	</tr>
	<tr>
		<td class="table_item" width="20%">�s��</td>
		<td class="table_td" width="30%">
			<html:select name="queryMap" property="PM0004ID">
				<html:options collection="UserGroupList" property="valuess" labelProperty="label"/>
			</html:select>
		</td>
		<td class="table_item" width="20%">�v��</td>
		<td class="table_td" width="30%">
			<html:select name="queryMap" property="LVL">
				<html:option value="">�п��</html:option>
			</html:select>
		</td>
	</tr>
	<tr>
		<td class="table_item">�b��</td>
		<td class="table_td" colspan="3">
			<html:text name="queryMap" property="ACCOUNT" size="20" maxlength="20"/>
			<font color="#FF0000" size="4">*</font>
		</td>
		<!-- 
		<td class="table_item">�K�X</td>
		<td class="table_td">
			<html:password name="queryMap" property="PASSWORD" size="20" maxlength="20"/>
			<font color="#FF0000" size="4">*</font>
		</td>
		 -->
	</tr>
	<tr>
		<td class="table_item">����</td>
		<td class="table_td">
			<html:text name="queryMap" property="DEPT" size="20" maxlength="20"/>
		</td>
		<td class="table_item">EMAIL</td>
		<td class="table_td">
			<html:text name="queryMap" property="EMAIL" size="20" maxlength="40"/>
		</td>
	</tr>
	<tr>
		<td class="table_item">�q��</td>
		<td class="table_td">
			<html:text name="queryMap" property="TEL" size="20" maxlength="20"/>
		</td>
		<td class="table_item">���</td>
		<td class="table_td">
			<html:text name="queryMap" property="MOBILE" size="20" maxlength="20"/>
		</td>
	</tr>
	<tr>
		<td class="table_item">�N�z�H�b��</td>
		<td class="table_td">
			<html:text name="queryMap" property="AGENTACCOUNT" size="20" maxlength="20"/>
		</td>
		<td class="table_item">�n�J���Ѧ���</td>
		<td class="table_td">
			<html:text name="queryMap" property="STATUS" size="2" maxlength="2" onblur="if(!isInteger(this.value)){alert('�i�n�J���Ѧ��ơj�������Ʀr!');this.value='0';}"/>
		</td>
	</tr>
</table>

