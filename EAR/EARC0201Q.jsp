<!--
程式目的：中央政府公債還本付息報表
程式代號：AIRB01
程式日期：0950227
程式作者：icefire
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/EAR/EARC0201QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("EARC02")%>'/>
	<tiles:put name='action' value='EARC02F'/>
	<tiles:put name='form' value='/EAR/EARC0201QForm.jsp'/>
	<tiles:put name='bar' value='/EAR/EARC0201QBar.jsp'/>
</tiles:insert>