<!-- EAMB0102LForm.jsp -->
<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>
<%if(request.getAttribute("debtList")!=null && session.getAttribute("debtTypeCode").toString().equals("A")){%>
<display:table class="table_list" name="debtList" id="row" defaultsort="1">
	<display:column title="�w��O" property="budgetCode" decorator="tw.gov.nta.account.form.BudgetCodeNameDecorator"/>
	<display:column title="�ŰȧO" property="debtCode" decorator="tw.gov.nta.account.form.DebtCodeNameDecorator"/>
	<display:column title="�o����B">
		<bean:write name="row" property="issueAmount" format="#,###"/>
	</display:column>
</display:table>	
<% } %> 
<display:table class="table_list" name="Eamb0102Form.voucherLists" id="row" defaultsort="1">
	<display:column title="�ǲ��s��">
	<%
		java.util.Map parm = new java.util.HashMap();
		parm.put("voucher_id",((tw.gov.nta.account.form.Eamb0103Form)pageContext.getAttribute("row")).getId());
		parm.put("issueMain.id",((tw.gov.nta.account.form.Eamb0102Form)request.getAttribute("Eamb0102Form")).getIssueMain().getId());
		pageContext.setAttribute("parm",parm);
	%>
	<html:link action="EAMB0104" name="parm" ><bean:write name="row" property="voucherNo"/></html:link>
	
	</display:column>
	<display:column title="�s�����" property="voucherDate" decorator="tw.gov.nta.account.form.ROCDateDecorator"/>
	<display:column title="�K�n" property="remark"/>
	<display:column title="�O�_�w�L�b" property="usered"/>
</display:table>

