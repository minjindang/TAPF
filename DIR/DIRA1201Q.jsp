<!--
程式目的：
程式代號：DIRA1201
程式日期：0950227
程式作者：icefire
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/DIR/DIRA1201QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("DIRA12")%>'/>
	<tiles:put name='action' value='DIRA12F'/>
	<tiles:put name='form' value='/DIR/DIRA1201QForm.jsp'/>
	<tiles:put name='bar' value='/DIR/DIRA1201QBar.jsp'/>
</tiles:insert>