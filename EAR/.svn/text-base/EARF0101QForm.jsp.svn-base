<!--
程式目的：GBA XML
程式代號：EARF01
程式日期：0970605
程式作者：HOWARDDP
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
		<tr>
		<td class='table_item'>發行/還本付息</td>
		<td class='table_td'>	
			<select name="ip" >	
				<option value ="0">發行</option>
				<option value ="1">還本付息</option>
			</select>
		</td>
	</tr>
	<tr>
		<td class='table_item'>平時/期初</td>
		<td class='table_td'>
			<select name="opening">
				<option value="0">平時</option>
				<option value="1">期初</option>
			</select>
		</td>
	</tr>
	
</table>