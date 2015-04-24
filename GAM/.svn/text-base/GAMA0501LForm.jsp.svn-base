<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<table class='table_1' width='100%'>
	<tr>
		<td>
			註記說明：
		</td>
	</tr>
	<tr>
		<td>
			◎：在排限及未排限數值中，無預算數及決算數，但存在實際數。
		</td>
	</tr>
	<tr>
		<td>
			※：在排限及未排限數值中，無預算數、決算數及實際數。
		</td>
	</tr>
	<tr>
		<td>
			<display:table class="table_list" name="collection" id="row">
				<display:column title="年度">
					<bean:define id="id" name="row" property="id" type="java.lang.Integer"/>

					<bean:define id="qryStartYear" name="Gama0501Form" property="qryStartYear" type="java.lang.String"/>
					<bean:define id="qryEndYear" name="Gama0501Form" property="qryEndYear" type="java.lang.String"/>
					<bean:define id="qryBudgetCode" name="Gama0501Form" property="qryBudgetCode" type="java.lang.Integer"/>
					<bean:define id="qryDebtCode" name="Gama0501Form" property="qryDebtCode" type="java.lang.Integer"/>
					<bean:define id="qryBoundCode" name="Gama0501Form" property="qryBoundCode" type="java.lang.String"/>
					<bean:define id="qryInoutType" name="Gama0501Form" property="qryInoutType" type="java.lang.String"/>
					<%
						java.util.Map paramMap = new java.util.HashMap();
							paramMap.put("id", id);
							paramMap.put("qryStartYear", qryStartYear);
							paramMap.put("qryEndYear", qryEndYear);
							paramMap.put("qryBudgetCode", qryBudgetCode);
							paramMap.put("qryDebtCode", qryDebtCode);
							paramMap.put("qryBoundCode", qryBoundCode);
							paramMap.put("qryInoutType", qryInoutType);
						pageContext.setAttribute("paramMap", paramMap);
					%>
					<html:link action='/GAMA0503' name='paramMap'>
						<bean:write name='row' property='accountYear'/>
					</html:link>
				</display:column>
				<display:column title="預算別" property="budgetCode" decorator="tw.gov.nta.account.form.BudgetCodeNameDecorator"/>
				<display:column title="債務別" property="debtCode" decorator="tw.gov.nta.account.form.DebtCodeNameDecorator"/>
				<display:column title="自償否" property="boundCode" decorator="tw.gov.nta.system.action.BoundCodeDecorator"/>
				<display:column title="內外債別" property="inoutType" decorator="tw.gov.nta.system.action.InOutTypeDecorator"/>
				<display:column title="註記">
				<%
				tw.gov.nta.sql.UserStatisticsMain dto = (tw.gov.nta.sql.UserStatisticsMain)row;
				java.math.BigDecimal budgetAmount = dto.getBudgetUamount1().add(dto.getBudgetUamount2()).add(dto.getBudgetBamount1()).add(dto.getBudgetBamount2());
				java.math.BigDecimal auditAmount = dto.getAuditUamount1().add(dto.getAuditUamount2()).add(dto.getAuditBamount1()).add(dto.getAuditBamount2());
				java.math.BigDecimal realAamount = dto.getRealUamount1().add(dto.getRealUamount2()).add(dto.getRealBamount1()).add(dto.getRealBamount2());
				if(budgetAmount.intValue()!=0 && auditAmount.intValue()!=0 )
					out.print("");
				else if(budgetAmount.intValue() == 0 && auditAmount.intValue() == 0 && realAamount.intValue() != 0)
					out.print("◎");
				else if(budgetAmount.intValue() == 0 && auditAmount.intValue() == 0 && realAamount.intValue() == 0)
					out.print("※");
				
				%>
				</display:column>
			</display:table>
		</td>
	</tr>
</table>
