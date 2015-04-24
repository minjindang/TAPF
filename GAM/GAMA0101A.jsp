<!-- GAMA0101A.jsp
程式目的：GAMA01
程式代號：GAMA01
程式日期：0950306
程式作者：Eric.Chen
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->


<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/GAM/GAMA0101AScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("GAMA01")%>'/>
	<tiles:put name='action' value='GAMA01F'/>
	<tiles:put name='form' value='/GAM/GAMA0101AForm.jsp'/>
	<tiles:put name='bar' value='/GAM/GAMA0101ABar.jsp'/>
</tiles:insert>
