<!-- GAMA0903M.jsp
�{���ت��GGAMA09
�{���N���GGAMA09
�{������G0980409
�{���@�̡GChris
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->
<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.masterDetailLevel4" flush="true">
	<tiles:put name='scripts' value='/GAM/GAMA0901MScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("GAMA09")%>'/>
	<tiles:put name='action' value='GAMA09F'/>
	<tiles:put name="mform" value="/GAM/GAMA0903MForm.jsp"/>
	<tiles:put name="mbar" value="/GAM/GAMA0903MBar.jsp"/>
	<tiles:put name="dform" value="/GAM/GAMA0903ML0Form.jsp"/>
	<tiles:put name="dbar" value="/GAM/GAMA0903MLBar.jsp"/>
	<tiles:put name="lform" value="/GAM/GAMA0903MLForm.jsp"/>
	<tiles:put name="lbar" value="/GAM/GAMA0903MLLBar.jsp"/>
	<!--<tiles:put name="llform" value="/GAM/GAMA0903MLSubDForm.jsp"/>-->
	<tiles:put name="llform" value="/common/blankBar.jsp"/>
	<tiles:put name="llbar" value="/common/blankBar.jsp"/>
</tiles:insert>