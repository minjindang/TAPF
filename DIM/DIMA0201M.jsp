<!-- DIMA0201M.jsp
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
<tiles:insert definition=".condition.mainListBody" flush="true">
	<tiles:put name='scripts' value='/DIM/DIMA0201MScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("DIMA02")+"-[���@�@�~]"%>'/>
	<tiles:put name='action' value='DIMA02F'/>
	<tiles:put name='mform' value='/DIM/DIMA0201MForm.jsp'/>
	<tiles:put name='mbar' value='/DIM/DIMA0201MBar.jsp'/>
	<tiles:put name='dform' value='/DIM/DIMA0201MLForm.jsp'/>
	<tiles:put name='dbar' value='/DIM/DIMA0201MLBar.jsp'/>
</tiles:insert>
