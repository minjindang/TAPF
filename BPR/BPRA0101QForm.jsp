<!-- APRA1501QForm.jsp
�{���ت��GAPRA15��r
�{���N���GAPRA15
�{������G0950221
�{���@�̡GAndrew Sung
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'><font color="red">*</font>���٥��I�����</td>
		<td class='table_td'>
			<html:text name='Bpra0101Form' property='date(repaySdate)' size='10' maxlength='7' onblur=''/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(repaySdate)",new Integer(0))%>
			~
			<html:text name='Bpra0101Form' property='date(repayEdate)' size='10' maxlength='7' onblur=''/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(repayEdate)",new Integer(1))%>
		</td>
	</tr>
</table>
