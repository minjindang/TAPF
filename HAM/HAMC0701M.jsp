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
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/HAM/HAMB0701MScript.jsp'/>
	<tiles:put name='title' value='<%="專案補助-"+gov.dnt.tame.util.CommonFun.getTitle("HAMC07")%>'/>
	<tiles:put name='action' value='HAMC07F'/>
	<tiles:put name='form' value='/HAM/HAMB0701MForm.jsp'/>
	<tiles:put name='bar' value='/HAM/HAMB0701MBar.jsp'/>
</tiles:insert>
