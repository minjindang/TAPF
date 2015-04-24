<!--
程式目的：受分配單位資料維護
程式代號：HAMA04
程式日期：1000920
程式作者：Powen Hsueh
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.masterDetailBody" flush="true">
	<tiles:put name='scripts' value='/HAM/HAMA0401QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("HAMA04")%>'/>
	<tiles:put name='action' value='HAMA04F'/>
	<tiles:put name="mform" value="/HAM/HAMA0401QForm.jsp"/>
	<tiles:put name="mbar" value="/HAM/HAMA0401QBar.jsp"/>
	<tiles:put name="dform" value="/HAM/HAMA0401LForm.jsp"/>
	<tiles:put name="dbar" value="/HAM/HAMA0401LBar.jsp"/>
</tiles:insert>
