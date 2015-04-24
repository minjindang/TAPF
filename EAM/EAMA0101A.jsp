<!-- EAMA0101Q.jsp
程式目的：EAMA01
程式代號：EAMA01
程式日期：0950308
程式作者：Linus.Tseng
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->


<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/EAMA/EAMA0101QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle((String)(session.getAttribute("SYSID")))%>'/>
	<tiles:put name='action' value='EAMA01F'/>
	<tiles:put name='form' value='/EAM/EAMA0101AForm.jsp'/>
	<tiles:put name='bar' value='/EAM/EAMA0101ABar.jsp'/>
</tiles:insert>