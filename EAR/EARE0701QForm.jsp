<!--
程式目的：總分類帳
程式代號：EARE07
程式日期：0950606
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
	<tr>
		<td class='table_item'>債務名稱</td>
		<td class='table_td'>
			<input type="text" name="issueYear" value='<c:out value="${AccountQueryForm.issueYear}"/>' onchange="form.action='<c:out value="${SYSID}"/>'; form.submit();" size="3"/>
			<select name="debtId"  onchange="form.action='<c:out value="${SYSID}"/>'; form.submit();">
				<c:forEach items="${AccountQueryForm.allDebtList}" var="debt">
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
									out.print(debt.getIssue().getDebtName() +"("+debitName+")");
								}
							}
						}
					%>
					</option>
				</c:forEach>
			</select>	
		</td>
	</tr>
	<tr>
		<td class='table_item'>報表種類</td>
		<td class='table_td'>
			<html:select name="AccountQueryForm" property="issueKind">
				<option value="0">登錄</option>
				<option value="1">債票</option>
			</html:select>
		</td>
	</tr>
</table>