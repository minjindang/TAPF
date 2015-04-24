<!--
程式目的：EAMA02文字
程式代號：EAMA02
程式日期：0950310
程式作者：FormBean Generator
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.masterDetailBody" flush="true">
	<tiles:put name='scripts' value='/EAM/EAMA0201AScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle((String)(session.getAttribute("SYSID")))%>'/>
	<tiles:put name='action' value='EAMA0201F'/>
	<tiles:put name='mform' value='/EAM/EAMA0201MForm.jsp'/>
	<tiles:put name='mbar' value='/EAM/EAMA0201MBar.jsp'/>
	<tiles:put name='dform' value='/EAM/EAMA0202LForm.jsp'/>
	<tiles:put name='dbar' value='/EAM/EAMA0202LBar.jsp'/>
</tiles:insert>
