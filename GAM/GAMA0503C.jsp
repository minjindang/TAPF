<!-- GAMA0101A.jsp
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
	<tiles:put name='scripts' value='/GAM/GAMA0503CScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("GAMA05")+"<br>�O�d�Ʋ���"%>'/>
	<tiles:put name='action' value='GAMA05F'/>
	<tiles:put name='form' value='/GAM/GAMA0503CForm.jsp'/>
	<tiles:put name='bar' value='/GAM/GAMA0503CBar.jsp'/>
</tiles:insert>
