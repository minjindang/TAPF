<!-- CIMA0102ML.jsp
�{���ت��GCIMA01
�{���N���GCIMA01
�{������G0950306
�{���@�̡GEric.Chen
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->
<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.mainListBody" flush="true">
	<tiles:put name='scripts' value='/CIM/CIMA0102MScript.jsp'/>
	<tiles:put name='title' value=''/>
	<tiles:put name='action' value='CIMA01F'/>
	<tiles:put name="mform" value="/CIM/CIMA0102ML0Form.jsp"/>
	<tiles:put name="mbar" value="/CIM/CIMA0102MLBar.jsp"/>
	<tiles:put name="dform" value="/CIM/CIMA0102MLForm.jsp"/>
	<tiles:put name="dbar" value="/CIM/CIMA0102MLLBar.jsp"/>
</tiles:insert>
