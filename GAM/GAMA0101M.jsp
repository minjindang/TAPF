<!-- GAMA0101M.jsp
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
<tiles:insert definition=".condition.mainDetailListBody" flush="true">
	<tiles:put name='scripts' value='/GAM/GAMA0101MScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("GAMA01")%>'/>
	<tiles:put name='action' value='GAMA01F'/>
	<tiles:put name="mform" value="/GAM/GAMA0101MForm.jsp"/>
	<tiles:put name="mbar" value="/GAM/GAMA0101MBar.jsp"/>
	<tiles:put name="dform" value="/GAM/GAMA0101ML2Form.jsp"/>
	<tiles:put name="dbar" value="/common/blankBar.jsp"/>
	<tiles:put name="lform" value="/GAM/GAMA0101MLForm.jsp"/>
	<tiles:put name="lbar" value="/common/blankBar.jsp"/>
</tiles:insert>
