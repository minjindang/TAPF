<!--
程式目的：HARA04文字
程式代號：HARA04
程式日期：0950221
程式作者：FormBean Generator
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/FAM/FAMA0301MScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("FAMA03")%>'/>
	<tiles:put name='action' value='FAMA03F'/>
	<tiles:put name='form' value='/FAM/FAMA0301MForm.jsp'/>
	<tiles:put name='bar' value='/FAM/FAMA0301MBar.jsp'/>
</tiles:insert>
