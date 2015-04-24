<!-- DIMA0301Q.jsp
程式目的：DIMA03
程式代號：DIMA03
程式日期：0950224
程式作者：Eric.Chen
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.masterDetailBody" flush="true">
	<tiles:put name='scripts' value='/DIM/DIMA0301QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("DIMA03")+"-[查詢作業]"%>'/>
	<tiles:put name='action' value='DIMA03F'/>
	<tiles:put name="mform" value="/DIM/DIMA0301QForm.jsp"/>
	<tiles:put name="mbar" value="/DIM/DIMA0301QBar.jsp"/>
	<tiles:put name="dform" value="/DIM/DIMA0301LForm.jsp"/>
	<tiles:put name="dbar" value="/DIM/DIMA0301LBar.jsp"/>
</tiles:insert>
