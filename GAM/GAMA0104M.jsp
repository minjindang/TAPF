<!-- GAMA0104M.jsp
�{���ت��GGAMA01
�{���N���GGAMA01
�{������G0950306
�{���@�̡GEric.Chen
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->


<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/GAM/GAMA0104MScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("GAMA01")%>'/>
	<tiles:put name='action' value='GAMA01F'/>
	<tiles:put name="form" value="/GAM/GAMA0104MForm.jsp"/>
	<tiles:put name="bar" value="/GAM/GAMA0104MBar.jsp"/>
</tiles:insert>