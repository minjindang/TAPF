<!-- DIMA0101Q.jsp
�{���ت��GDIMA01
�{���N���GDIMA01
�{������G0950223
�{���@�̡GEric.Chen
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.masterDetailBody" flush="true">
	<tiles:put name='scripts' value='/DIM/DIMA0101QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("DIMA01")+"-[�d�ߧ@�~]"%>'/>
	<tiles:put name='action' value='DIMA01F'/>
	<tiles:put name='mform' value='/DIM/DIMA0101QForm.jsp'/>
	<tiles:put name='mbar' value='/DIM/DIMA0101QBar.jsp'/>
	<tiles:put name="dform" value="/DIM/DIMA0101LForm.jsp"/>
	<tiles:put name="dbar" value="/DIM/DIMA0101LBar.jsp"/>
</tiles:insert>
