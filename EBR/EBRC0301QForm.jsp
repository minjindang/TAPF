<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@taglib uri="/tags/struts-bean" prefix="bean" %>
<%@taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %> 

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>�o��~��</td>
		<td class='table_td'>
			<input type="text" name="issueYear" value='<c:out value="${AccountQueryForm.issueYear}"/>' onchange="form.action='<c:out value="${SYSID}"/>'; form.submit();" />
		</td>
	</tr>
	<tr>
		<td class='table_item'>���ŦW��</td>
		<td class='table_td'>
			<html:select name="AccountQueryForm" property="issueId">
				<html:optionsCollection name='AccountQueryForm' property='issueList' label="debtName" value="id" />
			</html:select>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�d�ߤ��</td>
		<td class='table_td'>
			<html:text name='AccountQueryForm' property='date(queryDate)' size='7' maxlength='7'/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(queryDate)", new Integer(0))%>
		</td>
	</tr>
</table>