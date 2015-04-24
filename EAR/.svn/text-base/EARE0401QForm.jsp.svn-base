<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@taglib uri="/tags/struts-bean" prefix="bean" %>
<%@taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %> 

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>會計年度</td>
		<td class='table_td'>
			<input type="text" name="accountYear" value='<c:out value="${AccountQueryForm.accountYear}"/>' />
		</td> 
	</tr>

	<tr>
		<td class='table_item'>會計月份</td>
		<td class='table_td'>	
			<select name="month" >		    
				<c:forEach var="month" begin="1" end="12">
					<c:choose>
					    <c:when test="${month eq AccountQueryForm.month}">
					    	<option value='<c:out value="${month}"/>' selected = true>
						</c:when>
					    <c:otherwise>
			        		<option value='<c:out value="${month}"/>'>
						</c:otherwise>
					</c:choose>
					<c:out value="${month}"/>
					</option>		 
				</c:forEach>		
			</select>
		</td>
	</tr>	
	<tr>
		<td class='table_item'>會計類別</td>
		<td class='table_td'>
			<html:select name="AccountQueryForm" property="voucherType">
				<html:optionsCollection name='AccountQueryForm' property='phaseTypes' label="value" value="key" />
			</html:select>
		</td>
	</tr>	
	<c:if test="${debtTypeCode eq 'A'}">
		<tr>
			<td class='table_item'>報表種類</td>
			<td class='table_td'>
				<html:select name="AccountQueryForm" property="issueKind">
					<option value="0">登錄</option>
					<option value="1">債票</option>
				</html:select>
			</td>
		</tr>
	</c:if>	
</table>