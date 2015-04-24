<!-- DIMA0201A.jsp
程式目的：DIMA02
程式代號：DIMA02
程式日期：0950223
程式作者：Andrew Sung
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->


<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.mainListBody" flush="true">
	<tiles:put name='scripts' value='/DPM/DPMA0102AScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("DPMA01")%>'/>
	<tiles:put name='action' value='DPMA01F'/>
	<tiles:put name='mform' value='/DPM/DPMA0102AForm.jsp'/>
	<tiles:put name='mbar' value='/DPM/DPMA0102ABar.jsp'/>
	<tiles:put name='dform' value='/DPM/DPMA0102ALForm.jsp'/>
	<tiles:put name='dbar' value='/DPM/DPMA0102ALBar.jsp'/>
</tiles:insert>
