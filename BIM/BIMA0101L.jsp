<!-- BIMA0101L.jsp
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
	<tiles:put name='scripts' value='/common/blankScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("BIMA01")%>'/>
	<tiles:put name='action' value='BIMA01F'/>
	<tiles:put name='form' value='/BIM/BIMA0101LForm.jsp'/>
	<tiles:put name='bar' value='/BIM/BIMA0101LBar.jsp'/>
</tiles:insert>
