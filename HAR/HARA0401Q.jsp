<!--
程式目的：HARA04文字
程式代號：HARA04
程式名稱：HARA0401Q.jsp
程式日期：0950221
程式作者：Andrew Sung
程式內容：受分配單位分配比例資料查詢列印
程式說明：提供使用者查詢及列印各分配單位的分配比例
-->


<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>
<tiles:insert definition=".condition.masterDetailBody" flush="true">
	<tiles:put name='scripts' value='/common/blankScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("HARA04")%>'/>
	<tiles:put name='action' value='HARA0401F'/>
	<tiles:put name='mform' value='/HAR/HARA0401QForm.jsp'/>
	<tiles:put name='mbar' value='/HAR/HARA0401QBar.jsp'/>
	<tiles:put name="dform" value="/HAR/HARA0401LForm.jsp"/>
	<tiles:put name="dbar" value="/HAR/HARA0401LBar.jsp"/>
</tiles:insert>
