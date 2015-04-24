<!-- GAMA0904M.jsp
程式目的：GAMA09
程式代號：GAMA09
程式日期：0980409
程式作者：Chris
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->


<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/GAM/GAMA0901MScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("GAMA09")%>'/>
	<tiles:put name='action' value='GAMA09F'/>
	<tiles:put name="form" value="/GAM/GAMA0904MForm.jsp"/>
	<tiles:put name="bar" value="/GAM/GAMA0904MBar.jsp"/>
</tiles:insert>