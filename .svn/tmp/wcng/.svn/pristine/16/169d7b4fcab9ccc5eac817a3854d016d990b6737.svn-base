<!-- GARA3901QForm.jsp -->
<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'><font color="#ff000">*</font>統計年度</td>
		<td class='table_td'>
			<input type="text" name="year" size="3" maxlength="3"/>
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
	<tr>
		<td class='table_item'><font color="#ff000">*</font>報表種類</td>
		<td class='table_td'>
			<select name='reportType' onchange="changeReportType(this.form);">
				<option value='1' selected>總表</option>
				<option value='2'>各債種</option>
			</select>
		</td>
	</tr>
	<tr>
		<td class='table_item'>債種</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("DD"),"debtType","","readonly",10,false)%>
		</td>
	</tr>
</table>