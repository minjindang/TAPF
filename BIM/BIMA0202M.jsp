<!-- BIMA0202M.jsp
�{���ت��GBIMA02
�{���N���GBIMA02
�{������G0950302
�{���@�̡GEric.Chen
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->


<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/BIM/BIMA0202AScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("BIMA02")%>'/>
	<tiles:put name='action' value='BIMA02F'/>
	<tiles:put name='form' value='/BIM/BIMA0202MForm.jsp'/>
	<tiles:put name='bar' value='/BIM/BIMA0202MBar.jsp'/>
</tiles:insert>
