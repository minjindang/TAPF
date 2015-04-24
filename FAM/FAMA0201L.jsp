<!-- FAMA0201L.jsp
程式目的：FAMA02
程式代號：FAMA02
程式日期：0950222
程式作者：Eric.Chen
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/common/blankScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("FAMA02")%>'/>
	<tiles:put name='action' value='FAMA02F'/>
	<tiles:put name='form' value='/FAM/FAMA0201LForm.jsp'/>
	<tiles:put name='bar' value='/FAM/FAMA0201LBar.jsp'/>
</tiles:insert>
