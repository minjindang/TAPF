<!-- EAMB0101LForm.jsp -->
<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<display:table class="table_list" name="collection" id="row">
	<display:column title="債務代號" property="issueSerial" href="EAMB0103" paramId="issueMain.id" paramProperty="id">
	</display:column>
	<display:column title="發行日期" property="issueDate" decorator="tw.gov.nta.account.form.ROCDateDecorator"/>
	<display:column title="預算別" property="budgetCode" decorator="tw.gov.nta.account.form.BudgetCodeNameDecorator"/>
	<display:column title="債務別" property="debtCode" decorator="tw.gov.nta.account.form.DebtCodeNameDecorator"/>
	<display:column title="債務名稱">
		<bean:write name="row" property="debtName"/>
		<html:hidden name="row" property="id"/>
	</display:column>
</display:table>
