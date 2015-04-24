
<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@taglib uri="/tags/struts-bean" prefix="bean" %>
<%@taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %> 

<%@page import="tw.gov.nta.surplusage.common.GaraNoteManager"%>
<%@page import="tw.gov.nta.sql.debt.GaraNote"%>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>統計年度</td>
		<td class='table_td'>
			<input type="text" name="accountYear" size='3' maxlenght='3' value='<c:out value="${AccountQueryForm.accountYear}"/>' />
		</td> 
	</tr>
	
	<tr>
		<td class='table_item'>統計月份</td>
		<td class='table_td'>
			<select name="month" >
				<c:forEach var="month" begin="1" end="12">
					<c:if test="${month lt 10}">
						<c:set var="month" value="0${month}"/>
					</c:if>
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
		<td class='table_item'>備註</td>
		<td class='table_td'>
			<%request.setAttribute("memo",((GaraNote)new GaraNoteManager().getGaraNote((String)request.getAttribute("PATH"))).getMemo()); %>
			<input type='hidden' name='path' value='<%=(String)request.getAttribute("PATH") %>'/>
			<textarea name="memo" rows="10" cols="100" ><%=(request.getAttribute("memo")!=null)?request.getAttribute("memo"):""%></textarea>
		</td>
	</tr>

</table>