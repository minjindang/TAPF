<!-- EAMB0101LForm.jsp -->
<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<display:table class="table_list" name="collection" id="row">
	<display:column title="�ŰȥN��" property="issueSerial" href="EAMB0103" paramId="issueMain.id" paramProperty="id">
	</display:column>
	<display:column title="�o����" property="issueDate" decorator="tw.gov.nta.account.form.ROCDateDecorator"/>
	<display:column title="�w��O" property="budgetCode" decorator="tw.gov.nta.account.form.BudgetCodeNameDecorator"/>
	<display:column title="�ŰȧO" property="debtCode" decorator="tw.gov.nta.account.form.DebtCodeNameDecorator"/>
	<display:column title="�ŰȦW��">
		<bean:write name="row" property="debtName"/>
		<html:hidden name="row" property="id"/>
	</display:column>
</display:table>
