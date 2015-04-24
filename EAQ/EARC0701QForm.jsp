<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'><font color="#ff0000">*</font>會計年度</td>
		<td class='table_td'>
			<input type="text" name="accountYear" value='<c:out value="${AccountQueryForm.accountYear}"/>' size="3" maxlength="3"/>
		</td> 
	</tr>
	<tr>
		<td class='table_item'><font color="#ff0000">*</font>會計月份</td>
		<td class='table_td'>	
			<select name="month" >		    
				<c:forEach var="month" begin="1" end="12">
					<c:if test="${month lt 10}">
						<c:set var="month" value="0${month}"/>
					</c:if>
					<c:choose>
					    <c:when test="${month eq AccountQueryForm.month}">
					    	<option value='<c:out value="${month}"/>' selected="true">
						</c:when>
					    <c:otherwise>
			        		<option value='<c:out value="${month}"/>'>
						</c:otherwise>
					</c:choose>
					<c:out value="${month}"/></option>
				</c:forEach>		
			</select>
		</td>
	</tr>
	<tr>
		<td class='table_item'>轉檔資料名稱</td>
		<td class='table_td'>
			<select name="choose">
				<option value="1">實體公債轉換登錄公債</option>
				<option value="2">實體公債還本付息經付</option>
			</select>
		</td>
	</tr>	
	<tr>
		<td class='table_item'>處理設定</td>
		<td class='table_td'>
			<select name="proSet">
				<option value="1">央行資料重新轉入</option>
				<option value="2">開啟現存EXCEL</option>
			</select>
		</td>
	</tr>	
</table>