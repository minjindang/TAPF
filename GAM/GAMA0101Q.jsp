<!-- GAMA0101Q.jsp
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
<tiles:insert definition=".condition.masterDetailBody" flush="true">
	<tiles:put name='scripts' value='/common/blankScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("GAMA01")%>'/>
	<tiles:put name='action' value='GAMA01F'/>
	<tiles:put name="mform" value="/GAM/GAMA0101QForm.jsp"/>
	<tiles:put name="mbar" value="/GAM/GAMA0101QBar.jsp"/>
	<tiles:put name="dform" value="/GAM/GAMA0101LForm.jsp"/>
	<tiles:put name="dbar" value="/GAM/GAMA0101LBar.jsp"/>
</tiles:insert>