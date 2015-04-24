<!-- DIMA0101M.jsp
程式目的：DIMA01
程式代號：DIMA01
程式日期：0950223
程式作者：Eric.Chen
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->


<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/DIM/DIMA0101MScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("DIMA01")+"-[維護作業]"%>'/>
	<tiles:put name='action' value='DIMA01F'/>
	<tiles:put name='form' value='/DIM/DIMA0101MForm.jsp'/>
	<tiles:put name='bar' value='/DIM/DIMA0101MBar.jsp'/>
</tiles:insert>
