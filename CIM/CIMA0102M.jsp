<!-- CIMA0102M.jsp
程式目的：CIMA01
程式代號：CIMA01
程式日期：0950306
程式作者：Eric.Chen
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->
<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.masterDetailLevel4" flush="true">
	<tiles:put name='scripts' value='/CIM/CIMA0102MScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("CIMA01")%>'/>
	<tiles:put name='action' value='CIMA01F'/>
	<tiles:put name="mform" value="/CIM/CIMA0102MForm.jsp"/>
	<tiles:put name="mbar" value="/CIM/CIMA0102MBar.jsp"/>
	<tiles:put name="dform" value="/CIM/CIMA0102ML0Form.jsp"/>
	<tiles:put name="dbar" value="/CIM/CIMA0102MLBar.jsp"/>
	<tiles:put name="lform" value="/CIM/CIMA0102MLForm.jsp"/>
	<tiles:put name="lbar" value="/CIM/CIMA0102MLLBar.jsp"/>
	<tiles:put name="llform" value="/CIM/CIMA0102MLSubDForm.jsp"/>
	<tiles:put name="llbar" value="/common/blankBar.jsp"/>
</tiles:insert>
