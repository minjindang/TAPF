<!-- HAMB0101Q.jsp
程式目的：HAMB01文字
程式代號：HAMB01
程式日期：0950220
程式作者：Eric.Chen
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/HAM/HAMB0101QScript.jsp'/>
	<tiles:put name='title' value='<%="專案補助-"+gov.dnt.tame.util.CommonFun.getTitle("HAMC01")%>'/>
	<tiles:put name='action' value='HAMC01F'/>
	<tiles:put name='form' value='/HAM/HAMC0101QForm.jsp'/>
	<tiles:put name='bar' value='/HAM/HAMB0101QBar.jsp'/>
</tiles:insert>
