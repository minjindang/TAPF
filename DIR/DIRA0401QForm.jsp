<!--	CIRA0201QForm.jsp
�{���ت��GCIRA0201�������ɴڤ�����p��
�{���N���GCIRA0201
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
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %> 
<%@page import="java.util.Date"%>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>�ŰȦW��</td>
		<td class='table_td'>
			<input type="text" size="3"  name="issueYear" value='<c:out value="${Dira0401Form.issueYear}"/>' onblur="form.action='<c:out value="${SYSID}"/>'; form.submit();" />�~��
			<html:select name="Dira0401Form" property="issueId">
				<html:optionsCollection name='Dira0401Form' property='issueList' label="debtName" value="id" />
			</html:select>
		</td>
	</tr>
	<tr>
		<td class='table_item'>���</td>
		<td class='table_td'>
			<html:text name="Dira0401Form" property="date(baseDate)" size="10" maxlength="7" />
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(baseDate)")%>
		</td>
	</tr>
</table>