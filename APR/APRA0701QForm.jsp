<!--	APRA0701QForm.jsp
程式目的：APRA07中央政府實體公債還本付息核結數額表
程式代號：APRA07
程式日期：0950316
程式作者：ERIC CHEN
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'><font color="red">*</font>日期</td>
		<td class='table_td'>
			<html:text name='Apra0701Form' property='date(closeSdate)' size='10' maxlength='7' onblur=''/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(closeSdate)", new Integer(0))%>
			~
			<html:text name='Apra0701Form' property='date(closeEdate)' size='10' maxlength='7' onblur=''/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(closeEdate)", new Integer(1))%>
			
		</td>
	</tr>
</table>