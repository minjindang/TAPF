<!--
程式目的：AIMA01文字
程式代號：AIMA01
程式日期：0950306
程式作者：FormBean Generator
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/AIM/AIMA0301AScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("AIMA03")%>'/>
	<tiles:put name='action' value='AIMA0301AF'/>
	<tiles:put name='form' value='/AIM/AIMA0301AForm.jsp'/>
	<tiles:put name='bar' value='/AIM/AIMA0301ABar.jsp'/>
</tiles:insert>
