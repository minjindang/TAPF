<!-- GAMA0102M.jsp
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
<tiles:insert definition=".condition.masterDetailLevel4" flush="true">
	<tiles:put name='scripts' value='/GAM/GAMA0102MScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("GAMA01")%>'/>
	<tiles:put name='action' value='GAMA01F'/>
	<tiles:put name="mform" value="/GAM/GAMA0102MForm.jsp"/>
	<tiles:put name="mbar" value="/GAM/GAMA0102MBar.jsp"/>
	<tiles:put name="dform" value="/GAM/GAMA0102ML0Form.jsp"/>
	<tiles:put name="dbar" value="/GAM/GAMA0102MLBar.jsp"/>
	<tiles:put name="lform" value="/GAM/GAMA0102MLForm.jsp"/>
	<tiles:put name="lbar" value="/GAM/GAMA0102MLLBar.jsp"/>
	<tiles:put name="llform" value="/GAM/GAMA0102MLSubDForm.jsp"/>
	<tiles:put name="llbar" value="/common/blankBar.jsp"/>
</tiles:insert>
