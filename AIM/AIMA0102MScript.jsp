<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<script language="javascript">
function doBodyOnLoad(document)
{
	//do nothing
}

function checkForm(form)
{
	var cols = new Array("budgetCode" , "debtCode", "issueAmountx");
	var colNames = new Array("���ťN��", "�ŰȧO", "�o���B");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert("�i" + colNames[result] + "�j�A����J!!");
	}
	return result < 0;
}

function changeList(form)
{
	form.action = "AIMA0102MLIST" ;
	form.submit() ;
}
function total(form)
{
	issueAmount = <bean:write name='Aima0102MForm' property='issueAmount'/>
	totalIssueAmount = <%= request.getAttribute("totalIssueAmount") %> - <bean:write name='Aima0102MForm' property='issueAmountx'/>;
	
	issueAmountx = replaceAll(form.elements['BigDecimal(issueAmountx)'].value,",","");
	if( parseFloat(totalIssueAmount)+parseFloat(issueAmountx) <= issueAmount)
	{
		document.MainForm.elements['BigDecimal(issueAmountx)'].value = addMoneyMask(issueAmountx);
	}
	else
	{
		alert("�`�o���B�j��o����B�A�Э��s��J!");
		document.MainForm.elements['BigDecimal(issueAmountx)'].value = "0";
		return false;
	}
}
function checkAmount(form)
{
	issueRealAmount = <%= request.getAttribute("issueRealAmount") %>;
	totalRealAmount = <%= request.getAttribute("totalRealAmount") %> -  <bean:write name='Aima0102MForm' property='realAmount'/>;
	issueAmount = replaceAll(form.elements['BigDecimal(issueAmountx)'].value,",","");
	realAmount = replaceAll(form.elements['BigDecimal(realAmount)'].value,",","");
	//if( Number(issueAmount) < Number(realAmount))
	//{
		//alert("�ꦬ�B�j��o����B�A�Э��s��J!");
		//document.MainForm.elements['BigDecimal(realAmount)'].value = "0";
		//return false;
	//}
	if( Number(realAmount) + Number(totalRealAmount) > Number(issueRealAmount)){
		alert("�`�ꦬ�B�j��ꦬ�B�A�Э��s��J!");
		document.MainForm.elements['BigDecimal(realAmount)'].value = "0";
		return false;
	}
}
</script>