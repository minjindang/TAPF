<!-- CIMA0101M.jsp
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
<tiles:insert definition=".condition.mainDetailListBody" flush="true">
	<tiles:put name='scripts' value='/CIM/CIMA0101MScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("CIMA01")%>'/>
	<tiles:put name='action' value='CIMA01F'/>
	<tiles:put name="mform" value="/CIM/CIMA0101MForm.jsp"/>
	<tiles:put name="mbar" value="/CIM/CIMA0101MBar.jsp"/>
	<tiles:put name="dform" value="/CIM/CIMA0101ML2Form.jsp"/>
	<tiles:put name="dbar" value="/common/blankBar.jsp"/>
	<tiles:put name="lform" value="/CIM/CIMA0101MLForm.jsp"/>
	<tiles:put name="lbar" value="/common/blankBar.jsp"/>
</tiles:insert>
