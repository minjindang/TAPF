<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/CIM/CIMA0105MScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("CIMA01")%>'/>
	<tiles:put name='action' value='CIMA01F'/>
	<tiles:put name="form" value="/CIM/CIMA0105MForm.jsp"/>
	<tiles:put name="bar" value="/CIM/CIMA0105MBar.jsp"/>
</tiles:insert>