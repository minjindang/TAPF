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

<html:hidden property="debtType.id" name="AccountQueryForm"/>
<table class='table_1' width='100%'>
	<!-- <tr>
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
	</tr> -->
	<tr>
		<td class='table_item'>會計年度區間</td>
		<td class='table_td'>
			<input type="text" name="startDate" size="5" maxlength="5" value='<c:out value="${AccountQueryForm.startDate }"/>'/> ~ 
			<input type="text" name="endDate" size="5" maxlength="5" value='<c:out value="${AccountQueryForm.endDate }"/>'/> 
			ex:09801~09812
		</td>
	</tr>		
	<tr>
		<td class='table_item'>債務名稱</td>
		<td class='table_td'>
			<input type="text" name="issueYear" value='<c:out value="${AccountQueryForm.issueYear}"/>' onchange="form.action='<c:out value="${SYSID}"/>'; form.submit();" size="3"/>
			<html:select name="AccountQueryForm" property="issueId">
				<html:option value="0">全部</html:option>
				<html:optionsCollection name='AccountQueryForm' property='issueList' label="debtName" value="id" />
			</html:select>				
		</td>
	</tr>	
	<tr>
		<td class='table_item'>會計科目</td>
		<td class='table_td'>
			<html:select name="AccountQueryForm" property="accountId">
				<html:optionsCollection name='AccountQueryForm' property='accountList' label="accountName" value="id" />
			</html:select>
		</td>
	</tr>		
	<tr>
		<td class='table_item'>發行形式</td>
		<td class='table_td'>
			<html:select name="AccountQueryForm" property="issueKind">
				<html:option value="3">全部</html:option>
				<html:option value="1">債票</html:option>
				<html:option value="0">登錄</html:option>
			</html:select>
		</td>
	</tr>
</table>