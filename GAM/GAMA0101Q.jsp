<!-- GAMA0101Q.jsp
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
<tiles:insert definition=".condition.masterDetailBody" flush="true">
	<tiles:put name='scripts' value='/common/blankScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("GAMA01")%>'/>
	<tiles:put name='action' value='GAMA01F'/>
	<tiles:put name="mform" value="/GAM/GAMA0101QForm.jsp"/>
	<tiles:put name="mbar" value="/GAM/GAMA0101QBar.jsp"/>
	<tiles:put name="dform" value="/GAM/GAMA0101LForm.jsp"/>
	<tiles:put name="dbar" value="/GAM/GAMA0101LBar.jsp"/>
</tiles:insert>