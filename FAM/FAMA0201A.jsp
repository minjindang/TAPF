<!-- FAMA0201A.jsp
�{���ت��GFAMA02
�{���N���GFAMA02
�{������G0950222
�{���@�̡GEric.Chen
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/FAM/FAMA0201AScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("FAMA02")%>'/>
	<tiles:put name='action' value='FAMA02F'/>
	<tiles:put name='form' value='/FAM/FAMA0201AForm.jsp'/>
	<tiles:put name='bar' value='/FAM/FAMA0201ABar.jsp'/>
</tiles:insert>
