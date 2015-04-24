<!-- BIMA0101Q.jsp
程式目的：BIMA01
程式代號：BIMA01
程式日期：0950302
程式作者：Eric.Chen
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->


<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.masterDetailBody" flush="true">
	<tiles:put name='scripts' value='/BIM/BIMA0101QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("BIMA01")%>'/>
	<tiles:put name='action' value='BIMA01F'/>
	<tiles:put name='mform' value='/BIM/BIMA0101QForm.jsp'/>
	<tiles:put name='mbar' value='/BIM/BIMA0101QBar.jsp'/>
	<tiles:put name='dform' value='/BIM/BIMA0101LForm.jsp'/>
	<tiles:put name='dbar' value='/BIM/BIMA0101LBar.jsp'/>
</tiles:insert>
