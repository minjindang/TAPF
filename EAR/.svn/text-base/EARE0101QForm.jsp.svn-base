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
		<td class='table_item'>債務名稱</td>
		<td class='table_td'>
			<input type="text" name="issueYear" value='<c:out value="${AccountQueryForm.issueYear}"/>' onchange="form.action='<c:out value="${SYSID}"/>'; form.submit();" size="3"/>
			<select name="issueId" onchange="form.action='<c:out value="${SYSID}"/>'; form.submit();">
				<c:forEach items="${AccountQueryForm.issueList}" var="issue">
					<option value='<c:out value="${issue.id}"/>'
					<c:if test="${issue.id eq AccountQueryForm.issueId}">
					selected = "yes"
					</c:if> >
					<c:out value="${issue.debtName}"/></option>
				</c:forEach>
			</select>	
			<c:if test='${sessionScope.debtType} eq "A"'>
				<select name="debtId" >
					<c:forEach items="${AccountQueryForm.debtList}" var="debt">
						<option value='<c:out value="${debt.id}"/>'
						<c:if test="${debt.id eq AccountQueryForm.debtId}">
						selected = "yes"
						</c:if> >
						
						<%
							tw.gov.nta.sql.debt.DebtMain debt = (tw.gov.nta.sql.debt.DebtMain)pageContext.getAttribute("debt");
							Integer debtCodeId = debt.getDebtCode();
							if (debtCodeId != null){
								tw.gov.nta.sql.DebitRef debitRef = (tw.gov.nta.sql.DebitRef)tw.gov.nta.sql.dao.DebitRefDAO.getInstance().get(debtCodeId);
								if (debitRef != null){
									String debitName = debitRef.getDebitName();
									if (debitName!=null){
										out.print(debitName);
									}
								}
							}
						%>
						<c:out value="${issue.debtName}"/></option>
					</c:forEach>
				</select>	
			</c:if>
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
	<tr>
		<td class='table_item'><font color="#ff0000">*</font>報表類別</td>
		<td class='table_td'>
			<html:select name="AccountQueryForm" property="reportType">
				<option value='<c:out value="${SYSID}"/>'>封面</option>
				<html:optionsCollection name="AccountQueryForm" property='reportTypeList' label="name" value="path" />
			</html:select>
		</td>
	</tr>
</table>