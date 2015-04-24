<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@taglib uri="/tags/struts-bean" prefix="bean" %>
<%@taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %> 

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>債務名稱</td>
		<td class='table_td'>
			<input type="text" name="issueYear" value='<c:out value="${AccountQueryForm.issueYear}"/>' onchange="form.action='<c:out value="${SYSID}"/>'; form.submit();" size="3"/>
			<select name="issueId" onblur="if('A'=='<c:out value="${debtTypeCode}"/>'){form.action='<c:out value="${SYSID}"/>'; form.submit();}">
				<c:forEach items="${AccountQueryForm.issueList}" var="issue">
					<option value='<c:out value="${issue.id}"/>'
					<c:if test="${issue.id eq AccountQueryForm.issueId}">
					selected
					</c:if> >
					<c:out value="${issue.debtName}"/></option>
				</c:forEach>
			</select>
			<c:if test="${debtTypeCode eq 'A'}">	
				<select name="debtId" >
					<c:forEach items="${AccountQueryForm.debtList}" var="debt">
						<option value='<c:out value="${debt.id}"/>'
						<c:if test="${debt.id eq AccountQueryForm.debtId}">
						selected
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
		<td class='table_item'>會計科目</td>
		<td class='table_td'>
			<html:select name="AccountQueryForm" property="accountId">
				<html:optionsCollection name='AccountQueryForm' property='accountList' label="accountName" value="id" />
			</html:select>
		</td>
	</tr>	
	<c:if test="${debtTypeCode eq 'A'}">
		<tr>
			<td class='table_item'>傳票種類</td>
			<td class='table_td'>
				<html:select name="AccountQueryForm" property="issueKind">
					<option value="3">全部</option>
					<option value="0">登錄</option>
					<option value="1">債票</option>
				</html:select>
			</td>
		</tr>
	</c:if>		
</table>