<!-- BIMA0101M.jsp
�{���ت��GBIMA01
�{���N���GBIMA01
�{������G0950302
�{���@�̡GEric.Chen
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->


<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/BIM/BIMA0401AScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("BIMA04")+"-[���@�@�~]"%>'/>
	<tiles:put name='action' value='BIMA04F'/>
	<tiles:put name='form' value='/BIM/BIMA0401MForm.jsp'/>
	<tiles:put name='bar' value='/BIM/BIMA0401MBar.jsp'/>
</tiles:insert>