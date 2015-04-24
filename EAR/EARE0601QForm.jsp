<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@taglib uri="/tags/struts-bean" prefix="bean" %>
<%@taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %> 

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>�ŰȦW��</td>
		<td class='table_td'>
			<input type="text" name="issueYear" value='<c:out value="${AccountQueryForm.issueYear}"/>' onchange="form.action='<c:out value="${SYSID}"/>'; form.submit();" SIZE = "3" />�~
			<select name="issueMonth" onchange="form.action='<c:out value="${SYSID}"/>'; form.submit();">
			<%
				for(int i = 0;i<12;i++){
					int j = i+1;
					String s = String.valueOf(j);
					if (j<10)
						s = "0" + s;
					out.print("<option value="+s);
					String monthValue = ((tw.gov.nta.account.form.AccountQueryForm)request.getAttribute("AccountQueryForm")).getIssueMonth();

					if (s.equals(monthValue)){
						out.print(" selected=Y");
					}			
					out.println(">"+s+"</option>");		
				}
			%>

			</select>��

			<select name="debtId">
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
	
</table>