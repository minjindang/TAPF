<!-- BIMA0201M.jsp
程式目的：BIMA02
程式代號：BIMA02
程式日期：0950302
程式作者：Eric.Chen
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->


<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.masterDetailBody" flush="true">
	<tiles:put name='scripts' value='/BIM/BIMA0201MScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("BIMA02")%>'/>
	<tiles:put name='action' value='BIMA02F'/>
	<tiles:put name='mform' value='/BIM/BIMA0201MForm.jsp'/>
	<tiles:put name='mbar' value='/BIM/BIMA0201MBar.jsp'/>
	<tiles:put name='dform' value='/BIM/BIMA0202LForm.jsp'/>
	<tiles:put name='dbar' value='/BIM/BIMA0202LBar.jsp'/>
</tiles:insert>
