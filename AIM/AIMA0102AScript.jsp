<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<script language="javascript">
function doBodyOnLoad(document)
{
	var oNumberMask = new Mask("#,###", "number");
	var moneyCols = new Array("BigDecimal(issueAmountx)");
	for(var i = 0 ; i < moneyCols.length ; i++)
	{
		oNumberMask.attach(document.MainForm.elements[moneyCols[i]]);
		document.MainForm.elements[moneyCols[i]].value = addMoneyMask(document.MainForm.elements[moneyCols[i]].value);
	}
}

function checkForm(form)
{
	var cols = new Array("budgetCode_options" , "debtCode_options", "BigDecimal(issueAmountx)");
	var colNames = new Array("�w��O", "�ŰȧO", "�o���B");
	var result = checkFormEmpty(form, cols);
	if(result >= 0){
		alert("�i" + colNames[result] + "�j�A����J!!");
	}
	return result < 0;
}

function changeList(form)
{
	form.action = "AIMA0102ALIST" ;
	form.submit() ;
}
function total(form)
{
	issueAmount = <bean:write name='Aima0102MForm' property='issueAmount'/>
	totalIssueAmount = <%= request.getAttribute("totalIssueAmount") %>;
	issueAmountx = replaceAll(form.elements['BigDecimal(issueAmountx)'].value,",","");
	if( Number(issueAmountx) + Number(totalIssueAmount) <= issueAmount)
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
	totalRealAmount = <%= request.getAttribute("totalRealAmount") %>;
	issueAmount = Number(replaceAll(form.elements['BigDecimal(issueAmountx)'].value,",",""));
	realAmount = Number(replaceAll(form.elements['BigDecimal(realAmount)'].value,",",""));
	if( Number(realAmount) + Number(totalRealAmount) > Number(issueRealAmount)){
		alert("�`�ꦬ�B�j��ꦬ�B�A�Э��s��J!");
		document.MainForm.elements['BigDecimal(realAmount)'].value = "0";
		return false;
	}
}
</script>