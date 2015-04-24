<!--
程式目的：HAMA03文字
程式代號：HAMA03
程式日期：0950220
程式作者：FormBean Generator
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.uploadBody" flush="true">
	<tiles:put name='scripts' value='/HAM/HAMA0301MScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("HAMA03")%>'/>
	<tiles:put name='action' value='HAMA03F'/>
	<tiles:put name='mform' value='/HAM/HAMA0301MForm.jsp'/>
	<tiles:put name='mbar' value='/HAM/HAMA0301MBar.jsp'/>
	<tiles:put name="dform" value="/HAM/HAMA0301LForm.jsp"/>
	<tiles:put name="dbar" value="/HAM/HAMA0301LBar.jsp"/>
</tiles:insert>
