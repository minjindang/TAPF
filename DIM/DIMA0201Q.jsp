<!-- DIMA0201A.jsp
�{���ت��GDIMA02
�{���N���GDIMA02
�{������G0950223
�{���@�̡GAndrew Sung
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->


<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.masterDetailBody" flush="true">
	<tiles:put name='scripts' value='/common/blankScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("DIMA02")+"-[�d�ߧ@�~]"%>'/>
	<tiles:put name='action' value='DIMA02F'/>
	<tiles:put name='mform' value='/DIM/DIMA0201QForm.jsp'/>
	<tiles:put name='mbar' value='/DIM/DIMA0201QBar.jsp'/>
	<tiles:put name='dform' value='/DIM/DIMA0201LForm.jsp'/>
	<tiles:put name='dbar' value='/DIM/DIMA0201LBar.jsp'/>
</tiles:insert>
