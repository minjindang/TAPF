<!--
�{���ت��GHARA04��r
�{���N���GHARA04
�{������G0950221
�{���@�̡GFormBean Generator
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/FAM/FAMA0301MScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("FAMA03")%>'/>
	<tiles:put name='action' value='FAMA03F'/>
	<tiles:put name='form' value='/FAM/FAMA0301MForm.jsp'/>
	<tiles:put name='bar' value='/FAM/FAMA0301MBar.jsp'/>
</tiles:insert>
