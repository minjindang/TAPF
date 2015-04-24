<!-- GAMA0902M.jsp
程式目的：GAMA09
程式代號：GAMA09
程式日期：0980409
程式作者：Chris
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->
<%@ page language="java" contentType="text/html;charset=Big5"%>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles"%>
<tiles:insert definition=".condition.mainDetailListBody" flush="true">
	<tiles:put name='scripts' value='/GAM/GAMA0901QScript.jsp' />
	<tiles:put name='title'
		value='<%=gov.dnt.tame.util.CommonFun.getTitle("GAMA09")%>' />
	<tiles:put name='action' value='GAMA09F' />
	<tiles:put name="mform" value="/GAM/GAMA0902MForm.jsp" />
	<tiles:put name="mbar" value="/GAM/GAMA0902MBar.jsp" />
	<tiles:put name="dform"  value="/GAM/GAMA0902MLForm.jsp" />
	<tiles:put name="dbar" value="/common/blankBar.jsp" />
	<tiles:put name="lform" value="/common/blankBar.jsp" />
	<tiles:put name="lbar" value="/common/blankBar.jsp" />
</tiles:insert>
