<!-- DIMA0101L.jsp
程式目的：EAMA01
程式代號：EAMA01
程式日期：0950223
程式作者：Eric.Chen
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->


<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/common/blankScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle((String)(session.getAttribute("SYSID")))%>'/>
	<tiles:put name='action' value='EAMA01F'/>
	<tiles:put name='form' value='/EAM/EAMA0101LForm.jsp'/>
	<tiles:put name='bar' value='/EAM/EAMA0101LBar.jsp'/>
</tiles:insert>
