<!-- BIMA0102M.jsp
�{���ت��GBIMA01
�{���N���GBIMA01
�{������G0950303
�{���@�̡GEric.Chen
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->


<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/BIM/BIMA0102MScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("BIMA01")%>'/>
	<tiles:put name='action' value='BIMA01F'/>
	<tiles:put name='form' value='/BIM/BIMA0102MForm.jsp'/>
	<tiles:put name='bar' value='/BIM/BIMA0102MBar.jsp'/>
</tiles:insert>