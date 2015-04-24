<!-- BIMA0202M.jsp
程式目的：BIMA02
程式代號：BIMA02
程式日期：0950302
程式作者：Eric.Chen
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->


<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/BIM/BIMA0202AScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("BIMA02")%>'/>
	<tiles:put name='action' value='BIMA02F'/>
	<tiles:put name='form' value='/BIM/BIMA0202MForm.jsp'/>
	<tiles:put name='bar' value='/BIM/BIMA0202MBar.jsp'/>
</tiles:insert>
