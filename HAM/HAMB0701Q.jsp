<!--	電子郵件接收紀錄維護
程式目的：HAMB07文字
程式代號：HAMB07
程式日期：0950223
程式作者：FormBean Generator
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.masterDetailBody" flush="true">
	<tiles:put name='scripts' value='/HAM/HAMB0701QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("HAMB07")%>'/>
	<tiles:put name='action' value='HAMB07F'/>
	<tiles:put name='mform' value='/HAM/HAMB0701QForm.jsp'/>
	<tiles:put name='mbar' value='/HAM/HAMB0701QBar.jsp'/>
	<tiles:put name='dform' value='/HAM/HAMB0701LForm.jsp'/>
	<tiles:put name='dbar' value='/HAM/HAMB0701LBar.jsp'/>
</tiles:insert>
