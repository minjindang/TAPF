<!--
�{���ت��GFAMA03��r
�{���N���GFAMA03
�{������G0950222
�{���@�̡GFormBean Generator
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.masterDetailBody" flush="true">
	<tiles:put name='scripts' value='/common/blankScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("FAMA03")%>'/>
	<tiles:put name='action' value='FAMA03F'/>
	<tiles:put name="mform" value='/FAM/FAMA0301QForm.jsp'/>
	<tiles:put name="mbar" value='/FAM/FAMA0301QBar.jsp'/>
	<tiles:put name="dform" value="/FAM/FAMA0301LForm.jsp"/>
	<tiles:put name="dbar" value="/FAM/FAMA0301LBar.jsp"/>
</tiles:insert>
