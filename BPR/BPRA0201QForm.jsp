<!-- APRA1501QForm.jsp
程式目的：APRA15文字
程式代號：APRA15
程式日期：0950221
程式作者：Andrew Sung
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'><font color="red">*</font>核結日期</td>
		<td class='table_td'>
			<html:text name='Bpra0201Form' property='date(statrDate)' size='10' maxlength='7' onblur=''/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(statrDate)",new Integer(0))%>
			~
			<html:text name='Bpra0201Form' property='date(endDate)' size='10' maxlength='7' onblur=''/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(endDate)",new Integer(1))%>
		</td>
	</tr>
</table>
