<!-- HARB1001P.jsp
程式目的：HARB10文字
程式代號：HARB10
程式日期：0950221
程式作者：Andrew Sung
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/HAR/HARB1001PScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("HARB10")%>'/>
	<tiles:put name='action' value='HARB1001P'/>
	<tiles:put name='form' value='/HAR/HARB1001PForm.jsp'/>
	<tiles:put name='bar' value='/HAR/HARB1001PBar.jsp'/>
</tiles:insert>
