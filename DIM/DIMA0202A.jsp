<!-- DIMA0201M.jsp
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
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/DIM/DIMA0202AScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("DIMA02")+"-[新增作業]"%>'/>
	<tiles:put name='action' value='DIMA02F'/>
	<tiles:put name='form' value='/DIM/DIMA0202AForm.jsp'/>
	<tiles:put name='bar' value='/DIM/DIMA0202ABar.jsp'/>
</tiles:insert>
