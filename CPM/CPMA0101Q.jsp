<!-- CPMA0101Q.jsp
�{���ت��GCPMA01
�{���N���GCPMA01
�{������G0950306
�{���@�̡GEric.Chen
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->


<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<tiles:insert definition=".condition.masterDetailBody" flush="true">
	<tiles:put name='scripts' value='/common/blankScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("CPMA01")%>'/>
	<tiles:put name='action' value='CPMA01F'/>
	<tiles:put name='mform' value='/CPM/CPMA0101QForm.jsp'/>
	<tiles:put name='mbar' value='/CPM/CPMA0101QBar.jsp'/>
	<tiles:put name='dform' value='/CPM/CPMA0101LForm.jsp'/>
	<tiles:put name='dbar' value='/CPM/CPMA0101LBar.jsp'/>
</tiles:insert>
