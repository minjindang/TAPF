<!--	CPRB0301QForm.jsp
�{���ت��GCPRB0301
�{���N���GCPRB0301
�{������G0950316
�{���@�̡GERIC CHEN
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'><font color="red">*</font>�p���Ǧ~��</td>
		<td class='table_td'>
			<html:select name="Cprb0301Form" property="issueSerial" value="issueSerial" >
					<html:optionsCollection name="Cprb0301Form"  property="serialNoList" label="issueSerial" value="issueSerial" />
			</html:select>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�p��_��</td>
		<td class='table_td'>
			<html:text name="Cprb0301Form" property="date(startDate)" size="10" maxlength="7"/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(startDate)")%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�p�⨴��</td>
		<td class='table_td'>
			<html:text name="Cprb0301Form" property="date(endDate)" size="10" maxlength="7"/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(endDate)")%>
		</td>
	</tr>
</table>