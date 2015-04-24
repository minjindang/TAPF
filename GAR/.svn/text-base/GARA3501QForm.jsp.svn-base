<!--	GARA3501QForm.jsp
程式目的：GARA3501
程式代號：GARA3501
程式日期：0950611
程式作者：Leo Lee
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>年度</td>
		<td class='table_td'>
			<input type="text" name="accountYear" value='<c:out value="${AccountQueryForm.accountYear}"/>' size='3' maxlength='3'/>
		</td> 
	</tr>
	<tr>
		<td class='table_item'>月份</td>
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