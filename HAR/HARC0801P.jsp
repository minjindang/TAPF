<!-- HARC0801P.jsp
程式目的：HARC08文字
程式代號：HARC08
程式日期：0950221
程式作者：Eric.Chen
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/HAR/HARC0801PScript.jsp'/>
	<tiles:put name='title' value='<%="專案補助-"+gov.dnt.tame.util.CommonFun.getTitle("HARC08")%>'/>
	<tiles:put name='action' value='HARC08F'/>
	<tiles:put name='form' value='/HAR/HARC0801PForm.jsp'/>
	<tiles:put name='bar' value='/HAR/HARC0801PBar.jsp'/>
</tiles:insert>
