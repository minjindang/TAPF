<!--
程式目的：總分類帳
程式代號：EARD01
程式日期：0950317
程式作者：
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->
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
	
</table>